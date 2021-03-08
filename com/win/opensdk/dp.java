package com.win.opensdk;
/* loaded from: classes14.dex */
public class dp implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dv f8156a;

    public dp(dv dvVar) {
        this.f8156a = dvVar;
    }

    @Override // com.win.opensdk.g
    public void a(String str) {
    }

    @Override // com.win.opensdk.g
    public boolean a(String str, String str2) {
        dv dvVar = this.f8156a;
        if (bf.a(dvVar.qkh, dvVar.h)) {
            this.f8156a.h = System.currentTimeMillis();
            dv dvVar2 = this.f8156a;
            bf.a(dvVar2.f8159a, str, dvVar2.qkh, dvVar2.qlY, str2);
            ca.iT(this.f8156a.f8159a).a(new cd(this.f8156a.qkh), str).hD("desc", str2).a();
            PBNativeListener pBNativeListener = this.f8156a.qlX;
            if (pBNativeListener != null) {
                pBNativeListener.onClicked();
            }
            v.a(this.f8156a.qkh, str2);
            return true;
        }
        return true;
    }
}
