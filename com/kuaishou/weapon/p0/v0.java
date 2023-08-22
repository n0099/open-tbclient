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
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public boolean b;
    public boolean c;

    public v0(Context context) {
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
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(l2.g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public Set a(int i) {
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

    public Set a(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, i)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    Set a = a(i);
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
                        if (!replace.contains(packageName) && !packageName.contains(replace) && !a.contains(substring)) {
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

    public JSONArray a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            JSONObject jSONObject = this.a;
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public JSONArray b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    int i = 0;
                    if (TextUtils.equals(str, PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_CLOSE_BTN_CLICK)) {
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
                    } else if (TextUtils.equals(str, PayUVEventType.PAY_SPLIT_ORDER_RESULT_SUCCESS_PAGE_SHOW)) {
                        String a = j.a("aae31bed33c490b6613a", "0701");
                        String a2 = j.a("99e111e83fc4d0a7662b", "0701");
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
                            if (str2.contains(a)) {
                                this.b = true;
                            }
                            if (str2.contains(a2)) {
                                this.c = true;
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

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public Set c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            JSONObject jSONObject = this.a;
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

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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
}
