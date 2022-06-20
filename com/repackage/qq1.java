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
public final class qq1 extends mq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qq1() {
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

    @Override // com.repackage.mq1
    public sr1 c(@NonNull yy1 yy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yy1Var)) == null) {
            View r = aj2.i().r(yy1Var);
            if (r == null) {
                return new sr1(1001);
            }
            return e(r);
        }
        return (sr1) invokeL.objValue;
    }

    @Override // com.repackage.mq1
    public sr1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new sr1(1001) : (sr1) invokeI.objValue;
    }

    public final sr1 e(@NonNull View view2) {
        InterceptResult invokeL;
        sr1 sr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                sr1Var = new sr1(0, b((int) (jd3.P(view2.getLeft()) + 0.5f), (int) (jd3.P(view2.getTop()) + 0.5f), (int) (jd3.P(view2.getRight()) + 0.5f), (int) (jd3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (mq1.a) {
                    e.printStackTrace();
                }
                sr1Var = new sr1(1001, "result JSONException");
            }
            sw1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + sr1Var);
            return sr1Var;
        }
        return (sr1) invokeL.objValue;
    }
}
