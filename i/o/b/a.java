package i.o.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
/* loaded from: classes4.dex */
public final class a implements f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final f f64347k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f64348e;

    /* renamed from: f  reason: collision with root package name */
    public f f64349f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64350g;

    /* renamed from: h  reason: collision with root package name */
    public long f64351h;

    /* renamed from: i  reason: collision with root package name */
    public long f64352i;

    /* renamed from: j  reason: collision with root package name */
    public f f64353j;

    /* renamed from: i.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2269a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2269a() {
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

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371114777, "Li/o/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371114777, "Li/o/b/a;");
                return;
            }
        }
        f64347k = new C2269a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                long j2 = this.f64351h;
                long j3 = this.f64352i;
                f fVar = this.f64353j;
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 == 0 && j3 == 0 && fVar == null) {
                    this.f64350g = false;
                    return;
                }
                this.f64351h = 0L;
                this.f64352i = 0L;
                this.f64353j = null;
                long j4 = this.f64348e;
                if (j4 != Long.MAX_VALUE) {
                    long j5 = j4 + j2;
                    if (j5 < 0 || j5 == Long.MAX_VALUE) {
                        this.f64348e = Long.MAX_VALUE;
                        j4 = Long.MAX_VALUE;
                    } else {
                        j4 = j5 - j3;
                        if (j4 >= 0) {
                            this.f64348e = j4;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (fVar != null) {
                    if (fVar == f64347k) {
                        this.f64349f = null;
                    } else {
                        this.f64349f = fVar;
                        fVar.request(j4);
                    }
                } else {
                    f fVar2 = this.f64349f;
                    if (fVar2 != null && i2 != 0) {
                        fVar2.request(j2);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            if (j2 > 0) {
                synchronized (this) {
                    if (this.f64350g) {
                        this.f64352i += j2;
                        return;
                    }
                    this.f64350g = true;
                    try {
                        long j3 = this.f64348e;
                        if (j3 != Long.MAX_VALUE) {
                            long j4 = j3 - j2;
                            if (j4 >= 0) {
                                this.f64348e = j4;
                            } else {
                                throw new IllegalStateException("more items arrived than were requested");
                            }
                        }
                        a();
                        return;
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f64350g = false;
                            throw th;
                        }
                    }
                }
            }
            throw new IllegalArgumentException("n > 0 required");
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            synchronized (this) {
                if (this.f64350g) {
                    if (fVar == null) {
                        fVar = f64347k;
                    }
                    this.f64353j = fVar;
                    return;
                }
                this.f64350g = true;
                try {
                    this.f64349f = fVar;
                    if (fVar != null) {
                        fVar.request(this.f64348e);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f64350g = false;
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // i.f
    public void request(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (i2 == 0) {
                return;
            }
            synchronized (this) {
                if (this.f64350g) {
                    this.f64351h += j2;
                    return;
                }
                this.f64350g = true;
                try {
                    long j3 = this.f64348e + j2;
                    if (j3 < 0) {
                        j3 = Long.MAX_VALUE;
                    }
                    this.f64348e = j3;
                    f fVar = this.f64349f;
                    if (fVar != null) {
                        fVar.request(j2);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f64350g = false;
                        throw th;
                    }
                }
            }
        }
    }
}
