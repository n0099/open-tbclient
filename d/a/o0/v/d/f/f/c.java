package d.a.o0.v.d.f.f;

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
public class c extends d.a.o0.v.d.f.f.a {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f65603f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f65604g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(c.this.f65599d.f65551b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            c cVar = c.this;
            urlManager.dealOneLink(cVar.f65598c, new String[]{cVar.f65599d.f65551b}, true);
            d.a.o0.v.d.d.a.c().f("c12909", c.this.f65599d.f65554e, 3, "-1", null);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        e();
    }

    @Override // d.a.o0.v.d.f.f.a
    public void b(d.a.o0.v.d.f.c.a aVar) {
        super.b(aVar);
        this.f65604g.U(aVar.f65550a, 10, false);
        d.a.o0.v.d.d.a.c().f("c12908", this.f65599d.f65554e, 3, "-1", null);
    }

    @Override // d.a.o0.v.d.f.f.a
    public View c() {
        return this.f65603f;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void d() {
        this.f65603f = new FrameLayout(this.f65598c.getPageActivity());
        this.f65604g = new TbImageView(this.f65598c.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f65596a, this.f65597b);
        this.f65604g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f65604g.setLayoutParams(layoutParams);
        this.f65603f.addView(this.f65604g);
        this.f65600e.setVisibility(8);
        this.f65603f.addView(this.f65600e);
        this.f65604g.setOnClickListener(new a());
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.o0.v.d.f.f.a
    public boolean f(d.a.o0.v.d.f.c.a aVar) {
        return (aVar == null || 3 != aVar.f65553d || TextUtils.isEmpty(aVar.f65550a)) ? false : true;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void g(boolean z) {
    }

    @Override // d.a.o0.v.d.f.f.a
    public void h() {
        super.h();
        TbImageView tbImageView = this.f65604g;
        if (tbImageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = this.f65596a;
            layoutParams.height = this.f65597b;
            this.f65604g.setLayoutParams(layoutParams);
        }
    }

    @Override // d.a.o0.v.d.f.f.a
    public void i(int i2) {
        if (1 == i2) {
            this.f65600e.setVisibility(0);
        } else {
            this.f65600e.setVisibility(8);
        }
    }

    @Override // d.a.o0.v.d.f.f.a
    public void j() {
        this.f65604g = null;
    }

    @Override // d.a.o0.v.d.f.f.a
    public void m() {
    }

    @Override // d.a.o0.v.d.f.f.a
    public void n() {
    }
}
