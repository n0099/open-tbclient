package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f37182a;

    public s(H5Activity h5Activity) {
        this.f37182a = h5Activity;
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f37182a;
        if (o1.a(h5Activity.f37069e, h5Activity.f37072h)) {
            this.f37182a.f37072h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f37182a;
            o1.a(h5Activity2.f37065a, str, h5Activity2.f37069e, h5Activity2.f37073i, str2);
            x0.a(this.f37182a.f37065a).a(new y0(this.f37182a.f37069e), str).a("desc", str2).a();
            f1.a(this.f37182a.f37069e.getId() + this.f37182a.f37070f, "is_click", null);
            z.a(this.f37182a.f37069e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
        this.f37182a.f37071g = str;
    }
}
