package com.yy.hiidostatis.config;
/* loaded from: classes10.dex */
public enum ABNameDefine {
    GSLB("gslb", 1),
    VERIFY_RETURN("verifyreturn", 1),
    NEW_SEND_MODULE("newsendmodule", 1),
    NEW_PACKER_MODULE("newpackermodule", 1);
    
    public int defaultValue;
    public String name;

    ABNameDefine(String str, int i) {
        this.name = str;
        this.defaultValue = i;
    }

    public void setDefaultValue(int i) {
        this.defaultValue = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getDefaultValue() {
        return this.defaultValue;
    }

    public String getName() {
        return this.name;
    }
}
