package com.google.gwt.query.client.plugins.widgets;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Factory used to create a {@link TextBox} widget. A {@link TextBox} is created
 * if the element is a <i>input</i> with type text, a <i>div</i> or a<i>span</i> element.
 * 
 */
public class TextBoxWidgetFactory implements WidgetFactory<TextBox> {

  public TextBox create(Element e) {

    GQuery input = $(e).filter("input[type='text']");
    
    if (input.get(0) != null) {
      return TextBox.wrap(e);
    }

    if (WidgetsUtils.matchesTags(e, "div", "span")) {
      InputElement inputElement = Document.get().createTextInputElement();
      
      WidgetsUtils.replace(e, inputElement);

      TextBox textBox = TextBox.wrap(inputElement);
      textBox.setValue(e.getInnerText()); // maybe use setText and getInnerText

      return textBox;
    }

    return null;
  }
}