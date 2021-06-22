package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f40893a;

    public s(H5Activity h5Activity) {
        this.f40893a = h5Activity;
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f40893a;
        if (o1.a(h5Activity.f40780e, h5Activity.f40783h)) {
            this.f40893a.f40783h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f40893a;
            o1.a(h5Activity2.f40776a, str, h5Activity2.f40780e, h5Activity2.f40784i, str2);
            x0.a(this.f40893a.f40776a).a(new y0(this.f40893a.f40780e), str).a("desc", str2).a();
            f1.a(this.f40893a.f40780e.getId() + this.f40893a.f40781f, "is_click", null);
            z.a(this.f40893a.f40780e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
        this.f40893a.f40782g = str;
    }
}
