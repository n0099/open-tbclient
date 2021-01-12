package com.qq.e.comm.plugin.j;
/* loaded from: classes3.dex */
public class c extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final String f12178a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12179b;

    public c(int i, String str) {
        super(str);
        this.f12179b = i;
        this.f12178a = str;
    }

    public c(int i, String str, Throwable th) {
        super(str, th);
        this.f12179b = i;
        this.f12178a = str;
    }

    public int a() {
        return this.f12179b;
    }

    public String b() {
        return this.f12178a;
    }
}
