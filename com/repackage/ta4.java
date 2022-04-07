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
public class ta4 extends l94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, p94<String> p94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, p94Var) == null) || d(str, p94Var)) {
            return;
        }
        c(m74.g().getRequest(), str, map, map2, p94Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, p94<String> p94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, p94Var) == null) || d(str, p94Var)) {
            return;
        }
        i74 postStringRequest = m74.g().postStringRequest();
        u74.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, p94Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, p94<String> p94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, p94Var) == null) {
            httpRequestBuilder.url(q94.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(l94.b).cookieManager(l94.a).enableStat(true).build().executeStat(p94Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, p94<String> p94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, p94Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (p94Var != null) {
                p94Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
