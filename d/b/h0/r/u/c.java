package d.b.h0.r.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public View f51055a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f51056b;

    public c(View view) {
        this.f51055a = view;
        this.f51056b = a.d(view);
    }

    public static c a(View view) {
        return new c(view);
    }

    public c b(int i) {
        if (this.f51055a == null) {
            return this;
        }
        this.f51056b = a.b(this.f51056b, i);
        return this;
    }

    public void c(int i) {
        Drawable h2;
        if (this.f51055a == null || (h2 = a.h(this.f51056b, i)) == null) {
            return;
        }
        this.f51056b = h2;
        this.f51055a.setBackgroundDrawable(h2);
    }

    public void d(int i, int i2) {
        if (this.f51055a == null) {
            return;
        }
        Drawable y = a.y(this.f51056b, i, i2);
        this.f51056b = y;
        this.f51055a.setBackgroundDrawable(y);
    }

    public c e(int i) {
        Drawable e2;
        if (this.f51055a == null || (e2 = a.e(this.f51056b, i)) == null) {
            return this;
        }
        this.f51056b = e2;
        this.f51055a.setBackgroundDrawable(e2);
        return this;
    }

    public c f(int i) {
        if (this.f51055a == null) {
            return this;
        }
        this.f51056b = a.f(this.f51056b, i);
        return this;
    }

    public c g(int i) {
        if (this.f51055a == null) {
            return this;
        }
        this.f51056b = a.k(this.f51056b, i);
        return this;
    }

    public c h(int i) {
        if (this.f51055a == null) {
            return this;
        }
        this.f51056b = a.j(this.f51056b, i);
        return this;
    }

    public void i(int[] iArr) {
        Drawable n;
        if (this.f51055a == null || (n = a.n(this.f51056b, iArr)) == null) {
            return;
        }
        this.f51056b = n;
        this.f51055a.setBackgroundDrawable(n);
    }

    public c j(int i) {
        View view = this.f51055a;
        if (view == null) {
            return this;
        }
        view.setLayerType(i, null);
        return this;
    }

    public c k(int i) {
        View view = this.f51055a;
        if (view instanceof TextView) {
            ((TextView) view).setLinkTextColor(a.g(i));
            return this;
        }
        return this;
    }

    public void l(int i) {
        Drawable r;
        if (this.f51055a == null || (r = a.r(this.f51056b, a.A(i))) == null) {
            return;
        }
        this.f51056b = r;
        this.f51055a.setBackgroundDrawable(r);
    }

    public c m(int i) {
        Drawable w;
        View view = this.f51055a;
        if (view == null || (w = a.w(view, this.f51056b, a.A(i))) == null) {
            return this;
        }
        this.f51056b = w;
        this.f51055a.setBackgroundDrawable(w);
        j(1);
        return this;
    }

    public c n(int i) {
        View view = this.f51055a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(a.g(i));
            return this;
        }
        return this;
    }

    public c o(int i) {
        View view = this.f51055a;
        if (view instanceof EMTextView) {
            ((EMTextView) view).setLineSpacing(a.l(i), ((EMTextView) this.f51055a).getLineSpacingMultiplier());
            return this;
        }
        throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
    }

    public c p(int i) {
        View view = this.f51055a;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(a.B(i));
            return this;
        }
        return this;
    }

    public c q(int i) {
        if (this.f51055a instanceof TextView) {
            float[] x = a.x(i);
            ((TextView) this.f51055a).setShadowLayer(x[1], x[2], x[3], (int) x[0]);
            return this;
        }
        return this;
    }

    public c r(int i) {
        View view = this.f51055a;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, a.l(i));
            return this;
        }
        return this;
    }

    public c s(int i) {
        View view = this.f51055a;
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(a.C(a.z(i)));
            return this;
        }
        return this;
    }
}
