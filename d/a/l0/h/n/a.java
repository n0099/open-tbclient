package d.a.l0.h.n;

import android.annotation.SuppressLint;
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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.v0.c;
import d.a.l0.a.v2.f0;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.x;
import d.a.l0.a.v2.x0;
import d.a.l0.a.z1.b.c.a;
import d.a.l0.h.o0.g.f.c;
import d.a.l0.k.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.h0.g.d implements d.a.l0.h.e0.a.b.b, a.InterfaceC0935a {
    public static final boolean f1 = d.a.l0.a.k.f43199a;
    public View A0;
    public ImageView B0;
    public FrameLayout C0;
    public View D0;
    public d.a.l0.h.o0.c E0;
    public d.a.l0.h.o0.c K0;
    public d.a.l0.a.z1.b.c.a M0;
    public TextView O0;
    public boolean P0;
    public m Q0;
    public AudioManager S0;
    public boolean T0;
    public l U0;
    public OrientationEventListener V0;
    public GameCloseGuidePopView X0;
    public d.a.l0.h.o0.g.f.c Y0;
    public View a1;
    public boolean b1;
    public long c1;
    public long d1;
    public DuMixGameSurfaceView x0;
    public View y0;
    public ImageView z0;
    public d.a.l0.h.e0.a.b.a L0 = new d.a.l0.h.e0.a.b.a();
    public d.a.l0.h.o0.a N0 = new d.a.l0.h.o0.a();
    public volatile boolean R0 = true;
    public String W0 = "landscape";
    public boolean Z0 = false;
    public boolean e1 = false;

    /* renamed from: d.a.l0.h.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1032a implements Runnable {
        public RunnableC1032a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.C0.removeView(a.this.D0);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends OrientationEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.l0.a f47487a;

        /* renamed from: d.a.l0.h.n.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1033a implements Runnable {
            public RunnableC1033a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int b2;
                if (!f0.q(a.this.h(), a.this.y0) || (b2 = f0.b(a.this.h())) <= 0) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.y0.getLayoutParams();
                layoutParams.rightMargin += b2;
                a.this.y0.setLayoutParams(layoutParams);
                d.a.l0.h.t.a.e().b(b2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, int i2, d.a.l0.a.l0.a aVar) {
            super(context, i2);
            this.f47487a = aVar;
        }

        @Override // android.view.OrientationEventListener
        @SuppressLint({"SourceLockedOrientationActivity"})
        public void onOrientationChanged(int i2) {
            if (a.this.E0.h()) {
                return;
            }
            if (260 >= i2 || i2 >= 280 || a.this.W0.equals("landscape")) {
                if (80 >= i2 || i2 >= 100 || a.this.W0.endsWith("landscapeReverse")) {
                    return;
                }
                a.this.f0.setRequestedOrientation(8);
                a.this.W0 = "landscapeReverse";
                d.a.l0.h.j0.a.a(this.f47487a, a.this.W0);
                if (a.f1) {
                    Log.d("SwanGameFragment", "onOrientationChanged: " + a.this.W0);
                }
                a.this.y0.postDelayed(new RunnableC1033a(), 100L);
                return;
            }
            a.this.f0.setRequestedOrientation(0);
            a.this.W0 = "landscape";
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.y0.getLayoutParams();
            layoutParams.rightMargin = a.this.z().getDimensionPixelSize(d.a.l0.a.d.aigames_action_bar_right_operation_margin);
            a.this.y0.setLayoutParams(layoutParams);
            d.a.l0.h.t.a.e().b(0);
            d.a.l0.h.j0.a.a(this.f47487a, a.this.W0);
            if (a.f1) {
                Log.d("SwanGameFragment", "onOrientationChanged: " + a.this.W0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.h.t.a.i().a(a.this.g0, a.this.q());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnSystemUiVisibilityChangeListener {
        public d() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if (a.f1) {
                Log.d("SwanGameFragment", "onSystemUiVisibilityChange:" + i2 + ",mIsForeground:" + a.this.R0);
            }
            if (a.this.R0 || a.this.q3()) {
                d.a.l0.a.v2.f.e(a.this.f0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int e2 = f0.e(a.this.q());
            if (!f0.q(a.this.h(), a.this.y0) || ((SwanAppActivity) a.this.h()).isLandScape()) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.y0.getLayoutParams();
            layoutParams.topMargin = a.this.y0.getTop() + e2;
            a.this.y0.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.e2();
            d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
            fVar.f43189e = SupportMenuInflater.XML_MENU;
            a.this.y1(fVar);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.f1 && d.a.l0.a.u1.a.a.e()) {
                return;
            }
            d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
            if (i2 != null && TextUtils.equals(d.a.l0.a.a2.e.V(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
                a.this.z3();
            } else if (i2 != null && d.a.l0.a.v0.c.c().h()) {
                a.this.y3("exitButton");
            } else {
                d.a.l0.a.v0.b bVar = new d.a.l0.a.v0.b();
                bVar.h();
                if (bVar.k()) {
                    d.a.l0.a.v0.c.c().j(a.this.f0, bVar.f(), bVar.e(), bVar, a.this.C1());
                    return;
                }
                a.this.y3("exitButton");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements c.a {
        public h() {
        }

        @Override // d.a.l0.h.o0.g.f.c.a
        public void a() {
            a.this.t3("pandacontinue");
            a.this.Y0.dismiss();
        }

        @Override // d.a.l0.h.o0.g.f.c.a
        public void b() {
            a.this.t3("pandaclose");
            a.this.Y0.dismiss();
        }

        @Override // d.a.l0.h.o0.g.f.c.a
        public void c() {
            a.this.t3("pandaexit");
            a.this.Y0.dismiss();
            a.this.e3();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements GameCloseGuidePopView.e {
        public i() {
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            a.this.e3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
            a.this.e3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
            if (a.this.X0 != null) {
                a.this.C0.removeView(a.this.X0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements c.b {
        public j() {
        }

        @Override // d.a.l0.a.v0.c.b
        public void a() {
            a.this.e3();
        }
    }

    /* loaded from: classes3.dex */
    public class k implements GameCloseGuidePopView.e {
        public k() {
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void a() {
            if (a.this.a1 != null) {
                a.this.C0.removeView(a.this.a1);
                a.this.a1 = null;
            }
            a.this.e3();
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void b() {
        }

        @Override // com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.e
        public void c() {
        }
    }

    /* loaded from: classes3.dex */
    public class l implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: d.a.l0.h.n.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1034a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f47500e;

            public RunnableC1034a(int i2) {
                this.f47500e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.r3()) {
                    return;
                }
                int i2 = this.f47500e;
                if (i2 == -2) {
                    if (a.f1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    a.this.H2();
                } else if (i2 != -1) {
                } else {
                    if (a.f1) {
                        Log.d("SwanGameFragment", "--focusChange AUDIOFOCUS_LOSS");
                    }
                    a.this.H2();
                }
            }
        }

        public l() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            q0.b0(new RunnableC1034a(i2));
        }

        public /* synthetic */ l(a aVar, c cVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class m extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<TextView> f47502a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<DuMixGameSurfaceView> f47503b;

        public m(TextView textView, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f47502a = new WeakReference<>(textView);
            this.f47503b = new WeakReference<>(duMixGameSurfaceView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TextView textView = this.f47502a.get();
            DuMixGameSurfaceView duMixGameSurfaceView = this.f47503b.get();
            if (textView != null) {
                String valueOf = String.valueOf(duMixGameSurfaceView == null ? 0 : duMixGameSurfaceView.getFPS());
                textView.setText(valueOf);
                if (a.f1) {
                    Log.d("SwanGameFragment", "gameFps:" + valueOf);
                }
            }
            sendEmptyMessageDelayed(0, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.b C1() {
        return new j();
    }

    public static a s3() {
        return new a();
    }

    public final void A3() {
        if (this.P0) {
            if (f1) {
                Log.d("SwanGameFragment", "Fps monitor already started");
                return;
            }
            return;
        }
        this.P0 = true;
        m mVar = new m(this.O0, this.x0);
        this.Q0 = mVar;
        mVar.sendEmptyMessage(0);
        if (f1) {
            Log.d("SwanGameFragment", "Start fps monitor");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (f1) {
            Log.d("SwanGameFragment", "onCreateView obj: " + this);
        }
        if (f0.p(h())) {
            f0.s(h());
        }
        View inflate = layoutInflater.inflate(d.a.l0.a.g.ai_games_fragment, viewGroup, false);
        o3(inflate);
        l3();
        return inflate;
    }

    public final void B3() {
        if (!this.P0) {
            if (f1) {
                Log.d("SwanGameFragment", "fps monitor not started yet");
                return;
            }
            return;
        }
        this.P0 = false;
        m mVar = this.Q0;
        if (mVar != null) {
            mVar.removeMessages(0);
            this.Q0 = null;
        }
        if (f1) {
            Log.d("SwanGameFragment", "Stop fps monitor");
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public void C2() {
        DuMixGameSurfaceView duMixGameSurfaceView = this.x0;
        if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        this.x0.getV8Engine().F(new JSEvent("sharebtn"));
    }

    public final void C3() {
        if (n0.D(this.f0)) {
            d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.f.g.aiapps_game_not_support_split_screen).F();
            this.f0.finishAndRemoveTask();
        }
    }

    public void H2() {
        l lVar;
        if (this.T0) {
            AudioManager audioManager = this.S0;
            if (audioManager != null && (lVar = this.U0) != null) {
                audioManager.abandonAudioFocus(lVar);
                this.S0 = null;
                this.U0 = null;
            }
            this.T0 = false;
            if (f1) {
                Log.d("SwanGameFragment", "   abandonAudioFocus");
            }
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean K() {
        if (d.a.b0.a.j()) {
            return d.a.b0.a.j();
        }
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 != null && TextUtils.equals(d.a.l0.a.a2.e.V(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So")) {
            return z3();
        }
        if (i2 != null && d.a.l0.a.v0.c.c().h()) {
            return y3(com.alipay.sdk.widget.j.m);
        }
        d.a.l0.a.v0.b bVar = new d.a.l0.a.v0.b();
        bVar.h();
        if (bVar.k()) {
            d.a.l0.a.v0.c.c().j(this.f0, bVar.f(), bVar.e(), bVar, C1());
            return true;
        }
        return y3(com.alipay.sdk.widget.j.m);
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean Z1() {
        return false;
    }

    @Override // d.a.l0.h.e0.a.b.b
    @NonNull
    public d.a.l0.h.e0.a.b.a b() {
        return this.L0;
    }

    @Override // d.a.l0.a.h0.g.d
    public void e2() {
        Context q = q();
        if (q instanceof Activity) {
            x.a(q, ((Activity) q).getWindow().getDecorView().getWindowToken());
        }
        n3();
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.k0;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setAttentionBtnStates(d.a.l0.a.j0.b.a.n(d.a.l0.a.a2.d.g().getAppId()));
        }
        if (d.a.l0.a.a2.e.Q() != null) {
            this.j0.m(d.a.l0.a.a2.e.Q().L().d0());
        }
        this.j0.r(d.a.l0.a.c1.a.H().a(), E1(), this.k0, false);
    }

    public final void e3() {
        Activity activity = this.f0;
        if (activity != null) {
            activity.moveTaskToBack(true);
        }
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43189e = IntentConfig.CLOSE;
        y1(fVar);
        ((SwanAppActivity) this.f0).handleSwanAppExit(1);
        x0.b().e(2);
    }

    public final GameCloseGuidePopView.e f3() {
        return new k();
    }

    @NonNull
    public d.a.l0.h.o0.a g3() {
        return this.N0;
    }

    @Override // d.a.l0.a.z1.b.c.a.InterfaceC0935a
    public d.a.l0.a.z1.b.c.a getFloatLayer() {
        d.a.l0.h.o0.c cVar;
        if (this.M0 == null && (cVar = this.K0) != null && cVar.getRootView() != null) {
            this.M0 = new d.a.l0.a.z1.b.c.a(this, this.K0.getRootView(), 0);
        }
        return this.M0;
    }

    public View h3() {
        return this.y0;
    }

    public d.a.l0.h.o0.c i3() {
        return this.E0;
    }

    public n j3() {
        return this.j0;
    }

    public d.a.l0.h.o0.c k3() {
        return this.K0;
    }

    public final void l3() {
        DuMixGameSurfaceView duMixGameSurfaceView = this.x0;
        if (duMixGameSurfaceView == null) {
            return;
        }
        duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(new d());
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        super.m1(z);
        if (f1) {
            Log.d("SwanGameFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (n0()) {
            if (z) {
                w3();
            } else {
                u3();
            }
        }
    }

    public final void m3(View view) {
        View findViewById = view.findViewById(d.a.l0.a.f.titlebar_right_menu);
        this.y0 = findViewById;
        findViewById.post(new e());
        this.z0 = (ImageView) view.findViewById(d.a.l0.a.f.titlebar_right_menu_img);
        this.A0 = view.findViewById(d.a.l0.a.f.titlebar_right_menu_line);
        this.B0 = (ImageView) view.findViewById(d.a.l0.a.f.titlebar_right_menu_exit);
        this.z0.setImageDrawable(z().getDrawable(d.a.l0.a.e.aiapps_action_bar_single_menu_white_selector));
        this.B0.setImageDrawable(z().getDrawable(d.a.l0.a.e.aiapps_action_bar_exit_white_selector));
        this.A0.setBackgroundResource(d.a.l0.a.c.aiapps_action_bar_menu_line_white);
        this.y0.setBackgroundResource(d.a.l0.a.e.aiapps_action_bar_right_menu_bg_solid);
        this.z0.setOnClickListener(new f());
        this.B0.setOnClickListener(new g());
    }

    public void n3() {
        FragmentActivity h2 = h();
        if (h2 == null) {
            return;
        }
        if (this.Z0) {
            n nVar = this.j0;
            if (nVar != null && nVar.g()) {
                this.j0.e(false);
            }
            this.j0 = null;
            this.Z0 = false;
        }
        if (this.k0 == null) {
            this.k0 = new SwanAppMenuHeaderView(q());
        }
        if (this.j0 == null) {
            n nVar2 = new n(h2, this.y0, 0, d.a.l0.a.c1.a.G(), new d.a.l0.a.w2.h.b());
            this.j0 = nVar2;
            nVar2.k(d.a.l0.a.v2.f.c());
            this.L0.b(this.j0);
            d.a.l0.a.p.b.a.k H = d.a.l0.a.g1.f.V().H();
            if (H != null) {
                H.b(this.j0);
            }
            new d.a.l0.a.j1.a(this.j0, this, this.k0).z();
        }
    }

    public void o3(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(d.a.l0.a.f.ai_games_layout);
        this.C0 = frameLayout;
        DuMixGameSurfaceView r = d.a.l0.h.o.c.m().r();
        this.x0 = r;
        if (r != null && r.getParent() == null) {
            frameLayout.addView(this.x0, 0, new FrameLayout.LayoutParams(-1, -1));
            if (f1) {
                Log.d("SwanGameFragment", "SwanGameCoreRuntime GameSurfaceView is added");
            }
        }
        if (f1 && !d.a.l0.a.u1.a.a.n()) {
            View inflate = ((ViewStub) view.findViewById(d.a.l0.a.f.ai_games_fps_text_view_stub)).inflate();
            if (inflate != null) {
                this.O0 = (TextView) inflate.findViewById(d.a.l0.a.f.ai_games_fps_text);
            }
            A3();
        }
        m3(view);
        this.K0 = new d.a.l0.h.o0.c((FrameLayout) view.findViewById(d.a.l0.a.f.ai_games_na_layout));
        this.E0 = new d.a.l0.h.o0.c(this.C0);
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C3();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        q.i(new c(), "SwanGamePageHistory");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (f1) {
            Log.d("SwanGameFragment", "onDestroy() obj: " + this);
            B3();
        }
        DuMixGameSurfaceView duMixGameSurfaceView = this.x0;
        if (duMixGameSurfaceView != null) {
            duMixGameSurfaceView.setOnSystemUiVisibilityChangeListener(null);
            this.x0.p();
        }
        if (this.b1) {
            this.a1 = null;
            d.a.l0.h.t.a.e().release();
        }
        d.a.l0.h.o0.c cVar = this.E0;
        if (cVar != null) {
            cVar.l();
        }
        d.a.l0.h.o0.c cVar2 = this.K0;
        if (cVar2 != null) {
            cVar2.l();
        }
        this.N0.e();
        d.a.l0.a.i1.b.c();
        d.a.l0.h.q.c.b.g(false);
        d.a.l0.h.q.c.b.k();
        super.onDestroy();
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        if (f1) {
            Log.d("SwanGameFragment", "onPause() obj: " + this);
        }
        super.onPause();
        if (W()) {
            u3();
        }
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        if (f1) {
            Log.d("SwanGameFragment", "onResume() obj: " + this);
        }
        super.onResume();
        if (W()) {
            w3();
        }
    }

    public boolean p3() {
        return !this.R0;
    }

    public final boolean q3() {
        d.a.l0.a.h0.g.g J1 = J1();
        return J1 != null && (J1.m() instanceof a);
    }

    public final boolean r3() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        boolean booleanValue = i2 == null ? false : i2.J().c("key_audio_is_mix_with_other", Boolean.FALSE).booleanValue();
        if (f1) {
            Log.d("SwanGameFragment", "   isMixWithOther -> " + booleanValue);
        }
        return booleanValue;
    }

    public final void t3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43189e = str;
        y1(fVar);
    }

    public void u3() {
        this.R0 = false;
        H2();
        if (this.D0 == null) {
            this.D0 = new View(this.f0);
        }
        this.C0.removeView(this.D0);
        this.C0.addView(this.D0, new FrameLayout.LayoutParams(-1, -1));
        GameCloseGuidePopView gameCloseGuidePopView = this.X0;
        if (gameCloseGuidePopView != null) {
            this.C0.removeView(gameCloseGuidePopView);
            this.X0 = null;
        }
        d.a.l0.h.o0.c cVar = this.E0;
        if (cVar != null) {
            cVar.k();
        }
        d.a.l0.h.o0.c cVar2 = this.K0;
        if (cVar2 != null) {
            cVar2.k();
        }
        DuMixGameSurfaceView duMixGameSurfaceView = this.x0;
        if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        d.a.l0.a.l0.a v8Engine = this.x0.getV8Engine();
        if (f1) {
            Log.d("SwanGameFragment", "pause() obj: " + this + " ,v8Engine: " + v8Engine);
        }
        if (!v8Engine.s0()) {
            v8Engine.onPause();
            v8Engine.F(new JSEvent("apphide"));
            d.a.l0.h.j0.b.a(v8Engine);
            EventTarget p = v8Engine.p();
            if (p instanceof d.a.l0.h.d.b) {
                ((d.a.l0.h.d.b) p).hideKeyboard();
            }
        }
        d.a.l0.h.c.j.b.h().l();
        if (this.e1) {
            long currentTimeMillis = System.currentTimeMillis();
            this.d1 = currentTimeMillis;
            d.a.l0.h.j.a.d(this.c1, currentTimeMillis);
        }
        d.a.l0.h.b.d.p().n();
        d.a.l0.a.i1.b.i(false);
        this.x0.r();
        OrientationEventListener orientationEventListener = this.V0;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        n nVar = this.j0;
        if (nVar == null || !nVar.g()) {
            return;
        }
        this.j0.e(false);
    }

    public final void v3() {
        if (r3() || this.T0) {
            return;
        }
        if (this.S0 == null) {
            AudioManager audioManager = (AudioManager) AppRuntime.getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.S0 = audioManager;
            if (audioManager == null) {
                return;
            }
        }
        if (this.U0 == null) {
            this.U0 = new l(this, null);
        }
        this.T0 = this.S0.requestAudioFocus(this.U0, 3, 1) == 1;
        if (f1) {
            Log.d("SwanGameFragment", "   requestAudioFocus");
        }
    }

    public void w3() {
        Activity activity;
        v3();
        DuMixGameSurfaceView duMixGameSurfaceView = this.x0;
        if (duMixGameSurfaceView == null || duMixGameSurfaceView.getV8Engine() == null) {
            return;
        }
        d.a.l0.a.l0.a v8Engine = this.x0.getV8Engine();
        if (f1) {
            Log.d("SwanGameFragment", "resume() obj: " + this + " ,v8Engine: " + v8Engine);
        }
        this.R0 = true;
        this.x0.s();
        d.a.l0.h.c.j.b.h().k();
        d.a.l0.h.j0.b.b(v8Engine);
        Activity activity2 = this.f0;
        if (activity2 != null && (activity2 instanceof SwanAppActivity)) {
            v8Engine.F(new d.a.l0.h.w.e(((SwanAppActivity) activity2).getLaunchInfo()));
        }
        v8Engine.onResume();
        if (this.C0 != null && this.D0 != null) {
            q0.Y(new RunnableC1032a(), 500L);
        }
        Activity activity3 = this.f0;
        if (activity3 != null && (activity3 instanceof SwanAppActivity)) {
            boolean isLandScape = ((SwanAppActivity) activity3).isLandScape();
            if (!this.E0.h()) {
                this.f0.setRequestedOrientation(isLandScape ? this.W0.equals("landscape") ? 0 : 8 : 1);
                this.E0.n(isLandScape);
                this.K0.n(isLandScape);
            }
            d.a.l0.a.v2.f.e(this.f0);
        }
        if (this.V0 == null) {
            this.V0 = new b(this.f0, 3, v8Engine);
        }
        if (this.V0.canDetectOrientation() && (activity = this.f0) != null && ((SwanAppActivity) activity).isLandScape()) {
            this.V0.enable();
        } else {
            this.V0.disable();
        }
        this.e1 = false;
        if (d.a.l0.a.a2.e.i() != null && d.a.l0.a.a2.e.i().N() != null) {
            try {
                this.e1 = new JSONObject(d.a.l0.a.a2.e.i().N().P().getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA)).optBoolean("needDuration");
                this.c1 = System.currentTimeMillis();
            } catch (Exception e2) {
                if (f1) {
                    e2.printStackTrace();
                }
            }
        }
        d.a.l0.h.b.d.p().y();
        d.a.l0.a.i1.b.i(true);
        d.a.l0.h.o0.c cVar = this.E0;
        if (cVar != null) {
            cVar.m();
        }
        d.a.l0.h.o0.c cVar2 = this.K0;
        if (cVar2 != null) {
            cVar2.m();
        }
        C3();
    }

    public void x3(boolean z) {
        this.Z0 = z;
    }

    public boolean y3(String str) {
        String a2 = d.a.l0.h.o0.g.f.b.a();
        if (TextUtils.equals(a2, d.a.l0.h.o0.g.f.b.b("date"))) {
            if (TextUtils.equals(str, "exitButton")) {
                e3();
                return false;
            }
            return false;
        }
        View a3 = d.a.l0.h.t.a.e().a(this.f0, f3());
        this.a1 = a3;
        if (a3 != null) {
            this.C0.addView(a3);
            this.b1 = true;
            d.a.l0.h.o0.g.f.b.c("date", a2);
            return true;
        }
        if (this.X0 == null) {
            GameCloseGuidePopView gameCloseGuidePopView = new GameCloseGuidePopView(q());
            this.X0 = gameCloseGuidePopView;
            gameCloseGuidePopView.setOnClickListener(new i());
        }
        this.C0.addView(this.X0);
        d.a.l0.h.o0.g.f.b.c("date", a2);
        return true;
    }

    public boolean z3() {
        if (this.Y0 == null) {
            d.a.l0.h.o0.g.f.c cVar = new d.a.l0.h.o0.g.f.c(q());
            this.Y0 = cVar;
            cVar.e(new h());
        }
        t3("pandadialog");
        this.Y0.show();
        return true;
    }
}
