package d.a.h0.m.a.d;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final k f47422a;

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
        @Override // d.a.h0.m.a.d.f.k
        public int a(View view) {
            return d.a.h0.m.a.d.g.a(view);
        }

        @Override // d.a.h0.m.a.d.f.k
        public void c(View view, int i2, Paint paint) {
            d.a.h0.m.a.d.g.b(view, i2, paint);
        }

        @Override // d.a.h0.m.a.d.f.k
        public void d(View view, boolean z) {
            d.a.h0.m.a.d.g.c(view, z);
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends d {
        @Override // d.a.h0.m.a.d.f.k
        public boolean b(View view, int i2) {
            return d.a.h0.m.a.d.h.a(view, i2);
        }
    }

    /* renamed from: d.a.h0.m.a.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1000f extends e {
        @Override // d.a.h0.m.a.d.f.k
        public boolean e(View view) {
            return d.a.h0.m.a.d.i.a(view);
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends C1000f {
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
            f47422a = new j();
        } else {
            f47422a = new i();
        }
    }

    public static boolean a(View view, int i2) {
        return f47422a.b(view, i2);
    }

    public static int b(View view) {
        return f47422a.a(view);
    }

    public static boolean c(View view) {
        return f47422a.e(view);
    }

    public static void d(View view, int i2, Paint paint) {
        f47422a.c(view, i2, paint);
    }

    public static void e(View view, boolean z) {
        f47422a.d(view, z);
    }
}
