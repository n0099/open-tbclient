package d.a.j0.r.f0;

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
    public int f49674a;

    /* renamed from: b  reason: collision with root package name */
    public View f49675b;

    /* renamed from: c  reason: collision with root package name */
    public int f49676c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f49677d;

    /* renamed from: e  reason: collision with root package name */
    public int f49678e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f49679f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f49680g;

    /* renamed from: h  reason: collision with root package name */
    public int f49681h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49682i;
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
        this.f49674a = 3;
        int i2 = R.color.CAM_X0201;
        this.f49681h = i2;
        this.f49682i = false;
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
        this.f49675b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void g(int i2) {
        if (this.f49679f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f49679f);
            this.f49679f = null;
        }
        this.f49679f = new b();
        d.a.c.e.m.e.a().postDelayed(this.f49679f, i2);
    }

    public final void h(Activity activity, int i2, boolean z) {
        this.f49681h = i2;
        this.f49682i = z;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        this.f49680g = frameLayout;
        if (z) {
            SkinManager.setBackgroundColor(frameLayout, i2);
        } else {
            SkinManager.setBackgroundColor(frameLayout, i2, 0);
        }
        View childAt = this.f49680g.getChildAt(0);
        this.f49675b = childAt;
        if (childAt == null) {
            return;
        }
        this.j = new a();
        this.f49675b.getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        this.f49677d = this.f49675b.getLayoutParams();
    }

    public void i() {
        if (this.f49679f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f49679f);
            this.f49679f = null;
        }
        View view = this.f49675b;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this.j);
            this.j = null;
        }
        this.f49675b = null;
        this.f49680g = null;
    }

    public void j(int i2) {
        FrameLayout frameLayout;
        if (this.f49682i) {
            if (i2 != this.f49674a && (frameLayout = this.f49680g) != null) {
                SkinManager.setBackgroundColor(frameLayout, this.f49681h);
            }
            this.f49674a = i2;
        }
    }

    public final void k() {
        View view = this.f49675b;
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height > this.f49678e) {
            this.f49678e = height;
        }
        int f2 = f();
        int i2 = this.k;
        if (i2 > 0 && i2 <= this.f49677d.height) {
            f2 -= i2;
        }
        if (f2 != this.f49676c) {
            int i3 = this.f49678e;
            int i4 = i3 - f2;
            if (i4 == 0) {
                this.f49677d.height = i3;
                l();
            } else if (i4 > 200) {
                this.f49677d.height = i3 - i4;
                g(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i4) && i4 < (this.f49678e * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i4) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i4);
                }
            }
            this.f49676c = f2;
        }
    }

    public final void l() {
        this.f49675b.requestLayout();
    }

    public void m(int i2) {
        this.k = i2;
    }

    public d(Activity activity, boolean z) {
        this.f49674a = 3;
        int i2 = R.color.CAM_X0201;
        this.f49681h = i2;
        this.f49682i = false;
        this.j = null;
        this.k = 0;
        h(activity, i2, z);
    }

    public d(Activity activity, int i2, boolean z) {
        this.f49674a = 3;
        this.f49681h = R.color.CAM_X0201;
        this.f49682i = false;
        this.j = null;
        this.k = 0;
        h(activity, i2, z);
    }
}
