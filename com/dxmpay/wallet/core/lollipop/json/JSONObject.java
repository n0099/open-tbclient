package com.dxmpay.wallet.core.lollipop.json;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.lollipop.json.JSONStringer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class JSONObject {
    public static /* synthetic */ Interceptable $ic;
    public static final Double NEGATIVE_ZERO;
    public static final Object NULL;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<String, Object> nameValuePairs;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1769359825, "Lcom/dxmpay/wallet/core/lollipop/json/JSONObject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1769359825, "Lcom/dxmpay/wallet/core/lollipop/json/JSONObject;");
                return;
            }
        }
        NEGATIVE_ZERO = Double.valueOf(-0.0d);
        NULL = new Object() { // from class: com.dxmpay.wallet.core.lollipop.json.JSONObject.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? obj == this || obj == null : invokeL.booleanValue;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? StringUtil.NULL_STRING : (String) invokeV.objValue;
            }
        };
    }

    public JSONObject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.nameValuePairs = new LinkedHashMap<>();
    }

    public static String numberToString(Number number) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, number)) == null) {
            if (number != null) {
                double doubleValue = number.doubleValue();
                JSON.checkDouble(doubleValue);
                if (number.equals(NEGATIVE_ZERO)) {
                    return "-0";
                }
                long longValue = number.longValue();
                if (doubleValue == longValue) {
                    return Long.toString(longValue);
                }
                return number.toString();
            }
            throw new JSONException("Number must be non-null");
        }
        return (String) invokeL.objValue;
    }

    public static String quote(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return "\"\"";
            }
            try {
                JSONStringer jSONStringer = new JSONStringer();
                jSONStringer.open(JSONStringer.Scope.NULL, "");
                jSONStringer.value(str);
                jSONStringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
                return jSONStringer.toString();
            } catch (JSONException unused) {
                throw new AssertionError();
            }
        }
        return (String) invokeL.objValue;
    }

    public static Object wrap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            if (obj == null) {
                return NULL;
            }
            if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(NULL)) {
                return obj;
            }
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return new JSONArray(obj);
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                if (obj.getClass().getPackage().getName().startsWith("java.")) {
                    return obj.toString();
                }
                return null;
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public JSONObject accumulate(String str, Object obj) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
            Object obj2 = this.nameValuePairs.get(checkName(str));
            if (obj2 == null) {
                return put(str, obj);
            }
            if (obj2 instanceof JSONArray) {
                ((JSONArray) obj2).checkedPut(obj);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.checkedPut(obj2);
                jSONArray.checkedPut(obj);
                this.nameValuePairs.put(str, jSONArray);
            }
            return this;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public JSONObject append(String str, Object obj) throws JSONException {
        InterceptResult invokeLL;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            Object obj2 = this.nameValuePairs.get(checkName(str));
            if (obj2 instanceof JSONArray) {
                jSONArray = (JSONArray) obj2;
            } else if (obj2 == null) {
                jSONArray = new JSONArray();
                this.nameValuePairs.put(str, jSONArray);
            } else {
                throw new JSONException("Key " + str + " is not a JSONArray");
            }
            jSONArray.checkedPut(obj);
            return this;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public String checkName(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str != null) {
                return str;
            }
            throw new JSONException("Names must be non-null");
        }
        return (String) invokeL.objValue;
    }

    public Object get(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Object obj = this.nameValuePairs.get(str);
            if (obj != null) {
                return obj;
            }
            throw new JSONException("No value for " + str);
        }
        return invokeL.objValue;
    }

    public boolean getBoolean(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Object obj = get(str);
            Boolean bool = JSON.toBoolean(obj);
            if (bool != null) {
                return bool.booleanValue();
            }
            throw JSON.typeMismatch(str, obj, "boolean");
        }
        return invokeL.booleanValue;
    }

    public double getDouble(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Object obj = get(str);
            Double d2 = JSON.toDouble(obj);
            if (d2 != null) {
                return d2.doubleValue();
            }
            throw JSON.typeMismatch(str, obj, "double");
        }
        return invokeL.doubleValue;
    }

    public int getInt(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            Object obj = get(str);
            Integer integer = JSON.toInteger(obj);
            if (integer != null) {
                return integer.intValue();
            }
            throw JSON.typeMismatch(str, obj, "int");
        }
        return invokeL.intValue;
    }

    public JSONArray getJSONArray(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Object obj = get(str);
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
            throw JSON.typeMismatch(str, obj, "JSONArray");
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            Object obj = get(str);
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            throw JSON.typeMismatch(str, obj, "JSONObject");
        }
        return (JSONObject) invokeL.objValue;
    }

    public long getLong(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Object obj = get(str);
            Long l = JSON.toLong(obj);
            if (l != null) {
                return l.longValue();
            }
            throw JSON.typeMismatch(str, obj, "long");
        }
        return invokeL.longValue;
    }

    public String getString(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Object obj = get(str);
            String json = JSON.toString(obj);
            if (json != null) {
                return json;
            }
            throw JSON.typeMismatch(str, obj, "String");
        }
        return (String) invokeL.objValue;
    }

    public boolean has(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this.nameValuePairs.containsKey(str) : invokeL.booleanValue;
    }

    public boolean isNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Object obj = this.nameValuePairs.get(str);
            return obj == null || obj == NULL;
        }
        return invokeL.booleanValue;
    }

    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.nameValuePairs.keySet() : (Set) invokeV.objValue;
    }

    public Iterator<String> keys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.nameValuePairs.keySet().iterator() : (Iterator) invokeV.objValue;
    }

    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.nameValuePairs.size() : invokeV.intValue;
    }

    public JSONArray names() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.nameValuePairs.isEmpty()) {
                return null;
            }
            return new JSONArray((Collection) new ArrayList(this.nameValuePairs.keySet()));
        }
        return (JSONArray) invokeV.objValue;
    }

    public Object opt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this.nameValuePairs.get(str) : invokeL.objValue;
    }

    public boolean optBoolean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? optBoolean(str, false) : invokeL.booleanValue;
    }

    public double optDouble(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? optDouble(str, Double.NaN) : invokeL.doubleValue;
    }

    public int optInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? optInt(str, 0) : invokeL.intValue;
    }

    public JSONArray optJSONArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            Object opt = opt(str);
            if (opt instanceof JSONArray) {
                return (JSONArray) opt;
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONObject optJSONObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            Object opt = opt(str);
            if (opt instanceof JSONObject) {
                return (JSONObject) opt;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public long optLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? optLong(str, 0L) : invokeL.longValue;
    }

    public String optString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? optString(str, "") : (String) invokeL.objValue;
    }

    public JSONObject put(String str, boolean z) throws JSONException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, str, z)) == null) {
            this.nameValuePairs.put(checkName(str), Boolean.valueOf(z));
            return this;
        }
        return (JSONObject) invokeLZ.objValue;
    }

    public JSONObject putOpt(String str, Object obj) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, str, obj)) == null) ? (str == null || obj == null) ? this : put(str, obj) : (JSONObject) invokeLL.objValue;
    }

    public Object remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) ? this.nameValuePairs.remove(str) : invokeL.objValue;
    }

    public JSONArray toJSONArray(JSONArray jSONArray) throws JSONException {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, jSONArray)) == null) {
            JSONArray jSONArray2 = new JSONArray();
            if (jSONArray == null || (length = jSONArray.length()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < length; i2++) {
                jSONArray2.put(opt(JSON.toString(jSONArray.opt(i2))));
            }
            return jSONArray2;
        }
        return (JSONArray) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                writeTo(jSONStringer);
                return jSONStringer.toString();
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void writeTo(JSONStringer jSONStringer) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jSONStringer) == null) {
            jSONStringer.object();
            for (Map.Entry<String, Object> entry : this.nameValuePairs.entrySet()) {
                jSONStringer.key(entry.getKey()).value(entry.getValue());
            }
            jSONStringer.endObject();
        }
    }

    public boolean optBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048595, this, str, z)) == null) {
            Boolean bool = JSON.toBoolean(opt(str));
            return bool != null ? bool.booleanValue() : z;
        }
        return invokeLZ.booleanValue;
    }

    public double optDouble(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            Double d3 = JSON.toDouble(opt(str));
            return d3 != null ? d3.doubleValue() : d2;
        }
        return invokeCommon.doubleValue;
    }

    public int optInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, str, i2)) == null) {
            Integer integer = JSON.toInteger(opt(str));
            return integer != null ? integer.intValue() : i2;
        }
        return invokeLI.intValue;
    }

    public long optLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048603, this, str, j2)) == null) {
            Long l = JSON.toLong(opt(str));
            return l != null ? l.longValue() : j2;
        }
        return invokeLJ.longValue;
    }

    public String optString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, str2)) == null) {
            String json = JSON.toString(opt(str));
            return json != null ? json : str2;
        }
        return (String) invokeLL.objValue;
    }

    public JSONObject put(String str, double d2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            this.nameValuePairs.put(checkName(str), Double.valueOf(JSON.checkDouble(d2)));
            return this;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONObject(Map map) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                this.nameValuePairs.put(str, wrap(entry.getValue()));
            } else {
                throw new NullPointerException("key == null");
            }
        }
    }

    public JSONObject put(String str, int i2) throws JSONException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048607, this, str, i2)) == null) {
            this.nameValuePairs.put(checkName(str), Integer.valueOf(i2));
            return this;
        }
        return (JSONObject) invokeLI.objValue;
    }

    public JSONObject put(String str, long j2) throws JSONException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048608, this, str, j2)) == null) {
            this.nameValuePairs.put(checkName(str), Long.valueOf(j2));
            return this;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    public String toString(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            JSONStringer jSONStringer = new JSONStringer(i2);
            writeTo(jSONStringer);
            return jSONStringer.toString();
        }
        return (String) invokeI.objValue;
    }

    public JSONObject put(String str, Object obj) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, str, obj)) == null) {
            if (obj == null) {
                this.nameValuePairs.remove(str);
                return this;
            }
            if (obj instanceof Number) {
                JSON.checkDouble(((Number) obj).doubleValue());
            }
            this.nameValuePairs.put(checkName(str), obj);
            return this;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONTokener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Object nextValue = jSONTokener.nextValue();
        if (nextValue instanceof JSONObject) {
            this.nameValuePairs = ((JSONObject) nextValue).nameValuePairs;
            return;
        }
        throw JSON.typeMismatch(nextValue, "JSONObject");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONObject(String str) throws JSONException {
        this(new JSONTokener(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((JSONTokener) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONObject(JSONObject jSONObject, String[] strArr) throws JSONException {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, strArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        for (String str : strArr) {
            Object opt = jSONObject.opt(str);
            if (opt != null) {
                this.nameValuePairs.put(str, opt);
            }
        }
    }
}
