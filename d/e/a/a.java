package d.e.a;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.github.anrwatchdog.ANRError;
/* loaded from: classes10.dex */
public class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public static final f p;
    public static final e q;
    public static final g r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f72032e;

    /* renamed from: f  reason: collision with root package name */
    public e f72033f;

    /* renamed from: g  reason: collision with root package name */
    public g f72034g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f72035h;

    /* renamed from: i  reason: collision with root package name */
    public final int f72036i;
    public String j;
    public boolean k;
    public boolean l;
    public volatile long m;
    public volatile boolean n;
    public final Runnable o;

    /* renamed from: d.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2000a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2000a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.e.a.a.f
        public void onAppNotResponding(ANRError aNRError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) {
                throw aNRError;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.e.a.a.e
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                return 0L;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.e.a.a.g
        public void a(InterruptedException interruptedException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interruptedException) == null) {
                Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f72037e;

        public d(a aVar) {
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
            this.f72037e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72037e.m = 0L;
                this.f72037e.n = false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface e {
        long a(long j);
    }

    /* loaded from: classes10.dex */
    public interface f {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes10.dex */
    public interface g {
        void a(InterruptedException interruptedException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-39323607, "Ld/e/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-39323607, "Ld/e/a/a;");
                return;
            }
        }
        p = new C2000a();
        q = new b();
        r = new c();
    }

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72032e = p;
        this.f72033f = q;
        this.f72034g = r;
        this.f72035h = new Handler(Looper.getMainLooper());
        this.j = "";
        this.k = false;
        this.l = true;
        this.m = 0L;
        this.n = false;
        this.o = new d(this);
        this.f72036i = i2;
    }

    public a c(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null) {
                this.f72032e = p;
            } else {
                this.f72032e = fVar;
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.j = null;
            return this;
        }
        return (a) invokeV.objValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setName("|ANR-WatchDog|");
            long j = this.f72036i;
            while (!isInterrupted()) {
                boolean z = this.m == 0;
                this.m += j;
                if (z) {
                    this.f72035h.post(this.o);
                }
                try {
                    Thread.sleep(j);
                    if (this.m != 0 && !this.n) {
                        if (!this.l && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                            Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                            this.n = true;
                        } else {
                            j = this.f72033f.a(this.m);
                            if (j <= 0) {
                                if (this.j != null) {
                                    NewMainOnly = ANRError.New(this.m, this.j, this.k);
                                } else {
                                    NewMainOnly = ANRError.NewMainOnly(this.m);
                                }
                                this.f72032e.onAppNotResponding(NewMainOnly);
                                j = this.f72036i;
                                this.n = true;
                            }
                        }
                    }
                } catch (InterruptedException e2) {
                    this.f72034g.a(e2);
                    return;
                }
            }
        }
    }
}
