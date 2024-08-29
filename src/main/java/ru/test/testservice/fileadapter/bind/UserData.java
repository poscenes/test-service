package ru.test.testservice.fileadapter.bind;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {
    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private Integer age;

    @CsvBindByPosition(position = 2)
    private String city;
}
