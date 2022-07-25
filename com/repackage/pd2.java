package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class pd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public String c;
    public JSONObject d;

    public pd2() {
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

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (h03.K().k() == 0) {
                return c(this.d, "bbasp_guide_");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONArray optJSONArray = this.d.optJSONArray("custom_guide_list");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("appid", "");
                    if (i03.g0() == null || TextUtils.equals(i03.g0(), optString)) {
                        return c(optJSONObject, "");
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            boolean z = false;
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString(str + "count", "3");
            try {
                int intValue = !TextUtils.isEmpty(optString) ? Integer.valueOf(optString).intValue() : 0;
                String optString2 = jSONObject.optString(str + "interval", "72");
                long longValue = !TextUtils.isEmpty(optString2) ? Long.valueOf(optString2).longValue() : 0L;
                long optLong = jSONObject.optLong(str + "last_time", 0L);
                int optInt = jSONObject.optInt(str + "shown_count", 0);
                int optInt2 = jSONObject.optInt(str + "image_index", 0);
                boolean z2 = System.currentTimeMillis() - optLong > longValue * 3600000;
                boolean i = i(jSONObject.optJSONArray("scenes"));
                if (optInt < intValue && z2 && i) {
                    z = true;
                }
                if (z) {
                    g(jSONObject, optInt2, str + "images");
                }
            } catch (NumberFormatException unused) {
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String string = w83.a().getString("swan_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a) {
                return "special";
            }
            if (this.b) {
                return "normal";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public final int g(JSONObject jSONObject, int i, String str) {
        InterceptResult invokeLIL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, jSONObject, i, str)) == null) {
            if (jSONObject == null || i < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return 0;
            }
            if (i >= optJSONArray.length()) {
                i = 0;
            }
            this.c = optJSONArray.optString(i);
            return i;
        }
        return invokeLIL.intValue;
    }

    public pd2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.a = false;
            this.b = false;
            this.c = null;
            JSONObject d = d();
            this.d = d;
            if (d != null && d.length() != 0) {
                boolean b = b();
                this.a = b;
                if (b) {
                    return this;
                }
                this.b = a();
            }
            return this;
        }
        return (pd2) invokeV.objValue;
    }

    public final boolean i(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return true;
            }
            String T = h03.K().q().W().T();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(T, jSONArray.optString(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b || this.a : invokeV.booleanValue;
    }
}
