package d.a.i0.r.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f49446a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f49447b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f49448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49449f;

        public a(int i2, int i3) {
            this.f49448e = i2;
            this.f49449f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f49447b = d.a.i0.r.u.a.y(cVar.f49447b, this.f49448e, this.f49449f, c.this.f49446a.getMeasuredHeight());
            c.this.f49446a.setBackgroundDrawable(c.this.f49447b);
        }
    }

    public c(View view) {
        this.f49446a = view;
        this.f49447b = d.a.i0.r.u.a.d(view);
    }

    public static c d(View view) {
        return new c(view);
    }

    public c e(int i2) {
        if (this.f49446a == null) {
            return this;
        }
        this.f49447b = d.a.i0.r.u.a.b(this.f49447b, i2);
        return this;
    }

    public void f(int i2) {
        Drawable h2;
        if (this.f49446a == null || (h2 = d.a.i0.r.u.a.h(this.f49447b, i2)) == null) {
            return;
        }
        this.f49447b = h2;
        this.f49446a.setBackgroundDrawable(h2);
    }

    public void g(int i2, int i3) {
        View view = this.f49446a;
        if (view == null) {
            return;
        }
        view.post(new a(i2, i3));
    }

    public c h(int i2) {
        Drawable e2;
        if (this.f49446a == null || (e2 = d.a.i0.r.u.a.e(this.f49447b, i2)) == null) {
            return this;
        }
        this.f49447b = e2;
        this.f49446a.setBackgroundDrawable(e2);
        return this;
    }

    public c i(int i2) {
        if (this.f49446a == null) {
            return this;
        }
        this.f49447b = d.a.i0.r.u.a.f(this.f49447b, i2);
        return this;
    }

    public c j(int i2) {
        if (this.f49446a == null) {
            return this;
        }
        this.f49447b = d.a.i0.r.u.a.k(this.f49447b, i2);
        return this;
    }

    public c k(int i2) {
        if (this.f49446a == null) {
            return this;
        }
        this.f49447b = d.a.i0.r.u.a.j(this.f49447b, i2);
        return this;
    }

    public void l(int[] iArr) {
        Drawable n;
        if (this.f49446a == null || (n = d.a.i0.r.u.a.n(this.f49447b, iArr)) == null) {
            return;
        }
        this.f49447b = n;
        this.f49446a.setBackgroundDrawable(n);
    }

    public c m(int i2) {
        View view = this.f49446a;
        if (view == null) {
            return this;
        }
        view.setLayerType(i2, null);
        return this;
    }

    public c n(int i2) {
        View view = this.f49446a;
        if (view instanceof TextView) {
            ((TextView) view).setLinkTextColor(d.a.i0.r.u.a.g(i2));
            return this;
        }
        return this;
    }

    public void o(int i2) {
        Drawable r;
        if (this.f49446a == null || (r = d.a.i0.r.u.a.r(this.f49447b, d.a.i0.r.u.a.A(i2))) == null) {
            return;
        }
        this.f49447b = r;
        this.f49446a.setBackgroundDrawable(r);
    }

    public c p(int i2) {
        Drawable w;
        View view = this.f49446a;
        if (view == null || (w = d.a.i0.r.u.a.w(view, this.f49447b, d.a.i0.r.u.a.A(i2))) == null) {
            return this;
        }
        this.f49447b = w;
        this.f49446a.setBackgroundDrawable(w);
        m(1);
        return this;
    }

    public c q(int i2) {
        View view = this.f49446a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.i0.r.u.a.g(i2));
            return this;
        }
        return this;
    }

    public c r(int i2) {
        View view = this.f49446a;
        if (view instanceof EMTextView) {
            ((EMTextView) view).setLineSpacing(d.a.i0.r.u.a.l(i2), ((EMTextView) this.f49446a).getLineSpacingMultiplier());
            return this;
        }
        throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
    }

    public c s(int i2) {
        View view = this.f49446a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.i0.r.u.a.B(i2));
            return this;
        }
        return this;
    }

    public c t(int i2) {
        if (this.f49446a instanceof TextView) {
            float[] x = d.a.i0.r.u.a.x(i2);
            ((TextView) this.f49446a).setShadowLayer(x[1], x[2], x[3], (int) x[0]);
            return this;
        }
        return this;
    }

    public c u(int i2) {
        View view = this.f49446a;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, d.a.i0.r.u.a.l(i2));
            return this;
        }
        return this;
    }

    public c v(int i2) {
        View view = this.f49446a;
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(d.a.i0.r.u.a.C(d.a.i0.r.u.a.z(i2)));
            return this;
        }
        return this;
    }
}
