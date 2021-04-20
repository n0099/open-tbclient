package d.b.g0.l.l;

import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import d.b.g0.l.l.f;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class g implements StatResponseCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    public final f.a f49327a;

    public g(f.a aVar) {
        this.f49327a = aVar;
    }

    public final boolean a() {
        return this.f49327a != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public void onSuccess(String str, int i) {
        if (a()) {
            this.f49327a.b(str, i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: c */
    public String parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
        String str;
        String str2 = "";
        if (response == null || response.body() == null) {
            str = "";
        } else {
            str2 = response.request().url().toString();
            str = response.body().string();
        }
        if (a()) {
            this.f49327a.a(str2, str, networkStatRecord.toUBCJson());
        }
        return str;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        if (a()) {
            this.f49327a.onFail(exc);
        }
    }
}
