package com.ss.android.downloadlib.d;

import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.appdownloader.c.g;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements g {
    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(List<com.ss.android.socialbase.downloader.g.c> list) {
    }

    @Override // com.ss.android.socialbase.appdownloader.c.g
    public void a(com.ss.android.socialbase.downloader.g.c cVar, boolean z) {
        if (cVar != null) {
            a(cVar, cVar.w(), z);
        }
    }

    @WorkerThread
    public void a(com.ss.android.socialbase.downloader.g.c cVar, int i, boolean z) {
        com.ss.android.downloadlib.a.b.d.eEt().b();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEt().j(cVar);
        if (j == null) {
            i.b();
            return;
        }
        try {
            if (z) {
                j.c(cVar.eHP());
            } else if (j.g() != -1) {
                j.c(-1);
            } else {
                return;
            }
            com.ss.android.downloadlib.a.b.g.eEw().d(j);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", cVar.g());
            jSONObject.put("name", cVar.h());
            jSONObject.put("url", cVar.j());
            jSONObject.put("download_time", cVar.eHt());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", cVar.eHa());
            jSONObject.put("total_bytes", cVar.eij());
            jSONObject.put("only_wifi", cVar.x() ? 1 : 0);
            jSONObject.put("chunk_count", cVar.eHM());
            jSONObject.put("launch_resumed", z ? 1 : 2);
            jSONObject.put("failed_resume_count", cVar.eHP());
            com.ss.android.downloadlib.e.a.eFc().a("embeded_ad", "download_uncompleted", jSONObject, j);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
