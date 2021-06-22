package d.a.m0.a.j2;

import android.text.TextUtils;
import d.a.m0.a.v2.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46876e;

        public a(c cVar, JSONObject jSONObject) {
            this.f46876e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.j2.b.k("777", this.f46876e);
            d.a.m0.a.e0.d.h("SwanAppBusinessUbc", this.f46876e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f46877a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f46878b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f46879c;

        /* renamed from: d  reason: collision with root package name */
        public String f46880d;

        /* renamed from: e  reason: collision with root package name */
        public String f46881e;

        /* renamed from: f  reason: collision with root package name */
        public String f46882f;

        /* renamed from: g  reason: collision with root package name */
        public String f46883g;

        /* renamed from: h  reason: collision with root package name */
        public String f46884h;

        public b(int i2) {
            this.f46879c = String.valueOf(i2);
        }

        public b h(String str) {
            this.f46883g = str;
            return this;
        }

        public b i(String str) {
            this.f46884h = str;
            return this;
        }

        public b j(String str) {
            this.f46882f = str;
            return this;
        }

        public b k(String str) {
            this.f46880d = str;
            return this;
        }

        public b l(String str) {
            this.f46881e = str;
            return this;
        }

        public void m() {
            this.f46877a.b(this);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bVar.f46878b)) {
                jSONObject.put("from", bVar.f46878b);
            }
            if (!TextUtils.isEmpty(bVar.f46879c)) {
                jSONObject.put("type", bVar.f46879c);
            }
            if (!TextUtils.isEmpty(bVar.f46881e)) {
                jSONObject.put("value", bVar.f46881e);
            }
            if (!TextUtils.isEmpty(bVar.f46880d)) {
                jSONObject.put("source", bVar.f46880d);
            }
            if (!TextUtils.isEmpty(bVar.f46882f)) {
                jSONObject.put("page", bVar.f46882f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f46883g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f46884h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f46883g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f46884h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            q.j(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
