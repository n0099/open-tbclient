package d.b.h0.r.w.b;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f51067a = -2;

    /* renamed from: b  reason: collision with root package name */
    public int f51068b = -1;

    public void a(int i) {
        this.f51067a = i;
    }

    public void b(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f51068b, this.f51067a);
        } else {
            layoutParams.height = this.f51067a;
            layoutParams.width = this.f51068b;
        }
        viewPager.setLayoutParams(layoutParams);
    }
}
