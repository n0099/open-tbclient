package d.a.m0.r.w.b;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f54015a;

    /* renamed from: b  reason: collision with root package name */
    public int f54016b;

    /* renamed from: c  reason: collision with root package name */
    public int f54017c;

    /* renamed from: d  reason: collision with root package name */
    public int f54018d;

    /* renamed from: e  reason: collision with root package name */
    public int f54019e;

    /* renamed from: f  reason: collision with root package name */
    public int f54020f;

    public int a() {
        return this.f54016b;
    }

    public int b() {
        return this.f54017c;
    }

    public final void c(int i2) {
        this.f54016b = i2;
    }

    public final void d(int i2) {
        this.f54015a = i2;
    }

    public final void e(int i2) {
        this.f54019e = i2;
    }

    public void f(int i2) {
        this.f54020f = i2;
    }

    public final void g(int i2) {
        this.f54017c = i2;
    }

    public final void h(int i2) {
        this.f54018d = i2;
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i2 = this.f54018d;
        if (i2 > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i2));
        }
        int i3 = this.f54016b;
        if (i3 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i3));
        }
        int i4 = this.f54017c;
        if (i4 > 0) {
            indicatorView.setSelector(resources.getDrawable(i4));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.f54015a;
            int i5 = this.f54019e;
            if (i5 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i5);
            }
            int i6 = this.f54020f;
            if (i6 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i6);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
