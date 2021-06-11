package com.win.opensdk;
/* loaded from: classes7.dex */
public class B0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f40465a;

    public B0(C0 c0) {
        this.f40465a = c0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        D0 d0 = this.f40465a.f40470a;
        long currentTimeMillis = System.currentTimeMillis();
        D0 d02 = this.f40465a.f40470a;
        d0.f40485c = currentTimeMillis - d02.f40484b;
        x0.a(d02.f40483a).a(i2, this.f40465a.f40470a.f40485c).a();
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        long j;
        D0 d0 = this.f40465a.f40470a;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f40465a.f40470a.f40484b;
        d0.f40485c = currentTimeMillis - j;
        this.f40465a.f40470a.a((R0) obj);
    }
}
