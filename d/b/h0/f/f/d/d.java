package d.b.h0.f.f.d;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import d.b.h0.a.i2.v;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.h0.a.n1.a.a.a {

    /* renamed from: f  reason: collision with root package name */
    public String f48517f;

    /* renamed from: g  reason: collision with root package name */
    public String f48518g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f48519h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48520e;

        public a(JSONObject jSONObject) {
            this.f48520e = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            d.b.h0.f.f.a.l().y(d.this.f48519h);
            String str = d.this.f48517f;
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
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -606050596:
                    if (str.equals("resumeAllDownload")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -534830837:
                    if (str.equals("queryAllStatus")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -451216226:
                    if (str.equals("pauseDownload")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -417021581:
                    if (str.equals("pauseAllDownload")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 184711125:
                    if (str.equals("resumeDownload")) {
                        c2 = 4;
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
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    d.this.w(this.f48520e);
                    return;
                case 1:
                    d.this.t(this.f48520e);
                    return;
                case 2:
                    d.this.s();
                    return;
                case 3:
                    d.this.r(this.f48520e);
                    return;
                case 4:
                    d.this.v(this.f48520e);
                    return;
                case 5:
                    d.this.p(this.f48520e);
                    return;
                case 6:
                    d.this.u();
                    return;
                case 7:
                    d.this.q();
                    return;
                default:
                    d.this.x(new d.b.h0.f.f.g.a(31009, "invalid operation"));
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.f.f.f.b {
        public b() {
        }

        @Override // d.b.h0.f.f.f.b
        public void a(d.b.h0.f.f.g.b bVar) {
            d.this.x(bVar);
        }
    }

    @Override // d.b.h0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        this.f48517f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
        this.f48519h = v.b(bundle.getString(InstallAntiBlockingActivity.KEY_UBC_PARAMS, ""));
        JSONObject b2 = v.b(bundle.getString("data", ""));
        this.f48518g = b2.optString("packageName");
        d.b.h0.f.f.c.b.f48490d.execute(new a(b2));
    }

    public final void p(@NonNull JSONObject jSONObject) {
        d.b.h0.f.f.h.c.a(this.f48518g, this.f48517f, null, null, new d.b.h0.f.f.h.a(this.f48519h));
        d.b.h0.f.f.a.l().k(jSONObject.optString("url"), new b());
    }

    public final void q() {
        d.b.h0.f.f.a.l().o();
    }

    public final void r(@NonNull JSONObject jSONObject) {
        d.b.h0.f.f.h.c.a(this.f48518g, this.f48517f, null, null, new d.b.h0.f.f.h.a(this.f48519h));
        d.b.h0.f.f.a.l().p(jSONObject.optString("url"), new b());
    }

    public final void s() {
        d.b.h0.f.f.a.l().q(new b());
    }

    public final void t(@NonNull JSONObject jSONObject) {
        d.b.h0.f.f.a.l().r(jSONObject.optString("url"), new b());
    }

    public final void u() {
        d.b.h0.f.f.a.l().w();
    }

    public final void v(@NonNull JSONObject jSONObject) {
        d.b.h0.f.f.h.c.a(this.f48518g, this.f48517f, null, null, new d.b.h0.f.f.h.a(this.f48519h));
        d.b.h0.f.f.a.l().x(jSONObject.optString("url"), new b());
    }

    public final void w(@NonNull JSONObject jSONObject) {
        d.b.h0.f.f.h.c.a(this.f48518g, this.f48517f, null, null, new d.b.h0.f.f.h.a(this.f48519h));
        d.b.h0.f.f.a.l().z(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b());
    }

    public final void x(d.b.h0.f.f.g.b bVar) {
        this.f46061d.clear();
        if (bVar != null) {
            this.f46061d.putString("functionType", bVar.a());
            this.f46061d.putString("resultData", bVar.b());
            this.f46061d.putInt(l.f2017a, bVar.c());
            if (bVar.d()) {
                if (!TextUtils.equals(this.f48517f, "startDownload")) {
                    d.b.h0.f.f.h.c.a(this.f48518g, this.f48517f, "success", null, new d.b.h0.f.f.h.a(this.f48519h));
                }
            } else {
                d.b.h0.f.f.h.c.a(this.f48518g, this.f48517f, "fail", String.valueOf(bVar.c()), new d.b.h0.f.f.h.a(this.f48519h));
            }
        }
        c();
    }
}
