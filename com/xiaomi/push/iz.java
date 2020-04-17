package com.xiaomi.push;
/* loaded from: classes8.dex */
public class iz {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f788a;

    /* renamed from: a  reason: collision with other field name */
    public final short f789a;

    public iz() {
        this("", (byte) 0, (short) 0);
    }

    public iz(String str, byte b, short s) {
        this.f788a = str;
        this.a = b;
        this.f789a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f788a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f789a) + ">";
    }
}
