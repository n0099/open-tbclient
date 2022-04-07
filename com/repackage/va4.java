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
public class va4 extends o94<bb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va4(d84 d84Var, ob4 ob4Var) {
        super(d84Var, ob4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d84Var, ob4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d84) objArr2[0], (ob4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.o94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o94
    /* renamed from: v */
    public c94 e(String str, bb4 bb4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, bb4Var)) == null) {
            if (bb4Var != null && (i = bb4Var.a) != 0) {
                return new c94(i, bb4Var.b);
            }
            return super.e(str, bb4Var);
        }
        return (c94) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.repackage.o94
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(bb4 bb4Var) {
        InterceptResult invokeL;
        List<j94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bb4Var)) == null) {
            if (bb4Var == null || (list = bb4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (j94 j94Var : bb4Var.c) {
                if (j94Var == null || !j94Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            ob4 ob4Var = this.b;
            return !(ob4Var instanceof hb4) || ((hb4) ob4Var).f().size() == bb4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o94
    /* renamed from: x */
    public c94 t(bb4 bb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bb4Var)) == null) {
            this.a.F();
            qd4 qd4Var = new qd4();
            n(bb4Var.c, qd4Var);
            if (qd4Var.n() == 0) {
                this.a.G();
                return null;
            }
            this.a.H(qd4Var);
            t94.f(bb4Var.c, this.a);
            return null;
        }
        return (c94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o94
    /* renamed from: y */
    public bb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? pd4.e(jSONObject) : (bb4) invokeL.objValue;
    }
}
