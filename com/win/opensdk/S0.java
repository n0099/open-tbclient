package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class S0 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f40620a;

    public S0(Y0 y0) {
        this.f40620a = y0;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f40620a.f40662c = info;
            if (this.f40620a.f40665f != null) {
                if (info == null || info.getType() != 51) {
                    this.f40620a.f40665f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f40620a.b()) {
                    this.f40620a.f40665f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        r rVar = this.f40620a.f40665f;
        if (rVar != null) {
            rVar.onFail(pBError);
        }
    }
}
