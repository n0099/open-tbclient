package com.repackage;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i85 a;
    public String b;

    public g85(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = str;
    }

    public final void a(String str, int i) {
        int intValue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) || ki.isEmpty(str) || i <= 0 || TbSingleton.getInstance().isAnimFpsComputed(str) || (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) >= 5) {
            return;
        }
        int i2 = intValue + 1;
        int intValue2 = TbSingleton.getInstance().getAnimAvgFps(str).intValue();
        if (intValue2 > 0) {
            i = (i + (intValue2 * (i2 - 1))) / i2;
        }
        TbSingleton.getInstance().setAnimAvgFps(str, i);
        TbSingleton.getInstance().setAnimAvgFpsCount(str, i2);
        if (i2 >= 5) {
            TbSingleton.getInstance().setAnimComputedFps(str, i);
            h85.a();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (this.a == null) {
            this.a = new i85();
        }
        this.a.c();
    }

    public void c() {
        i85 i85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i85Var = this.a) == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        i85Var.d();
        a(this.b, this.a.b());
    }
}
