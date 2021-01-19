package com.ss.android.downloadlib.a.c;

import android.os.Environment;
import com.ss.android.downloadlib.a.b.g;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.downloader.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements Runnable {
    private com.ss.android.socialbase.downloader.g.c pRd;

    public b(com.ss.android.socialbase.downloader.g.c cVar) {
        this.pRd = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.b.a.b.a j;
        if (this.pRd != null && (j = com.ss.android.downloadlib.a.b.d.eCc().j(this.pRd)) != null) {
            com.ss.android.downloadlib.e.a.eCL().a("cleanspace_task", j);
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            long longValue = Double.valueOf((com.ss.android.downloadlib.f.d.QE(this.pRd.g()) + 1.0d) * this.pRd.efR()).longValue() - this.pRd.eEJ();
            if (j.eCw() != null) {
                j.eCw().b();
            }
            c.a();
            c.b();
            if (com.ss.android.downloadlib.f.d.QK(j.t())) {
                c.a(j.a());
            }
            long j2 = 0;
            try {
                j2 = com.ss.android.socialbase.downloader.m.d.c(externalStorageDirectory.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean z = j2 >= longValue;
            j.e(true);
            if (z) {
                j.j("1");
                g.eCf().d(j);
                com.ss.android.downloadlib.e.a.eCL().a("cleanspace_download_after_quite_clean", j);
                f.iy(j.a()).e(this.pRd.g());
            } else if (j.eCw() != null) {
                j.d(false);
                d.eCh().a(j.z(), new e() { // from class: com.ss.android.downloadlib.a.c.b.1
                });
                j.eCw().e(this.pRd.g(), this.pRd.j(), longValue);
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("show_dialog_result", 3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.eCL().a("cleanspace_window_show", jSONObject, j);
            }
        }
    }
}
