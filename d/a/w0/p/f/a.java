package d.a.w0.p.f;

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
import d.a.w0.t.m;
import d.a.w0.t.s;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import kotlinx.coroutines.CoroutineContextKt;
@TargetApi(18)
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public d.a.w0.p.g.c B;
    public boolean C;
    public boolean D;
    public d.a.w0.f.b.a E;
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
    public WindowSurface f68853a;

    /* renamed from: b  reason: collision with root package name */
    public EglCore f68854b;

    /* renamed from: c  reason: collision with root package name */
    public FullFrameRect f68855c;

    /* renamed from: d  reason: collision with root package name */
    public int f68856d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.w0.p.f.e f68857e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.w0.p.f.b f68858f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.w0.p.f.d f68859g;

    /* renamed from: h  reason: collision with root package name */
    public volatile g f68860h;

    /* renamed from: i  reason: collision with root package name */
    public Object f68861i;
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

    /* renamed from: d.a.w0.p.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1944a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface b {
        void b(long j);

        void onError(int i2, String str);

        void onStartSuccess();

        @WorkerThread
        void onStopSuccess();
    }

    /* loaded from: classes8.dex */
    public class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68862e;

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
            this.f68862e = aVar;
        }

        public /* synthetic */ c(a aVar, C1944a c1944a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.a.w0.p.f.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                int i2 = RecordConstants.MOVIE_ENCODE_SAMPLE_RATE;
                d.a.w0.g.a aVar = (d.a.w0.g.a) s.a("com.baidu.ugc.audioedit.AudioSpeedOperator");
                if (aVar != null) {
                    aVar.init(i2, 1);
                    aVar.setSpeed(this.f68862e.w);
                }
                synchronized (this.f68862e.I) {
                    while (!this.f68862e.J) {
                        try {
                            this.f68862e.I.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                try {
                    d.a.w0.p.f.c cVar = new d.a.w0.p.f.c(this.f68862e.A);
                    if (cVar.d() != null) {
                        this.f68862e.v = true;
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(d.a.w0.p.f.c.f68880d);
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(10240);
                        cVar.c();
                        if (cVar.e() != 3) {
                            a aVar2 = this.f68862e;
                            aVar2.e(1114, "音频开始录制失败 " + cVar.e());
                            cVar.b();
                            this.f68862e.f68858f.d();
                            return;
                        }
                        this.f68862e.l = 1;
                        while (!this.f68862e.O) {
                            try {
                                allocateDirect.clear();
                                allocateDirect2.clear();
                                int a2 = cVar.a(allocateDirect, d.a.w0.p.f.c.f68880d);
                                if (this.f68862e.C && this.f68862e.B != null) {
                                    double a3 = d.a.w0.p.i.a.a(allocateDirect, a2);
                                    if (a3 > 0.0d) {
                                        this.f68862e.B.a(a3);
                                    }
                                }
                                if (a2 > 0) {
                                    if (aVar == null) {
                                        allocateDirect.position(a2);
                                        allocateDirect.flip();
                                        this.f68862e.f68858f.b(allocateDirect, 0, a2, this.f68862e.G());
                                        bVar = this.f68862e.f68858f;
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
                                            if (this.f68862e.D) {
                                                byte[] k = d.a.w0.l.d.g.k(bArr2, 4.0d);
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
                                            this.f68862e.f68858f.b(allocateDirect2, 0, i3, this.f68862e.G());
                                            bVar = this.f68862e.f68858f;
                                        }
                                    }
                                    bVar.c();
                                }
                            } finally {
                                cVar.b();
                            }
                        }
                        this.f68862e.f68858f.b(null, 0, 0, this.f68862e.G());
                        this.f68862e.f68858f.c();
                        cVar.b();
                        this.f68862e.f68858f.d();
                    } else {
                        d.a.w0.t.c.e(TextureMovieEncoder.TAG, "failed to initialize AudioRecord");
                    }
                } catch (Exception e3) {
                    d.a.w0.t.c.f(TextureMovieEncoder.TAG, "AudioThread#run", e3);
                    d.a.w0.t.c.g(e3);
                    if (this.f68862e.l != 6) {
                        this.f68862e.l = 6;
                        String message = e3.getMessage();
                        a aVar3 = this.f68862e;
                        aVar3.e(1115, "结束音频编码错误" + message);
                    }
                }
                synchronized (this.f68862e.K) {
                    this.f68862e.L = true;
                    this.f68862e.K.notifyAll();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final File f68863a;

        /* renamed from: b  reason: collision with root package name */
        public final int f68864b;

        /* renamed from: c  reason: collision with root package name */
        public final int f68865c;

        /* renamed from: d  reason: collision with root package name */
        public final int f68866d;

        /* renamed from: e  reason: collision with root package name */
        public final EGLContext f68867e;

        /* renamed from: f  reason: collision with root package name */
        public final long f68868f;

        /* renamed from: g  reason: collision with root package name */
        public int f68869g;

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
            this.f68869g = 10000;
            this.f68863a = file;
            this.f68864b = i2;
            this.f68865c = i3;
            this.f68866d = i4;
            if (eGLContext != null) {
                this.f68867e = eGLContext;
            } else {
                this.f68867e = EGL14.eglGetCurrentContext();
            }
            this.f68868f = j;
            this.f68869g = i6;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "EncoderConfig: " + this.f68864b + "x" + this.f68865c + CoroutineContextKt.DEBUG_THREAD_NAME_SEPARATOR + this.f68866d + " to '" + this.f68863a.toString() + "' ctxt=" + this.f68867e;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(long j);
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes8.dex */
    public static class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f68870a;

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
            this.f68870a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                Object obj = message.obj;
                a aVar = this.f68870a.get();
                if (aVar == null) {
                    d.a.w0.t.c.l(TextureMovieEncoder.TAG, "VideoEncoderHandler.handleMessage: encoder is null");
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

    /* loaded from: classes8.dex */
    public class h extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68871e;

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
            this.f68871e = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                synchronized (this.f68871e.f68861i) {
                    this.f68871e.f68860h = new g(this.f68871e);
                    this.f68871e.j = true;
                    this.f68871e.f68861i.notifyAll();
                }
                Looper.loop();
                d.a.w0.t.c.c(TextureMovieEncoder.TAG, "Encoder thread exiting");
                synchronized (this.f68871e.f68861i) {
                    a aVar = this.f68871e;
                    this.f68871e.k = false;
                    aVar.j = false;
                    this.f68871e.f68860h = null;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-990357869, "Ld/a/w0/p/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-990357869, "Ld/a/w0/p/f/a;");
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
        this.f68861i = new Object();
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
            d.a.w0.t.c.c(TextureMovieEncoder.TAG, "handleStartRecording " + dVar);
            this.H = dVar;
            d.a.w0.m.a aVar = new d.a.w0.m.a();
            if (w(dVar.f68867e, dVar.f68864b, dVar.f68865c, dVar.f68866d, dVar.f68863a, aVar)) {
                this.O = false;
                b bVar = this.m;
                if (bVar != null) {
                    bVar.onStartSuccess();
                }
            } else if (this.l != 6) {
                this.l = 6;
                String str = aVar.f68766e;
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
            this.f68856d = i2;
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
            d.a.w0.t.c.c(TextureMovieEncoder.TAG, "handleStopRecording");
            this.O = true;
            try {
                this.f68857e.c(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Q();
            d.a.w0.t.c.e(TextureMovieEncoder.TAG, "handleStopRecording before stop success");
            while (!this.L && this.v) {
                synchronized (this.K) {
                    try {
                        this.K.wait();
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            long a2 = d.a.w0.n.a.a(this.M);
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
                this.f68857e.d();
                if (this.f68853a != null) {
                    this.f68853a.release();
                    this.f68853a = null;
                }
                if (this.f68855c != null) {
                    this.f68855c.release(false);
                    this.f68855c = null;
                }
                if (this.f68854b != null) {
                    this.f68854b.release();
                    this.f68854b = null;
                }
            } catch (Exception e2) {
                d.a.w0.t.c.g(e2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f68861i) {
                while (!this.j) {
                    try {
                        this.f68861i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            this.s = 0;
            d.a.w0.p.f.d dVar = this.f68859g;
            if (dVar == null || !dVar.e()) {
                this.O = true;
                d.a.w0.p.f.e eVar = this.f68857e;
                if (eVar != null) {
                    eVar.e();
                }
                d.a.w0.p.f.b bVar = this.f68858f;
                if (bVar != null) {
                    bVar.a();
                }
            }
            this.l = 4;
            this.f68860h.sendMessage(this.f68860h.obtainMessage(1));
            this.f68860h.sendMessage(this.f68860h.obtainMessage(5));
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
            synchronized (this.f68861i) {
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
                            d.a.w0.t.c.l(TextureMovieEncoder.TAG, "HEY: got SurfaceTexture with timestamp of zero");
                        } else {
                            this.f68860h.sendMessage(this.f68860h.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                        }
                    }
                }
            }
        }
    }

    public final void g(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eGLContext) == null) {
            d.a.w0.t.c.c(TextureMovieEncoder.TAG, "handleUpdatedSharedContext " + eGLContext);
            WindowSurface windowSurface = this.f68853a;
            if (windowSurface != null) {
                windowSurface.releaseEglSurface();
            }
            this.f68855c.release(false);
            EglCore eglCore = this.f68854b;
            if (eglCore != null) {
                eglCore.release();
            }
            EglCore eglCore2 = new EglCore(eGLContext, 2);
            this.f68854b = eglCore2;
            WindowSurface windowSurface2 = this.f68853a;
            if (windowSurface2 != null) {
                windowSurface2.recreate(eglCore2);
                this.f68853a.makeCurrent();
            }
            this.f68855c = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
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
        synchronized (this.f68861i) {
            if (this.j) {
                this.f68860h.sendMessage(this.f68860h.obtainMessage(3, this.s, 0, null));
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
            this.t = dVar.f68864b;
            this.u = dVar.f68865c;
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
            this.o = dVar.f68868f;
            this.p = System.nanoTime();
            this.q = 0L;
            this.r = 0L;
            synchronized (this.f68861i) {
                if (this.k) {
                    d.a.w0.t.c.l(TextureMovieEncoder.TAG, "Encoder thread already running");
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
                        this.f68861i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                this.y = -1L;
                this.f68860h.sendMessage(this.f68860h.obtainMessage(0, dVar));
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

    public void r(d.a.w0.p.g.c cVar) {
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
            d.a.w0.f.b.a aVar = this.E;
            if (aVar != null) {
                aVar.b();
            }
            if (this.s != 0) {
                try {
                    this.f68857e.c(false);
                } catch (Exception e2) {
                    d.a.w0.t.c.g(e2);
                    if (this.l != 6) {
                        this.l = 6;
                        String message = e2.getMessage();
                        e(FeatureCodes.SPLIT_FILTER, "录制编码错误transform:" + fArr + "timestampNanos:" + j + " , Exception : " + message);
                    }
                }
                d dVar = this.H;
                GLES20.glViewport(0, 0, dVar.f68864b, dVar.f68865c);
                synchronized (a.class) {
                    if (this.x != 0.0f) {
                        this.f68855c.setAngle(this.x);
                    }
                    this.f68855c.drawFrame(this.f68856d, fArr);
                }
                if (this.f68853a != null) {
                    long z = z();
                    if (this.y == -1) {
                        this.y = z;
                        this.z = 0L;
                    }
                    this.f68853a.setPresentationTime(z * 1000);
                    this.f68853a.swapBuffers();
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
                            d.a.a0.a.j.e.d(file);
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
                            d.a.a0.a.j.e.d(new File(str2));
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
                d.a.a0.a.j.e.d(file);
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
    public final boolean w(EGLContext eGLContext, int i2, int i3, int i4, File file, d.a.w0.m.a aVar) {
        InterceptResult invokeCommon;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{eGLContext, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), file, aVar})) == null) {
            try {
                if (this.D) {
                    RecordConstants.MOVIE_ENCODE_SAMPLE_RATE = 16000;
                    d.a.w0.p.f.c.f68879c = 16000;
                    RecordConstants.AUDIO_ENCODE_SAMPLE_RATE = 16000;
                } else {
                    RecordConstants.MOVIE_ENCODE_SAMPLE_RATE = 44100;
                    RecordConstants.AUDIO_ENCODE_SAMPLE_RATE = 44100;
                    d.a.w0.p.f.c.f68879c = 44100;
                }
                this.M = file.toString();
                this.f68859g = new d.a.w0.p.f.d(file.toString());
                if (this.F && Build.VERSION.SDK_INT <= 23) {
                    this.F = v(i2, i3, new File(file.toString()).getParent());
                }
                d.a.w0.p.f.e eVar = new d.a.w0.p.f.e(i2, i3, i4, this.F, this.f68859g);
                this.f68857e = eVar;
                eVar.b(this.H.f68869g);
                this.f68858f = new d.a.w0.p.f.b(this.f68859g);
                this.N = true;
                EglCore eglCore = new EglCore(eGLContext, 2);
                this.f68854b = eglCore;
                WindowSurface windowSurface = new WindowSurface(eglCore, this.f68857e.a(), true);
                this.f68853a = windowSurface;
                windowSurface.makeCurrent();
                this.f68855c = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                return true;
            } catch (IOException e2) {
                if (aVar != null && !TextUtils.isEmpty(e2.getMessage())) {
                    aVar.f68766e = e2.getMessage();
                }
                d.a.w0.t.c.g(e2);
                return false;
            } catch (IllegalStateException e3) {
                e = e3;
                if (aVar != null && !TextUtils.isEmpty(e.getMessage())) {
                    message = e.getMessage();
                    e = e;
                    aVar.f68766e = message;
                }
                d.a.w0.t.c.g(e);
                this.N = false;
                return false;
            } catch (RuntimeException e4) {
                e = e4;
                if (aVar != null && !TextUtils.isEmpty(e.getMessage())) {
                    message = e.getMessage();
                    e = e;
                    aVar.f68766e = message;
                }
                d.a.w0.t.c.g(e);
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
