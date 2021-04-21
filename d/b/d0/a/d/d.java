package d.b.d0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.player.AdVideoView;
import d.b.d0.a.i.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.b.d0.a.d.a {
    public static AtomicBoolean U = null;
    public static boolean V = false;
    public AdVideoView N;
    public AtomicInteger O;
    public f P;
    public volatile boolean Q;
    public d.b.d0.a.i.a R;
    public a.InterfaceC0603a S;
    public a.b T;

    /* loaded from: classes2.dex */
    public class a implements d.b.d0.a.i.a {
        public a() {
        }

        @Override // d.b.d0.a.i.a
        public void playCompletion() {
            d.this.W("time_end");
        }

        @Override // d.b.d0.a.i.a
        public void playFailure() {
            d.this.W("video_onError");
        }

        @Override // d.b.d0.a.i.a
        public void playPause() {
            d.this.Z();
        }

        @Override // d.b.d0.a.i.a
        public void playResume() {
            d.this.a0();
        }

        @Override // d.b.d0.a.i.a
        public void renderingStart() {
            try {
                d.this.b0();
                AdVideoView adVideoView = d.this.N;
                adVideoView.getLayoutParams().width = -1;
                adVideoView.getLayoutParams().height = -1;
                d.super.y();
                d.this.G();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0603a {
        public b() {
        }

        @Override // d.b.d0.a.i.a.InterfaceC0603a
        public void onDestroyed() {
            try {
                if (d.this.N != null) {
                    AdVideoView adVideoView = d.this.N;
                    adVideoView.getLayoutParams().width = 1;
                    adVideoView.getLayoutParams().height = 1;
                }
                if (d.this.n != null) {
                    d.this.n.setVisibility(8);
                }
                if (d.this.f43320c != null) {
                    d.this.f43320c.setVisibility(8);
                }
                if (d.this.f43321d != null) {
                    d.this.f43321d.setVisibility(8);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.b {
        public c() {
        }

        @Override // d.b.d0.a.i.a.b
        public void onPrepared() {
            d.this.V();
        }
    }

    /* renamed from: d.b.d0.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0601d implements View.OnClickListener {
        public View$OnClickListenerC0601d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.C();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.E();
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends d.b.d0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final WeakReference<d> f43354g;

        public f(d dVar) {
            this.f43354g = new WeakReference<>(dVar);
        }

        @Override // d.b.d0.a.l.b
        public Object b() {
            d dVar = this.f43354g.get();
            if (!d.U.get() || dVar == null || dVar.N == null || dVar.f43322e == null) {
                return null;
            }
            int currentPosition = dVar.N.getCurrentPosition();
            int duration = dVar.N.getDuration();
            dVar.f43322e.e(duration, duration - currentPosition);
            return null;
        }
    }

    public d(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        this.O = new AtomicInteger(0);
        this.Q = false;
        this.R = new a();
        this.S = new b();
        this.T = new c();
        this.s = "video";
        try {
            AdVideoView adVideoView = new AdVideoView(this.f43318a);
            this.N = adVideoView;
            if (this.G == 17) {
                adVideoView.setDisplayMode(7);
            } else {
                adVideoView.setDisplayMode(2);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
            layoutParams.addRule(13);
            j(this.N, layoutParams);
            this.N.setAdVideoViewListener(this.R);
            this.N.setDestroyedListener(this.S);
            this.N.setPreparedListener(this.T);
            this.N.B();
            this.N.n();
            this.N.setVideoMute(true);
            this.N.setVideoUrl(Y());
        } catch (Exception e2) {
            W("video_container_excepiton_constructor_" + e2.toString());
        }
    }

    @Override // d.b.d0.a.d.a
    public void M() {
        super.M();
    }

    public final void V() {
        try {
            if (this.O.incrementAndGet() == 2) {
                d.b.d0.a.k.a.a(new e());
            }
        } catch (Throwable unused) {
        }
    }

    public final void W(String str) {
        c0();
        V = false;
        super.u(str);
    }

    public Bitmap X() {
        AdVideoView adVideoView = this.N;
        long currentPosition = adVideoView != null ? adVideoView.getCurrentPosition() : 1L;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(this.f43318a, Uri.parse(Y()));
                    long j = currentPosition * 1000;
                    r3 = j > 0 ? mediaMetadataRetriever.getFrameAtTime(j, 3) : null;
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e2) {
                    e2.fillInStackTrace();
                }
            } catch (IllegalArgumentException e3) {
                this.f43323f.d(e3);
                mediaMetadataRetriever.release();
            } catch (RuntimeException e4) {
                this.f43323f.d(e4);
                mediaMetadataRetriever.release();
            }
            return r3;
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e5) {
                e5.fillInStackTrace();
            }
            throw th;
        }
    }

    public final String Y() {
        String b2 = this.i.b(this.u, MaterialLoader.MaterialCacheType.VIDEO);
        return TextUtils.isEmpty(b2) ? this.u : b2;
    }

    public final void Z() {
        AtomicBoolean atomicBoolean = U;
        if (atomicBoolean != null) {
            atomicBoolean.compareAndSet(true, false);
        }
    }

    public final void a0() {
        if (U == null) {
            U = new AtomicBoolean(true);
        }
        U.compareAndSet(false, true);
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void b() {
        super.b();
        this.N.setOnClickListener(new View$OnClickListenerC0601d());
        M();
    }

    public void b0() {
        this.P = new f(this);
        if (U == null) {
            U = new AtomicBoolean(true);
        }
        d.b.d0.a.l.c.a().d(this.P, 0L, 200L, TimeUnit.MILLISECONDS);
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i, int i2) {
    }

    public void c0() {
        AtomicBoolean atomicBoolean = U;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        f fVar = this.P;
        if (fVar != null) {
            fVar.cancel();
            this.P = null;
        }
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void destroy() {
        super.destroy();
        this.N = null;
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public View getAdView() {
        return super.getAdView();
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        String str = d.b.d0.a.d.a.M;
        Log.d(str, "onWindowFocusChanged: " + z);
        if (!z) {
            this.N.r();
        } else {
            this.N.s();
        }
        if (this.N != null && this.Q && z && !V) {
            W("onWindowFocusChanged");
        }
        this.Q = !z;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void pause() {
        if (this.N != null) {
            V = true;
        }
    }

    @Override // d.b.d0.a.d.a, d.b.d0.a.g.b
    public void resume() {
    }

    @Override // d.b.d0.a.d.a
    public void v() {
        AdVideoView adVideoView = this.N;
        if (adVideoView != null) {
            adVideoView.setOnClickListener(null);
        }
    }

    @Override // d.b.d0.a.d.a
    public void y() {
        try {
            this.N.A(Y());
            V();
        } catch (Exception e2) {
            W("video_container_excepiton_doStartOnUIThread_" + e2.toString());
        }
    }
}
