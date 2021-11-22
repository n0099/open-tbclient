package com.ss.android.downloadlib.g;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadInfo downloadInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, downloadInfo, jSONObject) == null) {
            try {
                c(downloadInfo, jSONObject);
                com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                if (a2 == null) {
                    return;
                }
                jSONObject.put("is_update_download", a2.V() ? 1 : 2);
                a(a2, jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void b(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, downloadInfo, jSONObject) == null) || jSONObject == null || (a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        try {
            c(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - a2.T()));
            jSONObject.putOpt("click_download_size", Long.valueOf(a2.U()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            a2.A();
            com.ss.android.downloadlib.addownload.b.i.a().a(a2);
            jSONObject.put("click_pause_times", a2.z());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long H = a2.H();
            if (H > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - H);
            }
            long B = a2.B();
            if (B > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - B);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(a2.E()));
            jSONObject.putOpt("fail_msg", a2.F());
            jSONObject.put("download_failed_times", a2.x());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, downloadInfo, jSONObject) == null) {
            if (downloadInfo != null) {
                try {
                    jSONObject.putOpt(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                    jSONObject.putOpt("app_name", downloadInfo.getTitle());
                    jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                    jSONObject.putOpt("file_name", downloadInfo.getName());
                    jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                    com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getId());
                    if (a2 != null) {
                        jSONObject.putOpt("click_download_time", Long.valueOf(a2.T()));
                        jSONObject.putOpt("click_download_size", Long.valueOf(a2.U()));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            int i2 = 1;
            jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2));
            jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.i.f.c(com.ss.android.downloadlib.addownload.j.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.downloader.i.f.b(com.ss.android.downloadlib.addownload.j.getContext())) {
                i2 = 2;
            }
            jSONObject.putOpt("network_is_wifi", Integer.valueOf(i2));
        }
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, bVar, jSONObject) == null) || jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", bVar.X() ? 1 : 0);
            jSONObject.put("origin_mime_type", bVar.W());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, jSONObject, i2) == null) || jSONObject == null) {
            return;
        }
        JSONArray e2 = com.ss.android.socialbase.downloader.g.a.a(i2).e("ah_report_config");
        if (e2 != null) {
            for (int i3 = 0; i3 < e2.length(); i3++) {
                try {
                    String string = e2.getString(i3);
                    g.a a2 = com.ss.android.socialbase.appdownloader.f.a.a(string);
                    if (a2 != null) {
                        String replaceAll = string.replaceAll(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "_");
                        jSONObject.put(replaceAll, a2.f() + "_" + a2.g());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.c.N()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jSONObject, aVar)) == null) {
            l.a(jSONObject, "open_url", l.a(aVar.f(), "open_url_not_exist"));
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, aVar)) == null) {
            l.a(jSONObject, com.ss.android.socialbase.appdownloader.f.d.i().replaceAll(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "_"), Integer.valueOf(l.b(com.ss.android.downloadlib.addownload.j.getContext(), com.ss.android.socialbase.appdownloader.f.d.i())));
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
