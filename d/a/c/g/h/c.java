package d.a.c.g.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IStatisticManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes7.dex */
public class c implements IStatisticManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordDownloadResult(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordException(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInstallResult(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            b.c(str, i2, i3);
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordInvokeResult(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            if (i2 == 14) {
                b.a(str, i3);
            }
            b.d(str, i2, i3);
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordPeriod(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.IStatisticManager
    public void recordResult(long j, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), str}) == null) {
        }
    }
}
