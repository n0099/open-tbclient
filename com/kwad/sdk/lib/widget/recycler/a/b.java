package com.kwad.sdk.lib.widget.recycler.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public final class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Executor f38539a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Executor f38540b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final e<T> f38541c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f38542d;

    /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class a<T> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final Object f38543e;

        /* renamed from: f  reason: collision with root package name */
        public static Executor f38544f;

        /* renamed from: g  reason: collision with root package name */
        public static final Executor f38545g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Executor f38546a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f38547b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f38548c;

        /* renamed from: d  reason: collision with root package name */
        public final e<T> f38549d;

        /* renamed from: com.kwad.sdk.lib.widget.recycler.a.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class ExecutorC0473a implements Executor {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final Handler f38550a;

            public ExecutorC0473a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38550a = new Handler(Looper.getMainLooper());
            }

            public /* synthetic */ ExecutorC0473a(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                    this.f38550a.post(runnable);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1977462700, "Lcom/kwad/sdk/lib/widget/recycler/a/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1977462700, "Lcom/kwad/sdk/lib/widget/recycler/a/b$a;");
                    return;
                }
            }
            f38543e = new Object();
            f38545g = new ExecutorC0473a(null);
        }

        public a(@NonNull e<T> eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f38549d = eVar;
        }

        @NonNull
        public a<T> a(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, executor)) == null) {
                this.f38547b = executor;
                return this;
            }
            return (a) invokeL.objValue;
        }

        @NonNull
        public b<T> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f38546a == null) {
                    this.f38546a = f38545g;
                }
                if (this.f38547b == null) {
                    synchronized (f38543e) {
                        if (f38544f == null) {
                            f38544f = Executors.newFixedThreadPool(2);
                        }
                    }
                    this.f38547b = f38544f;
                }
                return new b<>(this.f38546a, this.f38547b, this.f38549d, this.f38548c, null);
            }
            return (b) invokeV.objValue;
        }
    }

    public b(@NonNull Executor executor, @NonNull Executor executor2, @NonNull e<T> eVar, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, executor2, eVar, runnable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38539a = executor;
        this.f38540b = executor2;
        this.f38541c = eVar;
        this.f38542d = runnable;
    }

    public /* synthetic */ b(Executor executor, Executor executor2, e eVar, Runnable runnable, AnonymousClass1 anonymousClass1) {
        this(executor, executor2, eVar, runnable);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38539a : (Executor) invokeV.objValue;
    }

    @NonNull
    public Executor b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38540b : (Executor) invokeV.objValue;
    }

    @NonNull
    public e<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38541c : (e) invokeV.objValue;
    }

    @Nullable
    public Runnable d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38542d : (Runnable) invokeV.objValue;
    }
}
