package d.b.j0.j2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.view.SwitchImageView;
import d.b.i0.r.s.a;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes3.dex */
public class c {
    public static int Z0;
    public static CallStateReceiver a1;
    public String A;
    public boolean A0;
    public TbImageView B;
    public boolean B0;
    public CyberPlayerManager.OnPreparedListener C;
    public boolean C0;
    public CyberPlayerManager.OnCompletionListener D;
    public boolean D0;
    public CyberPlayerManager.OnErrorListener E;
    public boolean E0;
    public ImageView F;
    public TextView G;
    public Activity G0;
    public k0 H0;
    public View.OnClickListener L;
    public Animation M;
    public Animation N;
    public x O;
    public GestureDetector Q;
    public View R;
    public View S;
    public TextView T;
    public SeekBar U;
    public ImageView V;
    public ImageView W;
    public AudioManager X;
    public y Y;
    public int a0;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f57958c;

    /* renamed from: d  reason: collision with root package name */
    public View f57959d;

    /* renamed from: e  reason: collision with root package name */
    public View f57960e;
    public j0 e0;

    /* renamed from: f  reason: collision with root package name */
    public TbCyberVideoView f57961f;
    public d.b.j0.j2.j f0;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.j2.m f57962g;

    /* renamed from: h  reason: collision with root package name */
    public VideoListMediaControllerView f57963h;
    public int h0;
    public ProgressBar i;
    public int i0;
    public View j;
    public View k;
    public d0 k0;
    public FrameLayout l;
    public c0 l0;
    public FrameLayout.LayoutParams m;
    public e0 m0;
    public ImageView n;
    public f0 n0;
    public View o;
    public h0 o0;
    public View p;
    public v p0;
    public View q;
    public i0 q0;
    public View r;
    public g0 r0;
    public a0 s0;
    public SwitchImageView t;
    public b0 t0;
    public TextView u;
    public TextView v;
    public TextView w;
    public String x;
    public int y;
    public TextView y0;
    public String z;

    /* renamed from: a  reason: collision with root package name */
    public int f57956a = 100;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57957b = false;
    public boolean s = false;
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;
    public boolean K = false;
    public int P = 0;
    public int Z = 0;
    public int b0 = 0;
    public int c0 = 0;
    public long d0 = 60000;
    public int g0 = 0;
    public boolean j0 = false;
    public boolean u0 = true;
    public boolean v0 = false;
    public boolean w0 = false;
    public int x0 = -1;
    public boolean z0 = false;
    public boolean F0 = false;
    public CyberPlayerManager.OnPreparedListener I0 = new o();
    public CyberPlayerManager.OnInfoListener J0 = new p();
    public VideoLoadingProgressView.c K0 = new q();
    public Runnable L0 = new r();
    public CyberPlayerManager.OnCompletionListener M0 = new s();
    public CyberPlayerManager.OnErrorListener N0 = new t();
    public Runnable O0 = new u();
    public CyberPlayerManager.OnSeekCompleteListener P0 = new a();
    public Runnable Q0 = new b();
    public TbCyberVideoView.g R0 = new C1389c();
    public Runnable S0 = new d();
    public View.OnClickListener T0 = new e();
    public Animation.AnimationListener U0 = new h(this);
    public Runnable V0 = new i();
    public CustomMessageListener W0 = new k(2016503);
    public VideoControllerView.d X0 = new l();
    public SeekBar.OnSeekBarChangeListener Y0 = new m();

