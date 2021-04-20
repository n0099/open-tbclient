package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f40314a;

    public s(H5Activity h5Activity) {
        this.f40314a = h5Activity;
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f40314a;
        if (R1.a(h5Activity.f40160e, h5Activity.f40163h)) {
            this.f40314a.f40163h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f40314a;
            R1.a(h5Activity2.f40156a, str, h5Activity2.f40160e, h5Activity2.i, str2);
            a1.a(this.f40314a.f40156a).a(new b1(this.f40314a.f40160e), str).a("desc", str2).a();
            I1.a(this.f40314a.f40160e.getId() + this.f40314a.f40161f, "is_click", null);
            G.a(this.f40314a.f40160e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
        this.f40314a.f40162g = str;
    }
}
