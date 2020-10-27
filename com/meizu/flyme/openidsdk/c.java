package com.meizu.flyme.openidsdk;
/* loaded from: classes11.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f4448a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public c(String str, int i) {
        this.f4448a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f4448a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
