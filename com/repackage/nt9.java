package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class nt9 implements wr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final wr9 g;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public wr9 b;
    public boolean c;
    public long d;
    public long e;
    public wr9 f;

    /* loaded from: classes6.dex */
    public static class a implements wr9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.repackage.wr9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755457826, "Lcom/repackage/nt9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755457826, "Lcom/repackage/nt9;");
                return;
            }
        }
        g = new a();
    }

    public nt9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        while (true) {
            synchronized (this) {
                long j = this.d;
                long j2 = this.e;
                wr9 wr9Var = this.f;
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i == 0 && j2 == 0 && wr9Var == null) {
                    this.c = false;
                    return;
                }
                this.d = 0L;
                this.e = 0L;
                this.f = null;
                long j3 = this.a;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.a = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 >= 0) {
                            this.a = j3;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (wr9Var != null) {
                    if (wr9Var == g) {
                        this.b = null;
                    } else {
                        this.b = wr9Var;
                        wr9Var.request(j3);
                    }
                } else {
                    wr9 wr9Var2 = this.b;
                    if (wr9Var2 != null && i != 0) {
                        wr9Var2.request(j);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            if (j > 0) {
                synchronized (this) {
                    if (this.c) {
                        this.e += j;
                        return;
                    }
                    this.c = true;
                    try {
                        long j2 = this.a;
                        if (j2 != Long.MAX_VALUE) {
                            long j3 = j2 - j;
                            if (j3 >= 0) {
                                this.a = j3;
                            } else {
                                throw new IllegalStateException("more items arrived than were requested");
                            }
                        }
                        a();
                        return;
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.c = false;
                            throw th;
                        }
                    }
                }
            }
            throw new IllegalArgumentException("n > 0 required");
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void c(wr9 wr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wr9Var) == null) {
            synchronized (this) {
                if (this.c) {
                    if (wr9Var == null) {
                        wr9Var = g;
                    }
                    this.f = wr9Var;
                    return;
                }
                this.c = true;
                try {
                    this.b = wr9Var;
                    if (wr9Var != null) {
                        wr9Var.request(this.a);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.c = false;
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // com.repackage.wr9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (i == 0) {
                return;
            }
            synchronized (this) {
                if (this.c) {
                    this.d += j;
                    return;
                }
                this.c = true;
                try {
                    long j2 = this.a + j;
                    if (j2 < 0) {
                        j2 = Long.MAX_VALUE;
                    }
                    this.a = j2;
                    wr9 wr9Var = this.b;
                    if (wr9Var != null) {
                        wr9Var.request(j);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.c = false;
                        throw th;
                    }
                }
            }
        }
    }
}
