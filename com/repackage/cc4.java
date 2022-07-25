package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cc4 extends ob4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cc4() {
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

    @Override // com.repackage.ob4, com.repackage.rb4
    public void b(JSONObject jSONObject, b84 b84Var, @Nullable b84 b84Var2, @Nullable b84 b84Var3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, b84Var, b84Var2, b84Var3) == null) || jSONObject == null) {
            return;
        }
        ec4.b().e(jSONObject.optJSONObject("tipmsgs"));
        ic4.f().k(jSONObject.optJSONObject("page_tips"));
        ac4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        kc4.a().d(jSONObject.optJSONObject("pkg_preload"));
        sc4.f(jSONObject.optJSONObject("app_inner_preload"));
        dc4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        pc4.b().d(jSONObject.optJSONObject("tts"));
        lc4.a().e(jSONObject.optJSONObject("simple_control_item"));
        qc4.e(jSONObject.optJSONObject("update_expire_time"));
        if (mc4.a) {
            c(jSONObject);
        }
        oc4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        fc4.a().c(jSONObject.optJSONObject("local_debug"));
        r74.a().b(jSONObject.optJSONObject(r74.a().c()));
        if (nc4.b()) {
            hc4.a().b(jSONObject.optJSONObject("api_description"));
        }
        gc4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            p74 b = r74.b();
            ig4 i = b != null ? b.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                mc4.b = optString;
                if (i != null) {
                    i.putString("key_h2_heart_beat_version", optString);
                }
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) > 0) {
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
                mc4.a = false;
            }
        }
    }
}
