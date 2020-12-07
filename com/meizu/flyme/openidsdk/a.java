package com.meizu.flyme.openidsdk;
/* loaded from: classes18.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f4219a;
    public String b;
    public String c;
    public int d;

    public a(String str) {
        this.c = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f4219a = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean a() {
        return this.f4219a > System.currentTimeMillis();
    }

    public void b() {
        this.f4219a = 0L;
    }
}
