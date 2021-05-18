package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class S0 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f37012a;

    public S0(Y0 y0) {
        this.f37012a = y0;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f37012a.f37054c = info;
            if (this.f37012a.f37057f != null) {
                if (info == null || info.getType() != 51) {
                    this.f37012a.f37057f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f37012a.b()) {
                    this.f37012a.f37057f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        r rVar = this.f37012a.f37057f;
        if (rVar != null) {
            rVar.onFail(pBError);
        }
    }
}
