package d.a.m0.o.a.d;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final k f52098a;

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
        @Override // d.a.m0.o.a.d.f.k
        public int a(View view) {
            return d.a.m0.o.a.d.g.a(view);
        }

        @Override // d.a.m0.o.a.d.f.k
        public void c(View view, int i2, Paint paint) {
            d.a.m0.o.a.d.g.b(view, i2, paint);
        }

        @Override // d.a.m0.o.a.d.f.k
        public void d(View view, boolean z) {
            d.a.m0.o.a.d.g.c(view, z);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends d {
        @Override // d.a.m0.o.a.d.f.k
        public boolean b(View view, int i2) {
            return d.a.m0.o.a.d.h.a(view, i2);
        }
    }

    /* renamed from: d.a.m0.o.a.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1144f extends e {
        @Override // d.a.m0.o.a.d.f.k
        public boolean e(View view) {
            return d.a.m0.o.a.d.i.a(view);
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends C1144f {
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

        boolean b(View view, int i2);

        void c(View view, int i2, Paint paint);

        void d(View view, boolean z);

        boolean e(View view);
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f52098a = new j();
        } else {
            f52098a = new i();
        }
    }

    public static boolean a(View view, int i2) {
        return f52098a.b(view, i2);
    }

    public static int b(View view) {
        return f52098a.a(view);
    }

    public static boolean c(View view) {
        return f52098a.e(view);
    }

    public static void d(View view, int i2, Paint paint) {
        f52098a.c(view, i2, paint);
    }

    public static void e(View view, boolean z) {
        f52098a.d(view, z);
    }
}
