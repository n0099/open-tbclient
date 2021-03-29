package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class j0 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f39957a;

    public j0(p0 p0Var) {
        this.f39957a = p0Var;
    }

    @Override // com.win.opensdk.o1
    public void a() {
    }

    @Override // com.win.opensdk.o1
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f39957a.f40007c = info;
            if (this.f39957a.f40010f != null) {
                if (info == null || info.getType() != 11) {
                    this.f39957a.f40010f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f39957a.b()) {
                    this.f39957a.f40010f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.o1
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener = this.f39957a.f40010f;
        if (pBNativeListener != null) {
            pBNativeListener.onFail(pBError);
        }
    }
}
