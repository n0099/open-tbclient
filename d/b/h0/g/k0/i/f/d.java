package d.b.h0.g.k0.i.f;

import android.view.View;
import d.b.h0.g.k0.i.f.c;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a implements c.a {
        @Override // d.b.h0.g.k0.i.f.c.a
        public void a(View view) {
            if (view == null) {
                return;
            }
            view.setAlpha(0.2f);
        }

        @Override // d.b.h0.g.k0.i.f.c.a
        public void b(View view) {
            if (view == null) {
                return;
            }
            view.setAlpha(1.0f);
        }
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        c cVar = new c();
        cVar.b(view);
        cVar.a(new a());
        view.setBackground(cVar);
    }
}
