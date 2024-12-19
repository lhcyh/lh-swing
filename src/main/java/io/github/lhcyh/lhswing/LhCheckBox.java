package io.github.lhcyh.lhswing;

import javax.swing.*;
import java.awt.*;

public class LhCheckBox extends JCheckBox {
    private Integer padding=5;

    public LhCheckBox(String text){
        super(text);
        this.updateComponent();
    }

    public void setFontSize(float size){
        Font font=this.getFont().deriveFont(size);
        this.setFont(font);
        updateComponent();
    }

    private void updateComponent(){
        Font font=this.getFont();
        FontMetrics fontMetrics=sun.font.FontDesignMetrics.getMetrics(font);
        int width=fontMetrics.stringWidth(this.getText());
        int height=fontMetrics.getHeight();
        this.setSize(width+30+padding,height+padding*2);
    }

    public void setPadding(Integer padding) {
        this.padding = padding;
    }
}
