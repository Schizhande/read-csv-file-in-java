package com.schizhande.readcsvfile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Slf4j
@Component
public class UserService {
    public List<User> uploadFile(MultipartFile file) {

        // validate file
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Please select a CSV file to upload.");
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(reader)
                        .withType(User.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<User> users = csvToBean.parse();

                return users;

            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Failed due to "+ ex.getMessage());
            }
        }
    }
}
