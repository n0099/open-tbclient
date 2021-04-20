package d.b.i0.d2.k.e.c1;

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
/* loaded from: classes3.dex */
public class f extends d.b.i0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54072f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f54073g;

    /* renamed from: h  reason: collision with root package name */
    public a2 f54074h;
    public d.b.h0.r.q.a i;
    public o j;

    /* loaded from: classes3.dex */
    public class a extends d.b.h0.r.q.a {
        public a() {
        }

        @Override // d.b.h0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.h0.r.q.a
        public a2 n() {
            return f.this.f54074h;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = f.this;
            a.InterfaceC1129a interfaceC1129a = fVar.f54052c;
            if (interfaceC1129a != null) {
                interfaceC1129a.a(fVar.i);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public View a() {
        if (this.f54072f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54050a.getPageActivity());
            this.f54072f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f54072f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f54072f, R.color.CAM_X0206);
            this.f54072f.setOrientation(1);
            this.f54072f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54072f.removeAllViews();
        if (this.j == null) {
            o oVar = new o(this.f54050a.getPageActivity());
            this.j = oVar;
            oVar.n(Boolean.TRUE);
            this.j.x("pb");
            this.j.z(0);
            this.j.F(this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), 0);
            this.j.G(false);
            this.j.E(true);
        }
        this.f54072f.addView(this.j.g());
        if (this.f54073g == null) {
            this.f54073g = new ItemCardView(this.f54050a.getPageActivity());
        }
        this.f54073g.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f54072f.addView(this.f54073g, layoutParams);
        return this.f54072f;
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54054e != i) {
            this.f54054e = i;
            SkinManager.setBackgroundColor(this.f54072f, R.color.CAM_X0206);
            o oVar = this.j;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.f54073g;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54053d = originalThreadInfo;
        this.f54074h = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.i = new a();
        ItemCardView itemCardView = this.f54073g;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        o oVar = this.j;
        if (oVar != null) {
            oVar.a(this.i);
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void d(a.InterfaceC1129a interfaceC1129a) {
        super.d(interfaceC1129a);
        o oVar = this.j;
        if (oVar != null) {
            oVar.A(interfaceC1129a);
        }
        LinearLayout linearLayout = this.f54072f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.j;
        if (oVar != null) {
            oVar.l(this.f54051b);
        }
    }
}
