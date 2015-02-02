/*
 * Copyright (C) 2015 Genymobile
 *
 * This file is part of GenymotionGradlePlugin.
 *
 * GenymotionGradlePlugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version
 *
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GenymotionGradlePlugin.  If not, see <http://www.gnu.org/licenses/>.
 */

package main.groovy.com.genymotion.tools

class Tools {

    public static def checkFilesExist(value) {
        def values = getStringTable(value)

        for (String path in values) {
            File f = new File(path)
            if(!f.exists()){
                return path
            }
        }
        return true
    }

    public static ArrayList<String> getStringTable(def input)  {

        def values = []

        if (input instanceof String)
            values = [input]
        else if(input instanceof Map){
            values = input.keySet().toArray()
        } else if(input instanceof ArrayList){
            values = input
        }

        return values
    }
}