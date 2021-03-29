package d.b.g0.a.z1;

import android.text.TextUtils;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47188e;

        public a(c cVar, JSONObject jSONObject) {
            this.f47188e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.z1.b.j("777", this.f47188e);
            d.b.g0.a.c0.c.h("SwanAppBusinessUbc", this.f47188e.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f47189a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f47190b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f47191c;

        /* renamed from: d  reason: collision with root package name */
        public String f47192d;

        /* renamed from: e  reason: collision with root package name */
        public String f47193e;

        /* renamed from: f  reason: collision with root package name */
        public String f47194f;

        /* renamed from: g  reason: collision with root package name */
        public String f47195g;

        /* renamed from: h  reason: collision with root package name */
        public String f47196h;

        public b(int i) {
            this.f47191c = String.valueOf(i);
        }

        public b h(String str) {
            this.f47195g = str;
            return this;
        }

        public b i(String str) {
            this.f47196h = str;
            return this;
        }

        public b j(String str) {
            this.f47194f = str;
            return this;
        }

        public b k(String str) {
            this.f47192d = str;
            return this;
        }

        public void l() {
            this.f47189a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f47190b)) {
                jSONObject.put("from", bVar.f47190b);
            }
            if (!TextUtils.isEmpty(bVar.f47191c)) {
                jSONObject.put("type", bVar.f47191c);
            }
            if (!TextUtils.isEmpty(bVar.f47193e)) {
                jSONObject.put("value", bVar.f47193e);
            }
            if (!TextUtils.isEmpty(bVar.f47192d)) {
                jSONObject.put("source", bVar.f47192d);
            }
            if (!TextUtils.isEmpty(bVar.f47194f)) {
                jSONObject.put("page", bVar.f47194f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f47195g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f47196h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f47195g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f47196h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            p.k(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (k.f45051a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
