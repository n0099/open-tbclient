package com.xiaomi.push;
/* loaded from: classes5.dex */
public class iz {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f792a;

    /* renamed from: a  reason: collision with other field name */
    public final short f793a;

    public iz() {
        this("", (byte) 0, (short) 0);
    }

    public iz(String str, byte b, short s) {
        this.f792a = str;
        this.a = b;
        this.f793a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f792a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f793a) + ">";
    }
}
