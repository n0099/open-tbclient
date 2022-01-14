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
    public final String f59342b;

    /* renamed from: c  reason: collision with root package name */
    public final String f59343c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f59344d;

    /* renamed from: e  reason: collision with root package name */
    public final long f59345e;

    /* renamed from: f  reason: collision with root package name */
    public final String f59346f;

    /* renamed from: g  reason: collision with root package name */
    public final long f59347g;

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f59348h;

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f59349i;

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f59350j;
    public final int k;
    public final Object l;
    public final String m;
    public final boolean n;
    public final String o;
    public final JSONObject p;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59351b;

        /* renamed from: c  reason: collision with root package name */
        public String f59352c;

        /* renamed from: e  reason: collision with root package name */
        public long f59354e;

        /* renamed from: f  reason: collision with root package name */
        public String f59355f;

        /* renamed from: g  reason: collision with root package name */
        public long f59356g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f59357h;

        /* renamed from: i  reason: collision with root package name */
        public JSONObject f59358i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Object> f59359j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;

        /* renamed from: d  reason: collision with root package name */
        public boolean f59353d = false;
        public boolean o = false;

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public a b(String str) {
            this.f59352c = str;
            return this;
        }

        public a c(String str) {
            this.f59355f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(String str) {
            this.f59351b = str;
            return this;
        }

        public a b(long j2) {
            this.f59356g = j2;
            return this;
        }

        public a a(long j2) {
            this.f59354e = j2;
            return this;
        }

        public a b(boolean z) {
            this.f59353d = z;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f59357h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f59358i = jSONObject;
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
            if (this.f59357h == null) {
                this.f59357h = new JSONObject();
            }
            try {
                if (this.f59359j != null && !this.f59359j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f59359j.entrySet()) {
                        if (!this.f59357h.has(entry.getKey())) {
                            this.f59357h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.f59352c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.f59353d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f59357h.toString());
                    } else {
                        Iterator<String> keys = this.f59357h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.f59357h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.f59351b);
                    this.q.put("value", this.f59354e);
                    this.q.put("ext_value", this.f59356g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.f59358i != null) {
                        this.q = com.ss.android.download.api.c.b.a(this.f59358i, this.q);
                    }
                    if (this.f59353d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f59355f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f59355f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f59353d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.f59357h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f59355f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f59355f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.f59357h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.f59358i != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(this.f59358i, jSONObject);
                }
                this.f59357h = jSONObject;
            } catch (Exception e2) {
                j.s().a(e2, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f59342b = aVar.f59351b;
        this.f59343c = aVar.f59352c;
        this.f59344d = aVar.f59353d;
        this.f59345e = aVar.f59354e;
        this.f59346f = aVar.f59355f;
        this.f59347g = aVar.f59356g;
        this.f59348h = aVar.f59357h;
        this.f59349i = aVar.f59358i;
        this.f59350j = aVar.k;
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
        return this.f59342b;
    }

    public String c() {
        return this.f59343c;
    }

    public boolean d() {
        return this.f59344d;
    }

    public long e() {
        return this.f59345e;
    }

    public String f() {
        return this.f59346f;
    }

    public long g() {
        return this.f59347g;
    }

    public JSONObject h() {
        return this.f59348h;
    }

    public JSONObject i() {
        return this.f59349i;
    }

    public List<String> j() {
        return this.f59350j;
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
        sb.append(this.f59342b);
        sb.append("\tlabel: ");
        sb.append(this.f59343c);
        sb.append("\nisAd: ");
        sb.append(this.f59344d);
        sb.append("\tadId: ");
        sb.append(this.f59345e);
        sb.append("\tlogExtra: ");
        sb.append(this.f59346f);
        sb.append("\textValue: ");
        sb.append(this.f59347g);
        sb.append("\nextJson: ");
        sb.append(this.f59348h);
        sb.append("\nparamsJson: ");
        sb.append(this.f59349i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.f59350j;
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
