package d.b.j0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.b.i.a;
import d.b.i.o;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public class f extends d.b.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54493f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f54494g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f54495h;
    public d.b.i0.r.q.a i;
    public o j;

    /* loaded from: classes3.dex */
    public class a extends d.b.i0.r.q.a {
        public a() {
        }

        @Override // d.b.i0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.i0.r.q.a
        public a2 n() {
            return f.this.f54495h;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            a.InterfaceC1070a interfaceC1070a = fVar.f54473c;
            if (interfaceC1070a != null) {
                interfaceC1070a.a(fVar.i);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public View a() {
        if (this.f54493f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54471a.getPageActivity());
            this.f54493f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f54493f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f54493f, R.color.CAM_X0206);
            this.f54493f.setOrientation(1);
            this.f54493f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54493f.removeAllViews();
        if (this.j == null) {
            o oVar = new o(this.f54471a.getPageActivity());
            this.j = oVar;
            oVar.n(Boolean.TRUE);
            this.j.x("pb");
            this.j.z(0);
            this.j.F(this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.j.G(false);
            this.j.E(true);
        }
        this.f54493f.addView(this.j.g());
        if (this.f54494g == null) {
            this.f54494g = new ItemCardView(this.f54471a.getPageActivity());
        }
        this.f54494g.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f54493f.addView(this.f54494g, layoutParams);
        return this.f54493f;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54475e != i) {
            this.f54475e = i;
            SkinManager.setBackgroundColor(this.f54493f, R.color.CAM_X0206);
            o oVar = this.j;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.f54494g;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54474d = originalThreadInfo;
        this.f54495h = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.i = new a();
        ItemCardView itemCardView = this.f54494g;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        o oVar = this.j;
        if (oVar != null) {
            oVar.a(this.i);
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1070a interfaceC1070a) {
        super.d(interfaceC1070a);
        o oVar = this.j;
        if (oVar != null) {
            oVar.A(interfaceC1070a);
        }
        LinearLayout linearLayout = this.f54493f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.j;
        if (oVar != null) {
            oVar.l(this.f54472b);
        }
    }
}
