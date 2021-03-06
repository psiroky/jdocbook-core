/*
 * jDocBook, processing of DocBook sources
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.jboss.jdocbook;

import java.io.Serializable;

/**
 * Descriptor of the profiling to be applied.
 *
 * @author Steve Ebersole
 */
@SuppressWarnings({ "UnusedDeclaration" })
public class Profiling implements Serializable{
	private boolean enabled;
	private String attributeName;
	private String attributeValue;

	public Profiling() {
	}

	public Profiling(String attributeName, String attributeValue) {
		this.enabled = true;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

	/**
	 * Is profiling to be applied at all?
	 *
	 * @return True if profiling is to be performed; false otherwise.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Retrieve the attribute name on which to perform profiling.
	 *
	 * @return The profiling attribute name
	 */
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * Retrieve the value by which to perform profiling.
	 *
	 * @return The profiling attribute value
	 */
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}

		Profiling profiling = (Profiling) o;

		if ( enabled != profiling.enabled ) {
			return false;
		}

		//noinspection SimplifiableIfStatement
		if ( !enabled ) {
			// 2 disabled profiles are the same
			return true;
		}

		return !( attributeName != null ? !attributeName.equals( profiling.attributeName ) : profiling.attributeName != null )
				&& !( attributeValue != null ? !attributeValue.equals( profiling.attributeValue ) : profiling.attributeValue != null );

	}

	@Override
	public int hashCode() {
		int result = ( enabled ? 1 : 0 );
		result = 31 * result + ( attributeName != null ? attributeName.hashCode() : 0 );
		result = 31 * result + ( attributeValue != null ? attributeValue.hashCode() : 0 );
		return result;
	}
}
