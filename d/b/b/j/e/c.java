package d.b.b.j.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c implements BdSwipeRefreshLayout.i {

    /* renamed from: e  reason: collision with root package name */
    public Context f42363e;
    public a i;

    /* renamed from: f  reason: collision with root package name */
    public View f42364f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42365g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f42366h = 0;
    public boolean j = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar, int i, int i2, int i3, int i4);
    }

    public c(Context context) {
        this.f42363e = null;
        if (context != null) {
            this.f42363e = context;
            return;
        }
        throw new InvalidParameterException("BdIListPullView context is null");
    }

    public void A() {
        this.j = false;
    }

    public void B(boolean z) {
        this.f42365g = z;
    }

    public void C(a aVar) {
        this.i = aVar;
    }

    public void D(int i, int i2, int i3, int i4) {
        View view = this.f42364f;
        if (view == null || this.j) {
            return;
        }
        view.setPadding(i, i2, i3, i4);
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this, i, i3, i2 + q(), i4);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void d() {
        if (this.j) {
            return;
        }
        x(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void e() {
        if (this.j) {
            return;
        }
        z();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void f(float f2, float f3) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        return 0L;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public final View getView() {
        if (this.f42364f == null) {
            View n = n();
            this.f42364f = n;
            if (n != null) {
                t(n);
                this.f42366h = this.f42364f.getMeasuredHeight();
                this.f42364f.getMeasuredWidth();
            } else {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
        }
        return this.f42364f;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void j() {
        if (this.j) {
            return;
        }
        u();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void m() {
        if (this.j) {
            return;
        }
        y();
        v(true);
    }

    public abstract View n();

    public abstract void o(boolean z);

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onFinish() {
        if (this.j) {
            return;
        }
        o(true);
    }

    public Context p() {
        return this.f42363e;
    }

    public int q() {
        return this.f42366h;
    }

    public boolean r() {
        return this.f42365g;
    }

    public boolean s() {
        return this.j;
    }

    public final void t(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    public abstract void u();

    public abstract void v(boolean z);

    public void w() {
        this.j = true;
    }

    public abstract void x(boolean z);

    public abstract void y();

    public abstract void z();
}
