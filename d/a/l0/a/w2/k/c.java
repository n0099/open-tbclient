package d.a.l0.a.w2.k;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class c {
    public static void a(@NonNull b bVar, @NonNull d.a.l0.a.l1.e.a.a aVar) {
        bVar.f(aVar.e());
        bVar.g(aVar.f());
        if (aVar.h()) {
            bVar.a(1);
        } else {
            bVar.e(1);
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull d.a.l0.a.p.e.c cVar, @NonNull d.a.l0.a.l1.e.a.a aVar) {
        int i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.g(), aVar.d());
        int i3 = 0;
        if (aVar.h()) {
            i3 = cVar.getWebViewScrollX();
            i2 = cVar.getWebViewScrollY();
        } else {
            i2 = 0;
        }
        layoutParams.leftMargin = aVar.e() + i3;
        layoutParams.topMargin = aVar.f() + i2;
        return layoutParams;
    }
}
