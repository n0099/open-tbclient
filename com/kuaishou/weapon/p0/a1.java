package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    public a1(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(l2.c).intValue(), 2, i < 10 ? 10 : i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public Set a(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, set)) == null) {
            if (set != null) {
                try {
                    if (set.size() > 0) {
                        HashSet hashSet = new HashSet();
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            if (!a(set, str)) {
                                hashSet.add(str);
                            }
                        }
                        return hashSet;
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (Set) invokeL.objValue;
    }

    public JSONArray a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string) || string.length() <= 2) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add((String) jSONArray.get(i));
                    }
                    Set a = a(hashSet);
                    if (a == null || a.size() <= 0) {
                        return null;
                    }
                    return new JSONArray((Collection) a);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONObject a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (this.a != null) {
                try {
                    String b = b(str);
                    if (!TextUtils.isEmpty(b) && b.length() > 3) {
                        JSONObject jSONObject = new JSONObject(b);
                        if (z) {
                            Iterator<String> keys = jSONObject.keys();
                            boolean z2 = false;
                            while (keys.hasNext()) {
                                if (jSONObject.getInt(keys.next()) == 1) {
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                return jSONObject;
                            }
                            return null;
                        }
                        return jSONObject;
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (JSONObject) invokeLZ.objValue;
    }

    public JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            try {
                String a = j.a("da4c6c97b9", "0702");
                String a2 = j.a("da4c709eb15f", "0702");
                JSONArray optJSONArray = jSONObject.optJSONArray(a);
                JSONArray optJSONArray2 = jSONObject.optJSONArray(a2);
                JSONObject jSONObject2 = new JSONObject();
                if (optJSONArray != null && optJSONArray.length() == 3) {
                    jSONObject2.put("0", optJSONArray.get(2));
                }
                if (optJSONArray2 != null && optJSONArray2.length() == 3) {
                    jSONObject2.put("1", optJSONArray2.get(2));
                }
                if (jSONObject2.length() > 0) {
                    return jSONObject2;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public boolean a(Set set, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, set, str)) == null) {
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!str2.equals(str) && str2.contains(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    return jSONObject.getString(str);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.a != null) {
                try {
                    String b = b(str);
                    if (TextUtils.isEmpty(b) || b.length() <= 3) {
                        return null;
                    }
                    return new JSONObject(b);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.a != null) {
                try {
                    String b = b(str);
                    if (TextUtils.isEmpty(b) || b.length() <= 3) {
                        return null;
                    }
                    return a(new JSONObject(b));
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }
}
