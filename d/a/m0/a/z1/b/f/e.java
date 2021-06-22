package d.a.m0.a.z1.b.f;

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
import d.a.m0.a.h;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
/* loaded from: classes3.dex */
public class e {
    public static final boolean u = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public Context f49984a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f49985b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f49986c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f49987d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f49988e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f49989f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f49990g;

    /* renamed from: i  reason: collision with root package name */
    public int f49992i;
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
    public int f49991h = 2;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49993a;

        static {
            int[] iArr = new int[ToastTemplate.values().length];
            f49993a = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49993a[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49993a[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49993a[ToastTemplate.T4.ordinal()] = 4;
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
        this.f49984a = context;
    }

    public static void a() {
        d.a.m0.a.z1.b.f.a.d();
        f.h();
    }

    public static int c(@NonNull Context context) {
        return n0.u() + ((int) context.getResources().getDimension(d.a.m0.a.d.aiapps_normal_base_action_bar_height));
    }

    public static boolean d() {
        return d.a.m0.a.z1.b.f.a.e() || f.k();
    }

    public static e e(@NonNull Context context) {
        return new e(context);
    }

    public static e f(@NonNull Context context, @StringRes int i2) {
        e eVar = new e(context);
        eVar.f49985b = context.getText(i2);
        return eVar;
    }

    public static e g(@NonNull Context context, @NonNull CharSequence charSequence) {
        e eVar = new e(context);
        eVar.f49985b = charSequence;
        return eVar;
    }

    public void A() {
        B(false);
    }

    public void B(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f49984a;
                if (context instanceof Activity) {
                    f.n((Activity) context, this.f49985b, this.f49988e, this.n, this.f49991h, this.m);
                    return;
                }
            }
            d.a.m0.a.z1.b.f.a.j(this.f49984a, this.f49985b, this.f49988e, this.n, this.f49991h, this.m);
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
                x(this.f49984a, this.f49986c);
            } else if (this.f49984a instanceof Activity) {
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
                if (TextUtils.isEmpty(this.f49987d)) {
                    f.o((Activity) this.f49984a, null, null, null, this.f49985b, null, this.f49991h, this.r, this.j, this.m);
                    return;
                }
                CharSequence charSequence = this.f49986c;
                CharSequence charSequence2 = this.f49985b;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.f49985b)) {
                    charSequence = this.f49985b;
                    charSequence2 = "";
                }
                f.p((Activity) this.f49984a, this.f49990g, null, null, charSequence, charSequence2, this.f49987d, this.o, this.f49991h, false, this.j);
            } else {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    d.a.m0.a.z1.b.f.a.f(bVar2);
                    this.l = null;
                }
                x(this.f49984a, this.f49986c);
            }
        }
    }

    public void E() {
        if (b()) {
            a();
            d.a.m0.a.z1.b.f.a.h(this.f49984a, this.f49985b, this.f49991h, false, this.f49992i, this.m);
        }
    }

    public void F() {
        G(false);
    }

    public void G(boolean z) {
        if (b()) {
            a();
            if (!z && (this.f49984a instanceof Activity)) {
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
                f.o((Activity) this.f49984a, null, null, null, this.f49985b, null, this.f49991h, this.r, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                d.a.m0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f49984a, this.f49985b);
        }
    }

    public void H() {
        I(false);
    }

    public void I(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f49984a;
                if (context instanceof Activity) {
                    f.o((Activity) context, null, null, null, this.f49985b, null, this.f49991h, ToastLocation.BOTTOM, this.j, this.m);
                    return;
                }
            }
            x(this.f49984a, this.f49985b);
        }
    }

    public final boolean b() {
        if (this.f49984a == null) {
            if (u) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.f49985b == null) {
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
        this.f49987d = charSequence;
        return this;
    }

    public e l(int i2) {
        this.f49991h = Math.max(i2, 1);
        return this;
    }

    public e m(@DrawableRes int i2) {
        Context context = this.f49984a;
        if (context != null && context.getResources() != null) {
            this.f49988e = this.f49984a.getResources().getDrawable(i2);
        }
        return this;
    }

    public e n(@NonNull Drawable drawable) {
        this.f49988e = drawable;
        return this;
    }

    public e o(@NonNull Uri uri) {
        this.f49990g = uri;
        return this;
    }

    public e p(@NonNull int i2) {
        this.f49992i = i2;
        return this;
    }

    public e q(@NonNull CharSequence charSequence) {
        this.f49985b = charSequence;
        return this;
    }

    public e r(boolean z) {
        this.m = z;
        return this;
    }

    public e s(@NonNull CharSequence charSequence) {
        this.f49986c = charSequence;
        return this;
    }

    public e t(c cVar) {
        this.j = cVar;
        return this;
    }

    public void u() {
        if (this.f49984a != null && (!TextUtils.isEmpty(this.f49985b) || !TextUtils.isEmpty(this.f49986c))) {
            a();
            if (this.f49984a instanceof Activity) {
                int i2 = a.f49993a[this.s.ordinal()];
                if (i2 == 2) {
                    if (TextUtils.isEmpty(this.f49985b)) {
                        return;
                    }
                    f.o((Activity) this.f49984a, this.f49990g, this.f49989f, this.n, this.f49985b, this.q, this.f49991h, this.r, this.j, this.m);
                    return;
                } else if (i2 == 3) {
                    if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.f49985b)) {
                        f.o((Activity) this.f49984a, this.f49990g, this.f49989f, this.n, this.f49985b, this.q, this.f49991h, this.r, this.j, this.m);
                        return;
                    } else if (TextUtils.isEmpty(this.f49986c)) {
                        return;
                    } else {
                        f.p((Activity) this.f49984a, this.f49990g, this.f49989f, this.n, this.f49986c, this.p, this.q, this.o, this.f49991h, this.t, this.j);
                        return;
                    }
                } else if (i2 != 4) {
                    if (TextUtils.isEmpty(this.f49985b)) {
                        return;
                    }
                    f.o((Activity) this.f49984a, null, null, null, this.f49985b, null, this.f49991h, this.r, null, this.m);
                    return;
                } else if (TextUtils.isEmpty(this.f49985b)) {
                    return;
                } else {
                    f.n((Activity) this.f49984a, this.f49985b, this.f49988e, this.n, this.f49991h, this.m);
                    return;
                }
            } else if (a.f49993a[this.s.ordinal()] != 4) {
                x(this.f49984a, TextUtils.isEmpty(this.f49985b) ? this.f49986c : this.f49985b);
                return;
            } else if (TextUtils.isEmpty(this.f49985b)) {
                return;
            } else {
                d.a.m0.a.z1.b.f.a.j(this.f49984a, this.f49985b, this.f49988e, this.n, this.f49991h, this.m);
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
            if (!z && (this.f49984a instanceof Activity)) {
                b bVar = this.l;
                if (bVar != null) {
                    f.l(bVar);
                    this.l = null;
                }
                if (TextUtils.isEmpty(this.f49987d)) {
                    this.f49987d = d.a.m0.a.c1.a.b().getResources().getText(h.aiapps_check_action_text);
                }
                f.o((Activity) this.f49984a, null, null, null, this.f49985b, this.f49987d, this.f49991h, ToastLocation.BOTTOM, this.j, this.m);
                return;
            }
            b bVar2 = this.l;
            if (bVar2 != null) {
                d.a.m0.a.z1.b.f.a.f(bVar2);
                this.l = null;
            }
            x(this.f49984a, this.f49985b);
        }
    }

    public final void x(Context context, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        d.a.m0.a.z1.b.f.a.k(context, null, null, null, charSequence, null, this.f49991h, this.r, null, this.m);
    }

    public void y() {
        z(false);
    }

    public void z(boolean z) {
        if (b()) {
            a();
            if (!z) {
                Context context = this.f49984a;
                if (context instanceof Activity) {
                    f.m((Activity) context, this.f49985b, this.f49991h, this.m);
                    return;
                }
            }
            d.a.m0.a.z1.b.f.a.i(this.f49984a, this.f49985b, this.f49991h, this.m);
        }
    }
}
