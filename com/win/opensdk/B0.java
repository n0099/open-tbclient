package com.win.opensdk;
/* loaded from: classes6.dex */
public class B0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f37612a;

    public B0(C0 c0) {
        this.f37612a = c0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        D0 d0 = this.f37612a.f37617a;
        long currentTimeMillis = System.currentTimeMillis();
        D0 d02 = this.f37612a.f37617a;
        d0.f37632c = currentTimeMillis - d02.f37631b;
        x0.a(d02.f37630a).a(i2, this.f37612a.f37617a.f37632c).a();
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        long j;
        D0 d0 = this.f37612a.f37617a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f37612a.f37617a.f37631b;
        d0.f37632c = currentTimeMillis - j;
        this.f37612a.f37617a.a((R0) obj);
    }
}
