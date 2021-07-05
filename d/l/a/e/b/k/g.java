package d.l.a.e.b.k;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Object f74851a;

    /* renamed from: b  reason: collision with root package name */
    public Queue<b> f74852b;

    /* renamed from: c  reason: collision with root package name */
    public a f74853c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f74854d;

    /* loaded from: classes10.dex */
    public class a extends HandlerThread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f74855e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
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
            this.f74855e = gVar;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onLooperPrepared();
                Looper looper = getLooper();
                synchronized (this.f74855e.f74851a) {
                    this.f74855e.f74854d = new Handler(looper);
                }
                while (!this.f74855e.f74852b.isEmpty()) {
                    b bVar = (b) this.f74855e.f74852b.poll();
                    this.f74855e.f74854d.postDelayed(bVar.f74856a, bVar.f74857b);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Runnable f74856a;

        /* renamed from: b  reason: collision with root package name */
        public long f74857b;

        public b(g gVar, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74856a = runnable;
            this.f74857b = j;
        }
    }

    public g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74851a = new Object();
        this.f74852b = new ConcurrentLinkedQueue();
        this.f74853c = new a(this, str);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f74853c.start();
        }
    }

    public void d(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            e(runnable, 0L);
        }
    }

    public void e(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, runnable, j) == null) {
            if (this.f74854d == null) {
                synchronized (this.f74851a) {
                    if (this.f74854d == null) {
                        this.f74852b.add(new b(this, runnable, j));
                        return;
                    }
                }
            }
            this.f74854d.postDelayed(runnable, j);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f74853c.quit();
        }
    }
}
