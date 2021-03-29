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
/* loaded from: classes5.dex */
public class h extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public a2 f52597f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f52598g;

    /* renamed from: h  reason: collision with root package name */
    public o f52599h;
    public View i;

    /* loaded from: classes5.dex */
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
            return h.this.f52597f;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC1116a interfaceC1116a = hVar.f52567c;
            if (interfaceC1116a != null) {
                interfaceC1116a.a(hVar.f52598g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52599h == null) {
            o oVar = new o(this.f52565a.getPageActivity());
            this.f52599h = oVar;
            oVar.n(Boolean.TRUE);
            this.f52599h.x("pb");
            this.f52599h.z(0);
            this.f52599h.F(this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52565a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f52599h.G(false);
            this.f52599h.E(true);
        }
        View g2 = this.f52599h.g();
        this.i = g2;
        return g2;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52569e != i) {
            this.f52569e = i;
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            o oVar = this.f52599h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52568d = originalThreadInfo;
        this.f52597f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52598g = aVar;
        o oVar = this.f52599h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1116a interfaceC1116a) {
        super.d(interfaceC1116a);
        o oVar = this.f52599h;
        if (oVar != null) {
            oVar.A(interfaceC1116a);
        }
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f52599h;
        if (oVar != null) {
            oVar.l(this.f52566b);
        }
    }
}
