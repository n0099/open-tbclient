package d.a.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tieba.R;
import d.a.i.v0.a;
import d.a.n0.r.q.a;
/* loaded from: classes.dex */
public abstract class a<T extends d.a.n0.r.q.a> implements q, p<T> {

    /* renamed from: e  reason: collision with root package name */
    public l0 f43781e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43782f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f43783g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.z.b0<T> f43784h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0600a f43785i;

    /* renamed from: d.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0600a {
        void a(d.a.n0.r.q.a aVar);
    }

    public a(Context context) {
        this.f43782f = context;
    }

    public void b(int i2) {
    }

    public void c(int i2) {
    }

    public d.a.o0.z.b0<T> d() {
        return this.f43784h;
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
        return this.f43783g;
    }

    public abstract View g();

    public void h() {
    }

    public void i(int i2, a.b bVar) {
        this.f43781e.m(i2, bVar);
    }

    public void j(l0 l0Var) {
        this.f43781e = l0Var;
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

    public void l(d.a.o0.z.b0<T> b0Var) {
        this.f43784h = b0Var;
    }

    public void m(View view, int i2) {
        ThreadCardView e2 = e(view, i2);
        if (e2 != null) {
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(e2);
            d2.m(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }

    public void n(Boolean bool) {
        this.f43783g = bool;
    }
}
