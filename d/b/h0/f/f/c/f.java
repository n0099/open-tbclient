package d.b.h0.f.f.c;

import android.content.IntentFilter;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.b.h0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f48500c;

    static {
        boolean z = k.f45772a;
    }

    public f() {
        super("resumeAllDownloadWhileWifi");
    }

    @Override // d.b.h0.f.i.a
    public d.b.h0.a.t.e.b a(JSONObject jSONObject, d.b.h0.a.p0.b bVar) {
        if (jSONObject == null) {
            bVar.onFail(202, "params may be error");
            return null;
        }
        if (this.f48500c == null) {
            this.f48500c = new AppDownloadNetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        d.b.h0.a.w0.a.c().registerReceiver(this.f48500c, intentFilter);
        bVar.a(null);
        return null;
    }
}
