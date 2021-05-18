package d.a.i0.g.c.c;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends d.a.i0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f46823c;

    static {
        boolean z = k.f43025a;
    }

    public h() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // d.a.i0.g.f.a
    public d.a.i0.a.u.h.b a(JSONObject jSONObject, d.a.i0.a.u0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (this.f46823c == null) {
            this.f46823c = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.a.i0.a.c1.a.b().registerReceiver(this.f46823c, intentFilter);
        bVar.b(null);
        return null;
    }
}
