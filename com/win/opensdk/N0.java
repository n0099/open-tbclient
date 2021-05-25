package com.win.opensdk;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class N0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ O0 f36888a;

    public N0(O0 o0) {
        this.f36888a = o0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
        r0 r0Var = this.f36888a.f36890a.f36894d;
        if (r0Var != null) {
            r0Var.a();
        }
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        r0 r0Var = this.f36888a.f36890a.f36894d;
        if (r0Var != null) {
            r0Var.a(i2, str);
        }
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        w a2 = Q0.a(((R0) obj).f36930c);
        P0 p0 = this.f36888a.f36890a;
        r0 r0Var = p0.f36894d;
        if (r0Var != null) {
            if (a2 == null) {
                r0Var.a(101, "");
            } else if (TextUtils.isEmpty(p0.f36892b) || !this.f36888a.f36890a.f36892b.equalsIgnoreCase(a2.a())) {
                this.f36888a.f36890a.f36894d.a(2003, "");
            } else {
                this.f36888a.f36890a.f36894d.a(a2);
            }
        }
    }
}
