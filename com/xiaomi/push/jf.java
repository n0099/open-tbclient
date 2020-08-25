package com.xiaomi.push;
/* loaded from: classes7.dex */
public class jf {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f779a;

    /* renamed from: a  reason: collision with other field name */
    public final short f780a;

    public jf() {
        this("", (byte) 0, (short) 0);
    }

    public jf(String str, byte b, short s) {
        this.f779a = str;
        this.a = b;
        this.f780a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f779a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f780a) + ">";
    }
}
