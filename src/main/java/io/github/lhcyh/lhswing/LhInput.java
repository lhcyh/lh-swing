package io.github.lhcyh.lhswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LhInput extends JTextField {
    private Integer padding=10;
    private boolean isPlaceholder=false;
    private String placeholder="";
    private Color textColor;

    public LhInput(){
        //this.setSize(200,100);
        super.setText("");
        this.updateComponent();
        this.placeholderSet();
    }

    private void updateComponent(){
        Font font=this.getFont();
        FontMetrics fontMetrics=sun.font.FontDesignMetrics.getMetrics(font);
        //int width=fontMetrics.stringWidth(this.getText());
        int height=fontMetrics.getHeight();
        this.setSize(this.getWidth(),height+padding);
    }

    public void setWidth(Integer width){
        this.setSize(width,this.getHeight());
        this.updateComponent();
    }

    public void setFontSize(float size){
        Font font=this.getFont().deriveFont(size);
        this.setFont(font);
        this.updateComponent();
    }

    public void setPlaceholder(String placeholder){
        if(placeholder==null){
            return;
        }
        this.placeholder=placeholder;
        if(this.getText().equals("")){
            this.isPlaceholder=true;
            this.textColor=this.getForeground();
            setForeground(Color.GRAY);
            super.setText(this.placeholder);
        }
    }

    private void superSetText(String text){
        super.setText(text);
    }

    private void placeholderSet(){
        // 添加焦点监听器
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(isPlaceholder){
                    isPlaceholder=false;
                    superSetText("");
                    setForeground(textColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!isPlaceholder){
                    if(getText().equals("")){
                        isPlaceholder=true;
                        textColor=getForeground();
                        superSetText(placeholder);
                        setForeground(Color.GRAY);
                    }
                }
            }
        });
    }

    @Override
    public String getText() {
        if(isPlaceholder){
            return "";
        }else {
            return super.getText();
        }
    }

    @Override
    public void setText(String t) {
        if(t!=null&&!t.equals("")){
            isPlaceholder=false;
            super.setText(t);
            this.setForeground(textColor);
        }
    }
}
