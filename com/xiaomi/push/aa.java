package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a() {
        InterceptResult invokeV;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (!b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
                try {
                    StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                    return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
                } catch (Throwable unused) {
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m177a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return Environment.getExternalStorageState().equals("removed");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return true ^ Environment.getExternalStorageState().equals("mounted");
            } catch (Exception e) {
                Log.e("XMPush-", "check SDCard is busy: " + e);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a() <= ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (b() || c() || m177a()) ? false : true : invokeV.booleanValue;
    }
}
