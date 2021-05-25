package d.a.n0.v.d.f.f;

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
public class c extends d.a.n0.v.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f61763f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f61764g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f61759d.f61712b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f61758c, new String[]{cVar.f61759d.f61712b}, true);
            d.a.n0.v.d.d.a.c().f("c12909", c.this.f61759d.f61715e, 3, "-1");
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void b(d.a.n0.v.d.f.c.a aVar) {
        super.b(aVar);
        this.f61764g.V(aVar.f61711a, 10, false);
        d.a.n0.v.d.d.a.c().f("c12908", this.f61759d.f61715e, 3, "-1");
    }

    @Override // d.a.n0.v.d.f.f.a
    public View c() {
        return this.f61763f;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void d() {
        this.f61763f = new FrameLayout(this.f61758c.getPageActivity());
        this.f61764g = new TbImageView(this.f61758c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f61756a, this.f61757b);
        this.f61764g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f61764g.setLayoutParams(layoutParams);
        this.f61763f.addView(this.f61764g);
        this.f61760e.setVisibility(8);
        this.f61763f.addView(this.f61760e);
        this.f61764g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.v.d.f.f.a
    public boolean f(d.a.n0.v.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f61714d || TextUtils.isEmpty(aVar.f61711a)) ? false : true;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f61764g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f61756a;
            layoutParams.height = this.f61757b;
            this.f61764g.setLayoutParams(layoutParams);
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
        this.f61764g = null;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void m() {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void n() {
    }
}
