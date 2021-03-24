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
    public int f50492a;

    /* renamed from: b  reason: collision with root package name */
    public View f50493b;

    /* renamed from: c  reason: collision with root package name */
    public int f50494c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f50495d;

    /* renamed from: e  reason: collision with root package name */
    public int f50496e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f50497f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f50498g;

    /* renamed from: h  reason: collision with root package name */
    public int f50499h;
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
        this.f50492a = 3;
        int i = R.color.CAM_X0201;
        this.f50499h = i;
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
        this.f50493b.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public final void g(int i) {
        if (this.f50497f != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.f50497f);
            this.f50497f = null;
        }
        this.f50497f = new b();
        d.b.b.e.m.e.a().postDelayed(this.f50497f, i);
    }

    public final void h(Activity activity, int i, boolean z) {
        this.f50499h = i;
        this.i = z;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        this.f50498g = frameLayout;
        if (z) {
            SkinManager.setBackgroundColor(frameLayout, i);
        } else {
            SkinManager.setBackgroundColor(frameLayout, i, 0);
        }
        View childAt = this.f50498g.getChildAt(0);
        this.f50493b = childAt;
        if (childAt == null) {
            return;
        }
        this.j = new a();
        this.f50493b.getViewTreeObserver().addOnGlobalLayoutListener(this.j);
        this.f50495d = this.f50493b.getLayoutParams();
    }

    public void i() {
        if (this.f50497f != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.f50497f);
            this.f50497f = null;
        }
        View view = this.f50493b;
        if (view != null) {
            view.getViewTreeObserver().removeGlobalOnLayoutListener(this.j);
            this.j = null;
        }
        this.f50493b = null;
        this.f50498g = null;
    }

    public void j(int i) {
        FrameLayout frameLayout;
        if (this.i) {
            if (i != this.f50492a && (frameLayout = this.f50498g) != null) {
                SkinManager.setBackgroundColor(frameLayout, this.f50499h);
            }
            this.f50492a = i;
        }
    }

    public final void k() {
        View view = this.f50493b;
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        if (height > this.f50496e) {
            this.f50496e = height;
        }
        int f2 = f();
        int i = this.k;
        if (i > 0 && i <= this.f50495d.height) {
            f2 -= i;
        }
        if (f2 != this.f50494c) {
            int i2 = this.f50496e;
            int i3 = i2 - f2;
            if (i3 == 0) {
                this.f50495d.height = i2;
                l();
            } else if (i3 > 200) {
                this.f50495d.height = i2 - i3;
                g(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i3) && i3 < (this.f50496e * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i3) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i3);
                }
            }
            this.f50494c = f2;
        }
    }

    public final void l() {
        this.f50493b.requestLayout();
    }

    public void m(int i) {
        this.k = i;
    }

    public d(Activity activity, boolean z) {
        this.f50492a = 3;
        int i = R.color.CAM_X0201;
        this.f50499h = i;
        this.i = false;
        this.j = null;
        this.k = 0;
        h(activity, i, z);
    }

    public d(Activity activity, int i, boolean z) {
        this.f50492a = 3;
        this.f50499h = R.color.CAM_X0201;
        this.i = false;
        this.j = null;
        this.k = 0;
        h(activity, i, z);
    }
}
