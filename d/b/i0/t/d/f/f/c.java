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
    public ViewGroup f62150f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f62151g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f62146d.f62091b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f62145c, new String[]{cVar.f62146d.f62091b}, true);
            d.b.i0.t.d.d.a.c().f("c12909", c.this.f62146d.f62094e, 3, "-1");
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.b.i0.t.d.f.f.a
    public void b(d.b.i0.t.d.f.c.a aVar) {
        super.b(aVar);
        this.f62151g.W(aVar.f62090a, 10, false);
        d.b.i0.t.d.d.a.c().f("c12908", this.f62146d.f62094e, 3, "-1");
    }

    @Override // d.b.i0.t.d.f.f.a
    public View c() {
        return this.f62150f;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void d() {
        this.f62150f = new FrameLayout(this.f62145c.getPageActivity());
        this.f62151g = new TbImageView(this.f62145c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f62143a, this.f62144b);
        this.f62151g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62151g.setLayoutParams(layoutParams);
        this.f62150f.addView(this.f62151g);
        this.f62147e.setVisibility(8);
        this.f62150f.addView(this.f62147e);
        this.f62151g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.t.d.f.f.a
    public boolean f(d.b.i0.t.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f62093d || TextUtils.isEmpty(aVar.f62090a)) ? false : true;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f62151g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f62143a;
            layoutParams.height = this.f62144b;
            this.f62151g.setLayoutParams(layoutParams);
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
        this.f62151g = null;
    }

    @Override // d.b.i0.t.d.f.f.a
    public void m() {
    }

    @Override // d.b.i0.t.d.f.f.a
    public void n() {
    }
}
