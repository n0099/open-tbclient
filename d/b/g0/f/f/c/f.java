package d.b.g0.f.f.c;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.b.g0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f47779c;

    static {
        boolean z = k.f45051a;
    }

    public f() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // d.b.g0.f.i.a
    public d.b.g0.a.t.e.b a(JSONObject jSONObject, d.b.g0.a.p0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (this.f47779c == null) {
            this.f47779c = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.b.g0.a.w0.a.c().registerReceiver(this.f47779c, intentFilter);
        bVar.a(null);
        return null;
    }
}
