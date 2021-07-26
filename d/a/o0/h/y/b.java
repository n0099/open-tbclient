package d.a.o0.h.y;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.a2.n.c;
import d.a.o0.a.n1.o.d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes7.dex */
public class b extends HttpManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f50861a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super(d.a.o0.a.c1.a.b());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f50861a == null) {
                synchronized (b.class) {
                    if (f50861a == null) {
                        f50861a = new b();
                    }
                }
            }
            return f50861a;
        }
        return (b) invokeV.objValue;
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b bVar = new b();
            bVar.setHttpDnsEnable(c().getHttpDnsEnable());
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public void a(Request request, List<Interceptor> list, Callback callback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, request, list, callback) == null) || request == null) {
            return;
        }
        OkHttpClient.Builder newBuilder = getOkHttpClient().newBuilder();
        if (list != null && !list.isEmpty()) {
            for (Interceptor interceptor : list) {
                if (interceptor != null) {
                    newBuilder.addInterceptor(interceptor);
                }
            }
        }
        newBuilder.build().newCall(request).enqueue(callback);
    }

    public void b(Request request, Callback callback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, callback) == null) || request == null) {
            return;
        }
        getOkHttpClient().newCall(request).enqueue(callback);
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (e.i() == null) {
                return super.initClient();
            }
            d.a.o0.h.c0.a.a aVar2 = (d.a.o0.h.c0.a.a) e.i().I();
            OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
            int i2 = 60000;
            if (aVar2 != null && (aVar = aVar2.f43915a) != null) {
                i2 = aVar.f43921a;
                newBuilder.connectTimeout(aVar.f43922b, TimeUnit.MILLISECONDS);
                newBuilder.addNetworkInterceptor(new d());
            }
            long j = i2;
            newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
            OkHttpClient build = newBuilder.build();
            build.dispatcher().setMaxRequests(10);
            return build;
        }
        return (OkHttpClient) invokeV.objValue;
    }
}
