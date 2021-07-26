package d.a.o0.h.y.d;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.n1.e;
import d.a.o0.a.n1.h;
import d.a.o0.a.n1.o.a;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class d implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f50873a;

    /* renamed from: b  reason: collision with root package name */
    public final e f50874b;

    /* loaded from: classes7.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f50875a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50875a = dVar;
        }

        @Override // d.a.o0.a.n1.e
        public void a(long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
                if (this.f50875a.f50873a == null) {
                    if (k.f46335a) {
                        Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                    }
                } else if (j2 == -1 && j != 0) {
                    this.f50875a.f50873a.b(0, j, j2);
                } else if (j2 > 52428800) {
                    this.f50875a.f50873a.a(j2);
                    this.f50875a.f50873a = null;
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    this.f50875a.f50873a.c(j, j2);
                    this.f50875a.f50873a = null;
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor <= 100) {
                        this.f50875a.f50873a.b(floor, j, j2);
                    }
                }
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50874b = new a(this);
    }

    public void c(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f50873a = bVar;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chain)) == null) {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new h(proceed.body(), this.f50874b)).build();
        }
        return (Response) invokeL.objValue;
    }
}
