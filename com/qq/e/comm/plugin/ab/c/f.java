package com.qq.e.comm.plugin.ab.c;
/* loaded from: classes3.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f11733a;

    /* renamed from: b  reason: collision with root package name */
    private String f11734b;
    private int c;

    public f(int i, String str) {
        this.f11734b = str;
        this.c = i;
        this.f11733a = null;
    }

    public f(T t) {
        this.f11733a = t;
        this.c = 0;
        this.f11734b = "";
    }

    public T a() {
        return this.f11733a;
    }

    public String b() {
        return this.f11734b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.c == 0;
    }
}
