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
public final class hr1 extends dr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hr1() {
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

    @Override // com.repackage.dr1
    public js1 c(@NonNull pz1 pz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pz1Var)) == null) {
            View r = rj2.i().r(pz1Var);
            if (r == null) {
                return new js1(1001);
            }
            return e(r);
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.dr1
    public js1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new js1(1001) : (js1) invokeI.objValue;
    }

    public final js1 e(@NonNull View view2) {
        InterceptResult invokeL;
        js1 js1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            try {
                js1Var = new js1(0, b((int) (ae3.P(view2.getLeft()) + 0.5f), (int) (ae3.P(view2.getTop()) + 0.5f), (int) (ae3.P(view2.getRight()) + 0.5f), (int) (ae3.P(view2.getBottom()) + 0.5f)));
            } catch (JSONException e) {
                if (dr1.a) {
                    e.printStackTrace();
                }
                js1Var = new js1(1001, "result JSONException");
            }
            jx1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param normally, result = " + js1Var);
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }
}
