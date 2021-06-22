package com.win.opensdk;
/* loaded from: classes7.dex */
public class B0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f40568a;

    public B0(C0 c0) {
        this.f40568a = c0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        D0 d0 = this.f40568a.f40573a;
        long currentTimeMillis = System.currentTimeMillis();
        D0 d02 = this.f40568a.f40573a;
        d0.f40588c = currentTimeMillis - d02.f40587b;
        x0.a(d02.f40586a).a(i2, this.f40568a.f40573a.f40588c).a();
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        long j;
        D0 d0 = this.f40568a.f40573a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f40568a.f40573a.f40587b;
        d0.f40588c = currentTimeMillis - j;
        this.f40568a.f40573a.a((R0) obj);
    }
}
