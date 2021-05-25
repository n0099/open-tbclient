package d.a.l0.a.j2.q;

import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.l0.a.a2.d;
import d.a.l0.a.a2.e;
import d.a.l0.a.j2.b;
import d.a.l0.a.j2.k;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.w;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.l0.a.j2.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0725a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43197h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanInterfaceType f43198i;

        public RunnableC0725a(int i2, String str, String str2, String str3, SwanInterfaceType swanInterfaceType) {
            this.f43194e = i2;
            this.f43195f = str;
            this.f43196g = str2;
            this.f43197h = str3;
            this.f43198i = swanInterfaceType;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f43194e;
            boolean z = (i2 == 2000 || i2 == 0) ? false : true;
            String m = k.m(d.g().l());
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.g().getAppId());
            w.f(jSONObject, "hostName", d.a.l0.a.c1.a.m().a());
            w.f(jSONObject, "network", d.a.l0.t.a.e());
            w.f(jSONObject, "launchid", d.g().r().L().V());
            if (z) {
                w.f(jSONObject, "response", this.f43195f);
                w.f(jSONObject, "statusCode", this.f43196g);
                w.f(jSONObject, "request_url", this.f43197h);
            }
            a.d(m, this.f43198i.getClassify(), this.f43198i.getInterfaceName(), this.f43194e, jSONObject, z);
        }
    }

    public static void a(SwanInterfaceType swanInterfaceType) {
        c(swanInterfaceType, 2000, null, null);
    }

    public static void b(SwanInterfaceType swanInterfaceType, int i2, String str, String str2, String str3) {
        q.i(new RunnableC0725a(i2, str3, str2, str, swanInterfaceType), "onInterfaceStabilityStatistic");
    }

    public static void c(SwanInterfaceType swanInterfaceType, int i2, String str, Response response) {
        String str2;
        String str3 = null;
        if (response != null) {
            String valueOf = String.valueOf(response.code());
            str3 = response.request().url().toString();
            str2 = valueOf;
        } else {
            str2 = null;
        }
        b(swanInterfaceType, i2, str3, str2, str);
    }

    public static void d(String str, String str2, String str3, int i2, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", str);
            jSONObject2.put("type", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("page", str3);
            }
            jSONObject2.put("value", String.valueOf(i2));
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            b.k("874", jSONObject2);
            if (z) {
                b.i("2486", "86", jSONObject2);
            }
        } catch (JSONException e2) {
            if (e.y) {
                e2.printStackTrace();
            }
        }
    }
}
