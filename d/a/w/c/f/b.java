package d.a.w.c.f;

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
import d.a.w.b.g.c;
import d.a.w.c.g.d;
import d.a.w.c.g.e;
import d.a.w.c.g.g;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static final String f68364h = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f68365a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68366b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w.b.a f68367c;

    /* renamed from: d  reason: collision with root package name */
    public g f68368d;

    /* renamed from: e  reason: collision with root package name */
    public e f68369e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f68370f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68371g;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<c> f68372a;

        /* renamed from: b  reason: collision with root package name */
        public d f68373b;

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
            this.f68372a = arrayList;
            this.f68373b = dVar;
        }
    }

    /* renamed from: d.a.w.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC1948b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f68374a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1948b(b bVar, Looper looper) {
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
            this.f68374a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        a aVar = (a) message.obj;
                        this.f68374a.n(aVar.f68372a, aVar.f68373b);
                        return;
                    case 1002:
                        this.f68374a.o();
                        return;
                    case 1003:
                        this.f68374a.r((ArrayList) message.obj);
                        return;
                    case 1004:
                        this.f68374a.q((d.a.w.b.e.c) message.obj);
                        return;
                    case 1005:
                        this.f68374a.k((message.arg1 << 32) | (message.arg2 & 4294967295L));
                        return;
                    case 1006:
                        this.f68374a.p();
                        return;
                    case 1007:
                        this.f68374a.m();
                        return;
                    case 1008:
                        this.f68374a.l();
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1705933845, "Ld/a/w/c/f/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1705933845, "Ld/a/w/c/f/b;");
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
        this.f68370f = false;
        this.f68371g = false;
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i2 = (int) (j >> 32);
            int i3 = (int) j;
            if (this.f68366b == null || !this.f68370f) {
                return;
            }
            Handler handler = this.f68366b;
            handler.sendMessage(handler.obtainMessage(1005, i2, i3));
            synchronized (this.f68367c) {
                try {
                    if (this.f68371g) {
                        this.f68367c.wait(12L);
                    } else {
                        this.f68367c.wait(2L);
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
            g gVar = this.f68368d;
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
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f68368d) == null) {
            return;
        }
        gVar.c(false);
        this.f68367c.a(j);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Handler handler = this.f68366b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f68366b = null;
            }
            HandlerThread handlerThread = this.f68365a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.f68365a = null;
            }
        }
    }

    public final void m() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f68368d) == null) {
            return;
        }
        gVar.i();
        this.f68368d.e();
        this.f68368d = null;
        this.f68369e = null;
        this.f68367c.c();
        this.f68367c = null;
    }

    public final void n(ArrayList<c> arrayList, d dVar) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, arrayList, dVar) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f68368d) == null) {
            return;
        }
        gVar.l(dVar, this.f68369e);
        if (this.f68367c == null) {
            this.f68367c = new d.a.w.b.a(this.f68368d.k(), arrayList);
        }
    }

    public final void o() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f68368d) == null) {
            return;
        }
        gVar.h();
    }

    public final void p() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || Build.VERSION.SDK_INT < 18 || (gVar = this.f68368d) == null) {
            return;
        }
        gVar.c(true);
    }

    public final void q(d.a.w.b.e.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f68367c.d(cVar);
    }

    public final void r(ArrayList<c> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.f68367c.e(arrayList);
    }

    public final void s(e eVar, d.a.w.c.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, eVar, cVar) == null) {
            HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
            this.f68365a = handlerThread;
            handlerThread.start();
            this.f68366b = new HandlerC1948b(this, this.f68365a.getLooper());
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    this.f68368d = new g();
                } catch (VerifyError unused) {
                    Log.e(f68364h, "initRecorder videorecorder verifyError");
                    if (this.f68368d == null) {
                        return;
                    }
                }
                this.f68368d.f(cVar);
                this.f68369e = eVar;
            }
            if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
                this.f68371g = true;
            } else {
                this.f68371g = false;
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HandlerThread handlerThread = this.f68365a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f68366b != null && this.f68370f) {
            this.f68366b.removeMessages(1005);
        }
    }

    public void v() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (handler = this.f68366b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.f68366b;
        handler2.sendMessage(handler2.obtainMessage(1007));
        Handler handler3 = this.f68366b;
        handler3.sendMessage(handler3.obtainMessage(1008));
    }

    public boolean w(ArrayList<c> arrayList, d dVar, e eVar, d.a.w.c.g.c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, arrayList, dVar, eVar, cVar)) == null) {
            if (t()) {
                Log.e(f68364h, "setupRecorder error! As last video recorder thread is alive!");
                return false;
            }
            s(eVar, cVar);
            a aVar = new a(this, arrayList, dVar);
            Handler handler = this.f68366b;
            handler.sendMessage(handler.obtainMessage(1001, aVar));
            this.f68370f = true;
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void x() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (handler = this.f68366b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f68366b != null && this.f68370f) {
            this.f68370f = false;
            this.f68366b.removeMessages(1005);
            Handler handler = this.f68366b;
            handler.sendMessage(handler.obtainMessage(1006));
        }
    }

    public void z(ArrayList<c> arrayList) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || (handler = this.f68366b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1003, arrayList));
    }
}
