package d.b.j0.t.d.f.f;

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
    public ViewGroup f62569f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f62570g;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.b.j0.t.d.f.f.a
    public void b(d.b.j0.t.d.f.c.a aVar) {
        super.b(aVar);
    }

    @Override // d.b.j0.t.d.f.f.a
    public View c() {
        return this.f62569f;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void d() {
        this.f62569f = new FrameLayout(this.f62566c.getPageActivity());
        this.f62570g = new TbImageView(this.f62566c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f62564a, this.f62565b);
        this.f62570g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f62570g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62570g.setLayoutParams(layoutParams);
        this.f62569f.addView(this.f62570g);
        this.f62568e.setVisibility(8);
        this.f62569f.addView(this.f62568e);
        this.f62570g.setClickable(false);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.t.d.f.f.a
    public boolean f(d.b.j0.t.d.f.c.a aVar) {
        return true;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.b.j0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f62570g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f62564a;
            layoutParams.height = this.f62565b;
            this.f62570g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public void i(int i) {
        if (1 == i) {
            this.f62568e.setVisibility(0);
        } else {
            this.f62568e.setVisibility(8);
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public void j() {
        this.f62570g = null;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.j0.t.d.f.f.a
    public void n() {
    }
}
