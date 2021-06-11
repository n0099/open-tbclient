package d.a.w.c;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import androidx.core.view.DisplayCompat;
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
    public d.a.w.b.g.c f68493b;

    /* renamed from: e  reason: collision with root package name */
    public long f68496e;

    /* renamed from: f  reason: collision with root package name */
    public long f68497f;

    /* renamed from: g  reason: collision with root package name */
    public long f68498g;
    public d.a.w.c.g.d k;
    public boolean l;
    public Context m;
    public int n;
    public d.a.w.c.c o;
    public d.a.w.a.a.a q;

    /* renamed from: a  reason: collision with root package name */
    public int f68492a = 120000;

    /* renamed from: c  reason: collision with root package name */
    public int f68494c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68495d = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68499h = false;
    public int r = 0;
    public int s = 0;
    public byte[] t = ByteBuffer.allocate(DisplayCompat.DISPLAY_SIZE_4K_WIDTH).putShort(ShortCompanionObject.MIN_VALUE).array();
    public ByteBuffer u = ByteBuffer.allocate(DisplayCompat.DISPLAY_SIZE_4K_WIDTH).put(this.t);
    public Timer v = null;
    public TimerTask w = null;
    public boolean x = false;
    public boolean y = false;
    public long z = 0;

    /* renamed from: i  reason: collision with root package name */
    public d f68500i = d.x();
    public d.a.w.c.a p = null;
    public e j = new a();

    /* loaded from: classes2.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.w.c.e
        public void a(boolean z) {
            if (b.this.o != null) {
                b.this.o.onStart();
                b.this.x = true;
            }
        }

        @Override // d.a.w.c.e
        public void b(int i2) {
            String str = b.A;
            Log.i(str, "onRecorderError:" + i2);
            if (b.this.o != null) {
                b.this.o.onError(i2);
            }
        }

        @Override // d.a.w.c.e
        public void c(boolean z, String str) {
            String str2 = b.A;
            Log.i(str2, "on RecorderComplete record time :" + b.this.f68498g);
            if (b.this.o != null) {
                b.this.o.y((int) b.this.f68498g, str);
            }
        }

        @Override // d.a.w.c.e
        public void d(long j) {
            b.this.f68498g = j;
            if (j <= b.this.f68492a || !b.this.l) {
                return;
            }
            b.this.I();
        }
    }

    /* renamed from: d.a.w.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1872b extends TimerTask {
        public C1872b() {
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
            bVar.K(bVar.u, DisplayCompat.DISPLAY_SIZE_4K_WIDTH, System.nanoTime() - b.this.z);
            b.this.y = true;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements d.a.w.a.a.a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<b> f68503a;

        public c(b bVar) {
            this.f68503a = new WeakReference<>(bVar);
            String str = b.A;
            Log.i(str, "gameRecorderRef is:" + this.f68503a.get());
        }

        @Override // d.a.w.a.a.a
        public void a(ByteBuffer byteBuffer, int i2, long j) {
            if (this.f68503a.get() != null) {
                this.f68503a.get().y = false;
                this.f68503a.get().K(byteBuffer, i2, j);
            }
        }

        @Override // d.a.w.a.a.a
        public void b(boolean z, AudioParams audioParams) {
            if (this.f68503a.get() != null) {
                this.f68503a.get().G(z, audioParams);
                Log.i(b.A, "onAudioStart");
            }
        }

        @Override // d.a.w.a.a.a
        public void c(boolean z) {
            Log.i(b.A, "onAudioStop");
            if (this.f68503a.get() != null) {
                this.f68503a.get().H();
            }
        }
    }

    public b(Context context) {
        this.m = context;
        D(new d.a.w.c.g.d(), this.j);
    }

    public void A(d.a.w.c.a aVar) {
        this.p = aVar;
    }

    public void B(d.a.w.c.g.d dVar) {
        this.k = dVar;
    }

    public void C(d.a.w.c.c cVar) {
        this.o = cVar;
    }

    public void D(d.a.w.c.g.d dVar, e eVar) {
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

    public void F(boolean z, int i2, String str, boolean z2) {
        if (this.l) {
            return;
        }
        Log.i(A, "startRecored");
        this.z = System.nanoTime();
        this.k.u(str);
        this.k.s(z);
        int i3 = i2 * 1000;
        this.k.v(i3);
        this.k.x(this.r);
        this.k.w(this.s);
        this.f68496e = 0L;
        this.f68498g = 0L;
        if (i2 > 0 && i2 < 120) {
            this.f68492a = i3;
        } else {
            this.f68492a = 120000;
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
        C1872b c1872b = new C1872b();
        this.w = c1872b;
        this.v.schedule(c1872b, 300L, 20L);
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
        int i2 = this.n;
        if (i2 != 0) {
            if (i2 != 1 && i2 != 2) {
                throw new RuntimeException("unknown status " + this.n);
            }
            this.n = 0;
            d dVar = this.f68500i;
            if (dVar != null) {
                dVar.U();
            }
        }
    }

    public final void J(int i2, long j) {
        if (this.l && this.k != null) {
            int i3 = this.n;
            if (i3 == 0) {
                p();
                d dVar = this.f68500i;
                if (dVar != null) {
                    dVar.S(this.m, this.k, this.j);
                }
                this.n = 1;
            } else if (i3 != 1) {
                if (i3 == 2) {
                    this.f68493b.k().h(i2);
                    d dVar2 = this.f68500i;
                    if (dVar2 != null) {
                        dVar2.W(this.f68493b);
                    }
                    this.n = 1;
                } else {
                    throw new RuntimeException("unknown status " + this.n);
                }
            }
        }
        d dVar3 = this.f68500i;
        if (dVar3 == null || this.f68495d) {
            return;
        }
        dVar3.H(j - this.f68496e);
    }

    public final void K(ByteBuffer byteBuffer, int i2, long j) {
        d dVar = this.f68500i;
        if (dVar == null || !this.l || byteBuffer == null || i2 <= 0 || this.f68495d) {
            return;
        }
        dVar.F(byteBuffer, i2, j - this.f68496e);
    }

    public final void p() {
        d.a.w.c.g.d dVar = this.k;
        if (dVar == null || this.f68493b == null) {
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
        if (this.f68495d) {
            this.f68496e += System.nanoTime() - this.f68497f;
            this.f68495d = false;
        }
    }

    public long s() {
        return this.f68498g;
    }

    public void t(boolean z, EGLContext eGLContext, int i2, int i3, Context context) {
        if (eGLContext == null) {
            return;
        }
        this.m = context;
        String str = A;
        Log.i(str, "onContextChanged:" + eGLContext + "; w:" + i2 + "; h:" + i3 + "; isFlip:" + z);
        d.a.w.b.g.c cVar = this.f68493b;
        if (cVar == null) {
            this.f68493b = new d.a.w.b.g.c(eGLContext, 0, true);
        } else {
            cVar.o(eGLContext);
        }
        this.f68493b.j().f(i2);
        this.f68493b.j().e(i3);
        if (z) {
            this.f68493b.d().k(MirrorType.VERTICALLY);
        }
        this.r = i2;
        this.s = i3;
        this.k.x(i2);
        this.k.w(i3);
    }

    public void u(int i2) {
        if (this.f68493b == null) {
            return;
        }
        if (this.f68494c != i2) {
            d.a.w.b.f.d dVar = new d.a.w.b.f.d();
            dVar.h(i2);
            this.f68493b.r(dVar);
            d dVar2 = this.f68500i;
            if (dVar2 != null) {
                dVar2.s(this.f68493b);
            }
            this.f68494c = i2;
        }
        J(this.f68494c, System.nanoTime());
    }

    public void v() {
        if (this.f68495d) {
            Log.i(A, "pauseRecord cmd has executed, please run resumeRecord!");
        } else if (this.l) {
            this.f68495d = true;
            Log.i(A, "pauseRecord");
            this.f68497f = System.nanoTime();
            this.f68496e = 0L;
            d dVar = this.f68500i;
            if (dVar != null) {
                dVar.I();
                long y = (this.f68497f - (this.f68498g * 1000000)) - this.f68500i.y();
                this.f68496e = y;
                if (y < 0) {
                    this.f68496e = 0L;
                }
            }
            d.a.w.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onPause();
            }
            H();
        }
    }

    public void w() {
        if (!this.f68495d) {
            this.f68499h = true;
            v();
            return;
        }
        this.f68499h = false;
    }

    public void x() {
        d dVar = this.f68500i;
        if (dVar != null) {
            dVar.G();
            this.f68500i = null;
        }
        if (this.j != null) {
            this.j = null;
        }
    }

    public void y() {
        if (this.f68495d) {
            this.f68496e += System.nanoTime() - this.f68497f;
            this.f68495d = false;
            E(null);
            d.a.w.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onResume();
            }
        }
    }

    public void z() {
        if (this.f68495d && this.f68499h) {
            y();
        }
        this.f68499h = false;
    }
}
