package d.b.h0.r.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f51462a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f51463b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51464e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51465f;

        public a(int i, int i2) {
            this.f51464e = i;
            this.f51465f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f51463b = d.b.h0.r.u.a.y(cVar.f51463b, this.f51464e, this.f51465f, c.this.f51462a.getMeasuredHeight());
            c.this.f51462a.setBackgroundDrawable(c.this.f51463b);
        }
    }

    public c(View view) {
        this.f51462a = view;
        this.f51463b = d.b.h0.r.u.a.d(view);
    }

    public static c d(View view) {
        return new c(view);
    }

    public c e(int i) {
        if (this.f51462a == null) {
            return this;
        }
        this.f51463b = d.b.h0.r.u.a.b(this.f51463b, i);
        return this;
    }

    public void f(int i) {
        Drawable h2;
        if (this.f51462a == null || (h2 = d.b.h0.r.u.a.h(this.f51463b, i)) == null) {
            return;
        }
        this.f51463b = h2;
        this.f51462a.setBackgroundDrawable(h2);
    }

    public void g(int i, int i2) {
        View view = this.f51462a;
        if (view == null) {
            return;
        }
        view.post(new a(i, i2));
    }

    public c h(int i) {
        Drawable e2;
        if (this.f51462a == null || (e2 = d.b.h0.r.u.a.e(this.f51463b, i)) == null) {
            return this;
        }
        this.f51463b = e2;
        this.f51462a.setBackgroundDrawable(e2);
        return this;
    }

    public c i(int i) {
        if (this.f51462a == null) {
            return this;
        }
        this.f51463b = d.b.h0.r.u.a.f(this.f51463b, i);
        return this;
    }

    public c j(int i) {
        if (this.f51462a == null) {
            return this;
        }
        this.f51463b = d.b.h0.r.u.a.k(this.f51463b, i);
        return this;
    }

    public c k(int i) {
        if (this.f51462a == null) {
            return this;
        }
        this.f51463b = d.b.h0.r.u.a.j(this.f51463b, i);
        return this;
    }

    public void l(int[] iArr) {
        Drawable n;
        if (this.f51462a == null || (n = d.b.h0.r.u.a.n(this.f51463b, iArr)) == null) {
            return;
        }
        this.f51463b = n;
        this.f51462a.setBackgroundDrawable(n);
    }

    public c m(int i) {
        View view = this.f51462a;
        if (view == null) {
            return this;
        }
        view.setLayerType(i, null);
        return this;
    }

    public c n(int i) {
        View view = this.f51462a;
        if (view instanceof TextView) {
            ((TextView) view).setLinkTextColor(d.b.h0.r.u.a.g(i));
            return this;
        }
        return this;
    }

    public void o(int i) {
        Drawable r;
        if (this.f51462a == null || (r = d.b.h0.r.u.a.r(this.f51463b, d.b.h0.r.u.a.A(i))) == null) {
            return;
        }
        this.f51463b = r;
        this.f51462a.setBackgroundDrawable(r);
    }

    public c p(int i) {
        Drawable w;
        View view = this.f51462a;
        if (view == null || (w = d.b.h0.r.u.a.w(view, this.f51463b, d.b.h0.r.u.a.A(i))) == null) {
            return this;
        }
        this.f51463b = w;
        this.f51462a.setBackgroundDrawable(w);
        m(1);
        return this;
    }

    public c q(int i) {
        View view = this.f51462a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.b.h0.r.u.a.g(i));
            return this;
        }
        return this;
    }

    public c r(int i) {
        View view = this.f51462a;
        if (view instanceof EMTextView) {
            ((EMTextView) view).setLineSpacing(d.b.h0.r.u.a.l(i), ((EMTextView) this.f51462a).getLineSpacingMultiplier());
            return this;
        }
        throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
    }

    public c s(int i) {
        View view = this.f51462a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.b.h0.r.u.a.B(i));
            return this;
        }
        return this;
    }

    public c t(int i) {
        if (this.f51462a instanceof TextView) {
            float[] x = d.b.h0.r.u.a.x(i);
            ((TextView) this.f51462a).setShadowLayer(x[1], x[2], x[3], (int) x[0]);
            return this;
        }
        return this;
    }

    public c u(int i) {
        View view = this.f51462a;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, d.b.h0.r.u.a.l(i));
            return this;
        }
        return this;
    }

    public c v(int i) {
        View view = this.f51462a;
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(d.b.h0.r.u.a.C(d.b.h0.r.u.a.z(i)));
            return this;
        }
        return this;
    }
}
