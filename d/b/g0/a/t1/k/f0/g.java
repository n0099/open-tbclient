package d.b.g0.a.t1.k.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.t.c.c.a;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends a0 implements a.j {

    /* renamed from: c  reason: collision with root package name */
    public String f46327c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f46328d;

    /* renamed from: e  reason: collision with root package name */
    public long f46329e;

    /* renamed from: f  reason: collision with root package name */
    public long f46330f;

    /* renamed from: g  reason: collision with root package name */
    public long f46331g;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46332e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46333f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46334g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46335h;

        /* renamed from: d.b.g0.a.t1.k.f0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0834a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f46336e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f46337f;

            public RunnableC0834a(ShowFavoriteGuideApi.GuideType guideType, String str) {
                this.f46336e = guideType;
                this.f46337f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.a.t.c.c.a l = d.b.g0.a.t.c.c.a.l();
                a aVar = a.this;
                d.b.g0.a.r1.e eVar = aVar.f46335h;
                l.p(g.this, (Activity) aVar.f46333f, eVar, this.f46336e, this.f46337f, eVar.J().P(), g.this.f46329e);
            }
        }

        public a(String str, Context context, JSONObject jSONObject, d.b.g0.a.r1.e eVar) {
            this.f46332e = str;
            this.f46333f = context;
            this.f46334g = jSONObject;
            this.f46335h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.a2.g.b a2 = h.a();
            ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f46332e);
            String string = this.f46333f.getString(parse.defaultText);
            g.this.f46327c = this.f46334g.optString("cb");
            String str = this.f46335h.f45740f;
            String str2 = "favorite_guide_count_" + str;
            if (d.b.g0.a.g0.c.a.n(str)) {
                d.b.g0.a.c0.c.g("ShowFavoriteGuideAction", "favorite already");
                h.a().putString(str2, "-1");
                return;
            }
            String string2 = h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                d.b.g0.a.c0.c.g("ShowFavoriteGuideAction", "favorite at one time");
                return;
            }
            String[] split = string2.split("#");
            long j = 0;
            int i = 0;
            if (split.length == 2 && TextUtils.isDigitsOnly(split[0]) && TextUtils.isDigitsOnly(split[1])) {
                i = Integer.parseInt(split[0]);
                j = Long.parseLong(split[1]);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = i;
            g.this.f46329e = a2.getLong("swan_favorite_guide_duration", 3L);
            g.this.f46330f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            g.this.f46331g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            d.b.g0.a.c0.c.g("ShowFavoriteGuideAction", "duration=" + g.this.f46329e + ", mIntervalDays=" + g.this.f46330f + ", mMaxTimes=" + g.this.f46331g + " ,storageValue=" + string2);
            if (i2 < g.this.f46331g && currentTimeMillis - j > g.this.f46330f * 86400000) {
                h.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                k0.X(new RunnableC0834a(parse, string));
                return;
            }
            d.b.g0.a.c0.c.g("ShowFavoriteGuideAction", "Not satisfying display conditions");
        }
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // d.b.g0.a.t.c.c.a.j
    @AnyThread
    public void e(boolean z) {
        if (this.f46327c == null || this.f46328d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f46328d.handleSchemeDispatchCallback(this.f46327c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!k0.D()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
            d.b.g0.a.c0.c.g("ShowFavoriteGuideAction", "not support outside baiduboxapp");
            return false;
        }
        this.f46328d = callbackHandler;
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 != null && eVar != null && (context instanceof Activity)) {
            String optString = a2.optString("type");
            if (d.b.g0.a.t.c.c.a.l().n(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            p.g().execute(new a(optString, context, a2, eVar), "ShowFavoriteGuideAction");
            JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0);
            unitedSchemeEntity.result = wrapCallbackParams;
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
        d.b.g0.a.c0.c.g("ShowFavoriteGuideAction", "params parse error");
        return false;
    }
}
