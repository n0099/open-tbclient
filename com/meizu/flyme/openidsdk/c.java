package com.meizu.flyme.openidsdk;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f11670a;

    /* renamed from: b  reason: collision with root package name */
    public int f11671b;
    public long c = System.currentTimeMillis() + 86400000;

    public c(String str, int i) {
        this.f11670a = str;
        this.f11671b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f11670a + "', code=" + this.f11671b + ", expired=" + this.c + '}';
    }
}
