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
        public final /* synthetic */ JSONObject f43092e;

        public a(c cVar, JSONObject jSONObject) {
            this.f43092e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.j2.b.k("777", this.f43092e);
            d.a.l0.a.e0.d.h("SwanAppBusinessUbc", this.f43092e.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public c f43093a = new c(null);

        /* renamed from: b  reason: collision with root package name */
        public String f43094b = "swan";

        /* renamed from: c  reason: collision with root package name */
        public String f43095c;

        /* renamed from: d  reason: collision with root package name */
        public String f43096d;

        /* renamed from: e  reason: collision with root package name */
        public String f43097e;

        /* renamed from: f  reason: collision with root package name */
        public String f43098f;

        /* renamed from: g  reason: collision with root package name */
        public String f43099g;

        /* renamed from: h  reason: collision with root package name */
        public String f43100h;

        public b(int i2) {
            this.f43095c = String.valueOf(i2);
        }

        public b h(String str) {
            this.f43099g = str;
            return this;
        }

        public b i(String str) {
            this.f43100h = str;
            return this;
        }

        public b j(String str) {
            this.f43098f = str;
            return this;
        }

        public b k(String str) {
            this.f43096d = str;
            return this;
        }

        public b l(String str) {
            this.f43097e = str;
            return this;
        }

        public void m() {
            this.f43093a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f43094b)) {
                jSONObject.put("from", bVar.f43094b);
            }
            if (!TextUtils.isEmpty(bVar.f43095c)) {
                jSONObject.put("type", bVar.f43095c);
            }
            if (!TextUtils.isEmpty(bVar.f43097e)) {
                jSONObject.put("value", bVar.f43097e);
            }
            if (!TextUtils.isEmpty(bVar.f43096d)) {
                jSONObject.put("source", bVar.f43096d);
            }
            if (!TextUtils.isEmpty(bVar.f43098f)) {
                jSONObject.put("page", bVar.f43098f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f43099g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f43100h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f43099g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f43100h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            q.j(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
    }
}
