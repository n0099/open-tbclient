package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes7.dex */
public final class xr1 extends tr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xr1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.tr1
    public zs1 c(@NonNull f02 f02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f02Var)) == null) {
            View q = hk2.i().q(f02Var);
            if (q == null) {
                return new zs1(1001);
            }
            return e(q);
        }
        return (zs1) invokeL.objValue;
    }

    @Override // com.repackage.tr1
    public zs1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new zs1(1001) : (zs1) invokeI.objValue;
    }

    public final zs1 e(@NonNull View view2) {
        InterceptResult invokeL;
        zs1 zs1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                zs1Var = new zs1(0, b((int) (qe3.P(view2.getLeft()) + 0.5f), (int) (qe3.P(view2.getTop()) + 0.5f), (int) (qe3.P(view2.getRight()) + 0.5f), (int) (qe3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (tr1.a) {
                    e.printStackTrace();
                }
                zs1Var = new zs1(1001, "result JSONException");
            }
            zx1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + zs1Var);
            return zs1Var;
        }
        return (zs1) invokeL.objValue;
    }
}
