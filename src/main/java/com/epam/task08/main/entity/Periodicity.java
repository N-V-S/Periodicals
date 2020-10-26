package com.epam.task08.main.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "periodicity")
@XmlEnum
public enum Periodicity {
    DAILY,
    WEEKLY,
    BIWEEKLY,
    MONTHLY,
    BIMONTHLY,
    QUARTERLY
}