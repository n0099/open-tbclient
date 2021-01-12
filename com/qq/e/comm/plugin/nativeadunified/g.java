package com.qq.e.comm.plugin.nativeadunified;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import com.qq.e.ads.nativ.VideoPreloadListener;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.nativ.widget.ViewStatusListener;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.nativeadunified.b;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.bd;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.util.z;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class g implements NativeUnifiedADData, ADEventListener, com.qq.e.comm.plugin.a.d.a, c.a, b, com.qq.e.comm.plugin.r.a {
    private boolean A;
    private boolean B;
    private volatile boolean H;
    private final boolean J;
    private ADListener L;
    private b.a M;
    private b.c N;
    private VideoPreloadListener O;
    private final com.qq.e.comm.plugin.y.c Q;
    private long R;
    private com.qq.e.comm.plugin.c.a.a T;
    private f U;

    /* renamed from: a  reason: collision with root package name */
    NativeAdContainer f12286a;

    /* renamed from: b  reason: collision with root package name */
    boolean f12287b;
    final com.qq.e.comm.plugin.ad.g c;
    MediaView d;
    com.qq.e.comm.plugin.gdtnativead.a.c e;
    volatile com.qq.e.comm.plugin.aa.b.f f;
    Space g;
    boolean j;
    boolean m;
    ImageView n;
    r o;
    private final i p;
    private Context q;
    private final h r;
    private com.qq.e.comm.plugin.ac.a t;
    private long v;
    private int w;
    private boolean z;
    private int s = 0;
    private b.EnumC1199b u = b.EnumC1199b.INIT;
    private int x = 1;
    int h = 1;
    int i = 1;
    private int y = 1;
    private int C = n.a();
    private boolean D = false;
    private boolean E = false;
    private boolean F = true;
    private boolean G = true;
    boolean k = false;
    boolean l = false;
    private boolean I = true;
    private volatile b.d K = b.d.NOT_DOWNLOAD;
    private final a P = new a(Looper.getMainLooper());
    private boolean S = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (g.this.E()) {
                        g.this.a((View) g.this.f12286a);
                        return;
                    } else {
                        sendEmptyMessageDelayed(1, g.this.t() ? 100L : 1000L);
                        return;
                    }
                case 2:
                default:
                    return;
                case 3:
                    GDTLogger.d("MSG_CHECK_VIDEO_VISIBILITY, mMediaStatus = " + g.this.u);
                    g.this.P();
                    return;
                case 4:
                    if (g.this.t != null) {
                        g.this.t.a(message.arg1);
                        if (message.arg1 == 100) {
                            g.this.t.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (g.this.t != null) {
                        g.this.t.setVisibility(8);
                    }
                    if (g.this.e != null) {
                        g.this.e.c();
                        return;
                    }
                    return;
                case 6:
                    g.this.K = b.d.COMPLETE;
                    Object obj = message.obj;
                    if ((obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) && g.this.O != null) {
                        g.this.O.onVideoCached();
                    }
                    if (g.this.m) {
                        g.this.D();
                        if (g.this.N != null) {
                            g.this.N.a();
                            return;
                        }
                        return;
                    }
                    return;
                case 7:
                    Object obj2 = message.obj;
                    if ((obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) && g.this.O != null) {
                        g.this.O.onVideoCacheFailed(700, "video preload failed");
                    }
                    if (g.this.m) {
                        g.this.x = 2;
                        g.this.K = b.d.FAILED;
                        g.this.G();
                        g.this.a(3, new Object[]{700});
                        if (g.this.N != null) {
                            g.this.N.b();
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(JSONObject jSONObject, i iVar) {
        String c = iVar.c();
        this.r = new h(iVar.b(), c, iVar.d(), com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, jSONObject);
        this.r.c(this.r.v() && this.r.ah() && com.qq.e.comm.plugin.l.b.a(this.r.Z()));
        this.c = new com.qq.e.comm.plugin.ad.g();
        this.p = iVar;
        SM sm = GDTADManager.getInstance().getSM();
        this.J = SDKStatus.getSDKVersionCode() >= 70 && sm.getInteger("nativeCheckWindowFocus", 1) == 1;
        this.j = sm.getIntegerForPlacement("needVideoDetailPage", c, 1) == 1;
        this.Q = new com.qq.e.comm.plugin.y.c();
        this.Q.a(c);
        this.Q.b(this.r.m());
        this.Q.c(this.r.H());
        com.qq.e.comm.plugin.a.l.a().a(this.r.al(), this);
        if (sm.getInteger("nativeUnifiedPreloadVideo", 1) == 1) {
            A();
        }
    }

    private void A() {
        if (!t()) {
            GDTLogger.e("only video AD needs preloadVideo");
            return;
        }
        this.z = true;
        e(true);
    }

    private boolean B() {
        File d = ah.d(this.r.G());
        if (d == null || !d.exists()) {
            return false;
        }
        this.v = (int) (d.length() >> 10);
        return true;
    }

    private void C() {
        e(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (!N()) {
            this.e.a(0, true);
            GDTLogger.e("can't play now, auto = " + this.C + ", curr = " + GDTADManager.getInstance().getDeviceStatus().getNetworkType().getNameValue());
        } else if (this.x == 0) {
            GDTLogger.d("readyToPlayOnUIThread, but already play");
        } else {
            if (this.u != b.EnumC1199b.END && this.u != b.EnumC1199b.MANUAL_PAUSE && this.u != b.EnumC1199b.DEV_PAUSE && this.u != b.EnumC1199b.DEV_STOP) {
                a(b.EnumC1199b.AUTO_PAUSE);
            }
            a(8, new Object[]{Integer.valueOf(this.f == null ? -1 : this.f.e())});
            if (H()) {
                return;
            }
            if (!E()) {
                this.P.sendEmptyMessage(3);
                return;
            }
            this.x = 0;
            e_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        return bd.a(this.q, this.f12286a, 50, this.J);
    }

    private void F() {
        if (this.d == null) {
            return;
        }
        if (this.t == null) {
            this.t = new com.qq.e.comm.plugin.ac.a(this.d.getContext());
        } else {
            ViewParent parent = this.t.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
        this.t.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.d.getContext().getApplicationContext(), 46), ak.a(this.d.getContext().getApplicationContext(), 46));
        layoutParams.gravity = 17;
        this.d.addView(this.t, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.d == null) {
            GDTLogger.d("未绑定MediaView组件，不上报视频播放效果！");
            return;
        }
        com.qq.e.comm.plugin.w.d.a(this.h, this.i, this.y, this.x, this.x == 0 ? u() : 0, this.x == 0 ? this.w : 0, this.r.q(), new com.qq.e.comm.plugin.w.b(this.p.d(), com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, this.p.c()), new d.b() { // from class: com.qq.e.comm.plugin.nativeadunified.g.11
            @Override // com.qq.e.comm.plugin.w.d.b
            public void a() {
                GDTLogger.d("NativeAd report video info success");
                if (StringUtil.isEmpty(g.this.r.t())) {
                    return;
                }
                af.a(g.this.r.t());
            }

            @Override // com.qq.e.comm.plugin.w.d.b
            public void a(int i, Exception exc) {
                GDTLogger.e("NativeAd report video info error");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H() {
        return this == c.a();
    }

    private void I() {
        if (SDKStatus.getSDKVersionCode() <= 10 || this.d == null || this.f == null) {
            return;
        }
        if (this.g == null) {
            this.g = new Space(this.q.getApplicationContext());
        } else {
            ViewParent parent = this.g.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.g);
            }
        }
        this.d.addView(this.g, this.f == null ? new FrameLayout.LayoutParams(1, 1) : new FrameLayout.LayoutParams(this.f.getWidth(), this.f.getHeight()));
    }

    private void J() {
        if (SDKStatus.getSDKVersionCode() <= 10 || this.d == null || this.g == null) {
            return;
        }
        this.d.removeView(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        int i = this.j ? 4096 : 0;
        if (this.k) {
            i |= 1024;
        }
        if (this.C == 1) {
            i |= 256;
        } else if (this.C == 2) {
            i |= 512;
        }
        if (this.G) {
            i |= 64;
        }
        if (this.F) {
            i |= 16;
        }
        if (this.A) {
            i |= 4;
        }
        if (this.z) {
            i |= 1;
        }
        GDTLogger.d("trackVideoOptionOnExposed ,eventValue : " + i + " ,Binary : " + Integer.toBinaryString(i));
        u.a(30502, i, this.Q);
    }

    private void L() {
        G();
        a(12, (Object[]) null);
    }

    private String M() {
        return this.r.m();
    }

    private boolean N() {
        return (this.C == 0 && NetworkType.WIFI == GDTADManager.getInstance().getDeviceStatus().getNetworkType()) || this.C == 1 || this.D || this.E;
    }

    private boolean O() {
        int pictureWidth = getPictureWidth();
        int pictureHeight = getPictureHeight();
        if (pictureWidth == 0 || pictureHeight == 0) {
            u.a(30282, (pictureWidth == 0 && pictureHeight == 0) ? 3 : pictureWidth == 0 ? 1 : 2, this.Q);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        switch (this.u) {
            case AUTO_PAUSE:
                if (E()) {
                    this.h = 1;
                    e_();
                }
                this.P.sendEmptyMessageDelayed(3, 500L);
                return;
            case PLAYING:
                if (!E()) {
                    a(b.EnumC1199b.AUTO_PAUSE);
                    if (this.f != null) {
                        this.f.a();
                    }
                }
                this.P.sendEmptyMessageDelayed(3, 500L);
                return;
            default:
                return;
        }
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.n = new ImageView(this.q);
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(ak.a(this.q, 46), ak.a(this.q, 14));
            layoutParams.gravity = 8388693;
        }
        this.f12286a.addView(this.n, layoutParams);
        if (this.r != null) {
            com.qq.e.comm.plugin.util.g.a(this.n, this.r.C());
        }
        this.n.setOnClickListener(new f(this, this.r, this.T, this.q, this.Q));
    }

    private void a(VideoOption videoOption) {
        SM sm = GDTADManager.getInstance().getSM();
        if (sm != null) {
            String string = sm.getString("shouldMuteVideo");
            if (TextUtils.isEmpty(string)) {
                c(videoOption);
            } else {
                this.A = "1".equals(string);
            }
            String stringForPlacement = sm.getStringForPlacement("videoAutoPlayPolicy", p());
            if (TextUtils.isEmpty(stringForPlacement)) {
                b(videoOption);
            } else {
                try {
                    this.C = Integer.parseInt(stringForPlacement);
                } catch (Exception e) {
                    GDTLogger.e(e.getMessage());
                }
            }
        } else {
            c(videoOption);
            b(videoOption);
        }
        if (this.C < 0 || this.C > 2) {
            this.C = n.a();
        }
        if (videoOption != null && SDKStatus.getSDKVersionCode() >= 13) {
            this.G = videoOption.isNeedCoverImage();
            this.F = videoOption.isNeedProgressBar();
            this.k = videoOption.isEnableUserControl();
            if (!videoOption.isEnableDetailPage()) {
                this.j = videoOption.isEnableDetailPage();
            }
        }
        if (videoOption == null || SDKStatus.getSDKVersionCode() < 60) {
            return;
        }
        this.l = videoOption.isDetailPageMuted();
    }

    private void a(NativeAdContainer nativeAdContainer) {
        if (this.f12286a != null) {
            this.f12286a.setViewStatusListener(null);
        }
        this.f12286a = nativeAdContainer;
        this.f12286a.setViewStatusListener(new ViewStatusListener() { // from class: com.qq.e.comm.plugin.nativeadunified.g.5
            @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
            public void onAttachToWindow() {
                GDTLogger.d("Container has attached to window");
                g.this.w();
            }

            @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
            public void onDetachFromWindow() {
                GDTLogger.d("Container has detached to window");
                g.this.a();
            }

            @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
            public void onDispatchTouchEvent(MotionEvent motionEvent) {
                g.this.c.a((View) g.this.f12286a, motionEvent, false);
                g.this.o.a(motionEvent);
            }

            @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
            public void onWindowVisibilityChanged(int i) {
                GDTLogger.d("Container visibility changed visibility: " + i);
                if (i == 0) {
                    g.this.w();
                } else {
                    g.this.a();
                }
            }
        });
    }

    private void a(List<View> list, List<View> list2) {
        if (list != null && list.size() > 0) {
            for (View view : list) {
                view.setOnClickListener(new f(this, this.r, this.T, this.q, this.Q));
            }
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (View view2 : list2) {
            view2.setOnClickListener(new f(this, this.r, this.T, this.q, this.Q, true));
        }
    }

    private void a(boolean z, boolean z2) {
        int i = z ? 30312 : 30322;
        if (z2) {
            i = 30352;
        }
        if (c.a() != null) {
            GDTLogger.e("只能在视频预览页调用视频播放接口");
            u.a(i, 1, this.Q);
        } else if (this.f == null || this.f.c() || !E()) {
            GDTLogger.e("NOT Video AD or visible area too small, can't start play");
            u.a(i, 3, this.Q);
        } else {
            if (z) {
                this.E = true;
                if (!B()) {
                    C();
                    return;
                }
            }
            GDTLogger.d("startVideo by developer");
            this.h = 0;
            e_();
            u.a(i, 2, this.Q);
        }
    }

    private com.qq.e.comm.plugin.ad.f b(View view) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            GDTLogger.d("Ad is not visible.");
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int width2 = rect.width();
        int height2 = rect.height();
        GDTLogger.d("ViewWidth=" + width + ", ViewHeight=" + height);
        GDTLogger.d("VisibleWidth=" + width2 + ", VisibleHeight=" + height2);
        return new com.qq.e.comm.plugin.ad.f(true, width, height, width2, height2, view.toString());
    }

    private void b(VideoOption videoOption) {
        if (videoOption != null) {
            this.C = videoOption.getAutoPlayPolicy();
        }
    }

    private void c(VideoOption videoOption) {
        if (this.B) {
            return;
        }
        if (videoOption != null) {
            this.A = videoOption.getAutoPlayMuted();
        } else {
            this.A = true;
        }
    }

    private void d(boolean z) {
        if (this.d == null || this.f == null) {
            return;
        }
        if (z) {
            this.f.h();
        } else {
            this.f.i();
        }
    }

    private void e(boolean z) {
        if (B()) {
            GDTLogger.d("video exists!");
            if (!z) {
                this.K = b.d.COMPLETE;
                D();
                return;
            }
            if (this.O != null) {
                this.O.onVideoCached();
            }
            GDTLogger.d("preloadVideo, video already cached, cl : " + (this.r == null ? "" : this.r.m()));
        } else if (this.K == b.d.NOT_DOWNLOAD) {
            if (z) {
                GDTLogger.d("preloadVideo, cl : " + (this.r == null ? "" : this.r.m()));
            } else {
                F();
                if (this.e != null) {
                    this.e.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.g.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.this.e != null) {
                                g.this.e.d();
                            }
                        }
                    });
                }
            }
            a(z);
        }
    }

    private void f(boolean z) {
        int i = z ? 30332 : 30342;
        if (c.a() != null) {
            GDTLogger.e("只能在视频预览页调用视频暂停接口");
            u.a(i, 1, this.Q);
        } else if (this.f == null || !this.f.c()) {
            GDTLogger.e("Only Video AD can be paused");
            u.a(i, 3, this.Q);
        } else {
            GDTLogger.d("pauseVideo by developer");
            this.f.a();
            this.e.a(0L);
            a(b.EnumC1199b.DEV_PAUSE);
            u.a(i, 2, this.Q);
        }
    }

    private void v() {
        this.T = new com.qq.e.comm.plugin.c.a.c(this.q) { // from class: com.qq.e.comm.plugin.nativeadunified.g.1
            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(com.qq.e.comm.plugin.s.a aVar) {
                super.a(aVar);
                g.this.a((String) null, false);
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void b(com.qq.e.comm.plugin.s.a aVar) {
                super.b(aVar);
                g.this.a((String) null, false);
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void c(String str) {
                super.c(str);
                g.this.a(str, false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (t() && this.K == b.d.COMPLETE) {
            this.P.sendEmptyMessage(3);
        }
        if (this.f12287b) {
            return;
        }
        this.P.sendEmptyMessage(1);
    }

    @Deprecated
    private void x() {
        if (this.d != null) {
            this.d.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.g.6
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.d != null) {
                        int width = g.this.d.getWidth();
                        int i = (int) ((width * 9.0f) / 16.0f);
                        GDTLogger.d("width = " + width + ", height = " + i);
                        ViewGroup.LayoutParams layoutParams = g.this.d.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = i;
                        g.this.d.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }

    @SuppressLint({"NewApi"})
    private void y() {
        boolean z = this.f == null && this.e == null;
        this.d.removeAllViews();
        FrameLayout.LayoutParams z2 = z();
        if (this.f == null) {
            this.f = new com.qq.e.comm.plugin.aa.b.f(this.q.getApplicationContext());
            this.f.b(true);
            this.f.setFitsSystemWindows(true);
            this.f.setKeepScreenOn(true);
            this.f.setLayoutParams(z2);
            if (SDKStatus.getSDKVersionCode() >= 13) {
                this.f.a(getPictureWidth(), getPictureHeight());
                O();
            }
        } else {
            ViewParent parent = this.f.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f);
            }
        }
        this.d.addView(this.f);
        if (this.e == null) {
            this.e = new com.qq.e.comm.plugin.gdtnativead.a.c(this.q.getApplicationContext(), 1, getImgUrl(), this.F, this.G);
            this.e.setFitsSystemWindows(true);
            this.e.setKeepScreenOn(true);
        } else {
            ViewParent parent2 = this.e.getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(this.e);
            }
        }
        this.f.a(this.e);
        this.d.addView(this.e);
        com.qq.e.comm.plugin.aa.b.a.a(this.d, this.r.o(), this.f);
        com.qq.e.comm.plugin.aa.b.g.a(false);
        this.e.a(this);
        this.e.c(true);
        this.e.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.g.7
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.e != null) {
                    g.this.e.a(3000, true);
                }
            }
        });
        if (z) {
            a(b.EnumC1199b.INIT);
            a(5, (Object[]) null);
        }
    }

    private FrameLayout.LayoutParams z() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d.b a(View view, int i, String str, String str2, boolean z, int i2, boolean z2) {
        com.qq.e.comm.plugin.ad.f b2 = b(view);
        int integerForPlacement = GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, str, 0);
        if (this.r.a_() == 48) {
            i2 = 48;
        } else if (i2 == -1) {
            i2 = (!z || com.qq.e.comm.plugin.util.b.d(this.r)) ? 0 : 1;
        }
        return new d.b(i2, q() == 2 ? d.c.SysBrowser : d.c.InnerBrowser).a(i).a(str2).b(integerForPlacement).a(b2).a(z2);
    }

    protected void a() {
        GDTLogger.d("Container has detach from window");
        this.P.removeMessages(1);
        this.P.removeMessages(3);
        if (this.f == null || this.f == c.b() || !this.f.c()) {
            return;
        }
        this.f.a();
        a(b.EnumC1199b.AUTO_PAUSE);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(int i) {
        this.i = i;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void a(int i, Exception exc) {
        GDTLogger.d("onVideoError");
        this.x = 2;
        a(13, new Object[]{701});
        G();
        l.b(false, this.Q, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final Object[] objArr) {
        this.P.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.g.3
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.L != null) {
                    g.this.L.onADEvent(new ADEvent(i, objArr));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        if (this.f12287b) {
            return;
        }
        l.a((Boolean) null, this.Q, 0);
        com.qq.e.comm.plugin.ad.a.a().a(view);
        this.c.a(System.currentTimeMillis());
        final int b2 = com.qq.e.comm.plugin.ad.a.a().b(view);
        view.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.g.12
            @Override // java.lang.Runnable
            public void run() {
                com.qq.e.comm.plugin.w.b bVar = new com.qq.e.comm.plugin.w.b(g.this.p.d(), com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, g.this.p.c());
                String q = g.this.r.q();
                int i = 2;
                if (g.this.t()) {
                    g.this.K();
                    q = com.qq.e.comm.plugin.w.i.a(q);
                    i = 1;
                }
                com.qq.e.comm.plugin.w.i.a(g.this.c.a(g.this.f12286a, i, g.this.r.x(), null), b2, g.this.r, bVar, q, new d.b() { // from class: com.qq.e.comm.plugin.nativeadunified.g.12.1
                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a() {
                        if (!StringUtil.isEmpty(g.this.r.t())) {
                            af.a(g.this.r.t());
                        }
                        l.a((Boolean) true, g.this.Q, 0);
                    }

                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a(int i2, Exception exc) {
                        GDTLogger.e("NativeUnifiedAD exposed err");
                        l.a((Boolean) false, g.this.Q, i2);
                    }
                });
            }
        });
        this.r.V();
        this.r.W();
        a(1, (Object[]) null);
        this.f12287b = true;
        if (t()) {
            return;
        }
        l.c(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2, boolean z3) {
        if (view == null) {
            GDTLogger.e("clicked view is null");
            return;
        }
        if (!z2) {
            a(2, new Object[]{""});
        }
        d.a a2 = com.qq.e.comm.plugin.w.i.a(this.r);
        d.e eVar = new d.e(str3, com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, str2);
        d.b a3 = a(view, i, str2, str4, z, i2, z3);
        a3.i = com.qq.e.comm.plugin.ad.a.a().b(this.f12286a);
        com.qq.e.comm.plugin.w.a.d.a(view, a2, eVar, a3);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(View view, int i, String str, String str2, String str3, String str4, boolean z, boolean z2) {
        a(view, i, str, str2, str3, str4, z, -1, z2, false);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(View view, String str, boolean z) {
        com.qq.e.comm.plugin.c.e.b(new f.a(this.r, view).f(!z).a(str).a(), this.T);
        if (z) {
            return;
        }
        a(2, new Object[]{""});
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(b.a aVar) {
        this.M = aVar;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(b.EnumC1199b enumC1199b) {
        GDTLogger.d("NativeUnifiedADController setMediaStatus: " + this.u + "-->" + enumC1199b);
        this.u = enumC1199b;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(b.c cVar) {
        this.N = cVar;
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(String str, int i, int i2, long j) {
        if (this.r != null) {
            this.r.i(i);
            if (this.r.z() != null) {
                this.r.z().c(i);
                this.r.z().a(i2);
                this.r.z().a(j);
            }
        }
        this.s = i2;
        a(4, (Object[]) null);
        if (this.M != null) {
            this.M.a(str, i, i2, j);
        }
    }

    void a(String str, boolean z) {
        if (c.a() != null) {
            GDTLogger.e("广告点击太快");
        } else if (this.d == null) {
            GDTLogger.e("未绑定MediaView或广告已被释放！");
        } else {
            if (this.f != null && !this.f.c()) {
                this.h = 0;
            }
            I();
            this.d.removeView(this.f);
            this.d.removeView(this.e);
            c.a(this);
            JSONObject a2 = n.a(this.q, this);
            u.a(30292, 1, this.Q, new com.qq.e.comm.plugin.y.d(a2));
            GDTLogger.i("landing: " + a2.toString());
            c.a(this.e);
            c.a(this.f);
            c.a(u());
            c.a(z);
            String m = m();
            c.a(a(this.f12286a, 0, p(), m, isAppAd(), -1, false));
            c.a(new d.e(o(), com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, p()));
            this.e.a(true, false);
            this.e.a(true);
            a();
            Intent intent = new Intent();
            Context applicationContext = this.q.getApplicationContext();
            intent.setClassName(applicationContext.getApplicationContext(), ar.b());
            intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
            intent.putExtra(ACTD.DELEGATE_NAME_KEY, "detailPage");
            intent.putExtra("antiSpam", m);
            intent.putExtra("detailPageMuted", this.l);
            intent.putExtra("url", str);
            intent.addFlags(268435456);
            applicationContext.startActivity(intent);
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void a(final boolean z) {
        final long currentTimeMillis = System.currentTimeMillis();
        File f = ah.f();
        if (f == null) {
            a(3, new Object[]{700});
            return;
        }
        final String G = this.r.G();
        com.qq.e.comm.plugin.aa.a.a.a().a(new b.a().b(G).a(ah.a(G)).a(f).a(), G, new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.nativeadunified.g.9
            @Override // com.qq.e.comm.plugin.j.a
            public void a() {
                GDTLogger.d("onStarted");
                g.this.K = b.d.START;
                g.this.a(6, (Object[]) null);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, long j2, int i) {
                GDTLogger.d("downloading[" + g.this.getTitle() + "] video ---> Progress: " + i + "%");
                if (g.this.H()) {
                    if (g.this.N != null) {
                        g.this.N.a(i);
                        return;
                    }
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.arg1 = i;
                g.this.P.sendMessage(obtain);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, boolean z2) {
                g.this.v = j >> 10;
                GDTLogger.d("onConnected isRangeSupport: " + z2 + ", total: " + j);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(com.qq.e.comm.plugin.j.c cVar) {
                GDTLogger.e("Download Failed, code: " + cVar.a() + ", msg: " + cVar.b());
                Message obtain = Message.obtain();
                obtain.what = 7;
                obtain.obj = Boolean.valueOf(z);
                g.this.P.sendMessage(obtain);
                g.this.P.sendEmptyMessage(5);
                if (g.this.m) {
                    l.a(cVar, G, g.this.Q);
                }
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(File file, long j) {
                GDTLogger.d("onCompleted");
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                GDTLogger.d("download time: " + currentTimeMillis2 + "ms");
                GDTLogger.d("download speed: " + (g.this.v / currentTimeMillis2) + "kb/s");
                if (g.this.H) {
                    GDTLogger.i("download complete after destroyed");
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 6;
                obtain.obj = Boolean.valueOf(z);
                g.this.P.sendMessage(obtain);
                ba.a(j, (int) g.this.v, G, g.this.Q);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void b() {
                GDTLogger.i("onPaused");
                g.this.K = b.d.PAUSE;
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void c() {
                GDTLogger.i("onCanceled");
                g.this.K = b.d.FAILED;
                g.this.P.sendEmptyMessage(5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, View view2) {
        if (view2 == null || view == null) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.c.a
    public void b(boolean z) {
        GDTLogger.d("onPlayPauseButtonClicked mMediaStatus: " + this.u);
        if (!z) {
            this.h = 0;
        }
        a(z ? b.EnumC1199b.MANUAL_PAUSE : b.EnumC1199b.PLAYING);
        if (!H()) {
            if (this.k) {
                s();
            } else {
                u.a(30192, 3, this.Q);
                this.U.a(false);
            }
        }
        if (this.M != null) {
            this.M.c();
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void b_() {
        GDTLogger.d("onVideoReady");
        this.x = 0;
        if (this.d != null && this.f != null) {
            this.w = this.f.e();
            GDTLogger.d("duration = " + this.w);
        }
        a(7, (Object[]) null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        bindAdToView(context, nativeAdContainer, layoutParams, list, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        GDTLogger.d("NativeUnifiedADController bindAdToView");
        z.a().a(this.p.c());
        if (nativeAdContainer == null) {
            GDTLogger.e("NativeAdContainer can't be null when binding ad to view");
        } else if (context == null) {
            GDTLogger.e("Context can't be null when binding ad to view");
        } else if (this.H) {
            GDTLogger.e("NativeUnifiedADData has been destroyed");
        } else {
            l.b(this.Q);
            this.q = context;
            this.o = new r(this.q);
            v();
            this.U = new f(this, this.r, this.T, this.q, this.Q);
            a(nativeAdContainer);
            a(layoutParams);
            a(list, list2);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            View view = list.get(i2);
            if (view != null) {
                view.setOnClickListener(new e(this, this.r, this.T, this.Q));
            }
            i = i2 + 1;
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.m = false;
        if (this.z && this.K == b.d.START) {
            a(6, (Object[]) null);
        }
        GDTLogger.d("NativeUnifiedADController bindMediaView");
        if (mediaView == null) {
            GDTLogger.e("MediaView shouldn't be null！");
        } else if (mediaView.getVisibility() != 0) {
            GDTLogger.e("MediaView should be visible");
        } else if (Build.VERSION.SDK_INT < 16) {
            GDTLogger.e("Native ad don't support Android version below 4.1");
        } else if (!t()) {
            GDTLogger.e("The native ad doesn't contain video");
        } else {
            if (Build.VERSION.SDK_INT < 11 || mediaView.isHardwareAccelerated()) {
                this.I = true;
            } else {
                GDTLogger.e("Hardware acceleration is off");
                this.I = false;
            }
            if (!a(this.f12286a, mediaView)) {
                GDTLogger.e("MediaView is not in container");
            } else if (this.H) {
                GDTLogger.e("NativeUnifiedADData has been destroyed");
            } else {
                l.d(this.Q);
                this.m = true;
                this.d = mediaView;
                a(videoOption);
                if (this.d != null) {
                    this.d.setOnClickListener(new f(this, this.r, this.T, this.q, this.Q));
                }
                y();
                d(this.A);
                if (B()) {
                    this.K = b.d.COMPLETE;
                } else {
                    this.K = b.d.NOT_DOWNLOAD;
                }
                if (this.C == 1 || NetworkType.WIFI == GDTADManager.getInstance().getDeviceStatus().getNetworkType()) {
                    C();
                }
                if (SDKStatus.getSDKVersionCode() <= 10) {
                    x();
                } else if (SDKStatus.getSDKVersionCode() < 13) {
                    this.d.setRatio(getPictureWidth(), getPictureHeight());
                    O();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        a((String) null, z);
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void c_() {
        GDTLogger.d("onVideoStart");
        if (!this.f12287b) {
            l();
        }
        a(9, (Object[]) null);
        if (this.M != null) {
            this.M.d();
        }
        if (this.R > 0) {
            ba.b(System.currentTimeMillis() - this.R, (int) this.v, this.r.G(), this.Q);
            this.R = -1L;
        }
        l.b(true, this.Q, 0);
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public boolean d() {
        return this.I;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.H = true;
        this.P.removeCallbacksAndMessages(null);
        if (this.f != null) {
            this.f.l();
            this.f = null;
        }
        if (this.d != null) {
            this.d.removeAllViews();
            this.d = null;
        }
        if (this.e != null) {
            this.e.i();
            this.e.removeAllViews();
            this.e = null;
        }
        if (this.t != null) {
            this.t = null;
        }
        if (H()) {
            JSONObject a2 = n.a(this.q, c.a());
            u.a(30292, 4, this.Q, new com.qq.e.comm.plugin.y.d(a2));
            GDTLogger.i("release: " + a2.toString());
            c.g();
        }
        this.q = null;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public com.qq.e.comm.plugin.ad.g e() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void e_() {
        File d = ah.d(this.r.G());
        String absolutePath = d != null ? d.getAbsolutePath() : null;
        if (absolutePath == null) {
            GDTLogger.e("Video path is null.");
            return;
        }
        a(b.EnumC1199b.PLAYING);
        if (this.e != null) {
            this.P.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.g.10
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.e != null) {
                        g.this.e.d();
                    }
                }
            });
        }
        if (this.f != null) {
            if (!absolutePath.equals(this.f.k())) {
                this.f.a(absolutePath);
            }
            if (this.R == 0) {
                this.R = System.currentTimeMillis();
            }
            this.f.b();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData != null && (nativeUnifiedADData instanceof NativeUnifiedADDataAdapter)) {
            NativeUnifiedADData adData = ((NativeUnifiedADDataAdapter) nativeUnifiedADData).getAdData();
            if (adData instanceof g) {
                g gVar = (g) adData;
                if (M() == null) {
                    return gVar.M() == null;
                }
                return M().equals(gVar.M());
            }
            return false;
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public b.d f() {
        return this.K;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void f_() {
        GDTLogger.d("onVideoComplete");
        L();
        this.y = 3;
        a(b.EnumC1199b.END);
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void g() {
        GDTLogger.d("onVideoResume");
        this.y = 2;
        a(11, (Object[]) null);
        if (this.M != null) {
            this.M.d();
        }
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void g_() {
        GDTLogger.d("onVideoStop");
        G();
        a(SDKStatus.getSDKVersionCode() < 13 ? 12 : 14, (Object[]) null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.r.c();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.r.h();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.r.g();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.r.e();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.r.a();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.r.i();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.r.f();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getECPM() {
        return this.r.I();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        return this.r.J();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.r.p();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.r.d();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.r.o();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.r.K();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.r.ak();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.r.k();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.s;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.r.n();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    @Deprecated
    public String getVastContent() {
        return null;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    @Deprecated
    public String getVastTag() {
        return null;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        if (this.f != null) {
            return this.f.f();
        }
        GDTLogger.e("Only Video AD can getVideoCurrentPosition");
        return -1;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        if (SDKStatus.getSDKVersionCode() < 60) {
            if (this.f == null) {
                return -1;
            }
            return this.f.e();
        }
        return this.r.j();
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public b.EnumC1199b h() {
        return this.u;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void h_() {
        GDTLogger.d("onVideoPause");
        a(10, (Object[]) null);
        if (!this.S) {
            G();
        }
        this.S = false;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public int i() {
        return com.qq.e.comm.plugin.ad.a.a().b(this.f12286a);
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void i_() {
        GDTLogger.d("onEnterFSButtonClicked");
        if (this.M != null) {
            this.M.a();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.r.v();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.r.L();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    @Deprecated
    public boolean isSkippable() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void j() {
        this.M = null;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.c.a
    public void j_() {
        GDTLogger.d("onCloseButtonClicked");
        if (this.M != null) {
            this.M.b();
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (this.d == null) {
            GDTLogger.e("未绑定MediaView组件，不上报广告曝光！");
        } else if (!this.d.getGlobalVisibleRect(new Rect())) {
            GDTLogger.e("MediaView不可见，不上报广告曝光！");
        } else {
            GDTLogger.i("on video ad exposed");
            a((View) this.f12286a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        this.c.a().b(this.f12286a.getWidth());
        this.c.a().a(this.f12286a.getHeight());
        this.c.a().b(this.r.x());
        this.c.a().c(t() ? 1 : 2);
        try {
            String b2 = this.c.b();
            GDTLogger.d("anti info:" + b2);
            return URLEncoder.encode(b2, "UTF-8");
        } catch (Exception e) {
            GDTLogger.w("Get anti failed:" + e);
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.nativeadunified.b
    public com.qq.e.comm.plugin.s.a n() {
        return this.r;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        if (TextUtils.isEmpty(this.r.u())) {
            return;
        }
        af.a(this.r.u());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return this.p.d();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view) {
        GDTLogger.e("onVideoADExposured接口已经废弃，不会执行曝光");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p() {
        return this.p.c();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        f(true);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        this.O = videoPreloadListener;
        A();
    }

    int q() {
        return this.p.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.r.O();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    @Deprecated
    public void reportVastEvent(ADEvent aDEvent) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
        if (!H()) {
            u.a(30232, 1, this.Q);
            return;
        }
        this.S = true;
        this.f = c.b();
        d(this.A);
        this.e = (com.qq.e.comm.plugin.gdtnativead.a.c) c.c();
        JSONObject a2 = n.a(this.q, c.a());
        u.a(30292, 3, this.Q, new com.qq.e.comm.plugin.y.d(a2));
        GDTLogger.i("resume: " + a2.toString());
        c.g();
        ViewGroup viewGroup = (ViewGroup) this.f.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f);
        }
        if (this.e == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.e.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.e);
        }
        FrameLayout.LayoutParams z = z();
        this.f.setLayoutParams(z);
        this.d.addView(this.f);
        J();
        this.e.setLayoutParams(z);
        this.d.addView(this.e);
        this.e.c(true);
        this.i = 1;
        if (this.t != null && this.K == b.d.COMPLETE && this.t.getVisibility() == 0) {
            this.t.setVisibility(8);
        }
        this.e.a(this.F);
        this.e.a(this.G, true);
        u.a(30232, 2, this.Q);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        a(true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.D = true;
        if (!B()) {
            C();
        } else if (this.f == null || this.e == null) {
            GDTLogger.e("VideoView未初始化完成，无法播放或暂停");
        } else {
            if (this.f.c()) {
                f(false);
            } else {
                a(false, false);
            }
            a(15, (Object[]) null);
        }
    }

    @Override // com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        this.L = aDListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        if (c.a() != null) {
            GDTLogger.e("只能在视频预览页调用静音设置接口");
            u.a(30372, 1, this.Q);
            return;
        }
        if (this.f != null) {
            GDTLogger.d((z ? "mute" : "sound") + " by developer");
            d(z);
            this.A = z;
            u.a(30372, 2, this.Q);
        } else {
            GDTLogger.e("Only Video AD can be muted");
            u.a(30372, 3, this.Q);
        }
        this.B = true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        a(true, false);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        if (c.a() != null) {
            GDTLogger.e("只能在视频预览页调用视频停止接口");
            u.a(30362, 1, this.Q);
        } else if (this.f == null || !(this.f.c() || this.u == b.EnumC1199b.DEV_PAUSE || this.u == b.EnumC1199b.MANUAL_PAUSE)) {
            GDTLogger.e("Only Video AD can be stopped");
            u.a(30362, 3, this.Q);
        } else {
            this.f.a(true, true);
            this.e.postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.g.2
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.e != null) {
                        g.this.e.a(0L);
                    }
                }
            }, 100L);
            a(b.EnumC1199b.DEV_STOP);
            u.a(30362, 2, this.Q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.r.ah();
    }

    int u() {
        if (this.f != null) {
            return this.f.f();
        }
        return 0;
    }
}
