package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f61678b;

    /* renamed from: c  reason: collision with root package name */
    public final String f61679c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f61680d;

    /* renamed from: e  reason: collision with root package name */
    public final long f61681e;

    /* renamed from: f  reason: collision with root package name */
    public final String f61682f;

    /* renamed from: g  reason: collision with root package name */
    public final long f61683g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f61684h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f61685i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f61686j;

    /* renamed from: k  reason: collision with root package name */
    public final int f61687k;
    public final Object l;
    public final String m;
    public final boolean n;
    public final String o;
    public final JSONObject p;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f61688b;

        /* renamed from: c  reason: collision with root package name */
        public String f61689c;

        /* renamed from: e  reason: collision with root package name */
        public long f61691e;

        /* renamed from: f  reason: collision with root package name */
        public String f61692f;

        /* renamed from: g  reason: collision with root package name */
        public long f61693g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f61694h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f61695i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Object> f61696j;

        /* renamed from: k  reason: collision with root package name */
        public List<String> f61697k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f61690d = false;
        public boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f61689c = str;
            return this;
        }

        public a c(String str) {
            this.f61692f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.f61688b = str;
            return this;
        }

        public a b(long j2) {
            this.f61693g = j2;
            return this;
        }

        public a a(long j2) {
            this.f61691e = j2;
            return this;
        }

        public a b(boolean z) {
            this.f61690d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f61694h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f61695i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.f61697k = list;
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
            if (this.f61694h == null) {
                this.f61694h = new JSONObject();
            }
            try {
                if (this.f61696j != null && !this.f61696j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f61696j.entrySet()) {
                        if (!this.f61694h.has(entry.getKey())) {
                            this.f61694h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f61689c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f61690d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f61694h.toString());
                    } else {
                        Iterator<String> keys = this.f61694h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.f61694h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.f61688b);
                    this.q.put("value", this.f61691e);
                    this.q.put("ext_value", this.f61693g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f61695i != null) {
                        this.q = com.ss.android.download.api.c.b.a(this.f61695i, this.q);
                    }
                    if (this.f61690d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f61692f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f61692f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f61690d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f61694h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f61692f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f61692f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.f61694h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f61695i != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(this.f61695i, jSONObject);
                }
                this.f61694h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f61678b = aVar.f61688b;
        this.f61679c = aVar.f61689c;
        this.f61680d = aVar.f61690d;
        this.f61681e = aVar.f61691e;
        this.f61682f = aVar.f61692f;
        this.f61683g = aVar.f61693g;
        this.f61684h = aVar.f61694h;
        this.f61685i = aVar.f61695i;
        this.f61686j = aVar.f61697k;
        this.f61687k = aVar.l;
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
        return this.f61678b;
    }

    public String c() {
        return this.f61679c;
    }

    public boolean d() {
        return this.f61680d;
    }

    public long e() {
        return this.f61681e;
    }

    public String f() {
        return this.f61682f;
    }

    public long g() {
        return this.f61683g;
    }

    public JSONObject h() {
        return this.f61684h;
    }

    public JSONObject i() {
        return this.f61685i;
    }

    public List<String> j() {
        return this.f61686j;
    }

    public int k() {
        return this.f61687k;
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
        sb.append(this.f61678b);
        sb.append("\tlabel: ");
        sb.append(this.f61679c);
        sb.append("\nisAd: ");
        sb.append(this.f61680d);
        sb.append("\tadId: ");
        sb.append(this.f61681e);
        sb.append("\tlogExtra: ");
        sb.append(this.f61682f);
        sb.append("\textValue: ");
        sb.append(this.f61683g);
        sb.append("\nextJson: ");
        sb.append(this.f61684h);
        sb.append("\nparamsJson: ");
        sb.append(this.f61685i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f61686j;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.f61687k);
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
