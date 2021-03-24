package d.b.i0.p0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public View f58241a;

    /* renamed from: b  reason: collision with root package name */
    public int f58242b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f58243c = -1;

    public o(View view) {
        this.f58241a = view;
    }

    public int a() {
        return this.f58243c;
    }

    public int b() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f58241a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int c() {
        return this.f58242b;
    }

    public void d(double d2) {
        View view = this.f58241a;
        if (view == null) {
            return;
        }
        double d3 = this.f58242b;
        double d4 = PullRefreshFrameLayout.E;
        Double.isNaN(d4);
        Double.isNaN(d3);
        int i = (int) (d3 + (d4 * d2));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.f58243c = i;
            this.f58241a.setLayoutParams(layoutParams);
        }
    }

    public void e(int i) {
        this.f58243c = i;
    }

    public void f(int i) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f58241a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i;
        this.f58243c = i;
        this.f58241a.setLayoutParams(layoutParams);
    }

    public void g(int i) {
        this.f58242b = i;
    }
}
