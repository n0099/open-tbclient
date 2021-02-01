package com.qq.e.comm.plugin.k;
/* loaded from: classes15.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f12182a;

    public a(String str, int i) {
        super(str);
        this.f12182a = i;
    }

    public a(String str, Throwable th, int i) {
        super(str, th);
        this.f12182a = i;
    }

    public a(Throwable th, int i) {
        super(th);
        this.f12182a = i;
    }

    public int a() {
        return this.f12182a;
    }
}
