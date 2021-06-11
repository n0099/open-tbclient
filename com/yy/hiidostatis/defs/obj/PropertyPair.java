package com.yy.hiidostatis.defs.obj;

import com.yy.hiidostatis.inner.util.Util;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class PropertyPair implements Serializable {
    public static final String DIVIDE_FIELD = "=";
    public static final int TYPE_COUNT = 0;
    public static final int TYPE_TIMES = 1;
    public static final long serialVersionUID = 807395322993363767L;
    public String key;
    public int type = 0;
    public String value;

    public PropertyPair(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String getConnectedPair() {
        return Util.replaceEncode(this.key, "=") + "=" + Util.replaceEncode(this.value, "=") + "=" + this.type;
    }

    public String toString() {
        return this.key + "=" + this.value + "=" + this.type;
    }

    public PropertyPair(String str, double d2) {
        this.key = str;
        this.value = String.valueOf(d2);
    }
}
