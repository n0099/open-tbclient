package d.a.z.c.f;

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
import d.a.z.b.g.c;
import d.a.z.c.g.d;
import d.a.z.c.g.e;
import d.a.z.c.g.g;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static final String f71561h = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f71562a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f71563b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.z.b.a f71564c;

    /* renamed from: d  reason: collision with root package name */
    public g f71565d;

    /* renamed from: e  reason: collision with root package name */
    public e f71566e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f71567f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71568g;

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f71569a;

        /* renamed from: b  reason: collision with root package name */
        public d f71570b;

        public a(b bVar, ArrayList<c> arrayList, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, arrayList, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71569a = arrayList;
            this.f71570b = dVar;
        }
    }

    /* renamed from: d.a.z.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class HandlerC1989b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f71571a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1989b(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
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
            this.f71571a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        a aVar = (a) message.obj;
                        this.f71571a.n(aVar.f71569a, aVar.f71570b);
                        return;
                    case 1002:
                        this.f71571a.o();
                        return;
                    case 1003:
                        this.f71571a.r((ArrayList) message.obj);
                        return;
                    case 1004:
                        this.f71571a.q((d.a.z.b.e.c) message.obj);
                        return;
                    case 1005:
                        this.f71571a.k((message.arg1 << 32) | (message.arg2 & 4294967295L));
                        return;
                    case 1006:
                        this.f71571a.p();
                        return;
                    case 1007:
                        this.f71571a.m();
                        return;
                    case 1008:
                        this.f71571a.l();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-772470136, "Ld/a/z/c/f/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-772470136, "Ld/a/z/c/f/b;");
        }
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
        this.f71567f = false;
        this.f71568g = false;
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i2 = (int) (j >> 32);
            int i3 = (int) j;
            if (this.f71563b == null || !this.f71567f) {
                return;
            }
            Handler handler = this.f71563b;
            handler.sendMessage(handler.obtainMessage(1005, i2, i3));
            synchronized (this.f71564c) {
                try {
                    if (this.f71568g) {
                        this.f71564c.wait(12L);
                    } else {
                        this.f71564c.wait(2L);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.f71565d;
            if (gVar != null) {
                return gVar.d();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void k(long j) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f71565d) == null) {
            return;
        }
        gVar.c(false);
        this.f71564c.a(j);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Handler handler = this.f71563b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f71563b = null;
            }
            HandlerThread handlerThread = this.f71562a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f71562a = null;
            }
        }
    }

    public final void m() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f71565d) == null) {
            return;
        }
        gVar.i();
        this.f71565d.e();
        this.f71565d = null;
        this.f71566e = null;
        this.f71564c.c();
        this.f71564c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, arrayList, dVar) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f71565d) == null) {
            return;
        }
        gVar.l(dVar, this.f71566e);
        if (this.f71564c == null) {
            this.f71564c = new d.a.z.b.a(this.f71565d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f71565d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f71565d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(d.a.z.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f71564c.d(cVar);
    }

    public final void r(ArrayList<c> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f71564c.e(arrayList);
    }

    public final void s(e eVar, d.a.z.c.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
            this.f71562a = handlerThread;
            handlerThread.start();
            this.f71563b = new HandlerC1989b(this, this.f71562a.getLooper());
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    this.f71565d = new g();
                } catch (VerifyError unused) {
                    Log.e(f71561h, "initRecorder videorecorder verifyError");
                    if (this.f71565d == null) {
                        return;
                    }
                }
                this.f71565d.f(cVar);
                this.f71566e = eVar;
            }
            if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
                this.f71568g = true;
            } else {
                this.f71568g = false;
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HandlerThread handlerThread = this.f71562a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f71563b != null && this.f71567f) {
            this.f71563b.removeMessages(1005);
        }
    }

    public void v() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handler = this.f71563b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f71563b;
        handler2.sendMessage(handler2.obtainMessage(1007));
        Handler handler3 = this.f71563b;
        handler3.sendMessage(handler3.obtainMessage(1008));
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, d.a.z.c.g.c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, arrayList, dVar, eVar, cVar)) == null) {
            if (t()) {
                Log.e(f71561h, "setupRecorder error! As last video recorder thread is alive!");
                return false;
            }
            s(eVar, cVar);
            a aVar = new a(this, arrayList, dVar);
            Handler handler = this.f71563b;
            handler.sendMessage(handler.obtainMessage(1001, aVar));
            this.f71567f = true;
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void x() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (handler = this.f71563b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f71563b != null && this.f71567f) {
            this.f71567f = false;
            this.f71563b.removeMessages(1005);
            Handler handler = this.f71563b;
            handler.sendMessage(handler.obtainMessage(1006));
        }
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || (handler = this.f71563b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1003, arrayList));
    }
}
