package d.b.j0.d2.k.e.c1;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i.a;
import d.b.i.o;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public class h extends d.b.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public a2 f54503f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.q.a f54504g;

    /* renamed from: h  reason: collision with root package name */
    public o f54505h;
    public View i;

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
            return h.this.f54503f;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC1070a interfaceC1070a = hVar.f54473c;
            if (interfaceC1070a != null) {
                interfaceC1070a.a(hVar.f54504g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public View a() {
        if (this.f54505h == null) {
            o oVar = new o(this.f54471a.getPageActivity());
            this.f54505h = oVar;
            oVar.n(Boolean.TRUE);
            this.f54505h.x("pb");
            this.f54505h.z(0);
            this.f54505h.F(this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f54471a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f54505h.G(false);
            this.f54505h.E(true);
        }
        View g2 = this.f54505h.g();
        this.i = g2;
        return g2;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54475e != i) {
            this.f54475e = i;
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            o oVar = this.f54505h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54474d = originalThreadInfo;
        this.f54503f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f54504g = aVar;
        o oVar = this.f54505h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1070a interfaceC1070a) {
        super.d(interfaceC1070a);
        o oVar = this.f54505h;
        if (oVar != null) {
            oVar.A(interfaceC1070a);
        }
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f54505h;
        if (oVar != null) {
            oVar.l(this.f54472b);
        }
    }
}
