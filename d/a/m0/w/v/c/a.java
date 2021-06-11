package d.a.m0.w.v.c;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f54546a;

    /* renamed from: b  reason: collision with root package name */
    public View f54547b;

    public a(View view) {
        this.f54546a = view;
    }

    public void a(boolean z) {
        if (!z && this.f54546a.getVisibility() == 4) {
            this.f54546a.setVisibility(8);
        }
        if (z || this.f54547b == null) {
            return;
        }
        b();
        this.f54547b = null;
    }

    public final void b() {
        this.f54546a.setVisibility(4);
        d.a.m0.w.v.d.b.j(this.f54547b);
    }
}
