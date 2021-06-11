package d.e.b;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.faceunity.gles.Texture2dProgram;
import d.a.n0.u1.g;
import d.a.n0.u1.k;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import kotlinx.coroutines.CoroutineContextKt;
@TargetApi(18)
/* loaded from: classes6.dex */
public class d {
    public boolean A;
    public long B;

    /* renamed from: a  reason: collision with root package name */
    public d.e.c.e f69821a;

    /* renamed from: b  reason: collision with root package name */
    public d.e.c.a f69822b;

    /* renamed from: c  reason: collision with root package name */
    public d.e.c.c f69823c;

    /* renamed from: d  reason: collision with root package name */
    public int f69824d;

    /* renamed from: e  reason: collision with root package name */
    public d.e.b.e f69825e;

    /* renamed from: f  reason: collision with root package name */
    public d.e.b.a f69826f;

    /* renamed from: g  reason: collision with root package name */
    public d.e.b.c f69827g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f69828h;
    public boolean j;
    public boolean k;
    public int l;
    public InterfaceC1904d m;
    public int p;
    public int q;
    public int r;
    public int s;
    public g t;
    public c u;
    public final Object v;
    public boolean w;
    public final Object x;
    public boolean y;
    public boolean z;

    /* renamed from: i  reason: collision with root package name */
    public Object f69829i = new Object();
    public long n = 0;
    public long o = 0;

    /* loaded from: classes6.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            synchronized (d.this.v) {
                while (!d.this.w) {
                    try {
                        d.this.v.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            d.this.w = false;
            try {
                d.e.b.b bVar = new d.e.b.b();
                if (bVar.a() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d.e.b.b.f69812e);
                    bVar.e();
                    d.this.l = 1;
                    while (!d.this.A) {
                        allocateDirect.clear();
                        int c2 = bVar.c(allocateDirect, d.e.b.b.f69812e);
                        if (c2 > 0) {
                            allocateDirect.position(c2);
                            allocateDirect.flip();
                            d.this.f69826f.b(allocateDirect, c2, d.this.u());
                            d.this.f69826f.a();
                        }
                    }
                    d.this.f69826f.b(null, 0, d.this.u());
                    bVar.f();
                    bVar.d();
                    d.this.f69826f.c();
                } else {
                    Log.e("TextureMovieEncoder", "failed to initialize AudioRecord");
                }
            } catch (Exception e3) {
                Log.e("TextureMovieEncoder", "AudioThread#run", e3);
            }
            synchronized (d.this.x) {
                d.this.y = true;
                d.this.x.notify();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final File f69831a;

        /* renamed from: b  reason: collision with root package name */
        public final int f69832b;

        /* renamed from: c  reason: collision with root package name */
        public final int f69833c;

        /* renamed from: d  reason: collision with root package name */
        public final int f69834d;

        /* renamed from: e  reason: collision with root package name */
        public final EGLContext f69835e;

        /* renamed from: f  reason: collision with root package name */
        public final long f69836f;

