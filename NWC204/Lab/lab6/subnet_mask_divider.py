#!/usr/bin/python3
import readline
import sys

# Author: nquangit
# Date: 14/10/2023
# Tool to support for NWC204

def get_input():
    while True:
        host_ip_address = input("Enter the host IP address: ")
        subnet_mask = input("Enter the subnet mask: ")
        new_subnet_mask = input("Enter the new subnet mask: ")
        if is_valid_ip_address(host_ip_address) and is_valid_ip_address(subnet_mask) and is_valid_ip_address(new_subnet_mask):
            break
        else:
            print("Invalid IP address or subnet mask. Please try again.")
    return host_ip_address, subnet_mask, new_subnet_mask

def is_valid_ip_address(ip_address):
    ip_address = ip_address.split(".")
    if len(ip_address) != 4:
        return False
    for octet in ip_address:
        if not octet.isdigit():
            return False
        octet = int(octet)
        if octet < 0 or octet > 255:
            return False
    return True

def convert_ip_address_to_binary(ip_address):
    ip_address = ip_address.split(".")
    ip_address = [bin(int(octet))[2:].zfill(8) for octet in ip_address]
    ip_address = "".join(ip_address)
    return ip_address

def convert_binary_to_ip_address(binary):
    ip_address = ""
    for i in range(0, len(binary), 8):
        octet = binary[i:i+8]
        octet = int(octet, 2)
        ip_address += str(octet) + "."
    ip_address = ip_address[:-1]
    return ip_address

def get_number_of_subnet_bits_and_host_bits(subnet_mask, new_subnet_mask):
    subnet_mask = convert_ip_address_to_binary(subnet_mask)
    new_subnet_mask = convert_ip_address_to_binary(new_subnet_mask)
    number_of_subnet_bits = 0
    number_of_host_bits = 0
    for i in range(len(subnet_mask)):
        if subnet_mask[i] == "0" and new_subnet_mask[i] == "1":
            number_of_subnet_bits += 1
        elif subnet_mask[i] == "0" and new_subnet_mask[i] == "0":
            number_of_host_bits += 1
    return number_of_subnet_bits, number_of_host_bits

def get_number_of_subnets_created(number_of_subnet_bits):
    return 2 ** number_of_subnet_bits

def get_number_of_hosts_created_per_subnet(number_of_host_bits):
    return 2 ** number_of_host_bits - 2

def calc_network_address_for_subnet(host_ip_address, subnet_mask):
    host_ip_address = convert_ip_address_to_binary(host_ip_address)
    subnet_mask = convert_ip_address_to_binary(subnet_mask)
    network_address = ""
    for i in range(len(host_ip_address)):
        if subnet_mask[i] == "1":
            network_address += host_ip_address[i]
        else:
            network_address += "0"
    network_address = convert_binary_to_ip_address(network_address)
    return network_address

# Create a function that convert subnet mask 255.255.255.0 to /24
def convert_subnet_mask_to_slash_notation(subnet_mask):
    subnet_mask = convert_ip_address_to_binary(subnet_mask)
    slash_notation = 0
    for i in range(len(subnet_mask)):
        if subnet_mask[i] == "1":
            slash_notation += 1
    return slash_notation

def calc_ip_address_for_first_host_last_host_and_broadcast(network_address, new_subnet_mask):
    network_address = convert_ip_address_to_binary(network_address)
    new_subnet_mask = convert_ip_address_to_binary(new_subnet_mask)
    first_host_address = ""
    last_host_address = ""
    broadcast_address = ""
    for i in range(len(network_address)):
        if new_subnet_mask[i] == "1":
            first_host_address += network_address[i]
            last_host_address += network_address[i]
            broadcast_address += network_address[i]
        else:
            first_host_address += "0"
            last_host_address += "1"
            broadcast_address += "1"
    first_host_address = first_host_address[:-1] + "1"
    last_host_address = last_host_address[:-1] + "0"
    first_host_address = convert_binary_to_ip_address(first_host_address)
    last_host_address = convert_binary_to_ip_address(last_host_address)
    broadcast_address = convert_binary_to_ip_address(broadcast_address)
    return first_host_address, last_host_address, broadcast_address

