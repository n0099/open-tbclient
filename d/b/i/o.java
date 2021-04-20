package d.b.i;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import d.b.i.a;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public class o extends h {
    public NewGridImageLayout l;
    public d.b.h0.r.q.a m;
    public int n;
    public String o;
    public int p;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o oVar = o.this;
            a.InterfaceC1129a interfaceC1129a = oVar.i;
            if (interfaceC1129a != null) {
                interfaceC1129a.a(oVar.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1131a c1131a) {
            if (o.this.m != null && o.this.m.n() != null && !o.this.f().booleanValue()) {
                d.b.i0.x.m.a(o.this.m.n().o0());
                d.b.i0.x.m.l(o.this.l.f4530f, o.this.m.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.b.i0.x.m.l(o.this.l.f4531g, o.this.m.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public o(Context context) {
        super(context);
        this.n = 3;
        this.l = new NewGridImageLayout(context);
    }

    public void A(a.InterfaceC1129a interfaceC1129a) {
        this.i = interfaceC1129a;
    }

    public void B(boolean z) {
        this.l.setNeedFrsTabName(z);
    }

    public void C(d.b.c.e.k.b<ImageView> bVar, d.b.c.e.k.b<GifView> bVar2) {
        NewGridImageLayout newGridImageLayout = this.l;
        if (newGridImageLayout != null) {
            newGridImageLayout.setObjectPool(bVar, bVar2);
        }
    }

    public void E(boolean z) {
        GridImageLayout gridImageLayout;
        NewGridImageLayout newGridImageLayout = this.l;
        if (newGridImageLayout == null || (gridImageLayout = newGridImageLayout.j) == null) {
            return;
        }
        gridImageLayout.setIsTransform(z);
    }

    public void F(int i, int i2, int i3, int i4) {
        if (f().booleanValue()) {
            this.l.setPadding(i, i2, i3, i4);
        }
    }

    public void G(boolean z) {
        this.l.p = z;
    }

    @Override // d.b.i.a
    public View g() {
        return this.l;
    }

    @Override // d.b.i.a
    public void h() {
        i(1, new b());
    }

    @Override // d.b.i.a
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        this.l.setSubClickListener(b0Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.n != i && f().booleanValue()) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        }
        NewGridImageLayout newGridImageLayout = this.l;
        if (newGridImageLayout != null) {
            newGridImageLayout.p(i);
        }
        this.n = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: u */
    public void a(d.b.h0.r.q.a aVar) {
        this.m = aVar;
        this.l.setFrom(this.o);
        this.l.setFromForPb(this.p);
        this.l.setTransmit(f().booleanValue());
        this.l.a(aVar);
        this.l.setJumpToPbListener(new a());
    }

    public void v(int i) {
        this.l.setBackgroundColor(i);
    }

    public void w(int i) {
        NewGridImageLayout newGridImageLayout = this.l;
        if (newGridImageLayout != null) {
            newGridImageLayout.setCornerStyle(i);
        }
    }

    public void x(String str) {
        this.o = str;
    }

    public void y(boolean z) {
        this.l.setFromCDN(z);
    }

    public void z(int i) {
        this.p = i;
    }
}
