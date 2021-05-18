package i.a.a.e.h.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.google.protobuf.CodedInputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
@TargetApi(19)
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, i.a.a.e.h.a.b> f68765a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, i.a.a.e.h.a.b> f68766b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ArrayList<String>> f68767c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Activity f68768d;

    /* renamed from: e  reason: collision with root package name */
    public Window f68769e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f68770f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f68771g;

    /* renamed from: h  reason: collision with root package name */
    public Dialog f68772h;

    /* renamed from: i  reason: collision with root package name */
    public i.a.a.e.h.a.b f68773i;
    public i.a.a.e.h.a.a j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes8.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            if (Settings.System.getInt(d.this.f68768d.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                d.this.f68773i.t.setVisibility(8);
                d.this.f68771g.setPadding(0, d.this.f68771g.getPaddingTop(), 0, 0);
                return;
            }
            d.this.f68773i.t.setVisibility(0);
            if (!d.this.f68773i.B) {
                if (d.this.j.l()) {
                    d.this.f68771g.setPadding(0, d.this.f68771g.getPaddingTop(), 0, d.this.j.d());
                    return;
                } else {
                    d.this.f68771g.setPadding(0, d.this.f68771g.getPaddingTop(), d.this.j.f(), 0);
                    return;
                }
            }
            d.this.f68771g.setPadding(0, d.this.f68771g.getPaddingTop(), 0, 0);
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68775a;

        static {
            int[] iArr = new int[BarHide.values().length];
            f68775a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68775a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68775a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68775a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d(Activity activity) {
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.f68768d = activity2;
        this.f68769e = activity2.getWindow();
        String name = activity.getClass().getName();
        this.k = name;
        this.m = name;
        m();
    }

    public static d H(Activity activity) {
        return new d(activity);
    }

    public static boolean n(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean o() {
        return f.m() || f.k() || Build.VERSION.SDK_INT >= 23;
    }

    public d A(@ColorInt int i2) {
        this.f68773i.f68756e = i2;
        return this;
    }

    public d B(boolean z) {
        C(z, 0.0f);
        return this;
    }

    public d C(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        i.a.a.e.h.a.b bVar = this.f68773i;
        bVar.l = z;
        if (!z) {
            bVar.v = 0;
        }
        if (o()) {
            this.f68773i.f68758g = 0.0f;
        } else {
            this.f68773i.f68758g = f2;
        }
        return this;
    }

    public final void D() {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT < 21 || f.i() || (viewGroup = this.f68771g) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f68771g.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                this.f68773i.B = childAt.getFitsSystemWindows();
                if (this.f68773i.B) {
                    this.f68771g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
        }
        i.a.a.e.h.a.b bVar = this.f68773i;
        if (bVar.w) {
            this.f68771g.setPadding(0, this.j.i() + this.j.a(), 0, 0);
        } else if (bVar.r) {
            this.f68771g.setPadding(0, this.j.i(), 0, 0);
        } else {
            this.f68771g.setPadding(0, 0, 0, 0);
        }
    }

    public final void E() {
        if (this.f68773i.p.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.f68773i.p.entrySet()) {
                View key = entry.getKey();
                Integer valueOf = Integer.valueOf(this.f68773i.f68756e);
                Integer valueOf2 = Integer.valueOf(this.f68773i.n);
                for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.f68773i.q - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f68773i.f68758g));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.f68773i.q));
                    }
                }
            }
        }
    }

    public d F() {
        this.f68773i.f68756e = 0;
        return this;
    }

    public final void G() {
        if ((f.i() || f.h()) && this.j.k()) {
            i.a.a.e.h.a.b bVar = this.f68773i;
            if (!bVar.z || !bVar.A || bVar.E == null || bVar.t == null) {
                return;
            }
            this.f68768d.getContentResolver().unregisterContentObserver(this.f68773i.E);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public i.a.a.e.h.a.b clone() {
        return this.f68773i;
    }

    public void f() {
        G();
        i.a.a.e.h.a.b bVar = this.f68773i;
        e eVar = bVar.C;
        if (eVar != null) {
            eVar.o(bVar.y);
            this.f68773i.C = null;
        }
        if (this.f68770f != null) {
            this.f68770f = null;
        }
        if (this.f68771g != null) {
            this.f68771g = null;
        }
        if (this.j != null) {
            this.j = null;
        }
        if (this.f68769e != null) {
            this.f68769e = null;
        }
        if (this.f68772h != null) {
            this.f68772h = null;
        }
        if (this.f68768d != null) {
            this.f68768d = null;
        }
        if (n(this.m)) {
            return;
        }
        if (this.f68773i != null) {
            this.f68773i = null;
        }
        ArrayList<String> arrayList = this.f68767c.get(this.k);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f68766b.remove(it.next());
            }
            this.f68767c.remove(this.k);
        }
        this.f68765a.remove(this.m);
    }

    public d g(boolean z) {
        this.f68773i.r = z;
        return this;
    }

    public final int h(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i3 = b.f68775a[this.f68773i.k.ordinal()];
            if (i3 == 1) {
                i2 |= UIMsg.m_AppUI.MSG_COMPASS_DISPLAY;
            } else if (i3 == 2) {
                i2 |= SDKLogTypeConstants.EXPTYPE_LITEINC_INSTALL;
            } else if (i3 == 3) {
                i2 |= 514;
            } else if (i3 == 4) {
                i2 |= 0;
            }
        }
        return i2 | 4096;
    }

    public d i() {
        this.f68765a.put(this.m, this.f68773i);
        j();
        v();
        E();
        p();
        r();
        return this;
    }

    public final void j() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            int i3 = 256;
            if (i2 >= 21 && !f.i()) {
                i3 = u(k(256));
                D();
            } else {
                l();
                y();
            }
            this.f68769e.getDecorView().setSystemUiVisibility(h(i3));
        }
        if (f.m()) {
            s(this.f68769e, this.f68773i.l);
        } else if (f.k()) {
            i.a.a.e.h.a.b bVar = this.f68773i;
            int i4 = bVar.v;
            if (i4 != 0) {
                c.d(this.f68768d, i4);
            } else if (Build.VERSION.SDK_INT < 23) {
                c.e(this.f68768d, bVar.l);
            }
        } else if (f.n()) {
            t(this.f68773i.l);
        }
    }

    @RequiresApi(api = 21)
    public final int k(int i2) {
        int i3 = i2 | 1024;
        i.a.a.e.h.a.b bVar = this.f68773i;
        if (bVar.f68760i && bVar.z) {
            i3 |= 512;
        }
        this.f68769e.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        if (this.j.k()) {
            this.f68769e.clearFlags(134217728);
        }
        this.f68769e.addFlags(Integer.MIN_VALUE);
        i.a.a.e.h.a.b bVar2 = this.f68773i;
        if (bVar2.m) {
            this.f68769e.setStatusBarColor(ColorUtils.blendARGB(bVar2.f68756e, bVar2.n, bVar2.f68758g));
        } else {
            this.f68769e.setStatusBarColor(ColorUtils.blendARGB(bVar2.f68756e, 0, bVar2.f68758g));
        }
        i.a.a.e.h.a.b bVar3 = this.f68773i;
        if (bVar3.z) {
            this.f68769e.setNavigationBarColor(ColorUtils.blendARGB(bVar3.f68757f, bVar3.o, bVar3.f68759h));
        }
        return i3;
    }

    public final void l() {
        this.f68769e.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        x();
        if (this.j.k()) {
            i.a.a.e.h.a.b bVar = this.f68773i;
            if (bVar.z && bVar.A) {
                this.f68769e.addFlags(134217728);
            } else {
                this.f68769e.clearFlags(134217728);
            }
            w();
        }
    }

    public final void m() {
        ViewGroup viewGroup = (ViewGroup) this.f68769e.getDecorView();
        this.f68770f = viewGroup;
        this.f68771g = (ViewGroup) viewGroup.findViewById(16908290);
        this.j = new i.a.a.e.h.a.a(this.f68768d);
        if (this.f68765a.get(this.m) == null) {
            this.f68773i = new i.a.a.e.h.a.b();
            if (!n(this.l)) {
                if (this.f68765a.get(this.k) != null) {
                    if (Build.VERSION.SDK_INT == 19 || f.i()) {
                        this.f68773i.s = this.f68765a.get(this.k).s;
                        this.f68773i.t = this.f68765a.get(this.k).t;
                    }
                    this.f68773i.C = this.f68765a.get(this.k).C;
                } else {
                    throw new IllegalArgumentException("在Fragment里使用时，请先在加载Fragment的Activity里初始化！！！");
                }
            }
            this.f68765a.put(this.m, this.f68773i);
            return;
        }
        this.f68773i = this.f68765a.get(this.m);
    }

    public final void p() {
        if (Build.VERSION.SDK_INT >= 19) {
            i.a.a.e.h.a.b bVar = this.f68773i;
            if (bVar.C == null) {
                bVar.C = e.q(this.f68768d, this.f68769e);
            }
            i.a.a.e.h.a.b bVar2 = this.f68773i;
            bVar2.C.r(bVar2);
            i.a.a.e.h.a.b bVar3 = this.f68773i;
            if (bVar3.x) {
                bVar3.C.p(bVar3.y);
            } else {
                bVar3.C.o(bVar3.y);
            }
        }
    }

    public d q(boolean z) {
        this.f68773i.z = z;
        return this;
    }

    public final void r() {
        if ((f.i() || f.h()) && this.j.k()) {
            i.a.a.e.h.a.b bVar = this.f68773i;
            if (bVar.z && bVar.A) {
                if (bVar.E == null && bVar.t != null) {
                    bVar.E = new a(new Handler());
                }
                this.f68768d.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.f68773i.E);
            }
        }
    }

    public final void s(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i2));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void t(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f68769e.addFlags(Integer.MIN_VALUE);
        }
        int systemUiVisibility = this.f68769e.getDecorView().getSystemUiVisibility();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
        } else if (i2 >= 19) {
            systemUiVisibility = z ? systemUiVisibility | 16 : systemUiVisibility & (-17);
        }
        this.f68769e.getDecorView().setSystemUiVisibility(systemUiVisibility);
    }

    public final int u(int i2) {
        return (Build.VERSION.SDK_INT < 23 || !this.f68773i.l) ? i2 : i2 | 8192;
    }

    public final void v() {
        View view;
        if (Build.VERSION.SDK_INT < 19 || (view = this.f68773i.u) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.j.i();
        this.f68773i.u.setLayoutParams(layoutParams);
    }

    public final void w() {
        FrameLayout.LayoutParams layoutParams;
        i.a.a.e.h.a.b bVar = this.f68773i;
        if (bVar.t == null) {
            bVar.t = new View(this.f68768d);
        }
        if (this.j.l()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.j.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.j.f(), -1);
            layoutParams.gravity = 8388613;
        }
        this.f68773i.t.setLayoutParams(layoutParams);
        i.a.a.e.h.a.b bVar2 = this.f68773i;
        if (bVar2.z && bVar2.A) {
            if (!bVar2.f68760i && bVar2.o == 0) {
                bVar2.t.setBackgroundColor(ColorUtils.blendARGB(bVar2.f68757f, -16777216, bVar2.f68759h));
            } else {
                i.a.a.e.h.a.b bVar3 = this.f68773i;
                bVar3.t.setBackgroundColor(ColorUtils.blendARGB(bVar3.f68757f, bVar3.o, bVar3.f68759h));
            }
        } else {
            this.f68773i.t.setBackgroundColor(0);
        }
        this.f68773i.t.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) this.f68773i.t.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f68773i.t);
        }
        this.f68770f.addView(this.f68773i.t);
    }

    public final void x() {
        i.a.a.e.h.a.b bVar = this.f68773i;
        if (bVar.s == null) {
            bVar.s = new View(this.f68768d);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.j.i());
        layoutParams.gravity = 48;
        this.f68773i.s.setLayoutParams(layoutParams);
        i.a.a.e.h.a.b bVar2 = this.f68773i;
        if (bVar2.m) {
            bVar2.s.setBackgroundColor(ColorUtils.blendARGB(bVar2.f68756e, bVar2.n, bVar2.f68758g));
        } else {
            bVar2.s.setBackgroundColor(ColorUtils.blendARGB(bVar2.f68756e, 0, bVar2.f68758g));
        }
        this.f68773i.s.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) this.f68773i.s.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f68773i.s);
        }
        this.f68770f.addView(this.f68773i.s);
    }

    public final void y() {
        int childCount = this.f68771g.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.f68771g.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                if (childAt instanceof DrawerLayout) {
                    View childAt2 = ((DrawerLayout) childAt).getChildAt(0);
                    if (childAt2 != null) {
                        this.f68773i.B = childAt2.getFitsSystemWindows();
                        if (this.f68773i.B) {
                            this.f68771g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else {
                        continue;
                    }
                } else {
                    this.f68773i.B = childAt.getFitsSystemWindows();
                    if (this.f68773i.B) {
                        this.f68771g.setPadding(0, 0, 0, 0);
                        return;
                    }
                }
            }
        }
        if (this.j.k()) {
            i.a.a.e.h.a.b bVar = this.f68773i;
            if (!bVar.j && !bVar.f68760i) {
                if (this.j.l()) {
                    i.a.a.e.h.a.b bVar2 = this.f68773i;
                    if (!bVar2.w) {
                        if (bVar2.z && bVar2.A) {
                            if (bVar2.r) {
                                this.f68771g.setPadding(0, this.j.i(), 0, this.j.d());
                                return;
                            } else {
                                this.f68771g.setPadding(0, 0, 0, this.j.d());
                                return;
                            }
                        } else if (this.f68773i.r) {
                            this.f68771g.setPadding(0, this.j.i(), 0, 0);
                            return;
                        } else {
                            this.f68771g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else if (bVar2.z && bVar2.A) {
                        this.f68771g.setPadding(0, this.j.i() + this.j.a() + 10, 0, this.j.d());
                        return;
                    } else {
                        this.f68771g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                        return;
                    }
                }
                i.a.a.e.h.a.b bVar3 = this.f68773i;
                if (!bVar3.w) {
                    if (bVar3.z && bVar3.A) {
                        if (bVar3.r) {
                            this.f68771g.setPadding(0, this.j.i(), this.j.f(), 0);
                            return;
                        } else {
                            this.f68771g.setPadding(0, 0, this.j.f(), 0);
                            return;
                        }
                    } else if (this.f68773i.r) {
                        this.f68771g.setPadding(0, this.j.i(), 0, 0);
                        return;
                    } else {
                        this.f68771g.setPadding(0, 0, 0, 0);
                        return;
                    }
                } else if (bVar3.z && bVar3.A) {
                    this.f68771g.setPadding(0, this.j.i() + this.j.a() + 10, this.j.f(), 0);
                    return;
                } else {
                    this.f68771g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                    return;
                }
            }
        }
        i.a.a.e.h.a.b bVar4 = this.f68773i;
        if (!bVar4.w) {
            if (bVar4.r) {
                this.f68771g.setPadding(0, this.j.i(), 0, 0);
                return;
            } else {
                this.f68771g.setPadding(0, 0, 0, 0);
                return;
            }
        }
        this.f68771g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
    }

    public d z(int i2) {
        A(ContextCompat.getColor(this.f68768d, i2));
        return this;
    }
}
