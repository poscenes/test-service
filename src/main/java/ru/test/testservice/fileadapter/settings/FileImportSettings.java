package ru.test.testservice.fileadapter.settings;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class FileImportSettings {

    @Value("${file-import.in.path:/data/in}")
    private String inputDirectory;
}
