package d.o.a.a.a.d;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f67363a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67364b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67365c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67366d;

    /* renamed from: e  reason: collision with root package name */
    public final long f67367e;

    /* renamed from: f  reason: collision with root package name */
    public final String f67368f;

    /* renamed from: g  reason: collision with root package name */
    public final long f67369g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f67370h;
    public final JSONObject i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f67371a;

        /* renamed from: b  reason: collision with root package name */
        public String f67372b;

        /* renamed from: c  reason: collision with root package name */
        public String f67373c;

        /* renamed from: e  reason: collision with root package name */
        public long f67375e;

        /* renamed from: f  reason: collision with root package name */
        public String f67376f;

        /* renamed from: g  reason: collision with root package name */
        public long f67377g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f67378h;
        public JSONObject i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67374d = false;
        public boolean o = false;

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a b(long j) {
            this.f67375e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f67372b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f67378h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f67371a)) {
                this.f67371a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f67378h == null) {
                this.f67378h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f67378h.has(entry.getKey())) {
                            this.f67378h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f67373c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f67378h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f67378h.get(next));
                    }
                    this.q.put("category", this.f67371a);
                    this.q.put("tag", this.f67372b);
                    this.q.put("value", this.f67375e);
                    this.q.put("ext_value", this.f67377g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    if (this.i != null) {
                        this.q = d.o.a.a.a.e.a.d(this.i, this.q);
                    }
                    if (this.f67374d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f67376f)) {
                            this.q.put("log_extra", this.f67376f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f67374d) {
                    jSONObject.put("ad_extra_data", this.f67378h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f67376f)) {
                        jSONObject.put("log_extra", this.f67376f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f67378h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                if (this.i != null) {
                    jSONObject = d.o.a.a.a.e.a.d(this.i, jSONObject);
                }
                this.f67378h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f67377g = j;
            return this;
        }

        public a k(String str) {
            this.f67373c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f67374d = z;
            return this;
        }

        public a o(String str) {
            this.f67376f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f67363a = aVar.f67371a;
        this.f67364b = aVar.f67372b;
        this.f67365c = aVar.f67373c;
        this.f67366d = aVar.f67374d;
        this.f67367e = aVar.f67375e;
        this.f67368f = aVar.f67376f;
        this.f67369g = aVar.f67377g;
        this.f67370h = aVar.f67378h;
        this.i = aVar.i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        return this.f67364b;
    }

    public String b() {
        return this.f67365c;
    }

    public boolean c() {
        return this.f67366d;
    }

    public JSONObject d() {
        return this.f67370h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f67363a);
        sb.append("\ttag: ");
        sb.append(this.f67364b);
        sb.append("\tlabel: ");
        sb.append(this.f67365c);
        sb.append("\nisAd: ");
        sb.append(this.f67366d);
        sb.append("\tadId: ");
        sb.append(this.f67367e);
        sb.append("\tlogExtra: ");
        sb.append(this.f67368f);
        sb.append("\textValue: ");
        sb.append(this.f67369g);
        sb.append("\nextJson: ");
        sb.append(this.f67370h);
        sb.append("\nparamsJson: ");
        sb.append(this.i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.j;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.k);
        sb.append("\textraObject: ");
        Object obj = this.l;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.m);
        sb.append("\tV3EventName: ");
        sb.append(this.n);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.o;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }
}
