package d.b.h0.r.w.b;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f51472a;

    /* renamed from: b  reason: collision with root package name */
    public int f51473b;

    /* renamed from: c  reason: collision with root package name */
    public int f51474c;

    /* renamed from: d  reason: collision with root package name */
    public int f51475d;

    /* renamed from: e  reason: collision with root package name */
    public int f51476e;

    /* renamed from: f  reason: collision with root package name */
    public int f51477f;

    public int a() {
        return this.f51473b;
    }

    public int b() {
        return this.f51474c;
    }

    public final void c(int i) {
        this.f51473b = i;
    }

    public final void d(int i) {
        this.f51472a = i;
    }

    public final void e(int i) {
        this.f51476e = i;
    }

    public void f(int i) {
        this.f51477f = i;
    }

    public final void g(int i) {
        this.f51474c = i;
    }

    public final void h(int i) {
        this.f51475d = i;
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i = this.f51475d;
        if (i > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i));
        }
        int i2 = this.f51473b;
        if (i2 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i2));
        }
        int i3 = this.f51474c;
        if (i3 > 0) {
            indicatorView.setSelector(resources.getDrawable(i3));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.f51472a;
            int i4 = this.f51476e;
            if (i4 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i4);
            }
            int i5 = this.f51477f;
            if (i5 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i5);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
