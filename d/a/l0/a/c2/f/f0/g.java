package d.a.l0.a.c2.f.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.u.e.d.b;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 implements b.j {

    /* renamed from: c  reason: collision with root package name */
    public String f44683c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f44684d;

    /* renamed from: e  reason: collision with root package name */
    public long f44685e;

    /* renamed from: f  reason: collision with root package name */
    public long f44686f;

    /* renamed from: g  reason: collision with root package name */
    public long f44687g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44688e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44689f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44690g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f44691h;

        /* renamed from: d.a.l0.a.c2.f.f0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0636a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f44693e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f44694f;

            public RunnableC0636a(ShowFavoriteGuideApi.GuideType guideType, String str) {
                this.f44693e = guideType;
                this.f44694f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.u.e.d.b l = d.a.l0.a.u.e.d.b.l();
                a aVar = a.this;
                d.a.l0.a.a2.e eVar = aVar.f44691h;
                l.p(g.this, (Activity) aVar.f44689f, eVar, this.f44693e, this.f44694f, eVar.L().Q(), g.this.f44685e);
            }
        }

        public a(String str, Context context, JSONObject jSONObject, d.a.l0.a.a2.e eVar) {
            this.f44688e = str;
            this.f44689f = context;
            this.f44690g = jSONObject;
            this.f44691h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.k2.g.b a2 = h.a();
            ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f44688e);
            String string = this.f44689f.getString(parse.defaultText);
            g.this.f44683c = this.f44690g.optString("cb");
            String str = this.f44691h.f44425f;
            String str2 = "favorite_guide_count_" + str;
            if (d.a.l0.a.j0.b.a.n(str)) {
                d.a.l0.a.e0.d.g("ShowFavoriteGuideAction", "favorite already");
                h.a().putString(str2, "-1");
                return;
            }
            String string2 = h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                d.a.l0.a.e0.d.g("ShowFavoriteGuideAction", "favorite at one time");
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
            g.this.f44685e = a2.getLong("swan_favorite_guide_duration", 3L);
            g.this.f44686f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            g.this.f44687g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            d.a.l0.a.e0.d.g("ShowFavoriteGuideAction", "duration=" + g.this.f44685e + ", mIntervalDays=" + g.this.f44686f + ", mMaxTimes=" + g.this.f44687g + " ,storageValue=" + string2);
            if (i3 < g.this.f44687g && currentTimeMillis - j > g.this.f44686f * 86400000) {
                h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                q0.b0(new RunnableC0636a(parse, string));
                return;
            }
            d.a.l0.a.e0.d.g("ShowFavoriteGuideAction", "Not satisfying display conditions");
        }
    }

    public g(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.g("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!q0.G()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
            d.a.l0.a.e0.d.g("ShowFavoriteGuideAction", "not support outside baiduboxapp");
            return false;
        }
        this.f44684d = callbackHandler;
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 != null && eVar != null && (context instanceof Activity)) {
            String optString = a2.optString("type");
            if (d.a.l0.a.u.e.d.b.l().n(optString)) {
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
        d.a.l0.a.e0.d.g("ShowFavoriteGuideAction", "params parse error");
        return false;
    }

    @Override // d.a.l0.a.u.e.d.b.j
    @AnyThread
    public void e(boolean z) {
        if (this.f44683c == null || this.f44684d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f44684d.handleSchemeDispatchCallback(this.f44683c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }
}
