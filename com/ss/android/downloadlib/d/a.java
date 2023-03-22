package com.ss.android.downloadlib.d;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.c;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.f;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.f.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.ss.android.downloadlib.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0687a {
        public static a a = new a();
    }

    public a() {
    }

    public static a a() {
        return C0687a.a;
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

    private JSONObject a(com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            l.a(aVar.g(), jSONObject);
            l.a(aVar.p(), jSONObject);
            jSONObject.putOpt("download_url", aVar.a());
            jSONObject.putOpt("package_name", aVar.e());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", d.g());
            jSONObject.putOpt("rom_version", d.h());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
            if (aVar.h() == 2) {
                f.b(jSONObject, aVar);
            }
        } catch (Exception e) {
            j.s().a(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void a(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            com.ss.android.downloadlib.e.c.a().a("onEvent data null");
        } else if ((aVar instanceof e) && ((e) aVar).x()) {
            com.ss.android.downloadlib.e.c.a().a("onEvent ModelBox notValid");
        } else {
            try {
                c.a c = new c.a().a(l.a(str, aVar.j(), "embeded_ad")).b(str2).b(aVar.c()).a(aVar.b()).c(aVar.d());
                if (j <= 0) {
                    j = aVar.l();
                }
                c.a a = c.b(j).d(aVar.i()).a(aVar.n()).a(l.a(a(aVar), jSONObject)).b(aVar.k()).a(aVar.o());
                if (i <= 0) {
                    i = 2;
                }
                a(a.a(i).a(aVar.m()).a());
            } catch (Exception e) {
                com.ss.android.downloadlib.e.c.a().a(e, "onEvent");
            }
        }
    }

    public void a(long j, int i) {
        String clickButtonTag;
        int i2;
        e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendClickEvent ModelBox notValid");
        } else if (!e.c.isEnableClickEvent()) {
        } else {
            int i3 = 1;
            DownloadEventConfig downloadEventConfig = e.c;
            if (i == 1) {
                clickButtonTag = downloadEventConfig.getClickItemTag();
            } else {
                clickButtonTag = downloadEventConfig.getClickButtonTag();
            }
            String a = l.a(e.c.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                if (com.ss.android.socialbase.appdownloader.e.d.a()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                jSONObject.putOpt("permission_notification", Integer.valueOf(i2));
                if (!com.ss.android.socialbase.downloader.i.f.c(j.getContext())) {
                    i3 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(clickButtonTag, a, jSONObject, e);
            if ("click".equals(a) && e.b != null) {
                c.a().a(j, e.b.getLogExtra());
            }
        }
    }

    public void b(DownloadInfo downloadInfo, BaseException baseException) {
        int i;
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a == null) {
            com.ss.android.downloadlib.e.c.a().a("sendDownloadFailedEvent nativeModel null");
        } else if (a.c.get()) {
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                f.c(downloadInfo, jSONObject);
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
                int i2 = 1;
                if (a.d.get()) {
                    i = 1;
                } else {
                    i = 2;
                }
                jSONObject.put("has_send_download_failed_finally", i);
                f.a(a, jSONObject);
                if (!a.V()) {
                    i2 = 2;
                }
                jSONObject.put("is_update_download", i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(a.j(), "download_failed", jSONObject, a);
            i.a().a(a);
        }
    }

    public void a(long j, int i, DownloadInfo downloadInfo) {
        e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendEvent ModelBox notValid");
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "download_scene", Integer.valueOf(e.t()));
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            if (downloadInfo != null) {
                                try {
                                    f.a(jSONObject, downloadInfo.getId());
                                    com.ss.android.downloadlib.a.b(jSONObject, downloadInfo);
                                } catch (Throwable unused) {
                                }
                            }
                            str = l.a(e.c.getClickInstallLabel(), "click_install");
                        }
                    } else {
                        str = l.a(e.c.getClickContinueLabel(), "click_continue");
                        f.c(downloadInfo, jSONObject);
                    }
                } else {
                    str = l.a(e.c.getClickPauseLabel(), "click_pause");
                    f.b(downloadInfo, jSONObject);
                }
            } else {
                str = l.a(e.c.getClickStartLabel(), "click_start");
                f.a(downloadInfo, jSONObject);
            }
        } else {
            str = l.a(e.c.getStorageDenyLabel(), "storage_deny");
        }
        a(null, str, jSONObject, 0L, 1, e);
    }

    public void a(long j, BaseException baseException) {
        e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b("download_failed", jSONObject, e);
    }

    public void a(long j, boolean z, int i) {
        String str;
        e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendQuickAppEvent ModelBox notValid");
        } else if (e.b.getQuickAppModel() == null) {
        } else {
            DownloadModel downloadModel = e.b;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (z) {
                str = "deeplink_quickapp_success";
            } else {
                str = "deeplink_quickapp_failed";
            }
            b(str, jSONObject, e);
        }
    }

    public void a(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            f.c(downloadInfo, jSONObject);
            a.a(System.currentTimeMillis());
            a(a.j(), "download_resume", jSONObject, a);
            i.a().a(a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.a.b a;
        int i;
        int i2;
        if (downloadInfo == null || (a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null || a.c.get()) {
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
            int i3 = 1;
            if (a.V()) {
                i = 1;
            } else {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
            if (com.ss.android.socialbase.appdownloader.e.d.a()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            jSONObject.put("can_show_notification", i2);
            if (!a.d.get()) {
                i3 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        a(a.j(), "download_cancel", jSONObject, a);
    }

    public void a(String str, int i, e eVar) {
        a(null, str, null, i, 0, eVar);
    }

    public void b(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, jSONObject, aVar);
    }

    public void a(String str, long j) {
        com.ss.android.downloadad.api.a.b d = com.ss.android.downloadlib.addownload.b.f.a().d(j);
        if (d != null) {
            b(str, d);
        } else {
            b(str, com.ss.android.downloadlib.addownload.b.f.a().e(j));
        }
    }

    public void b(long j, int i) {
        a(j, i, (DownloadInfo) null);
    }

    public void a(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        b(str, new e(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        a(str, (JSONObject) null, aVar);
    }

    public void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, aVar);
    }

    public void a(String str, String str2, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, (JSONObject) null, aVar);
    }

    public void a(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, jSONObject, 0L, 0, aVar);
    }

    public void a(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.a.a d = com.ss.android.downloadlib.addownload.b.f.a().d(j);
        if (d != null) {
            a(str, jSONObject, d);
            return;
        }
        e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendUnityEvent ModelBox notValid");
        } else {
            a(str, jSONObject, e);
        }
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        l.a(jSONObject2, "unity_label", str);
        a("embeded_ad", "ttdownloader_unity", l.a(jSONObject, jSONObject2), aVar);
    }

    public void a(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar.j(), "install_finish", jSONObject, bVar);
    }
}
