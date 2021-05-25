package d.a.n0.r0.n1.g;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import d.a.m0.r.q.a2;
import d.a.m0.z0.c0;
import d.a.m0.z0.m0;
import d.a.n0.k2.f;
import d.a.n0.z.z;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.a.n0.z.b<a2> implements z, Object {
    public TbPageContext<?> A;
    public RelativeLayout B;
    public LinearLayout C;
    public TextView D;
    public TbImageView E;
    public ImageView F;
    public TbCyberVideoView G;
    public TextView H;
    public View I;
    public d.a.n0.k2.m J;
    public a2 K;
    public View L;
    public TextView M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public String R;
    public d.a.n0.k2.f S;
    public Animation T;
    public d.a.n0.r0.o2.i U;
    public TbImageView V;
    public String W;
    public String X;
    public String Y;
    public View Z;
    public boolean a0;
    public int b0;
    public Handler c0;
    public CyberPlayerManager.OnPreparedListener d0;
    public CyberPlayerManager.OnInfoListener e0;
    public CyberPlayerManager.OnCompletionListener f0;
    public CyberPlayerManager.OnErrorListener g0;
    public VideoLoadingProgressView.c h0;
    public String i0;
    public TbImageView.f j0;
    public ViewTreeObserver.OnGlobalLayoutListener k0;
    public Runnable l0;
    public ThreadCommentAndPraiseInfoLayout m;
    public Runnable m0;
    public ThreadSourceShareAndPraiseLayout n;
    public TbCyberVideoView.g n0;
    public ThreadUserInfoLayout o;
    public View.OnClickListener o0;
    public ThreadGodReplyLayout p;
    public final View.OnClickListener p0;
    public HeadPendantClickableView q;
    public final View.OnClickListener q0;
    public View r;
    public f.b r0;
    public TextView s;
    public Animation.AnimationListener s0;
    public FrameLayout t;
    public LinearLayout u;
    public ThreadSkinView v;
    public TextView w;
    public LinearLayout x;
    public View y;
    public TextView z;

    /* renamed from: d.a.n0.r0.n1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1520a implements TbImageView.f {
        public C1520a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || a.this.E == null) {
                return;
            }
            a.this.E.setDefaultBgResource(0);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout = a.this.t;
            if (frameLayout == null || frameLayout.getLayoutParams() == null || a.this.t.getVisibility() == 8) {
                return;
            }
            a.this.t.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = a.this.t.getLayoutParams();
            if (a.this.t.getWidth() <= 0) {
                return;
            }
            layoutParams.height = (int) (a.this.t.getWidth() * 0.5625d);
            a.this.t.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a2 f59104e;

        public c(a2 a2Var) {
            this.f59104e = a2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.A != null) {
                a.this.f63441f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(a.this.f63441f.getContext(), "", this.f59104e.v1, true)));
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.m0.b1.m.f {
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2, String str, String str2) {
            super(i2, str);
            this.l = str2;
        }

        @Override // d.a.m0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.a.m0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
            TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "2"));
        }

        @Override // d.a.m0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.G == null || a.this.G.isPlaying()) {
                return;
            }
            a.this.f0(true, 1);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a0();
            a.this.f0(true, 4);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TbCyberVideoView.g {
        public g() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            a.this.stopPlay();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.K == null || StringUtils.isNull(a.this.K.i0())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.A.getPageActivity()).createNormalCfg(a.this.K.i0(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            if (a.this.q0 != null) {
                a.this.q0.onClick(view);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.h() != null) {
                a.this.h().a(view, a.this.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.K == null || a.this.h() == null) {
                return;
            }
            a.this.h().a(view, a.this.K);
        }
    }

    /* loaded from: classes4.dex */
    public class k extends Handler {
        public k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 202) {
                a.this.Q();
            } else if (i2 != 203) {
            } else {
                a.this.P();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements f.b {
        public l() {
        }

        @Override // d.a.n0.k2.f.b
        public void a() {
            a.this.d0();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Animation.AnimationListener {
        public m() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.P != 3 || a.this.E == null) {
                return;
            }
            a.this.E.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class n implements CyberPlayerManager.OnPreparedListener {
        public n() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (a.this.G != null) {
                a.this.G.setVolume(0.0f, 0.0f);
            }
            a.this.j0();
        }
    }

    /* loaded from: classes4.dex */
    public class o implements CyberPlayerManager.OnInfoListener {
        public o() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3) {
                a.this.f0(false, 3);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements CyberPlayerManager.OnCompletionListener {
        public p() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            a.this.G.start();
        }
    }

    /* loaded from: classes4.dex */
    public class q implements CyberPlayerManager.OnErrorListener {
        public q() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            a.this.a0();
            a.this.f0(true, 4);
            a.this.Q = false;
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class r implements VideoLoadingProgressView.c {
        public r() {
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            a.this.j0();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnAttachStateChangeListener {
        public s() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameLayout frameLayout = a.this.t;
            if (frameLayout != null) {
                frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(a.this.k0);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FrameLayout frameLayout = a.this.t;
            if (frameLayout != null) {
                frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(a.this.k0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = a.this.m;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements ThreadCommentAndPraiseInfoLayout.j {
        public u() {
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            if (a.this.Z != null) {
                SkinManager.setBackgroundColor(a.this.Z, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.N = 3;
        this.O = 0;
        this.P = 1;
        this.Q = false;
        this.c0 = new k(Looper.getMainLooper());
        this.d0 = new n();
        this.e0 = new o();
        this.f0 = new p();
        this.g0 = new q();
        this.h0 = new r();
        this.j0 = new C1520a();
        this.k0 = new b();
        this.l0 = new e();
        this.m0 = new f();
        this.n0 = new g();
        this.o0 = new h();
        this.p0 = new i();
        this.q0 = new j();
        this.r0 = new l();
        this.s0 = new m();
        p(bdUniqueId);
        this.l = 3;
        this.A = tbPageContext;
        View l2 = l();
        this.y = l2.findViewById(R.id.divider_line);
        this.B = (RelativeLayout) l2.findViewById(R.id.layout_root);
        this.V = (TbImageView) l2.findViewById(R.id.frs_normal_item_star_view);
        this.C = (LinearLayout) l2.findViewById(R.id.video_card_content_layout);
        this.B.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) this.B.findViewById(R.id.card_home_page_video_user_pendant_header);
        this.q = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.q.getHeadView().setIsRound(true);
            this.q.getHeadView().setDrawBorder(false);
            this.q.getHeadView().setDefaultResource(17170445);
            this.q.getHeadView().setRadius(d.a.c.e.p.l.g(this.A.getPageActivity(), R.dimen.ds70));
        }
        this.q.setHasPendantStyle();
        if (this.q.getPendantView() != null) {
            this.q.getPendantView().setIsRound(true);
            this.q.getPendantView().setDrawBorder(false);
        }
        TextView textView = (TextView) l2.findViewById(R.id.thread_info_bar_name);
        this.s = textView;
        textView.setVisibility(8);
        this.s.setOnClickListener(this.o0);
        d.a.n0.k2.m mVar = new d.a.n0.k2.m((ViewGroup) l2.findViewById(R.id.auto_video_loading_container));
        this.J = mVar;
        mVar.f(this.h0);
        this.D = (TextView) l2.findViewById(R.id.text_title);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) l2.findViewById(R.id.text_bottom);
        this.m = threadCommentAndPraiseInfoLayout;
        threadCommentAndPraiseInfoLayout.setForumAfterClickListener(this.q0);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) l2.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.o = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.r = l2.findViewById(R.id.divider_below_reply_number_layout);
        if (this.m.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
        }
        this.m.setOnClickListener(this);
        this.m.setReplyTimeVisible(false);
        this.m.setShowPraiseNum(true);
        this.m.setNeedAddPraiseIcon(true);
        this.m.setNeedAddReplyIcon(true);
        this.m.setIsBarViewVisible(false);
        this.m.setShareVisible(true);
        this.m.setShareReportFrom(1);
        this.m.setStType("frs_page");
        this.m.setFrom(2);
        this.m.R = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) l2.findViewById(R.id.text_bottom_threaad);
        this.n = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12401f.setOnClickListener(this);
        this.n.setFrom(2);
        this.n.setShareReportFrom(1);
        this.n.setSourceFromForPb(3);
        this.n.setStType("frs_page");
        this.n.setHideBarName(true);
        FrameLayout frameLayout = (FrameLayout) l2.findViewById(R.id.frame_video);
        this.t = frameLayout;
        frameLayout.setOnClickListener(this);
        this.t.addOnAttachStateChangeListener(new s());
        TbImageView tbImageView = (TbImageView) l2.findViewById(R.id.image_video);
        this.E = tbImageView;
        tbImageView.setPageId(i());
        this.E.setDrawCorner(true);
        this.E.setPlaceHolder(3);
        this.E.setEvent(this.j0);
        this.E.setGifIconSupport(false);
        this.F = (ImageView) l2.findViewById(R.id.image_video_play);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(b());
        this.G = tbCyberVideoView;
        tbCyberVideoView.setStageType("2003");
        e0();
        this.G.setContinuePlayEnable(true);
        this.G.setOnPreparedListener(this.d0);
        this.G.setOnCompletionListener(this.f0);
        this.G.setOnErrorListener(this.g0);
        this.G.setOnInfoListener(this.e0);
        this.G.setOnSurfaceDestroyedListener(this.n0);
        d.a.n0.k2.f fVar = new d.a.n0.k2.f();
        this.S = fVar;
        fVar.l(this.G);
        this.S.i(this.r0);
        this.L = l2.findViewById(R.id.auto_video_black_mask);
        this.H = (TextView) l2.findViewById(R.id.auto_video_error_tips);
        this.I = l2.findViewById(R.id.auto_video_error_background);
        this.u = (LinearLayout) l2.findViewById(R.id.video_card_content_layout);
        this.v = (ThreadSkinView) l2.findViewById(R.id.frs_thread_skin);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.A.getPageActivity(), R.anim.fade_out_video_cover);
        this.T = loadAnimation;
        loadAnimation.setAnimationListener(this.s0);
        this.w = (TextView) l2.findViewById(R.id.text_video_duration);
        this.M = (TextView) l2.findViewById(R.id.text_video_play_count);
        this.x = (LinearLayout) l2.findViewById(R.id.duration_container);
        d.a.n0.r0.o2.i iVar = new d.a.n0.r0.o2.i(tbPageContext, this.B);
        this.U = iVar;
        iVar.d(i());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) l2.findViewById(R.id.card_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        View findViewById = l2.findViewById(R.id.thread_multi_del_mask_view);
        this.Z = findViewById;
        findViewById.setOnClickListener(new t());
        this.m.setOnSelectStatusChangeListener(new u());
        this.z = (TextView) l2.findViewById(R.id.nani_video_icon);
    }

    public int K(int i2) {
        return d.a.n0.o.d.c().b(this.X, i2);
    }

    public String L() {
        return this.R;
    }

    public View M() {
        return this.t;
    }

    public final void N() {
        if (this.K != null) {
            String str = this.b0 == 501 ? "frs_tab" : "frs";
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(this.K);
            arrayList.add(videoItemData);
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f63441f.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, str);
            if (this.K.V() != null) {
                videoPlayActivityConfig.setNid(this.K.V().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
        }
    }

    public final void O() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K);
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (l().getX() + M().getX() + this.u.getX());
        videoCardViewInfo.cardViewY = (int) (l().getY() + M().getY() + this.u.getY());
        videoCardViewInfo.cardViewWidth = M().getWidth();
        videoCardViewInfo.cardViewHeight = M().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.A.getPageActivity(), this.b0 == 501 ? "frs_tab" : "frs", this.K.y1(), d.a.n0.z.m.g(), "", videoSerializeVideoThreadInfo);
        if (this.K.V() != null) {
            videoMiddlePageActivityConfig.setNid(this.K.V().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public final void P() {
        if (l().getParent() == null) {
            stopPlay();
            return;
        }
        this.c0.removeMessages(203);
        int currentPosition = this.G.getCurrentPosition();
        if (currentPosition != this.O) {
            this.O = currentPosition;
            f0(false, 3);
        } else {
            f0(false, 2);
        }
        this.c0.sendEmptyMessageDelayed(203, 3000L);
    }

    public final void Q() {
        this.c0.removeMessages(202);
        if (this.G.getCurrentPosition() > 0) {
            f0(false, 3);
            this.c0.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.c0.sendEmptyMessageDelayed(202, 20L);
    }

    public final void R(View view) {
        if (this.K != null) {
            StatisticItem statisticItem = new StatisticItem("c11100");
            statisticItem.param("tid", this.K.o0());
            statisticItem.param("fid", this.K.c0() + "");
            TiebaStatic.log(statisticItem);
        }
        if (h() != null) {
            h().a(view, this.K);
        }
        if (view == this.t) {
            if (!d.a.c.e.p.j.z()) {
                d.a.c.e.p.l.L(this.A.getPageActivity(), R.string.no_network_guide);
            } else {
                O();
            }
        }
    }

    public final void S(View view) {
        if (h() != null) {
            h().a(view, this.K);
        }
        if (!d.a.c.e.p.j.z()) {
            d.a.c.e.p.l.L(this.A.getPageActivity(), R.string.no_network_guide);
        } else {
            N();
        }
    }

    public final void T(View view) {
        a2 a2Var = this.K;
        if (a2Var != null) {
            if (a2Var.Z1()) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).param("fid", String.valueOf(this.K.c0())).param("obj_type", 2));
            } else {
                StatisticItem statisticItem = new StatisticItem("c11100");
                statisticItem.param("tid", this.K.o0());
                statisticItem.param("fid", this.K.c0() + "");
                TiebaStatic.log(statisticItem);
            }
            if (this.K.T() != null && this.K.T().getGodUserData() != null && this.K.T().getGodUserData().getType() == 2) {
                TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", this.K.o0()));
            }
        }
        if (h() != null) {
            h().a(view, this.K);
        }
        a2 a2Var2 = this.K;
        if (a2Var2 != null) {
            d.a.n0.z.m.a(a2Var2.o0());
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0109, 1);
            c0.b(this.K.o0());
            String str = null;
            String valueOf = String.valueOf(this.K.c0());
            OriginalForumInfo originalForumInfo = this.K.D1;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                str = valueOf;
            }
            String str2 = "floor5";
            if (this.K.B0() > 0 && d.a.n0.e3.n0.e.c()) {
                PbActivityConfig createHistoryCfg = new PbActivityConfig(this.A.getPageActivity()).createHistoryCfg(this.K.y1(), String.valueOf(this.K.B0()), false, true, "frs_page");
                if (this.b0 == 501) {
                    str2 = "frs_tab";
                } else if (!this.K.Z1()) {
                    str2 = "frs";
                }
                createHistoryCfg.setVideo_source(str2);
                createHistoryCfg.setFromSmartFrs(this.K.w2());
                createHistoryCfg.setSmartFrsPosition(this.K.l1());
                createHistoryCfg.setForumId(valueOf);
                createHistoryCfg.setFromForumId(str);
                createHistoryCfg.setStartFrom(this.l);
                if (view == this.p) {
                    createHistoryCfg.setJumpGodReply(true);
                }
                this.A.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.A.getPageActivity()).createFromThreadCfg(this.K, this.i0, "frs_page", 18003, true, false, false);
            if (this.b0 == 501) {
                str2 = "frs_tab";
            } else if (!this.K.Z1()) {
                str2 = "frs";
            }
            createFromThreadCfg.setVideo_source(str2);
            createFromThreadCfg.setFromSmartFrs(this.K.w2());
            createFromThreadCfg.setSmartFrsPosition(this.K.l1());
            createFromThreadCfg.setForumId(valueOf);
            createFromThreadCfg.setFromForumId(str);
            createFromThreadCfg.setStartFrom(this.l);
            if (view == this.p) {
                createFromThreadCfg.setJumpGodReply(true);
            }
            this.A.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void V() {
        a2 a2Var;
        b0();
        a0();
        if (this.E == null || this.t == null || this.G == null) {
            return;
        }
        if (d.a.m0.r.k.c().g() && (a2Var = this.K) != null && a2Var.w1() != null) {
            this.t.setVisibility(0);
            this.E.setPlaceHolder(3);
            this.E.V(this.K.w1().thumbnail_url, 10, false);
            stopPlay();
            String str = this.K.w1().video_url;
            this.R = str;
            if (StringUtils.isNull(str)) {
                f0(true, 4);
                TiebaStatic.log(new StatisticItem("c12026").param("tid", this.K.o0()));
            }
            this.G.setThreadDataForStatistic(this.K);
            return;
        }
        this.t.setVisibility(8);
    }

    public boolean W() {
        return this.Q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: X */
    public void m(a2 a2Var) {
        this.K = a2Var;
        Y();
    }

    public final void Y() {
        a2 a2Var = this.K;
        if (a2Var != null && a2Var.T() != null) {
            this.B.setVisibility(0);
            this.B.setOnClickListener(this);
            V();
            if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.Y)) {
                this.K.l4(this.W, this.Y);
            }
            boolean z = true;
            this.K.V2(false, true);
            SpannableStringBuilder m1 = this.K.m1();
            if (this.K.A() && !StringUtils.isNull(this.K.y1())) {
                String str = d.a.m0.r.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.y1();
                m1.append((CharSequence) this.K.B(new d(this, 2, str, str)));
            }
            this.D.setOnTouchListener(new d.a.n0.v3.i(m1));
            this.D.setText(m1);
            this.U.a(this.K);
            i0(this.K);
            this.o.j(this.K);
            if (this.o.getHeaderImg() != null) {
                if (this.o.getIsSimpleThread()) {
                    this.o.getHeaderImg().setVisibility(8);
                    this.q.setVisibility(8);
                } else if (this.K.T() != null && this.K.T().getPendantData() != null && !StringUtils.isNull(this.K.T().getPendantData().a())) {
                    this.o.getHeaderImg().setVisibility(4);
                    this.q.setVisibility(0);
                    this.q.setData(this.K);
                } else {
                    this.q.setVisibility(8);
                    this.o.getHeaderImg().setVisibility(0);
                    this.o.getHeaderImg().setData(this.K);
                }
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
            this.o.setUserAfterClickListener(this.p0);
            h0(K(1));
            this.w.setText(StringHelper.stringForVideoTime(this.K.w1().video_duration.intValue() * 1000));
            this.M.setText(String.format(this.A.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.K.w1().play_count.intValue())));
            this.p.setData(this.K.B1());
            this.p.k();
            if (d.a.n0.z.m.k(this.K.o0())) {
                SkinManager.setViewTextColor(this.D, R.color.CAM_X0109, 1);
                d.a.n0.z.m.l(this.p.getGodReplyContent(), this.K.o0(), R.color.CAM_X0106, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.D, R.color.CAM_X0105, 1);
            }
            a2 a2Var2 = this.K;
            if ((a2Var2 == null || a2Var2.w1() == null || this.K.w1().is_vertical.intValue() != 1) ? false : false) {
                this.z.setVisibility(0);
            } else {
                this.z.setVisibility(8);
            }
            if ((d.a.n0.r0.b.e().g() || d.a.n0.r0.a.h().j()) && this.m.isInFrsAllThread()) {
                this.Z.setVisibility(0);
                if (!this.K.l2() && !this.K.m2() && !this.K.A2()) {
                    this.Z.setBackgroundResource(R.color.transparent);
                } else {
                    SkinManager.setBackgroundColor(this.Z, R.color.CAM_X0201);
                }
            } else {
                this.Z.setVisibility(8);
            }
            n(this.A, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        this.B.setVisibility(8);
    }

    public void Z(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        if (bdUniqueId == null || this.m == null || (threadUserInfoLayout = this.o) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
        this.i0 = str;
    }

    public final void a0() {
        this.c0.removeMessages(202);
        this.c0.removeMessages(203);
    }

    public final void b0() {
        d.a.c.e.m.e.a().removeCallbacks(this.l0);
        d.a.c.e.m.e.a().removeCallbacks(this.m0);
    }

    public final void d0() {
        a2 a2Var = this.K;
        if (a2Var == null || a2Var.w1() == null) {
            return;
        }
        String str = this.K.Z1() ? "floor5" : "frs";
        if (this.b0 == 501) {
            str = "frs_tab";
        }
        d.a.n0.k2.o oVar = new d.a.n0.k2.o();
        oVar.f56898a = str;
        oVar.f56900c = this.K.y1();
        oVar.f56901d = this.K.c0() + "";
        oVar.f56902e = TbadkCoreApplication.getCurrentAccount();
        a2 a2Var2 = this.K;
        oVar.f56903f = a2Var2.S0;
        String str2 = a2Var2.U0;
        oVar.l = str2;
        oVar.f56904g = str2;
        oVar.f56905h = a2Var2.T0;
        oVar.f56906i = "";
        oVar.m = a2Var2.w1().video_md5;
        d.a.n0.k2.h.e(this.K.w1().video_md5, "", "1", oVar, this.G.getPcdnState());
    }

    public final void e0() {
        TbCyberVideoView tbCyberVideoView = this.G;
        if (tbCyberVideoView == null || tbCyberVideoView.getParent() != null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.t.addView(this.G.getView(), 0);
        this.G.getView().setLayoutParams(layoutParams);
    }

    public final void f0(boolean z, int i2) {
        if (this.F == null || this.E == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.P != i2) {
            this.P = i2;
            d.a.c.e.m.e.a().removeCallbacks(this.m0);
            d.a.c.e.m.e.a().removeCallbacks(this.l0);
            if (i2 == 2) {
                this.F.setVisibility(8);
                this.T.cancel();
                this.E.clearAnimation();
                this.E.setVisibility(0);
                this.L.setVisibility(0);
                this.x.setVisibility(0);
                this.J.g();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                d.a.c.e.m.e.a().postDelayed(this.m0, 60000L);
            } else if (i2 == 3) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.x.setVisibility(8);
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                a2 a2Var = this.K;
                if (a2Var == null || a2Var.w1() == null) {
                    return;
                }
                this.K.w1().video_length.intValue();
                this.K.w1().video_duration.intValue();
                this.K.y1();
            } else if (i2 == 4) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                d.a.c.e.m.e.a().postDelayed(this.l0, 2000L);
            } else {
                this.F.setVisibility(0);
                this.x.setVisibility(0);
                this.T.cancel();
                this.E.clearAnimation();
                this.E.setVisibility(0);
                this.L.setVisibility(0);
                this.J.b();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
            }
        }
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    public void g0(d.a.n0.k2.o oVar) {
        TbCyberVideoView tbCyberVideoView = this.G;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.setVideoStatData(oVar);
        }
    }

    public int getCurrentPosition() {
        TbCyberVideoView tbCyberVideoView = this.G;
        if (tbCyberVideoView == null) {
            return 0;
        }
        return tbCyberVideoView.getCurrentPosition();
    }

    public void h0(int i2) {
        a2 a2Var = this.K;
        if (a2Var == null) {
            return;
        }
        if (i2 == 1) {
            this.m.setVisibility(8);
            this.n.g(this.K);
            this.r.setVisibility(8);
            return;
        }
        this.m.setData(a2Var);
        this.r.setVisibility(8);
        this.n.setVisibility(8);
    }

    public final void i0(a2 a2Var) {
        TbImageView tbImageView = this.V;
        if (tbImageView == null) {
            return;
        }
        if (a2Var == null) {
            tbImageView.setVisibility(8);
        } else if (!StringUtils.isNull(a2Var.u1)) {
            d.a.n0.r0.o2.i iVar = this.U;
            if (iVar != null && iVar.b() && (this.V.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
                layoutParams.rightMargin = d.a.c.e.p.l.g(this.A.getContext(), R.dimen.tbds106);
                this.V.setLayoutParams(layoutParams);
            }
            this.V.setVisibility(0);
            this.V.setImageDrawable(null);
            this.V.V(a2Var.u1, 10, false);
            this.V.setOnClickListener(new c(a2Var));
        } else {
            this.V.setVisibility(8);
        }
    }

    public boolean isPlaying() {
        TbCyberVideoView tbCyberVideoView = this.G;
        if (tbCyberVideoView == null) {
            return false;
        }
        return tbCyberVideoView.isPlaying();
    }

    public final void j0() {
        TbCyberVideoView tbCyberVideoView = this.G;
        if (tbCyberVideoView == null || !this.Q) {
            return;
        }
        try {
            tbCyberVideoView.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.c0.sendEmptyMessageDelayed(202, 20L);
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.N != i2) {
            SkinManager.setBackgroundResource(this.B, R.drawable.addresslist_item_bg);
            SkinManager.setImageResource(this.F, R.drawable.btn_icon_play_video_n);
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.M, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.I, R.color.common_color_10014);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            if (this.H != null) {
                this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.n;
            if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                this.n.f();
            }
            this.m.onChangeSkinType();
            this.N = i2;
            this.o.h();
            HeadPendantClickableView headPendantClickableView = this.q;
            if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.q.getHeadView() instanceof TbImageView)) {
                this.q.getHeadView().setPlaceHolder(1);
            }
            this.E.setPlaceHolder(3);
            this.U.c();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.B && view != this.m.getCommentNumView() && view != this.C) {
            if (view == this.t) {
                a2 a2Var = this.K;
                boolean z = false;
                if (a2Var != null && a2Var.w1() != null && this.K.w1().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    S(view);
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    R(this.t);
                } else {
                    T(this.t);
                }
            } else {
                ThreadGodReplyLayout threadGodReplyLayout = this.p;
                if (view == threadGodReplyLayout) {
                    T(threadGodReplyLayout);
                }
            }
        } else {
            T(this.B);
        }
        a2 a2Var2 = this.K;
        if (a2Var2 != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, a2Var2));
        }
    }

    @Override // d.a.n0.z.z
    public void q(int i2) {
        this.l = i2;
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.m;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.R = i2;
            threadCommentAndPraiseInfoLayout.setFrom(2);
        }
        ThreadUserInfoLayout threadUserInfoLayout = this.o;
        if (threadUserInfoLayout != null) {
            threadUserInfoLayout.setFrom(3);
        }
    }

    public void setPage(String str) {
        this.X = str;
    }

    public void startPlay() {
        a2 a2Var;
        TbCyberVideoView tbCyberVideoView;
        if (this.Q || (a2Var = this.K) == null || a2Var.w1() == null || (tbCyberVideoView = this.G) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        if (m0.d()) {
            if (this.a0 || d.a.m0.r.d0.b.j().k("auto_play_video_frs", 0) == 1) {
                f0(true, 2);
                if (StringUtils.isNull(this.R)) {
                    TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "frs").param("tid", this.K.o0()));
                    this.R = this.K.w1().video_url;
                }
                this.Q = true;
                this.G.setVideoPath(this.R, this.K.o0());
                d.a.n0.k2.f fVar = this.S;
                if (fVar != null) {
                    fVar.m();
                }
                d0();
            }
        }
    }

    public void stopPlay() {
        b0();
        a0();
        f0(true, 1);
        TbCyberVideoView tbCyberVideoView = this.G;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            d.a.n0.k2.f fVar = this.S;
            if (fVar != null) {
                fVar.n();
            }
        }
        this.Q = false;
    }
}
