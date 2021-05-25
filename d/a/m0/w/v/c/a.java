package d.a.m0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f50869a;

    /* renamed from: b  reason: collision with root package name */
    public View f50870b;

    public a(View view) {
        this.f50869a = view;
    }

    public void a(boolean z) {
        if (!z && this.f50869a.getVisibility() == 4) {
            this.f50869a.setVisibility(8);
        }
        if (z || this.f50870b == null) {
            return;
        }
        b();
        this.f50870b = null;
    }

    public final void b() {
        this.f50869a.setVisibility(4);
        d.a.m0.w.v.d.b.j(this.f50870b);
    }
}
