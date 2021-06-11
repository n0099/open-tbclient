package d.a.m0.r.f0;

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
    public int f53393a;

    /* renamed from: b  reason: collision with root package name */
    public View f53394b;

    /* renamed from: c  reason: collision with root package name */
    public int f53395c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f53396d;

    /* renamed from: e  reason: collision with root package name */
    public int f53397e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f53398f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f53399g;

    /* renamed from: h  reason: collision with root package name */
    public int f53400h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53401i;
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
        this.f53393a = 3;
        int i2 = R.color.CAM_X0201;
        this.f53400h = i2;
        this.f53401i = false;
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
        this.f53394b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void g(int i2) {
        if (this.f53398f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f53398f);
            this.f53398f = null;
        }
        this.f53398f = new b();
        d.a.c.e.m.e.a().postDelayed(this.f53398f, i2);
    }

    public final void h(Activity activity, int i2, boolean z) {
        this.f53400h = i2;
        this.f53401i = z;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        this.f53399g = frameLayout;
        if (z) {
            SkinManager.setBackgroundColor(frameLayout, i2);
        } else {
            SkinManager.setBackgroundColor(frameLayout, i2, 0);
        }
        View childAt = this.f53399g.getChildAt(0);
        this.f53394b = childAt;
        if (childAt == null) {
            return;
        }
        this.j = new a();
        this.f53394b.getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        this.f53396d = this.f53394b.getLayoutParams();
    }

    public void i() {
        if (this.f53398f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f53398f);
            this.f53398f = null;
        }
        View view = this.f53394b;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this.j);
            this.j = null;
        }
        this.f53394b = null;
        this.f53399g = null;
    }

    public void j(int i2) {
        FrameLayout frameLayout;
        if (this.f53401i) {
            if (i2 != this.f53393a && (frameLayout = this.f53399g) != null) {
                SkinManager.setBackgroundColor(frameLayout, this.f53400h);
            }
            this.f53393a = i2;
        }
    }

    public final void k() {
        View view = this.f53394b;
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height > this.f53397e) {
            this.f53397e = height;
        }
        int f2 = f();
        int i2 = this.k;
        if (i2 > 0 && i2 <= this.f53396d.height) {
            f2 -= i2;
        }
        if (f2 != this.f53395c) {
            int i3 = this.f53397e;
            int i4 = i3 - f2;
            if (i4 == 0) {
                this.f53396d.height = i3;
                l();
            } else if (i4 > 200) {
                this.f53396d.height = i3 - i4;
                g(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i4) && i4 < (this.f53397e * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i4) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i4);
                }
            }
            this.f53395c = f2;
        }
    }

    public final void l() {
        this.f53394b.requestLayout();
    }

    public void m(int i2) {
        this.k = i2;
    }

    public d(Activity activity, boolean z) {
        this.f53393a = 3;
        int i2 = R.color.CAM_X0201;
        this.f53400h = i2;
        this.f53401i = false;
        this.j = null;
        this.k = 0;
        h(activity, i2, z);
    }

    public d(Activity activity, int i2, boolean z) {
        this.f53393a = 3;
        this.f53400h = R.color.CAM_X0201;
        this.f53401i = false;
        this.j = null;
        this.k = 0;
        h(activity, i2, z);
    }
}
