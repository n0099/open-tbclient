package d.b.i0.q0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public View f59781a;

    /* renamed from: b  reason: collision with root package name */
    public int f59782b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f59783c = -1;

    public o(View view) {
        this.f59781a = view;
    }

    public int a() {
        return this.f59783c;
    }

    public int b() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f59781a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int c() {
        return this.f59782b;
    }

    public void d(double d2) {
        View view = this.f59781a;
        if (view == null) {
            return;
        }
        int i = (int) (this.f59782b + (PullRefreshFrameLayout.E * d2));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.f59783c = i;
            this.f59781a.setLayoutParams(layoutParams);
        }
    }

    public void e(int i) {
        this.f59783c = i;
    }

    public void f(int i) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f59781a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i;
        this.f59783c = i;
        this.f59781a.setLayoutParams(layoutParams);
    }

    public void g(int i) {
        this.f59782b = i;
    }
}
