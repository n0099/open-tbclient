package com.xiaomi.push;
/* loaded from: classes12.dex */
public class jf {

    /* renamed from: a  reason: collision with root package name */
    public final byte f5000a;

    /* renamed from: a  reason: collision with other field name */
    public final String f777a;

    /* renamed from: a  reason: collision with other field name */
    public final short f778a;

    public jf() {
        this("", (byte) 0, (short) 0);
    }

    public jf(String str, byte b, short s) {
        this.f777a = str;
        this.f5000a = b;
        this.f778a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f777a + "' type:" + ((int) this.f5000a) + " field-id:" + ((int) this.f778a) + ">";
    }
}
