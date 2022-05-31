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
public class bb4 extends na4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bb4() {
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

    @Override // com.repackage.na4, com.repackage.qa4
    public void b(JSONObject jSONObject, a74 a74Var, @Nullable a74 a74Var2, @Nullable a74 a74Var3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, a74Var, a74Var2, a74Var3) == null) || jSONObject == null) {
            return;
        }
        db4.b().e(jSONObject.optJSONObject("tipmsgs"));
        hb4.f().k(jSONObject.optJSONObject("page_tips"));
        za4.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        jb4.a().d(jSONObject.optJSONObject("pkg_preload"));
        rb4.f(jSONObject.optJSONObject("app_inner_preload"));
        cb4.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        ob4.b().d(jSONObject.optJSONObject("tts"));
        kb4.a().e(jSONObject.optJSONObject("simple_control_item"));
        pb4.e(jSONObject.optJSONObject("update_expire_time"));
        if (lb4.a) {
            c(jSONObject);
        }
        nb4.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        eb4.a().c(jSONObject.optJSONObject("local_debug"));
        q64.a().b(jSONObject.optJSONObject(q64.a().c()));
        if (mb4.b()) {
            gb4.a().b(jSONObject.optJSONObject("api_description"));
        }
        fb4.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            o64 b = q64.b();
            if4 i = b != null ? b.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                lb4.b = optString;
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
                lb4.a = false;
            }
        }
    }
}
