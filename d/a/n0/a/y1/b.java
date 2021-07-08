package d.a.n0.a.y1;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.d;
import d.a.n0.a.g1.f;
import d.a.n0.a.k;
import d.a.n0.a.v2.o0;
import java.util.HashMap;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48530a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<d.a.n0.a.y1.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0990b f48531a;

        public a(InterfaceC0990b interfaceC0990b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0990b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48531a = interfaceC0990b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(d.a.n0.a.y1.a aVar, int i2) {
            InterfaceC0990b interfaceC0990b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || (interfaceC0990b = this.f48531a) == null) {
                return;
            }
            if (aVar == null) {
                interfaceC0990b.a(null);
            } else {
                interfaceC0990b.a(aVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public d.a.n0.a.y1.a parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                    return null;
                }
                if (b.f48530a) {
                    Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
                }
                return d.a.n0.a.y1.a.a(optJSONObject);
            }
            return (d.a.n0.a.y1.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            InterfaceC0990b interfaceC0990b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) || (interfaceC0990b = this.f48531a) == null) {
                return;
            }
            interfaceC0990b.a(null);
        }
    }

    /* renamed from: d.a.n0.a.y1.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0990b {
        void a(d.a.n0.a.y1.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(722205050, "Ld/a/n0/a/y1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(722205050, "Ld/a/n0/a/y1/b;");
                return;
            }
        }
        f48530a = k.f45831a;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SwanCoreVersion N = f.V().N();
            String h2 = d.a.n0.n.i.f.h(d.a.n0.a.c1.a.n().I());
            HashMap hashMap = new HashMap(4);
            hashMap.put("appkey", d.g().getAppId());
            hashMap.put("swan_core_ver", d.a.n0.a.m2.b.i(N, d.g().l()));
            hashMap.put("swan_game_ver", d.a.n0.a.m2.b.h(1));
            hashMap.put("uid", d.a.n0.a.c1.a.a0().i(d.a.n0.a.c1.a.b()));
            return o0.b(h2, hashMap);
        }
        return (String) invokeV.objValue;
    }

    public static void c(InterfaceC0990b interfaceC0990b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, interfaceC0990b) == null) {
            d.a.n0.m.d.a aVar = new d.a.n0.m.d.a(b(), new a(interfaceC0990b));
            if (d.a.n0.m.e.a.g().c()) {
                aVar.f50598f = true;
            }
            aVar.f50599g = true;
            d.a.n0.m.e.a.g().d(aVar);
        }
    }
}
