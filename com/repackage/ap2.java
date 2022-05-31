package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ap2 extends np1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap2(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "UpdateMenuStyleApi" : (String) invokeV.objValue;
    }

    public hr1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#changeMenuStyle", false);
            Pair<hr1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((hr1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(202);
                }
                int y = y(optString);
                uk2 U = uk2.U();
                if (U == null) {
                    return new hr1(1001);
                }
                qy1 V = U.V();
                if (V == null) {
                    return new hr1(1001);
                }
                ny1 m = V.m();
                if (m == null) {
                    return new hr1(1001);
                }
                m54 N1 = m.N1();
                if (N1 == null) {
                    if (m instanceof uy1) {
                        ((uy1) m).i3(y);
                        return hr1.f();
                    }
                    return new hr1(1001);
                }
                N1.e(y);
                N1.z();
                return hr1.f();
            }
            return new hr1(202);
        }
        return (hr1) invokeL.objValue;
    }

    public final int y(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1866956286) {
                if (hashCode == -838846263 && str.equals("update")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("webDegrade")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                return c != 1 ? 12 : 20;
            }
            return 19;
        }
        return invokeL.intValue;
    }
}
