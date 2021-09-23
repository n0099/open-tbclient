package com.meizu.cloud.pushsdk.b.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.meizu.cloud.pushsdk.b.a.b;
import com.meizu.cloud.pushsdk.b.c.b;
import com.meizu.cloud.pushsdk.b.c.c;
import com.meizu.cloud.pushsdk.b.c.f;
import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.h;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.c.k;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f74798a = "b";
    public static final g w = g.a("application/json; charset=utf-8");
    public static final g x = g.a("text/x-markdown; charset=utf-8");
    public static final Object z = new Object();
    public com.meizu.cloud.pushsdk.b.c.a A;
    public int B;
    public boolean C;
    public int D;
    public com.meizu.cloud.pushsdk.b.d.a E;
    public Bitmap.Config F;
    public int G;
    public int H;
    public ImageView.ScaleType I;
    public Executor J;
    public String K;
    public Type L;

    /* renamed from: b  reason: collision with root package name */
    public int f74799b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f74800c;

    /* renamed from: d  reason: collision with root package name */
    public int f74801d;

    /* renamed from: e  reason: collision with root package name */
    public String f74802e;

    /* renamed from: f  reason: collision with root package name */
    public int f74803f;

    /* renamed from: g  reason: collision with root package name */
    public Object f74804g;

    /* renamed from: h  reason: collision with root package name */
    public e f74805h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f74806i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, String> f74807j;
    public HashMap<String, String> k;
    public HashMap<String, String> l;
    public HashMap<String, String> m;
    public HashMap<String, String> n;
    public HashMap<String, File> o;
    public String p;
    public String q;
    public JSONObject r;
    public JSONArray s;
    public String t;
    public byte[] u;
    public File v;
    public g y;

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f74809a;

        static {
            int[] iArr = new int[e.values().length];
            f74809a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f74809a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f74809a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f74809a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f74809a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f74811b;

        /* renamed from: c  reason: collision with root package name */
        public Object f74812c;

        /* renamed from: g  reason: collision with root package name */
        public String f74816g;

        /* renamed from: h  reason: collision with root package name */
        public String f74817h;

        /* renamed from: j  reason: collision with root package name */
        public Executor f74819j;
        public String k;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74810a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f74813d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f74814e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f74815f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f74818i = 0;

        public a(String str, String str2, String str3) {
            this.f74811b = str;
            this.f74816g = str2;
            this.f74817h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2039b<T extends C2039b> {

        /* renamed from: b  reason: collision with root package name */
        public int f74821b;

        /* renamed from: c  reason: collision with root package name */
        public String f74822c;

        /* renamed from: d  reason: collision with root package name */
        public Object f74823d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f74824e;

        /* renamed from: f  reason: collision with root package name */
        public int f74825f;

        /* renamed from: g  reason: collision with root package name */
        public int f74826g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f74827h;
        public Executor l;
        public String m;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74820a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f74828i = new HashMap<>();

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f74829j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C2039b(String str) {
            this.f74821b = 0;
            this.f74822c = str;
            this.f74821b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f74829j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class c<T extends c> {

        /* renamed from: b  reason: collision with root package name */
        public String f74831b;

        /* renamed from: c  reason: collision with root package name */
        public Object f74832c;

        /* renamed from: j  reason: collision with root package name */
        public Executor f74839j;
        public String k;
        public String l;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74830a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f74833d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f74834e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f74835f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f74836g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f74837h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f74838i = 0;

        public c(String str) {
            this.f74831b = str;
        }

        public T a(String str, File file) {
            this.f74837h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f74834e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class d<T extends d> {

        /* renamed from: b  reason: collision with root package name */
        public int f74841b;

        /* renamed from: c  reason: collision with root package name */
        public String f74842c;

        /* renamed from: d  reason: collision with root package name */
        public Object f74843d;
        public Executor o;
        public String p;
        public String q;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74840a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f74844e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f74845f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f74846g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f74847h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f74848i = null;

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f74849j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f74841b = 1;
            this.f74842c = str;
            this.f74841b = 1;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.k.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f74806i = new HashMap<>();
        this.f74807j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.J = null;
        this.K = null;
        this.L = null;
        this.f74801d = 1;
        this.f74799b = 0;
        this.f74800c = aVar.f74810a;
        this.f74802e = aVar.f74811b;
        this.f74804g = aVar.f74812c;
        this.p = aVar.f74816g;
        this.q = aVar.f74817h;
        this.f74806i = aVar.f74813d;
        this.m = aVar.f74814e;
        this.n = aVar.f74815f;
        this.D = aVar.f74818i;
        this.J = aVar.f74819j;
        this.K = aVar.k;
    }

    public b(C2039b c2039b) {
        this.f74806i = new HashMap<>();
        this.f74807j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.J = null;
        this.K = null;
        this.L = null;
        this.f74801d = 0;
        this.f74799b = c2039b.f74821b;
        this.f74800c = c2039b.f74820a;
        this.f74802e = c2039b.f74822c;
        this.f74804g = c2039b.f74823d;
        this.f74806i = c2039b.f74828i;
        this.F = c2039b.f74824e;
        this.H = c2039b.f74826g;
        this.G = c2039b.f74825f;
        this.I = c2039b.f74827h;
        this.m = c2039b.f74829j;
        this.n = c2039b.k;
        this.J = c2039b.l;
        this.K = c2039b.m;
    }

    public b(c cVar) {
        this.f74806i = new HashMap<>();
        this.f74807j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.J = null;
        this.K = null;
        this.L = null;
        this.f74801d = 2;
        this.f74799b = 1;
        this.f74800c = cVar.f74830a;
        this.f74802e = cVar.f74831b;
        this.f74804g = cVar.f74832c;
        this.f74806i = cVar.f74833d;
        this.m = cVar.f74835f;
        this.n = cVar.f74836g;
        this.l = cVar.f74834e;
        this.o = cVar.f74837h;
        this.D = cVar.f74838i;
        this.J = cVar.f74839j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f74806i = new HashMap<>();
        this.f74807j = new HashMap<>();
        this.k = new HashMap<>();
        this.l = new HashMap<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.D = 0;
        this.J = null;
        this.K = null;
        this.L = null;
        this.f74801d = 0;
        this.f74799b = dVar.f74841b;
        this.f74800c = dVar.f74840a;
        this.f74802e = dVar.f74842c;
        this.f74804g = dVar.f74843d;
        this.f74806i = dVar.f74849j;
        this.f74807j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f74844e;
        this.s = dVar.f74845f;
        this.t = dVar.f74846g;
        this.v = dVar.f74848i;
        this.u = dVar.f74847h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f74805h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.f74809a[this.f74805h.ordinal()];
        if (i2 == 1) {
            try {
                return com.meizu.cloud.pushsdk.b.a.c.a(new JSONArray(com.meizu.cloud.pushsdk.b.g.g.a(kVar.b().a()).h()));
            } catch (Exception e2) {
                return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e2)));
            }
        } else if (i2 == 2) {
            try {
                return com.meizu.cloud.pushsdk.b.a.c.a(new JSONObject(com.meizu.cloud.pushsdk.b.g.g.a(kVar.b().a()).h()));
            } catch (Exception e3) {
                return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e3)));
            }
        } else if (i2 == 3) {
            try {
                return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.g.g.a(kVar.b().a()).h());
            } catch (Exception e4) {
                return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e4)));
            }
        } else if (i2 != 4) {
            if (i2 != 5) {
                return null;
            }
            return com.meizu.cloud.pushsdk.b.a.c.a(PrefetchEvent.MODULE);
        } else {
            synchronized (z) {
                try {
                    try {
                        a2 = com.meizu.cloud.pushsdk.b.i.b.a(kVar, this.G, this.H, this.F, this.I);
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Exception e5) {
                    return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e5)));
                }
            }
            return a2;
        }
    }

    public com.meizu.cloud.pushsdk.b.b.a a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        try {
            if (aVar.a() != null && aVar.a().b() != null && aVar.a().b().a() != null) {
                aVar.b(com.meizu.cloud.pushsdk.b.g.g.a(aVar.a().b().a()).h());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public void a(com.meizu.cloud.pushsdk.b.c.a aVar) {
        this.A = aVar;
    }

    public void a(String str) {
        this.K = str;
    }

    public com.meizu.cloud.pushsdk.b.a.c b() {
        this.f74805h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f74799b;
    }

    public String e() {
        String str = this.f74802e;
        for (Map.Entry<String, String> entry : this.n.entrySet()) {
            str = str.replace(StringUtil.ARRAY_START + entry.getKey() + "}", String.valueOf(entry.getValue()));
        }
        f.a g2 = f.c(str).g();
        for (Map.Entry<String, String> entry2 : this.m.entrySet()) {
            g2.a(entry2.getKey(), entry2.getValue());
        }
        return g2.b().toString();
    }

    public e f() {
        return this.f74805h;
    }

    public int g() {
        return this.f74801d;
    }

    public String h() {
        return this.K;
    }

    public com.meizu.cloud.pushsdk.b.d.a i() {
        return new com.meizu.cloud.pushsdk.b.d.a() { // from class: com.meizu.cloud.pushsdk.b.a.b.1
            @Override // com.meizu.cloud.pushsdk.b.d.a
            public void a(long j2, long j3) {
                b.this.B = (int) ((100 * j2) / j3);
                if (b.this.E == null || b.this.C) {
                    return;
                }
                b.this.E.a(j2, j3);
            }
        };
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.q;
    }

    public com.meizu.cloud.pushsdk.b.c.a l() {
        return this.A;
    }

    public j m() {
        JSONObject jSONObject = this.r;
        if (jSONObject != null) {
            g gVar = this.y;
            return gVar != null ? j.a(gVar, jSONObject.toString()) : j.a(w, jSONObject.toString());
        }
        JSONArray jSONArray = this.s;
        if (jSONArray != null) {
            g gVar2 = this.y;
            return gVar2 != null ? j.a(gVar2, jSONArray.toString()) : j.a(w, jSONArray.toString());
        }
        String str = this.t;
        if (str != null) {
            g gVar3 = this.y;
            return gVar3 != null ? j.a(gVar3, str) : j.a(x, str);
        }
        File file = this.v;
        if (file != null) {
            g gVar4 = this.y;
            return gVar4 != null ? j.a(gVar4, file) : j.a(x, file);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            g gVar5 = this.y;
            return gVar5 != null ? j.a(gVar5, bArr) : j.a(x, bArr);
        }
        b.a aVar = new b.a();
        try {
            for (Map.Entry<String, String> entry : this.f74807j.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    aVar.a(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.k.entrySet()) {
                if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                    aVar.b(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public j n() {
        h.a a2 = new h.a().a(h.f74915e);
        try {
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.b.c.c.a("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), j.a((g) null, entry.getValue()));
            }
            for (Map.Entry<String, File> entry2 : this.o.entrySet()) {
                if (entry2.getValue() != null) {
                    String name = entry2.getValue().getName();
                    j a3 = j.a(g.a(com.meizu.cloud.pushsdk.b.i.b.a(name)), entry2.getValue());
                    a2.a(com.meizu.cloud.pushsdk.b.c.c.a("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), a3);
                    if (this.y != null) {
                        a2.a(this.y);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.b.c.c o() {
        c.a aVar = new c.a();
        try {
            for (Map.Entry<String, String> entry : this.f74806i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f74803f + ", mMethod=" + this.f74799b + ", mPriority=" + this.f74800c + ", mRequestType=" + this.f74801d + ", mUrl=" + this.f74802e + ExtendedMessageFormat.END_FE;
    }
}
