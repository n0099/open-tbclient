package d.a.n0.v.d.f.f;

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
    public int f65471a;

    /* renamed from: b  reason: collision with root package name */
    public int f65472b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f65473c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.v.d.f.c.a f65474d;

    /* renamed from: e  reason: collision with root package name */
    public View f65475e;

    public a(TbPageContext tbPageContext) {
        this.f65473c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f65471a = k;
        this.f65472b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.a.n0.v.d.f.c.a aVar) {
        this.f65474d = aVar;
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        this.f65475e = new View(this.f65473c.getPageActivity());
        this.f65475e.setLayoutParams(new FrameLayout.LayoutParams(this.f65471a, this.f65472b));
        this.f65475e.setBackgroundDrawable(new ColorDrawable(this.f65473c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.f65475e;
    }

    public abstract boolean f(d.a.n0.v.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        int k = l.k(this.f65473c.getPageActivity());
        this.f65471a = k;
        this.f65472b = (int) ((k * 9.0d) / 16.0d);
        View view = this.f65475e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.f65471a;
            layoutParams.height = this.f65472b;
            this.f65475e.setLayoutParams(layoutParams);
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
