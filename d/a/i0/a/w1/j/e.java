package d.a.i0.a.w1.j;

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
    public static int f45443a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f45444b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f45445c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f45446d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f45447e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f45448f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f45449g = false;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f45450e;

        public a(View view) {
            this.f45450e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.m(this.f45450e);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onSoftInputShowing(boolean z);
    }

    /* loaded from: classes3.dex */
    public static class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final d.a.i0.a.w1.k.b f45451e;

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f45452f;

        /* renamed from: g  reason: collision with root package name */
        public final b f45453g;

        /* renamed from: h  reason: collision with root package name */
        public int f45454h = 0;

        /* renamed from: i  reason: collision with root package name */
        public boolean f45455i;
        public final Activity j;
        public int k;

        public c(Activity activity, ViewGroup viewGroup, d.a.i0.a.w1.k.b bVar, b bVar2) {
            this.j = activity;
            this.f45453g = bVar2;
            this.f45452f = viewGroup;
            this.f45451e = bVar;
        }

        public final void a(int i2) {
            int abs;
            int j;
            if (this.f45454h == 0) {
                this.f45454h = i2;
                this.f45451e.refreshHeight(e.j(c()));
            }
            if (d.a.i0.a.w1.j.b.e(this.f45452f.getContext())) {
                abs = ((View) this.f45452f.getParent()).getHeight() - i2;
            } else {
                abs = Math.abs(i2 - this.f45454h);
            }
            if (abs > e.g(c())) {
                if (!e.l(c(), abs) || this.f45451e.getHeight() == (j = e.j(c()))) {
                    return;
                }
                this.f45451e.refreshHeight(j);
            } else if (Math.abs(abs) == e.i(this.f45452f.getContext())) {
                this.f45454h -= abs;
            }
        }

        public final void b(int i2) {
            View view = (View) this.f45452f.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            boolean z = true;
            if (!d.a.i0.a.w1.j.b.e(this.f45452f.getContext())) {
                int i3 = this.k;
                if (i3 == 0) {
                    z = this.f45455i;
                } else if (i2 >= i3 - e.g(c())) {
                    z = false;
                }
                this.k = Math.max(this.k, height);
            } else if (height <= i2) {
                z = false;
            }
            if (this.f45455i != z) {
                this.f45451e.onSoftInputShowing(z);
                b bVar = this.f45453g;
                if (bVar != null) {
                    bVar.onSoftInputShowing(z);
                }
            }
            this.f45455i = z;
        }

        public final Context c() {
            return this.f45452f.getContext();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i2;
            View childAt = this.f45452f.getChildAt(0);
            Rect rect = new Rect();
            if (childAt == null) {
                i2 = -1;
            } else if (!d.a.i0.a.w1.j.b.e(this.f45452f.getContext()) && (!g.e(this.j) || !g.c(this.j))) {
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

    public static ViewTreeObserver.OnGlobalLayoutListener c(Activity activity, ViewGroup viewGroup, d.a.i0.a.w1.k.b bVar, b bVar2) {
        if (viewGroup == null) {
            viewGroup = (ViewGroup) activity.findViewById(16908290);
        }
        c cVar = new c(activity, viewGroup, bVar, bVar2);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
        return cVar;
    }

    public static int d(Resources resources) {
        if (f45446d == 0) {
            f45446d = resources.getDimensionPixelSize(d.a.i0.a.d.aiapps_max_panel_height);
        }
        return f45446d;
    }

    public static int e(Context context) {
        if (f45444b == 0) {
            f45444b = context.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_max_softinput_height);
        }
        return f45444b;
    }

    public static int f(Resources resources) {
        if (f45445c == 0) {
            f45445c = resources.getDimensionPixelSize(d.a.i0.a.d.aiapps_min_panel_height);
        }
        return f45445c;
    }

    public static int g(Context context) {
        if (f45443a == 0) {
            f45443a = context.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_min_softinput_height);
        }
        return f45443a;
    }

    public static int h(Context context) {
        if (f45447e == 0) {
            f45447e = d.a.i0.a.w1.h.e.a(context, f(context.getResources()));
        }
        return f45447e;
    }

    public static synchronized int i(Context context) {
        int i2;
        int identifier;
        synchronized (e.class) {
            if (!f45449g && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                f45448f = context.getResources().getDimensionPixelSize(identifier);
                f45449g = true;
            }
            i2 = f45448f;
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
        if (f45447e != i2 && i2 >= 0) {
            f45447e = i2;
            return d.a.i0.a.w1.h.e.b(context, i2);
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
