#!/bin/sh


######### 0 1 1 2 3 5 8 13

fibonacci() {
	i1=0
	i2=1
	i=0
	while [ $i -ne $1 ]
	do
		echo -n "$i1 "
		i2=$(($i1 + $i2))
		i1=$(($i2 - $i1))
		i=$(($i + 1))
	done
}

main() {
	echo "Fibonacci sequence"

	echo -n "Enter the length of fibonacci sequence you want to display: "
	read id
	# Print fibonacci from 1 to $id
	fibonacci $id
}


main
