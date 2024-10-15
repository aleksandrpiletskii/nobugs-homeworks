package org.example.api.models;

import com.google.gson.annotations.SerializedName;
import groovy.transform.builder.Builder;
import lombok.*;

@Builder
@Data
public class Student {
    private String name;
    private int grade;
    @SerializedName("_id")
    private String id;
}