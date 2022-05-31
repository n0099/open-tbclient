package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public List<LiveTabEntity> c;
    public boolean d;
    public long e;
    public int f;

    public i80() {
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

    public final void a(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.c = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                LiveTabEntity liveTabEntity = new LiveTabEntity();
                liveTabEntity.parserJson(optJSONObject);
                this.c.add(liveTabEntity);
            }
        }
    }

    public void b(JSONObject jSONObject, boolean z, int i) {
        List<LiveTabEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (jSONObject != null) {
                this.a = jSONObject.optInt("inner_errno");
                this.b = jSONObject.optString("inner_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                a(optJSONArray);
                if (z && optJSONArray != null && (list = this.c) != null && !list.isEmpty()) {
                    q80.e("live_feed_page_tab_cache_time", System.currentTimeMillis());
                    q80.f("live_feed_page_tab_cache_key", optJSONArray.toString());
                }
            }
            if (z) {
                List<LiveTabEntity> list2 = this.c;
                if (list2 == null || list2.isEmpty()) {
                    this.f = 2;
                    String b = q80.b("live_feed_page_tab_cache_key", "");
                    if (TextUtils.isEmpty(b)) {
                        return;
                    }
                    try {
                        a(new JSONArray(b));
                        this.d = true;
                        if (i == -101) {
                            this.f = 1;
                        } else if (this.a != 0) {
                            this.f = 3;
                        }
                        this.e = q80.c("live_feed_page_tab_cache_time", 0L);
                    } catch (JSONException unused) {
                        q80.g("live_feed_page_tab_cache_key");
                        q80.g("live_feed_page_tab_cache_time");
                    }
                }
            }
        }
    }
}
