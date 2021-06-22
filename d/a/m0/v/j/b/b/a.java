package d.a.m0.v.j.b.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.VideoContainerManager;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.a.a2.e;
import d.a.m0.a.c1.d.j;
import d.a.m0.a.k;
import d.a.m0.v.g;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a implements j {
    public static final boolean s = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public SwanVideoView f52343a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52344b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f52345c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52346d;

    /* renamed from: e  reason: collision with root package name */
    public int f52347e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52348f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52350h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.a.i1.g.c f52351i;
    public FrameLayout j;
    public j.d k;
    public j.b l;
    public j.a m;
    public j.e n;
    public j.f o;
    public j.c p;
    public boolean q;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52349g = true;
    public int r = 0;

    /* renamed from: d.a.m0.v.j.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1151a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f52352e;

        public RunnableC1151a(Activity activity) {
            this.f52352e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f52352e.setRequestedOrientation(0);
            this.f52352e.getWindow().addFlags(1024);
            a.this.N(this.f52352e);
            SwanAppComponentContainerView I = a.this.O().I();
            I.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            g.b(I);
            g.a(this.f52352e, I);
            d.a.m0.v.j.b.a.a.c(a.this.f52351i.n, a.this.f52351i.f44630g, true, a.this.O());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.b(a.this.O().I());
            a.this.O().w();
            d.a.m0.v.j.b.a.a.c(a.this.f52351i.n, a.this.f52351i.f44630g, false, a.this.O());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a0();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.m0.v.h.b {
        public d() {
        }

        @Override // d.a.m0.v.h.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                d.a.m0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                d.a.m0.v.j.b.a.a.b(a.this.f52351i.n, a.this.f52351i.f44630g, "waiting", new JSONObject());
                return;
            }
            d.a.m0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            c(currentPosition, duration);
        }

        @Override // d.a.m0.v.h.a
        public void b(boolean z) {
            if (z) {
                a.this.S();
            } else {
                a.this.T();
            }
        }

        public final void c(int i2, int i3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i3));
                jSONObject.putOpt("currentTime", Integer.valueOf(i2));
            } catch (JSONException e2) {
                if (a.s) {
                    e2.printStackTrace();
                }
            }
            d.a.m0.v.j.b.a.a.b(a.this.f52351i.n, a.this.f52351i.f44630g, "timeupdate", jSONObject);
        }

        @Override // d.a.m0.v.h.a
        public void onEnd() {
            a.this.f52346d = false;
            d.a.m0.v.j.b.a.a.b(a.this.f52351i.n, a.this.f52351i.f44630g, "ended", new JSONObject());
            if (a.this.m != null) {
                a.this.m.b(a.this);
            }
            a.this.f52350h = true;
            d.a.m0.a.e0.d.a("video", "onEnded call back");
        }

        @Override // d.a.m0.v.h.a
        public void onError(int i2, int i3, String str) {
            a.this.f52346d = false;
            d.a.m0.a.e0.d.b("video", "errorCode :" + i2);
            a.this.O().L();
            a.this.O().M();
            d.a.m0.v.j.b.a.a.b(a.this.f52351i.n, a.this.f52351i.f44630g, "error", d.a.m0.v.j.a.b.a.c(i3));
            if (a.this.l != null) {
                a.this.l.f(a.this, i2, i3);
            }
            a.this.f52350h = false;
            int currentPosition = a.this.P().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = aVar.r;
            }
            aVar.r = currentPosition;
            d.a.m0.a.e0.d.b("video", "onError what " + i2 + " ,extra " + i3);
        }

        @Override // d.a.m0.v.h.a
        public void onPause() {
            d.a.m0.v.j.b.a.a.b(a.this.f52351i.n, a.this.f52351i.f44630g, "pause", new JSONObject());
            d.a.m0.a.e0.d.a("video", "onPaused call back");
            a.this.f52346d = true;
            if (a.this.p != null) {
                a.this.p.c(a.this);
            }
        }

        @Override // d.a.m0.v.h.a
        public void onPrepared() {
            d.a.m0.a.e0.d.a("video", "onPrepared call back");
            a.this.V();
            a.this.M();
            if (a.this.k != null) {
                a.this.k.e(a.this);
            }
        }

        @Override // d.a.m0.v.h.b, d.a.m0.v.h.a
        public void onResume() {
            super.onResume();
            d.a.m0.v.j.b.a.a.b(a.this.f52351i.n, a.this.f52351i.f44630g, "play", new JSONObject());
            a.this.f52350h = false;
            a.this.f52346d = false;
            a.this.O().M();
            if (a.this.n != null) {
                a.this.n.a(a.this);
            }
        }

        @Override // d.a.m0.v.h.a
        public void onStart() {
            d.a.m0.v.j.b.a.a.b(a.this.f52351i.n, a.this.f52351i.f44630g, "play", new JSONObject());
            a.this.f52350h = false;
            a.this.f52346d = false;
            a.this.O().M();
            if (a.this.o != null) {
                a.this.o.d(a.this);
            }
        }

        public /* synthetic */ d(a aVar, RunnableC1151a runnableC1151a) {
            this();
        }
    }

    public final void K(d.a.m0.a.i1.g.c cVar) {
        d.a.m0.a.i1.g.c cVar2 = this.f52351i;
        if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.f52351i.C, cVar.C)) {
            this.f52348f = true;
        } else {
            this.f52348f = false;
        }
    }

    public a L(Context context, @NonNull d.a.m0.a.i1.g.c cVar) {
        this.f52344b = context;
        this.f52351i = cVar;
        O();
        return this;
    }

    public final void M() {
        if (this.f52349g) {
            return;
        }
        pause();
    }

    public final void N(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final VideoContainerManager O() {
        if (this.f52351i == null) {
            d.a.m0.a.c0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.f52345c == null) {
            this.f52345c = new VideoContainerManager(this.f52344b, this.f52351i);
        }
        return this.f52345c;
    }

    public final SwanVideoView P() {
        if (this.f52343a == null) {
            d.a.m0.a.e0.d.g("video", "create player");
            this.f52343a = new SwanVideoView(this.f52344b);
            Q();
        }
        return this.f52343a;
    }

    public final void Q() {
        P().setVideoPlayerCallback(new d(this, null));
    }

    public final boolean R() {
        return this.q;
    }

    public final boolean S() {
        Activity k;
        e i2 = e.i();
        if (i2 == null || (k = i2.k()) == null || k.isFinishing()) {
            return false;
        }
        k.runOnUiThread(new RunnableC1151a(k));
        this.q = true;
        this.f52343a.setIsLandscape(true);
        return true;
    }

    public final boolean T() {
        Activity k;
        e i2 = e.i();
        if (i2 == null || (k = i2.k()) == null || k.isFinishing()) {
            return false;
        }
        k.setRequestedOrientation(1);
        k.getWindow().clearFlags(1024);
        k.runOnUiThread(new b());
        this.q = false;
        this.f52343a.setIsLandscape(false);
        return true;
    }

    public void U() {
        SwanVideoView swanVideoView = this.f52343a;
        if (swanVideoView != null) {
            swanVideoView.D();
            g.b(this.f52343a);
            this.f52343a = null;
        }
    }

    public final void V() {
        if (f0()) {
            if (this.f52347e != 0) {
                P().B(this.f52347e);
                this.f52347e = 0;
                return;
            }
            int i2 = this.f52351i.q;
            if (i2 != 0) {
                this.f52343a.B(i2 * 1000);
                this.f52351i.q = 0;
                return;
            }
            int i3 = this.r;
            if (i3 != 0) {
                this.f52343a.B(i3);
                this.r = 0;
            }
        }
    }

    public final void W(d.a.m0.a.i1.g.c cVar) {
        if (cVar == null) {
            d.a.m0.a.e0.d.b("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        P().setVideoPath(this.f52351i.C);
        d.a.m0.a.e0.d.a("video", "setDataSource url " + cVar.C);
    }

    public final void X(d.a.m0.a.i1.g.c cVar) {
        P().setMuted(cVar.o);
        P().setMediaControllerEnabled(cVar.B);
        P().setLooping(cVar.t);
        if (TextUtils.equals(cVar.u, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
            P().setVideoScalingMode(2);
        } else if (TextUtils.equals(cVar.u, "fill")) {
            P().setVideoScalingMode(3);
        } else {
            P().setVideoScalingMode(1);
        }
    }

    public final boolean Y(d.a.m0.a.i1.g.c cVar) {
        d.a.m0.a.i1.g.c cVar2 = this.f52351i;
        if (cVar2 == null) {
            return false;
        }
        if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
            d.a.m0.a.i1.g.c cVar3 = this.f52351i;
            return (cVar3.L == cVar.L && cVar3.H == cVar.H && cVar3.I == cVar.I && cVar3.K == cVar.K && cVar3.J == cVar.J && cVar3.t == cVar.t) ? false : true;
        }
        return true;
    }

    public final void Z() {
        O().O(new c());
    }

    @Override // d.a.m0.a.c1.d.j
    public void a(FrameLayout frameLayout) {
        this.j = frameLayout;
    }

    public void a0() {
        if (f0()) {
            O().L();
            U();
            P().w();
            X(this.f52351i);
            h(this.f52351i, false);
            W(this.f52351i);
            P().C();
            this.f52348f = false;
        }
    }

    @Override // d.a.m0.a.c1.d.j
    public void b() {
    }

    public final void b0() {
        SwanVideoView swanVideoView = this.f52343a;
        if (swanVideoView != null) {
            swanVideoView.D();
        }
    }

    @Override // d.a.m0.a.c1.d.j
    public void c() {
    }

    public final void c0(boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.f52343a == null || z || !isPlaying()) {
            return;
        }
        this.f52343a.x();
    }

    @Override // d.a.m0.a.c1.d.j
    public void d(boolean z) {
    }

    public void d0(d.a.m0.a.i1.g.c cVar) {
        O().Q(cVar);
        e0();
    }

    @Override // d.a.m0.a.c1.d.j
    public /* bridge */ /* synthetic */ j e(Context context, @NonNull d.a.m0.a.i1.g.c cVar) {
        L(context, cVar);
        return this;
    }

    public final void e0() {
        SwanVideoView swanVideoView = this.f52343a;
        if (swanVideoView == null) {
            return;
        }
        g.b(swanVideoView);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.addView(this.f52343a);
        } else {
            O().J().addView(this.f52343a);
        }
    }

    @Override // d.a.m0.a.c1.d.j
    public void f() {
    }

    public final boolean f0() {
        d.a.m0.a.i1.g.c cVar = this.f52351i;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f52351i.n) || TextUtils.isEmpty(this.f52351i.f44629f)) ? false : true;
    }

    @Override // d.a.m0.a.c1.d.j
    public void g(j.a aVar) {
        this.m = aVar;
    }

    @Override // d.a.m0.a.c1.d.j
    public int getCurrentPosition() {
        return P().getCurrentPosition();
    }

    @Override // d.a.m0.a.c1.d.j
    public int getDuration() {
        return P().getDuration();
    }

    @Override // d.a.m0.a.c1.d.j
    public void h(d.a.m0.a.i1.g.c cVar, boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        d.a.m0.a.e0.d.a("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (Y(cVar)) {
            X(cVar);
        }
        this.f52351i = cVar;
        if (z) {
            c0(cVar.j());
        }
        d0(cVar);
    }

    @Override // d.a.m0.a.c1.d.j
    public void i(String str) {
    }

    @Override // d.a.m0.a.c1.d.j
    public boolean isEnd() {
        return this.f52350h;
    }

    @Override // d.a.m0.a.c1.d.j
    public boolean isPlaying() {
        SwanVideoView swanVideoView = this.f52343a;
        if (swanVideoView == null) {
            return false;
        }
        return swanVideoView.v();
    }

    @Override // d.a.m0.a.c1.d.j
    public void j(j.e eVar) {
        this.n = eVar;
    }

    @Override // d.a.m0.a.c1.d.j
    public void k(j.f fVar) {
        this.o = fVar;
    }

    @Override // d.a.m0.a.c1.d.j
    public void l(boolean z, int i2) {
        if (z) {
            S();
        } else {
            T();
        }
    }

    @Override // d.a.m0.a.c1.d.j
    public void m(j.d dVar) {
        this.k = dVar;
    }

    @Override // d.a.m0.a.c1.d.j
    public void mute(boolean z) {
        P().setMuted(z);
    }

    @Override // d.a.m0.a.c1.d.j
    public void n(d.a.m0.a.i1.g.c cVar) {
    }

    @Override // d.a.m0.a.c1.d.j
    public void o(d.a.m0.a.i1.g.c cVar) {
        d.a.m0.a.e0.d.a("video", "Open Player " + cVar.n);
        K(cVar);
        this.f52351i = cVar;
        d0(cVar);
        if (cVar.i() && cVar.j()) {
            a0();
            return;
        }
        b0();
        Z();
        O().P(cVar.p, cVar.u);
    }

    @Override // d.a.m0.a.c1.d.j
    public boolean onBackPressed() {
        return R() && T();
    }

    @Override // d.a.m0.a.c1.d.j
    public void p(j.b bVar) {
        this.l = bVar;
    }

    @Override // d.a.m0.a.c1.d.j
    public void pause() {
        P().x();
        this.f52346d = true;
    }

    @Override // d.a.m0.a.c1.d.j
    public void q(j.c cVar) {
        this.p = cVar;
    }

    @Override // d.a.m0.a.c1.d.j
    public void resume() {
        if (this.f52346d && !this.f52348f) {
            P().C();
        } else {
            a0();
        }
    }

    @Override // d.a.m0.a.c1.d.j
    public void seekTo(int i2) {
        if (f0()) {
            if (!this.f52348f) {
                P().B(i2);
            } else {
                this.f52347e = i2;
            }
        }
    }

    @Override // d.a.m0.a.c1.d.j
    public void stop() {
        d.a.m0.a.e0.d.a("video", IntentConfig.STOP);
        U();
        P().y();
    }
}
