package d.a.h0.a.t1.k.f0;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.t.c.c.a;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 implements a.j {

    /* renamed from: c  reason: collision with root package name */
    public String f44438c;

    /* renamed from: d  reason: collision with root package name */
    public CallbackHandler f44439d;

    /* renamed from: e  reason: collision with root package name */
    public long f44440e;

    /* renamed from: f  reason: collision with root package name */
    public long f44441f;

    /* renamed from: g  reason: collision with root package name */
    public long f44442g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44444f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44445g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44446h;

        /* renamed from: d.a.h0.a.t1.k.f0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0805a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShowFavoriteGuideApi.GuideType f44448e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f44449f;

            public RunnableC0805a(ShowFavoriteGuideApi.GuideType guideType, String str) {
                this.f44448e = guideType;
                this.f44449f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.h0.a.t.c.c.a l = d.a.h0.a.t.c.c.a.l();
                a aVar = a.this;
                d.a.h0.a.r1.e eVar = aVar.f44446h;
                l.p(g.this, (Activity) aVar.f44444f, eVar, this.f44448e, this.f44449f, eVar.J().P(), g.this.f44440e);
            }
        }

        public a(String str, Context context, JSONObject jSONObject, d.a.h0.a.r1.e eVar) {
            this.f44443e = str;
            this.f44444f = context;
            this.f44445g = jSONObject;
            this.f44446h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.a2.g.b a2 = h.a();
            ShowFavoriteGuideApi.GuideType parse = ShowFavoriteGuideApi.GuideType.parse(this.f44443e);
            String string = this.f44444f.getString(parse.defaultText);
            g.this.f44438c = this.f44445g.optString("cb");
            String str = this.f44446h.f43823f;
            String str2 = "favorite_guide_count_" + str;
            if (d.a.h0.a.g0.c.a.n(str)) {
                d.a.h0.a.c0.c.g("ShowFavoriteGuideAction", "favorite already");
                h.a().putString(str2, "-1");
                return;
            }
            String string2 = h.a().getString(str2, "");
            if (TextUtils.equals("-1", string2)) {
                d.a.h0.a.c0.c.g("ShowFavoriteGuideAction", "favorite at one time");
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
            g.this.f44440e = a2.getLong("swan_favorite_guide_duration", 3L);
            g.this.f44441f = a2.getLong("swan_favorite_guide_intervalDays", 3L);
            g.this.f44442g = a2.getLong("swan_favorite_guide_maxTimes", 3L);
            d.a.h0.a.c0.c.g("ShowFavoriteGuideAction", "duration=" + g.this.f44440e + ", mIntervalDays=" + g.this.f44441f + ", mMaxTimes=" + g.this.f44442g + " ,storageValue=" + string2);
            if (i3 < g.this.f44442g && currentTimeMillis - j > g.this.f44441f * 86400000) {
                h.a().putString(str2, (i3 + 1) + "#" + currentTimeMillis);
                k0.X(new RunnableC0805a(parse, string));
                return;
            }
            d.a.h0.a.c0.c.g("ShowFavoriteGuideAction", "Not satisfying display conditions");
        }
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/showFavoriteGuide");
    }

    @Override // d.a.h0.a.t.c.c.a.j
    @AnyThread
    public void d(boolean z) {
        if (this.f44438c == null || this.f44439d == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", z ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f44439d.handleSchemeDispatchCallback(this.f44438c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success").toString());
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("ShowFavoriteGuideAction", "call ShowFavoriteGuideAction pid=" + Process.myPid() + ", Thread=" + Thread.currentThread().getName());
        if (!k0.D()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support outside baiduboxapp");
            d.a.h0.a.c0.c.g("ShowFavoriteGuideAction", "not support outside baiduboxapp");
            return false;
        }
        this.f44439d = callbackHandler;
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 != null && eVar != null && (context instanceof Activity)) {
            String optString = a2.optString("type");
            if (d.a.h0.a.t.c.c.a.l().n(optString)) {
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
        d.a.h0.a.c0.c.g("ShowFavoriteGuideAction", "params parse error");
        return false;
    }
}
