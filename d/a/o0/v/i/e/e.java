package d.a.o0.v.i.e;

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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.r.k;
import d.a.n0.r.q.a2;
import d.a.o0.z.m;
import d.a.o0.z.z;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class e extends d.a.o0.z.a<a2> implements z, d.a.o0.o.e {
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
    public d.a.o0.v.i.d.a V;
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
        q(bdUniqueId);
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
        v(threadCommentAndPraiseInfoLayout);
        this.p.setSelectVisible(false);
        this.p.setIsBarViewVisible(false);
        this.p.setCommentNumEnable(true);
        this.p.setLiveShareEnable(false);
        this.p.setFrom(2);
        this.p.getCommentContainer().setOnClickListener(this);
        this.p.hideDisagree();
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 2;
        eVar.f53783h = 2;
        this.p.setAgreeStatisticData(eVar);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) m.findViewById(R.id.card_bottom_op_weight_layout);
        this.q = threadCommentAndPraiseInfoLayout2;
        v(threadCommentAndPraiseInfoLayout2);
        this.q.setFrom(2);
        this.q.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) m.findViewById(R.id.text_bottom_2);
        this.x = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12545f.setOnClickListener(this);
        this.x.f12545f.getCommentContainer().setOnClickListener(this);
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
        d.a.o0.v.i.d.a aVar = new d.a.o0.v.i.d.a(tbPageContext, this.w.getSuffixContainer());
        this.V = aVar;
        aVar.d(j());
        this.L = (FrameLayout) m.findViewById(R.id.text_bottom_layout);
        this.M = (LinearLayout) m.findViewById(R.id.forum_friends_now_looking);
        this.N = (TextView) m.findViewById(R.id.tv_forum_friends_now_looking);
        this.O = (ImageView) m.findViewById(R.id.image_forum_friends_now_looking);
    }

    public final void N(a2 a2Var, String str) {
        TiebaStatic.log(new StatisticItem("c12126").param("tid", a2Var.o0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", a2Var.s1().live_id).param("obj_type", 2));
        if (a2Var.s1() != null && a2Var.s1().user_info != null && a2Var.s1().user_info.is_official == 2) {
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

    public final void O(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12125").param("tid", a2Var.o0()).param("obj_locate", this.Q ? 2 : 1).param("obj_id", a2Var.s1().live_id).param("obj_type", 2));
        if (a2Var.s1() == null || a2Var.s1().user_info == null || a2Var.s1().user_info.is_official != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12800").param("tid", a2Var.o0()));
    }

    public int P(int i2) {
        return d.a.o0.o.d.c().b(this.R, i2);
    }

    public void Q() {
        T t;
        if (k.c().g() && (t = this.o) != 0) {
            a2 a2Var = (a2) t;
            a2Var.i();
            if (a2Var != null) {
                a2 a2Var2 = (a2) this.o;
                a2Var2.i();
                if (a2Var2.s1() != null) {
                    this.F.setPlaceHolder(3);
                    TbImageView tbImageView = this.F;
                    a2 a2Var3 = (a2) this.o;
                    a2Var3.i();
                    tbImageView.U(a2Var3.s1().cover, 10, false);
                    this.E.setVisibility(0);
                    return;
                }
            }
        }
        this.E.setVisibility(8);
    }

    public void R(Context context, a2 a2Var) {
        if (context == null || a2Var == null || a2Var.s1() == null) {
            return;
        }
        if (!j.z()) {
            l.L(context, R.string.no_network_guide);
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
        N(a2Var, str);
        AlaInfoData s1 = a2Var.s1();
        if (s1.isLegalYYLiveData()) {
            TbPageContext<?> tbPageContext = this.m;
            YyExtData yyExtData = s1.mYyExtData;
            String str2 = yyExtData.mSid;
            String str3 = yyExtData.mSsid;
            String str4 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str2, str3, str4, "" + s1.roomId, YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + frsCurTabType);
            T(((a2) this.o).z1(), String.valueOf(((a2) this.o).c0()), String.valueOf(s1.roomId), String.valueOf(s1.live_id), s1.mYyExtData.mSid);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: S */
    public void n(a2 a2Var) {
        this.o = a2Var;
        U();
    }

    public final void T(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tid", str);
            jSONObject.put("fid", str2);
            if (TextUtils.equals("0", str3)) {
                str3 = null;
            }
            jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, str3);
            if (TextUtils.equals("0", str4)) {
                str4 = null;
            }
            jSONObject.put("liveId", str4);
            jSONObject.put("sid", str5);
            jSONObject.put("roomInfo", "roomInfo");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
    }

    public final void U() {
        T t = this.o;
        int i2 = 8;
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
            if (((a2) this.o).s1() != null && ((a2) this.o).s1().user_info != null && ((a2) this.o).s1().user_info.is_official == 2) {
                this.T = true;
                sparseArray = ((a2) this.o).s1().dislikeInfo;
                this.D.setVisibility(0);
                int[] p = l.p(b());
                ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
                layoutParams2.width = p[0];
                layoutParams2.height = (p[0] * 156) / IdCardOcrCameraActivity.G;
                this.D.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(((a2) this.o).s1().liveStagePicUrl)) {
                    this.D.U(((a2) this.o).s1().liveStagePicUrl, 10, false);
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
            ((a2) this.o).W2(false, true);
            this.w.setData((a2) this.o);
            SpannableStringBuilder n1 = ((a2) this.o).n1();
            if (n1 != null && !StringUtils.isNull(n1.toString())) {
                this.C.setText(((a2) this.o).n1());
                this.C.setVisibility(0);
            } else {
                this.C.setVisibility(8);
            }
            if (((a2) this.o).s1().audience_count > 0) {
                this.K.setVisibility(0);
                this.H.setVisibility(0);
                this.H.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((a2) this.o).s1().audience_count)));
            } else {
                this.K.setVisibility(8);
                this.H.setVisibility(8);
            }
            this.I.setVisibility(8);
            if (((a2) this.o).s1().openRecomReason == 1) {
                String str = ((a2) this.o).s1().recomReason;
                if (!StringUtils.isNull(str)) {
                    this.I.setVisibility(0);
                    this.I.setText(str);
                } else {
                    String D0 = ((a2) this.o).D0();
                    String J0 = ((a2) this.o).J0();
                    if (UtilHelper.isDecimal(D0) && UtilHelper.isDecimal(J0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                        AppPosInfo c2 = d.a.o0.t2.g0.a.e().c();
                        String str2 = c2.latitude;
                        String str3 = c2.longitude;
                        if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(D0), Double.parseDouble(J0)) <= 50.0d) {
                            this.I.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                            this.I.setVisibility(0);
                        }
                    }
                }
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.L.getLayoutParams();
            if (((a2) this.o).s1() != null && !StringUtils.isNull(((a2) this.o).s1().forumUserLiveMsg)) {
                this.M.setVisibility(0);
                String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((a2) this.o).s1().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                this.N.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                layoutParams3.addRule(3, R.id.forum_friends_now_looking);
            } else {
                this.M.setVisibility(8);
                layoutParams3.addRule(3, R.id.video_card_content_layout);
            }
            this.L.setLayoutParams(layoutParams3);
            Y(P(1));
            O((a2) this.o);
            this.S.setVisibility((d.a.o0.r0.b.e().g() || d.a.o0.r0.a.h().j()) ? 0 : 0);
            o(this.m, TbadkCoreApplication.getInst().getSkinType());
            Q();
            this.G.playAnimation();
            F(this.B);
            return;
        }
        this.B.setVisibility(8);
    }

    public void V(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.p == null) {
            return;
        }
        CardUserInfoLayout cardUserInfoLayout = this.w;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        q(bdUniqueId);
        y(bdUniqueId);
    }

    public void X(boolean z) {
        this.Q = z;
    }

    public void Y(int i2) {
        T t = this.o;
        if (t == 0) {
            return;
        }
        if (i2 == 1) {
            this.p.setVisibility(8);
            this.x.g((a2) this.o);
            return;
        }
        this.y.setVisibility(this.p.setData((a2) t) ? 8 : 0);
        this.x.setVisibility(8);
    }

    @Override // d.a.o0.z.z
    public void a(String str) {
        this.P = str;
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.frs_ala_video_layout_new;
    }

    @Override // d.a.o0.z.b
    @SuppressLint({"ResourceAsColor"})
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.f67283e != i2) {
            x(tbPageContext, i2);
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.B);
            d2.m(R.string.J_X06);
            d2.h(R.color.CAM_X0205, R.color.CAM_X0206);
            d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(this.E);
            d3.k(R.dimen.L_X01);
            d3.j(R.color.CAM_X0401);
            d3.m(R.string.J_X05);
            d3.f(R.color.CAM_X0611);
            float g2 = l.g(b(), R.dimen.tbds31);
            SkinManager.setBackgroundEndColorToAutoColor(this.J, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(b(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.M);
            SkinManager.setViewTextColor(this.N, R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.O, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.w.onChangeSkinType(k(), TbadkCoreApplication.getInst().getSkinType());
            this.F.setPlaceHolder(3);
            this.p.onChangeSkinType();
            this.f67283e = i2;
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
        if (d.a.o0.r0.b.e().g() || d.a.o0.r0.a.h().j()) {
            return;
        }
        if (view != this.B && view != this.p.getCommentContainer() && view != this.z && view != this.x.f12545f.getCommentContainer() && view != this.q.getCommentContainer() && view != this.M) {
            if (view.getId() == R.id.video_container) {
                if (i() != null) {
                    i().a(view, this.o);
                }
                R(b(), (a2) this.o);
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
        R(b(), (a2) this.o);
        if (this.o != 0) {
            if (view == this.p.getCommentContainer() || view == this.x.f12545f.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", ((a2) this.o).z1());
                statisticItem.param("nid", ((a2) this.o).M0());
                d.a.n0.i0.c f2 = TbPageExtraHelper.f(view);
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

    @Override // d.a.o0.z.z
    public void r(int i2) {
    }

    @Override // d.a.o0.o.e
    public void setPage(String str) {
        this.R = str;
    }
}
