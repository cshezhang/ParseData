/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
// Denise Smith - 2.3
package org.eclipse.persistence.testing.jaxb.xmlschema.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeDerivationControl.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <br>
 * <pre>{@code
 * <simpleType name="typeDerivationControl">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}derivationControl">
 *     <enumeration value="extension"/>
 *     <enumeration value="restriction"/>
 *     <enumeration value="list"/>
 *     <enumeration value="union"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "typeDerivationControl")
@XmlEnum(DerivationControl.class)
public enum TypeDerivationControl {

    @XmlEnumValue("extension")
    EXTENSION(DerivationControl.EXTENSION),
    @XmlEnumValue("restriction")
    RESTRICTION(DerivationControl.RESTRICTION),
    @XmlEnumValue("list")
    LIST(DerivationControl.LIST),
    @XmlEnumValue("union")
    UNION(DerivationControl.UNION);
    private final DerivationControl value;

    TypeDerivationControl(DerivationControl v) {
        value = v;
    }

    public DerivationControl value() {
        return value;
    }

    public static TypeDerivationControl fromValue(DerivationControl v) {
        for (TypeDerivationControl c: TypeDerivationControl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
