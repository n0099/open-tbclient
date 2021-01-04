package com.qq.e.comm.plugin.gdtnativead;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.gdtnativead.a.b;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.ae;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ax;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.ba;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.bd;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.util.z;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h implements View.OnClickListener, NEADVI, com.qq.e.comm.plugin.a.d.a, com.qq.e.comm.plugin.ab.a.b, com.qq.e.comm.plugin.ab.c, com.qq.e.comm.plugin.ab.d.f, h.a, b.a, c.a {
    private static final String p = com.qq.e.comm.plugin.gdtnativead.b.c();
    private static final String q;
    private static final String r;
    private int A;
    private String B;
    private HashMap<String, JSONObject> C;
    private String D;
    private f G;
    private com.qq.e.comm.plugin.ac.a I;
    private ax J;
    private int O;
    private int Q;
    private int R;
    private FrameLayout S;
    private int T;
    private FrameLayout.LayoutParams U;
    private FrameLayout.LayoutParams V;
    private FrameLayout.LayoutParams W;
    private FrameLayout.LayoutParams X;
    private Window.Callback Y;
    private d Z;

    /* renamed from: a  reason: collision with root package name */
    com.qq.e.comm.plugin.ab.h f12326a;
    private ae aa;
    private com.qq.e.comm.plugin.gdtnativead.a.c ac;
    private com.qq.e.comm.plugin.ab.d.a ad;
    private com.qq.e.comm.plugin.gdtnativead.a.b ae;
    private boolean af;
    private ViewGroup al;
    private com.qq.e.comm.plugin.ad.g an;
    private String ap;
    private long aw;
    private int ax;
    private i ay;
    private com.qq.e.comm.plugin.c.a.c az;

    /* renamed from: b  reason: collision with root package name */
    ViewGroup f12327b;
    JSONObject c;
    com.qq.e.comm.plugin.s.a d;
    j g;
    Context h;
    MediaView i;
    a j;
    FrameLayout l;
    Context m;
    protected int o;
    private String s;
    private String t;
    private m u;
    private final String v;
    private final com.qq.e.comm.plugin.ad.e w;
    private ADListener x;
    private ADSize y;
    private int z;
    boolean e = false;
    boolean f = false;
    private boolean E = false;
    private Boolean F = null;
    private int H = -2;
    int k = 1;
    private int K = 1;
    private int L = 1;
    private int M = 1;
    private int N = 0;
    private Rect P = new Rect();
    private RectF ab = new RectF();
    private boolean ag = true;
    private int ah = n.a();
    private boolean ai = false;
    private boolean aj = false;
    private boolean ak = false;
    private int am = -1;
    private int ao = 0;
    private boolean aq = false;
    private boolean ar = false;
    private boolean as = false;
    private boolean at = false;
    private boolean au = false;
    private volatile boolean av = false;
    com.qq.e.comm.plugin.y.c n = new com.qq.e.comm.plugin.y.c();
    private Runnable aA = new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.22
        @Override // java.lang.Runnable
        public void run() {
            GDTLogger.d("onContentChanged from view " + (h.this.f12326a != null ? Integer.valueOf(h.this.f12326a.a().hashCode()) : null));
            h.this.x();
        }
    };
    private ae.a aB = new ae.a() { // from class: com.qq.e.comm.plugin.gdtnativead.h.10
        @Override // com.qq.e.comm.plugin.util.ae.a
        public void a() {
            if (h.this.k == 1) {
                return;
            }
            h.this.g(false);
            h.this.d(3);
        }

        @Override // com.qq.e.comm.plugin.util.ae.a
        public void b() {
            if (h.this.k == 1) {
                return;
            }
            h.this.g(true);
            h.this.d(4);
        }

        @Override // com.qq.e.comm.plugin.util.ae.a
        public void c() {
            if (h.this.k == 1) {
                return;
            }
            h.this.g(true);
            h.this.d(4);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends com.qq.e.comm.plugin.aa.b.f {
        public a(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.aa.b.f, com.qq.e.comm.plugin.aa.b.e
        public void a() {
            a(true);
        }

        public void a(boolean z) {
            super.a();
            if (SDKStatus.getSDKVersionCode() < 11) {
                h.this.N = 4;
            } else if (z) {
                h.this.N = 4;
            } else {
                h.this.N = 6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements AdData.VideoPlayer {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<com.qq.e.comm.plugin.aa.b.f> f12369a;

        public b(com.qq.e.comm.plugin.aa.b.f fVar) {
            this.f12369a = new WeakReference<>(fVar);
        }

        @Override // com.qq.e.comm.pi.AdData.VideoPlayer
        public int getCurrentPosition() {
            com.qq.e.comm.plugin.aa.b.f fVar = this.f12369a.get();
            if (fVar != null) {
                return fVar.f();
            }
            return 0;
        }

        @Override // com.qq.e.comm.pi.AdData.VideoPlayer
        public int getDuration() {
            com.qq.e.comm.plugin.aa.b.f fVar = this.f12369a.get();
            if (fVar != null) {
                return fVar.e();
            }
            return 0;
        }

        @Override // com.qq.e.comm.pi.AdData.VideoPlayer
        public int getVideoState() {
            com.qq.e.comm.plugin.aa.b.f fVar = this.f12369a.get();
            return (fVar == null ? f.d.ERROR : fVar.g()).ordinal();
        }
    }

    static {
        q = com.qq.e.comm.plugin.util.m.a(p, "1.1.0") ? p : "1.1.0";
        r = "<script src=\"" + String.format("http://qzonestyle.gtimg.cn/qzone/biz/gdt/mob/sdk/v2/android03/js-release/%s/native.js", q) + "\"></script>\n";
    }

    public h(NEADI neadi, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap) {
        this.af = true;
        this.s = str;
        this.t = str2;
        this.u = new m(str2, com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, (com.qq.e.comm.plugin.ad.d) null);
        this.y = aDSize;
        this.f12327b = viewGroup;
        this.v = com.qq.e.comm.plugin.util.a.a(str, str2, o.b());
        if (neadi instanceof f) {
            this.G = (f) neadi;
            this.w = this.G.d();
        } else {
            this.w = null;
        }
        if (X()) {
            this.af = false;
        }
        this.C = hashMap;
        this.l = new FrameLayout(context) { // from class: com.qq.e.comm.plugin.gdtnativead.h.1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                h.this.a(motionEvent);
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        viewGroup.addView(this.l, new FrameLayout.LayoutParams(-1, -1));
        this.al = viewGroup;
        if ((this.al instanceof NativeExpressADView) && SDKStatus.getSDKVersionCode() >= 120) {
            ((NativeExpressADView) this.al).setViewBindStatusListener(new NativeExpressADView.ViewBindStatusListener() { // from class: com.qq.e.comm.plugin.gdtnativead.h.12
                @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
                public void onAttachedToWindow() {
                    h.this.r();
                }

                @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
                public void onDetachedFromWindow() {
                    h.this.q();
                }

                @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
                public void onFinishTemporaryDetach() {
                    h.this.r();
                }

                @Override // com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener
                public void onStartTemporaryDetach() {
                    h.this.q();
                }
            });
        }
        this.h = context.getApplicationContext();
        this.m = context;
        this.an = new com.qq.e.comm.plugin.ad.g();
        a(this.h);
        a(jSONObject);
        s();
        if (((this.w == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD && com.qq.e.comm.plugin.gdtnativead.b.b()) || X()) && w()) {
            preloadVideo();
        }
        p();
    }

    private void A() {
        if (this.c == null) {
            return;
        }
        com.qq.e.comm.plugin.ad.a.a().a(this.l);
        a(5, new Object[]{this.f12327b});
        this.an.a(System.currentTimeMillis());
        this.e = true;
        this.l.post(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.4
            @Override // java.lang.Runnable
            public void run() {
                String q2 = h.this.d.q();
                if (h.this.m()) {
                    q2 = com.qq.e.comm.plugin.w.i.a(q2);
                }
                com.qq.e.comm.plugin.w.b bVar = new com.qq.e.comm.plugin.w.b(h.this.a(), com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, h.this.b());
                final String optString = h.this.c.optString("customizedpingurl");
                boolean z = h.this.m() && bb.a();
                String a2 = h.this.an.a(h.this.f12327b, z ? 1 : 2, h.this.d != null ? h.this.d.x() : null, null);
                c.a(h.this.w, (Boolean) null, h.this.n, 0, (Exception) null);
                com.qq.e.comm.plugin.w.i.a(a2, com.qq.e.comm.plugin.ad.a.a().b(h.this.l), h.this.d, bVar, q2, new d.b() { // from class: com.qq.e.comm.plugin.gdtnativead.h.4.1
                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a() {
                        if (!com.qq.e.comm.plugin.util.m.a(optString)) {
                            af.a(optString);
                        }
                        c.a(h.this.w, (Boolean) true, h.this.n, 0, (Exception) null);
                    }

                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a(int i, Exception exc) {
                        GDTLogger.e("GDT Native Express AD exposure error");
                        c.a(h.this.w, (Boolean) false, h.this.n, i, exc);
                    }
                });
            }
        });
        this.d.V();
        this.d.W();
    }

    private void B() {
        d(false);
        if (this.I == null) {
            this.I = new com.qq.e.comm.plugin.ac.a(this.f12327b.getContext());
        }
        if (this.i == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.h, 46), ak.a(this.h, 46));
        layoutParams.gravity = 17;
        this.i.addView(this.I, layoutParams);
        this.i.setBackgroundColor(Color.parseColor("#40000000"));
    }

    private void C() {
        if (this.aq || this.i == null || this.i.getLayoutParams() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = ak.a(this.h, (int) (this.ab.right - this.ab.left));
        layoutParams.height = ak.a(this.h, (int) (this.ab.bottom - this.ab.top));
        layoutParams.leftMargin = ak.a(this.h, (int) this.ab.left);
        layoutParams.topMargin = ak.a(this.h, (int) this.ab.top);
        this.i.setLayoutParams(layoutParams);
    }

    private void D() {
        if (this.J == null) {
            this.J = new ax(Long.MAX_VALUE, 200L) { // from class: com.qq.e.comm.plugin.gdtnativead.h.5
                @Override // com.qq.e.comm.plugin.util.ax
                public void a() {
                }

                @Override // com.qq.e.comm.plugin.util.ax
                public void a(long j) {
                    h.this.T();
                }
            };
        }
        this.J.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.J != null) {
            this.J.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.J != null) {
            this.J.e();
        }
    }

    private void G() {
        if (this.J != null) {
            this.J.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.j == null || this.j.c()) {
            return;
        }
        this.j.setVisibility(0);
        com.qq.e.comm.plugin.aa.b.a.a(this.i);
        this.j.b();
        this.M = 0;
    }

    private void I() {
        if (this.i == null) {
            GDTLogger.w("NativeExpressAD Error: MediaView is not init", null);
            return;
        }
        this.i.getGlobalVisibleRect(this.P);
        this.Q = this.i.getWidth();
        this.R = this.i.getHeight();
        Activity a2 = bb.a(this.f12327b.getContext());
        if (a2 == null) {
            GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
            return;
        }
        this.U = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        this.Y = a2.getWindow().getCallback();
        this.T = a2.getRequestedOrientation();
    }

    private void J() {
        Activity a2 = bb.a(this.f12327b.getContext());
        if (a2 == null) {
            GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
            return;
        }
        if (this.Z == null) {
            this.Z = new d(a2) { // from class: com.qq.e.comm.plugin.gdtnativead.h.8
                private boolean c = false;

                @Override // com.qq.e.comm.plugin.gdtnativead.d, android.view.Window.Callback
                public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
                        this.c = true;
                    }
                    if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4 && this.c && keyEvent.getRepeatCount() == 0) {
                        h.this.l();
                        this.c = false;
                    }
                    return false;
                }
            };
        }
        if (this.X == null) {
            this.X = new FrameLayout.LayoutParams(0, 0);
            this.X.setMargins(0, 0, 0, 0);
            this.X.gravity = 48;
            this.X.width = Math.min(ak.b(this.h), ak.c(this.h));
            this.X.height = (int) (this.X.width * 0.5625f);
        }
        if (this.W == null) {
            this.W = new FrameLayout.LayoutParams(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.ac == null || this.i == null || this.ac.getParent() != null) {
            return;
        }
        if (this.N == 3 || this.N == 5) {
            this.i.addView(this.ac, new FrameLayout.LayoutParams(-1, -1));
            this.ac.d();
        }
    }

    private void L() {
        if (this.ae != null && this.S != null) {
            this.S.removeView(this.ae);
        }
        if (this.ad != null && this.S != null) {
            this.S.removeView(this.ad.b());
        }
        if (this.ac == null || this.i == null || this.N == 3 || this.ac.getParent() == null) {
            return;
        }
        this.i.removeView(this.ac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.ac == null || this.i == null || this.N != 3 || this.ac.getParent() == null) {
            return;
        }
        this.i.removeView(this.ac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        Activity a2 = bb.a(this.f12327b.getContext());
        if (a2 == null) {
            GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
            return;
        }
        if (this.aa == null) {
            this.aa = new ae(a2);
            this.aa.a(this.aB);
        }
        this.aa.a(true);
    }

    private void O() {
        if (this.aa != null) {
            this.aa.a(false);
        }
    }

    private void P() {
        this.ar = true;
        if (this.as || this.k == 1) {
            return;
        }
        if (com.qq.e.comm.plugin.util.d.a(this.c) && !com.qq.e.comm.plugin.util.d.b(this.c)) {
            com.qq.e.comm.plugin.w.a.f.a(new d.a(this.c, null));
        }
        final Activity a2 = bb.a(this.f12327b.getContext());
        if (a2 == null) {
            GDTLogger.e("NativeExpressAD constructor must have Activity Context!");
            return;
        }
        this.aq = false;
        com.qq.e.comm.plugin.aa.b.a.b(this.i);
        O();
        L();
        a2.getWindow().setCallback(this.Y);
        final ViewGroup viewGroup = (ViewGroup) a2.findViewById(16908290);
        if (viewGroup != null) {
            if (Build.VERSION.SDK_INT < 21 || !this.af) {
                E();
                if (this.i != null) {
                    viewGroup.removeView(this.i);
                    this.l.addView(this.i, this.U);
                }
                bb.a(a2, this.ao);
                viewGroup.removeView(this.S);
                M();
                b(19, new Object[]{this.f12327b});
                F();
                this.ar = false;
            } else {
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(200L);
                TransitionManager.beginDelayedTransition(viewGroup, changeBounds);
                if (this.i != null) {
                    this.i.setLayoutParams(this.V);
                }
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.11
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.E();
                        if (h.this.i != null && h.this.S != null) {
                            viewGroup.removeView(h.this.i);
                            h.this.l.addView(h.this.i, h.this.U);
                            bb.a(a2, h.this.ao);
                            viewGroup.removeView(h.this.S);
                            h.this.M();
                        }
                        h.this.b(19, new Object[]{h.this.f12327b});
                        h.this.F();
                        h.this.ar = false;
                    }
                }, 500L);
            }
            try {
                a2.setRequestedOrientation(this.T);
            } catch (IllegalStateException e) {
                GDTLogger.e("setRequestedOrientation exception", e);
            }
            Q();
            this.k = 1;
            a(10, new Object[]{this.f12327b});
        }
    }

    private void Q() {
        if (this.j == null) {
            return;
        }
        if (this.ag) {
            this.j.h();
        } else {
            this.j.i();
        }
    }

    private void R() {
        if (this.j == null || this.i == null) {
            return;
        }
        if (!bd.a(this.h, this.i, 50, X())) {
            if (this.N == 1) {
                if (SDKStatus.getSDKVersionCode() >= 11) {
                    this.j.a(false);
                } else {
                    this.j.j();
                }
            }
            this.aj = false;
            return;
        }
        switch (this.N) {
            case 0:
                if (!this.j.c() && w()) {
                    this.j.setVisibility(0);
                    com.qq.e.comm.plugin.aa.b.a.a(this.i);
                    this.j.b();
                    y();
                    this.M = 1;
                    break;
                }
                break;
            case 3:
                if (!this.aj && !this.j.c() && w()) {
                    this.j.setVisibility(0);
                    com.qq.e.comm.plugin.aa.b.a.a(this.i);
                    this.j.b();
                    y();
                    this.M = 1;
                    break;
                }
                break;
            case 4:
                if (this.k == 1 && !this.j.c()) {
                    this.j.setVisibility(0);
                    com.qq.e.comm.plugin.aa.b.a.a(this.i);
                    this.j.b();
                    break;
                }
                break;
            case 5:
                if (!this.j.c() && w()) {
                    this.j.setVisibility(0);
                    com.qq.e.comm.plugin.aa.b.a.a(this.i);
                    this.j.b();
                    y();
                    this.M = 1;
                    break;
                }
                break;
            case 6:
                if (!this.j.c()) {
                    this.j.setVisibility(0);
                    com.qq.e.comm.plugin.aa.b.a.a(this.i);
                    this.j.b();
                    break;
                }
                break;
        }
        this.aj = true;
        if (this.e) {
            return;
        }
        c.b(this.w, this.n);
    }

    private void S() {
        if (!bd.a(this.h, this.f12327b, 50) || this.e || this.f12327b.getHeight() <= 1) {
            return;
        }
        A();
        if (m()) {
            return;
        }
        c.a(this.w, this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (!m()) {
            S();
            return;
        }
        S();
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        com.qq.e.comm.plugin.w.b bVar = new com.qq.e.comm.plugin.w.b(this.v, com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, this.t);
        int V = this.L == 0 ? V() : 0;
        int W = this.L == 0 ? W() : 0;
        String optString = this.c.optString("apurl");
        final String optString2 = this.c.optString("customizedpingurl");
        com.qq.e.comm.plugin.w.d.a(this.M, this.k, this.K, this.L, V, W, optString, bVar, new d.b() { // from class: com.qq.e.comm.plugin.gdtnativead.h.13
            @Override // com.qq.e.comm.plugin.w.d.b
            public void a() {
                GDTLogger.d("GDTNativeExpressAD report video info success");
                if (StringUtil.isEmpty(optString2)) {
                    return;
                }
                af.a(optString2);
            }

            @Override // com.qq.e.comm.plugin.w.d.b
            public void a(int i, Exception exc) {
                GDTLogger.e("GDTNativeExpressAD report video info error");
            }
        });
    }

    private int V() {
        if (this.j != null) {
            return this.j.f();
        }
        return 0;
    }

    private int W() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X() {
        return this.w == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL;
    }

    private static com.qq.e.comm.plugin.ad.n a(HashMap<String, JSONObject> hashMap) {
        JSONObject jSONObject = hashMap.get(Constants.KEYS.AD_INFO);
        Object opt = jSONObject != null ? jSONObject.opt(Constants.KEYS.AD_INFO) : null;
        if (opt instanceof com.qq.e.comm.plugin.ad.n) {
            return (com.qq.e.comm.plugin.ad.n) opt;
        }
        return null;
    }

    private void a(int i, final String str, boolean z, boolean z2, String str2) {
        if (this.ad == null) {
            this.ad = new com.qq.e.comm.plugin.ab.d.e(this.f12327b.getContext(), this.c).a();
            this.ad.a(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = i;
        if (Build.VERSION.SDK_INT >= 11) {
            this.ad.b().setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ad.b(), "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setStartDelay(700L);
            ofFloat.start();
        }
        if (this.ad.b().getParent() != null) {
            bc.a(this.ad.b());
        }
        if (this.S != null) {
            this.S.addView(this.ad.b(), layoutParams);
        }
        if (str != null) {
            if (!z2 && z) {
                String a2 = com.qq.e.comm.plugin.w.a.h.a(str);
                final String d = this.c != null ? com.qq.e.comm.plugin.util.d.d(this.c).d() : null;
                com.qq.e.comm.plugin.w.a.d.a(a2, this.d, new com.qq.e.comm.plugin.util.j<Pair<Integer, JSONObject>>() { // from class: com.qq.e.comm.plugin.gdtnativead.h.9
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.qq.e.comm.plugin.util.j
                    public void a(Pair<Integer, JSONObject> pair) {
                        if (pair != null && pair.second != null) {
                            String optString = ((JSONObject) pair.second).optString("clickid");
                            com.qq.e.comm.plugin.w.a.a(optString);
                            com.qq.e.comm.plugin.w.a.a(d, optString);
                            final String optString2 = ((JSONObject) pair.second).optString("dstlink");
                            if (!TextUtils.isEmpty(optString2)) {
                                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.9.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (h.this.ad != null) {
                                            h.this.ad.a(optString2);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.9.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (h.this.ad != null) {
                                    h.this.ad.a(str);
                                }
                            }
                        });
                    }
                });
                this.ay.a(a2);
                return;
            }
            if (!z2 && this.d != null) {
                this.d.X();
                this.d.Y();
            }
            if (!z2) {
                str2 = str;
            }
            ai.a("gdt_tag_net", "get url: " + str2);
            this.ad.a(str2);
            if (z2) {
                return;
            }
            this.ay.a(str);
        }
    }

    private void a(Context context) {
        this.f12326a = new com.qq.e.comm.plugin.ab.e(context, this).a(true).a((com.qq.e.comm.plugin.ab.a.b) this).b(true).c(false).d(false).a((h.a) this).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        this.an.a((View) this.l, motionEvent, false);
    }

    private void a(ADSize aDSize) {
        if (aDSize.getWidth() <= 0 && aDSize.getWidth() != -1) {
            GDTLogger.w("NativeExpressAD的宽度必须大于0或者为ADSize.FULL_WIDTH，已将广告宽度调整为ADSize.FULL_WIDTH", null);
        }
        if (aDSize.getHeight() <= 0 && aDSize.getHeight() != -2) {
            GDTLogger.w("NativeExpressAD的高度必须大于0或者为ADSize.AUTO_HEIGHT，已经广告高度调整为ADSize.AUTO_HEIGHT", null);
        }
        this.z = aDSize.getWidth() > 0 ? ak.a(this.h, aDSize.getWidth()) : -1;
        this.A = aDSize.getHeight() <= 0 ? 1 : ak.a(this.h, aDSize.getHeight());
        int b2 = ak.b(this.h);
        int c = ak.c(this.h);
        if (this.z > b2) {
            this.z = b2;
        }
        if (this.A > c) {
            this.A = c;
        }
        GDTLogger.d("ExpressADView's width in pixel = " + this.z + ", height in pixel = " + this.A);
    }

    private void a(JSONObject jSONObject) {
        String property;
        if (SDKStatus.getSDKVersionCode() >= 3) {
            com.qq.e.comm.plugin.ad.n a2 = a(this.C);
            if (a2 != null) {
                try {
                    property = a2.getProperty("ad_info");
                } catch (JSONException e) {
                    GDTLogger.e("load ad data failed: " + e);
                }
            } else {
                property = null;
            }
            this.c = property != null ? new JSONObject(property) : null;
            if (this.c != null) {
                this.B = this.c.optString("video");
                String optString = this.c.optString(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO);
                if (!TextUtils.isEmpty(optString)) {
                    this.ap = optString.replace("__ACT_TYPE__", "2001");
                }
            }
        } else {
            this.c = this.C.get(Constants.KEYS.AD_INFO);
            this.B = this.c != null ? this.c.optString("video") : null;
        }
        this.d = new com.qq.e.comm.plugin.s.a(this.s, this.t, this.v, com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD);
        this.d.g(this.c);
        this.n.a(this.t);
        if (this.c != null) {
            this.n.b(this.c.optString(Config.CELL_LOCATION));
            this.n.b(this.c.optString("traceid"));
        }
        if (jSONObject != null) {
            this.D = jSONObject.optString("view");
        }
        if (m() && bb.a()) {
            v();
        }
    }

    private void a(final boolean z, final boolean z2) {
        com.qq.e.comm.plugin.aa.a.a.a().a(new b.a().b(this.B).a(ah.a(this.B)).a(ah.f()).a(), this.B, new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.gdtnativead.h.3
            @Override // com.qq.e.comm.plugin.j.a
            public void a() {
                GDTLogger.d("onStarted");
                h.this.av = true;
                h.this.b(12, new Object[]{h.this.f12327b});
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, long j2, final int i) {
                GDTLogger.d("downloading video ---> Progress: " + i + "%");
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.I != null) {
                            h.this.I.a(i);
                            if (i == 100) {
                                h.this.I.setVisibility(8);
                                if (h.this.i != null) {
                                    h.this.i.setBackgroundColor(0);
                                }
                                h.this.d(true);
                            }
                        }
                    }
                });
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(long j, boolean z3) {
                h.this.ax = (int) (j >> 10);
                GDTLogger.d("onConnected isRangeSupport: " + z3 + ", total: " + j);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(com.qq.e.comm.plugin.j.c cVar) {
                int a2 = cVar.a();
                GDTLogger.w("Video download Failed, code: " + a2 + ", msg: " + cVar.b(), null);
                h.this.av = false;
                h.this.L = 2;
                h.this.U();
                if (z2) {
                    h.this.b(17, new Object[]{h.this.f12327b, 702});
                } else {
                    h.this.b(17, new Object[]{h.this.f12327b, 700});
                }
                c.a(h.this.w, h.this.n, h.this.B, a2, cVar);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void a(File file, long j) {
                GDTLogger.d("onCompleted");
                GDTLogger.d("download time: " + j + "ms");
                h.this.av = false;
                h.this.d(true);
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.L = 0;
                        if (h.this.au) {
                            if (h.this.X()) {
                                h.this.G.e();
                            } else {
                                h.this.b(21, new Object[]{h.this.f12327b});
                            }
                        }
                        File d = ah.d(h.this.B);
                        if (h.this.j == null || d == null) {
                            return;
                        }
                        h.this.aw = System.currentTimeMillis();
                        h.this.j.a(d.getAbsolutePath());
                        h.this.j.b();
                        h.this.y();
                        if (z) {
                            h.this.M = 1;
                        } else {
                            h.this.M = 0;
                        }
                    }
                });
                ba.a(j, h.this.ax, h.this.B, h.this.n);
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void b() {
            }

            @Override // com.qq.e.comm.plugin.j.a
            public void c() {
                c.a(h.this.w, h.this.n, h.this.B, 0, (Exception) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final boolean z2, final String str) {
        if (!this.ar && this.k == 1) {
            a(20, new Object[]{this.f12327b});
            if (this.i == null) {
                f(false);
            }
            this.aq = true;
            this.i.setVisibility(0);
            this.i.post(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.6
                @Override // java.lang.Runnable
                public void run() {
                    h.this.b(z, z2, str);
                }
            });
        }
    }

    private void b(int i) {
        ADSize aDSize = new ADSize(this.y.getWidth(), i);
        ViewGroup.LayoutParams layoutParams = this.f12326a.a().getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        a(aDSize);
        if (layoutParams.height != this.A) {
            layoutParams.height = this.A;
            this.f12326a.a().setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i, final Object[] objArr) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.21
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.x != null) {
                    h.this.x.onADEvent(new ADEvent(i, objArr));
                }
            }
        });
    }

    private void b(com.qq.e.comm.plugin.ab.a.a aVar) {
        if (this.F != null) {
            return;
        }
        this.F = false;
        this.f12326a.a(8);
        a(3, new Object[]{this.f12327b});
        c.a(this.w, this.F, this.n, aVar);
    }

    private void b(JSONObject jSONObject) {
        GDTLogger.d("Get AdSpecMeasured params：" + jSONObject.toString() + ", adContentHeightInDp: " + this.H + ", view is " + this.f12326a.a().hashCode());
        u.a(50002, 2, this.n, new com.qq.e.comm.plugin.y.d(jSONObject));
        this.H = jSONObject.optInt("contentHeight");
        if (this.y.getHeight() <= 0) {
            u.a(50022, this.H, this.n);
            b(this.H);
        }
        if (m() && bb.a()) {
            this.ab.left = jSONObject.optInt("imgHolderLeft");
            this.ab.top = jSONObject.optInt("imgHolderTop");
            this.ab.right = jSONObject.optInt("imgHolderRight") + 1;
            this.ab.bottom = jSONObject.optInt("imgHolderBottom") + 1;
            if (this.i != null) {
                C();
            } else if (w()) {
                f(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z, final boolean z2, final String str) {
        this.as = true;
        final Activity a2 = bb.a(this.f12327b.getContext());
        if (a2 == null) {
            GDTLogger.e("Native Express AD constructor must have an Activity Context, or video ad will not be able to enter fullscreen!");
            return;
        }
        u.a(100372, 0, this.n);
        I();
        J();
        E();
        final boolean z3 = ak.b(this.h) > ak.c(this.h);
        final ViewGroup viewGroup = (ViewGroup) a2.findViewById(16908290);
        if (viewGroup != null) {
            if (this.S == null) {
                this.S = new FrameLayout(this.f12327b.getContext());
                this.S.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bc.a(this.S);
            viewGroup.addView(this.S, new FrameLayout.LayoutParams(-1, -1));
            this.ao = bb.c(a2);
            bb.b(a2);
            this.l.removeView(this.i);
            if (Build.VERSION.SDK_INT < 21 || !this.af) {
                K();
                bc.a(this.i);
                viewGroup.addView(this.i, z3 ? this.W : this.X);
                com.qq.e.comm.plugin.aa.b.a.a(this.i, this.d.o(), this.j);
                a2.getWindow().setCallback(this.Z);
                c(z, z2, str);
                N();
                H();
                F();
                if (this.I != null && this.I.getVisibility() == 0) {
                    this.I.bringToFront();
                }
                b(18, new Object[]{this.f12327b});
                this.as = false;
            } else {
                if (this.V == null) {
                    this.V = new FrameLayout.LayoutParams(this.Q, this.R);
                }
                this.V.width = this.Q;
                this.V.height = this.R;
                this.V.setMargins(this.P.left, this.P.top, 0, 0);
                bc.a(this.i);
                viewGroup.addView(this.i, this.V);
                com.qq.e.comm.plugin.aa.b.a.a(this.i, this.d.o(), this.j);
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.7
                    @Override // java.lang.Runnable
                    @TargetApi(19)
                    public void run() {
                        h.this.K();
                        TransitionManager.beginDelayedTransition(viewGroup);
                        if (h.this.i != null) {
                            h.this.i.setLayoutParams(z3 ? h.this.W : h.this.X);
                        }
                        a2.getWindow().setCallback(h.this.Z);
                        h.this.c(z, z2, str);
                        h.this.N();
                        h.this.H();
                        h.this.F();
                        if (h.this.I != null && h.this.I.getVisibility() == 0) {
                            h.this.I.bringToFront();
                        }
                        h.this.b(18, new Object[]{h.this.f12327b});
                        h.this.as = false;
                    }
                }, 500L);
            }
            if (this.j != null) {
                if (this.ai) {
                    this.j.h();
                } else {
                    this.j.i();
                }
            }
            if (z3) {
                d(4);
            } else {
                d(3);
            }
            a(9, new Object[]{this.f12327b});
        }
    }

    private void c(int i) {
        if (this.ae == null) {
            this.ae = new com.qq.e.comm.plugin.gdtnativead.a.b(this.f12327b.getContext(), this.g, this.c);
            this.ae.a(this);
        } else {
            bc.a(this.ae);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = i;
        if (Build.VERSION.SDK_INT >= 11) {
            this.ae.setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ae, "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setStartDelay(700L);
            ofFloat.start();
        }
        if (this.S != null) {
            this.S.addView(this.ae, layoutParams);
        }
        if (this.g == null || !com.qq.e.comm.plugin.a.e.b.a(this.g.h(), this.t)) {
            return;
        }
        c(true);
    }

    private void c(JSONObject jSONObject) {
        if (this.F != null) {
            return;
        }
        u.a(50002, 1, this.n);
        GDTLogger.d("renderSuccess view: " + this.f12326a.hashCode());
        this.F = true;
        a(this.y);
        this.l.addView(this.f12326a.a(), new ViewGroup.LayoutParams(this.z, this.A));
        a(4, new Object[]{this.f12327b});
        e(jSONObject.optString("traceid"));
        u();
        c.a(this.w, this.F, this.n, (com.qq.e.comm.plugin.ab.a.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, String str) {
        String str2;
        if (this.i != null && this.ac != null && this.ac.getParent() == null) {
            this.i.addView(this.ac, new FrameLayout.LayoutParams(-1, -1));
            this.ac.c();
        }
        if (this.c == null) {
            GDTLogger.e("广告数据出现错误！");
            return;
        }
        int min = (int) (Math.min(ak.b(this.h), ak.c(this.h)) * 0.5625f);
        if (com.qq.e.comm.plugin.util.d.a(this.c)) {
            if (!com.qq.e.comm.plugin.util.d.b(this.c)) {
                c(min);
                return;
            }
            String a2 = com.qq.e.comm.plugin.w.a.d.a((String) null, this.c, o(), com.qq.e.comm.plugin.ad.a.a().b(this.l));
            if (this.g != null && com.qq.e.comm.plugin.a.e.b.a(this.g.h(), this.t)) {
                a2 = az.c(a2, "_autodownload", "1");
            }
            a(min, a2, z, z2, str);
            return;
        }
        String optString = this.c != null ? this.c.optString("rl") : null;
        if (TextUtils.isEmpty(optString)) {
            str2 = optString;
        } else {
            String o = o();
            str2 = optString + "&s=" + o;
            if (t.a(str2)) {
                ai.b("gdt_tag_p", "get P in addFullscreenViews , url = %s", str2);
                str2 = t.a(str2, com.qq.e.comm.plugin.ad.g.a(o, com.qq.e.comm.plugin.ad.a.a().b(this.l), "click"));
            }
        }
        a(min, str2, z, z2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        this.k = i;
        if (this.ac != null) {
            this.ac.a(i);
            this.ac.f();
            this.ac.g();
        }
        if (m()) {
            if (i == 3 || i == 4) {
                int i2 = i == 3 ? 0 : 8;
                if (this.ae != null) {
                    this.ae.setVisibility(i2);
                } else if (this.ad != null) {
                    this.ad.b().setVisibility(i2);
                }
            }
        }
    }

    private void d(JSONObject jSONObject) {
        this.an.b(System.currentTimeMillis());
        this.ay.a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final boolean z) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.2
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f12326a == null) {
                    return;
                }
                if (!z) {
                    h.this.f12326a.b("mtaid.setPlayIconVisibility(false)");
                    return;
                }
                h.this.f12326a.a(0);
                h.this.f12326a.b("mtaid.setPlayIconVisibility(true)");
            }
        });
    }

    private void e(String str) {
        if (!com.qq.e.comm.plugin.util.m.a(str) && com.qq.e.comm.plugin.util.d.a(this.c)) {
            this.g = com.qq.e.comm.plugin.util.d.d(this.c);
            l.a().a(this.g.d(), this);
            com.qq.e.comm.plugin.a.c d = d(this.g.d());
            if (d == null || d.o() != 32 || d.b("progress") <= 0) {
                return;
            }
            this.g.a(d.b("progress"));
            this.g.c(d.o());
        }
    }

    private void e(boolean z) {
        if (!t()) {
            B();
            a(z, false);
            return;
        }
        File d = ah.d(this.B);
        this.aw = System.currentTimeMillis();
        if (d != null) {
            this.j.a(d.getAbsolutePath());
        }
        if (this.I != null) {
            this.I.setVisibility(8);
        }
        if (this.i != null) {
            this.i.setBackgroundColor(0);
        }
    }

    private void f(boolean z) {
        com.qq.e.comm.plugin.ad.n a2;
        if (this.i == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.h, (int) (this.ab.right - this.ab.left)), ak.a(this.h, (int) (this.ab.bottom - this.ab.top)));
            layoutParams.leftMargin = ak.a(this.h, (int) this.ab.left);
            layoutParams.topMargin = ak.a(this.h, (int) this.ab.top);
            this.i = new MediaView(this.f12327b.getContext());
            this.i.setLayoutParams(layoutParams);
            this.l.addView(this.i);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            this.j = new a(this.f12327b.getContext());
            this.j.setKeepScreenOn(true);
            this.j.setLayoutParams(layoutParams2);
            if (X()) {
                this.j.a(this.c.optInt(VrPlayerActivityConfig.PIC_WIDTH), this.c.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
            }
            this.i.addView(this.j);
            this.i.setOnClickListener(this);
            this.ac = new com.qq.e.comm.plugin.gdtnativead.a.c(this.f12327b.getContext(), this.k, this.c.optString("img"));
            this.ac.a(this);
            this.j.a(this.ac);
            if (SDKStatus.getSDKVersionCode() >= 3 && (a2 = a(this.C)) != null) {
                a2.a(new b(this.j));
            }
            b(11, new Object[]{this.f12327b});
            if (this.av && X()) {
                b(12, new Object[]{this.f12327b});
            }
            e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        if (this.i != null) {
            if (z) {
                this.i.setLayoutParams(this.W);
            } else {
                this.i.setLayoutParams(this.X);
            }
        }
    }

    private void p() {
        this.az = new com.qq.e.comm.plugin.c.a.c(this.m) { // from class: com.qq.e.comm.plugin.gdtnativead.h.16
            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(com.qq.e.comm.plugin.s.a aVar) {
                super.a(aVar);
                h.this.a(false, true, (String) null);
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void a(boolean z) {
                if (z) {
                    h.this.a(8, new Object[]{h.this.f12327b});
                    h.this.a(9, new Object[]{h.this.f12327b});
                }
                super.a(z);
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public BrowserType b(String str, com.qq.e.comm.plugin.s.a aVar) {
                h.this.a(9, new Object[]{h.this.f12327b});
                return super.b(str, aVar);
            }

            @Override // com.qq.e.comm.plugin.c.a.c, com.qq.e.comm.plugin.c.a.a
            public void c(String str) {
                super.c(str);
                h.this.a(false, true, str);
            }
        };
        this.ay = new i(this, this.az);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.aq) {
            return;
        }
        this.at = false;
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.17
            @Override // java.lang.Runnable
            public void run() {
                ViewParent parent;
                if (h.this.at) {
                    return;
                }
                if (h.this.j != null && (parent = h.this.j.getParent()) != null) {
                    ((ViewGroup) parent).removeView(h.this.j);
                }
                h.this.E();
                h.this.T();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.aq) {
            return;
        }
        this.at = true;
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.18
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.at) {
                    if (h.this.j != null) {
                        if (h.this.j.getParent() == null) {
                            h.this.i.addView(h.this.j);
                        }
                        if (h.this.N == 6) {
                            h.this.y();
                        }
                    }
                    h.this.F();
                }
            }
        });
    }

    private void s() {
        if (this.f12327b != null) {
            this.f12327b.setTag(n());
        }
    }

    private boolean t() {
        File d = ah.d(this.B);
        if (d == null || !d.exists()) {
            return false;
        }
        this.ax = (int) (d.length() >> 10);
        return true;
    }

    private void u() {
        GDTLogger.d("callJsHeightMeasure view: " + this.f12326a.hashCode() + ", renderSuccess: " + this.F + ", webViewWidth: " + this.am + ", adContentHeightInDp: " + this.H);
        if (!this.F.booleanValue() || this.am <= 0) {
            return;
        }
        w.a(this.aA);
    }

    private void v() {
        JSONObject b2 = com.qq.e.comm.plugin.gdtnativead.b.b(b());
        this.ag = b2.optBoolean("autoPlayMuted", true);
        this.ah = b2.optInt("autoPlayPolicy", n.a());
        this.ai = b2.optBoolean("detailPageMuted", false);
    }

    private boolean w() {
        if (this.k == 3 || this.k == 4) {
            return true;
        }
        boolean z = GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI;
        switch (this.ah) {
            case 0:
                return z || t();
            case 1:
            default:
                return true;
            case 2:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.f12326a != null) {
            this.f12326a.b("mtaid.measureAdSpec()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.k != 1 || this.j == null) {
            return;
        }
        if (this.ag) {
            this.j.h();
        } else {
            this.j.i();
        }
    }

    private void z() {
        D();
    }

    @Override // com.qq.e.comm.plugin.ab.c
    public String a() {
        return this.v;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(int i) {
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void a(int i, Exception exc) {
        this.L = 2;
        U();
        b(17, new Object[]{this.f12327b, 701});
        c.a(this.w, false, this.n, i, exc);
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(int i, String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final int i, final Object[] objArr) {
        Runnable runnable = new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.20
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.G == null || h.this.G.h() == null) {
                    return;
                }
                h.this.G.h().onADEvent(new ADEvent(i, objArr));
            }
        };
        if (Looper.getMainLooper() != Looper.myLooper()) {
            w.a(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
    }

    @Override // com.qq.e.comm.plugin.ab.a.b
    public void a(com.qq.e.comm.plugin.ab.a.a aVar) {
        GDTLogger.d("On AD LifeEvent: " + aVar.a());
        switch (aVar.a()) {
            case ADReady:
                c(aVar.b());
                return;
            case ADLoadFail:
                b(aVar);
                return;
            case Exposured:
                z();
                return;
            case ADSpecMeasured:
                b(aVar.b());
                return;
            case Clicked:
                d(aVar.b());
                return;
            case ADClosed:
                a(7, new Object[]{this.f12327b});
                destroy();
                return;
            case ADLeftApplication:
                a(8, new Object[]{this.f12327b});
                return;
            case ADOpenOverlay:
                a(9, new Object[]{this.f12327b});
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(String str) {
    }

    @Override // com.qq.e.comm.plugin.a.d.a
    public void a(String str, final int i, final int i2, long j) {
        if (!str.equals(this.g.d()) || this.ae == null) {
            return;
        }
        this.g.c(i);
        this.g.a(i2);
        this.g.a(j);
        if (!(i == 4 && i2 % 5 == 0) && i == 4) {
            return;
        }
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.14
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.ae != null) {
                    h.this.ae.a(i2, i);
                }
            }
        });
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void a(String str, Bitmap bitmap) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        a(z, false, (String) null);
    }

    @Override // com.qq.e.comm.plugin.ab.c
    public String b() {
        return this.t;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void b(String str) {
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.c.a
    public void b(boolean z) {
        if (this.N == 3) {
            if (this.k == 3 || this.k == 4) {
                this.M = 0;
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        return false;
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void b_() {
        this.L = 0;
        if (this.i != null && this.j != null) {
            this.O = this.j.e();
            GDTLogger.d("duration = " + this.O);
            com.qq.e.comm.plugin.aa.b.a.a(this.i, this.d.o(), this.j);
        }
        b(13, new Object[]{this.f12327b, Integer.valueOf(this.O)});
    }

    @Override // com.qq.e.comm.plugin.ab.c
    public com.qq.e.comm.plugin.ad.e c() {
        return com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void c(String str) {
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.b.a
    public void c(boolean z) {
        this.ay.a(z);
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void c_() {
        this.N = 1;
        String str = "";
        if (this.c != null) {
            this.c.optString("edid");
            str = this.c.optString("video_tracking_url");
        }
        GDTLogger.d("call onVideoExpose");
        aa.a(str);
        if (!this.e) {
            u.a(50032, 0, this.n);
            k();
        }
        if (this.j != null && this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
            com.qq.e.comm.plugin.aa.b.a.a(this.i);
        }
        b(14, new Object[]{this.f12327b});
        c.a(this.w, true, this.n, 0, (Exception) null);
        if (this.aw != 0) {
            ba.b(System.currentTimeMillis() - this.aw, this.ax, this.B, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.a.c d(String str) {
        com.qq.e.comm.plugin.a.c cVar;
        List<com.qq.e.comm.plugin.a.c> d = l.a().d();
        if (d == null) {
            return null;
        }
        Iterator<com.qq.e.comm.plugin.a.c> it = d.iterator();
        while (true) {
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            cVar = it.next();
            if (cVar.h().equals(str)) {
                break;
            }
        }
        return cVar;
    }

    @Override // com.qq.e.comm.plugin.ab.d.f
    public void d_() {
        a(8, new Object[]{this.f12327b});
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void destroy() {
        if (this.ak) {
            return;
        }
        this.ak = true;
        if (this.N == 1) {
            U();
        }
        G();
        if (this.aa != null) {
            this.aa.a();
        }
        if (this.j != null) {
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.h.19
                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.i != null) {
                        h.this.j.l();
                        h.this.i.removeAllViews();
                        h.this.i = null;
                        h.this.j = null;
                    }
                    if (h.this.S != null) {
                        h.this.S.removeAllViews();
                        h.this.S = null;
                    }
                    if (h.this.ac != null) {
                        h.this.ac.i();
                        h.this.ac.removeAllViews();
                        h.this.ac = null;
                    }
                    if (h.this.ae != null) {
                        h.this.ae.removeAllViews();
                        h.this.ae = null;
                    }
                }
            });
        }
        if (this.ad != null) {
            this.ad.a();
            this.ad = null;
        }
        if (this.f12326a != null) {
            this.f12326a.c();
            this.f12326a = null;
        }
        com.qq.e.comm.plugin.ab.j.e().d();
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void f_() {
        this.N = 3;
        U();
        this.K = 3;
        if (this.j != null) {
            this.j.setVisibility(4);
            if (!this.aq) {
                com.qq.e.comm.plugin.aa.b.a.b(this.i);
            }
        }
        if (this.k == 4) {
            l();
        }
        b(16, new Object[]{this.f12327b});
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void g() {
        this.K = 2;
        this.N = 1;
        b(14, new Object[]{this.f12327b});
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void g_() {
        this.N = 5;
        U();
        if (this.j != null) {
            this.j.setVisibility(4);
            if (!this.aq) {
                com.qq.e.comm.plugin.aa.b.a.b(this.i);
            }
        }
        b(16, new Object[]{this.f12327b});
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void h_() {
        U();
        b(15, new Object[]{this.f12327b});
    }

    @Override // com.qq.e.comm.plugin.aa.b.d.a
    public void i_() {
        if (this.aa != null) {
            this.aa.b();
        }
        u.a(100382, 0, this.n);
    }

    @Override // com.qq.e.comm.plugin.ab.h.a
    public void j() {
        int measuredWidth;
        GDTLogger.d("webview onLayout: " + this.l.hashCode() + ", view width: " + (this.f12326a != null ? Integer.valueOf(this.f12326a.a().getMeasuredWidth()) : "null"));
        if (this.f12326a == null || (measuredWidth = this.f12326a.a().getMeasuredWidth()) == this.am) {
            return;
        }
        this.am = measuredWidth;
        u();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.a.c.a
    public void j_() {
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        if (!this.e) {
            A();
        }
        this.f = true;
    }

    public void l() {
        if (this.k == 4) {
            if (this.aa != null) {
                this.aa.b();
            }
        } else if (this.k == 3) {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return (this.c == null || com.qq.e.comm.plugin.util.m.a(this.B)) ? false : true;
    }

    public Point n() {
        return this.c != null ? new Point(this.c.optInt("template_width"), this.c.optInt("template_height")) : new Point();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o() {
        if (this.f12326a == null) {
            GDTLogger.w("view == null!!");
            return null;
        }
        this.an.a().b(this.f12326a.a().getWidth());
        this.an.a().a(ak.a(this.h, this.H));
        this.an.a().b(this.c != null ? this.c.optString("template_id") : null);
        this.an.a().c(m() ? 1 : 2);
        try {
            String b2 = this.an.b();
            GDTLogger.d("anti info:" + b2);
            return URLEncoder.encode(b2, "UTF-8");
        } catch (Exception e) {
            GDTLogger.w("Get anti failed:" + e);
            return null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d(new JSONObject());
        if (view != this.i || this.j == null) {
            return;
        }
        if (this.k == 3 || this.k == 4) {
            this.j.n();
        }
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void preloadVideo() {
        if (TextUtils.isEmpty(this.B) || this.au) {
            return;
        }
        this.au = true;
        if (!t()) {
            GDTLogger.d("preloadVideo, cl : " + (this.d == null ? "" : this.d.m()));
            a(false, true);
            return;
        }
        if (X()) {
            this.G.e();
        } else {
            b(21, new Object[]{this.f12327b});
        }
        GDTLogger.d("preloadVideo, video already cached, cl : " + (this.d == null ? "" : this.d.m()));
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void render() {
        if (this.w == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            z.a().a(this.t);
        }
        c.a(this.w, (Boolean) null, this.n, (com.qq.e.comm.plugin.ab.a.a) null);
        if (this.E || this.f12326a == null) {
            c.c(this.w, this.n);
            return;
        }
        this.f12326a.a(null, r + this.D, "text/html", "UTF-8", null);
        this.E = true;
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void reportAdNegative() {
        if (TextUtils.isEmpty(this.ap)) {
            GDTLogger.e("reportAdNegative negativeFeedbackUrl is null");
        } else {
            af.a(this.ap);
        }
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void setAdListener(ADListener aDListener) {
        this.x = aDListener;
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void setAdSize(ADSize aDSize) {
        if (this.f12326a == null) {
            GDTLogger.w("Express AD View is null", null);
            return;
        }
        this.y = aDSize;
        a(this.y);
        ViewGroup.LayoutParams layoutParams = this.f12326a.a().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.z;
            layoutParams.height = this.A;
        } else {
            layoutParams = new ViewGroup.LayoutParams(this.z, this.A);
        }
        this.f12326a.a().setLayoutParams(layoutParams);
        w.a(this.aA);
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void setBrowserType(int i) {
        this.o = i;
    }
}
