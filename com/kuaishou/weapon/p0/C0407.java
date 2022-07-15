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
/* renamed from: com.kuaishou.weapon.p0.ˊˊ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0407 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f476;

    public C0407(Context context, int i) {
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
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C0331.f78).intValue(), 2, i < 10 ? 10 : i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f476 = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Set m571(Set set) {
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
                            if (!m575(set, str)) {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONArray m572(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = this.f476;
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
                    Set m571 = m571(hashSet);
                    if (m571 == null || m571.size() <= 0) {
                        return null;
                    }
                    return new JSONArray((Collection) m571);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m573(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (this.f476 != null) {
                try {
                    String m576 = m576(str);
                    if (!TextUtils.isEmpty(m576) && m576.length() > 3) {
                        JSONObject jSONObject = new JSONObject(m576);
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m574(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            try {
                String m182 = C0307.m182("da4c6c97b9", "0702");
                String m1822 = C0307.m182("da4c709eb15f", "0702");
                JSONArray optJSONArray = jSONObject.optJSONArray(m182);
                JSONArray optJSONArray2 = jSONObject.optJSONArray(m1822);
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m575(Set set, String str) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m576(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            JSONObject jSONObject = this.f476;
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public JSONObject m577(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.f476 != null) {
                try {
                    String m576 = m576(str);
                    if (TextUtils.isEmpty(m576) || m576.length() <= 3) {
                        return null;
                    }
                    return new JSONObject(m576);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public JSONObject m578(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.f476 != null) {
                try {
                    String m576 = m576(str);
                    if (TextUtils.isEmpty(m576) || m576.length() <= 3) {
                        return null;
                    }
                    return m574(new JSONObject(m576));
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }
}
