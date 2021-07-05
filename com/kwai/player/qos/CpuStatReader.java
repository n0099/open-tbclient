package com.kwai.player.qos;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes7.dex */
public class CpuStatReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.kwai.player.qos.CpuStatReader";
    public transient /* synthetic */ FieldHolder $fh;
    public long lastGuestNicTime;
    public long lastGuestTime;
    public long lastIdleTime;
    public long lastIowaitTime;
    public long lastIrqTime;
    public long lastNiceTime;
    public boolean lastReadSuccess;
    public long lastSoftirqTime;
    public long[] lastStats;
    public long lastStealTime;
    public long lastSystemTime;
    public long lastUpdateInterval;
    public long lastUpdateTime;
    public long lastUserTime;
    public long[] stats;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1141245251, "Lcom/kwai/player/qos/CpuStatReader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1141245251, "Lcom/kwai/player/qos/CpuStatReader;");
        }
    }

    public CpuStatReader() {
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
        this.stats = new long[10];
        this.lastStats = new long[10];
        this.lastReadSuccess = false;
        update();
    }

    private boolean parseSystemStat(String str, long[] jArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, jArr)) == null) {
            if (str == null) {
                return false;
            }
            String[] split = str.split("\\s+");
            for (int i2 = 1; i2 <= 10; i2++) {
                try {
                    jArr[i2 - 1] = Long.parseLong(split[i2]);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean readSystemStat(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, jArr)) == null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", r.f7745a);
                String readLine = randomAccessFile.readLine();
                randomAccessFile.close();
                return parseSystemStat(readLine, jArr);
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public long getLastGuestNicTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.lastGuestNicTime : invokeV.longValue;
    }

    public long getLastGuestTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.lastGuestTime : invokeV.longValue;
    }

    public long getLastIdleTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.lastIdleTime : invokeV.longValue;
    }

    public long getLastIowaitTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lastIowaitTime : invokeV.longValue;
    }

    public long getLastIrqTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lastIrqTime : invokeV.longValue;
    }

    public long getLastNiceTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.lastNiceTime : invokeV.longValue;
    }

    public boolean getLastReadSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.lastReadSuccess : invokeV.booleanValue;
    }

    public long getLastSoftirqTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.lastSoftirqTime : invokeV.longValue;
    }

    public long getLastStealTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.lastStealTime : invokeV.longValue;
    }

    public long getLastSystemTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.lastSystemTime : invokeV.longValue;
    }

    public long getLastTotalTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.lastUserTime + this.lastNiceTime + this.lastSystemTime + this.lastIdleTime + this.lastIowaitTime + this.lastIrqTime + this.lastSoftirqTime + this.lastStealTime + this.lastGuestTime + this.lastGuestNicTime : invokeV.longValue;
    }

    public long getLastUpdateInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.lastUpdateInterval : invokeV.longValue;
    }

    public long getLastUserTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.lastUserTime : invokeV.longValue;
    }

    public void update() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.lastReadSuccess = false;
            if (readSystemStat(this.stats)) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int i2 = 0;
                while (true) {
                    if (i2 >= 10) {
                        z = true;
                        break;
                    } else if (this.stats[i2] < this.lastStats[i2]) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    long[] jArr = this.lastStats;
                    if (jArr[0] != 0) {
                        long[] jArr2 = this.stats;
                        this.lastUserTime = jArr2[0] - jArr[0];
                        this.lastNiceTime = jArr2[1] - jArr[1];
                        this.lastSystemTime = jArr2[2] - jArr[2];
                        this.lastIdleTime = jArr2[3] - jArr[3];
                        this.lastIowaitTime = jArr2[4] - jArr[4];
                        this.lastIrqTime = jArr2[5] - jArr[5];
                        this.lastSoftirqTime = jArr2[6] - jArr[6];
                        this.lastStealTime = jArr2[7] - jArr[7];
                        this.lastGuestTime = jArr2[8] - jArr[8];
                        this.lastGuestNicTime = jArr2[9] - jArr[9];
                        this.lastReadSuccess = true;
                        this.lastUpdateInterval = elapsedRealtime - this.lastUpdateTime;
                    }
                    this.lastUpdateTime = SystemClock.elapsedRealtime();
                    System.arraycopy(this.stats, 0, this.lastStats, 0, 10);
                }
            }
        }
    }
}
