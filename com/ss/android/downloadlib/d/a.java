package com.ss.android.downloadlib.d;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.c;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.ss.android.downloadlib.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2044a {
        public static a a = new a();
    }

    public static a a() {
        return C2044a.a;
    }

    public void b(long j, int i) {
        a(j, i, (DownloadInfo) null);
    }

    public a() {
    }

    public void a(long j, int i) {
        e e2 = f.a().e(j);
        if (e2.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendClickEvent ModelBox notValid");
        } else if (e2.f42775c.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = e2.f42775c;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String a = l.a(e2.f42775c.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(d.a() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.i.f.c(j.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            a(clickItemTag, a, jSONObject, e2);
            if (!"click".equals(a) || e2.f42774b == null) {
                return;
            }
            c.a().a(j, e2.f42774b.getLogExtra());
        }
    }

    public void b(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b a = f.a().a(downloadInfo);
        if (a == null) {
            com.ss.android.downloadlib.e.c.a().a("sendDownloadFailedEvent nativeModel null");
        } else if (a.f42680c.get()) {
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
                if (baseException != null) {
                    jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                    a.d(baseException.getErrorCode());
                    a.a(baseException.getErrorMessage());
                }
                a.y();
                jSONObject.put("download_failed_times", a.x());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                int i = 1;
                jSONObject.put("has_send_download_failed_finally", a.f42681d.get() ? 1 : 2);
                com.ss.android.downloadlib.g.f.a(a, jSONObject);
                if (!a.V()) {
                    i = 2;
                }
                jSONObject.put("is_update_download", i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(a.j(), "download_failed", jSONObject, a);
            i.a().a(a);
        }
    }

    public void a(long j, int i, DownloadInfo downloadInfo) {
        e e2 = f.a().e(j);
        if (e2.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendEvent ModelBox notValid");
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "download_scene", Integer.valueOf(e2.t()));
        if (i == 1) {
            str = l.a(e2.f42775c.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            str = l.a(e2.f42775c.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.g.f.a(downloadInfo, jSONObject);
        } else if (i == 3) {
            str = l.a(e2.f42775c.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.g.f.b(downloadInfo, jSONObject);
        } else if (i == 4) {
            str = l.a(e2.f42775c.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
        } else if (i == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.a.b(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            str = l.a(e2.f42775c.getClickInstallLabel(), "click_install");
        }
        a(null, str, jSONObject, 0L, 1, e2);
    }

    public void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, aVar);
    }

    public void b(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, jSONObject, aVar);
    }

    public void a(String str, int i, e eVar) {
        a(null, str, null, i, 0, eVar);
    }

    public void a(long j, boolean z, int i) {
        e e2 = f.a().e(j);
        if (e2.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendQuickAppEvent ModelBox notValid");
        } else if (e2.f42774b.getQuickAppModel() == null) {
        } else {
            DownloadModel downloadModel = e2.f42774b;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            b(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, e2);
        }
    }

    public void a(long j, BaseException baseException) {
        e e2 = f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        b("download_failed", jSONObject, e2);
    }

    public void a(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.a.b a = f.a().a(downloadInfo);
        if (a == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a.a(System.currentTimeMillis());
            a(a.j(), "download_resume", jSONObject, a);
            i.a().a(a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar.j(), "install_finish", jSONObject, bVar);
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.a.b a;
        if (downloadInfo == null || (a = f.a().a(downloadInfo)) == null || a.f42680c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(a.E()));
            jSONObject.putOpt("fail_msg", a.F());
            jSONObject.put("download_failed_times", a.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (a.H() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - a.H());
            }
            if (a.B() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - a.B());
            }
            int i = 1;
            jSONObject.put("is_update_download", a.V() ? 1 : 2);
            jSONObject.put("can_show_notification", d.a() ? 1 : 2);
            if (!a.f42681d.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(a.j(), "download_cancel", jSONObject, a);
    }

    public void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        a(str, (JSONObject) null, aVar);
    }

    public void a(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.a.a d2 = f.a().d(j);
        if (d2 != null) {
            a(str, jSONObject, d2);
            return;
        }
        e e2 = f.a().e(j);
        if (e2.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendUnityEvent ModelBox notValid");
        } else {
            a(str, jSONObject, e2);
        }
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        l.a(jSONObject2, "unity_label", str);
        a("embeded_ad", "ttdownloader_unity", l.a(jSONObject, jSONObject2), aVar);
    }

    public void a(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        b(str, new e(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void a(String str, long j) {
        com.ss.android.downloadad.api.a.b d2 = f.a().d(j);
        if (d2 != null) {
            b(str, d2);
        } else {
            b(str, f.a().e(j));
        }
    }

    public void a(String str, String str2, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, (JSONObject) null, aVar);
    }

    public void a(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, jSONObject, 0L, 0, aVar);
    }

    private void a(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            com.ss.android.downloadlib.e.c.a().a("onEvent data null");
        } else if ((aVar instanceof e) && ((e) aVar).x()) {
            com.ss.android.downloadlib.e.c.a().a("onEvent ModelBox notValid");
        } else {
            try {
                c.a c2 = new c.a().a(l.a(str, aVar.j(), "embeded_ad")).b(str2).b(aVar.c()).a(aVar.b()).c(aVar.d());
                if (j <= 0) {
                    j = aVar.l();
                }
                c.a a = c2.b(j).d(aVar.i()).a(aVar.n()).a(l.a(a(aVar), jSONObject)).b(aVar.k()).a(aVar.o());
                if (i <= 0) {
                    i = 2;
                }
                a(a.a(i).a(aVar.m()).a());
            } catch (Exception e2) {
                com.ss.android.downloadlib.e.c.a().a(e2, "onEvent");
            }
        }
    }

    private JSONObject a(com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            l.a(aVar.g(), jSONObject);
            l.a(aVar.p(), jSONObject);
            jSONObject.putOpt("download_url", aVar.a());
            jSONObject.putOpt("package_name", aVar.e());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.f.d.g());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.f.d.h());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
            if (aVar.h() == 2) {
                com.ss.android.downloadlib.g.f.b(jSONObject, aVar);
            }
        } catch (Exception e2) {
            j.s().a(e2, "getBaseJson");
        }
        return jSONObject;
    }

    private void a(com.ss.android.download.api.model.c cVar) {
        if (j.a() == null) {
            return;
        }
        if (cVar.m()) {
            j.a().a(cVar);
        } else {
            j.a().b(cVar);
        }
    }
}
