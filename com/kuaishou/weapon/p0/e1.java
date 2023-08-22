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
public class e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    public e1(Context context, int i) {
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
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(l2.c).intValue(), 5, i, "");
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

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (JSONObject) invokeV.objValue;
    }

    public JSONObject a(JSONArray jSONArray) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (string.contains("data/data")) {
                            if (string.contains("libjnigraphics.so")) {
                                jSONObject.put("0", 1);
                                str = "0-p";
                            } else if (string.contains("libandroid.so")) {
                                jSONObject.put("1", 1);
                                str = "1-p";
                            } else if (string.contains("libjavacrypto.so")) {
                                jSONObject.put("2", 1);
                                str = "2-p";
                            } else if (string.contains("libRSCpuRef.so")) {
                                jSONObject.put("3", 1);
                                str = "3-p";
                            }
                            jSONObject.put(str, string);
                        }
                    }
                    if (jSONObject.length() > 0) {
                        return jSONObject;
                    }
                } catch (Exception unused) {
                }
            }
            return null;
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
}
