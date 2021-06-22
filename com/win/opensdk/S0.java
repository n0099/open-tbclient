package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class S0 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f40723a;

    public S0(Y0 y0) {
        this.f40723a = y0;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f40723a.f40765c = info;
            if (this.f40723a.f40768f != null) {
                if (info == null || info.getType() != 51) {
                    this.f40723a.f40768f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f40723a.b()) {
                    this.f40723a.f40768f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        r rVar = this.f40723a.f40768f;
        if (rVar != null) {
            rVar.onFail(pBError);
        }
    }
}
