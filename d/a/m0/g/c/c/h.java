package d.a.m0.g.c.c;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends d.a.m0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f50781c;

    static {
        boolean z = k.f46983a;
    }

    public h() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // d.a.m0.g.f.a
    public d.a.m0.a.u.h.b a(JSONObject jSONObject, d.a.m0.a.u0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (this.f50781c == null) {
            this.f50781c = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.a.m0.a.c1.a.b().registerReceiver(this.f50781c, intentFilter);
        bVar.a(null);
        return null;
    }
}
