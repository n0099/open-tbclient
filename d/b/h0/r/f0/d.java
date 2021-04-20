package d.b.h0.r.f0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f50900a;

    /* renamed from: b  reason: collision with root package name */
    public View f50901b;

    /* renamed from: c  reason: collision with root package name */
    public int f50902c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f50903d;

    /* renamed from: e  reason: collision with root package name */
    public int f50904e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f50905f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f50906g;

    /* renamed from: h  reason: collision with root package name */
    public int f50907h;
    public boolean i;
    public ViewTreeObserver.OnGlobalLayoutListener j;
    public int k;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            d.this.k();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l();
        }
    }

    public d(Activity activity) {
        this.f50900a = 3;
        int i = R.color.CAM_X0201;
        this.f50907h = i;
        this.i = false;
        this.j = null;
        this.k = 0;
        h(activity, i, true);
    }

    public static d c(Activity activity) {
        return new d(activity);
    }

    public static d d(Activity activity, int i, boolean z) {
        return new d(activity, i, z);
    }

    public static d e(Activity activity, boolean z) {
        return new d(activity, z);
    }

    public final int f() {
        Rect rect = new Rect();
        this.f50901b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void g(int i) {
        if (this.f50905f != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f50905f);
            this.f50905f = null;
        }
        this.f50905f = new b();
        d.b.c.e.m.e.a().postDelayed(this.f50905f, i);
    }

    public final void h(Activity activity, int i, boolean z) {
        this.f50907h = i;
        this.i = z;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        this.f50906g = frameLayout;
        if (z) {
            SkinManager.setBackgroundColor(frameLayout, i);
        } else {
            SkinManager.setBackgroundColor(frameLayout, i, 0);
        }
        View childAt = this.f50906g.getChildAt(0);
        this.f50901b = childAt;
        if (childAt == null) {
            return;
        }
        this.j = new a();
        this.f50901b.getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        this.f50903d = this.f50901b.getLayoutParams();
    }

    public void i() {
        if (this.f50905f != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f50905f);
            this.f50905f = null;
        }
        View view = this.f50901b;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this.j);
            this.j = null;
        }
        this.f50901b = null;
        this.f50906g = null;
    }

    public void j(int i) {
        FrameLayout frameLayout;
        if (this.i) {
            if (i != this.f50900a && (frameLayout = this.f50906g) != null) {
                SkinManager.setBackgroundColor(frameLayout, this.f50907h);
            }
            this.f50900a = i;
        }
    }

    public final void k() {
        View view = this.f50901b;
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height > this.f50904e) {
            this.f50904e = height;
        }
        int f2 = f();
        int i = this.k;
        if (i > 0 && i <= this.f50903d.height) {
            f2 -= i;
        }
        if (f2 != this.f50902c) {
            int i2 = this.f50904e;
            int i3 = i2 - f2;
            if (i3 == 0) {
                this.f50903d.height = i2;
                l();
            } else if (i3 > 200) {
                this.f50903d.height = i2 - i3;
                g(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i3) && i3 < (this.f50904e * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i3) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i3);
                }
            }
            this.f50902c = f2;
        }
    }

    public final void l() {
        this.f50901b.requestLayout();
    }

    public void m(int i) {
        this.k = i;
    }

    public d(Activity activity, boolean z) {
        this.f50900a = 3;
        int i = R.color.CAM_X0201;
        this.f50907h = i;
        this.i = false;
        this.j = null;
        this.k = 0;
        h(activity, i, z);
    }

    public d(Activity activity, int i, boolean z) {
        this.f50900a = 3;
        this.f50907h = R.color.CAM_X0201;
        this.i = false;
        this.j = null;
        this.k = 0;
        h(activity, i, z);
    }
}
