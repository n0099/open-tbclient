package com.tachikoma.core.utility;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TKUtility {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class TKUtilityHold {
        public static /* synthetic */ Interceptable $ic;
        public static TKUtility instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536482255, "Lcom/tachikoma/core/utility/TKUtility$TKUtilityHold;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(536482255, "Lcom/tachikoma/core/utility/TKUtility$TKUtilityHold;");
                    return;
                }
            }
            instance = new TKUtility();
        }

        public TKUtilityHold() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public TKUtility() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String TKJSONEncode(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? _NJJSONStringWithObject(obj) : (String) invokeL.objValue;
    }

    public static String _NJJSONStringWithObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof ArrayList) {
                return sharedInstance().getJsonFromArray((ArrayList) obj).toString();
            }
            if (obj instanceof Map) {
                return sharedInstance().getJsonFromMap((Map) obj).toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private JSONArray getJsonFromArray(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, arrayList)) == null) ? new JSONArray((Collection) arrayList) : (JSONArray) invokeL.objValue;
    }

    private JSONObject getJsonFromMap(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, map)) != null) {
            return (JSONObject) invokeL.objValue;
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    if (obj instanceof Map) {
                        obj = getJsonFromMap((Map) obj);
                    } else if (obj instanceof ArrayList) {
                        obj = getJsonFromArray((ArrayList) obj);
                    }
                    jSONObject2.put(str, obj);
                }
                return jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public static int getResourceId(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, str, str2, str3)) == null) {
            try {
                return context.getResources().getIdentifier(str, str2, str3);
            } catch (Exception e2) {
                throw new RuntimeException("Error getResourceId", e2);
            }
        }
        return invokeLLLL.intValue;
    }

    public static int getResourceId(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, str3)) == null) {
            if (str3 == null) {
                try {
                    str3 = TKContextUtil.getContext().getPackageName();
                } catch (Exception e2) {
                    throw new RuntimeException("Error getResourceId by TKContextUtil.getContext()", e2);
                }
            }
            return TKContextUtil.getContext().getResources().getIdentifier(str, str2, str3);
        }
        return invokeLLL.intValue;
    }

    public static TKUtility sharedInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? TKUtilityHold.instance : (TKUtility) invokeV.objValue;
    }
}