def calc_new_host_ip_address_for_next_subnet(last_address, subnet_mask):
    # Last address is the broadcast address of the previous subnet 
    # and the new host IP address for the next subnet
    last_address = convert_ip_address_to_binary(last_address)
    subnet_mask = convert_ip_address_to_binary(subnet_mask)
    new_host_ip_address = last_address[::-1]
    for idx, value in enumerate(last_address[::-1]):
        if value == "1":
            new_host_ip_address = new_host_ip_address[:idx] + "0" + new_host_ip_address[idx+1:]
        if value == "0":
            new_host_ip_address = new_host_ip_address[:idx] + "1" + new_host_ip_address[idx+1:]
            break
    new_host_ip_address = new_host_ip_address[::-1]
    new_host_ip_address = convert_binary_to_ip_address(new_host_ip_address)
    return new_host_ip_address

if __name__ == "__main__":
    print("Created by @nquangit")
    if len(sys.argv) == 4:
        host_ip_address = sys.argv[1]
        subnet_mask = sys.argv[2]
        new_subnet_mask = sys.argv[3]
    else: 
        host_ip_address, subnet_mask, new_subnet_mask = get_input()
    number_of_subnet_bits, number_of_host_bits = get_number_of_subnet_bits_and_host_bits(subnet_mask, new_subnet_mask)
    number_of_subnets_created = get_number_of_subnets_created(number_of_subnet_bits)
    number_of_hosts_created_per_subnet = get_number_of_hosts_created_per_subnet(number_of_host_bits)
    network_address = calc_network_address_for_subnet(host_ip_address, new_subnet_mask)
    slash_notation = convert_subnet_mask_to_slash_notation(new_subnet_mask)
    first_host_address, last_host_address, broadcast_address = calc_ip_address_for_first_host_last_host_and_broadcast(network_address, new_subnet_mask)

    original_host_ip_address = convert_ip_address_to_binary(host_ip_address)
    print(f"Host IP address: {host_ip_address}")
    print(f"Subnet mask: {subnet_mask}")
    print(f"New subnet mask: {new_subnet_mask}")
    print()
    print(f"Number of subnet bits: {number_of_subnet_bits}")
    print(f"Number of subnets created: {number_of_subnets_created}")
    print(f"Number of host bits: {number_of_host_bits}")
    print(f"Number of hosts created per subnet: {number_of_hosts_created_per_subnet}")
    for _ in range(number_of_subnets_created):
        end = False
        print()
        print(f"Subnet: {_+1}")
        # Calculate network address, slash_notation, first host address, last host address, and broadcast address for each subnet
        network_address = calc_network_address_for_subnet(host_ip_address, new_subnet_mask)
        slash_notation = convert_subnet_mask_to_slash_notation(new_subnet_mask)
        first_host_address, last_host_address, broadcast_address = calc_ip_address_for_first_host_last_host_and_broadcast(network_address, new_subnet_mask)
        print(f"Network address: {network_address}/{slash_notation}")
        print(f"First host address: {first_host_address}")
        print(f"Last host address: {last_host_address}")
        print(f"Broadcast address: {broadcast_address}")
        # Calculate new host IP address for next subnet
        host_ip_address = calc_new_host_ip_address_for_next_subnet(broadcast_address, new_subnet_mask)
        # Check if new host IP address is valid
        host_ip_address_binary = convert_ip_address_to_binary(host_ip_address)        
        subnet_mask_binary = convert_ip_address_to_binary(subnet_mask)
        for idx, value in enumerate(host_ip_address_binary):
            if subnet_mask_binary[idx] == "1" and (host_ip_address_binary[idx] != original_host_ip_address[idx]):
                end = True
                break
        if end:
            break
        print(f"New host IP address for next subnet: {host_ip_address}")



