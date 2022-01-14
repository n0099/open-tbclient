package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public static boolean a(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static boolean a(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean b(int i2) {
        return i2 == 2 || i2 == 1;
    }

    public static boolean b(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static int a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, boolean z, com.ss.android.socialbase.appdownloader.f fVar) {
        int i2;
        if (fVar == null || TextUtils.isEmpty(fVar.a()) || fVar.getContext() == null) {
            return 0;
        }
        try {
            i2 = a(fVar, fVar.a());
        } catch (Throwable th) {
            j.s().a(th, "redirectSavePathIfPossible");
            i2 = 4;
        }
        fVar.a(i2);
        if (i2 == 0) {
            fVar.a(new com.ss.android.downloadlib.c.a());
        }
        if (!fVar.Z()) {
            fVar.a(new com.ss.android.downloadlib.c.b());
        }
        int a = com.ss.android.socialbase.appdownloader.d.j().a(fVar);
        com.ss.android.downloadad.api.a.b a2 = a(eVar, a);
        com.ss.android.downloadlib.addownload.b.f.a().a(a2);
        a2.g(a);
        a2.h(System.currentTimeMillis());
        a2.i(0L);
        com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(fVar.ad());
        if (!a(fVar, a3, a) && eVar.f59464b.isShowToast()) {
            String startToast = eVar.f59464b.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = a3.c("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            j.c().a(2, fVar.getContext(), eVar.f59464b, startToast, null, 0);
        }
        return a;
    }

    public static com.ss.android.downloadad.api.a.b a(com.ss.android.downloadlib.addownload.b.e eVar, int i2) {
        com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.f59464b, eVar.f59465c, eVar.f59466d, i2);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.g.a.a(i2).a("download_event_opt", 1) > 1) {
            try {
                String packageName = eVar.f59464b.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (j.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    bVar.h(z);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    public static boolean a(com.ss.android.socialbase.appdownloader.f fVar, @NonNull com.ss.android.socialbase.downloader.g.a aVar, int i2) {
        String optString;
        JSONArray e2 = aVar.e("ah_plans");
        if (e2 != null && e2.length() != 0) {
            int length = e2.length();
            JSONObject jSONObject = null;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    JSONObject optJSONObject = e2.optJSONObject(i3);
                    if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject))) {
                        char c2 = 65535;
                        switch (optString.hashCode()) {
                            case -985763637:
                                if (optString.equals("plan_a")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case -985763636:
                                if (optString.equals("plan_b")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -985763635:
                                if (optString.equals("plan_c")) {
                                    c2 = 7;
                                    break;
                                }
                                break;
                            case -985763634:
                                if (optString.equals("plan_d")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case -985763633:
                                if (optString.equals("plan_e")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case -985763632:
                                if (optString.equals("plan_f")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -985763631:
                                if (optString.equals("plan_g")) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                            case -985763630:
                                if (optString.equals("plan_h")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                if (com.ss.android.socialbase.appdownloader.b.a(optJSONObject, aVar).f59700b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 6:
                                if (com.ss.android.socialbase.appdownloader.b.b(optJSONObject, aVar).f59700b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 7:
                                jSONObject = optJSONObject;
                                continue;
                        }
                    }
                    i3++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.c.N(), (Intent) null, jSONObject, i2, new com.ss.android.socialbase.appdownloader.a());
                }
            }
        }
        return false;
    }

    public static String a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static int a(com.ss.android.socialbase.appdownloader.f fVar, String str) {
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(fVar.ad());
        JSONObject d2 = a.d("download_dir");
        if (d2 == null || TextUtils.isEmpty(d2.optString("dir_name"))) {
            return -1;
        }
        String b2 = fVar.b();
        String L = fVar.L();
        if (TextUtils.isEmpty(L)) {
            L = com.ss.android.socialbase.appdownloader.c.a(str, b2, fVar.l(), true);
        }
        if (L.length() > 255) {
            L = L.substring(L.length() - 255);
        }
        if (TextUtils.isEmpty(b2)) {
            b2 = L;
        }
        String c2 = fVar.c();
        if (TextUtils.isEmpty(c2)) {
            c2 = com.ss.android.socialbase.appdownloader.c.b();
        }
        String str2 = c2 + File.separator + com.ss.android.socialbase.appdownloader.c.a(b2, a);
        DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(fVar.getContext(), str);
        if (a2 != null && a2.isSavePathRedirected()) {
            fVar.c(a2.getSavePath());
            try {
                fVar.a(new JSONObject(a2.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        } else if (a2 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.d.j().a(L, fVar.l()))) {
            return a2 != null ? 8 : 9;
        } else {
            int a3 = com.ss.android.socialbase.appdownloader.b.a(a);
            if (a3 == 0) {
                fVar.c(str2);
                return a3;
            }
            return a3;
        }
    }
}
