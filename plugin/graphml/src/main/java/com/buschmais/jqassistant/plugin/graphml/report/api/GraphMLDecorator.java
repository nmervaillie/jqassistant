package com.buschmais.jqassistant.plugin.graphml.report.api;

import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.neo4j.graphdb.Node;

public interface GraphMLDecorator {

    /**
     * Return the additional namespaces identified by their prefixes which are used by the decorator.
     * 
     * @return The additional namespaces identified by their prefixes.
     */
    Map<String, String> getNamespaces();

    /**
     * Writes a bunch of keys in the graphml-Tag that will be used for formating or so. This method can be overwritten if any special default keys are
     * necessary. Please call super to ensure all needed keys will be created.
     *
     * @param writer
     *            the XMLWriter
     * @throws XMLStreamException
     */
    void writeKeys(XMLStreamWriter writer) throws XMLStreamException;

    /**
     * Can be overwritten to add additional node attributes. Please call super to ensure all necessary attributes will be written.
     *
     * @param writer
     *            the xml writer
     * @param node
     *            the node
     * @throws XMLStreamException
     */
    void writeNodeAttributes(XMLStreamWriter writer, Node node) throws XMLStreamException;

    /**
     * Used to insert additional elements inside a node-element. Can be overwriten, but please call super to ensure all needed elements will be
     * created.
     *
     * @param writer
     *            the xml writer
     * @param nodeLabel
     *            the label of the node
     * @throws XMLStreamException
     */
    void writeNodeElements(XMLStreamWriter writer, String nodeLabel) throws XMLStreamException;

}
