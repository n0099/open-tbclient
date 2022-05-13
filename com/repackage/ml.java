package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes6.dex */
public class ml implements IStatisticManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ml() {
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

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordDownloadResult(int i, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordException(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInstallResult(int i, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2}) == null) {
            ll.c(str, i, i2);
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInvokeResult(int i, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2}) == null) {
            if (i == 14) {
                ll.a(str, i2);
            }
            ll.d(str, i, i2);
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordPeriod(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordResult(long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), str}) == null) {
        }
    }
}
