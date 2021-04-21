package d.b.i0.r.f0;

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
    public int f51236a;

    /* renamed from: b  reason: collision with root package name */
    public View f51237b;

    /* renamed from: c  reason: collision with root package name */
    public int f51238c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f51239d;

    /* renamed from: e  reason: collision with root package name */
    public int f51240e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f51241f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f51242g;

    /* renamed from: h  reason: collision with root package name */
    public int f51243h;
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
        this.f51236a = 3;
        int i = R.color.CAM_X0201;
        this.f51243h = i;
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
        this.f51237b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void g(int i) {
        if (this.f51241f != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f51241f);
            this.f51241f = null;
        }
        this.f51241f = new b();
        d.b.c.e.m.e.a().postDelayed(this.f51241f, i);
    }

    public final void h(Activity activity, int i, boolean z) {
        this.f51243h = i;
        this.i = z;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        this.f51242g = frameLayout;
        if (z) {
            SkinManager.setBackgroundColor(frameLayout, i);
        } else {
            SkinManager.setBackgroundColor(frameLayout, i, 0);
        }
        View childAt = this.f51242g.getChildAt(0);
        this.f51237b = childAt;
        if (childAt == null) {
            return;
        }
        this.j = new a();
        this.f51237b.getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        this.f51239d = this.f51237b.getLayoutParams();
    }

    public void i() {
        if (this.f51241f != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f51241f);
            this.f51241f = null;
        }
        View view = this.f51237b;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this.j);
            this.j = null;
        }
        this.f51237b = null;
        this.f51242g = null;
    }

    public void j(int i) {
        FrameLayout frameLayout;
        if (this.i) {
            if (i != this.f51236a && (frameLayout = this.f51242g) != null) {
                SkinManager.setBackgroundColor(frameLayout, this.f51243h);
            }
            this.f51236a = i;
        }
    }

    public final void k() {
        View view = this.f51237b;
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height > this.f51240e) {
            this.f51240e = height;
        }
        int f2 = f();
        int i = this.k;
        if (i > 0 && i <= this.f51239d.height) {
            f2 -= i;
        }
        if (f2 != this.f51238c) {
            int i2 = this.f51240e;
            int i3 = i2 - f2;
            if (i3 == 0) {
                this.f51239d.height = i2;
                l();
            } else if (i3 > 200) {
                this.f51239d.height = i2 - i3;
                g(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i3) && i3 < (this.f51240e * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i3) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i3);
                }
            }
            this.f51238c = f2;
        }
    }

    public final void l() {
        this.f51237b.requestLayout();
    }

    public void m(int i) {
        this.k = i;
    }

    public d(Activity activity, boolean z) {
        this.f51236a = 3;
        int i = R.color.CAM_X0201;
        this.f51243h = i;
        this.i = false;
        this.j = null;
        this.k = 0;
        h(activity, i, z);
    }

    public d(Activity activity, int i, boolean z) {
        this.f51236a = 3;
        this.f51243h = R.color.CAM_X0201;
        this.i = false;
        this.j = null;
        this.k = 0;
        h(activity, i, z);
    }
}
