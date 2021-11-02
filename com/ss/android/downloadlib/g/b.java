package com.ss.android.downloadlib.g;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f68844a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.ss.android.downloadlib.g.b$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, asyncTask, tArr) == null) {
                try {
                    asyncTask.execute(tArr);
                } catch (Throwable unused) {
                }
            }
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1976b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1976b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.ss.android.downloadlib.g.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, asyncTask, tArr) == null) {
                try {
                    asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
                } catch (Throwable unused) {
                }
            }
        }

        public /* synthetic */ C1976b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1671141288, "Lcom/ss/android/downloadlib/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1671141288, "Lcom/ss/android/downloadlib/g/b;");
                return;
            }
        }
        f68844a = new C1976b(null);
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, asyncTask, tArr) == null) {
            f68844a.a(asyncTask, tArr);
        }
    }
}
