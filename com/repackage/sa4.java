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
public class sa4 extends k94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map, Map<String, String> map2, o94<String> o94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, str, map, map2, o94Var) == null) || d(str, o94Var)) {
            return;
        }
        c(l74.g().getRequest(), str, map, map2, o94Var);
    }

    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, o94<String> o94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65537, null, str, map, map2, jSONObject, o94Var) == null) || d(str, o94Var)) {
            return;
        }
        h74 postStringRequest = l74.g().postStringRequest();
        t74.a(postStringRequest, map);
        postStringRequest.content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6);
        c(postStringRequest, str, map, map2, o94Var);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public static void c(HttpRequestBuilder<?> httpRequestBuilder, String str, Map<String, String> map, Map<String, String> map2, o94<String> o94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, httpRequestBuilder, str, map, map2, o94Var) == null) {
            httpRequestBuilder.url(p94.j(str, map)).requestSubFrom(10).addHeaders(map2).userAgent(k94.b).cookieManager(k94.a).enableStat(true).build().executeStat(o94Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean d(String str, o94<String> o94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, o94Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (o94Var != null) {
                o94Var.onStart();
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
