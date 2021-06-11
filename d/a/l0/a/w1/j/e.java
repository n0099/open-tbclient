package d.a.l0.a.w1.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static int f49293a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f49294b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f49295c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f49296d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f49297e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f49298f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f49299g = false;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f49300e;

        public a(View view) {
            this.f49300e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.m(this.f49300e);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onSoftInputShowing(boolean z);
    }

    /* loaded from: classes3.dex */
    public static class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final d.a.l0.a.w1.k.b f49301e;

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f49302f;

        /* renamed from: g  reason: collision with root package name */
        public final b f49303g;

        /* renamed from: h  reason: collision with root package name */
        public int f49304h = 0;

        /* renamed from: i  reason: collision with root package name */
        public boolean f49305i;
        public final Activity j;
        public int k;

        public c(Activity activity, ViewGroup viewGroup, d.a.l0.a.w1.k.b bVar, b bVar2) {
            this.j = activity;
            this.f49303g = bVar2;
            this.f49302f = viewGroup;
            this.f49301e = bVar;
        }

        public final void a(int i2) {
            int abs;
            int j;
            if (this.f49304h == 0) {
                this.f49304h = i2;
                this.f49301e.refreshHeight(e.j(c()));
            }
            if (d.a.l0.a.w1.j.b.e(this.f49302f.getContext())) {
                abs = ((View) this.f49302f.getParent()).getHeight() - i2;
            } else {
                abs = Math.abs(i2 - this.f49304h);
            }
            if (abs > e.g(c())) {
                if (!e.l(c(), abs) || this.f49301e.getHeight() == (j = e.j(c()))) {
                    return;
                }
                this.f49301e.refreshHeight(j);
            } else if (Math.abs(abs) == e.i(this.f49302f.getContext())) {
                this.f49304h -= abs;
            }
        }

        public final void b(int i2) {
            View view = (View) this.f49302f.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            boolean z = true;
            if (!d.a.l0.a.w1.j.b.e(this.f49302f.getContext())) {
                int i3 = this.k;
                if (i3 == 0) {
                    z = this.f49305i;
                } else if (i2 >= i3 - e.g(c())) {
                    z = false;
                }
                this.k = Math.max(this.k, height);
            } else if (height <= i2) {
                z = false;
            }
            if (this.f49305i != z) {
                this.f49301e.onSoftInputShowing(z);
                b bVar = this.f49303g;
                if (bVar != null) {
                    bVar.onSoftInputShowing(z);
                }
            }
            this.f49305i = z;
        }

        public final Context c() {
            return this.f49302f.getContext();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            View childAt = this.f49302f.getChildAt(0);
            Rect rect = new Rect();
            if (childAt == null) {
                i2 = -1;
            } else if (!d.a.l0.a.w1.j.b.e(this.f49302f.getContext()) && (!g.e(this.j) || !g.c(this.j))) {
                i2 = childAt.getHeight();
            } else {
                childAt.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
            }
            if (i2 == -1) {
                return;
            }
            a(i2);
            b(i2);
        }
    }

    public static ViewTreeObserver.OnGlobalLayoutListener c(Activity activity, ViewGroup viewGroup, d.a.l0.a.w1.k.b bVar, b bVar2) {
        if (viewGroup == null) {
            viewGroup = (ViewGroup) activity.findViewById(16908290);
        }
        c cVar = new c(activity, viewGroup, bVar, bVar2);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
        return cVar;
    }

    public static int d(Resources resources) {
        if (f49296d == 0) {
            f49296d = resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_max_panel_height);
        }
        return f49296d;
    }

    public static int e(Context context) {
        if (f49294b == 0) {
            f49294b = context.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_max_softinput_height);
        }
        return f49294b;
    }

    public static int f(Resources resources) {
        if (f49295c == 0) {
            f49295c = resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_min_panel_height);
        }
        return f49295c;
    }

    public static int g(Context context) {
        if (f49293a == 0) {
            f49293a = context.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_min_softinput_height);
        }
        return f49293a;
    }

    public static int h(Context context) {
        if (f49297e == 0) {
            f49297e = d.a.l0.a.w1.h.e.a(context, f(context.getResources()));
        }
        return f49297e;
    }

    public static synchronized int i(Context context) {
        int i2;
        int identifier;
        synchronized (e.class) {
            if (!f49299g && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                f49298f = context.getResources().getDimensionPixelSize(identifier);
                f49299g = true;
            }
            i2 = f49298f;
        }
        return i2;
    }

    public static int j(Context context) {
        return Math.min(d(context.getResources()), Math.max(f(context.getResources()), h(context)));
    }

    public static void k(@NonNull View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean l(Context context, int i2) {
        if (f49297e != i2 && i2 >= 0) {
            f49297e = i2;
            return d.a.l0.a.w1.h.e.b(context, i2);
        }
        return false;
    }

    public static void m(View view) {
        view.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    public static void n(View view, long j) {
        view.postDelayed(new a(view), j);
    }
}
