package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class G1 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f36826a;

    public G1(I1 i1) {
        this.f36826a = i1;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        this.f36826a.a((Info) obj);
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        this.f36826a.f36842h.onFail(pBError);
    }
}
