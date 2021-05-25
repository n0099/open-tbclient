package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f37111a;

    public s(H5Activity h5Activity) {
        this.f37111a = h5Activity;
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f37111a;
        if (o1.a(h5Activity.f36998e, h5Activity.f37001h)) {
            this.f37111a.f37001h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f37111a;
            o1.a(h5Activity2.f36994a, str, h5Activity2.f36998e, h5Activity2.f37002i, str2);
            x0.a(this.f37111a.f36994a).a(new y0(this.f37111a.f36998e), str).a("desc", str2).a();
            f1.a(this.f37111a.f36998e.getId() + this.f37111a.f36999f, "is_click", null);
            z.a(this.f37111a.f36998e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
        this.f37111a.f37000g = str;
    }
}
