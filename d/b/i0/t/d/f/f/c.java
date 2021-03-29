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
    public ViewGroup f60586f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f60587g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f60582d.f60527b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f60581c, new String[]{cVar.f60582d.f60527b}, true);
            d.b.i0.t.d.d.a.c().f("c12909", c.this.f60582d.f60530e, 3, "-1");
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void b(d.b.i0.t.d.f.c.a aVar) {
        super.b(aVar);
        this.f60587g.W(aVar.f60526a, 10, false);
        d.b.i0.t.d.d.a.c().f("c12908", this.f60582d.f60530e, 3, "-1");
    }

    @Override // d.b.i0.t.d.f.f.a
    public View c() {
        return this.f60586f;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void d() {
        this.f60586f = new FrameLayout(this.f60581c.getPageActivity());
        this.f60587g = new TbImageView(this.f60581c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f60579a, this.f60580b);
        this.f60587g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60587g.setLayoutParams(layoutParams);
        this.f60586f.addView(this.f60587g);
        this.f60583e.setVisibility(8);
        this.f60586f.addView(this.f60583e);
        this.f60587g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.t.d.f.f.a
    public boolean f(d.b.i0.t.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f60529d || TextUtils.isEmpty(aVar.f60526a)) ? false : true;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f60587g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f60579a;
            layoutParams.height = this.f60580b;
            this.f60587g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void i(int i) {
        if (1 == i) {
            this.f60583e.setVisibility(0);
        } else {
            this.f60583e.setVisibility(8);
        }
    }

    @Override // d.b.i0.t.d.f.f.a
    public void j() {
        this.f60587g = null;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void n() {
    }
}
