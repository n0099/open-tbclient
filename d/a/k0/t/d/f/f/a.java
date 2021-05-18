package d.a.k0.t.d.f.f;

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
    public int f61468a;

    /* renamed from: b  reason: collision with root package name */
    public int f61469b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f61470c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.t.d.f.c.a f61471d;

    /* renamed from: e  reason: collision with root package name */
    public View f61472e;

    public a(TbPageContext tbPageContext) {
        this.f61470c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f61468a = k;
        this.f61469b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.a.k0.t.d.f.c.a aVar) {
        this.f61471d = aVar;
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        this.f61472e = new View(this.f61470c.getPageActivity());
        this.f61472e.setLayoutParams(new FrameLayout.LayoutParams(this.f61468a, this.f61469b));
        this.f61472e.setBackgroundDrawable(new ColorDrawable(this.f61470c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.f61472e;
    }

    public abstract boolean f(d.a.k0.t.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        int k = l.k(this.f61470c.getPageActivity());
        this.f61468a = k;
        this.f61469b = (int) ((k * 9.0d) / 16.0d);
        View view = this.f61472e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = this.f61468a;
            layoutParams.height = this.f61469b;
            this.f61472e.setLayoutParams(layoutParams);
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
