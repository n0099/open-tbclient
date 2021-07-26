package d.f.b.a.j0;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.v;
@TargetApi(16)
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WindowManager f71009a;

    /* renamed from: b  reason: collision with root package name */
    public final b f71010b;

    /* renamed from: c  reason: collision with root package name */
    public final a f71011c;

    /* renamed from: d  reason: collision with root package name */
    public long f71012d;

    /* renamed from: e  reason: collision with root package name */
    public long f71013e;

    /* renamed from: f  reason: collision with root package name */
    public long f71014f;

    /* renamed from: g  reason: collision with root package name */
    public long f71015g;

    /* renamed from: h  reason: collision with root package name */
    public long f71016h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71017i;
    public long j;
    public long k;
    public long l;

    @TargetApi(17)
    /* loaded from: classes8.dex */
    public final class a implements DisplayManager.DisplayListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final DisplayManager f71018a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f71019b;

        public a(d dVar, DisplayManager displayManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, displayManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71019b = dVar;
            this.f71018a = displayManager;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f71018a.registerDisplayListener(this, null);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f71018a.unregisterDisplayListener(this);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && i2 == 0) {
                this.f71019b.h();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements Choreographer.FrameCallback, Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public static final b j;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public volatile long f71020e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f71021f;

        /* renamed from: g  reason: collision with root package name */
        public final HandlerThread f71022g;

        /* renamed from: h  reason: collision with root package name */
        public Choreographer f71023h;

        /* renamed from: i  reason: collision with root package name */
        public int f71024i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1339840071, "Ld/f/b/a/j0/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1339840071, "Ld/f/b/a/j0/d$b;");
                    return;
                }
            }
            j = new b();
        }

        public b() {
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
            this.f71020e = -9223372036854775807L;
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f71022g = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.f71022g.getLooper(), this);
            this.f71021f = handler;
            handler.sendEmptyMessage(0);
        }

        public static b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? j : (b) invokeV.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f71021f.sendEmptyMessage(1);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.f71024i + 1;
                this.f71024i = i2;
                if (i2 == 1) {
                    this.f71023h.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f71023h = Choreographer.getInstance();
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
                this.f71020e = j2;
                this.f71023h.postFrameCallbackDelayed(this, 500L);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f71021f.sendEmptyMessage(2);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i2 = this.f71024i - 1;
                this.f71024i = i2;
                if (i2 == 0) {
                    this.f71023h.removeFrameCallback(this);
                    this.f71020e = -9223372036854775807L;
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    c();
                    return true;
                } else if (i2 == 1) {
                    b();
                    return true;
                } else if (i2 != 2) {
                    return false;
                } else {
                    f();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    public d(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        WindowManager windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        this.f71009a = windowManager;
        if (windowManager != null) {
            this.f71011c = v.f70969a >= 17 ? g(context) : null;
            this.f71010b = b.d();
        } else {
            this.f71011c = null;
            this.f71010b = null;
        }
        this.f71012d = -9223372036854775807L;
        this.f71013e = -9223372036854775807L;
    }

    public static long c(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j5 = j2 + (((j - j2) / j3) * j3);
            if (j <= j5) {
                j4 = j5 - j3;
            } else {
                j5 = j3 + j5;
                j4 = j5;
            }
            return j5 - j < j - j4 ? j5 : j4;
        }
        return invokeCommon.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(long j, long j2) {
        InterceptResult invokeCommon;
        long j3;
        long j4;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j5 = 1000 * j;
            if (this.f71017i) {
                if (j != this.f71014f) {
                    this.l++;
                    this.f71015g = this.f71016h;
                }
                long j6 = this.l;
                if (j6 >= 6) {
                    j4 = this.f71015g + ((j5 - this.k) / j6);
                    if (f(j4, j2)) {
                        this.f71017i = false;
                    } else {
                        j3 = (this.j + j4) - this.k;
                        if (!this.f71017i) {
                            this.k = j5;
                            this.j = j2;
                            this.l = 0L;
                            this.f71017i = true;
                        }
                        this.f71014f = j;
                        this.f71016h = j4;
                        bVar = this.f71010b;
                        if (bVar != null || this.f71012d == -9223372036854775807L) {
                            return j3;
                        }
                        long j7 = bVar.f71020e;
                        return j7 == -9223372036854775807L ? j3 : c(j3, j7, this.f71012d) - this.f71013e;
                    }
                } else if (f(j5, j2)) {
                    this.f71017i = false;
                }
            }
            j3 = j2;
            j4 = j5;
            if (!this.f71017i) {
            }
            this.f71014f = j;
            this.f71016h = j4;
            bVar = this.f71010b;
            if (bVar != null) {
            }
            return j3;
        }
        return invokeCommon.longValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f71009a == null) {
            return;
        }
        a aVar = this.f71011c;
        if (aVar != null) {
            aVar.b();
        }
        this.f71010b.e();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f71017i = false;
            if (this.f71009a != null) {
                this.f71010b.a();
                a aVar = this.f71011c;
                if (aVar != null) {
                    aVar.a();
                }
                h();
            }
        }
    }

    public final boolean f(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Math.abs((j2 - this.j) - (j - this.k)) > 20000000 : invokeCommon.booleanValue;
    }

    @TargetApi(17)
    public final a g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return null;
            }
            return new a(this, displayManager);
        }
        return (a) invokeL.objValue;
    }

    public final void h() {
        Display defaultDisplay;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (defaultDisplay = this.f71009a.getDefaultDisplay()) == null) {
            return;
        }
        long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
        this.f71012d = refreshRate;
        this.f71013e = (refreshRate * 80) / 100;
    }
}
