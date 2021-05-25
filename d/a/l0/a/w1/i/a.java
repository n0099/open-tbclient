package d.a.l0.a.w1.i;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f45604a;

    public a(View view) {
        this.f45604a = view;
    }

    public void a(boolean z) {
        if (z || this.f45604a.getVisibility() != 4) {
            return;
        }
        this.f45604a.setVisibility(8);
    }
}
