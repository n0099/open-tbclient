package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l {
    public static com.ss.android.downloadlib.addownload.a.c a;

    public static com.ss.android.downloadlib.addownload.a.c a() {
        return a;
    }

    public static boolean a(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static void a(com.ss.android.downloadlib.addownload.a.c cVar) {
        a = cVar;
    }

    public static boolean a(final com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.d.c cVar) {
        if (bVar == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi nativeModel null");
            return false;
        } else if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("tryReverseWifi info null");
            return false;
        } else {
            final int id = downloadInfo.getId();
            boolean b = com.ss.android.downloadlib.g.e.b(bVar);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("switch_status", Integer.valueOf(b ? 1 : 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("pause_reserve_wifi_switch_status", jSONObject, bVar);
            if (b && a(i) && !com.ss.android.socialbase.downloader.i.f.b(j.getContext()) && !downloadInfo.hasPauseReservedOnWifi()) {
                a(new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.l.1
                    @Override // com.ss.android.downloadlib.addownload.a.c
                    public void a() {
                        l.a((com.ss.android.downloadlib.addownload.a.c) null);
                        DownloadInfo downloadInfo2 = Downloader.getInstance(j.getContext()).getDownloadInfo(id);
                        if (downloadInfo2 != null) {
                            downloadInfo2.startPauseReserveOnWifi();
                            r.a().a(downloadInfo2);
                            com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_confirm", bVar);
                        }
                        cVar.a(bVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.a.c
                    public void b() {
                        l.a((com.ss.android.downloadlib.addownload.a.c) null);
                        DownloadInfo downloadInfo2 = Downloader.getInstance(j.getContext()).getDownloadInfo(id);
                        if (downloadInfo2 != null) {
                            downloadInfo2.stopPauseReserveOnWifi();
                        }
                        com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel", bVar);
                        cVar.a(bVar);
                    }
                });
                TTDelegateActivity.b(bVar);
                return true;
            }
            return false;
        }
    }
}
