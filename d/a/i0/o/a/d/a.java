package d.a.i0.o.a.d;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC1073a f48136a;

    /* renamed from: d.a.i0.o.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1073a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes3.dex */
    public static class b implements InterfaceC1073a {
        @Override // d.a.i0.o.a.d.a.InterfaceC1073a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.i0.o.a.d.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        @Override // d.a.i0.o.a.d.a.b, d.a.i0.o.a.d.a.InterfaceC1073a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.i0.o.a.d.c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.a.i0.o.a.d.a.c, d.a.i0.o.a.d.a.b, d.a.i0.o.a.d.a.InterfaceC1073a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.i0.o.a.d.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f48136a = new d();
        } else if (i2 >= 11) {
            f48136a = new c();
        } else {
            f48136a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f48136a.a(layoutInflater, eVar);
    }
}
