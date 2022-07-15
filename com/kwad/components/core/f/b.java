package com.kwad.components.core.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.config.d;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_local_ad_force_active", 0);
            a aVar = new a();
            if (sharedPreferences.contains("ksadsdk_local_ad_force_active_data")) {
                String string = sharedPreferences.getString("ksadsdk_local_ad_force_active_data", null);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        aVar.parseJson(new JSONObject(string));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.b(e);
                    }
                }
                z = aVar.a(d.S(), d.T());
                com.kwad.sdk.core.d.b.a("LocalAdForceActiveHelper", "addCount contains success: " + z);
            } else {
                com.kwad.sdk.core.d.b.a("LocalAdForceActiveHelper", "addCount not contains");
                aVar.a();
                z = true;
            }
            if (z) {
                sharedPreferences.edit().putString("ksadsdk_local_ad_force_active_data", aVar.toJson().toString()).apply();
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
