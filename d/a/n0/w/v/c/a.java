package d.a.n0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f54653a;

    /* renamed from: b  reason: collision with root package name */
    public View f54654b;

    public a(View view) {
        this.f54653a = view;
    }

    public void a(boolean z) {
        if (!z && this.f54653a.getVisibility() == 4) {
            this.f54653a.setVisibility(8);
        }
        if (z || this.f54654b == null) {
            return;
        }
        b();
        this.f54654b = null;
    }

    public final void b() {
        this.f54653a.setVisibility(4);
        d.a.n0.w.v.d.b.j(this.f54654b);
    }
}
