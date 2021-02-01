package com.meizu.flyme.openidsdk;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f11372a;

    /* renamed from: b  reason: collision with root package name */
    public int f11373b;
    public long c = System.currentTimeMillis() + 86400000;

    public c(String str, int i) {
        this.f11372a = str;
        this.f11373b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f11372a + "', code=" + this.f11373b + ", expired=" + this.c + '}';
    }
}
