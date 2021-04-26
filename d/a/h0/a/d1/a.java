package d.a.h0.a.d1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.i.n;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41842a = k.f43101a;

    /* renamed from: d.a.h0.a.d1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0614a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f41844f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41845g;

        public RunnableC0614a(Context context, SwanAppActionBar swanAppActionBar, String str) {
            this.f41843e = context;
            this.f41844f = swanAppActionBar;
            this.f41845g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e(this.f41843e, this.f41844f, this.f41845g);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f41846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f41847f;

        public b(JSONObject jSONObject, SwanAppActionBar swanAppActionBar) {
            this.f41846e = jSONObject;
            this.f41847f = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.l(this.f41847f, a.k(this.f41846e));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41848e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f41849f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41850g;

        public c(Context context, n nVar, String str) {
            this.f41848e = context;
            this.f41849f = nVar;
            this.f41850g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(this.f41848e, this.f41849f, this.f41850g);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f41851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f41852f;

        public d(JSONArray jSONArray, n nVar) {
            this.f41851e = jSONArray;
            this.f41852f = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length = this.f41851e.length();
            if (this.f41851e == null || length == 0) {
                return;
            }
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = this.f41851e.optJSONObject(i2);
                if (optJSONObject != null) {
                    this.f41852f.v(optJSONObject);
                    a.d(optJSONObject);
                }
            }
            this.f41852f.i();
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject != null && Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() > 0) {
            int optInt = jSONObject.optInt("pa_type");
            String str = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? "" : "message" : PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : ErrorContentResponse.Operations.NOTICE : LightappBusinessClient.MTD_CUSTOMER_SERVICE;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.a.h0.a.c1.a.r(str, "1", "show");
        }
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2 = d.a.h0.a.w0.a.g().c(context, str);
        if (c2 == null || swanAppActionBar == null) {
            return;
        }
        d.a.h0.a.r1.d.g().post(new b(c2, swanAppActionBar));
    }

    public static void f(Context context, n nVar, String str) {
        JSONObject c2 = d.a.h0.a.w0.a.g().c(context, str);
        if (c2 == null || nVar == null) {
            return;
        }
        k(c2);
        d.a.h0.a.r1.d.g().post(new d(c2.optJSONArray("un_read_list"), nVar));
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
        ExecutorUtilsExt.postOnElastic(new RunnableC0614a(context, swanAppActionBar, str), "getRefreshTips", 1);
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
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            int optInt = optJSONObject.optInt("pa_type");
            if (optInt == 7) {
                i2 += optJSONObject.optInt("pa_unread_sums");
            }
            if (k0.L() && (optInt == 27 || optInt == 17)) {
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
        if (e.O() != null) {
            e.O().H().i("key_unread_counts_message", Integer.valueOf(i2));
        }
        return i2;
    }

    public static void l(SwanAppActionBar swanAppActionBar, int i2) {
        if (f41842a) {
            Log.i("messageRefresh", "update_red_dots:" + i2);
        }
        if (swanAppActionBar != null) {
            swanAppActionBar.setRightRedDotVisibility(i2 > 0);
        }
    }
}
