package d.b.j0.t.d.f.f;

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
public class c extends d.b.j0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f62571f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f62572g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f62567d.f62512b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f62566c, new String[]{cVar.f62567d.f62512b}, true);
            d.b.j0.t.d.d.a.c().f("c12909", c.this.f62567d.f62515e, 3, "-1");
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.b.j0.t.d.f.f.a
    public void b(d.b.j0.t.d.f.c.a aVar) {
        super.b(aVar);
        this.f62572g.W(aVar.f62511a, 10, false);
        d.b.j0.t.d.d.a.c().f("c12908", this.f62567d.f62515e, 3, "-1");
    }

    @Override // d.b.j0.t.d.f.f.a
    public View c() {
        return this.f62571f;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void d() {
        this.f62571f = new FrameLayout(this.f62566c.getPageActivity());
        this.f62572g = new TbImageView(this.f62566c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f62564a, this.f62565b);
        this.f62572g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62572g.setLayoutParams(layoutParams);
        this.f62571f.addView(this.f62572g);
        this.f62568e.setVisibility(8);
        this.f62571f.addView(this.f62568e);
        this.f62572g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.t.d.f.f.a
    public boolean f(d.b.j0.t.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f62514d || TextUtils.isEmpty(aVar.f62511a)) ? false : true;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.b.j0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f62572g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f62564a;
            layoutParams.height = this.f62565b;
            this.f62572g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public void i(int i) {
        if (1 == i) {
            this.f62568e.setVisibility(0);
        } else {
            this.f62568e.setVisibility(8);
        }
    }

    @Override // d.b.j0.t.d.f.f.a
    public void j() {
        this.f62572g = null;
    }

    @Override // d.b.j0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.j0.t.d.f.f.a
    public void n() {
    }
}
