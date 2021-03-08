package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes14.dex */
public class ef implements g {
    public final /* synthetic */ H5Activity qmh;

    public ef(H5Activity h5Activity) {
        this.qmh = h5Activity;
    }

    @Override // com.win.opensdk.g
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.qmh;
        if (bf.a(h5Activity.qlr, h5Activity.h)) {
            this.qmh.h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.qmh;
            bf.a(h5Activity2.f8105a, str, h5Activity2.qlr, h5Activity2.qls, str2);
            ca.iT(this.qmh.f8105a).a(new cd(this.qmh.qlr), str).hD("desc", str2).a();
            ae.a(this.qmh.qlr.getId() + this.qmh.f, "is_click", null);
            v.a(this.qmh.qlr, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.g
    public void a(String str) {
        this.qmh.g = str;
    }
}
