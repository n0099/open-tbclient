package d.b.g0.g.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f47903a;

        public a(c cVar) {
            this.f47903a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject b2 = e.b(str, this.f47903a);
                if (b2 == null) {
                    return;
                }
                this.f47903a.onSuccess(g.a(b2));
                return;
            }
            this.f47903a.onFail("response is null");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47903a.onFail(exc.getMessage());
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f47904a;

        public b(c cVar) {
            this.f47904a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject b2 = e.b(str, this.f47904a);
                if (b2 == null) {
                    return;
                }
                this.f47904a.onSuccess(f.a(b2));
                return;
            }
            this.f47904a.onFail("response is null");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47904a.onFail(exc.getMessage());
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public static JSONObject b(String str, c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("errno", -1) != 0) {
                cVar.onFail(jSONObject.optString("errmsg"));
                return null;
            }
            return jSONObject.optJSONObject("data");
        } catch (Exception e2) {
            cVar.onFail(e2.getMessage());
            return null;
        }
    }

    public static void c(String str, c cVar) {
        if (cVar == null) {
            return;
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            cVar.onFail("swan app is null");
            return;
        }
        d.b.g0.g.w.b.c().getRequest().cookieManager(d.b.g0.a.w0.a.m().a()).url(d.b.g0.a.w0.a.l().G()).addUrlParam("appkey", O.B()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).build().executeAsync(new b(cVar));
    }

    public static void d(long j, c cVar) {
        if (cVar == null) {
            return;
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            cVar.onFail("swan app is null");
            return;
        }
        d.b.g0.g.w.b.c().getRequest().cookieManager(d.b.g0.a.w0.a.m().a()).url(d.b.g0.a.w0.a.l().A()).addUrlParam("appkey", O.B()).addUrlParam("duration", String.valueOf(j)).build().executeAsync(new a(cVar));
    }
}
