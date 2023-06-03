package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements Runnable {
    public DownloadInfo a;

    public b(DownloadInfo downloadInfo) {
        this.a = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.a.b a;
        boolean z;
        if (this.a == null || (a = f.a().a(this.a)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_task", a);
        long longValue = Double.valueOf((com.ss.android.downloadlib.g.e.a(this.a.getId()) + 1.0d) * this.a.getTotalBytes()).longValue() - this.a.getCurBytes();
        long a2 = l.a(0L);
        if (j.l() != null) {
            j.l().e();
        }
        c.a();
        c.b();
        if (com.ss.android.downloadlib.g.e.g(a.s())) {
            c.a(j.getContext());
        }
        long a3 = l.a(0L);
        if (a3 >= longValue) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            a.l("1");
            i.a().a(a);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(a3 - a2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, a);
            Downloader.getInstance(j.getContext()).restart(this.a.getId());
        } else if (j.l() != null) {
            a.d(false);
            d.a().a(a.a(), new e() { // from class: com.ss.android.downloadlib.addownload.c.b.1
            });
            if (j.l().a(this.a.getId(), this.a.getUrl(), true, longValue)) {
                a.e(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject2, a);
        }
    }
}
