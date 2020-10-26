package com.epam.task08.main.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "type")
@XmlEnum
public enum PeriodicalType {
    NEWSPAPER,
    MAGAZINE,
    BOOKLET
}