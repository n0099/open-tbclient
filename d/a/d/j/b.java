package d.a.d.j;

import com.baidu.searchbox.cloudcontrol.utils.CloudControlUrlConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? String.format(CloudControlUrlConfig.mUrl, "http://showcase.baidu.com") : (String) invokeV.objValue;
    }
}
