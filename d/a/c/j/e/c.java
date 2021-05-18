package d.a.c.j.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c implements BdSwipeRefreshLayout.i {

    /* renamed from: e  reason: collision with root package name */
    public Context f39570e;

    /* renamed from: i  reason: collision with root package name */
    public a f39574i;

    /* renamed from: f  reason: collision with root package name */
    public View f39571f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39572g = true;

    /* renamed from: h  reason: collision with root package name */
    public int f39573h = 0;
    public boolean j = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar, int i2, int i3, int i4, int i5);
    }

    public c(Context context) {
        this.f39570e = null;
        if (context != null) {
            this.f39570e = context;
            return;
        }
        throw new InvalidParameterException("BdIListPullView context is null");
    }

    public void A() {
        this.j = false;
    }

    public void B(boolean z) {
        this.f39572g = z;
    }

    public void C(a aVar) {
        this.f39574i = aVar;
    }

    public void D(int i2, int i3, int i4, int i5) {
        View view = this.f39571f;
        if (view == null || this.j) {
            return;
        }
        view.setPadding(i2, i3, i4, i5);
        a aVar = this.f39574i;
        if (aVar != null) {
            aVar.a(this, i2, i4, i3 + q(), i5);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void c() {
        if (this.j) {
            return;
        }
        x(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void d() {
        if (this.j) {
            return;
        }
        z();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void e(float f2, float f3) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        return 0L;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public final View getView() {
        if (this.f39571f == null) {
            View n = n();
            this.f39571f = n;
            if (n != null) {
                t(n);
                this.f39573h = this.f39571f.getMeasuredHeight();
                this.f39571f.getMeasuredWidth();
            } else {
                throw new IllegalStateException("BdIListPullView getView is null");
            }
        }
        return this.f39571f;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void k() {
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
        return this.f39570e;
    }

    public int q() {
        return this.f39573h;
    }

    public boolean r() {
        return this.f39572g;
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
        int i2 = layoutParams.height;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
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
