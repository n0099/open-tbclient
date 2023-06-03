package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    public static boolean a(int i) {
        return i == 0 || i == 1;
    }

    public static boolean b(int i) {
        return i == 2 || i == 1;
    }

    public static int a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, boolean z, com.ss.android.socialbase.appdownloader.f fVar) {
        int i;
        String str;
        if (fVar != null && !TextUtils.isEmpty(fVar.a()) && fVar.getContext() != null) {
            try {
                i = a(fVar, fVar.a());
            } catch (Throwable th) {
                j.s().a(th, "redirectSavePathIfPossible");
                i = 4;
            }
            fVar.a(i);
            if (i == 0) {
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
            if (!a(fVar, a3, a) && eVar.b.isShowToast()) {
                String startToast = eVar.b.getStartToast();
                if (TextUtils.isEmpty(startToast)) {
                    startToast = a3.c("download_start_toast_text");
                }
                if (TextUtils.isEmpty(startToast)) {
                    if (z) {
                        str = "已开始下载，可在\"我的\"里查看管理";
                    } else {
                        str = "已开始下载";
                    }
                    startToast = str;
                }
                j.c().a(2, fVar.getContext(), eVar.b, startToast, null, 0);
            }
            return a;
        }
        return 0;
    }

    public static int a(com.ss.android.socialbase.appdownloader.f fVar, String str) {
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(fVar.ad());
        JSONObject d = a.d("download_dir");
        if (d != null && !TextUtils.isEmpty(d.optString("dir_name"))) {
            String b = fVar.b();
            String L = fVar.L();
            if (TextUtils.isEmpty(L)) {
                L = com.ss.android.socialbase.appdownloader.c.a(str, b, fVar.l(), true);
            }
            if (L.length() > 255) {
                L = L.substring(L.length() - 255);
            }
            if (TextUtils.isEmpty(b)) {
                b = L;
            }
            String c = fVar.c();
            if (TextUtils.isEmpty(c)) {
                c = com.ss.android.socialbase.appdownloader.c.b();
            }
            String str2 = c + File.separator + com.ss.android.socialbase.appdownloader.c.a(b, a);
            DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(fVar.getContext(), str);
            if (a2 != null && a2.isSavePathRedirected()) {
                fVar.c(a2.getSavePath());
                try {
                    fVar.a(new JSONObject(a2.getDownloadSettingString()));
                    return 0;
                } catch (Throwable unused) {
                    return 0;
                }
            } else if (a2 == null && "application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.d.j().a(L, fVar.l()))) {
                int a3 = com.ss.android.socialbase.appdownloader.b.a(a);
                if (a3 == 0) {
                    fVar.c(str2);
                    return a3;
                }
                return a3;
            } else if (a2 != null) {
                return 8;
            } else {
                return 9;
            }
        }
        return -1;
    }

    public static com.ss.android.downloadad.api.a.b a(com.ss.android.downloadlib.addownload.b.e eVar, int i) {
        com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.b, eVar.c, eVar.d, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("download_event_opt", 1) > 1) {
            try {
                String packageName = eVar.b.getPackageName();
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

    public static String a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean b(DownloadModel downloadModel) {
        if (downloadModel != null && downloadModel.getModelType() == 2) {
            return true;
        }
        return false;
    }

    public static boolean a(DownloadModel downloadModel) {
        if (downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1) {
            return true;
        }
        return false;
    }

    public static boolean a(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (downloadModel.isAd() && iDownloadButtonClickListener != null) {
            return true;
        }
        return false;
    }

    public static boolean a(com.ss.android.socialbase.appdownloader.f fVar, @NonNull com.ss.android.socialbase.downloader.g.a aVar, int i) {
        boolean z;
        String optString;
        JSONArray e = aVar.e("ah_plans");
        if (e != null && e.length() != 0) {
            int length = e.length();
            JSONObject jSONObject = null;
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 < length) {
                    JSONObject optJSONObject = e.optJSONObject(i2);
                    if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject))) {
                        char c = 65535;
                        switch (optString.hashCode()) {
                            case -985763637:
                                if (optString.equals("plan_a")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -985763636:
                                if (optString.equals("plan_b")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -985763635:
                                if (optString.equals("plan_c")) {
                                    c = 7;
                                    break;
                                }
                                break;
                            case -985763634:
                                if (optString.equals("plan_d")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -985763633:
                                if (optString.equals("plan_e")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -985763632:
                                if (optString.equals("plan_f")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case -985763631:
                                if (optString.equals("plan_g")) {
                                    c = 6;
                                    break;
                                }
                                break;
                            case -985763630:
                                if (optString.equals("plan_h")) {
                                    c = 5;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                if (com.ss.android.socialbase.appdownloader.b.a(optJSONObject, aVar).b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 6:
                                if (com.ss.android.socialbase.appdownloader.b.b(optJSONObject, aVar).b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 7:
                                jSONObject = optJSONObject;
                                continue;
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") != 1) {
                    z = false;
                }
                if (z) {
                    return com.ss.android.socialbase.appdownloader.b.a(com.ss.android.socialbase.downloader.downloader.c.N(), (Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.a());
                }
            }
        }
        return false;
    }
}
