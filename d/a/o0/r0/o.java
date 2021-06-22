package d.a.o0.r0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public View f62983a;

    /* renamed from: b  reason: collision with root package name */
    public int f62984b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f62985c = -1;

    public o(View view) {
        this.f62983a = view;
    }

    public int a() {
        return this.f62985c;
    }

    public int b() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f62983a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int c() {
        return this.f62984b;
    }

    public void d(double d2) {
        View view = this.f62983a;
        if (view == null) {
            return;
        }
        int i2 = (int) (this.f62984b + (PullRefreshFrameLayout.E * d2));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            this.f62985c = i2;
            this.f62983a.setLayoutParams(layoutParams);
        }
    }

    public void e(int i2) {
        this.f62985c = i2;
    }

    public void f(int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f62983a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i2;
        this.f62985c = i2;
        this.f62983a.setLayoutParams(layoutParams);
    }

    public void g(int i2) {
        this.f62984b = i2;
    }
}
