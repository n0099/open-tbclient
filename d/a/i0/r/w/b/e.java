package d.a.i0.r.w.b;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f49462a = -2;

    /* renamed from: b  reason: collision with root package name */
    public int f49463b = -1;

    public void a(int i2) {
        this.f49462a = i2;
    }

    public void b(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f49463b, this.f49462a);
        } else {
            layoutParams.height = this.f49462a;
            layoutParams.width = this.f49463b;
        }
        viewPager.setLayoutParams(layoutParams);
    }
}
