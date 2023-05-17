package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final long e;
    public final String f;
    public final long g;
    public final JSONObject h;
    public final JSONObject i;
    public final List<String> j;
    public final int k;
    public final Object l;
    public final String m;
    public final boolean n;
    public final String o;
    public final JSONObject p;

    public c(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.k;
        this.k = aVar.l;
        this.l = aVar.m;
        this.n = aVar.o;
        this.o = aVar.p;
        this.p = aVar.q;
        this.m = aVar.n;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public String a;
        public String b;
        public String c;
        public long e;
        public String f;
        public long g;
        public JSONObject h;
        public JSONObject i;
        public Map<String, Object> j;
        public List<String> k;
        public int l;
        public Object m;
        public String n;
        public String p;
        public JSONObject q;
        public boolean d = false;
        public boolean o = false;

        public a a(int i) {
            this.l = i;
            return this;
        }

        public a b(long j) {
            this.g = j;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.n = str;
            return this;
        }

        public a a(long j) {
            this.e = j;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(Object obj) {
            this.m = obj;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.i = jSONObject;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(boolean z) {
            this.d = z;
            return this;
        }

        public a a(List<String> list) {
            this.k = list;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public a a(boolean z) {
            this.o = z;
            return this;
        }

        public c a() {
            if (TextUtils.isEmpty(this.a)) {
                this.a = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                if (this.j != null && !this.j.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.j.entrySet()) {
                        if (!this.h.has(entry.getKey())) {
                            this.h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.o) {
                    this.p = this.c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.q = jSONObject2;
                    if (this.d) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.h.toString());
                    } else {
                        Iterator<String> keys = this.h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.q.put(next, this.h.get(next));
                        }
                    }
                    this.q.put("category", this.a);
                    this.q.put("tag", this.b);
                    this.q.put("value", this.e);
                    this.q.put("ext_value", this.g);
                    if (!TextUtils.isEmpty(this.n)) {
                        this.q.put(TiebaStatic.Params.REFER, this.n);
                    }
                    if (this.i != null) {
                        this.q = com.ss.android.download.api.c.b.a(this.i, this.q);
                    }
                    if (this.d) {
                        if (!this.q.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f)) {
                            this.q.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f);
                        }
                        this.q.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.d) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.h.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.f)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.f);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.h);
                }
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.putOpt(TiebaStatic.Params.REFER, this.n);
                }
                if (this.i != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(this.i, jSONObject);
                }
                this.h = jSONObject;
            } catch (Exception e) {
                j.s().a(e, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public long g() {
        return this.g;
    }

    public JSONObject h() {
        return this.h;
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
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.a);
        sb.append("\ttag: ");
        sb.append(this.b);
        sb.append("\tlabel: ");
        sb.append(this.c);
        sb.append("\nisAd: ");
        sb.append(this.d);
        sb.append("\tadId: ");
        sb.append(this.e);
        sb.append("\tlogExtra: ");
        sb.append(this.f);
        sb.append("\textValue: ");
        sb.append(this.g);
        sb.append("\nextJson: ");
        sb.append(this.h);
        sb.append("\nparamsJson: ");
        sb.append(this.i);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.j;
        String str3 = "";
        if (list == null) {
            str = "";
        } else {
            str = list.toString();
        }
        sb.append(str);
        sb.append("\teventSource: ");
        sb.append(this.k);
        sb.append("\textraObject: ");
        Object obj = this.l;
        if (obj == null) {
            str2 = "";
        } else {
            str2 = obj.toString();
        }
        sb.append(str2);
        sb.append("\nisV3: ");
        sb.append(this.n);
        sb.append("\tV3EventName: ");
        sb.append(this.o);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.p;
        if (jSONObject != null) {
            str3 = jSONObject.toString();
        }
        sb.append(str3);
        return sb.toString();
    }
}
