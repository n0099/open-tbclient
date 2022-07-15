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
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼˆ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0324 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f69;

    public C0324(Context context) {
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
            String nop = Engine.getInstance(context).nop();
            if (TextUtils.isEmpty(nop)) {
                return;
            }
            try {
                this.f69 = new JSONObject(nop);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONArray m232(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.f69;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    try {
                        if (jSONArray.length() > 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                String m174 = C0304.m174(jSONObject2.optString("1"));
                                String m1742 = C0304.m174(jSONObject2.optString("2"));
                                if (!TextUtils.isEmpty(m174)) {
                                    jSONObject2.put("1", m174);
                                }
                                if (!TextUtils.isEmpty(m1742)) {
                                    jSONObject2.put("2", m1742);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONArray;
                } catch (Exception unused2) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m233(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = this.f69;
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
