package d.a.k0.d2.k.e.c1;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.o;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class h extends d.a.k0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public a2 f53001f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.q.a f53002g;

    /* renamed from: h  reason: collision with root package name */
    public o f53003h;

    /* renamed from: i  reason: collision with root package name */
    public View f53004i;

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
            return h.this.f53001f;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC0547a interfaceC0547a = hVar.f52967c;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(hVar.f53002g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        if (this.f53003h == null) {
            o oVar = new o(this.f52965a.getPageActivity());
            this.f53003h = oVar;
            oVar.n(Boolean.TRUE);
            this.f53003h.x("pb");
            this.f53003h.z(0);
            this.f53003h.F(this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52965a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f53003h.G(false);
            this.f53003h.E(true);
        }
        View g2 = this.f53003h.g();
        this.f53004i = g2;
        return g2;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            SkinManager.setBackgroundColor(this.f53004i, R.color.CAM_X0204);
            o oVar = this.f53003h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52968d = originalThreadInfo;
        this.f53001f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f53002g = aVar;
        o oVar = this.f53003h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void d(a.InterfaceC0547a interfaceC0547a) {
        super.d(interfaceC0547a);
        o oVar = this.f53003h;
        if (oVar != null) {
            oVar.A(interfaceC0547a);
        }
        View view = this.f53004i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f53003h;
        if (oVar != null) {
            oVar.l(this.f52966b);
        }
    }
}
