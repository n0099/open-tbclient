package com.ss.android.downloadlib.addownload;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.download.api.model.DownloadShortInfo;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) ? (i3 <= 0 || i3 >= 100 || !a(i2)) ? i3 : (int) (Math.sqrt(i3) * 10.0d) : invokeII.intValue;
    }

    public static long a(int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (a(i2)) {
                if (j2 <= 0) {
                    return 0L;
                }
                return j3 <= 0 ? j2 : (j3 * a(i2, (int) ((j2 * 100) / j3))) / 100;
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public static DownloadShortInfo a(DownloadShortInfo downloadShortInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, downloadShortInfo)) == null) {
            if (downloadShortInfo != null && a((int) downloadShortInfo.id)) {
                downloadShortInfo.currentBytes = a((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
            }
            return downloadShortInfo;
        }
        return (DownloadShortInfo) invokeL.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.g.a.a(i2).a("pause_optimise_switch", 0) == 1 : invokeI.booleanValue;
    }
}
