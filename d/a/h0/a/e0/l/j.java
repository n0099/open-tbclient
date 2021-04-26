package d.a.h0.a.e0.l;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.i2.p0;
import d.a.h0.a.i2.w;
import d.a.h0.a.p.c.x0;
import d.a.h0.a.q0.c;
import d.a.h0.a.q1.b.c.a;
import d.a.h0.i.n;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes2.dex */
public class j extends d.a.h0.a.e0.l.c implements d.a.h0.g.b0.a.b.b, a.InterfaceC0736a {
    public static final boolean c1 = d.a.h0.a.k.f43101a;
    public ImageView A0;
    public View B0;
    public ImageView C0;
    public FrameLayout D0;
    public View E0;
    public d.a.h0.g.k0.d K0;
    public d.a.h0.g.k0.d L0;
    public d.a.h0.a.q1.b.c.a N0;
    public TextView P0;
    public boolean Q0;
    public k R0;
    public AudioManager T0;
    public boolean U0;
    public C0635j V0;
    public OrientationEventListener W0;
    public GameCloseGuidePopView Y0;
    public View a1;
    public boolean b1;
    public DuMixGameSurfaceView y0;
    public View z0;
    public d.a.h0.g.b0.a.b.a M0 = new d.a.h0.g.b0.a.b.a();
    public d.a.h0.g.k0.b O0 = new d.a.h0.g.k0.b();
    public volatile boolean S0 = true;
    public String X0 = "landscape";
    public boolean Z0 = false;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x0 f2 = d.a.h0.g.r.a.f();
            j jVar = j.this;
            f2.a(jVar.g0, jVar.m());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnSystemUiVisibilityChangeListener {
        public b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if (j.c1) {
                Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i2 + ",mIsForeground:" + j.this.S0);
            }
            if (j.this.S0 || j.this.d3()) {
                d.a.h0.a.i2.e.d(j.this.f0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Z1();
            d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
            fVar.f45414d = SupportMenuInflater.XML_MENU;
            j.this.s1(fVar);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.c1 && d.a.h0.a.m1.a.a.e()) {
                return;
            }
            if (d.a.h0.a.r1.e.h() != null && d.a.h0.a.q0.c.c().h()) {
                j.this.k3("exitButton");
                return;
            }
            d.a.h0.a.q0.b bVar = new d.a.h0.a.q0.b();
            bVar.i();
            if (bVar.j()) {
                String g2 = bVar.g();
                String f2 = bVar.f();
                d.a.h0.a.q0.c c2 = d.a.h0.a.q0.c.c();
                j jVar = j.this;
                c2.j(jVar.f0, g2, f2, jVar.w1());
                return;
            }
            j.this.k3("exitButton");
        }
    }

    /* loaded from: classes2.dex */
    public class e implements GameCloseGuidePopView.e {
        public e() {
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            j.this.R2();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            if (j.this.Y0 != null) {
                j.this.D0.removeView(j.this.Y0);
            }
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            j.this.R2();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements c.b {
        public f() {
        }

        @Override // d.a.h0.a.q0.c.b
        public void a() {
            j.this.R2();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements GameCloseGuidePopView.e {
        public g() {
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            if (j.this.a1 != null) {
                j.this.D0.removeView(j.this.a1);
                j.this.a1 = null;
            }
            j.this.R2();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.D0.removeView(j.this.E0);
        }
    }

    /* loaded from: classes2.dex */
    public class i extends OrientationEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.i.a f42059a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context, int i2, d.a.h0.g.i.a aVar) {
            super(context, i2);
            this.f42059a = aVar;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            if (j.this.K0.d()) {
                return;
            }
            if (260 >= i2 || i2 >= 280 || j.this.X0 == "landscape") {
                if (80 >= i2 || i2 >= 100 || j.this.X0 == "landscapeReverse") {
                    return;
                }
                j.this.f0.setRequestedOrientation(8);
                j.this.X0 = "landscapeReverse";
                d.a.h0.g.g0.a.a(this.f42059a, j.this.X0);
                if (j.c1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.X0);
                    return;
                }
                return;
            }
            j.this.f0.setRequestedOrientation(0);
            j.this.X0 = "landscape";
            d.a.h0.g.g0.a.a(this.f42059a, j.this.X0);
            if (j.c1) {
                Log.d("SwanGameFragment", "onOrientationChanged: " + j.this.X0);
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.l.j$j  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0635j implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: d.a.h0.a.e0.l.j$j$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f42062e;

            public a(int i2) {
                this.f42062e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.e3()) {
                    return;
                }
                int i2 = this.f42062e;
                if (i2 == -2) {
                    if (j.c1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    j.this.g1();
                } else if (i2 != -1) {
                } else {
                    if (j.c1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                    }
                    j.this.g1();
                }
            }
        }

        public C0635j() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            k0.X(new a(i2));
        }

        public /* synthetic */ C0635j(j jVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class k extends Handler {
        public k() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (j.this.P0 != null) {
                String valueOf = String.valueOf(j.this.y0 == null ? 0 : j.this.y0.getFPS());
                j.this.P0.setText(valueOf);
                if (j.c1) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            j.this.R0.sendEmptyMessageDelayed(0, 500L);
        }

        public /* synthetic */ k(j jVar, a aVar) {
            this();
        }
    }

    public static j f3() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.b w1() {
        return new f();
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        if (d.a.z.a.j()) {
            return d.a.z.a.j();
        }
        if (d.a.h0.a.r1.e.h() != null && d.a.h0.a.q0.c.c().h()) {
            return k3(com.alipay.sdk.widget.j.m);
        }
        d.a.h0.a.q0.b bVar = new d.a.h0.a.q0.b();
        bVar.i();
        if (bVar.j()) {
            d.a.h0.a.q0.c.c().j(this.f0, bVar.g(), bVar.f(), w1());
            return true;
        }
        return k3(com.alipay.sdk.widget.j.m);
    }

    public final void R2() {
        Activity activity = this.f0;
        if (activity != null) {
            activity.moveTaskToBack(true);
        }
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45414d = IntentConfig.CLOSE;
        s1(fVar);
        ((SwanAppActivity) this.f0).handleSwanAppExit(1);
        p0.b().e(2);
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean S1() {
        return true;
    }

    public final GameCloseGuidePopView.e S2() {
        return new g();
    }

    @NonNull
    public d.a.h0.g.k0.b T2() {
        return this.O0;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean U1() {
        return false;
    }

    public View U2() {
        return this.z0;
    }

    public d.a.h0.g.k0.d V2() {
        return this.K0;
    }

    public n W2() {
        return this.j0;
    }

    public d.a.h0.g.k0.d X2() {
        return this.L0;
    }

    public final void Y2() {
        DuMixGameSurfaceView duMixGameSurfaceView = this.y0;
        if (duMixGameSurfaceView == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new b());
    }

    @Override // d.a.h0.a.e0.l.c
    public void Z1() {
        Context m = m();
        if (m instanceof Activity) {
            w.a(m, ((Activity) m).getWindow().getDecorView().getWindowToken());
        }
        a3();
        if (d.a.h0.a.r1.e.O() != null) {
            this.j0.n(d.a.h0.a.r1.e.O().J().a0());
        }
        this.j0.r(d.a.h0.a.w0.a.z().a(), y1(), this.k0, false);
    }

    public final void Z2(View view) {
        this.z0 = view.findViewById(d.a.h0.a.f.titlebar_right_menu);
        this.A0 = (ImageView) view.findViewById(d.a.h0.a.f.titlebar_right_menu_img);
        this.B0 = view.findViewById(d.a.h0.a.f.titlebar_right_menu_line);
        this.C0 = (ImageView) view.findViewById(d.a.h0.a.f.titlebar_right_menu_exit);
        this.A0.setImageDrawable(t().getDrawable(d.a.h0.a.e.aiapps_action_bar_single_menu_white_selector));
        this.C0.setImageDrawable(t().getDrawable(d.a.h0.a.e.aiapps_action_bar_exit_white_selector));
        this.B0.setBackgroundResource(d.a.h0.a.c.aiapps_action_bar_menu_line_white);
        this.z0.setBackgroundResource(d.a.h0.a.e.aiapps_action_bar_right_menu_bg_solid);
        this.A0.setOnClickListener(new c());
        this.C0.setOnClickListener(new d());
    }

    public void a3() {
        FragmentActivity f2 = f();
        if (f2 == null) {
            return;
        }
        if (this.Z0) {
            n nVar = this.j0;
            if (nVar != null && nVar.h()) {
                this.j0.f(false);
            }
            this.j0 = null;
            this.Z0 = false;
        }
        if (this.k0 == null) {
            this.k0 = new SwanAppMenuHeaderView(m());
        }
        if (this.j0 == null) {
            n nVar2 = new n(f2, this.z0, 0, d.a.h0.a.w0.a.y(), new d.a.h0.a.j2.g.b());
            this.j0 = nVar2;
            nVar2.l(d.a.h0.a.i2.e.c());
            this.M0.b(this.j0);
            d.a.h0.g.v.a H = d.a.h0.a.z0.f.V().H();
            if (H != null) {
                H.a(this.j0);
            }
            new d.a.h0.a.c1.a(this.j0, this, this.k0).z();
        }
    }

    public void b3(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(d.a.h0.a.f.ai_games_layout);
        this.D0 = frameLayout;
        DuMixGameSurfaceView r = d.a.h0.g.m.a.m().r();
        this.y0 = r;
        if (r != null && r.getParent() == null) {
            frameLayout.addView(this.y0, 0, new FrameLayout.LayoutParams(-1, -1));
            if (c1) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (c1 && !d.a.h0.a.m1.a.a.l()) {
            View inflate = ((ViewStub) view.findViewById(d.a.h0.a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.P0 = (TextView) inflate.findViewById(d.a.h0.a.f.ai_games_fps_text);
            }
            l3();
        }
        Z2(view);
        this.L0 = new d.a.h0.g.k0.d((FrameLayout) view.findViewById(d.a.h0.a.f.ai_games_na_layout));
        this.K0 = new d.a.h0.g.k0.d(this.D0);
    }

    public boolean c3() {
        return !this.S0;
    }

    @Override // d.a.h0.g.b0.a.b.b
    @NonNull
    public d.a.h0.g.b0.a.b.a d() {
        return this.M0;
    }

    public final boolean d3() {
        d.a.h0.a.e0.l.f E1 = E1();
        return E1 != null && (E1.m() instanceof j);
    }

    public final boolean e3() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        boolean booleanValue = h2 == null ? false : h2.H().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
        if (c1) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void f1(boolean z) {
        super.f1(z);
        if (c1) {
            Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (d0()) {
            if (z) {
                i3();
            } else {
                g3();
            }
        }
    }

    @Override // d.a.h0.a.e0.l.c
    public void g1() {
        C0635j c0635j;
        if (this.U0) {
            AudioManager audioManager = this.T0;
            if (audioManager != null && (c0635j = this.V0) != null) {
                audioManager.abandonAudioFocus(c0635j);
                this.T0 = null;
                this.V0 = null;
            }
            this.U0 = false;
            if (c1) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    public void g3() {
        this.S0 = false;
        g1();
        if (this.E0 == null) {
            this.E0 = new View(this.f0);
        }
        this.D0.removeView(this.E0);
        this.D0.addView(this.E0, new FrameLayout.LayoutParams(-1, -1));
        GameCloseGuidePopView gameCloseGuidePopView = this.Y0;
        if (gameCloseGuidePopView != null) {
            this.D0.removeView(gameCloseGuidePopView);
            this.Y0 = null;
        }
        d.a.h0.g.k0.d dVar = this.K0;
        if (dVar != null) {
            dVar.i();
        }
        d.a.h0.g.k0.d dVar2 = this.L0;
        if (dVar2 != null) {
            dVar2.i();
        }
        DuMixGameSurfaceView duMixGameSurfaceView = this.y0;
        if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        d.a.h0.g.i.a v8Engine = this.y0.getV8Engine();
        if (c1) {
            Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
        }
        if (!v8Engine.o0()) {
            v8Engine.onPause();
            v8Engine.Q(new JSEvent("apphide"));
            d.a.h0.g.g0.b.a(v8Engine);
            EventTarget o = v8Engine.o();
            if (o instanceof d.a.h0.g.e.c) {
                ((d.a.h0.g.e.c) o).hideKeyboard();
            }
        }
        d.a.h0.g.c.j.b.h().l();
        d.a.h0.g.b.d.p().n();
        d.a.h0.a.b1.b.i(false);
        this.y0.r();
        OrientationEventListener orientationEventListener = this.W0;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        n nVar = this.j0;
        if (nVar == null || !nVar.h()) {
            return;
        }
        this.j0.f(false);
    }

    @Override // d.a.h0.a.q1.b.c.a.InterfaceC0736a
    public d.a.h0.a.q1.b.c.a getFloatLayer() {
        d.a.h0.g.k0.d dVar;
        if (this.N0 == null && (dVar = this.L0) != null && dVar.e() != null) {
            this.N0 = new d.a.h0.a.q1.b.c.a(this, this.L0.e(), 0);
        }
        return this.N0;
    }

    public final void h3() {
        if (e3() || this.U0) {
            return;
        }
        if (this.T0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.T0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.V0 == null) {
            this.V0 = new C0635j(this, null);
        }
        this.U0 = this.T0.requestAudioFocus(this.V0, 3, 1) == 1;
        if (c1) {
            Log.d("SwanGameFragment", "   requestAudioFocus");
        }
    }

    public void i3() {
        Activity activity;
        h3();
        DuMixGameSurfaceView duMixGameSurfaceView = this.y0;
        if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        d.a.h0.g.i.a v8Engine = this.y0.getV8Engine();
        if (c1) {
            Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
        }
        this.S0 = true;
        this.y0.s();
        d.a.h0.g.c.j.b.h().k();
        d.a.h0.g.g0.b.b(v8Engine);
        Activity activity2 = this.f0;
        if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
            v8Engine.Q(new d.a.h0.g.u.e(((SwanAppActivity) activity2).getLaunchInfo()));
        }
        v8Engine.onResume();
        if (this.D0 != null && this.E0 != null) {
            k0.U(new h(), 500L);
        }
        Activity activity3 = this.f0;
        if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
            boolean isLandScape = ((SwanAppActivity) activity3).isLandScape();
            if (!this.K0.d()) {
                this.f0.setRequestedOrientation(!isLandScape);
                this.K0.o(isLandScape);
                this.L0.o(isLandScape);
            }
            d.a.h0.a.i2.e.d(this.f0);
        }
        if (this.W0 == null) {
            this.W0 = new i(this.f0, 3, v8Engine);
        }
        if (this.W0.canDetectOrientation() && (activity = this.f0) != null && ((SwanAppActivity) activity).isLandScape()) {
            this.W0.enable();
        } else {
            this.W0.disable();
        }
        d.a.h0.g.b.d.p().y();
        d.a.h0.a.b1.b.i(true);
        d.a.h0.g.k0.d dVar = this.K0;
        if (dVar != null) {
            dVar.k();
        }
        d.a.h0.g.k0.d dVar2 = this.L0;
        if (dVar2 != null) {
            dVar2.k();
        }
        n3();
    }

    public void j3(boolean z) {
        this.Z0 = z;
    }

    public boolean k3(String str) {
        String a2 = d.a.h0.g.k0.i.f.b.a();
        if (TextUtils.equals(a2, d.a.h0.g.k0.i.f.b.b("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                R2();
                return false;
            }
            return false;
        }
        View a3 = d.a.h0.g.r.a.b().a(this.f0, S2());
        this.a1 = a3;
        if (a3 != null) {
            this.D0.addView(a3);
            this.b1 = true;
            d.a.h0.g.k0.i.f.b.c("date", a2);
            return true;
        }
        if (this.Y0 == null) {
            GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(m());
            this.Y0 = gameCloseGuidePopView;
            gameCloseGuidePopView.setOnClickListener(new e());
        }
        this.D0.addView(this.Y0);
        d.a.h0.g.k0.i.f.b.c("date", a2);
        return true;
    }

    public final void l3() {
        if (this.Q0) {
            if (c1) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.Q0 = true;
        k kVar = new k(this, null);
        this.R0 = kVar;
        kVar.sendEmptyMessage(0);
        if (c1) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    public final void m3() {
        if (!this.Q0) {
            if (c1) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.Q0 = false;
        k kVar = this.R0;
        if (kVar != null) {
            kVar.removeMessages(0);
            this.R0 = null;
        }
        if (c1) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    public final void n3() {
        if (h0.A(this.f0)) {
            d.a.h0.a.q1.b.f.d.e(d.a.h0.a.w0.a.c(), d.a.h0.a.h.aiapps_game_not_support_split_screen).C();
            this.f0.finishAndRemoveTask();
        }
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n3();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        p.j(new a(), "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (c1) {
            Log.d("SwanGameFragment", "onDestroy() obj: " + this);
            m3();
        }
        DuMixGameSurfaceView duMixGameSurfaceView = this.y0;
        if (duMixGameSurfaceView != null) {
            duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
            this.y0.p();
        }
        if (this.b1) {
            this.a1 = null;
            d.a.h0.g.r.a.b().release();
        }
        d.a.h0.g.k0.d dVar = this.K0;
        if (dVar != null) {
            dVar.j();
        }
        d.a.h0.g.k0.d dVar2 = this.L0;
        if (dVar2 != null) {
            dVar2.j();
        }
        this.O0.b();
        d.a.h0.a.b1.b.c();
        d.a.h0.g.o.c.b.g(false);
        d.a.h0.g.o.c.b.k();
        super.onDestroy();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        if (c1) {
            Log.d("SwanGameFragment", "onPause() obj: " + this);
        }
        super.onPause();
        if (N()) {
            g3();
        }
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        if (c1) {
            Log.d("SwanGameFragment", "onResume() obj: " + this);
        }
        super.onResume();
        if (N()) {
            i3();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (c1) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        View inflate = layoutInflater.inflate(d.a.h0.a.g.ai_games_fragment, viewGroup, false);
        b3(inflate);
        Y2();
        return inflate;
    }

    @Override // d.a.h0.a.e0.l.c
    public void w2() {
        DuMixGameSurfaceView duMixGameSurfaceView = this.y0;
        if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        this.y0.getV8Engine().Q(new JSEvent("sharebtn"));
    }
}
