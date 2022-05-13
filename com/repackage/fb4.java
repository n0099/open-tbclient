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
/* loaded from: classes6.dex */
public class fb4 extends y94<lb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb4(n84 n84Var, yb4 yb4Var) {
        super(n84Var, yb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n84Var, yb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((n84) objArr2[0], (yb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.y94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: v */
    public m94 e(String str, lb4 lb4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, lb4Var)) == null) {
            if (lb4Var != null && (i = lb4Var.a) != 0) {
                return new m94(i, lb4Var.b);
            }
            return super.e(str, lb4Var);
        }
        return (m94) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.repackage.y94
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(lb4 lb4Var) {
        InterceptResult invokeL;
        List<t94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, lb4Var)) == null) {
            if (lb4Var == null || (list = lb4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (t94 t94Var : lb4Var.c) {
                if (t94Var == null || !t94Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            yb4 yb4Var = this.b;
            return !(yb4Var instanceof rb4) || ((rb4) yb4Var).f().size() == lb4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: x */
    public m94 t(lb4 lb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lb4Var)) == null) {
            this.a.F();
            ae4 ae4Var = new ae4();
            n(lb4Var.c, ae4Var);
            if (ae4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(ae4Var);
            da4.f(lb4Var.c, this.a);
            return null;
        }
        return (m94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: y */
    public lb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? zd4.e(jSONObject) : (lb4) invokeL.objValue;
    }
}
