package com.xiaomi.push;
/* loaded from: classes7.dex */
public class iy {

    /* renamed from: a  reason: collision with root package name */
    public final byte f40867a;

    /* renamed from: a  reason: collision with other field name */
    public final String f806a;

    /* renamed from: a  reason: collision with other field name */
    public final short f807a;

    public iy() {
        this("", (byte) 0, (short) 0);
    }

    public iy(String str, byte b2, short s) {
        this.f806a = str;
        this.f40867a = b2;
        this.f807a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f806a + "' type:" + ((int) this.f40867a) + " field-id:" + ((int) this.f807a) + ">";
    }
}
