package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wx9;
import com.repackage.zx9;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes5.dex */
public final class cz9<T> implements wx9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zx9 a;
    public final boolean b;
    public final int c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends cy9<T> implements jy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final cy9<? super T> e;
        public final zx9.a f;
        public final boolean g;
        public final Queue<Object> h;
        public final int i;
        public volatile boolean j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: com.repackage.cz9$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0395a implements yx9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0395a(a aVar) {
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

            @Override // com.repackage.yx9
            public void request(long j) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j <= 0) {
                    return;
                }
                ry9.b(this.a.k, j);
                this.a.i();
            }
        }

        public a(zx9 zx9Var, cy9<? super T> cy9Var, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, cy9Var, Boolean.valueOf(z), Integer.valueOf(i)};
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
            this.e = cy9Var;
            this.f = zx9Var.createWorker();
            this.g = z;
            i = i <= 0 ? f0a.c : i;
            this.i = i - (i >> 2);
            if (t1a.b()) {
                this.h = new f1a(i);
            } else {
                this.h = new k0a(i);
            }
            e(i);
        }

        @Override // com.repackage.jy9
        public void call() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.n;
                Queue<Object> queue = this.h;
                cy9<? super T> cy9Var = this.e;
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
                        if (g(z, z2, cy9Var, queue)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        cy9Var.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.i) {
                            j3 = ry9.g(this.k, j);
                            e(j);
                            j = 0;
                        }
                    }
                    if (i == 0 && g(this.j, queue.isEmpty(), cy9Var, queue)) {
                        return;
                    }
                    this.n = j;
                    j2 = this.l.addAndGet(-j2);
                } while (j2 != 0);
            }
        }

        public boolean g(boolean z, boolean z2, cy9<? super T> cy9Var, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), cy9Var, queue})) == null) {
                if (cy9Var.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.g) {
                        if (z2) {
                            Throwable th = this.m;
                            try {
                                if (th != null) {
                                    cy9Var.onError(th);
                                } else {
                                    cy9Var.onCompleted();
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
                            cy9Var.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            cy9Var.onCompleted();
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
                cy9<? super T> cy9Var = this.e;
                cy9Var.f(new C0395a(this));
                cy9Var.b(this.f);
                cy9Var.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f.b(this);
            }
        }

        @Override // com.repackage.xx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || isUnsubscribed() || this.j) {
                return;
            }
            this.j = true;
            i();
        }

        @Override // com.repackage.xx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.j) {
                    this.m = th;
                    this.j = true;
                    i();
                    return;
                }
                d2a.j(th);
            }
        }

        @Override // com.repackage.xx9
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

    public cz9(zx9 zx9Var, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zx9Var, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zx9Var;
        this.b = z;
        this.c = i <= 0 ? f0a.c : i;
    }

    @Override // com.repackage.wx9.b, com.repackage.oy9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((cy9) ((cy9) obj));
    }

    public cy9<? super T> call(cy9<? super T> cy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cy9Var)) == null) {
            zx9 zx9Var = this.a;
            if ((zx9Var instanceof uz9) || (zx9Var instanceof zz9)) {
                return cy9Var;
            }
            a aVar = new a(zx9Var, cy9Var, this.b, this.c);
            aVar.h();
            return aVar;
        }
        return (cy9) invokeL.objValue;
    }
}
