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
    public LinearLayout f53249f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f53250g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f53251h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.r.q.a f53252i;
    public o j;

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
            return f.this.f53251h;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            a.InterfaceC0542a interfaceC0542a = fVar.f53227c;
            if (interfaceC0542a != null) {
                interfaceC0542a.a(fVar.f53252i);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f53249f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f53225a.getPageActivity());
            this.f53249f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f53249f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f53249f, R.color.CAM_X0206);
            this.f53249f.setOrientation(1);
            this.f53249f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f53249f.removeAllViews();
        if (this.j == null) {
            o oVar = new o(this.f53225a.getPageActivity());
            this.j = oVar;
            oVar.n(Boolean.TRUE);
            this.j.x("pb");
            this.j.z(0);
            this.j.F(this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.j.G(false);
            this.j.E(true);
        }
        this.f53249f.addView(this.j.g());
        if (this.f53250g == null) {
            this.f53250g = new ItemCardView(this.f53225a.getPageActivity());
        }
        this.f53250g.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f53249f.addView(this.f53250g, layoutParams);
        return this.f53249f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f53229e != i2) {
            this.f53229e = i2;
            SkinManager.setBackgroundColor(this.f53249f, R.color.CAM_X0206);
            o oVar = this.j;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f53250g;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f53228d = originalThreadInfo;
        this.f53251h = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.f53252i = new a();
        ItemCardView itemCardView = this.f53250g;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        o oVar = this.j;
        if (oVar != null) {
            oVar.a(this.f53252i);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0542a interfaceC0542a) {
        super.d(interfaceC0542a);
        o oVar = this.j;
        if (oVar != null) {
            oVar.A(interfaceC0542a);
        }
        LinearLayout linearLayout = this.f53249f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.j;
        if (oVar != null) {
            oVar.l(this.f53226b);
        }
    }
}
