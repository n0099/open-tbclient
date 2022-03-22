package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42663b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42664c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f42665d;

    /* renamed from: e  reason: collision with root package name */
    public final long f42666e;

    /* renamed from: f  reason: collision with root package name */
    public final String f42667f;

    /* renamed from: g  reason: collision with root package name */
    public final long f42668g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f42669h;
    public final JSONObject i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final String m;
    public final boolean n;
    public final String o;
    public final JSONObject p;

    /* loaded from: classes7.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f42670b;

        /* renamed from: c  reason: collision with root package name */
        public String f42671c;

        /* renamed from: e  reason: collision with root package name */
        public long f42673e;

        /* renamed from: f  reason: collision with root package name */
        public String f42674f;

        /* renamed from: g  reason: collision with root package name */
        public long f42675g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f42676h;
        public JSONObject i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f42672d = false;
        public boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f42671c = str;
            return this;
        }

        public a c(String str) {
            this.f42674f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.f42670b = str;
            return this;
        }

        public a b(long j) {
            this.f42675g = j;
            return this;
        }

        public a a(long j) {
            this.f42673e = j;
            return this;
        }

        public a b(boolean z) {
            this.f42672d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f42676h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.k = list;
            return this;
        }

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a a(Object obj) {
            this.m = obj;
            return this;
        }

        public c a() {
            if (TextUtils.isEmpty(this.a)) {
                this.a = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f42676h == null) {
                this.f42676h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.f42676h.has(entry.getKey())) {
                            this.f42676h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f42671c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f42672d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f42676h.toString());
                    } else {
                        Iterator<String> keys = this.f42676h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.f42676h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.f42670b);
                    this.q.put("value", this.f42673e);
                    this.q.put("ext_value", this.f42675g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.i != null) {
                        this.q = com.ss.android.download.api.c.b.a(this.i, this.q);
                    }
                    if (this.f42672d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f42674f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f42674f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f42672d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f42676h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f42674f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f42674f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.f42676h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.i != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(this.i, jSONObject);
                }
                this.f42676h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f42663b = aVar.f42670b;
        this.f42664c = aVar.f42671c;
        this.f42665d = aVar.f42672d;
        this.f42666e = aVar.f42673e;
        this.f42667f = aVar.f42674f;
        this.f42668g = aVar.f42675g;
        this.f42669h = aVar.f42676h;
        this.i = aVar.i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.m = aVar.n;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.f42663b;
    }

    public String c() {
        return this.f42664c;
    }

    public boolean d() {
        return this.f42665d;
    }

    public long e() {
        return this.f42666e;
    }

    public String f() {
        return this.f42667f;
    }

    public long g() {
        return this.f42668g;
    }

    public JSONObject h() {
        return this.f42669h;
    }

    public JSONObject i() {
        return this.i;
    }

    public List<String> j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public Object l() {
        return this.l;
    }

    public boolean m() {
        return this.n;
    }

    public String n() {
        return this.o;
    }

    public JSONObject o() {
        return this.p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.a);
        sb.append("\ttag: ");
        sb.append(this.f42663b);
        sb.append("\tlabel: ");
        sb.append(this.f42664c);
        sb.append("\nisAd: ");
        sb.append(this.f42665d);
        sb.append("\tadId: ");
        sb.append(this.f42666e);
        sb.append("\tlogExtra: ");
        sb.append(this.f42667f);
        sb.append("\textValue: ");
        sb.append(this.f42668g);
        sb.append("\nextJson: ");
        sb.append(this.f42669h);
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
        sb.append(this.n);
        sb.append("\tV3EventName: ");
        sb.append(this.o);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.p;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }
}
