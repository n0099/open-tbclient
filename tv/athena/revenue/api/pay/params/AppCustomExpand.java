package tv.athena.revenue.api.pay.params;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Keep
/* loaded from: classes8.dex */
public class AppCustomExpand {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> appClientExpand;
    public Map<String, String> appServerExpand;
    public IAppServerExpand iAppServerExpand;

    public AppCustomExpand() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "AppCustomExpand{appClientExpand=" + this.appClientExpand + "appServerExpand=" + this.appServerExpand + ", iAppServerExpand='" + this.iAppServerExpand + "'}";
        }
        return (String) invokeV.objValue;
    }
}
