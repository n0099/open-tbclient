package com.ss.android.socialbase.downloader.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.down.request.db.DownloadDataConstants;
import com.kwai.video.player.KsMediaMeta;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.m.d;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static void a(com.ss.android.socialbase.downloader.d.c cVar, com.ss.android.socialbase.downloader.g.c cVar2, com.ss.android.socialbase.downloader.e.a aVar, int i) {
        if (cVar != null) {
            try {
                JSONObject a2 = a(cVar.b(), cVar2, aVar, i);
                if (a2 == null) {
                    a2 = new JSONObject();
                }
                cVar.a(a2);
            } catch (Throwable th) {
            }
        }
    }

    private static JSONObject a(String str, com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
        JSONException e;
        JSONObject jSONObject;
        String str2;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            q eGW = com.ss.android.socialbase.downloader.downloader.b.eGW();
            String str3 = "";
            String str4 = "";
            String str5 = "";
            int i2 = 0;
            if (eGW == null) {
                str2 = "";
            } else {
                str3 = eGW.b();
                try {
                    if (TextUtils.isDigitsOnly(str3)) {
                        str4 = String.valueOf(Long.valueOf(str3).longValue() % 100);
                    }
                    str2 = str4;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    str2 = "";
                }
                str5 = eGW.a();
                i2 = eGW.c();
            }
            jSONObject.put("event_page", str);
            jSONObject.put("app_id", str5);
            jSONObject.put("device_id", str3);
            jSONObject.put("device_id_postfix", str2);
            jSONObject.put("update_version", i2);
            jSONObject.put("download_status", i);
            if (cVar != null) {
                jSONObject.put("download_id", cVar.g());
                jSONObject.put("name", cVar.h());
                jSONObject.put("url", cVar.j());
                jSONObject.put("download_time", cVar.eIo());
                jSONObject.put("cur_bytes", cVar.eHV());
                jSONObject.put("total_bytes", cVar.ejK());
                jSONObject.put("network_quality", cVar.eHX());
                jSONObject.put("only_wifi", cVar.x() ? 1 : 0);
                jSONObject.put("need_https_degrade", cVar.eIb() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", cVar.t() ? 1 : 0);
                jSONObject.put("md5", cVar.F());
                jSONObject.put("chunk_count", cVar.eIH());
                jSONObject.put("is_force", cVar.aj() ? 1 : 0);
                jSONObject.put(DownloadDataConstants.Columns.COLUMN_RETRY_COUNT, cVar.eHP());
                jSONObject.put("cur_retry_time", cVar.ax());
                jSONObject.put("need_retry_delay", cVar.eIc() ? 1 : 0);
                jSONObject.put("need_reuse_first_connection", cVar.ad() ? 1 : 0);
                jSONObject.put("default_http_service_backup", cVar.o() ? 1 : 0);
                jSONObject.put("retry_delay_status", cVar.eIj().ordinal());
                jSONObject.put("backup_url_used", cVar.P() ? 1 : 0);
                jSONObject.put("download_byte_error_retry_status", cVar.eHW().ordinal());
                jSONObject.put("forbidden_handler_status", cVar.eIk().ordinal());
                jSONObject.put("need_independent_process", cVar.ae() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", cVar.c() != null ? cVar.c() : "");
                jSONObject.put("extra", cVar.C() != null ? cVar.C() : "");
                jSONObject.put("add_listener_to_same_task", cVar.ai() ? 1 : 0);
                if (cVar.eIu() != null) {
                    jSONObject.put("backup_url_count", cVar.eIu().size());
                    jSONObject.put("cur_backup_url_index", cVar.s());
                }
                if (cVar.eHR() != null) {
                    jSONObject.put("forbidden_urls", cVar.eHR().toString());
                }
            }
            if (aVar != null) {
                jSONObject.put("error_code", aVar.a());
                jSONObject.put("error_msg", aVar.b());
            }
            return jSONObject;
        } catch (JSONException e4) {
            e = e4;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:8|(2:72|73)|10|(2:54|(1:(13:63|(1:65)(3:66|67|68)|15|(3:19|20|21)|24|25|26|(1:28)|29|30|(1:47)|34|(2:41|43)(1:44)))(1:60))|14|15|(4:17|19|20|21)|24|25|26|(0)|29|30|(1:32)|45|47|34|(1:36)|39|41|43) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0129, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x012a, code lost:
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1 A[Catch: Throwable -> 0x0106, JSONException -> 0x0129, TryCatch #2 {JSONException -> 0x0129, blocks: (B:32:0x007a, B:34:0x00b1, B:35:0x00c4), top: B:68:0x007a, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(@Nullable e eVar, String str, long j, String str2, int i, IOException iOException, com.ss.android.socialbase.downloader.g.c cVar) {
        com.ss.android.socialbase.downloader.k.a SR;
        int b2;
        String b3;
        int aq;
        String path;
        String lastPathSegment;
        JSONObject jSONObject;
        c eHq;
        b eHr;
        if (cVar != null && (b2 = (SR = com.ss.android.socialbase.downloader.k.a.SR(cVar.g())).b("monitor_download_connect")) > 0 && !TextUtils.isEmpty(str)) {
            int i2 = -1;
            if (eVar != null) {
                try {
                    i2 = eVar.b();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            if (i2 < 200 || i2 >= 400) {
                if (cVar.ax() == 0 || ((aq = cVar.aq()) >= 200 && aq < 400)) {
                    if (iOException != null) {
                        if (!d.b(com.ss.android.socialbase.downloader.downloader.b.eHp())) {
                            i2 = 1049;
                            b3 = null;
                        } else {
                            try {
                                d.a((Throwable) iOException, "");
                                b3 = null;
                            } catch (com.ss.android.socialbase.downloader.e.a e) {
                                i2 = e.a();
                                b3 = e.b();
                            }
                        }
                        Uri parse = Uri.parse(str);
                        String host = parse.getHost();
                        path = parse.getPath();
                        lastPathSegment = parse.getLastPathSegment();
                        if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                            try {
                                path = path.substring(0, path.length() - lastPathSegment.length());
                            } catch (Throwable th2) {
                            }
                        }
                        jSONObject = new JSONObject();
                        jSONObject.put("setting_tag", SR.d("setting_tag"));
                        jSONObject.put("url_host", host);
                        jSONObject.put("url_path", path);
                        jSONObject.put("url_file", lastPathSegment);
                        jSONObject.put("net_lib", i);
                        jSONObject.put("connect_type", str2);
                        jSONObject.put("status_code", i2);
                        if (b3 != null) {
                            jSONObject.put("err_msg", d.a(b3, SR.a("exception_msg_length", 500)));
                        }
                        jSONObject.put(KsMediaMeta.KSM_KEY_HTTP_CONNECT_TIME, j);
                        jSONObject.put("pkg_name", cVar.D());
                        jSONObject.put("name", cVar.i());
                        if ((b2 != 1 || b2 == 3) && (eHq = com.ss.android.socialbase.downloader.downloader.b.eHq()) != null) {
                            eHq.a("download_connect", jSONObject);
                        }
                        if ((b2 != 2 || b2 == 3) && (eHr = com.ss.android.socialbase.downloader.downloader.b.eHr()) != null) {
                            eHr.a(cVar, "download_connect", jSONObject);
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
            b3 = null;
            Uri parse2 = Uri.parse(str);
            String host2 = parse2.getHost();
            path = parse2.getPath();
            lastPathSegment = parse2.getLastPathSegment();
            if (!TextUtils.isEmpty(path)) {
                path = path.substring(0, path.length() - lastPathSegment.length());
            }
            jSONObject = new JSONObject();
            jSONObject.put("setting_tag", SR.d("setting_tag"));
            jSONObject.put("url_host", host2);
            jSONObject.put("url_path", path);
            jSONObject.put("url_file", lastPathSegment);
            jSONObject.put("net_lib", i);
            jSONObject.put("connect_type", str2);
            jSONObject.put("status_code", i2);
            if (b3 != null) {
            }
            jSONObject.put(KsMediaMeta.KSM_KEY_HTTP_CONNECT_TIME, j);
            jSONObject.put("pkg_name", cVar.D());
            jSONObject.put("name", cVar.i());
            if (b2 != 1) {
            }
            eHq.a("download_connect", jSONObject);
            if (b2 != 2) {
            }
            eHr.a(cVar, "download_connect", jSONObject);
        }
    }
}
