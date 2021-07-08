package h.o.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.f;
/* loaded from: classes8.dex */
public final class a implements f {
    public static /* synthetic */ Interceptable $ic;
    public static final f k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f72567e;

    /* renamed from: f  reason: collision with root package name */
    public f f72568f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72569g;

    /* renamed from: h  reason: collision with root package name */
    public long f72570h;

    /* renamed from: i  reason: collision with root package name */
    public long f72571i;
    public f j;

    /* renamed from: h.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2069a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2069a() {
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

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1371695558, "Lh/o/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1371695558, "Lh/o/b/a;");
                return;
            }
        }
        k = new C2069a();
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
                long j = this.f72570h;
                long j2 = this.f72571i;
                f fVar = this.j;
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 == 0 && j2 == 0 && fVar == null) {
                    this.f72569g = false;
                    return;
                }
                this.f72570h = 0L;
                this.f72571i = 0L;
                this.j = null;
                long j3 = this.f72567e;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.f72567e = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 >= 0) {
                            this.f72567e = j3;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (fVar != null) {
                    if (fVar == k) {
                        this.f72568f = null;
                    } else {
                        this.f72568f = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.f72568f;
                    if (fVar2 != null && i2 != 0) {
                        fVar2.request(j);
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
                    if (this.f72569g) {
                        this.f72571i += j;
                        return;
                    }
                    this.f72569g = true;
                    try {
                        long j2 = this.f72567e;
                        if (j2 != Long.MAX_VALUE) {
                            long j3 = j2 - j;
                            if (j3 >= 0) {
                                this.f72567e = j3;
                            } else {
                                throw new IllegalStateException("more items arrived than were requested");
                            }
                        }
                        a();
                        return;
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f72569g = false;
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
                if (this.f72569g) {
                    if (fVar == null) {
                        fVar = k;
                    }
                    this.j = fVar;
                    return;
                }
                this.f72569g = true;
                try {
                    this.f72568f = fVar;
                    if (fVar != null) {
                        fVar.request(this.f72567e);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f72569g = false;
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // h.f
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (i2 == 0) {
                return;
            }
            synchronized (this) {
                if (this.f72569g) {
                    this.f72570h += j;
                    return;
                }
                this.f72569g = true;
                try {
                    long j2 = this.f72567e + j;
                    if (j2 < 0) {
                        j2 = Long.MAX_VALUE;
                    }
                    this.f72567e = j2;
                    f fVar = this.f72568f;
                    if (fVar != null) {
                        fVar.request(j);
                    }
                    a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f72569g = false;
                        throw th;
                    }
                }
            }
        }
    }
}
