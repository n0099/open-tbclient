package d.a.k0.d2.k.e.c1;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class g extends d.a.k0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52995f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f52996g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f52997h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f52998i;
    public d.a.j0.r.q.a j;
    public s0 k;

    /* loaded from: classes5.dex */
    public class a extends d.a.j0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.j0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.j0.r.q.a
        public a2 m() {
            return g.this.f52998i;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.this;
            a.InterfaceC0547a interfaceC0547a = gVar.f52967c;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(gVar.j);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        if (this.f52995f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52965a.getPageActivity());
            this.f52995f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f52995f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f52995f, R.color.CAM_X0206);
            this.f52995f.setOrientation(1);
            this.f52995f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52995f.removeAllViews();
        if (this.f52996g == null) {
            g0 g0Var = new g0(this.f52965a);
            this.f52996g = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52995f.addView(this.f52996g.g(), layoutParams);
        if (this.k == null) {
            s0 s0Var = new s0(this.f52965a.getPageActivity());
            this.k = s0Var;
            s0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.f52995f.addView(this.k.g(), layoutParams2);
        if (this.f52997h == null) {
            this.f52997h = new ItemCardView(this.f52965a.getPageActivity());
        }
        this.f52997h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52995f.addView(this.f52997h, layoutParams3);
        return this.f52995f;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            SkinManager.setBackgroundColor(this.f52995f, R.color.CAM_X0206);
            g0 g0Var = this.f52996g;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f52997h;
            if (itemCardView != null) {
                itemCardView.b();
            }
            s0 s0Var = this.k;
            if (s0Var != null) {
                s0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52968d = originalThreadInfo;
        this.f52998i = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.j = aVar;
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.a(aVar);
        }
        ItemCardView itemCardView = this.f52997h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        g0 g0Var = this.f52996g;
        if (g0Var != null) {
            g0Var.a(this.j);
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void d(a.InterfaceC0547a interfaceC0547a) {
        super.d(interfaceC0547a);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.w(interfaceC0547a);
        }
        g0 g0Var = this.f52996g;
        if (g0Var != null) {
            g0Var.w(interfaceC0547a);
        }
        LinearLayout linearLayout = this.f52995f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.l(this.f52966b);
        }
    }
}
