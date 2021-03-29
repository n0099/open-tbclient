package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f40025a;

    public s(H5Activity h5Activity) {
        this.f40025a = h5Activity;
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f40025a;
        if (R1.a(h5Activity.f39871e, h5Activity.f39874h)) {
            this.f40025a.f39874h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f40025a;
            R1.a(h5Activity2.f39867a, str, h5Activity2.f39871e, h5Activity2.i, str2);
            a1.a(this.f40025a.f39867a).a(new b1(this.f40025a.f39871e), str).a("desc", str2).a();
            I1.a(this.f40025a.f39871e.getId() + this.f40025a.f39872f, "is_click", null);
            G.a(this.f40025a.f39871e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
        this.f40025a.f39873g = str;
    }
}
