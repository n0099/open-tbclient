package d.a.j0.q0.p2;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.tencent.connect.common.Constants;
import d.a.d.m.d;
import d.a.j0.j2.c;
import d.a.j0.j2.f;
import d.a.j0.q0.i1.g;
import java.text.MessageFormat;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a extends d.a.j0.x.b<d.a.j0.q0.i1.g> implements d.a.j0.q0.i1.c, d.a.j0.j1.o.l.k, d.a.j0.j1.o.l.h {
    public FrameLayout A;
    public TextView B;
    public TbPageContext<?> C;
    public d.a.j0.q0.i1.g D;
    public int E;
    public d.a.j0.q0.i1.h F;
    public d.a.j0.j2.o G;
    public d.a.j0.j2.o H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public String Q;
    public String R;
    public View S;
    public View T;
    public d.a.j0.q0.p2.c U;
    public Animation V;
    public Animation W;
    public d.a.j0.q0.p2.j.a X;
    public d.a.j0.j1.o.l.f Y;
    public s Z;
    public VideoNetworkStateTipView a0;
    public d.a.d.m.d b0;
    public d.a.j0.q0.p2.b c0;
    public d.a.v.c d0;
    public d.a.j0.j1.o.l.g e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;
    public long i0;
    public int j0;
    public Animation.AnimationListener k0;
    public Animation.AnimationListener l0;
    public FrameLayout m;
    public Runnable m0;
    public FrameLayout n;
    public Runnable n0;
    public ExpandableTextView o;
    public View p;
    public HeadImageView q;
    public TextView r;
    public AgreeView s;
    public TextView t;
    public ImageView u;
    public View v;
    public TextView w;
    public ImageView x;
    public View y;
    public d.a.j0.j2.c z;

    /* renamed from: d.a.j0.q0.p2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1447a implements f.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.q0.i1.g f58456a;

        public C1447a(d.a.j0.q0.i1.g gVar) {
            this.f58456a = gVar;
        }

        @Override // d.a.j0.j2.f.c
        public void a(int i2, int i3) {
            if (a.this.i0 <= 0) {
                a.this.i0 = i3;
            }
            a aVar = a.this;
            g.a aVar2 = aVar.D.z.o;
            boolean z = true;
            if (aVar2 == null) {
                if (i3 >= i2) {
                    d.a.d.m.d dVar = aVar.b0;
                    boolean z2 = a.this.K;
                    d.a.j0.j2.c cVar = a.this.z;
                    dVar.I(z2, cVar != null && cVar.S0(), "VIDEO_LIST");
                } else if (i2 != 0 && (i3 * 100) / i2 >= 80 && i2 > 15000) {
                    aVar.b0.K(a.this.Y(this.f58456a));
                }
            }
            if (aVar2 == null || a.this.K || a.this.z.S0() || d.a.v.b.b().a(aVar2.f57814d)) {
                return;
            }
            boolean z3 = a.this.i0 >= (aVar2.f57811a * 1000) + 1000;
            long j = i3;
            if ((j < aVar2.f57811a * 1000 || j >= aVar2.f57812b * 1000) ? false : false) {
                if (a.this.d0.c()) {
                    return;
                }
                d.a.v.a aVar3 = new d.a.v.a();
                aVar3.f64103b = aVar2.f57815e;
                aVar3.f64104c = aVar2.f57816f;
                aVar3.f64105d = aVar2.f57814d;
                aVar3.f64102a = aVar2.f57813c;
                d.a.j0.q0.i1.g gVar = a.this.D;
                aVar3.f64107f = gVar != null ? gVar.f57806e : null;
                d.a.j0.q0.i1.g gVar2 = a.this.D;
                aVar3.f64106e = gVar2 != null ? gVar2.f57807f : null;
                aVar3.f64108g = 3;
                if (z3) {
                    a.this.d0.f(aVar3, (ViewGroup) a.this.z.E0());
                } else {
                    a.this.d0.e(aVar3, (ViewGroup) a.this.z.E0());
                }
            } else if (a.this.d0.c()) {
                a.this.d0.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.q0.i1.a f58458e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58459f;

        public b(d.a.j0.q0.i1.a aVar, int i2) {
            this.f58458e = aVar;
            this.f58459f = i2;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            d.a.d.m.d dVar = a.this.b0;
            boolean z = a.this.K;
            d.a.j0.j2.c cVar = a.this.z;
            if (dVar.I(z, cVar != null && cVar.S0(), "VIDEO_LIST")) {
                return;
            }
            if (a.this.K) {
                a.this.L = true;
                a.this.M = true;
                a.this.J = false;
            }
            if (this.f58458e == null || a.this.K) {
                return;
            }
            this.f58458e.a(this.f58459f);
            a.this.z.a1();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements CyberPlayerManager.OnErrorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.q0.i1.a f58461e;

        public c(d.a.j0.q0.i1.a aVar) {
            this.f58461e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            d.a.j0.q0.i1.g gVar = a.this.D;
            if (gVar != null && gVar.z != null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", a.this.D.z.f57834d);
            }
            d.a.j0.q0.i1.a aVar = this.f58461e;
            if (aVar != null) {
                aVar.cancel();
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.InterfaceC0530d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.q0.i1.a f58463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f58464b;

        public d(d.a.j0.q0.i1.a aVar, int i2) {
            this.f58463a = aVar;
            this.f58464b = i2;
        }

        @Override // d.a.d.m.d.InterfaceC0530d
        public void a() {
            if (a.this.K) {
                a.this.L = true;
                a.this.M = true;
                a.this.J = false;
            }
            if (this.f58463a == null || a.this.K) {
                return;
            }
            this.f58463a.a(this.f58464b);
            a.this.z.a1();
        }

        @Override // d.a.d.m.d.InterfaceC0530d
        public void b() {
            d.a.j0.j2.c cVar = a.this.z;
            if (cVar != null) {
                cVar.f1(4);
            }
        }

        @Override // d.a.d.m.d.InterfaceC0530d
        public void c() {
            a.this.M = false;
        }

        @Override // d.a.d.m.d.InterfaceC0530d
        public boolean d() {
            return a.this.T();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.S != null) {
                a.this.S.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (a.this.S != null) {
                a.this.S.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.S != null) {
                a.this.S.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (a.this.S != null) {
                a.this.S.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.q0.i1.g f58468e;

        public g(d.a.j0.q0.i1.g gVar) {
            this.f58468e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f58468e.l().hasAgree && this.f58468e.l().agreeType == 2) {
                a.this.Z.g(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.A.getVisibility() == 0) {
                a.this.A.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.j2.c cVar = a.this.z;
            if (cVar != null) {
                cVar.k2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CyberPlayerManager.OnPreparedListener {
        public j() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            a aVar = a.this;
            d.a.j0.q0.p2.j.a aVar2 = aVar.X;
            if (aVar2 != null) {
                g.c cVar = aVar.D.z;
                if (cVar.f57835e > 8) {
                    aVar2.a(aVar.I, cVar.f57834d);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements c.v {
        public k() {
        }

        @Override // d.a.j0.j2.c.v
        public void a(boolean z) {
            if (a.this.Z == null) {
                return;
            }
            if (z) {
                a.this.Z.g(0);
            } else {
                a.this.Z.g(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements c.i0 {
        public l() {
        }

        @Override // d.a.j0.j2.c.i0
        public void onStopTrackingTouch(SeekBar seekBar) {
            a.this.i0 = -1L;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58475e;

        public m(String str) {
            this.f58475e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f58475e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(a.this.k().getPageActivity()), new String[]{this.f58475e}, true);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.c cVar;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_FLOW_PLAY_CLICK));
            a.this.a0.setHasAgreeToPlay(true);
            a.this.z.n1(false);
            a.this.a0.g();
            if (a.this.b0.r()) {
                a.this.b0.E();
                return;
            }
            a aVar = a.this;
            d.a.j0.q0.i1.g gVar = aVar.D;
            if (gVar == null || (cVar = gVar.z) == null) {
                return;
            }
            aVar.z.d2(cVar.f57834d, gVar.f57807f);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements ExpandableTextView.e {
        public o() {
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            a.this.D.H = z;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements c.x {
        public p() {
        }

        @Override // d.a.j0.j2.c.x
        public void a() {
            a.this.V();
            if (a.this.b0 != null) {
                a.this.b0.x();
            }
        }

        @Override // d.a.j0.j2.c.x
        public void b() {
            a.this.W();
            a.this.z.T0();
            if (a.this.L || (a.this.b0 != null && a.this.b0.r())) {
                d.a.c.e.m.e.a().removeCallbacks(a.this.n0);
                d.a.c.e.m.e.a().post(a.this.n0);
            }
            if (a.this.b0 != null) {
                a.this.b0.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements c.g0 {
        public q() {
        }

        @Override // d.a.j0.j2.c.g0
        public void a() {
            a aVar = a.this;
            aVar.onClick(aVar.m);
        }

        @Override // d.a.j0.j2.c.g0
        public void b() {
            g.c cVar;
            d.a.j0.q0.i1.g gVar = a.this.D;
            if (gVar != null && (cVar = gVar.z) != null && d.a.c.e.m.b.d(cVar.f57837g, 0) > d.a.c.e.m.b.d(a.this.D.z.f57836f, 0)) {
                a.this.z.M1(false, false);
            } else {
                a.this.z.M1(true, false);
            }
            a.this.L = false;
            a aVar = a.this;
            aVar.p0(aVar.N ? "1" : "2");
            a aVar2 = a.this;
            aVar2.onClick(aVar2.n);
            if (a.this.Y != null) {
                a.this.Y.h(a.this);
            }
            if (a.this.e0 != null) {
                a.this.e0.b(a.this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements c.a0 {
        public r() {
        }

        @Override // d.a.j0.j2.c.a0
        public void a(boolean z) {
            a aVar = a.this;
            d.a.j0.j2.c cVar = aVar.z;
            d.a.j0.q0.i1.g gVar = aVar.D;
            cVar.d2(gVar.z.f57834d, gVar.f57807f);
            a.this.p0("2");
            a aVar2 = a.this;
            aVar2.onClick(aVar2.n);
        }
    }

    public a(TbPageContext<?> tbPageContext, boolean z, String str, String str2, d.a.j0.q0.p2.b bVar) {
        super(tbPageContext);
        this.J = true;
        this.O = false;
        this.P = false;
        this.f0 = false;
        this.g0 = false;
        this.h0 = false;
        this.i0 = -1L;
        this.j0 = 0;
        this.k0 = new e();
        this.l0 = new f();
        this.m0 = new h();
        this.n0 = new i();
        this.Q = str;
        this.R = str2;
        this.c0 = bVar;
        View l2 = l();
        this.C = tbPageContext;
        this.m = (FrameLayout) l2.findViewById(R.id.video_agg_container);
        this.p = l2.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) l2.findViewById(R.id.video_container);
        this.n = frameLayout;
        d.a.j0.j2.c cVar = new d.a.j0.j2.c(tbPageContext, frameLayout, false);
        this.z = cVar;
        cVar.O1("2005");
        this.z.q1(z);
        this.z.K1(new j());
        this.z.p1(new k());
        this.z.N1(new l());
        this.o = (ExpandableTextView) l2.findViewById(R.id.title);
        this.q = (HeadImageView) l2.findViewById(R.id.user_icon);
        this.r = (TextView) l2.findViewById(R.id.user_name);
        this.s = (AgreeView) l2.findViewById(R.id.agree_view);
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49132c = 2;
        eVar.f49137h = 6;
        this.s.setStatisticData(eVar);
        this.s.setResourceId(R.raw.lottie_card_agree, R.raw.lottie_disagree);
        this.t = (TextView) l2.findViewById(R.id.thread_info_commont_num);
        this.u = (ImageView) l2.findViewById(R.id.thread_info_commont_img);
        this.v = l2.findViewById(R.id.thread_info_commont_container);
        this.w = (TextView) l2.findViewById(R.id.thread_info_share_num);
        this.x = (ImageView) l2.findViewById(R.id.share_num_img);
        this.y = l2.findViewById(R.id.share_num_container);
        this.A = (FrameLayout) l2.findViewById(R.id.download_nani_guide_container);
        this.B = (TextView) l2.findViewById(R.id.download_nani_guide_txt);
        this.A.setVisibility(8);
        String p2 = d.a.i0.r.d0.b.j().p("nani_key_download_txt", null);
        if (!TextUtils.isEmpty(p2)) {
            this.B.setText(p2);
        }
        this.B.setOnClickListener(new m(d.a.i0.r.d0.b.j().p("nani_key_download_link_url", null)));
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) l2.findViewById(R.id.network_state_tip);
        this.a0 = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new n());
        this.S = l2.findViewById(R.id.video_agg_container_foreground);
        this.T = l2.findViewById(R.id.title_and_comment_container_foreground);
        this.S.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.p.setOnClickListener(this);
        int k2 = d.a.c.e.p.l.k(tbPageContext.getPageActivity());
        this.E = k2;
        this.j0 = k2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = (int) (this.E * 0.5625f);
        this.m.setLayoutParams(layoutParams);
        this.q.setIsRound(true);
        this.q.setPlaceHolder(1);
        this.F = new d.a.j0.q0.i1.h(this.C, this);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.V = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.V.setAnimationListener(this.l0);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.W = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.W.setAnimationListener(this.k0);
        this.Z = new s(this, null);
        this.b0 = new d.a.d.m.d(b(), this.n);
        this.d0 = new d.a.v.c(this.f62438g);
    }

    public void A0(d.a.j0.q0.i1.g gVar) {
        g.b bVar;
        if (gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        this.r.setText(TextUtils.isEmpty(bVar.f57819c) ? gVar.y.f57818b : gVar.y.f57819c);
        z0(gVar);
        x0(gVar);
        u0(gVar);
        y0(gVar);
    }

    public final void B0(boolean z) {
        d.a.j0.q0.p2.j.a aVar = this.X;
        boolean z2 = this.I == (aVar == null ? -1 : aVar.b());
        this.O = z2;
        if (z2 && z && isPlaying() && this.N && !this.P) {
            this.A.setVisibility(0);
            this.P = true;
            this.A.postDelayed(this.m0, 5000L);
            d.a.j0.q0.p2.j.a aVar2 = this.X;
            if (aVar2 != null) {
                aVar2.c(System.currentTimeMillis());
                return;
            }
            return;
        }
        this.A.setVisibility(8);
        Runnable runnable = this.m0;
        if (runnable != null) {
            this.A.removeCallbacks(runnable);
        }
    }

    public final void C0() {
        String str;
        String str2;
        String format;
        g.b bVar;
        d.a.j0.q0.i1.g gVar = this.D;
        if (gVar == null || this.f62438g == null) {
            return;
        }
        String valueOf = String.valueOf(gVar.f57806e);
        d.a.j0.q0.i1.g gVar2 = this.D;
        String str3 = gVar2.x;
        BaijiahaoData baijiahaoData = gVar2.A;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.D.A.oriUgcType + "&dvid=" + this.D.A.oriUgcVid + "&nid=" + this.D.A.oriUgcNid;
        } else {
            str = gVar2.f57807f;
            str2 = "?share=9105&fr=share";
        }
        String str4 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str5 = this.D.z.j;
        Uri parse = str5 == null ? null : Uri.parse(str5);
        String str6 = this.D.x;
        String string = this.f62438g.getResources().getString(R.string.share_content_tpl);
        String string2 = this.f62438g.getResources().getString(R.string.default_share_content_tpl);
        d.a.j0.q0.i1.g gVar3 = this.D;
        if (gVar3.A != null && (bVar = gVar3.y) != null) {
            format = MessageFormat.format(string2, bVar.f57819c, this.f62438g.getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str3, str6);
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = str3;
        shareItem.s = format;
        d.a.j0.q0.i1.g gVar4 = this.D;
        if (gVar4.A != null) {
            shareItem.D = format;
            shareItem.R = -1L;
        } else {
            shareItem.D = str6;
            shareItem.R = gVar4.j;
        }
        shareItem.t = str4;
        shareItem.q = str;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = "";
        shareItem.K = str;
        shareItem.f13356f = true;
        shareItem.E = 11;
        if (this.D.p() == 1) {
            shareItem.M = 2;
        } else if (this.D.p() == 2) {
            shareItem.M = 8;
        } else if (this.D.p() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.D.A != null) {
            shareItem.f0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        originalThreadInfo.f12798c = str5;
        originalThreadInfo.f12796a = 3;
        originalThreadInfo.f12797b = str3;
        originalThreadInfo.f12801f = str;
        originalThreadInfo.p = this.D.A;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", 12);
        statisticItem.param("nid", this.D.f57808g);
        BaijiahaoData baijiahaoData2 = this.D.A;
        if (baijiahaoData2 != null && !d.a.c.e.p.k.isEmpty(baijiahaoData2.oriUgcVid)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.D.A.oriUgcVid);
        }
        if (this.D.p() == 1) {
            statisticItem.param("card_type", 2);
        } else if (this.D.p() == 2) {
            statisticItem.param("card_type", 8);
        } else if (this.D.p() == 3) {
            statisticItem.param("card_type", 6);
        }
        statisticItem.param("recom_source", this.D.q);
        statisticItem.param("ab_tag", this.D.t);
        statisticItem.param("weight", this.D.r);
        statisticItem.param("extra", this.D.s);
        statisticItem.param(TiebaStatic.Params.OBJ_PAGE, "a023");
        TbPageContext<?> tbPageContext = this.C;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && d.a.i0.j0.c.j(this.C.getPageActivity()) != null && d.a.i0.j0.c.j(this.C.getPageActivity()).b() != null && !TextUtils.isEmpty(d.a.i0.j0.c.j(this.C.getPageActivity()).b().locatePage) && "a002".equals(d.a.i0.j0.c.j(this.C.getPageActivity()).b().locatePage)) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
        }
        TiebaStatic.log(statisticItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f62438g, shareItem, true, true);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageHorizontal);
        d.a.j0.b0.f.b().k(shareDialogConfig);
    }

    public void D0() {
        this.b0.L();
    }

    public void E0() {
        this.P = false;
        this.z.k2();
        ExpandableTextView expandableTextView = this.o;
        if (expandableTextView != null) {
            expandableTextView.setVisibility(0);
        }
        s sVar = this.Z;
        if (sVar != null) {
            sVar.g(2);
        }
        B0(false);
        this.O = true;
        d.a.d.m.d dVar = this.b0;
        if (dVar == null || !dVar.r()) {
            return;
        }
        this.b0.L();
    }

    public final boolean T() {
        TbPageContext<?> tbPageContext;
        if (this.z != null && this.n != null && (tbPageContext = this.C) != null && tbPageContext.getPageActivity() != null && this.C.getPageActivity().getWindow() != null && (this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
            if (this.n.getParent() != null) {
                if (this.n.getParent() == frameLayout) {
                    if (this.f0) {
                        this.f0 = false;
                        return true;
                    } else if (!this.g0) {
                        this.g0 = true;
                        return true;
                    }
                } else if (this.n.getParent() == this.m) {
                    if (this.g0) {
                        this.g0 = false;
                        this.h0 = true;
                        return true;
                    } else if (!this.f0 && this.h0) {
                        this.f0 = true;
                        this.h0 = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void V() {
        TbPageContext<?> tbPageContext;
        if (this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        this.K = true;
        if (this.n.getParent() != null) {
            if (this.n.getParent() == frameLayout) {
                frameLayout.removeView(this.n);
            } else {
                ViewParent parent = this.n.getParent();
                FrameLayout frameLayout2 = this.m;
                if (parent == frameLayout2) {
                    frameLayout2.removeView(this.n);
                }
            }
        }
        if (this.n.getParent() != null) {
            return;
        }
        frameLayout.addView(this.n);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.n.setLayoutParams(layoutParams);
        d.a.v.c cVar = this.d0;
        if (cVar != null && cVar.c()) {
            this.d0.a();
        }
        d.a.i0.z0.e.m().n(true);
    }

    public final void W() {
        TbPageContext<?> tbPageContext;
        if (this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        this.K = false;
        if (this.n.getParent() != null) {
            if (this.n.getParent() == frameLayout) {
                X();
                frameLayout.removeView(this.n);
            } else if (this.n.getParent() == this.m) {
                X();
                this.m.removeView(this.n);
            }
        }
        if (this.n.getParent() != null) {
            return;
        }
        this.m.addView(this.n, 0);
        r0();
        this.z.q0();
        this.i0 = -1L;
        d.a.i0.z0.e.m().n(false);
    }

    public final void X() {
        d.a.d.m.d dVar = this.b0;
        if (dVar == null || !dVar.r()) {
            return;
        }
        this.b0.F(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.d.m.a Y(d.a.j0.q0.i1.g gVar) {
        int i2;
        g.c cVar;
        int i3;
        int i4;
        if (gVar == null) {
            return null;
        }
        d.a.j0.q0.p2.b bVar = this.c0;
        d.a.d.m.e.b c2 = bVar != null ? bVar.c(gVar.m()) : null;
        if (c2 == null) {
            return null;
        }
        int c3 = c2.c();
        int b2 = c2.b();
        int a2 = c2.a();
        int i5 = -1;
        if (a2 != -1) {
            int i6 = c3 != -1 ? (a2 - c3) - 1 : -1;
            if (b2 != -1) {
                i5 = i6;
                i2 = (b2 - a2) - 1;
                cVar = gVar.z;
                if (cVar == null) {
                    i3 = d.a.c.e.m.b.d(cVar.f57836f, 0);
                    i4 = d.a.c.e.m.b.d(gVar.z.f57837g, 0);
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("video_vid", gVar.f57807f);
                hashMap.put("video_title", gVar.x);
                hashMap.put("forum_id", gVar.f57806e);
                hashMap.put("forum_name", "");
                hashMap.put("up_distance", String.valueOf(i5));
                hashMap.put("down_distance", String.valueOf(i2));
                d.a.d.m.a h2 = d.a.d.m.c.h(3, 0, "1546857125210", a2 + 1, i3, i4);
                h2.a(hashMap);
                return h2;
            }
            i5 = i6;
        }
        i2 = -1;
        cVar = gVar.z;
        if (cVar == null) {
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("video_vid", gVar.f57807f);
        hashMap2.put("video_title", gVar.x);
        hashMap2.put("forum_id", gVar.f57806e);
        hashMap2.put("forum_name", "");
        hashMap2.put("up_distance", String.valueOf(i5));
        hashMap2.put("down_distance", String.valueOf(i2));
        d.a.d.m.a h22 = d.a.d.m.c.h(3, 0, "1546857125210", a2 + 1, i3, i4);
        h22.a(hashMap2);
        return h22;
    }

    public final void Z(boolean z) {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
        CustomMessage customMessage = new CustomMessage(2921317);
        if (z) {
            customMessage.setExtra("high");
        } else {
            customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
        }
        customResponsedMessage.setmOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public final void a0(d.a.j0.q0.i1.g gVar, int i2, d.a.j0.q0.i1.a aVar, boolean z) {
        if (gVar == null || gVar.z == null) {
            return;
        }
        this.z.k2();
        this.z.s1(true);
        this.z.v1(true);
        this.z.t1(true);
        this.z.M1(false, false);
        this.z.L1(i2);
        this.z.y1(new p());
        this.z.G1(new q());
        this.z.A1(new r());
        this.z.o1(false);
        d.a.v.c cVar = this.d0;
        if (cVar != null) {
            cVar.d();
        }
        this.i0 = -1L;
        if (this.z.I0() != null && this.z.I0().getMediaProgressObserver() != null) {
            this.z.I0().getMediaProgressObserver().j(new C1447a(gVar));
        }
        d.a.j0.j2.o oVar = new d.a.j0.j2.o();
        this.G = oVar;
        oVar.f56013c = gVar.f57807f;
        oVar.t = gVar.f57808g;
        oVar.f56014d = gVar.f57806e;
        oVar.f56015e = TbadkCoreApplication.getCurrentAccount();
        d.a.j0.j2.o oVar2 = this.G;
        oVar2.f56011a = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        oVar2.f56016f = gVar.q;
        oVar2.f56017g = gVar.r;
        oVar2.f56019i = this.Q;
        oVar2.l = gVar.t;
        oVar2.k = this.R;
        oVar2.o = gVar.s;
        oVar2.p = "0";
        oVar2.j = gVar.p();
        d.a.j0.j2.o oVar3 = new d.a.j0.j2.o();
        this.H = oVar3;
        oVar3.f56013c = gVar.f57807f;
        oVar3.f56014d = gVar.f57806e;
        oVar3.f56015e = TbadkCoreApplication.getCurrentAccount();
        d.a.j0.j2.o oVar4 = this.H;
        oVar4.f56017g = "auto_midpage";
        oVar4.f56011a = "auto_midpage";
        oVar4.f56019i = this.Q;
        oVar4.f56016f = gVar.q;
        oVar4.p = "0";
        g.c cVar2 = gVar.z;
        if (cVar2 != null) {
            d.a.j0.j2.o oVar5 = this.G;
            String str = cVar2.f57833c;
            oVar5.m = str;
            oVar4.m = str;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", gVar.f57807f);
        statisticItem.param("nid", gVar.f57808g);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("fid", gVar.f57806e);
        statisticItem.param("obj_param1", d.a.c.e.p.k.isEmpty(gVar.r) ? "0" : gVar.r);
        statisticItem.param("extra", d.a.c.e.p.k.isEmpty(gVar.s) ? "0" : gVar.s);
        statisticItem.param("obj_id", this.R);
        statisticItem.param("ab_tag", d.a.c.e.p.k.isEmpty(gVar.t) ? "0" : gVar.t);
        statisticItem.param("obj_type", this.Q);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.p());
        statisticItem.param("obj_source", d.a.c.e.p.k.isEmpty(gVar.q) ? "0" : gVar.q);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 0);
        BaijiahaoData baijiahaoData = gVar.A;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, gVar.A.oriUgcVid);
        }
        TiebaStatic.log(statisticItem);
        this.z.I0().setVideoStatData(this.G);
        this.z.q0();
        this.z.I1(new b(aVar, i2));
        this.z.J1(new c(aVar));
        if (!z || !gVar.F) {
            this.b0.B();
        }
        this.b0.G(new d(aVar, i2));
        this.z.S1(gVar.z.j);
        this.z.T1(gVar.z.f57835e);
        this.z.Y1(gVar.z.f57834d, gVar.f57807f);
        this.z.m1(gVar.f57806e);
        this.z.a1();
        this.z.a2();
        B0(false);
        if (gVar.F) {
            onClick(this.n);
            if (this.a0.d()) {
                this.z.c2(false);
                this.a0.f();
                this.z.n1(true);
                this.z.U0(gVar.z.f57834d, gVar.f57807f);
                if (this.b0.r()) {
                    this.b0.L();
                    this.b0.J();
                }
            } else {
                this.z.n1(false);
                this.z.c2(false);
                this.a0.b();
                d.a.d.m.d dVar = this.b0;
                if (dVar == null || (dVar != null && !dVar.r())) {
                    this.z.i2(gVar.z.f57834d, gVar.f57807f, null, new Object[0]);
                }
            }
            if (i2 == 0 && gVar.G) {
                this.S.setVisibility(8);
                this.Z.g(3);
            } else {
                if (this.S.getVisibility() == 0) {
                    this.S.startAnimation(this.W);
                }
                this.Z.g(0);
            }
            gVar.G = false;
        } else {
            this.S.setVisibility(0);
            this.a0.b();
            this.z.c2(true);
            this.Z.g(3);
            this.z.U0(gVar.z.f57834d, gVar.f57807f);
        }
        this.L = false;
        this.M = false;
        if (z || !this.b0.r()) {
            return;
        }
        stopPlay();
    }

    public boolean b0() {
        s sVar = this.Z;
        if (sVar != null) {
            return sVar.f() == 2 || this.Z.f() == 3;
        }
        return false;
    }

    @Override // d.a.j0.q0.i1.c
    public void c(String str) {
        this.C.showToast(str);
    }

    @Override // d.a.j0.q0.i1.c
    public void d() {
        if (this.D == null) {
            return;
        }
        this.s.s();
    }

    public final boolean d0() {
        try {
            int parseInt = Integer.parseInt(this.D.z.f57836f);
            return parseInt <= 0 || ((float) Integer.parseInt(this.D.z.f57837g)) / ((float) parseInt) < 1.0f;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    @Override // d.a.j0.q0.i1.c
    public void e(boolean z) {
        g.b bVar;
        d.a.j0.q0.i1.g gVar = this.D;
        if (gVar == null || (bVar = gVar.y) == null) {
            return;
        }
        bVar.f57821e = z;
    }

    public boolean e0() {
        return this.b0.r();
    }

    public void f0(d.a.j0.q0.i1.g gVar, int i2, d.a.j0.q0.i1.a aVar) {
        this.D = gVar;
        this.N = gVar.F;
        a0(gVar, i2, aVar, false);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_video_middle_page_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: g0 */
    public void m(d.a.j0.q0.i1.g gVar) {
    }

    public void h0(d.a.j0.q0.i1.g gVar, int i2, d.a.j0.q0.i1.a aVar) {
        if (gVar == null || gVar.z == null) {
            return;
        }
        boolean z = this.D == gVar;
        this.D = gVar;
        this.N = gVar.F;
        this.P = false;
        B0(false);
        this.o.setVisibility(0);
        this.o.setTextSize(d.a.c.e.p.l.g(b(), R.dimen.tbfontsize40));
        this.o.setTextColor(R.color.CAM_X0101);
        this.o.setLineSpacingExtra(d.a.c.e.p.l.g(b(), R.dimen.tbds14));
        g.c cVar = gVar.z;
        if (cVar != null && !StringUtils.isNull(cVar.n)) {
            this.o.setTextMaxLine(2);
            this.o.setExpandable(false);
            d.a.j0.q0.p2.k.a.a(this.f62438g, this.o.getContentView(), gVar.x, gVar.z.n, gVar.m());
        } else {
            this.o.setTextMaxLine(Integer.MAX_VALUE);
            this.o.setExpandable(true);
            this.o.setOnStatusChangedListener(new o());
            this.o.setData(gVar.x, gVar.H, gVar.E);
        }
        int k2 = d.a.c.e.p.l.k(this.f62438g);
        this.E = k2;
        if (k2 != this.j0) {
            this.z.c1();
            this.j0 = this.E;
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.n.setLayoutParams(layoutParams);
        }
        q0();
        a0(gVar, i2, aVar, z);
        A0(gVar);
        n(this.C, TbadkCoreApplication.getInst().getSkinType());
    }

    public void i0(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        if (this.z == null || this.n == null || (tbPageContext = this.C) == null || tbPageContext.getPageActivity() == null || this.C.getPageActivity().getWindow() == null || !(this.C.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.C.getPageActivity().getWindow().getDecorView();
        if (this.J) {
            this.z.k1();
        }
        if (configuration.orientation == 2) {
            configuration.orientation = 2;
            V();
        } else {
            configuration.orientation = 1;
            W();
            this.J = true;
        }
        this.z.V0(this.C, configuration);
    }

    @Override // d.a.j0.j1.o.l.k
    public boolean isPlaying() {
        return this.z.T0();
    }

    @Override // d.a.j0.j1.o.l.k
    public void j() {
        m0();
    }

    public boolean j0(int i2) {
        d.a.d.m.d dVar;
        if (i2 == 4 && (dVar = this.b0) != null && ((dVar.r() || this.M) && this.z != null)) {
            this.b0.D(i2);
            if (this.K) {
                if (this.b0.a()) {
                    this.z.q2();
                    return true;
                }
                this.z.m2();
                return true;
            }
        }
        return this.z.f1(i2);
    }

    public void m0() {
        if (isPlaying()) {
            this.z.W0();
        }
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        this.s.t(i2);
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.o.w();
    }

    public void n0() {
        d.a.j0.j2.c cVar = this.z;
        if (cVar != null) {
            cVar.v0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar;
        d.a.j0.q0.p2.c cVar;
        if (h() != null) {
            view.setTag(this);
            h().a(view, this.D);
        }
        boolean z = true;
        if (view != this.q && view != this.r) {
            if (view == this.v) {
                if (this.D == null) {
                    return;
                }
                this.Z.g(0);
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f62438g);
                pbActivityConfig.createNormalCfg(this.D.f57807f, null, null);
                pbActivityConfig.setVideo_source("auto_midpage");
                pbActivityConfig.setBjhData(this.D.A);
                pbActivityConfig.setJumpToCommentArea(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                return;
            } else if (view != this.o && view != this.p) {
                if (view == this.y) {
                    this.Z.g(0);
                    C0();
                    return;
                }
                View view2 = this.S;
                if (view == view2 && view2.getVisibility() == 0 && (cVar = this.U) != null) {
                    cVar.q0(this.I);
                    return;
                }
                return;
            } else if (this.D == null) {
                return;
            } else {
                if (this.Z.f() != 2 && this.Z.f() != 3) {
                    z = false;
                }
                this.Z.g(0);
                if (z) {
                    return;
                }
                PbActivityConfig pbActivityConfig2 = new PbActivityConfig(this.f62438g);
                pbActivityConfig2.createNormalCfg(this.D.f57807f, null, null);
                pbActivityConfig2.setVideo_source("auto_midpage");
                pbActivityConfig2.setBjhData(this.D.A);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig2));
                return;
            }
        }
        d.a.j0.q0.i1.g gVar = this.D;
        if (gVar == null || (bVar = gVar.y) == null || TextUtils.isEmpty(bVar.f57817a)) {
            return;
        }
        this.Z.g(0);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.C.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(this.D.y.f57817a, 0L), (TbadkCoreApplication.isLogin() && this.D.y.f57817a.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false, this.D.y.f57822f)));
    }

    @Override // d.a.j0.j1.o.l.k
    public void onDestroy() {
        n0();
        d.a.j0.q0.i1.h hVar = this.F;
        if (hVar != null) {
            hVar.b();
        }
        View view = this.S;
        if (view != null) {
            view.clearAnimation();
        }
        this.b0.w();
    }

    public final void p0(String str) {
        d.a.j0.q0.i1.g gVar = this.D;
        if (gVar == null || gVar.z == null) {
            return;
        }
        if ("1".equals(str) || "2".equals(str)) {
            d.a.j0.j2.h.e(this.D.z.f57833c, "", str, this.H, this.z.I0().getPcdnState());
        }
    }

    public final void q0() {
        if (!d0()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.height = (int) (this.E * 0.875f);
            this.m.setLayoutParams(layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams2.height = (int) (this.E * 0.5625f);
        this.m.setLayoutParams(layoutParams2);
    }

    public final void r0() {
        float f2;
        int i2;
        if (!d0()) {
            f2 = 0.875f;
            i2 = this.E;
        } else {
            f2 = 0.5625f;
            i2 = this.E;
        }
        int i3 = (int) (i2 * f2);
        if (i3 <= 0) {
            return;
        }
        this.n.setLayoutParams(new FrameLayout.LayoutParams(this.E, i3));
    }

    @Override // d.a.j0.j1.o.l.h
    public void setAutoPlayCallBack(d.a.j0.q0.i1.a aVar) {
    }

    @Override // d.a.j0.j1.o.l.h
    public void setCurrentPlayCallBack(d.a.j0.j1.o.l.f fVar) {
        this.Y = fVar;
    }

    @Override // d.a.j0.j1.o.l.h
    public void setOnVideoContainerForegroundClickListener(d.a.j0.q0.p2.c cVar) {
        this.U = cVar;
    }

    @Override // d.a.j0.j1.o.l.k
    public void stopPlay() {
        E0();
    }

    public void t0() {
        this.b0.E();
    }

    public void u0(d.a.j0.q0.i1.g gVar) {
        if (gVar == null) {
            return;
        }
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.k;
        if (j2 > 0) {
            this.t.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.t.setText(this.f62438g.getString(R.string.reply));
        }
    }

    public void v0(boolean z) {
        FrameLayout frameLayout = this.m;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 0 : 4);
        }
    }

    public void w0(d.a.j0.j1.o.l.g gVar) {
        this.e0 = gVar;
    }

    public void x0(d.a.j0.q0.i1.g gVar) {
        if (gVar == null) {
            return;
        }
        if (gVar.l() != null) {
            gVar.l().isInThread = true;
            gVar.l().nid = gVar.f57808g;
            if (this.D.p() == 1) {
                gVar.l().cardType = 2;
            } else if (this.D.p() == 2) {
                gVar.l().cardType = 8;
            } else if (this.D.p() == 3) {
                gVar.l().cardType = 6;
            }
            gVar.l().baijiahaoData = gVar.A;
            gVar.l().recomSource = gVar.q;
            gVar.l().recomWeight = gVar.r;
            gVar.l().recomAbTag = gVar.t;
            gVar.l().recomExtra = gVar.s;
        }
        this.s.setAgreeAlone(true);
        this.s.setIsFromMiddlePage(true);
        this.s.setData(gVar.l());
        this.s.setAfterClickListener(new g(gVar));
    }

    public void y0(d.a.j0.q0.i1.g gVar) {
        if (gVar == null) {
            return;
        }
        this.w.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        WebPManager.setPureDrawable(this.x, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        long j2 = gVar.l;
        if (j2 > 0) {
            this.w.setText(StringHelper.numFormatOverWan(j2));
        } else {
            this.w.setText(this.f62438g.getString(R.string.share));
        }
    }

    public final void z0(d.a.j0.q0.i1.g gVar) {
        g.b bVar = gVar.y;
        if (bVar == null) {
            return;
        }
        g.b.a aVar = bVar.f57824h;
        if (aVar != null && !TextUtils.isEmpty(aVar.f57826b)) {
            this.q.V(gVar.y.f57824h.f57826b, 12, false);
        } else if (!StringUtils.isNull(gVar.y.f57820d) && gVar.y.f57820d.startsWith("http")) {
            this.q.V(gVar.y.f57820d, 10, false);
        } else {
            this.q.V(gVar.y.f57820d, 12, false);
        }
        g.b.a aVar2 = gVar.y.f57824h;
        if (aVar2 != null && aVar2.f57829e.intValue() > 0) {
            this.q.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(gVar.y.f57824h.f57829e.intValue(), 1));
            this.q.setShowV(true);
            this.q.setGodIconWidth(R.dimen.tbds31);
            return;
        }
        this.q.setBjhAuthIconRes(0);
        g.b bVar2 = gVar.y;
        boolean z = bVar2.f57823g;
        if (z) {
            this.q.setShowV(z);
            this.q.setIsBigV(gVar.y.f57823g);
        } else {
            boolean z2 = bVar2.f57822f;
            if (z2) {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f57822f);
            } else {
                this.q.setShowV(z2);
                this.q.setIsBigV(gVar.y.f57822f);
            }
        }
        this.q.setGodIconWidth(R.dimen.tbds31);
    }

    /* loaded from: classes4.dex */
    public class s {

        /* renamed from: a  reason: collision with root package name */
        public int f58482a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f58483b;

        /* renamed from: d.a.j0.q0.p2.a$s$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1448a implements Runnable {
            public RunnableC1448a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.c.e.m.e.a().removeCallbacks(s.this.f58483b);
                s.this.g(2);
            }
        }

        public s() {
            this.f58482a = -1;
            this.f58483b = new RunnableC1448a();
        }

        public final void b() {
            d.a.c.e.m.e.a().removeCallbacks(this.f58483b);
            d.a.c.e.m.e.a().postDelayed(this.f58483b, 3000L);
        }

        public final int c(int i2) {
            int i3 = this.f58482a;
            if (i2 == i3) {
                return i3;
            }
            a.this.T.setVisibility(8);
            a.this.Z(true);
            return i2;
        }

        public final int d(int i2) {
            int i3 = this.f58482a;
            if (i2 == i3) {
                return i3;
            }
            a.this.T.setVisibility(0);
            a.this.Z(true);
            return i2;
        }

        public final int e(int i2) {
            int i3 = this.f58482a;
            if (i2 == i3) {
                return i3;
            }
            a.this.T.setVisibility(0);
            if (i3 != 3 || a.this.D.F) {
                a.this.Z(false);
                return i2;
            }
            return i2;
        }

        public int f() {
            return this.f58482a;
        }

        public void g(int i2) {
            if (i2 == 0) {
                this.f58482a = c(i2);
                b();
            } else if (i2 == 1) {
                this.f58482a = c(i2);
                d.a.c.e.m.e.a().removeCallbacks(this.f58483b);
            } else if (i2 == 2) {
                this.f58482a = e(i2);
            } else if (i2 != 3) {
                this.f58482a = e(i2);
            } else {
                this.f58482a = d(i2);
                b();
            }
        }

        public /* synthetic */ s(a aVar, j jVar) {
            this();
        }
    }
}
