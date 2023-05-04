package com.xiaomi.push;
/* loaded from: classes9.dex */
public class ja {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f812a;

    /* renamed from: a  reason: collision with other field name */
    public final short f813a;

    public ja() {
        this("", (byte) 0, (short) 0);
    }

    public ja(String str, byte b, short s) {
        this.f812a = str;
        this.a = b;
        this.f813a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f812a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f813a) + ">";
    }
}
