package d.b.j0.q0;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public View f60202a;

    /* renamed from: b  reason: collision with root package name */
    public int f60203b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f60204c = -1;

    public o(View view) {
        this.f60202a = view;
    }

    public int a() {
        return this.f60204c;
    }

    public int b() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f60202a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return 0;
        }
        return layoutParams.height;
    }

    public int c() {
        return this.f60203b;
    }

    public void d(double d2) {
        View view = this.f60202a;
        if (view == null) {
            return;
        }
        int i = (int) (this.f60203b + (PullRefreshFrameLayout.E * d2));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.f60204c = i;
            this.f60202a.setLayoutParams(layoutParams);
        }
    }

    public void e(int i) {
        this.f60204c = i;
    }

    public void f(int i) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f60202a;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i;
        this.f60204c = i;
        this.f60202a.setLayoutParams(layoutParams);
    }

    public void g(int i) {
        this.f60203b = i;
    }
}
