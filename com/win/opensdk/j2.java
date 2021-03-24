package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class j2 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f39959a;

    public j2(m2 m2Var) {
        this.f39959a = m2Var;
    }

    @Override // com.win.opensdk.o1
    public void a() {
    }

    @Override // com.win.opensdk.o1
    public void a(Object obj) {
        m2.a(this.f39959a, (Info) obj);
    }

    @Override // com.win.opensdk.o1
    public void onFail(PBError pBError) {
        this.f39959a.f39981h.onFail(pBError);
    }
}
