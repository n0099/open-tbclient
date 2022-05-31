package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qu9;
import com.repackage.tu9;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public final class sv9<T> implements qu9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final iv9<qu9<? extends Notification<?>>, qu9<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final qu9<T> a;
    public final iv9<? super qu9<? extends Notification<?>>, ? extends qu9<?>> b;
    public final boolean c;
    public final boolean d;
    public final tu9 e;

    /* loaded from: classes7.dex */
    public static class a implements iv9<qu9<? extends Notification<?>>, qu9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.sv9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0523a implements iv9<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0523a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.iv9
            public Notification<?> call(Notification<?> notification) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) ? Notification.c(null) : (Notification) invokeL.objValue;
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.repackage.qu9<R>, com.repackage.qu9<?> */
        @Override // com.repackage.iv9
        public qu9<?> call(qu9<? extends Notification<?>> qu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qu9Var)) == null) ? qu9Var.h(new C0523a(this)) : (qu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements dv9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu9 a;
        public final /* synthetic */ iz9 b;
        public final /* synthetic */ jw9 c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ mz9 e;
        public final /* synthetic */ sv9 f;

        /* loaded from: classes7.dex */
        public class a extends wu9<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean e;
            public final /* synthetic */ b f;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = bVar;
            }

            @Override // com.repackage.wu9
            public void f(su9 su9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, su9Var) == null) {
                    this.f.c.c(su9Var);
                }
            }

            public final void g() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    do {
                        j = this.f.d.get();
                        if (j == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!this.f.d.compareAndSet(j, j - 1));
                }
            }

            @Override // com.repackage.ru9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.a());
            }

            @Override // com.repackage.ru9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.b(th));
            }

            @Override // com.repackage.ru9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.e) {
                    return;
                }
                this.f.a.onNext(t);
                g();
                this.f.c.b(1L);
            }
        }

        public b(sv9 sv9Var, wu9 wu9Var, iz9 iz9Var, jw9 jw9Var, AtomicLong atomicLong, mz9 mz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv9Var, wu9Var, iz9Var, jw9Var, atomicLong, mz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = sv9Var;
            this.a = wu9Var;
            this.b = iz9Var;
            this.c = jw9Var;
            this.d = atomicLong;
            this.e = mz9Var;
        }

        @Override // com.repackage.dv9
        public void call() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isUnsubscribed()) {
                return;
            }
            a aVar = new a(this);
            this.e.a(aVar);
            this.f.a.B(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements qu9.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv9 a;

        /* loaded from: classes7.dex */
        public class a extends wu9<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wu9 e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, wu9 wu9Var, wu9 wu9Var2) {
                super(wu9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, wu9Var, wu9Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((wu9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = wu9Var2;
            }

            @Override // com.repackage.wu9
            public void f(su9 su9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, su9Var) == null) {
                    su9Var.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ru9
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification) == null) {
                    if (notification.i() && this.f.a.c) {
                        this.e.onCompleted();
                    } else if (notification.j() && this.f.a.d) {
                        this.e.onError(notification.e());
                    } else {
                        this.e.onNext(notification);
                    }
                }
            }

            @Override // com.repackage.ru9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }

            @Override // com.repackage.ru9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }
        }

        public c(sv9 sv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.qu9.b, com.repackage.iv9
        public wu9<? super Notification<?>> call(wu9<? super Notification<?>> wu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wu9Var)) == null) ? new a(this, wu9Var, wu9Var) : (wu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements dv9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu9 a;
        public final /* synthetic */ wu9 b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ tu9.a d;
        public final /* synthetic */ dv9 e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes7.dex */
        public class a extends wu9<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, wu9 wu9Var) {
                super(wu9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, wu9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((wu9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.repackage.wu9
            public void f(su9 su9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, su9Var) == null) {
                    su9Var.request(Long.MAX_VALUE);
                }
            }

            @Override // com.repackage.ru9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.repackage.ru9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.repackage.ru9
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.e.b.isUnsubscribed()) {
                    return;
                }
                if (this.e.c.get() > 0) {
                    d dVar = this.e;
                    dVar.d.b(dVar.e);
                    return;
                }
                this.e.f.compareAndSet(false, true);
            }
        }

        public d(sv9 sv9Var, qu9 qu9Var, wu9 wu9Var, AtomicLong atomicLong, tu9.a aVar, dv9 dv9Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv9Var, qu9Var, wu9Var, atomicLong, aVar, dv9Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu9Var;
            this.b = wu9Var;
            this.c = atomicLong;
            this.d = aVar;
            this.e = dv9Var;
            this.f = atomicBoolean;
        }

        @Override // com.repackage.dv9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements su9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ jw9 b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ tu9.a d;
        public final /* synthetic */ dv9 e;

        public e(sv9 sv9Var, AtomicLong atomicLong, jw9 jw9Var, AtomicBoolean atomicBoolean, tu9.a aVar, dv9 dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv9Var, atomicLong, jw9Var, atomicBoolean, aVar, dv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicLong;
            this.b = jw9Var;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = dv9Var;
        }

        @Override // com.repackage.su9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            lv9.b(this.a, j);
            this.b.request(j);
            if (this.c.compareAndSet(true, false)) {
                this.d.b(this.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755306949, "Lcom/repackage/sv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755306949, "Lcom/repackage/sv9;");
                return;
            }
        }
        f = new a();
    }

    public sv9(qu9<T> qu9Var, iv9<? super qu9<? extends Notification<?>>, ? extends qu9<?>> iv9Var, boolean z, boolean z2, tu9 tu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qu9Var, iv9Var, Boolean.valueOf(z), Boolean.valueOf(z2), tu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = qu9Var;
        this.b = iv9Var;
        this.c = z;
        this.d = z2;
        this.e = tu9Var;
    }

    public static <T> qu9<T> a(qu9<T> qu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qu9Var)) == null) ? b(qu9Var, f) : (qu9) invokeL.objValue;
    }

    public static <T> qu9<T> b(qu9<T> qu9Var, iv9<? super qu9<? extends Notification<?>>, ? extends qu9<?>> iv9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, qu9Var, iv9Var)) == null) ? qu9.a(new sv9(qu9Var, iv9Var, true, false, Schedulers.trampoline())) : (qu9) invokeLL.objValue;
    }

    @Override // com.repackage.qu9.a, com.repackage.ev9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((wu9) ((wu9) obj));
    }

    public void call(wu9<? super T> wu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            tu9.a createWorker = this.e.createWorker();
            wu9Var.b(createWorker);
            mz9 mz9Var = new mz9();
            wu9Var.b(mz9Var);
            hz9<T, T> C = fz9.D().C();
            C.u(uy9.a());
            jw9 jw9Var = new jw9();
            b bVar = new b(this, wu9Var, C, jw9Var, atomicLong, mz9Var);
            createWorker.b(new d(this, this.b.call(C.g(new c(this))), wu9Var, atomicLong, createWorker, bVar, atomicBoolean));
            wu9Var.f(new e(this, atomicLong, jw9Var, atomicBoolean, createWorker, bVar));
        }
    }
}
