package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f40409a;

    public s(H5Activity h5Activity) {
        this.f40409a = h5Activity;
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f40409a;
        if (R1.a(h5Activity.f40255e, h5Activity.f40258h)) {
            this.f40409a.f40258h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f40409a;
            R1.a(h5Activity2.f40251a, str, h5Activity2.f40255e, h5Activity2.i, str2);
            a1.a(this.f40409a.f40251a).a(new b1(this.f40409a.f40255e), str).a("desc", str2).a();
            I1.a(this.f40409a.f40255e.getId() + this.f40409a.f40256f, "is_click", null);
            G.a(this.f40409a.f40255e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
        this.f40409a.f40257g = str;
    }
}
