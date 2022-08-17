package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru9;
import com.repackage.uu9;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public final class tv9<T> implements ru9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final jv9<ru9<? extends Notification<?>>, ru9<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final ru9<T> a;
    public final jv9<? super ru9<? extends Notification<?>>, ? extends ru9<?>> b;
    public final boolean c;
    public final boolean d;
    public final uu9 e;

    /* loaded from: classes7.dex */
    public static class a implements jv9<ru9<? extends Notification<?>>, ru9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.tv9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0593a implements jv9<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0593a(a aVar) {
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
            @Override // com.repackage.jv9
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.repackage.ru9<R>, com.repackage.ru9<?> */
        @Override // com.repackage.jv9
        public ru9<?> call(ru9<? extends Notification<?>> ru9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ru9Var)) == null) ? ru9Var.h(new C0593a(this)) : (ru9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu9 a;
        public final /* synthetic */ jz9 b;
        public final /* synthetic */ kw9 c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ nz9 e;
        public final /* synthetic */ tv9 f;

        /* loaded from: classes7.dex */
        public class a extends xu9<T> {
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

            @Override // com.repackage.xu9
            public void f(tu9 tu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, tu9Var) == null) {
                    this.f.c.c(tu9Var);
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

            @Override // com.repackage.su9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.a());
            }

            @Override // com.repackage.su9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.b(th));
            }

            @Override // com.repackage.su9
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

        public b(tv9 tv9Var, xu9 xu9Var, jz9 jz9Var, kw9 kw9Var, AtomicLong atomicLong, nz9 nz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv9Var, xu9Var, jz9Var, kw9Var, atomicLong, nz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tv9Var;
            this.a = xu9Var;
            this.b = jz9Var;
            this.c = kw9Var;
            this.d = atomicLong;
            this.e = nz9Var;
        }

        @Override // com.repackage.ev9
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
    public class c implements ru9.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv9 a;

        /* loaded from: classes7.dex */
        public class a extends xu9<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xu9 e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, xu9 xu9Var, xu9 xu9Var2) {
                super(xu9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, xu9Var, xu9Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((xu9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = xu9Var2;
            }

            @Override // com.repackage.xu9
            public void f(tu9 tu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, tu9Var) == null) {
                    tu9Var.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.su9
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

            @Override // com.repackage.su9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }

            @Override // com.repackage.su9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }
        }

        public c(tv9 tv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ru9.b, com.repackage.jv9
        public xu9<? super Notification<?>> call(xu9<? super Notification<?>> xu9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xu9Var)) == null) ? new a(this, xu9Var, xu9Var) : (xu9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru9 a;
        public final /* synthetic */ xu9 b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ uu9.a d;
        public final /* synthetic */ ev9 e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes7.dex */
        public class a extends xu9<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, xu9 xu9Var) {
                super(xu9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, xu9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((xu9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.repackage.xu9
            public void f(tu9 tu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, tu9Var) == null) {
                    tu9Var.request(Long.MAX_VALUE);
                }
            }

            @Override // com.repackage.su9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.repackage.su9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.repackage.su9
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

        public d(tv9 tv9Var, ru9 ru9Var, xu9 xu9Var, AtomicLong atomicLong, uu9.a aVar, ev9 ev9Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv9Var, ru9Var, xu9Var, atomicLong, aVar, ev9Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ru9Var;
            this.b = xu9Var;
            this.c = atomicLong;
            this.d = aVar;
            this.e = ev9Var;
            this.f = atomicBoolean;
        }

        @Override // com.repackage.ev9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements tu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ kw9 b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ uu9.a d;
        public final /* synthetic */ ev9 e;

        public e(tv9 tv9Var, AtomicLong atomicLong, kw9 kw9Var, AtomicBoolean atomicBoolean, uu9.a aVar, ev9 ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv9Var, atomicLong, kw9Var, atomicBoolean, aVar, ev9Var};
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
            this.b = kw9Var;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = ev9Var;
        }

        @Override // com.repackage.tu9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            mv9.b(this.a, j);
            this.b.request(j);
            if (this.c.compareAndSet(true, false)) {
                this.d.b(this.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755277158, "Lcom/repackage/tv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755277158, "Lcom/repackage/tv9;");
                return;
            }
        }
        f = new a();
    }

    public tv9(ru9<T> ru9Var, jv9<? super ru9<? extends Notification<?>>, ? extends ru9<?>> jv9Var, boolean z, boolean z2, uu9 uu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ru9Var, jv9Var, Boolean.valueOf(z), Boolean.valueOf(z2), uu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ru9Var;
        this.b = jv9Var;
        this.c = z;
        this.d = z2;
        this.e = uu9Var;
    }

    public static <T> ru9<T> a(ru9<T> ru9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ru9Var)) == null) ? b(ru9Var, f) : (ru9) invokeL.objValue;
    }

    public static <T> ru9<T> b(ru9<T> ru9Var, jv9<? super ru9<? extends Notification<?>>, ? extends ru9<?>> jv9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ru9Var, jv9Var)) == null) ? ru9.a(new tv9(ru9Var, jv9Var, true, false, Schedulers.trampoline())) : (ru9) invokeLL.objValue;
    }

    @Override // com.repackage.ru9.a, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xu9) ((xu9) obj));
    }

    public void call(xu9<? super T> xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            uu9.a createWorker = this.e.createWorker();
            xu9Var.b(createWorker);
            nz9 nz9Var = new nz9();
            xu9Var.b(nz9Var);
            iz9<T, T> C = gz9.D().C();
            C.u(vy9.a());
            kw9 kw9Var = new kw9();
            b bVar = new b(this, xu9Var, C, kw9Var, atomicLong, nz9Var);
            createWorker.b(new d(this, this.b.call(C.g(new c(this))), xu9Var, atomicLong, createWorker, bVar, atomicBoolean));
            xu9Var.f(new e(this, atomicLong, kw9Var, atomicBoolean, createWorker, bVar));
        }
    }
}
