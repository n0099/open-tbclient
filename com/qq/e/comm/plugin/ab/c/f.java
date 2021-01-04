package com.qq.e.comm.plugin.ab.c;
/* loaded from: classes3.dex */
public class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f12032a;

    /* renamed from: b  reason: collision with root package name */
    private String f12033b;
    private int c;

    public f(int i, String str) {
        this.f12033b = str;
        this.c = i;
        this.f12032a = null;
    }

    public f(T t) {
        this.f12032a = t;
        this.c = 0;
        this.f12033b = "";
    }

    public T a() {
        return this.f12032a;
    }

    public String b() {
        return this.f12033b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.c == 0;
    }
}
