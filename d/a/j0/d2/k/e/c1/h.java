package d.a.j0.d2.k.e.c1;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.o;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public class h extends d.a.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public a2 f52302f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.q.a f52303g;

    /* renamed from: h  reason: collision with root package name */
    public o f52304h;

    /* renamed from: i  reason: collision with root package name */
    public View f52305i;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public a2 m() {
            return h.this.f52302f;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = h.this;
            a.InterfaceC1009a interfaceC1009a = hVar.f52268c;
            if (interfaceC1009a != null) {
                interfaceC1009a.a(hVar.f52303g);
            }
        }
    }

    public h(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public View a() {
        if (this.f52304h == null) {
            o oVar = new o(this.f52266a.getPageActivity());
            this.f52304h = oVar;
            oVar.n(Boolean.TRUE);
            this.f52304h.x("pb");
            this.f52304h.z(0);
            this.f52304h.F(this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.f52266a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f52304h.G(false);
            this.f52304h.E(true);
        }
        View g2 = this.f52304h.g();
        this.f52305i = g2;
        return g2;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52270e != i2) {
            this.f52270e = i2;
            SkinManager.setBackgroundColor(this.f52305i, R.color.CAM_X0204);
            o oVar = this.f52304h;
            if (oVar != null) {
                oVar.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52269d = originalThreadInfo;
        this.f52302f = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52303g = aVar;
        o oVar = this.f52304h;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1009a interfaceC1009a) {
        super.d(interfaceC1009a);
        o oVar = this.f52304h;
        if (oVar != null) {
            oVar.A(interfaceC1009a);
        }
        View view = this.f52305i;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o oVar = this.f52304h;
        if (oVar != null) {
            oVar.l(this.f52267b);
        }
    }
}
