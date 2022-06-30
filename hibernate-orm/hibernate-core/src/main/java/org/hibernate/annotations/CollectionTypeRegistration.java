/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;

import org.hibernate.metamodel.CollectionClassification;
import org.hibernate.usertype.UserCollectionType;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Allows to register a {@link org.hibernate.usertype.UserCollectionType}
 * to use as the default for the specified classification of collection.
 *
 * @see CollectionType
 *
 * @since 6.0
 *
 * @author Steve Ebersole
 */
@java.lang.annotation.Target({TYPE, PACKAGE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Repeatable( CollectionTypeRegistrations.class )
public @interface CollectionTypeRegistration {
	/**
	 * The collection classification for which the supplied type applies
	 */
	CollectionClassification classification();

	/**
	 * Specifies the UserCollectionType to use when we encounter
	 * a plural attribute classified as {@link #classification()}
	 */
	Class<? extends UserCollectionType> type();

	/**
	 * Specifies configuration information for the type.  Note that if the named type is a
	 * {@link org.hibernate.usertype.UserCollectionType}, it must also implement
	 * {@link org.hibernate.usertype.ParameterizedType} in order to receive these values.
	 */
	Parameter[] parameters() default {};
}
