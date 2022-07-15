package com.repackage;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.za4;
/* loaded from: classes7.dex */
public abstract class s74<T> extends t74<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s74() {
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

    public abstract void l(PMSAppInfo pMSAppInfo);

    public abstract void o(za4.a aVar, PMSAppInfo pMSAppInfo, z84 z84Var);

    public abstract void p(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2);
}
