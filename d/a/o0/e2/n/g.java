package d.a.o0.e2.n;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.CustomFrameLayout;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import d.a.c.e.g.d;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.k1;
import d.a.o0.k2.c;
import d.a.o0.k2.f;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class g {
    public static VideoControllerView.c U = new h();
    public static c.d0 V = new i();
    public d.a.x.c A;
    public PbVideoWifiTipLayout B;
    public int C;
    public c.y F;
    public Handler H;
    public PbFullScreenFloatingHuajiAninationView I;
    public d.a.c.e.g.c K;
    public Bitmap L;
    public boolean M;
    public boolean O;
    public int R;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f57514a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.e2.k.e.f1.c f57515b;

    /* renamed from: c  reason: collision with root package name */
    public CustomFrameLayout f57516c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f57517d;

    /* renamed from: e  reason: collision with root package name */
    public c.y f57518e;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.k2.c f57521h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.k2.o f57522i;
    public d.a.o0.e2.n.e j;
    public boolean k;
    public a2 l;
    public a2 m;
    public String n;
    public float s;
    public int v;
    public double w;
    public View x;
    public float y;
    public boolean z;

    /* renamed from: f  reason: collision with root package name */
    public String f57519f = null;

    /* renamed from: g  reason: collision with root package name */
    public VideoInfo f57520g = null;
    public boolean o = false;
    public boolean p = false;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public long D = -1;
    public c.k0 E = new k();
    public boolean G = true;
    public PbFullScreenFloatingHuajiAninationView.c J = new n();
    public boolean N = false;
    public c.h0 P = new o();
    public CustomMessageListener Q = new p(2000994);
    public Animation.AnimationListener S = new u();
    public CustomMessageListener T = new m(2921414);

    /* loaded from: classes5.dex */
    public class a implements f.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoInfo f57523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57524b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a2 f57525c;

        public a(VideoInfo videoInfo, String str, a2 a2Var) {
            this.f57523a = videoInfo;
            this.f57524b = str;
            this.f57525c = a2Var;
        }

        @Override // d.a.o0.k2.f.c
        public void a(int i2, int i3) {
            if (g.this.D <= 0) {
                g.this.D = i3;
            }
            McnAdInfo mcnAdInfo = this.f57523a.mcn_ad_card;
            if (mcnAdInfo == null) {
                return;
            }
            boolean a2 = d.a.x.b.b().a(mcnAdInfo.jump_url);
            if (!g.this.z || a2 || g.this.p) {
                return;
            }
            boolean z = true;
            boolean z2 = g.this.D >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000;
            long j = i3;
            if ((j < mcnAdInfo.ad_start_time.longValue() * 1000 || j >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                if (g.this.A.c()) {
                    return;
                }
                d.a.x.a aVar = new d.a.x.a();
                aVar.f68665b = mcnAdInfo.card_title;
                aVar.f68666c = mcnAdInfo.button_title;
                aVar.f68667d = mcnAdInfo.jump_url;
                aVar.f68664a = mcnAdInfo.pic_url;
                aVar.f68669f = this.f57524b;
                aVar.f68668e = this.f57525c.z1();
                aVar.f68670g = 4;
                if (z2) {
                    g.this.A.f(aVar, (ViewGroup) g.this.f57521h.E0());
                } else {
                    g.this.A.e(aVar, (ViewGroup) g.this.f57521h.E0());
                }
            } else if (g.this.A.c()) {
                g.this.A.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.x {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.this.C > 0) {
                    g gVar = g.this;
                    gVar.M(gVar.C);
                    g gVar2 = g.this;
                    gVar2.j0(gVar2.C);
                    g.this.C = 0;
                }
                g.this.G = true;
            }
        }

        public b() {
        }

        @Override // d.a.o0.k2.c.x
        public void a() {
            g.this.f57517d.getBaseFragmentActivity().setSwipeBackEnabled(false);
            g.this.G = false;
            g gVar = g.this;
            gVar.C = gVar.P().getHeight();
        }

        @Override // d.a.o0.k2.c.x
        public void b() {
            g.this.f57517d.getBaseFragmentActivity().setSwipeBackEnabled(true);
            g.this.H.postDelayed(new a(), 200L);
            g.this.D = -1L;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.c0 {
        public c() {
        }

        @Override // d.a.o0.k2.c.c0
        public void a() {
            if (g.this.f57517d == null || g.this.m == null || StringUtils.isNull(g.this.m.o0())) {
                return;
            }
            g.this.f57517d.m5(g.this.m.o0());
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.e0 {
        public d() {
        }

        @Override // d.a.o0.k2.c.e0
        public void a(boolean z) {
            if (g.this.l != null) {
                g.this.l0(z ? "1" : "2");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public e() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", g.this.f57519f);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements d.a.c.e.g.b {
        public f() {
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 5;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 32;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            ImageView imageView = new ImageView(g.this.f57517d.getActivity());
            if (g.this.L == null) {
                try {
                    g.this.L = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.pb_video_guide_like);
                    imageView.setImageBitmap(g.this.L);
                } catch (Throwable unused) {
                }
            }
            return imageView;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    /* renamed from: d.a.o0.e2.n.g$g  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1340g implements d.a {
        public C1340g() {
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            g.this.K = null;
            if (g.this.L != null && !g.this.L.isRecycled()) {
                g.this.L.recycle();
            }
            g.this.L = null;
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements VideoControllerView.c {
        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements c.d0 {
        @Override // d.a.o0.k2.c.d0
        public void a() {
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.j0(gVar.P().getHeight());
        }
    }

    /* loaded from: classes5.dex */
    public class k implements c.k0 {
        public k() {
        }

        @Override // d.a.o0.k2.c.k0
        public void a() {
            if (g.this.f57517d == null || g.this.f57517d.A() == null || g.this.f57517d.A().C0() == null) {
                return;
            }
            PostData j = g.this.f57517d.A().C0().j();
            if (j == null && ListUtils.getCount(g.this.f57517d.A().C0().D()) > 1) {
                j = (PostData) ListUtils.getItem(g.this.f57517d.A().C0().D(), 0);
            }
            d.a.o0.e2.m.a.b(g.this.f57517d.A().C0(), j, 1, 1, 4);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.m0();
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.f57520g != null) {
                g gVar = g.this;
                gVar.b0(gVar.f57520g);
                g.this.f57521h.c1();
                g.this.f57521h.q0();
                if (g.this.x == null || g.this.x.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = g.this.x.getLayoutParams();
                layoutParams.height = g.this.v;
                g.this.x.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public n() {
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            g.this.N(false);
        }
    }

    /* loaded from: classes5.dex */
    public class o implements c.h0 {
        public o() {
        }

        @Override // d.a.o0.k2.c.h0
        public boolean a() {
            return false;
        }

        @Override // d.a.o0.k2.c.h0
        public boolean b() {
            if (g.this.w >= 1.0d) {
                if (!g.this.f57517d.checkUpIsLogin()) {
                    return true;
                }
                g.this.f57517d.Y4();
                if (g.this.f57517d.A() != null && g.this.f57517d.A().C0() != null && g.this.f57517d.A().C0().P() != null) {
                    d.a.o0.e2.h.p P = g.this.f57517d.A().C0().P();
                    if (g.this.I == null) {
                        g.this.I = new PbFullScreenFloatingHuajiAninationView(g.this.f57517d.getActivity());
                        g.this.I.setFloatingHuajiAninationListener(g.this.J);
                    }
                    g.this.I.f(!P.g());
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public p(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.c.e.p.j.z()) {
                if (g.this.f57521h != null) {
                    g.this.f57521h.w1();
                }
                if (!d.a.c.e.p.j.x() || g.this.f57521h == null || !g.this.f57521h.T0() || g.this.f57520g == null || g.this.f57520g.video_length.intValue() <= 0 || g.this.f57520g.video_duration.intValue() <= 0) {
                    return;
                }
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                double intValue = ((g.this.f57520g.video_length.intValue() * (1.0f - ((g.this.f57521h.B0() * 1.0f) / (g.this.f57520g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                if (intValue >= 0.1d) {
                    d.a.c.e.p.l.M(g.this.f57517d.getPageContext().getPageActivity(), String.format(g.this.f57517d.getPageContext().getString(R.string.pb_video_net_change_tip), decimalFormat.format(intValue)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements c.i0 {
        public q() {
        }

        @Override // d.a.o0.k2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            g.this.D = -1L;
        }
    }

    /* loaded from: classes5.dex */
    public class r implements c.f0 {
        public r() {
        }

        @Override // d.a.o0.k2.c.f0
        public void onStart() {
        }

        @Override // d.a.o0.k2.c.f0
        public void onStop() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
            if (r3 != 3) goto L9;
         */
        @Override // d.a.o0.k2.c.f0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (g.this.f57517d.getListView() != null && g.this.f57517d.getListView().getChildCount() > 0 && g.this.f57517d.getListView().getChildAt(0) == g.this.R()) {
                            g.this.f57517d.getListView().setSelectionFromTop(0, g.this.R + ((int) (motionEvent.getY() - g.this.y)));
                        }
                    }
                }
                g.this.y = 0.0f;
                g.this.R = 0;
            } else {
                g.this.y = motionEvent.getY();
                if (g.this.f57517d.getListView() != null && g.this.f57517d.getListView().getChildCount() > 0 && g.this.f57517d.getListView().getChildAt(0) == g.this.R()) {
                    g gVar = g.this;
                    gVar.R = gVar.R().getTop();
                }
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.M = true;
            g.this.B.setVisibility(8);
            g.this.w0();
            TiebaStatic.log("c12618");
        }
    }

    /* loaded from: classes5.dex */
    public class t implements c.y {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f57544a;

        public t(Animation animation) {
            this.f57544a = animation;
        }

        @Override // d.a.o0.k2.c.y
        public void a(boolean z) {
            if (!g.this.a0() || g.this.f57515b == null) {
                return;
            }
            this.f57544a.setAnimationListener(null);
            g.this.f57515b.i().clearAnimation();
            g.this.u0();
            if (z) {
                this.f57544a.setAnimationListener(g.this.S);
                g.this.f57515b.i().startAnimation(this.f57544a);
            }
        }

        @Override // d.a.o0.k2.c.y
        public void b() {
            if (g.this.a0()) {
                g.this.S();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements Animation.AnimationListener {
        public u() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            g.this.S();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public g(PbFragment pbFragment, d.a.o0.e2.k.e.f1.c cVar, VideoInfo videoInfo, long j2) {
        this.s = 0.0f;
        this.f57517d = pbFragment;
        this.f57515b = cVar;
        this.s = d.a.c.e.p.l.g(pbFragment.getActivity(), R.dimen.ds240);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.Q);
        this.T.setTag(pbFragment.getUniqueId());
        this.T.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.T);
        this.A = new d.a.x.c(pbFragment.getActivity());
    }

    public final void M(int i2) {
        if (P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57516c.getLayoutParams();
        if ((layoutParams.width == -1 && layoutParams.height == -1) || i2 == 0) {
            return;
        }
        if (i2 > 0) {
            this.O = false;
            if (this.v != P().getHeight()) {
                this.f57516c.setLayoutParams(new RelativeLayout.LayoutParams(d.a.c.e.p.l.k(this.f57517d.getActivity()), Math.min(this.v, P().getHeight() + i2)));
                this.f57521h.q0();
            }
        } else if (d.a.c.e.p.l.k(this.f57517d.getActivity()) * 0.5625d != P().getHeight()) {
            this.f57516c.setLayoutParams(new RelativeLayout.LayoutParams(d.a.c.e.p.l.k(this.f57517d.getActivity()), (int) Math.max(d.a.c.e.p.l.k(this.f57517d.getActivity()) * 0.5625d, P().getHeight() + i2)));
            this.f57521h.q0();
        }
    }

    public final void N(boolean z) {
        PbFragment pbFragment = this.f57517d;
        if (pbFragment != null) {
            pbFragment.l4();
        }
    }

    public void O() {
        d.a.o0.k2.c cVar = this.f57521h;
        if (cVar != null) {
            cVar.v0();
        }
        CustomFrameLayout customFrameLayout = this.f57516c;
        if (customFrameLayout != null) {
            customFrameLayout.clearAnimation();
        }
        d.a.o0.e2.n.e eVar = this.j;
        if (eVar != null) {
            eVar.k();
        }
        MessageManager.getInstance().unRegisterListener(this.Q);
        MessageManager.getInstance().unRegisterListener(this.T);
    }

    public View P() {
        return this.f57514a;
    }

    public int Q() {
        return this.v;
    }

    public View R() {
        return this.x;
    }

    public void S() {
        d.a.o0.e2.k.e.f1.c cVar = this.f57515b;
        if (cVar != null) {
            cVar.k();
        }
    }

    public final void T() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f57517d.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        if (this.f57518e == null) {
            this.f57518e = new t(loadAnimation);
        }
        p0(this.f57518e);
        UtilHelper.getLightStatusBarHeight();
        d.a.c.e.p.l.g(this.f57517d.getActivity(), R.dimen.ds98);
        this.H = new Handler();
    }

    public void U(VideoInfo videoInfo, a2 a2Var, String str) {
        d.a.o0.k2.c cVar;
        if (videoInfo == null || (cVar = this.f57521h) == null || a2Var == null) {
            return;
        }
        this.f57520g = videoInfo;
        this.l = a2Var;
        this.f57519f = videoInfo.video_url;
        cVar.k2();
        d.a.o0.k2.o oVar = new d.a.o0.k2.o();
        this.f57522i = oVar;
        oVar.f60712a = "pb";
        oVar.f60714c = a2Var.z1();
        d.a.o0.k2.o oVar2 = this.f57522i;
        oVar2.f60715d = str;
        oVar2.f60716e = TbadkCoreApplication.getCurrentAccount();
        if (a2Var.V1()) {
            if (!StringUtils.isNull(this.f57517d.n1)) {
                this.f57522i.k = this.f57517d.n1;
            }
            d.a.o0.k2.o oVar3 = this.f57522i;
            oVar3.f60720i = this.f57517d.m1 + "";
        } else {
            this.f57522i.f60720i = this.f57517d.R4();
        }
        k1 O4 = this.f57517d.O4();
        if (O4 != null) {
            O4.d(this.f57522i);
        }
        d.a.o0.k2.o oVar4 = this.f57522i;
        oVar4.m = videoInfo.video_md5;
        d.a.o0.k2.o b2 = oVar4.b();
        b2.f60712a = "6";
        this.D = -1L;
        if (this.f57521h.I0() != null && this.f57521h.I0().getMediaProgressObserver() != null) {
            this.f57521h.I0().getMediaProgressObserver().j(new a(videoInfo, str, a2Var));
        }
        this.f57521h.I0().setVideoStatData(b2);
        if (this.f57521h.H0()) {
            this.f57521h.q0();
        }
        this.f57521h.z1(this.F);
        this.n = null;
        this.m = null;
        this.f57521h.x1(null);
        this.f57521h.K0().setOnDragingListener(U);
        this.f57521h.y1(new b());
        this.f57521h.C1(new c());
        this.f57521h.E1(new d());
        this.f57521h.J1(new e());
        this.f57521h.S1(videoInfo.thumbnail_url);
        this.f57521h.Y1(this.f57519f, a2Var.z1());
        this.f57521h.m1(str);
        this.f57521h.X1(a2Var.A1());
        this.f57521h.D1(V);
        this.f57521h.a1();
        this.f57521h.a2();
    }

    public final void V(VideoInfo videoInfo) {
        NavigationBar navigationBar;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f57517d.getPageContext().getPageActivity()).inflate(R.layout.video_pb_container_layout, (ViewGroup) null);
        this.f57514a = relativeLayout;
        this.f57516c = (CustomFrameLayout) relativeLayout.findViewById(R.id.pb_video_container);
        int b0 = b0(videoInfo);
        int i2 = 0;
        this.z = ((double) this.v) <= (((double) d.a.c.e.p.l.k(this.f57517d.getActivity())) * 0.5625d) + 5.0d;
        int intValue = videoInfo.video_width.intValue();
        d.a.o0.k2.c cVar = new d.a.o0.k2.c(this.f57517d.getPageContext(), this.f57516c, true);
        this.f57521h = cVar;
        cVar.O1("2002");
        this.f57521h.Z1(this.P);
        this.f57521h.t1(false);
        this.f57521h.U1(this.E);
        this.f57521h.V1(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
        this.f57521h.N1(new q());
        if (TbSingleton.getInstance().isNotchScreen(this.f57517d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f57517d.getBaseFragmentActivity())) {
            this.f57521h.o1(false);
        }
        this.f57521h.F1(new r());
        if (intValue > 0) {
            if (this.w >= 1.0d) {
                this.f57521h.M1(false, true);
            } else {
                this.f57521h.M1(true, false);
            }
            boolean z = ((float) b0) + this.s > ((float) d.a.c.e.p.l.i(this.f57517d.getActivity()));
            this.t = z;
            if (z) {
                if (this.j == null) {
                    this.j = new d.a.o0.e2.n.e(this.f57517d.getPageContext(), this.f57516c);
                }
                this.f57517d.N4().W0();
                this.k = true;
            }
        }
        v0();
        this.x = new View(this.f57517d.getContext());
        this.x.setLayoutParams(new AbsListView.LayoutParams(-1, this.v));
        d.a.o0.e2.k.e.f1.c cVar2 = this.f57515b;
        if (cVar2 != null && (navigationBar = cVar2.f57137a) != null) {
            navigationBar.getBarBgView().setAlpha(0.0f);
            this.f57515b.f57137a.getTopCoverBgView().setAlpha(1.0f);
            NavigationBar navigationBar2 = this.f57515b.f57137a;
            if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.f57517d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.f57517d.getBaseFragmentActivity())) {
                i2 = 8;
            }
            navigationBar2.setStatusBarVisibility(i2);
        }
        PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.f57514a.findViewById(R.id.layout_wifi_tip);
        this.B = pbVideoWifiTipLayout;
        pbVideoWifiTipLayout.setOnPlayClickListener(new s());
        d.a.x.c cVar3 = this.A;
        if (cVar3 != null) {
            cVar3.d();
        }
    }

    public boolean W() {
        return this.p;
    }

    public boolean X() {
        if (P() == null) {
            return false;
        }
        return P().getBottom() > d.a.c.e.p.l.i(P().getContext()) - d.a.c.e.p.l.g(P().getContext(), R.dimen.ds50);
    }

    public void Y() {
        if (this.j == null) {
            return;
        }
        if (W()) {
            this.f57517d.N4().W0();
        } else if (this.j.f().getVisibility() == 0) {
            this.f57517d.N4().W0();
            this.k = true;
        } else if (this.k) {
            this.f57517d.N4().V2(false);
            this.k = false;
        }
    }

    public boolean Z() {
        return this.w >= 1.0d;
    }

    public final boolean a0() {
        return P().getY() >= 0.0f;
    }

    public final int b0(VideoInfo videoInfo) {
        if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
            this.f57516c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return d.a.c.e.p.l.k(this.f57517d.getActivity());
        }
        int k2 = d.a.c.e.p.l.k(this.f57517d.getActivity());
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.f57517d.getPageContext().getPageActivity());
        int i2 = visibilityRegion.height() <= 0 ? d.a.c.e.p.l.i(this.f57517d.getActivity()) : visibilityRegion.height();
        int i3 = (int) (k2 * 0.5625d);
        int intValue = videoInfo != null ? videoInfo.video_width.intValue() : 0;
        int intValue2 = videoInfo != null ? videoInfo.video_height.intValue() : 0;
        if (intValue > 0) {
            double d2 = (intValue2 * 1.0d) / intValue;
            this.w = d2;
            if (d2 > 0.5625d) {
                i3 = Math.min((intValue2 * k2) / intValue, i2);
            }
        }
        this.v = i3;
        this.f57516c.setLayoutParams(new RelativeLayout.LayoutParams(k2, i3));
        return i3;
    }

    public void c0(int i2) {
        d.a.o0.e2.k.e.f1.c cVar = this.f57515b;
        if (cVar != null) {
            cVar.n(i2);
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.e(i2);
        }
        d.a.o0.e2.n.e eVar = this.j;
        if (eVar != null) {
            eVar.j(i2);
        }
    }

    public void d0(Configuration configuration) {
        CustomFrameLayout customFrameLayout;
        this.p = false;
        if (this.f57521h == null || (customFrameLayout = this.f57516c) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
        layoutParams.topMargin = 0;
        if (configuration.orientation == 2) {
            d.a.x.c cVar = this.A;
            if (cVar != null && cVar.c()) {
                this.A.b();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
            d.a.c.e.g.c cVar2 = this.K;
            if (cVar2 != null) {
                cVar2.d();
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.p = true;
            this.f57516c.setLayoutParams(layoutParams);
            this.f57517d.N4().W0();
            this.k = true;
        } else {
            b0(this.f57520g);
            u0();
            this.p = false;
            this.f57515b.t(true);
        }
        this.f57521h.V0(this.f57517d.getPageContext(), configuration);
    }

    public boolean e0(int i2) {
        d.a.o0.k2.c cVar = this.f57521h;
        if (cVar == null) {
            return false;
        }
        return cVar.f1(i2);
    }

    public void f0() {
        d.a.o0.k2.c cVar = this.f57521h;
        if (cVar == null) {
            return;
        }
        if (cVar.T0()) {
            this.o = true;
            this.f57521h.k2();
        } else if (this.f57521h.C0() == 3) {
            this.o = false;
        } else if (this.f57521h.C0() != 0 && this.f57521h.C0() != 1) {
            this.o = false;
            this.f57521h.k2();
        } else {
            this.o = true;
            this.f57521h.k2();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.I;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.g();
        }
    }

    public void g0() {
        d.a.o0.k2.c cVar = this.f57521h;
        if (cVar != null && this.o) {
            cVar.i1();
        }
    }

    public void h0(AbsListView absListView, int i2) {
        if (absListView != null && absListView.getChildAt(0) != null) {
            View childAt = absListView.getChildAt(0);
            if (childAt == R()) {
                int bottom = childAt.getBottom() - P().getBottom();
                M((childAt.getHeight() == 0 || P().getHeight() == 0) ? 0 : 0);
            } else {
                M((-this.v) + 2);
            }
        }
        if (!W() && this.G) {
            int i3 = this.q;
            if (i3 == 1) {
                this.N = true;
                j0(P().getHeight());
            } else if (i3 != 2) {
                if (i3 == 0) {
                    if (this.N || !VideoPlayActivity.FROM_VIDEO_PLAY.equals(this.f57517d.R4())) {
                        j0(P().getHeight());
                    }
                }
            } else {
                this.N = true;
                int y = (int) P().getY();
                if (this.r == y) {
                    j0(P().getHeight());
                } else {
                    this.r = y;
                    j0(P().getHeight());
                }
                if (i2 == 0 && this.u) {
                    this.u = false;
                    this.H.postDelayed(new l(), 100L);
                }
            }
        }
    }

    public void i0(AbsListView absListView, int i2) {
        if (W()) {
            return;
        }
        this.q = i2;
        if (i2 == 0) {
            new Handler().postDelayed(new j(), 100L);
        }
        Y();
    }

    public final void j0(int i2) {
        n0(i2);
        Y();
    }

    public void k0(PostData postData, a2 a2Var, d.a.o0.e2.h.p pVar) {
        d.a.o0.e2.n.e eVar = this.j;
        if (eVar != null) {
            eVar.m(postData, a2Var, pVar);
        }
    }

    public final void l0(String str) {
        if (this.f57520g != null) {
            if ("1".equals(str) || "2".equals(str)) {
                d.a.o0.k2.h.e(this.f57520g.video_md5, "", str, this.f57522i, this.f57521h.I0().getPcdnState());
            }
        }
    }

    public void m0() {
        d.a.o0.k2.c cVar = this.f57521h;
        if (cVar != null) {
            cVar.g1();
        }
    }

    public final void n0(int i2) {
        if (this.j == null) {
            return;
        }
        a2 a2Var = this.l;
        if (a2Var != null && a2Var.C2()) {
            this.j.f().setVisibility(8);
            return;
        }
        if (i2 == 0) {
            i2 = this.v;
        }
        float f2 = this.v - i2;
        float f3 = this.s;
        float f4 = f2 > f3 ? 0.0f : 1.0f - (f2 / f3);
        if (this.O) {
            f4 = 0.0f;
        }
        if (f4 == 0.0f) {
            this.j.f().setVisibility(8);
        } else {
            this.j.f().setVisibility(0);
        }
        this.j.n(f4);
    }

    public void o0(boolean z) {
        this.O = z;
    }

    public void p0(c.y yVar) {
        this.F = yVar;
    }

    public void q0(a2 a2Var) {
        this.m = a2Var;
    }

    public void r0(String str) {
        this.n = str;
        d.a.o0.k2.c cVar = this.f57521h;
        if (cVar != null) {
            cVar.x1(str);
        }
    }

    public void s0(View.OnClickListener onClickListener) {
        d.a.o0.e2.n.e eVar = this.j;
        if (eVar != null) {
            eVar.o(onClickListener);
        }
    }

    public void t0() {
        this.u = true;
    }

    public void u0() {
        if (this.f57515b != null) {
            this.f57515b.v(this.f57517d.isSimpleForum());
        }
    }

    public final void v0() {
        if (d.a.n0.r.d0.b.j().g("show_video_pb_double_tap_tips", false)) {
            return;
        }
        d.a.n0.r.d0.b.j().t("show_video_pb_double_tap_tips", true);
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.h(false);
        dVar.k(16908290);
        dVar.c(153);
        dVar.i(false);
        dVar.a(new f());
        dVar.g(new C1340g());
        d.a.c.e.g.c b2 = dVar.b();
        this.K = b2;
        b2.q(this.f57517d.getActivity());
    }

    public void w0() {
        a2 a2Var;
        if (this.f57521h != null) {
            if (d.a.c.e.p.j.x() && !this.M && !d.a.o0.r3.f.d().e()) {
                this.B.setVisibility(0);
                this.B.setData(this.f57520g);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.f57519f) && (a2Var = this.l) != null && a2Var.x1() != null) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "pb").param("tid", this.l.z1()));
                this.f57519f = this.l.x1().video_url;
            }
            d.a.o0.k2.c cVar = this.f57521h;
            String str = this.f57519f;
            a2 a2Var2 = this.l;
            cVar.d2(str, a2Var2 == null ? "" : a2Var2.z1());
            l0("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void x0(String str) {
        d.a.o0.k2.o oVar = this.f57522i;
        if (oVar != null) {
            oVar.f60715d = str;
        }
    }
}
