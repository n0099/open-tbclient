package com.bytedance.sdk.openadsdk.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f67683a;

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f67684b;

    public a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67683a = str;
        this.f67684b = jSONObject;
    }

    public static a a(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, str3, jSONObject)) == null) ? new a(UUID.randomUUID().toString(), b(context, str, str2, str3, jSONObject)) : (a) invokeLLLLL.objValue;
    }

    public static JSONObject b(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event_ts", System.currentTimeMillis());
                jSONObject2.putOpt("tag", str);
                jSONObject2.putOpt(NotificationCompatJellybean.KEY_LABEL, str2);
                jSONObject2.putOpt("category", "app_union");
                try {
                    jSONObject2.putOpt("value", Long.valueOf(Long.parseLong(str3)));
                } catch (NumberFormatException unused) {
                    jSONObject2.putOpt("value", 0L);
                }
                jSONObject2.putOpt("is_ad_event", "1");
                jSONObject2.putOpt("nt", Integer.valueOf(com.bytedance.sdk.component.utils.n.c(context)));
                jSONObject2.putOpt("tob_ab_sdk_version", com.bytedance.sdk.openadsdk.core.h.d().w());
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.putOpt(next, jSONObject.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }

    public static a a(String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), jSONObject})) == null) ? new a(UUID.randomUUID().toString(), b(str, str2, str3, j2, j3, jSONObject)) : (a) invokeCommon.objValue;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("localId", null);
                JSONObject optJSONObject = jSONObject.optJSONObject("event");
                if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                    return new a(optString, optJSONObject);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f67683a) || this.f67684b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.f67683a);
                jSONObject.put("event", this.f67684b);
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject b(String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), jSONObject})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event_ts", System.currentTimeMillis());
                jSONObject2.putOpt("tag", str2);
                jSONObject2.putOpt(NotificationCompatJellybean.KEY_LABEL, str3);
                jSONObject2.putOpt("category", str);
                jSONObject2.putOpt("value", Long.valueOf(j2));
                jSONObject2.putOpt("is_ad_event", "1");
                jSONObject2.putOpt("ext_value", Long.valueOf(j3));
                jSONObject2.putOpt("tob_ab_sdk_version", com.bytedance.sdk.openadsdk.core.h.d().w());
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.putOpt(next, jSONObject.opt(next));
                    }
                }
            } catch (Exception unused) {
            }
            return jSONObject2;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.e.i
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67683a : (String) invokeV.objValue;
    }
}
