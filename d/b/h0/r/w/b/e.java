package d.b.h0.r.w.b;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f51068a = -2;

    /* renamed from: b  reason: collision with root package name */
    public int f51069b = -1;

    public void a(int i) {
        this.f51068a = i;
    }

    public void b(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f51069b, this.f51068a);
        } else {
            layoutParams.height = this.f51068a;
            layoutParams.width = this.f51069b;
        }
        viewPager.setLayoutParams(layoutParams);
    }
}
