package d.a.j0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.f0;
import d.a.i.r0;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public class g extends d.a.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52296f;

    /* renamed from: g  reason: collision with root package name */
    public f0 f52297g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f52298h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f52299i;
    public d.a.i0.r.q.a j;
    public r0 k;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public a2 m() {
            return g.this.f52299i;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.this;
            a.InterfaceC1009a interfaceC1009a = gVar.f52268c;
            if (interfaceC1009a != null) {
                interfaceC1009a.a(gVar.j);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public View a() {
        if (this.f52296f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52266a.getPageActivity());
            this.f52296f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f52296f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f52296f, R.color.CAM_X0206);
            this.f52296f.setOrientation(1);
            this.f52296f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52296f.removeAllViews();
        if (this.f52297g == null) {
            f0 f0Var = new f0(this.f52266a);
            this.f52297g = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52296f.addView(this.f52297g.g(), layoutParams);
        if (this.k == null) {
            r0 r0Var = new r0(this.f52266a.getPageActivity());
            this.k = r0Var;
            r0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.f52296f.addView(this.k.g(), layoutParams2);
        if (this.f52298h == null) {
            this.f52298h = new ItemCardView(this.f52266a.getPageActivity());
        }
        this.f52298h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52296f.addView(this.f52298h, layoutParams3);
        return this.f52296f;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52270e != i2) {
            this.f52270e = i2;
            SkinManager.setBackgroundColor(this.f52296f, R.color.CAM_X0206);
            f0 f0Var = this.f52297g;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f52298h;
            if (itemCardView != null) {
                itemCardView.b();
            }
            r0 r0Var = this.k;
            if (r0Var != null) {
                r0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52269d = originalThreadInfo;
        this.f52299i = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.j = aVar;
        r0 r0Var = this.k;
        if (r0Var != null) {
            r0Var.a(aVar);
        }
        ItemCardView itemCardView = this.f52298h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        f0 f0Var = this.f52297g;
        if (f0Var != null) {
            f0Var.a(this.j);
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1009a interfaceC1009a) {
        super.d(interfaceC1009a);
        r0 r0Var = this.k;
        if (r0Var != null) {
            r0Var.w(interfaceC1009a);
        }
        f0 f0Var = this.f52297g;
        if (f0Var != null) {
            f0Var.w(interfaceC1009a);
        }
        LinearLayout linearLayout = this.f52296f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        r0 r0Var = this.k;
        if (r0Var != null) {
            r0Var.l(this.f52267b);
        }
    }
}
