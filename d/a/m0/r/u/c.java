package d.a.m0.r.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f50327a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f50328b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50329e;

        public a(int i2) {
            this.f50329e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f50328b = d.a.m0.r.u.a.z(cVar.f50328b, this.f50329e, c.this.f50327a.getMeasuredHeight());
            c.this.f50327a.setBackgroundDrawable(c.this.f50328b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50332f;

        public b(int i2, int i3) {
            this.f50331e = i2;
            this.f50332f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f50328b = d.a.m0.r.u.a.A(cVar.f50328b, this.f50331e, this.f50332f, c.this.f50327a.getMeasuredHeight());
            c.this.f50327a.setBackgroundDrawable(c.this.f50328b);
        }
    }

    public c(View view) {
        this.f50327a = view;
        this.f50328b = d.a.m0.r.u.a.d(view);
    }

    public static c d(View view) {
        return new c(view);
    }

    public c e(int i2) {
        if (this.f50327a == null) {
            return this;
        }
        this.f50328b = d.a.m0.r.u.a.b(this.f50328b, i2);
        return this;
    }

    public void f(int i2) {
        Drawable i3;
        if (this.f50327a == null || (i3 = d.a.m0.r.u.a.i(this.f50328b, i2)) == null) {
            return;
        }
        this.f50328b = i3;
        this.f50327a.setBackgroundDrawable(i3);
    }

    public void g(int i2) {
        View view = this.f50327a;
        if (view == null) {
            return;
        }
        view.post(new a(i2));
    }

    public void h(int i2, int i3) {
        View view = this.f50327a;
        if (view == null) {
            return;
        }
        view.post(new b(i2, i3));
    }

    public c i(int i2) {
        Drawable e2;
        if (this.f50327a == null || (e2 = d.a.m0.r.u.a.e(this.f50328b, i2)) == null) {
            return this;
        }
        this.f50328b = e2;
        this.f50327a.setBackgroundDrawable(e2);
        return this;
    }

    public c j(int i2) {
        Drawable f2;
        if (this.f50327a == null || (f2 = d.a.m0.r.u.a.f(this.f50328b, i2)) == null) {
            return this;
        }
        this.f50328b = f2;
        this.f50327a.setBackgroundDrawable(f2);
        return this;
    }

    public c k(int i2) {
        if (this.f50327a == null) {
            return this;
        }
        this.f50328b = d.a.m0.r.u.a.g(this.f50328b, i2);
        return this;
    }

    public c l(int i2) {
        if (this.f50327a == null) {
            return this;
        }
        this.f50328b = d.a.m0.r.u.a.l(this.f50328b, i2);
        return this;
    }

    public c m(int i2) {
        if (this.f50327a == null) {
            return this;
        }
        this.f50328b = d.a.m0.r.u.a.k(this.f50328b, i2);
        return this;
    }

    public void n(int[] iArr) {
        Drawable o;
        if (this.f50327a == null || (o = d.a.m0.r.u.a.o(this.f50328b, iArr)) == null) {
            return;
        }
        this.f50328b = o;
        this.f50327a.setBackgroundDrawable(o);
    }

    public c o(int i2) {
        View view = this.f50327a;
        if (view == null) {
            return this;
        }
        view.setLayerType(i2, null);
        return this;
    }

    public c p(int i2) {
        View view = this.f50327a;
        if (view instanceof TextView) {
            ((TextView) view).setLinkTextColor(d.a.m0.r.u.a.h(i2));
            return this;
        }
        return this;
    }

    public void q(int i2) {
        Drawable s;
        if (this.f50327a == null || (s = d.a.m0.r.u.a.s(this.f50328b, d.a.m0.r.u.a.C(i2))) == null) {
            return;
        }
        this.f50328b = s;
        this.f50327a.setBackgroundDrawable(s);
    }

    public c r(int i2) {
        Drawable x;
        View view = this.f50327a;
        if (view == null || (x = d.a.m0.r.u.a.x(view, this.f50328b, d.a.m0.r.u.a.C(i2))) == null) {
            return this;
        }
        this.f50328b = x;
        this.f50327a.setBackgroundDrawable(x);
        o(1);
        return this;
    }

    public c s(int i2) {
        View view = this.f50327a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.m0.r.u.a.h(i2));
            return this;
        }
        return this;
    }

    public c t(int i2) {
        View view = this.f50327a;
        if (view instanceof EMTextView) {
            ((EMTextView) view).setLineSpacing(d.a.m0.r.u.a.m(i2), ((EMTextView) this.f50327a).getLineSpacingMultiplier());
            return this;
        }
        throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
    }

    public c u(int i2) {
        View view = this.f50327a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.m0.r.u.a.D(i2));
            return this;
        }
        return this;
    }

    public c v(int i2) {
        if (this.f50327a instanceof TextView) {
            float[] y = d.a.m0.r.u.a.y(i2);
            ((TextView) this.f50327a).setShadowLayer(y[1], y[2], y[3], (int) y[0]);
            return this;
        }
        return this;
    }

    public c w(int i2) {
        View view = this.f50327a;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, d.a.m0.r.u.a.m(i2));
            return this;
        }
        return this;
    }

    public c x(int i2) {
        View view = this.f50327a;
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(d.a.m0.r.u.a.E(d.a.m0.r.u.a.B(i2)));
            return this;
        }
        return this;
    }
}
