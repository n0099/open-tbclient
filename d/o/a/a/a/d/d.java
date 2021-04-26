package d.o.a.a.a.d;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f65844a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65845b;

    /* renamed from: c  reason: collision with root package name */
    public final String f65846c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f65847d;

    /* renamed from: e  reason: collision with root package name */
    public final long f65848e;

    /* renamed from: f  reason: collision with root package name */
    public final String f65849f;

    /* renamed from: g  reason: collision with root package name */
    public final long f65850g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f65851h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f65852i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f65853a;

        /* renamed from: b  reason: collision with root package name */
        public String f65854b;

        /* renamed from: c  reason: collision with root package name */
        public String f65855c;

        /* renamed from: e  reason: collision with root package name */
        public long f65857e;

        /* renamed from: f  reason: collision with root package name */
        public String f65858f;

        /* renamed from: g  reason: collision with root package name */
        public long f65859g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f65860h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f65861i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65856d = false;
        public boolean o = false;

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a b(long j) {
            this.f65857e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f65854b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f65860h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f65853a)) {
                this.f65853a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f65860h == null) {
                this.f65860h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f65860h.has(entry.getKey())) {
                            this.f65860h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f65855c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f65860h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f65860h.get(next));
                    }
                    this.q.put("category", this.f65853a);
                    this.q.put("tag", this.f65854b);
                    this.q.put("value", this.f65857e);
                    this.q.put("ext_value", this.f65859g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    if (this.f65861i != null) {
                        this.q = d.o.a.a.a.e.a.d(this.f65861i, this.q);
                    }
                    if (this.f65856d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f65858f)) {
                            this.q.put("log_extra", this.f65858f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f65856d) {
                    jSONObject.put("ad_extra_data", this.f65860h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f65858f)) {
                        jSONObject.put("log_extra", this.f65858f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f65860h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                if (this.f65861i != null) {
                    jSONObject = d.o.a.a.a.e.a.d(this.f65861i, jSONObject);
                }
                this.f65860h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f65859g = j;
            return this;
        }

        public a k(String str) {
            this.f65855c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.f65861i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f65856d = z;
            return this;
        }

        public a o(String str) {
            this.f65858f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f65844a = aVar.f65853a;
        this.f65845b = aVar.f65854b;
        this.f65846c = aVar.f65855c;
        this.f65847d = aVar.f65856d;
        this.f65848e = aVar.f65857e;
        this.f65849f = aVar.f65858f;
        this.f65850g = aVar.f65859g;
        this.f65851h = aVar.f65860h;
        this.f65852i = aVar.f65861i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        return this.f65845b;
    }

    public String b() {
        return this.f65846c;
    }

    public boolean c() {
        return this.f65847d;
    }

    public JSONObject d() {
        return this.f65851h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f65844a);
        sb.append("\ttag: ");
        sb.append(this.f65845b);
        sb.append("\tlabel: ");
        sb.append(this.f65846c);
        sb.append("\nisAd: ");
        sb.append(this.f65847d);
        sb.append("\tadId: ");
        sb.append(this.f65848e);
        sb.append("\tlogExtra: ");
        sb.append(this.f65849f);
        sb.append("\textValue: ");
        sb.append(this.f65850g);
        sb.append("\nextJson: ");
        sb.append(this.f65851h);
        sb.append("\nparamsJson: ");
        sb.append(this.f65852i);
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
