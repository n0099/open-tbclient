package d.o.a.e.b.e;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.kwai.video.player.KsMediaMeta;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.xiaomi.mipush.sdk.Constants;
import d.o.a.e.b.f.m;
import d.o.a.e.b.f.q;
import d.o.a.e.b.f.y;
import d.o.a.e.b.g.d;
import d.o.a.e.b.g.p;
import d.o.a.e.b.l.e;
import d.o.a.e.b.o.g;
import d.o.a.e.b.o.i;
import d.o.a.e.b.o.k;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static String a(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static JSONObject b(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                p v0 = d.v0();
                if (v0 != null) {
                    str2 = v0.b();
                    str3 = a(str2);
                    str4 = v0.a();
                    i2 = v0.c();
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    i2 = 0;
                }
                jSONObject2.put("event_page", str);
                jSONObject2.put(Constants.APP_ID, str4);
                jSONObject2.put(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, str2);
                jSONObject2.put("device_id_postfix", str3);
                jSONObject2.put(PackageTable.UPDATE_VERSION, i2);
                jSONObject2.put("download_status", i);
                jSONObject2.put("setting_tag", d.o.a.e.b.j.a.d(downloadInfo.c0()).t("setting_tag"));
                if (downloadInfo != null) {
                    jSONObject2.put("download_id", downloadInfo.c0());
                    jSONObject2.put("name", downloadInfo.q0());
                    jSONObject2.put("url", downloadInfo.T0());
                    jSONObject2.put("download_time", downloadInfo.M());
                    jSONObject2.put("cur_bytes", downloadInfo.E());
                    jSONObject2.put("total_bytes", downloadInfo.Q0());
                    jSONObject2.put("network_quality", downloadInfo.r0());
                    int i3 = 1;
                    jSONObject2.put("only_wifi", downloadInfo.K1() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.B1() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.x1() ? 1 : 0);
                    jSONObject2.put(PackageTable.MD5, downloadInfo.l0() == null ? "" : downloadInfo.l0());
                    jSONObject2.put("chunk_count", downloadInfo.B());
                    jSONObject2.put("is_force", downloadInfo.v1() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.B0());
                    jSONObject2.put("cur_retry_time", downloadInfo.F());
                    jSONObject2.put("need_retry_delay", downloadInfo.E1() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.G1() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.A1() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.C0().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.e1() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.z().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.u().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.C1() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.Z() != null ? downloadInfo.Z() : "");
                    jSONObject2.put("extra", downloadInfo.R() != null ? downloadInfo.R() : "");
                    if (!downloadInfo.b1()) {
                        i3 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i3);
                    jSONObject2.put("backup_url_count", downloadInfo.w() != null ? downloadInfo.w().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.w() != null ? downloadInfo.D() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.Y() != null ? downloadInfo.Y().toString() : "");
                    String T0 = downloadInfo.T0();
                    if (TextUtils.isEmpty(T0)) {
                        str5 = "";
                        str6 = str5;
                        str7 = str6;
                    } else {
                        Uri parse = Uri.parse(T0);
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
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
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

    public static void c(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double L = downloadInfo.L();
            if (L >= 0.0d) {
                jSONObject.put("download_speed", L);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static void d(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (bVar == null || !downloadInfo.H1() || TextUtils.isEmpty(downloadInfo.p0())) {
            return;
        }
        try {
            JSONObject b2 = b(downloadInfo.p0(), downloadInfo, baseException, i);
            if (b2 == null) {
                b2 = new JSONObject();
            }
            if (i == -1) {
                b2.put("status", baseException.getErrorCode());
                bVar.a("download_failed", b2, null, null);
                return;
            }
            c(i, b2, downloadInfo);
            bVar.a("download_common", b2, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void e(y yVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (yVar == null) {
            return;
        }
        try {
            String b2 = yVar.b();
            if (TextUtils.isEmpty(b2)) {
                b2 = "default";
            }
            JSONObject b3 = b(b2, downloadInfo, baseException, i);
            if (b3 == null) {
                b3 = new JSONObject();
            }
            yVar.a(b3);
        } catch (Throwable unused) {
        }
    }

    public static void f(d.o.a.e.b.j.a aVar, DownloadInfo downloadInfo, String str, k kVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        j("download_io", aVar.m("monitor_download_io"), aVar, downloadInfo, str, null, null, kVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void g(d.o.a.e.b.j.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, k kVar, BaseException baseException, long j, long j2) {
        j("segment_io", aVar.m("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, kVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    public static void h(d.o.a.e.b.n.a aVar, BaseException baseException, int i) {
        if (aVar == null) {
            return;
        }
        try {
            DownloadInfo H = aVar.H();
            if (H == null) {
                return;
            }
            y O = aVar.O();
            boolean d2 = d.o.a.e.b.d.a.d(i);
            if (!d2 && !(d2 = k(H.T(), i)) && O != null && (O instanceof m)) {
                d2 = k(((m) O).a(), i);
            }
            if (d2) {
                q C = aVar.C();
                if (C != null) {
                    C.a(H, baseException, i);
                }
                e(O, H, baseException, i);
                d(d.p0(), H, baseException, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(4:66|67|68|(15:70|14|(2:49|(1:(2:57|(1:59)(3:60|61|62)))(1:54))|17|18|(2:22|23)|26|27|28|(1:30)|31|32|(1:44)|35|(2:39|41)(1:38)))|13|14|(0)|49|(1:51)|(0)|17|18|(3:20|22|23)|26|27|28|(0)|31|32|(0)|42|44|35|(0)|39|41) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0103, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0104, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056 A[Catch: all -> 0x0129, TRY_LEAVE, TryCatch #5 {all -> 0x0129, blocks: (B:18:0x002f, B:20:0x0033, B:40:0x0074, B:42:0x008a, B:45:0x009d, B:46:0x00a2, B:48:0x00d8, B:49:0x00e9, B:62:0x011d, B:56:0x010f, B:58:0x0115, B:52:0x0104, B:25:0x0045, B:27:0x004b, B:32:0x0056, B:35:0x0063, B:38:0x006a, B:13:0x0025), top: B:74:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8 A[Catch: JSONException -> 0x0103, all -> 0x0129, TryCatch #0 {JSONException -> 0x0103, blocks: (B:46:0x00a2, B:48:0x00d8, B:49:0x00e9), top: B:68:0x00a2, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(@Nullable i iVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        d.o.a.e.b.j.a d2;
        int b2;
        String e2;
        String errorMessage;
        int a0;
        String path;
        String lastPathSegment;
        JSONObject jSONObject;
        b p0;
        if (downloadInfo == null || (b2 = (d2 = d.o.a.e.b.j.a.d(downloadInfo.c0())).b("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = -1;
        if (iVar != null) {
            try {
                i2 = iVar.b();
                if (iVar instanceof d.o.a.e.b.o.c) {
                    e2 = ((d.o.a.e.b.o.c) iVar).e();
                    if (i2 >= 200 || i2 >= 400) {
                        if (downloadInfo.F() == 0 && ((a0 = downloadInfo.a0()) < 200 || a0 >= 400)) {
                            return;
                        }
                        if (iOException != null) {
                            if (e.p0(d.l())) {
                                try {
                                    e.A(iOException, "");
                                    throw null;
                                } catch (BaseException e3) {
                                    i2 = e3.getErrorCode();
                                    errorMessage = e3.getErrorMessage();
                                }
                            } else {
                                i2 = 1049;
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
                    jSONObject.put("setting_tag", d2.t("setting_tag"));
                    jSONObject.put("url_host", host);
                    jSONObject.putOpt("host_ip", str2);
                    jSONObject.putOpt("host_real_ip", e2);
                    jSONObject.put("url_path", path);
                    jSONObject.put("url_last_path_segment", lastPathSegment);
                    jSONObject.put("net_lib", i);
                    jSONObject.put("connect_type", str3);
                    jSONObject.put("status_code", i2);
                    if (errorMessage != null) {
                        jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, e.j(errorMessage, d2.b("exception_msg_length", 500)));
                    }
                    jSONObject.put(KsMediaMeta.KSM_KEY_HTTP_CONNECT_TIME, j);
                    jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.v0());
                    jSONObject.put("name", downloadInfo.P0());
                    if ((b2 != 1 || b2 == 3) && (p0 = d.p0()) != null) {
                        p0.a("download_connect", jSONObject, null, null);
                    }
                    if (b2 != 2 || b2 == 3) {
                        d.n().b(downloadInfo.c0(), "download_connect", jSONObject);
                    }
                    return;
                }
            }
        }
        e2 = null;
        if (i2 >= 200) {
        }
        if (downloadInfo.F() == 0) {
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
        jSONObject.put("setting_tag", d2.t("setting_tag"));
        jSONObject.put("url_host", host2);
        jSONObject.putOpt("host_ip", str2);
        jSONObject.putOpt("host_real_ip", e2);
        jSONObject.put("url_path", path);
        jSONObject.put("url_last_path_segment", lastPathSegment);
        jSONObject.put("net_lib", i);
        jSONObject.put("connect_type", str3);
        jSONObject.put("status_code", i2);
        if (errorMessage != null) {
        }
        jSONObject.put(KsMediaMeta.KSM_KEY_HTTP_CONNECT_TIME, j);
        jSONObject.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.v0());
        jSONObject.put("name", downloadInfo.P0());
        if (b2 != 1) {
        }
        p0.a("download_connect", jSONObject, null, null);
        if (b2 != 2) {
        }
        d.n().b(downloadInfo.c0(), "download_connect", jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e A[Catch: all -> 0x0191, TryCatch #1 {all -> 0x0191, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x006e, B:32:0x0075, B:34:0x0081, B:35:0x008b, B:39:0x0098, B:41:0x009c, B:45:0x00b3, B:47:0x00c6, B:49:0x00fb, B:50:0x010c, B:52:0x011e, B:56:0x0133, B:58:0x0142, B:60:0x0151, B:61:0x0154, B:73:0x0185, B:66:0x0171, B:68:0x0177, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:80:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb A[Catch: all -> 0x0191, TryCatch #1 {all -> 0x0191, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x006e, B:32:0x0075, B:34:0x0081, B:35:0x008b, B:39:0x0098, B:41:0x009c, B:45:0x00b3, B:47:0x00c6, B:49:0x00fb, B:50:0x010c, B:52:0x011e, B:56:0x0133, B:58:0x0142, B:60:0x0151, B:61:0x0154, B:73:0x0185, B:66:0x0171, B:68:0x0177, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:80:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e A[Catch: all -> 0x0191, TryCatch #1 {all -> 0x0191, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x006e, B:32:0x0075, B:34:0x0081, B:35:0x008b, B:39:0x0098, B:41:0x009c, B:45:0x00b3, B:47:0x00c6, B:49:0x00fb, B:50:0x010c, B:52:0x011e, B:56:0x0133, B:58:0x0142, B:60:0x0151, B:61:0x0154, B:73:0x0185, B:66:0x0171, B:68:0x0177, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:80:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0177 A[Catch: all -> 0x0191, TryCatch #1 {all -> 0x0191, blocks: (B:7:0x0016, B:9:0x002d, B:26:0x0065, B:28:0x006e, B:32:0x0075, B:34:0x0081, B:35:0x008b, B:39:0x0098, B:41:0x009c, B:45:0x00b3, B:47:0x00c6, B:49:0x00fb, B:50:0x010c, B:52:0x011e, B:56:0x0133, B:58:0x0142, B:60:0x0151, B:61:0x0154, B:73:0x0185, B:66:0x0171, B:68:0x0177, B:20:0x004d, B:24:0x005e, B:23:0x005a), top: B:80:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0183 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(String str, int i, d.o.a.e.b.j.a aVar, DownloadInfo downloadInfo, String str2, String str3, String str4, k kVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        int i2;
        String errorMessage;
        long j6;
        int i3;
        int i4;
        double d2;
        b p0;
        String str5;
        int i5;
        if (i <= 0 || j2 <= 0) {
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
                i2 = 1;
            } else if (z2) {
                i2 = 2;
            } else if (baseException != null) {
                i2 = !e.p0(d.l()) ? 1049 : baseException.getErrorCode();
                errorMessage = baseException.getErrorMessage();
                JSONObject jSONObject2 = new JSONObject();
                if (kVar == null) {
                    i4 = kVar instanceof g ? 0 : 1;
                    String a2 = kVar.a("X-Cache");
                    int contains = TextUtils.isEmpty(a2) ? -1 : a2.toLowerCase().contains("hit");
                    if (aVar.b("monitor_sla", 1) == 1 && !z && !z2 && (kVar instanceof d.o.a.e.b.o.c)) {
                        ((d.o.a.e.b.o.c) kVar).c(jSONObject2, true);
                    }
                    j6 = j;
                    i3 = contains;
                } else {
                    j6 = j;
                    i3 = -1;
                    i4 = -1;
                }
                double d3 = j6;
                Double.isNaN(d3);
                double d4 = d3 / 1048576.0d;
                double d5 = j2;
                double nanos = TimeUnit.SECONDS.toNanos(1L);
                Double.isNaN(d5);
                Double.isNaN(nanos);
                d2 = d5 / nanos;
                jSONObject2.put("setting_tag", aVar.t("setting_tag"));
                jSONObject2.put("url_host", host);
                jSONObject2.putOpt("host_ip", str3);
                jSONObject2.putOpt("host_real_ip", str4);
                jSONObject2.put("url_path", path);
                jSONObject2.put("url_last_path_segment", lastPathSegment);
                jSONObject2.put("net_lib", i4);
                jSONObject2.put("hit_cdn_cache", i3);
                jSONObject2.put("status_code", i2);
                if (errorMessage != null) {
                    jSONObject2.put(PmsConstant.Statistic.STATISTIC_ERRMSG, e.j(errorMessage, aVar.b("exception_msg_length", 500)));
                }
                jSONObject2.put("download_sec", d2);
                jSONObject2.put("download_mb", d4);
                if (d2 > 0.0d) {
                    jSONObject2.put("download_speed", d4 / d2);
                }
                if (z3) {
                    double d6 = j3;
                    Double.isNaN(d6);
                    Double.isNaN(d5);
                    jSONObject2.put("rw_read_time", d6 / d5);
                    double d7 = j4;
                    Double.isNaN(d7);
                    Double.isNaN(d5);
                    jSONObject2.put("rw_write_time", d7 / d5);
                    double d8 = j5;
                    Double.isNaN(d8);
                    Double.isNaN(d5);
                    jSONObject2.put("rw_sync_time", d8 / d5);
                }
                jSONObject2.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.v0());
                jSONObject2.put("name", downloadInfo.P0());
                if (i != 1 && i != 3) {
                    i5 = 2;
                    str5 = str;
                    if (i != i5 || i == 3) {
                        d.n().b(downloadInfo.c0(), str5, jSONObject2);
                    }
                    return;
                }
                p0 = d.p0();
                if (p0 == null) {
                    str5 = str;
                    p0.a(str5, jSONObject2, null, null);
                } else {
                    str5 = str;
                }
                i5 = 2;
                if (i != i5) {
                }
                d.n().b(downloadInfo.c0(), str5, jSONObject2);
            } else {
                i2 = 0;
            }
            errorMessage = null;
            JSONObject jSONObject22 = new JSONObject();
            if (kVar == null) {
            }
            double d32 = j6;
            Double.isNaN(d32);
            double d42 = d32 / 1048576.0d;
            double d52 = j2;
            double nanos2 = TimeUnit.SECONDS.toNanos(1L);
            Double.isNaN(d52);
            Double.isNaN(nanos2);
            d2 = d52 / nanos2;
            jSONObject22.put("setting_tag", aVar.t("setting_tag"));
            jSONObject22.put("url_host", host);
            jSONObject22.putOpt("host_ip", str3);
            jSONObject22.putOpt("host_real_ip", str4);
            jSONObject22.put("url_path", path);
            jSONObject22.put("url_last_path_segment", lastPathSegment);
            jSONObject22.put("net_lib", i4);
            jSONObject22.put("hit_cdn_cache", i3);
            jSONObject22.put("status_code", i2);
            if (errorMessage != null) {
            }
            jSONObject22.put("download_sec", d2);
            jSONObject22.put("download_mb", d42);
            if (d2 > 0.0d) {
            }
            if (z3) {
            }
            jSONObject22.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, downloadInfo.v0());
            jSONObject22.put("name", downloadInfo.P0());
            if (i != 1) {
                i5 = 2;
                str5 = str;
                if (i != i5) {
                }
                d.n().b(downloadInfo.c0(), str5, jSONObject22);
            }
            p0 = d.p0();
            if (p0 == null) {
            }
            i5 = 2;
            if (i != i5) {
            }
            d.n().b(downloadInfo.c0(), str5, jSONObject22);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean k(int[] iArr, int i) {
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
