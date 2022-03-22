package com.yy.gslbsdk.control;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class TtlController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIVE_THRESHOLD = 5;
    public static final int ENABLE_EXPIRED_THRESHOLD = 7;
    public static final int MAX_QUEUE_SIZE = 15;
    public static final int[] TTL_INTERVAL;
    public static TtlController sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Boolean> mList;
    public int mTtlFailedCount;
    public int mTtlIntervalCount;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(785604337, "Lcom/yy/gslbsdk/control/TtlController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(785604337, "Lcom/yy/gslbsdk/control/TtlController;");
                return;
            }
        }
        TTL_INTERVAL = new int[]{1, 6, 10, 16, 32, 64, 80, 92, 104, 114, 120};
    }

    public TtlController() {
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
        this.mTtlIntervalCount = 0;
        this.mTtlFailedCount = 0;
        this.mList = new ArrayList();
    }

    private void calcFailedCount() {
        List<Boolean> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this.mList) {
                list = (List) ((ArrayList) this.mList).clone();
            }
            int i = 0;
            for (Boolean bool : list) {
                if (bool != null && !bool.booleanValue()) {
                    i++;
                }
            }
            this.mTtlFailedCount = Math.min(i, 15);
        }
    }

    public static synchronized TtlController getInstance() {
        InterceptResult invokeV;
        TtlController ttlController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (TtlController.class) {
                if (sInstance == null) {
                    sInstance = new TtlController();
                }
                ttlController = sInstance;
            }
            return ttlController;
        }
        return (TtlController) invokeV.objValue;
    }

    public boolean addStatus(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            synchronized (this.mList) {
                this.mList.add(Boolean.valueOf(z));
                if (this.mList.size() < 15) {
                    return false;
                }
                while (this.mList.size() > 15) {
                    this.mList.remove(0);
                }
                calcFailedCount();
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean addTtlIntervalCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.mTtlIntervalCount + 1;
            this.mTtlIntervalCount = i;
            if (i < getTtlIntervalValue()) {
                return false;
            }
            resetTtlIntervalCount();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean enableExpired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getFailedCount() > 7 : invokeV.booleanValue;
    }

    public int getFailedCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTtlFailedCount : invokeV.intValue;
    }

    public int getTtlIntervalCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTtlIntervalCount : invokeV.intValue;
    }

    public int getTtlIntervalLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int failedCount = getFailedCount();
            if (failedCount <= 5) {
                return 0;
            }
            return failedCount - 5;
        }
        return invokeV.intValue;
    }

    public int getTtlIntervalValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? TTL_INTERVAL[getTtlIntervalLevel()] : invokeV.intValue;
    }

    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getFailedCount() > 5 : invokeV.booleanValue;
    }

    public void resetTtlIntervalCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mTtlIntervalCount = 0;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this.mList) {
                list = (List) ((ArrayList) this.mList).clone();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("( ");
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(i);
                stringBuffer.append("-");
                stringBuffer.append(((Boolean) list.get(i)).booleanValue() ? "t" : "f");
                stringBuffer.append(" ");
            }
            stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
            return String.format(Locale.US, "[TtlController failed: %d, level: %d, value: %d, count: %d, isActive: %b, enableExpired: %b, queue: %s]", Integer.valueOf(getFailedCount()), Integer.valueOf(getTtlIntervalLevel()), Integer.valueOf(getTtlIntervalValue()), Integer.valueOf(getTtlIntervalCount()), Boolean.valueOf(isActive()), Boolean.valueOf(enableExpired()), stringBuffer.toString());
        }
        return (String) invokeV.objValue;
    }
}
