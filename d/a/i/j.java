package d.a.i;

import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.R;
import d.a.i0.r.q.a2;
/* loaded from: classes.dex */
public class j extends c implements p<a2>, q {

    /* renamed from: i  reason: collision with root package name */
    public FollowUserDecorView f47711i;
    public boolean j = true;
    public int k = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds166);
    public int l = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);

    public j(TbPageContext tbPageContext, boolean z) {
        FollowUserDecorView followUserDecorView = new FollowUserDecorView(tbPageContext.getPageActivity());
        this.f47711i = followUserDecorView;
        followUserDecorView.setUseNewStyle(z);
        h(-1);
        m(z);
    }

    public void k(d.a.i0.r.q.a aVar, boolean z) {
        this.j = z;
        s(0);
        o(true);
    }

    public final int l(int i2) {
        return d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), i2);
    }

    public final void m(boolean z) {
        if (z) {
            this.k = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
            this.l = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds76);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.k, this.l);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = l(R.dimen.tbds50);
        if (z) {
            layoutParams.topMargin = l(R.dimen.tbds52);
        }
        i(layoutParams);
        g(this.f47711i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: n */
    public void a(a2 a2Var) {
        if (a2Var != null && a2Var.T() != null) {
            p(l(this.j ? R.dimen.tbds120 : R.dimen.tbds44));
            this.f47711i.setVisibility(0);
            this.f47711i.setData(a2Var);
            this.f47711i.setTag(a2Var);
            return;
        }
        this.f47711i.setVisibility(8);
    }

    public void o(boolean z) {
        this.f47711i.setClickableUnLike(z);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.f47711i.r(i2);
    }

    public void p(int i2) {
        if (d() != null) {
            d().rightMargin = i2;
        }
        this.f47711i.setLayoutParams(d());
    }

    public void q(FollowUserButton.a aVar) {
        this.f47711i.setOnClickEvent(aVar);
    }

    public void r(BdUniqueId bdUniqueId) {
        this.f47711i.setPageUniqueId(bdUniqueId);
    }

    public void s(int i2) {
        this.f47711i.setSvgIconResId(i2);
    }
}
