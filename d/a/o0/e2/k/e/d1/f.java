package d.a.o0.e2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.o;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class f extends d.a.o0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57063f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f57064g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f57065h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r.q.a f57066i;
    public o j;

    /* loaded from: classes5.dex */
    public class a extends d.a.n0.r.q.a {
        public a() {
        }

        @Override // d.a.n0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.n0.r.q.a
        public a2 i() {
            return f.this.f57065h;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            a.InterfaceC0600a interfaceC0600a = fVar.f57041c;
            if (interfaceC0600a != null) {
                interfaceC0600a.a(fVar.f57066i);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public View a() {
        if (this.f57063f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f57039a.getPageActivity());
            this.f57063f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f57063f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f57063f, R.color.CAM_X0206);
            this.f57063f.setOrientation(1);
            this.f57063f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f57063f.removeAllViews();
        if (this.j == null) {
            o oVar = new o(this.f57039a.getPageActivity());
            this.j = oVar;
            oVar.n(Boolean.TRUE);
            this.j.x("pb");
            this.j.z(0);
            this.j.F(this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.j.G(false);
            this.j.E(true);
        }
        this.f57063f.addView(this.j.g());
        if (this.f57064g == null) {
            this.f57064g = new ItemCardView(this.f57039a.getPageActivity());
        }
        this.f57064g.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f57063f.addView(this.f57064g, layoutParams);
        return this.f57063f;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f57043e != i2) {
            this.f57043e = i2;
            SkinManager.setBackgroundColor(this.f57063f, R.color.CAM_X0206);
            o oVar = this.j;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f57064g;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f57042d = originalThreadInfo;
        this.f57065h = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.f57066i = new a();
        ItemCardView itemCardView = this.f57064g;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        o oVar = this.j;
        if (oVar != null) {
            oVar.a(this.f57066i);
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void d(a.InterfaceC0600a interfaceC0600a) {
        super.d(interfaceC0600a);
        o oVar = this.j;
        if (oVar != null) {
            oVar.A(interfaceC0600a);
        }
        LinearLayout linearLayout = this.f57063f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.j;
        if (oVar != null) {
            oVar.l(this.f57040b);
        }
    }
}
