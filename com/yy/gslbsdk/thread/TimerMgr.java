package com.yy.gslbsdk.thread;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.LogTools;
import java.util.HashMap;
import java.util.Timer;
/* loaded from: classes4.dex */
public class TimerMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TimerMgr";
    public static TimerMgr mTimerMgr;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer mTimer;
    public HashMap<String, TimerTaskInfo> workerList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1312585327, "Lcom/yy/gslbsdk/thread/TimerMgr;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1312585327, "Lcom/yy/gslbsdk/thread/TimerMgr;");
        }
    }

    public TimerMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.workerList = new HashMap<>();
        this.mTimer = new Timer("Timer-gslb");
    }

    public static TimerMgr getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mTimerMgr == null) {
                mTimerMgr = new TimerMgr();
            }
            return mTimerMgr;
        }
        return (TimerMgr) invokeV.objValue;
    }

    public int addWorker(TimerTaskInfo timerTaskInfo, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{timerTaskInfo, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (timerTaskInfo == null || j3 <= 0) {
                return 5;
            }
            if (this.workerList.containsKey(timerTaskInfo.getTaskName())) {
                return 0;
            }
            try {
                this.mTimer.schedule(timerTaskInfo.getWorker(), j2, j3);
                this.workerList.put(timerTaskInfo.getTaskName(), timerTaskInfo);
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public int stopAllWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.mTimer.cancel();
            this.workerList.clear();
            return 0;
        }
        return invokeV.intValue;
    }
}
