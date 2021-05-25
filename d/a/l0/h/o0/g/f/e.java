package d.a.l0.h.o0.g.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import d.a.l0.h.o0.g.f.d;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a implements d.a {
        @Override // d.a.l0.h.o0.g.f.d.a
        public void a(View view) {
            if (view == null) {
                return;
            }
            view.setAlpha(1.0f);
        }

        @Override // d.a.l0.h.o0.g.f.d.a
        public void b(View view) {
            if (view == null) {
                return;
            }
            view.setAlpha(0.2f);
        }
    }

    public static void a(View view) {
        b(view, null);
    }

    public static void b(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        d dVar = drawable == null ? new d() : new d(drawable);
        dVar.b(view);
        dVar.a(new a());
        view.setBackground(dVar);
    }
}
