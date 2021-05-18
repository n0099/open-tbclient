package d.a.i;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.v0.a;
/* loaded from: classes.dex */
public class o extends h {
    public NewGridImageLayout l;
    public d.a.j0.r.q.a m;
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
            a.InterfaceC0547a interfaceC0547a = oVar.f40319i;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(oVar.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0549a c0549a) {
            if (o.this.m != null && o.this.m.m() != null && !o.this.f().booleanValue()) {
                d.a.k0.x.m.a(o.this.m.m().o0());
                d.a.k0.x.m.l(o.this.l.f4477f, o.this.m.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.a.k0.x.m.l(o.this.l.f4478g, o.this.m.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public o(Context context) {
        super(context);
        this.n = 3;
        this.l = new NewGridImageLayout(context);
    }

    public void A(a.InterfaceC0547a interfaceC0547a) {
        this.f40319i = interfaceC0547a;
    }

    public void B(boolean z) {
        this.l.setNeedFrsTabName(z);
    }

    public void D(d.a.c.e.k.b<ImageView> bVar, d.a.c.e.k.b<GifView> bVar2) {
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

    public void F(int i2, int i3, int i4, int i5) {
        if (f().booleanValue()) {
            this.l.setPadding(i2, i3, i4, i5);
        }
    }

    public void G(boolean z) {
        this.l.p = z;
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.a
    public void h() {
        i(1, new b());
    }

    @Override // d.a.i.a
    public void l(d.a.k0.x.b0<d.a.j0.r.q.a> b0Var) {
        this.l.setSubClickListener(b0Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.n != i2 && f().booleanValue()) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        }
        NewGridImageLayout newGridImageLayout = this.l;
        if (newGridImageLayout != null) {
            newGridImageLayout.p(i2);
        }
        this.n = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: u */
    public void a(d.a.j0.r.q.a aVar) {
        this.m = aVar;
        this.l.setFrom(this.o);
        this.l.setFromForPb(this.p);
        this.l.setTransmit(f().booleanValue());
        this.l.a(aVar);
        this.l.setJumpToPbListener(new a());
    }

    public void v(int i2) {
        this.l.setBackgroundColor(i2);
    }

    public void w(int i2) {
        NewGridImageLayout newGridImageLayout = this.l;
        if (newGridImageLayout != null) {
            newGridImageLayout.setCornerStyle(i2);
        }
    }

    public void x(String str) {
        this.o = str;
    }

    public void y(boolean z) {
        this.l.setFromCDN(z);
    }

    public void z(int i2) {
        this.p = i2;
    }
}
