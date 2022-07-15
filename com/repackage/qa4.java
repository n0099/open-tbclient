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
public class qa4 extends i94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, m94<String> m94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, m94Var) == null) || d(str, m94Var)) {
            return;
        }
        c(j74.g().getRequest(), str, map, map2, m94Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, m94<String> m94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, m94Var) == null) || d(str, m94Var)) {
            return;
        }
        f74 postStringRequest = j74.g().postStringRequest();
        r74.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, m94Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, m94<String> m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, m94Var) == null) {
            httpRequestBuilder.url(n94.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(i94.b).cookieManager(i94.a).enableStat(true).build().executeStat(m94Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, m94<String> m94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, m94Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (m94Var != null) {
                m94Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
