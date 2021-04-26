package d.a.j0.x;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.a.i0.r.q.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
/* loaded from: classes4.dex */
public abstract class a<T extends d.a.i0.r.q.a> extends b<T> {
    public TbPageContext<?> m;
    public BdUniqueId n;
    public T o;
    public ThreadCommentAndPraiseInfoLayout p;
    public ThreadCommentAndPraiseInfoLayout q;
    public NEGFeedBackView r;
    public UnfollowedDecorView s;
    public FollowUserDecorView t;
    public ForumEnterLayout u;
    public boolean v;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.r = null;
        this.s = null;
        this.v = false;
    }

    public void A(int i2) {
        this.l = i2;
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.R = i2;
        }
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.q;
        if (threadCommentAndPraiseInfoLayout2 != null) {
            threadCommentAndPraiseInfoLayout2.R = i2;
        }
    }

    public void B(ViewGroup viewGroup) {
        H(viewGroup, I(viewGroup));
        J(viewGroup);
        G();
        F();
        s();
    }

    public void F() {
        T t = this.o;
        if (t == null || t.m() == null) {
            return;
        }
        a2 m = this.o.m();
        this.p.setVisibility(8);
        this.q.setData(m);
    }

    public final void G() {
        T t = this.o;
        if (t == null || t.m() == null || this.u == null) {
            return;
        }
        if (this.o.u()) {
            this.u.setData(this.o.m());
        } else if (this.v) {
            this.u.setData(this.o.m());
        }
    }

    public final void H(ViewGroup viewGroup, boolean z) {
        T t = this.o;
        if (t == null || t.m() == null) {
            return;
        }
        if (this.t == null) {
            FollowUserDecorView followUserDecorView = new FollowUserDecorView(this.m.getPageActivity());
            this.t = followUserDecorView;
            viewGroup.addView(followUserDecorView);
        }
        if (v()) {
            this.t.setPageUniqueId(this.n);
            this.t.setSvgIconResId(0);
            int t2 = t(R.dimen.tbds166);
            int t3 = t(R.dimen.tbds78);
            int t4 = t(z ? R.dimen.tbds104 : R.dimen.tbds44);
            int t5 = t(R.dimen.tbds50);
            if (d.a.i0.b.d.T()) {
                t2 = t(R.dimen.tbds177);
                t3 = t(R.dimen.tbds76);
                t4 = t(z ? R.dimen.tbds126 : R.dimen.tbds44);
                t5 = t(R.dimen.tbds52);
                this.t.setUseNewStyle(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(t2, t3);
            layoutParams.topMargin = t5;
            layoutParams.rightMargin = t4;
            layoutParams.gravity = 53;
            this.t.setLayoutParams(layoutParams);
            this.t.setData(this.o.m());
            return;
        }
        FollowUserDecorView followUserDecorView2 = this.t;
        if (followUserDecorView2 != null) {
            followUserDecorView2.setVisibility(8);
        }
    }

    public final boolean I(ViewGroup viewGroup) {
        SparseArray<String> sparseArray;
        T t = this.o;
        if (t == null || t.m() == null) {
            return false;
        }
        if (this.o.m() != null && (sparseArray = this.o.feedBackReasonMap) != null && sparseArray.size() > 0) {
            if (this.r == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(k());
                this.r = nEGFeedBackView;
                viewGroup.addView(nEGFeedBackView);
            }
            this.r.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g5 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.rightMargin = g4;
            layoutParams.topMargin = g5;
            layoutParams.gravity = 53;
            this.r.setPadding(g3, g3, g3, g3);
            this.r.setLayoutParams(layoutParams);
            v0 v0Var = new v0();
            v0Var.n(this.o.m().w1());
            v0Var.k(this.o.m().c0());
            v0Var.m(this.o.m().L0());
            v0Var.j(this.o.feedBackReasonMap);
            this.r.setVisibility(0);
            this.r.setData(v0Var);
            this.r.setFirstRowSingleColumn(true);
            return true;
        }
        NEGFeedBackView nEGFeedBackView2 = this.r;
        if (nEGFeedBackView2 != null) {
            nEGFeedBackView2.setVisibility(8);
            return false;
        }
        return false;
    }

    public final void J(ViewGroup viewGroup) {
        T t = this.o;
        if (t == null || t.m() == null) {
            return;
        }
        if (this.s == null) {
            UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(this.m.getPageActivity());
            this.s = unfollowedDecorView;
            viewGroup.addView(unfollowedDecorView);
        }
        if (this.o.m().U1 && !ThreadCardUtils.isSelf(this.o.m())) {
            this.s.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g5 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.rightMargin = g4;
            layoutParams.topMargin = g5;
            layoutParams.gravity = 53;
            this.s.setPadding(g3, g3, g3, g3);
            this.s.setLayoutParams(layoutParams);
            this.s.setVisibility(0);
            this.s.a(this.o.m());
            return;
        }
        UnfollowedDecorView unfollowedDecorView2 = this.s;
        if (unfollowedDecorView2 != null) {
            unfollowedDecorView2.setVisibility(8);
        }
    }

    public final void s() {
        ForumEnterLayout forumEnterLayout = this.u;
        if ((forumEnterLayout == null || forumEnterLayout.getVisibility() != 0) && !d.a.i0.b.d.T()) {
            y(this.p, t(R.dimen.tbds20));
            y(this.q, t(R.dimen.tbds20));
            return;
        }
        y(this.p, 0);
        y(this.q, 0);
    }

    public int t(int i2) {
        return d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), i2);
    }

    public void u(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        if (threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnClickListener(this);
        threadCommentAndPraiseInfoLayout.setReplyTimeVisible(false);
        threadCommentAndPraiseInfoLayout.setShowPraiseNum(true);
        threadCommentAndPraiseInfoLayout.setCommentNumEnable(true);
        threadCommentAndPraiseInfoLayout.setNeedAddReplyIcon(true);
        threadCommentAndPraiseInfoLayout.setNeedAddPraiseIcon(true);
        if (threadCommentAndPraiseInfoLayout.getCommentContainer() != null) {
            threadCommentAndPraiseInfoLayout.getCommentContainer().setOnClickListener(this);
        }
        threadCommentAndPraiseInfoLayout.setShareVisible(true);
        threadCommentAndPraiseInfoLayout.setFrom(7);
        threadCommentAndPraiseInfoLayout.setShareReportFrom(3);
        threadCommentAndPraiseInfoLayout.hideDisagree();
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 7;
        eVar.f49137h = 1;
        threadCommentAndPraiseInfoLayout.setAgreeStatisticData(eVar);
    }

    public final boolean v() {
        T t = this.o;
        if (t == null || t.m() == null || this.o.m().T() == null) {
            return false;
        }
        a2 m = this.o.m();
        if (ThreadCardUtils.isSelf(m)) {
            return false;
        }
        boolean z = m.T1() || m.O1() || m.R1();
        return (z && m.T1) || (z && m.V1 && !m.T().hadConcerned()) || (m.q1() != null && d.a.j0.x.e0.j.i0(m) && m.T1);
    }

    public void w(TbPageContext<?> tbPageContext, int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.onChangeSkinType();
        }
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.q;
        if (threadCommentAndPraiseInfoLayout2 != null) {
            threadCommentAndPraiseInfoLayout2.onChangeSkinType();
        }
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.q();
        }
        UnfollowedDecorView unfollowedDecorView = this.s;
        if (unfollowedDecorView != null) {
            unfollowedDecorView.i();
        }
        ForumEnterLayout forumEnterLayout = this.u;
        if (forumEnterLayout != null) {
            forumEnterLayout.m(tbPageContext, i2);
        }
        FollowUserDecorView followUserDecorView = this.t;
        if (followUserDecorView != null) {
            followUserDecorView.r(i2);
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        p(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        FollowUserDecorView followUserDecorView = this.t;
        if (followUserDecorView != null) {
            followUserDecorView.setPageUniqueId(bdUniqueId);
        }
    }

    public void y(View view, int i2) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin != i2) {
            marginLayoutParams.topMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void z(NEGFeedBackView.b bVar) {
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setEventCallback(bVar);
        }
    }
}
