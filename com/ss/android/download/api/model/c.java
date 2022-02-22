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
    public final String f59554b;

    /* renamed from: c  reason: collision with root package name */
    public final String f59555c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f59556d;

    /* renamed from: e  reason: collision with root package name */
    public final long f59557e;

    /* renamed from: f  reason: collision with root package name */
    public final String f59558f;

    /* renamed from: g  reason: collision with root package name */
    public final long f59559g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f59560h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f59561i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f59562j;
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
        public String f59563b;

        /* renamed from: c  reason: collision with root package name */
        public String f59564c;

        /* renamed from: e  reason: collision with root package name */
        public long f59566e;

        /* renamed from: f  reason: collision with root package name */
        public String f59567f;

        /* renamed from: g  reason: collision with root package name */
        public long f59568g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f59569h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f59570i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Object> f59571j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f59565d = false;
        public boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f59564c = str;
            return this;
        }

        public a c(String str) {
            this.f59567f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.f59563b = str;
            return this;
        }

        public a b(long j2) {
            this.f59568g = j2;
            return this;
        }

        public a a(long j2) {
            this.f59566e = j2;
            return this;
        }

        public a b(boolean z) {
            this.f59565d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f59569h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f59570i = jSONObject;
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
            if (this.f59569h == null) {
                this.f59569h = new JSONObject();
            }
            try {
                if (this.f59571j != null && !this.f59571j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f59571j.entrySet()) {
                        if (!this.f59569h.has(entry.getKey())) {
                            this.f59569h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f59564c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f59565d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f59569h.toString());
                    } else {
                        Iterator<String> keys = this.f59569h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.f59569h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.f59563b);
                    this.q.put("value", this.f59566e);
                    this.q.put("ext_value", this.f59568g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f59570i != null) {
                        this.q = com.ss.android.download.api.c.b.a(this.f59570i, this.q);
                    }
                    if (this.f59565d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f59567f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f59567f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f59565d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f59569h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f59567f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f59567f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.f59569h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f59570i != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(this.f59570i, jSONObject);
                }
                this.f59569h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f59554b = aVar.f59563b;
        this.f59555c = aVar.f59564c;
        this.f59556d = aVar.f59565d;
        this.f59557e = aVar.f59566e;
        this.f59558f = aVar.f59567f;
        this.f59559g = aVar.f59568g;
        this.f59560h = aVar.f59569h;
        this.f59561i = aVar.f59570i;
        this.f59562j = aVar.k;
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
        return this.f59554b;
    }

    public String c() {
        return this.f59555c;
    }

    public boolean d() {
        return this.f59556d;
    }

    public long e() {
        return this.f59557e;
    }

    public String f() {
        return this.f59558f;
    }

    public long g() {
        return this.f59559g;
    }

    public JSONObject h() {
        return this.f59560h;
    }

    public JSONObject i() {
        return this.f59561i;
    }

    public List<String> j() {
        return this.f59562j;
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
        sb.append(this.f59554b);
        sb.append("\tlabel: ");
        sb.append(this.f59555c);
        sb.append("\nisAd: ");
        sb.append(this.f59556d);
        sb.append("\tadId: ");
        sb.append(this.f59557e);
        sb.append("\tlogExtra: ");
        sb.append(this.f59558f);
        sb.append("\textValue: ");
        sb.append(this.f59559g);
        sb.append("\nextJson: ");
        sb.append(this.f59560h);
        sb.append("\nparamsJson: ");
        sb.append(this.f59561i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f59562j;
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
