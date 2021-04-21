package d.b.i0.w.v.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f52316a;

    /* renamed from: b  reason: collision with root package name */
    public static int f52317b;

    /* renamed from: c  reason: collision with root package name */
    public static int f52318c;

    /* renamed from: d  reason: collision with root package name */
    public static int f52319d;

    /* loaded from: classes3.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f52321f;

        /* renamed from: g  reason: collision with root package name */
        public final d.b.i0.w.v.b f52322g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f52323h;
        public final boolean i;
        public final boolean j;
        public final int k;
        public boolean l;
        public final InterfaceC1145b m;
        public final int n;
        public int p;

        /* renamed from: e  reason: collision with root package name */
        public int f52320e = 0;
        public boolean o = false;

        public a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, d.b.i0.w.v.b bVar, InterfaceC1145b interfaceC1145b, int i) {
            this.f52321f = viewGroup;
            this.f52322g = bVar;
            this.f52323h = z;
            this.i = z2;
            this.j = z3;
            this.k = c.a(viewGroup.getContext());
            this.m = interfaceC1145b;
            this.n = i;
        }

        public final void a(int i) {
            int abs;
            int h2;
            if (this.f52320e == 0) {
                this.f52320e = i;
                this.f52322g.refreshHeight(b.h(c()));
                return;
            }
            if (d.b.i0.w.v.d.a.a(this.f52323h, this.i, this.j)) {
                abs = ((View) this.f52321f.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.f52320e);
            }
            if (abs <= b.f(c())) {
                int height = ((View) this.f52321f.getParent()).getHeight() - i;
                if (i >= this.f52320e) {
                    return;
                }
                abs = height - this.k;
            }
            if (abs == this.k || !b.i(c(), abs) || this.f52322g.getHeight() == (h2 = b.h(c()))) {
                return;
            }
            this.f52322g.refreshHeight(h2);
        }

        public final void b(int i) {
            boolean z;
            View view = (View) this.f52321f.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (d.b.i0.w.v.d.a.a(this.f52323h, this.i, this.j)) {
                if (this.i || height - i != this.k) {
                    z = height > i;
                } else {
                    z = this.l;
                }
            } else {
                int i2 = this.f52321f.getResources().getDisplayMetrics().heightPixels;
                int i3 = this.p;
                if (i3 == 0) {
                    z = this.l;
                } else {
                    z = i < i3 - b.f(c());
                }
                this.p = Math.max(this.p, height);
            }
            if (this.l != z) {
                this.f52322g.a(z);
                InterfaceC1145b interfaceC1145b = this.m;
                if (interfaceC1145b != null) {
                    interfaceC1145b.a(z);
                }
            }
            this.l = z;
        }

        public final Context c() {
            return this.f52321f.getContext();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.f52321f.getChildAt(0);
            View view = (View) this.f52321f.getParent();
            Rect rect = new Rect();
            if (this.i) {
                view.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
                if (!this.o) {
                    this.o = i == this.n;
                }
                if (!this.o) {
                    i += this.k;
                }
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i == -1) {
                return;
            }
            a(i);
            b(i);
            this.f52320e = i;
        }
    }

    /* renamed from: d.b.i0.w.v.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1145b {
        void a(boolean z);
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener b(Activity activity, d.b.i0.w.v.b bVar, InterfaceC1145b interfaceC1145b) {
        int height;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        boolean b2 = d.b(activity);
        boolean c2 = d.c(activity);
        boolean a2 = d.a(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            height = point.y;
        } else {
            height = defaultDisplay.getHeight();
        }
        a aVar = new a(b2, c2, a2, viewGroup, bVar, interfaceC1145b, height);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        return aVar;
    }

    @TargetApi(16)
    public static void c(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (Build.VERSION.SDK_INT >= 16) {
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static int d(Context context) {
        if (f52316a == 0) {
            int k = d.b.i0.r.d0.b.j().k("key_last_keyboard_height", g(context.getResources()));
            f52316a = k;
            if (k > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(f52316a);
            }
        }
        return f52316a;
    }

    public static int e(Resources resources) {
        if (f52317b == 0) {
            f52317b = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return f52317b;
    }

    public static int f(Context context) {
        if (f52319d == 0) {
            f52319d = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return f52319d;
    }

    public static int g(Resources resources) {
        if (f52318c == 0) {
            f52318c = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return f52318c;
    }

    public static int h(Context context) {
        return Math.min(e(context.getResources()), Math.max(g(context.getResources()), d(context)));
    }

    public static boolean i(Context context, int i) {
        if (f52316a != i && i > 0) {
            f52316a = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(f52316a);
            d.b.i0.r.d0.b.j().v("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static void j(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }
}
