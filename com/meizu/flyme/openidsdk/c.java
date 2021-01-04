package com.meizu.flyme.openidsdk;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f11669a;

    /* renamed from: b  reason: collision with root package name */
    public int f11670b;
    public long c = System.currentTimeMillis() + 86400000;

    public c(String str, int i) {
        this.f11669a = str;
        this.f11670b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f11669a + "', code=" + this.f11670b + ", expired=" + this.c + '}';
    }
}
