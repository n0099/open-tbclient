package com.ss.android.a.a.d;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f12903a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12904b;
    private final String c;
    private final boolean d;
    private final long e;
    private final String f;
    private final long g;
    private final JSONObject h;
    private final List<String> i;
    private final int j;
    private final Object k;
    private final String l;
    private final boolean m;
    private final String n;
    private final JSONObject o;

    d(a aVar) {
        this.f12903a = aVar.f12905a;
        this.f12904b = aVar.f12906b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.j;
        this.j = aVar.k;
        this.k = aVar.l;
        this.m = aVar.n;
        this.n = aVar.o;
        this.o = aVar.asz;
        this.l = aVar.m;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f12905a;
        private JSONObject asz;

        /* renamed from: b  reason: collision with root package name */
        private String f12906b;
        private String c;
        private long e;
        private String f;
        private long g;
        private JSONObject h;
        private Map<String, Object> i;
        private List<String> j;
        private int k;
        private Object l;
        private String m;
        private String o;
        private boolean d = false;
        private boolean n = false;

        public a BK(boolean z) {
            this.n = z;
            return this;
        }

        public a aaj(String str) {
            this.f12906b = str;
            return this;
        }

        public a aak(String str) {
            this.c = str;
            return this;
        }

        public a iW(long j) {
            this.e = j;
            return this;
        }

        public a iX(long j) {
            this.g = j;
            return this;
        }

        public a aal(String str) {
            this.f = str;
            return this;
        }

        public a BL(boolean z) {
            this.d = z;
            return this;
        }

        public a fa(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public a gU(List<String> list) {
            this.j = list;
            return this;
        }

        public a QM(int i) {
            this.k = i;
            return this;
        }

        public a bF(Object obj) {
            this.l = obj;
            return this;
        }

        public a aam(String str) {
            this.m = str;
            return this;
        }

        public d eEd() {
            if (TextUtils.isEmpty(this.f12905a)) {
                this.f12905a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                if (this.i != null && !this.i.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.i.entrySet()) {
                        if (!this.h.has(entry.getKey())) {
                            this.h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.n) {
                    this.o = this.c;
                    this.asz = new JSONObject();
                    Iterator<String> keys = this.h.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.asz.put(next, this.h.get(next));
                    }
                    this.asz.put("category", this.f12905a);
                    this.asz.put("tag", this.f12906b);
                    this.asz.put("value", this.e);
                    this.asz.put("ext_value", this.g);
                    if (!TextUtils.isEmpty(this.m)) {
                        this.asz.put("refer", this.m);
                    }
                    if (this.d) {
                        if (!this.asz.has("log_extra") && !TextUtils.isEmpty(this.f)) {
                            this.asz.put("log_extra", this.f);
                        }
                        this.asz.put("is_ad_event", "1");
                    }
                }
                if (this.d) {
                    jSONObject.put("ad_extra_data", this.h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f)) {
                        jSONObject.put("log_extra", this.f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.h);
                }
                if (!TextUtils.isEmpty(this.m)) {
                    jSONObject.putOpt("refer", this.m);
                }
                this.h = jSONObject;
            } catch (Exception e) {
            }
            return new d(this);
        }
    }

    public String a() {
        return this.f12904b;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public JSONObject d() {
        return this.h;
    }

    public boolean e() {
        return this.m;
    }

    public String toString() {
        return "category: " + this.f12903a + "\ttag: " + this.f12904b + "\tlabel: " + this.c + "\nisAd: " + this.d + "\tadId: " + this.e + "\tlogExtra: " + this.f + "\textValue: " + this.g + "\nextJson: " + this.h + "\nclickTrackUrl: " + (this.i != null ? this.i.toString() : "") + "\teventSource: " + this.j + "\textraObject: " + (this.k != null ? this.k.toString() : "") + "\nisV3: " + this.m + "\tV3EventName: " + this.n + "\tV3EventParams: " + (this.o != null ? this.o.toString() : "");
    }
}
