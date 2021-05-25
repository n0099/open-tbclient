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
    public LinearLayout f53255f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f53256g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f53257h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f53258i;
    public d.a.m0.r.q.a j;
    public s0 k;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public a2 m() {
            return g.this.f53258i;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.this;
            a.InterfaceC0542a interfaceC0542a = gVar.f53227c;
            if (interfaceC0542a != null) {
                interfaceC0542a.a(gVar.j);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f53255f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f53225a.getPageActivity());
            this.f53255f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f53255f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f53255f, R.color.CAM_X0206);
            this.f53255f.setOrientation(1);
            this.f53255f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f53255f.removeAllViews();
        if (this.f53256g == null) {
            g0 g0Var = new g0(this.f53225a);
            this.f53256g = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f53255f.addView(this.f53256g.g(), layoutParams);
        if (this.k == null) {
            s0 s0Var = new s0(this.f53225a.getPageActivity());
            this.k = s0Var;
            s0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.bottomMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
        this.f53255f.addView(this.k.g(), layoutParams2);
        if (this.f53257h == null) {
            this.f53257h = new ItemCardView(this.f53225a.getPageActivity());
        }
        this.f53257h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams3.leftMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.rightMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams3.bottomMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f53255f.addView(this.f53257h, layoutParams3);
        return this.f53255f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f53229e != i2) {
            this.f53229e = i2;
            SkinManager.setBackgroundColor(this.f53255f, R.color.CAM_X0206);
            g0 g0Var = this.f53256g;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f53257h;
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
        this.f53228d = originalThreadInfo;
        this.f53258i = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.j = aVar;
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.a(aVar);
        }
        ItemCardView itemCardView = this.f53257h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        g0 g0Var = this.f53256g;
        if (g0Var != null) {
            g0Var.a(this.j);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0542a interfaceC0542a) {
        super.d(interfaceC0542a);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.w(interfaceC0542a);
        }
        g0 g0Var = this.f53256g;
        if (g0Var != null) {
            g0Var.w(interfaceC0542a);
        }
        LinearLayout linearLayout = this.f53255f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        s0 s0Var = this.k;
        if (s0Var != null) {
            s0Var.l(this.f53226b);
        }
    }
}
