package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class c0 implements L0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f40804a;

    public c0(i0 i0Var) {
        this.f40804a = i0Var;
    }

    @Override // com.win.opensdk.L0
    public void a() {
    }

    @Override // com.win.opensdk.L0
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f40804a.f40838c = info;
            if (this.f40804a.f40841f != null) {
                if (info == null || info.getType() != 11) {
                    this.f40804a.f40841f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f40804a.b()) {
                    this.f40804a.f40841f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.L0
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener = this.f40804a.f40841f;
        if (pBNativeListener != null) {
            pBNativeListener.onFail(pBError);
        }
    }
}
