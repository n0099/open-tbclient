package d.b.i0.x;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class j extends d.b.i0.x.a<d.b.i0.x.e0.j> implements d.b.i0.m.e {
    public RelativeLayout A;
    public TbImageView B;
    public TBLottieAnimationView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public View G;
    public boolean H;
    public int I;
    public View.OnClickListener J;
    public CustomMessageListener K;
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
            j.this.C.playAnimation();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            j.this.C.cancelAnimation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.i() != null) {
                j.this.i().a(view, j.this.o);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            T t;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (t = j.this.o) == 0 || ((d.b.i0.x.e0.j) t).f62196e == null || ((d.b.i0.x.e0.j) t).f62196e.w1() == null || j.this.z == null || !((String) customResponsedMessage.getData()).equals(((d.b.i0.x.e0.j) j.this.o).f62196e.w1())) {
                return;
            }
            j jVar = j.this;
            TextView textView = jVar.z;
            String o0 = ((d.b.i0.x.e0.j) jVar.o).f62196e.o0();
            int i = R.color.CAM_X0109;
            m.l(textView, o0, i, i);
        }
    }

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.H = false;
        this.I = 0;
        this.J = new b();
        this.K = new c(2001390);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        R(m());
    }

    public View O() {
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            return cardUserInfoLayout.getAvatar();
        }
        return null;
    }

    public View P() {
        if (this.H) {
            CardUserInfoLayout cardUserInfoLayout = this.y;
            if (cardUserInfoLayout != null) {
                return cardUserInfoLayout.getUserName();
            }
            return null;
        }
        return this.z;
    }

    public void Q() {
        T t;
        if (d.b.h0.r.k.c().g() && (t = this.o) != 0 && ((d.b.i0.x.e0.j) t).n() != null && ((d.b.i0.x.e0.j) this.o).n().q1() != null) {
            this.B.setPlaceHolder(3);
            this.B.W(((d.b.i0.x.e0.j) this.o).n().q1().cover, 10, false);
            this.A.setVisibility(0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final void R(View view) {
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
        w(this.p);
        w(this.q);
        this.x.setOnClickListener(this);
        d.b.h0.b.g.b.f(view.findViewById(R.id.imageMask), R.color.transparent);
    }

    public final void S(long j, long j2, String str) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<?> tbPageContext = this.f62180f;
        urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + j2 + "&live_id=" + j + "&enterroom_type=1&from" + str});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: T */
    public void n(d.b.i0.x.e0.j jVar) {
        this.o = jVar;
        U();
    }

    public final void U() {
        T t = this.o;
        if (t != 0 && ((d.b.i0.x.e0.j) t).n() != null) {
            this.w.setVisibility(0);
            int k = d.b.b.e.p.l.k(this.m.getPageActivity());
            if (k != this.I) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                int dimenPixelSize = k - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                layoutParams.width = dimenPixelSize;
                layoutParams.height = (dimenPixelSize * 9) / 16;
                this.A.setLayoutParams(layoutParams);
                this.I = k;
            }
            this.p.setShowFlag(11);
            this.p.resetShareContainer();
            this.y.setVisibility(0);
            this.y.setData(((d.b.i0.x.e0.j) this.o).n());
            this.y.setUserAfterClickListener(this.J);
            if (((d.b.i0.x.e0.j) this.o).n().q1() != null) {
                this.z.setText(((d.b.i0.x.e0.j) this.o).n().q1().friendRoomName);
            }
            if (((d.b.i0.x.e0.j) this.o).f62196e.q1().audience_count > 0) {
                this.G.setVisibility(0);
                this.D.setVisibility(0);
                this.D.setText(String.format(this.m.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((d.b.i0.x.e0.j) this.o).f62196e.q1().audience_count)));
            } else {
                this.G.setVisibility(8);
                this.D.setVisibility(8);
            }
            this.E.setVisibility(8);
            if (((d.b.i0.x.e0.j) this.o).f62196e.q1().openRecomReason == 1) {
                String str = ((d.b.i0.x.e0.j) this.o).f62196e.q1().recomReason;
                if (!StringUtils.isNull(str)) {
                    this.E.setVisibility(0);
                    this.E.setText(str);
                } else {
                    String C0 = ((d.b.i0.x.e0.j) this.o).f62196e.C0();
                    String I0 = ((d.b.i0.x.e0.j) this.o).f62196e.I0();
                    if (UtilHelper.isDecimal(C0) && UtilHelper.isDecimal(I0) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                        AppPosInfo c2 = d.b.i0.r2.a0.a.e().c();
                        String str2 = c2.latitude;
                        String str3 = c2.longitude;
                        if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && d.b.b.e.p.l.a(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(C0), Double.parseDouble(I0)) <= 50.0d) {
                            this.E.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                            this.E.setVisibility(0);
                        }
                    }
                }
            }
            F(this.w);
            o(this.m, TbadkCoreApplication.getInst().getSkinType());
            if (m.k(((d.b.i0.x.e0.j) this.o).f62196e.o0())) {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0105, 1);
            }
            Q();
            this.C.playAnimation();
            return;
        }
        this.w.setVisibility(8);
    }

    public void V(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null || this.p == null || this.K == null) {
            return;
        }
        r(bdUniqueId);
        z(bdUniqueId);
        CardUserInfoLayout cardUserInfoLayout = this.y;
        if (cardUserInfoLayout != null) {
            cardUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        this.K.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.K);
    }

    public void W(boolean z) {
        this.H = z;
    }

    public void X(int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.p;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.S = String.valueOf(i);
        }
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_home_page_ala_live_item_new;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62179e != i) {
            y(tbPageContext, i);
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.x);
            a2.h(R.string.J_X06);
            a2.d(R.color.CAM_X0205, R.color.CAM_X0206);
            d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.A);
            a3.f(R.dimen.L_X01);
            a3.e(R.color.CAM_X0401);
            a3.h(R.string.J_X05);
            a3.c(R.color.CAM_X0611);
            float g2 = d.b.b.e.p.l.g(b(), R.dimen.tbds31);
            SkinManager.setBackgroundEndColorToAutoColor(this.F, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0101);
            this.y.onChangeSkinType(l(), TbadkCoreApplication.getInst().getSkinType());
            this.B.setPlaceHolder(3);
            this.f62179e = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.x || view == this.p.getCommentContainer() || view == this.q.getCommentContainer()) {
            S(((d.b.i0.x.e0.j) this.o).n().q1().live_id, ((d.b.i0.x.e0.j) this.o).n().q1().roomId, this.H ? AlaLiveRoomActivityConfig.FROM_TYPE_HOME_CONCERN_TAB : AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY);
            m.l(this.z, ((d.b.i0.x.e0.j) this.o).f62196e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            if (((d.b.i0.x.e0.j) this.o).n() == null || ((d.b.i0.x.e0.j) this.o).n().q1() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
            statisticItem.param("obj_locate", this.H ? 2 : 1);
            statisticItem.param("obj_param1", ((d.b.i0.x.e0.j) this.o).n().q1().live_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.b.i0.m.e
    public void setPage(String str) {
    }
}
