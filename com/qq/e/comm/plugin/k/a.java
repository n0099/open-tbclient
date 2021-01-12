package com.qq.e.comm.plugin.k;
/* loaded from: classes3.dex */
public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f12180a;

    public a(String str, int i) {
        super(str);
        this.f12180a = i;
    }

    public a(String str, Throwable th, int i) {
        super(str, th);
        this.f12180a = i;
    }

    public a(Throwable th, int i) {
        super(th);
        this.f12180a = i;
    }

    public int a() {
        return this.f12180a;
    }
}
