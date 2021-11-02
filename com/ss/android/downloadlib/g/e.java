package com.ss.android.downloadlib.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? com.ss.android.downloadlib.addownload.j.i().optJSONObject("ad") : (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.g.a b(DownloadModel downloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, downloadModel)) == null) ? com.ss.android.socialbase.downloader.g.a.a(a(downloadModel)) : (com.ss.android.socialbase.downloader.g.a) invokeL.objValue;
    }

    public static int c(@NonNull DownloadModel downloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, downloadModel)) == null) ? a(b(downloadModel)) : invokeL.intValue;
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("clean_fetch_apk_switch", 0L) == 1 : invokeI.booleanValue;
    }

    public static boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("clean_space_before_download_switch", 0L) == 1 : invokeI.booleanValue;
    }

    public static boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("clean_space_switch", 0) == 1 : invokeI.booleanValue;
    }

    public static boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("clean_app_cache_dir", 0) == 1 : invokeI.booleanValue;
    }

    public static JSONObject a(DownloadModel downloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadModel)) == null) {
            if (downloadModel == null) {
                return null;
            }
            if (downloadModel.isAd()) {
                return a();
            }
            return downloadModel.getDownloadSettings();
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean b(com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) ? a(aVar).a("pause_reserve_on_wifi", 0) == 1 && aVar.q() : invokeL.booleanValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            long optLong = com.ss.android.downloadlib.addownload.j.i().optLong("start_install_interval");
            if (optLong == 0) {
                return 300000L;
            }
            return optLong;
        }
        return invokeV.longValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            long optLong = com.ss.android.downloadlib.addownload.j.i().optLong("next_install_min_interval");
            if (optLong == 0) {
                return 10000L;
            }
            return optLong;
        }
        return invokeV.longValue;
    }

    public static long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("clean_fetch_apk_head_time_out", 800L) : invokeI.longValue;
    }

    public static long b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("storage_min_size", 0L) : invokeI.longValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? com.ss.android.downloadlib.addownload.j.i().optInt("is_enable_start_install_again") == 1 : invokeV.booleanValue;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.g.a a(com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            if (aVar == null) {
                return com.ss.android.socialbase.downloader.g.a.c();
            }
            if (aVar.s() != 0) {
                return com.ss.android.socialbase.downloader.g.a.a(aVar.s());
            }
            if (aVar.c()) {
                return com.ss.android.socialbase.downloader.g.a.a(a());
            }
            if (aVar.r() != null) {
                return com.ss.android.socialbase.downloader.g.a.a(aVar.r());
            }
            return com.ss.android.socialbase.downloader.g.a.c();
        }
        return (com.ss.android.socialbase.downloader.g.a) invokeL.objValue;
    }

    public static boolean b(com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, aVar)) == null) ? aVar != null && aVar.a("kllk_need_rename_apk", 0) == 1 : invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? com.ss.android.socialbase.downloader.g.a.c().a("fix_notification_anr") : invokeV.booleanValue;
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? aVar.a("external_storage_permission_path_type", 0) : invokeL.intValue;
    }

    public static double a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? com.ss.android.socialbase.downloader.g.a.a(i2).a("clean_min_install_size", 0.0d) : invokeI.doubleValue;
    }
}
