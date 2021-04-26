package d.a.h0.f.f.c;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.a.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f45960c;

    static {
        boolean z = k.f43101a;
    }

    public f() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // d.a.h0.f.i.a
    public d.a.h0.a.t.e.b a(JSONObject jSONObject, d.a.h0.a.p0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (this.f45960c == null) {
            this.f45960c = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.a.h0.a.w0.a.c().registerReceiver(this.f45960c, intentFilter);
        bVar.a(null);
        return null;
    }
}
