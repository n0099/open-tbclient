package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class c0 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f37093a;

    public c0(i0 i0Var) {
        this.f37093a = i0Var;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f37093a.f37127c = info;
            if (this.f37093a.f37130f != null) {
                if (info == null || info.getType() != 11) {
                    this.f37093a.f37130f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f37093a.b()) {
                    this.f37093a.f37130f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener = this.f37093a.f37130f;
        if (pBNativeListener != null) {
            pBNativeListener.onFail(pBError);
        }
    }
}
