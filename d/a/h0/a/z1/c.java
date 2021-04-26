package d.a.h0.a.z1;

import android.text.TextUtils;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45345e;

        public a(c cVar, JSONObject jSONObject) {
            this.f45345e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.z1.b.j("777", this.f45345e);
            d.a.h0.a.c0.c.h("SwanAppBusinessUbc", this.f45345e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f45346a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f45347b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f45348c;

        /* renamed from: d  reason: collision with root package name */
        public String f45349d;

        /* renamed from: e  reason: collision with root package name */
        public String f45350e;

        /* renamed from: f  reason: collision with root package name */
        public String f45351f;

        /* renamed from: g  reason: collision with root package name */
        public String f45352g;

        /* renamed from: h  reason: collision with root package name */
        public String f45353h;

        public b(int i2) {
            this.f45348c = String.valueOf(i2);
        }

        public b h(String str) {
            this.f45352g = str;
            return this;
        }

        public b i(String str) {
            this.f45353h = str;
            return this;
        }

        public b j(String str) {
            this.f45351f = str;
            return this;
        }

        public b k(String str) {
            this.f45349d = str;
            return this;
        }

        public void l() {
            this.f45346a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f45347b)) {
                jSONObject.put("from", bVar.f45347b);
            }
            if (!TextUtils.isEmpty(bVar.f45348c)) {
                jSONObject.put("type", bVar.f45348c);
            }
            if (!TextUtils.isEmpty(bVar.f45350e)) {
                jSONObject.put("value", bVar.f45350e);
            }
            if (!TextUtils.isEmpty(bVar.f45349d)) {
                jSONObject.put("source", bVar.f45349d);
            }
            if (!TextUtils.isEmpty(bVar.f45351f)) {
                jSONObject.put("page", bVar.f45351f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f45352g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f45353h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f45352g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f45353h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            p.k(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (k.f43101a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
