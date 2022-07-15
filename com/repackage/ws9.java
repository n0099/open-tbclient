package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
import com.repackage.xr9;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public final class ws9<T> implements ur9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final ms9<ur9<? extends Notification<?>>, ur9<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final ur9<T> a;
    public final ms9<? super ur9<? extends Notification<?>>, ? extends ur9<?>> b;
    public final boolean c;
    public final boolean d;
    public final xr9 e;

    /* loaded from: classes7.dex */
    public static class a implements ms9<ur9<? extends Notification<?>>, ur9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.ws9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0764a implements ms9<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0764a(a aVar) {
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
            @Override // com.repackage.ms9
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.repackage.ur9<R>, com.repackage.ur9<?> */
        @Override // com.repackage.ms9
        public ur9<?> call(ur9<? extends Notification<?>> ur9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ur9Var)) == null) ? ur9Var.h(new C0764a(this)) : (ur9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements hs9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as9 a;
        public final /* synthetic */ mw9 b;
        public final /* synthetic */ nt9 c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ qw9 e;
        public final /* synthetic */ ws9 f;

        /* loaded from: classes7.dex */
        public class a extends as9<T> {
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

            @Override // com.repackage.as9
            public void f(wr9 wr9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr9Var) == null) {
                    this.f.c.c(wr9Var);
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

            @Override // com.repackage.vr9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.a());
            }

            @Override // com.repackage.vr9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.b(th));
            }

            @Override // com.repackage.vr9
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

        public b(ws9 ws9Var, as9 as9Var, mw9 mw9Var, nt9 nt9Var, AtomicLong atomicLong, qw9 qw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ws9Var, as9Var, mw9Var, nt9Var, atomicLong, qw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ws9Var;
            this.a = as9Var;
            this.b = mw9Var;
            this.c = nt9Var;
            this.d = atomicLong;
            this.e = qw9Var;
        }

        @Override // com.repackage.hs9
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
    public class c implements ur9.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ws9 a;

        /* loaded from: classes7.dex */
        public class a extends as9<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ as9 e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, as9 as9Var, as9 as9Var2) {
                super(as9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, as9Var, as9Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((as9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = as9Var2;
            }

            @Override // com.repackage.as9
            public void f(wr9 wr9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr9Var) == null) {
                    wr9Var.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.vr9
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

            @Override // com.repackage.vr9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }

            @Override // com.repackage.vr9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }
        }

        public c(ws9 ws9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ws9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ws9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ur9.b, com.repackage.ms9
        public as9<? super Notification<?>> call(as9<? super Notification<?>> as9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, as9Var)) == null) ? new a(this, as9Var, as9Var) : (as9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements hs9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur9 a;
        public final /* synthetic */ as9 b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ xr9.a d;
        public final /* synthetic */ hs9 e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes7.dex */
        public class a extends as9<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, as9 as9Var) {
                super(as9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, as9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((as9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.repackage.as9
            public void f(wr9 wr9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wr9Var) == null) {
                    wr9Var.request(Long.MAX_VALUE);
                }
            }

            @Override // com.repackage.vr9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.repackage.vr9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.repackage.vr9
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

        public d(ws9 ws9Var, ur9 ur9Var, as9 as9Var, AtomicLong atomicLong, xr9.a aVar, hs9 hs9Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ws9Var, ur9Var, as9Var, atomicLong, aVar, hs9Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur9Var;
            this.b = as9Var;
            this.c = atomicLong;
            this.d = aVar;
            this.e = hs9Var;
            this.f = atomicBoolean;
        }

        @Override // com.repackage.hs9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements wr9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ nt9 b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ xr9.a d;
        public final /* synthetic */ hs9 e;

        public e(ws9 ws9Var, AtomicLong atomicLong, nt9 nt9Var, AtomicBoolean atomicBoolean, xr9.a aVar, hs9 hs9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ws9Var, atomicLong, nt9Var, atomicBoolean, aVar, hs9Var};
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
            this.b = nt9Var;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = hs9Var;
        }

        @Override // com.repackage.wr9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            ps9.b(this.a, j);
            this.b.request(j);
            if (this.c.compareAndSet(true, false)) {
                this.d.b(this.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755190668, "Lcom/repackage/ws9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755190668, "Lcom/repackage/ws9;");
                return;
            }
        }
        f = new a();
    }

    public ws9(ur9<T> ur9Var, ms9<? super ur9<? extends Notification<?>>, ? extends ur9<?>> ms9Var, boolean z, boolean z2, xr9 xr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ur9Var, ms9Var, Boolean.valueOf(z), Boolean.valueOf(z2), xr9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ur9Var;
        this.b = ms9Var;
        this.c = z;
        this.d = z2;
        this.e = xr9Var;
    }

    public static <T> ur9<T> a(ur9<T> ur9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ur9Var)) == null) ? b(ur9Var, f) : (ur9) invokeL.objValue;
    }

    public static <T> ur9<T> b(ur9<T> ur9Var, ms9<? super ur9<? extends Notification<?>>, ? extends ur9<?>> ms9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ur9Var, ms9Var)) == null) ? ur9.a(new ws9(ur9Var, ms9Var, true, false, Schedulers.trampoline())) : (ur9) invokeLL.objValue;
    }

    @Override // com.repackage.ur9.a, com.repackage.is9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((as9) ((as9) obj));
    }

    public void call(as9<? super T> as9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            xr9.a createWorker = this.e.createWorker();
            as9Var.b(createWorker);
            qw9 qw9Var = new qw9();
            as9Var.b(qw9Var);
            lw9<T, T> C = jw9.D().C();
            C.u(yv9.a());
            nt9 nt9Var = new nt9();
            b bVar = new b(this, as9Var, C, nt9Var, atomicLong, qw9Var);
            createWorker.b(new d(this, this.b.call(C.g(new c(this))), as9Var, atomicLong, createWorker, bVar, atomicBoolean));
            as9Var.f(new e(this, atomicLong, nt9Var, atomicBoolean, createWorker, bVar));
        }
    }
}
