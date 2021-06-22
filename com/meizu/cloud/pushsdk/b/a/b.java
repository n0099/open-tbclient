package com.meizu.cloud.pushsdk.b.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidubce.AbstractBceClient;
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
    public static final String f38298a = "b";
    public static final g w = g.a(AbstractBceClient.DEFAULT_CONTENT_TYPE);
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
    public int f38299b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f38300c;

    /* renamed from: d  reason: collision with root package name */
    public int f38301d;

    /* renamed from: e  reason: collision with root package name */
    public String f38302e;

    /* renamed from: f  reason: collision with root package name */
    public int f38303f;

    /* renamed from: g  reason: collision with root package name */
    public Object f38304g;

    /* renamed from: h  reason: collision with root package name */
    public e f38305h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f38306i;
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
        public static final /* synthetic */ int[] f38308a;

        static {
            int[] iArr = new int[e.values().length];
            f38308a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38308a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38308a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38308a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38308a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f38310b;

        /* renamed from: c  reason: collision with root package name */
        public Object f38311c;

        /* renamed from: g  reason: collision with root package name */
        public String f38315g;

        /* renamed from: h  reason: collision with root package name */
        public String f38316h;
        public Executor j;
        public String k;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f38309a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f38312d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f38313e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f38314f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f38317i = 0;

        public a(String str, String str2, String str3) {
            this.f38310b = str;
            this.f38315g = str2;
            this.f38316h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0457b<T extends C0457b> {

        /* renamed from: b  reason: collision with root package name */
        public int f38319b;

        /* renamed from: c  reason: collision with root package name */
        public String f38320c;

        /* renamed from: d  reason: collision with root package name */
        public Object f38321d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f38322e;

        /* renamed from: f  reason: collision with root package name */
        public int f38323f;

        /* renamed from: g  reason: collision with root package name */
        public int f38324g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f38325h;
        public Executor l;
        public String m;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f38318a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f38326i = new HashMap<>();
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C0457b(String str) {
            this.f38319b = 0;
            this.f38320c = str;
            this.f38319b = 0;
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
        public String f38328b;

        /* renamed from: c  reason: collision with root package name */
        public Object f38329c;
        public Executor j;
        public String k;
        public String l;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f38327a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f38330d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f38331e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f38332f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f38333g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f38334h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f38335i = 0;

        public c(String str) {
            this.f38328b = str;
        }

        public T a(String str, File file) {
            this.f38334h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f38331e.put(entry.getKey(), entry.getValue());
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
        public int f38337b;

        /* renamed from: c  reason: collision with root package name */
        public String f38338c;

        /* renamed from: d  reason: collision with root package name */
        public Object f38339d;
        public Executor o;
        public String p;
        public String q;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f38336a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f38340e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f38341f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f38342g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f38343h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f38344i = null;
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f38337b = 1;
            this.f38338c = str;
            this.f38337b = 1;
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
        this.f38306i = new HashMap<>();
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
        this.f38301d = 1;
        this.f38299b = 0;
        this.f38300c = aVar.f38309a;
        this.f38302e = aVar.f38310b;
        this.f38304g = aVar.f38311c;
        this.p = aVar.f38315g;
        this.q = aVar.f38316h;
        this.f38306i = aVar.f38312d;
        this.m = aVar.f38313e;
        this.n = aVar.f38314f;
        this.D = aVar.f38317i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(C0457b c0457b) {
        this.f38306i = new HashMap<>();
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
        this.f38301d = 0;
        this.f38299b = c0457b.f38319b;
        this.f38300c = c0457b.f38318a;
        this.f38302e = c0457b.f38320c;
        this.f38304g = c0457b.f38321d;
        this.f38306i = c0457b.f38326i;
        this.F = c0457b.f38322e;
        this.H = c0457b.f38324g;
        this.G = c0457b.f38323f;
        this.I = c0457b.f38325h;
        this.m = c0457b.j;
        this.n = c0457b.k;
        this.J = c0457b.l;
        this.K = c0457b.m;
    }

    public b(c cVar) {
        this.f38306i = new HashMap<>();
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
        this.f38301d = 2;
        this.f38299b = 1;
        this.f38300c = cVar.f38327a;
        this.f38302e = cVar.f38328b;
        this.f38304g = cVar.f38329c;
        this.f38306i = cVar.f38330d;
        this.m = cVar.f38332f;
        this.n = cVar.f38333g;
        this.l = cVar.f38331e;
        this.o = cVar.f38334h;
        this.D = cVar.f38335i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f38306i = new HashMap<>();
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
        this.f38301d = 0;
        this.f38299b = dVar.f38337b;
        this.f38300c = dVar.f38336a;
        this.f38302e = dVar.f38338c;
        this.f38304g = dVar.f38339d;
        this.f38306i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f38340e;
        this.s = dVar.f38341f;
        this.t = dVar.f38342g;
        this.v = dVar.f38344i;
        this.u = dVar.f38343h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f38305h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.f38308a[this.f38305h.ordinal()];
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
        this.f38305h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f38299b;
    }

    public String e() {
        String str = this.f38302e;
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
        return this.f38305h;
    }

    public int g() {
        return this.f38301d;
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
        h.a a2 = new h.a().a(h.f38409e);
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
            for (Map.Entry<String, String> entry : this.f38306i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f38303f + ", mMethod=" + this.f38299b + ", mPriority=" + this.f38300c + ", mRequestType=" + this.f38301d + ", mUrl=" + this.f38302e + '}';
    }
}
