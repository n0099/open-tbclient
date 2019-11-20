package com.xiaomi.push;
/* loaded from: classes3.dex */
public class iz {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f787a;

    /* renamed from: a  reason: collision with other field name */
    public final short f788a;

    public iz() {
        this("", (byte) 0, (short) 0);
    }

    public iz(String str, byte b, short s) {
        this.f787a = str;
        this.a = b;
        this.f788a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f787a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f788a) + ">";
    }
}
