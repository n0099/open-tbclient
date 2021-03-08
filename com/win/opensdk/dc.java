package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class dc implements du {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dv f8150a;

    public dc(dv dvVar) {
        this.f8150a = dvVar;
    }

    @Override // com.win.opensdk.du
    public void a() {
    }

    @Override // com.win.opensdk.du
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f8150a.qkh = info;
            if (this.f8150a.qlX != null) {
                if (info == null || info.getType() != 11) {
                    this.f8150a.qlX.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f8150a.b()) {
                    this.f8150a.qlX.onLoaded();
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.win.opensdk.du
    public void onFail(PBError pBError) {
        PBNativeListener pBNativeListener = this.f8150a.qlX;
        if (pBNativeListener != null) {
            pBNativeListener.onFail(pBError);
        }
    }
}
