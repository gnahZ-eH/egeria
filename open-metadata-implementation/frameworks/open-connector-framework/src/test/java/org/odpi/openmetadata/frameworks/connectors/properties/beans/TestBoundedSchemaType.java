/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.frameworks.connectors.properties.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Validate that the PrimitiveSchemaType bean can be cloned, compared, serialized, deserialized and printed as a String.
 */
public class TestBoundedSchemaType
{
    private ElementType          type                 = new ElementType();
    private List<Classification> classifications      = new ArrayList<>();
    private Map<String, String>  additionalProperties = new HashMap<>();


    /**
     * Default constructor
     */
    public TestBoundedSchemaType()
    {

    }


    /**
     * Set up an example object to test.
     *
     * @return filled in object
     */
    private BoundedSchemaType getTestObject()
    {
        BoundedSchemaType testObject = new BoundedSchemaType();

        testObject.setType(type);
        testObject.setGUID("TestGUID");
        testObject.setURL("TestURL");
        testObject.setClassifications(classifications);

        testObject.setQualifiedName("TestQualifiedName");
        testObject.setAdditionalProperties(additionalProperties);

        testObject.setVersionNumber("TestVersionNumber");
        testObject.setAuthor("TestAuthor");
        testObject.setUsage("TestUsage");
        testObject.setEncodingStandard("TestEncodingStandard");

        testObject.setBoundedSchemaCategory(BoundedSchemaCategory.ARRAY);
        testObject.setMaximumElements(100);

        return testObject;
    }


    /**
     * Validate that the object that comes out of the test has the same content as the original test object.
     *
     * @param resultObject object returned by the test
     */
    private void validateResultObject(BoundedSchemaType resultObject)
    {
        assertTrue(resultObject.getType().equals(type));
        assertTrue(resultObject.getGUID().equals("TestGUID"));
        assertTrue(resultObject.getURL().equals("TestURL"));
        assertTrue(resultObject.getClassifications() == null);

        assertTrue(resultObject.getQualifiedName().equals("TestQualifiedName"));
        assertTrue(resultObject.getAdditionalProperties() == null);

        assertTrue(resultObject.getVersionNumber().equals("TestVersionNumber"));
        assertTrue(resultObject.getAuthor().equals("TestAuthor"));
        assertTrue(resultObject.getUsage().equals("TestUsage"));
        assertTrue(resultObject.getEncodingStandard().equals("TestEncodingStandard"));

        assertTrue(resultObject.getBoundedSchemaCategory().equals(BoundedSchemaCategory.ARRAY));
        assertTrue(resultObject.getMaximumElements() == 100);
    }


    /**
     * Validate that the object is initialized properly
     */
    @Test public void testNullObject()
    {
        BoundedSchemaType nullObject = new BoundedSchemaType();

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getURL() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getQualifiedName() == null);
        assertTrue(nullObject.getAdditionalProperties() == null);

        assertTrue(nullObject.getVersionNumber() == null);
        assertTrue(nullObject.getAuthor() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getEncodingStandard() == null);

        assertTrue(nullObject.getBoundedSchemaCategory() == null);
        assertTrue(nullObject.getMaximumElements() == 0);


        nullObject = new BoundedSchemaType(null);

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getURL() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getQualifiedName() == null);
        assertTrue(nullObject.getAdditionalProperties() == null);

        assertTrue(nullObject.getVersionNumber() == null);
        assertTrue(nullObject.getAuthor() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getEncodingStandard() == null);

        assertTrue(nullObject.getBoundedSchemaCategory() == null);
        assertTrue(nullObject.getMaximumElements() == 0);

        nullObject = new BoundedSchemaType(null);

        assertTrue(nullObject.getType() == null);
        assertTrue(nullObject.getGUID() == null);
        assertTrue(nullObject.getURL() == null);
        assertTrue(nullObject.getClassifications() == null);

        assertTrue(nullObject.getQualifiedName() == null);
        assertTrue(nullObject.getAdditionalProperties() == null);

        assertTrue(nullObject.getVersionNumber() == null);
        assertTrue(nullObject.getAuthor() == null);
        assertTrue(nullObject.getUsage() == null);
        assertTrue(nullObject.getEncodingStandard() == null);

        assertTrue(nullObject.getBoundedSchemaCategory() == null);
        assertTrue(nullObject.getMaximumElements() == 0);
    }


    /**
     * Validate that 2 different objects with the same content are evaluated as equal.
     * Also that different objects are considered not equal.
     */
    @Test public void testEquals()
    {
        assertFalse(getTestObject().equals(null));
        assertFalse(getTestObject().equals("DummyString"));
        assertTrue(getTestObject().equals(getTestObject()));

        BoundedSchemaType sameObject = getTestObject();
        assertTrue(sameObject.equals(sameObject));

        BoundedSchemaType differentObject = getTestObject();
        differentObject.setGUID("Different");
        assertFalse(getTestObject().equals(differentObject));
    }


    /**
     *  Validate that 2 different objects with the same content have the same hash code.
     */
    @Test public void testHashCode()
    {
        assertTrue(getTestObject().hashCode() == getTestObject().hashCode());
    }


    /**
     *  Validate that an object cloned from another object has the same content as the original
     */
    @Test public void testClone()
    {
        validateResultObject(new BoundedSchemaType(getTestObject()));
    }


    /**
     * Test that a an object cloned through the superclass cloneSchemaElement has the same content as
     * the original
     */
    @Test public void testAbstractClone()
    {
        SchemaElement schemaElement = getTestObject();

        validateResultObject((BoundedSchemaType)schemaElement.cloneSchemaElement());
    }


    @Test public void testCloneSchemaType()
    {
        validateResultObject((BoundedSchemaType)getTestObject().cloneSchemaType());
    }

    
    /**
     * Validate that an object generated from a JSON String has the same content as the object used to
     * create the JSON String.
     */
    @Test public void testJSON()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonString   = null;

        /*
         * This class
         */
        try
        {
            jsonString = objectMapper.writeValueAsString(getTestObject());
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject(objectMapper.readValue(jsonString, BoundedSchemaType.class));
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        SchemaElement schemaElement = getTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(schemaElement);
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject((BoundedSchemaType) objectMapper.readValue(jsonString, SchemaElement.class));
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        Referenceable referenceable = getTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(referenceable);
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject((BoundedSchemaType) objectMapper.readValue(jsonString, Referenceable.class));
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        ElementHeader elementHeader = getTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(elementHeader);
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject((BoundedSchemaType) objectMapper.readValue(jsonString, ElementHeader.class));
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        /*
         * Through superclass
         */
        PropertyBase propertyBase = getTestObject();

        try
        {
            jsonString = objectMapper.writeValueAsString(propertyBase);
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }

        try
        {
            validateResultObject((BoundedSchemaType) objectMapper.readValue(jsonString, PropertyBase.class));
        }
        catch (Throwable  exc)
        {
            assertTrue(false, "Exception: " + exc.getMessage());
        }
    }


    /**
     * Test that toString is overridden.
     */
    @Test public void testToString()
    {
        assertTrue(getTestObject().toString().contains("BoundedSchemaType"));
    }
}
