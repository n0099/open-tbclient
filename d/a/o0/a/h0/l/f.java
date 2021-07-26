package d.a.o0.a.h0.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f implements V8ThreadDelegatePolicy, d.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45369h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public V8Engine f45370b;

    /* renamed from: c  reason: collision with root package name */
    public Thread f45371c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f45372d;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f45373e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f45374f;

    /* renamed from: g  reason: collision with root package name */
    public int f45375g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45376e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45376e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                this.f45376e.f45372d = new Handler();
                this.f45376e.f45370b.startEngineInternal();
                Looper.loop();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447400872, "Ld/a/o0/a/h0/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447400872, "Ld/a/o0/a/h0/l/f;");
                return;
            }
        }
        f45369h = d.a.o0.a.v2.d.a();
    }

    public f() {
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
        this.f45370b = null;
        this.f45371c = null;
        this.f45372d = null;
        this.f45374f = null;
        this.f45375g = 0;
        this.f45373e = Looper.getMainLooper().getThread();
    }

    public final boolean c(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable != null && this.f45372d != null) {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                    this.f45372d.postAtFrontOfQueue(runnable);
                    return true;
                }
                if (this.f45373e == currentThread) {
                    if (f45369h) {
                        Runnable runnable2 = this.f45374f;
                        if (runnable2 == null) {
                            this.f45372d.postAtFrontOfQueue(runnable);
                        } else if (this.f45372d.hasCallbacks(runnable2)) {
                            this.f45372d.post(runnable);
                        } else {
                            this.f45372d.postAtFrontOfQueue(runnable);
                        }
                        this.f45374f = runnable;
                    } else {
                        boolean hasMessages = this.f45372d.hasMessages(this.f45375g);
                        this.f45375g++;
                        Message obtain = Message.obtain(this.f45372d, runnable);
                        obtain.what = this.f45375g;
                        if (hasMessages) {
                            this.f45372d.sendMessage(obtain);
                        } else {
                            this.f45372d.sendMessageAtFrontOfQueue(obtain);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Engine) == null) {
            this.f45370b = v8Engine;
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || this.f45372d == null || c(runnable)) {
            return;
        }
        this.f45372d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) || this.f45372d == null || c(runnable)) {
            return;
        }
        this.f45372d.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Handler handler = this.f45372d;
            if (handler != null) {
                return handler.getLooper().getThread();
            }
            return null;
        }
        return (Thread) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (handler = this.f45372d) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.f45372d.getLooper().quitSafely();
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, v8Engine) == null) && this.f45371c == null) {
            Thread thread = new Thread(new a(this));
            this.f45371c = thread;
            thread.setName(v8Engine.threadName());
            this.f45371c.setPriority(10);
            this.f45371c.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, runnable, j) == null) || this.f45372d == null || c(runnable)) {
            return;
        }
        this.f45372d.postDelayed(runnable, j);
    }
}
