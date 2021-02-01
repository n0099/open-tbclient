package com.qq.e.comm.plugin.j;
/* loaded from: classes15.dex */
public class c extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final String f12180a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12181b;

    public c(int i, String str) {
        super(str);
        this.f12181b = i;
        this.f12180a = str;
    }

    public c(int i, String str, Throwable th) {
        super(str, th);
        this.f12181b = i;
        this.f12180a = str;
    }

    public int a() {
        return this.f12181b;
    }

    public String b() {
        return this.f12180a;
    }
}
