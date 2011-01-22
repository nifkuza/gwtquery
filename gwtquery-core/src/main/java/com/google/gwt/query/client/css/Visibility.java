/*
 * Copyright 2011, The gwtquery team.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.query.client.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style;

/**
 * The 'visibility' property specifies whether the boxes generated by an element
 * are rendered. Invisible boxes still affect layout (set the 'display' property
 * to 'none' to suppress box generation altogether). Values have the following
 * meanings:
 */
public class Visibility implements CssProperty<Visibility.VisibilityValue> {

  public static void init() {
    CSS.VISIBILITY = new Visibility();
    CSS.VISIBLE = VisibilityValue.create("visible");
    CSS.HIDDEN = VisibilityValue.create("hidden");
    CSS.COLLAPSE = VisibilityValue.create("collapse");
  }

  public void set(Style s, VisibilityValue value) {
    s.setProperty("visibility", value.value());
  }

  public String get(Style s) {
    return s.getProperty("visibilityat");
  }

  final static public class VisibilityValue extends JavaScriptObject {

    protected VisibilityValue() {
    }

    protected static VisibilityValue create(String val) {
      return GWT.isScript() ? createWeb(val) : createHosted(val);
    }

    public String value() {
      return GWT.isScript() ? valueWeb() : valueHosted();
    }

    private static native VisibilityValue createWeb(String val) /*-{
      return val;
    }-*/;

    private static native VisibilityValue createHosted(String val) /*-{
      return [val];
    }-*/;

    private native String valueWeb() /*-{
       return this;
    }-*/;

    private native String valueHosted() /*-{
       return this[0];
    }-*/;
  }
}
