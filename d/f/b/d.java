package d.f.b;

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
import d.b.j0.t1.g;
import d.b.j0.t1.k;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes6.dex */
public class d {
    public boolean A;
    public long B;

    /* renamed from: a  reason: collision with root package name */
    public d.f.c.e f66951a;

    /* renamed from: b  reason: collision with root package name */
    public d.f.c.a f66952b;

    /* renamed from: c  reason: collision with root package name */
    public d.f.c.c f66953c;

    /* renamed from: d  reason: collision with root package name */
    public int f66954d;

    /* renamed from: e  reason: collision with root package name */
    public d.f.b.e f66955e;

    /* renamed from: f  reason: collision with root package name */
    public d.f.b.a f66956f;

    /* renamed from: g  reason: collision with root package name */
    public d.f.b.c f66957g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f66958h;
    public boolean j;
    public boolean k;
    public int l;
    public InterfaceC1837d m;
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
    public Object i = new Object();
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
                d.f.b.b bVar = new d.f.b.b();
                if (bVar.a() != null) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d.f.b.b.f66942e);
                    bVar.e();
                    d.this.l = 1;
                    while (!d.this.A) {
                        allocateDirect.clear();
                        int c2 = bVar.c(allocateDirect, d.f.b.b.f66942e);
                        if (c2 > 0) {
                            allocateDirect.position(c2);
                            allocateDirect.flip();
                            d.this.f66956f.b(allocateDirect, c2, d.this.u());
                            d.this.f66956f.a();
                        }
                    }
                    d.this.f66956f.b(null, 0, d.this.u());
                    bVar.f();
                    bVar.d();
                    d.this.f66956f.c();
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
        public final File f66960a;

        /* renamed from: b  reason: collision with root package name */
        public final int f66961b;

        /* renamed from: c  reason: collision with root package name */
        public final int f66962c;

        /* renamed from: d  reason: collision with root package name */
        public final int f66963d;

        /* renamed from: e  reason: collision with root package name */
        public final EGLContext f66964e;

        /* renamed from: f  reason: collision with root package name */
        public final long f66965f;

        public c(File file, int i, int i2, int i3, EGLContext eGLContext, long j) {
            this.f66960a = file;
            this.f66961b = i;
            this.f66962c = i2;
            this.f66963d = i3;
            if (eGLContext != null) {
                this.f66964e = eGLContext;
            } else {
                this.f66964e = EGL14.eglGetCurrentContext();
            }
            this.f66965f = j;
        }

        public String toString() {
            return "EncoderConfig: " + this.f66961b + "x" + this.f66962c + " @" + this.f66963d + " to '" + this.f66960a.toString() + "' ctxt=" + this.f66964e;
        }
    }

    /* renamed from: d.f.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1837d {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d> f66966a;

        public e(d dVar) {
            this.f66966a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.f66966a.get();
            if (dVar == null) {
                Log.w("TextureMovieEncoder", "VideoEncoderHandler.handleMessage: encoder is null");
            } else if (i == 0) {
                dVar.x((c) obj);
            } else if (i == 1) {
                dVar.y();
            } else if (i == 2) {
                if (dVar.z) {
                    dVar.v((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                }
            } else if (i == 3) {
                if (dVar.z) {
                    dVar.w(message.arg1);
                }
            } else if (i == 4) {
                if (dVar.z) {
                    dVar.z((EGLContext) message.obj);
                }
            } else if (i == 5) {
                Looper.myLooper().quit();
            } else {
                throw new RuntimeException("Unhandled msg what=" + i);
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
            synchronized (d.this.i) {
                d.this.f66958h = new e(d.this);
                d.this.j = true;
                d.this.i.notify();
            }
            Looper.loop();
            Log.d("TextureMovieEncoder", "Encoder thread exiting");
            synchronized (d.this.i) {
                d dVar = d.this;
                d.this.k = false;
                dVar.j = false;
                d.this.f66958h = null;
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

    public final void A(EGLContext eGLContext, int i, int i2, int i3, File file) {
        try {
            d.f.b.c cVar = new d.f.b.c(file.toString());
            this.f66957g = cVar;
            this.f66955e = new d.f.b.e(i, i2, i3, cVar);
            this.f66956f = new d.f.b.a(this.f66957g);
            this.z = true;
            synchronized (this.v) {
                this.w = true;
                this.v.notify();
            }
        } catch (IOException e2) {
            g gVar = this.t;
            if (gVar != null) {
                gVar.c(12, d.b.j0.t1.a.a(e2));
            }
        } catch (IllegalStateException e3) {
            this.z = false;
            g gVar2 = this.t;
            if (gVar2 != null) {
                gVar2.c(13, d.b.j0.t1.a.a(e3));
                return;
            }
            return;
        }
        d.f.c.a aVar = new d.f.c.a(eGLContext, 1);
        this.f66952b = aVar;
        d.f.c.e eVar = new d.f.c.e(aVar, this.f66955e.b(), true);
        this.f66951a = eVar;
        eVar.b();
        this.f66953c = new d.f.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }

    public final void B() {
        try {
            this.f66955e.c();
            if (this.f66951a != null) {
                this.f66951a.g();
                this.f66951a = null;
            }
            if (this.f66953c != null) {
                this.f66953c.c(false);
                this.f66953c = null;
            }
            if (this.f66952b != null) {
                this.f66952b.e();
                this.f66952b = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            g gVar = this.t;
            if (gVar != null) {
                gVar.c(14, d.b.j0.t1.a.a(e2));
            }
        }
    }

    public void C(InterfaceC1837d interfaceC1837d) {
        this.m = interfaceC1837d;
    }

    public void D(d.f.c.c cVar, int i, float[] fArr) {
        if (this.p != 0) {
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            GLES20.glBindFramebuffer(36160, this.q);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.p, 0);
            GLES20.glViewport(0, 0, this.r, this.s);
            if (cVar != null) {
                cVar.b(i, fArr);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            synchronized (this.i) {
                if (this.j) {
                    this.f66958h.sendMessage(this.f66958h.obtainMessage(3, this.p, 0, null));
                }
            }
        }
    }

    public void E(c cVar) {
        this.r = cVar.f66961b;
        this.s = cVar.f66962c;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.p = i;
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, this.r, this.s, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.q = iArr2[0];
        Log.d("TextureMovieEncoder", "Encoder: startRecording()");
        this.l = 5;
        this.n = cVar.f66965f;
        this.o = System.nanoTime();
        synchronized (this.i) {
            if (this.k) {
                Log.w("TextureMovieEncoder", "Encoder thread already running");
                return;
            }
            this.k = true;
            new f("TextureMovieVideoEncoder").start();
            new b().start();
            while (!this.j) {
                try {
                    this.i.wait();
                } catch (InterruptedException unused) {
                }
            }
            this.f66958h.sendMessage(this.f66958h.obtainMessage(0, cVar));
        }
    }

    public void F() {
        GLES20.glDeleteFramebuffers(1, new int[]{this.q}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.p}, 0);
        this.q = 0;
        this.p = 0;
        d.f.b.c cVar = this.f66957g;
        if (cVar == null || !cVar.b()) {
            this.A = true;
            d.f.b.e eVar = this.f66955e;
            if (eVar != null) {
                eVar.d();
            }
        }
        this.l = 4;
        this.f66958h.sendMessage(this.f66958h.obtainMessage(1));
        this.f66958h.sendMessage(this.f66958h.obtainMessage(5));
    }

    public boolean s(int i) {
        return this.l == i;
    }

    public void t(SurfaceTexture surfaceTexture) {
        synchronized (this.i) {
            if (this.j) {
                float[] fArr = new float[16];
                Matrix.setIdentityM(fArr, 0);
                long timestamp = surfaceTexture.getTimestamp();
                if (timestamp == 0) {
                    Log.w("TextureMovieEncoder", "HEY: got SurfaceTexture with timestamp of zero");
                } else {
                    this.f66958h.sendMessage(this.f66958h.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
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
                this.f66955e.a(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c cVar = this.u;
            GLES20.glViewport(0, 0, cVar.f66961b, cVar.f66962c);
            synchronized (d.class) {
                this.f66953c.b(this.f66954d, fArr);
            }
            d.f.c.e eVar = this.f66951a;
            if (eVar != null) {
                eVar.d(u() * 1000);
                this.f66951a.e();
            }
        }
    }

    public final void w(int i) {
        this.f66954d = i;
    }

    public final void x(c cVar) {
        Log.d("TextureMovieEncoder", "handleStartRecording " + cVar);
        this.u = cVar;
        A(cVar.f66964e, cVar.f66961b, cVar.f66962c, cVar.f66963d, cVar.f66960a);
        this.A = false;
        InterfaceC1837d interfaceC1837d = this.m;
        if (interfaceC1837d != null) {
            interfaceC1837d.b();
        }
    }

    public final void y() {
        Log.d("TextureMovieEncoder", "handleStopRecording");
        try {
            this.f66955e.a(true);
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
        InterfaceC1837d interfaceC1837d = this.m;
        if (interfaceC1837d != null) {
            interfaceC1837d.a();
        }
    }

    public final void z(EGLContext eGLContext) {
        Log.d("TextureMovieEncoder", "handleUpdatedSharedContext " + eGLContext);
        d.f.c.e eVar = this.f66951a;
        if (eVar != null) {
            eVar.c();
        }
        this.f66953c.c(false);
        d.f.c.a aVar = this.f66952b;
        if (aVar != null) {
            aVar.e();
        }
        d.f.c.a aVar2 = new d.f.c.a(eGLContext, 1);
        this.f66952b = aVar2;
        d.f.c.e eVar2 = this.f66951a;
        if (eVar2 != null) {
            eVar2.f(aVar2);
            this.f66951a.b();
        }
        this.f66953c = new d.f.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
    }
}
