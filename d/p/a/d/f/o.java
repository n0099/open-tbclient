package d.p.a.d.f;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.d.f.c;
import d.p.a.d.j;
import d.p.a.e.b.g.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o implements q {
    @Override // d.p.a.e.b.g.q
    public void a(DownloadInfo downloadInfo, int i, int i2) {
        d.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j.c.a().u("pause_reserve_wifi", jSONObject, c2);
    }
}
