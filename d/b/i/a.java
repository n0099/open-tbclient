package d.b.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tieba.R;
import d.b.h0.r.q.a;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public abstract class a<T extends d.b.h0.r.q.a> implements q, p<T> {

    /* renamed from: e  reason: collision with root package name */
    public k0 f52186e;

    /* renamed from: f  reason: collision with root package name */
    public Context f52187f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f52188g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.x.b0<T> f52189h;
    public InterfaceC1129a i;

    /* renamed from: d.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC1129a {
        void a(d.b.h0.r.q.a aVar);
    }

    public a(Context context) {
        this.f52187f = context;
    }

    public void b(int i) {
    }

    public void c(int i) {
    }

    public d.b.i0.x.b0<T> d() {
        return this.f52189h;
    }

    public final ThreadCardView e(View view, int i) {
        if (view == null || view.getParent() == null || i == 0) {
            return null;
        }
        if (view.getParent() instanceof ThreadCardView) {
            return (ThreadCardView) view.getParent();
        }
        return e((View) view.getParent(), i - 1);
    }

    public Boolean f() {
        return this.f52188g;
    }

    public abstract View g();

    public void h() {
    }

    public void i(int i, a.b bVar) {
        this.f52186e.m(i, bVar);
    }

    public void j(k0 k0Var) {
        this.f52186e = k0Var;
    }

    public void k(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(d.b.i0.x.b0<T> b0Var) {
        this.f52189h = b0Var;
    }

    public void m(View view, int i) {
        ThreadCardView e2 = e(view, i);
        if (e2 != null) {
            d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(e2);
            d2.k(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }

    public void n(Boolean bool) {
        this.f52188g = bool;
    }
}
