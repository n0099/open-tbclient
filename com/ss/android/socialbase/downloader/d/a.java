package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.g;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.e;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadTask downloadTask, BaseException baseException, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65544, null, downloadTask, baseException, i2) == null) || downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            x monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i2);
            if (!isMonitorStatus && !(isMonitorStatus = a(downloadInfo.getExtraMonitorStatus(), i2)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.c)) {
                isMonitorStatus = a(((com.ss.android.socialbase.downloader.depend.c) monitorDepend).a(), i2);
            }
            if (isMonitorStatus) {
                n depend = downloadTask.getDepend();
                if (depend != null) {
                    depend.a(downloadInfo, baseException, i2);
                }
                a(monitorDepend, downloadInfo, baseException, i2);
                a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, baseException, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, iArr, i2)) == null) {
            if (iArr != null && iArr.length > 0) {
                for (int i3 : iArr) {
                    if (i2 == i3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void a(x xVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, xVar, downloadInfo, baseException, i2) == null) || xVar == null) {
            return;
        }
        try {
            String b2 = xVar.b();
            if (TextUtils.isEmpty(b2)) {
                b2 = "default";
            }
            JSONObject a2 = a(b2, downloadInfo, baseException, i2);
            if (a2 == null) {
                a2 = new JSONObject();
            }
            xVar.a(a2);
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65539, null, bVar, downloadInfo, baseException, i2) == null) || bVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject a2 = a(downloadInfo.getMonitorScene(), downloadInfo, baseException, i2);
            if (a2 == null) {
                a2 = new JSONObject();
            }
            if (i2 == -1) {
                a2.put("status", baseException.getErrorCode());
                bVar.a("download_failed", a2, null, null);
                return;
            }
            a(i2, a2, downloadInfo);
            bVar.a("download_common", a2, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(int i2, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, null, i2, jSONObject, downloadInfo) == null) {
            if (i2 == -5) {
                str = "download_uncomplete";
            } else if (i2 == -4) {
                str = "download_cancel";
            } else if (i2 != -3) {
                str = i2 != -2 ? i2 != 0 ? i2 != 2 ? i2 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
            } else {
                double downloadSpeed = downloadInfo.getDownloadSpeed();
                if (downloadSpeed >= 0.0d) {
                    jSONObject.put("download_speed", downloadSpeed);
                }
                str = "download_success";
            }
            jSONObject.put("status", str);
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject a(String str, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        InterceptResult invokeLLLI;
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLI = interceptable.invokeLLLI(65537, null, str, downloadInfo, baseException, i2)) != null) {
            return (JSONObject) invokeLLLI.objValue;
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                q k = com.ss.android.socialbase.downloader.downloader.c.k();
                if (k != null) {
                    str2 = k.b();
                    str3 = a(str2);
                    str4 = k.a();
                    i3 = k.c();
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    i3 = 0;
                }
                String a2 = (baseException == null || !(baseException instanceof g)) ? "" : ((g) baseException).a();
                jSONObject2.put("event_page", str);
                jSONObject2.put("app_id", str4);
                jSONObject2.put("device_id", str2);
                jSONObject2.put("device_id_postfix", str3);
                jSONObject2.put("update_version", i3);
                jSONObject2.put("download_status", i2);
                if (downloadInfo != null) {
                    jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).c("setting_tag"));
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("save_path", downloadInfo.getSavePath());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    int i4 = 1;
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put(PackageTable.MD5, downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i4 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i4);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    String url = downloadInfo.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        str5 = "";
                        str6 = str5;
                        str7 = str6;
                    } else {
                        Uri parse = Uri.parse(url);
                        str6 = parse.getHost();
                        str7 = parse.getPath();
                        str5 = parse.getLastPathSegment();
                        if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str5)) {
                            try {
                                str7 = str7.substring(0, str7.length() - str5.length());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    jSONObject2.put("url_host", str6);
                    jSONObject2.put("url_path", str7);
                    jSONObject2.put("url_last_path_segment", str5);
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put("request_log", a2);
                return jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:13|(4:70|71|72|(16:74|75|16|(2:51|(1:(2:59|(1:61)(2:62|63)))(1:56))|19|20|(2:24|25)|28|29|30|(1:32)|33|34|(1:46)|37|(2:41|43)(1:40)))|15|16|(0)|51|(1:53)|(0)|19|20|(3:22|24|25)|28|29|30|(0)|33|34|(0)|44|46|37|(0)|41|43) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0118, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0119, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005c A[Catch: all -> 0x013e, TRY_LEAVE, TryCatch #3 {all -> 0x013e, blocks: (B:20:0x0033, B:22:0x0037, B:46:0x0083, B:48:0x0099, B:51:0x00ac, B:52:0x00b1, B:54:0x00ed, B:55:0x00fe, B:68:0x0132, B:62:0x0124, B:64:0x012a, B:58:0x0119, B:28:0x004b, B:30:0x0051, B:35:0x005c, B:38:0x0069, B:42:0x006f, B:44:0x007b, B:15:0x0029), top: B:81:0x0029, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed A[Catch: JSONException -> 0x0118, all -> 0x013e, TryCatch #1 {JSONException -> 0x0118, blocks: (B:52:0x00b1, B:54:0x00ed, B:55:0x00fe), top: B:79:0x00b1, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(@Nullable com.ss.android.socialbase.downloader.network.g gVar, String str, String str2, long j, String str3, int i2, IOException iOException, DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.g.a a2;
        int a3;
        String e2;
        String errorMessage;
        int httpStatusCode;
        String path;
        String lastPathSegment;
        JSONObject jSONObject;
        b g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{gVar, str, str2, Long.valueOf(j), str3, Integer.valueOf(i2), iOException, downloadInfo}) == null) || downloadInfo == null || (a3 = (a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId())).a("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        int i3 = -1;
        if (gVar != null) {
            try {
                i3 = gVar.b();
                if (gVar instanceof com.ss.android.socialbase.downloader.network.a) {
                    e2 = ((com.ss.android.socialbase.downloader.network.a) gVar).e();
                    String str4 = "";
                    if (i3 >= 200 || i3 >= 400) {
                        if (downloadInfo.getCurRetryTime() == 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                            return;
                        }
                        if (iOException != null) {
                            if (f.c(com.ss.android.socialbase.downloader.downloader.c.N())) {
                                try {
                                    f.a((Throwable) iOException, "");
                                } catch (BaseException e3) {
                                    i3 = e3.getErrorCode();
                                    errorMessage = e3.getErrorMessage();
                                    if (e3 instanceof g) {
                                        str4 = ((g) e3).a();
                                    }
                                }
                            } else {
                                i3 = SDKLogTypeConstants.TYPE_LP_LOAD_URL;
                            }
                        }
                    }
                    errorMessage = null;
                    Uri parse = Uri.parse(str);
                    String host = parse.getHost();
                    path = parse.getPath();
                    lastPathSegment = parse.getLastPathSegment();
                    if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                        try {
                            path = path.substring(0, path.length() - lastPathSegment.length());
                        } catch (Throwable unused) {
                        }
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("setting_tag", a2.c("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.putOpt("host_ip", str2);
                    jSONObject.putOpt("host_real_ip", e2);
                    jSONObject.put("url_path", path);
                    jSONObject.put("url_last_path_segment", lastPathSegment);
                    jSONObject.put("net_lib", i2);
                    jSONObject.put("connect_type", str3);
                    jSONObject.put("status_code", i3);
                    jSONObject.put("request_log", str4);
                    if (errorMessage != null) {
                        jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, f.a(errorMessage, a2.a("exception_msg_length", 500)));
                    }
                    jSONObject.put("connect_time", j);
                    jSONObject.put("pkg_name", downloadInfo.getPackageName());
                    jSONObject.put("name", downloadInfo.getTitle());
                    if ((a3 != 1 || a3 == 3) && (g2 = com.ss.android.socialbase.downloader.downloader.c.g()) != null) {
                        g2.a("download_connect", jSONObject, null, null);
                    }
                    if (a3 != 2 || a3 == 3) {
                        com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), "download_connect", jSONObject);
                    }
                    return;
                }
            }
        }
        e2 = null;
        String str42 = "";
        if (i3 >= 200) {
        }
        if (downloadInfo.getCurRetryTime() == 0) {
        }
        if (iOException != null) {
        }
        errorMessage = null;
        Uri parse2 = Uri.parse(str);
        String host2 = parse2.getHost();
        path = parse2.getPath();
        lastPathSegment = parse2.getLastPathSegment();
        if (!TextUtils.isEmpty(path)) {
            path = path.substring(0, path.length() - lastPathSegment.length());
        }
        jSONObject = new JSONObject();
        jSONObject.put("setting_tag", a2.c("setting_tag"));
        jSONObject.put("url_host", host2);
        jSONObject.putOpt("host_ip", str2);
        jSONObject.putOpt("host_real_ip", e2);
        jSONObject.put("url_path", path);
        jSONObject.put("url_last_path_segment", lastPathSegment);
        jSONObject.put("net_lib", i2);
        jSONObject.put("connect_type", str3);
        jSONObject.put("status_code", i3);
        jSONObject.put("request_log", str42);
        if (errorMessage != null) {
        }
        jSONObject.put("connect_time", j);
        jSONObject.put("pkg_name", downloadInfo.getPackageName());
        jSONObject.put("name", downloadInfo.getTitle());
        if (a3 != 1) {
        }
        g2.a("download_connect", jSONObject, null, null);
        if (a3 != 2) {
        }
        com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), "download_connect", jSONObject);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{aVar, downloadInfo, str, iVar, Boolean.valueOf(z), Boolean.valueOf(z2), baseException, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), jSONObject}) == null) {
            a("download_io", aVar.b("monitor_download_io"), aVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
        }
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{aVar, downloadInfo, str, str2, str3, Boolean.valueOf(z), iVar, baseException, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a("segment_io", aVar.b("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012f A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0178 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:9:0x001a, B:11:0x0031, B:28:0x0069, B:30:0x0074, B:34:0x007b, B:36:0x0087, B:37:0x0091, B:41:0x009e, B:43:0x00a2, B:44:0x00a8, B:46:0x00ac, B:49:0x00bf, B:51:0x010c, B:52:0x011d, B:54:0x012f, B:56:0x0138, B:57:0x0153, B:69:0x0186, B:62:0x0172, B:64:0x0178, B:22:0x0051, B:26:0x0062, B:25:0x005e), top: B:77:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0184 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, int i2, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str2, String str3, String str4, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        int i3;
        String errorMessage;
        long j6;
        String str5;
        int i4;
        int i5;
        double nanos;
        b g2;
        String str6;
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Integer.valueOf(i2), aVar, downloadInfo, str2, str3, str4, iVar, Boolean.valueOf(z), Boolean.valueOf(z2), baseException, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), jSONObject}) == null) || i2 <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri parse = Uri.parse(str2);
            String host = parse.getHost();
            String path = parse.getPath();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                i3 = 1;
            } else if (z2) {
                i3 = 2;
            } else if (baseException != null) {
                i3 = !f.c(com.ss.android.socialbase.downloader.downloader.c.N()) ? SDKLogTypeConstants.TYPE_LP_LOAD_URL : baseException.getErrorCode();
                errorMessage = baseException.getErrorMessage();
                JSONObject jSONObject2 = new JSONObject();
                if (iVar == null) {
                    i4 = iVar instanceof e ? 0 : 1;
                    String a2 = iVar.a("X-Cache");
                    int contains = TextUtils.isEmpty(a2) ? -1 : a2.toLowerCase().contains("hit");
                    if (aVar.a("monitor_sla", 1) == 1 && !z && !z2 && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
                        ((com.ss.android.socialbase.downloader.network.a) iVar).a(jSONObject2, true);
                    }
                    j6 = j;
                    str5 = iVar instanceof com.ss.android.socialbase.downloader.network.a ? ((com.ss.android.socialbase.downloader.network.a) iVar).f() : "";
                    i5 = contains;
                } else {
                    j6 = j;
                    str5 = "";
                    i4 = -1;
                    i5 = -1;
                }
                double d2 = j6 / 1048576.0d;
                double d3 = j2;
                nanos = d3 / TimeUnit.SECONDS.toNanos(1L);
                jSONObject2.put("setting_tag", aVar.c("setting_tag"));
                jSONObject2.put("url_host", host);
                jSONObject2.putOpt("host_ip", str3);
                jSONObject2.putOpt("host_real_ip", str4);
                jSONObject2.put("url_path", path);
                jSONObject2.put("url_last_path_segment", lastPathSegment);
                jSONObject2.put("net_lib", i4);
                jSONObject2.put("hit_cdn_cache", i5);
                jSONObject2.put("status_code", i3);
                jSONObject2.put("request_log", str5);
                if (errorMessage != null) {
                    jSONObject2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, f.a(errorMessage, aVar.a("exception_msg_length", 500)));
                }
                jSONObject2.put("download_sec", nanos);
                jSONObject2.put("download_mb", d2);
                if (nanos > 0.0d) {
                    jSONObject2.put("download_speed", d2 / nanos);
                }
                if (z3) {
                    jSONObject2.put("rw_read_time", j3 / d3);
                    jSONObject2.put("rw_write_time", j4 / d3);
                    jSONObject2.put("rw_sync_time", j5 / d3);
                }
                jSONObject2.put("pkg_name", downloadInfo.getPackageName());
                jSONObject2.put("name", downloadInfo.getTitle());
                if (i2 != 1 && i2 != 3) {
                    i6 = 2;
                    str6 = str;
                    if (i2 != i6 || i2 == 3) {
                        com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject2);
                    }
                    return;
                }
                g2 = com.ss.android.socialbase.downloader.downloader.c.g();
                if (g2 == null) {
                    str6 = str;
                    g2.a(str6, jSONObject2, null, null);
                } else {
                    str6 = str;
                }
                i6 = 2;
                if (i2 != i6) {
                }
                com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject2);
            } else {
                i3 = 0;
            }
            errorMessage = null;
            JSONObject jSONObject22 = new JSONObject();
            if (iVar == null) {
            }
            double d22 = j6 / 1048576.0d;
            double d32 = j2;
            nanos = d32 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject22.put("setting_tag", aVar.c("setting_tag"));
            jSONObject22.put("url_host", host);
            jSONObject22.putOpt("host_ip", str3);
            jSONObject22.putOpt("host_real_ip", str4);
            jSONObject22.put("url_path", path);
            jSONObject22.put("url_last_path_segment", lastPathSegment);
            jSONObject22.put("net_lib", i4);
            jSONObject22.put("hit_cdn_cache", i5);
            jSONObject22.put("status_code", i3);
            jSONObject22.put("request_log", str5);
            if (errorMessage != null) {
            }
            jSONObject22.put("download_sec", nanos);
            jSONObject22.put("download_mb", d22);
            if (nanos > 0.0d) {
            }
            if (z3) {
            }
            jSONObject22.put("pkg_name", downloadInfo.getPackageName());
            jSONObject22.put("name", downloadInfo.getTitle());
            if (i2 != 1) {
                i6 = 2;
                str6 = str;
                if (i2 != i6) {
                }
                com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject22);
            }
            g2 = com.ss.android.socialbase.downloader.downloader.c.g();
            if (g2 == null) {
            }
            i6 = 2;
            if (i2 != i6) {
            }
            com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject22);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.f.i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, downloadInfo, list) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("segments", com.ss.android.socialbase.downloader.f.i.a(list));
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                c P = com.ss.android.socialbase.downloader.downloader.c.P();
                if (P != null) {
                    P.a(downloadInfo.getId(), "segments_error", jSONObject);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
