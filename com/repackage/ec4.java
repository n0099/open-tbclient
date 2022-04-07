package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ec4 extends qb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ec4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.qb4, com.repackage.tb4
    public void b(JSONObject jSONObject, d84 d84Var, @Nullable d84 d84Var2, @Nullable d84 d84Var3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, d84Var, d84Var2, d84Var3) == null) || jSONObject == null) {
            return;
        }
        gc4.b().e(jSONObject.optJSONObject("tipmsgs"));
        kc4.f().k(jSONObject.optJSONObject("page_tips"));
        cc4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        mc4.a().d(jSONObject.optJSONObject("pkg_preload"));
        uc4.f(jSONObject.optJSONObject("app_inner_preload"));
        fc4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        rc4.b().d(jSONObject.optJSONObject("tts"));
        nc4.a().e(jSONObject.optJSONObject("simple_control_item"));
        sc4.e(jSONObject.optJSONObject("update_expire_time"));
        if (oc4.a) {
            c(jSONObject);
        }
        qc4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        hc4.a().c(jSONObject.optJSONObject("local_debug"));
        t74.a().b(jSONObject.optJSONObject(t74.a().c()));
        if (pc4.b()) {
            jc4.a().b(jSONObject.optJSONObject("api_description"));
        }
        ic4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            r74 b = t74.b();
            lg4 i = b != null ? b.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                oc4.b = optString;
                if (i != null) {
                    i.putString("key_h2_heart_beat_version", optString);
                }
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                if (optJSONObject2.optInt("switch") > 0) {
                    int optInt = optJSONObject2.optInt("timespan");
                    int optInt2 = optJSONObject2.optInt("timeout");
                    if (i != null) {
                        if (optInt > 0) {
                            i.putInt("key_h2_heart_beat_timespan", optInt);
                        }
                        if (optInt2 > 0) {
                            i.putInt("key_h2_heart_beat_timeout", optInt2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                oc4.a = false;
            }
        }
    }
}
