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
/* loaded from: classes5.dex */
public class db4 extends v94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, z94<String> z94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, z94Var) == null) || d(str, z94Var)) {
            return;
        }
        c(w74.g().getRequest(), str, map, map2, z94Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, z94<String> z94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, z94Var) == null) || d(str, z94Var)) {
            return;
        }
        s74 postStringRequest = w74.g().postStringRequest();
        e84.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, z94Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, z94<String> z94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, z94Var) == null) {
            httpRequestBuilder.url(aa4.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(v94.b).cookieManager(v94.a).enableStat(true).build().executeStat(z94Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, z94<String> z94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, z94Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (z94Var != null) {
                z94Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
