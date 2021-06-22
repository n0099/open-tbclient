package d.a.m0.c.a.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import d.a.m0.c.a.f;
import d.a.m0.c.a.k.c;
import d.a.m0.n.i.e;
import d.a.m0.n.i.g;
import java.io.IOException;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e<String> {

    /* renamed from: e  reason: collision with root package name */
    public final g.a f50248e;

    public a(g.a aVar) {
        this.f50248e = aVar;
    }

    @Override // d.a.m0.n.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        if (c()) {
            this.f50248e.a(str, str2, jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public void onSuccess(String str, int i2) {
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "BdtlsPmsRequest onSuccess=" + str);
        }
        if (this.f50248e == null) {
            return;
        }
        d.a.m0.c.a.g l = d.a.m0.c.a.g.l();
        if (TextUtils.equals(str, "recovery")) {
            if (l.m().b()) {
                l.m().a();
                l.f50243d.i(true);
                c cVar = l.f50243d;
                if (cVar instanceof d.a.m0.c.a.k.a) {
                    ((d.a.m0.c.a.k.a) cVar).j();
                    return;
                }
                return;
            }
            this.f50248e.onFail(new Exception("Exceeded the limit of continuous downgrade"));
            return;
        }
        l.m().k();
        c cVar2 = l.f50243d;
        if (cVar2 instanceof d.a.m0.c.a.k.a) {
            d.a.m0.c.a.k.a aVar = (d.a.m0.c.a.k.a) cVar2;
            if (l.k()) {
                if (l.f50243d.f50287b == 1) {
                    f.a("application");
                    this.f50248e.b(str, i2);
                    aVar.f50278h = 0;
                    return;
                }
                int i3 = aVar.f50278h;
                aVar.f50278h = i3 + 1;
                if (i3 < 3) {
                    aVar.j();
                    return;
                }
                g.a aVar2 = this.f50248e;
                aVar2.onFail(new IOException("request fail : " + str));
                aVar.f50278h = 0;
                return;
            }
            this.f50248e.b(str, i2);
            aVar.f50278h = 0;
        }
    }

    public final boolean c() {
        return this.f50248e != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: d */
    public String parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
        String string;
        if (response == null || response.body() == null) {
            return "";
        }
        d.a.m0.c.a.g l = d.a.m0.c.a.g.l();
        if (TextUtils.equals(response.headers().get("Bdtls"), "recovery")) {
            l.m().s(0);
            return "recovery";
        }
        if (l.k()) {
            string = l.f50243d.g(response.body().bytes());
            if (d.a.m0.c.a.a.f50231a) {
                Log.d("BDTLS", "BdtlsPmsRequest parseResponse=" + string);
            }
        } else {
            string = response.body().string();
        }
        a(String.valueOf(response.request().url()), string, networkStatRecord.toUBCJson());
        return string;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        if (d.a.m0.c.a.a.f50231a) {
            Log.d("BDTLS", "BdtlsPmsRequest onFail = " + exc.getMessage());
        }
        if (c()) {
            this.f50248e.onFail(exc);
        }
    }

    @Override // d.a.m0.n.i.g.a
    public void onStart() {
        if (c()) {
            this.f50248e.onStart();
        }
    }
}
