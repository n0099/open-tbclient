package d.a.o0.h.n0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import d.a.o0.a.a2.e;
import d.a.o0.a.e2.c.f;
import d.a.o0.a.k;
import d.a.o0.h.m0.c;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50634a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.h.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1112a implements d.a.o0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50636f;

        public C1112a(d.a.o0.a.y.b.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50635e = aVar;
            this.f50636f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f44833d || fVar.j != 1) {
                    a.c(this.f50635e, "system deny");
                } else {
                    a.e(this.f50635e, this.f50636f);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1861905833, "Ld/a/o0/h/n0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1861905833, "Ld/a/o0/h/n0/a;");
                return;
            }
        }
        f50634a = k.f46335a;
    }

    public static void c(d.a.o0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, aVar, str) == null) {
            d.a.o0.h.d.c.b bVar = new d.a.o0.h.d.c.b();
            bVar.errMsg = str;
            c.a(aVar, false, bVar);
        }
    }

    public static void d(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        e Q = e.Q();
        if (Q == null) {
            c(G, "internal error");
            return;
        }
        String D = G.D("domain", "baidu.com");
        if (f50634a) {
            Log.i("SwanGameUuapApi", "getUUAPInfo-domain: " + D);
        }
        Q.T().e("mapp_uuap_info", new C1112a(G, D));
    }

    public static void e(d.a.o0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, str) == null) {
            b bVar = new b();
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                Map<String, String> f2 = f(cookie);
                bVar.uuap_p_token = f2.get("UUAP_P_TOKEN");
                bVar.uuap_p_token_offline = f2.get("UUAP_P_TOKEN_OFFLINE");
                bVar.uuap_s_token = f2.get("UUAP_S_TOKEN");
            }
            c.a(aVar, true, bVar);
        }
    }

    @NonNull
    public static Map<String, String> f(@NonNull String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(";")) {
                if (str2 != null && str2.contains("=")) {
                    int indexOf = str2.indexOf("=");
                    hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(Locale.US), str2.substring(indexOf + 1));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
