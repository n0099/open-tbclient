package d.a.l0.a.j2;

import android.text.TextUtils;
import d.a.l0.a.v2.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46768e;

        public a(c cVar, JSONObject jSONObject) {
            this.f46768e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k("777", this.f46768e);
            d.a.l0.a.e0.d.h("SwanAppBusinessUbc", this.f46768e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f46769a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f46770b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f46771c;

        /* renamed from: d  reason: collision with root package name */
        public String f46772d;

        /* renamed from: e  reason: collision with root package name */
        public String f46773e;

        /* renamed from: f  reason: collision with root package name */
        public String f46774f;

        /* renamed from: g  reason: collision with root package name */
        public String f46775g;

        /* renamed from: h  reason: collision with root package name */
        public String f46776h;

        public b(int i2) {
            this.f46771c = String.valueOf(i2);
        }

        public b h(String str) {
            this.f46775g = str;
            return this;
        }

        public b i(String str) {
            this.f46776h = str;
            return this;
        }

        public b j(String str) {
            this.f46774f = str;
            return this;
        }

        public b k(String str) {
            this.f46772d = str;
            return this;
        }

        public b l(String str) {
            this.f46773e = str;
            return this;
        }

        public void m() {
            this.f46769a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f46770b)) {
                jSONObject.put("from", bVar.f46770b);
            }
            if (!TextUtils.isEmpty(bVar.f46771c)) {
                jSONObject.put("type", bVar.f46771c);
            }
            if (!TextUtils.isEmpty(bVar.f46773e)) {
                jSONObject.put("value", bVar.f46773e);
            }
            if (!TextUtils.isEmpty(bVar.f46772d)) {
                jSONObject.put("source", bVar.f46772d);
            }
            if (!TextUtils.isEmpty(bVar.f46774f)) {
                jSONObject.put("page", bVar.f46774f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f46775g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f46776h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f46775g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f46776h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            q.j(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
