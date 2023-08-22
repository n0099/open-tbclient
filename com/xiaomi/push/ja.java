package com.xiaomi.push;
/* loaded from: classes10.dex */
public class ja {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f813a;

    /* renamed from: a  reason: collision with other field name */
    public final short f814a;

    public ja() {
        this("", (byte) 0, (short) 0);
    }

    public ja(String str, byte b, short s) {
        this.f813a = str;
        this.a = b;
        this.f814a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f813a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f814a) + ">";
    }
}
