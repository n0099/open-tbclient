package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.i.u0.a;
/* loaded from: classes2.dex */
public class y extends d.b.i.a<d.b.h0.r.q.a> {
    public MutiImgSingleVerticalLayout j;
    public d.b.h0.r.q.a k;
    public int l;
    public String m;

    /* loaded from: classes2.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1117a c1117a) {
            if (y.this.k != null && y.this.k.n() != null) {
                d.b.i0.x.m.a(y.this.k.n().o0());
                y yVar = y.this;
                d.b.i0.x.m.l(yVar.j.f4477e, yVar.k.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                y yVar2 = y.this;
                d.b.i0.x.m.l(yVar2.j.f4478f, yVar2.k.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public y(Context context) {
        super(context);
        this.l = 3;
        this.j = new MutiImgSingleVerticalLayout(context);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.a
    public void h() {
        i(1, new a());
    }

    @Override // d.b.i.a
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.l = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: p */
    public void a(d.b.h0.r.q.a aVar) {
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
