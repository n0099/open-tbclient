package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes6.dex */
public class s implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f37937a;

    public s(H5Activity h5Activity) {
        this.f37937a = h5Activity;
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f37937a;
        if (o1.a(h5Activity.f37824e, h5Activity.f37827h)) {
            this.f37937a.f37827h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f37937a;
            o1.a(h5Activity2.f37820a, str, h5Activity2.f37824e, h5Activity2.f37828i, str2);
            x0.a(this.f37937a.f37820a).a(new y0(this.f37937a.f37824e), str).a("desc", str2).a();
            f1.a(this.f37937a.f37824e.getId() + this.f37937a.f37825f, "is_click", null);
            z.a(this.f37937a.f37824e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
        this.f37937a.f37826g = str;
    }
}
