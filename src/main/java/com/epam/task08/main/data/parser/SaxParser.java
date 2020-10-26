package com.epam.task08.main.data.parser;

import com.epam.task08.main.data.DataException;
import com.epam.task08.main.entity.AbstractPublication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    @Override
    public List<AbstractPublication> parse(String fileName) throws ParserException, DataException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        PublicationsHandler handler = new PublicationsHandler();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(fileName, handler);
        } catch (SAXException | ParserConfigurationException e) {
            throw new ParserException(e.getMessage(), e);
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        return handler.getPublications();
    }
}