package d.b.i;

import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
import d.b.i0.r.q.a2;
/* loaded from: classes.dex */
public class j extends c implements p<a2>, q {
    public FollowUserDecorView i;
    public boolean j = true;
    public int k = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    public int l = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public j(TbPageContext tbPageContext, boolean z) {
        FollowUserDecorView followUserDecorView = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.i = followUserDecorView;
        followUserDecorView.setUseNewStyle(z);
        h(-1);
        m(z);
    }

    public void k(d.b.i0.r.q.a aVar, boolean z) {
        this.j = z;
        s(0);
        o(true);
    }

    public final int l(int i) {
        return d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), i);
    }

    public final void m(boolean z) {
        if (z) {
            this.k = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.l = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds76);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.k, this.l);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = l(R.dimen.tbds50);
        if (z) {
            layoutParams.topMargin = l(R.dimen.tbds52);
        }
        i(layoutParams);
        g(this.i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: n */
    public void a(a2 a2Var) {
        if (a2Var != null && a2Var.T() != null) {
            p(l(this.j ? R.dimen.tbds120 : R.dimen.tbds44));
            this.i.setVisibility(0);
            this.i.setData(a2Var);
            this.i.setTag(a2Var);
            return;
        }
        this.i.setVisibility(8);
    }

    public void o(boolean z) {
        this.i.setClickableUnLike(z);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.i.r(i);
    }

    public void p(int i) {
        if (d() != null) {
            d().rightMargin = i;
        }
        this.i.setLayoutParams(d());
    }

    public void q(FollowUserButton.a aVar) {
        this.i.setOnClickEvent(aVar);
    }

    public void r(BdUniqueId bdUniqueId) {
        this.i.setPageUniqueId(bdUniqueId);
    }

    public void s(int i) {
        this.i.setSvgIconResId(i);
    }
}
