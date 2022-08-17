package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru9;
import com.repackage.uu9;
/* loaded from: classes5.dex */
public final class bw9<T> implements ru9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uu9 a;
    public final ru9<T> b;

    /* loaded from: classes5.dex */
    public class a implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu9 a;
        public final /* synthetic */ uu9.a b;
        public final /* synthetic */ bw9 c;

        /* renamed from: com.repackage.bw9$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0453a extends xu9<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Thread e;
            public final /* synthetic */ a f;

            /* renamed from: com.repackage.bw9$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0454a implements tu9 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ tu9 a;
                public final /* synthetic */ C0453a b;

                /* renamed from: com.repackage.bw9$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public class C0455a implements ev9 {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ C0454a b;

                    public C0455a(C0454a c0454a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0454a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = c0454a;
                        this.a = j;
                    }

                    @Override // com.repackage.ev9
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.b.a.request(this.a);
                        }
                    }
                }

                public C0454a(C0453a c0453a, tu9 tu9Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0453a, tu9Var};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0453a;
                    this.a = tu9Var;
                }

                @Override // com.repackage.tu9
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.b.e == Thread.currentThread()) {
                            this.a.request(j);
                        } else {
                            this.b.f.b.b(new C0455a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0453a(a aVar, xu9 xu9Var, Thread thread) {
                super(xu9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, xu9Var, thread};
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
                this.f = aVar;
                this.e = thread;
            }

            @Override // com.repackage.xu9
            public void f(tu9 tu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, tu9Var) == null) {
                    this.f.a.f(new C0454a(this, tu9Var));
                }
            }

            @Override // com.repackage.su9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        this.f.a.onCompleted();
                    } finally {
                        this.f.b.unsubscribe();
                    }
                }
            }

            @Override // com.repackage.su9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    try {
                        this.f.a.onError(th);
                    } finally {
                        this.f.b.unsubscribe();
                    }
                }
            }

            @Override // com.repackage.su9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f.a.onNext(t);
                }
            }
        }

        public a(bw9 bw9Var, xu9 xu9Var, uu9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw9Var, xu9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bw9Var;
            this.a = xu9Var;
            this.b = aVar;
        }

        @Override // com.repackage.ev9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.B(new C0453a(this, this.a, Thread.currentThread()));
            }
        }
    }

    public bw9(ru9<T> ru9Var, uu9 uu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ru9Var, uu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uu9Var;
        this.b = ru9Var;
    }

    @Override // com.repackage.ru9.a, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xu9) ((xu9) obj));
    }

    public void call(xu9<? super T> xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
            uu9.a createWorker = this.a.createWorker();
            xu9Var.b(createWorker);
            createWorker.b(new a(this, xu9Var, createWorker));
        }
    }
}
