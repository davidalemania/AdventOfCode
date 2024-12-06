#include <algorithm>
#include <iostream>
#include <fstream>
#include <vector>
#include <string>

int main(){
    
    std::fstream file;
    file.open("data.txt", std::fstream::in);

    std::string line = "";
    int safeReports = 0;

    while(std::getline(file, line)){
        std::string number = "";
        std::string type = " "; // "a" for ascending, "d" for descending 
        int start_pos = line.find(' ');
        auto it = line.begin() + start_pos + 1;
        int previous_number = std::stoi(line.substr(0, start_pos));


        while(it != line.end()){
            if(*it == ' '){
                
                int n = std::stoi(number);
                
                if(n == previous_number){
                    break;
                } else if (n > previous_number){
                    if(type == "d" || n - previous_number > 3)
                        break;

                    type = "a";
                } else {
                    if(type == "a" || previous_number - n > 3)
                        break;

                    type = "d";
                }

                previous_number = n;
                number = "";
            } else {
                number += *it;
            }
            it++;

            if(it == line.end()){
                
                int n = std::stoi(number);

                if(type == "a"){
                    if(n <= previous_number || n - previous_number > 3)
                        break;
                } else{
                    if(n >= previous_number || previous_number - n > 3)
                        break;
                }

                safeReports++;
            }
        }
    }

    std::cout << "The number of safe reports is: " << safeReports << std::endl;
    return 0;
}