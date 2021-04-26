package d.a.i0.r.w.b;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f49456a;

    /* renamed from: b  reason: collision with root package name */
    public int f49457b;

    /* renamed from: c  reason: collision with root package name */
    public int f49458c;

    /* renamed from: d  reason: collision with root package name */
    public int f49459d;

    /* renamed from: e  reason: collision with root package name */
    public int f49460e;

    /* renamed from: f  reason: collision with root package name */
    public int f49461f;

    public int a() {
        return this.f49457b;
    }

    public int b() {
        return this.f49458c;
    }

    public final void c(int i2) {
        this.f49457b = i2;
    }

    public final void d(int i2) {
        this.f49456a = i2;
    }

    public final void e(int i2) {
        this.f49460e = i2;
    }

    public void f(int i2) {
        this.f49461f = i2;
    }

    public final void g(int i2) {
        this.f49458c = i2;
    }

    public final void h(int i2) {
        this.f49459d = i2;
    }

    public void i(IndicatorView indicatorView) {
        Resources resources;
        if (indicatorView == null || (resources = indicatorView.getResources()) == null) {
            return;
        }
        int i2 = this.f49459d;
        if (i2 > 0) {
            indicatorView.setSpacing(resources.getDimensionPixelSize(i2));
        }
        int i3 = this.f49457b;
        if (i3 > 0) {
            indicatorView.setDrawable(resources.getDrawable(i3));
        }
        int i4 = this.f49458c;
        if (i4 > 0) {
            indicatorView.setSelector(resources.getDrawable(i4));
        }
        ViewGroup.LayoutParams layoutParams = indicatorView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = this.f49456a;
            int i5 = this.f49460e;
            if (i5 > 0) {
                layoutParams2.bottomMargin = resources.getDimensionPixelSize(i5);
            }
            int i6 = this.f49461f;
            if (i6 > 0) {
                layoutParams2.rightMargin = resources.getDimensionPixelSize(i6);
            }
            indicatorView.setLayoutParams(layoutParams);
        }
    }
}
