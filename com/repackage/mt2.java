package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mt2 implements ot2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public Set<String> c;

    public mt2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "boxjs.";
        this.c = Sets.newHashSet("getAppInfoSync", "performpanel", "statisticEvent", "ubcReport", "getSlaveIdSync", "ubcFlowJar");
    }

    @Override // com.repackage.ot2
    public List<at2> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            ArrayList arrayList = new ArrayList();
            String optString = jSONObject.optString("apiName");
            c("api-name " + optString);
            if (TextUtils.isEmpty(optString)) {
                return arrayList;
            }
            int optInt = jSONObject.optInt("count");
            c("api-count " + optInt);
            if (optInt <= 0) {
                return arrayList;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(FetchLog.START_TIME);
            JSONArray optJSONArray2 = jSONObject.optJSONArray(FetchLog.END_TIME);
            if (optJSONArray != null && optJSONArray2 != null) {
                int min = Math.min(optJSONArray.length(), optJSONArray2.length());
                if (min <= 0) {
                    return arrayList;
                }
                for (int i = 0; i < min; i++) {
                    at2 at2Var = new at2();
                    at2Var.f(optString);
                    at2Var.g(b(at2Var));
                    at2Var.i(optJSONArray.optLong(i));
                    at2Var.h(optJSONArray2.optLong(i));
                    arrayList.add(at2Var);
                    if (ot2.a) {
                        c(at2Var.toString());
                    }
                }
                return arrayList;
            }
            c("startTimes or endTimes is empty");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final int b(at2 at2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, at2Var)) == null) {
            String a = at2Var.a();
            if (TextUtils.isEmpty(a)) {
                return 0;
            }
            return (a.startsWith(this.b) || this.c.contains(a)) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && ot2.a) {
            Log.d("Api-Parser", str);
        }
    }
}
