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
    private com.ss.android.socialbase.downloader.g.c pVD;

    public b(com.ss.android.socialbase.downloader.g.c cVar) {
        this.pVD = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.b.a.b.a j;
        if (this.pVD != null && (j = com.ss.android.downloadlib.a.b.d.eFT().j(this.pVD)) != null) {
            com.ss.android.downloadlib.e.a.eGB().a("cleanspace_task", j);
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            long longValue = Double.valueOf((com.ss.android.downloadlib.f.d.Sl(this.pVD.g()) + 1.0d) * this.pVD.ejL()).longValue() - this.pVD.eIz();
            if (j.eGn() != null) {
                j.eGn().b();
            }
            c.a();
            c.b();
            if (com.ss.android.downloadlib.f.d.Sr(j.t())) {
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
                g.eFW().d(j);
                com.ss.android.downloadlib.e.a.eGB().a("cleanspace_download_after_quite_clean", j);
                f.iA(j.a()).e(this.pVD.g());
            } else if (j.eGn() != null) {
                j.d(false);
                d.eFY().a(j.z(), new e() { // from class: com.ss.android.downloadlib.a.c.b.1
                });
                j.eGn().e(this.pVD.g(), this.pVD.j(), longValue);
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("show_dialog_result", 3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.e.a.eGB().a("cleanspace_window_show", jSONObject, j);
            }
        }
    }
}
