package d.b.i;

import android.widget.RelativeLayout;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
/* loaded from: classes.dex */
public class f extends c implements p<a2>, q {
    public final CardForumHeadLayout i;
    public int j = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    public int k = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    public int l = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);

    public f(TbPageContext tbPageContext) {
        this.i = new CardForumHeadLayout(tbPageContext.getPageActivity());
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.k;
        layoutParams.topMargin = this.j;
        layoutParams.bottomMargin = this.l;
        i(layoutParams);
        g(this.i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: k */
    public void a(a2 a2Var) {
        if (a2Var != null && a2Var.T() != null) {
            this.i.setVisibility(0);
            this.i.setData(a2Var);
            this.i.setTag(a2Var);
            return;
        }
        this.i.setVisibility(8);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.i.b();
    }
}
