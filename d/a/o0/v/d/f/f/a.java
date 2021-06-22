package d.a.o0.v.d.f.f;

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
    public int f65596a;

    /* renamed from: b  reason: collision with root package name */
    public int f65597b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f65598c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.v.d.f.c.a f65599d;

    /* renamed from: e  reason: collision with root package name */
    public View f65600e;

    public a(TbPageContext tbPageContext) {
        this.f65598c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f65596a = k;
        this.f65597b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.a.o0.v.d.f.c.a aVar) {
        this.f65599d = aVar;
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        this.f65600e = new View(this.f65598c.getPageActivity());
        this.f65600e.setLayoutParams(new FrameLayout.LayoutParams(this.f65596a, this.f65597b));
        this.f65600e.setBackgroundDrawable(new ColorDrawable(this.f65598c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.f65600e;
    }

    public abstract boolean f(d.a.o0.v.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        int k = l.k(this.f65598c.getPageActivity());
        this.f65596a = k;
        this.f65597b = (int) ((k * 9.0d) / 16.0d);
        View view = this.f65600e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.f65596a;
            layoutParams.height = this.f65597b;
            this.f65600e.setLayoutParams(layoutParams);
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
