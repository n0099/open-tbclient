package com.repackage;

import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<k80> a;

    public l80() {
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

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("inner_errno");
        jSONObject.optString("inner_msg");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.a = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    k80 k80Var = new k80();
                    k80Var.a(optJSONObject2);
                    this.a.add(k80Var);
                }
            }
        }
        if (na0.c(this.a) || (optJSONObject = jSONObject.optJSONObject("more")) == null) {
            return;
        }
        String optString = optJSONObject.optString("scheme");
        if (ta0.a(optString)) {
            return;
        }
        k80 k80Var2 = new k80();
        k80Var2.d = optString;
        k80Var2.a = true;
        LiveHostInfo liveHostInfo = new LiveHostInfo();
        liveHostInfo.name = optJSONObject.optString("txt");
        k80Var2.e = liveHostInfo;
        this.a.add(k80Var2);
    }
}
