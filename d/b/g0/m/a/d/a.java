package d.b.g0.m.a.d;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC1027a f49171a;

    /* renamed from: d.b.g0.m.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1027a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes3.dex */
    public static class b implements InterfaceC1027a {
        @Override // d.b.g0.m.a.d.a.InterfaceC1027a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.g0.m.a.d.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        @Override // d.b.g0.m.a.d.a.b, d.b.g0.m.a.d.a.InterfaceC1027a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.g0.m.a.d.c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.b.g0.m.a.d.a.c, d.b.g0.m.a.d.a.b, d.b.g0.m.a.d.a.InterfaceC1027a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.g0.m.a.d.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f49171a = new d();
        } else if (i >= 11) {
            f49171a = new c();
        } else {
            f49171a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f49171a.a(layoutInflater, eVar);
    }
}
