package d.a.i0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f49977a;

    /* renamed from: b  reason: collision with root package name */
    public View f49978b;

    public a(View view) {
        this.f49977a = view;
    }

    public void a(boolean z) {
        if (!z && this.f49977a.getVisibility() == 4) {
            this.f49977a.setVisibility(8);
        }
        if (z || this.f49978b == null) {
            return;
        }
        b();
        this.f49978b = null;
    }

    public final void b() {
        this.f49977a.setVisibility(4);
        d.a.i0.w.v.d.b.j(this.f49978b);
    }
}
