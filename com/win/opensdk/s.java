package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f40024a;

    public s(H5Activity h5Activity) {
        this.f40024a = h5Activity;
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f40024a;
        if (R1.a(h5Activity.f39870e, h5Activity.f39873h)) {
            this.f40024a.f39873h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f40024a;
            R1.a(h5Activity2.f39866a, str, h5Activity2.f39870e, h5Activity2.i, str2);
            a1.a(this.f40024a.f39866a).a(new b1(this.f40024a.f39870e), str).a("desc", str2).a();
            I1.a(this.f40024a.f39870e.getId() + this.f40024a.f39871f, "is_click", null);
            G.a(this.f40024a.f39870e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
        this.f40024a.f39872g = str;
    }
}
