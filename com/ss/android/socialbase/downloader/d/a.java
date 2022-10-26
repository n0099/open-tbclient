package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
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
/* loaded from: classes8.dex */
public class a {
    public static String a(String str) {
        try {
            if (TextUtils.isDigitsOnly(str)) {
                return String.valueOf(Long.valueOf(str).longValue() % 100);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static JSONObject a(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        int i3;
        int i4;
        int i5;
        String md5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String str6;
        String str7;
        int i12;
        int i13;
        String str8;
        String taskId;
        String str9;
        String str10;
        String str11;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                q k = com.ss.android.socialbase.downloader.downloader.c.k();
                String str12 = "";
                int i14 = 0;
                if (k == null) {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    i2 = 0;
                } else {
                    str2 = k.b();
                    str3 = a(str2);
                    str4 = k.a();
                    i2 = k.c();
                }
                if (baseException == null || !(baseException instanceof g)) {
                    str5 = "";
                } else {
                    str5 = ((g) baseException).a();
                }
                jSONObject2.put("event_page", str);
                jSONObject2.put("app_id", str4);
                jSONObject2.put("device_id", str2);
                jSONObject2.put("device_id_postfix", str3);
                jSONObject2.put("update_version", i2);
                jSONObject2.put("download_status", i);
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
                    int i15 = 1;
                    if (downloadInfo.isOnlyWifi()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    jSONObject2.put("only_wifi", i3);
                    if (downloadInfo.isNeedHttpsToHttpRetry()) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    jSONObject2.put("need_https_degrade", i4);
                    if (downloadInfo.isHttpsToHttpRetryUsed()) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    jSONObject2.put("https_degrade_retry_used", i5);
                    if (downloadInfo.getMd5() == null) {
                        md5 = "";
                    } else {
                        md5 = downloadInfo.getMd5();
                    }
                    jSONObject2.put(PackageTable.MD5, md5);
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    if (downloadInfo.isForce()) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    jSONObject2.put("is_force", i6);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    if (downloadInfo.isNeedRetryDelay()) {
                        i7 = 1;
                    } else {
                        i7 = 0;
                    }
                    jSONObject2.put("need_retry_delay", i7);
                    if (downloadInfo.isNeedReuseFirstConnection()) {
                        i8 = 1;
                    } else {
                        i8 = 0;
                    }
                    jSONObject2.put("need_reuse_first_connection", i8);
                    if (downloadInfo.isNeedDefaultHttpServiceBackUp()) {
                        i9 = 1;
                    } else {
                        i9 = 0;
                    }
                    jSONObject2.put("default_http_service_backup", i9);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    if (downloadInfo.isBackUpUrlUsed()) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    jSONObject2.put("backup_url_used", i10);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    if (downloadInfo.isNeedIndependentProcess()) {
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    jSONObject2.put("need_independent_process", i11);
                    if (downloadInfo.getHeadConnectionException() == null) {
                        str6 = "";
                    } else {
                        str6 = downloadInfo.getHeadConnectionException();
                    }
                    jSONObject2.put("head_connection_error_msg", str6);
                    if (downloadInfo.getExtra() == null) {
                        str7 = "";
                    } else {
                        str7 = downloadInfo.getExtra();
                    }
                    jSONObject2.put("extra", str7);
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i15 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i15);
                    if (downloadInfo.getBackUpUrls() != null) {
                        i12 = downloadInfo.getBackUpUrls().size();
                    } else {
                        i12 = 0;
                    }
                    jSONObject2.put("backup_url_count", i12);
                    if (downloadInfo.getBackUpUrls() != null) {
                        i13 = downloadInfo.getCurBackUpUrlIndex();
                    } else {
                        i13 = -1;
                    }
                    jSONObject2.put("cur_backup_url_index", i13);
                    if (downloadInfo.getForbiddenBackupUrls() == null) {
                        str8 = "";
                    } else {
                        str8 = downloadInfo.getForbiddenBackupUrls().toString();
                    }
                    jSONObject2.put("forbidden_urls", str8);
                    if (TextUtils.isEmpty(downloadInfo.getTaskId())) {
                        taskId = "";
                    } else {
                        taskId = downloadInfo.getTaskId();
                    }
                    jSONObject2.put("task_id", taskId);
                    String url = downloadInfo.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        str9 = "";
                        str10 = str9;
                        str11 = str10;
                    } else {
                        Uri parse = Uri.parse(url);
                        str10 = parse.getHost();
                        str11 = parse.getPath();
                        str9 = parse.getLastPathSegment();
                        if (!TextUtils.isEmpty(str11) && !TextUtils.isEmpty(str9)) {
                            try {
                                str11 = str11.substring(0, str11.length() - str9.length());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    jSONObject2.put("url_host", str10);
                    jSONObject2.put("url_path", str11);
                    jSONObject2.put("url_last_path_segment", str9);
                }
                if (baseException != null) {
                    i14 = baseException.getErrorCode();
                }
                jSONObject2.put("error_code", i14);
                if (baseException != null) {
                    str12 = baseException.getErrorMessage();
                }
                jSONObject2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str12);
                jSONObject2.put("request_log", str5);
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static void a(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i != -5) {
            if (i != -4) {
                if (i != -3) {
                    if (i != -2) {
                        if (i != 0) {
                            if (i != 2) {
                                if (i != 6) {
                                    str = "";
                                } else {
                                    str = "download_first_start";
                                }
                            } else {
                                str = "download_start";
                            }
                        } else {
                            str = "download_create";
                        }
                    } else {
                        str = "download_pause";
                    }
                } else {
                    double downloadSpeed = downloadInfo.getDownloadSpeed();
                    if (downloadSpeed >= 0.0d) {
                        jSONObject.put("download_speed", downloadSpeed);
                    }
                    str = "download_success";
                }
            } else {
                str = "download_cancel";
            }
        } else {
            str = "download_uncomplete";
        }
        jSONObject.put("status", str);
    }

    public static void a(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (bVar != null && downloadInfo.isNeedSDKMonitor() && !TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            try {
                JSONObject a = a(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
                if (a == null) {
                    a = new JSONObject();
                }
                if (i == -1) {
                    a.put("status", baseException.getErrorCode());
                    bVar.a("download_failed", a, null, null);
                    return;
                }
                a(i, a, downloadInfo);
                bVar.a("download_common", a, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(x xVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (xVar == null) {
            return;
        }
        try {
            String b = xVar.b();
            if (TextUtils.isEmpty(b)) {
                b = "default";
            }
            JSONObject a = a(b, downloadInfo, baseException, i);
            if (a == null) {
                a = new JSONObject();
            }
            xVar.a(a);
        } catch (Throwable unused) {
        }
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        a("download_io", aVar.b("monitor_download_io"), aVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j, long j2) {
        a("segment_io", aVar.b("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    public static void a(DownloadInfo downloadInfo, List list) {
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

    public static void a(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            x monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!isMonitorStatus && !(isMonitorStatus = a(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.c)) {
                isMonitorStatus = a(((com.ss.android.socialbase.downloader.depend.c) monitorDepend).a(), i);
            }
            if (isMonitorStatus) {
                n depend = downloadTask.getDepend();
                if (depend != null) {
                    depend.a(downloadInfo, baseException, i);
                }
                a(monitorDepend, downloadInfo, baseException, i);
                a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, baseException, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(4:68|69|70|(16:72|73|14|(2:49|(1:(2:57|(1:59)(2:60|61)))(1:54))|17|18|(2:22|23)|26|27|28|(1:30)|31|32|(1:44)|35|(2:39|41)(1:38)))|13|14|(0)|49|(1:51)|(0)|17|18|(3:20|22|23)|26|27|28|(0)|31|32|(0)|42|44|35|(0)|39|41) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0114, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0115, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[Catch: all -> 0x013a, TRY_LEAVE, TryCatch #3 {all -> 0x013a, blocks: (B:18:0x002f, B:20:0x0033, B:44:0x007f, B:46:0x0095, B:49:0x00a8, B:50:0x00ad, B:52:0x00e9, B:53:0x00fa, B:66:0x012e, B:60:0x0120, B:62:0x0126, B:56:0x0115, B:26:0x0047, B:28:0x004d, B:33:0x0058, B:36:0x0065, B:40:0x006b, B:42:0x0077, B:13:0x0025), top: B:76:0x0025, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9 A[Catch: JSONException -> 0x0114, all -> 0x013a, TryCatch #0 {JSONException -> 0x0114, blocks: (B:50:0x00ad, B:52:0x00e9, B:53:0x00fa), top: B:72:0x00ad, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.ss.android.socialbase.downloader.network.g gVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.g.a a;
        int a2;
        String e;
        String errorMessage;
        int httpStatusCode;
        String path;
        String lastPathSegment;
        JSONObject jSONObject;
        b g;
        if (downloadInfo == null || (a2 = (a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId())).a("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = -1;
        if (gVar != null) {
            try {
                i2 = gVar.b();
                if (gVar instanceof com.ss.android.socialbase.downloader.network.a) {
                    e = ((com.ss.android.socialbase.downloader.network.a) gVar).e();
                    String str4 = "";
                    if (i2 >= 200 || i2 >= 400) {
                        if (downloadInfo.getCurRetryTime() == 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                            return;
                        }
                        if (iOException != null) {
                            if (!f.c(com.ss.android.socialbase.downloader.downloader.c.N())) {
                                i2 = 1049;
                            } else {
                                try {
                                    f.a((Throwable) iOException, "");
                                } catch (BaseException e2) {
                                    i2 = e2.getErrorCode();
                                    errorMessage = e2.getErrorMessage();
                                    if (e2 instanceof g) {
                                        str4 = ((g) e2).a();
                                    }
                                }
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
                    jSONObject.put("setting_tag", a.c("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.putOpt("host_ip", str2);
                    jSONObject.putOpt("host_real_ip", e);
                    jSONObject.put("url_path", path);
                    jSONObject.put("url_last_path_segment", lastPathSegment);
                    jSONObject.put("net_lib", i);
                    jSONObject.put("connect_type", str3);
                    jSONObject.put("status_code", i2);
                    jSONObject.put("request_log", str4);
                    if (errorMessage != null) {
                        jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, f.a(errorMessage, a.a("exception_msg_length", 500)));
                    }
                    jSONObject.put("connect_time", j);
                    jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
                    jSONObject.put("name", downloadInfo.getTitle());
                    if ((a2 != 1 || a2 == 3) && (g = com.ss.android.socialbase.downloader.downloader.c.g()) != null) {
                        g.a("download_connect", jSONObject, null, null);
                    }
                    if (a2 != 2 || a2 == 3) {
                        com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), "download_connect", jSONObject);
                    }
                    return;
                }
            }
        }
        e = null;
        String str42 = "";
        if (i2 >= 200) {
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
        jSONObject.put("setting_tag", a.c("setting_tag"));
        jSONObject.put("url_host", host2);
        jSONObject.putOpt("host_ip", str2);
        jSONObject.putOpt("host_real_ip", e);
        jSONObject.put("url_path", path);
        jSONObject.put("url_last_path_segment", lastPathSegment);
        jSONObject.put("net_lib", i);
        jSONObject.put("connect_type", str3);
        jSONObject.put("status_code", i2);
        jSONObject.put("request_log", str42);
        if (errorMessage != null) {
        }
        jSONObject.put("connect_time", j);
        jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
        jSONObject.put("name", downloadInfo.getTitle());
        if (a2 != 1) {
        }
        g.a("download_connect", jSONObject, null, null);
        if (a2 != 2) {
        }
        com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), "download_connect", jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0108 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012b A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0174 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x0070, B:32:0x0077, B:34:0x0083, B:35:0x008d, B:39:0x009a, B:41:0x009e, B:42:0x00a4, B:44:0x00a8, B:47:0x00bb, B:49:0x0108, B:50:0x0119, B:52:0x012b, B:54:0x0134, B:55:0x014f, B:67:0x0182, B:60:0x016e, B:62:0x0174, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:74:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0180 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, int i, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str2, String str3, String str4, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        int i2;
        String errorMessage;
        long j6;
        String str5;
        int i3;
        int i4;
        double nanos;
        b g;
        String str6;
        int i5;
        if (i > 0 && j2 > 0) {
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
                    i2 = 1;
                } else if (z2) {
                    i2 = 2;
                } else if (baseException != null) {
                    if (!f.c(com.ss.android.socialbase.downloader.downloader.c.N())) {
                        i2 = 1049;
                    } else {
                        i2 = baseException.getErrorCode();
                    }
                    errorMessage = baseException.getErrorMessage();
                    JSONObject jSONObject2 = new JSONObject();
                    String str7 = "";
                    int i6 = -1;
                    if (iVar == null) {
                        if (iVar instanceof e) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        String a = iVar.a("X-Cache");
                        if (!TextUtils.isEmpty(a)) {
                            i6 = a.toLowerCase().contains("hit");
                        }
                        if (aVar.a("monitor_sla", 1) == 1 && !z && !z2 && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
                            ((com.ss.android.socialbase.downloader.network.a) iVar).a(jSONObject2, true);
                        }
                        if (iVar instanceof com.ss.android.socialbase.downloader.network.a) {
                            str7 = ((com.ss.android.socialbase.downloader.network.a) iVar).f();
                        }
                        j6 = j;
                        str5 = str7;
                        i4 = i6;
                    } else {
                        j6 = j;
                        str5 = "";
                        i3 = -1;
                        i4 = -1;
                    }
                    double d = j6 / 1048576.0d;
                    double d2 = j2;
                    nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
                    jSONObject2.put("setting_tag", aVar.c("setting_tag"));
                    jSONObject2.put("url_host", host);
                    jSONObject2.putOpt("host_ip", str3);
                    jSONObject2.putOpt("host_real_ip", str4);
                    jSONObject2.put("url_path", path);
                    jSONObject2.put("url_last_path_segment", lastPathSegment);
                    jSONObject2.put("net_lib", i3);
                    jSONObject2.put("hit_cdn_cache", i4);
                    jSONObject2.put("status_code", i2);
                    jSONObject2.put("request_log", str5);
                    if (errorMessage != null) {
                        jSONObject2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, f.a(errorMessage, aVar.a("exception_msg_length", 500)));
                    }
                    jSONObject2.put("download_sec", nanos);
                    jSONObject2.put("download_mb", d);
                    if (nanos > 0.0d) {
                        jSONObject2.put("download_speed", d / nanos);
                    }
                    if (z3) {
                        jSONObject2.put("rw_read_time", j3 / d2);
                        jSONObject2.put("rw_write_time", j4 / d2);
                        jSONObject2.put("rw_sync_time", j5 / d2);
                    }
                    jSONObject2.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
                    jSONObject2.put("name", downloadInfo.getTitle());
                    if (i != 1 && i != 3) {
                        i5 = 2;
                        str6 = str;
                        if (i != i5 || i == 3) {
                            com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject2);
                        }
                        return;
                    }
                    g = com.ss.android.socialbase.downloader.downloader.c.g();
                    if (g == null) {
                        str6 = str;
                        g.a(str6, jSONObject2, null, null);
                    } else {
                        str6 = str;
                    }
                    i5 = 2;
                    if (i != i5) {
                    }
                    com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject2);
                } else {
                    i2 = 0;
                }
                errorMessage = null;
                JSONObject jSONObject22 = new JSONObject();
                String str72 = "";
                int i62 = -1;
                if (iVar == null) {
                }
                double d3 = j6 / 1048576.0d;
                double d22 = j2;
                nanos = d22 / TimeUnit.SECONDS.toNanos(1L);
                jSONObject22.put("setting_tag", aVar.c("setting_tag"));
                jSONObject22.put("url_host", host);
                jSONObject22.putOpt("host_ip", str3);
                jSONObject22.putOpt("host_real_ip", str4);
                jSONObject22.put("url_path", path);
                jSONObject22.put("url_last_path_segment", lastPathSegment);
                jSONObject22.put("net_lib", i3);
                jSONObject22.put("hit_cdn_cache", i4);
                jSONObject22.put("status_code", i2);
                jSONObject22.put("request_log", str5);
                if (errorMessage != null) {
                }
                jSONObject22.put("download_sec", nanos);
                jSONObject22.put("download_mb", d3);
                if (nanos > 0.0d) {
                }
                if (z3) {
                }
                jSONObject22.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.getPackageName());
                jSONObject22.put("name", downloadInfo.getTitle());
                if (i != 1) {
                    i5 = 2;
                    str6 = str;
                    if (i != i5) {
                    }
                    com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject22);
                }
                g = com.ss.android.socialbase.downloader.downloader.c.g();
                if (g == null) {
                }
                i5 = 2;
                if (i != i5) {
                }
                com.ss.android.socialbase.downloader.downloader.c.P().a(downloadInfo.getId(), str6, jSONObject22);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean a(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }
}
