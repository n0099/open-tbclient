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
/* loaded from: classes6.dex */
public class q94 extends i84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, m84<String> m84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, m84Var) == null) || d(str, m84Var)) {
            return;
        }
        c(j64.g().getRequest(), str, map, map2, m84Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, m84<String> m84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, m84Var) == null) || d(str, m84Var)) {
            return;
        }
        f64 postStringRequest = j64.g().postStringRequest();
        r64.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, m84Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, m84<String> m84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, m84Var) == null) {
            httpRequestBuilder.url(n84.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(i84.b).cookieManager(i84.a).enableStat(true).build().executeStat(m84Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, m84<String> m84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, m84Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (m84Var != null) {
                m84Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
