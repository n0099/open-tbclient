package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MutiImgSingleHorizontalLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class x extends a<d.a.n0.r.q.a> {
    public MutiImgSingleHorizontalLayout j;
    public int k;

    public x(Context context) {
        super(context);
        this.k = 3;
        this.j = new MutiImgSingleHorizontalLayout(context);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.a
    public void h() {
    }

    @Override // d.a.i.a
    public void l(d.a.o0.z.b0<d.a.n0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(d.a.n0.r.q.a aVar) {
        this.j.a(aVar);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.k = i2;
    }

    public void p(String str) {
    }

    public void q(boolean z) {
        this.j.setFromCDN(z);
    }
}
