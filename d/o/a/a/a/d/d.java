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
    public String f66530a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66531b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66532c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f66533d;

    /* renamed from: e  reason: collision with root package name */
    public final long f66534e;

    /* renamed from: f  reason: collision with root package name */
    public final String f66535f;

    /* renamed from: g  reason: collision with root package name */
    public final long f66536g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f66537h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f66538i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final boolean m;
    public final String n;
    public final JSONObject o;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f66539a;

        /* renamed from: b  reason: collision with root package name */
        public String f66540b;

        /* renamed from: c  reason: collision with root package name */
        public String f66541c;

        /* renamed from: e  reason: collision with root package name */
        public long f66543e;

        /* renamed from: f  reason: collision with root package name */
        public String f66544f;

        /* renamed from: g  reason: collision with root package name */
        public long f66545g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f66546h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f66547i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66542d = false;
        public boolean o = false;

        public a a(int i2) {
            this.l = i2;
            return this;
        }

        public a b(long j) {
            this.f66543e = j;
            return this;
        }

        public a c(Object obj) {
            this.m = obj;
            return this;
        }

        public a d(String str) {
            this.f66540b = str;
            return this;
        }

        public a e(List<String> list) {
            this.k = list;
            return this;
        }

        public a f(JSONObject jSONObject) {
            this.f66546h = jSONObject;
            return this;
        }

        public a g(boolean z) {
            this.o = z;
            return this;
        }

        public d h() {
            if (TextUtils.isEmpty(this.f66539a)) {
                this.f66539a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f66546h == null) {
                this.f66546h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f66546h.has(entry.getKey())) {
                            this.f66546h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f66541c;
                    this.q = new JSONObject();
                    Iterator<String> keys = this.f66546h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.q.put(next, this.f66546h.get(next));
                    }
                    this.q.put("category", this.f66539a);
                    this.q.put("tag", this.f66540b);
                    this.q.put("value", this.f66543e);
                    this.q.put("ext_value", this.f66545g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f66547i != null) {
                        this.q = d.o.a.a.a.e.a.d(this.f66547i, this.q);
                    }
                    if (this.f66542d) {
                        if (!this.q.has("log_extra") && !TextUtils.isEmpty(this.f66544f)) {
                            this.q.put("log_extra", this.f66544f);
                        }
                        this.q.put("is_ad_event", "1");
                    }
                }
                if (this.f66542d) {
                    jSONObject.put("ad_extra_data", this.f66546h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f66544f)) {
                        jSONObject.put("log_extra", this.f66544f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f66546h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f66547i != null) {
                    jSONObject = d.o.a.a.a.e.a.d(this.f66547i, jSONObject);
                }
                this.f66546h = jSONObject;
            } catch (Exception unused) {
            }
            return new d(this);
        }

        public a j(long j) {
            this.f66545g = j;
            return this;
        }

        public a k(String str) {
            this.f66541c = str;
            return this;
        }

        public a l(JSONObject jSONObject) {
            this.f66547i = jSONObject;
            return this;
        }

        public a m(boolean z) {
            this.f66542d = z;
            return this;
        }

        public a o(String str) {
            this.f66544f = str;
            return this;
        }

        public a q(String str) {
            this.n = str;
            return this;
        }
    }

    public d(a aVar) {
        this.f66530a = aVar.f66539a;
        this.f66531b = aVar.f66540b;
        this.f66532c = aVar.f66541c;
        this.f66533d = aVar.f66542d;
        this.f66534e = aVar.f66543e;
        this.f66535f = aVar.f66544f;
        this.f66536g = aVar.f66545g;
        this.f66537h = aVar.f66546h;
        this.f66538i = aVar.f66547i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.m = aVar.o;
        this.n = aVar.p;
        this.o = aVar.q;
        String unused = aVar.n;
    }

    public String a() {
        return this.f66531b;
    }

    public String b() {
        return this.f66532c;
    }

    public boolean c() {
        return this.f66533d;
    }

    public JSONObject d() {
        return this.f66537h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f66530a);
        sb.append("\ttag: ");
        sb.append(this.f66531b);
        sb.append("\tlabel: ");
        sb.append(this.f66532c);
        sb.append("\nisAd: ");
        sb.append(this.f66533d);
        sb.append("\tadId: ");
        sb.append(this.f66534e);
        sb.append("\tlogExtra: ");
        sb.append(this.f66535f);
        sb.append("\textValue: ");
        sb.append(this.f66536g);
        sb.append("\nextJson: ");
        sb.append(this.f66537h);
        sb.append("\nparamsJson: ");
        sb.append(this.f66538i);
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
