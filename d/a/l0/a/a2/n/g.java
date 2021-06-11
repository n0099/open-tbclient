package d.a.l0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.k;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public static final boolean r = k.f46875a;
    public static final f<g> s = new a();
    public static final e<g> t = new b();

    /* renamed from: b  reason: collision with root package name */
    public String f44469b;

    /* renamed from: d  reason: collision with root package name */
    public String f44471d;

    /* renamed from: g  reason: collision with root package name */
    public String f44474g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44475h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f44476i;
    public boolean k;
    public String q;
    public boolean l = false;
    public boolean m = false;
    public boolean n = true;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: a  reason: collision with root package name */
    public int f44468a = -16777216;

    /* renamed from: c  reason: collision with root package name */
    public String f44470c = "#ffffff";
    public String j = "default";

    /* renamed from: e  reason: collision with root package name */
    public int f44472e = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44473f = false;

    /* loaded from: classes3.dex */
    public static class a extends f<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull g gVar, @NonNull d.a.l0.a.b1.d dVar) throws Exception {
            dVar.writeInt(gVar.f44468a);
            dVar.n(gVar.f44469b);
            dVar.n(gVar.f44470c);
            dVar.n(gVar.f44471d);
            dVar.writeInt(gVar.f44472e);
            dVar.writeBoolean(gVar.f44473f);
            dVar.n(gVar.f44474g);
            dVar.writeBoolean(gVar.f44475h);
            dVar.writeBoolean(gVar.f44476i);
            dVar.n(gVar.j);
            dVar.writeBoolean(gVar.k);
            dVar.writeBoolean(gVar.l);
            dVar.writeBoolean(gVar.m);
            dVar.writeBoolean(gVar.n);
            dVar.writeBoolean(gVar.o);
            dVar.writeBoolean(gVar.p);
            dVar.n(gVar.q);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends e<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.a2.n.e
        /* renamed from: c */
        public g b(@NonNull d.a.l0.a.b1.c cVar) throws Exception {
            g gVar = new g();
            gVar.f44468a = cVar.readInt();
            gVar.f44469b = cVar.s();
            gVar.f44470c = cVar.s();
            gVar.f44471d = cVar.s();
            gVar.f44472e = cVar.readInt();
            gVar.f44473f = cVar.readBoolean();
            gVar.f44474g = cVar.s();
            gVar.f44475h = cVar.readBoolean();
            gVar.f44476i = cVar.readBoolean();
            gVar.j = cVar.s();
            gVar.k = cVar.readBoolean();
            gVar.l = cVar.readBoolean();
            gVar.m = cVar.readBoolean();
            gVar.n = cVar.readBoolean();
            gVar.o = cVar.readBoolean();
            gVar.p = cVar.readBoolean();
            gVar.q = cVar.s();
            return gVar;
        }
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return d();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            return d();
        }
        return c(optJSONObject);
    }

    public static g b(String str, @NonNull g gVar) {
        if (TextUtils.isEmpty(str)) {
            return gVar;
        }
        try {
            return e(new JSONObject(str), gVar);
        } catch (JSONException e2) {
            if (r) {
                Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e2));
            }
            return gVar;
        }
    }

    public static g c(JSONObject jSONObject) {
        g gVar = new g();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            optString = "#000000";
        }
        gVar.f44468a = SwanAppConfigData.s(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        gVar.f44470c = optString2;
        gVar.f44469b = jSONObject.optString("navigationBarTitleText");
        gVar.f44471d = jSONObject.optString("backgroundTextStyle", "black");
        gVar.f44472e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
        gVar.f44473f = jSONObject.optBoolean("enablePullDownRefresh");
        gVar.f44474g = jSONObject.optString("onReachBottomDistance");
        gVar.f44475h = jSONObject.optBoolean("enableOpacityNavigationBar");
        gVar.f44476i = jSONObject.optBoolean("enableOpacityNavigationBarText");
        gVar.j = jSONObject.optString("navigationStyle", "default");
        gVar.k = jSONObject.optBoolean("navigationHomeButtonHidden");
        gVar.q = jSONObject.optString("textSizeAdjust");
        return gVar;
    }

    public static g d() {
        if (r) {
            Log.e("WindowConfig", "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception()));
        }
        return new g();
    }

    public static g e(JSONObject jSONObject, @NonNull g gVar) {
        g gVar2 = new g();
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        gVar2.f44468a = TextUtils.isEmpty(optString) ? gVar.f44468a : SwanAppConfigData.s(optString);
        gVar2.f44469b = jSONObject.optString("navigationBarTitleText", gVar.f44469b);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = gVar.f44470c;
        }
        gVar2.f44470c = optString2;
        gVar2.f44471d = jSONObject.optString("backgroundTextStyle", gVar.f44471d);
        gVar2.f44472e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : gVar.f44472e;
        gVar2.f44473f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f44473f);
        gVar2.f44474g = jSONObject.optString("onReachBottomDistance", gVar.f44474g);
        gVar2.f44475h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f44475h);
        gVar2.f44476i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.f44476i);
        gVar2.j = jSONObject.optString("navigationStyle", gVar.j);
        gVar2.k = jSONObject.optBoolean("navigationHomeButtonHidden", gVar.k);
        gVar2.l = jSONObject.optBoolean("disableSwipeBack", false);
        gVar2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
        gVar2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
        gVar2.o = jSONObject.optBoolean("_hasVideo", false);
        return gVar2;
    }

    public static boolean f(g gVar) {
        if (gVar == null) {
            return false;
        }
        return gVar.f44475h || TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
    }

    public void g(boolean z) {
        if (!z || this.p) {
            return;
        }
        this.p = true;
    }
}
