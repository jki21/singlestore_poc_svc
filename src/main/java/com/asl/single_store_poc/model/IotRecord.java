package com.asl.single_store_poc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("iot_record")
public class IotRecord {
    @Column("iot_record_id")
    private @Id Long iotRecordId;
    private int type;
    private String location, stringValue;
    private double decimalValue;
    @JsonIgnore
    private int markDeleted;
    private Date create_date_time;


}
