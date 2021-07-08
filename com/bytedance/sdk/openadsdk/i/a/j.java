package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.q;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j extends com.bytedance.sdk.component.a.e<JSONObject, JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    private int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if ("video".equals(str)) {
                return 2;
            }
            return "canvas".equals(str) ? 3 : 0;
        }
        return invokeL.intValue;
    }

    private m c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            String e2 = com.bytedance.sdk.openadsdk.r.d.e();
            if (TextUtils.isEmpty(e2)) {
                return null;
            }
            try {
                return com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(e2));
            } catch (Throwable unused) {
                com.bytedance.sdk.component.utils.j.f("ReportPlayableScreenshotMethod", "ReportPlayableScreenshotMethod materialMeta is null ");
                return null;
            }
        }
        return (m) invokeV.objValue;
    }

    public static void a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qVar) == null) {
            qVar.a("reportPlayableScreenshot", (com.bytedance.sdk.component.a.e<?, ?>) new j());
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

    private JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        String optString;
        Bitmap a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            com.bytedance.sdk.component.utils.j.b("ReportPlayableScreenshotMethod", "reportPlayableScreenshot ");
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                a(jSONObject2, 1, "params is null");
                return jSONObject2;
            }
            try {
                String optString2 = jSONObject.optString("image");
                optString = jSONObject.optString("type");
                a2 = com.bytedance.sdk.component.utils.d.a(optString2);
            } catch (Throwable unused) {
            }
            if (a2 == null) {
                a(jSONObject2, 1, "imageBase64 to Bitmap error");
                return jSONObject2;
            }
            m c2 = c();
            if (c2 == null) {
                a(jSONObject2, 1, "materialMeta is null");
                return jSONObject2;
            }
            com.bytedance.sdk.openadsdk.r.q.a(o.a(), c2, "rewarded_video", "playable_show_status", com.bytedance.sdk.component.utils.d.a(a2, a2.getWidth() / 6, a2.getHeight() / 6), true, b(optString));
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    private void a(JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, this, jSONObject, i2, str) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i2);
            jSONObject.put("codeMsg", str);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.j.b("ReportPlayableScreenshotMethod", str);
        }
    }
}
