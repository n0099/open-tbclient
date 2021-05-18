package d.a.i0.a.j2.q;

import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.i0.a.a2.d;
import d.a.i0.a.a2.e;
import d.a.i0.a.j2.b;
import d.a.i0.a.j2.k;
import d.a.i0.a.v2.q;
import d.a.i0.a.v2.w;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.i0.a.j2.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0714a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f43020e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43021f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43022g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43023h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanInterfaceType f43024i;

        public RunnableC0714a(int i2, String str, String str2, String str3, SwanInterfaceType swanInterfaceType) {
            this.f43020e = i2;
            this.f43021f = str;
            this.f43022g = str2;
            this.f43023h = str3;
            this.f43024i = swanInterfaceType;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.f43020e;
            boolean z = (i2 == 2000 || i2 == 0) ? false : true;
            String m = k.m(d.g().l());
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.g().getAppId());
            w.f(jSONObject, "hostName", d.a.i0.a.c1.a.m().a());
            w.f(jSONObject, "network", d.a.i0.t.a.e());
            w.f(jSONObject, "launchid", d.g().r().L().V());
            if (z) {
                w.f(jSONObject, "response", this.f43021f);
                w.f(jSONObject, "statusCode", this.f43022g);
                w.f(jSONObject, "request_url", this.f43023h);
            }
            a.d(m, this.f43024i.getClassify(), this.f43024i.getInterfaceName(), this.f43020e, jSONObject, z);
        }
    }

    public static void a(SwanInterfaceType swanInterfaceType) {
        c(swanInterfaceType, 2000, null, null);
    }

    public static void b(SwanInterfaceType swanInterfaceType, int i2, String str, String str2, String str3) {
        q.i(new RunnableC0714a(i2, str3, str2, str, swanInterfaceType), "onInterfaceStabilityStatistic");
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
