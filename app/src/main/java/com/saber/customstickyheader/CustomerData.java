package com.saber.customstickyheader;

import com.saber.stickyheader.stickyData.StickyMainData;

public class CustomerData implements StickyMainData {
    private String label;

    public CustomerData(int i) {
        label = String.valueOf(i);
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
}
