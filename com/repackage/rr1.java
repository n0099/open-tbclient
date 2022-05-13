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
/* loaded from: classes7.dex */
public final class rr1 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rr1() {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a02Var)) == null) ? e() : (us1) invokeL.objValue;
    }

    @Override // com.repackage.or1
    public us1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? e() : (us1) invokeI.objValue;
    }

    public us1 e() {
        InterceptResult invokeV;
        us1 us1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Application c = bk2.c();
            int i = (int) 28.4d;
            int P = (int) le3.P(le3.o(c) - c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f1));
            int i2 = P - ((int) 75.53d);
            int P2 = ((int) (le3.P(le3.t()) + 0.5f)) + ((38 - i) / 2);
            try {
                us1Var = new us1(0, b(i2, P2, P, i + P2));
            } catch (JSONException e) {
                if (or1.a) {
                    e.printStackTrace();
                }
                us1Var = new us1(1001, "result JSONException");
            }
            ux1.k("AbsMenuButtonHandle", "getMenuButtonBoundingClientRect call success, param valid, get param abnormally, result = " + us1Var);
            return us1Var;
        }
        return (us1) invokeV.objValue;
    }
}
