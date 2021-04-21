package d.b.h0.a.t1.k.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p;
import d.b.h0.a.t.c.c.a;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 implements a.j {

    /* renamed from: c  reason: collision with root package name */
    public String f47048c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f47049d;

    /* renamed from: e  reason: collision with root package name */
    public long f47050e;

    /* renamed from: f  reason: collision with root package name */
    public long f47051f;

    /* renamed from: g  reason: collision with root package name */
    public long f47052g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47053e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f47054f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47055g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47056h;

        /* renamed from: d.b.h0.a.t1.k.f0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0866a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f47057e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f47058f;

            public RunnableC0866a(ShowFavoriteGuideApi.GuideType guideType, String str) {
                this.f47057e = guideType;
                this.f47058f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.h0.a.t.c.c.a l = d.b.h0.a.t.c.c.a.l();
                a aVar = a.this;
                d.b.h0.a.r1.e eVar = aVar.f47056h;
                l.p(g.this, (Activity) aVar.f47054f, eVar, this.f47057e, this.f47058f, eVar.J().P(), g.this.f47050e);
            }
        }

        public a(String str, Context context, JSONObject jSONObject, d.b.h0.a.r1.e eVar) {
            this.f47053e = str;
            this.f47054f = context;
            this.f47055g = jSONObject;
            this.f47056h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.a2.g.b a2 = h.a();
            ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f47053e);
            String string = this.f47054f.getString(parse.defaultText);
            g.this.f47048c = this.f47055g.optString("cb");
            String str = this.f47056h.f46461f;
            String str2 = "favorite_guide_count_" + str;
            if (d.b.h0.a.g0.c.a.n(str)) {
                d.b.h0.a.c0.c.g("ShowFavoriteGuideAction", "favorite already");
                h.a().putString(str2, "-1");
                return;
            }
            String string2 = h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                d.b.h0.a.c0.c.g("ShowFavoriteGuideAction", "favorite at one time");
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
            g.this.f47050e = a2.getLong("swan_favorite_guide_duration", 3L);
            g.this.f47051f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            g.this.f47052g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            d.b.h0.a.c0.c.g("ShowFavoriteGuideAction", "duration=" + g.this.f47050e + ", mIntervalDays=" + g.this.f47051f + ", mMaxTimes=" + g.this.f47052g + " ,storageValue=" + string2);
            if (i2 < g.this.f47052g && currentTimeMillis - j > g.this.f47051f * 86400000) {
                h.a().putString(str2, (i2 + 1) + "#" + currentTimeMillis);
                k0.X(new RunnableC0866a(parse, string));
                return;
            }
            d.b.h0.a.c0.c.g("ShowFavoriteGuideAction", "Not satisfying display conditions");
        }
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // d.b.h0.a.t.c.c.a.j
    @AnyThread
    public void e(boolean z) {
        if (this.f47048c == null || this.f47049d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f47049d.handleSchemeDispatchCallback(this.f47048c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!k0.D()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
            d.b.h0.a.c0.c.g("ShowFavoriteGuideAction", "not support outside baiduboxapp");
            return false;
        }
        this.f47049d = callbackHandler;
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 != null && eVar != null && (context instanceof Activity)) {
            String optString = a2.optString("type");
            if (d.b.h0.a.t.c.c.a.l().n(optString)) {
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
        d.b.h0.a.c0.c.g("ShowFavoriteGuideAction", "params parse error");
        return false;
    }
}
