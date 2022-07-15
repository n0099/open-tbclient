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
public class sa4 extends l94<ya4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sa4(a84 a84Var, lb4 lb4Var) {
        super(a84Var, lb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a84Var, lb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a84) objArr2[0], (lb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.l94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: v */
    public z84 e(String str, ya4 ya4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ya4Var)) == null) {
            if (ya4Var != null && (i = ya4Var.a) != 0) {
                return new z84(i, ya4Var.b);
            }
            return super.e(str, ya4Var);
        }
        return (z84) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.repackage.l94
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(ya4 ya4Var) {
        InterceptResult invokeL;
        List<g94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ya4Var)) == null) {
            if (ya4Var == null || (list = ya4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (g94 g94Var : ya4Var.c) {
                if (g94Var == null || !g94Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            lb4 lb4Var = this.b;
            return !(lb4Var instanceof eb4) || ((eb4) lb4Var).f().size() == ya4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: x */
    public z84 t(ya4 ya4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ya4Var)) == null) {
            this.a.E();
            nd4 nd4Var = new nd4();
            n(ya4Var.c, nd4Var);
            if (nd4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(nd4Var);
            q94.f(ya4Var.c, this.a);
            return null;
        }
        return (z84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: y */
    public ya4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? md4.e(jSONObject) : (ya4) invokeL.objValue;
    }
}
