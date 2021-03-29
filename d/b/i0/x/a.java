package d.b.i0.x;

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
import d.b.h0.r.q.a;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
/* loaded from: classes4.dex */
public abstract class a<T extends d.b.h0.r.q.a> extends b<T> {
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

    public void A(View view, int i) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin != i) {
            marginLayoutParams.topMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void B(NEGFeedBackView.b bVar) {
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setEventCallback(bVar);
        }
    }

    public void E(int i) {
        this.l = i;
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.R = i;
        }
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.q;
        if (threadCommentAndPraiseInfoLayout2 != null) {
            threadCommentAndPraiseInfoLayout2.R = i;
        }
    }

    public void F(ViewGroup viewGroup) {
        J(viewGroup, K(viewGroup));
        L(viewGroup);
        I();
        G();
        u();
    }

    public void G() {
        T t = this.o;
        if (t == null || t.n() == null) {
            return;
        }
        a2 n = this.o.n();
        this.p.setVisibility(8);
        this.q.setData(n);
    }

    public final void I() {
        T t = this.o;
        if (t == null || t.n() == null || this.u == null) {
            return;
        }
        if (this.o.u()) {
            this.u.setData(this.o.n());
        } else if (this.v) {
            this.u.setData(this.o.n());
        }
    }

    public final void J(ViewGroup viewGroup, boolean z) {
        T t = this.o;
        if (t == null || t.n() == null) {
            return;
        }
        if (this.t == null) {
            FollowUserDecorView followUserDecorView = new FollowUserDecorView(this.m.getPageActivity());
            this.t = followUserDecorView;
            viewGroup.addView(followUserDecorView);
        }
        if (x()) {
            this.t.setPageUniqueId(this.n);
            this.t.setSvgIconResId(0);
            int v = v(R.dimen.tbds166);
            int v2 = v(R.dimen.tbds78);
            int v3 = v(z ? R.dimen.tbds104 : R.dimen.tbds44);
            int v4 = v(R.dimen.tbds50);
            if (d.b.h0.b.d.R()) {
                v = v(R.dimen.tbds177);
                v2 = v(R.dimen.tbds76);
                v3 = v(z ? R.dimen.tbds126 : R.dimen.tbds44);
                v4 = v(R.dimen.tbds52);
                this.t.setUseNewStyle(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(v, v2);
            layoutParams.topMargin = v4;
            layoutParams.rightMargin = v3;
            layoutParams.gravity = 53;
            this.t.setLayoutParams(layoutParams);
            this.t.setData(this.o.n());
            return;
        }
        FollowUserDecorView followUserDecorView2 = this.t;
        if (followUserDecorView2 != null) {
            followUserDecorView2.setVisibility(8);
        }
    }

    public final boolean K(ViewGroup viewGroup) {
        SparseArray<String> sparseArray;
        T t = this.o;
        if (t == null || t.n() == null) {
            return false;
        }
        if (this.o.n() != null && (sparseArray = this.o.feedBackReasonMap) != null && sparseArray.size() > 0) {
            if (this.r == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(l());
                this.r = nEGFeedBackView;
                viewGroup.addView(nEGFeedBackView);
            }
            this.r.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int g3 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g5 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.rightMargin = g4;
            layoutParams.topMargin = g5;
            layoutParams.gravity = 53;
            this.r.setPadding(g3, g3, g3, g3);
            this.r.setLayoutParams(layoutParams);
            v0 v0Var = new v0();
            v0Var.n(this.o.n().w1());
            v0Var.k(this.o.n().c0());
            v0Var.m(this.o.n().L0());
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

    public final void L(ViewGroup viewGroup) {
        T t = this.o;
        if (t == null || t.n() == null) {
            return;
        }
        if (this.s == null) {
            UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(this.m.getPageActivity());
            this.s = unfollowedDecorView;
            viewGroup.addView(unfollowedDecorView);
        }
        if (this.o.n().U1 && !ThreadCardUtils.isSelf(this.o.n())) {
            this.s.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds90);
            int g3 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g5 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, g2);
            layoutParams.rightMargin = g4;
            layoutParams.topMargin = g5;
            layoutParams.gravity = 53;
            this.s.setPadding(g3, g3, g3, g3);
            this.s.setLayoutParams(layoutParams);
            this.s.setVisibility(0);
            this.s.a(this.o.n());
            return;
        }
        UnfollowedDecorView unfollowedDecorView2 = this.s;
        if (unfollowedDecorView2 != null) {
            unfollowedDecorView2.setVisibility(8);
        }
    }

    public final void u() {
        ForumEnterLayout forumEnterLayout = this.u;
        if ((forumEnterLayout == null || forumEnterLayout.getVisibility() != 0) && !d.b.h0.b.d.R()) {
            A(this.p, v(R.dimen.tbds20));
            A(this.q, v(R.dimen.tbds20));
            return;
        }
        A(this.p, 0);
        A(this.q, 0);
    }

    public int v(int i) {
        return d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), i);
    }

    public void w(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f50763b = 7;
        eVar.f50769h = 1;
        threadCommentAndPraiseInfoLayout.setAgreeStatisticData(eVar);
    }

    public final boolean x() {
        T t = this.o;
        if (t == null || t.n() == null || this.o.n().T() == null) {
            return false;
        }
        a2 n = this.o.n();
        if (ThreadCardUtils.isSelf(n)) {
            return false;
        }
        boolean z = n.T1() || n.O1() || n.R1();
        return (z && n.T1) || (z && n.V1 && !n.T().hadConcerned()) || (n.q1() != null && d.b.i0.x.e0.j.i0(n) && n.T1);
    }

    public void y(TbPageContext<?> tbPageContext, int i) {
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
            unfollowedDecorView.c();
        }
        ForumEnterLayout forumEnterLayout = this.u;
        if (forumEnterLayout != null) {
            forumEnterLayout.m(tbPageContext, i);
        }
        FollowUserDecorView followUserDecorView = this.t;
        if (followUserDecorView != null) {
            followUserDecorView.r(i);
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        r(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        FollowUserDecorView followUserDecorView = this.t;
        if (followUserDecorView != null) {
            followUserDecorView.setPageUniqueId(bdUniqueId);
        }
    }
}
