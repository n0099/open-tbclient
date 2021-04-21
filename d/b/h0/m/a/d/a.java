package d.b.h0.m.a.d;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final InterfaceC1060a f49893a;

    /* renamed from: d.b.h0.m.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1060a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes3.dex */
    public static class b implements InterfaceC1060a {
        @Override // d.b.h0.m.a.d.a.InterfaceC1060a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.h0.m.a.d.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
        @Override // d.b.h0.m.a.d.a.b, d.b.h0.m.a.d.a.InterfaceC1060a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.h0.m.a.d.c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.b.h0.m.a.d.a.c, d.b.h0.m.a.d.a.b, d.b.h0.m.a.d.a.InterfaceC1060a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.b.h0.m.a.d.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f49893a = new d();
        } else if (i >= 11) {
            f49893a = new c();
        } else {
            f49893a = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f49893a.a(layoutInflater, eVar);
    }
}
