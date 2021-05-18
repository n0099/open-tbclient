package d.a.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tieba.R;
import d.a.i.v0.a;
import d.a.j0.r.q.a;
/* loaded from: classes.dex */
public abstract class a<T extends d.a.j0.r.q.a> implements q, p<T> {

    /* renamed from: e  reason: collision with root package name */
    public l0 f40315e;

    /* renamed from: f  reason: collision with root package name */
    public Context f40316f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f40317g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.x.b0<T> f40318h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0547a f40319i;

    /* renamed from: d.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0547a {
        void a(d.a.j0.r.q.a aVar);
    }

    public a(Context context) {
        this.f40316f = context;
    }

    public void b(int i2) {
    }

    public void c(int i2) {
    }

    public d.a.k0.x.b0<T> d() {
        return this.f40318h;
    }

    public final ThreadCardView e(View view, int i2) {
        if (view == null || view.getParent() == null || i2 == 0) {
            return null;
        }
        if (view.getParent() instanceof ThreadCardView) {
            return (ThreadCardView) view.getParent();
        }
        return e((View) view.getParent(), i2 - 1);
    }

    public Boolean f() {
        return this.f40317g;
    }

    public abstract View g();

    public void h() {
    }

    public void i(int i2, a.b bVar) {
        this.f40315e.m(i2, bVar);
    }

    public void j(l0 l0Var) {
        this.f40315e = l0Var;
    }

    public void k(View view, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(d.a.k0.x.b0<T> b0Var) {
        this.f40318h = b0Var;
    }

    public void m(View view, int i2) {
        ThreadCardView e2 = e(view, i2);
        if (e2 != null) {
            d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(e2);
            d2.k(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }

    public void n(Boolean bool) {
        this.f40317g = bool;
    }
}
