package com.meizu.flyme.openidsdk;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes8.dex */
public class ValueData {
    @Keep
    public int code;
    @Keep
    public long expired = System.currentTimeMillis() + 86400000;
    @Keep
    public String value;

    public ValueData(String str, int i) {
        this.value = str;
        this.code = i;
    }

    @Keep
    public native String toString();
}
