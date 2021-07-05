package d.a.y0.p.f;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.EglCore;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.faceunity.gles.WindowSurface;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.faceunity.encoder.TextureMovieEncoder;
import com.faceunity.gles.GeneratedTexture;
import d.a.y0.t.m;
import d.a.y0.t.s;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import kotlinx.coroutines.CoroutineContextKt;
@TargetApi(18)
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public d.a.y0.p.g.c B;
    public boolean C;
    public boolean D;
    public d.a.y0.f.b.a E;
    public boolean F;
    public f G;
    public d H;
    public final Object I;
    public boolean J;
    public final Object K;
    public boolean L;
    public String M;
    public boolean N;
    public volatile boolean O;
    public long P;
    public long Q;
    public volatile long R;

    /* renamed from: a  reason: collision with root package name */
    public WindowSurface f71372a;

    /* renamed from: b  reason: collision with root package name */
    public EglCore f71373b;

    /* renamed from: c  reason: collision with root package name */
    public FullFrameRect f71374c;

    /* renamed from: d  reason: collision with root package name */
    public int f71375d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.y0.p.f.e f71376e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.y0.p.f.b f71377f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.y0.p.f.d f71378g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f71379h;

    /* renamed from: i  reason: collision with root package name */
    public Object f71380i;
    public boolean j;
    public boolean k;
    public int l;
    public b m;
    public e n;
    public volatile long o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public int s;
    public int t;
    public int u;
    public volatile boolean v;
    public float w;
    public float x;
    public long y;
    public long z;

    /* renamed from: d.a.y0.p.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1980a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public interface b {
        void b(long j);

        void onError(int i2, String str);

        void onStartSuccess();

        @WorkerThread
        void onStopSuccess();
    }

    /* loaded from: classes9.dex */
    public class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f71381e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71381e = aVar;
        }

        public /* synthetic */ c(a aVar, C1980a c1980a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.a.y0.p.f.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                int i2 = RecordConstants.MOVIE_ENCODE_SAMPLE_RATE;
                d.a.y0.g.a aVar = (d.a.y0.g.a) s.a("com.baidu.ugc.audioedit.AudioSpeedOperator");
                if (aVar != null) {
                    aVar.init(i2, 1);
                    aVar.setSpeed(this.f71381e.w);
                }
                synchronized (this.f71381e.I) {
                    while (!this.f71381e.J) {
                        try {
                            this.f71381e.I.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                try {
                    d.a.y0.p.f.c cVar = new d.a.y0.p.f.c(this.f71381e.A);
                    if (cVar.d() != null) {
                        this.f71381e.v = true;
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d.a.y0.p.f.c.f71399d);
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(10240);
                        cVar.c();
                        if (cVar.e() != 3) {
                            a aVar2 = this.f71381e;
                            aVar2.e(1114, "音频开始录制失败 " + cVar.e());
                            cVar.b();
                            this.f71381e.f71377f.d();
                            return;
                        }
                        this.f71381e.l = 1;
                        while (!this.f71381e.O) {
                            try {
                                allocateDirect.clear();
                                allocateDirect2.clear();
                                int a2 = cVar.a(allocateDirect, d.a.y0.p.f.c.f71399d);
                                if (this.f71381e.C && this.f71381e.B != null) {
                                    double a3 = d.a.y0.p.i.a.a(allocateDirect, a2);
                                    if (a3 > 0.0d) {
                                        this.f71381e.B.a(a3);
                                    }
                                }
                                if (a2 > 0) {
                                    if (aVar == null) {
                                        allocateDirect.position(a2);
                                        allocateDirect.flip();
                                        this.f71381e.f71377f.b(allocateDirect, 0, a2, this.f71381e.G());
                                        bVar = this.f71381e.f71377f;
                                    } else {
                                        byte[] bArr = new byte[a2];
                                        allocateDirect.get(bArr);
                                        aVar.putBytes(bArr, a2);
                                        allocateDirect.position(a2);
                                        allocateDirect.flip();
                                        int availableBytes = aVar.availableBytes();
                                        if (availableBytes > 0) {
                                            byte[] bArr2 = new byte[availableBytes];
                                            aVar.receiveBytes(bArr2, availableBytes);
                                            if (this.f71381e.D) {
                                                byte[] k = d.a.y0.l.d.g.k(bArr2, 4.0d);
                                                if (k != null) {
                                                    availableBytes = k.length;
                                                }
                                                allocateDirect2.put(k);
                                            } else {
                                                allocateDirect2.put(bArr2);
                                            }
                                            int i3 = availableBytes;
                                            allocateDirect2.position(i3);
                                            allocateDirect2.flip();
                                            this.f71381e.f71377f.b(allocateDirect2, 0, i3, this.f71381e.G());
                                            bVar = this.f71381e.f71377f;
                                        }
                                    }
                                    bVar.c();
                                }
                            } finally {
                                cVar.b();
                            }
                        }
                        this.f71381e.f71377f.b(null, 0, 0, this.f71381e.G());
                        this.f71381e.f71377f.c();
                        cVar.b();
                        this.f71381e.f71377f.d();
                    } else {
                        d.a.y0.t.c.e(TextureMovieEncoder.TAG, "failed to initialize AudioRecord");
                    }
                } catch (Exception e3) {
                    d.a.y0.t.c.f(TextureMovieEncoder.TAG, "AudioThread#run", e3);
                    d.a.y0.t.c.g(e3);
                    if (this.f71381e.l != 6) {
                        this.f71381e.l = 6;
                        String message = e3.getMessage();
                        a aVar3 = this.f71381e;
                        aVar3.e(1115, "结束音频编码错误" + message);
                    }
                }
                synchronized (this.f71381e.K) {
                    this.f71381e.L = true;
                    this.f71381e.K.notifyAll();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final File f71382a;

        /* renamed from: b  reason: collision with root package name */
        public final int f71383b;

        /* renamed from: c  reason: collision with root package name */
        public final int f71384c;

        /* renamed from: d  reason: collision with root package name */
        public final int f71385d;

        /* renamed from: e  reason: collision with root package name */
        public final EGLContext f71386e;

        /* renamed from: f  reason: collision with root package name */
        public final long f71387f;

        /* renamed from: g  reason: collision with root package name */
        public int f71388g;

        public d(File file, int i2, int i3, int i4, int i5, EGLContext eGLContext, long j, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), eGLContext, Long.valueOf(j), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71388g = 10000;
            this.f71382a = file;
            this.f71383b = i2;
            this.f71384c = i3;
            this.f71385d = i4;
            if (eGLContext != null) {
                this.f71386e = eGLContext;
            } else {
                this.f71386e = EGL14.eglGetCurrentContext();
            }
            this.f71387f = j;
            this.f71388g = i6;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "EncoderConfig: " + this.f71383b + "x" + this.f71384c + CoroutineContextKt.DEBUG_THREAD_NAME_SEPARATOR + this.f71385d + " to '" + this.f71382a.toString() + "' ctxt=" + this.f71386e;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(long j);
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes9.dex */
    public static class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f71389a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71389a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                Object obj = message.obj;
                a aVar = this.f71389a.get();
                if (aVar == null) {
                    d.a.y0.t.c.l(TextureMovieEncoder.TAG, "VideoEncoderHandler.handleMessage: encoder is null");
                } else if (i2 == 0) {
                    aVar.C((d) obj);
                } else if (i2 == 1) {
                    aVar.P();
                } else if (i2 == 2) {
                    if (aVar.N) {
                        aVar.t((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                    }
                } else if (i2 == 3) {
                    if (aVar.N) {
                        aVar.H(message.arg1);
                    }
                } else if (i2 == 4) {
                    if (aVar.N) {
                        aVar.g((EGLContext) message.obj);
                    }
                } else if (i2 == 5) {
                    Looper.myLooper().quit();
                } else {
                    throw new RuntimeException("Unhandled msg what=" + i2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f71390e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a aVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71390e = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                synchronized (this.f71390e.f71380i) {
                    this.f71390e.f71379h = new g(this.f71390e);
                    this.f71390e.j = true;
                    this.f71390e.f71380i.notifyAll();
                }
                Looper.loop();
                d.a.y0.t.c.c(TextureMovieEncoder.TAG, "Encoder thread exiting");
                synchronized (this.f71390e.f71380i) {
                    a aVar = this.f71390e;
                    this.f71390e.k = false;
                    aVar.j = false;
                    this.f71390e.f71379h = null;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-310299499, "Ld/a/y0/p/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-310299499, "Ld/a/y0/p/f/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71380i = new Object();
        this.l = 4;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.v = false;
        this.w = 1.0f;
        this.x = 0.0f;
        this.y = -1L;
        this.z = 0L;
        this.A = -100;
        this.E = null;
        this.H = null;
        this.I = new Object();
        this.J = false;
        this.K = new Object();
        this.L = false;
        this.M = null;
        this.N = false;
        this.O = false;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        this.l = 2;
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.x = f2;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.A = i2;
        }
    }

    public final void C(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            d.a.y0.t.c.c(TextureMovieEncoder.TAG, "handleStartRecording " + dVar);
            this.H = dVar;
            d.a.y0.m.a aVar = new d.a.y0.m.a();
            if (w(dVar.f71386e, dVar.f71383b, dVar.f71384c, dVar.f71385d, dVar.f71382a, aVar)) {
                this.O = false;
                b bVar = this.m;
                if (bVar != null) {
                    bVar.onStartSuccess();
                }
            } else if (this.l != 6) {
                this.l = 6;
                String str = aVar.f71285e;
                e(1111, "开始录制编码错误" + dVar.toString() + " , 错误信息：" + str);
            }
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.C = z;
        }
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.w == 1.0f) {
                return M();
            }
            long nanoTime = System.nanoTime();
            if (this.o != 0) {
                if (this.r == 0) {
                    this.r = nanoTime;
                }
                nanoTime = (((float) (nanoTime - this.r)) / this.w) + this.o;
            }
            long j = nanoTime / 1000;
            long j2 = this.Q;
            if (j < j2) {
                j = 100 + j2;
            }
            this.Q = j;
            return j;
        }
        return invokeV.longValue;
    }

    public final void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f71375d = i2;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.D = z;
        }
    }

    public long M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long nanoTime = System.nanoTime();
            if (this.o != 0) {
                if (this.p == 0) {
                    this.p = nanoTime;
                }
                nanoTime = (((float) (nanoTime - this.p)) / this.w) + this.o;
            }
            long j = nanoTime / 1000;
            if (j < this.R) {
                j = this.R + 100;
            }
            this.R = j;
            return j;
        }
        return invokeV.longValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.y0.t.c.c(TextureMovieEncoder.TAG, "handleStopRecording");
            this.O = true;
            try {
                this.f71376e.c(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Q();
            d.a.y0.t.c.e(TextureMovieEncoder.TAG, "handleStopRecording before stop success");
            while (!this.L && this.v) {
                synchronized (this.K) {
                    try {
                        this.K.wait();
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            long a2 = d.a.y0.n.a.a(this.M);
            e eVar = this.n;
            if (eVar != null) {
                eVar.a(a2);
            }
            this.L = false;
            b bVar = this.m;
            if (bVar != null) {
                bVar.onStopSuccess();
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.f71376e.d();
                if (this.f71372a != null) {
                    this.f71372a.release();
                    this.f71372a = null;
                }
                if (this.f71374c != null) {
                    this.f71374c.release(false);
                    this.f71374c = null;
                }
                if (this.f71373b != null) {
                    this.f71373b.release();
                    this.f71373b = null;
                }
            } catch (Exception e2) {
                d.a.y0.t.c.g(e2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f71380i) {
                while (!this.j) {
                    try {
                        this.f71380i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            this.s = 0;
            d.a.y0.p.f.d dVar = this.f71378g;
            if (dVar == null || !dVar.e()) {
                this.O = true;
                d.a.y0.p.f.e eVar = this.f71376e;
                if (eVar != null) {
                    eVar.e();
                }
                d.a.y0.p.f.b bVar = this.f71377f;
                if (bVar != null) {
                    bVar.a();
                }
            }
            this.l = 4;
            this.f71379h.sendMessage(this.f71379h.obtainMessage(1));
            this.f71379h.sendMessage(this.f71379h.obtainMessage(5));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r5 < 0.33333334f) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || f2 == this.w) {
            return;
        }
        float f3 = f2 <= 3.0f ? 0.33333334f : 3.0f;
        this.w = f3;
        this.w = f2;
    }

    public final void e(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            c();
            b bVar = this.m;
            if (bVar != null) {
                bVar.onError(i2, str);
            }
        }
    }

    public void f(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceTexture) == null) {
            synchronized (this.f71380i) {
                if (this.j) {
                    synchronized (this.I) {
                        if (!this.J && this.N) {
                            this.J = true;
                            this.I.notifyAll();
                            this.l = 1;
                            if (this.G != null) {
                                this.G.a();
                            }
                        }
                    }
                    if (this.J) {
                        float[] fArr = new float[16];
                        Matrix.setIdentityM(fArr, 0);
                        long timestamp = surfaceTexture.getTimestamp();
                        if (timestamp == 0) {
                            d.a.y0.t.c.l(TextureMovieEncoder.TAG, "HEY: got SurfaceTexture with timestamp of zero");
                        } else {
                            this.f71379h.sendMessage(this.f71379h.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                        }
                    }
                }
            }
        }
    }

    public final void g(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eGLContext) == null) {
            d.a.y0.t.c.c(TextureMovieEncoder.TAG, "handleUpdatedSharedContext " + eGLContext);
            WindowSurface windowSurface = this.f71372a;
            if (windowSurface != null) {
                windowSurface.releaseEglSurface();
            }
            this.f71374c.release(false);
            EglCore eglCore = this.f71373b;
            if (eglCore != null) {
                eglCore.release();
            }
            EglCore eglCore2 = new EglCore(eGLContext, 2);
            this.f71373b = eglCore2;
            WindowSurface windowSurface2 = this.f71372a;
            if (windowSurface2 != null) {
                windowSurface2.recreate(eglCore2);
                this.f71372a.makeCurrent();
            }
            this.f71374c = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        }
    }

    public void h(FullFrameRect fullFrameRect, int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048591, this, fullFrameRect, i2, fArr) == null) || this.s == 0) {
            return;
        }
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        GLES20.glBindFramebuffer(36160, iArr2[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.s, 0);
        GLES20.glViewport(0, 0, this.t, this.u);
        if (fullFrameRect != null) {
            try {
                fullFrameRect.drawFrame(i2, fArr);
            } catch (Exception e2) {
                e(1112, "setTextureId错误fuTex:" + i2 + "---" + e2.toString());
            }
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr2, 0);
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        synchronized (this.f71380i) {
            if (this.j) {
                this.f71379h.sendMessage(this.f71379h.obtainMessage(3, this.s, 0, null));
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.t = dVar.f71383b;
            this.u = dVar.f71384c;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            this.s = i2;
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.t, this.u, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            this.l = 5;
            this.o = dVar.f71387f;
            this.p = System.nanoTime();
            this.q = 0L;
            this.r = 0L;
            synchronized (this.f71380i) {
                if (this.k) {
                    d.a.y0.t.c.l(TextureMovieEncoder.TAG, "Encoder thread already running");
                    if (this.l != 6) {
                        this.l = 6;
                        e(1113, "录制编码调起错误" + dVar.toString());
                    }
                    return;
                }
                this.k = true;
                new h(this, "TextureMovieVideoEncoder").start();
                new c(this, null).start();
                while (!this.j) {
                    try {
                        this.f71380i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                this.y = -1L;
                this.f71379h.sendMessage(this.f71379h.obtainMessage(0, dVar));
            }
        }
    }

    public void k(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.G = fVar;
        }
    }

    public void r(d.a.y0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.B = cVar;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.F = z;
        }
    }

    public final void t(float[] fArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, fArr, j) == null) {
            d.a.y0.f.b.a aVar = this.E;
            if (aVar != null) {
                aVar.b();
            }
            if (this.s != 0) {
                try {
                    this.f71376e.c(false);
                } catch (Exception e2) {
                    d.a.y0.t.c.g(e2);
                    if (this.l != 6) {
                        this.l = 6;
                        String message = e2.getMessage();
                        e(FeatureCodes.SPLIT_FILTER, "录制编码错误transform:" + fArr + "timestampNanos:" + j + " , Exception : " + message);
                    }
                }
                d dVar = this.H;
                GLES20.glViewport(0, 0, dVar.f71383b, dVar.f71384c);
                synchronized (a.class) {
                    if (this.x != 0.0f) {
                        this.f71374c.setAngle(this.x);
                    }
                    this.f71374c.drawFrame(this.f71375d, fArr);
                }
                if (this.f71372a != null) {
                    long z = z();
                    if (this.y == -1) {
                        this.y = z;
                        this.z = 0L;
                    }
                    this.f71372a.setPresentationTime(z * 1000);
                    this.f71372a.swapBuffers();
                    long j2 = z - this.y;
                    this.z = j2;
                    e eVar = this.n;
                    if (eVar != null) {
                        eVar.a(j2 / 1000);
                    }
                }
            }
        }
    }

    public boolean u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? this.l == i2 : invokeI.booleanValue;
    }

    public final boolean v(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        String str2;
        File file;
        MediaMuxer mediaMuxer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048600, this, i2, i3, str)) == null) {
            MediaMuxer mediaMuxer2 = null;
            try {
                if (m.m("video/hevc") != null) {
                    str2 = str + File.separator + System.currentTimeMillis() + "_checkHevc.mp4";
                    try {
                        try {
                            mediaMuxer = new MediaMuxer(str2, 0);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        mediaMuxer.addTrack(MediaFormat.createVideoFormat("video/hevc", i2, i3));
                        mediaMuxer2 = mediaMuxer;
                    } catch (Exception e3) {
                        e = e3;
                        mediaMuxer2 = mediaMuxer;
                        e.printStackTrace();
                        this.F = false;
                        if (mediaMuxer2 != null) {
                            try {
                                mediaMuxer2.release();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            file = new File(str2);
                            d.a.c0.a.j.e.d(file);
                        }
                        return this.F;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaMuxer2 = mediaMuxer;
                        if (mediaMuxer2 != null) {
                            try {
                                mediaMuxer2.release();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            d.a.c0.a.j.e.d(new File(str2));
                        }
                        throw th;
                    }
                } else {
                    str2 = null;
                }
                if (mediaMuxer2 != null) {
                    try {
                        mediaMuxer2.release();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (Exception e7) {
                e = e7;
                str2 = null;
            } catch (Throwable th3) {
                th = th3;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                file = new File(str2);
                d.a.c0.a.j.e.d(file);
            }
            return this.F;
        }
        return invokeIIL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0093 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.IllegalStateException] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean w(EGLContext eGLContext, int i2, int i3, int i4, File file, d.a.y0.m.a aVar) {
        InterceptResult invokeCommon;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{eGLContext, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), file, aVar})) == null) {
            try {
                if (this.D) {
                    RecordConstants.MOVIE_ENCODE_SAMPLE_RATE = 16000;
                    d.a.y0.p.f.c.f71398c = 16000;
                    RecordConstants.AUDIO_ENCODE_SAMPLE_RATE = 16000;
                } else {
                    RecordConstants.MOVIE_ENCODE_SAMPLE_RATE = 44100;
                    RecordConstants.AUDIO_ENCODE_SAMPLE_RATE = 44100;
                    d.a.y0.p.f.c.f71398c = 44100;
                }
                this.M = file.toString();
                this.f71378g = new d.a.y0.p.f.d(file.toString());
                if (this.F && Build.VERSION.SDK_INT <= 23) {
                    this.F = v(i2, i3, new File(file.toString()).getParent());
                }
                d.a.y0.p.f.e eVar = new d.a.y0.p.f.e(i2, i3, i4, this.F, this.f71378g);
                this.f71376e = eVar;
                eVar.b(this.H.f71388g);
                this.f71377f = new d.a.y0.p.f.b(this.f71378g);
                this.N = true;
                EglCore eglCore = new EglCore(eGLContext, 2);
                this.f71373b = eglCore;
                WindowSurface windowSurface = new WindowSurface(eglCore, this.f71376e.a(), true);
                this.f71372a = windowSurface;
                windowSurface.makeCurrent();
                this.f71374c = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                return true;
            } catch (IOException e2) {
                if (aVar != null && !TextUtils.isEmpty(e2.getMessage())) {
                    aVar.f71285e = e2.getMessage();
                }
                d.a.y0.t.c.g(e2);
                return false;
            } catch (IllegalStateException e3) {
                e = e3;
                if (aVar != null && !TextUtils.isEmpty(e.getMessage())) {
                    message = e.getMessage();
                    e = e;
                    aVar.f71285e = message;
                }
                d.a.y0.t.c.g(e);
                this.N = false;
                return false;
            } catch (RuntimeException e4) {
                e = e4;
                if (aVar != null && !TextUtils.isEmpty(e.getMessage())) {
                    message = e.getMessage();
                    e = e;
                    aVar.f71285e = message;
                }
                d.a.y0.t.c.g(e);
                this.N = false;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.w == 1.0f) {
                return M();
            }
            long nanoTime = System.nanoTime();
            if (this.o != 0) {
                if (this.q == 0) {
                    this.q = nanoTime;
                }
                nanoTime = (((float) (nanoTime - this.q)) / this.w) + this.o;
            }
            long j = nanoTime / 1000;
            long j2 = this.P;
            if (j < j2) {
                j = 100 + j2;
            }
            this.P = j;
            return j;
        }
        return invokeV.longValue;
    }
}
