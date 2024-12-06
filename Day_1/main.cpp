#include <algorithm>
#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <string>

int main()
{
    std::fstream file;
    file.open("data.txt", std::fstream::in);
    
    std::string line = "";
    std::vector<int> column_1;
    std::vector<int> column_2;
    std::map<int, int> repetitions; // Other half of exercise

    while(std::getline(file, line)){
        int num_1;
        int num_2;
        
        size_t space = line.find(" ");
        column_1.emplace_back(std::stoi(line.substr(0, space)));
        column_2.emplace_back(std::stoi(line.substr(space)));
        if(repetitions.find(column_2.back()) == repetitions.end()){
            repetitions.emplace(std::make_pair(column_2.back(), 1));
        } else {
            repetitions[column_2.back()]++;
        }
    }

    std::sort(column_1.begin(), column_1.end());
    std::sort(column_2.begin(), column_2.end());
    
    int total = 0;
    int total_similarity = 0; // Other half of exercise
    for(int i = 0; i < column_1.size(); i++){
        total += std::abs(column_2[i] - column_1[i]);
        if(repetitions.find(column_1[i]) != repetitions.end()){
            total_similarity += column_1[i] * repetitions[column_1[i]];
        }
        
    }
    
    std::cout << "The distance between the two lists is: " << total << std::endl;
    std::cout << "The similarity of the two lists is: " << total_similarity << std::endl;
    return 0;
}