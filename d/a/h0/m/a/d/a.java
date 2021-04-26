package d.a.h0.m.a.d;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC0999a f47418a;

    /* renamed from: d.a.h0.m.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0999a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes3.dex */
    public static class b implements InterfaceC0999a {
        @Override // d.a.h0.m.a.d.a.InterfaceC0999a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.h0.m.a.d.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        @Override // d.a.h0.m.a.d.a.b, d.a.h0.m.a.d.a.InterfaceC0999a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.h0.m.a.d.c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.a.h0.m.a.d.a.c, d.a.h0.m.a.d.a.b, d.a.h0.m.a.d.a.InterfaceC0999a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.h0.m.a.d.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f47418a = new d();
        } else if (i2 >= 11) {
            f47418a = new c();
        } else {
            f47418a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f47418a.a(layoutInflater, eVar);
    }
}
