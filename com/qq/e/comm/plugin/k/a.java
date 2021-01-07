package com.qq.e.comm.plugin.k;
/* loaded from: classes4.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f12480a;

    public a(String str, int i) {
        super(str);
        this.f12480a = i;
    }

    public a(String str, Throwable th, int i) {
        super(str, th);
        this.f12480a = i;
    }

    public a(Throwable th, int i) {
        super(th);
        this.f12480a = i;
    }

    public int a() {
        return this.f12480a;
    }
}
