package d.a.j0.r.w.b;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f50275a;

    /* renamed from: b  reason: collision with root package name */
    public int f50276b;

    /* renamed from: c  reason: collision with root package name */
    public int f50277c;

    /* renamed from: d  reason: collision with root package name */
    public int f50278d;

    /* renamed from: e  reason: collision with root package name */
    public int f50279e;

    /* renamed from: f  reason: collision with root package name */
    public int f50280f;

    public int a() {
        return this.f50276b;
    }

    public int b() {
        return this.f50277c;
    }

    public final void c(int i2) {
        this.f50276b = i2;
    }

    public final void d(int i2) {
        this.f50275a = i2;
    }

    public final void e(int i2) {
        this.f50279e = i2;
    }

    public void f(int i2) {
        this.f50280f = i2;
    }

    public final void g(int i2) {
        this.f50277c = i2;
    }

    public final void h(int i2) {
        this.f50278d = i2;
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i2 = this.f50278d;
        if (i2 > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i2));
        }
        int i3 = this.f50276b;
        if (i3 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i3));
        }
        int i4 = this.f50277c;
        if (i4 > 0) {
            indicatorView.setSelector(resources.getDrawable(i4));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.f50275a;
            int i5 = this.f50279e;
            if (i5 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i5);
            }
            int i6 = this.f50280f;
            if (i6 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i6);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
