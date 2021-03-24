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
        public final /* synthetic */ JSONObject f47187e;

        public a(c cVar, JSONObject jSONObject) {
            this.f47187e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j("777", this.f47187e);
            d.b.g0.a.c0.c.h("SwanAppBusinessUbc", this.f47187e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f47188a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f47189b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f47190c;

        /* renamed from: d  reason: collision with root package name */
        public String f47191d;

        /* renamed from: e  reason: collision with root package name */
        public String f47192e;

        /* renamed from: f  reason: collision with root package name */
        public String f47193f;

        /* renamed from: g  reason: collision with root package name */
        public String f47194g;

        /* renamed from: h  reason: collision with root package name */
        public String f47195h;

        public b(int i) {
            this.f47190c = String.valueOf(i);
        }

        public b h(String str) {
            this.f47194g = str;
            return this;
        }

        public b i(String str) {
            this.f47195h = str;
            return this;
        }

        public b j(String str) {
            this.f47193f = str;
            return this;
        }

        public b k(String str) {
            this.f47191d = str;
            return this;
        }

        public void l() {
            this.f47188a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f47189b)) {
                jSONObject.put("from", bVar.f47189b);
            }
            if (!TextUtils.isEmpty(bVar.f47190c)) {
                jSONObject.put("type", bVar.f47190c);
            }
            if (!TextUtils.isEmpty(bVar.f47192e)) {
                jSONObject.put("value", bVar.f47192e);
            }
            if (!TextUtils.isEmpty(bVar.f47191d)) {
                jSONObject.put("source", bVar.f47191d);
            }
            if (!TextUtils.isEmpty(bVar.f47193f)) {
                jSONObject.put("page", bVar.f47193f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f47194g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f47195h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f47194g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f47195h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            p.k(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (k.f45050a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
