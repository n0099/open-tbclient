package d.b.i0.t.d.f.f;

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
    public int f62143a;

    /* renamed from: b  reason: collision with root package name */
    public int f62144b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f62145c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.t.d.f.c.a f62146d;

    /* renamed from: e  reason: collision with root package name */
    public View f62147e;

    public a(TbPageContext tbPageContext) {
        this.f62145c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f62143a = k;
        this.f62144b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.b.i0.t.d.f.c.a aVar) {
        this.f62146d = aVar;
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        this.f62147e = new View(this.f62145c.getPageActivity());
        this.f62147e.setLayoutParams(new FrameLayout.LayoutParams(this.f62143a, this.f62144b));
        this.f62147e.setBackgroundDrawable(new ColorDrawable(this.f62145c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.f62147e;
    }

    public abstract boolean f(d.b.i0.t.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        int k = l.k(this.f62145c.getPageActivity());
        this.f62143a = k;
        this.f62144b = (int) ((k * 9.0d) / 16.0d);
        View view = this.f62147e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.f62143a;
            layoutParams.height = this.f62144b;
            this.f62147e.setLayoutParams(layoutParams);
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
