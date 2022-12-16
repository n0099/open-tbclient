package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    public q0(Context context) {
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
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(l2.g).intValue(), 0, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (!TextUtils.isEmpty(string)) {
                        if (string.contains(StringUtil.EMPTY_ARRAY)) {
                            return null;
                        }
                        return string;
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public JSONObject b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string) || string.length() <= 3) {
                        return null;
                    }
                    return new JSONObject(string);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }
}
