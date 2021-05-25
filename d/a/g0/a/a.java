package d.a.g0.a;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.Log;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import com.heytap.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import org.json.JSONArray;
import org.webrtc.EglBase10;
/* loaded from: classes2.dex */
public final class a implements AREngineDelegate {
    public static PermissionProxy o;
    public static int p;

    /* renamed from: a  reason: collision with root package name */
    public Context f39900a;

    /* renamed from: b  reason: collision with root package name */
    public ArBridge f39901b;

    /* renamed from: e  reason: collision with root package name */
    public long f39904e;

    /* renamed from: h  reason: collision with root package name */
    public GLSurfaceView.Renderer f39907h;
    public Object k;
    public SurfaceHolder l;
    public b m;
    public boolean n;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<DebugConsole> f39902c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f39903d = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f39905f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f39906g = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39908i = false;
    public final d j = new d(null);

    /* renamed from: d.a.g0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0539a implements Runnable {
        public RunnableC0539a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m.m = true;
            a.this.f39901b.smallGameDestroy();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Thread {
        public boolean C;
        public c H;
        public d I;
        public a J;
        public boolean o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;

        /* renamed from: e  reason: collision with root package name */
        public int f39910e = 0;

        /* renamed from: f  reason: collision with root package name */
        public long f39911f = 0;

        /* renamed from: g  reason: collision with root package name */
        public long f39912g = 0;

        /* renamed from: h  reason: collision with root package name */
        public long f39913h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f39914i = 0;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;
        public volatile boolean m = false;
        public volatile boolean n = false;
        public LinkedList<Runnable> D = new LinkedList<>();
        public LinkedList<Runnable> E = new LinkedList<>();
        public TreeSet<e> F = new TreeSet<>();
        public boolean G = true;
        public V8Engine K = null;
        public int x = 0;
        public int y = 0;
        public boolean A = true;
        public int z = 1;
        public boolean B = false;

        public b(a aVar) {
            this.J = aVar;
            this.I = aVar.j;
        }

