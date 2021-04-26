package d.a.h0.l.l;

import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import d.a.h0.l.l.f;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class g implements StatResponseCallback<String> {

    /* renamed from: a  reason: collision with root package name */
    public final f.a f47166a;

    public g(f.a aVar) {
        this.f47166a = aVar;
    }

    public final boolean a() {
        return this.f47166a != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: b */
    public void onSuccess(String str, int i2) {
        if (a()) {
            this.f47166a.b(str, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: c */
    public String parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
        String str;
        String str2 = "";
        if (response == null || response.body() == null) {
            str = "";
        } else {
            str2 = response.request().url().toString();
            str = response.body().string();
        }
        if (a()) {
            this.f47166a.a(str2, str, networkStatRecord.toUBCJson());
        }
        return str;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onFail(Exception exc) {
        if (a()) {
            this.f47166a.onFail(exc);
        }
    }
}
