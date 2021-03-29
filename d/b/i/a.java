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
    public k0 f51762e;

    /* renamed from: f  reason: collision with root package name */
    public Context f51763f;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f51764g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.x.b0<T> f51765h;
    public InterfaceC1116a i;

    /* renamed from: d.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC1116a {
        void a(d.b.h0.r.q.a aVar);
    }

    public a(Context context) {
        this.f51763f = context;
    }

    public void b(int i) {
    }

    public void c(int i) {
    }

    public d.b.i0.x.b0<T> d() {
        return this.f51765h;
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
        return this.f51764g;
    }

    public abstract View g();

    public void h() {
    }

    public void i(int i, a.b bVar) {
        this.f51762e.m(i, bVar);
    }

    public void j(k0 k0Var) {
        this.f51762e = k0Var;
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
        this.f51765h = b0Var;
    }

    public void m(View view, int i) {
        ThreadCardView e2 = e(view, i);
        if (e2 != null) {
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(e2);
            a2.h(R.string.J_X06);
            a2.c(R.color.CAM_X0205);
        }
    }

    public void n(Boolean bool) {
        this.f51764g = bool;
    }
}
