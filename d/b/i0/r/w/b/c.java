package d.b.i0.r.w.b;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f51808a;

    /* renamed from: b  reason: collision with root package name */
    public int f51809b;

    /* renamed from: c  reason: collision with root package name */
    public int f51810c;

    /* renamed from: d  reason: collision with root package name */
    public int f51811d;

    /* renamed from: e  reason: collision with root package name */
    public int f51812e;

    /* renamed from: f  reason: collision with root package name */
    public int f51813f;

    public int a() {
        return this.f51809b;
    }

    public int b() {
        return this.f51810c;
    }

    public final void c(int i) {
        this.f51809b = i;
    }

    public final void d(int i) {
        this.f51808a = i;
    }

    public final void e(int i) {
        this.f51812e = i;
    }

    public void f(int i) {
        this.f51813f = i;
    }

    public final void g(int i) {
        this.f51810c = i;
    }

    public final void h(int i) {
        this.f51811d = i;
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i = this.f51811d;
        if (i > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i));
        }
        int i2 = this.f51809b;
        if (i2 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i2));
        }
        int i3 = this.f51810c;
        if (i3 > 0) {
            indicatorView.setSelector(resources.getDrawable(i3));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.f51808a;
            int i4 = this.f51812e;
            if (i4 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i4);
            }
            int i5 = this.f51813f;
            if (i5 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i5);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
