package com.win.opensdk;
/* loaded from: classes7.dex */
public class B0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f36786a;

    public B0(C0 c0) {
        this.f36786a = c0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        D0 d0 = this.f36786a.f36791a;
        long currentTimeMillis = System.currentTimeMillis();
        D0 d02 = this.f36786a.f36791a;
        d0.f36806c = currentTimeMillis - d02.f36805b;
        x0.a(d02.f36804a).a(i2, this.f36786a.f36791a.f36806c).a();
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        long j;
        D0 d0 = this.f36786a.f36791a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f36786a.f36791a.f36805b;
        d0.f36806c = currentTimeMillis - j;
        this.f36786a.f36791a.a((R0) obj);
    }
}
