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
    public String f66573a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66574b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66575c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f66576d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66577e;

    /* renamed from: f  reason: collision with root package name */
    public final String f66578f;

    /* renamed from: g  reason: collision with root package name */
    public final long f66579g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f66580h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f66581i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f66582a;

        /* renamed from: b  reason: collision with root package name */
        public String f66583b;

        /* renamed from: c  reason: collision with root package name */
        public String f66584c;

        /* renamed from: e  reason: collision with root package name */
        public long f66586e;

        /* renamed from: f  reason: collision with root package name */
        public String f66587f;

        /* renamed from: g  reason: collision with root package name */
        public long f66588g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f66589h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f66590i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66585d = false;
        public boolean o = false;

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a b(long j) {
            this.f66586e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f66583b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f66589h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f66582a)) {
                this.f66582a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f66589h == null) {
                this.f66589h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f66589h.has(entry.getKey())) {
                            this.f66589h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f66584c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f66589h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f66589h.get(next));
                    }
                    this.q.put("category", this.f66582a);
                    this.q.put("tag", this.f66583b);
                    this.q.put("value", this.f66586e);
                    this.q.put("ext_value", this.f66588g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f66590i != null) {
                        this.q = d.o.a.a.a.e.a.d(this.f66590i, this.q);
                    }
                    if (this.f66585d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f66587f)) {
                            this.q.put("log_extra", this.f66587f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f66585d) {
                    jSONObject.put("ad_extra_data", this.f66589h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f66587f)) {
                        jSONObject.put("log_extra", this.f66587f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f66589h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f66590i != null) {
                    jSONObject = d.o.a.a.a.e.a.d(this.f66590i, jSONObject);
                }
                this.f66589h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f66588g = j;
            return this;
        }

        public a k(String str) {
            this.f66584c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.f66590i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f66585d = z;
            return this;
        }

        public a o(String str) {
            this.f66587f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f66573a = aVar.f66582a;
        this.f66574b = aVar.f66583b;
        this.f66575c = aVar.f66584c;
        this.f66576d = aVar.f66585d;
        this.f66577e = aVar.f66586e;
        this.f66578f = aVar.f66587f;
        this.f66579g = aVar.f66588g;
        this.f66580h = aVar.f66589h;
        this.f66581i = aVar.f66590i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        return this.f66574b;
    }

    public String b() {
        return this.f66575c;
    }

    public boolean c() {
        return this.f66576d;
    }

    public JSONObject d() {
        return this.f66580h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f66573a);
        sb.append("\ttag: ");
        sb.append(this.f66574b);
        sb.append("\tlabel: ");
        sb.append(this.f66575c);
        sb.append("\nisAd: ");
        sb.append(this.f66576d);
        sb.append("\tadId: ");
        sb.append(this.f66577e);
        sb.append("\tlogExtra: ");
        sb.append(this.f66578f);
        sb.append("\textValue: ");
        sb.append(this.f66579g);
        sb.append("\nextJson: ");
        sb.append(this.f66580h);
        sb.append("\nparamsJson: ");
        sb.append(this.f66581i);
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
