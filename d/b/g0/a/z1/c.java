package d.b.g0.a.z1;

import android.text.TextUtils;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47580e;

        public a(c cVar, JSONObject jSONObject) {
            this.f47580e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j("777", this.f47580e);
            d.b.g0.a.c0.c.h("SwanAppBusinessUbc", this.f47580e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f47581a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f47582b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f47583c;

        /* renamed from: d  reason: collision with root package name */
        public String f47584d;

        /* renamed from: e  reason: collision with root package name */
        public String f47585e;

        /* renamed from: f  reason: collision with root package name */
        public String f47586f;

        /* renamed from: g  reason: collision with root package name */
        public String f47587g;

        /* renamed from: h  reason: collision with root package name */
        public String f47588h;

        public b(int i) {
            this.f47583c = String.valueOf(i);
        }

        public b h(String str) {
            this.f47587g = str;
            return this;
        }

        public b i(String str) {
            this.f47588h = str;
            return this;
        }

        public b j(String str) {
            this.f47586f = str;
            return this;
        }

        public b k(String str) {
            this.f47584d = str;
            return this;
        }

        public void l() {
            this.f47581a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f47582b)) {
                jSONObject.put("from", bVar.f47582b);
            }
            if (!TextUtils.isEmpty(bVar.f47583c)) {
                jSONObject.put("type", bVar.f47583c);
            }
            if (!TextUtils.isEmpty(bVar.f47585e)) {
                jSONObject.put("value", bVar.f47585e);
            }
            if (!TextUtils.isEmpty(bVar.f47584d)) {
                jSONObject.put("source", bVar.f47584d);
            }
            if (!TextUtils.isEmpty(bVar.f47586f)) {
                jSONObject.put("page", bVar.f47586f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f47587g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f47588h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f47587g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f47588h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            p.k(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (k.f45443a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
