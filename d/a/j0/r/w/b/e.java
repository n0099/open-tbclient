package d.a.j0.r.w.b;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f50281a = -2;

    /* renamed from: b  reason: collision with root package name */
    public int f50282b = -1;

    public void a(int i2) {
        this.f50281a = i2;
    }

    public void b(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f50282b, this.f50281a);
        } else {
            layoutParams.height = this.f50281a;
            layoutParams.width = this.f50282b;
        }
        viewPager.setLayoutParams(layoutParams);
    }
}
