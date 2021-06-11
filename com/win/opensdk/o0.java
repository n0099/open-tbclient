package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class o0 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f40769a;

    public o0(q0 q0Var) {
        this.f40769a = q0Var;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        this.f40769a.a((Info) obj);
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        this.f40769a.f40782h.onFail(pBError);
    }
}
