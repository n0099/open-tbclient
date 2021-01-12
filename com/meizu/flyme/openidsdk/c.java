package com.meizu.flyme.openidsdk;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f11370a;

    /* renamed from: b  reason: collision with root package name */
    public int f11371b;
    public long c = System.currentTimeMillis() + 86400000;

    public c(String str, int i) {
        this.f11370a = str;
        this.f11371b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f11370a + "', code=" + this.f11371b + ", expired=" + this.c + '}';
    }
}
