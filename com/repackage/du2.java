package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class du2 implements eu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public du2() {
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

    @Override // com.repackage.eu2
    public List<qt2> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
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
            if (optInt > 0 && (optJSONObject = jSONObject.optJSONObject("caller")) != null) {
                b(optString, optJSONObject.optJSONObject("swan"), arrayList, 0);
                b(optString, optJSONObject.optJSONObject("boxjs"), arrayList, 1);
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void b(String str, @Nullable JSONObject jSONObject, @NonNull List<qt2> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, list, i) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(FetchLog.START_TIME);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(FetchLog.END_TIME);
        if (optJSONArray == null || optJSONArray2 == null) {
            return;
        }
        int min = Math.min(optJSONArray.length(), optJSONArray2.length());
        for (int i2 = 0; i2 < min; i2++) {
            qt2 qt2Var = new qt2();
            qt2Var.g(i);
            qt2Var.f(str);
            qt2Var.i(optJSONArray.optLong(i2));
            qt2Var.h(optJSONArray2.optLong(i2));
            list.add(qt2Var);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && eu2.a) {
            Log.d("Api-Parser", str);
        }
    }
}
