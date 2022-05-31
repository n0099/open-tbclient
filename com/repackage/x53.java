package com.repackage;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.y53;
/* loaded from: classes7.dex */
public class x53 extends hv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x53() {
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

    @Override // com.repackage.hv2
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            y53.a aVar = y53.a().a;
            if (!ProcessUtils.isMainProcess() || aVar == null) {
                return;
            }
            aVar.a(bundle.getString("statTag"), bundle.getString("statisticData"));
        }
    }
}
