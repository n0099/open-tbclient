package d.a.n0.r.w.b;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f54128a = -2;

    /* renamed from: b  reason: collision with root package name */
    public int f54129b = -1;

    public void a(int i2) {
        this.f54128a = i2;
    }

    public void b(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f54129b, this.f54128a);
        } else {
            layoutParams.height = this.f54128a;
            layoutParams.width = this.f54129b;
        }
        viewPager.setLayoutParams(layoutParams);
    }
}
