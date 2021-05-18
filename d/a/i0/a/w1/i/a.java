package d.a.i0.a.w1.i;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f45428a;

    public a(View view) {
        this.f45428a = view;
    }

    public void a(boolean z) {
        if (z || this.f45428a.getVisibility() != 4) {
            return;
        }
        this.f45428a.setVisibility(8);
    }
}
