package com.tencent.turingfd.sdk.ams.au;
/* loaded from: classes3.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    public int f13767a;

    /* renamed from: b  reason: collision with root package name */
    public int f13768b;
    public int c;
    public String d;
    public int e;

    public ag(int i, int i2, String str, int i3, String str2, int i4) {
        this.d = "";
        this.f13767a = i;
        this.f13768b = i2;
        this.d = str;
        this.c = i3;
        this.e = i4;
    }

    public String toString() {
        String format = String.format("% 6d", Integer.valueOf(this.f13767a));
        return "" + format + "    " + String.format("% 6d", Integer.valueOf(this.f13768b)) + "    " + String.format("% 6d", Integer.valueOf(this.c)) + "    " + this.d;
    }
}
