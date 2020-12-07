package com.meizu.flyme.openidsdk;
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f4220a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public c(String str, int i) {
        this.f4220a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f4220a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
