package com.win.opensdk;
/* loaded from: classes7.dex */
public class B0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f36857a;

    public B0(C0 c0) {
        this.f36857a = c0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        D0 d0 = this.f36857a.f36862a;
        long currentTimeMillis = System.currentTimeMillis();
        D0 d02 = this.f36857a.f36862a;
        d0.f36877c = currentTimeMillis - d02.f36876b;
        x0.a(d02.f36875a).a(i2, this.f36857a.f36862a.f36877c).a();
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        long j;
        D0 d0 = this.f36857a.f36862a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f36857a.f36862a.f36876b;
        d0.f36877c = currentTimeMillis - j;
        this.f36857a.f36862a.a((R0) obj);
    }
}
