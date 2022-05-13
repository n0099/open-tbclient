package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Comparator<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, jSONObject2)) == null) ? jSONObject.optString(this.a, "").compareTo(jSONObject2.optString(this.a, "")) : invokeLL.intValue;
        }
    }

    public static JSONArray a(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jSONArray, str)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return jSONArray;
            }
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(optJSONObject);
                }
            }
            Collections.sort(arrayList, new a(str));
            return new JSONArray((Collection) arrayList);
        }
        return (JSONArray) invokeLL.objValue;
    }

    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jSONObject, jSONObject2, str)) == null) ? jSONObject.optLong(str, -1L) != jSONObject2.optLong(str, -1L) : invokeLLL.booleanValue;
    }

    public static boolean c(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, jSONObject, jSONObject2, str)) == null) {
            String optString = jSONObject.optString(str);
            String optString2 = jSONObject2.optString(str);
            return !(TextUtils.isEmpty(optString) ? TextUtils.isEmpty(optString2) : optString.equals(optString2));
        }
        return invokeLLL.booleanValue;
    }
}
