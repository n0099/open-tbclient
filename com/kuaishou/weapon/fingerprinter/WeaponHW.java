package com.kuaishou.weapon.fingerprinter;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.d0;
import com.kuaishou.weapon.un.l1;
import com.kuaishou.weapon.un.t0;
/* loaded from: classes7.dex */
public class WeaponHW {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WeaponHW() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void doEnvReport(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, intent) == null) {
            try {
                new d0(context).a();
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public static void doFingerPrinterReport(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, intent) == null) {
            try {
                new t0(context).a();
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }
}
