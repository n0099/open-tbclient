package d.a.m0.o.a.d;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC1143a f52094a;

    /* renamed from: d.a.m0.o.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1143a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes3.dex */
    public static class b implements InterfaceC1143a {
        @Override // d.a.m0.o.a.d.a.InterfaceC1143a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.m0.o.a.d.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        @Override // d.a.m0.o.a.d.a.b, d.a.m0.o.a.d.a.InterfaceC1143a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.m0.o.a.d.c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.a.m0.o.a.d.a.c, d.a.m0.o.a.d.a.b, d.a.m0.o.a.d.a.InterfaceC1143a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.m0.o.a.d.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f52094a = new d();
        } else if (i2 >= 11) {
            f52094a = new c();
        } else {
            f52094a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f52094a.a(layoutInflater, eVar);
    }
}
