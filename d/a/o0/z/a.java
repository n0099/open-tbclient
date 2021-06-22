package d.a.o0.z;

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
import d.a.n0.r.q.a;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
/* loaded from: classes4.dex */
public abstract class a<T extends d.a.n0.r.q.a> extends b<T> {
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

    public void A(NEGFeedBackView.b bVar) {
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setEventCallback(bVar);
        }
    }

    public void B(int i2) {
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

    public void F(ViewGroup viewGroup) {
        I(viewGroup, J(viewGroup));
        K(viewGroup);
        H();
        G();
        t();
    }

    public void G() {
        T t = this.o;
        if (t == null || t.i() == null) {
            return;
        }
        a2 i2 = this.o.i();
        this.p.setVisibility(8);
        this.q.setData(i2);
    }

    public final void H() {
        T t = this.o;
        if (t == null || t.i() == null || this.u == null) {
            return;
        }
        if (this.o.q()) {
            this.u.setData(this.o.i());
        } else if (this.v) {
            this.u.setData(this.o.i());
        }
    }

    public final void I(ViewGroup viewGroup, boolean z) {
        T t = this.o;
        if (t == null || t.i() == null) {
            return;
        }
        if (this.t == null) {
            FollowUserDecorView followUserDecorView = new FollowUserDecorView(this.m.getPageActivity());
            this.t = followUserDecorView;
            viewGroup.addView(followUserDecorView);
        }
        if (w()) {
            this.t.setPageUniqueId(this.n);
            this.t.setSvgIconResId(0);
            int u = u(R.dimen.tbds166);
            int u2 = u(R.dimen.tbds78);
            int u3 = u(z ? R.dimen.tbds104 : R.dimen.tbds44);
            int u4 = u(R.dimen.tbds50);
            if (d.a.n0.b.d.V()) {
                u = u(R.dimen.tbds177);
                u2 = u(R.dimen.tbds76);
                u3 = u(z ? R.dimen.tbds126 : R.dimen.tbds44);
                u4 = u(R.dimen.tbds52);
                this.t.setUseNewStyle(true);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(u, u2);
            layoutParams.topMargin = u4;
            layoutParams.rightMargin = u3;
            layoutParams.gravity = 53;
            this.t.setLayoutParams(layoutParams);
            this.t.setData(this.o.i());
            return;
        }
        FollowUserDecorView followUserDecorView2 = this.t;
        if (followUserDecorView2 != null) {
            followUserDecorView2.setVisibility(8);
        }
    }

    public final boolean J(ViewGroup viewGroup) {
        SparseArray<String> sparseArray;
        T t = this.o;
        if (t == null || t.i() == null) {
            return false;
        }
        if (this.o.i() != null && (sparseArray = this.o.feedBackReasonMap) != null && sparseArray.size() > 0) {
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
            v0Var.n(this.o.i().z1());
            v0Var.k(this.o.i().c0());
            v0Var.m(this.o.i().M0());
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

    public final void K(ViewGroup viewGroup) {
        T t = this.o;
        if (t == null || t.i() == null) {
            return;
        }
        if (this.s == null) {
            UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(this.m.getPageActivity());
            this.s = unfollowedDecorView;
            viewGroup.addView(unfollowedDecorView);
        }
        if (this.o.i().W1 && !ThreadCardUtils.isSelf(this.o.i())) {
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
            this.s.a(this.o.i());
            return;
        }
        UnfollowedDecorView unfollowedDecorView2 = this.s;
        if (unfollowedDecorView2 != null) {
            unfollowedDecorView2.setVisibility(8);
        }
    }

    public final void t() {
        ForumEnterLayout forumEnterLayout = this.u;
        if ((forumEnterLayout == null || forumEnterLayout.getVisibility() != 0) && !d.a.n0.b.d.V()) {
            z(this.p, u(R.dimen.tbds20));
            z(this.q, u(R.dimen.tbds20));
            return;
        }
        z(this.p, 0);
        z(this.q, 0);
    }

    public int u(int i2) {
        return d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), i2);
    }

    public void v(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 7;
        eVar.f53783h = 1;
        threadCommentAndPraiseInfoLayout.setAgreeStatisticData(eVar);
    }

    public final boolean w() {
        T t = this.o;
        if (t == null || t.i() == null || this.o.i().T() == null) {
            return false;
        }
        a2 i2 = this.o.i();
        if (ThreadCardUtils.isSelf(i2)) {
            return false;
        }
        boolean z = i2.W1() || i2.R1() || i2.U1();
        if ((!z || !i2.V1) && (!z || !i2.X1 || i2.T().hadConcerned())) {
            if (i2.s1() == null || !d.a.o0.z.e0.j.i0(i2)) {
                return false;
            }
            if (!i2.V1 && !i2.Y1) {
                return false;
            }
        }
        return true;
    }

    public void x(TbPageContext<?> tbPageContext, int i2) {
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
            unfollowedDecorView.l();
        }
        ForumEnterLayout forumEnterLayout = this.u;
        if (forumEnterLayout != null) {
            forumEnterLayout.n(tbPageContext, i2);
        }
        FollowUserDecorView followUserDecorView = this.t;
        if (followUserDecorView != null) {
            followUserDecorView.r(i2);
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        q(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.r;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        FollowUserDecorView followUserDecorView = this.t;
        if (followUserDecorView != null) {
            followUserDecorView.setPageUniqueId(bdUniqueId);
        }
    }

    public void z(View view, int i2) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin != i2) {
            marginLayoutParams.topMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
