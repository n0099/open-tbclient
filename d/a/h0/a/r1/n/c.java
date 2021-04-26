package d.a.h0.a.r1.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.k;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static final boolean o = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public String f43857b;

    /* renamed from: d  reason: collision with root package name */
    public String f43859d;

    /* renamed from: g  reason: collision with root package name */
    public String f43862g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43863h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43864i;
    public boolean k;
    public String n;
    public boolean l = false;
    public boolean m = false;

    /* renamed from: a  reason: collision with root package name */
    public int f43856a = -16777216;

    /* renamed from: c  reason: collision with root package name */
    public String f43858c = "#ffffff";
    public String j = "default";

    /* renamed from: e  reason: collision with root package name */
    public int f43860e = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43861f = false;

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
        cVar.f43856a = SwanAppConfigData.s(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        cVar.f43858c = optString2;
        cVar.f43857b = jSONObject.optString("navigationBarTitleText");
        cVar.f43859d = jSONObject.optString("backgroundTextStyle", "black");
        cVar.f43860e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
        cVar.f43861f = jSONObject.optBoolean("enablePullDownRefresh");
        cVar.f43862g = jSONObject.optString("onReachBottomDistance");
        cVar.f43863h = jSONObject.optBoolean("enableOpacityNavigationBar");
        cVar.f43864i = jSONObject.optBoolean("enableOpacityNavigationBarText");
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
        cVar2.f43856a = TextUtils.isEmpty(optString) ? cVar.f43856a : SwanAppConfigData.s(optString);
        cVar2.f43857b = jSONObject.optString("navigationBarTitleText", cVar.f43857b);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = cVar.f43858c;
        }
        cVar2.f43858c = optString2;
        cVar2.f43859d = jSONObject.optString("backgroundTextStyle", cVar.f43859d);
        cVar2.f43860e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : cVar.f43860e;
        cVar2.f43861f = jSONObject.optBoolean("enablePullDownRefresh", cVar.f43861f);
        cVar2.f43862g = jSONObject.optString("onReachBottomDistance", cVar.f43862g);
        cVar2.f43863h = jSONObject.optBoolean("enableOpacityNavigationBar", cVar.f43863h);
        cVar2.f43864i = jSONObject.optBoolean("enableOpacityNavigationBarText", cVar.f43864i);
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
        return cVar.f43863h || TextUtils.equals(cVar.j, SchedulerSupport.CUSTOM);
    }

    public void g(boolean z) {
        if (!z || this.m) {
            return;
        }
        this.m = true;
    }
}
