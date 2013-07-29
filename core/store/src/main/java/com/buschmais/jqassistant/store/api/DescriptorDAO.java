package com.buschmais.jqassistant.store.api;

import com.buschmais.jqassistant.core.model.api.descriptor.AbstractDescriptor;

import java.util.Map;

/**
 * Interface definition for a Descriptor DAO.
 */
public interface DescriptorDAO {

    /**
     * Find a {@link AbstractDescriptor} by the full qualified name.
     * <p/>
     * Only supported for {@link AbstractDescriptor}s which are indexed.
     *
     * @param <T>               The descriptor type.
     * @param type              The class type.
     * @param fullQualifiedName The full qualified name.
     * @return The {@link AbstractDescriptor} or <code>null</code> if it does
     *         not exist.
     */
    <T extends AbstractDescriptor> T find(Class<T> type, String fullQualifiedName);

    /**
     * Persists an {@link AbstractDescriptor}.
     * <p>
     * A node is create in the store and the id is assigned to the descriptor.
     * Relations which are added to the descripter after calling
     * {@link #persist(AbstractDescriptor)} will be stored by calling
     * {@link #flush()}.
     * </p>
     *
     * @param <T>        The descriptor type.
     * @param descriptor The descriptor.
     */
    <T extends AbstractDescriptor> void persist(T descriptor);

    /**
     * Flushes all pending changes to the database.
     * <p/>
     * This currently only affects relations added to an
     * {@link AbstractDescriptor} after calling
     * {@link #persist(AbstractDescriptor)} on it. The method is automatically
     * called if {@link #find(Class, String)} or
     * {@link #executeQuery(String, Map)} are called.
     */
    void flush();

    /**
     * Executes a CYPHER query.
     *
     * @param query      The CYPHER query.
     * @param parameters The {@link Map} of parameters for the given query.
     * @return The {@link QueryResult}.
     */
    QueryResult executeQuery(String query, Map<String, Object> parameters);

}