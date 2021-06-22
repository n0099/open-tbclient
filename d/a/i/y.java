package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.i.v0.a;
/* loaded from: classes.dex */
public class y extends d.a.i.a<d.a.n0.r.q.a> {
    public MutiImgSingleVerticalLayout j;
    public d.a.n0.r.q.a k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0602a c0602a) {
            if (y.this.k != null && y.this.k.i() != null) {
                d.a.o0.z.m.a(y.this.k.i().o0());
                y yVar = y.this;
                d.a.o0.z.m.l(yVar.j.f4480e, yVar.k.i().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                y yVar2 = y.this;
                d.a.o0.z.m.l(yVar2.j.f4481f, yVar2.k.i().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public y(Context context) {
        super(context);
        this.l = 3;
        this.j = new MutiImgSingleVerticalLayout(context);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.a
    public void h() {
        i(1, new a());
    }

    @Override // d.a.i.a
    public void l(d.a.o0.z.b0<d.a.n0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.l = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: p */
    public void a(d.a.n0.r.q.a aVar) {
        this.k = aVar;
        this.j.setFrom(this.m);
        this.j.a(aVar);
    }

    public void q(String str) {
        this.m = str;
    }

    public void r(boolean z) {
        this.j.setFromCDN(z);
    }

    public void s(boolean z) {
        this.j.setNeedFrsTabName(z);
    }
}
