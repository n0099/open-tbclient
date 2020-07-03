package com.xiaomi.push;
/* loaded from: classes8.dex */
public class jf {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f782a;

    /* renamed from: a  reason: collision with other field name */
    public final short f783a;

    public jf() {
        this("", (byte) 0, (short) 0);
    }

    public jf(String str, byte b, short s) {
        this.f782a = str;
        this.a = b;
        this.f783a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f782a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f783a) + ">";
    }
}
