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
    public ViewGroup f65476f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f65477g;

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
        return this.f65476f;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void d() {
        this.f65476f = new FrameLayout(this.f65473c.getPageActivity());
        this.f65477g = new TbImageView(this.f65473c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f65471a, this.f65472b);
        this.f65477g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f65477g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f65477g.setLayoutParams(layoutParams);
        this.f65476f.addView(this.f65477g);
        this.f65475e.setVisibility(8);
        this.f65476f.addView(this.f65475e);
        this.f65477g.setClickable(false);
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
        TbImageView tbImageView = this.f65477g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f65471a;
            layoutParams.height = this.f65472b;
            this.f65477g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void i(int i2) {
        if (1 == i2) {
            this.f65475e.setVisibility(0);
        } else {
            this.f65475e.setVisibility(8);
        }
    }

    @Override // d.a.n0.v.d.f.f.a
    public void j() {
        this.f65477g = null;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void m() {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void n() {
    }
}
