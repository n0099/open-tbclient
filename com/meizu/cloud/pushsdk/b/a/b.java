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
/* loaded from: classes6.dex */
public class b<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f37075a = "b";
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
    public int f37076b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f37077c;

    /* renamed from: d  reason: collision with root package name */
    public int f37078d;

    /* renamed from: e  reason: collision with root package name */
    public String f37079e;

    /* renamed from: f  reason: collision with root package name */
    public int f37080f;

    /* renamed from: g  reason: collision with root package name */
    public Object f37081g;

    /* renamed from: h  reason: collision with root package name */
    public e f37082h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f37083i;
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
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37085a;

        static {
            int[] iArr = new int[e.values().length];
            f37085a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37085a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37085a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37085a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37085a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f37087b;

        /* renamed from: c  reason: collision with root package name */
        public Object f37088c;

        /* renamed from: g  reason: collision with root package name */
        public String f37092g;

        /* renamed from: h  reason: collision with root package name */
        public String f37093h;
        public Executor j;
        public String k;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f37086a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f37089d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f37090e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f37091f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f37094i = 0;

        public a(String str, String str2, String str3) {
            this.f37087b = str;
            this.f37092g = str2;
            this.f37093h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0462b<T extends C0462b> {

        /* renamed from: b  reason: collision with root package name */
        public int f37096b;

        /* renamed from: c  reason: collision with root package name */
        public String f37097c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37098d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f37099e;

        /* renamed from: f  reason: collision with root package name */
        public int f37100f;

        /* renamed from: g  reason: collision with root package name */
        public int f37101g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f37102h;
        public Executor l;
        public String m;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f37095a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f37103i = new HashMap<>();
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C0462b(String str) {
            this.f37096b = 0;
            this.f37097c = str;
            this.f37096b = 0;
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

    /* loaded from: classes6.dex */
    public static class c<T extends c> {

        /* renamed from: b  reason: collision with root package name */
        public String f37105b;

        /* renamed from: c  reason: collision with root package name */
        public Object f37106c;
        public Executor j;
        public String k;
        public String l;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f37104a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f37107d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f37108e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f37109f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f37110g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f37111h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f37112i = 0;

        public c(String str) {
            this.f37105b = str;
        }

        public T a(String str, File file) {
            this.f37111h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f37108e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes6.dex */
    public static class d<T extends d> {

        /* renamed from: b  reason: collision with root package name */
        public int f37114b;

        /* renamed from: c  reason: collision with root package name */
        public String f37115c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37116d;
        public Executor o;
        public String p;
        public String q;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f37113a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f37117e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f37118f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f37119g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f37120h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f37121i = null;
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f37114b = 1;
            this.f37115c = str;
            this.f37114b = 1;
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
        this.f37083i = new HashMap<>();
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
        this.f37078d = 1;
        this.f37076b = 0;
        this.f37077c = aVar.f37086a;
        this.f37079e = aVar.f37087b;
        this.f37081g = aVar.f37088c;
        this.p = aVar.f37092g;
        this.q = aVar.f37093h;
        this.f37083i = aVar.f37089d;
        this.m = aVar.f37090e;
        this.n = aVar.f37091f;
        this.D = aVar.f37094i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(C0462b c0462b) {
        this.f37083i = new HashMap<>();
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
        this.f37078d = 0;
        this.f37076b = c0462b.f37096b;
        this.f37077c = c0462b.f37095a;
        this.f37079e = c0462b.f37097c;
        this.f37081g = c0462b.f37098d;
        this.f37083i = c0462b.f37103i;
        this.F = c0462b.f37099e;
        this.H = c0462b.f37101g;
        this.G = c0462b.f37100f;
        this.I = c0462b.f37102h;
        this.m = c0462b.j;
        this.n = c0462b.k;
        this.J = c0462b.l;
        this.K = c0462b.m;
    }

    public b(c cVar) {
        this.f37083i = new HashMap<>();
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
        this.f37078d = 2;
        this.f37076b = 1;
        this.f37077c = cVar.f37104a;
        this.f37079e = cVar.f37105b;
        this.f37081g = cVar.f37106c;
        this.f37083i = cVar.f37107d;
        this.m = cVar.f37109f;
        this.n = cVar.f37110g;
        this.l = cVar.f37108e;
        this.o = cVar.f37111h;
        this.D = cVar.f37112i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f37083i = new HashMap<>();
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
        this.f37078d = 0;
        this.f37076b = dVar.f37114b;
        this.f37077c = dVar.f37113a;
        this.f37079e = dVar.f37115c;
        this.f37081g = dVar.f37116d;
        this.f37083i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f37117e;
        this.s = dVar.f37118f;
        this.t = dVar.f37119g;
        this.v = dVar.f37121i;
        this.u = dVar.f37120h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f37082h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.f37085a[this.f37082h.ordinal()];
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
        this.f37082h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f37076b;
    }

    public String e() {
        String str = this.f37079e;
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
        return this.f37082h;
    }

    public int g() {
        return this.f37078d;
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
        h.a a2 = new h.a().a(h.f37186e);
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
            for (Map.Entry<String, String> entry : this.f37083i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f37080f + ", mMethod=" + this.f37076b + ", mPriority=" + this.f37077c + ", mRequestType=" + this.f37078d + ", mUrl=" + this.f37079e + '}';
    }
}
