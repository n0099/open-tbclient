package d.a.x.c.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.x.c.g.c;
import d.a.x.c.g.d;
import d.a.x.c.g.e;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final String f69032f = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f69033a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f69034b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.x.c.g.a f69035c;

    /* renamed from: d  reason: collision with root package name */
    public e f69036d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f69037e;

    /* renamed from: d.a.x.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1952a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ByteBuffer f69038a;

        /* renamed from: b  reason: collision with root package name */
        public int f69039b;

        /* renamed from: c  reason: collision with root package name */
        public long f69040c;

        public C1952a(a aVar, ByteBuffer byteBuffer, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69038a = byteBuffer;
            this.f69039b = i2;
            this.f69040c = j;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f69041a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69041a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.f69041a.k((d) message.obj);
                        return;
                    case 1002:
                        this.f69041a.l();
                        return;
                    case 1003:
                        C1952a c1952a = (C1952a) message.obj;
                        this.f69041a.h(c1952a.f69038a, c1952a.f69039b, c1952a.f69040c);
                        return;
                    case 1004:
                        this.f69041a.m();
                        return;
                    case 1005:
                        this.f69041a.j();
                        return;
                    case 1006:
                        this.f69041a.i();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(36876459, "Ld/a/x/c/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(36876459, "Ld/a/x/c/f/a;");
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
        this.f69037e = false;
    }

    public void g(ByteBuffer byteBuffer, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || byteBuffer == null || i2 <= 0) {
            return;
        }
        C1952a c1952a = new C1952a(this, byteBuffer, i2, j);
        if (this.f69034b == null || !this.f69037e) {
            return;
        }
        Handler handler = this.f69034b;
        handler.sendMessage(handler.obtainMessage(1003, c1952a));
    }

    public final void h(ByteBuffer byteBuffer, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Long.valueOf(j)}) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f69035c.a(false, byteBuffer, i2, j);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.f69034b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f69034b = null;
            }
            HandlerThread handlerThread = this.f69033a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f69033a = null;
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        d.a.x.c.g.a aVar = this.f69035c;
        if (aVar != null) {
            aVar.i();
            this.f69035c.e();
        }
        this.f69035c = null;
        this.f69036d = null;
    }

    public final void k(d dVar) {
        d.a.x.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f69035c) == null) {
            return;
        }
        aVar.k(dVar, this.f69036d);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f69035c.h();
    }

    public final void m() {
        d.a.x.c.g.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (aVar = this.f69035c) == null) {
            return;
        }
        aVar.a(true, null, 0, 0L);
    }

    public final void n(e eVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
            this.f69033a = handlerThread;
            handlerThread.start();
            this.f69034b = new b(this, this.f69033a.getLooper());
            try {
                this.f69035c = new d.a.x.c.g.a();
            } catch (VerifyError unused) {
                Log.e(f69032f, "initRecorder verifyError");
                if (this.f69035c == null) {
                    return;
                }
            }
            this.f69036d = eVar;
            if (Build.VERSION.SDK_INT >= 18) {
                this.f69035c.f(cVar);
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HandlerThread handlerThread = this.f69033a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (handler = this.f69034b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f69034b;
        handler2.sendMessage(handler2.obtainMessage(1005));
        Handler handler3 = this.f69034b;
        handler3.sendMessage(handler3.obtainMessage(1006));
    }

    public boolean q(d dVar, e eVar, c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, dVar, eVar, cVar)) == null) {
            if (o()) {
                Log.e(f69032f, "setupRecorder error! As last audio recorder thread is alive!");
                return false;
            }
            n(eVar, cVar);
            Handler handler = this.f69034b;
            handler.sendMessage(handler.obtainMessage(1001, dVar));
            this.f69037e = true;
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void r() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (handler = this.f69034b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f69034b != null && this.f69037e) {
            this.f69037e = false;
            Handler handler = this.f69034b;
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }
}
