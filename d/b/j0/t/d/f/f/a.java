package d.b.j0.t.d.f.f;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62564a;

    /* renamed from: b  reason: collision with root package name */
    public int f62565b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f62566c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.t.d.f.c.a f62567d;

    /* renamed from: e  reason: collision with root package name */
    public View f62568e;

    public a(TbPageContext tbPageContext) {
        this.f62566c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f62564a = k;
        this.f62565b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.b.j0.t.d.f.c.a aVar) {
        this.f62567d = aVar;
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        this.f62568e = new View(this.f62566c.getPageActivity());
        this.f62568e.setLayoutParams(new FrameLayout.LayoutParams(this.f62564a, this.f62565b));
        this.f62568e.setBackgroundDrawable(new ColorDrawable(this.f62566c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.f62568e;
    }

    public abstract boolean f(d.b.j0.t.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        int k = l.k(this.f62566c.getPageActivity());
        this.f62564a = k;
        this.f62565b = (int) ((k * 9.0d) / 16.0d);
        View view = this.f62568e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.f62564a;
            layoutParams.height = this.f62565b;
            this.f62568e.setLayoutParams(layoutParams);
        }
    }

    public abstract void i(int i);

    public abstract void j();

    public void k() {
    }

    public void l() {
    }

    public abstract void m();

    public abstract void n();
}
