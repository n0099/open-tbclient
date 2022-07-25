package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ra4 extends j94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, n94<String> n94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, n94Var) == null) || d(str, n94Var)) {
            return;
        }
        c(k74.g().getRequest(), str, map, map2, n94Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, n94<String> n94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, n94Var) == null) || d(str, n94Var)) {
            return;
        }
        g74 postStringRequest = k74.g().postStringRequest();
        s74.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, n94Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, n94<String> n94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, n94Var) == null) {
            httpRequestBuilder.url(o94.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(j94.b).cookieManager(j94.a).enableStat(true).build().executeStat(n94Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, n94<String> n94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, n94Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (n94Var != null) {
                n94Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
