package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public abstract class ml6 implements ol6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public Context b;
    public View c;

    public ml6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ef8.b();
    }

    @Override // com.repackage.ol6, com.repackage.wl6
    @Nullable
    @CallSuper
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            return null;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.repackage.ol6
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.repackage.ol6
    public void e(@NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeElement) == null) {
        }
    }

    @Override // com.repackage.ol6
    public void f(@NonNull FrsFragment frsFragment, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, frsFragment, view2) == null) && this.c == null) {
            this.a = frsFragment;
            this.b = view2.getContext();
            this.c = view2;
            o();
        }
    }

    @Override // com.repackage.wl6
    public void g(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
        }
    }

    @Override // com.repackage.ol6
    @NonNull
    public tl6 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.y0().f0() : (tl6) invokeV.objValue;
    }

    @Override // com.repackage.wl6
    public void j(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.repackage.wl6
    public void k(@Nullable String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
        }
    }

    @Override // com.repackage.wl6
    public void l(@NonNull LogicField logicField, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, logicField, i) == null) {
        }
    }

    @Override // com.repackage.ol6
    public int n(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, logicField)) == null) {
            return 8;
        }
        return invokeL.intValue;
    }

    public abstract void o();

    @Override // com.repackage.wl6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }
}
