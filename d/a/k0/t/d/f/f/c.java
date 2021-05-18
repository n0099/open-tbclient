package d.a.k0.t.d.f.f;

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
public class c extends d.a.k0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f61475f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f61476g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f61471d.f61424b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f61470c, new String[]{cVar.f61471d.f61424b}, true);
            d.a.k0.t.d.d.a.c().f("c12909", c.this.f61471d.f61427e, 3, "-1");
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.k0.t.d.f.f.a
    public void b(d.a.k0.t.d.f.c.a aVar) {
        super.b(aVar);
        this.f61476g.V(aVar.f61423a, 10, false);
        d.a.k0.t.d.d.a.c().f("c12908", this.f61471d.f61427e, 3, "-1");
    }

    @Override // d.a.k0.t.d.f.f.a
    public View c() {
        return this.f61475f;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void d() {
        this.f61475f = new FrameLayout(this.f61470c.getPageActivity());
        this.f61476g = new TbImageView(this.f61470c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f61468a, this.f61469b);
        this.f61476g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f61476g.setLayoutParams(layoutParams);
        this.f61475f.addView(this.f61476g);
        this.f61472e.setVisibility(8);
        this.f61475f.addView(this.f61472e);
        this.f61476g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.k0.t.d.f.f.a
    public boolean f(d.a.k0.t.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f61426d || TextUtils.isEmpty(aVar.f61423a)) ? false : true;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.k0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f61476g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f61468a;
            layoutParams.height = this.f61469b;
            this.f61476g.setLayoutParams(layoutParams);
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
        this.f61476g = null;
    }

    @Override // d.a.k0.t.d.f.f.a
    public void m() {
    }

    @Override // d.a.k0.t.d.f.f.a
    public void n() {
    }
}
