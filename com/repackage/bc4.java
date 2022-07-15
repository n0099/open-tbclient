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
public class bc4 extends nb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bc4() {
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

    @Override // com.repackage.nb4, com.repackage.qb4
    public void b(JSONObject jSONObject, a84 a84Var, @Nullable a84 a84Var2, @Nullable a84 a84Var3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, a84Var, a84Var2, a84Var3) == null) || jSONObject == null) {
            return;
        }
        dc4.b().e(jSONObject.optJSONObject("tipmsgs"));
        hc4.f().k(jSONObject.optJSONObject("page_tips"));
        zb4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        jc4.a().d(jSONObject.optJSONObject("pkg_preload"));
        rc4.f(jSONObject.optJSONObject("app_inner_preload"));
        cc4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        oc4.b().d(jSONObject.optJSONObject("tts"));
        kc4.a().e(jSONObject.optJSONObject("simple_control_item"));
        pc4.e(jSONObject.optJSONObject("update_expire_time"));
        if (lc4.a) {
            c(jSONObject);
        }
        nc4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        ec4.a().c(jSONObject.optJSONObject("local_debug"));
        q74.a().b(jSONObject.optJSONObject(q74.a().c()));
        if (mc4.b()) {
            gc4.a().b(jSONObject.optJSONObject("api_description"));
        }
        fc4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            o74 b = q74.b();
            hg4 i = b != null ? b.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                lc4.b = optString;
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
                lc4.a = false;
            }
        }
    }
}
