package d.a.j0.t.d.f.f;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60744a;

    /* renamed from: b  reason: collision with root package name */
    public int f60745b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f60746c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.t.d.f.c.a f60747d;

    /* renamed from: e  reason: collision with root package name */
    public View f60748e;

    public a(TbPageContext tbPageContext) {
        this.f60746c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f60744a = k;
        this.f60745b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.a.j0.t.d.f.c.a aVar) {
        this.f60747d = aVar;
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        this.f60748e = new View(this.f60746c.getPageActivity());
        this.f60748e.setLayoutParams(new FrameLayout.LayoutParams(this.f60744a, this.f60745b));
        this.f60748e.setBackgroundDrawable(new ColorDrawable(this.f60746c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.f60748e;
    }

    public abstract boolean f(d.a.j0.t.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        int k = l.k(this.f60746c.getPageActivity());
        this.f60744a = k;
        this.f60745b = (int) ((k * 9.0d) / 16.0d);
        View view = this.f60748e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.f60744a;
            layoutParams.height = this.f60745b;
            this.f60748e.setLayoutParams(layoutParams);
        }
    }

    public abstract void i(int i2);

    public abstract void j();

    public void k() {
    }

    public void l() {
    }

    public abstract void m();

    public abstract void n();
}
