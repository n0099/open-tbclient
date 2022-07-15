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
/* renamed from: com.kuaishou.weapon.p0.ʽʽ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0354 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f177;

    public C0354(Context context, int i) {
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
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C0331.f78).intValue(), 3, i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f177 = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Set m355(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.f177;
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m356(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = this.f177;
            if (jSONObject != null) {
                try {
                    return jSONObject.optString(str, null);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
