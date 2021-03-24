package d.b.i0.c2.k.e.a1;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i.a;
import d.b.i.o;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class h extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public a2 f52596f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f52597g;

    /* renamed from: h  reason: collision with root package name */
    public o f52598h;
    public View i;

    /* loaded from: classes4.dex */
    public class a extends d.b.h0.r.q.a {
        public a() {
        }

        @Override // d.b.h0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.h0.r.q.a
        public a2 n() {
            return h.this.f52596f;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC1115a interfaceC1115a = hVar.f52566c;
            if (interfaceC1115a != null) {
                interfaceC1115a.a(hVar.f52597g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52598h == null) {
            o oVar = new o(this.f52564a.getPageActivity());
            this.f52598h = oVar;
            oVar.n(Boolean.TRUE);
            this.f52598h.x("pb");
            this.f52598h.z(0);
            this.f52598h.F(this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52564a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f52598h.G(false);
            this.f52598h.E(true);
        }
        View g2 = this.f52598h.g();
        this.i = g2;
        return g2;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52568e != i) {
            this.f52568e = i;
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            o oVar = this.f52598h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52567d = originalThreadInfo;
        this.f52596f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52597g = aVar;
        o oVar = this.f52598h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1115a interfaceC1115a) {
        super.d(interfaceC1115a);
        o oVar = this.f52598h;
        if (oVar != null) {
            oVar.A(interfaceC1115a);
        }
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f52598h;
        if (oVar != null) {
            oVar.l(this.f52565b);
        }
    }
}
