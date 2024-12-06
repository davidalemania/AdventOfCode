column_1 = []
column_2 = []
repetitions = {} #Second half of exercise

with open('data.txt') as file:
    for line in file:
        space = line.find(" ")
        column_1.append(int(line[:space]))
        column_2.append(int(line[space:]))
        if(repetitions.get(column_2[-1]) == None):
            repetitions[column_2[-1]] = 1
        else:
            repetitions[column_2[-1]] += 1


column_1.sort()
column_2.sort()

total = 0
total_similarity = 0 #Second half of exercise
for i in range(0, len(column_1)):
    total += abs(column_2[i] - column_1[i])
    if(repetitions.get(column_1[i]) != None):
        total_similarity += column_1[i] * repetitions.get(column_1[i])

print("The distance between the two lists is: " + str(total))
print("The similarity between the two lists is: " + str(total_similarity))