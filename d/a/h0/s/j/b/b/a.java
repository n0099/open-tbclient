package d.a.h0.s.j.b.b;

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
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.w0.c.j;
import d.a.h0.s.g;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a implements j {
    public static final boolean s = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public SwanVideoView f47654a;

    /* renamed from: b  reason: collision with root package name */
    public Context f47655b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f47656c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47657d;

    /* renamed from: e  reason: collision with root package name */
    public int f47658e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47659f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47661h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.a.b1.g.c f47662i;
    public FrameLayout j;
    public j.d k;
    public j.b l;
    public j.a m;
    public j.e n;
    public j.f o;
    public j.c p;
    public boolean q;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47660g = true;
    public int r = 0;

    /* renamed from: d.a.h0.s.j.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1007a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47663e;

        public RunnableC1007a(Activity activity) {
            this.f47663e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47663e.setRequestedOrientation(0);
            this.f47663e.getWindow().addFlags(1024);
            a.this.N(this.f47663e);
            SwanAppComponentContainerView I = a.this.O().I();
            I.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            g.b(I);
            g.a(this.f47663e, I);
            d.a.h0.s.j.b.a.a.c(a.this.f47662i.n, a.this.f47662i.f41093g, true, a.this.O());
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
            d.a.h0.s.j.b.a.a.c(a.this.f47662i.n, a.this.f47662i.f41093g, false, a.this.O());
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
    public class d extends d.a.h0.s.h.b {
        public d() {
        }

        @Override // d.a.h0.s.h.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                d.a.h0.a.c0.c.a("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                d.a.h0.s.j.b.a.a.b(a.this.f47662i.n, a.this.f47662i.f41093g, "waiting", new JSONObject());
                return;
            }
            d.a.h0.a.c0.c.a("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            c(currentPosition, duration);
        }

        @Override // d.a.h0.s.h.a
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
            d.a.h0.s.j.b.a.a.b(a.this.f47662i.n, a.this.f47662i.f41093g, "timeupdate", jSONObject);
        }

        @Override // d.a.h0.s.h.a
        public void onEnd() {
            a.this.f47657d = false;
            d.a.h0.s.j.b.a.a.b(a.this.f47662i.n, a.this.f47662i.f41093g, "ended", new JSONObject());
            if (a.this.m != null) {
                a.this.m.b(a.this);
            }
            a.this.f47661h = true;
            d.a.h0.a.c0.c.a("video", "onEnded call back");
        }

        @Override // d.a.h0.s.h.a
        public void onError(int i2, int i3, String str) {
            a.this.f47657d = false;
            d.a.h0.a.c0.c.b("video", "errorCode :" + i2);
            a.this.O().L();
            a.this.O().M();
            d.a.h0.s.j.b.a.a.b(a.this.f47662i.n, a.this.f47662i.f41093g, "error", d.a.h0.s.j.a.b.a.c(i3));
            if (a.this.l != null) {
                a.this.l.f(a.this, i2, i3);
            }
            a.this.f47661h = false;
            int currentPosition = a.this.P().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = aVar.r;
            }
            aVar.r = currentPosition;
            d.a.h0.a.c0.c.b("video", "onError what " + i2 + " ,extra " + i3);
        }

        @Override // d.a.h0.s.h.a
        public void onPause() {
            d.a.h0.s.j.b.a.a.b(a.this.f47662i.n, a.this.f47662i.f41093g, "pause", new JSONObject());
            d.a.h0.a.c0.c.a("video", "onPaused call back");
            a.this.f47657d = true;
            if (a.this.p != null) {
                a.this.p.c(a.this);
            }
        }

        @Override // d.a.h0.s.h.a
        public void onPrepared() {
            d.a.h0.a.c0.c.a("video", "onPrepared call back");
            a.this.V();
            a.this.M();
            if (a.this.k != null) {
                a.this.k.e(a.this);
            }
        }

        @Override // d.a.h0.s.h.b, d.a.h0.s.h.a
        public void onResume() {
            super.onResume();
            d.a.h0.s.j.b.a.a.b(a.this.f47662i.n, a.this.f47662i.f41093g, "play", new JSONObject());
            a.this.f47661h = false;
            a.this.f47657d = false;
            a.this.O().M();
            if (a.this.n != null) {
                a.this.n.a(a.this);
            }
        }

        @Override // d.a.h0.s.h.a
        public void onStart() {
            d.a.h0.s.j.b.a.a.b(a.this.f47662i.n, a.this.f47662i.f41093g, "play", new JSONObject());
            a.this.f47661h = false;
            a.this.f47657d = false;
            a.this.O().M();
            if (a.this.o != null) {
                a.this.o.d(a.this);
            }
        }

        public /* synthetic */ d(a aVar, RunnableC1007a runnableC1007a) {
            this();
        }
    }

    public final void K(d.a.h0.a.b1.g.c cVar) {
        d.a.h0.a.b1.g.c cVar2 = this.f47662i;
        if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.f47662i.C, cVar.C)) {
            this.f47659f = true;
        } else {
            this.f47659f = false;
        }
    }

    public a L(Context context, @NonNull d.a.h0.a.b1.g.c cVar) {
        this.f47655b = context;
        this.f47662i = cVar;
        O();
        return this;
    }

    public final void M() {
        if (this.f47660g) {
            return;
        }
        pause();
    }

    public final void N(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final VideoContainerManager O() {
        if (this.f47662i == null) {
            d.a.h0.a.a0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.f47656c == null) {
            this.f47656c = new VideoContainerManager(this.f47655b, this.f47662i);
        }
        return this.f47656c;
    }

    public final SwanVideoView P() {
        if (this.f47654a == null) {
            d.a.h0.a.c0.c.g("video", "create player");
            this.f47654a = new SwanVideoView(this.f47655b);
            Q();
        }
        return this.f47654a;
    }

    public final void Q() {
        P().setVideoPlayerCallback(new d(this, null));
    }

    public final boolean R() {
        return this.q;
    }

    public final boolean S() {
        Activity A;
        e h2 = e.h();
        if (h2 == null || (A = h2.A()) == null || A.isFinishing()) {
            return false;
        }
        A.runOnUiThread(new RunnableC1007a(A));
        this.q = true;
        this.f47654a.setIsLandscape(true);
        return true;
    }

    public final boolean T() {
        Activity A;
        e h2 = e.h();
        if (h2 == null || (A = h2.A()) == null || A.isFinishing()) {
            return false;
        }
        A.setRequestedOrientation(1);
        A.getWindow().clearFlags(1024);
        A.runOnUiThread(new b());
        this.q = false;
        this.f47654a.setIsLandscape(false);
        return true;
    }

    public void U() {
        SwanVideoView swanVideoView = this.f47654a;
        if (swanVideoView != null) {
            swanVideoView.D();
            g.b(this.f47654a);
            this.f47654a = null;
        }
    }

    public final void V() {
        if (f0()) {
            if (this.f47658e != 0) {
                P().B(this.f47658e);
                this.f47658e = 0;
                return;
            }
            int i2 = this.f47662i.q;
            if (i2 != 0) {
                this.f47654a.B(i2 * 1000);
                this.f47662i.q = 0;
                return;
            }
            int i3 = this.r;
            if (i3 != 0) {
                this.f47654a.B(i3);
                this.r = 0;
            }
        }
    }

    public final void W(d.a.h0.a.b1.g.c cVar) {
        if (cVar == null) {
            d.a.h0.a.c0.c.b("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        P().setVideoPath(this.f47662i.C);
        d.a.h0.a.c0.c.a("video", "setDataSource url " + cVar.C);
    }

    public final void X(d.a.h0.a.b1.g.c cVar) {
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

    public final boolean Y(d.a.h0.a.b1.g.c cVar) {
        d.a.h0.a.b1.g.c cVar2 = this.f47662i;
        if (cVar2 == null) {
            return false;
        }
        if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
            d.a.h0.a.b1.g.c cVar3 = this.f47662i;
            return (cVar3.L == cVar.L && cVar3.H == cVar.H && cVar3.I == cVar.I && cVar3.K == cVar.K && cVar3.J == cVar.J && cVar3.t == cVar.t) ? false : true;
        }
        return true;
    }

    public final void Z() {
        O().O(new c());
    }

    @Override // d.a.h0.a.w0.c.j
    public void a() {
    }

    public void a0() {
        if (f0()) {
            O().L();
            U();
            P().w();
            X(this.f47662i);
            g(this.f47662i, false);
            W(this.f47662i);
            P().C();
            this.f47659f = false;
        }
    }

    @Override // d.a.h0.a.w0.c.j
    public void b() {
    }

    public final void b0() {
        SwanVideoView swanVideoView = this.f47654a;
        if (swanVideoView != null) {
            swanVideoView.D();
        }
    }

    @Override // d.a.h0.a.w0.c.j
    public /* bridge */ /* synthetic */ j c(Context context, @NonNull d.a.h0.a.b1.g.c cVar) {
        L(context, cVar);
        return this;
    }

    public final void c0(boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.f47654a == null || z || !isPlaying()) {
            return;
        }
        this.f47654a.x();
    }

    @Override // d.a.h0.a.w0.c.j
    public void d() {
    }

    public void d0(d.a.h0.a.b1.g.c cVar) {
        O().Q(cVar);
        e0();
    }

    @Override // d.a.h0.a.w0.c.j
    public void e(FrameLayout frameLayout) {
        this.j = frameLayout;
    }

    public final void e0() {
        SwanVideoView swanVideoView = this.f47654a;
        if (swanVideoView == null) {
            return;
        }
        g.b(swanVideoView);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.addView(this.f47654a);
        } else {
            O().J().addView(this.f47654a);
        }
    }

    @Override // d.a.h0.a.w0.c.j
    public void f(j.a aVar) {
        this.m = aVar;
    }

    public final boolean f0() {
        d.a.h0.a.b1.g.c cVar = this.f47662i;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f47662i.n) || TextUtils.isEmpty(this.f47662i.f41092f)) ? false : true;
    }

    @Override // d.a.h0.a.w0.c.j
    public void g(d.a.h0.a.b1.g.c cVar, boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        d.a.h0.a.c0.c.a("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (Y(cVar)) {
            X(cVar);
        }
        this.f47662i = cVar;
        if (z) {
            c0(cVar.j());
        }
        d0(cVar);
    }

    @Override // d.a.h0.a.w0.c.j
    public int getCurrentPosition() {
        return P().getCurrentPosition();
    }

    @Override // d.a.h0.a.w0.c.j
    public int getDuration() {
        return P().getDuration();
    }

    @Override // d.a.h0.a.w0.c.j
    public void h(String str) {
    }

    @Override // d.a.h0.a.w0.c.j
    public void i(j.e eVar) {
        this.n = eVar;
    }

    @Override // d.a.h0.a.w0.c.j
    public boolean isEnd() {
        return this.f47661h;
    }

    @Override // d.a.h0.a.w0.c.j
    public boolean isPlaying() {
        SwanVideoView swanVideoView = this.f47654a;
        if (swanVideoView == null) {
            return false;
        }
        return swanVideoView.v();
    }

    @Override // d.a.h0.a.w0.c.j
    public void j(j.f fVar) {
        this.o = fVar;
    }

    @Override // d.a.h0.a.w0.c.j
    public void k(boolean z, int i2) {
        if (z) {
            S();
        } else {
            T();
        }
    }

    @Override // d.a.h0.a.w0.c.j
    public void l(j.d dVar) {
        this.k = dVar;
    }

    @Override // d.a.h0.a.w0.c.j
    public void m(d.a.h0.a.b1.g.c cVar) {
    }

    @Override // d.a.h0.a.w0.c.j
    public void mute(boolean z) {
        P().setMuted(z);
    }

    @Override // d.a.h0.a.w0.c.j
    public void n(boolean z) {
    }

    @Override // d.a.h0.a.w0.c.j
    public void o(d.a.h0.a.b1.g.c cVar) {
        d.a.h0.a.c0.c.a("video", "Open Player " + cVar.n);
        K(cVar);
        this.f47662i = cVar;
        d0(cVar);
        if (cVar.i() && cVar.j()) {
            a0();
            return;
        }
        b0();
        Z();
        O().P(cVar.p, cVar.u);
    }

    @Override // d.a.h0.a.w0.c.j
    public boolean onBackPressed() {
        return R() && T();
    }

    @Override // d.a.h0.a.w0.c.j
    public void p(j.b bVar) {
        this.l = bVar;
    }

    @Override // d.a.h0.a.w0.c.j
    public void pause() {
        P().x();
        this.f47657d = true;
    }

    @Override // d.a.h0.a.w0.c.j
    public void q(j.c cVar) {
        this.p = cVar;
    }

    @Override // d.a.h0.a.w0.c.j
    public void resume() {
        if (this.f47657d && !this.f47659f) {
            P().C();
        } else {
            a0();
        }
    }

    @Override // d.a.h0.a.w0.c.j
    public void seekTo(int i2) {
        if (f0()) {
            if (!this.f47659f) {
                P().B(i2);
            } else {
                this.f47658e = i2;
            }
        }
    }

    @Override // d.a.h0.a.w0.c.j
    public void stop() {
        d.a.h0.a.c0.c.a("video", IntentConfig.STOP);
        U();
        P().y();
    }
}
