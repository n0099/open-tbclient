package d.a.o0.v.d.f.f;

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
    public ViewGroup f65601f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f65602g;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.o0.v.d.f.f.a
    public void b(d.a.o0.v.d.f.c.a aVar) {
        super.b(aVar);
    }

    @Override // d.a.o0.v.d.f.f.a
    public View c() {
        return this.f65601f;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void d() {
        this.f65601f = new FrameLayout(this.f65598c.getPageActivity());
        this.f65602g = new TbImageView(this.f65598c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f65596a, this.f65597b);
        this.f65602g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f65602g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f65602g.setLayoutParams(layoutParams);
        this.f65601f.addView(this.f65602g);
        this.f65600e.setVisibility(8);
        this.f65601f.addView(this.f65600e);
        this.f65602g.setClickable(false);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.o0.v.d.f.f.a
    public boolean f(d.a.o0.v.d.f.c.a aVar) {
        return true;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.o0.v.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f65602g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f65596a;
            layoutParams.height = this.f65597b;
            this.f65602g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.o0.v.d.f.f.a
    public void i(int i2) {
        if (1 == i2) {
            this.f65600e.setVisibility(0);
        } else {
            this.f65600e.setVisibility(8);
        }
    }

    @Override // d.a.o0.v.d.f.f.a
    public void j() {
        this.f65602g = null;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void m() {
    }

    @Override // d.a.o0.v.d.f.f.a
    public void n() {
    }
}
