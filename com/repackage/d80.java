package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public long b;
    public boolean c;
    public a d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;

        public a() {
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

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject != null) {
                    a aVar = new a();
                    aVar.a = jSONObject.optInt("enable") == 1;
                    aVar.b = jSONObject.optInt("max_auto_play_count");
                    return aVar;
                }
                return null;
            }
            return (a) invokeL.objValue;
        }
    }

    public d80() {
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

    public void a(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, jSONObject, z) == null) {
            if (jSONObject != null) {
                this.a = jSONObject.optString("start_live_scheme");
                this.b = jSONObject.optLong("timeout_refresh_time");
                this.c = jSONObject.optInt("feed_search_switch") == 1;
                this.d = a.a(jSONObject.optJSONObject("auto_play"));
                if (z) {
                    q80.f("live_feed_page_config_cache_key", jSONObject.toString());
                }
            } else if (z) {
                String b = q80.b("live_feed_page_config_cache_key", "");
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(b);
                    this.a = jSONObject2.optString("start_live_scheme");
                    this.b = jSONObject2.optLong("timeout_refresh_time");
                    this.c = jSONObject2.optInt("feed_search_switch") == 1;
                    this.d = a.a(jSONObject2.optJSONObject("auto_play"));
                } catch (JSONException unused) {
                    q80.g("live_feed_page_config_cache_key");
                }
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.d;
            if (aVar != null) {
                return aVar.a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
