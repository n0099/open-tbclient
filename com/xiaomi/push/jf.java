package com.xiaomi.push;
/* loaded from: classes18.dex */
public class jf {

    /* renamed from: a  reason: collision with root package name */
    public final byte f5000a;

    /* renamed from: a  reason: collision with other field name */
    public final String f780a;

    /* renamed from: a  reason: collision with other field name */
    public final short f781a;

    public jf() {
        this("", (byte) 0, (short) 0);
    }

    public jf(String str, byte b, short s) {
        this.f780a = str;
        this.f5000a = b;
        this.f781a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f780a + "' type:" + ((int) this.f5000a) + " field-id:" + ((int) this.f781a) + ">";
    }
}
