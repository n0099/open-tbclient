package d.a.l0.h.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50822a;

        public a(c cVar) {
            this.f50822a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject b2 = e.b(str, this.f50822a);
                if (b2 == null) {
                    return;
                }
                this.f50822a.onSuccess(g.a(b2));
                return;
            }
            this.f50822a.onFail("response is null");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f50822a.onFail(exc.getMessage());
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50823a;

        public b(c cVar) {
            this.f50823a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject b2 = e.b(str, this.f50823a);
                if (b2 == null) {
                    return;
                }
                this.f50823a.onSuccess(f.a(b2));
                return;
            }
            this.f50823a.onFail("response is null");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f50823a.onFail(exc.getMessage());
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
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            cVar.onFail("swan app is null");
            return;
        }
        d.a.l0.h.y.b.c().getRequest().cookieManager(d.a.l0.a.c1.a.p().a()).url(d.a.l0.h.t.a.b().h()).addUrlParam("appkey", Q.D()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).requestFrom(16).requestSubFrom(1601).build().executeAsync(new b(cVar));
    }

    public static void d(long j, c cVar) {
        if (cVar == null) {
            return;
        }
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            cVar.onFail("swan app is null");
            return;
        }
        d.a.l0.h.y.b.c().getRequest().cookieManager(d.a.l0.a.c1.a.p().a()).url(d.a.l0.h.t.a.b().g()).addUrlParam("appkey", Q.D()).addUrlParam("duration", String.valueOf(j)).requestFrom(16).requestSubFrom(1601).build().executeAsync(new a(cVar));
    }
}
