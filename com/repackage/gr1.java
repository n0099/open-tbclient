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
/* loaded from: classes6.dex */
public final class gr1 extends cr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gr1() {
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

    @Override // com.repackage.cr1
    public is1 c(@NonNull oz1 oz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oz1Var)) == null) {
            View q = qj2.i().q(oz1Var);
            if (q == null) {
                return new is1(1001);
            }
            return e(q);
        }
        return (is1) invokeL.objValue;
    }

    @Override // com.repackage.cr1
    public is1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new is1(1001) : (is1) invokeI.objValue;
    }

    public final is1 e(@NonNull View view2) {
        InterceptResult invokeL;
        is1 is1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                is1Var = new is1(0, b((int) (zd3.P(view2.getLeft()) + 0.5f), (int) (zd3.P(view2.getTop()) + 0.5f), (int) (zd3.P(view2.getRight()) + 0.5f), (int) (zd3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (cr1.a) {
                    e.printStackTrace();
                }
                is1Var = new is1(1001, "result JSONException");
            }
            ix1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + is1Var);
            return is1Var;
        }
        return (is1) invokeL.objValue;
    }
}
