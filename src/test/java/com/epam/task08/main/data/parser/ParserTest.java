package com.epam.task08.main.data.parser;

import com.epam.task08.main.data.DataException;
import com.epam.task08.main.entity.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class ParserTest {

    private final static String VALID_XML_FILE = "src/test/resources/publications.xml";
    private final static String INVALID_XML_FILE = "src/test/resources/invalid.xml";

    private final List<AbstractPublication> expected = Arrays.asList(
            new Book(1, "Head First Java", new PublishingHouse("Eksmo", 1991), "Kathy Sierra"),
            new Book(2, "Effective Java", new PublishingHouse("Prentice Hall", 1913), "Joshua Bloch"),
            new Periodical(3, "Time", new PublishingHouse("Time Inc", 1500), PeriodicalType.MAGAZINE, Periodicity.WEEKLY),
            new Periodical(4, "Newsday", new PublishingHouse("Newsday Media Group", 1940), PeriodicalType.NEWSPAPER, Periodicity.DAILY)
    );

    private Parser parser;

    public ParserTest(Parser parser) {
        this.parser = parser;
    }

    @Test
    public void testParseShouldReturnPublicationListWhenFileIsValid() throws ParserException, DataException {
        //when
        List<AbstractPublication> actual = parser.parse(VALID_XML_FILE);
        //then
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = ParserException.class) //then
    public void testParseShouldThrowParserExceptionWhenFileIsNotValid() throws ParserException, DataException {
        //when
        List<AbstractPublication> actual = parser.parse(INVALID_XML_FILE);

    }
}