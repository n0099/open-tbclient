package d.o.a.a.a.d;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f70359a;

    /* renamed from: b  reason: collision with root package name */
    public final String f70360b;

    /* renamed from: c  reason: collision with root package name */
    public final String f70361c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f70362d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70363e;

    /* renamed from: f  reason: collision with root package name */
    public final String f70364f;

    /* renamed from: g  reason: collision with root package name */
    public final long f70365g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f70366h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f70367i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f70368a;

        /* renamed from: b  reason: collision with root package name */
        public String f70369b;

        /* renamed from: c  reason: collision with root package name */
        public String f70370c;

        /* renamed from: e  reason: collision with root package name */
        public long f70372e;

        /* renamed from: f  reason: collision with root package name */
        public String f70373f;

        /* renamed from: g  reason: collision with root package name */
        public long f70374g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f70375h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f70376i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70371d = false;
        public boolean o = false;

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a b(long j) {
            this.f70372e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f70369b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f70375h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f70368a)) {
                this.f70368a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f70375h == null) {
                this.f70375h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f70375h.has(entry.getKey())) {
                            this.f70375h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f70370c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f70375h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f70375h.get(next));
                    }
                    this.q.put("category", this.f70368a);
                    this.q.put("tag", this.f70369b);
                    this.q.put("value", this.f70372e);
                    this.q.put("ext_value", this.f70374g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f70376i != null) {
                        this.q = d.o.a.a.a.e.a.d(this.f70376i, this.q);
                    }
                    if (this.f70371d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f70373f)) {
                            this.q.put("log_extra", this.f70373f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f70371d) {
                    jSONObject.put("ad_extra_data", this.f70375h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f70373f)) {
                        jSONObject.put("log_extra", this.f70373f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f70375h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f70376i != null) {
                    jSONObject = d.o.a.a.a.e.a.d(this.f70376i, jSONObject);
                }
                this.f70375h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f70374g = j;
            return this;
        }

        public a k(String str) {
            this.f70370c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.f70376i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f70371d = z;
            return this;
        }

        public a o(String str) {
            this.f70373f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f70359a = aVar.f70368a;
        this.f70360b = aVar.f70369b;
        this.f70361c = aVar.f70370c;
        this.f70362d = aVar.f70371d;
        this.f70363e = aVar.f70372e;
        this.f70364f = aVar.f70373f;
        this.f70365g = aVar.f70374g;
        this.f70366h = aVar.f70375h;
        this.f70367i = aVar.f70376i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        return this.f70360b;
    }

    public String b() {
        return this.f70361c;
    }

    public boolean c() {
        return this.f70362d;
    }

    public JSONObject d() {
        return this.f70366h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f70359a);
        sb.append("\ttag: ");
        sb.append(this.f70360b);
        sb.append("\tlabel: ");
        sb.append(this.f70361c);
        sb.append("\nisAd: ");
        sb.append(this.f70362d);
        sb.append("\tadId: ");
        sb.append(this.f70363e);
        sb.append("\tlogExtra: ");
        sb.append(this.f70364f);
        sb.append("\textValue: ");
        sb.append(this.f70365g);
        sb.append("\nextJson: ");
        sb.append(this.f70366h);
        sb.append("\nparamsJson: ");
        sb.append(this.f70367i);
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
