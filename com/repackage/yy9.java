package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wx9;
import com.repackage.zx9;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public final class yy9<T> implements wx9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final oy9<wx9<? extends Notification<?>>, wx9<?>> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final wx9<T> a;
    public final oy9<? super wx9<? extends Notification<?>>, ? extends wx9<?>> b;
    public final boolean c;
    public final boolean d;
    public final zx9 e;

    /* loaded from: classes7.dex */
    public static class a implements oy9<wx9<? extends Notification<?>>, wx9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.yy9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0567a implements oy9<Notification<?>, Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0567a(a aVar) {
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
            @Override // com.repackage.oy9
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
        /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: com.repackage.wx9<R>, com.repackage.wx9<?> */
        @Override // com.repackage.oy9
        public wx9<?> call(wx9<? extends Notification<?>> wx9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wx9Var)) == null) ? wx9Var.h(new C0567a(this)) : (wx9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements jy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cy9 a;
        public final /* synthetic */ o2a b;
        public final /* synthetic */ pz9 c;
        public final /* synthetic */ AtomicLong d;
        public final /* synthetic */ s2a e;
        public final /* synthetic */ yy9 f;

        /* loaded from: classes7.dex */
        public class a extends cy9<T> {
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

            @Override // com.repackage.cy9
            public void f(yx9 yx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, yx9Var) == null) {
                    this.f.c.c(yx9Var);
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

            @Override // com.repackage.xx9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.a());
            }

            @Override // com.repackage.xx9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || this.e) {
                    return;
                }
                this.e = true;
                unsubscribe();
                this.f.b.onNext(Notification.b(th));
            }

            @Override // com.repackage.xx9
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

        public b(yy9 yy9Var, cy9 cy9Var, o2a o2aVar, pz9 pz9Var, AtomicLong atomicLong, s2a s2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy9Var, cy9Var, o2aVar, pz9Var, atomicLong, s2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = yy9Var;
            this.a = cy9Var;
            this.b = o2aVar;
            this.c = pz9Var;
            this.d = atomicLong;
            this.e = s2aVar;
        }

        @Override // com.repackage.jy9
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
    public class c implements wx9.b<Notification<?>, Notification<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy9 a;

        /* loaded from: classes7.dex */
        public class a extends cy9<Notification<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cy9 e;
            public final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, cy9 cy9Var, cy9 cy9Var2) {
                super(cy9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cy9Var, cy9Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((cy9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
                this.e = cy9Var2;
            }

            @Override // com.repackage.cy9
            public void f(yx9 yx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, yx9Var) == null) {
                    yx9Var.request(Long.MAX_VALUE);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.xx9
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

            @Override // com.repackage.xx9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.e.onCompleted();
                }
            }

            @Override // com.repackage.xx9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.e.onError(th);
                }
            }
        }

        public c(yy9 yy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.wx9.b, com.repackage.oy9
        public cy9<? super Notification<?>> call(cy9<? super Notification<?>> cy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cy9Var)) == null) ? new a(this, cy9Var, cy9Var) : (cy9) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements jy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx9 a;
        public final /* synthetic */ cy9 b;
        public final /* synthetic */ AtomicLong c;
        public final /* synthetic */ zx9.a d;
        public final /* synthetic */ jy9 e;
        public final /* synthetic */ AtomicBoolean f;

        /* loaded from: classes7.dex */
        public class a extends cy9<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, cy9 cy9Var) {
                super(cy9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, cy9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((cy9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
            }

            @Override // com.repackage.cy9
            public void f(yx9 yx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, yx9Var) == null) {
                    yx9Var.request(Long.MAX_VALUE);
                }
            }

            @Override // com.repackage.xx9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.e.b.onCompleted();
                }
            }

            @Override // com.repackage.xx9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.b.onError(th);
                }
            }

            @Override // com.repackage.xx9
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

        public d(yy9 yy9Var, wx9 wx9Var, cy9 cy9Var, AtomicLong atomicLong, zx9.a aVar, jy9 jy9Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy9Var, wx9Var, cy9Var, atomicLong, aVar, jy9Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx9Var;
            this.b = cy9Var;
            this.c = atomicLong;
            this.d = aVar;
            this.e = jy9Var;
            this.f = atomicBoolean;
        }

        @Override // com.repackage.jy9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B(new a(this, this.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements yx9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicLong a;
        public final /* synthetic */ pz9 b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ zx9.a d;
        public final /* synthetic */ jy9 e;

        public e(yy9 yy9Var, AtomicLong atomicLong, pz9 pz9Var, AtomicBoolean atomicBoolean, zx9.a aVar, jy9 jy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy9Var, atomicLong, pz9Var, atomicBoolean, aVar, jy9Var};
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
            this.b = pz9Var;
            this.c = atomicBoolean;
            this.d = aVar;
            this.e = jy9Var;
        }

        @Override // com.repackage.yx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                return;
            }
            ry9.b(this.a, j);
            this.b.request(j);
            if (this.c.compareAndSet(true, false)) {
                this.d.b(this.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755125320, "Lcom/repackage/yy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755125320, "Lcom/repackage/yy9;");
                return;
            }
        }
        f = new a();
    }

    public yy9(wx9<T> wx9Var, oy9<? super wx9<? extends Notification<?>>, ? extends wx9<?>> oy9Var, boolean z, boolean z2, zx9 zx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wx9Var, oy9Var, Boolean.valueOf(z), Boolean.valueOf(z2), zx9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = wx9Var;
        this.b = oy9Var;
        this.c = z;
        this.d = z2;
        this.e = zx9Var;
    }

    public static <T> wx9<T> a(wx9<T> wx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, wx9Var)) == null) ? b(wx9Var, f) : (wx9) invokeL.objValue;
    }

    public static <T> wx9<T> b(wx9<T> wx9Var, oy9<? super wx9<? extends Notification<?>>, ? extends wx9<?>> oy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, wx9Var, oy9Var)) == null) ? wx9.a(new yy9(wx9Var, oy9Var, true, false, Schedulers.trampoline())) : (wx9) invokeLL.objValue;
    }

    @Override // com.repackage.wx9.a, com.repackage.ky9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((cy9) ((cy9) obj));
    }

    public void call(cy9<? super T> cy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            AtomicLong atomicLong = new AtomicLong();
            zx9.a createWorker = this.e.createWorker();
            cy9Var.b(createWorker);
            s2a s2aVar = new s2a();
            cy9Var.b(s2aVar);
            n2a<T, T> C = l2a.D().C();
            C.u(a2a.a());
            pz9 pz9Var = new pz9();
            b bVar = new b(this, cy9Var, C, pz9Var, atomicLong, s2aVar);
            createWorker.b(new d(this, this.b.call(C.g(new c(this))), cy9Var, atomicLong, createWorker, bVar, atomicBoolean));
            cy9Var.f(new e(this, atomicLong, pz9Var, atomicBoolean, createWorker, bVar));
        }
    }
}
