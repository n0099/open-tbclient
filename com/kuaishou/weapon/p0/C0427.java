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
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ˑˑ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0427 extends C0375 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f606;

    public C0427(Context context) {
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
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C0331.f78).intValue(), 5, 5, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f606 = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m820(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.f606;
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public Set m821(Set set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set != null) {
                try {
                    if (set.size() > 0) {
                        HashSet hashSet = new HashSet();
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            if (!m823(set, str)) {
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
    public JSONObject m822() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f606 : (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m823(Set set, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, set, str)) == null) {
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
}
