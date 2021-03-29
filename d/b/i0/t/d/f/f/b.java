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
    public ViewGroup f60584f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60585g;

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
        return this.f60584f;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void d() {
        this.f60584f = new FrameLayout(this.f60581c.getPageActivity());
        this.f60585g = new TbImageView(this.f60581c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f60579a, this.f60580b);
        this.f60585g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f60585g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60585g.setLayoutParams(layoutParams);
        this.f60584f.addView(this.f60585g);
        this.f60583e.setVisibility(8);
        this.f60584f.addView(this.f60583e);
        this.f60585g.setClickable(false);
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
        TbImageView tbImageView = this.f60585g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f60579a;
            layoutParams.height = this.f60580b;
            this.f60585g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void i(int i) {
        if (1 == i) {
            this.f60583e.setVisibility(0);
        } else {
            this.f60583e.setVisibility(8);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void j() {
        this.f60585g = null;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void n() {
    }
}
