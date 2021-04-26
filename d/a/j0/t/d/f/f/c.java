package d.a.j0.t.d.f.f;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class c extends d.a.j0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f60751f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60752g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f60747d.f60700b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f60746c, new String[]{cVar.f60747d.f60700b}, true);
            d.a.j0.t.d.d.a.c().f("c12909", c.this.f60747d.f60703e, 3, "-1");
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.j0.t.d.f.f.a
    public void b(d.a.j0.t.d.f.c.a aVar) {
        super.b(aVar);
        this.f60752g.V(aVar.f60699a, 10, false);
        d.a.j0.t.d.d.a.c().f("c12908", this.f60747d.f60703e, 3, "-1");
    }

    @Override // d.a.j0.t.d.f.f.a
    public View c() {
        return this.f60751f;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void d() {
        this.f60751f = new FrameLayout(this.f60746c.getPageActivity());
        this.f60752g = new TbImageView(this.f60746c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f60744a, this.f60745b);
        this.f60752g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60752g.setLayoutParams(layoutParams);
        this.f60751f.addView(this.f60752g);
        this.f60748e.setVisibility(8);
        this.f60751f.addView(this.f60748e);
        this.f60752g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.t.d.f.f.a
    public boolean f(d.a.j0.t.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f60702d || TextUtils.isEmpty(aVar.f60699a)) ? false : true;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.j0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f60752g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f60744a;
            layoutParams.height = this.f60745b;
            this.f60752g.setLayoutParams(layoutParams);
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
        this.f60752g = null;
    }

    @Override // d.a.j0.t.d.f.f.a
    public void m() {
    }

    @Override // d.a.j0.t.d.f.f.a
    public void n() {
    }
}
