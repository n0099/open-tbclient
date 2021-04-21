package d.b.i0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f52305a;

    /* renamed from: b  reason: collision with root package name */
    public View f52306b;

    public a(View view) {
        this.f52305a = view;
    }

    public void a(boolean z) {
        if (!z && this.f52305a.getVisibility() == 4) {
            this.f52305a.setVisibility(8);
        }
        if (z || this.f52306b == null) {
            return;
        }
        b();
        this.f52306b = null;
    }

    public final void b() {
        this.f52305a.setVisibility(4);
        d.b.i0.w.v.d.b.j(this.f52306b);
    }
}
