column_1 = []
column_2 = []

with open('data.txt') as file:
    for line in file:
        space = line.find(" ")
        column_1.append(int(line[:space]))
        column_2.append(int(line[space:]))


column_1.sort()
column_2.sort()

total = 0
for i in range(0, len(column_1)):
    total += abs(column_2[i] - column_1[i])

print("The distance between the two lists is: " + str(total)); 