package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f57904b;

    /* renamed from: c  reason: collision with root package name */
    public final String f57905c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f57906d;

    /* renamed from: e  reason: collision with root package name */
    public final long f57907e;

    /* renamed from: f  reason: collision with root package name */
    public final String f57908f;

    /* renamed from: g  reason: collision with root package name */
    public final long f57909g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f57910h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f57911i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f57912j;
    public final int k;
    public final Object l;
    public final String m;
    public final boolean n;
    public final String o;
    public final JSONObject p;

    /* loaded from: classes8.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57913b;

        /* renamed from: c  reason: collision with root package name */
        public String f57914c;

        /* renamed from: e  reason: collision with root package name */
        public long f57916e;

        /* renamed from: f  reason: collision with root package name */
        public String f57917f;

        /* renamed from: g  reason: collision with root package name */
        public long f57918g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f57919h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f57920i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Object> f57921j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57915d = false;
        public boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f57914c = str;
            return this;
        }

        public a c(String str) {
            this.f57917f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.f57913b = str;
            return this;
        }

        public a b(long j2) {
            this.f57918g = j2;
            return this;
        }

        public a a(long j2) {
            this.f57916e = j2;
            return this;
        }

        public a b(boolean z) {
            this.f57915d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f57919h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f57920i = jSONObject;
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
            if (this.f57919h == null) {
                this.f57919h = new JSONObject();
            }
            try {
                if (this.f57921j != null && !this.f57921j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f57921j.entrySet()) {
                        if (!this.f57919h.has(entry.getKey())) {
                            this.f57919h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f57914c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f57915d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f57919h.toString());
                    } else {
                        Iterator<String> keys = this.f57919h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.f57919h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.f57913b);
                    this.q.put("value", this.f57916e);
                    this.q.put("ext_value", this.f57918g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f57920i != null) {
                        this.q = com.ss.android.download.api.c.b.a(this.f57920i, this.q);
                    }
                    if (this.f57915d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f57917f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f57917f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f57915d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f57919h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f57917f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f57917f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.f57919h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f57920i != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(this.f57920i, jSONObject);
                }
                this.f57919h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f57904b = aVar.f57913b;
        this.f57905c = aVar.f57914c;
        this.f57906d = aVar.f57915d;
        this.f57907e = aVar.f57916e;
        this.f57908f = aVar.f57917f;
        this.f57909g = aVar.f57918g;
        this.f57910h = aVar.f57919h;
        this.f57911i = aVar.f57920i;
        this.f57912j = aVar.k;
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
        return this.f57904b;
    }

    public String c() {
        return this.f57905c;
    }

    public boolean d() {
        return this.f57906d;
    }

    public long e() {
        return this.f57907e;
    }

    public String f() {
        return this.f57908f;
    }

    public long g() {
        return this.f57909g;
    }

    public JSONObject h() {
        return this.f57910h;
    }

    public JSONObject i() {
        return this.f57911i;
    }

    public List<String> j() {
        return this.f57912j;
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
        sb.append(this.f57904b);
        sb.append("\tlabel: ");
        sb.append(this.f57905c);
        sb.append("\nisAd: ");
        sb.append(this.f57906d);
        sb.append("\tadId: ");
        sb.append(this.f57907e);
        sb.append("\tlogExtra: ");
        sb.append(this.f57908f);
        sb.append("\textValue: ");
        sb.append(this.f57909g);
        sb.append("\nextJson: ");
        sb.append(this.f57910h);
        sb.append("\nparamsJson: ");
        sb.append(this.f57911i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f57912j;
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
