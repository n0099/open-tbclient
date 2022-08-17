package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uu9;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes6.dex */
public final class mw9 extends uu9 implements sw9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int c;
    public static final c d;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThreadFactory a;
    public final AtomicReference<b> b;

    /* loaded from: classes6.dex */
    public static final class a extends uu9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final cx9 a;
        public final lz9 b;
        public final cx9 c;
        public final c d;

        /* renamed from: com.repackage.mw9$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0529a implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ev9 a;
            public final /* synthetic */ a b;

            public C0529a(a aVar, ev9 ev9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ev9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = ev9Var;
            }

            @Override // com.repackage.ev9
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.isUnsubscribed()) {
                    return;
                }
                this.a.call();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ev9 a;
            public final /* synthetic */ a b;

            public b(a aVar, ev9 ev9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ev9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = ev9Var;
            }

            @Override // com.repackage.ev9
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.isUnsubscribed()) {
                    return;
                }
                this.a.call();
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new cx9();
            lz9 lz9Var = new lz9();
            this.b = lz9Var;
            this.c = new cx9(this.a, lz9Var);
            this.d = cVar;
        }

        @Override // com.repackage.uu9.a
        public yu9 b(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) {
                if (isUnsubscribed()) {
                    return oz9.c();
                }
                return this.d.i(new C0529a(this, ev9Var), 0L, null, this.a);
            }
            return (yu9) invokeL.objValue;
        }

        @Override // com.repackage.uu9.a
        public yu9 c(ev9 ev9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ev9Var, Long.valueOf(j), timeUnit})) == null) {
                if (isUnsubscribed()) {
                    return oz9.c();
                }
                return this.d.j(new b(this, ev9Var), j, timeUnit, this.b);
            }
            return (yu9) invokeCommon.objValue;
        }

        @Override // com.repackage.yu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.yu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c.unsubscribe();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final c[] b;
        public long c;

        public b(ThreadFactory threadFactory, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = new c[i];
            for (int i4 = 0; i4 < i; i4++) {
                this.b[i4] = new c(threadFactory);
            }
        }

        public c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.a;
                if (i == 0) {
                    return mw9.d;
                }
                c[] cVarArr = this.b;
                long j = this.c;
                this.c = 1 + j;
                return cVarArr[(int) (j % i)];
            }
            return (c) invokeV.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (c cVar : this.b) {
                    cVar.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends rw9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ThreadFactory) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755484734, "Lcom/repackage/mw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755484734, "Lcom/repackage/mw9;");
                return;
            }
        }
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        c = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        d = cVar;
        cVar.unsubscribe();
        e = new b(null, 0);
    }

    public mw9(ThreadFactory threadFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = threadFactory;
        this.b = new AtomicReference<>(e);
        start();
    }

    public yu9 a(ev9 ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) ? this.b.get().a().h(ev9Var, -1L, TimeUnit.NANOSECONDS) : (yu9) invokeL.objValue;
    }

    @Override // com.repackage.uu9
    public uu9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this.b.get().a()) : (uu9.a) invokeV.objValue;
    }

    @Override // com.repackage.sw9
    public void shutdown() {
        b bVar;
        b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            do {
                bVar = this.b.get();
                bVar2 = e;
                if (bVar == bVar2) {
                    return;
                }
            } while (!this.b.compareAndSet(bVar, bVar2));
            bVar.b();
        }
    }

    @Override // com.repackage.sw9
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = new b(this.a, c);
            if (this.b.compareAndSet(e, bVar)) {
                return;
            }
            bVar.b();
        }
    }
}
