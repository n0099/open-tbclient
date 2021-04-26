package d.a.j0.q0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public View f58284a;

    /* renamed from: b  reason: collision with root package name */
    public int f58285b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f58286c = -1;

    public o(View view) {
        this.f58284a = view;
    }

    public int a() {
        return this.f58286c;
    }

    public int b() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f58284a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int c() {
        return this.f58285b;
    }

    public void d(double d2) {
        View view = this.f58284a;
        if (view == null) {
            return;
        }
        int i2 = (int) (this.f58285b + (PullRefreshFrameLayout.E * d2));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i2;
            this.f58286c = i2;
            this.f58284a.setLayoutParams(layoutParams);
        }
    }

    public void e(int i2) {
        this.f58286c = i2;
    }

    public void f(int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f58284a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i2;
        this.f58286c = i2;
        this.f58284a.setLayoutParams(layoutParams);
    }

    public void g(int i2) {
        this.f58285b = i2;
    }
}
