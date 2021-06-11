package d.a.n0.e2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.g0;
import d.a.i.s0;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class g extends d.a.n0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f56944f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f56945g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f56946h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f56947i;
    public d.a.m0.r.q.a j;
    public s0 k;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.r.q.a {
        public a() {
        }

        @Override // d.a.m0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public a2 i() {
            return g.this.f56947i;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.this;
            a.InterfaceC0598a interfaceC0598a = gVar.f56916c;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(gVar.j);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f56944f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f56914a.getPageActivity());
            this.f56944f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f56944f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f56944f, R.color.CAM_X0206);
            this.f56944f.setOrientation(1);
            this.f56944f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f56944f.removeAllViews();
        if (this.f56945g == null) {
            g0 g0Var = new g0(this.f56914a);
            this.f56945g = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f56944f.addView(this.f56945g.g(), layoutParams);
        if (this.k == null) {
            s0 s0Var = new s0(this.f56914a.getPageActivity());
            this.k = s0Var;
            s0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.f56944f.addView(this.k.g(), layoutParams2);
        if (this.f56946h == null) {
            this.f56946h = new ItemCardView(this.f56914a.getPageActivity());
        }
        this.f56946h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f56944f.addView(this.f56946h, layoutParams3);
        return this.f56944f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            SkinManager.setBackgroundColor(this.f56944f, R.color.CAM_X0206);
            g0 g0Var = this.f56945g;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f56946h;
            if (itemCardView != null) {
                itemCardView.b();
            }
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56917d = originalThreadInfo;
        this.f56947i = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.j = aVar;
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.a(aVar);
        }
        ItemCardView itemCardView = this.f56946h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        g0 g0Var = this.f56945g;
        if (g0Var != null) {
            g0Var.a(this.j);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0598a interfaceC0598a) {
        super.d(interfaceC0598a);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.w(interfaceC0598a);
        }
        g0 g0Var = this.f56945g;
        if (g0Var != null) {
            g0Var.w(interfaceC0598a);
        }
        LinearLayout linearLayout = this.f56944f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.l(this.f56915b);
        }
    }
}
