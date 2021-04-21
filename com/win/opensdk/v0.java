package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class v0 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40442a;

    public v0(y0 y0Var) {
        this.f40442a = y0Var;
    }

    @Override // com.win.opensdk.o1
    public void a() {
    }

    @Override // com.win.opensdk.o1
    public void a(Object obj) {
        this.f40442a.a((Info) obj);
    }

    @Override // com.win.opensdk.o1
    public void onFail(PBError pBError) {
        this.f40442a.f40497h.onFail(pBError);
    }
}
