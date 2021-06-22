package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class G1 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f40608a;

    public G1(I1 i1) {
        this.f40608a = i1;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        this.f40608a.a((Info) obj);
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        this.f40608a.f40624h.onFail(pBError);
    }
}
