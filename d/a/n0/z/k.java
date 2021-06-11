package d.a.n0.z;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class k extends d.a.n0.z.a<d.a.n0.z.e0.j> implements d.a.n0.o.e {
    public static final int O = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
    public RelativeLayout A;
    public TbImageView B;
    public TBLottieAnimationView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public View G;
    public LinearLayout H;
    public TextView I;
    public ImageView J;
    public boolean K;
    public int L;
    public View.OnClickListener M;
    public CustomMessageListener N;
    public FrameLayout w;
    public LinearLayout x;
    public CardUserInfoLayout y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            k.this.C.playAnimation();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            k.this.C.cancelAnimation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.i() != null) {
                k.this.i().a(view, k.this.o);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = k.this.o) == 0 || ((d.a.n0.z.e0.j) t).f67177e == null || ((d.a.n0.z.e0.j) t).f67177e.z1() == null || k.this.z == null || !((String) customResponsedMessage.getData()).equals(((d.a.n0.z.e0.j) k.this.o).f67177e.z1())) {
                return;
            }
            k kVar = k.this;
            TextView textView = kVar.z;
            String o0 = ((d.a.n0.z.e0.j) kVar.o).f67177e.o0();
            int i2 = R.color.CAM_X0109;
            m.l(textView, o0, i2, i2);
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.K = false;
        this.L = 0;
        this.M = new b();
        this.N = new c(2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        P(m());
    }

    public View M() {
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            return cardUserInfoLayout.getAvatar();
        }
        return null;
    }

    public View N() {
        if (this.K) {
            CardUserInfoLayout cardUserInfoLayout = this.y;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getUserName();
            }
            return null;
        }
        return this.z;
    }

    public void O() {
        T t;
        if (d.a.m0.r.k.c().g() && (t = this.o) != 0 && ((d.a.n0.z.e0.j) t).i() != null && ((d.a.n0.z.e0.j) this.o).i().s1() != null) {
            this.B.setPlaceHolder(3);
            this.B.U(((d.a.n0.z.e0.j) this.o).i().s1().cover, 10, false);
            this.A.setVisibility(0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final void P(View view) {
        this.w = (FrameLayout) view.findViewById(R.id.layout_root);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
        this.x = linearLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        layoutParams.bottomMargin = 0;
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) view.findViewById(R.id.card_home_page_ala_video_user_info_layout);
        this.y = cardUserInfoLayout;
        cardUserInfoLayout.setPageContext(this.m);
        this.y.setPageUniqueId(this.n);
        this.z = (TextView) view.findViewById(R.id.text_title);
        this.A = (RelativeLayout) view.findViewById(R.id.frame_video);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.image_video);
        this.B = tbImageView;
        tbImageView.setDrawCorner(true);
        this.B.setPlaceHolder(3);
        this.B.setDefaultResource(0);
        this.B.setRadiusById(R.string.J_X05);
        this.B.setConrers(15);
        this.B.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.B.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.B.setBorderSurroundContent(true);
        this.B.setDrawBorder(true);
        this.F = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.C = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.C, R.raw.ala_live2);
        this.C.addOnAttachStateChangeListener(new a());
        this.D = (TextView) view.findViewById(R.id.play_count);
        this.E = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.G = view.findViewById(R.id.play_count_line);
        this.u = (ForumEnterLayout) view.findViewById(R.id.card_forum_enter_button);
        this.p = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_layout);
        this.q = (ThreadCardBottomOpSegmentWeightLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        v(this.p);
        v(this.q);
        this.x.setOnClickListener(this);
        this.H = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
        this.I = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
        this.J = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
        this.H.setOnClickListener(this);
        d.a.m0.b.g.b.f(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    public final void Q(String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<?> tbPageContext = this.f67159f;
        urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public final void R(View view) {
        String str;
        if (i() != null) {
            i().a(view, this.o);
        }
        T t = this.o;
        if (t == 0 || ((d.a.n0.z.e0.j) t).i() == null || ((d.a.n0.z.e0.j) this.o).i().s1() == null) {
            return;
        }
        AlaInfoData s1 = ((d.a.n0.z.e0.j) this.o).i().s1();
        m.a(((d.a.n0.z.e0.j) this.o).f67177e.o0());
        m.l(this.z, ((d.a.n0.z.e0.j) this.o).f67177e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        if (s1.isLegalYYLiveData()) {
            if (((d.a.n0.z.e0.j) this.o).i().V1) {
                str = YYLiveUtil.SOURCE_HOME_RECOMMEND_PLAY;
            } else {
                str = ((d.a.n0.z.e0.j) this.o).i().W1 ? YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_CARD : YYLiveUtil.SOURCE_NOT_DEFINE;
            }
            String str2 = str;
            TbPageContext<?> tbPageContext = this.m;
            YyExtData yyExtData = s1.mYyExtData;
            String str3 = yyExtData.mSid;
            String str4 = yyExtData.mSsid;
            String str5 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str3, str4, str5, "" + s1.roomId, str2);
            T(((d.a.n0.z.e0.j) this.o).i().z1(), String.valueOf(((d.a.n0.z.e0.j) this.o).i().c0()), String.valueOf(s1.roomId), String.valueOf(s1.live_id), s1.mYyExtData.mSid);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: S */
    public void n(d.a.n0.z.e0.j jVar) {
        this.o = jVar;
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
        if (t != 0 && ((d.a.n0.z.e0.j) t).i() != null) {
            this.w.setVisibility(0);
            int k = d.a.c.e.p.l.k(this.m.getPageActivity());
            if (k != this.L) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                layoutParams.width = dimenPixelSize;
                layoutParams.height = (dimenPixelSize * 9) / 16;
                this.A.setLayoutParams(layoutParams);
                this.L = k;
            }
            if (((d.a.n0.z.e0.j) this.o).i().s1() != null && ((d.a.n0.z.e0.j) this.o).i().s1().isChushou) {
                this.p.setShowFlag(10);
                this.p.hideShareContainer();
            } else {
                this.p.setShowFlag(11);
                this.p.resetShareContainer();
            }
            this.y.setVisibility(0);
            this.y.setData(((d.a.n0.z.e0.j) this.o).i());
            this.y.setUserAfterClickListener(this.M);
            ((d.a.n0.z.e0.j) this.o).i().Z2();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((d.a.n0.z.e0.j) this.o).i().n1());
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                this.z.setVisibility(8);
            } else {
                this.z.setText(spannableStringBuilder);
                this.z.setVisibility(0);
            }
            if (((d.a.n0.z.e0.j) this.o).f67177e.s1().audience_count > 0) {
                this.G.setVisibility(0);
                this.D.setVisibility(0);
                this.D.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((d.a.n0.z.e0.j) this.o).f67177e.s1().audience_count)));
            } else {
                this.G.setVisibility(8);
                this.D.setVisibility(8);
            }
            this.E.setVisibility(8);
            if (((d.a.n0.z.e0.j) this.o).f67177e.s1().openRecomReason == 1) {
                String str = ((d.a.n0.z.e0.j) this.o).f67177e.s1().recomReason;
                if (!StringUtils.isNull(str)) {
                    this.E.setVisibility(0);
                    this.E.setText(str);
                } else {
                    String D0 = ((d.a.n0.z.e0.j) this.o).f67177e.D0();
                    String J0 = ((d.a.n0.z.e0.j) this.o).f67177e.J0();
                    if (UtilHelper.isDecimal(D0) && UtilHelper.isDecimal(J0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                        AppPosInfo c2 = d.a.n0.t2.g0.a.e().c();
                        String str2 = c2.latitude;
                        String str3 = c2.longitude;
                        if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && d.a.c.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(D0), Double.parseDouble(J0)) <= 50.0d) {
                            this.E.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                            this.E.setVisibility(0);
                        }
                    }
                }
            }
            if (((d.a.n0.z.e0.j) this.o).f67177e.s1() != null && !StringUtils.isNull(((d.a.n0.z.e0.j) this.o).f67177e.s1().forumUserLiveMsg)) {
                this.H.setVisibility(0);
                String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((d.a.n0.z.e0.j) this.o).f67177e.s1().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                this.I.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
            } else {
                this.H.setVisibility(8);
            }
            F(this.w);
            o(this.m, TbadkCoreApplication.getInst().getSkinType());
            if (m.k(((d.a.n0.z.e0.j) this.o).f67177e.o0())) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0105, 1);
            }
            O();
            this.C.playAnimation();
            return;
        }
        this.w.setVisibility(8);
    }

    public void V(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.p == null || this.N == null) {
            return;
        }
        q(bdUniqueId);
        y(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.N.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.N);
    }

    public void X(boolean z) {
        this.K = z;
    }

    public void Y(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.S = String.valueOf(i2);
        }
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.card_home_page_ala_live_item_new;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.f67158e != i2) {
            x(tbPageContext, i2);
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.x);
            d2.m(R.string.J_X06);
            d2.h(R.color.CAM_X0205, R.color.CAM_X0206);
            d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.A);
            d3.k(R.dimen.L_X01);
            d3.j(R.color.CAM_X0401);
            d3.m(R.string.J_X05);
            d3.f(R.color.CAM_X0611);
            float g2 = d.a.c.e.p.l.g(b(), R.dimen.tbds31);
            SkinManager.setBackgroundEndColorToAutoColor(this.F, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(d.a.c.e.p.l.g(b(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(O).into(this.H);
            SkinManager.setViewTextColor(this.I, R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.J, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.y.onChangeSkinType(k(), TbadkCoreApplication.getInst().getSkinType());
            this.B.setPlaceHolder(3);
            this.f67158e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.x || view == this.p.getCommentContainer() || view == this.q.getCommentContainer() || view == this.H) {
            if (((d.a.n0.z.e0.j) this.o).i().s1() != null && ((d.a.n0.z.e0.j) this.o).i().s1().isChushou) {
                Q(((d.a.n0.z.e0.j) this.o).i().s1().thirdRoomId, ((d.a.n0.z.e0.j) this.o).i().s1().thirdLiveType);
            } else {
                R(view);
            }
        }
    }

    @Override // d.a.n0.o.e
    public void setPage(String str) {
    }
}
