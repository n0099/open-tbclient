package com.repackage;

import android.app.Application;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class eq1 extends bq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eq1() {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ny1Var)) == null) ? e() : (hr1) invokeL.objValue;
    }

    @Override // com.repackage.bq1
    public hr1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? e() : (hr1) invokeI.objValue;
    }

    public hr1 e() {
        InterceptResult invokeV;
        hr1 hr1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = oi2.c();
            int i = (int) 28.4d;
            int P = (int) yc3.P(yc3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f1));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (yc3.P(yc3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                hr1Var = new hr1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (bq1.a) {
                    e.printStackTrace();
                }
                hr1Var = new hr1(1001, "result JSONException");
            }
            hw1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + hr1Var);
            return hr1Var;
        }
        return (hr1) invokeV.objValue;
    }
}
