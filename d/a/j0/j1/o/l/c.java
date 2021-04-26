package d.a.j0.j1.o.l;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.tencent.connect.common.Constants;
import d.a.i0.r.s.a;
import d.a.i0.z0.m0;
import d.a.j0.s2.w;
import java.lang.ref.WeakReference;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class c {
    public static int s0;
    public static CallStateReceiver t0;
    public View A;
    public Animation E;
    public Animation F;
    public p G;
    public GestureDetector I;
    public WindowManager J;
    public View K;
    public View L;
    public TextView M;
    public SeekBar N;
    public ImageView O;
    public ImageView P;
    public AudioManager Q;
    public int S;
    public String V;
    public String W;
    public d.a.j0.j2.j X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55802a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public SwipeBackLayout.c f55803b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.j1.o.l.o f55804c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f55805d;

    /* renamed from: e  reason: collision with root package name */
    public View f55806e;
    public WeakReference<Context> e0;

    /* renamed from: f  reason: collision with root package name */
    public TbCyberVideoView f55807f;

    /* renamed from: g  reason: collision with root package name */
    public View f55808g;

    /* renamed from: h  reason: collision with root package name */
    public VideoListMediaControllerView f55809h;

    /* renamed from: i  reason: collision with root package name */
    public View f55810i;
    public View j;
    public FrameLayout k;
    public FrameLayout.LayoutParams l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public View p;
    public View r;
    public ImageView t;
    public String u;
    public TbImageView v;
    public CyberPlayerManager.OnPreparedListener w;
    public d.a.j0.j1.o.l.m x;
    public ImageView y;
    public TextView z;
    public int q = 0;
    public boolean s = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public int H = 0;
    public int R = 0;
    public int T = 0;
    public int U = 0;
    public boolean d0 = false;
    public boolean f0 = true;
    public CyberPlayerManager.OnPreparedListener g0 = new g();
    public Runnable h0 = new h();
    public CyberPlayerManager.OnCompletionListener i0 = new i();
    public CyberPlayerManager.OnErrorListener j0 = new j();
    public Runnable k0 = new k();
    public TbCyberVideoView.g l0 = new l();
    public View.OnClickListener m0 = new m();
    public boolean n0 = false;
    public Animation.AnimationListener o0 = new b();
    public Animation.AnimationListener p0 = new animation.Animation$AnimationListenerC1322c();
    public Runnable q0 = new d();
    public CustomMessageListener r0 = new e(2016503);

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public a(c cVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (c.this.p == null) {
                return;
            }
            c.this.p.setVisibility(8);
            c.this.D = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: d.a.j0.j1.o.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1322c implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1322c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.C = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.l0();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.o0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean onTouchEvent = c.this.I.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1) {
                c cVar = c.this;
                if (cVar.s && cVar.B) {
                    if (c.this.R == 1 && c.this.U != 0) {
                        c cVar2 = c.this;
                        cVar2.R(cVar2.U == 1 ? 1000.0f : -1000.0f, false);
                        c.this.U = 0;
                        c.this.T = 0;
                    }
                    if (!c.this.f55807f.isPlaying() && 8 == c.this.t.getVisibility()) {
                        c.this.t.setVisibility(0);
                    }
                }
                c.this.q0();
            }
            return onTouchEvent;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements CyberPlayerManager.OnPreparedListener {
        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared() {
            d.a.c.e.m.e.a().removeCallbacks(c.this.h0);
            d.a.c.e.m.e.a().post(c.this.h0);
            d.a.c.e.m.e.a().removeCallbacks(c.this.k0);
            if (c.this.f55807f == null || c.this.f55809h == null) {
                return;
            }
            if (!c.this.d0) {
                c cVar = c.this;
                if (!cVar.s) {
                    cVar.f55807f.setVolume(0.0f, 0.0f);
                    m0.e(c.this.e0, false);
                    c.this.f55809h.o(c.this.H, c.this.f55807f.getDuration());
                    if (c.this.H != 0) {
                        c.this.f55807f.seekTo(c.this.H);
                    }
                    if (c.this.w == null) {
                        c.this.w.onPrepared();
                        return;
                    }
                    return;
                }
            }
            c.this.f55807f.setVolume(1.0f, 1.0f);
            m0.e(c.this.e0, true);
            c.this.f55809h.o(c.this.H, c.this.f55807f.getDuration());
            if (c.this.H != 0) {
            }
            if (c.this.w == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f55807f.getCurrentPositionSync() > 100) {
                c.this.B = true;
                c.this.f55810i.setVisibility(8);
                c.this.j.setVisibility(8);
                c.this.f55808g.setVisibility(8);
                c.this.v.setVisibility(8);
                c.this.U();
                if (c.this.p != null) {
                    c.this.p.setVisibility(0);
                }
                c.this.f55809h.s();
                return;
            }
            d.a.c.e.m.e.a().postDelayed(c.this.h0, 20L);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements CyberPlayerManager.OnCompletionListener {
        public i() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            c.this.B = false;
            c.this.H = 0;
            c cVar = c.this;
            if (cVar.s) {
                cVar.q0();
                c.this.t0();
                c.this.X();
            } else {
                cVar.r0();
            }
            if (c.this.x != null) {
                c.this.x.a(c.this.u);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CyberPlayerManager.OnErrorListener {
        public j() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            c.this.j.setVisibility(0);
            c.this.f55808g.setVisibility(8);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j.setVisibility(0);
            c.this.f55808g.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TbCyberVideoView.g {
        public l() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            c.this.B = false;
            d.a.c.e.m.e.a().removeCallbacks(c.this.h0);
            d.a.c.e.m.e.a().removeCallbacks(c.this.k0);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != c.this.j.getId()) {
                if (view.getId() != c.this.t.getId() && view.getId() != c.this.n.getId()) {
                    if (view.getId() != c.this.o.getId()) {
                        if (view.getId() == c.this.y.getId()) {
                            TiebaStatic.log(new StatisticItem("c11713"));
                            c.this.Q0();
                            return;
                        } else if (view.getId() == c.this.f55805d.getId()) {
                            if (c.this.B || c.this.s) {
                                c.this.X();
                                return;
                            }
                            return;
                        } else if (view.getId() == c.this.m.getId()) {
                            c cVar = c.this;
                            if (cVar.s) {
                                return;
                            }
                            if (cVar.d0) {
                                c.this.f55807f.setVolume(0.0f, 0.0f);
                                c.this.m.setImageResource(R.drawable.card_icon_sound_close);
                                m0.e(c.this.e0, false);
                                c.this.d0 = false;
                                return;
                            }
                            c.this.f55807f.setVolume(1.0f, 1.0f);
                            c.this.m.setImageResource(R.drawable.card_icon_sound_open);
                            m0.e(c.this.e0, true);
                            c.this.d0 = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    c cVar2 = c.this;
                    if (cVar2.s) {
                        SwipeBackLayout.c cVar3 = cVar2.f55803b;
                        if (cVar3 != null) {
                            cVar3.enableSwipeBack();
                        }
                        TiebaStatic.log(new StatisticItem("c11714"));
                    } else {
                        SwipeBackLayout.c cVar4 = cVar2.f55803b;
                        if (cVar4 != null) {
                            cVar4.disableSwipeBack();
                        }
                        TiebaStatic.log(new StatisticItem("c11710"));
                        w.p().m().b(c.this.V, c.this.W);
                    }
                    c.this.Q0();
                    return;
                } else if (!d.a.c.e.p.j.z()) {
                    d.a.c.e.p.l.J(c.this.f55802a.getPageActivity(), c.this.f55802a.getString(R.string.neterror));
                    return;
                } else if (!c.this.f55807f.isPlaying()) {
                    if (c.this.B) {
                        c.this.s0();
                        return;
                    } else {
                        c.this.p0();
                        return;
                    }
                } else {
                    c.this.o0();
                    return;
                }
            }
            c.this.p0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements a.e {
        public n() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            c.this.n0 = true;
            c cVar = c.this;
            cVar.O0(cVar.u);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class o extends GestureDetector.SimpleOnGestureListener {
        public o() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            c cVar = c.this;
            if (cVar.s && cVar.B) {
                if (!c.this.f55807f.isPlaying() && c.this.t.getVisibility() == 0 && c.this.R == 1) {
                    c.this.t.setVisibility(8);
                }
                if (c.this.R == 0) {
                    c.this.F0();
                    if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                        c.this.R = 1;
                        c cVar2 = c.this;
                        cVar2.T = cVar2.f55807f.getCurrentPositionSync();
                        c.this.R(f2, true);
                    } else {
                        c.this.R = 2;
                        c.this.S(f3);
                    }
                } else if (c.this.R == 1) {
                    c.this.R(f2, true);
                } else if (c.this.R == 2) {
                    c.this.S(f3);
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return super.onScroll(motionEvent, motionEvent2, f2, f3);
        }

        public /* synthetic */ o(c cVar, f fVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface p {
        void a();

        void b();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        this.a0 = 0;
        this.e0 = null;
        this.f55802a = tbPageContext;
        this.e0 = new WeakReference<>(TbadkCoreApplication.getInst());
        View g0 = g0(tbPageContext);
        this.f55805d = g0;
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(g0);
        }
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f55805d.findViewById(R.id.videoView);
        this.f55807f = tbCyberVideoView;
        tbCyberVideoView.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.f55808g = this.f55805d.findViewById(R.id.video_list_layout_loading);
        VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.f55805d.findViewById(R.id.media_controller);
        this.f55809h = videoListMediaControllerView;
        videoListMediaControllerView.setPlayer(this.f55807f);
        this.f55810i = this.f55805d.findViewById(R.id.black_mask);
        View findViewById = this.f55805d.findViewById(R.id.layout_error);
        this.j = findViewById;
        findViewById.setOnClickListener(this.m0);
        this.k = (FrameLayout) this.f55805d.findViewById(R.id.danmu_container);
        ImageView imageView = (ImageView) this.f55805d.findViewById(R.id.img_play_icon);
        this.n = imageView;
        imageView.setOnClickListener(this.m0);
        ImageView imageView2 = (ImageView) this.f55805d.findViewById(R.id.img_sound_control);
        this.m = imageView2;
        imageView2.setOnClickListener(this.m0);
        ImageView imageView3 = (ImageView) this.f55805d.findViewById(R.id.card_img_full_screen);
        this.o = imageView3;
        imageView3.setOnClickListener(this.m0);
        this.p = this.f55805d.findViewById(R.id.card_layout_media_controller);
        this.f55806e = this.f55805d.findViewById(R.id.rl_control);
        this.f55807f.setOnPreparedListener(this.g0);
        this.f55807f.setOnCompletionListener(this.i0);
        this.f55807f.setOnErrorListener(this.j0);
        this.f55807f.setOnSurfaceDestroyedListener(this.l0);
        ImageView imageView4 = (ImageView) this.f55805d.findViewById(R.id.img_play);
        this.t = imageView4;
        imageView4.setOnClickListener(this.m0);
        TbImageView tbImageView = (TbImageView) this.f55805d.findViewById(R.id.video_thumbnail);
        this.v = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.Y = d.a.c.e.p.l.k(this.f55802a.getPageActivity());
        this.Z = d0(this.f55802a.getPageActivity());
        ImageView imageView5 = (ImageView) this.f55805d.findViewById(R.id.img_exit);
        this.y = imageView5;
        imageView5.setOnClickListener(this.m0);
        this.z = (TextView) this.f55805d.findViewById(R.id.video_title);
        View findViewById2 = this.f55805d.findViewById(R.id.layout_title);
        this.A = findViewById2;
        findViewById2.setVisibility(8);
        this.E = AnimationUtils.loadAnimation(this.f55802a.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.F = AnimationUtils.loadAnimation(this.f55802a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.J = (WindowManager) this.f55802a.getPageActivity().getSystemService("window");
        this.I = new GestureDetector(this.f55802a.getPageActivity(), new o(this, null));
        AudioManager audioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.Q = audioManager;
        this.S = audioManager.getStreamMaxVolume(3);
        this.c0 = this.Q.getStreamVolume(3);
        s0 = 100 / this.S;
        this.f55805d.setOnTouchListener(new f());
        d.a.j0.j2.j jVar = new d.a.j0.j2.j(this.f55802a.getPageActivity());
        this.X = jVar;
        jVar.j();
        this.a0 = d.a.c.e.p.l.g(this.f55802a.getPageActivity(), R.dimen.ds16);
        if (t0 == null) {
            t0 = new CallStateReceiver();
        }
        t0.register(this.f55802a.getPageActivity());
        this.f55802a.registerListener(this.r0);
    }

    public void A0(View view) {
        this.r = view;
    }

    public void B0() {
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.f55808g.setVisibility(8);
        this.t.setVisibility(0);
    }

    public void C0(boolean z) {
        this.f0 = z;
    }

    public void D0(int i2) {
        this.H = i2;
    }

    public void E0(SwipeBackLayout.c cVar) {
        this.f55803b = cVar;
    }

    public final void F0() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            this.f55805d.setSystemUiVisibility(2);
        } else if (i2 >= 16 && i2 <= 18) {
            this.f55805d.setSystemUiVisibility(4);
        } else {
            this.f55805d.setSystemUiVisibility(5894);
        }
    }

    public void G0(String str) {
        this.v.V(str, 17, false);
    }

    public void H0(d.a.j0.j1.o.l.o oVar) {
        this.f55804c = oVar;
    }

    public void I0(long j2) {
        StringHelper.numberUniformFormat(j2);
    }

    public void J0(String str) {
        this.u = str;
    }

    public void K0(int i2) {
        d.a.j0.j1.o.l.o oVar = this.f55804c;
        if (oVar == null || i2 == oVar.l()) {
            return;
        }
        this.f55804c.w();
    }

    public void L0() {
        this.f55805d.setVisibility(0);
    }

    public void M0() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f55806e.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.f55806e.setLayoutParams(layoutParams);
        this.o.setClickable(true);
        this.o.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = false;
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(0, R.id.card_img_full_screen);
            int dimension = (int) (this.f55802a.getResources().getDimension(R.dimen.ds16) + 0.5f);
            this.m.setPadding((int) (this.f55802a.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.f55802a.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.f55802a.getResources().getDimension(R.dimen.ds16) + 0.5f), dimension);
            this.m.setLayoutParams(layoutParams2);
        }
    }

    public void N0(boolean z) {
        if (z) {
            this.f55809h.setVisibility(0);
            this.n.setVisibility(0);
            return;
        }
        this.f55809h.setVisibility(8);
        this.n.setVisibility(8);
    }

    public void O0(String str) {
        this.f55807f.setVideoPath(str);
        this.f55807f.start();
        this.f55808g.setVisibility(0);
        this.v.setVisibility(0);
        this.t.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midplay);
        this.j.setVisibility(8);
        d.a.c.e.m.e.a().removeCallbacks(this.k0);
        d.a.c.e.m.e.a().postDelayed(this.k0, 60000L);
    }

    public final void P() {
        int i2 = this.R;
        if (i2 == 1) {
            if (this.K == null) {
                View inflate = LayoutInflater.from(this.f55802a.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                this.K = inflate;
                this.M = (TextView) inflate.findViewById(R.id.show_time);
                this.P = (ImageView) this.K.findViewById(R.id.arrow_icon);
            }
            if (this.K.getParent() == null) {
                this.J.addView(this.K, Z());
            }
        } else if (i2 == 2) {
            if (this.L == null) {
                View inflate2 = LayoutInflater.from(this.f55802a.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                this.L = inflate2;
                this.O = (ImageView) inflate2.findViewById(R.id.arrow_voice_icon);
                this.N = (SeekBar) this.L.findViewById(R.id.show_voice_seekbar);
            }
            if (this.L.getParent() == null) {
                this.J.addView(this.L, Z());
            }
        }
    }

    public void P0() {
        d.a.c.e.m.e.a().removeCallbacks(this.h0);
        d.a.c.e.m.e.a().removeCallbacks(this.k0);
        this.f55807f.stopPlayback();
        this.B = false;
        this.H = 0;
        r0();
    }

    public void Q() {
        if (this.r == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f55805d.getLayoutParams();
        this.l = layoutParams;
        layoutParams.width = this.r.getWidth();
        this.l.height = this.r.getHeight();
        int[] iArr = new int[2];
        this.r.getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams2 = this.l;
        layoutParams2.topMargin = iArr[1] - this.q;
        this.f55805d.setLayoutParams(layoutParams2);
    }

    public void Q0() {
        d.a.j0.j2.j jVar = this.X;
        if (jVar != null) {
            jVar.l();
        }
    }

    public final void R(float f2, boolean z) {
        if (z) {
            if (f2 > 0.0f) {
                this.T -= 1000;
                this.U = 1;
            } else {
                this.T += 1000;
                this.U = 2;
            }
            int i2 = this.T;
            if (i2 < 0) {
                this.T = 0;
            } else if (i2 > this.f55807f.getDuration()) {
                this.T = this.f55807f.getDuration();
            }
        }
        P();
        String m2 = this.f55809h.m(this.T);
        if (f2 > 0.0f) {
            this.P.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.P.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(m2)) {
            TextView textView = this.M;
            StringBuilder sb = new StringBuilder();
            sb.append(m2);
            sb.append("/");
            sb.append(this.f55809h.m(this.f55807f.getDuration()));
            textView.setText(sb);
        }
        this.f55809h.setCurrentDuration(this.T, !z);
    }

    public void R0(String str, String str2) {
        this.V = str;
        this.W = str2;
    }

    public final void S(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!this.f55807f.isPlaying()) {
            this.R = 0;
            return;
        }
        P();
        int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i6 > 0 && (i5 = this.b0) < 100) {
            this.b0 = i5 + 1;
        }
        int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i7 < 0 && (i4 = this.b0) > 0) {
            this.b0 = i4 - 1;
        }
        if (this.b0 % s0 == 0) {
            if (i6 > 0 && (i3 = this.c0) < this.S) {
                this.c0 = i3 + 1;
            }
            if (i7 < 0 && (i2 = this.c0) > 0) {
                this.c0 = i2 - 1;
            }
        }
        if (this.c0 > 0) {
            this.O.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.O.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.Q.setStreamVolume(3, this.c0, 0);
        this.N.setProgress(this.b0);
    }

    public void T() {
        U();
    }

    public final void U() {
        if (this.p == null) {
            return;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.q0);
        this.F.setAnimationListener(null);
        this.E.setAnimationListener(null);
        this.p.clearAnimation();
        this.D = false;
        this.C = false;
    }

    public void V() {
        P0();
        d.a.c.e.m.e.a().removeCallbacks(this.q0);
        d.a.c.e.m.e.a().removeCallbacks(this.h0);
        d.a.c.e.m.e.a().removeCallbacks(this.k0);
        this.X.k();
        t0.unregister(this.f55802a.getPageActivity());
    }

    public void W() {
        View view = this.p;
        if (view == null || this.C) {
            return;
        }
        if (this.D || view.getVisibility() != 0) {
            U();
            this.p.setVisibility(0);
            this.F.setAnimationListener(this.p0);
            this.p.startAnimation(this.F);
            this.C = true;
        }
    }

    public void X() {
        W();
        d.a.c.e.m.e.a().removeCallbacks(this.q0);
        if (this.f0) {
            d.a.c.e.m.e.a().postDelayed(this.q0, 3000L);
        }
    }

    public final void Y(BaseFragmentActivity baseFragmentActivity, boolean z) {
        if (baseFragmentActivity == null || baseFragmentActivity.getWindow() == null) {
            return;
        }
        if (z) {
            WindowManager.LayoutParams attributes = baseFragmentActivity.getWindow().getAttributes();
            attributes.flags |= 1024;
            baseFragmentActivity.getWindow().setAttributes(attributes);
            baseFragmentActivity.getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = baseFragmentActivity.getWindow().getAttributes();
        attributes2.flags &= -1025;
        baseFragmentActivity.getWindow().setAttributes(attributes2);
        baseFragmentActivity.getWindow().clearFlags(512);
        this.f55808g.getVisibility();
    }

    public final WindowManager.LayoutParams Z() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public boolean a0() {
        return this.B;
    }

    public View b0() {
        return this.p;
    }

    public View c0() {
        return this.r;
    }

    public int d0(Context context) {
        int i2 = 0;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            i2 = displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i2 == 0 ? d.a.c.e.p.l.i(context) : i2;
    }

    public boolean e0() {
        return !this.s;
    }

    public TbCyberVideoView f0() {
        return this.f55807f;
    }

    public View g0(TbPageContext<?> tbPageContext) {
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null);
    }

    public VideoListMediaControllerView h0() {
        return this.f55809h;
    }

    public void i0(int i2) {
        if (this.f55807f.getDuration() - i2 > 3000 || !this.s) {
            return;
        }
        U();
        View view = this.p;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void j0() {
        this.f55805d.setVisibility(8);
    }

    public void k0() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f55806e.getLayoutParams();
        if (d.a.j0.j1.o.k.e.c(this.f55802a.getPageActivity())) {
            layoutParams.bottomMargin = (int) (this.f55802a.getResources().getDimension(R.dimen.ds40) + 0.5f);
        } else {
            layoutParams.bottomMargin = (int) (this.f55802a.getResources().getDimension(R.dimen.ds30) + 0.5f);
        }
        this.f55806e.setLayoutParams(layoutParams);
        this.o.setClickable(false);
        this.o.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.alignWithParent = true;
            int dimension = (int) (this.f55802a.getResources().getDimension(R.dimen.ds16) + 0.5f);
            this.m.setPadding((int) (this.f55802a.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.f55802a.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.f55802a.getResources().getDimension(R.dimen.ds38) + 0.5f), dimension);
            layoutParams2.addRule(11);
            this.m.setLayoutParams(layoutParams2);
        }
    }

    public void l0() {
        View view = this.p;
        if (view == null || this.D || view.getVisibility() != 0) {
            return;
        }
        U();
        this.p.setVisibility(0);
        this.E.setAnimationListener(this.o0);
        this.p.startAnimation(this.E);
        this.D = true;
    }

    public boolean m0() {
        return this.f55805d.getVisibility() == 0;
    }

    public void n0(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        View view;
        if (configuration.orientation == 2) {
            this.s = true;
            this.m.setVisibility(8);
            this.f55807f.setVolume(1.0f, 1.0f);
            m0.e(this.e0, true);
            this.f55805d.setLayoutParams(new FrameLayout.LayoutParams(this.Z, this.Y));
            Y(baseFragmentActivity, true);
            this.A.setVisibility(0);
            v0(true);
            this.k.setVisibility(8);
            p pVar = this.G;
            if (pVar != null) {
                pVar.a();
            }
            X();
            this.o.setImageResource(R.drawable.icon_suoxiao);
            w0(this.a0);
            F0();
            return;
        }
        this.s = false;
        this.m.setVisibility(0);
        if (this.d0) {
            this.f55807f.setVolume(1.0f, 1.0f);
            m0.e(this.e0, true);
        } else {
            this.f55807f.setVolume(0.0f, 0.0f);
            m0.e(this.e0, false);
        }
        FrameLayout.LayoutParams layoutParams = this.l;
        if (layoutParams != null) {
            this.f55805d.setLayoutParams(layoutParams);
        }
        Y(baseFragmentActivity, false);
        this.A.setVisibility(8);
        v0(false);
        this.k.setVisibility(0);
        p pVar2 = this.G;
        if (pVar2 != null) {
            pVar2.b();
        }
        if (!this.B && (view = this.p) != null) {
            view.clearAnimation();
            this.p.setVisibility(4);
        }
        q0();
        this.o.setImageResource(R.drawable.icon_fangda);
        w0(0);
        this.f55805d.setSystemUiVisibility(0);
    }

    public void o0() {
        this.f55807f.pause();
        B0();
    }

    public void p0() {
        if (d.a.c.e.p.j.x() && !this.n0) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f55802a.getPageActivity());
            aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.setPositiveButton(R.string.confirm, new n());
            aVar.setNegativeButton(R.string.cancel, new a(this));
            aVar.create(this.f55802a).show();
            return;
        }
        O0(this.u);
    }

    public final void q0() {
        if (this.R == 0) {
            return;
        }
        this.R = 0;
        View view = this.K;
        if (view != null && view.getParent() != null) {
            try {
                this.J.removeView(this.K);
            } catch (IllegalArgumentException unused) {
            }
        }
        View view2 = this.L;
        if (view2 == null || view2.getParent() == null) {
            return;
        }
        try {
            this.J.removeView(this.L);
        } catch (IllegalArgumentException unused2) {
        }
    }

    public void r0() {
        if (this.p == null) {
            return;
        }
        this.f55810i.setVisibility(0);
        this.t.setVisibility(0);
        this.f55808g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(4);
        this.j.setVisibility(8);
        this.f55809h.q();
        this.v.setVisibility(0);
    }

    public void s0() {
        this.f55807f.start();
        this.n.setImageResource(R.drawable.icon_video_midplay);
        this.v.setVisibility(8);
        this.f55810i.setVisibility(8);
        this.f55808g.setVisibility(8);
        this.f55809h.s();
        this.t.setVisibility(8);
    }

    public void t0() {
        if (this.p == null) {
            return;
        }
        this.f55810i.setVisibility(0);
        this.t.setVisibility(0);
        this.f55808g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(0);
        this.j.setVisibility(8);
        this.f55809h.q();
        this.v.setVisibility(0);
    }

    public void u0(int i2) {
        this.q = i2;
    }

    public void v0(boolean z) {
        if (z) {
            this.f55805d.setOnClickListener(this.m0);
        } else {
            this.f55805d.setClickable(false);
        }
    }

    public final void w0(int i2) {
        VideoListMediaControllerView videoListMediaControllerView = this.f55809h;
        if (videoListMediaControllerView == null || !(videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f55809h.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        this.f55809h.setLayoutParams(layoutParams);
    }

    public void x0(p pVar) {
        this.G = pVar;
    }

    public void y0(d.a.j0.j1.o.l.m mVar) {
        this.x = mVar;
    }

    public void z0(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.w = onPreparedListener;
    }
}
