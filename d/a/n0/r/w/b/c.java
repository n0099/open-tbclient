package d.a.n0.r.w.b;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f54122a;

    /* renamed from: b  reason: collision with root package name */
    public int f54123b;

    /* renamed from: c  reason: collision with root package name */
    public int f54124c;

    /* renamed from: d  reason: collision with root package name */
    public int f54125d;

    /* renamed from: e  reason: collision with root package name */
    public int f54126e;

    /* renamed from: f  reason: collision with root package name */
    public int f54127f;

    public int a() {
        return this.f54123b;
    }

    public int b() {
        return this.f54124c;
    }

    public final void c(int i2) {
        this.f54123b = i2;
    }

    public final void d(int i2) {
        this.f54122a = i2;
    }

    public final void e(int i2) {
        this.f54126e = i2;
    }

    public void f(int i2) {
        this.f54127f = i2;
    }

    public final void g(int i2) {
        this.f54124c = i2;
    }

    public final void h(int i2) {
        this.f54125d = i2;
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i2 = this.f54125d;
        if (i2 > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i2));
        }
        int i3 = this.f54123b;
        if (i3 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i3));
        }
        int i4 = this.f54124c;
        if (i4 > 0) {
            indicatorView.setSelector(resources.getDrawable(i4));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.f54122a;
            int i5 = this.f54126e;
            if (i5 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i5);
            }
            int i6 = this.f54127f;
            if (i6 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i6);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
