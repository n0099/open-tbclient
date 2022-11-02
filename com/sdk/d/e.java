package com.sdk.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class e<Params, Progress, Result> implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final b a;
    public static final Executor b;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<Params, Result> c;
    public final FutureTask<Result> d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public volatile boolean g;
    public Boolean h;
    public com.sdk.d.b i;

    /* loaded from: classes8.dex */
    public static class a<Data> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;
        public final Data[] b;

        public a(e eVar, Data... dataArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, dataArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = dataArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593226800, "Lcom/sdk/d/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593226800, "Lcom/sdk/d/e;");
                return;
            }
        }
        a = new b(null);
        b = new g();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new AtomicBoolean();
        this.f = new AtomicBoolean();
        this.g = false;
        this.h = Boolean.valueOf(com.sdk.f.g.c);
        this.c = new com.sdk.d.c(this);
        this.d = new d(this, this.c);
    }

    public final Result a(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            a.obtainMessage(1, new a(this, result)).sendToTarget();
            return result;
        }
        return (Result) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(com.sdk.d.c cVar) {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                a aVar = (a) message.obj;
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        e eVar = aVar.a;
                        Object[] objArr = aVar.b;
                        com.sdk.a.e eVar2 = (com.sdk.a.e) eVar;
                        if (eVar2.p != e.a.e && objArr != null && objArr.length != 0 && eVar2.m != null) {
                            int intValue = ((Integer) objArr[0]).intValue();
                            if (intValue != 1) {
                                if (intValue != 2) {
                                    if (intValue != 3) {
                                        if (intValue == 4 && objArr.length == 2) {
                                            eVar2.p = e.a.f;
                                            eVar2.m.a((com.sdk.a.i) objArr[1], eVar2.y.d);
                                            return;
                                        }
                                        return;
                                    } else if (objArr.length == 3) {
                                        eVar2.p = e.a.d;
                                        Object obj = eVar2.m;
                                        int intValue2 = ((Integer) objArr[1]).intValue();
                                        com.sdk.g.b bVar = ((com.sdk.g.a) obj).b;
                                        String str = ((Object) ((String) objArr[2])) + "";
                                        com.sdk.e.a<T> aVar2 = bVar.g;
                                        if (aVar2 != 0) {
                                            aVar2.a(intValue2, 302002, str);
                                            bVar.g = null;
                                            return;
                                        }
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (objArr.length == 3) {
                                    eVar2.p = e.a.c;
                                    eVar2.m.a(Long.parseLong(String.valueOf(objArr[1])), Long.parseLong(String.valueOf(objArr[2])), eVar2.r);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            eVar2.p = e.a.b;
                            eVar2.m.b();
                            return;
                        }
                        return;
                    }
                    return;
                }
                e.c(aVar.a, aVar.b[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class c<Params, Result> implements Callable<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Params[] a;

        public /* synthetic */ c(com.sdk.d.c cVar) {
        }
    }

    public static /* synthetic */ void b(e eVar, Object obj) {
        if (!eVar.f.get()) {
            eVar.a((e) obj);
        }
    }

    public static /* synthetic */ void c(e eVar, Object obj) {
        eVar.e.get();
    }

    public final void a(Progress... progressArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, progressArr) == null) && !this.e.get()) {
            a.obtainMessage(2, new a(this, progressArr)).sendToTarget();
        }
    }
}
