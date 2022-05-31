package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i, String str, String str2) {
        InterceptResult invokeILL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65536, null, i, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                str3 = "statecode={" + i + "};order_no={" + str + "};notify=" + str2;
            } else {
                str3 = "statecode={" + i + "};order_no={" + str + "};notify={" + str2 + "}";
            }
            try {
                jSONObject.put("statusCode", i);
                jSONObject.put("statusMsg", str2);
                jSONObject.put("responseData", str3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeILL.objValue;
    }
}