        public c(File file, int i2, int i3, int i4, EGLContext eGLContext, long j) {
            this.f69831a = file;
            this.f69832b = i2;
            this.f69833c = i3;
            this.f69834d = i4;
            if (eGLContext != null) {
                this.f69835e = eGLContext;
            } else {
                this.f69835e = EGL14.eglGetCurrentContext();
            }
            this.f69836f = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.f69832b + "x" + this.f69833c + CoroutineContextKt.DEBUG_THREAD_NAME_SEPARATOR + this.f69834d + " to '" + this.f69831a.toString() + "' ctxt=" + this.f69835e;
        }
    }

    /* renamed from: d.e.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1904d {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d> f69837a;

        public e(d dVar) {
            this.f69837a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            Object obj = message.obj;
            d dVar = this.f69837a.get();
            if (dVar == null) {
                Log.w("TextureMovieEncoder", "VideoEncoderHandler.handleMessage: encoder is null");
            } else if (i2 == 0) {
                dVar.x((c) obj);
            } else if (i2 == 1) {
                dVar.y();
            } else if (i2 == 2) {
                if (dVar.z) {
                    dVar.v((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                }
            } else if (i2 == 3) {
                if (dVar.z) {
                    dVar.w(message.arg1);
                }
            } else if (i2 == 4) {
                if (dVar.z) {
                    dVar.z((EGLContext) message.obj);
                }
            } else if (i2 == 5) {
                Looper.myLooper().quit();
            } else {
                throw new RuntimeException("Unhandled msg what=" + i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends Thread {
        public f(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (d.this.f69829i) {
                d.this.f69828h = new e(d.this);
                d.this.j = true;
                d.this.f69829i.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.f69829i) {
                d dVar = d.this;
                d.this.k = false;
                dVar.j = false;
                d.this.f69828h = null;
            }
        }
    }

    public d() {
        this.l = 4;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.t = kVar.get();
        }
        this.u = null;
        this.v = new Object();
        this.w = false;
        this.x = new Object();
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = 0L;
        this.l = 2;
    }

    public final void A(EGLContext eGLContext, int i2, int i3, int i4, File file) {
        try {
            d.e.b.c cVar = new d.e.b.c(file.toString());
            this.f69827g = cVar;
            this.f69825e = new d.e.b.e(i2, i3, i4, cVar);
            this.f69826f = new d.e.b.a(this.f69827g);
            this.z = true;
            synchronized (this.v) {
                this.w = true;
                this.v.notify();
            }
        } catch (IOException e2) {
            g gVar = this.t;
            if (gVar != null) {
                gVar.b(12, d.a.n0.u1.a.a(e2));
            }
        } catch (IllegalStateException e3) {
            this.z = false;
            g gVar2 = this.t;
            if (gVar2 != null) {
                gVar2.b(13, d.a.n0.u1.a.a(e3));
                return;
            }
            return;
        }
        d.e.c.a aVar = new d.e.c.a(eGLContext, 1);
        this.f69822b = aVar;
        d.e.c.e eVar = new d.e.c.e(aVar, this.f69825e.b(), true);
        this.f69821a = eVar;
        eVar.b();
        this.f69823c = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    public final void B() {
        try {
            this.f69825e.c();
            if (this.f69821a != null) {
                this.f69821a.g();
                this.f69821a = null;
            }
            if (this.f69823c != null) {
                this.f69823c.c(false);
                this.f69823c = null;
            }
            if (this.f69822b != null) {
                this.f69822b.e();
                this.f69822b = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            g gVar = this.t;
            if (gVar != null) {
                gVar.b(14, d.a.n0.u1.a.a(e2));
            }
        }
    }

    public void C(InterfaceC1904d interfaceC1904d) {
        this.m = interfaceC1904d;
    }

    public void D(d.e.c.c cVar, int i2, float[] fArr) {
        if (this.p != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.q);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.p, 0);
            GLES20.glViewport(0, 0, this.r, this.s);
            if (cVar != null) {
                cVar.b(i2, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.f69829i) {
                if (this.j) {
                    this.f69828h.sendMessage(this.f69828h.obtainMessage(3, this.p, 0, null));
                }
            }
        }
    }

    public void E(c cVar) {
        this.r = cVar.f69832b;
        this.s = cVar.f69833c;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        this.p = i2;
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.r, this.s, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.q = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.l = 5;
        this.n = cVar.f69836f;
        this.o = System.nanoTime();
        synchronized (this.f69829i) {
            if (this.k) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.k = true;
            new f("TextureMovieVideoEncoder").start();
            new b().start();
            while (!this.j) {
                try {
                    this.f69829i.wait();
                } catch (InterruptedException unused) {
                }
            }
            this.f69828h.sendMessage(this.f69828h.obtainMessage(0, cVar));
        }
    }

    public void F() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.q}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.p}, 0);
        this.q = 0;
        this.p = 0;
        d.e.b.c cVar = this.f69827g;
        if (cVar == null || !cVar.b()) {
            this.A = true;
            d.e.b.e eVar = this.f69825e;
            if (eVar != null) {
                eVar.d();
            }
        }
        this.l = 4;
        this.f69828h.sendMessage(this.f69828h.obtainMessage(1));
        this.f69828h.sendMessage(this.f69828h.obtainMessage(5));
    }

    public boolean s(int i2) {
        return this.l == i2;
    }

    public void t(SurfaceTexture surfaceTexture) {
        synchronized (this.f69829i) {
            if (this.j) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.f69828h.sendMessage(this.f69828h.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                }
            }
        }
    }

    public long u() {
        long nanoTime = System.nanoTime();
        if (this.n != 0) {
            if (this.o == 0) {
                this.o = nanoTime;
            }
            nanoTime = (nanoTime - this.o) + this.n;
        }
        long j = nanoTime / 1000;
        long j2 = this.B;
        if (j < j2) {
            j += j2 - j;
        }
        if (j == this.B) {
            j += 100;
        }
        this.B = j;
        return j;
    }

    public final void v(float[] fArr, long j) {
        if (this.p != 0) {
            try {
                this.f69825e.a(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c cVar = this.u;
            GLES20.glViewport(0, 0, cVar.f69832b, cVar.f69833c);
            synchronized (d.class) {
                this.f69823c.b(this.f69824d, fArr);
            }
            d.e.c.e eVar = this.f69821a;
            if (eVar != null) {
                eVar.d(u() * 1000);
                this.f69821a.e();
            }
        }
    }

    public final void w(int i2) {
        this.f69824d = i2;
    }

    public final void x(c cVar) {
        Log.d("TextureMovieEncoder", "handleStartRecording " + cVar);
        this.u = cVar;
        A(cVar.f69835e, cVar.f69832b, cVar.f69833c, cVar.f69834d, cVar.f69831a);
        this.A = false;
        InterfaceC1904d interfaceC1904d = this.m;
        if (interfaceC1904d != null) {
            interfaceC1904d.a();
        }
    }

    public final void y() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.f69825e.a(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.A = true;
        B();
        Log.e("TextureMovieEncoder", "handleStopRecording before stop success");
        while (!this.y) {
            synchronized (this.x) {
                try {
                    this.x.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
        }
        this.y = false;
        InterfaceC1904d interfaceC1904d = this.m;
        if (interfaceC1904d != null) {
            interfaceC1904d.b();
        }
    }

    public final void z(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        d.e.c.e eVar = this.f69821a;
        if (eVar != null) {
            eVar.c();
        }
        this.f69823c.c(false);
        d.e.c.a aVar = this.f69822b;
        if (aVar != null) {
            aVar.e();
        }
        d.e.c.a aVar2 = new d.e.c.a(eGLContext, 1);
        this.f69822b = aVar2;
        d.e.c.e eVar2 = this.f69821a;
        if (eVar2 != null) {
            eVar2.f(aVar2);
            this.f69821a.b();
        }
        this.f69823c = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }
}
