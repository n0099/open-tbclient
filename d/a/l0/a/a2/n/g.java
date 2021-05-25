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
    public static final boolean r = k.f43199a;
    public static final f<g> s = new a();
    public static final e<g> t = new b();

    /* renamed from: b  reason: collision with root package name */
    public String f40793b;

    /* renamed from: d  reason: collision with root package name */
    public String f40795d;

    /* renamed from: g  reason: collision with root package name */
    public String f40798g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40799h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40800i;
    public boolean k;
    public String q;
    public boolean l = false;
    public boolean m = false;
    public boolean n = true;
    public boolean o = false;
    public boolean p = false;

    /* renamed from: a  reason: collision with root package name */
    public int f40792a = -16777216;

    /* renamed from: c  reason: collision with root package name */
    public String f40794c = "#ffffff";
    public String j = "default";

    /* renamed from: e  reason: collision with root package name */
    public int f40796e = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40797f = false;

    /* loaded from: classes3.dex */
    public static class a extends f<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull g gVar, @NonNull d.a.l0.a.b1.d dVar) throws Exception {
            dVar.writeInt(gVar.f40792a);
            dVar.n(gVar.f40793b);
            dVar.n(gVar.f40794c);
            dVar.n(gVar.f40795d);
            dVar.writeInt(gVar.f40796e);
            dVar.writeBoolean(gVar.f40797f);
            dVar.n(gVar.f40798g);
            dVar.writeBoolean(gVar.f40799h);
            dVar.writeBoolean(gVar.f40800i);
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
            gVar.f40792a = cVar.readInt();
            gVar.f40793b = cVar.s();
            gVar.f40794c = cVar.s();
            gVar.f40795d = cVar.s();
            gVar.f40796e = cVar.readInt();
            gVar.f40797f = cVar.readBoolean();
            gVar.f40798g = cVar.s();
            gVar.f40799h = cVar.readBoolean();
            gVar.f40800i = cVar.readBoolean();
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
        gVar.f40792a = SwanAppConfigData.s(optString);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "white";
        }
        gVar.f40794c = optString2;
        gVar.f40793b = jSONObject.optString("navigationBarTitleText");
        gVar.f40795d = jSONObject.optString("backgroundTextStyle", "black");
        gVar.f40796e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
        gVar.f40797f = jSONObject.optBoolean("enablePullDownRefresh");
        gVar.f40798g = jSONObject.optString("onReachBottomDistance");
        gVar.f40799h = jSONObject.optBoolean("enableOpacityNavigationBar");
        gVar.f40800i = jSONObject.optBoolean("enableOpacityNavigationBarText");
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
        gVar2.f40792a = TextUtils.isEmpty(optString) ? gVar.f40792a : SwanAppConfigData.s(optString);
        gVar2.f40793b = jSONObject.optString("navigationBarTitleText", gVar.f40793b);
        String optString2 = jSONObject.optString("navigationBarTextStyle");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = gVar.f40794c;
        }
        gVar2.f40794c = optString2;
        gVar2.f40795d = jSONObject.optString("backgroundTextStyle", gVar.f40795d);
        gVar2.f40796e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : gVar.f40796e;
        gVar2.f40797f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f40797f);
        gVar2.f40798g = jSONObject.optString("onReachBottomDistance", gVar.f40798g);
        gVar2.f40799h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f40799h);
        gVar2.f40800i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.f40800i);
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
        return gVar.f40799h || TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
    }

    public void g(boolean z) {
        if (!z || this.p) {
            return;
        }
        this.p = true;
    }
}
