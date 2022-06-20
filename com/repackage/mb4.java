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
/* loaded from: classes6.dex */
public class mb4 extends ya4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mb4() {
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

    @Override // com.repackage.ya4, com.repackage.bb4
    public void b(JSONObject jSONObject, l74 l74Var, @Nullable l74 l74Var2, @Nullable l74 l74Var3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, l74Var, l74Var2, l74Var3) == null) || jSONObject == null) {
            return;
        }
        ob4.b().e(jSONObject.optJSONObject("tipmsgs"));
        sb4.f().k(jSONObject.optJSONObject("page_tips"));
        kb4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        ub4.a().d(jSONObject.optJSONObject("pkg_preload"));
        cc4.f(jSONObject.optJSONObject("app_inner_preload"));
        nb4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        zb4.b().d(jSONObject.optJSONObject("tts"));
        vb4.a().e(jSONObject.optJSONObject("simple_control_item"));
        ac4.e(jSONObject.optJSONObject("update_expire_time"));
        if (wb4.a) {
            c(jSONObject);
        }
        yb4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        pb4.a().c(jSONObject.optJSONObject("local_debug"));
        b74.a().b(jSONObject.optJSONObject(b74.a().c()));
        if (xb4.b()) {
            rb4.a().b(jSONObject.optJSONObject("api_description"));
        }
        qb4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            z64 b = b74.b();
            sf4 i = b != null ? b.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                wb4.b = optString;
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
                wb4.a = false;
            }
        }
    }
}
