package d.a.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.RecommendInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f0 extends h {
    public RecommendInfoLayout l;

    public f0(Context context) {
        super(context);
        int g2 = d.a.c.e.p.l.g(context, R.dimen.M_H_X003);
        int g3 = d.a.c.e.p.l.g(context, d.a.j0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
        r(g2);
        q(g3);
        this.l = new RecommendInfoLayout(context);
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.l.c();
    }

    public void s() {
        if (d.a.j0.b.d.U()) {
            int g2 = d.a.c.e.p.l.g(this.f40316f, R.dimen.M_H_X003);
            int g3 = d.a.c.e.p.l.g(this.f40316f, d.a.j0.b.g.b.c(R.dimen.tbds21, R.dimen.tbds0));
            r(g2);
            q(g3);
            return;
        }
        int g4 = d.a.c.e.p.l.g(this.f40316f, R.dimen.tbds10);
        r(g4);
        q(0);
        u(this.l, g4, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: t */
    public void a(d.a.j0.r.q.a aVar) {
        this.l.setData(aVar);
    }

    public void u(View view, int i2, int i3) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin == i2 && marginLayoutParams.bottomMargin == i3) {
            return;
        }
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.bottomMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }
}
