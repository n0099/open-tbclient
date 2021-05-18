package d.a.i0.v.j.b.b;

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
import d.a.i0.a.a2.e;
import d.a.i0.a.c1.d.j;
import d.a.i0.a.k;
import d.a.i0.v.g;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a implements j {
    public static final boolean s = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public SwanVideoView f48385a;

    /* renamed from: b  reason: collision with root package name */
    public Context f48386b;

    /* renamed from: c  reason: collision with root package name */
    public VideoContainerManager f48387c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48388d;

    /* renamed from: e  reason: collision with root package name */
    public int f48389e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48390f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48392h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.a.i1.g.c f48393i;
    public FrameLayout j;
    public j.d k;
    public j.b l;
    public j.a m;
    public j.e n;
    public j.f o;
    public j.c p;
    public boolean q;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48391g = true;
    public int r = 0;

    /* renamed from: d.a.i0.v.j.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1081a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f48394e;

        public RunnableC1081a(Activity activity) {
            this.f48394e = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f48394e.setRequestedOrientation(0);
            this.f48394e.getWindow().addFlags(1024);
            a.this.N(this.f48394e);
            SwanAppComponentContainerView I = a.this.O().I();
            I.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            g.b(I);
            g.a(this.f48394e, I);
            d.a.i0.v.j.b.a.a.c(a.this.f48393i.n, a.this.f48393i.f40672g, true, a.this.O());
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
            d.a.i0.v.j.b.a.a.c(a.this.f48393i.n, a.this.f48393i.f40672g, false, a.this.O());
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
    public class d extends d.a.i0.v.h.b {
        public d() {
        }

        @Override // d.a.i0.v.h.a
        public void a(SwanVideoView swanVideoView) {
            int currentPosition = swanVideoView.getCurrentPosition() / 1000;
            int duration = swanVideoView.getDuration() / 1000;
            int bufferPercentage = (swanVideoView.getBufferPercentage() * duration) / 100;
            if (currentPosition >= bufferPercentage && currentPosition != 0 && (currentPosition <= 0 || bufferPercentage != 0)) {
                d.a.i0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo wait progress : %s, buffer : %s, duration : %s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
                d.a.i0.v.j.b.a.a.b(a.this.f48393i.n, a.this.f48393i.f40672g, "waiting", new JSONObject());
                return;
            }
            d.a.i0.a.e0.d.a("SwanAppVideoPlayer", String.format("onInfo update progress : %s, buffer : %s, duration :%s", Integer.valueOf(currentPosition), Integer.valueOf(bufferPercentage), Integer.valueOf(duration)));
            c(currentPosition, duration);
        }

        @Override // d.a.i0.v.h.a
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
            d.a.i0.v.j.b.a.a.b(a.this.f48393i.n, a.this.f48393i.f40672g, "timeupdate", jSONObject);
        }

        @Override // d.a.i0.v.h.a
        public void onEnd() {
            a.this.f48388d = false;
            d.a.i0.v.j.b.a.a.b(a.this.f48393i.n, a.this.f48393i.f40672g, "ended", new JSONObject());
            if (a.this.m != null) {
                a.this.m.b(a.this);
            }
            a.this.f48392h = true;
            d.a.i0.a.e0.d.a("video", "onEnded call back");
        }

        @Override // d.a.i0.v.h.a
        public void onError(int i2, int i3, String str) {
            a.this.f48388d = false;
            d.a.i0.a.e0.d.b("video", "errorCode :" + i2);
            a.this.O().L();
            a.this.O().M();
            d.a.i0.v.j.b.a.a.b(a.this.f48393i.n, a.this.f48393i.f40672g, "error", d.a.i0.v.j.a.b.a.c(i3));
            if (a.this.l != null) {
                a.this.l.f(a.this, i2, i3);
            }
            a.this.f48392h = false;
            int currentPosition = a.this.P().getCurrentPosition();
            a aVar = a.this;
            if (currentPosition <= 0) {
                currentPosition = aVar.r;
            }
            aVar.r = currentPosition;
            d.a.i0.a.e0.d.b("video", "onError what " + i2 + " ,extra " + i3);
        }

        @Override // d.a.i0.v.h.a
        public void onPause() {
            d.a.i0.v.j.b.a.a.b(a.this.f48393i.n, a.this.f48393i.f40672g, "pause", new JSONObject());
            d.a.i0.a.e0.d.a("video", "onPaused call back");
            a.this.f48388d = true;
            if (a.this.p != null) {
                a.this.p.c(a.this);
            }
        }

        @Override // d.a.i0.v.h.a
        public void onPrepared() {
            d.a.i0.a.e0.d.a("video", "onPrepared call back");
            a.this.V();
            a.this.M();
            if (a.this.k != null) {
                a.this.k.e(a.this);
            }
        }

        @Override // d.a.i0.v.h.b, d.a.i0.v.h.a
        public void onResume() {
            super.onResume();
            d.a.i0.v.j.b.a.a.b(a.this.f48393i.n, a.this.f48393i.f40672g, "play", new JSONObject());
            a.this.f48392h = false;
            a.this.f48388d = false;
            a.this.O().M();
            if (a.this.n != null) {
                a.this.n.a(a.this);
            }
        }

        @Override // d.a.i0.v.h.a
        public void onStart() {
            d.a.i0.v.j.b.a.a.b(a.this.f48393i.n, a.this.f48393i.f40672g, "play", new JSONObject());
            a.this.f48392h = false;
            a.this.f48388d = false;
            a.this.O().M();
            if (a.this.o != null) {
                a.this.o.d(a.this);
            }
        }

        public /* synthetic */ d(a aVar, RunnableC1081a runnableC1081a) {
            this();
        }
    }

    public final void K(d.a.i0.a.i1.g.c cVar) {
        d.a.i0.a.i1.g.c cVar2 = this.f48393i;
        if (cVar2 != null && cVar != null && !TextUtils.isEmpty(cVar2.C) && !TextUtils.isEmpty(cVar.C) && !TextUtils.equals(this.f48393i.C, cVar.C)) {
            this.f48390f = true;
        } else {
            this.f48390f = false;
        }
    }

    public a L(Context context, @NonNull d.a.i0.a.i1.g.c cVar) {
        this.f48386b = context;
        this.f48393i = cVar;
        O();
        return this;
    }

    public final void M() {
        if (this.f48391g) {
            return;
        }
        pause();
    }

    public final void N(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final VideoContainerManager O() {
        if (this.f48393i == null) {
            d.a.i0.a.c0.g.a.a("SwanAppVideoPlayer", "getContainerManager with a null mParams");
        }
        if (this.f48387c == null) {
            this.f48387c = new VideoContainerManager(this.f48386b, this.f48393i);
        }
        return this.f48387c;
    }

    public final SwanVideoView P() {
        if (this.f48385a == null) {
            d.a.i0.a.e0.d.g("video", "create player");
            this.f48385a = new SwanVideoView(this.f48386b);
            Q();
        }
        return this.f48385a;
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
        k.runOnUiThread(new RunnableC1081a(k));
        this.q = true;
        this.f48385a.setIsLandscape(true);
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
        this.f48385a.setIsLandscape(false);
        return true;
    }

    public void U() {
        SwanVideoView swanVideoView = this.f48385a;
        if (swanVideoView != null) {
            swanVideoView.D();
            g.b(this.f48385a);
            this.f48385a = null;
        }
    }

    public final void V() {
        if (f0()) {
            if (this.f48389e != 0) {
                P().B(this.f48389e);
                this.f48389e = 0;
                return;
            }
            int i2 = this.f48393i.q;
            if (i2 != 0) {
                this.f48385a.B(i2 * 1000);
                this.f48393i.q = 0;
                return;
            }
            int i3 = this.r;
            if (i3 != 0) {
                this.f48385a.B(i3);
                this.r = 0;
            }
        }
    }

    public final void W(d.a.i0.a.i1.g.c cVar) {
        if (cVar == null) {
            d.a.i0.a.e0.d.b("SwanAppVideoPlayer", "setDataSource params is null!");
            return;
        }
        P().setVideoPath(this.f48393i.C);
        d.a.i0.a.e0.d.a("video", "setDataSource url " + cVar.C);
    }

    public final void X(d.a.i0.a.i1.g.c cVar) {
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

    public final boolean Y(d.a.i0.a.i1.g.c cVar) {
        d.a.i0.a.i1.g.c cVar2 = this.f48393i;
        if (cVar2 == null) {
            return false;
        }
        if (cVar2.o == cVar.o && cVar2.B == cVar.B && TextUtils.equals(cVar2.u, cVar.u)) {
            d.a.i0.a.i1.g.c cVar3 = this.f48393i;
            return (cVar3.L == cVar.L && cVar3.H == cVar.H && cVar3.I == cVar.I && cVar3.K == cVar.K && cVar3.J == cVar.J && cVar3.t == cVar.t) ? false : true;
        }
        return true;
    }

    public final void Z() {
        O().O(new c());
    }

    @Override // d.a.i0.a.c1.d.j
    public void a(FrameLayout frameLayout) {
        this.j = frameLayout;
    }

    public void a0() {
        if (f0()) {
            O().L();
            U();
            P().w();
            X(this.f48393i);
            h(this.f48393i, false);
            W(this.f48393i);
            P().C();
            this.f48390f = false;
        }
    }

    @Override // d.a.i0.a.c1.d.j
    public void b() {
    }

    public final void b0() {
        SwanVideoView swanVideoView = this.f48385a;
        if (swanVideoView != null) {
            swanVideoView.D();
        }
    }

    @Override // d.a.i0.a.c1.d.j
    public void c() {
    }

    public final void c0(boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "updatePlayStateAfterVisibleChanged isVisible=" + z);
        }
        if (this.f48385a == null || z || !isPlaying()) {
            return;
        }
        this.f48385a.x();
    }

    @Override // d.a.i0.a.c1.d.j
    public void d(boolean z) {
    }

    public void d0(d.a.i0.a.i1.g.c cVar) {
        O().Q(cVar);
        e0();
    }

    @Override // d.a.i0.a.c1.d.j
    public /* bridge */ /* synthetic */ j e(Context context, @NonNull d.a.i0.a.i1.g.c cVar) {
        L(context, cVar);
        return this;
    }

    public final void e0() {
        SwanVideoView swanVideoView = this.f48385a;
        if (swanVideoView == null) {
            return;
        }
        g.b(swanVideoView);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.addView(this.f48385a);
        } else {
            O().J().addView(this.f48385a);
        }
    }

    @Override // d.a.i0.a.c1.d.j
    public void f() {
    }

    public final boolean f0() {
        d.a.i0.a.i1.g.c cVar = this.f48393i;
        return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f48393i.n) || TextUtils.isEmpty(this.f48393i.f40671f)) ? false : true;
    }

    @Override // d.a.i0.a.c1.d.j
    public void g(j.a aVar) {
        this.m = aVar;
    }

    @Override // d.a.i0.a.c1.d.j
    public int getCurrentPosition() {
        return P().getCurrentPosition();
    }

    @Override // d.a.i0.a.c1.d.j
    public int getDuration() {
        return P().getDuration();
    }

    @Override // d.a.i0.a.c1.d.j
    public void h(d.a.i0.a.i1.g.c cVar, boolean z) {
        if (s) {
            Log.e("SwanAppVideoPlayer", "fromUpdateAction=" + z + " params:" + cVar.toString());
        }
        d.a.i0.a.e0.d.a("video", "updatePlayerConfigInternal params: " + cVar.toString());
        if (Y(cVar)) {
            X(cVar);
        }
        this.f48393i = cVar;
        if (z) {
            c0(cVar.j());
        }
        d0(cVar);
    }

    @Override // d.a.i0.a.c1.d.j
    public void i(String str) {
    }

    @Override // d.a.i0.a.c1.d.j
    public boolean isEnd() {
        return this.f48392h;
    }

    @Override // d.a.i0.a.c1.d.j
    public boolean isPlaying() {
        SwanVideoView swanVideoView = this.f48385a;
        if (swanVideoView == null) {
            return false;
        }
        return swanVideoView.v();
    }

    @Override // d.a.i0.a.c1.d.j
    public void j(j.e eVar) {
        this.n = eVar;
    }

    @Override // d.a.i0.a.c1.d.j
    public void k(j.f fVar) {
        this.o = fVar;
    }

    @Override // d.a.i0.a.c1.d.j
    public void l(boolean z, int i2) {
        if (z) {
            S();
        } else {
            T();
        }
    }

    @Override // d.a.i0.a.c1.d.j
    public void m(j.d dVar) {
        this.k = dVar;
    }

    @Override // d.a.i0.a.c1.d.j
    public void mute(boolean z) {
        P().setMuted(z);
    }

    @Override // d.a.i0.a.c1.d.j
    public void n(d.a.i0.a.i1.g.c cVar) {
    }

    @Override // d.a.i0.a.c1.d.j
    public void o(d.a.i0.a.i1.g.c cVar) {
        d.a.i0.a.e0.d.a("video", "Open Player " + cVar.n);
        K(cVar);
        this.f48393i = cVar;
        d0(cVar);
        if (cVar.i() && cVar.j()) {
            a0();
            return;
        }
        b0();
        Z();
        O().P(cVar.p, cVar.u);
    }

    @Override // d.a.i0.a.c1.d.j
    public boolean onBackPressed() {
        return R() && T();
    }

    @Override // d.a.i0.a.c1.d.j
    public void p(j.b bVar) {
        this.l = bVar;
    }

    @Override // d.a.i0.a.c1.d.j
    public void pause() {
        P().x();
        this.f48388d = true;
    }

    @Override // d.a.i0.a.c1.d.j
    public void q(j.c cVar) {
        this.p = cVar;
    }

    @Override // d.a.i0.a.c1.d.j
    public void resume() {
        if (this.f48388d && !this.f48390f) {
            P().C();
        } else {
            a0();
        }
    }

    @Override // d.a.i0.a.c1.d.j
    public void seekTo(int i2) {
        if (f0()) {
            if (!this.f48390f) {
                P().B(i2);
            } else {
                this.f48389e = i2;
            }
        }
    }

    @Override // d.a.i0.a.c1.d.j
    public void stop() {
        d.a.i0.a.e0.d.a("video", IntentConfig.STOP);
        U();
        P().y();
    }
}
