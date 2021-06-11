package d.a.l0.a.z1.b.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.swan.apps.res.widget.toast.ToastTemplate;
import d.a.l0.a.h;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
/* loaded from: classes3.dex */
public class e {
    public static final boolean u = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public Context f49876a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f49877b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f49878c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f49879d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f49880e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f49881f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f49882g;

    /* renamed from: i  reason: collision with root package name */
    public int f49884i;
    public c j;
    public b l;
    public boolean m;
    public View n;
    public CharSequence p;
    public CharSequence q;
    public int k = 2;
    public ToastRightAreaStyle o = ToastRightAreaStyle.JUMP;
    public ToastLocation r = ToastLocation.MIDDLE;
    public ToastTemplate s = ToastTemplate.T1;
    public boolean t = false;

    /* renamed from: h  reason: collision with root package name */
    public int f49883h = 2;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49885a;

        static {
            int[] iArr = new int[ToastTemplate.values().length];
            f49885a = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49885a[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49885a[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49885a[ToastTemplate.T4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    public e(Context context) {
        this.f49876a = context;
    }

    public static void a() {
        d.a.l0.a.z1.b.f.a.d();
        f.h();
    }

    public static int c(@NonNull Context context) {
        return n0.u() + ((int) context.getResources().getDimension(d.a.l0.a.d.aiapps_normal_base_action_bar_height));
    }

    public static boolean d() {
        return d.a.l0.a.z1.b.f.a.e() || f.k();
    }

    public static e e(@NonNull Context context) {
        return new e(context);
    }

    public static e f(@NonNull Context context, @StringRes int i2) {
        e eVar = new e(context);
        eVar.f49877b = context.getText(i2);
        return eVar;
    }

    public static e g(@NonNull Context context, @NonNull CharSequence charSequence) {
        e eVar = new e(context);
        eVar.f49877b = charSequence;
        return eVar;
    }

    public void A() {
        B(false);
    }

    public void B(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f49876a;
                if (context instanceof Activity) {
                    f.n((Activity) context, this.f49877b, this.f49880e, this.n, this.f49883h, this.m);
                    return;
                }
            }
            d.a.l0.a.z1.b.f.a.j(this.f49876a, this.f49877b, this.f49880e, this.n, this.f49883h, this.m);
        }
    }

    @Deprecated
    public void C() {
        D(false);
    }

    @Deprecated
    public void D(boolean z) {
        if (b()) {
            a();
            if (z) {
                x(this.f49876a, this.f49878c);
            } else if (this.f49876a instanceof Activity) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (1 == this.k) {
                    this.o = ToastRightAreaStyle.JUMP;
                } else {
                    this.o = ToastRightAreaStyle.BUTTON;
                }
                if (TextUtils.isEmpty(this.f49879d)) {
                    f.o((Activity) this.f49876a, null, null, null, this.f49877b, null, this.f49883h, this.r, this.j, this.m);
                    return;
                }
                CharSequence charSequence = this.f49878c;
                CharSequence charSequence2 = this.f49877b;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f49877b)) {
                    charSequence = this.f49877b;
                    charSequence2 = "";
                }
                f.p((Activity) this.f49876a, this.f49882g, null, null, charSequence, charSequence2, this.f49879d, this.o, this.f49883h, false, this.j);
            } else {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    d.a.l0.a.z1.b.f.a.f(bVar2);
                    this.l = null;
                }
                x(this.f49876a, this.f49878c);
            }
        }
    }

    public void E() {
        if (b()) {
            a();
            d.a.l0.a.z1.b.f.a.h(this.f49876a, this.f49877b, this.f49883h, false, this.f49884i, this.m);
        }
    }

    public void F() {
        G(false);
    }

    public void G(boolean z) {
        if (b()) {
            a();
            if (!z && (this.f49876a instanceof Activity)) {
                if (u) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("给View set 的mOnDismissListener是不是空?");
                    sb.append(this.l == null);
                    Log.w("UniversalToast", sb.toString());
                }
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                f.o((Activity) this.f49876a, null, null, null, this.f49877b, null, this.f49883h, this.r, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                d.a.l0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f49876a, this.f49877b);
        }
    }

    public void H() {
        I(false);
    }

    public void I(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f49876a;
                if (context instanceof Activity) {
                    f.o((Activity) context, null, null, null, this.f49877b, null, this.f49883h, ToastLocation.BOTTOM, this.j, this.m);
                    return;
                }
            }
            x(this.f49876a, this.f49877b);
        }
    }

    public final boolean b() {
        if (this.f49876a == null) {
            if (u) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.f49877b == null) {
            if (u) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    @Deprecated
    public e h(int i2) {
        return this;
    }

    public e i(int i2) {
        return this;
    }

    @Deprecated
    public e j(int i2) {
        this.k = i2;
        return this;
    }

    public e k(@NonNull CharSequence charSequence) {
        this.f49879d = charSequence;
        return this;
    }

    public e l(int i2) {
        this.f49883h = Math.max(i2, 1);
        return this;
    }

    public e m(@DrawableRes int i2) {
        Context context = this.f49876a;
        if (context != null && context.getResources() != null) {
            this.f49880e = this.f49876a.getResources().getDrawable(i2);
        }
        return this;
    }

    public e n(@NonNull Drawable drawable) {
        this.f49880e = drawable;
        return this;
    }

    public e o(@NonNull Uri uri) {
        this.f49882g = uri;
        return this;
    }

    public e p(@NonNull int i2) {
        this.f49884i = i2;
        return this;
    }

    public e q(@NonNull CharSequence charSequence) {
        this.f49877b = charSequence;
        return this;
    }

    public e r(boolean z) {
        this.m = z;
        return this;
    }

    public e s(@NonNull CharSequence charSequence) {
        this.f49878c = charSequence;
        return this;
    }

    public e t(c cVar) {
        this.j = cVar;
        return this;
    }

    public void u() {
        if (this.f49876a != null && (!TextUtils.isEmpty(this.f49877b) || !TextUtils.isEmpty(this.f49878c))) {
            a();
            if (this.f49876a instanceof Activity) {
                int i2 = a.f49885a[this.s.ordinal()];
                if (i2 == 2) {
                    if (TextUtils.isEmpty(this.f49877b)) {
                        return;
                    }
                    f.o((Activity) this.f49876a, this.f49882g, this.f49881f, this.n, this.f49877b, this.q, this.f49883h, this.r, this.j, this.m);
                    return;
                } else if (i2 == 3) {
                    if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.f49877b)) {
                        f.o((Activity) this.f49876a, this.f49882g, this.f49881f, this.n, this.f49877b, this.q, this.f49883h, this.r, this.j, this.m);
                        return;
                    } else if (TextUtils.isEmpty(this.f49878c)) {
                        return;
                    } else {
                        f.p((Activity) this.f49876a, this.f49882g, this.f49881f, this.n, this.f49878c, this.p, this.q, this.o, this.f49883h, this.t, this.j);
                        return;
                    }
                } else if (i2 != 4) {
                    if (TextUtils.isEmpty(this.f49877b)) {
                        return;
                    }
                    f.o((Activity) this.f49876a, null, null, null, this.f49877b, null, this.f49883h, this.r, null, this.m);
                    return;
                } else if (TextUtils.isEmpty(this.f49877b)) {
                    return;
                } else {
                    f.n((Activity) this.f49876a, this.f49877b, this.f49880e, this.n, this.f49883h, this.m);
                    return;
                }
            } else if (a.f49885a[this.s.ordinal()] != 4) {
                x(this.f49876a, TextUtils.isEmpty(this.f49877b) ? this.f49878c : this.f49877b);
                return;
            } else if (TextUtils.isEmpty(this.f49877b)) {
                return;
            } else {
                d.a.l0.a.z1.b.f.a.j(this.f49876a, this.f49877b, this.f49880e, this.n, this.f49883h, this.m);
                return;
            }
        }
        d.h("has no mToastText or mTitleText");
    }

    @Deprecated
    public void v() {
        w(false, false);
    }

    @Deprecated
    public void w(boolean z, boolean z2) {
        if (b()) {
            a();
            if (!z && (this.f49876a instanceof Activity)) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (TextUtils.isEmpty(this.f49879d)) {
                    this.f49879d = d.a.l0.a.c1.a.b().getResources().getText(h.aiapps_check_action_text);
                }
                f.o((Activity) this.f49876a, null, null, null, this.f49877b, this.f49879d, this.f49883h, ToastLocation.BOTTOM, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                d.a.l0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f49876a, this.f49877b);
        }
    }

    public final void x(Context context, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        d.a.l0.a.z1.b.f.a.k(context, null, null, null, charSequence, null, this.f49883h, this.r, null, this.m);
    }

    public void y() {
        z(false);
    }

    public void z(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f49876a;
                if (context instanceof Activity) {
                    f.m((Activity) context, this.f49877b, this.f49883h, this.m);
                    return;
                }
            }
            d.a.l0.a.z1.b.f.a.i(this.f49876a, this.f49877b, this.f49883h, this.m);
        }
    }
}
