package d.b.g0.m.a.d;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC1028a f49172a;

    /* renamed from: d.b.g0.m.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1028a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes3.dex */
    public static class b implements InterfaceC1028a {
        @Override // d.b.g0.m.a.d.a.InterfaceC1028a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.g0.m.a.d.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        @Override // d.b.g0.m.a.d.a.b, d.b.g0.m.a.d.a.InterfaceC1028a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.g0.m.a.d.c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.b.g0.m.a.d.a.c, d.b.g0.m.a.d.a.b, d.b.g0.m.a.d.a.InterfaceC1028a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.g0.m.a.d.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f49172a = new d();
        } else if (i >= 11) {
            f49172a = new c();
        } else {
            f49172a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f49172a.a(layoutInflater, eVar);
    }
}
