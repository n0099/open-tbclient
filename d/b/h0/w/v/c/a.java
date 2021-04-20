package d.b.h0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f51969a;

    /* renamed from: b  reason: collision with root package name */
    public View f51970b;

    public a(View view) {
        this.f51969a = view;
    }

    public void a(boolean z) {
        if (!z && this.f51969a.getVisibility() == 4) {
            this.f51969a.setVisibility(8);
        }
        if (z || this.f51970b == null) {
            return;
        }
        b();
        this.f51970b = null;
    }

    public final void b() {
        this.f51969a.setVisibility(4);
        d.b.h0.w.v.d.b.j(this.f51970b);
    }
}
