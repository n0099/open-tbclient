package d.a.j0.r.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f50265a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f50266b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50267e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50268f;

        public a(int i2, int i3) {
            this.f50267e = i2;
            this.f50268f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.f50266b = d.a.j0.r.u.a.y(cVar.f50266b, this.f50267e, this.f50268f, c.this.f50265a.getMeasuredHeight());
            c.this.f50265a.setBackgroundDrawable(c.this.f50266b);
        }
    }

    public c(View view) {
        this.f50265a = view;
        this.f50266b = d.a.j0.r.u.a.d(view);
    }

    public static c d(View view) {
        return new c(view);
    }

    public c e(int i2) {
        if (this.f50265a == null) {
            return this;
        }
        this.f50266b = d.a.j0.r.u.a.b(this.f50266b, i2);
        return this;
    }

    public void f(int i2) {
        Drawable h2;
        if (this.f50265a == null || (h2 = d.a.j0.r.u.a.h(this.f50266b, i2)) == null) {
            return;
        }
        this.f50266b = h2;
        this.f50265a.setBackgroundDrawable(h2);
    }

    public void g(int i2, int i3) {
        View view = this.f50265a;
        if (view == null) {
            return;
        }
        view.post(new a(i2, i3));
    }

    public c h(int i2) {
        Drawable e2;
        if (this.f50265a == null || (e2 = d.a.j0.r.u.a.e(this.f50266b, i2)) == null) {
            return this;
        }
        this.f50266b = e2;
        this.f50265a.setBackgroundDrawable(e2);
        return this;
    }

    public c i(int i2) {
        if (this.f50265a == null) {
            return this;
        }
        this.f50266b = d.a.j0.r.u.a.f(this.f50266b, i2);
        return this;
    }

    public c j(int i2) {
        if (this.f50265a == null) {
            return this;
        }
        this.f50266b = d.a.j0.r.u.a.k(this.f50266b, i2);
        return this;
    }

    public c k(int i2) {
        if (this.f50265a == null) {
            return this;
        }
        this.f50266b = d.a.j0.r.u.a.j(this.f50266b, i2);
        return this;
    }

    public void l(int[] iArr) {
        Drawable n;
        if (this.f50265a == null || (n = d.a.j0.r.u.a.n(this.f50266b, iArr)) == null) {
            return;
        }
        this.f50266b = n;
        this.f50265a.setBackgroundDrawable(n);
    }

    public c m(int i2) {
        View view = this.f50265a;
        if (view == null) {
            return this;
        }
        view.setLayerType(i2, null);
        return this;
    }

    public c n(int i2) {
        View view = this.f50265a;
        if (view instanceof TextView) {
            ((TextView) view).setLinkTextColor(d.a.j0.r.u.a.g(i2));
            return this;
        }
        return this;
    }

    public void o(int i2) {
        Drawable r;
        if (this.f50265a == null || (r = d.a.j0.r.u.a.r(this.f50266b, d.a.j0.r.u.a.A(i2))) == null) {
            return;
        }
        this.f50266b = r;
        this.f50265a.setBackgroundDrawable(r);
    }

    public c p(int i2) {
        Drawable w;
        View view = this.f50265a;
        if (view == null || (w = d.a.j0.r.u.a.w(view, this.f50266b, d.a.j0.r.u.a.A(i2))) == null) {
            return this;
        }
        this.f50266b = w;
        this.f50265a.setBackgroundDrawable(w);
        m(1);
        return this;
    }

    public c q(int i2) {
        View view = this.f50265a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.j0.r.u.a.g(i2));
            return this;
        }
        return this;
    }

    public c r(int i2) {
        View view = this.f50265a;
        if (view instanceof EMTextView) {
            ((EMTextView) view).setLineSpacing(d.a.j0.r.u.a.l(i2), ((EMTextView) this.f50265a).getLineSpacingMultiplier());
            return this;
        }
        throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
    }

    public c s(int i2) {
        View view = this.f50265a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(d.a.j0.r.u.a.B(i2));
            return this;
        }
        return this;
    }

    public c t(int i2) {
        if (this.f50265a instanceof TextView) {
            float[] x = d.a.j0.r.u.a.x(i2);
            ((TextView) this.f50265a).setShadowLayer(x[1], x[2], x[3], (int) x[0]);
            return this;
        }
        return this;
    }

    public c u(int i2) {
        View view = this.f50265a;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, d.a.j0.r.u.a.l(i2));
            return this;
        }
        return this;
    }

    public c v(int i2) {
        View view = this.f50265a;
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(d.a.j0.r.u.a.C(d.a.j0.r.u.a.z(i2)));
            return this;
        }
        return this;
    }
}
