package d.b.u.c;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.ShortCompanionObject;
/* loaded from: classes2.dex */
public class b {
    public static final String A = "b";

    /* renamed from: b  reason: collision with root package name */
    public d.b.u.b.g.c f64726b;

    /* renamed from: e  reason: collision with root package name */
    public long f64729e;

    /* renamed from: f  reason: collision with root package name */
    public long f64730f;

    /* renamed from: g  reason: collision with root package name */
    public long f64731g;
    public d.b.u.c.g.d k;
    public boolean l;
    public Context m;
    public int n;
    public d.b.u.c.c o;
    public d.b.u.a.a.a q;

    /* renamed from: a  reason: collision with root package name */
    public int f64725a = 120000;

    /* renamed from: c  reason: collision with root package name */
    public int f64727c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64728d = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64732h = false;
    public int r = 0;
    public int s = 0;
    public byte[] t = ByteBuffer.allocate(3840).putShort(ShortCompanionObject.MIN_VALUE).array();
    public ByteBuffer u = ByteBuffer.allocate(3840).put(this.t);
    public Timer v = null;
    public TimerTask w = null;
    public boolean x = false;
    public boolean y = false;
    public long z = 0;
    public d i = d.x();
    public d.b.u.c.a p = null;
    public e j = new a();

    /* loaded from: classes2.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.b.u.c.e
        public void a(int i) {
            String str = b.A;
            Log.i(str, "onRecorderError:" + i);
            if (b.this.o != null) {
                b.this.o.onError(i);
            }
        }

        @Override // d.b.u.c.e
        public void b(boolean z, String str) {
            String str2 = b.A;
            Log.i(str2, "on RecorderComplete record time :" + b.this.f64731g);
            if (b.this.o != null) {
                b.this.o.w((int) b.this.f64731g, str);
            }
        }

        @Override // d.b.u.c.e
        public void c(long j) {
            b.this.f64731g = j;
            if (j <= b.this.f64725a || !b.this.l) {
                return;
            }
            b.this.I();
        }

        @Override // d.b.u.c.e
        public void d(boolean z) {
            if (b.this.o != null) {
                b.this.o.onStart();
                b.this.x = true;
            }
        }
    }

    /* renamed from: d.b.u.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1771b extends TimerTask {
        public C1771b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (b.this.x && !b.this.y) {
                Log.i(b.A, "cancel audio time");
                b.this.H();
                b.this.y = false;
                return;
            }
            b bVar = b.this;
            bVar.K(bVar.u, 3840, System.nanoTime() - b.this.z);
            b.this.y = true;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements d.b.u.a.a.a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<b> f64735a;

        public c(b bVar) {
            this.f64735a = new WeakReference<>(bVar);
            String str = b.A;
            Log.i(str, "gameRecorderRef is:" + this.f64735a.get());
        }

        @Override // d.b.u.a.a.a
        public void a(ByteBuffer byteBuffer, int i, long j) {
            if (this.f64735a.get() != null) {
                this.f64735a.get().y = false;
                this.f64735a.get().K(byteBuffer, i, j);
            }
        }

        @Override // d.b.u.a.a.a
        public void b(boolean z) {
            Log.i(b.A, "onAudioStop");
            if (this.f64735a.get() != null) {
                this.f64735a.get().H();
            }
        }

        @Override // d.b.u.a.a.a
        public void c(boolean z, AudioParams audioParams) {
            if (this.f64735a.get() != null) {
                this.f64735a.get().G(z, audioParams);
                Log.i(b.A, "onAudioStart");
            }
        }
    }

    public b(Context context) {
        this.m = context;
        D(new d.b.u.c.g.d(), this.j);
    }

    public void A(d.b.u.c.a aVar) {
        this.p = aVar;
    }

    public void B(d.b.u.c.g.d dVar) {
        this.k = dVar;
    }

    public void C(d.b.u.c.c cVar) {
        this.o = cVar;
    }

    public void D(d.b.u.c.g.d dVar, e eVar) {
        B(dVar);
        this.j = eVar;
    }

    public final void E(AudioParams audioParams) {
        if (this.q == null) {
            q();
        }
        if (audioParams == null) {
            Log.i(A, "audioParams is null,start to create AudioPams");
            new AudioParams();
        }
        if (this.p != null) {
            String str = A;
            Log.i(str, "set audio engie:" + this.p);
            this.p.a(this.q);
        }
    }

    public void F(boolean z, int i, String str, boolean z2) {
        if (this.l) {
            return;
        }
        Log.i(A, "startRecored");
        this.z = System.nanoTime();
        this.k.u(str);
        this.k.s(z);
        int i2 = i * 1000;
        this.k.v(i2);
        this.k.x(this.r);
        this.k.w(this.s);
        this.f64729e = 0L;
        this.f64731g = 0L;
        if (i > 0 && i < 120) {
            this.f64725a = i2;
        } else {
            this.f64725a = 120000;
        }
        E(null);
    }

    public final void G(boolean z, AudioParams audioParams) {
        if (audioParams != null) {
            this.k.t(audioParams.getSampleRate());
            this.k.r(audioParams.getFrameSize());
            this.k.q(audioParams.getChannelConfig());
        }
        this.x = false;
        this.l = true;
        H();
        this.v = new Timer();
        C1771b c1771b = new C1771b();
        this.w = c1771b;
        this.v.schedule(c1771b, 300L, 20L);
    }

    public final synchronized void H() {
        if (this.v != null) {
            this.v.cancel();
            this.v = null;
            this.w = null;
        }
    }

    public void I() {
        Log.i(A, "stopRecored");
        r();
        this.l = false;
        this.x = false;
        this.y = false;
        int i = this.n;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw new RuntimeException("unknown status " + this.n);
            }
            this.n = 0;
            d dVar = this.i;
            if (dVar != null) {
                dVar.U();
            }
        }
    }

    public final void J(int i, long j) {
        if (this.l && this.k != null) {
            int i2 = this.n;
            if (i2 == 0) {
                p();
                d dVar = this.i;
                if (dVar != null) {
                    dVar.S(this.m, this.k, this.j);
                }
                this.n = 1;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    this.f64726b.k().h(i);
                    d dVar2 = this.i;
                    if (dVar2 != null) {
                        dVar2.W(this.f64726b);
                    }
                    this.n = 1;
                } else {
                    throw new RuntimeException("unknown status " + this.n);
                }
            }
        }
        d dVar3 = this.i;
        if (dVar3 == null || this.f64728d) {
            return;
        }
        dVar3.H(j - this.f64729e);
    }

    public final void K(ByteBuffer byteBuffer, int i, long j) {
        d dVar = this.i;
        if (dVar == null || !this.l || byteBuffer == null || i <= 0 || this.f64728d) {
            return;
        }
        dVar.F(byteBuffer, i, j - this.f64729e);
    }

    public final void p() {
        d.b.u.c.g.d dVar = this.k;
        if (dVar == null || this.f64726b == null) {
            return;
        }
        int l = dVar.l();
        int n = this.k.n();
        if (l >= 1920 || n >= 1920) {
            l = (int) ((l * 2) / 3.0f);
            n = (int) ((n * 2) / 3.0f);
        }
        if (l % 2 == 1) {
            l++;
        }
        if (n % 2 == 1) {
            n++;
        }
        String str = A;
        Log.i(str, "Record video width:" + n + " ;video height:" + l);
        this.k.x(n);
        this.k.w(l);
    }

    public final void q() {
        if (this.q != null) {
            return;
        }
        this.q = new c(this);
    }

    public final void r() {
        if (this.f64728d) {
            this.f64729e += System.nanoTime() - this.f64730f;
            this.f64728d = false;
        }
    }

    public long s() {
        return this.f64731g;
    }

    public void t(boolean z, EGLContext eGLContext, int i, int i2, Context context) {
        if (eGLContext == null) {
            return;
        }
        this.m = context;
        String str = A;
        Log.i(str, "onContextChanged:" + eGLContext + "; w:" + i + "; h:" + i2 + "; isFlip:" + z);
        d.b.u.b.g.c cVar = this.f64726b;
        if (cVar == null) {
            this.f64726b = new d.b.u.b.g.c(eGLContext, 0, true);
        } else {
            cVar.o(eGLContext);
        }
        this.f64726b.j().f(i);
        this.f64726b.j().e(i2);
        if (z) {
            this.f64726b.d().k(MirrorType.VERTICALLY);
        }
        this.r = i;
        this.s = i2;
        this.k.x(i);
        this.k.w(i2);
    }

    public void u(int i) {
        if (this.f64726b == null) {
            return;
        }
        if (this.f64727c != i) {
            d.b.u.b.f.d dVar = new d.b.u.b.f.d();
            dVar.h(i);
            this.f64726b.r(dVar);
            d dVar2 = this.i;
            if (dVar2 != null) {
                dVar2.s(this.f64726b);
            }
            this.f64727c = i;
        }
        J(this.f64727c, System.nanoTime());
    }

    public void v() {
        if (this.f64728d) {
            Log.i(A, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.l) {
            this.f64728d = true;
            Log.i(A, "pauseRecord");
            this.f64730f = System.nanoTime();
            this.f64729e = 0L;
            d dVar = this.i;
            if (dVar != null) {
                dVar.I();
                long y = (this.f64730f - (this.f64731g * 1000000)) - this.i.y();
                this.f64729e = y;
                if (y < 0) {
                    this.f64729e = 0L;
                }
            }
            d.b.u.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onPause();
            }
            H();
        }
    }

    public void w() {
        if (!this.f64728d) {
            this.f64732h = true;
            v();
            return;
        }
        this.f64732h = false;
    }

    public void x() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.G();
            this.i = null;
        }
        if (this.j != null) {
            this.j = null;
        }
    }

    public void y() {
        if (this.f64728d) {
            this.f64729e += System.nanoTime() - this.f64730f;
            this.f64728d = false;
            E(null);
            d.b.u.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onResume();
            }
        }
    }

    public void z() {
        if (this.f64728d && this.f64732h) {
            y();
        }
        this.f64732h = false;
    }
}
