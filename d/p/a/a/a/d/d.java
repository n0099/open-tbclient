package d.p.a.a.a.d;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f67510a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67511b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67512c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67513d;

    /* renamed from: e  reason: collision with root package name */
    public final long f67514e;

    /* renamed from: f  reason: collision with root package name */
    public final String f67515f;

    /* renamed from: g  reason: collision with root package name */
    public final long f67516g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f67517h;
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
        public String f67518a;

        /* renamed from: b  reason: collision with root package name */
        public String f67519b;

        /* renamed from: c  reason: collision with root package name */
        public String f67520c;

        /* renamed from: e  reason: collision with root package name */
        public long f67522e;

        /* renamed from: f  reason: collision with root package name */
        public String f67523f;

        /* renamed from: g  reason: collision with root package name */
        public long f67524g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f67525h;
        public JSONObject i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67521d = false;
        public boolean o = false;

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a b(long j) {
            this.f67522e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f67519b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f67525h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f67518a)) {
                this.f67518a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f67525h == null) {
                this.f67525h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f67525h.has(entry.getKey())) {
                            this.f67525h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f67520c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f67525h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f67525h.get(next));
                    }
                    this.q.put("category", this.f67518a);
                    this.q.put("tag", this.f67519b);
                    this.q.put("value", this.f67522e);
                    this.q.put("ext_value", this.f67524g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put("refer", this.n);
                    }
                    if (this.i != null) {
                        this.q = d.p.a.a.a.e.a.d(this.i, this.q);
                    }
                    if (this.f67521d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f67523f)) {
                            this.q.put("log_extra", this.f67523f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f67521d) {
                    jSONObject.put("ad_extra_data", this.f67525h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f67523f)) {
                        jSONObject.put("log_extra", this.f67523f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f67525h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt("refer", this.n);
                }
                if (this.i != null) {
                    jSONObject = d.p.a.a.a.e.a.d(this.i, jSONObject);
                }
                this.f67525h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f67524g = j;
            return this;
        }

        public a k(String str) {
            this.f67520c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f67521d = z;
            return this;
        }

        public a o(String str) {
            this.f67523f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f67510a = aVar.f67518a;
        this.f67511b = aVar.f67519b;
        this.f67512c = aVar.f67520c;
        this.f67513d = aVar.f67521d;
        this.f67514e = aVar.f67522e;
        this.f67515f = aVar.f67523f;
        this.f67516g = aVar.f67524g;
        this.f67517h = aVar.f67525h;
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
        return this.f67511b;
    }

    public String b() {
        return this.f67512c;
    }

    public boolean c() {
        return this.f67513d;
    }

    public JSONObject d() {
        return this.f67517h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f67510a);
        sb.append("\ttag: ");
        sb.append(this.f67511b);
        sb.append("\tlabel: ");
        sb.append(this.f67512c);
        sb.append("\nisAd: ");
        sb.append(this.f67513d);
        sb.append("\tadId: ");
        sb.append(this.f67514e);
        sb.append("\tlogExtra: ");
        sb.append(this.f67515f);
        sb.append("\textValue: ");
        sb.append(this.f67516g);
        sb.append("\nextJson: ");
        sb.append(this.f67517h);
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
