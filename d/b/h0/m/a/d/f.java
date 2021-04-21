package d.b.h0.m.a.d;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final k f49897a;

    /* loaded from: classes3.dex */
    public static class a implements k {
    }

    /* loaded from: classes3.dex */
    public static class b extends a {
    }

    /* loaded from: classes3.dex */
    public static class c extends b {
    }

    /* loaded from: classes3.dex */
    public static class d extends c {
        @Override // d.b.h0.m.a.d.f.k
        public int a(View view) {
            return d.b.h0.m.a.d.g.a(view);
        }

        @Override // d.b.h0.m.a.d.f.k
        public void b(View view, int i, Paint paint) {
            d.b.h0.m.a.d.g.b(view, i, paint);
        }

        @Override // d.b.h0.m.a.d.f.k
        public void c(View view, boolean z) {
            d.b.h0.m.a.d.g.c(view, z);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends d {
        @Override // d.b.h0.m.a.d.f.k
        public boolean e(View view, int i) {
            return d.b.h0.m.a.d.h.a(view, i);
        }
    }

    /* renamed from: d.b.h0.m.a.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1061f extends e {
        @Override // d.b.h0.m.a.d.f.k
        public boolean d(View view) {
            return d.b.h0.m.a.d.i.a(view);
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends C1061f {
    }

    /* loaded from: classes3.dex */
    public static class h extends g {
    }

    /* loaded from: classes3.dex */
    public static class i extends h {
    }

    /* loaded from: classes3.dex */
    public static class j extends i {
    }

    /* loaded from: classes3.dex */
    public interface k {
        int a(View view);

        void b(View view, int i, Paint paint);

        void c(View view, boolean z);

        boolean d(View view);

        boolean e(View view, int i);
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f49897a = new j();
        } else {
            f49897a = new i();
        }
    }

    public static boolean a(View view, int i2) {
        return f49897a.e(view, i2);
    }

    public static int b(View view) {
        return f49897a.a(view);
    }

    public static boolean c(View view) {
        return f49897a.d(view);
    }

    public static void d(View view, int i2, Paint paint) {
        f49897a.b(view, i2, paint);
    }

    public static void e(View view, boolean z) {
        f49897a.c(view, z);
    }
}
