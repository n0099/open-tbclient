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
public class ba4 extends t84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, x84<String> x84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, x84Var) == null) || d(str, x84Var)) {
            return;
        }
        c(u64.g().getRequest(), str, map, map2, x84Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, x84<String> x84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, x84Var) == null) || d(str, x84Var)) {
            return;
        }
        q64 postStringRequest = u64.g().postStringRequest();
        c74.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, x84Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, x84<String> x84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, x84Var) == null) {
            httpRequestBuilder.url(y84.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(t84.b).cookieManager(t84.a).enableStat(true).build().executeStat(x84Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, x84<String> x84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, x84Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (x84Var != null) {
                x84Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
