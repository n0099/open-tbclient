package d.b.h0.r.w.b;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f51478a = -2;

    /* renamed from: b  reason: collision with root package name */
    public int f51479b = -1;

    public void a(int i) {
        this.f51478a = i;
    }

    public void b(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f51479b, this.f51478a);
        } else {
            layoutParams.height = this.f51478a;
            layoutParams.width = this.f51479b;
        }
        viewPager.setLayoutParams(layoutParams);
    }
}