    /* loaded from: classes3.dex */
    public class a implements CyberPlayerManager.OnSeekCompleteListener {
        public a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (c.this.v0) {
                d.b.c.e.m.e.a().postDelayed(c.this.Q0, 200L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a0 {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.f57961f == null || !cVar.v0) {
                d.b.c.e.m.e.a().postDelayed(c.this.L0, 200L);
                c.this.v0 = false;
            } else if (c.this.P != c.this.f57961f.getCurrentPosition()) {
                c.this.v0 = false;
                d.b.c.e.m.e.a().postDelayed(c.this.L0, 20L);
            } else {
                d.b.c.e.m.e.a().postDelayed(c.this.Q0, 200L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b0 {
        void onPause();
    }

    /* renamed from: d.b.j0.j2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1389c implements TbCyberVideoView.g {
        public C1389c() {
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
        public void onSurfaceDestroyed() {
            c.this.H = false;
            if (c.this.J && !c.this.K) {
                d.b.c.e.m.e.a().postDelayed(c.this.S0, 300L);
            }
            d.b.c.e.m.e.a().removeCallbacks(c.this.L0);
            d.b.c.e.m.e.a().removeCallbacks(c.this.O0);
        }
    }

    /* loaded from: classes3.dex */
    public interface c0 {
        void a();
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.C0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public interface d0 {
        void a();
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.H0 != null) {
                c.this.H0.a();
            }
            if (view.getId() != c.this.k.getId()) {
                if (view.getId() != c.this.t.getId()) {
                    if (view.getId() == c.this.v.getId()) {
                        if (c.this.l0 != null) {
                            c.this.l0.a();
                            return;
                        }
                        return;
                    } else if (view.getId() == c.this.u.getId()) {
                        if (c.this.m0 != null) {
                            c.this.m0.a(false);
                        }
                        c cVar = c.this;
                        cVar.d2(cVar.x, c.this.z);
                        return;
                    } else if (view.getId() == c.this.n.getId()) {
                        int i = c.this.J ? 1 : 2;
                        if (c.this.s) {
                            TiebaStatic.log(new StatisticItem("c11714"));
                            TiebaStatic.log(new StatisticItem("c13262").param("tid", c.this.z).param("fid", c.this.A).param("obj_type", i).param("obj_source", 2));
                        } else {
                            TiebaStatic.log(new StatisticItem("c11710"));
                            TiebaStatic.log(new StatisticItem("c13262").param("tid", c.this.z).param("fid", c.this.A).param("obj_type", i).param("obj_source", 1));
                        }
                        if (c.this.r0 != null) {
                            c.this.r0.b();
                        }
                        if (c.this.S0()) {
                            c cVar2 = c.this;
                            if (cVar2.s) {
                                cVar2.z0();
                            } else {
                                cVar2.y0();
                            }
                            c cVar3 = c.this;
                            cVar3.o2(cVar3.s);
                            return;
                        }
                        c.this.m2();
                        return;
                    } else if (view.getId() != c.this.F.getId()) {
                        if (c.this.L != null) {
                            c.this.L.onClick(view);
                            return;
                        }
                        return;
                    } else {
                        TiebaStatic.log(new StatisticItem("c11713"));
                        if (c.this.r0 != null) {
                            c.this.r0.b();
                        }
                        if (c.this.S0()) {
                            c.this.z0();
                            c.this.o2(false);
                            return;
                        }
                        c.this.m2();
                        return;
                    }
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_PLAY_BTN_CLICK));
                c.this.g1();
                c.this.p2();
                if (c.this.x0 != 1) {
                    c.this.X0();
                    c.this.x0();
                } else {
                    c.this.w0();
                }
                if (c.this.p0 != null) {
                    c.this.p0.a(c.this.x0 == 1);
                    return;
                }
                return;
            }
            c.this.f57961f.stopPlayback();
            c.this.H = false;
            c.this.h2();
        }
    }

    /* loaded from: classes3.dex */
    public interface e0 {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f57969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f57970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f57971g;

        public f(z zVar, String str, String str2) {
            this.f57969e = zVar;
            this.f57970f = str;
            this.f57971g = str2;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            c.this.j1();
            aVar.dismiss();
            c.this.f2(this.f57969e, false, this.f57970f, this.f57971g);
        }
    }

    /* loaded from: classes3.dex */
    public interface f0 {
        void onStart();

        void onStop();

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
    public class g implements a.e {
        public g(c cVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public interface g0 {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public class h implements Animation.AnimationListener {
        public h(c cVar) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public interface h0 {
        boolean a();

        boolean b();
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.N0();
        }
    }

    /* loaded from: classes3.dex */
    public interface i0 {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnTouchListener {
        public j() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.n0 != null) {
                c.this.n0.onTouch(view, motionEvent);
            }
            boolean onTouchEvent = c.this.Q.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1) {
                if (c.this.H) {
                    if (c.this.Z == 1 && c.this.c0 != 0) {
                        c cVar = c.this;
                        cVar.r0(cVar.c0 == 1 ? 1000.0f : -1000.0f, false);
                        c.this.c0 = 0;
                        c.this.b0 = 0;
                    }
                    if (!c.this.f57961f.isPlaying()) {
                        c.this.v.setVisibility(8);
                        c.this.u.setVisibility(8);
                        c.this.w.setVisibility(8);
                    }
                }
                c.this.Y0();
                if (c.this.n0 != null) {
                    c.this.n0.onStop();
                }
            }
            return onTouchEvent;
        }
    }

    /* loaded from: classes3.dex */
    public interface j0 {
        void a();

        void b();

        void c();

        void d(int i);

        void onPaused();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                c.this.W0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface k0 {
        void a();
    }

    /* loaded from: classes3.dex */
    public class l implements VideoControllerView.d {
        public l() {
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i) {
            int duration;
            TbCyberVideoView tbCyberVideoView = c.this.f57961f;
            if (tbCyberVideoView == null || (duration = tbCyberVideoView.getDuration()) <= 0 || c.this.i == null) {
                return;
            }
            c.this.i.setProgress((int) ((i * c.this.f57960e.getWidth()) / duration));
            if (c.this.e0 != null) {
                c.this.e0.d((c.this.f57961f.getCurrentPosition() * 100) / duration);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements SeekBar.OnSeekBarChangeListener {
        public m() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_SEEK_CLICK));
            c.this.X0();
            c.this.c2(false);
            if (c.this.p0 != null) {
                c.this.p0.a(false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (c.this.K0() != null) {
                c cVar = c.this;
                cVar.P1(cVar.K0().getSeekPosition());
                if (!c.this.D0()) {
                    c.this.h2();
                } else {
                    c.this.h1();
                    if (c.this.k0 != null) {
                        c.this.k0.a();
                    }
                }
            }
            c.this.c2(true);
            c.this.u0();
            if (c.this.p0 != null) {
                c.this.p0.a(true);
            }
            if (c.this.q0 != null) {
                c.this.q0.onStopTrackingTouch(seekBar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends d.b.i0.m.g {
        public n() {
        }

        @Override // d.b.i0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == c.this.G0) {
                MessageManager.getInstance().unRegisterListener(c.this.W0);
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements CyberPlayerManager.OnPreparedListener {
        public o() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbCyberVideoView tbCyberVideoView;
            if (c.this.f57963h != null && (tbCyberVideoView = c.this.f57961f) != null && tbCyberVideoView.getDuration() > 0) {
                c.this.f57963h.o(0, c.this.f57961f.getDuration());
            }
            c.this.j2();
            if (c.this.e0 != null) {
                c.this.e0.onPrepared();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements CyberPlayerManager.OnInfoListener {
        public p() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            if (i == 3 || i == 702 || i == 904) {
                c.this.P0();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class q implements VideoLoadingProgressView.c {
        public q() {
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            c.this.j2();
        }
    }

    /* loaded from: classes3.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.c.e.m.e.a().removeCallbacks(c.this.L0);
            if (c.this.B.getVisibility() == 8) {
                return;
            }
            if (c.this.f57961f.getCurrentPosition() > c.this.f57956a) {
                c.this.P0();
            } else {
                d.b.c.e.m.e.a().postDelayed(c.this.L0, 20L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements CyberPlayerManager.OnCompletionListener {
        public s() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView = c.this.f57961f;
            if (tbCyberVideoView == null) {
                return;
            }
            int duration = tbCyberVideoView.getDuration();
            if (duration - c.this.B0() > 5000) {
                return;
            }
            c.this.H = false;
            c.this.C0 = false;
            c.this.P = 0;
            c.this.Y0();
            c.this.j.setVisibility(0);
            c.this.i.setProgress(c.this.i.getMax());
            c.this.f57956a = 100;
            if (c.this.D != null) {
                c.this.D.onCompletion();
            }
            c.this.x0 = 3;
            if (duration > 150000) {
                c.this.b1(false);
                c.this.c2(true);
            } else {
                c.this.O0();
                c.this.u.setVisibility(0);
            }
            c cVar = c.this;
            if (!cVar.s && duration <= 150000) {
                if (!cVar.z0) {
                    if (c.this.m0 != null) {
                        c.this.m0.a(true);
                    }
                    c cVar2 = c.this;
                    cVar2.e2(cVar2.x, c.this.z, false);
                } else {
                    c.this.x0 = 5;
                    c.this.f57961f.pause();
                    c.this.f57961f.seekTo(0);
                }
            }
            if (c.this.e0 != null) {
                c.this.e0.d(c.this.i.getMax());
                c.this.e0.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements CyberPlayerManager.OnErrorListener {
        public t() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            c.this.k.setVisibility(0);
            c.this.f57962g.b();
            c.this.x0 = 4;
            if (c.this.E != null) {
                c.this.E.onError(i, i2, null);
            }
            if (!d.b.c.e.p.j.z()) {
                c.this.A0 = true;
            }
            if (c.this.e0 != null) {
                c.this.e0.a();
            }
            c.this.C0 = false;
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbCyberVideoView tbCyberVideoView = c.this.f57961f;
            if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
                c.this.k.setVisibility(0);
                c.this.f57962g.b();
                if (c.this.e0 != null) {
                    c.this.e0.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface v {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class w extends GestureDetector.SimpleOnGestureListener {
        public w() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!c.this.E0) {
                if (c.this.o0 == null || !c.this.o0.b()) {
                    c.this.g1();
                    c.this.p2();
                    if (c.this.f57961f.isPlaying()) {
                        c.this.u0();
                    } else {
                        c.this.X0();
                    }
                    if (c.this.p0 != null) {
                        c.this.p0.a(c.this.f57961f.isPlaying());
                    }
                    return super.onDoubleTap(motionEvent);
                }
                return true;
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (c.this.n0 != null) {
                c.this.n0.onStart();
            }
            c cVar = c.this;
            if (cVar.s && cVar.H) {
                if (c.this.Z == 1) {
                    c.this.O0();
                }
                if (c.this.Z != 0) {
                    if (c.this.Z == 1) {
                        c.this.r0(f2, true);
                    } else if (c.this.Z == 2) {
                        c.this.s0(f3);
                    }
                } else {
                    c cVar2 = c.this;
                    if (cVar2.s) {
                        cVar2.Q1();
                    }
                    if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                        c.this.Z = 1;
                        c cVar3 = c.this;
                        cVar3.b0 = cVar3.f57961f.getCurrentPosition();
                        c.this.r0(f2, true);
                    } else {
                        c.this.Z = 2;
                        c.this.s0(f3);
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return super.onScroll(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!c.this.E0) {
                if (c.this.H) {
                    if (c.this.o0 != null && c.this.o0.a()) {
                        return true;
                    }
                    c.this.l2();
                    if (c.this.f57961f.isPlaying()) {
                        c.this.u0();
                    } else {
                        c.this.X0();
                    }
                    if (c.this.p0 != null) {
                        c.this.p0.a(c.this.f57961f.isPlaying());
                    }
                } else {
                    c.this.g1();
                    c.this.p2();
                    if (c.this.x0 != 1) {
                        c.this.X0();
                        c.this.x0();
                    } else {
                        c.this.w0();
                    }
                    if (c.this.p0 != null) {
                        c.this.p0.a(c.this.x0 == 1);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        public /* synthetic */ w(c cVar, j jVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface x {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public interface y {
        void a(boolean z);

        void b();
    }

    /* loaded from: classes3.dex */
    public interface z {
        void a(boolean z);
    }

    public c(TbPageContext<?> tbPageContext, View view, boolean z2) {
        this.D0 = true;
        if (tbPageContext == null) {
            return;
        }
        this.f57958c = tbPageContext;
        this.f57959d = view;
        this.D0 = z2;
        this.r = view;
        this.G0 = tbPageContext.getPageActivity();
        Q0();
    }

    public static String F0() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int L0(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean M0(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z2 = resources.getBoolean(identifier);
            String F0 = F0();
            if ("1".equals(F0)) {
                return false;
            }
            if ("0".equals(F0)) {
                return true;
            }
            return z2;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public final void A0(Activity activity, boolean z2) {
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        if (z2) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags |= 1024;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
        attributes2.flags &= -1025;
        activity.getWindow().setAttributes(attributes2);
        activity.getWindow().clearFlags(512);
    }

    public void A1(a0 a0Var) {
        this.s0 = a0Var;
    }

    public int B0() {
        TbCyberVideoView tbCyberVideoView = this.f57961f;
        if (tbCyberVideoView == null) {
            return 0;
        }
        return tbCyberVideoView.getCurrentPosition();
    }

    public void B1(b0 b0Var) {
        this.t0 = b0Var;
    }

    public int C0() {
        return this.x0;
    }

    public void C1(c0 c0Var) {
        this.l0 = c0Var;
    }

    public boolean D0() {
        return this.H;
    }

    public void D1(d0 d0Var) {
        this.k0 = d0Var;
    }

    public View E0() {
        return this.f57960e;
    }

    public void E1(e0 e0Var) {
        this.m0 = e0Var;
    }

    public void F1(f0 f0Var) {
        this.n0 = f0Var;
    }

    public int G0(Context context) {
        int i2 = 0;
        if (context == null) {
            return 0;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            if (context.getResources() != null && context.getResources().getConfiguration() != null && context.getResources().getConfiguration().orientation == 2) {
                i2 = displayMetrics.widthPixels;
            } else {
                i2 = displayMetrics.heightPixels;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i2 == 0 ? d.b.c.e.p.l.i(context) : i2;
    }

    public void G1(g0 g0Var) {
        this.r0 = g0Var;
    }

    public boolean H0() {
        return !this.s;
    }

    public void H1(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public TbCyberVideoView I0() {
        return this.f57961f;
    }

    public void I1(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.D = onCompletionListener;
    }

    public View J0(Activity activity) {
        if (activity == null) {
            return null;
        }
        return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
    }

    public void J1(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.E = onErrorListener;
    }

    public VideoListMediaControllerView K0() {
        return this.f57963h;
    }

    public void K1(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.C = onPreparedListener;
    }

    public void L1(int i2) {
    }

    public void M1(boolean z2, boolean z3) {
        VideoListMediaControllerView videoListMediaControllerView;
        if (this.f0 != null) {
            ImageView imageView = this.n;
            if (imageView != null) {
                imageView.setVisibility((z2 || !z3) ? 0 : 8);
            }
            if (!z2 && z3 && (videoListMediaControllerView = this.f57963h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57963h.getLayoutParams();
                layoutParams.rightMargin = d.b.c.e.p.l.g(this.G0, R.dimen.tbds52);
                this.f57963h.setLayoutParams(layoutParams);
            }
            this.f0.i(z2);
        }
    }

    public void N0() {
        if (this.o == null || !this.I) {
            return;
        }
        c2(false);
        t0();
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.i.setVisibility(0);
        this.M.setAnimationListener(this.U0);
        this.o.startAnimation(this.M);
        this.I = false;
        y yVar = this.Y;
        if (yVar != null) {
            yVar.b();
        }
    }

    public void N1(i0 i0Var) {
        this.q0 = i0Var;
    }

    public void O0() {
        if (this.o == null || !this.I) {
            return;
        }
        this.N.cancel();
        this.M.cancel();
        c2(false);
        t0();
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.i.setVisibility(0);
        this.I = false;
        y yVar = this.Y;
        if (yVar != null) {
            yVar.b();
        }
    }

    public void O1(String str) {
        TbCyberVideoView tbCyberVideoView = this.f57961f;
        if (tbCyberVideoView != null) {
            tbCyberVideoView.setStageType(str);
        }
    }

    public final void P0() {
        if (this.B.getVisibility() == 8 && this.H) {
            return;
        }
        this.H = true;
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.f57962g.c();
        this.B.setVisibility(8);
        Z0();
        this.f57963h.s();
        this.i.setVisibility(0);
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.C;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
    }

    public void P1(int i2) {
        this.P = i2;
    }

    public void Q0() {
        View J0 = J0(this.G0);
        this.f57960e = J0;
        J0.setOnClickListener(this.T0);
        View view = this.f57959d;
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.f57960e);
        }
        this.f57961f = new TbCyberVideoView(this.G0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        ((ViewGroup) this.f57960e).addView(this.f57961f.getView(), 0);
        this.f57961f.getView().setLayoutParams(layoutParams);
        d.b.j0.j2.m mVar = new d.b.j0.j2.m((ViewGroup) this.f57960e.findViewById(R.id.auto_video_loading_container));
        this.f57962g = mVar;
        mVar.f(this.K0);
        VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.f57960e.findViewById(R.id.media_controller);
        this.f57963h = videoListMediaControllerView;
        videoListMediaControllerView.setPlayer(this.f57961f);
        ProgressBar progressBar = (ProgressBar) this.f57960e.findViewById(R.id.pgrBottomProgress);
        this.i = progressBar;
        progressBar.setMax(d.b.c.e.p.l.k(this.G0));
        this.i.setProgress(0);
        this.f57963h.setOnSeekBarChangeListener(this.Y0);
        this.f57963h.setOnProgressUpdatedListener(this.X0);
        this.j = this.f57960e.findViewById(R.id.black_mask);
        View findViewById = this.f57960e.findViewById(R.id.layout_error);
        this.k = findViewById;
        findViewById.setOnClickListener(this.T0);
        this.y0 = (TextView) this.f57960e.findViewById(R.id.auto_video_error_tips);
        this.l = (FrameLayout) this.f57960e.findViewById(R.id.danmu_container);
        ImageView imageView = (ImageView) this.f57960e.findViewById(R.id.img_full_screen);
        this.n = imageView;
        imageView.setOnClickListener(this.T0);
        this.o = this.f57960e.findViewById(R.id.layout_media_controller);
        this.p = this.f57960e.findViewById(R.id.time_show_controller);
        this.f57961f.setContinuePlayEnable(true);
        this.f57961f.setOnPreparedListener(this.I0);
        this.f57961f.setOnCompletionListener(this.M0);
        this.f57961f.setOnErrorListener(this.N0);
        this.f57961f.setOnSeekCompleteListener(this.P0);
        this.f57961f.setOnInfoListener(this.J0);
        this.f57961f.setOnSurfaceDestroyedListener(this.R0);
        SwitchImageView switchImageView = (SwitchImageView) this.f57960e.findViewById(R.id.img_play_controller);
        this.t = switchImageView;
        switchImageView.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
        this.t.setState(0);
        this.t.setOnClickListener(this.T0);
        TextView textView = (TextView) this.f57960e.findViewById(R.id.txt_replay);
        this.u = textView;
        textView.setOnClickListener(this.T0);
        TextView textView2 = (TextView) this.f57960e.findViewById(R.id.txt_playnext);
        this.v = textView2;
        textView2.setOnClickListener(this.T0);
        this.w = (TextView) this.f57960e.findViewById(R.id.txt_next_video_title);
        TbImageView tbImageView = (TbImageView) this.f57960e.findViewById(R.id.video_thumbnail);
        this.B = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
        d.b.c.e.p.l.k(this.G0);
        G0(this.G0);
        ImageView imageView2 = (ImageView) this.f57960e.findViewById(R.id.img_exit);
        this.F = imageView2;
        imageView2.setOnClickListener(this.T0);
        this.G = (TextView) this.f57960e.findViewById(R.id.video_title);
        View findViewById2 = this.f57960e.findViewById(R.id.layout_title);
        this.q = findViewById2;
        findViewById2.setVisibility(8);
        this.M = AnimationUtils.loadAnimation(this.G0, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.N = AnimationUtils.loadAnimation(this.G0, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.Q = new GestureDetector(this.G0, new w(this, null));
        AudioManager audioManager = (AudioManager) this.G0.getSystemService("audio");
        this.X = audioManager;
        this.a0 = audioManager.getStreamMaxVolume(3);
        this.i0 = this.X.getStreamVolume(3);
        Z0 = 100 / this.a0;
        this.f57960e.setOnTouchListener(new j());
        d.b.j0.j2.j jVar = new d.b.j0.j2.j(this.G0);
        this.f0 = jVar;
        if (this.D0) {
            jVar.j();
        }
        this.g0 = d.b.c.e.p.l.g(this.G0, R.dimen.ds16);
        if (a1 == null) {
            a1 = new CallStateReceiver();
        }
        a1.register(this.G0);
        R1();
        MessageManager.getInstance().registerListener(this.W0);
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new n());
    }

    public final void Q1() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            this.f57960e.setSystemUiVisibility(2);
        } else if (i2 >= 16 && i2 <= 18) {
            this.f57960e.setSystemUiVisibility(4);
        } else {
            this.f57960e.setSystemUiVisibility(5894);
        }
    }

    public boolean R0() {
        return this.s;
    }

    public void R1() {
        if (this.u0) {
            if (!UtilHelper.canUseStyleImmersiveSticky() || TbSingleton.getInstance().isNotchScreen(this.G0) || TbSingleton.getInstance().isCutoutScreen(this.G0)) {
                return;
            }
            this.f57960e.setSystemUiVisibility(4);
            return;
        }
        this.f57960e.setSystemUiVisibility(0);
    }

    public boolean S0() {
        TbCyberVideoView tbCyberVideoView = this.f57961f;
        return tbCyberVideoView != null && tbCyberVideoView.getView().getHeight() >= this.f57961f.getView().getWidth();
    }

    public void S1(String str) {
        this.B.W(str, 17, false);
    }

    public boolean T0() {
        TbCyberVideoView tbCyberVideoView = this.f57961f;
        if (tbCyberVideoView == null) {
            return false;
        }
        return tbCyberVideoView.isPlaying();
    }

    public void T1(int i2) {
        this.y = i2;
    }

    public void U0(String str, String str2) {
    }

    public void U1(k0 k0Var) {
        this.H0 = k0Var;
    }

    public void V0(TbPageContext tbPageContext, Configuration configuration) {
        if (!this.j0) {
            if (this.s) {
                TiebaStatic.log(new StatisticItem("c11712"));
            } else {
                TiebaStatic.log(new StatisticItem("c11711"));
            }
        } else {
            this.j0 = false;
        }
        if (configuration.orientation == 2) {
            y0();
        } else {
            z0();
        }
        n2();
        if (this.G0 == d.b.c.a.b.f().b()) {
            h1();
        }
        p2();
        w0();
        v vVar = this.p0;
        if (vVar != null) {
            vVar.a(true);
        }
    }

    public void V1(int i2) {
        TbImageView tbImageView = this.B;
        if (tbImageView != null) {
            tbImageView.setDefaultBgResource(i2);
        }
    }

    public void W0() {
        this.f57961f.pause();
        this.x0 = 2;
        d1();
    }

    public void W1(int i2) {
        TbImageView tbImageView = this.B;
        if (tbImageView != null) {
            tbImageView.setPlaceHolder(i2);
        }
    }

    public final void X0() {
        d.b.c.e.m.e.a().removeCallbacks(this.V0);
    }

    public void X1(String str) {
        this.G.setText(str);
    }

    public final void Y0() {
        this.Z = 0;
        View view = this.R;
        if (view != null && view.getParent() != null && (this.R.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) this.R.getParent()).removeView(this.R);
                this.R = null;
            } catch (IllegalArgumentException unused) {
            }
        }
        View view2 = this.S;
        if (view2 == null || view2.getParent() == null || !(this.S.getParent() instanceof ViewGroup)) {
            return;
        }
        try {
            ((ViewGroup) this.S.getParent()).removeView(this.S);
            this.S = null;
        } catch (IllegalArgumentException unused2) {
        }
    }

    public void Y1(String str, String str2) {
        this.x = str;
        this.z = str2;
    }

    public final void Z0() {
        if (this.o == null) {
            return;
        }
        this.N.setAnimationListener(null);
        this.M.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public void Z1(h0 h0Var) {
        this.o0 = h0Var;
    }

    public void a1() {
        b1(true);
    }

    public void a2() {
        this.f57960e.setVisibility(0);
    }

    public final void b1(boolean z2) {
        if (this.o == null) {
            return;
        }
        this.j.setVisibility(0);
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        this.w.setVisibility(8);
        this.f57962g.b();
        O0();
        this.i.setVisibility(8);
        this.k.setVisibility(8);
        this.f57963h.q();
        this.B.setVisibility(z2 ? 0 : 8);
    }

    public final void b2() {
        if (d.b.c.e.p.j.x()) {
            d.b.j0.q3.f.d().g(this.G0);
        }
    }

    public void c1() {
        d.b.c.e.p.l.k(this.f57958c.getPageActivity());
        G0(this.f57958c.getPageActivity());
    }

    public void c2(boolean z2) {
        p2();
        if (z2) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    public final void d1() {
        this.f57962g.b();
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        this.w.setVisibility(8);
        p2();
    }

    public void d2(String str, String str2) {
        e2(str, str2, true);
    }

    public final void e1(boolean z2) {
        if (z2) {
            this.B.setVisibility(0);
            O0();
            this.i.setProgress(0);
        } else {
            this.B.setVisibility(8);
            O0();
        }
        this.f57963h.s();
        this.j.setVisibility(8);
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        this.w.setVisibility(8);
        this.k.setVisibility(8);
    }

    public final void e2(String str, String str2, boolean z2) {
        b2();
        this.C0 = true;
        this.x0 = 0;
        Y1(str, str2);
        this.f57961f.setVideoDuration(this.y);
        this.f57961f.setVideoPath(str, str2);
        d.b.c.e.m.e.a().removeCallbacks(this.O0);
        if (this.d0 > 0) {
            d.b.c.e.m.e.a().postDelayed(this.O0, this.d0);
        }
        j0 j0Var = this.e0;
        if (j0Var != null) {
            j0Var.onStarted();
        }
        this.f57962g.g();
        e1(z2);
    }

    public boolean f1(int i2) {
        AudioManager audioManager;
        if (i2 != 4) {
            if ((i2 == 24 || i2 == 25) && (audioManager = this.X) != null && this.a0 > 0 && this.U != null) {
                int streamVolume = audioManager.getStreamVolume(3);
                this.i0 = streamVolume;
                int i3 = (int) ((streamVolume * 100.0d) / this.a0);
                this.h0 = i3;
                this.U.setProgress(i3);
            }
            return false;
        } else if (this.s) {
            if (S0()) {
                o2(false);
                z0();
                return true;
            }
            m2();
            return true;
        }
        return false;
    }

    public final void f2(z zVar, boolean z2, String str, String str2) {
        if (this.w0) {
            g2(str, str2);
        } else {
            d2(str, str2);
        }
        if (zVar != null) {
            zVar.a(z2);
        }
    }

    public void g1() {
        if (this.f57961f.isPlaying()) {
            W0();
            b0 b0Var = this.t0;
            if (b0Var != null) {
                b0Var.onPause();
            }
            j0 j0Var = this.e0;
            if (j0Var != null) {
                j0Var.onPaused();
            }
        } else if (this.H) {
            h1();
            d0 d0Var = this.k0;
            if (d0Var != null) {
                d0Var.a();
            }
            j0 j0Var2 = this.e0;
            if (j0Var2 != null) {
                j0Var2.b();
            }
        } else {
            h2();
        }
    }

    public void g2(String str, String str2) {
        b2();
        this.C0 = true;
        this.x0 = 0;
        d.b.c.e.m.e.a().removeCallbacks(this.O0);
        if (this.d0 > 0) {
            d.b.c.e.m.e.a().postDelayed(this.O0, this.d0);
        }
        j0 j0Var = this.e0;
        if (j0Var != null) {
            j0Var.onStarted();
        }
        this.f57962g.g();
        e1(true);
    }

    public void h1() {
        TbCyberVideoView tbCyberVideoView = this.f57961f;
        if (tbCyberVideoView == null || this.f57963h == null) {
            return;
        }
        this.H = true;
        this.x0 = 1;
        tbCyberVideoView.R(null);
        int c2 = d.b.j0.j2.n.d().c(this.x);
        this.P = c2;
        this.v0 = true;
        int i2 = 100;
        if (c2 > 100) {
            int duration = this.f57961f.getDuration();
            int i3 = this.P;
            if (duration > i3) {
                i2 = i3;
            }
        }
        this.f57956a = i2;
        this.f57962g.b();
        e1(false);
    }

    public final void h2() {
        i2(this.x, this.z, null, new Object[0]);
    }

    public void i1() {
        h1();
        this.i.setVisibility(0);
    }

    public void i2(String str, String str2, z zVar, Object... objArr) {
        b2();
        if (d.b.c.e.p.j.x() && !d.b.j0.q3.f.d().e() && !TbSingleton.getInstance().hasAgreeToPlay()) {
            Date date = new Date(d.b.i0.r.d0.b.j().l("video_list_confirm_play_in_mobile_net", 0L));
            Date date2 = new Date();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.w0 = ((Boolean) objArr[0]).booleanValue();
            }
            if (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay()) {
                a0 a0Var = this.s0;
                if (a0Var != null) {
                    a0Var.a(true);
                    return;
                }
                if (!this.f57957b) {
                    this.f57957b = true;
                    d.b.c.e.p.l.K(this.G0, R.string.play_video_mobile_tip2);
                }
                f2(zVar, true, str, str2);
                return;
            }
            a0 a0Var2 = this.s0;
            if (a0Var2 != null) {
                a0Var2.a(false);
                return;
            }
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.G0);
            aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
            aVar.setPositiveButton(R.string.editor_dialog_yes, new f(zVar, str, str2));
            aVar.setNegativeButton(R.string.editor_dialog_no, new g(this));
            aVar.create(this.f57958c).show();
            return;
        }
        f2(zVar, true, str, str2);
        g0 g0Var = this.r0;
        if (g0Var != null) {
            g0Var.a();
        }
    }

    public void j1() {
        d.b.i0.r.d0.b.j().w("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
    }

    public final void j2() {
        VideoListMediaControllerView videoListMediaControllerView;
        if (this.f57961f == null || (videoListMediaControllerView = this.f57963h) == null) {
            return;
        }
        videoListMediaControllerView.s();
        this.P = d.b.j0.j2.n.d().c(this.x);
        if (this.C0) {
            this.f57961f.setVolume(1.0f, 1.0f);
            this.f57961f.start();
            this.C0 = false;
            d.b.c.e.m.e.a().removeCallbacks(this.L0);
            d.b.c.e.m.e.a().postDelayed(this.L0, 20L);
            d.b.c.e.m.e.a().removeCallbacks(this.O0);
            d.b.c.e.m.e.a().removeCallbacks(this.S0);
            if (this.f57961f.L()) {
                this.x0 = 1;
                O0();
            }
            this.P = d.b.j0.j2.n.d().c(this.x);
            this.f57963h.setPlayer(this.f57961f);
            if (this.P != 0) {
                this.v0 = true;
            }
            if (!this.B0) {
                this.f57963h.s();
            }
            if (!this.J && this.f57961f.getDuration() <= 0) {
                K0().setVisibility(4);
            }
        }
        int i2 = 100;
        if (this.P > 100) {
            int duration = this.f57961f.getDuration();
            int i3 = this.P;
            if (duration > i3) {
                i2 = i3;
            }
        }
        this.f57956a = i2;
    }

    public void k1() {
        if (this.f57961f.getDuration() < this.f57961f.getCurrentPosition()) {
            return;
        }
        d.b.j0.j2.n.d().f(this.x, this.f57961f.getCurrentPositionSync());
    }

    public void k2() {
        this.x0 = 5;
        d.b.c.e.m.e.a().removeCallbacks(this.L0);
        d.b.c.e.m.e.a().removeCallbacks(this.O0);
        d.b.c.e.m.e.a().removeCallbacks(this.S0);
        this.f57961f.stopPlayback();
        this.H = false;
        this.C0 = false;
        this.P = 0;
        a1();
    }

    public void l1(j0 j0Var) {
        this.e0 = j0Var;
    }

    public final void l2() {
        if (this.o == null) {
            return;
        }
        if (this.I) {
            O0();
        } else {
            x0();
        }
    }

    public void m1(String str) {
        this.A = str;
    }

    public void m2() {
        this.j0 = true;
        d.b.j0.j2.j jVar = this.f0;
        if (jVar != null) {
            jVar.l();
        }
    }

    public void n1(boolean z2) {
        this.E0 = z2;
    }

    public void n2() {
        if (this.f57961f != null) {
            int k2 = d.b.c.e.p.l.k(this.G0);
            if (this.s) {
                k2 = d.b.c.e.p.l.i(this.G0);
            }
            this.i.setMax(k2);
            int duration = this.f57961f.getDuration();
            if (duration > 0) {
                if (this.u.getVisibility() == 0) {
                    ProgressBar progressBar = this.i;
                    progressBar.setProgress(progressBar.getMax());
                    return;
                }
                this.i.setProgress((int) ((this.f57961f.getCurrentPositionSync() * this.i.getMax()) / duration));
            }
        }
    }

    public void o1(boolean z2) {
        this.u0 = z2;
        R1();
    }

    public void o2(boolean z2) {
        if (M0(this.G0) && (this.p.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (z2) {
                layoutParams.bottomMargin = L0(this.G0);
                this.p.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.p.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.p.setLayoutParams(layoutParams);
        }
    }

    public final void p0() {
        View view;
        View view2;
        int i2 = this.Z;
        if (i2 == 1) {
            if (this.R == null && (view2 = this.f57960e) != null && (view2 instanceof ViewGroup)) {
                LayoutInflater.from(this.G0).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.f57960e, true);
                View findViewById = this.f57960e.findViewById(R.id.lay_jindu);
                this.R = findViewById;
                this.T = (TextView) findViewById.findViewById(R.id.show_time);
                this.W = (ImageView) this.R.findViewById(R.id.arrow_icon);
            }
        } else if (i2 == 2 && this.S == null && (view = this.f57960e) != null && (view instanceof ViewGroup)) {
            LayoutInflater.from(this.G0).inflate(R.layout.float_video_window_voice, (ViewGroup) this.f57960e, true);
            View findViewById2 = this.f57960e.findViewById(R.id.lay_voice);
            this.S = findViewById2;
            this.V = (ImageView) findViewById2.findViewById(R.id.arrow_voice_icon);
            this.U = (SeekBar) this.S.findViewById(R.id.show_voice_seekbar);
        }
    }

    public void p1(v vVar) {
        this.p0 = vVar;
    }

    public final void p2() {
        if (this.x0 == 1) {
            this.t.setState(1);
        } else {
            this.t.setState(0);
        }
    }

    public void q0() {
        View view = this.r;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f57960e.getLayoutParams();
        this.m = layoutParams2;
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        layoutParams2.topMargin = 0;
        Activity activity = this.G0;
        if (activity != null && activity.getResources() != null && this.G0.getResources().getConfiguration() != null && this.G0.getResources().getConfiguration().orientation == 2) {
            this.f57960e.setLayoutParams(new FrameLayout.LayoutParams(d.b.c.e.p.l.i(this.G0), d.b.c.e.p.l.k(this.G0)));
            return;
        }
        this.f57960e.setLayoutParams(this.m);
    }

    public void q1(boolean z2) {
        this.J = z2;
    }

    public void q2() {
        o2(false);
        z0();
    }

    public final void r0(float f2, boolean z2) {
        if (z2) {
            if (f2 > 0.0f) {
                this.b0 -= 1000;
                this.c0 = 1;
            } else {
                this.b0 += 1000;
                this.c0 = 2;
            }
            int i2 = this.b0;
            if (i2 < 0) {
                this.b0 = 0;
            } else if (i2 > this.f57961f.getDuration()) {
                this.b0 = this.f57961f.getDuration();
            }
        }
        p0();
        String m2 = this.f57963h.m(this.b0);
        if (f2 > 0.0f) {
            this.W.setImageResource(R.drawable.icon_kuaitui);
        } else {
            this.W.setImageResource(R.drawable.icon_kuaijin);
        }
        if (!StringUtils.isNull(m2)) {
            TextView textView = this.T;
            StringBuilder sb = new StringBuilder();
            sb.append(m2);
            sb.append("/");
            sb.append(this.f57963h.m(this.f57961f.getDuration()));
            textView.setText(sb);
        }
        this.f57963h.setCurrentDuration(this.b0, !z2);
        O0();
        n2();
    }

    public void r1(boolean z2) {
        this.K = z2;
    }

    public final void s0(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!this.H) {
            this.Z = 0;
            return;
        }
        if (Z0 == 0) {
            int streamMaxVolume = this.X.getStreamMaxVolume(3);
            this.a0 = streamMaxVolume;
            int i6 = 100 / streamMaxVolume;
            Z0 = i6;
            if (i6 == 0) {
                Z0 = 1;
            }
        }
        p0();
        int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i7 > 0 && (i5 = this.h0) < 100) {
            this.h0 = i5 + 1;
        }
        int i8 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i8 < 0 && (i4 = this.h0) > 0) {
            this.h0 = i4 - 1;
        }
        if (this.h0 % Z0 == 0) {
            if (i7 > 0 && (i3 = this.i0) < this.a0) {
                this.i0 = i3 + 1;
            }
            if (i8 < 0 && (i2 = this.i0) > 0) {
                this.i0 = i2 - 1;
            }
        }
        if (this.h0 > 0) {
            this.V.setImageResource(R.drawable.icon_shengyin_open);
        } else {
            this.V.setImageResource(R.drawable.icon_shengyin_close);
        }
        this.X.setStreamVolume(3, this.i0, 0);
        this.U.setProgress(this.h0);
    }

    public void s1(boolean z2) {
        this.z0 = z2;
    }

    public final void t0() {
        if (this.o == null) {
            return;
        }
        d.b.c.e.m.e.a().removeCallbacks(this.V0);
        this.N.setAnimationListener(null);
        this.M.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public void t1(boolean z2) {
        this.J = z2;
    }

    public final void u0() {
        d.b.c.e.m.e.a().removeCallbacks(this.V0);
        d.b.c.e.m.e.a().postDelayed(this.V0, 3000L);
    }

    public final void u1(int i2) {
        VideoListMediaControllerView videoListMediaControllerView = this.f57963h;
        if (videoListMediaControllerView == null || !(videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f57963h.getLayoutParams();
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        this.f57963h.setLayoutParams(layoutParams);
    }

    public void v0() {
        k2();
        d.b.c.e.m.e.a().removeCallbacks(this.V0);
        d.b.c.e.m.e.a().removeCallbacks(this.L0);
        d.b.c.e.m.e.a().removeCallbacks(this.O0);
        d.b.c.e.m.e.a().removeCallbacks(this.Q0);
        d.b.c.e.m.e.a().removeCallbacks(this.S0);
        this.f0.k();
        a1.unregister(this.G0);
    }

    public void v1(boolean z2) {
    }

    public void w0() {
        x0();
        u0();
    }

    public void w1() {
        if (!d.b.c.e.p.j.z() || !this.A0 || StringUtils.isNull(this.x) || StringUtils.isNull(this.z)) {
            return;
        }
        this.A0 = false;
        this.B0 = true;
        d2(this.x, this.z);
    }

    public void x0() {
        if (this.o == null || this.I || this.F0) {
            return;
        }
        c2(true);
        t0();
        this.o.setVisibility(0);
        this.p.setVisibility(0);
        this.i.setVisibility(8);
        this.I = true;
        y yVar = this.Y;
        if (yVar != null) {
            yVar.a(false);
        }
    }

    public void x1(String str) {
    }

    public void y0() {
        this.s = true;
        this.f57960e.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(d.b.i0.z0.g.c().f(this.G0)), Integer.parseInt(d.b.i0.z0.g.c().e(this.G0))));
        A0(this.G0, true);
        this.q.setVisibility(0);
        this.F.setVisibility(0);
        this.G.setVisibility(0);
        this.l.setVisibility(8);
        this.f57962g.b();
        this.B.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_narrow_white);
        u1(this.g0);
        Q1();
        x xVar = this.O;
        if (xVar != null) {
            xVar.a();
        }
    }

    public void y1(x xVar) {
        this.O = xVar;
    }

    public void z0() {
        this.s = false;
        FrameLayout.LayoutParams layoutParams = this.m;
        if (layoutParams != null) {
            this.f57960e.setLayoutParams(layoutParams);
        }
        A0(this.G0, false);
        this.q.setVisibility(8);
        this.l.setVisibility(0);
        this.f57962g.b();
        this.B.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_enlarge_white);
        VideoListMediaControllerView videoListMediaControllerView = this.f57963h;
        if (videoListMediaControllerView != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f57963h.getLayoutParams();
            layoutParams2.leftMargin = d.b.c.e.p.l.g(this.G0, R.dimen.tbds24);
            layoutParams2.rightMargin = 0;
            this.f57963h.setLayoutParams(layoutParams2);
        }
        this.f57960e.setSystemUiVisibility(0);
        R1();
        x xVar = this.O;
        if (xVar != null) {
            xVar.b();
        }
    }

    public void z1(y yVar) {
        this.Y = yVar;
    }
}
