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
import d.a.i.o;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class f extends d.a.n0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f56938f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f56939g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f56940h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.r.q.a f56941i;
    public o j;

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
            return f.this.f56940h;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            a.InterfaceC0598a interfaceC0598a = fVar.f56916c;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(fVar.f56941i);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f56938f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f56914a.getPageActivity());
            this.f56938f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f56938f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f56938f, R.color.CAM_X0206);
            this.f56938f.setOrientation(1);
            this.f56938f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f56938f.removeAllViews();
        if (this.j == null) {
            o oVar = new o(this.f56914a.getPageActivity());
            this.j = oVar;
            oVar.n(Boolean.TRUE);
            this.j.x("pb");
            this.j.z(0);
            this.j.F(this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.j.G(false);
            this.j.E(true);
        }
        this.f56938f.addView(this.j.g());
        if (this.f56939g == null) {
            this.f56939g = new ItemCardView(this.f56914a.getPageActivity());
        }
        this.f56939g.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f56938f.addView(this.f56939g, layoutParams);
        return this.f56938f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            SkinManager.setBackgroundColor(this.f56938f, R.color.CAM_X0206);
            o oVar = this.j;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f56939g;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56917d = originalThreadInfo;
        this.f56940h = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.f56941i = new a();
        ItemCardView itemCardView = this.f56939g;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        o oVar = this.j;
        if (oVar != null) {
            oVar.a(this.f56941i);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0598a interfaceC0598a) {
        super.d(interfaceC0598a);
        o oVar = this.j;
        if (oVar != null) {
            oVar.A(interfaceC0598a);
        }
        LinearLayout linearLayout = this.f56938f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.j;
        if (oVar != null) {
            oVar.l(this.f56915b);
        }
    }
}
