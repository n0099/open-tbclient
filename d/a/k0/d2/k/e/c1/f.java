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
import d.a.i.o;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class f extends d.a.k0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52989f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f52990g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f52991h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.r.q.a f52992i;
    public o j;

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
            return f.this.f52991h;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            a.InterfaceC0547a interfaceC0547a = fVar.f52967c;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(fVar.f52992i);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        if (this.f52989f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52965a.getPageActivity());
            this.f52989f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f52989f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f52989f, R.color.CAM_X0206);
            this.f52989f.setOrientation(1);
            this.f52989f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52989f.removeAllViews();
        if (this.j == null) {
            o oVar = new o(this.f52965a.getPageActivity());
            this.j = oVar;
            oVar.n(Boolean.TRUE);
            this.j.x("pb");
            this.j.z(0);
            this.j.F(this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.j.G(false);
            this.j.E(true);
        }
        this.f52989f.addView(this.j.g());
        if (this.f52990g == null) {
            this.f52990g = new ItemCardView(this.f52965a.getPageActivity());
        }
        this.f52990g.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52989f.addView(this.f52990g, layoutParams);
        return this.f52989f;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            SkinManager.setBackgroundColor(this.f52989f, R.color.CAM_X0206);
            o oVar = this.j;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f52990g;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52968d = originalThreadInfo;
        this.f52991h = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.f52992i = new a();
        ItemCardView itemCardView = this.f52990g;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        o oVar = this.j;
        if (oVar != null) {
            oVar.a(this.f52992i);
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void d(a.InterfaceC0547a interfaceC0547a) {
        super.d(interfaceC0547a);
        o oVar = this.j;
        if (oVar != null) {
            oVar.A(interfaceC0547a);
        }
        LinearLayout linearLayout = this.f52989f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.j;
        if (oVar != null) {
            oVar.l(this.f52966b);
        }
    }
}
