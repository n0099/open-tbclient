package com.huawei.hms.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class FailedBinderCallBack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long AGING_TIME = 10000;
    public static final String CALLER_ID = "callId";
    public static final Object LOCK_OBJECT;
    public static final String TAG = "FailedBinderCallBack";
    public static Map<Long, BinderCallBack> binderCallBackMap;
    public static FailedBinderCallBack instance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public interface BinderCallBack {
        void binderCallBack(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1302912203, "Lcom/huawei/hms/api/FailedBinderCallBack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1302912203, "Lcom/huawei/hms/api/FailedBinderCallBack;");
                return;
            }
        }
        binderCallBackMap = new ConcurrentHashMap();
        LOCK_OBJECT = new Object();
    }

    public FailedBinderCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static FailedBinderCallBack getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (LOCK_OBJECT) {
                if (instance == null) {
                    instance = new FailedBinderCallBack();
                }
            }
            return instance;
        }
        return (FailedBinderCallBack) invokeV.objValue;
    }

    private void agingCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long time = new Timestamp(System.currentTimeMillis()).getTime() - 10000;
            for (Long l : binderCallBackMap.keySet()) {
                if (time >= l.longValue()) {
                    binderCallBackMap.remove(l);
                }
            }
        }
    }

    private void putCallBackInMap(Long l, BinderCallBack binderCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, l, binderCallBack) == null) {
            if (binderCallBackMap == null) {
                HMSLog.e(TAG, "binderCallBackMap is null");
                return;
            }
            agingCheck();
            binderCallBackMap.put(l, binderCallBack);
        }
    }

    public void setCallBack(Long l, BinderCallBack binderCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, binderCallBack) == null) {
            putCallBackInMap(l, binderCallBack);
        }
    }

    public BinderCallBack getCallBack(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l)) == null) {
            Map<Long, BinderCallBack> map = binderCallBackMap;
            if (map == null) {
                HMSLog.e(TAG, "binderCallBackMap is null");
                return null;
            }
            return map.remove(l);
        }
        return (BinderCallBack) invokeL.objValue;
    }
}
