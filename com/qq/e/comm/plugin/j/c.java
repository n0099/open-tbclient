package com.qq.e.comm.plugin.j;
/* loaded from: classes4.dex */
public class c extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final String f12478a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12479b;

    public c(int i, String str) {
        super(str);
        this.f12479b = i;
        this.f12478a = str;
    }

    public c(int i, String str, Throwable th) {
        super(str, th);
        this.f12479b = i;
        this.f12478a = str;
    }

    public int a() {
        return this.f12479b;
    }

    public String b() {
        return this.f12478a;
    }
}
