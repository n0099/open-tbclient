package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qu9;
import com.repackage.tu9;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public final class wv9<T> implements qu9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tu9 a;
    public final boolean b;
    public final int c;

    /* loaded from: classes7.dex */
    public static final class a<T> extends wu9<T> implements dv9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wu9<? super T> e;
        public final tu9.a f;
        public final boolean g;
        public final Queue<Object> h;
        public final int i;
        public volatile boolean j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: com.repackage.wv9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0553a implements su9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0553a(a aVar) {
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
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.repackage.su9
            public void request(long j) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                    return;
                }
                lv9.b(this.a.k, j);
                this.a.i();
            }
        }

        public a(tu9 tu9Var, wu9<? super T> wu9Var, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu9Var, wu9Var, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new AtomicLong();
            this.l = new AtomicLong();
            this.e = wu9Var;
            this.f = tu9Var.createWorker();
            this.g = z;
            i = i <= 0 ? zw9.c : i;
            this.i = i - (i >> 2);
            if (ny9.b()) {
                this.h = new zx9(i);
            } else {
                this.h = new ex9(i);
            }
            e(i);
        }

        @Override // com.repackage.dv9
        public void call() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.n;
                Queue<Object> queue = this.h;
                wu9<? super T> wu9Var = this.e;
                long j2 = 1;
                do {
                    long j3 = this.k.get();
                    while (true) {
                        i = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z = this.j;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (g(z, z2, wu9Var, queue)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        wu9Var.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.i) {
                            j3 = lv9.g(this.k, j);
                            e(j);
                            j = 0;
                        }
                    }
                    if (i == 0 && g(this.j, queue.isEmpty(), wu9Var, queue)) {
                        return;
                    }
                    this.n = j;
                    j2 = this.l.addAndGet(-j2);
                } while (j2 != 0);
            }
        }

        public boolean g(boolean z, boolean z2, wu9<? super T> wu9Var, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), wu9Var, queue})) == null) {
                if (wu9Var.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.g) {
                        if (z2) {
                            Throwable th = this.m;
                            try {
                                if (th != null) {
                                    wu9Var.onError(th);
                                } else {
                                    wu9Var.onCompleted();
                                }
                                return false;
                            } finally {
                            }
                        }
                        return false;
                    }
                    Throwable th2 = this.m;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            wu9Var.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            wu9Var.onCompleted();
                            return true;
                        } finally {
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                wu9<? super T> wu9Var = this.e;
                wu9Var.f(new C0553a(this));
                wu9Var.b(this.f);
                wu9Var.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f.b(this);
            }
        }

        @Override // com.repackage.ru9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isUnsubscribed() || this.j) {
                return;
            }
            this.j = true;
            i();
        }

        @Override // com.repackage.ru9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.j) {
                    this.m = th;
                    this.j = true;
                    i();
                    return;
                }
                xy9.j(th);
            }
        }

        @Override // com.repackage.ru9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, t) == null) || isUnsubscribed() || this.j) {
                return;
            }
            if (!this.h.offer(NotificationLite.h(t))) {
                onError(new MissingBackpressureException());
            } else {
                i();
            }
        }
    }

    public wv9(tu9 tu9Var, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tu9Var, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tu9Var;
        this.b = z;
        this.c = i <= 0 ? zw9.c : i;
    }

    @Override // com.repackage.qu9.b, com.repackage.iv9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((wu9) ((wu9) obj));
    }

    public wu9<? super T> call(wu9<? super T> wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wu9Var)) == null) {
            tu9 tu9Var = this.a;
            if ((tu9Var instanceof ow9) || (tu9Var instanceof tw9)) {
                return wu9Var;
            }
            a aVar = new a(tu9Var, wu9Var, this.b, this.c);
            aVar.h();
            return aVar;
        }
        return (wu9) invokeL.objValue;
    }
}
