package d.a.n0.e2.k.e.d1;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.o;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class h extends d.a.n0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public a2 f53261f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.q.a f53262g;

    /* renamed from: h  reason: collision with root package name */
    public o f53263h;

    /* renamed from: i  reason: collision with root package name */
    public View f53264i;

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
            return h.this.f53261f;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC0542a interfaceC0542a = hVar.f53227c;
            if (interfaceC0542a != null) {
                interfaceC0542a.a(hVar.f53262g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f53263h == null) {
            o oVar = new o(this.f53225a.getPageActivity());
            this.f53263h = oVar;
            oVar.n(Boolean.TRUE);
            this.f53263h.x("pb");
            this.f53263h.z(0);
            this.f53263h.F(this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f53225a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f53263h.G(false);
            this.f53263h.E(true);
        }
        View g2 = this.f53263h.g();
        this.f53264i = g2;
        return g2;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f53229e != i2) {
            this.f53229e = i2;
            SkinManager.setBackgroundColor(this.f53264i, R.color.CAM_X0204);
            o oVar = this.f53263h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f53228d = originalThreadInfo;
        this.f53261f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f53262g = aVar;
        o oVar = this.f53263h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0542a interfaceC0542a) {
        super.d(interfaceC0542a);
        o oVar = this.f53263h;
        if (oVar != null) {
            oVar.A(interfaceC0542a);
        }
        View view = this.f53264i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f53263h;
        if (oVar != null) {
            oVar.l(this.f53226b);
        }
    }
}
