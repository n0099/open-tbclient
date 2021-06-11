package d.a.l0.o.a.d;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC1140a f51986a;

    /* renamed from: d.a.l0.o.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1140a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes3.dex */
    public static class b implements InterfaceC1140a {
        @Override // d.a.l0.o.a.d.a.InterfaceC1140a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.l0.o.a.d.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        @Override // d.a.l0.o.a.d.a.b, d.a.l0.o.a.d.a.InterfaceC1140a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.l0.o.a.d.c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.a.l0.o.a.d.a.c, d.a.l0.o.a.d.a.b, d.a.l0.o.a.d.a.InterfaceC1140a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a.l0.o.a.d.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f51986a = new d();
        } else if (i2 >= 11) {
            f51986a = new c();
        } else {
            f51986a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f51986a.a(layoutInflater, eVar);
    }
}
