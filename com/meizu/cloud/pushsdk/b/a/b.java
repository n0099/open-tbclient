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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40061a = "b";
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
    public int f40062b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f40063c;

    /* renamed from: d  reason: collision with root package name */
    public int f40064d;

    /* renamed from: e  reason: collision with root package name */
    public String f40065e;

    /* renamed from: f  reason: collision with root package name */
    public int f40066f;

    /* renamed from: g  reason: collision with root package name */
    public Object f40067g;

    /* renamed from: h  reason: collision with root package name */
    public e f40068h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f40069i;
    public HashMap<String, String> j;
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
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40071a;

        static {
            int[] iArr = new int[e.values().length];
            f40071a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40071a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40071a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40071a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40071a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f40073b;

        /* renamed from: c  reason: collision with root package name */
        public Object f40074c;

        /* renamed from: g  reason: collision with root package name */
        public String f40078g;

        /* renamed from: h  reason: collision with root package name */
        public String f40079h;
        public Executor j;
        public String k;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f40072a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f40075d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f40076e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f40077f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f40080i = 0;

        public a(String str, String str2, String str3) {
            this.f40073b = str;
            this.f40078g = str2;
            this.f40079h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0501b<T extends C0501b> {

        /* renamed from: b  reason: collision with root package name */
        public int f40082b;

        /* renamed from: c  reason: collision with root package name */
        public String f40083c;

        /* renamed from: d  reason: collision with root package name */
        public Object f40084d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f40085e;

        /* renamed from: f  reason: collision with root package name */
        public int f40086f;

        /* renamed from: g  reason: collision with root package name */
        public int f40087g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f40088h;
        public Executor l;
        public String m;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f40081a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f40089i = new HashMap<>();
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C0501b(String str) {
            this.f40082b = 0;
            this.f40083c = str;
            this.f40082b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes7.dex */
    public static class c<T extends c> {

        /* renamed from: b  reason: collision with root package name */
        public String f40091b;

        /* renamed from: c  reason: collision with root package name */
        public Object f40092c;
        public Executor j;
        public String k;
        public String l;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f40090a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f40093d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f40094e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f40095f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f40096g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f40097h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f40098i = 0;

        public c(String str) {
            this.f40091b = str;
        }

        public T a(String str, File file) {
            this.f40097h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f40094e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes7.dex */
    public static class d<T extends d> {

        /* renamed from: b  reason: collision with root package name */
        public int f40100b;

        /* renamed from: c  reason: collision with root package name */
        public String f40101c;

        /* renamed from: d  reason: collision with root package name */
        public Object f40102d;
        public Executor o;
        public String p;
        public String q;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f40099a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f40103e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f40104f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f40105g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f40106h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f40107i = null;
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f40100b = 1;
            this.f40101c = str;
            this.f40100b = 1;
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
        this.f40069i = new HashMap<>();
        this.j = new HashMap<>();
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
        this.f40064d = 1;
        this.f40062b = 0;
        this.f40063c = aVar.f40072a;
        this.f40065e = aVar.f40073b;
        this.f40067g = aVar.f40074c;
        this.p = aVar.f40078g;
        this.q = aVar.f40079h;
        this.f40069i = aVar.f40075d;
        this.m = aVar.f40076e;
        this.n = aVar.f40077f;
        this.D = aVar.f40080i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(C0501b c0501b) {
        this.f40069i = new HashMap<>();
        this.j = new HashMap<>();
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
        this.f40064d = 0;
        this.f40062b = c0501b.f40082b;
        this.f40063c = c0501b.f40081a;
        this.f40065e = c0501b.f40083c;
        this.f40067g = c0501b.f40084d;
        this.f40069i = c0501b.f40089i;
        this.F = c0501b.f40085e;
        this.H = c0501b.f40087g;
        this.G = c0501b.f40086f;
        this.I = c0501b.f40088h;
        this.m = c0501b.j;
        this.n = c0501b.k;
        this.J = c0501b.l;
        this.K = c0501b.m;
    }

    public b(c cVar) {
        this.f40069i = new HashMap<>();
        this.j = new HashMap<>();
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
        this.f40064d = 2;
        this.f40062b = 1;
        this.f40063c = cVar.f40090a;
        this.f40065e = cVar.f40091b;
        this.f40067g = cVar.f40092c;
        this.f40069i = cVar.f40093d;
        this.m = cVar.f40095f;
        this.n = cVar.f40096g;
        this.l = cVar.f40094e;
        this.o = cVar.f40097h;
        this.D = cVar.f40098i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f40069i = new HashMap<>();
        this.j = new HashMap<>();
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
        this.f40064d = 0;
        this.f40062b = dVar.f40100b;
        this.f40063c = dVar.f40099a;
        this.f40065e = dVar.f40101c;
        this.f40067g = dVar.f40102d;
        this.f40069i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f40103e;
        this.s = dVar.f40104f;
        this.t = dVar.f40105g;
        this.v = dVar.f40107i;
        this.u = dVar.f40106h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f40068h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.f40071a[this.f40068h.ordinal()];
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
        this.f40068h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f40062b;
    }

    public String e() {
        String str = this.f40065e;
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
        return this.f40068h;
    }

    public int g() {
        return this.f40064d;
    }

    public String h() {
        return this.K;
    }

    public com.meizu.cloud.pushsdk.b.d.a i() {
        return new com.meizu.cloud.pushsdk.b.d.a() { // from class: com.meizu.cloud.pushsdk.b.a.b.1
            @Override // com.meizu.cloud.pushsdk.b.d.a
            public void a(long j, long j2) {
                b.this.B = (int) ((100 * j) / j2);
                if (b.this.E == null || b.this.C) {
                    return;
                }
                b.this.E.a(j, j2);
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
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
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
        h.a a2 = new h.a().a(h.f40172e);
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
            for (Map.Entry<String, String> entry : this.f40069i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f40066f + ", mMethod=" + this.f40062b + ", mPriority=" + this.f40063c + ", mRequestType=" + this.f40064d + ", mUrl=" + this.f40065e + '}';
    }
}
