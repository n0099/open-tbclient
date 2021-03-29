package d.b.g0.a.q1.b.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import d.b.g0.a.i2.h0;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class d {
    public static boolean o = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public Context f45668a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f45669b;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f45671d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f45672e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f45673f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f45674g;
    public int i;
    public a j;
    public boolean n;
    public int k = 2;
    public int l = 1;
    public int m = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f45675h = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f45670c = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public d(Context context) {
        this.f45668a = context;
    }

    public static void a() {
        d.b.g0.a.q1.b.f.a.d();
        e.h();
    }

    public static int c(Context context) {
        return h0.s() + ((int) context.getResources().getDimension(d.b.g0.a.d.aiapps_normal_base_action_bar_height));
    }

    public static d d(@NonNull Context context) {
        return new d(context);
    }

    public static d e(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.f45669b = context.getText(i);
        return dVar;
    }

    public static d f(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.f45669b = charSequence;
        return dVar;
    }

    public void A(boolean z) {
        if (b()) {
            a();
            if (z) {
                d.b.g0.a.q1.b.f.a.j(this.f45668a, this.f45674g, this.m, this.f45671d, this.f45669b, this.f45672e, this.k, this.f45675h, this.j);
                return;
            }
            Context context = this.f45668a;
            if (context instanceof Activity) {
                e.m((Activity) context, this.f45674g, this.m, this.f45671d, this.f45669b, this.f45672e, this.k, this.l, this.f45675h, this.j);
            } else {
                d.b.g0.a.q1.b.f.a.j(context, this.f45674g, this.m, this.f45671d, this.f45669b, this.f45672e, this.k, this.f45675h, this.j);
            }
        }
    }

    public void B() {
        if (b()) {
            a();
            d.b.g0.a.q1.b.f.a.f(this.f45668a, this.f45669b, this.f45675h, false, this.i, this.n);
        }
    }

    public void C() {
        D(false);
    }

    public void D(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f45668a;
                if (context instanceof Activity) {
                    e.n((Activity) context, this.f45669b, this.f45675h, this.i, this.n);
                    return;
                }
            }
            d.b.g0.a.q1.b.f.a.f(this.f45668a, this.f45669b, this.f45675h, true, this.i, this.n);
        }
    }

    public void E() {
        F(false);
    }

    public void F(boolean z) {
        if (b()) {
            a();
            if (z) {
                d.b.g0.a.q1.b.f.a.k(this.f45668a, this.f45669b, this.f45675h);
                return;
            }
            Context context = this.f45668a;
            if (context instanceof Activity) {
                e.o((Activity) context, this.f45669b, this.f45675h);
            } else {
                d.b.g0.a.q1.b.f.a.k(context, this.f45669b, this.f45675h);
            }
        }
    }

    public final boolean b() {
        if (this.f45668a == null) {
            if (o) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.f45669b == null) {
            if (o) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public d g(int i) {
        this.m = i;
        return this;
    }

    public d h(int i) {
        this.l = i;
        return this;
    }

    public d i(int i) {
        this.k = i;
        return this;
    }

    public d j(@NonNull CharSequence charSequence) {
        this.f45672e = charSequence;
        return this;
    }

    public d k(int i) {
        if (i >= 1 && i <= 10) {
            this.f45675h = i;
        } else {
            this.f45675h = 2;
        }
        return this;
    }

    public d l(@DrawableRes int i) {
        Context context = this.f45668a;
        if (context != null && context.getResources() != null) {
            this.f45673f = this.f45668a.getResources().getDrawable(i);
        }
        return this;
    }

    public d m(@NonNull Drawable drawable) {
        this.f45673f = drawable;
        return this;
    }

    public d n(@NonNull Uri uri) {
        this.f45674g = uri;
        return this;
    }

    public d o(@NonNull int i) {
        this.i = i;
        return this;
    }

    public d p(@NonNull CharSequence charSequence) {
        this.f45669b = charSequence;
        return this;
    }

    public d q(boolean z) {
        this.n = z;
        return this;
    }

    public d r(@NonNull CharSequence charSequence) {
        this.f45671d = charSequence;
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
                Context context = this.f45668a;
                if (context instanceof Activity) {
                    e.j((Activity) context, this.f45669b, this.f45670c, this.f45672e, this.f45675h, this.j);
                    return;
                }
            }
            d.b.g0.a.q1.b.f.a.g(this.f45668a, this.f45669b, this.f45670c, this.f45672e, this.f45675h, this.j);
        }
    }

    public void v() {
        w(false);
    }

    public void w(boolean z) {
        if (b()) {
            a();
            if (z) {
                d.b.g0.a.q1.b.f.a.h(this.f45668a, this.f45669b, this.f45675h, this.n);
                return;
            }
            Context context = this.f45668a;
            if (context instanceof Activity) {
                e.k((Activity) context, this.f45669b, this.f45675h, this.n);
            } else {
                d.b.g0.a.q1.b.f.a.h(context, this.f45669b, this.f45675h, this.n);
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
                d.b.g0.a.q1.b.f.a.i(this.f45668a, this.f45669b, this.f45673f, this.f45675h, this.n);
                return;
            }
            Context context = this.f45668a;
            if (context instanceof Activity) {
                e.l((Activity) context, this.f45669b, this.f45673f, this.f45675h, this.n);
            } else {
                d.b.g0.a.q1.b.f.a.i(context, this.f45669b, this.f45673f, this.f45675h, this.n);
            }
        }
    }

    public void z() {
        A(false);
    }
}
