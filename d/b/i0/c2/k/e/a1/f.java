package d.b.i0.c2.k.e.a1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i.a;
import d.b.i.o;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class f extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52586f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f52587g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f52588h;
    public d.b.h0.r.q.a i;
    public o j;

    /* loaded from: classes4.dex */
    public class a extends d.b.h0.r.q.a {
        public a() {
        }

        @Override // d.b.h0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.h0.r.q.a
        public a2 n() {
            return f.this.f52588h;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            a.InterfaceC1115a interfaceC1115a = fVar.f52566c;
            if (interfaceC1115a != null) {
                interfaceC1115a.a(fVar.i);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52586f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52564a.getPageActivity());
            this.f52586f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f52586f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f52586f, R.color.CAM_X0206);
            this.f52586f.setOrientation(1);
            this.f52586f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52586f.removeAllViews();
        if (this.j == null) {
            o oVar = new o(this.f52564a.getPageActivity());
            this.j = oVar;
            oVar.n(Boolean.TRUE);
            this.j.x("pb");
            this.j.z(0);
            this.j.F(this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.j.G(false);
            this.j.E(true);
        }
        this.f52586f.addView(this.j.g());
        if (this.f52587g == null) {
            this.f52587g = new ItemCardView(this.f52564a.getPageActivity());
        }
        this.f52587g.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52586f.addView(this.f52587g, layoutParams);
        return this.f52586f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52568e != i) {
            this.f52568e = i;
            SkinManager.setBackgroundColor(this.f52586f, R.color.CAM_X0206);
            o oVar = this.j;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.f52587g;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52567d = originalThreadInfo;
        this.f52588h = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.i = new a();
        ItemCardView itemCardView = this.f52587g;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        o oVar = this.j;
        if (oVar != null) {
            oVar.a(this.i);
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1115a interfaceC1115a) {
        super.d(interfaceC1115a);
        o oVar = this.j;
        if (oVar != null) {
            oVar.A(interfaceC1115a);
        }
        LinearLayout linearLayout = this.f52586f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.j;
        if (oVar != null) {
            oVar.l(this.f52565b);
        }
    }
}
