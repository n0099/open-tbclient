package com.ksad.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.L;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes7.dex */
public class k<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Executor f33825a;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Thread f33826b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<h<T>> f33827c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<h<Throwable>> f33828d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f33829e;

    /* renamed from: f  reason: collision with root package name */
    public final FutureTask<j<T>> f33830f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile j<T> f33831g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1819786166, "Lcom/ksad/lottie/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1819786166, "Lcom/ksad/lottie/k;");
                return;
            }
        }
        f33825a = Executors.newCachedThreadPool();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(Callable<j<T>> callable) {
        this(callable, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Callable) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(Callable<j<T>> callable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f33827c = new LinkedHashSet(1);
        this.f33828d = new LinkedHashSet(1);
        this.f33829e = new Handler(Looper.getMainLooper());
        this.f33831g = null;
        FutureTask<j<T>> futureTask = new FutureTask<>(callable);
        this.f33830f = futureTask;
        if (!z) {
            f33825a.execute(futureTask);
            b();
            return;
        }
        try {
            a((j) callable.call());
        } catch (Throwable th) {
            a((j) new j<>(th));
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f33829e.post(new Runnable(this) { // from class: com.ksad.lottie.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ k f33832a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f33832a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f33832a.f33831g == null || this.f33832a.f33830f.isCancelled()) {
                        return;
                    }
                    j jVar = this.f33832a.f33831g;
                    if (jVar.a() != null) {
                        this.f33832a.a((k) jVar.a());
                    } else {
                        this.f33832a.a(jVar.b());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable j<T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, jVar) == null) {
            if (this.f33831g != null) {
                throw new IllegalStateException("A task may only be set once.");
            }
            this.f33831g = jVar;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, t) == null) {
            for (h hVar : new ArrayList(this.f33827c)) {
                hVar.a(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, th) == null) {
            ArrayList<h> arrayList = new ArrayList(this.f33828d);
            if (arrayList.isEmpty()) {
                Log.w(L.TAG, "Lottie encountered an error but no failure listener was added.", th);
                return;
            }
            for (h hVar : arrayList) {
                hVar.a(th);
            }
        }
    }

    private synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            synchronized (this) {
                if (!d() && this.f33831g == null) {
                    Thread thread = new Thread(this, "LottieTaskObserver") { // from class: com.ksad.lottie.k.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ k f33833a;

                        /* renamed from: b  reason: collision with root package name */
                        public boolean f33834b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r8};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f33833a = this;
                            this.f33834b = false;
                        }

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                while (!isInterrupted() && !this.f33834b) {
                                    if (this.f33833a.f33830f.isDone()) {
                                        try {
                                            this.f33833a.a((j) this.f33833a.f33830f.get());
                                        } catch (InterruptedException | ExecutionException e2) {
                                            this.f33833a.a(new j(e2));
                                        }
                                        this.f33834b = true;
                                        this.f33833a.c();
                                    }
                                }
                            }
                        }
                    };
                    this.f33826b = thread;
                    thread.start();
                    c.a("Starting TaskObserver thread");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            synchronized (this) {
                if (d()) {
                    if (this.f33827c.isEmpty() || this.f33831g != null) {
                        this.f33826b.interrupt();
                        this.f33826b = null;
                        c.a("Stopping TaskObserver thread");
                    }
                }
            }
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Thread thread = this.f33826b;
            return thread != null && thread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public synchronized k<T> a(h<T> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            synchronized (this) {
                if (this.f33831g != null && this.f33831g.a() != null) {
                    hVar.a(this.f33831g.a());
                }
                this.f33827c.add(hVar);
                b();
            }
            return this;
        }
        return (k) invokeL.objValue;
    }

    public synchronized k<T> b(h<T> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar)) == null) {
            synchronized (this) {
                this.f33827c.remove(hVar);
                c();
            }
            return this;
        }
        return (k) invokeL.objValue;
    }

    public synchronized k<T> c(h<Throwable> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar)) == null) {
            synchronized (this) {
                if (this.f33831g != null && this.f33831g.b() != null) {
                    hVar.a(this.f33831g.b());
                }
                this.f33828d.add(hVar);
                b();
            }
            return this;
        }
        return (k) invokeL.objValue;
    }

    public synchronized k<T> d(h<Throwable> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) {
            synchronized (this) {
                this.f33828d.remove(hVar);
                c();
            }
            return this;
        }
        return (k) invokeL.objValue;
    }
}
