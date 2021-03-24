package d.o.a.a.a.d;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f66369a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66370b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66371c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f66372d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66373e;

    /* renamed from: f  reason: collision with root package name */
    public final String f66374f;

    /* renamed from: g  reason: collision with root package name */
    public final long f66375g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f66376h;
    public final JSONObject i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f66377a;

        /* renamed from: b  reason: collision with root package name */
        public String f66378b;

        /* renamed from: c  reason: collision with root package name */
        public String f66379c;

        /* renamed from: e  reason: collision with root package name */
        public long f66381e;

        /* renamed from: f  reason: collision with root package name */
        public String f66382f;

        /* renamed from: g  reason: collision with root package name */
        public long f66383g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f66384h;
        public JSONObject i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66380d = false;
        public boolean o = false;

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a b(long j) {
            this.f66381e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f66378b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f66384h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f66377a)) {
                this.f66377a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f66384h == null) {
                this.f66384h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f66384h.has(entry.getKey())) {
                            this.f66384h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f66379c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f66384h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f66384h.get(next));
                    }
                    this.q.put("category", this.f66377a);
                    this.q.put("tag", this.f66378b);
                    this.q.put("value", this.f66381e);
                    this.q.put("ext_value", this.f66383g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    if (this.i != null) {
                        this.q = d.o.a.a.a.e.a.d(this.i, this.q);
                    }
                    if (this.f66380d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f66382f)) {
                            this.q.put("log_extra", this.f66382f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f66380d) {
                    jSONObject.put("ad_extra_data", this.f66384h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f66382f)) {
                        jSONObject.put("log_extra", this.f66382f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f66384h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                if (this.i != null) {
                    jSONObject = d.o.a.a.a.e.a.d(this.i, jSONObject);
                }
                this.f66384h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f66383g = j;
            return this;
        }

        public a k(String str) {
            this.f66379c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f66380d = z;
            return this;
        }

        public a o(String str) {
            this.f66382f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f66369a = aVar.f66377a;
        this.f66370b = aVar.f66378b;
        this.f66371c = aVar.f66379c;
        this.f66372d = aVar.f66380d;
        this.f66373e = aVar.f66381e;
        this.f66374f = aVar.f66382f;
        this.f66375g = aVar.f66383g;
        this.f66376h = aVar.f66384h;
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
        return this.f66370b;
    }

    public String b() {
        return this.f66371c;
    }

    public boolean c() {
        return this.f66372d;
    }

    public JSONObject d() {
        return this.f66376h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f66369a);
        sb.append("\ttag: ");
        sb.append(this.f66370b);
        sb.append("\tlabel: ");
        sb.append(this.f66371c);
        sb.append("\nisAd: ");
        sb.append(this.f66372d);
        sb.append("\tadId: ");
        sb.append(this.f66373e);
        sb.append("\tlogExtra: ");
        sb.append(this.f66374f);
        sb.append("\textValue: ");
        sb.append(this.f66375g);
        sb.append("\nextJson: ");
        sb.append(this.f66376h);
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
