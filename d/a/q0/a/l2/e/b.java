package d.a.q0.a.l2.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f49344f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l2.d.b f49345a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a.l2.b f49346b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f49347c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f49348d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f49349e;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49350a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
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
            this.f49350a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 101) {
                this.f49350a.f();
                if (!this.f49350a.f49347c) {
                    this.f49350a.f49349e.removeMessages(101);
                } else {
                    this.f49350a.f49345a.c();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(17663379, "Ld/a/q0/a/l2/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(17663379, "Ld/a/q0/a/l2/e/b;");
                return;
            }
        }
        f49344f = k.f49133a;
    }

    public b(d.a.q0.a.l2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49345a = new d.a.q0.a.l2.d.b();
        this.f49346b = bVar;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f49347c) {
                    return;
                }
                d();
                this.f49349e.sendMessage(this.f49349e.obtainMessage(101));
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f49349e == null) {
            HandlerThread handlerThread = new HandlerThread("cookieSync");
            this.f49348d = handlerThread;
            handlerThread.start();
            this.f49349e = new a(this, this.f49348d.getLooper());
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.f49347c = true;
                if (this.f49348d != null) {
                    this.f49348d.quitSafely();
                }
                this.f49349e = null;
                this.f49348d = null;
            }
        }
    }

    public abstract void f();

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f49347c) {
                    return;
                }
                d();
                this.f49349e.sendMessageDelayed(this.f49349e.obtainMessage(101), 5000L);
            }
        }
    }
}
