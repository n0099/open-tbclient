package d.a.m0.a.w1.i;

import android.view.View;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final View f49386a;

    public a(View view) {
        this.f49386a = view;
    }

    public void a(boolean z) {
        if (z || this.f49386a.getVisibility() != 4) {
            return;
        }
        this.f49386a.setVisibility(8);
    }
}
