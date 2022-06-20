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
/* loaded from: classes5.dex */
public class da4 extends w84<ja4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da4(l74 l74Var, wa4 wa4Var) {
        super(l74Var, wa4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l74Var, wa4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((l74) objArr2[0], (wa4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.w84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: v */
    public k84 e(String str, ja4 ja4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ja4Var)) == null) {
            if (ja4Var != null && (i = ja4Var.a) != 0) {
                return new k84(i, ja4Var.b);
            }
            return super.e(str, ja4Var);
        }
        return (k84) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.repackage.w84
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(ja4 ja4Var) {
        InterceptResult invokeL;
        List<r84> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ja4Var)) == null) {
            if (ja4Var == null || (list = ja4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (r84 r84Var : ja4Var.c) {
                if (r84Var == null || !r84Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            wa4 wa4Var = this.b;
            return !(wa4Var instanceof pa4) || ((pa4) wa4Var).f().size() == ja4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: x */
    public k84 t(ja4 ja4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ja4Var)) == null) {
            this.a.E();
            yc4 yc4Var = new yc4();
            n(ja4Var.c, yc4Var);
            if (yc4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(yc4Var);
            b94.f(ja4Var.c, this.a);
            return null;
        }
        return (k84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w84
    /* renamed from: y */
    public ja4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? xc4.e(jSONObject) : (ja4) invokeL.objValue;
    }
}
