package d.b.h0.n;

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
    public String f50030c;

    /* renamed from: d  reason: collision with root package name */
    public String f50031d;

    /* renamed from: e  reason: collision with root package name */
    public String f50032e;

    /* renamed from: f  reason: collision with root package name */
    public String f50033f;

    /* renamed from: g  reason: collision with root package name */
    public String f50034g;

    /* renamed from: h  reason: collision with root package name */
    public String f50035h;
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
    public b f50028a = new b(this);

    /* renamed from: b  reason: collision with root package name */
    public c f50029b = new c();
    public String i = d.b.h0.o.a.c();
    public String o = "";

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: d  reason: collision with root package name */
        public String f50039d;

        /* renamed from: g  reason: collision with root package name */
        public String f50042g;

        /* renamed from: h  reason: collision with root package name */
        public int f50043h;

        /* renamed from: a  reason: collision with root package name */
        public String f50036a = "Android";

        /* renamed from: b  reason: collision with root package name */
        public String f50037b = Build.VERSION.RELEASE;

        /* renamed from: c  reason: collision with root package name */
        public String f50038c = Build.MANUFACTURER;

        /* renamed from: e  reason: collision with root package name */
        public int f50040e = Build.VERSION.SDK_INT;

        /* renamed from: f  reason: collision with root package name */
        public String f50041f = Build.MODEL;

        public b(r rVar) {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            this.f50042g = windowManager.getDefaultDisplay().getWidth() + "_" + windowManager.getDefaultDisplay().getHeight();
            this.f50043h = appContext.getResources().getDisplayMetrics().densityDpi;
        }
    }

    /* loaded from: classes3.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public String f50044a;

        public c(r rVar) {
            this.f50044a = e.g().r(AppRuntime.getAppContext());
        }
    }

    public r(String str) {
        Context appContext = AppRuntime.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            this.f50030c = packageInfo.versionName;
            this.f50032e = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) AppRuntime.getAppContext().getSystemService("phone");
        if (telephonyManager != null && (Build.VERSION.SDK_INT < 23 || appContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            this.j = telephonyManager.getSimOperator();
        }
        this.f50033f = e.g().n(appContext);
        this.f50034g = e.g().o(appContext);
        this.f50035h = e.g().g();
        this.n = e.g().b();
        this.q = str;
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
        if (e.g() == null) {
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
        l g2 = e.g();
        String str = "";
        if (jSONObject == null || g2 == null) {
            return "";
        }
        try {
            if (g2.h() == 0) {
                str = "swan";
            } else if (g2.h() == 1) {
                str = SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("smartAppId", g2.getAppId());
            jSONObject2.putOpt("smartAppVersion", g2.getAppVersion());
            jSONObject2.putOpt("swanCoreVersion", g2.l());
            jSONObject2.putOpt("swanNativeVersion", g2.b());
            jSONObject2.putOpt("swanType", str);
            jSONObject.putOpt(DI.APP_INFO_NAME, jSONObject2);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }

    public static void d(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 1) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
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
            jSONObject2.putOpt(IAdRequestParam.OS, this.f50028a.f50036a);
            jSONObject2.putOpt("osversion", this.f50028a.f50037b);
            jSONObject2.putOpt("model", this.f50028a.f50041f);
            jSONObject2.putOpt("deviceType", this.f50028a.f50039d);
            jSONObject2.putOpt("sdk", this.f50028a.f50040e + "");
            jSONObject2.putOpt("brand", this.f50028a.f50038c);
            jSONObject2.putOpt("screen", this.f50028a.f50042g);
            jSONObject2.putOpt("density", this.f50028a.f50043h + "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("passId", this.f50029b.f50044a);
            jSONObject.putOpt("userInfo", jSONObject3);
            jSONObject.putOpt("system", jSONObject2);
            jSONObject.putOpt("appVersion", this.f50030c);
            jSONObject.putOpt("appBranch", this.f50031d);
            jSONObject.putOpt("appPackageName", this.f50032e);
            jSONObject.putOpt("cuid", this.f50033f);
            jSONObject.putOpt("uuid", this.f50034g);
            jSONObject.putOpt("hostName", this.f50035h);
            jSONObject.putOpt("net", this.i);
            jSONObject.putOpt("operator", this.j);
            jSONObject.putOpt("smartAppId", this.k);
            jSONObject.putOpt("smartAppVersion", this.l);
            jSONObject.putOpt("swanCoreVersion", this.m);
            jSONObject.putOpt("swanNativeVersion", this.n);
            jSONObject.putOpt("swanType", this.o);
            jSONObject.putOpt("swanId", this.p);
            jSONObject.putOpt("bizId", this.q);
            jSONObject.putOpt("eventType", this.r);
            jSONObject.putOpt("eventName", this.s);
            jSONObject.putOpt("content", this.t);
            jSONObject.putOpt("propagation", this.u);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
