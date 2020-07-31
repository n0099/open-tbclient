package com.meizu.flyme.openidsdk;
/* loaded from: classes19.dex */
public class c {
    public String a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public c(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
