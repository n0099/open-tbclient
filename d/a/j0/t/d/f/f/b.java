package d.a.j0.t.d.f.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f60749f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60750g;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.j0.t.d.f.f.a
    public void b(d.a.j0.t.d.f.c.a aVar) {
        super.b(aVar);
    }

    @Override // d.a.j0.t.d.f.f.a
    public View c() {
        return this.f60749f;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void d() {
        this.f60749f = new FrameLayout(this.f60746c.getPageActivity());
        this.f60750g = new TbImageView(this.f60746c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f60744a, this.f60745b);
        this.f60750g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f60750g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60750g.setLayoutParams(layoutParams);
        this.f60749f.addView(this.f60750g);
        this.f60748e.setVisibility(8);
        this.f60749f.addView(this.f60748e);
        this.f60750g.setClickable(false);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.t.d.f.f.a
    public boolean f(d.a.j0.t.d.f.c.a aVar) {
        return true;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.j0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f60750g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f60744a;
            layoutParams.height = this.f60745b;
            this.f60750g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void i(int i2) {
        if (1 == i2) {
            this.f60748e.setVisibility(0);
        } else {
            this.f60748e.setVisibility(8);
        }
    }

    @Override // d.a.j0.t.d.f.f.a
    public void j() {
        this.f60750g = null;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void m() {
    }

    @Override // d.a.j0.t.d.f.f.a
    public void n() {
    }
}
