package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) ? !str.equals(str2) ? b(str, str2) : str : (String) invokeLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            HashSet<String> hashSet = new HashSet();
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("services");
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add(jSONArray.getString(i));
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONArray jSONArray2 = new JSONObject(str2).getJSONArray("services");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    hashSet.add(jSONArray2.getString(i2));
                }
            }
            if (hashSet.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray3 = new JSONArray();
            for (String str3 : hashSet) {
                jSONArray3.put(str3);
            }
            jSONObject.put("services", jSONArray3);
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }
}
