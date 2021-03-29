package d.b.h0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f51551a;

    /* renamed from: b  reason: collision with root package name */
    public View f51552b;

    public a(View view) {
        this.f51551a = view;
    }

    public void a(boolean z) {
        if (!z && this.f51551a.getVisibility() == 4) {
            this.f51551a.setVisibility(8);
        }
        if (z || this.f51552b == null) {
            return;
        }
        b();
        this.f51552b = null;
    }

    public final void b() {
        this.f51551a.setVisibility(4);
        d.b.h0.w.v.d.b.j(this.f51552b);
    }
}
