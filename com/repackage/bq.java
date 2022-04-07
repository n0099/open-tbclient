package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bq() {
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

    public final boolean a(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aqVar)) == null) ? aqVar.i == 1 : invokeL.booleanValue;
    }

    public void b(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aqVar) == null) {
            aqVar.a = 2;
            up.a(aqVar, "image");
        }
    }

    public void c(@NonNull aq aqVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aqVar, i) == null) {
            aqVar.a = 7;
            up.b(aqVar, i);
        }
    }

    public void d(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aqVar) == null) {
            aqVar.a = 5;
            up.d(aqVar);
        }
    }

    public void e(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aqVar) == null) {
            aqVar.a = 2;
            up.a(aqVar, NativeConstants.ID_BUTTON);
        }
    }

    public void f(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aqVar) == null) && a(aqVar)) {
            aqVar.a = 34;
            up.c(aqVar);
        }
    }

    public void g(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, aqVar) == null) && a(aqVar)) {
            aqVar.a = 32;
            up.c(aqVar);
        }
    }

    public void h(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, aqVar) == null) && a(aqVar)) {
            aqVar.a = 33;
            up.c(aqVar);
        }
    }

    public void i(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aqVar) == null) {
            aqVar.a = 3;
            up.e(aqVar);
            if (a(aqVar)) {
                aqVar.a = 31;
                up.f(aqVar);
            }
        }
    }

    public void j(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aqVar) == null) {
            aqVar.a = 2;
            up.a(aqVar, "title");
        }
    }

    public void k(@NonNull aq aqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aqVar) == null) {
        }
    }

    public void l(@NonNull aq aqVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, aqVar, i) == null) {
            up.g(aqVar, i);
        }
    }
}
