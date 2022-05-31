package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aq0 extends eq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aq0() {
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

    @Override // com.repackage.eq0, com.repackage.cq0, com.repackage.dq0, com.repackage.zp0
    public void k(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, er0Var) == null) {
            super.k(er0Var);
            if (PlayerEvent.ACTION_PLAYER_ATTACH.equals(er0Var.c())) {
                K(r().n1().g() ? 0 : 8);
            }
        }
    }
}
