package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class S0 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f36941a;

    public S0(Y0 y0) {
        this.f36941a = y0;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f36941a.f36983c = info;
            if (this.f36941a.f36986f != null) {
                if (info == null || info.getType() != 51) {
                    this.f36941a.f36986f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f36941a.b()) {
                    this.f36941a.f36986f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        r rVar = this.f36941a.f36986f;
        if (rVar != null) {
            rVar.onFail(pBError);
        }
    }
}
