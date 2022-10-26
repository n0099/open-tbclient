package com.yy.hiidostatis.defs.monitor;

import android.content.Context;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.ArdUtil;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class TrafficMonitor {
    public static final /* synthetic */ TrafficMonitor[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TrafficMonitor instance;
    public transient /* synthetic */ FieldHolder $fh;
    public int appUid;
    public long endAlr;
    public long endAls;
    public long endApr;
    public long endAps;
    public long startAlr;
    public long startAls;
    public long startApr;
    public long startAps;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1513195035, "Lcom/yy/hiidostatis/defs/monitor/TrafficMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1513195035, "Lcom/yy/hiidostatis/defs/monitor/TrafficMonitor;");
                return;
            }
        }
        TrafficMonitor trafficMonitor = new TrafficMonitor(Transition.MATCH_INSTANCE_STR, 0);
        instance = trafficMonitor;
        $VALUES = new TrafficMonitor[]{trafficMonitor};
    }

    public static TrafficMonitor[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (TrafficMonitor[]) $VALUES.clone();
        }
        return (TrafficMonitor[]) invokeV.objValue;
    }

    public void end() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.endAls = ArdUtil.getTotalTxBytes();
            this.endAlr = ArdUtil.getTotalRxBytes();
            this.endAps = ArdUtil.getUidTxBytes(this.appUid);
            this.endApr = ArdUtil.getUidRxBytes(this.appUid);
        }
    }

    public long getAlr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.endAlr;
            long j2 = this.startAlr;
            if (j - j2 < 0) {
                return 0L;
            }
            return j - j2;
        }
        return invokeV.longValue;
    }

    public long getAls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = this.endAls;
            long j2 = this.startAls;
            if (j - j2 < 0) {
                return 0L;
            }
            return j - j2;
        }
        return invokeV.longValue;
    }

    public long getApr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.endApr;
            long j2 = this.startApr;
            if (j - j2 < 0) {
                return 0L;
            }
            return j - j2;
        }
        return invokeV.longValue;
    }

    public long getAps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long j = this.endAps;
            long j2 = this.startAps;
            if (j - j2 < 0) {
                return 0L;
            }
            return j - j2;
        }
        return invokeV.longValue;
    }

    public TrafficMonitor(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static TrafficMonitor valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (TrafficMonitor) Enum.valueOf(TrafficMonitor.class, str);
        }
        return (TrafficMonitor) invokeL.objValue;
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.appUid = ArdUtil.getCurrAppUid(context);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.startAls = ArdUtil.getTotalTxBytes();
            this.startAlr = ArdUtil.getTotalRxBytes();
            this.startAps = ArdUtil.getUidTxBytes(this.appUid);
            this.startApr = ArdUtil.getUidRxBytes(this.appUid);
            this.endAls = 0L;
            this.endAlr = 0L;
            this.endAps = 0L;
            this.endApr = 0L;
        }
    }
}
