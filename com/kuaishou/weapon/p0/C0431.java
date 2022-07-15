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
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ــ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0431 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f609;

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean f610;

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean f611;

    public C0431(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C0331.f82).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f609 = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Set m834(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            HashSet hashSet = new HashSet();
            if (i == 0) {
                hashSet.add("/preas/chi");
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Set m835(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, i)) == null) {
            JSONObject jSONObject = this.f609;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    Set m834 = m834(i);
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    HashSet hashSet = new HashSet();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String replace = jSONArray.getString(i2).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                        if (replace.startsWith(":")) {
                            replace = replace.substring(1);
                        }
                        String substring = replace.length() > 10 ? replace.substring(0, 10) : replace;
                        String packageName = context.getPackageName();
                        if (!replace.contains(packageName) && !packageName.contains(replace) && !m834.contains(substring)) {
                            hashSet.add(replace);
                        }
                    }
                    if (hashSet.size() > 0) {
                        return hashSet;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Set) invokeLLI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONArray m836(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            JSONObject jSONObject = this.f609;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    HashSet<Object> hashSet = new HashSet();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(jSONArray.getString(i));
                    }
                    JSONArray jSONArray2 = new JSONArray();
                    for (Object obj : hashSet) {
                        jSONArray2.put(obj);
                    }
                    return jSONArray2;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m837() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f611 : invokeV.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public JSONArray m838(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            JSONObject jSONObject = this.f609;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    int i = 0;
                    if (TextUtils.equals(str, "46")) {
                        if (TextUtils.isEmpty(string) || string.length() <= 3) {
                            return null;
                        }
                        JSONArray jSONArray = new JSONArray(string);
                        JSONArray jSONArray2 = new JSONArray();
                        while (i < jSONArray.length()) {
                            jSONArray2.put(jSONArray.getString(i).replaceAll(" ", "").replace("\n", "").replace(">", ""));
                            i++;
                        }
                        return jSONArray2;
                    } else if (TextUtils.equals(str, "45")) {
                        String m182 = C0307.m182("aae31bed33c490b6613a", "0701");
                        String m1822 = C0307.m182("99e111e83fc4d0a7662b", "0701");
                        if (TextUtils.isEmpty(string) || string.length() <= 3) {
                            return null;
                        }
                        JSONArray jSONArray3 = new JSONArray(string);
                        HashSet hashSet = new HashSet();
                        while (i < jSONArray3.length()) {
                            hashSet.add(jSONArray3.getString(i).replaceAll(" ", "").replace("\n", ""));
                            i++;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        for (Object obj : hashSet) {
                            jSONArray4.put(obj);
                            String str2 = (String) obj;
                            if (str2.contains(m182)) {
                                this.f610 = true;
                            }
                            if (str2.contains(m1822)) {
                                this.f611 = true;
                            }
                        }
                        return jSONArray4;
                    } else {
                        return null;
                    }
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m839() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f610 : invokeV.booleanValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public Set m840(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            JSONObject jSONObject = this.f609;
            if (jSONObject != null) {
                try {
                    String optString = jSONObject.optString(str, null);
                    if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                        HashSet hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(optString);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i), 16).intValue()));
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

    /* renamed from: ʾ  reason: contains not printable characters */
    public String m841(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            JSONObject jSONObject = this.f609;
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
}
