package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʽـ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0375 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0375() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONArray m425(JSONArray jSONArray, JSONArray jSONArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, jSONArray2)) == null) {
            if (jSONArray != null) {
                if (jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
                    Set m452 = C0380.m452(jSONArray);
                    Set m4522 = C0380.m452(jSONArray2);
                    if (m452 != null && m4522 != null) {
                        m452.removeAll(m4522);
                        if (m452.size() > 0) {
                            return new JSONArray((Collection) m452);
                        }
                        return null;
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONArray m426(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str)) == null) {
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String str2 = (String) jSONArray.get(i);
                        if (str2.contains("frida")) {
                            hashSet.add(str2);
                        }
                    }
                    if (hashSet.size() > 0) {
                        return new JSONArray((Collection) hashSet);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeLL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONArray m427(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
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
                    if (hashSet.size() > 0) {
                        return new JSONArray((Collection) hashSet);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeLL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public JSONArray m428(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, str)) == null) {
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String str2 = (String) jSONArray.get(i);
                        if (str2.contains("substrate") || str2.contains(".jar") || str2.contains("xposed")) {
                            hashSet.add(str2);
                        }
                    }
                    if (hashSet.size() > 0) {
                        return new JSONArray((Collection) hashSet);
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeLL.objValue;
    }
}
