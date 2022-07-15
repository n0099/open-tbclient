package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʻﹶ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0316 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject f62;

    public C0316(Context context) {
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
            String fgh = Engine.getInstance(context).fgh();
            if (TextUtils.isEmpty(fgh)) {
                return;
            }
            try {
                this.f62 = new JSONObject(fgh);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m223(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.f62;
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
