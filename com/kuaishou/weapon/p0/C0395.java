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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʾʾ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0395 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f366;

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean f367;

    public C0395(Context context) {
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
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C0331.f82).intValue(), 0, 200, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f366 = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public List m504(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.f366;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    String m182 = C0307.m182("98bb0a15913e0654348b", "0805");
                    JSONArray jSONArray = new JSONArray(string);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string2 = jSONArray.getString(i);
                        if (string2.contains(m182)) {
                            this.f367 = true;
                        } else {
                            arrayList.add(string2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        return arrayList;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m505() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f367 : invokeV.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m506(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            JSONObject jSONObject = this.f366;
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
