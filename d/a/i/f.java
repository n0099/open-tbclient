package d.a.i;

import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.i0.r.q.a2;
/* loaded from: classes.dex */
public class f extends c implements p<a2>, q {

    /* renamed from: i  reason: collision with root package name */
    public final CardForumHeadLayout f47704i;
    public int j = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    public int k = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    public int l = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public f(TbPageContext tbPageContext) {
        this.f47704i = new CardForumHeadLayout(tbPageContext.getPageActivity());
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.k;
        layoutParams.topMargin = this.j;
        layoutParams.bottomMargin = this.l;
        i(layoutParams);
        g(this.f47704i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: k */
    public void a(a2 a2Var) {
        if (a2Var != null && a2Var.T() != null) {
            this.f47704i.setVisibility(0);
            this.f47704i.setData(a2Var);
            this.f47704i.setTag(a2Var);
            return;
        }
        this.f47704i.setVisibility(8);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.f47704i.b();
    }
}
