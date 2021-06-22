package d.a.n0.r.f0;

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
    public int f53500a;

    /* renamed from: b  reason: collision with root package name */
    public View f53501b;

    /* renamed from: c  reason: collision with root package name */
    public int f53502c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f53503d;

    /* renamed from: e  reason: collision with root package name */
    public int f53504e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f53505f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f53506g;

    /* renamed from: h  reason: collision with root package name */
    public int f53507h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53508i;
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
        this.f53500a = 3;
        int i2 = R.color.CAM_X0201;
        this.f53507h = i2;
        this.f53508i = false;
        this.j = null;
        this.k = 0;
        h(activity, i2, true);
    }

    public static d c(Activity activity) {
        return new d(activity);
    }

    public static d d(Activity activity, int i2, boolean z) {
        return new d(activity, i2, z);
    }

    public static d e(Activity activity, boolean z) {
        return new d(activity, z);
    }

    public final int f() {
        Rect rect = new Rect();
        this.f53501b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void g(int i2) {
        if (this.f53505f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f53505f);
            this.f53505f = null;
        }
        this.f53505f = new b();
        d.a.c.e.m.e.a().postDelayed(this.f53505f, i2);
    }

    public final void h(Activity activity, int i2, boolean z) {
        this.f53507h = i2;
        this.f53508i = z;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        this.f53506g = frameLayout;
        if (z) {
            SkinManager.setBackgroundColor(frameLayout, i2);
        } else {
            SkinManager.setBackgroundColor(frameLayout, i2, 0);
        }
        View childAt = this.f53506g.getChildAt(0);
        this.f53501b = childAt;
        if (childAt == null) {
            return;
        }
        this.j = new a();
        this.f53501b.getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        this.f53503d = this.f53501b.getLayoutParams();
    }

    public void i() {
        if (this.f53505f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f53505f);
            this.f53505f = null;
        }
        View view = this.f53501b;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this.j);
            this.j = null;
        }
        this.f53501b = null;
        this.f53506g = null;
    }

    public void j(int i2) {
        FrameLayout frameLayout;
        if (this.f53508i) {
            if (i2 != this.f53500a && (frameLayout = this.f53506g) != null) {
                SkinManager.setBackgroundColor(frameLayout, this.f53507h);
            }
            this.f53500a = i2;
        }
    }

    public final void k() {
        View view = this.f53501b;
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height > this.f53504e) {
            this.f53504e = height;
        }
        int f2 = f();
        int i2 = this.k;
        if (i2 > 0 && i2 <= this.f53503d.height) {
            f2 -= i2;
        }
        if (f2 != this.f53502c) {
            int i3 = this.f53504e;
            int i4 = i3 - f2;
            if (i4 == 0) {
                this.f53503d.height = i3;
                l();
            } else if (i4 > 200) {
                this.f53503d.height = i3 - i4;
                g(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i4) && i4 < (this.f53504e * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i4) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i4);
                }
            }
            this.f53502c = f2;
        }
    }

    public final void l() {
        this.f53501b.requestLayout();
    }

    public void m(int i2) {
        this.k = i2;
    }

    public d(Activity activity, boolean z) {
        this.f53500a = 3;
        int i2 = R.color.CAM_X0201;
        this.f53507h = i2;
        this.f53508i = false;
        this.j = null;
        this.k = 0;
        h(activity, i2, z);
    }

    public d(Activity activity, int i2, boolean z) {
        this.f53500a = 3;
        this.f53507h = R.color.CAM_X0201;
        this.f53508i = false;
        this.j = null;
        this.k = 0;
        h(activity, i2, z);
    }
}
