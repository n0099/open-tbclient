package d.b.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tieba.R;
import d.b.i.u0.a;
import d.b.i0.r.q.a;
/* loaded from: classes.dex */
public abstract class a<T extends d.b.i0.r.q.a> implements q, p<T> {

    /* renamed from: e  reason: collision with root package name */
    public k0 f50154e;

    /* renamed from: f  reason: collision with root package name */
    public Context f50155f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f50156g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.x.b0<T> f50157h;
    public InterfaceC1070a i;

    /* renamed from: d.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC1070a {
        void a(d.b.i0.r.q.a aVar);
    }

    public a(Context context) {
        this.f50155f = context;
    }

    public void b(int i) {
    }

    public void c(int i) {
    }

    public d.b.j0.x.b0<T> d() {
        return this.f50157h;
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
        return this.f50156g;
    }

    public abstract View g();

    public void h() {
    }

    public void i(int i, a.b bVar) {
        this.f50154e.m(i, bVar);
    }

    public void j(k0 k0Var) {
        this.f50154e = k0Var;
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

    public void l(d.b.j0.x.b0<T> b0Var) {
        this.f50157h = b0Var;
    }

    public void m(View view, int i) {
        ThreadCardView e2 = e(view, i);
        if (e2 != null) {
            d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(e2);
            d2.k(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }

    public void n(Boolean bool) {
        this.f50156g = bool;
    }
}
