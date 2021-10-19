package com.bytedance.sdk.openadsdk.h.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.g.a;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, rVar) == null) {
            rVar.a("getDownloadStatus", (com.bytedance.sdk.component.a.e<?, ?>) new f());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.a.e
    @Nullable
    public JSONObject a(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, fVar)) == null) ? a(jSONObject) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                a(jSONObject2, 1, "params is null", 1, 1);
                return jSONObject2;
            }
            try {
                String optString = jSONObject.optString("ad_down_load_id");
                if (TextUtils.isEmpty(optString)) {
                    a(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                    return jSONObject2;
                }
                com.bytedance.sdk.component.utils.k.b("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadId " + optString);
                JSONObject a2 = a.C1925a.a(optString);
                com.bytedance.sdk.component.utils.k.b("GetDownloadStatusMethod", "GetDownloadStatusMethod analysisJson downloadJson " + a2.toString());
                return a2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void a(JSONObject jSONObject, int i2, String str, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{jSONObject, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i2);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i3);
            jSONObject.put("downloadProcessRate", i4);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.k.b("GetDownloadStatusMethod", str);
        }
    }
}
