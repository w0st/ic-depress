/*
ImpressiveCode Depress Framework
Copyright (C) 2013  ImpressiveCode contributors

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.impressivecode.depress.its;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marek Majchrzak, ImpressiveCode
 * @author Maciej Borkowski, Capgemini Poland
 */
public enum ITSStatus {
    OPEN("New"), IN_PROGRESS("In progress"), REOPENED("Reopened"), CLOSED("Closed"), RESOLVED("Resolved"), UNKNOWN("Unknown");
    
    private final String label;

    private ITSStatus(final String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return (this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase())
                .replaceAll("_", " ");
    };

    private static Map<String, ITSStatus> lookup = new HashMap<String, ITSStatus>();
    static {
        for (ITSStatus type : ITSStatus.values()) {
            lookup.put(type.getLabel(), type);
        }
    }

    public static ITSStatus get(final String label) {
        return lookup.get(label);
    }

    public String getLabel() {
        return label;
    }

    public static String[] labels() {
        return Arrays.toString(ITSStatus.values()).replaceAll("^.|.$", "").split(", ");
    }
}
