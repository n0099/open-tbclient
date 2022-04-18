package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ua4 extends n94<ab4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua4(c84 c84Var, nb4 nb4Var) {
        super(c84Var, nb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c84Var, nb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c84) objArr2[0], (nb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.n94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: v */
    public b94 e(String str, ab4 ab4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ab4Var)) == null) {
            if (ab4Var != null && (i = ab4Var.a) != 0) {
                return new b94(i, ab4Var.b);
            }
            return super.e(str, ab4Var);
        }
        return (b94) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.repackage.n94
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(ab4 ab4Var) {
        InterceptResult invokeL;
        List<i94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ab4Var)) == null) {
            if (ab4Var == null || (list = ab4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (i94 i94Var : ab4Var.c) {
                if (i94Var == null || !i94Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            nb4 nb4Var = this.b;
            return !(nb4Var instanceof gb4) || ((gb4) nb4Var).f().size() == ab4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: x */
    public b94 t(ab4 ab4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ab4Var)) == null) {
            this.a.F();
            pd4 pd4Var = new pd4();
            n(ab4Var.c, pd4Var);
            if (pd4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(pd4Var);
            s94.f(ab4Var.c, this.a);
            return null;
        }
        return (b94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n94
    /* renamed from: y */
    public ab4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? od4.e(jSONObject) : (ab4) invokeL.objValue;
    }
}
