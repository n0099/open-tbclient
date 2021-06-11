package com.yy.hiidostatis.config;
/* loaded from: classes7.dex */
public enum ABNameDefine {
    GSLB("gslb", 1),
    VERIFY_RETURN("verifyreturn", 1),
    NEW_SEND_MODULE("newsendmodule", 1),
    NEW_PACKER_MODULE("newpackermodule", 1);
    
    public int defaultValue;
    public String name;

    ABNameDefine(String str, int i2) {
        this.name = str;
        this.defaultValue = i2;
    }

    public int getDefaultValue() {
        return this.defaultValue;
    }

    public String getName() {
        return this.name;
    }

    public void setDefaultValue(int i2) {
        this.defaultValue = i2;
    }

    public void setName(String str) {
        this.name = str;
    }
}
