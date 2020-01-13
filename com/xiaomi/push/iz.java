package com.xiaomi.push;
/* loaded from: classes6.dex */
public class iz {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f790a;

    /* renamed from: a  reason: collision with other field name */
    public final short f791a;

    public iz() {
        this("", (byte) 0, (short) 0);
    }

    public iz(String str, byte b, short s) {
        this.f790a = str;
        this.a = b;
        this.f791a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f790a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f791a) + ">";
    }
}
