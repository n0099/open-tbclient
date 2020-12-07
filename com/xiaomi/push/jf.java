package com.xiaomi.push;
/* loaded from: classes18.dex */
public class jf {

    /* renamed from: a  reason: collision with root package name */
    public final byte f4770a;

    /* renamed from: a  reason: collision with other field name */
    public final String f778a;

    /* renamed from: a  reason: collision with other field name */
    public final short f779a;

    public jf() {
        this("", (byte) 0, (short) 0);
    }

    public jf(String str, byte b, short s) {
        this.f778a = str;
        this.f4770a = b;
        this.f779a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f778a + "' type:" + ((int) this.f4770a) + " field-id:" + ((int) this.f779a) + ">";
    }
}
