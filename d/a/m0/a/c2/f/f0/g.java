package d.a.m0.a.c2.f.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.k2.g.h;
import d.a.m0.a.u.e.d.b;
import d.a.m0.a.v2.q;
import d.a.m0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 implements b.j {

    /* renamed from: c  reason: collision with root package name */
    public String f44791c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f44792d;

    /* renamed from: e  reason: collision with root package name */
    public long f44793e;

    /* renamed from: f  reason: collision with root package name */
    public long f44794f;

    /* renamed from: g  reason: collision with root package name */
    public long f44795g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44796e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44797f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44798g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f44799h;

        /* renamed from: d.a.m0.a.c2.f.f0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0639a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f44801e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f44802f;

            public RunnableC0639a(ShowFavoriteGuideApi.GuideType guideType, String str) {
                this.f44801e = guideType;
                this.f44802f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.m0.a.u.e.d.b l = d.a.m0.a.u.e.d.b.l();
                a aVar = a.this;
                d.a.m0.a.a2.e eVar = aVar.f44799h;
                l.p(g.this, (Activity) aVar.f44797f, eVar, this.f44801e, this.f44802f, eVar.L().Q(), g.this.f44793e);
            }
        }

        public a(String str, Context context, JSONObject jSONObject, d.a.m0.a.a2.e eVar) {
            this.f44796e = str;
            this.f44797f = context;
            this.f44798g = jSONObject;
            this.f44799h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.k2.g.b a2 = h.a();
            ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f44796e);
            String string = this.f44797f.getString(parse.defaultText);
            g.this.f44791c = this.f44798g.optString("cb");
            String str = this.f44799h.f44533f;
            String str2 = "favorite_guide_count_" + str;
            if (d.a.m0.a.j0.b.a.n(str)) {
                d.a.m0.a.e0.d.g("ShowFavoriteGuideAction", "favorite already");
                h.a().putString(str2, "-1");
                return;
            }
            String string2 = h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                d.a.m0.a.e0.d.g("ShowFavoriteGuideAction", "favorite at one time");
                return;
            }
            String[] split = string2.split("#");
            long j = 0;
            int i2 = 0;
            if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                i2 = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = i2;
            g.this.f44793e = a2.getLong("swan_favorite_guide_duration", 3L);
            g.this.f44794f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            g.this.f44795g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            d.a.m0.a.e0.d.g("ShowFavoriteGuideAction", "duration=" + g.this.f44793e + ", mIntervalDays=" + g.this.f44794f + ", mMaxTimes=" + g.this.f44795g + " ,storageValue=" + string2);
            if (i3 < g.this.f44795g && currentTimeMillis - j > g.this.f44794f * 86400000) {
                h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                q0.b0(new RunnableC0639a(parse, string));
                return;
            }
            d.a.m0.a.e0.d.g("ShowFavoriteGuideAction", "Not satisfying display conditions");
        }
    }

    public g(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.e0.d.g("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!q0.G()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
            d.a.m0.a.e0.d.g("ShowFavoriteGuideAction", "not support outside baiduboxapp");
            return false;
        }
        this.f44792d = callbackHandler;
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 != null && eVar != null && (context instanceof Activity)) {
            String optString = a2.optString("type");
            if (d.a.m0.a.u.e.d.b.l().n(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            q.f().execute(new a(optString, context, a2, eVar), "ShowFavoriteGuideAction");
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
            unitedSchemeEntity.result = wrapCallbackParams;
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
        d.a.m0.a.e0.d.g("ShowFavoriteGuideAction", "params parse error");
        return false;
    }

    @Override // d.a.m0.a.u.e.d.b.j
    @AnyThread
    public void e(boolean z) {
        if (this.f44791c == null || this.f44792d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f44792d.handleSchemeDispatchCallback(this.f44791c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }
}
