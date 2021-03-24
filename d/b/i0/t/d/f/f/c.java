package d.b.i0.t.d.f.f;

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
public class c extends d.b.i0.t.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f60585f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60586g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f60581d.f60526b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f60580c, new String[]{cVar.f60581d.f60526b}, true);
            d.b.i0.t.d.d.a.c().f("c12909", c.this.f60581d.f60529e, 3, "-1");
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void b(d.b.i0.t.d.f.c.a aVar) {
        super.b(aVar);
        this.f60586g.W(aVar.f60525a, 10, false);
        d.b.i0.t.d.d.a.c().f("c12908", this.f60581d.f60529e, 3, "-1");
    }

    @Override // d.b.i0.t.d.f.f.a
    public View c() {
        return this.f60585f;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void d() {
        this.f60585f = new FrameLayout(this.f60580c.getPageActivity());
        this.f60586g = new TbImageView(this.f60580c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f60578a, this.f60579b);
        this.f60586g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60586g.setLayoutParams(layoutParams);
        this.f60585f.addView(this.f60586g);
        this.f60582e.setVisibility(8);
        this.f60585f.addView(this.f60582e);
        this.f60586g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.t.d.f.f.a
    public boolean f(d.b.i0.t.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f60528d || TextUtils.isEmpty(aVar.f60525a)) ? false : true;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f60586g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f60578a;
            layoutParams.height = this.f60579b;
            this.f60586g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void i(int i) {
        if (1 == i) {
            this.f60582e.setVisibility(0);
        } else {
            this.f60582e.setVisibility(8);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void j() {
        this.f60586g = null;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void n() {
    }
}
