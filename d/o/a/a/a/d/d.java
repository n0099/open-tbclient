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
    public String f70463a;

    /* renamed from: b  reason: collision with root package name */
    public final String f70464b;

    /* renamed from: c  reason: collision with root package name */
    public final String f70465c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f70466d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70467e;

    /* renamed from: f  reason: collision with root package name */
    public final String f70468f;

    /* renamed from: g  reason: collision with root package name */
    public final long f70469g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f70470h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f70471i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f70472a;

        /* renamed from: b  reason: collision with root package name */
        public String f70473b;

        /* renamed from: c  reason: collision with root package name */
        public String f70474c;

        /* renamed from: e  reason: collision with root package name */
        public long f70476e;

        /* renamed from: f  reason: collision with root package name */
        public String f70477f;

        /* renamed from: g  reason: collision with root package name */
        public long f70478g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f70479h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f70480i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70475d = false;
        public boolean o = false;

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a b(long j) {
            this.f70476e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f70473b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f70479h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f70472a)) {
                this.f70472a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f70479h == null) {
                this.f70479h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f70479h.has(entry.getKey())) {
                            this.f70479h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f70474c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f70479h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f70479h.get(next));
                    }
                    this.q.put("category", this.f70472a);
                    this.q.put("tag", this.f70473b);
                    this.q.put("value", this.f70476e);
                    this.q.put("ext_value", this.f70478g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f70480i != null) {
                        this.q = d.o.a.a.a.e.a.d(this.f70480i, this.q);
                    }
                    if (this.f70475d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f70477f)) {
                            this.q.put("log_extra", this.f70477f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f70475d) {
                    jSONObject.put("ad_extra_data", this.f70479h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f70477f)) {
                        jSONObject.put("log_extra", this.f70477f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f70479h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f70480i != null) {
                    jSONObject = d.o.a.a.a.e.a.d(this.f70480i, jSONObject);
                }
                this.f70479h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f70478g = j;
            return this;
        }

        public a k(String str) {
            this.f70474c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.f70480i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f70475d = z;
            return this;
        }

        public a o(String str) {
            this.f70477f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f70463a = aVar.f70472a;
        this.f70464b = aVar.f70473b;
        this.f70465c = aVar.f70474c;
        this.f70466d = aVar.f70475d;
        this.f70467e = aVar.f70476e;
        this.f70468f = aVar.f70477f;
        this.f70469g = aVar.f70478g;
        this.f70470h = aVar.f70479h;
        this.f70471i = aVar.f70480i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        return this.f70464b;
    }

    public String b() {
        return this.f70465c;
    }

    public boolean c() {
        return this.f70466d;
    }

    public JSONObject d() {
        return this.f70470h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f70463a);
        sb.append("\ttag: ");
        sb.append(this.f70464b);
        sb.append("\tlabel: ");
        sb.append(this.f70465c);
        sb.append("\nisAd: ");
        sb.append(this.f70466d);
        sb.append("\tadId: ");
        sb.append(this.f70467e);
        sb.append("\tlogExtra: ");
        sb.append(this.f70468f);
        sb.append("\textValue: ");
        sb.append(this.f70469g);
        sb.append("\nextJson: ");
        sb.append(this.f70470h);
        sb.append("\nparamsJson: ");
        sb.append(this.f70471i);
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
