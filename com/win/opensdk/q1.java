package com.win.opensdk;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class q1 implements S0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r1 f40019a;

    public q1(r1 r1Var) {
        this.f40019a = r1Var;
    }

    @Override // com.win.opensdk.S0
    public void a() {
        S0 s0 = this.f40019a.f40023a.f40029d;
        if (s0 != null) {
            s0.a();
        }
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        S0 s0 = this.f40019a.f40023a.f40029d;
        if (s0 != null) {
            s0.a(i, str);
        }
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        D a2 = t1.a(((u1) obj).f40048c);
        s1 s1Var = this.f40019a.f40023a;
        S0 s0 = s1Var.f40029d;
        if (s0 != null) {
            if (a2 == null) {
                s0.a(101, "");
            } else if (TextUtils.isEmpty(s1Var.f40027b) || !this.f40019a.f40023a.f40027b.equalsIgnoreCase(a2.a())) {
                this.f40019a.f40023a.f40029d.a(2003, "");
            } else {
                this.f40019a.f40023a.f40029d.a(a2);
            }
        }
    }
}
