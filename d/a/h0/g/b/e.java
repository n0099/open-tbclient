package d.a.h0.g.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    public static class a extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f46089a;

        public a(c cVar) {
            this.f46089a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject b2 = e.b(str, this.f46089a);
                if (b2 == null) {
                    return;
                }
                this.f46089a.onSuccess(g.a(b2));
                return;
            }
            this.f46089a.onFail("response is null");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f46089a.onFail(exc.getMessage());
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends StringResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f46090a;

        public b(c cVar) {
            this.f46090a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject b2 = e.b(str, this.f46090a);
                if (b2 == null) {
                    return;
                }
                this.f46090a.onSuccess(f.a(b2));
                return;
            }
            this.f46090a.onFail("response is null");
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f46090a.onFail(exc.getMessage());
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
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            cVar.onFail("swan app is null");
            return;
        }
        d.a.h0.g.w.b.c().getRequest().cookieManager(d.a.h0.a.w0.a.m().a()).url(d.a.h0.a.w0.a.l().p()).addUrlParam("appkey", O.B()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).build().executeAsync(new b(cVar));
    }

    public static void d(long j, c cVar) {
        if (cVar == null) {
            return;
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            cVar.onFail("swan app is null");
            return;
        }
        d.a.h0.g.w.b.c().getRequest().cookieManager(d.a.h0.a.w0.a.m().a()).url(d.a.h0.a.w0.a.l().m()).addUrlParam("appkey", O.B()).addUrlParam("duration", String.valueOf(j)).build().executeAsync(new a(cVar));
    }
}
