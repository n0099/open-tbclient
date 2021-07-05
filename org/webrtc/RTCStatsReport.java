package org.webrtc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes10.dex */
public class RTCStatsReport {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, RTCStats> stats;
    public final long timestampUs;

    public RTCStatsReport(long j, Map<String, RTCStats> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.timestampUs = j;
        this.stats = map;
    }

    @CalledByNative
    public static RTCStatsReport create(long j, Map map) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, map)) == null) ? new RTCStatsReport(j, map) : (RTCStatsReport) invokeJL.objValue;
    }

    public Map<String, RTCStats> getStatsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.stats : (Map) invokeV.objValue;
    }

    public double getTimestampUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.timestampUs : invokeV.doubleValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{ timestampUs: ");
            sb.append(this.timestampUs);
            sb.append(", stats: [\n");
            boolean z = true;
            for (RTCStats rTCStats : this.stats.values()) {
                if (!z) {
                    sb.append(",\n");
                }
                sb.append(rTCStats);
                z = false;
            }
            sb.append(" ] }");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
