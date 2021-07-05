package d.a.z.c;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mario.audio.AudioParams;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.ShortCompanionObject;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f71526a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.z.b.g.c f71527b;

    /* renamed from: c  reason: collision with root package name */
    public int f71528c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71529d;

    /* renamed from: e  reason: collision with root package name */
    public long f71530e;

    /* renamed from: f  reason: collision with root package name */
    public long f71531f;

    /* renamed from: g  reason: collision with root package name */
    public long f71532g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71533h;

    /* renamed from: i  reason: collision with root package name */
    public d f71534i;
    public e j;
    public d.a.z.c.g.d k;
    public boolean l;
    public Context m;
    public int n;
    public d.a.z.c.c o;
    public d.a.z.c.a p;
    public d.a.z.a.a.a q;
    public int r;
    public int s;
    public byte[] t;
    public ByteBuffer u;
    public Timer v;
    public TimerTask w;
    public boolean x;
    public boolean y;
    public long z;

    /* loaded from: classes9.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f71535a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71535a = bVar;
        }

        @Override // d.a.z.c.e
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f71535a.f71532g = j;
                if (j <= this.f71535a.f71526a || !this.f71535a.l) {
                    return;
                }
                this.f71535a.I();
            }
        }

        @Override // d.a.z.c.e
        public void onRecorderComplete(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                String str2 = b.A;
                Log.i(str2, "on RecorderComplete record time :" + this.f71535a.f71532g);
                if (this.f71535a.o != null) {
                    this.f71535a.o.x((int) this.f71535a.f71532g, str);
                }
            }
        }

        @Override // d.a.z.c.e
        public void onRecorderError(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                String str = b.A;
                Log.i(str, "onRecorderError:" + i2);
                if (this.f71535a.o != null) {
                    this.f71535a.o.onError(i2);
                }
            }
        }

        @Override // d.a.z.c.e
        public void onRecorderStart(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.f71535a.o == null) {
                return;
            }
            this.f71535a.o.onStart();
            this.f71535a.x = true;
        }
    }

    /* renamed from: d.a.z.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1986b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f71536e;

        public C1986b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71536e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f71536e.x && !this.f71536e.y) {
                    Log.i(b.A, "cancel audio time");
                    this.f71536e.H();
                    this.f71536e.y = false;
                    return;
                }
                b bVar = this.f71536e;
                bVar.K(bVar.u, 3840, System.nanoTime() - this.f71536e.z);
                this.f71536e.y = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements d.a.z.a.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<b> f71537a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71537a = new WeakReference<>(bVar);
            String str = b.A;
            Log.i(str, "gameRecorderRef is:" + this.f71537a.get());
        }

        @Override // d.a.z.a.a.a
        public void a(boolean z, AudioParams audioParams) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, audioParams) == null) || this.f71537a.get() == null) {
                return;
            }
            this.f71537a.get().G(z, audioParams);
            Log.i(b.A, "onAudioStart");
        }

        @Override // d.a.z.a.a.a
        public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f71537a.get() == null) {
                return;
            }
            this.f71537a.get().y = false;
            this.f71537a.get().K(byteBuffer, i2, j);
        }

        @Override // d.a.z.a.a.a
        public void onAudioStop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                Log.i(b.A, "onAudioStop");
                if (this.f71537a.get() != null) {
                    this.f71537a.get().H();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1095774785, "Ld/a/z/c/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1095774785, "Ld/a/z/c/b;");
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f71526a = 120000;
        this.f71528c = -1;
        this.f71529d = false;
        this.f71533h = false;
        this.r = 0;
        this.s = 0;
        this.t = ByteBuffer.allocate(3840).putShort(ShortCompanionObject.MIN_VALUE).array();
        this.u = ByteBuffer.allocate(3840).put(this.t);
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = false;
        this.z = 0L;
        this.m = context;
        this.f71534i = d.x();
        this.p = null;
        this.j = new a(this);
        D(new d.a.z.c.g.d(), this.j);
    }

    public void A(d.a.z.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public void B(d.a.z.c.g.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void C(d.a.z.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void D(d.a.z.c.g.d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dVar, eVar) == null) {
            B(dVar);
            this.j = eVar;
        }
    }

    public final void E(AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, audioParams) == null) {
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
    }

    public void F(boolean z, int i2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2)}) == null) || this.l) {
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
        this.f71530e = 0L;
        this.f71532g = 0L;
        if (i2 > 0 && i2 < 120) {
            this.f71526a = i3;
        } else {
            this.f71526a = 120000;
        }
        E(null);
    }

    public final void G(boolean z, AudioParams audioParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, audioParams) == null) {
            if (audioParams != null) {
                this.k.t(audioParams.getSampleRate());
                this.k.r(audioParams.getFrameSize());
                this.k.q(audioParams.getChannelConfig());
            }
            this.x = false;
            this.l = true;
            H();
            this.v = new Timer();
            C1986b c1986b = new C1986b(this);
            this.w = c1986b;
            this.v.schedule(c1986b, 300L, 20L);
        }
    }

    public final synchronized void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.v != null) {
                    this.v.cancel();
                    this.v = null;
                    this.w = null;
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
                d dVar = this.f71534i;
                if (dVar != null) {
                    dVar.U();
                }
            }
        }
    }

    public final void J(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            if (this.l && this.k != null) {
                int i3 = this.n;
                if (i3 == 0) {
                    p();
                    d dVar = this.f71534i;
                    if (dVar != null) {
                        dVar.S(this.m, this.k, this.j);
                    }
                    this.n = 1;
                } else if (i3 != 1) {
                    if (i3 == 2) {
                        this.f71527b.m().j(i2);
                        d dVar2 = this.f71534i;
                        if (dVar2 != null) {
                            dVar2.W(this.f71527b);
                        }
                        this.n = 1;
                    } else {
                        throw new RuntimeException("unknown status " + this.n);
                    }
                }
            }
            d dVar3 = this.f71534i;
            if (dVar3 == null || this.f71529d) {
                return;
            }
            dVar3.H(j - this.f71530e);
        }
    }

    public final void K(ByteBuffer byteBuffer, int i2, long j) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (dVar = this.f71534i) == null || !this.l || byteBuffer == null || i2 <= 0 || this.f71529d) {
            return;
        }
        dVar.F(byteBuffer, i2, j - this.f71530e);
    }

    public final void p() {
        d.a.z.c.g.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (dVar = this.k) == null || this.f71527b == null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.q == null) {
            this.q = new c(this);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f71529d) {
            this.f71530e += System.nanoTime() - this.f71531f;
            this.f71529d = false;
        }
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f71532g : invokeV.longValue;
    }

    public void t(boolean z, EGLContext eGLContext, int i2, int i3, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), eGLContext, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || eGLContext == null) {
            return;
        }
        this.m = context;
        String str = A;
        Log.i(str, "onContextChanged:" + eGLContext + "; w:" + i2 + "; h:" + i3 + "; isFlip:" + z);
        d.a.z.b.g.c cVar = this.f71527b;
        if (cVar == null) {
            this.f71527b = new d.a.z.b.g.c(eGLContext, 0, true);
        } else {
            cVar.q(eGLContext);
        }
        this.f71527b.l().h(i2);
        this.f71527b.l().g(i3);
        if (z) {
            this.f71527b.f().m(MirrorType.VERTICALLY);
        }
        this.r = i2;
        this.s = i3;
        this.k.x(i2);
        this.k.w(i3);
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.f71527b == null) {
            return;
        }
        if (this.f71528c != i2) {
            d.a.z.b.f.d dVar = new d.a.z.b.f.d();
            dVar.j(i2);
            this.f71527b.t(dVar);
            d dVar2 = this.f71534i;
            if (dVar2 != null) {
                dVar2.s(this.f71527b);
            }
            this.f71528c = i2;
        }
        J(this.f71528c, System.nanoTime());
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f71529d) {
                Log.i(A, "pauseRecord cmd has executed, please run resumeRecord!");
            } else if (this.l) {
                this.f71529d = true;
                Log.i(A, "pauseRecord");
                this.f71531f = System.nanoTime();
                this.f71530e = 0L;
                d dVar = this.f71534i;
                if (dVar != null) {
                    dVar.I();
                    long y = (this.f71531f - (this.f71532g * 1000000)) - this.f71534i.y();
                    this.f71530e = y;
                    if (y < 0) {
                        this.f71530e = 0L;
                    }
                }
                d.a.z.c.c cVar = this.o;
                if (cVar != null) {
                    cVar.onPause();
                }
                H();
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!this.f71529d) {
                this.f71533h = true;
                v();
                return;
            }
            this.f71533h = false;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d dVar = this.f71534i;
            if (dVar != null) {
                dVar.G();
                this.f71534i = null;
            }
            if (this.j != null) {
                this.j = null;
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.f71529d) {
            this.f71530e += System.nanoTime() - this.f71531f;
            this.f71529d = false;
            E(null);
            d.a.z.c.c cVar = this.o;
            if (cVar != null) {
                cVar.onResume();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f71529d && this.f71533h) {
                y();
            }
            this.f71533h = false;
        }
    }
}
