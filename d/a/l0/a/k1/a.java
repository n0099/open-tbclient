package d.a.l0.a.k1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import d.a.l0.k.n;
import d.a.l0.k.o;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f46884a = k.f46875a;

    /* renamed from: d.a.l0.a.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0783a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46885e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f46886f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46887g;

        public RunnableC0783a(Context context, SwanAppActionBar swanAppActionBar, String str) {
            this.f46885e = context;
            this.f46886f = swanAppActionBar;
            this.f46887g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e(this.f46885e, this.f46886f, this.f46887g);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46888e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f46889f;

        public b(JSONObject jSONObject, SwanAppActionBar swanAppActionBar) {
            this.f46888e = jSONObject;
            this.f46889f = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.o(this.f46889f, a.n(this.f46888e));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f46891f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46892g;

        public c(Context context, n nVar, String str) {
            this.f46890e = context;
            this.f46891f = nVar;
            this.f46892g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(this.f46890e, this.f46891f, this.f46892g);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f46894f;

        public d(JSONArray jSONArray, n nVar) {
            this.f46893e = jSONArray;
            this.f46894f = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray jSONArray = this.f46893e;
            int length = jSONArray == null ? 0 : jSONArray.length();
            if (length == 0) {
                return;
            }
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = this.f46893e.optJSONObject(i2);
                if (optJSONObject != null) {
                    this.f46894f.v(optJSONObject);
                    a.d(optJSONObject);
                }
            }
            this.f46894f.h();
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject != null && Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() > 0) {
            int optInt = jSONObject.optInt("pa_type");
            String str = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? "" : "message" : PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : ErrorContentResponse.Operations.NOTICE : LightappBusinessClient.MTD_CUSTOMER_SERVICE;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.l0.a.j1.a.q(str, "1", "show");
        }
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2 = d.a.l0.a.c1.a.h().c(context, str);
        if (c2 == null || swanAppActionBar == null) {
            return;
        }
        d.a.l0.a.a2.d.i().post(new b(c2, swanAppActionBar));
    }

    public static void f(Context context, n nVar, String str) {
        JSONObject c2 = d.a.l0.a.c1.a.h().c(context, str);
        if (c2 == null || nVar == null) {
            return;
        }
        m(c2, nVar);
    }

    public static int g() {
        return d.a.l0.a.a2.d.g().r().J().d("key_unread_counts_message", 0).intValue();
    }

    public static int h(Context context) {
        JSONArray optJSONArray;
        e r = d.a.l0.a.a2.d.g().r();
        if (r == null || r.L() == null || r.L().f0() == null) {
            return 0;
        }
        JSONObject c2 = d.a.l0.a.c1.a.h().c(context, r.L().f0().paNumber);
        if (c2 == null || (optJSONArray = c2.optJSONArray("un_read_list")) == null || optJSONArray.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null && optJSONObject.optInt("pa_type") == 888) {
                i2 += optJSONObject.optInt("pa_unread_sums");
            }
        }
        return i2;
    }

    public static void i() {
        if (e.Q() != null) {
            e.Q().J().i("key_unread_counts_message", 0);
        }
    }

    public static void j(o oVar) {
        if (e.Q() != null) {
            e.Q().J().i("key_unread_counts_message", Integer.valueOf(Math.max((int) (e.Q().J().d("key_unread_counts_message", 0).intValue() - oVar.e()), 0)));
        }
    }

    public static void k(Context context, SwanAppActionBar swanAppActionBar, String str) {
        d.a.l0.a.r1.k.i.c.f().e(new RunnableC0783a(context, swanAppActionBar, str), "getRefreshTips");
    }

    public static void l(Context context, n nVar, String str) {
        ExecutorUtilsExt.postOnElastic(new c(context, nVar, str), "getMenuToolRefreshTips", 1);
    }

    public static void m(JSONObject jSONObject, n nVar) {
        n(jSONObject);
        d.a.l0.a.a2.d.i().post(new d(jSONObject.optJSONArray("un_read_list"), nVar));
    }

    public static int n(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("un_read_list")) == null || optJSONArray.length() == 0) {
            return 0;
        }
        int length = optJSONArray.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            int optInt = optJSONObject.optInt("pa_type");
            if (optInt == 7) {
                i2 += optJSONObject.optInt("pa_unread_sums");
            }
            if (q0.Q() && (optInt == 27 || optInt == 17)) {
                i2 += optJSONObject.optInt("pa_unread_sums");
            }
        }
        if (i2 == 0) {
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                int optInt2 = optJSONObject2.optInt("pa_type");
                if (optInt2 == 888 || optInt2 == 666 || optInt2 == 999) {
                    i2 += optJSONObject2.optInt("pa_unread_sums");
                }
            }
        }
        if (e.Q() != null) {
            e.Q().J().i("key_unread_counts_message", Integer.valueOf(i2));
        }
        return i2;
    }

    public static void o(SwanAppActionBar swanAppActionBar, int i2) {
        if (f46884a) {
            Log.i("messageRefresh", "update_red_dots:" + i2);
        }
        if (swanAppActionBar != null) {
            swanAppActionBar.setRightRedDotVisibility(i2 > 0);
        }
    }
}
