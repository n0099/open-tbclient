package d.a.q0.n.i;

import android.text.TextUtils;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f53941a;

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f53942b;

    /* renamed from: c  reason: collision with root package name */
    public static String f53943c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.n.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1195a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f53944a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f53945b;

        public C1195a(Map map, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53944a = map;
            this.f53945b = eVar;
        }

        @Override // d.a.q0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.q0.m.e.a.g().postByteRequest();
                d.a.q0.n.d.a(postByteRequest, this.f53944a);
                postByteRequest.url(f.i(str, this.f53944a)).content(bArr).mediaType(MediaType.parse("application/json; charset=utf-8")).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(a.f53943c)) {
                    postByteRequest.userAgent(a.f53943c);
                }
                postByteRequest.cookieManager(a.f53942b).enableStat(true).build().executeStat(this.f53945b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f53946a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f53947b;

        public b(Map map, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53946a = map;
            this.f53947b = eVar;
        }

        @Override // d.a.q0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = d.a.q0.m.e.a.g().getRequest().url(f.i(str, this.f53946a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(a.f53943c)) {
                    requestSubFrom.userAgent(a.f53943c);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(a.f53942b).enableStat(true).build().executeStat(this.f53947b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1207265388, "Ld/a/q0/n/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1207265388, "Ld/a/q0/n/i/a;");
                return;
            }
        }
        f53941a = d.a.q0.n.c.f53910a;
        f53942b = d.a.q0.n.c.b().g();
        d.a.q0.m.a b2 = d.a.q0.m.b.b();
        if (b2 == null || !d.a.q0.m.e.a.g().c()) {
            return;
        }
        f53943c = b2.a();
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, str, map, map2, eVar) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f53941a) {
                    throw new InvalidParameterException("PMS request URL is empty");
                }
                return;
            }
            if (eVar != null) {
                eVar.onStart();
            }
            d.a.q0.n.a b2 = d.a.q0.n.c.b();
            if (PMSConstants.a(b2)) {
                b2.m(f.i(str, map), null, new b(map, eVar));
                return;
            }
            GetRequest.GetRequestBuilder requestSubFrom = d.a.q0.m.e.a.g().getRequest().url(f.i(str, map)).requestSubFrom(10);
            if (!TextUtils.isEmpty(f53943c)) {
                requestSubFrom.userAgent(f53943c);
            }
            if (map2 != null) {
                requestSubFrom.addHeaders(map2);
            }
            requestSubFrom.cookieManager(f53942b).enableStat(true).build().executeStat(eVar);
        }
    }

    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, eVar) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f53941a) {
                    throw new InvalidParameterException("PMS request URL is empty");
                }
                return;
            }
            if (eVar != null) {
                eVar.onStart();
            }
            d.a.q0.n.a b2 = d.a.q0.n.c.b();
            if (PMSConstants.a(b2)) {
                b2.m(f.i(str, map), jSONObject.toString(), new C1195a(map, eVar));
                return;
            }
            d.a.q0.m.c.h postStringRequest = d.a.q0.m.e.a.g().postStringRequest();
            d.a.q0.n.d.a(postStringRequest, map);
            postStringRequest.url(f.i(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse("application/json; charset=utf-8")).requestFrom(6).requestSubFrom(10);
            if (map2 != null) {
                postStringRequest.addHeaders(map2);
            }
            if (!TextUtils.isEmpty(f53943c)) {
                postStringRequest.userAgent(f53943c);
            }
            postStringRequest.cookieManager(f53942b).enableStat(true).build().executeStat(eVar);
        }
    }
}
