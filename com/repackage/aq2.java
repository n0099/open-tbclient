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
public class aq2 extends nq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq2(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "UpdateMenuStyleApi" : (String) invokeV.objValue;
    }

    public hs1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#changeMenuStyle", false);
            Pair<hs1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((hs1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202);
                }
                int y = y(optString);
                ul2 U = ul2.U();
                if (U == null) {
                    return new hs1(1001);
                }
                qz1 V = U.V();
                if (V == null) {
                    return new hs1(1001);
                }
                nz1 m = V.m();
                if (m == null) {
                    return new hs1(1001);
                }
                m64 O1 = m.O1();
                if (O1 == null) {
                    if (m instanceof uz1) {
                        ((uz1) m).j3(y);
                        return hs1.f();
                    }
                    return new hs1(1001);
                }
                O1.e(y);
                O1.y();
                return hs1.f();
            }
            return new hs1(202);
        }
        return (hs1) invokeL.objValue;
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
