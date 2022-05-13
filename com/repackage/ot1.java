package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ot1 extends kw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String j;
    public String k;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            char c;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode == 3551) {
                    if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        c = 2;
                    }
                    c = 65535;
                } else if (hashCode != 109935) {
                    if (hashCode == 3005871 && str.equals("auto")) {
                        c = 0;
                    }
                    c = 65535;
                } else {
                    if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                        c = 1;
                    }
                    c = 65535;
                }
                return (c == 0 || c == 1 || c == 2) ? str : "auto";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot1(String str) {
        super("camera", "cameraId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            a(new JSONObject(str));
        } catch (JSONException e) {
            ux1.d("Camera", "parsing CameraAttrModel occurs exception", e);
        }
    }

    @Override // com.repackage.kw1, com.repackage.tq2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.a(jSONObject);
            this.j = jSONObject.optString("devicePosition", "back");
            this.k = jSONObject.optString("flash", "auto");
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.a(this.k) : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ar2 ar2Var = this.h;
            if (ar2Var == null) {
                return 0;
            }
            return ar2Var.c();
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ar2 ar2Var = this.h;
            if (ar2Var == null) {
                return 0;
            }
            return ar2Var.f();
        }
        return invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.equals(this.j, "front") : invokeV.booleanValue;
    }
}
