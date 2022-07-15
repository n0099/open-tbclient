package com.repackage;

import android.annotation.SuppressLint;
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
import com.baidubce.AbstractBceClient;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes6.dex */
public class i94 {
    public static /* synthetic */ Interceptable $ic;
    public static CookieManager a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ m94 b;

        public a(Map map, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, m94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.b = m94Var;
        }

        @Override // com.repackage.i94.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = j74.g().postByteRequest();
                r74.a(postByteRequest, this.a);
                postByteRequest.url(n94.j(str, this.a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(i94.b)) {
                    postByteRequest.userAgent(i94.b);
                }
                postByteRequest.cookieManager(i94.a).enableStat(true).build().executeStat(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ m94 b;

        public b(Map map, m94 m94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, m94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.b = m94Var;
        }

        @Override // com.repackage.i94.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = j74.g().getRequest().url(n94.j(str, this.a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(i94.b)) {
                    requestSubFrom.userAgent(i94.b);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(i94.a).enableStat(true).build().executeStat(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755663635, "Lcom/repackage/i94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755663635, "Lcom/repackage/i94;");
                return;
            }
        }
        a = q74.b().f();
        w64 b2 = x64.b();
        if (b2 == null || !j74.g().c()) {
            return;
        }
        b = b2.getUserAgent();
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, m94<String> m94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, str, map, map2, m94Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (m94Var != null) {
            m94Var.onStart();
        }
        o74 b2 = q74.b();
        if (PMSConstants.a(b2)) {
            b2.m(n94.j(str, map), null, new b(map, m94Var));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = j74.g().getRequest().url(n94.j(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(b)) {
            requestSubFrom.userAgent(b);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(a).enableStat(true).build().executeStat(m94Var);
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, m94<String> m94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, m94Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (m94Var != null) {
            m94Var.onStart();
        }
        o74 b2 = q74.b();
        if (PMSConstants.a(b2)) {
            b2.m(n94.j(str, map), jSONObject.toString(), new a(map, m94Var));
            return;
        }
        f74 postStringRequest = j74.g().postStringRequest();
        r74.a(postStringRequest, map);
        postStringRequest.url(n94.j(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(b)) {
            postStringRequest.userAgent(b);
        }
        postStringRequest.cookieManager(a).enableStat(true).build().executeStat(m94Var);
    }
}
