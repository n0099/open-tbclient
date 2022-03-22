package com.yy.gslbsdk.statistic;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.thread.ThreadInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class StatisticMgr {
    public static /* synthetic */ Interceptable $ic;
    public static StatisticMgr sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledThreadPoolExecutor mExecutor;
    public Map<String, StatisticInfo> mMapStatistic;
    public IGslbStatistic mStatistic;

    /* loaded from: classes7.dex */
    public interface IGslbStatistic {
        void onStatistic(Map<String, String> map);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-176784344, "Lcom/yy/gslbsdk/statistic/StatisticMgr;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-176784344, "Lcom/yy/gslbsdk/statistic/StatisticMgr;");
        }
    }

    public StatisticMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStatistic = null;
        this.mExecutor = new ScheduledThreadPoolExecutor(1);
        this.mMapStatistic = new ConcurrentHashMap();
    }

    public static StatisticMgr getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new StatisticMgr();
            }
            return sInstance;
        }
        return (StatisticMgr) invokeV.objValue;
    }

    public void addTask(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadInfo) == null) {
            this.mExecutor.execute(threadInfo);
        }
    }

    public Map<String, StatisticInfo> getMapStatistic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mMapStatistic == null) {
                this.mMapStatistic = new ConcurrentHashMap();
            }
            return this.mMapStatistic;
        }
        return (Map) invokeV.objValue;
    }

    public IGslbStatistic getStatistic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mStatistic : (IGslbStatistic) invokeV.objValue;
    }

    public StatisticInfo getStatisticInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new StatisticInfo();
            }
            StatisticInfo statisticInfo = getMapStatistic().get(str);
            return statisticInfo == null ? new StatisticInfo() : statisticInfo;
        }
        return (StatisticInfo) invokeL.objValue;
    }

    public void onStatistic(Map<String, String> map) {
        IGslbStatistic iGslbStatistic;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, map) == null) || (iGslbStatistic = this.mStatistic) == null) {
            return;
        }
        iGslbStatistic.onStatistic(map);
    }

    public void removeStatisticInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            getMapStatistic().remove(str);
        }
    }

    public void setStatistic(IGslbStatistic iGslbStatistic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iGslbStatistic) == null) {
            this.mStatistic = iGslbStatistic;
        }
    }

    public boolean setStatisticInfo(String str, StatisticInfo statisticInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, statisticInfo)) == null) {
            if (TextUtils.isEmpty(str) || getMapStatistic().containsKey(str)) {
                return false;
            }
            getMapStatistic().put(str, statisticInfo);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void addTask(ThreadInfo threadInfo, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo, j) == null) {
            this.mExecutor.schedule(threadInfo, j, TimeUnit.MILLISECONDS);
        }
    }
}
