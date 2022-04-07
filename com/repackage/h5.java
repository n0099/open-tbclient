package com.repackage;

import com.badlogic.gdx.utils.JsonValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m7;
/* loaded from: classes6.dex */
public abstract class h5 extends c5 implements m7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h5() {
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

    @Override // com.repackage.c5, com.repackage.m7.c
    public void a(m7 m7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, m7Var, jsonValue) == null) {
            ((Integer) m7Var.l("minParticleCount", Integer.TYPE, jsonValue)).intValue();
            ((Integer) m7Var.l("maxParticleCount", Integer.TYPE, jsonValue)).intValue();
        }
    }
}
