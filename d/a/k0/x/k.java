package d.a.k0.x;

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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
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
public class k extends d.a.k0.x.a<d.a.k0.x.e0.j> implements d.a.k0.m.e {
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
            if (k.this.h() != null) {
                k.this.h().a(view, k.this.o);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = k.this.o) == 0 || ((d.a.k0.x.e0.j) t).f63179e == null || ((d.a.k0.x.e0.j) t).f63179e.x1() == null || k.this.z == null || !((String) customResponsedMessage.getData()).equals(((d.a.k0.x.e0.j) k.this.o).f63179e.x1())) {
                return;
            }
            k kVar = k.this;
            TextView textView = kVar.z;
            String o0 = ((d.a.k0.x.e0.j) kVar.o).f63179e.o0();
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
        O(l());
    }

    public View L() {
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            return cardUserInfoLayout.getAvatar();
        }
        return null;
    }

    public View M() {
        if (this.K) {
            CardUserInfoLayout cardUserInfoLayout = this.y;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getUserName();
            }
            return null;
        }
        return this.z;
    }

    public void N() {
        T t;
        if (d.a.j0.r.k.c().g() && (t = this.o) != 0 && ((d.a.k0.x.e0.j) t).m() != null && ((d.a.k0.x.e0.j) this.o).m().q1() != null) {
            this.B.setPlaceHolder(3);
            this.B.V(((d.a.k0.x.e0.j) this.o).m().q1().cover, 10, false);
            this.A.setVisibility(0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final void O(View view) {
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
        u(this.p);
        u(this.q);
        this.x.setOnClickListener(this);
        this.H = (LinearLayout) view.findViewById(R.id.forum_friends_now_looking);
        this.I = (TextView) view.findViewById(R.id.tv_forum_friends_now_looking);
        this.J = (ImageView) view.findViewById(R.id.image_forum_friends_now_looking);
        this.H.setOnClickListener(this);
        d.a.j0.b.g.b.f(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    public final void P(String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<?> tbPageContext = this.f63161f;
        urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public final void Q(View view) {
        if (h() != null) {
            h().a(view, this.o);
        }
        T t = this.o;
        if (t == 0 || ((d.a.k0.x.e0.j) t).m() == null || ((d.a.k0.x.e0.j) this.o).m().q1() == null) {
            return;
        }
        AlaInfoData q1 = ((d.a.k0.x.e0.j) this.o).m().q1();
        m.a(((d.a.k0.x.e0.j) this.o).f63179e.o0());
        m.l(this.z, ((d.a.k0.x.e0.j) this.o).f63179e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        if (q1.isLegalYYLiveData()) {
            YYLiveUtil.jumpYYLiveRoom(this.m, q1);
            S(((d.a.k0.x.e0.j) this.o).m().x1(), String.valueOf(((d.a.k0.x.e0.j) this.o).m().c0()), String.valueOf(q1.roomId), String.valueOf(q1.live_id), q1.mYyExtData.mSid);
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(q1);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.m.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        S(((d.a.k0.x.e0.j) this.o).m().x1(), String.valueOf(((d.a.k0.x.e0.j) this.o).m().c0()), String.valueOf(q1.roomId), String.valueOf(q1.live_id), null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: R */
    public void m(d.a.k0.x.e0.j jVar) {
        this.o = jVar;
        T();
    }

    public final void S(String str, String str2, String str3, String str4, String str5) {
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

    public final void T() {
        T t = this.o;
        if (t != 0 && ((d.a.k0.x.e0.j) t).m() != null) {
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
            if (((d.a.k0.x.e0.j) this.o).m().q1() != null && ((d.a.k0.x.e0.j) this.o).m().q1().isChushou) {
                this.p.setShowFlag(10);
                this.p.hideShareContainer();
            } else {
                this.p.setShowFlag(11);
                this.p.resetShareContainer();
            }
            this.y.setVisibility(0);
            this.y.setData(((d.a.k0.x.e0.j) this.o).m());
            this.y.setUserAfterClickListener(this.M);
            ((d.a.k0.x.e0.j) this.o).m().X2();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((d.a.k0.x.e0.j) this.o).m().l1());
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                this.z.setVisibility(8);
            } else {
                this.z.setText(spannableStringBuilder);
                this.z.setVisibility(0);
            }
            if (((d.a.k0.x.e0.j) this.o).f63179e.q1().audience_count > 0) {
                this.G.setVisibility(0);
                this.D.setVisibility(0);
                this.D.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((d.a.k0.x.e0.j) this.o).f63179e.q1().audience_count)));
            } else {
                this.G.setVisibility(8);
                this.D.setVisibility(8);
            }
            this.E.setVisibility(8);
            if (((d.a.k0.x.e0.j) this.o).f63179e.q1().openRecomReason == 1) {
                String str = ((d.a.k0.x.e0.j) this.o).f63179e.q1().recomReason;
                if (!StringUtils.isNull(str)) {
                    this.E.setVisibility(0);
                    this.E.setText(str);
                } else {
                    String C0 = ((d.a.k0.x.e0.j) this.o).f63179e.C0();
                    String I0 = ((d.a.k0.x.e0.j) this.o).f63179e.I0();
                    if (UtilHelper.isDecimal(C0) && UtilHelper.isDecimal(I0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                        AppPosInfo c2 = d.a.k0.s2.g0.a.e().c();
                        String str2 = c2.latitude;
                        String str3 = c2.longitude;
                        if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && d.a.c.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(C0), Double.parseDouble(I0)) <= 50.0d) {
                            this.E.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                            this.E.setVisibility(0);
                        }
                    }
                }
            }
            if (((d.a.k0.x.e0.j) this.o).f63179e.q1() != null && !StringUtils.isNull(((d.a.k0.x.e0.j) this.o).f63179e.q1().forumUserLiveMsg)) {
                this.H.setVisibility(0);
                String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(((d.a.k0.x.e0.j) this.o).f63179e.q1().forumUserLiveMsg, 10, StringHelper.STRING_MORE);
                this.I.setText(cutChineseAndEnglishWithSuffix + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
            } else {
                this.H.setVisibility(8);
            }
            B(this.w);
            n(this.m, TbadkCoreApplication.getInst().getSkinType());
            if (m.k(((d.a.k0.x.e0.j) this.o).f63179e.o0())) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0105, 1);
            }
            N();
            this.C.playAnimation();
            return;
        }
        this.w.setVisibility(8);
    }

    public void V(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.p == null || this.N == null) {
            return;
        }
        p(bdUniqueId);
        x(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.N.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.N);
    }

    public void W(boolean z) {
        this.K = z;
    }

    public void X(int i2) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.S = String.valueOf(i2);
        }
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.card_home_page_ala_live_item_new;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f63160e != i2) {
            w(tbPageContext, i2);
            d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.x);
            d2.k(R.string.J_X06);
            d2.g(R.color.CAM_X0205, R.color.CAM_X0206);
            d.a.j0.r.u.c d3 = d.a.j0.r.u.c.d(this.A);
            d3.i(R.dimen.L_X01);
            d3.h(R.color.CAM_X0401);
            d3.k(R.string.J_X05);
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
            this.f63160e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.x || view == this.p.getCommentContainer() || view == this.q.getCommentContainer() || view == this.H) {
            if (((d.a.k0.x.e0.j) this.o).m().q1() != null && ((d.a.k0.x.e0.j) this.o).m().q1().isChushou) {
                P(((d.a.k0.x.e0.j) this.o).m().q1().thirdRoomId, ((d.a.k0.x.e0.j) this.o).m().q1().thirdLiveType);
            } else {
                Q(view);
            }
        }
    }

    @Override // d.a.k0.m.e
    public void setPage(String str) {
    }
}
