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
    public ViewGroup f62148f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f62149g;

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
        return this.f62148f;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void d() {
        this.f62148f = new FrameLayout(this.f62145c.getPageActivity());
        this.f62149g = new TbImageView(this.f62145c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f62143a, this.f62144b);
        this.f62149g.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.f62149g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62149g.setLayoutParams(layoutParams);
        this.f62148f.addView(this.f62149g);
        this.f62147e.setVisibility(8);
        this.f62148f.addView(this.f62147e);
        this.f62149g.setClickable(false);
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
        TbImageView tbImageView = this.f62149g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f62143a;
            layoutParams.height = this.f62144b;
            this.f62149g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void i(int i) {
        if (1 == i) {
            this.f62147e.setVisibility(0);
        } else {
            this.f62147e.setVisibility(8);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void j() {
        this.f62149g = null;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void n() {
    }
}
