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
/* loaded from: classes5.dex */
public final class fq1 extends bq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fq1() {
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

    @Override // com.repackage.bq1
    public hr1 c(@NonNull ny1 ny1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ny1Var)) == null) {
            View r = pi2.i().r(ny1Var);
            if (r == null) {
                return new hr1(1001);
            }
            return e(r);
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.bq1
    public hr1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new hr1(1001) : (hr1) invokeI.objValue;
    }

    public final hr1 e(@NonNull View view2) {
        InterceptResult invokeL;
        hr1 hr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                hr1Var = new hr1(0, b((int) (yc3.P(view2.getLeft()) + 0.5f), (int) (yc3.P(view2.getTop()) + 0.5f), (int) (yc3.P(view2.getRight()) + 0.5f), (int) (yc3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (bq1.a) {
                    e.printStackTrace();
                }
                hr1Var = new hr1(1001, "result JSONException");
            }
            hw1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + hr1Var);
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }
}
