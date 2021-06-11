package com.win.opensdk;

import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class s implements V1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ H5Activity f40790a;

    public s(H5Activity h5Activity) {
        this.f40790a = h5Activity;
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        H5Activity h5Activity = this.f40790a;
        if (o1.a(h5Activity.f40677e, h5Activity.f40680h)) {
            this.f40790a.f40680h = System.currentTimeMillis();
            H5Activity h5Activity2 = this.f40790a;
            o1.a(h5Activity2.f40673a, str, h5Activity2.f40677e, h5Activity2.f40681i, str2);
            x0.a(this.f40790a.f40673a).a(new y0(this.f40790a.f40677e), str).a("desc", str2).a();
            f1.a(this.f40790a.f40677e.getId() + this.f40790a.f40678f, "is_click", null);
            z.a(this.f40790a.f40677e, str2);
            return true;
        }
        return true;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
        this.f40790a.f40679g = str;
    }
}
