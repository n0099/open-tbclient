package d.b.i0.t.d.f.f;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60579a;

    /* renamed from: b  reason: collision with root package name */
    public int f60580b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f60581c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.t.d.f.c.a f60582d;

    /* renamed from: e  reason: collision with root package name */
    public View f60583e;

    public a(TbPageContext tbPageContext) {
        this.f60581c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f60579a = k;
        this.f60580b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.b.i0.t.d.f.c.a aVar) {
        this.f60582d = aVar;
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        this.f60583e = new View(this.f60581c.getPageActivity());
        this.f60583e.setLayoutParams(new FrameLayout.LayoutParams(this.f60579a, this.f60580b));
        this.f60583e.setBackgroundDrawable(new ColorDrawable(this.f60581c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.f60583e;
    }

    public abstract boolean f(d.b.i0.t.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        int k = l.k(this.f60581c.getPageActivity());
        this.f60579a = k;
        this.f60580b = (int) ((k * 9.0d) / 16.0d);
        View view = this.f60583e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.f60579a;
            layoutParams.height = this.f60580b;
            this.f60583e.setLayoutParams(layoutParams);
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
