package d.a.k0.t.d.f.f;

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
    public ViewGroup f61473f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f61474g;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.k0.t.d.f.f.a
    public void b(d.a.k0.t.d.f.c.a aVar) {
        super.b(aVar);
    }

    @Override // d.a.k0.t.d.f.f.a
    public View c() {
        return this.f61473f;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void d() {
        this.f61473f = new FrameLayout(this.f61470c.getPageActivity());
        this.f61474g = new TbImageView(this.f61470c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f61468a, this.f61469b);
        this.f61474g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f61474g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f61474g.setLayoutParams(layoutParams);
        this.f61473f.addView(this.f61474g);
        this.f61472e.setVisibility(8);
        this.f61473f.addView(this.f61472e);
        this.f61474g.setClickable(false);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.k0.t.d.f.f.a
    public boolean f(d.a.k0.t.d.f.c.a aVar) {
        return true;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.k0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f61474g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f61468a;
            layoutParams.height = this.f61469b;
            this.f61474g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void i(int i2) {
        if (1 == i2) {
            this.f61472e.setVisibility(0);
        } else {
            this.f61472e.setVisibility(8);
        }
    }

    @Override // d.a.k0.t.d.f.f.a
    public void j() {
        this.f61474g = null;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void m() {
    }

    @Override // d.a.k0.t.d.f.f.a
    public void n() {
    }
}
