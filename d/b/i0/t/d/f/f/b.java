package d.b.i0.t.d.f.f;

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
    public ViewGroup f60583f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60584g;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void b(d.b.i0.t.d.f.c.a aVar) {
        super.b(aVar);
    }

    @Override // d.b.i0.t.d.f.f.a
    public View c() {
        return this.f60583f;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void d() {
        this.f60583f = new FrameLayout(this.f60580c.getPageActivity());
        this.f60584g = new TbImageView(this.f60580c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f60578a, this.f60579b);
        this.f60584g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f60584g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60584g.setLayoutParams(layoutParams);
        this.f60583f.addView(this.f60584g);
        this.f60582e.setVisibility(8);
        this.f60583f.addView(this.f60582e);
        this.f60584g.setClickable(false);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.t.d.f.f.a
    public boolean f(d.b.i0.t.d.f.c.a aVar) {
        return true;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f60584g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f60578a;
            layoutParams.height = this.f60579b;
            this.f60584g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void i(int i) {
        if (1 == i) {
            this.f60582e.setVisibility(0);
        } else {
            this.f60582e.setVisibility(8);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void j() {
        this.f60584g = null;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void n() {
    }
}
