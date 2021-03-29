package d.b.g0.a.r1.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static final boolean o = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public String f45772b;

    /* renamed from: d  reason: collision with root package name */
    public String f45774d;

    /* renamed from: g  reason: collision with root package name */
    public String f45777g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45778h;
    public boolean i;
    public boolean k;
    public String n;
    public boolean l = false;
    public boolean m = false;

    /* renamed from: a  reason: collision with root package name */
    public int f45771a = -16777216;

    /* renamed from: c  reason: collision with root package name */
    public String f45773c = "#ffffff";
    public String j = "default";

    /* renamed from: e  reason: collision with root package name */
    public int f45775e = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45776f = false;

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return d();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return d();
        }
        return c(optJSONObject);
    }

    public static c b(String str, @NonNull c cVar) {
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        try {
            return e(new JSONObject(str), cVar);
        } catch (JSONException e2) {
            if (o) {
                Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e2));
            }
            return cVar;
        }
    }

    public static c c(JSONObject jSONObject) {
        c cVar = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        cVar.f45771a = SwanAppConfigData.s(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.f45773c = optString2;
        cVar.f45772b = jSONObject.optString("navigationBarTitleText");
        cVar.f45774d = jSONObject.optString("backgroundTextStyle", "black");
        cVar.f45775e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
        cVar.f45776f = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.f45777g = jSONObject.optString("onReachBottomDistance");
        cVar.f45778h = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.i = jSONObject.optBoolean("enableOpacityNavigationBarText");
        cVar.j = jSONObject.optString("navigationStyle", "default");
        cVar.k = jSONObject.optBoolean("navigationHomeButtonHidden");
        cVar.n = jSONObject.optString("textSizeAdjust");
        return cVar;
    }

    public static c d() {
        if (o) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new c();
    }

    public static c e(JSONObject jSONObject, @NonNull c cVar) {
        c cVar2 = new c();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        cVar2.f45771a = TextUtils.isEmpty(optString) ? cVar.f45771a : SwanAppConfigData.s(optString);
        cVar2.f45772b = jSONObject.optString("navigationBarTitleText", cVar.f45772b);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.f45773c;
        }
        cVar2.f45773c = optString2;
        cVar2.f45774d = jSONObject.optString("backgroundTextStyle", cVar.f45774d);
        cVar2.f45775e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : cVar.f45775e;
        cVar2.f45776f = jSONObject.optBoolean("enablePullDownRefresh", cVar.f45776f);
        cVar2.f45777g = jSONObject.optString("onReachBottomDistance", cVar.f45777g);
        cVar2.f45778h = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.f45778h);
        cVar2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.i);
        cVar2.j = jSONObject.optString("navigationStyle", cVar.j);
        cVar2.k = jSONObject.optBoolean("navigationHomeButtonHidden", cVar.k);
        cVar2.l = jSONObject.optBoolean("disableSwipeBack", false);
        jSONObject.optBoolean("pageFavoriteEnable", true);
        return cVar2;
    }

    public static boolean f(c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.f45778h || TextUtils.equals(cVar.j, "custom");
    }

    public void g(boolean z) {
        if (!z || this.m) {
            return;
        }
        this.m = true;
    }
}
