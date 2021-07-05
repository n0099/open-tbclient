package com.kwad.sdk.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.n;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public final Map<com.kwad.sdk.glide.load.c, b> f37950a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f37951b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f37952c;

    /* renamed from: d  reason: collision with root package name */
    public final ReferenceQueue<n<?>> f37953d;

    /* renamed from: e  reason: collision with root package name */
    public n.a f37954e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f37955f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public volatile InterfaceC0463a f37956g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0463a {
        void a();
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class b extends WeakReference<n<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.c f37960a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f37961b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public s<?> f37962c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NonNull com.kwad.sdk.glide.load.c cVar, @NonNull n<?> nVar, @NonNull ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, nVar, referenceQueue, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(objArr2[0], (ReferenceQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37960a = (com.kwad.sdk.glide.load.c) com.kwad.sdk.glide.g.j.a(cVar);
            this.f37962c = (nVar.f() && z) ? (s) com.kwad.sdk.glide.g.j.a(nVar.b()) : null;
            this.f37961b = nVar.f();
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f37962c = null;
                clear();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.glide.load.engine.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
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

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) ? new Thread(new Runnable(this, runnable) { // from class: com.kwad.sdk.glide.load.engine.a.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Runnable f37957a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f37958b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, runnable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f37958b = this;
                        this.f37957a = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Process.setThreadPriority(10);
                            this.f37957a.run();
                        }
                    }
                }, "glide-active-resources") : (Thread) invokeL.objValue;
            }
        }));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Executor) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public a(boolean z, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37950a = new HashMap();
        this.f37953d = new ReferenceQueue<>();
        this.f37951b = z;
        this.f37952c = executor;
        executor.execute(new Runnable(this) { // from class: com.kwad.sdk.glide.load.engine.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37959a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37959a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37959a.a();
                }
            }
        });
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (!this.f37955f) {
                try {
                    a((b) this.f37953d.remove());
                    InterfaceC0463a interfaceC0463a = this.f37956g;
                    if (interfaceC0463a != null) {
                        interfaceC0463a.a();
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            synchronized (this) {
                b remove = this.f37950a.remove(cVar);
                if (remove != null) {
                    remove.a();
                }
            }
        }
    }

    public synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, nVar) == null) {
            synchronized (this) {
                b put = this.f37950a.put(cVar, new b(cVar, nVar, this.f37953d, this.f37951b));
                if (put != null) {
                    put.a();
                }
            }
        }
    }

    public void a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            synchronized (this.f37954e) {
                synchronized (this) {
                    this.f37950a.remove(bVar.f37960a);
                    if (bVar.f37961b && bVar.f37962c != null) {
                        n<?> nVar = new n<>(bVar.f37962c, true, false);
                        nVar.a(bVar.f37960a, this.f37954e);
                        this.f37954e.a(bVar.f37960a, nVar);
                    }
                }
            }
        }
    }

    public void a(n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            synchronized (aVar) {
                synchronized (this) {
                    this.f37954e = aVar;
                }
            }
        }
    }

    @Nullable
    public synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            synchronized (this) {
                b bVar = this.f37950a.get(cVar);
                if (bVar == null) {
                    return null;
                }
                n<?> nVar = bVar.get();
                if (nVar == null) {
                    a(bVar);
                }
                return nVar;
            }
        }
        return (n) invokeL.objValue;
    }
}
