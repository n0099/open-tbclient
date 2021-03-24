package d.b.g0.a.d1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.i.n;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43825a = k.f45050a;

    /* renamed from: d.b.g0.a.d1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0642a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43826e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f43827f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43828g;

        public RunnableC0642a(Context context, SwanAppActionBar swanAppActionBar, String str) {
            this.f43826e = context;
            this.f43827f = swanAppActionBar;
            this.f43828g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e(this.f43826e, this.f43827f, this.f43828g);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f43830f;

        public b(JSONObject jSONObject, SwanAppActionBar swanAppActionBar) {
            this.f43829e = jSONObject;
            this.f43830f = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.l(this.f43830f, a.k(this.f43829e));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f43832f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43833g;

        public c(Context context, n nVar, String str) {
            this.f43831e = context;
            this.f43832f = nVar;
            this.f43833g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(this.f43831e, this.f43832f, this.f43833g);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f43834e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f43835f;

        public d(JSONArray jSONArray, n nVar) {
            this.f43834e = jSONArray;
            this.f43835f = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length = this.f43834e.length();
            if (this.f43834e == null || length == 0) {
                return;
            }
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = this.f43834e.optJSONObject(i);
                if (optJSONObject != null) {
                    this.f43835f.v(optJSONObject);
                    a.d(optJSONObject);
                }
            }
            this.f43835f.i();
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject != null && Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() > 0) {
            int optInt = jSONObject.optInt("pa_type");
            String str = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? "" : "message" : PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : ErrorContentResponse.Operations.NOTICE : LightappBusinessClient.MTD_CUSTOMER_SERVICE;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b.g0.a.c1.a.r(str, "1", "show");
        }
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject b2 = d.b.g0.a.w0.a.g().b(context, str);
        if (b2 == null || swanAppActionBar == null) {
            return;
        }
        d.b.g0.a.r1.d.g().post(new b(b2, swanAppActionBar));
    }

    public static void f(Context context, n nVar, String str) {
        JSONObject b2 = d.b.g0.a.w0.a.g().b(context, str);
        if (b2 == null || nVar == null) {
            return;
        }
        k(b2);
        d.b.g0.a.r1.d.g().post(new d(b2.optJSONArray("un_read_list"), nVar));
    }

    public static boolean g(boolean z) {
        if (e.O() == null) {
            return false;
        }
        e O = e.O();
        PMSAppInfo c0 = e.O().J().c0();
        if (O.i0() || c0 == null || TextUtils.isEmpty(c0.paNumber)) {
            return false;
        }
        return z || O.H().d("key_unread_counts_message", 0).intValue() <= 0;
    }

    public static void h() {
        if (e.O() != null) {
            e.O().H().i("key_unread_counts_message", 0);
        }
    }

    public static void i(Context context, SwanAppActionBar swanAppActionBar, String str) {
        ExecutorUtilsExt.postOnElastic(new RunnableC0642a(context, swanAppActionBar, str), "getRefreshTips", 1);
    }

    public static void j(Context context, n nVar, String str) {
        ExecutorUtilsExt.postOnElastic(new c(context, nVar, str), "getMenuToolRefreshTips", 1);
    }

    public static int k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("un_read_list");
        int length = optJSONArray.length();
        if (optJSONArray == null || length == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            int optInt = optJSONObject.optInt("pa_type");
            if (optInt == 7) {
                i += optJSONObject.optInt("pa_unread_sums");
            }
            if (k0.L() && (optInt == 27 || optInt == 17)) {
                i += optJSONObject.optInt("pa_unread_sums");
            }
        }
        if (i == 0) {
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                int optInt2 = optJSONObject2.optInt("pa_type");
                if (optInt2 == 888 || optInt2 == 666 || optInt2 == 999) {
                    i += optJSONObject2.optInt("pa_unread_sums");
                }
            }
        }
        if (e.O() != null) {
            e.O().H().i("key_unread_counts_message", Integer.valueOf(i));
        }
        return i;
    }

    public static void l(SwanAppActionBar swanAppActionBar, int i) {
        if (f43825a) {
            Log.i("messageRefresh", "update_red_dots:" + i);
        }
        if (swanAppActionBar != null) {
            swanAppActionBar.setRightRedDotVisibility(i > 0);
        }
    }
}
