package d.a.o0.e2.k.e.d1;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.o;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class h extends d.a.o0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public a2 f57075f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.q.a f57076g;

    /* renamed from: h  reason: collision with root package name */
    public o f57077h;

    /* renamed from: i  reason: collision with root package name */
    public View f57078i;

    /* loaded from: classes5.dex */
    public class a extends d.a.n0.r.q.a {
        public a() {
        }

        @Override // d.a.n0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.n0.r.q.a
        public a2 i() {
            return h.this.f57075f;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC0600a interfaceC0600a = hVar.f57041c;
            if (interfaceC0600a != null) {
                interfaceC0600a.a(hVar.f57076g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public View a() {
        if (this.f57077h == null) {
            o oVar = new o(this.f57039a.getPageActivity());
            this.f57077h = oVar;
            oVar.n(Boolean.TRUE);
            this.f57077h.x("pb");
            this.f57077h.z(0);
            this.f57077h.F(this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f57039a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f57077h.G(false);
            this.f57077h.E(true);
        }
        View g2 = this.f57077h.g();
        this.f57078i = g2;
        return g2;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f57043e != i2) {
            this.f57043e = i2;
            SkinManager.setBackgroundColor(this.f57078i, R.color.CAM_X0204);
            o oVar = this.f57077h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f57042d = originalThreadInfo;
        this.f57075f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f57076g = aVar;
        o oVar = this.f57077h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void d(a.InterfaceC0600a interfaceC0600a) {
        super.d(interfaceC0600a);
        o oVar = this.f57077h;
        if (oVar != null) {
            oVar.A(interfaceC0600a);
        }
        View view = this.f57078i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f57077h;
        if (oVar != null) {
            oVar.l(this.f57040b);
        }
    }
}
