package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class G1 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f37652a;

    public G1(I1 i1) {
        this.f37652a = i1;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        this.f37652a.a((Info) obj);
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        this.f37652a.f37668h.onFail(pBError);
    }
}
