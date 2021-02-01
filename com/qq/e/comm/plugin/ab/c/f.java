package com.qq.e.comm.plugin.ab.c;
/* loaded from: classes15.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f11735a;

    /* renamed from: b  reason: collision with root package name */
    private String f11736b;
    private int c;

    public f(int i, String str) {
        this.f11736b = str;
        this.c = i;
        this.f11735a = null;
    }

    public f(T t) {
        this.f11735a = t;
        this.c = 0;
        this.f11736b = "";
    }

    public T a() {
        return this.f11735a;
    }

    public String b() {
        return this.f11736b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.c == 0;
    }
}
