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
/* loaded from: classes6.dex */
public final class gr1 extends dr1 {
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

    @Override // com.repackage.dr1
    public js1 c(@NonNull pz1 pz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pz1Var)) == null) ? e() : (js1) invokeL.objValue;
    }

    @Override // com.repackage.dr1
    public js1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? e() : (js1) invokeI.objValue;
    }

    public js1 e() {
        InterceptResult invokeV;
        js1 js1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = qj2.c();
            int i = (int) 28.4d;
            int P = (int) ae3.P(ae3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f1));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (ae3.P(ae3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                js1Var = new js1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (dr1.a) {
                    e.printStackTrace();
                }
                js1Var = new js1(1001, "result JSONException");
            }
            jx1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + js1Var);
            return js1Var;
        }
        return (js1) invokeV.objValue;
    }
}
