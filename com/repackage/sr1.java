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
public final class sr1 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sr1() {
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

    @Override // com.repackage.or1
    public us1 c(@NonNull a02 a02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a02Var)) == null) {
            View r = ck2.i().r(a02Var);
            if (r == null) {
                return new us1(1001);
            }
            return e(r);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.or1
    public us1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new us1(1001) : (us1) invokeI.objValue;
    }

    public final us1 e(@NonNull View view2) {
        InterceptResult invokeL;
        us1 us1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                us1Var = new us1(0, b((int) (le3.P(view2.getLeft()) + 0.5f), (int) (le3.P(view2.getTop()) + 0.5f), (int) (le3.P(view2.getRight()) + 0.5f), (int) (le3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (or1.a) {
                    e.printStackTrace();
                }
                us1Var = new us1(1001, "result JSONException");
            }
            ux1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + us1Var);
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }
}
