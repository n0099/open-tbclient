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
    public ViewGroup f65478f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f65479g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f65474d.f65426b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f65473c, new String[]{cVar.f65474d.f65426b}, true);
            d.a.n0.v.d.d.a.c().f("c12909", c.this.f65474d.f65429e, 3, "-1", null);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.n0.v.d.f.f.a
    public void b(d.a.n0.v.d.f.c.a aVar) {
        super.b(aVar);
        this.f65479g.U(aVar.f65425a, 10, false);
        d.a.n0.v.d.d.a.c().f("c12908", this.f65474d.f65429e, 3, "-1", null);
    }

    @Override // d.a.n0.v.d.f.f.a
    public View c() {
        return this.f65478f;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void d() {
        this.f65478f = new FrameLayout(this.f65473c.getPageActivity());
        this.f65479g = new TbImageView(this.f65473c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f65471a, this.f65472b);
        this.f65479g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f65479g.setLayoutParams(layoutParams);
        this.f65478f.addView(this.f65479g);
        this.f65475e.setVisibility(8);
        this.f65478f.addView(this.f65475e);
        this.f65479g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.v.d.f.f.a
    public boolean f(d.a.n0.v.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f65428d || TextUtils.isEmpty(aVar.f65425a)) ? false : true;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f65479g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f65471a;
            layoutParams.height = this.f65472b;
            this.f65479g.setLayoutParams(layoutParams);
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
        this.f65479g = null;
    }

    @Override // d.a.n0.v.d.f.f.a
    public void m() {
    }

    @Override // d.a.n0.v.d.f.f.a
    public void n() {
    }
}
