package d.a.i0.w.v.d;

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
    public static int f49988a;

    /* renamed from: b  reason: collision with root package name */
    public static int f49989b;

    /* renamed from: c  reason: collision with root package name */
    public static int f49990c;

    /* renamed from: d  reason: collision with root package name */
    public static int f49991d;

    /* loaded from: classes3.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: f  reason: collision with root package name */
        public final ViewGroup f49993f;

        /* renamed from: g  reason: collision with root package name */
        public final d.a.i0.w.v.b f49994g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f49995h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f49996i;
        public final boolean j;
        public final int k;
        public boolean l;
        public final InterfaceC1084b m;
        public final int n;
        public int p;

        /* renamed from: e  reason: collision with root package name */
        public int f49992e = 0;
        public boolean o = false;

        public a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, d.a.i0.w.v.b bVar, InterfaceC1084b interfaceC1084b, int i2) {
            this.f49993f = viewGroup;
            this.f49994g = bVar;
            this.f49995h = z;
            this.f49996i = z2;
            this.j = z3;
            this.k = c.a(viewGroup.getContext());
            this.m = interfaceC1084b;
            this.n = i2;
        }

        public final void a(int i2) {
            int abs;
            int h2;
            if (this.f49992e == 0) {
                this.f49992e = i2;
                this.f49994g.refreshHeight(b.h(c()));
                return;
            }
            if (d.a.i0.w.v.d.a.a(this.f49995h, this.f49996i, this.j)) {
                abs = ((View) this.f49993f.getParent()).getHeight() - i2;
            } else {
                abs = Math.abs(i2 - this.f49992e);
            }
            if (abs <= b.f(c())) {
                int height = ((View) this.f49993f.getParent()).getHeight() - i2;
                if (i2 >= this.f49992e) {
                    return;
                }
                abs = height - this.k;
            }
            if (abs == this.k || !b.i(c(), abs) || this.f49994g.getHeight() == (h2 = b.h(c()))) {
                return;
            }
            this.f49994g.refreshHeight(h2);
        }

        public final void b(int i2) {
            boolean z;
            View view = (View) this.f49993f.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (d.a.i0.w.v.d.a.a(this.f49995h, this.f49996i, this.j)) {
                if (this.f49996i || height - i2 != this.k) {
                    z = height > i2;
                } else {
                    z = this.l;
                }
            } else {
                int i3 = this.f49993f.getResources().getDisplayMetrics().heightPixels;
                int i4 = this.p;
                if (i4 == 0) {
                    z = this.l;
                } else {
                    z = i2 < i4 - b.f(c());
                }
                this.p = Math.max(this.p, height);
            }
            if (this.l != z) {
                this.f49994g.a(z);
                InterfaceC1084b interfaceC1084b = this.m;
                if (interfaceC1084b != null) {
                    interfaceC1084b.a(z);
                }
            }
            this.l = z;
        }

        public final Context c() {
            return this.f49993f.getContext();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i2;
            View childAt = this.f49993f.getChildAt(0);
            View view = (View) this.f49993f.getParent();
            Rect rect = new Rect();
            if (this.f49996i) {
                view.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
                if (!this.o) {
                    this.o = i2 == this.n;
                }
                if (!this.o) {
                    i2 += this.k;
                }
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
            } else {
                i2 = -1;
            }
            if (i2 == -1) {
                return;
            }
            a(i2);
            b(i2);
            this.f49992e = i2;
        }
    }

    /* renamed from: d.a.i0.w.v.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1084b {
        void a(boolean z);
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener b(Activity activity, d.a.i0.w.v.b bVar, InterfaceC1084b interfaceC1084b) {
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
        a aVar = new a(b2, c2, a2, viewGroup, bVar, interfaceC1084b, height);
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
        if (f49988a == 0) {
            int k = d.a.i0.r.d0.b.j().k("key_last_keyboard_height", g(context.getResources()));
            f49988a = k;
            if (k > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(f49988a);
            }
        }
        return f49988a;
    }

    public static int e(Resources resources) {
        if (f49989b == 0) {
            f49989b = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return f49989b;
    }

    public static int f(Context context) {
        if (f49991d == 0) {
            f49991d = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return f49991d;
    }

    public static int g(Resources resources) {
        if (f49990c == 0) {
            f49990c = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return f49990c;
    }

    public static int h(Context context) {
        return Math.min(e(context.getResources()), Math.max(g(context.getResources()), d(context)));
    }

    public static boolean i(Context context, int i2) {
        if (f49988a != i2 && i2 > 0) {
            f49988a = i2;
            TbadkCoreApplication.getInst().setKeyboardHeight(f49988a);
            d.a.i0.r.d0.b.j().v("key_last_keyboard_height", i2);
            return true;
        }
        return false;
    }

    public static void j(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }
}