        public void A() {
            synchronized (this.I) {
                this.q = true;
                this.v = false;
                this.I.notifyAll();
                while (this.s && !this.v && !this.n) {
                    try {
                        this.I.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void B() {
            synchronized (this.I) {
                this.q = false;
                this.I.notifyAll();
                while (!this.s && !this.n) {
                    try {
                        this.I.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public boolean a() {
            return this.t && this.u && r();
        }

        public final void e() {
            this.f39910e++;
            if (this.f39911f != 0) {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.f39911f)) / 1000.0f;
                if (currentTimeMillis > 1.0f) {
                    this.J.r((int) (this.f39910e / currentTimeMillis));
                    this.f39910e = 0;
                    this.f39911f = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.f39911f = System.currentTimeMillis();
        }

        public void f() {
            synchronized (this.I) {
                this.D.clear();
                this.E.clear();
                this.F.clear();
            }
        }

        public final Runnable g() {
            synchronized (this.I) {
                if (!this.F.isEmpty() && this.F.first().b()) {
                    return this.F.pollFirst();
                }
                return this.D.pollFirst();
            }
        }

        public int h() {
            int i2;
            synchronized (this.I) {
                i2 = this.z;
            }
            return i2;
        }

        public final V8Engine i() {
            if (this.K == null) {
                this.K = V8Engine.getInstance();
            }
            return this.K;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x01a4, code lost:
            if (r20.J == null) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x01a6, code lost:
            r20.k = true;
            r20.J.o("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x01b4, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x01b8, code lost:
            if (r20.J == null) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x01ba, code lost:
            r20.J.n(1, r12.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x01c4, code lost:
            r12.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x01c8, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x01ca, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:119:0x01e6, code lost:
            if (r7 == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x01ee, code lost:
            if (r20.H.a() == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x01f0, code lost:
            r3 = r20.I;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x01f2, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x01f4, code lost:
            r20.v = true;
            r20.I.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x01fb, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x01fc, code lost:
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x0201, code lost:
            r3 = r20.I;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x0203, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x0205, code lost:
            r20.v = true;
            r20.r = true;
            r20.I.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x020e, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x020f, code lost:
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:140:0x0215, code lost:
            if (r8 == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x0217, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0218, code lost:
            if (r6 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x021a, code lost:
            r0 = r20.J;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x021c, code lost:
            if (r0 == null) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x021e, code lost:
            r0.f39907h.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x0226, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0227, code lost:
            if (r9 == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x0229, code lost:
            r0 = r20.J;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x022b, code lost:
            if (r0 == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x022d, code lost:
            r0.f39907h.onSurfaceChanged(null, r10, r11);
            r0.updateSurfaceViewSize(r10, r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x023a, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x023b, code lost:
            r0 = r20.J;
            r14 = java.lang.System.currentTimeMillis();
            r2 = r14 - r20.f39912g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x024b, code lost:
            if (r0.f39908i == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0254, code lost:
            if (((float) r2) < k()) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x0256, code lost:
            r20.f39912g = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x025e, code lost:
            if (r20.j != false) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0262, code lost:
            if (r20.J == null) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0264, code lost:
            r20.j = true;
            r20.J.o("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x026e, code lost:
            r0.f39907h.onDrawFrame(null);
            e();
            r2 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0282, code lost:
            if ((r14 - r20.f39914i) <= 33) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x0284, code lost:
            r0.f39901b.notifyFrameUpdated();
            r20.f39914i = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x028f, code lost:
            if (r20.l == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x0291, code lost:
            r20.J.f39901b.smallGameOnResume();
            r20.l = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x029f, code lost:
            r4 = r0.f39901b.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x02a7, code lost:
            if (r4 == false) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x02a9, code lost:
            r14 = r20.H.i();
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x02b1, code lost:
            if (r14 == 12288) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x02b5, code lost:
            if (r14 == 12302) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x02b7, code lost:
            d.a.g0.a.a.c.f(com.baidu.smallgame.sdk.ArBridge.TAG, "eglSwapBuffers", r14);
            r3 = r20.I;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x02c0, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x02c2, code lost:
            r20.r = true;
            r20.I.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x02c9, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:183:0x02ce, code lost:
            r14 = r2;
            r15 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x02d1, code lost:
            r14 = r2;
            r15 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x02d4, code lost:
            r20.f39913h = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x02e4, code lost:
            if (r20.J.f39901b.isRenderCallbackQueueEmpty() != false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x02e6, code lost:
            if (r4 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x02e8, code lost:
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x02ea, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:191:0x02f5, code lost:
            if ((r0.f39901b.getStuckScreenHandler() instanceof d.a.g0.a.b) == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:192:0x02f7, code lost:
            ((d.a.g0.a.b) r0.f39901b.getStuckScreenHandler()).f(r2, r20.f39913h);
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x0306, code lost:
            r0 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x0309, code lost:
            r14 = r4;
            r0.f39908i = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x030e, code lost:
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:196:0x0310, code lost:
            if (r13 == false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:197:0x0312, code lost:
            r4 = true;
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:198:0x0315, code lost:
            r4 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:199:0x0316, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x019c, code lost:
            if (r12 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x01a0, code lost:
            if (r20.k != false) goto L100;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void j() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            this.H = new c(this.J);
            boolean z7 = false;
            this.t = false;
            this.u = false;
            this.B = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            int i2 = 0;
            int i3 = 0;
            Runnable runnable = null;
            boolean z15 = false;
            loop0: while (true) {
                try {
                    synchronized (this.I) {
                        while (!this.m) {
                            if (!this.E.isEmpty()) {
                                runnable = this.E.pollFirst();
                            } else if (!a() || (!x() && (runnable = g()) == null)) {
                                if (this.p != this.o) {
                                    boolean z16 = this.o;
                                    this.p = this.o;
                                    if (this.o) {
                                        this.l = z7;
                                        this.J.f39901b.smallGameOnPauseOnGLThrad();
                                    } else {
                                        this.l = true;
                                    }
                                    this.I.notifyAll();
                                    StringBuilder sb = new StringBuilder();
                                    z4 = z16;
                                    sb.append("mPaused is now ");
                                    sb.append(this.p);
                                    sb.append(" tid=");
                                    z2 = z10;
                                    z3 = z11;
                                    sb.append(getId());
                                    Log.i(ArBridge.TAG, sb.toString());
                                } else {
                                    z2 = z10;
                                    z3 = z11;
                                    z4 = false;
                                }
                                if (this.w) {
                                    z();
                                    y();
                                    this.w = false;
                                    z10 = true;
                                } else {
                                    z10 = z2;
                                }
                                if (z8) {
                                    z();
                                    y();
                                    z8 = false;
                                }
                                if (z4 && this.u) {
                                    z();
                                }
                                if (z4) {
                                    boolean z17 = this.t;
                                }
                                if (!this.q && !this.s) {
                                    if (this.u) {
                                        z();
                                    }
                                    this.s = true;
                                    this.r = false;
                                    this.I.notifyAll();
                                }
                                if (this.q && this.s) {
                                    this.s = false;
                                    this.I.notifyAll();
                                }
                                if (z9) {
                                    this.B = false;
                                    this.C = true;
                                    this.I.notifyAll();
                                    z9 = false;
                                }
                                if (r()) {
                                    if (this.t) {
                                        z5 = z10;
                                        z11 = z3;
                                    } else if (z10) {
                                        z11 = z3;
                                        z5 = false;
                                    } else {
                                        try {
                                            this.H.h();
                                            this.J.f39901b.setEglContextToRecorder(this.J.m(), 0, 0);
                                            this.t = true;
                                            this.I.notifyAll();
                                            z5 = z10;
                                            z11 = true;
                                        } catch (RuntimeException e2) {
                                            this.I.a(this);
                                            throw e2;
                                        }
                                    }
                                    if (this.t && !this.u) {
                                        this.u = true;
                                        z12 = true;
                                        z13 = true;
                                        z14 = true;
                                    }
                                    if (this.u) {
                                        if (this.G) {
                                            int i4 = this.x;
                                            int i5 = this.y;
                                            this.B = true;
                                            this.G = false;
                                            i2 = i4;
                                            i3 = i5;
                                            z6 = false;
                                            z12 = true;
                                            z14 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        this.A = z6;
                                        this.I.notifyAll();
                                        z10 = z5;
                                        if (this.B) {
                                            z15 = true;
                                        }
                                    } else {
                                        z10 = z5;
                                    }
                                } else {
                                    z11 = z3;
                                }
                                this.I.wait();
                                z7 = false;
                            }
                            z = z8;
                        }
                        break loop0;
                    }
                } catch (Throwable th) {
                    synchronized (this.I) {
                        if (this.J != null) {
                            this.J.f39901b.smallGameDestroy();
                        }
                        V8Engine v8Engine = V8Engine.getInstance();
                        if (v8Engine != null && !v8Engine.isDestroyed()) {
                            Log.e(ArBridge.TAG, "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                        }
                        z();
                        y();
                        throw th;
                    }
                }
            }
            synchronized (this.I) {
                if (this.J != null) {
                    this.J.f39901b.smallGameDestroy();
                }
                V8Engine v8Engine2 = V8Engine.getInstance();
                if (v8Engine2 != null && !v8Engine2.isDestroyed()) {
                    Log.e(ArBridge.TAG, "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                }
                z();
                y();
            }
            return;
            if (V8Engine.isDebug() && this.J != null) {
                this.J.n(2, runnable.toString());
            }
            z8 = z;
            z7 = false;
            runnable = null;
        }

        public final float k() {
            V8Engine i2 = i();
            if (i2 != null) {
                return i2.minFramesInterval();
            }
            return 16.666666f;
        }

        public void l() {
            synchronized (this.I) {
                Log.i(ArBridge.TAG, "onPause tid=" + getId());
                this.o = true;
                if (this.J != null && (this.J.f39901b.getStuckScreenHandler() instanceof d.a.g0.a.b)) {
                    ((d.a.g0.a.b) this.J.f39901b.getStuckScreenHandler()).e();
                }
                this.I.notifyAll();
                while (!this.n && !this.p) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        this.I.wait(500L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m() {
            synchronized (this.I) {
                Log.i(ArBridge.TAG, "onResume tid=" + getId());
                this.o = false;
                this.A = true;
                this.C = false;
                this.I.notifyAll();
                while (!this.n && this.p && !this.C) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        this.I.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void n(int i2, int i3) {
            synchronized (this.I) {
                this.x = i2;
                this.y = i3;
                this.G = true;
                this.A = true;
                this.C = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                this.I.notifyAll();
                while (!this.n && !this.p && !this.C && a()) {
                    try {
                        this.I.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void o(Runnable runnable, long j) {
            if (runnable != null) {
                if (this.m || this.n) {
                    return;
                }
                synchronized (this.I) {
                    TreeSet<e> treeSet = this.F;
                    if (j <= 0) {
                        j = 0;
                    }
                    treeSet.add(new e(runnable, j));
                    this.I.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void p(Runnable runnable) {
            q(runnable, true);
        }

        public final void q(Runnable runnable, boolean z) {
            if (runnable != null) {
                if (this.m || this.n) {
                    return;
                }
                synchronized (this.I) {
                    if (V8Engine.isDebug() && this.J != null) {
                        this.J.n(0, runnable.toString());
                    }
                    if (!z && !a()) {
                        this.E.add(runnable);
                        this.I.notifyAll();
                    }
                    this.D.add(runnable);
                    this.I.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public final boolean r() {
            return !this.p && this.q && !this.r && this.x > 0 && this.y > 0 && (this.A || this.z == 1);
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.searchbox.v8engine.V8Engine, d.a.g0.a.a$c, d.a.g0.a.a] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            a aVar = this.J;
            if (aVar != null) {
                ArBridge k = aVar.k();
                if (k != null) {
                    k.setGLThreadID(getId());
                    k.smallGameOnInit();
                    this.J.initDisplayMetrics();
                } else {
                    Log.e(ArBridge.TAG, "Render Engine Init Failed. ArBridge is null");
                }
            } else {
                Log.e(ArBridge.TAG, "Render Engine Init Failed. AREngine is null");
            }
            try {
                try {
                    j();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.I.b(this);
                this.H.g();
                this.H = null;
                this.J = null;
                this.K = null;
            }
        }

        public void s() {
            synchronized (this.I) {
                this.m = true;
                this.I.notifyAll();
                while (!this.n) {
                    try {
                        this.I.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void t() {
            synchronized (this.I) {
                this.A = true;
                this.I.notifyAll();
            }
        }

        public void u() {
            synchronized (this.I) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.B = true;
                this.A = true;
                this.C = false;
                this.I.notifyAll();
                while (!this.n && !this.p && !this.C && a()) {
                    try {
                        this.I.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void v(Runnable runnable) {
            q(runnable, false);
        }

        public void w(int i2) {
            if (i2 >= 0 && i2 <= 1) {
                synchronized (this.I) {
                    this.z = i2;
                    this.I.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public boolean x() {
            return this.J.f39901b.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.f39913h)) > k();
        }

        public final void y() {
            if (this.t) {
                this.H.c();
                this.t = false;
                this.I.a(this);
            }
        }

        public final void z() {
            if (this.u) {
                this.u = false;
                this.H.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public a f39915a;

        /* renamed from: b  reason: collision with root package name */
        public EGLDisplay f39916b;

        /* renamed from: c  reason: collision with root package name */
        public EGLSurface f39917c;

        /* renamed from: d  reason: collision with root package name */
        public EGLConfig f39918d;

        /* renamed from: e  reason: collision with root package name */
        public EGLContext f39919e;

        public c(a aVar) {
            this.f39915a = aVar;
        }

        public static String d(String str, int i2) {
            return str + " failed: " + i2;
        }

        public static void f(String str, String str2, int i2) {
            Log.w(str, d(str2, i2));
        }

        public static void k(String str, int i2) {
            throw new RuntimeException(d(str, i2));
        }

        public boolean a() {
            if (this.f39916b != null) {
                if (this.f39918d != null) {
                    b();
                    Object obj = this.f39915a.l;
                    if (obj == null) {
                        obj = this.f39915a.k;
                    }
                    if (obj != null) {
                        this.f39917c = EGL14.eglCreateWindowSurface(this.f39916b, this.f39918d, obj, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                    } else {
                        this.f39917c = null;
                    }
                    EGLSurface eGLSurface = this.f39917c;
                    if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                        return EGL14.eglMakeCurrent(this.f39916b, eGLSurface, eGLSurface, this.f39919e);
                    }
                    if (EGL14.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                throw new RuntimeException("mEglConfig not initialized");
            }
            throw new RuntimeException("eglDisplay not initialized");
        }

        public void b() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f39917c;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL14.EGL_NO_SURFACE)) {
                return;
            }
            EGL14.eglMakeCurrent(this.f39916b, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f39916b, this.f39917c);
            this.f39917c = null;
        }

        public void c() {
            EGLContext eGLContext = this.f39919e;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f39916b, eGLContext);
                this.f39919e = null;
            }
            EGLDisplay eGLDisplay = this.f39916b;
            if (eGLDisplay != null) {
                EGL14.eglTerminate(eGLDisplay);
                this.f39916b = null;
            }
            this.f39915a.f39904e = -1L;
        }

        public final EGLConfig e(int i2, int i3, boolean z) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.f39916b, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, z ? 16 : 0, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, 0, 12352, 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER, 0, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                Log.w(ArBridge.TAG, "unable to find RGB8888 / " + i3 + " EGLConfig");
                return null;
            }
            return eGLConfigArr[0];
        }

        public void g() {
            this.f39915a = null;
        }

        public void h() {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f39916b = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig e2 = e(0, 0, false);
                    this.f39918d = e2;
                    this.f39919e = EGL14.eglCreateContext(this.f39916b, e2, EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                    this.f39915a.f39904e = Thread.currentThread().getId();
                    EGLContext eGLContext = this.f39919e;
                    if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
                        this.f39917c = null;
                        return;
                    }
                    this.f39919e = null;
                    j("createContext");
                    throw null;
                }
                this.f39916b = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }

        public int i() {
            return !EGL14.eglSwapBuffers(this.f39916b, this.f39917c) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public final void j(String str) {
            k(str, EGL14.eglGetError());
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public b f39920a;

        public d() {
        }

        public void a(b bVar) {
            if (this.f39920a == bVar) {
                this.f39920a = null;
            }
            synchronized (this) {
                notifyAll();
            }
        }

        public synchronized void b(b bVar) {
            bVar.n = true;
            if (this.f39920a == bVar) {
                this.f39920a = null;
            }
            notifyAll();
        }

        public /* synthetic */ d(RunnableC0539a runnableC0539a) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements Comparable<e>, Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final long f39921e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f39922f;

        public e(Runnable runnable, long j) {
            this.f39922f = runnable;
            this.f39921e = System.currentTimeMillis() + j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return (int) (this.f39921e - eVar.f39921e);
        }

        public boolean b() {
            return System.currentTimeMillis() >= this.f39921e;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f39922f.run();
        }
    }

    public a() {
        Log.setMinLogLevel(6, false);
        this.f39901b = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        b bVar = this.m;
        return bVar != null && bVar.a();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void addDebugConsole(DebugConsole debugConsole) {
        if (this.f39902c == null) {
            this.f39902c = new ArrayList<>(1);
        }
        this.f39902c.add(debugConsole);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.s();
        }
        Log.e(ArBridge.TAG, "[V8Dispose][AREngine] exitGLThread.");
    }

    public void finalize() {
        try {
            if (this.m != null) {
                this.m.s();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        if (this.f39901b.getGameRecorder() != null) {
            return this.f39901b.getGameRecorder().s();
        }
        return 0L;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getFPS() {
        return this.f39903d;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        return this.m;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        ArBridge arBridge = this.f39901b;
        return arBridge == null ? new JSONArray() : arBridge.getPerformanceJson();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        ArBridge arBridge = this.f39901b;
        return arBridge == null ? new PerformanceJsonBean() : arBridge.getPerformanceJsonBean();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        b bVar = this.m;
        if (bVar != null) {
            return bVar.h();
        }
        return 1;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public d.a.g0.a.d.c getStuckScreenHandler() {
        ArBridge arBridge = this.f39901b;
        if (arBridge == null) {
            return null;
        }
        return arBridge.getStuckScreenHandler();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void initDisplayMetrics() {
        Context l = l();
        if (l != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) l.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.widthPixels;
            float f3 = displayMetrics.heightPixels;
            float f4 = this.f39905f;
            float f5 = f4 != 0.0f ? f4 : f2;
            float f6 = this.f39906g;
            float f7 = f6 != 0.0f ? f6 : f3;
            ArBridge arBridge = this.f39901b;
            if (arBridge != null) {
                arBridge.setDisplayMetrics(f5, f7, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
                return;
            } else {
                Log.e(ArBridge.TAG, "[RenderError] error init render display, because arbridge is null");
                return;
            }
        }
        throw new NullPointerException("[RenderError] initDisplayMetrics Error. because AppContext is null");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean isDestroyed() {
        return this.f39901b.isDestroyed();
    }

    public ArBridge k() {
        return this.f39901b;
    }

    public Context l() {
        return this.f39900a;
    }

    public EGLContext m() {
        b bVar = this.m;
        if (bVar == null || bVar.H == null) {
            return null;
        }
        return this.m.H.f39919e;
    }

    public final void n(int i2, String str) {
        if (this.f39902c != null) {
            for (DebugConsole debugConsole : new ArrayList(this.f39902c)) {
                debugConsole.onReceiveInfo(i2, str);
            }
        }
    }

    public void o(String str) {
        ArBridge arBridge = this.f39901b;
        if (arBridge != null) {
            arBridge.getPerformanceJsonBean().put(str);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        if (this.n && this.f39907h != null) {
            b bVar = this.m;
            int h2 = bVar != null ? bVar.h() : 1;
            b bVar2 = new b(this);
            this.m = bVar2;
            if (h2 != 1) {
                bVar2.w(h2);
            }
            this.m.start();
        }
        this.n = false;
        Log.w(ArBridge.TAG, "[V8Dispose][AREngine] onAttachedToWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        b bVar;
        if (!this.n && (bVar = this.m) != null) {
            bVar.s();
        }
        this.n = true;
        Log.w(ArBridge.TAG, "[V8Dispose][AREngine] onDetachedFromWindow");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.l();
        }
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.getGameRecorder().w();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.m();
        }
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.getGameRecorder().z();
        }
    }

    public void p(Context context) {
        this.f39900a = context;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.getGameRecorder().v();
        }
    }

    public void q(SurfaceHolder surfaceHolder) {
        this.l = (SurfaceHolder) new WeakReference(surfaceHolder).get();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.p(runnable);
        }
    }

    public void r(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 60) {
            i2 = 60;
        }
        this.f39903d = i2;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void removeDebugConsole(DebugConsole debugConsole) {
        if (this.f39902c == null) {
            return;
        }
        this.f39902c.remove(debugConsole);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.t();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.getGameRecorder().y();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.v(runnable);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(d.a.w.c.a aVar) {
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.getGameRecorder().A(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        this.f39901b.setFirstFrameListener(firstFrameListener);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(d.a.w.c.c cVar) {
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.getGameRecorder().C(cVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(d.a.g0.a.d.a aVar) {
        ArBridge arBridge = this.f39901b;
        if (arBridge != null) {
            arBridge.setOnStuckScreenListener(aVar);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        o = permissionProxy;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i2) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.w(i2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f39907h = renderer;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        this.f39901b.setScreenShotStatus(z);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j) {
        ArBridge arBridge = this.f39901b;
        if (arBridge != null) {
            arBridge.setStuckScreenLimitTime(j);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        b bVar = this.m;
        if (bVar == null) {
            Log.e(ArBridge.TAG, "Destroy AREngine fail. Because GLThread is null");
        } else {
            bVar.v(new RunnableC0539a());
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        this.f39901b.smallGameOnPause();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        this.f39901b.smallGameUpdate();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        if (this.f39907h != null) {
            b bVar = new b(this);
            this.m = bVar;
            bVar.start();
            return;
        }
        throw new NullPointerException("start render engine failed. because renderer is not set");
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i2, String str, boolean z2) {
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.nativeUpdateRecordingStatus(true);
            this.f39901b.getGameRecorder().F(z, i2, str, z2);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        if (this.f39901b.getGameRecorder() != null) {
            this.f39901b.getGameRecorder().I();
            this.f39901b.nativeUpdateRecordingStatus(false);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i2, int i3) {
        Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceChanged. width=" + i2 + ", height=" + i3);
        this.m.n(i2, i3);
        this.f39901b.setEglContextToRecorder(m(), i2, i3);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceCreated.");
        this.m.A();
        Context appContext = V8Engine.getAppContext();
        if (appContext != null) {
            p = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceDestroyed.");
        this.m.B();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void updateSurfaceViewSize(float f2, float f3) {
        Log.w(ArBridge.TAG, "[ARDispose] updateSurfaceViewSize, width=" + f2 + ", height=" + f3);
        this.f39905f = f2;
        this.f39906g = f3;
        this.f39901b.setSize(f2, f3);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.o(runnable, j);
        }
    }
}
