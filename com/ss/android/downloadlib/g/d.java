package com.ss.android.downloadlib.g;

import android.text.TextUtils;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, boolean z, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, Boolean.valueOf(z), str3})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("notification_jump_url", str2);
                }
                jSONObject.put("show_toast", z);
                jSONObject.put(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
