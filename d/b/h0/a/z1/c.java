package d.b.h0.a.z1;

import android.text.TextUtils;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47909e;

        public a(c cVar, JSONObject jSONObject) {
            this.f47909e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.z1.b.j("777", this.f47909e);
            d.b.h0.a.c0.c.h("SwanAppBusinessUbc", this.f47909e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f47910a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f47911b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f47912c;

        /* renamed from: d  reason: collision with root package name */
        public String f47913d;

        /* renamed from: e  reason: collision with root package name */
        public String f47914e;

        /* renamed from: f  reason: collision with root package name */
        public String f47915f;

        /* renamed from: g  reason: collision with root package name */
        public String f47916g;

        /* renamed from: h  reason: collision with root package name */
        public String f47917h;

        public b(int i) {
            this.f47912c = String.valueOf(i);
        }

        public b h(String str) {
            this.f47916g = str;
            return this;
        }

        public b i(String str) {
            this.f47917h = str;
            return this;
        }

        public b j(String str) {
            this.f47915f = str;
            return this;
        }

        public b k(String str) {
            this.f47913d = str;
            return this;
        }

        public void l() {
            this.f47910a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f47911b)) {
                jSONObject.put("from", bVar.f47911b);
            }
            if (!TextUtils.isEmpty(bVar.f47912c)) {
                jSONObject.put("type", bVar.f47912c);
            }
            if (!TextUtils.isEmpty(bVar.f47914e)) {
                jSONObject.put("value", bVar.f47914e);
            }
            if (!TextUtils.isEmpty(bVar.f47913d)) {
                jSONObject.put("source", bVar.f47913d);
            }
            if (!TextUtils.isEmpty(bVar.f47915f)) {
                jSONObject.put("page", bVar.f47915f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f47916g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f47917h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f47916g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f47917h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            p.k(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (k.f45772a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
