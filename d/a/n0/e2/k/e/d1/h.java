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
    public a2 f56950f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.q.a f56951g;

    /* renamed from: h  reason: collision with root package name */
    public o f56952h;

    /* renamed from: i  reason: collision with root package name */
    public View f56953i;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.r.q.a {
        public a() {
        }

        @Override // d.a.m0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public a2 i() {
            return h.this.f56950f;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC0598a interfaceC0598a = hVar.f56916c;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(hVar.f56951g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f56952h == null) {
            o oVar = new o(this.f56914a.getPageActivity());
            this.f56952h = oVar;
            oVar.n(Boolean.TRUE);
            this.f56952h.x("pb");
            this.f56952h.z(0);
            this.f56952h.F(this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f56914a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f56952h.G(false);
            this.f56952h.E(true);
        }
        View g2 = this.f56952h.g();
        this.f56953i = g2;
        return g2;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            SkinManager.setBackgroundColor(this.f56953i, R.color.CAM_X0204);
            o oVar = this.f56952h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56917d = originalThreadInfo;
        this.f56950f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f56951g = aVar;
        o oVar = this.f56952h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0598a interfaceC0598a) {
        super.d(interfaceC0598a);
        o oVar = this.f56952h;
        if (oVar != null) {
            oVar.A(interfaceC0598a);
        }
        View view = this.f56953i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f56952h;
        if (oVar != null) {
            oVar.l(this.f56915b);
        }
    }
}
