package d.a.i0.n.i;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import d.a.i0.n.i.g;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends e<String> {

    /* renamed from: e  reason: collision with root package name */
    public final g.a f47855e;

    public h(g.a aVar) {
        this.f47855e = aVar;
    }

    @Override // d.a.i0.n.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        if (c()) {
            this.f47855e.a(str, str2, jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public void onSuccess(String str, int i2) {
        if (c()) {
            this.f47855e.b(str, i2);
        }
    }

    public final boolean c() {
        return this.f47855e != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: d */
    public String parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
        String str;
        String str2 = "";
        if (response == null || response.body() == null) {
            str = "";
        } else {
            str2 = response.request().url().toString();
            str = response.body().string();
        }
        a(str2, str, networkStatRecord.toUBCJson());
        return str;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        if (c()) {
            this.f47855e.onFail(exc);
        }
    }

    @Override // d.a.i0.n.i.g.a
    public void onStart() {
        if (c()) {
            this.f47855e.onStart();
        }
    }
}
