package d.a.m0.r.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f54003a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f54004b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54005e;

        public a(int i2) {
            this.f54005e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f54004b = d.a.m0.r.u.a.z(cVar.f54004b, this.f54005e, c.this.f54003a.getMeasuredHeight());
            c.this.f54003a.setBackgroundDrawable(c.this.f54004b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54007e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54008f;

        public b(int i2, int i3) {
            this.f54007e = i2;
            this.f54008f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f54004b = d.a.m0.r.u.a.A(cVar.f54004b, this.f54007e, this.f54008f, c.this.f54003a.getMeasuredHeight());
            c.this.f54003a.setBackgroundDrawable(c.this.f54004b);
        }
    }

    public c(View view) {
        this.f54003a = view;
        this.f54004b = d.a.m0.r.u.a.d(view);
    }

    public static c d(View view) {
        return new c(view);
    }

    public c e(int i2) {
        if (this.f54003a == null) {
            return this;
        }
        this.f54004b = d.a.m0.r.u.a.b(this.f54004b, i2);
        return this;
    }

    public void f(int i2) {
        Drawable i3;
        if (this.f54003a == null || (i3 = d.a.m0.r.u.a.i(this.f54004b, i2)) == null) {
            return;
        }
        this.f54004b = i3;
        this.f54003a.setBackgroundDrawable(i3);
    }

    public void g(int i2) {
        View view = this.f54003a;
        if (view == null) {
            return;
        }
        view.post(new a(i2));
    }

    public void h(int i2, int i3) {
        View view = this.f54003a;
        if (view == null) {
            return;
        }
        view.post(new b(i2, i3));
    }

    public c i(int i2) {
        Drawable e2;
        if (this.f54003a == null || (e2 = d.a.m0.r.u.a.e(this.f54004b, i2)) == null) {
            return this;
        }
        this.f54004b = e2;
        this.f54003a.setBackgroundDrawable(e2);
        return this;
    }

    public c j(int i2) {
        Drawable f2;
        if (this.f54003a == null || (f2 = d.a.m0.r.u.a.f(this.f54004b, i2)) == null) {
            return this;
        }
        this.f54004b = f2;
        this.f54003a.setBackgroundDrawable(f2);
        return this;
    }

    public c k(int i2) {
        if (this.f54003a == null) {
            return this;
        }
        this.f54004b = d.a.m0.r.u.a.g(this.f54004b, i2);
        return this;
    }

    public c l(int i2) {
        if (this.f54003a == null) {
            return this;
        }
        this.f54004b = d.a.m0.r.u.a.l(this.f54004b, i2);
        return this;
    }

    public c m(int i2) {
        if (this.f54003a == null) {
            return this;
        }
        this.f54004b = d.a.m0.r.u.a.k(this.f54004b, i2);
        return this;
    }

    public void n(int[] iArr) {
        Drawable o;
        if (this.f54003a == null || (o = d.a.m0.r.u.a.o(this.f54004b, iArr)) == null) {
            return;
        }
        this.f54004b = o;
        this.f54003a.setBackgroundDrawable(o);
    }

    public c o(int i2) {
        View view = this.f54003a;
        if (view == null) {
            return this;
        }
        view.setLayerType(i2, null);
        return this;
    }

    public c p(int i2) {
        View view = this.f54003a;
        if (view instanceof TextView) {
            ((TextView) view).setLinkTextColor(d.a.m0.r.u.a.h(i2));
            return this;
        }
        return this;
    }

    public void q(int i2) {
        Drawable s;
        if (this.f54003a == null || (s = d.a.m0.r.u.a.s(this.f54004b, d.a.m0.r.u.a.C(i2))) == null) {
            return;
        }
        this.f54004b = s;
        this.f54003a.setBackgroundDrawable(s);
    }

    public c r(int i2) {
        Drawable x;
        View view = this.f54003a;
        if (view == null || (x = d.a.m0.r.u.a.x(view, this.f54004b, d.a.m0.r.u.a.C(i2))) == null) {
            return this;
        }
        this.f54004b = x;
        this.f54003a.setBackgroundDrawable(x);
        o(1);
        return this;
    }

    public c s(int i2) {
        View view = this.f54003a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.m0.r.u.a.h(i2));
            return this;
        }
        return this;
    }

    public c t(int i2) {
        View view = this.f54003a;
        if (view instanceof EMTextView) {
            ((EMTextView) view).setLineSpacing(d.a.m0.r.u.a.m(i2), ((EMTextView) this.f54003a).getLineSpacingMultiplier());
            return this;
        }
        throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
    }

    public c u(int i2) {
        View view = this.f54003a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.m0.r.u.a.D(i2));
            return this;
        }
        return this;
    }

    public c v(int i2) {
        if (this.f54003a instanceof TextView) {
            float[] y = d.a.m0.r.u.a.y(i2);
            ((TextView) this.f54003a).setShadowLayer(y[1], y[2], y[3], (int) y[0]);
            return this;
        }
        return this;
    }

    public c w(int i2) {
        View view = this.f54003a;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, d.a.m0.r.u.a.m(i2));
            return this;
        }
        return this;
    }

    public c x(int i2) {
        View view = this.f54003a;
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(d.a.m0.r.u.a.E(d.a.m0.r.u.a.B(i2)));
            return this;
        }
        return this;
    }
}
