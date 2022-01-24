package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f59387b;

    /* renamed from: c  reason: collision with root package name */
    public final String f59388c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f59389d;

    /* renamed from: e  reason: collision with root package name */
    public final long f59390e;

    /* renamed from: f  reason: collision with root package name */
    public final String f59391f;

    /* renamed from: g  reason: collision with root package name */
    public final long f59392g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f59393h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f59394i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f59395j;
    public final int k;
    public final Object l;
    public final String m;
    public final boolean n;
    public final String o;
    public final JSONObject p;

    /* loaded from: classes4.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59396b;

        /* renamed from: c  reason: collision with root package name */
        public String f59397c;

        /* renamed from: e  reason: collision with root package name */
        public long f59399e;

        /* renamed from: f  reason: collision with root package name */
        public String f59400f;

        /* renamed from: g  reason: collision with root package name */
        public long f59401g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f59402h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f59403i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Object> f59404j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f59398d = false;
        public boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f59397c = str;
            return this;
        }

        public a c(String str) {
            this.f59400f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.f59396b = str;
            return this;
        }

        public a b(long j2) {
            this.f59401g = j2;
            return this;
        }

        public a a(long j2) {
            this.f59399e = j2;
            return this;
        }

        public a b(boolean z) {
            this.f59398d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f59402h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f59403i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.k = list;
            return this;
        }

        public a a(int i2) {
            this.l = i2;
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
            if (this.f59402h == null) {
                this.f59402h = new JSONObject();
            }
            try {
                if (this.f59404j != null && !this.f59404j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f59404j.entrySet()) {
                        if (!this.f59402h.has(entry.getKey())) {
                            this.f59402h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f59397c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f59398d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f59402h.toString());
                    } else {
                        Iterator<String> keys = this.f59402h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.f59402h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.f59396b);
                    this.q.put("value", this.f59399e);
                    this.q.put("ext_value", this.f59401g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f59403i != null) {
                        this.q = com.ss.android.download.api.c.b.a(this.f59403i, this.q);
                    }
                    if (this.f59398d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f59400f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f59400f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f59398d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f59402h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f59400f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f59400f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.f59402h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f59403i != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(this.f59403i, jSONObject);
                }
                this.f59402h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f59387b = aVar.f59396b;
        this.f59388c = aVar.f59397c;
        this.f59389d = aVar.f59398d;
        this.f59390e = aVar.f59399e;
        this.f59391f = aVar.f59400f;
        this.f59392g = aVar.f59401g;
        this.f59393h = aVar.f59402h;
        this.f59394i = aVar.f59403i;
        this.f59395j = aVar.k;
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
        return this.f59387b;
    }

    public String c() {
        return this.f59388c;
    }

    public boolean d() {
        return this.f59389d;
    }

    public long e() {
        return this.f59390e;
    }

    public String f() {
        return this.f59391f;
    }

    public long g() {
        return this.f59392g;
    }

    public JSONObject h() {
        return this.f59393h;
    }

    public JSONObject i() {
        return this.f59394i;
    }

    public List<String> j() {
        return this.f59395j;
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
        sb.append(this.f59387b);
        sb.append("\tlabel: ");
        sb.append(this.f59388c);
        sb.append("\nisAd: ");
        sb.append(this.f59389d);
        sb.append("\tadId: ");
        sb.append(this.f59390e);
        sb.append("\tlogExtra: ");
        sb.append(this.f59391f);
        sb.append("\textValue: ");
        sb.append(this.f59392g);
        sb.append("\nextJson: ");
        sb.append(this.f59393h);
        sb.append("\nparamsJson: ");
        sb.append(this.f59394i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f59395j;
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
