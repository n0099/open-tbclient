package d.a.j0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f50796a;

    /* renamed from: b  reason: collision with root package name */
    public View f50797b;

    public a(View view) {
        this.f50796a = view;
    }

    public void a(boolean z) {
        if (!z && this.f50796a.getVisibility() == 4) {
            this.f50796a.setVisibility(8);
        }
        if (z || this.f50797b == null) {
            return;
        }
        b();
        this.f50797b = null;
    }

    public final void b() {
        this.f50796a.setVisibility(4);
        d.a.j0.w.v.d.b.j(this.f50797b);
    }
}
