package d.a.m0.f.j.n;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import d.a.m0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.a.m0.a.v1.a.a.a {

    /* renamed from: f  reason: collision with root package name */
    public String f50708f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f50709g;

    /* renamed from: h  reason: collision with root package name */
    public i f50710h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50711e;

        public a(JSONObject jSONObject) {
            this.f50711e = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            e.s().H(f.this.f50709g);
            String str = f.this.f50708f;
            switch (str.hashCode()) {
                case -1261560102:
                    if (str.equals("queryStatus")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -625158317:
                    if (str.equals("deleteDownload")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -451216226:
                    if (str.equals("pauseDownload")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -234424485:
                    if (str.equals("open_manual")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 184711125:
                    if (str.equals("resumeDownload")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 900412038:
                    if (str.equals("installApp")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1554935562:
                    if (str.equals("startDownload")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1944785703:
                    if (str.equals("checkPackageExpired")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    f.this.v(this.f50711e);
                    return;
                case 1:
                    f.this.t(this.f50711e);
                    return;
                case 2:
                    f.this.s(this.f50711e);
                    return;
                case 3:
                    f.this.u(this.f50711e);
                    return;
                case 4:
                    f.this.o(this.f50711e);
                    return;
                case 5:
                    f.this.p(this.f50711e);
                    return;
                case 6:
                    f.this.r(this.f50711e);
                    return;
                case 7:
                    f.this.q(this.f50711e);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // d.a.m0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        this.f50708f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
        this.f50709g = w.d(bundle.getString("ubc_params", ""));
        JSONObject d2 = w.d(bundle.getString("data", ""));
        if (this.f50710h == null) {
            this.f50710h = new i(this);
        }
        e.s().G(this.f50710h);
        e.m.execute(new a(d2));
    }

    public final void o(@NonNull JSONObject jSONObject) {
        e.s().r(jSONObject.optString("key_download_package_name"));
    }

    public final void p(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("key_download_url");
        String optString2 = jSONObject.optString("key_download_package_name");
        String optString3 = jSONObject.optString("download_params");
        d.a.m0.f.j.r.b.n().h("manualInstall", new d.a.m0.f.j.r.a(this.f50709g), optString2, optString3, optString);
        e.s().J(optString, optString2, optString3);
    }

    public final void q(@NonNull JSONObject jSONObject) {
        e.s().w(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"));
    }

    public final void r(@NonNull JSONObject jSONObject) {
        e.s().o(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optLong(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, 0L));
    }

    public final void s(@NonNull JSONObject jSONObject) {
        e.s().x(jSONObject.optString("key_download_package_name"));
    }

    public final void t(@NonNull JSONObject jSONObject) {
        e.s().y(jSONObject.optString("key_download_package_name"));
    }

    public final void u(@NonNull JSONObject jSONObject) {
        e.s().F(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
    }

    public final void v(@NonNull JSONObject jSONObject) {
        e.s().I(jSONObject.optString("key_download_url"), jSONObject.optString("key_download_package_name"), jSONObject.optString("download_params"));
    }
}
