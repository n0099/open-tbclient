package d.a.h0.a.q1.b.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import d.a.h0.a.i2.h0;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class d {
    public static boolean o = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public Context f43747a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f43748b;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f43750d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f43751e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f43752f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f43753g;

    /* renamed from: i  reason: collision with root package name */
    public int f43755i;
    public a j;
    public boolean n;
    public int k = 2;
    public int l = 1;
    public int m = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f43754h = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f43749c = 14;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public d(Context context) {
        this.f43747a = context;
    }

    public static void a() {
        d.a.h0.a.q1.b.f.a.d();
        e.h();
    }

    public static int c(Context context) {
        return h0.s() + ((int) context.getResources().getDimension(d.a.h0.a.d.aiapps_normal_base_action_bar_height));
    }

    public static d d(@NonNull Context context) {
        return new d(context);
    }

    public static d e(@NonNull Context context, @StringRes int i2) {
        d dVar = new d(context);
        dVar.f43748b = context.getText(i2);
        return dVar;
    }

    public static d f(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.f43748b = charSequence;
        return dVar;
    }

    public void A(boolean z) {
        if (b()) {
            a();
            if (z) {
                d.a.h0.a.q1.b.f.a.j(this.f43747a, this.f43753g, this.m, this.f43750d, this.f43748b, this.f43751e, this.k, this.f43754h, this.j);
                return;
            }
            Context context = this.f43747a;
            if (context instanceof Activity) {
                e.m((Activity) context, this.f43753g, this.m, this.f43750d, this.f43748b, this.f43751e, this.k, this.l, this.f43754h, this.j);
            } else {
                d.a.h0.a.q1.b.f.a.j(context, this.f43753g, this.m, this.f43750d, this.f43748b, this.f43751e, this.k, this.f43754h, this.j);
            }
        }
    }

    public void B() {
        if (b()) {
            a();
            d.a.h0.a.q1.b.f.a.f(this.f43747a, this.f43748b, this.f43754h, false, this.f43755i, this.n);
        }
    }

    public void C() {
        D(false);
    }

    public void D(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f43747a;
                if (context instanceof Activity) {
                    e.n((Activity) context, this.f43748b, this.f43754h, this.f43755i, this.n);
                    return;
                }
            }
            d.a.h0.a.q1.b.f.a.f(this.f43747a, this.f43748b, this.f43754h, true, this.f43755i, this.n);
        }
    }

    public void E() {
        F(false);
    }

    public void F(boolean z) {
        if (b()) {
            a();
            if (z) {
                d.a.h0.a.q1.b.f.a.k(this.f43747a, this.f43748b, this.f43754h);
                return;
            }
            Context context = this.f43747a;
            if (context instanceof Activity) {
                e.o((Activity) context, this.f43748b, this.f43754h);
            } else {
                d.a.h0.a.q1.b.f.a.k(context, this.f43748b, this.f43754h);
            }
        }
    }

    public final boolean b() {
        if (this.f43747a == null) {
            if (o) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.f43748b == null) {
            if (o) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public d g(int i2) {
        this.m = i2;
        return this;
    }

    public d h(int i2) {
        this.l = i2;
        return this;
    }

    public d i(int i2) {
        this.k = i2;
        return this;
    }

    public d j(@NonNull CharSequence charSequence) {
        this.f43751e = charSequence;
        return this;
    }

    public d k(int i2) {
        if (i2 >= 1 && i2 <= 10) {
            this.f43754h = i2;
        } else {
            this.f43754h = 2;
        }
        return this;
    }

    public d l(@DrawableRes int i2) {
        Context context = this.f43747a;
        if (context != null && context.getResources() != null) {
            this.f43752f = this.f43747a.getResources().getDrawable(i2);
        }
        return this;
    }

    public d m(@NonNull Drawable drawable) {
        this.f43752f = drawable;
        return this;
    }

    public d n(@NonNull Uri uri) {
        this.f43753g = uri;
        return this;
    }

    public d o(@NonNull int i2) {
        this.f43755i = i2;
        return this;
    }

    public d p(@NonNull CharSequence charSequence) {
        this.f43748b = charSequence;
        return this;
    }

    public d q(boolean z) {
        this.n = z;
        return this;
    }

    public d r(@NonNull CharSequence charSequence) {
        this.f43750d = charSequence;
        return this;
    }

    public d s(a aVar) {
        this.j = aVar;
        return this;
    }

    public void t() {
        u(false);
    }

    public void u(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f43747a;
                if (context instanceof Activity) {
                    e.j((Activity) context, this.f43748b, this.f43749c, this.f43751e, this.f43754h, this.j);
                    return;
                }
            }
            d.a.h0.a.q1.b.f.a.g(this.f43747a, this.f43748b, this.f43749c, this.f43751e, this.f43754h, this.j);
        }
    }

    public void v() {
        w(false);
    }

    public void w(boolean z) {
        if (b()) {
            a();
            if (z) {
                d.a.h0.a.q1.b.f.a.h(this.f43747a, this.f43748b, this.f43754h, this.n);
                return;
            }
            Context context = this.f43747a;
            if (context instanceof Activity) {
                e.k((Activity) context, this.f43748b, this.f43754h, this.n);
            } else {
                d.a.h0.a.q1.b.f.a.h(context, this.f43748b, this.f43754h, this.n);
            }
        }
    }

    public void x() {
        y(false);
    }

    public void y(boolean z) {
        if (b()) {
            a();
            if (z) {
                d.a.h0.a.q1.b.f.a.i(this.f43747a, this.f43748b, this.f43752f, this.f43754h, this.n);
                return;
            }
            Context context = this.f43747a;
            if (context instanceof Activity) {
                e.l((Activity) context, this.f43748b, this.f43752f, this.f43754h, this.n);
            } else {
                d.a.h0.a.q1.b.f.a.i(context, this.f43748b, this.f43752f, this.f43754h, this.n);
            }
        }
    }

    public void z() {
        A(false);
    }
}
