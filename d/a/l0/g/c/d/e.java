package d.a.l0.g.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import d.a.l0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.l0.a.v1.a.a.a {

    /* renamed from: f  reason: collision with root package name */
    public String f47021f;

    /* renamed from: g  reason: collision with root package name */
    public String f47022g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f47023h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47024e;

        public a(JSONObject jSONObject) {
            this.f47024e = jSONObject;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            char c2;
            d.a.l0.g.c.a.n().G(e.this.f47023h);
            String str = e.this.f47021f;
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
                    e.this.w(this.f47024e);
                    return;
                case 1:
                    e.this.t(this.f47024e);
                    return;
                case 2:
                    e.this.s();
                    return;
                case 3:
                    e.this.r(this.f47024e);
                    return;
                case 4:
                    e.this.v(this.f47024e);
                    return;
                case 5:
                    e.this.p(this.f47024e);
                    return;
                case 6:
                    e.this.u();
                    return;
                case 7:
                    e.this.q();
                    return;
                default:
                    e.this.x(new d.a.l0.g.c.g.a(31009, "invalid operation"));
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.g.c.f.b {
        public b() {
        }

        @Override // d.a.l0.g.c.f.b
        public void b(d.a.l0.g.c.g.b bVar) {
            e.this.x(bVar);
        }
    }

    @Override // d.a.l0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        this.f47021f = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "");
        this.f47023h = w.d(bundle.getString("ubc_params", ""));
        JSONObject d2 = w.d(bundle.getString("data", ""));
        this.f47022g = d2.optString("packageName");
        d.a.l0.g.c.c.b.f46988d.execute(new a(d2));
    }

    public final void p(@NonNull JSONObject jSONObject) {
        d.a.l0.g.c.a.n().m(jSONObject, new b());
    }

    public final void q() {
        d.a.l0.g.c.a.n().u();
    }

    public final void r(@NonNull JSONObject jSONObject) {
        d.a.l0.g.c.a.n().v(jSONObject, new b());
    }

    public final void s() {
        d.a.l0.g.c.a.n().w(new b());
    }

    public final void t(@NonNull JSONObject jSONObject) {
        d.a.l0.g.c.a.n().x(jSONObject, new b());
    }

    public final void u() {
        d.a.l0.g.c.a.n().D();
    }

    public final void v(@NonNull JSONObject jSONObject) {
        d.a.l0.g.c.a.n().E(jSONObject, new b());
    }

    public final void w(@NonNull JSONObject jSONObject) {
        d.a.l0.g.c.a.n().H(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new b());
    }

    public final void x(d.a.l0.g.c.g.b bVar) {
        this.f45272d.clear();
        if (bVar != null) {
            this.f45272d.putString("functionType", bVar.a());
            this.f45272d.putString("resultData", bVar.b());
            this.f45272d.putInt(l.f1974a, bVar.c());
            if (bVar.d()) {
                if (!TextUtils.equals(this.f47021f, "startDownload")) {
                    d.a.l0.g.c.i.c.a(this.f47022g, this.f47021f, "success", null, new d.a.l0.g.c.i.a(this.f47023h));
                }
            } else {
                d.a.l0.g.c.i.c.a(this.f47022g, this.f47021f, "fail", String.valueOf(bVar.c()), new d.a.l0.g.c.i.a(this.f47023h));
            }
        }
        c();
    }
}
