package d.b.j0.t.i.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.z0.i0;
import d.b.j0.x.m;
import d.b.j0.x.z;
/* loaded from: classes4.dex */
public class c extends d.b.j0.x.a<a2> implements z, d.b.j0.m.e {
    public TextView A;
    public HeadImageView B;
    public TextView C;
    public AlaVideoContainer D;
    public RelativeLayout E;
    public LinearLayout F;
    public ThreadSourceShareAndPraiseLayout G;
    public View H;
    public String I;
    public String J;
    public View K;
    public final View.OnClickListener L;
    public LinearLayout w;
    public RelativeLayout x;
    public CardUserInfoLayout y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.i() != null) {
                c.this.i().a(view, c.this.o);
            }
        }
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.L = new a();
        r(bdUniqueId);
        this.m = tbPageContext;
        View m = m();
        RelativeLayout relativeLayout = (RelativeLayout) m.findViewById(R.id.layout_root);
        this.x = relativeLayout;
        relativeLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) m.findViewById(R.id.video_card_content_layout);
        this.w = linearLayout;
        linearLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) m.findViewById(R.id.ala_share_container);
        this.E = relativeLayout2;
        this.F = (LinearLayout) relativeLayout2.findViewById(R.id.challenge_root);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) m.findViewById(R.id.card_ala_video_user_info_layout);
        this.y = cardUserInfoLayout;
        cardUserInfoLayout.setShowFlag(6141);
        HeadImageView headImageView = (HeadImageView) m.findViewById(R.id.ala_share_live_user_pendant_header);
        this.B = headImageView;
        headImageView.setIsRound(true);
        this.B.setDrawBorder(false);
        this.B.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.B.setAutoChangeStyle(false);
        this.C = (TextView) m.findViewById(R.id.ala_share_live_username_text);
        this.z = (TextView) m.findViewById(R.id.text_title);
        this.A = (TextView) m.findViewById(R.id.ala_live_room_title);
        AlaVideoContainer alaVideoContainer = (AlaVideoContainer) m.findViewById(R.id.ala_video_container);
        this.D = alaVideoContainer;
        alaVideoContainer.setOnVideoClickListener(this);
        View findViewById = m.findViewById(R.id.thread_multi_del_mask_view);
        this.K = findViewById;
        findViewById.setClickable(true);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) m.findViewById(R.id.text_bottom);
        this.p = threadCommentAndPraiseInfoLayout;
        w(threadCommentAndPraiseInfoLayout);
        this.p.setSelectVisible(false);
        this.p.setIsBarViewVisible(false);
        this.p.setCommentNumEnable(true);
        this.p.setLiveShareEnable(false);
        this.p.setFrom(2);
        this.p.getCommentContainer().setOnClickListener(this);
        this.p.hideDisagree();
        this.p.setShareReportFrom(1);
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 2;
        eVar.f51512h = 2;
        this.p.setAgreeStatisticData(eVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) m.findViewById(R.id.card_bottom_op_weight_layout);
        this.q = threadCommentAndPraiseInfoLayout2;
        w(threadCommentAndPraiseInfoLayout2);
        this.q.setFrom(2);
        this.q.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) m.findViewById(R.id.text_bottom_2);
        this.G = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f13205f.setOnClickListener(this);
        this.G.f13205f.getCommentContainer().setOnClickListener(this);
        this.G.setFrom(2);
        this.G.setShareReportFrom(1);
        this.G.setSourceFromForPb(3);
        this.G.setStType("frs_page");
        this.G.setHideBarName(true);
        this.H = m.findViewById(R.id.divider_below_reply_number_layout);
        this.D.setLigvingLogLayoutVisible(8);
    }

    public final void O() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
        if (this.z.getVisibility() == 0) {
            layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        } else {
            layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32);
        }
        this.E.setLayoutParams(layoutParams);
    }

    public ThreadCommentAndPraiseInfoLayout P() {
        return this.p;
    }

    public int Q(int i) {
        return d.b.j0.m.d.c().b(this.J, i);
    }

    public ThreadCommentAndPraiseInfoLayout R() {
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.G;
        if (threadSourceShareAndPraiseLayout != null) {
            return threadSourceShareAndPraiseLayout.f13205f;
        }
        return null;
    }

    public void S(TbPageContext<?> tbPageContext) {
        T t;
        if (tbPageContext == null || (t = this.o) == 0 || ((a2) t).q1() == null) {
            return;
        }
        if (!j.z()) {
            l.K(tbPageContext.getPageActivity(), R.string.no_network_guide);
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(((a2) this.o).q1());
        if (((a2) this.o).q1().user_info != null) {
            alaLiveInfoCoreData.userName = ((a2) this.o).q1().user_info.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_FRS_SHARE_LIVE, "", false, this.I)));
    }

    public final void T(TbPageContext<?> tbPageContext) {
        T t = this.o;
        if (t == 0 || ((a2) t).q1() == null || ((a2) this.o).q1().share_info == null) {
            return;
        }
        if (((a2) this.o).q1().share_info.record_tid <= 0) {
            S(this.f64177f);
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(String.valueOf(((a2) this.o).q1().share_info.record_tid), null, "frs_page");
        createNormalCfg.setVideo_source(((a2) this.o).X1() ? "floor5" : "frs");
        createNormalCfg.setFromSmartFrs(((a2) this.o).t2());
        createNormalCfg.setSmartFrsPosition(((a2) this.o).k1());
        createNormalCfg.setStartFrom(3);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: U */
    public void n(a2 a2Var) {
        this.o = a2Var;
        V();
    }

    public final void V() {
        T t = this.o;
        int i = 8;
        if (t != 0 && ((a2) t).T() != null) {
            this.x.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.x.getLayoutParams();
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.bottomMargin = 0;
            this.y.setData((a2) this.o);
            this.y.setUserAfterClickListener(this.L);
            this.D.getController().d((a2) this.o, this.I, "", false);
            this.D.getController().c();
            if (((a2) this.o).q1() != null && ((a2) this.o).q1().share_info != null && !StringUtils.isNull(((a2) this.o).q1().share_info.content)) {
                this.z.setVisibility(0);
                this.z.setText(((a2) this.o).q1().share_info.content);
            } else {
                this.z.setVisibility(8);
            }
            if (((a2) this.o).q1() != null && ((a2) this.o).q1().user_info != null) {
                String str = ((a2) this.o).q1().user_info.user_name;
                if (i0.d(str) > 14) {
                    str = i0.m(str, 14) + StringHelper.STRING_MORE;
                }
                this.C.setText(str + ":");
                if (TextUtils.isEmpty(((a2) this.o).q1().user_info.portrait)) {
                    this.B.setPlaceHolder(1);
                } else {
                    this.B.X(((a2) this.o).q1().user_info.portrait, 10, false, false);
                }
            }
            String x1 = ((a2) this.o).x1();
            if (!StringUtils.isNull(x1)) {
                this.A.setText(x1);
                this.A.setVisibility(0);
            } else {
                this.A.setVisibility(8);
            }
            X(Q(1));
            if (((a2) this.o).q1().mChallengeInfoData != null && ((a2) this.o).q1().mChallengeInfoData.challenge_id > 0) {
                this.F.setVisibility(0);
            } else {
                this.F.setVisibility(8);
            }
            this.K.setVisibility((d.b.j0.q0.b.e().g() || d.b.j0.q0.a.h().j()) ? 0 : 0);
            F(this.x);
            o(l(), TbadkCoreApplication.getInst().getSkinType());
            O();
            return;
        }
        this.x.setVisibility(8);
    }

    public void W(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        r(bdUniqueId);
        z(bdUniqueId);
    }

    public void X(int i) {
        T t = this.o;
        if (t == 0) {
            return;
        }
        if (i == 1) {
            this.p.setVisibility(8);
            this.G.g((a2) this.o);
            return;
        }
        this.p.setData((a2) t);
        this.G.setVisibility(8);
    }

    @Override // d.b.j0.x.z
    public void a(String str) {
        this.I = str;
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.frs_ala_share_live_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f64176e != i) {
            y(tbPageContext, i);
            d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.x);
            d2.k(R.string.J_X06);
            d2.g(R.color.CAM_X0205, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.E, R.color.CAM_X0204);
            AlaVideoContainer alaVideoContainer = this.D;
            if (alaVideoContainer != null) {
                alaVideoContainer.o(i);
            }
            this.y.onChangeSkinType(l(), TbadkCoreApplication.getInst().getSkinType());
            this.p.onChangeSkinType();
            this.f64176e = i;
            HeadImageView headImageView = this.B;
            if (headImageView != null) {
                headImageView.setPlaceHolder(1);
            }
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.G;
            if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                this.G.f();
            }
        }
        T t = this.o;
        if (t != 0 && m.k(((a2) t).o0())) {
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
        }
        SkinManager.setBackgroundColor(this.K, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (d.b.j0.q0.b.e().g() || d.b.j0.q0.a.h().j()) {
            return;
        }
        int i = 1;
        if (view != this.x && view != this.p.getCommentContainer() && this.w != view && view != this.G.f13205f.getCommentContainer() && view != this.q.getCommentContainer()) {
            if (view.getId() == R.id.video_container) {
                if (i() != null) {
                    i().a(view, this.o);
                }
                TiebaStatic.log(new StatisticItem("c12323"));
                if (((a2) this.o).q1().live_status == 1) {
                    S(this.f64177f);
                    return;
                } else {
                    T(this.f64177f);
                    return;
                }
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((a2) t).o0());
        }
        if (i() != null) {
            i().a(this.x, this.o);
        }
        TiebaStatic.log(new StatisticItem("c12323"));
        if (((a2) this.o).q1().live_status == 1) {
            S(this.f64177f);
            i = 5;
        } else {
            T(this.f64177f);
        }
        if (view == this.p.getCommentContainer() || view == this.G.f13205f.getCommentContainer()) {
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 2);
            statisticItem.param("tid", ((a2) this.o).w1());
            statisticItem.param("obj_type", i);
            statisticItem.param("nid", ((a2) this.o).L0());
            d.b.i0.i0.c f2 = TbPageExtraHelper.f(view);
            if (f2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.b.j0.x.z
    public void p(int i) {
    }

    @Override // d.b.j0.m.e
    public void setPage(String str) {
        this.J = str;
    }
}
