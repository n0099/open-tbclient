package d.b.h0.a.d1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.i.n;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f44547a = k.f45772a;

    /* renamed from: d.b.h0.a.d1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0675a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f44549f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44550g;

        public RunnableC0675a(Context context, SwanAppActionBar swanAppActionBar, String str) {
            this.f44548e = context;
            this.f44549f = swanAppActionBar;
            this.f44550g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.e(this.f44548e, this.f44549f, this.f44550g);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActionBar f44552f;

        public b(JSONObject jSONObject, SwanAppActionBar swanAppActionBar) {
            this.f44551e = jSONObject;
            this.f44552f = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.l(this.f44552f, a.k(this.f44551e));
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f44554f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44555g;

        public c(Context context, n nVar, String str) {
            this.f44553e = context;
            this.f44554f = nVar;
            this.f44555g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(this.f44553e, this.f44554f, this.f44555g);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44556e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f44557f;

        public d(JSONArray jSONArray, n nVar) {
            this.f44556e = jSONArray;
            this.f44557f = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length = this.f44556e.length();
            if (this.f44556e == null || length == 0) {
                return;
            }
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = this.f44556e.optJSONObject(i);
                if (optJSONObject != null) {
                    this.f44557f.v(optJSONObject);
                    a.d(optJSONObject);
                }
            }
            this.f44557f.i();
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject != null && Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() > 0) {
            int optInt = jSONObject.optInt("pa_type");
            String str = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? "" : "message" : PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : ErrorContentResponse.Operations.NOTICE : LightappBusinessClient.MTD_CUSTOMER_SERVICE;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b.h0.a.c1.a.r(str, "1", "show");
        }
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject b2 = d.b.h0.a.w0.a.g().b(context, str);
        if (b2 == null || swanAppActionBar == null) {
            return;
        }
        d.b.h0.a.r1.d.g().post(new b(b2, swanAppActionBar));
    }

    public static void f(Context context, n nVar, String str) {
        JSONObject b2 = d.b.h0.a.w0.a.g().b(context, str);
        if (b2 == null || nVar == null) {
            return;
        }
        k(b2);
        d.b.h0.a.r1.d.g().post(new d(b2.optJSONArray("un_read_list"), nVar));
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
        ExecutorUtilsExt.postOnElastic(new RunnableC0675a(context, swanAppActionBar, str), "getRefreshTips", 1);
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
        if (f44547a) {
            Log.i("messageRefresh", "update_red_dots:" + i);
        }
        if (swanAppActionBar != null) {
            swanAppActionBar.setRightRedDotVisibility(i > 0);
        }
    }
}
