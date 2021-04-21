package d.b.j0.t.i.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.k;
import d.b.i0.r.q.a2;
import d.b.j0.x.m;
import d.b.j0.x.z;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class e extends d.b.j0.x.a<a2> implements z, d.b.j0.m.e {
    public ThreadSkinView A;
    public RelativeLayout B;
    public TextView C;
    public TbImageView D;
    public RelativeLayout E;
    public TbImageView F;
    public TBLottieAnimationView G;
    public TextView H;
    public TextView I;
    public LinearLayout J;
    public View K;
    public FrameLayout L;
    public LinearLayout M;
    public TextView N;
    public ImageView O;
    public String P;
    public boolean Q;
    public String R;
    public View S;
    public boolean T;
    public int U;
    public d.b.j0.t.i.d.a V;
    public final View.OnClickListener W;
    public CardUserInfoLayout w;
    public ThreadSourceShareAndPraiseLayout x;
    public View y;
    public LinearLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            e.this.G.playAnimation();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            e.this.G.cancelAnimation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.i() != null) {
                e.this.i().a(view, e.this.o);
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Q = false;
        this.U = 0;
        this.W = new b();
        r(bdUniqueId);
        this.m = tbPageContext;
        View m = m();
        RelativeLayout relativeLayout = (RelativeLayout) m.findViewById(R.id.layout_root);
        this.B = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.z = (LinearLayout) m.findViewById(R.id.video_card_content_layout);
        this.B.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) m.findViewById(R.id.video_card_stage_view);
        this.D = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.D.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) m.findViewById(R.id.card_ala_video_user_info_layout);
        this.w = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.W);
        this.C = (TextView) m.findViewById(R.id.text_title);
        this.E = (RelativeLayout) m.findViewById(R.id.frame_video);
        TbImageView tbImageView2 = (TbImageView) m.findViewById(R.id.image_video);
        this.F = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.F.setPlaceHolder(3);
        this.F.setDefaultResource(0);
        this.F.setRadiusById(R.string.J_X05);
        this.F.setConrers(15);
        this.F.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.F.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.F.setBorderSurroundContent(true);
        this.F.setDrawBorder(true);
        this.J = (LinearLayout) m.findViewById(R.id.ala_live_lottie_bg);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) m.findViewById(R.id.ala_live_lottie);
        this.G = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.G, R.raw.ala_live2);
        this.G.addOnAttachStateChangeListener(new a());
        this.H = (TextView) m.findViewById(R.id.play_count);
        this.I = (TextView) m.findViewById(R.id.ala_live_recom_reason);
        this.K = m.findViewById(R.id.play_count_line);
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
        this.x = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f13205f.setOnClickListener(this);
        this.x.f13205f.getCommentContainer().setOnClickListener(this);
        this.x.setFrom(2);
        this.x.setShareReportFrom(1);
        this.x.setSourceFromForPb(3);
        this.x.setStType("frs_page");
        this.x.setHideBarName(true);
        this.y = m.findViewById(R.id.divider_below_reply_number_layout);
        this.A = (ThreadSkinView) m.findViewById(R.id.frs_thread_skin);
        View findViewById = m.findViewById(R.id.thread_multi_del_mask_view);
        this.S = findViewById;
        findViewById.setClickable(true);
        d.b.j0.t.i.d.a aVar = new d.b.j0.t.i.d.a(tbPageContext, this.w.getSuffixContainer());
        this.V = aVar;
        aVar.d(k());
        this.L = (FrameLayout) m.findViewById(R.id.text_bottom_layout);
        this.M = (LinearLayout) m.findViewById(R.id.forum_friends_now_looking);
        this.N = (TextView) m.findViewById(R.id.tv_forum_friends_now_looking);
        this.O = (ImageView) m.findViewById(R.id.image_forum_friends_now_looking);
    }

    public final void P(a2 a2Var, String str) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", a2Var.q1().live_id).param("obj_type", 2));
        if (a2Var.q1() != null && a2Var.q1().user_info != null && a2Var.q1().user_info.is_official == 2) {
            TiebaStatic.log(new StatisticItem("c12801").param("tid", a2Var.o0()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
            if (a2Var.i0().equals(this.P)) {
                TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", a2Var.c0()));
            } else {
                TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", a2Var.c0()));
            }
        }
    }

    public final void Q(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12125").param("tid", a2Var.o0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", a2Var.q1().live_id).param("obj_type", 2));
        if (a2Var.q1() == null || a2Var.q1().user_info == null || a2Var.q1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12800").param("tid", a2Var.o0()));
    }

    public int R(int i) {
        return d.b.j0.m.d.c().b(this.R, i);
    }

    public void S() {
        T t;
        if (k.c().g() && (t = this.o) != 0) {
            a2 a2Var = (a2) t;
            a2Var.n();
            if (a2Var != null) {
                a2 a2Var2 = (a2) this.o;
                a2Var2.n();
                if (a2Var2.q1() != null) {
                    this.F.setPlaceHolder(3);
                    TbImageView tbImageView = this.F;
                    a2 a2Var3 = (a2) this.o;
                    a2Var3.n();
                    tbImageView.W(a2Var3.q1().cover, 10, false);
                    this.E.setVisibility(0);
                    return;
                }
            }
        }
        this.E.setVisibility(8);
    }

    public void T(Context context, a2 a2Var) {
        if (context == null || a2Var == null || a2Var.q1() == null) {
            return;
        }
        if (!j.z()) {
            l.K(context, R.string.no_network_guide);
            return;
        }
        String str = this.T ? AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE : AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
        if (a2Var.j0() != null) {
            str = a2Var.j0();
        }
        int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
        if (frsCurTabType == 14) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + a2Var.c0();
        } else if (frsCurTabType == 13) {
            str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + a2Var.c0();
        }
        String str2 = str;
        P(a2Var, str2);
        AlaInfoData q1 = a2Var.q1();
        boolean equals = (TbadkCoreApplication.getCurrentAccountInfo() == null || a2Var.T() == null) ? false : TextUtils.equals(a2Var.T().getUserId(), TbadkCoreApplication.getCurrentAccount());
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(q1);
        AlaUserInfoData alaUserInfoData = q1.user_info;
        if (alaUserInfoData != null) {
            alaLiveInfoCoreData.userName = alaUserInfoData.user_name;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str2, "", equals, this.P)));
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
            this.B.setVisibility(0);
            int k = l.k(this.m.getPageActivity());
            if (k != this.U) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                int k2 = l.k(b()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                layoutParams.width = k2;
                layoutParams.height = (k2 * 9) / 16;
                this.E.setLayoutParams(layoutParams);
                this.U = k;
            }
            SparseArray<String> sparseArray = null;
            if (((a2) this.o).q1() != null && ((a2) this.o).q1().user_info != null && ((a2) this.o).q1().user_info.is_official == 2) {
                this.T = true;
                sparseArray = ((a2) this.o).q1().dislikeInfo;
                this.D.setVisibility(0);
                int[] p = l.p(b());
                ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
                layoutParams2.width = p[0];
                layoutParams2.height = (p[0] * 156) / 1080;
                this.D.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(((a2) this.o).q1().liveStagePicUrl)) {
                    this.D.W(((a2) this.o).q1().liveStagePicUrl, 10, false);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                marginLayoutParams.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds24);
                this.w.setLayoutParams(marginLayoutParams);
            } else {
                this.T = false;
                this.D.setVisibility(8);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                marginLayoutParams2.topMargin = this.m.getResources().getDimensionPixelSize(R.dimen.tbds44);
                this.w.setLayoutParams(marginLayoutParams2);
            }
            if (this.T && sparseArray != null && sparseArray.size() > 0) {
                this.V.b((a2) this.o, "ala_frs_demo_hell_live_feed_back_type");
            } else if (this.V.a() != null) {
                this.V.a().setVisibility(8);
            }
            ((a2) this.o).S2(false, true);
            this.w.setData((a2) this.o);
            SpannableStringBuilder l1 = ((a2) this.o).l1();
            if (l1 != null && !StringUtils.isNull(l1.toString())) {
                this.C.setText(((a2) this.o).l1());
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
            if (((a2) this.o).q1().audience_count > 0) {
                this.K.setVisibility(0);
                this.H.setVisibility(0);
                this.H.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((a2) this.o).q1().audience_count)));
            } else {
                this.K.setVisibility(8);
                this.H.setVisibility(8);
            }
            this.I.setVisibility(8);
            if (((a2) this.o).q1().openRecomReason == 1) {
                String str = ((a2) this.o).q1().recomReason;
                if (!StringUtils.isNull(str)) {
                    this.I.setVisibility(0);
                    this.I.setText(str);
                } else {
                    String C0 = ((a2) this.o).C0();
                    String I0 = ((a2) this.o).I0();
                    if (UtilHelper.isDecimal(C0) && UtilHelper.isDecimal(I0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                        AppPosInfo c2 = d.b.j0.s2.d0.a.e().c();
                        String str2 = c2.latitude;
                        String str3 = c2.longitude;
                        if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(C0), Double.parseDouble(I0)) <= 50.0d) {
                            this.I.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                            this.I.setVisibility(0);
                        }
                    }
                }
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.L.getLayoutParams();
            if (((a2) this.o).q1() != null && !StringUtils.isNull(((a2) this.o).q1().forumUserLiveMsg)) {
                this.M.setVisibility(0);
                String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((a2) this.o).q1().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                this.N.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                layoutParams3.addRule(3, R.id.forum_friends_now_looking);
            } else {
                this.M.setVisibility(8);
                layoutParams3.addRule(3, R.id.video_card_content_layout);
            }
            this.L.setLayoutParams(layoutParams3);
            Y(R(1));
            Q((a2) this.o);
            this.S.setVisibility((d.b.j0.q0.b.e().g() || d.b.j0.q0.a.h().j()) ? 0 : 0);
            o(this.m, TbadkCoreApplication.getInst().getSkinType());
            S();
            this.G.playAnimation();
            F(this.B);
            return;
        }
        this.B.setVisibility(8);
    }

    public void W(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.w;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        r(bdUniqueId);
        z(bdUniqueId);
    }

    public void X(boolean z) {
        this.Q = z;
    }

    public void Y(int i) {
        T t = this.o;
        if (t == 0) {
            return;
        }
        if (i == 1) {
            this.p.setVisibility(8);
            this.x.g((a2) this.o);
            return;
        }
        this.y.setVisibility(this.p.setData((a2) t) ? 8 : 0);
        this.x.setVisibility(8);
    }

    @Override // d.b.j0.x.z
    public void a(String str) {
        this.P = str;
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.frs_ala_video_layout_new;
    }

    @Override // d.b.j0.x.b
    @SuppressLint({"ResourceAsColor"})
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f64176e != i) {
            y(tbPageContext, i);
            d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.B);
            d2.k(R.string.J_X06);
            d2.g(R.color.CAM_X0205, R.color.CAM_X0206);
            d.b.i0.r.u.c d3 = d.b.i0.r.u.c.d(this.E);
            d3.i(R.dimen.L_X01);
            d3.h(R.color.CAM_X0401);
            d3.k(R.string.J_X05);
            d3.f(R.color.CAM_X0611);
            float g2 = l.g(b(), R.dimen.tbds31);
            SkinManager.setBackgroundEndColorToAutoColor(this.J, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(b(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.M);
            SkinManager.setViewTextColor(this.N, R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.O, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.w.onChangeSkinType(l(), TbadkCoreApplication.getInst().getSkinType());
            this.F.setPlaceHolder(3);
            this.p.onChangeSkinType();
            this.f64176e = i;
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.x;
            if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                this.x.f();
            }
        }
        T t = this.o;
        if (t != 0 && m.k(((a2) t).o0())) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0109);
        } else {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
        }
        SkinManager.setBackgroundColor(this.S, R.color.CAM_X0201);
        this.V.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (d.b.j0.q0.b.e().g() || d.b.j0.q0.a.h().j()) {
            return;
        }
        if (view != this.B && view != this.p.getCommentContainer() && view != this.z && view != this.x.f13205f.getCommentContainer() && view != this.q.getCommentContainer() && view != this.M) {
            if (view.getId() == R.id.video_container) {
                if (i() != null) {
                    i().a(view, this.o);
                }
                T(b(), (a2) this.o);
                return;
            }
            return;
        }
        T t = this.o;
        if (t != 0) {
            m.a(((a2) t).o0());
        }
        if (i() != null) {
            i().a(this.B, this.o);
        }
        T(b(), (a2) this.o);
        if (this.o != 0) {
            if (view == this.p.getCommentContainer() || view == this.x.f13205f.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", ((a2) this.o).w1());
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
    }

    @Override // d.b.j0.x.z
    public void p(int i) {
    }

    @Override // d.b.j0.m.e
    public void setPage(String str) {
        this.R = str;
    }
}
