package d.a.n0.v.d.f.f;

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
    public ViewGroup f61761f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f61762g;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void b(d.a.n0.v.d.f.c.a aVar) {
        super.b(aVar);
    }

    @Override // d.a.n0.v.d.f.f.a
    public View c() {
        return this.f61761f;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void d() {
        this.f61761f = new FrameLayout(this.f61758c.getPageActivity());
        this.f61762g = new TbImageView(this.f61758c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f61756a, this.f61757b);
        this.f61762g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f61762g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f61762g.setLayoutParams(layoutParams);
        this.f61761f.addView(this.f61762g);
        this.f61760e.setVisibility(8);
        this.f61761f.addView(this.f61760e);
        this.f61762g.setClickable(false);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.v.d.f.f.a
    public boolean f(d.a.n0.v.d.f.c.a aVar) {
        return true;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f61762g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f61756a;
            layoutParams.height = this.f61757b;
            this.f61762g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void i(int i2) {
        if (1 == i2) {
            this.f61760e.setVisibility(0);
        } else {
            this.f61760e.setVisibility(8);
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void j() {
        this.f61762g = null;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void m() {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void n() {
    }
}
