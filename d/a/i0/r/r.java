package d.a.i0.r;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    public String f48288c;

    /* renamed from: d  reason: collision with root package name */
    public String f48289d;

    /* renamed from: e  reason: collision with root package name */
    public String f48290e;

    /* renamed from: f  reason: collision with root package name */
    public String f48291f;

    /* renamed from: g  reason: collision with root package name */
    public String f48292g;

    /* renamed from: h  reason: collision with root package name */
    public String f48293h;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;

    /* renamed from: a  reason: collision with root package name */
    public a f48286a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    public b f48287b = new b(this);

    /* renamed from: i  reason: collision with root package name */
    public String f48294i = d.a.i0.s.a.c();
    public String o = "";

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: d  reason: collision with root package name */
        public String f48298d;

        /* renamed from: g  reason: collision with root package name */
        public String f48301g;

        /* renamed from: h  reason: collision with root package name */
        public int f48302h;

        /* renamed from: a  reason: collision with root package name */
        public String f48295a = "Android";

        /* renamed from: b  reason: collision with root package name */
        public String f48296b = Build.VERSION.RELEASE;

        /* renamed from: c  reason: collision with root package name */
        public String f48297c = Build.MANUFACTURER;

        /* renamed from: e  reason: collision with root package name */
        public int f48299e = Build.VERSION.SDK_INT;

        /* renamed from: f  reason: collision with root package name */
        public String f48300f = Build.MODEL;

        public a(r rVar) {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.f48301g = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.f48302h = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* loaded from: classes3.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f48303a = e.h().w(AppRuntime.getAppContext());

        public b(r rVar) {
        }
    }

    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.f48288c = packageInfo.versionName;
            this.f48290e = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.j = telephonyManager.getSimOperator();
        }
        this.f48291f = e.h().t(appContext);
        this.f48292g = e.h().p(appContext);
        this.f48293h = e.h().a();
        this.n = e.h().b();
        this.q = e.h().u();
        this.r = str;
    }

    public static void a(JSONObject jSONObject) {
        JSONObject e2 = new r(jSONObject.optString("bizId")).e();
        Iterator<String> keys = e2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.has(next)) {
                try {
                    jSONObject.putOpt(next, e2.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static String b(String str) {
        JSONObject jSONObject;
        if (e.h() == null) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            return c(jSONObject);
        } catch (JSONException unused) {
            return str;
        }
    }

    public static String c(JSONObject jSONObject) {
        l h2 = e.h();
        String str = "";
        if (jSONObject == null || h2 == null) {
            return "";
        }
        try {
            if (h2.l() == 0) {
                str = "swan";
            } else if (h2.l() == 1) {
                str = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", h2.getAppId());
            jSONObject2.putOpt("smartAppVersion", h2.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", h2.n());
            jSONObject2.putOpt("swanNativeVersion", h2.b());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt(DI.APP_INFO_NAME, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("source", h2.k());
            jSONObject.put("propagation", jSONObject3);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }

    public static void d(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 1) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                JSONObject jSONObject3 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.putOpt(next, jSONObject3.optString(next));
                }
                jSONObject2.remove(DI.APP_INFO_NAME);
            } catch (JSONException unused) {
            }
        }
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(IAdRequestParam.OS, this.f48286a.f48295a);
            jSONObject2.putOpt("osversion", this.f48286a.f48296b);
            jSONObject2.putOpt("model", this.f48286a.f48300f);
            jSONObject2.putOpt("deviceType", this.f48286a.f48298d);
            jSONObject2.putOpt("sdk", this.f48286a.f48299e + "");
            jSONObject2.putOpt("brand", this.f48286a.f48297c);
            jSONObject2.putOpt("screen", this.f48286a.f48301g);
            jSONObject2.putOpt("density", this.f48286a.f48302h + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.f48287b.f48303a);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.f48288c);
            jSONObject.putOpt("appBranch", this.f48289d);
            jSONObject.putOpt("appPackageName", this.f48290e);
            jSONObject.putOpt("cuid", this.f48291f);
            jSONObject.putOpt("uuid", this.f48292g);
            jSONObject.putOpt("hostName", this.f48293h);
            jSONObject.putOpt("net", this.f48294i);
            jSONObject.putOpt("operator", this.j);
            jSONObject.putOpt("smartAppId", this.k);
            jSONObject.putOpt("smartAppVersion", this.l);
            jSONObject.putOpt("swanCoreVersion", this.m);
            jSONObject.putOpt("swanNativeVersion", this.n);
            jSONObject.putOpt("swanType", this.o);
            jSONObject.putOpt("swanId", this.p);
            jSONObject.putOpt("bizId", this.r);
            jSONObject.putOpt("eventType", this.s);
            jSONObject.putOpt("eventName", this.t);
            jSONObject.putOpt("content", this.u);
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.putOpt("appClientId", this.q);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
