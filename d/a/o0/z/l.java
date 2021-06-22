package d.a.o0.z;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import d.a.d.m.d;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.n0.z0.m0;
import d.a.o0.k2.f;
import java.util.ArrayList;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class l extends d.a.o0.z.b<d.a.o0.z.e0.l> implements View.OnClickListener, d.a.o0.o.e {
    public TbImageView A;
    public ImageView B;
    public TbCyberVideoView C;
    public TextView D;
    public LinearLayout E;
    public TextView F;
    public View G;
    public TextView H;
    public View I;
    public d.a.o0.k2.m J;
    public d.a.o0.z.e0.l K;
    public View L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public String R;
    public boolean S;
    public d.a.o0.k2.f T;
    public Animation U;
    public int V;
    public TextView W;
    public boolean X;
    public TextView Y;
    public String Z;
    public Handler a0;
    public CyberPlayerManager.OnPreparedListener b0;
    public CyberPlayerManager.OnInfoListener c0;
    public CyberPlayerManager.OnCompletionListener i0;
    public CyberPlayerManager.OnErrorListener j0;
    public VideoLoadingProgressView.c k0;
    public TbImageView.f l0;
    public d.a.d.m.d m;
    public Runnable m0;
    public ThreadCommentAndPraiseInfoLayout n;
    public Runnable n0;
    public View o;
    public CustomMessageListener o0;
    public FrameLayout p;
    public TbCyberVideoView.g p0;
    public ThreadGodReplyLayout q;
    public final View.OnClickListener q0;
    public LinearLayout r;
    public final View.OnClickListener r0;
    public NEGFeedBackView s;
    public CustomMessageListener s0;
    public String t;
    public final View.OnClickListener t0;
    public ThreadSourceShareAndPraiseLayout u;
    public f.b u0;
    public TbPageContext<?> v;
    public Animation.AnimationListener v0;
    public RelativeLayout w;
    public TextView x;
    public ThreadUserInfoLayout y;
    public HeadPendantClickableView z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.C == null || l.this.C.isPlaying()) {
                return;
            }
            l.this.m0(true, 1);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.m0(true, 4);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.c {
        public c() {
        }

        @Override // d.a.o0.k2.f.c
        public void a(int i2, int i3) {
            if (i3 >= i2) {
                l.this.m.I(false, false, "NEWINDEX");
            } else if (i2 == 0 || (i3 * 100) / i2 < 80 || i2 <= 15000) {
            } else {
                l lVar = l.this;
                lVar.s0(lVar.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.d.m.e.b bVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.d.m.e.b) || (bVar = (d.a.d.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || l.this.K == null || l.this.K.f67302e == null || !d2.equals(l.this.K.f67302e.o0())) {
                return;
            }
            d.a.d.m.d dVar = l.this.m;
            l lVar = l.this;
            dVar.K(lVar.N(lVar.K, bVar));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TbCyberVideoView.g {
        public e() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            l.this.stopPlay();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.K == null) {
                if (l.this.i() != null) {
                    l.this.i().a(view, l.this.K);
                    return;
                }
                return;
            }
            if (view == l.this.y.getUserName()) {
                l.this.K.k = 3;
            } else if (view == l.this.y.getHeaderImg()) {
                l.this.K.k = 4;
            } else {
                l.this.K.k = 1;
            }
            if (l.this.i() != null) {
                l.this.i().a(view, l.this.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.K != null) {
                l.this.K.k = 4;
            }
            if (l.this.i() != null) {
                l.this.i().a(view, l.this.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016477) {
                return;
            }
            l.this.S = false;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.K != null) {
                if (l.this.i() != null) {
                    l.this.i().a(view, l.this.K);
                }
                if (l.this.K.f67302e == null) {
                    return;
                }
                l lVar = l.this;
                if (view == lVar.u.f12544e) {
                    return;
                }
                d.a.o0.z.m.a(lVar.K.f67302e.o0());
                if (l.this.b0()) {
                    return;
                }
                d.a.o0.z.m.l(l.this.x, l.this.K.f67302e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.a.o0.z.m.l(l.this.q.getGodReplyContent(), l.this.K.i().o0(), R.color.CAM_X0106, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements f.b {
        public j() {
        }

        @Override // d.a.o0.k2.f.b
        public void a() {
            if (l.this.K == null || l.this.K.f67302e == null || l.this.K.f67302e.x1() == null) {
                return;
            }
            l.this.j0();
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
                l.this.U();
            } else if (i2 != 203) {
            } else {
                l.this.T();
            }
        }
    }

    /* renamed from: d.a.o0.z.l$l  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1815l implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1815l() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (l.this.A != null) {
                l.this.A.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class m implements CyberPlayerManager.OnPreparedListener {
        public m() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            if (l.this.C != null) {
                l.this.C.setVolume(0.0f, 0.0f);
            }
            l.this.q0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements CyberPlayerManager.OnInfoListener {
        public n() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (i2 == 3 || i2 == 904) {
                l.this.m0(false, 3);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements CyberPlayerManager.OnCompletionListener {
        public o() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            if (l.this.m.I(false, false, "NEWINDEX")) {
                return;
            }
            l.this.C.start();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements CyberPlayerManager.OnErrorListener {
        public p() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            l.this.m0(true, 4);
            l.this.P = false;
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements VideoLoadingProgressView.c {
        public q() {
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            l.this.q0();
        }
    }

    /* loaded from: classes4.dex */
    public class r implements d.InterfaceC0576d {
        public r() {
        }

        @Override // d.a.d.m.d.InterfaceC0576d
        public void a() {
            if (!l.this.X) {
                l.this.C.start();
            } else {
                l.this.startPlay();
            }
            l.this.X = false;
        }

        @Override // d.a.d.m.d.InterfaceC0576d
        public void b() {
        }

        @Override // d.a.d.m.d.InterfaceC0576d
        public void c() {
        }

        @Override // d.a.d.m.d.InterfaceC0576d
        public boolean d() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class s implements TbImageView.f {
        public s() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || l.this.A == null) {
                return;
            }
            l.this.A.setDefaultBgResource(0);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class t extends d.a.n0.b1.m.f {
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(l lVar, int i2, String str, String str2) {
            super(i2, str);
            this.l = str2;
        }

        @Override // d.a.n0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.a.n0.l.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
            TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
        }

        @Override // d.a.n0.b1.m.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
            textPaint.setUnderlineText(false);
        }
    }

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.s = null;
        this.M = 3;
        this.N = 0;
        this.O = 1;
        this.P = false;
        this.Q = true;
        this.V = 100;
        this.X = false;
        this.a0 = new k(Looper.getMainLooper());
        this.b0 = new m();
        this.c0 = new n();
        this.i0 = new o();
        this.j0 = new p();
        this.k0 = new q();
        this.l0 = new s();
        this.m0 = new a();
        this.n0 = new b();
        this.o0 = new d(2921395);
        this.p0 = new e();
        this.q0 = new f();
        this.r0 = new g();
        this.s0 = new h(2016477);
        this.t0 = new i();
        this.u0 = new j();
        this.v0 = new animation.Animation$AnimationListenerC1815l();
        this.v = tbPageContext;
        View m2 = m();
        RelativeLayout relativeLayout = (RelativeLayout) m2.findViewById(R.id.layout_root);
        this.w = relativeLayout;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) relativeLayout.findViewById(R.id.card_home_page_video_user_pendant_header);
        this.z = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.z.getHeadView().setIsRound(true);
            this.z.getHeadView().setDrawBorder(false);
            this.z.getHeadView().setDefaultResource(17170445);
            this.z.getHeadView().setRadius(d.a.c.e.p.l.g(this.v.getPageActivity(), R.dimen.ds70));
            this.z.getHeadView().setPlaceHolder(1);
        }
        this.z.setHasPendantStyle();
        if (this.z.getPendantView() != null) {
            this.z.getPendantView().setIsRound(true);
            this.z.getPendantView().setDrawBorder(false);
        }
        d.a.o0.k2.m mVar = new d.a.o0.k2.m((ViewGroup) m2.findViewById(R.id.auto_video_loading_container));
        this.J = mVar;
        mVar.f(this.k0);
        this.x = (TextView) m2.findViewById(R.id.text_title);
        this.y = (ThreadUserInfoLayout) m2.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.s = new NEGFeedBackView(k());
        int g2 = d.a.c.e.p.l.g(b(), R.dimen.tbds120);
        d.a.c.e.p.l.g(b(), R.dimen.tbds16);
        this.s.l(this.w, g2, 0);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) m2.findViewById(R.id.text_bottom);
        this.n = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.n.setLayoutParams(layoutParams);
        }
        this.n.setOnClickListener(this);
        this.n.setReplyTimeVisible(false);
        this.n.setShowPraiseNum(true);
        this.n.setNeedAddPraiseIcon(true);
        this.n.setNeedAddReplyIcon(true);
        this.n.setShareVisible(true);
        this.n.setShareReportFrom(3);
        this.n.setForumAfterClickListener(this.t0);
        this.n.setFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) m2.findViewById(R.id.text_bottom_threaad);
        this.u = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12545f.setOnClickListener(this);
        this.u.setFrom(1);
        this.u.setShareReportFrom(3);
        this.u.setForumAfterClickListener(this.t0);
        this.o = m2.findViewById(R.id.divider_below_reply_number_layout);
        FrameLayout frameLayout = (FrameLayout) m2.findViewById(R.id.frame_video);
        this.p = frameLayout;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        int k2 = d.a.c.e.p.l.k(this.v.getPageActivity()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.width = k2;
        layoutParams2.height = (int) (k2 * 0.5625d);
        this.p.setLayoutParams(layoutParams2);
        TbImageView tbImageView = (TbImageView) m2.findViewById(R.id.image_video);
        this.A = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.A.setGifIconSupport(false);
        this.A.setEvent(this.l0);
        this.A.setRadius(d.a.c.e.p.l.g(this.v.getPageActivity(), R.dimen.tbds10));
        this.A.setConrers(15);
        this.A.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.A.setBorderSurroundContent(true);
        this.A.setDrawBorder(true);
        this.B = (ImageView) m2.findViewById(R.id.image_video_play);
        this.w.setOnClickListener(this);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(b());
        this.C = tbCyberVideoView;
        tbCyberVideoView.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.p.addView(this.C.getView(), 0);
        this.C.getView().setLayoutParams(layoutParams3);
        this.C.setContinuePlayEnable(true);
        this.C.setOnPreparedListener(this.b0);
        this.C.setOnInfoListener(this.c0);
        this.C.setOnCompletionListener(this.i0);
        this.C.setOnErrorListener(this.j0);
        this.C.setOnSurfaceDestroyedListener(this.p0);
        d.a.o0.k2.f fVar = new d.a.o0.k2.f();
        this.T = fVar;
        fVar.l(this.C);
        this.T.i(this.u0);
        this.D = (TextView) m2.findViewById(R.id.text_video_duration);
        this.E = (LinearLayout) m2.findViewById(R.id.duration_container);
        this.F = (TextView) m2.findViewById(R.id.text_video_play_count);
        this.L = m2.findViewById(R.id.auto_video_black_mask);
        this.H = (TextView) m2.findViewById(R.id.auto_video_error_tips);
        this.I = m2.findViewById(R.id.auto_video_error_background);
        this.r = (LinearLayout) m2.findViewById(R.id.video_card_content_layout);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.v.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.U = loadAnimation;
        loadAnimation.setAnimationListener(this.v0);
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) m2.findViewById(R.id.card_god_reply_layout);
        this.q = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        this.G = m2.findViewById(R.id.divider_line);
        this.W = (TextView) m2.findViewById(R.id.txt_video_num_during_playing);
        this.C.getView().setOnClickListener(this);
        this.Y = (TextView) m2.findViewById(R.id.nani_video_icon);
        d.a.d.m.d dVar = new d.a.d.m.d(b(), this.p);
        this.m = dVar;
        dVar.G(new r());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.d.m.a N(d.a.o0.z.e0.l lVar, d.a.d.m.e.b bVar) {
        a2 a2Var;
        int i2;
        VideoInfo x1;
        int i3;
        int i4;
        if (lVar == null || (a2Var = lVar.f67302e) == null || bVar == null) {
            return null;
        }
        int c2 = bVar.c();
        int b2 = bVar.b();
        int a2 = bVar.a();
        int i5 = -1;
        if (a2 != -1) {
            int i6 = c2 != -1 ? (a2 - c2) - 1 : -1;
            if (b2 != -1) {
                i5 = i6;
                i2 = (b2 - a2) - 1;
                x1 = a2Var.x1();
                if (x1 == null) {
                    int intValue = x1.video_width.intValue();
                    i4 = x1.video_height.intValue();
                    i3 = intValue;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("video_vid", a2Var.o0());
                hashMap.put("video_title", a2Var.A1());
                hashMap.put("forum_id", String.valueOf(a2Var.c0()));
                hashMap.put("forum_name", a2Var.i0());
                hashMap.put("up_distance", String.valueOf(i5));
                hashMap.put("down_distance", String.valueOf(i2));
                d.a.d.m.a h2 = d.a.d.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
                h2.a(hashMap);
                return h2;
            }
            i5 = i6;
        }
        i2 = -1;
        x1 = a2Var.x1();
        if (x1 == null) {
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("video_vid", a2Var.o0());
        hashMap2.put("video_title", a2Var.A1());
        hashMap2.put("forum_id", String.valueOf(a2Var.c0()));
        hashMap2.put("forum_name", a2Var.i0());
        hashMap2.put("up_distance", String.valueOf(i5));
        hashMap2.put("down_distance", String.valueOf(i2));
        d.a.d.m.a h22 = d.a.d.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
        h22.a(hashMap2);
        return h22;
    }

    public int O(int i2) {
        return d.a.o0.o.d.c().b(this.t, i2);
    }

    public String P() {
        return this.R;
    }

    public View Q() {
        return this.p;
    }

    public final void R() {
        d.a.o0.z.e0.l lVar = this.K;
        if (lVar == null || lVar.f67302e == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.K.f67302e);
        videoItemData.mRecomExtra = this.K.B();
        videoItemData.mRecomAbTag = this.K.z();
        videoItemData.mRecomSource = this.K.F();
        videoItemData.mRecomWeight = this.K.O();
        arrayList.add(videoItemData);
        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f67284f.getPageActivity(), arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", this.K.g(), "index");
        if (this.K.f67302e.V() != null) {
            videoPlayActivityConfig.setNid(this.K.f67302e.V().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
    }

    public final void S() {
        a2 a2Var;
        d.a.o0.z.e0.l lVar = this.K;
        if (lVar == null || (a2Var = lVar.f67302e) == null || a2Var.o0() == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K.f67302e);
        videoSerializeVideoThreadInfo.source = this.K.F();
        videoSerializeVideoThreadInfo.extra = this.K.B();
        videoSerializeVideoThreadInfo.ab_tag = this.K.z();
        videoSerializeVideoThreadInfo.weight = this.K.O();
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (this.r.getX() + Q().getX());
        videoCardViewInfo.cardViewY = (int) (m().getY() + this.r.getY() + Q().getY());
        videoCardViewInfo.cardViewWidth = Q().getWidth();
        videoCardViewInfo.cardViewHeight = Q().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.v.getPageActivity(), (d.a.c.e.p.k.isEmpty(this.Z) || !this.Z.equals("hottopic")) ? "index" : "hottopic", this.K.f67302e.z1(), d.a.o0.z.m.g(), this.K.g(), videoSerializeVideoThreadInfo);
        if (this.K.i() != null && this.K.i().V() != null) {
            videoMiddlePageActivityConfig.setNid(this.K.i().V().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public final void T() {
        if (m().getParent() == null) {
            stopPlay();
            return;
        }
        this.a0.removeMessages(203);
        int currentPositionSync = this.C.getCurrentPositionSync();
        if (currentPositionSync != this.N) {
            this.N = currentPositionSync;
            m0(false, 3);
        } else {
            m0(false, 2);
        }
        this.a0.sendEmptyMessageDelayed(203, 3000L);
    }

    public final void U() {
        this.a0.removeMessages(202);
        if (this.C.getCurrentPositionSync() > this.V) {
            m0(false, 3);
            this.a0.sendEmptyMessageDelayed(203, 3000L);
            return;
        }
        this.a0.sendEmptyMessageDelayed(202, 20L);
    }

    public final void V(View view) {
        if (i() != null) {
            i().a(view, this.K);
        }
        if (!d.a.c.e.p.j.z()) {
            d.a.c.e.p.l.L(this.v.getPageActivity(), R.string.no_network_guide);
        } else {
            R();
        }
    }

    public final void X(View view) {
        d.a.o0.z.e0.l lVar = this.K;
        if (lVar != null) {
            lVar.k = 1;
        }
        if (i() != null) {
            i().a(view, this.K);
        }
        d.a.o0.z.e0.l lVar2 = this.K;
        if (lVar2 == null || lVar2.f67302e == null) {
            return;
        }
        if (!b0()) {
            d.a.o0.z.m.a(this.K.f67302e.o0());
            d.a.o0.z.m.l(this.x, this.K.f67302e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
        PbActivityConfig addLocateParam = new PbActivityConfig(this.v.getPageActivity()).createFromThreadCfg(this.K.f67302e, null, d.a.o0.z.m.g(), 18003, true, false, false).addLocateParam(this.K.g());
        addLocateParam.setVideo_source(this.K.V == 0 ? "index" : "hot_juhe");
        if (this.K.V == 0) {
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
        }
        addLocateParam.setForumId(String.valueOf(this.K.f67302e.c0()));
        addLocateParam.setForumName(this.K.f67302e.i0());
        addLocateParam.setStartFrom(this.l);
        if (view == this.q) {
            addLocateParam.setJumpGodReply(true);
        }
        this.v.sendMessage(new CustomMessage(2004001, addLocateParam));
    }

    public final void Y() {
        d.a.o0.z.e0.l lVar;
        a2 a2Var;
        i0();
        h0();
        if (this.A == null || this.p == null || this.C == null) {
            return;
        }
        if (d.a.n0.r.k.c().g() && (lVar = this.K) != null && (a2Var = lVar.f67302e) != null && a2Var.x1() != null) {
            this.A.setPlaceHolder(3);
            this.A.U(this.K.f67302e.x1().thumbnail_url, 10, false);
            this.p.setVisibility(0);
            stopPlay();
            this.R = this.K.f67302e.x1().video_url;
            if (a0()) {
                this.R = this.K.f67302e.y1().video_url;
            }
            if (StringUtils.isNull(this.K.f67302e.x1().video_url)) {
                m0(true, 4);
            }
            this.C.setThreadDataForStatistic(this.K.f67302e);
        } else {
            this.p.setVisibility(8);
        }
        this.m.B();
        this.T.j(new c());
    }

    public final void Z(View view) {
        if (i() != null) {
            i().a(view, this.K);
        }
        if (!d.a.c.e.p.j.z()) {
            d.a.c.e.p.l.L(this.v.getPageActivity(), R.string.no_network_guide);
        } else {
            S();
        }
    }

    public final boolean a0() {
        a2 a2Var;
        d.a.o0.z.e0.l lVar = this.K;
        return (lVar == null || (a2Var = lVar.f67302e) == null || a2Var.y1() == null || TextUtils.isEmpty(this.K.f67302e.y1().video_url)) ? false : true;
    }

    public final boolean b0() {
        d.a.o0.z.e0.l lVar = this.K;
        return lVar.T && !lVar.U;
    }

    public boolean c0() {
        return this.P;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: d0 */
    public void n(d.a.o0.z.e0.l lVar) {
        this.K = lVar;
        e0();
    }

    public final void e0() {
        a2 a2Var;
        a2 a2Var2;
        d.a.o0.z.e0.l lVar = this.K;
        if (lVar != null && (a2Var = lVar.f67302e) != null && a2Var.T() != null) {
            this.w.setVisibility(0);
            Y();
            if (!b0() && d.a.o0.z.m.k(this.K.f67302e.o0())) {
                d.a.o0.z.m.l(this.x, this.K.f67302e.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.a.o0.z.m.l(this.q.getGodReplyContent(), this.K.i().o0(), R.color.CAM_X0106, R.color.CAM_X0109);
            }
            this.K.i().Z2();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.K.i().n1());
            if (this.K.i().A() && !StringUtils.isNull(this.K.i().z1())) {
                String str = d.a.n0.r.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.i().z1();
                spannableStringBuilder.append((CharSequence) this.K.i().B(new t(this, 2, str, str)));
            }
            this.x.setOnTouchListener(new d.a.o0.v3.i(spannableStringBuilder));
            this.x.setText(spannableStringBuilder);
            this.y.j(this.K.i());
            this.y.setUserAfterClickListener(this.q0);
            if (this.y.getHeaderImg() != null) {
                this.y.getHeaderImg().setAfterClickListener(this.r0);
                if (this.y.getIsSimpleThread()) {
                    this.y.getHeaderImg().setVisibility(8);
                    this.z.setVisibility(8);
                } else if (this.K.i() != null && this.K.i().T() != null && this.K.i().T().getPendantData() != null && !StringUtils.isNull(this.K.i().T().getPendantData().a())) {
                    this.y.getHeaderImg().setVisibility(4);
                    this.z.setVisibility(0);
                    this.z.setData(this.K.i());
                } else {
                    this.z.setVisibility(8);
                    this.y.getHeaderImg().setVisibility(0);
                    if (this.K.i().r1 > 0 && this.K.i().s1 == 0) {
                        this.K.i().T().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                        this.y.getHeaderImg().setData(this.K.i(), false);
                    } else {
                        this.y.getHeaderImg().setData(this.K.i());
                        this.y.getHeaderImg().setOnInterceptClickEventListener(null);
                    }
                }
            }
            this.D.setText(StringHelper.stringForVideoTime(this.K.f67302e.x1().video_duration.intValue() * 1000));
            this.F.setText(String.format(this.v.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.K.f67302e.x1().play_count.intValue())));
            if (this.s != null && this.K.i() != null) {
                v0 v0Var = new v0();
                v0Var.n(this.K.i().z1());
                v0Var.k(this.K.i().c0());
                v0Var.m(this.K.i().M0());
                v0Var.j(this.K.feedBackReasonMap);
                this.s.setData(v0Var);
                this.s.setFirstRowSingleColumn(true);
                this.s.setVisibility(this.Q ? 0 : 8);
            }
            this.q.setData(this.K.i().C1());
            p0(O(1));
            o(this.v, TbadkCoreApplication.getInst().getSkinType());
            if (d.a.o0.z.m.k(this.K.f67302e.o0())) {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0105, 1);
            }
            d.a.o0.z.e0.l lVar2 = this.K;
            if ((lVar2 == null || (a2Var2 = lVar2.f67302e) == null || a2Var2.x1() == null || this.K.f67302e.x1().is_vertical.intValue() != 1) ? false : true) {
                this.Y.setVisibility(0);
                if (a0()) {
                    this.Y.setText(String.format("%s | %s", this.v.getResources().getString(R.string.nani_video), this.v.getResources().getString(R.string.video_preview)));
                    return;
                } else {
                    this.Y.setText(this.v.getString(R.string.nani_video));
                    return;
                }
            } else if (a0()) {
                this.Y.setVisibility(0);
                this.Y.setText(this.v.getString(R.string.video_preview));
                return;
            } else {
                this.Y.setVisibility(8);
                return;
            }
        }
        this.w.setVisibility(8);
    }

    public void g0(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        this.s0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.s0);
        this.o0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.o0);
        l0(bdUniqueId);
    }

    public int getCurrentPosition() {
        TbCyberVideoView tbCyberVideoView = this.C;
        if (tbCyberVideoView == null) {
            return 0;
        }
        return tbCyberVideoView.getCurrentPosition();
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.card_home_page_auto_video_view_new;
    }

    public final void h0() {
        this.a0.removeMessages(202);
        this.a0.removeMessages(203);
    }

    public final void i0() {
        d.a.c.e.m.e.a().removeCallbacks(this.m0);
        d.a.c.e.m.e.a().removeCallbacks(this.n0);
    }

    public boolean isPlaying() {
        TbCyberVideoView tbCyberVideoView = this.C;
        if (tbCyberVideoView == null) {
            return false;
        }
        return tbCyberVideoView.isPlaying();
    }

    public final void j0() {
        d.a.o0.z.e0.l lVar = this.K;
        if (lVar == null || lVar.f67302e == null) {
            return;
        }
        d.a.o0.k2.o oVar = new d.a.o0.k2.o();
        oVar.f60712a = this.K.V == 0 ? "index" : "hot_juhe";
        oVar.f60714c = this.K.f67302e.z1();
        oVar.f60715d = this.K.f67302e.c0() + "";
        oVar.f60716e = TbadkCoreApplication.getCurrentAccount();
        d.a.o0.z.e0.l lVar2 = this.K;
        a2 a2Var = lVar2.f67302e;
        oVar.f60717f = a2Var.T0;
        String str = a2Var.V0;
        oVar.l = str;
        oVar.f60718g = str;
        oVar.f60719h = a2Var.U0;
        oVar.f60720i = "";
        oVar.k = lVar2.B();
        if (this.K.f67302e.x1() != null) {
            oVar.m = this.K.f67302e.x1().video_md5;
        }
        d.a.o0.k2.h.e(this.K.f67302e.x1().video_md5, "", "1", oVar, this.C.getPcdnState());
    }

    public void k0(boolean z) {
        this.Q = z;
    }

    public final void l0(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout = this.y;
        if (threadUserInfoLayout != null) {
            threadUserInfoLayout.setPageUniqueId(bdUniqueId);
        }
        TbImageView tbImageView = this.A;
        if (tbImageView != null) {
            tbImageView.setPageId(bdUniqueId);
        }
        NEGFeedBackView nEGFeedBackView = this.s;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
    }

    public final void m0(boolean z, int i2) {
        a2 a2Var;
        if (this.B == null || this.A == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.O != i2) {
            this.O = i2;
            d.a.c.e.m.e.a().removeCallbacks(this.n0);
            d.a.c.e.m.e.a().removeCallbacks(this.m0);
            if (i2 == 2) {
                this.B.setVisibility(8);
                this.U.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.L.setVisibility(0);
                this.E.setVisibility(0);
                this.W.setVisibility(8);
                this.J.g();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                d.a.c.e.m.e.a().postDelayed(this.n0, 60000L);
            } else if (i2 == 3) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.U);
                this.L.setVisibility(8);
                this.E.setVisibility(8);
                d.a.o0.z.e0.l lVar = this.K;
                if (lVar != null && lVar.i() != null && this.K.i().r1 > 0) {
                    this.W.setVisibility(0);
                }
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                d.a.o0.z.e0.l lVar2 = this.K;
                if (lVar2 != null && (a2Var = lVar2.f67302e) != null && a2Var.x1() != null) {
                    this.K.f67302e.x1().video_length.intValue();
                    this.K.f67302e.x1().video_duration.intValue();
                    this.K.f67302e.z1();
                }
            } else if (i2 == 4) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.U);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                d.a.c.e.m.e.a().postDelayed(this.m0, 2000L);
            } else {
                this.B.setVisibility(0);
                this.U.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.L.setVisibility(0);
                this.E.setVisibility(0);
                this.J.b();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
            }
            d.a.o0.z.e0.l lVar3 = this.K;
            if (lVar3 == null || lVar3.i() == null || this.K.i().r1 <= 0) {
                return;
            }
            this.E.setVisibility(8);
        }
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.M != i2) {
            SkinManager.setBackgroundResource(this.w, R.drawable.addresslist_item_bg);
            SkinManager.setImageResource(this.B, R.drawable.btn_icon_play_video_n);
            SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.W, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.I, R.color.common_color_10014);
            SkinManager.setBackgroundColor(this.G, R.color.CAM_X0204);
            TextView textView = this.Y;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.Y, R.drawable.video_play_count_bg);
            }
            if (this.H != null) {
                this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
            }
            this.q.l();
            NEGFeedBackView nEGFeedBackView = this.s;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.q();
            }
            this.y.h();
            this.n.onChangeSkinType();
            this.u.f();
            this.A.setPlaceHolder(3);
            this.z.getHeadView().setPlaceHolder(1);
            this.M = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a2 a2Var;
        a2 a2Var2;
        d.a.o0.z.e0.l lVar = this.K;
        if (lVar != null && (a2Var2 = lVar.f67302e) != null && a2Var2.r1 > 0) {
            if (i() != null) {
                i().a(view, this.K);
            }
            this.v.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.v.getPageActivity(), this.K.f67302e.z1(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, d.a.o0.z.m.g(), this.K.g())));
            return;
        }
        if (view == this.w || view == this.q) {
            X(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
        }
        if (view == this.C.getView()) {
            d.a.o0.z.e0.l lVar2 = this.K;
            if (lVar2 != null) {
                lVar2.k = 5;
            }
            d.a.o0.z.e0.l lVar3 = this.K;
            boolean z = false;
            if (lVar3 != null && (a2Var = lVar3.f67302e) != null && a2Var.x1() != null && this.K.f67302e.x1().is_vertical.intValue() == 1) {
                z = true;
            }
            if (z) {
                V(this.C.getView());
            } else if (UtilHelper.isGotoVideoMiddlePage()) {
                Z(this.C.getView());
            } else {
                X(m());
            }
        }
    }

    public void p0(int i2) {
        a2 a2Var;
        d.a.o0.z.e0.l lVar = this.K;
        if (lVar == null || (a2Var = lVar.f67302e) == null) {
            return;
        }
        if (i2 == 1) {
            if (a2Var.r1 > 0) {
                this.u.f12545f.setShowPraiseNum(false);
                this.u.f12545f.setShareVisible(false);
                this.W.setText(StringHelper.numFormatOverWan(this.K.f67302e.r1));
                this.W.setVisibility(0);
            } else {
                this.u.f12545f.setShowPraiseNum(true);
                this.u.f12545f.setShareVisible(true);
                this.W.setVisibility(8);
            }
            this.u.g(this.K.f67302e);
            this.n.setVisibility(8);
            this.y.l(false);
            return;
        }
        this.u.setVisibility(8);
        this.y.l(true);
        if (this.K.f67302e.r1 > 0) {
            this.n.setShowPraiseNum(false);
            this.n.setShareVisible(false);
            this.W.setText(StringHelper.numFormatOverWan(this.K.f67302e.r1));
            this.W.setVisibility(0);
        } else {
            this.n.setShowPraiseNum(true);
            this.n.setShareVisible(true);
            this.W.setVisibility(8);
        }
        if (this.n.setData(this.K.f67302e)) {
            this.o.setVisibility(8);
        } else {
            this.o.setVisibility(0);
        }
    }

    public final void q0() {
        TbCyberVideoView tbCyberVideoView = this.C;
        if (tbCyberVideoView == null || !this.P) {
            return;
        }
        try {
            tbCyberVideoView.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int c2 = d.a.o0.k2.n.d().c(this.R);
        this.V = (c2 <= 100 || this.C.getDuration() <= c2) ? 100 : 100;
        this.a0.sendEmptyMessageDelayed(202, 20L);
    }

    public final void s0(d.a.o0.z.e0.l lVar) {
        a2 a2Var;
        if (lVar == null || (a2Var = lVar.f67302e) == null || a2Var.o0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, a2Var.o0()));
    }

    @Override // d.a.o0.z.b
    public void setFrom(String str) {
        this.Z = str;
    }

    @Override // d.a.o0.o.e
    public void setPage(String str) {
        this.t = str;
    }

    public void startPlay() {
        d.a.o0.z.e0.l lVar;
        a2 a2Var;
        if (this.P || (lVar = this.K) == null || (a2Var = lVar.f67302e) == null || a2Var.x1() == null || this.C == null) {
            return;
        }
        if (this.m.r()) {
            this.m.E();
            this.X = true;
            return;
        }
        this.X = false;
        this.C.stopPlayback();
        if (m0.b(1, this.R)) {
            m0(true, 2);
            if (StringUtils.isNull(this.R)) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "index").param("tid", this.K.l));
                this.R = this.K.f67302e.x1().video_url;
            }
            this.P = true;
            this.C.setVideoPath(this.R, this.K.l);
            d.a.o0.k2.f fVar = this.T;
            if (fVar != null) {
                fVar.m();
            }
            j0();
        }
    }

    public void stopPlay() {
        this.X = false;
        i0();
        h0();
        m0(true, 1);
        TbCyberVideoView tbCyberVideoView = this.C;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.stopPlayback();
            d.a.o0.k2.f fVar = this.T;
            if (fVar != null) {
                fVar.n();
            }
        }
        this.P = false;
        this.m.L();
    }
}
