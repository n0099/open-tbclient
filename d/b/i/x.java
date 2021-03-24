package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MutiImgSingleHorizontalLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class x extends a<d.b.h0.r.q.a> {
    public MutiImgSingleHorizontalLayout j;
    public int k;

    public x(Context context) {
        super(context);
        this.k = 3;
        this.j = new MutiImgSingleHorizontalLayout(context);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.a
    public void h() {
    }

    @Override // d.b.i.a
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: o */
    public void a(d.b.h0.r.q.a aVar) {
        this.j.a(aVar);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.k = i;
    }

    public void p(String str) {
    }

    public void q(boolean z) {
        this.j.setFromCDN(z);
    }
}
