package com.ss.android.downloadlib.addownload.b;
/* loaded from: classes10.dex */
public class g {
    public int a;
    public int b;
    public String c;

    public g(int i) {
        this(i, 0, null);
    }

    public g(int i, int i2) {
        this(i, i2, null);
    }

    public g(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public g(int i, String str) {
        this(i, 0, str);
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int getType() {
        return this.a;
    }
}
