package d.a.i0.a.j2;

import android.text.TextUtils;
import d.a.i0.a.v2.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42918e;

        public a(c cVar, JSONObject jSONObject) {
            this.f42918e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.j2.b.k("777", this.f42918e);
            d.a.i0.a.e0.d.h("SwanAppBusinessUbc", this.f42918e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f42919a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f42920b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f42921c;

        /* renamed from: d  reason: collision with root package name */
        public String f42922d;

        /* renamed from: e  reason: collision with root package name */
        public String f42923e;

        /* renamed from: f  reason: collision with root package name */
        public String f42924f;

        /* renamed from: g  reason: collision with root package name */
        public String f42925g;

        /* renamed from: h  reason: collision with root package name */
        public String f42926h;

        public b(int i2) {
            this.f42921c = String.valueOf(i2);
        }

        public b h(String str) {
            this.f42925g = str;
            return this;
        }

        public b i(String str) {
            this.f42926h = str;
            return this;
        }

        public b j(String str) {
            this.f42924f = str;
            return this;
        }

        public b k(String str) {
            this.f42922d = str;
            return this;
        }

        public b l(String str) {
            this.f42923e = str;
            return this;
        }

        public void m() {
            this.f42919a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f42920b)) {
                jSONObject.put("from", bVar.f42920b);
            }
            if (!TextUtils.isEmpty(bVar.f42921c)) {
                jSONObject.put("type", bVar.f42921c);
            }
            if (!TextUtils.isEmpty(bVar.f42923e)) {
                jSONObject.put("value", bVar.f42923e);
            }
            if (!TextUtils.isEmpty(bVar.f42922d)) {
                jSONObject.put("source", bVar.f42922d);
            }
            if (!TextUtils.isEmpty(bVar.f42924f)) {
                jSONObject.put("page", bVar.f42924f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f42925g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f42926h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f42925g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f42926h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            q.j(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (d.a.i0.a.k.f43025a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
