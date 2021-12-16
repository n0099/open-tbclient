package com.ss.android.socialbase.downloader.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, downloadInfo)) == null) ? downloadInfo != null && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("optimize_head_request") == 1 : invokeL.booleanValue;
    }

    public static boolean b(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, downloadInfo)) == null) ? downloadInfo != null && com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("optimize_save_path") == 1 : invokeL.booleanValue;
    }
}
