package d.a.l0.a.j2;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o extends d.a.l0.a.u.c.d {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43182f;

        public a(o oVar, String str, String str2) {
            this.f43181e = str;
            this.f43182f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.equals(this.f43181e, "671")) {
                d.a.l0.a.e0.d.h("ubcAndCeresStatisticEvent", "671 event=" + this.f43182f);
            }
            try {
                d.a.l0.a.j2.b.m(this.f43181e, new JSONObject(this.f43182f));
            } catch (JSONException e2) {
                d.a.l0.a.e0.d.h("ubcAndCeresStatisticEvent", e2.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43183e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43184f;

        public b(o oVar, String str, JSONObject jSONObject) {
            this.f43183e = str;
            this.f43184f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.e.m(this.f43183e, this.f43184f);
        }
    }

    public o(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void r(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        b.a L = d.a.l0.a.a2.d.g().r().L();
        w.f(jSONObject, "launchId", L.V());
        w.f(jSONObject, "scheme", L.W());
        w.f(jSONObject, "appid", L.H());
        w.f(jSONObject, "swan", d.a.l0.a.m2.b.i(L.i0(), L.G()));
        w.f(jSONObject, "packageVersion", L.u1());
        w.f(jSONObject, "thirdversion", L.v1());
    }

    public d.a.l0.a.u.h.b s(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-ubcAndCeresStatisticEvent", "start handle ubcStatisticEvent.");
            Log.d("Api-ubcAndCeresStatisticEvent", "data - " + str);
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-ubcAndCeresStatisticEvent", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (bVar.a()) {
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("ubcId");
            String optString2 = jSONObject.optString("bizId");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optJSONObject != null) {
                w.f(optJSONObject, "source", d.a.l0.a.a2.d.g().r().L().T());
                r(optJSONObject.optJSONObject("ext"));
                d.a.l0.a.r1.k.i.c.f().e(new a(this, optString, optJSONObject.toString()), "Api-ubcAndCeresStatisticEvent");
                d.a.l0.a.r1.k.f.j().i().d(jSONObject);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                String str2 = null;
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ext");
                    String optString3 = optJSONObject2.optString("type");
                    optJSONObject2.remove("type");
                    optJSONObject2.remove("from");
                    r(optJSONObject3);
                    str2 = optString3;
                }
                jSONObject.remove("ubcId");
                try {
                    jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
                    jSONObject.putOpt("eventType", "0");
                    jSONObject.putOpt("propagation", w.f(jSONObject.optJSONObject("propagation"), "source", d.a.l0.a.a2.d.g().r().L().T()));
                    jSONObject.put("eventName", str2);
                } catch (JSONException e2) {
                    if (d.a.l0.a.u.c.d.f44812c) {
                        e2.printStackTrace();
                    }
                }
                d.a.l0.a.e0.d.g("Api-ubcAndCeresStatisticEvent", "OpenStat : " + jSONObject);
                d.a.l0.a.r1.k.i.c.f().e(new b(this, optString2, jSONObject), "OpenStatisticEvent");
                return new d.a.l0.a.u.h.b(0);
            }
            return new d.a.l0.a.u.h.b(202);
        }
        return bVar;
    }
}
