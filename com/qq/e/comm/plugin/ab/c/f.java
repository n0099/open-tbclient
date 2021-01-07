package com.qq.e.comm.plugin.ab.c;
/* loaded from: classes4.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f12033a;

    /* renamed from: b  reason: collision with root package name */
    private String f12034b;
    private int c;

    public f(int i, String str) {
        this.f12034b = str;
        this.c = i;
        this.f12033a = null;
    }

    public f(T t) {
        this.f12033a = t;
        this.c = 0;
        this.f12034b = "";
    }

    public T a() {
        return this.f12033a;
    }

    public String b() {
        return this.f12034b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.c == 0;
    }
}
