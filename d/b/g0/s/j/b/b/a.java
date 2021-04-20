package d.b.g0.s.j.b.b;

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
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.w0.c.j;
import d.b.g0.s.g;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a implements j {
    public static final boolean s = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public SwanVideoView f49792a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49793b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f49794c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49795d;

    /* renamed from: e  reason: collision with root package name */
    public int f49796e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49797f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49799h;
    public d.b.g0.a.b1.g.c i;
    public FrameLayout j;
    public j.d k;
    public j.b l;
    public j.a m;
    public j.e n;
    public j.f o;
    public j.c p;
    public boolean q;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49798g = true;
    public int r = 0;

    /* renamed from: d.b.g0.s.j.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1048a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49800e;

        public RunnableC1048a(Activity activity) {
            this.f49800e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49800e.setRequestedOrientation(0);
            this.f49800e.getWindow().addFlags(1024);
            a.this.N(this.f49800e);
            SwanAppComponentContainerView I = a.this.O().I();
            I.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            g.b(I);
            g.a(this.f49800e, I);
            d.b.g0.s.j.b.a.a.c(a.this.i.n, a.this.i.f43506g, true, a.this.O());
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
            d.b.g0.s.j.b.a.a.c(a.this.i.n, a.this.i.f43506g, false, a.this.O());
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
    public class d extends d.b.g0.s.h.b {
        public d() {
        }

        @Override // d.b.g0.s.h.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                d.b.g0.a.c0.c.a("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                d.b.g0.s.j.b.a.a.b(a.this.i.n, a.this.i.f43506g, "waiting", new JSONObject());
                return;
            }
            d.b.g0.a.c0.c.a("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            c(currentPosition, duration);
        }

        @Override // d.b.g0.s.h.a
        public void b(boolean z) {
            if (z) {
                a.this.S();
            } else {
                a.this.T();
            }
        }

        public final void c(int i, int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Integer.valueOf(i2));
                jSONObject.putOpt("currentTime", Integer.valueOf(i));
            } catch (JSONException e2) {
                if (a.s) {
                    e2.printStackTrace();
                }
            }
            d.b.g0.s.j.b.a.a.b(a.this.i.n, a.this.i.f43506g, "timeupdate", jSONObject);
        }

        @Override // d.b.g0.s.h.a
        public void onEnd() {
            a.this.f49795d = false;
            d.b.g0.s.j.b.a.a.b(a.this.i.n, a.this.i.f43506g, "ended", new JSONObject());
            if (a.this.m != null) {
                a.this.m.d(a.this);
            }
            a.this.f49799h = true;
            d.b.g0.a.c0.c.a("video", "onEnded call back");
        }

        @Override // d.b.g0.s.h.a
        public void onError(int i, int i2, String str) {
            a.this.f49795d = false;
            d.b.g0.a.c0.c.b("video", "errorCode :" + i);
            a.this.O().L();
            a.this.O().M();
            d.b.g0.s.j.b.a.a.b(a.this.i.n, a.this.i.f43506g, "error", d.b.g0.s.j.a.b.a.c(i2));
            if (a.this.l != null) {
                a.this.l.b(a.this, i, i2);
            }
            a.this.f49799h = false;
            int currentPosition = a.this.P().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = aVar.r;
            }
            aVar.r = currentPosition;
            d.b.g0.a.c0.c.b("video", "onError what " + i + " ,extra " + i2);
        }

        @Override // d.b.g0.s.h.a
        public void onPause() {
            d.b.g0.s.j.b.a.a.b(a.this.i.n, a.this.i.f43506g, "pause", new JSONObject());
            d.b.g0.a.c0.c.a("video", "onPaused call back");
            a.this.f49795d = true;
            if (a.this.p != null) {
                a.this.p.e(a.this);
            }
        }

        @Override // d.b.g0.s.h.a
        public void onPrepared() {
            d.b.g0.a.c0.c.a("video", "onPrepared call back");
            a.this.V();
            a.this.M();
            if (a.this.k != null) {
                a.this.k.a(a.this);
            }
        }

        @Override // d.b.g0.s.h.b, d.b.g0.s.h.a
        public void onResume() {
            super.onResume();
            d.b.g0.s.j.b.a.a.b(a.this.i.n, a.this.i.f43506g, "play", new JSONObject());
            a.this.f49799h = false;
            a.this.f49795d = false;
            a.this.O().M();
            if (a.this.n != null) {
                a.this.n.c(a.this);
            }
        }

        @Override // d.b.g0.s.h.a
        public void onStart() {
            d.b.g0.s.j.b.a.a.b(a.this.i.n, a.this.i.f43506g, "play", new JSONObject());
            a.this.f49799h = false;
            a.this.f49795d = false;
            a.this.O().M();
            if (a.this.o != null) {
                a.this.o.f(a.this);
            }
        }

        public /* synthetic */ d(a aVar, RunnableC1048a runnableC1048a) {
            this();
        }
    }

    public final void K(d.b.g0.a.b1.g.c cVar) {
        d.b.g0.a.b1.g.c cVar2 = this.i;
        if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.i.C, cVar.C)) {
            this.f49797f = true;
        } else {
            this.f49797f = false;
        }
    }

    public a L(Context context, @NonNull d.b.g0.a.b1.g.c cVar) {
        this.f49793b = context;
        this.i = cVar;
        O();
        return this;
    }

    public final void M() {
        if (this.f49798g) {
            return;
        }
        pause();
    }

    public final void N(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final VideoContainerManager O() {
        if (this.i == null) {
            d.b.g0.a.a0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.f49794c == null) {
            this.f49794c = new VideoContainerManager(this.f49793b, this.i);
        }
        return this.f49794c;
    }

    public final SwanVideoView P() {
        if (this.f49792a == null) {
            d.b.g0.a.c0.c.g("video", "create player");
            this.f49792a = new SwanVideoView(this.f49793b);
            Q();
        }
        return this.f49792a;
    }

    public final void Q() {
        P().setVideoPlayerCallback(new d(this, null));
    }

    public final boolean R() {
        return this.q;
    }

    public final boolean S() {
        Activity A;
        e y = e.y();
        if (y == null || (A = y.A()) == null || A.isFinishing()) {
            return false;
        }
        A.runOnUiThread(new RunnableC1048a(A));
        this.q = true;
        this.f49792a.setIsLandscape(true);
        return true;
    }

    public final boolean T() {
        Activity A;
        e y = e.y();
        if (y == null || (A = y.A()) == null || A.isFinishing()) {
            return false;
        }
        A.setRequestedOrientation(1);
        A.getWindow().clearFlags(1024);
        A.runOnUiThread(new b());
        this.q = false;
        this.f49792a.setIsLandscape(false);
        return true;
    }

    public void U() {
        SwanVideoView swanVideoView = this.f49792a;
        if (swanVideoView != null) {
            swanVideoView.D();
            g.b(this.f49792a);
            this.f49792a = null;
        }
    }

    public final void V() {
        if (f0()) {
            if (this.f49796e != 0) {
                P().B(this.f49796e);
                this.f49796e = 0;
                return;
            }
            int i = this.i.q;
            if (i != 0) {
                this.f49792a.B(i * 1000);
                this.i.q = 0;
                return;
            }
            int i2 = this.r;
            if (i2 != 0) {
                this.f49792a.B(i2);
                this.r = 0;
            }
        }
    }

    public final void W(d.b.g0.a.b1.g.c cVar) {
        if (cVar == null) {
            d.b.g0.a.c0.c.b("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        P().setVideoPath(this.i.C);
        d.b.g0.a.c0.c.a("video", "setDataSource url " + cVar.C);
    }

    public final void X(d.b.g0.a.b1.g.c cVar) {
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

    public final boolean Y(d.b.g0.a.b1.g.c cVar) {
        d.b.g0.a.b1.g.c cVar2 = this.i;
        if (cVar2 == null) {
            return false;
        }
        if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
            d.b.g0.a.b1.g.c cVar3 = this.i;
            return (cVar3.L == cVar.L && cVar3.H == cVar.H && cVar3.I == cVar.I && cVar3.K == cVar.K && cVar3.J == cVar.J && cVar3.t == cVar.t) ? false : true;
        }
        return true;
    }

    public final void Z() {
        O().O(new c());
    }

    @Override // d.b.g0.a.w0.c.j
    public void a() {
    }

    public void a0() {
        if (f0()) {
            O().L();
            U();
            P().w();
            X(this.i);
            k(this.i, false);
            W(this.i);
            P().C();
            this.f49797f = false;
        }
    }

    @Override // d.b.g0.a.w0.c.j
    public void b() {
    }

    public final void b0() {
        SwanVideoView swanVideoView = this.f49792a;
        if (swanVideoView != null) {
            swanVideoView.D();
        }
    }

    @Override // d.b.g0.a.w0.c.j
    public /* bridge */ /* synthetic */ j c(Context context, @NonNull d.b.g0.a.b1.g.c cVar) {
        L(context, cVar);
        return this;
    }

    public final void c0(boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.f49792a == null || z || !isPlaying()) {
            return;
        }
        this.f49792a.x();
    }

    @Override // d.b.g0.a.w0.c.j
    public void d(d.b.g0.a.b1.g.c cVar) {
    }

    public void d0(d.b.g0.a.b1.g.c cVar) {
        O().Q(cVar);
        e0();
    }

    @Override // d.b.g0.a.w0.c.j
    public void e(boolean z) {
    }

    public final void e0() {
        SwanVideoView swanVideoView = this.f49792a;
        if (swanVideoView == null) {
            return;
        }
        g.b(swanVideoView);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.addView(this.f49792a);
        } else {
            O().J().addView(this.f49792a);
        }
    }

    @Override // d.b.g0.a.w0.c.j
    public void f(d.b.g0.a.b1.g.c cVar) {
        d.b.g0.a.c0.c.a("video", "Open Player " + cVar.n);
        K(cVar);
        this.i = cVar;
        d0(cVar);
        if (cVar.i() && cVar.j()) {
            a0();
            return;
        }
        b0();
        Z();
        O().P(cVar.p, cVar.u);
    }

    public final boolean f0() {
        d.b.g0.a.b1.g.c cVar = this.i;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.i.n) || TextUtils.isEmpty(this.i.f43505f)) ? false : true;
    }

    @Override // d.b.g0.a.w0.c.j
    public void g(j.b bVar) {
        this.l = bVar;
    }

    @Override // d.b.g0.a.w0.c.j
    public int getCurrentPosition() {
        return P().getCurrentPosition();
    }

    @Override // d.b.g0.a.w0.c.j
    public int getDuration() {
        return P().getDuration();
    }

    @Override // d.b.g0.a.w0.c.j
    public void h() {
    }

    @Override // d.b.g0.a.w0.c.j
    public void i(FrameLayout frameLayout) {
        this.j = frameLayout;
    }

    @Override // d.b.g0.a.w0.c.j
    public boolean isEnd() {
        return this.f49799h;
    }

    @Override // d.b.g0.a.w0.c.j
    public boolean isPlaying() {
        SwanVideoView swanVideoView = this.f49792a;
        if (swanVideoView == null) {
            return false;
        }
        return swanVideoView.v();
    }

    @Override // d.b.g0.a.w0.c.j
    public void j(j.a aVar) {
        this.m = aVar;
    }

    @Override // d.b.g0.a.w0.c.j
    public void k(d.b.g0.a.b1.g.c cVar, boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        d.b.g0.a.c0.c.a("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (Y(cVar)) {
            X(cVar);
        }
        this.i = cVar;
        if (z) {
            c0(cVar.j());
        }
        d0(cVar);
    }

    @Override // d.b.g0.a.w0.c.j
    public void l(String str) {
    }

    @Override // d.b.g0.a.w0.c.j
    public void m(j.e eVar) {
        this.n = eVar;
    }

    @Override // d.b.g0.a.w0.c.j
    public void mute(boolean z) {
        P().setMuted(z);
    }

    @Override // d.b.g0.a.w0.c.j
    public void n(j.f fVar) {
        this.o = fVar;
    }

    @Override // d.b.g0.a.w0.c.j
    public void o(boolean z, int i) {
        if (z) {
            S();
        } else {
            T();
        }
    }

    @Override // d.b.g0.a.w0.c.j
    public boolean onBackPressed() {
        return R() && T();
    }

    @Override // d.b.g0.a.w0.c.j
    public void p(j.c cVar) {
        this.p = cVar;
    }

    @Override // d.b.g0.a.w0.c.j
    public void pause() {
        P().x();
        this.f49795d = true;
    }

    @Override // d.b.g0.a.w0.c.j
    public void q(j.d dVar) {
        this.k = dVar;
    }

    @Override // d.b.g0.a.w0.c.j
    public void resume() {
        if (this.f49795d && !this.f49797f) {
            P().C();
        } else {
            a0();
        }
    }

    @Override // d.b.g0.a.w0.c.j
    public void seekTo(int i) {
        if (f0()) {
            if (!this.f49797f) {
                P().B(i);
            } else {
                this.f49796e = i;
            }
        }
    }

    @Override // d.b.g0.a.w0.c.j
    public void stop() {
        d.b.g0.a.c0.c.a("video", IntentConfig.STOP);
        U();
        P().y();
    }
}
