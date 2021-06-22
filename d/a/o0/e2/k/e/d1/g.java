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
import d.a.i.g0;
import d.a.i.s0;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class g extends d.a.o0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57069f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f57070g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f57071h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f57072i;
    public d.a.n0.r.q.a j;
    public s0 k;

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
            return g.this.f57072i;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.this;
            a.InterfaceC0600a interfaceC0600a = gVar.f57041c;
            if (interfaceC0600a != null) {
                interfaceC0600a.a(gVar.j);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public View a() {
        if (this.f57069f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f57039a.getPageActivity());
            this.f57069f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f57069f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f57069f, R.color.CAM_X0206);
            this.f57069f.setOrientation(1);
            this.f57069f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f57069f.removeAllViews();
        if (this.f57070g == null) {
            g0 g0Var = new g0(this.f57039a);
            this.f57070g = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f57069f.addView(this.f57070g.g(), layoutParams);
        if (this.k == null) {
            s0 s0Var = new s0(this.f57039a.getPageActivity());
            this.k = s0Var;
            s0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.f57069f.addView(this.k.g(), layoutParams2);
        if (this.f57071h == null) {
            this.f57071h = new ItemCardView(this.f57039a.getPageActivity());
        }
        this.f57071h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f57069f.addView(this.f57071h, layoutParams3);
        return this.f57069f;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f57043e != i2) {
            this.f57043e = i2;
            SkinManager.setBackgroundColor(this.f57069f, R.color.CAM_X0206);
            g0 g0Var = this.f57070g;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f57071h;
            if (itemCardView != null) {
                itemCardView.b();
            }
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f57042d = originalThreadInfo;
        this.f57072i = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.j = aVar;
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.a(aVar);
        }
        ItemCardView itemCardView = this.f57071h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        g0 g0Var = this.f57070g;
        if (g0Var != null) {
            g0Var.a(this.j);
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void d(a.InterfaceC0600a interfaceC0600a) {
        super.d(interfaceC0600a);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.w(interfaceC0600a);
        }
        g0 g0Var = this.f57070g;
        if (g0Var != null) {
            g0Var.w(interfaceC0600a);
        }
        LinearLayout linearLayout = this.f57069f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.l(this.f57040b);
        }
    }
}
