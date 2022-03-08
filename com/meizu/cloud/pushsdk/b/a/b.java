package com.meizu.cloud.pushsdk.b.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b<T extends b> {
    public static final String a = "b";
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
    public int f57024b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f57025c;

    /* renamed from: d  reason: collision with root package name */
    public int f57026d;

    /* renamed from: e  reason: collision with root package name */
    public String f57027e;

    /* renamed from: f  reason: collision with root package name */
    public int f57028f;

    /* renamed from: g  reason: collision with root package name */
    public Object f57029g;

    /* renamed from: h  reason: collision with root package name */
    public e f57030h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f57031i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, String> f57032j;
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
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f57033b;

        /* renamed from: c  reason: collision with root package name */
        public Object f57034c;

        /* renamed from: g  reason: collision with root package name */
        public String f57038g;

        /* renamed from: h  reason: collision with root package name */
        public String f57039h;

        /* renamed from: j  reason: collision with root package name */
        public Executor f57041j;
        public String k;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f57035d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f57036e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f57037f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f57040i = 0;

        public a(String str, String str2, String str3) {
            this.f57033b = str;
            this.f57038g = str2;
            this.f57039h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2162b<T extends C2162b> {

        /* renamed from: b  reason: collision with root package name */
        public int f57042b;

        /* renamed from: c  reason: collision with root package name */
        public String f57043c;

        /* renamed from: d  reason: collision with root package name */
        public Object f57044d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f57045e;

        /* renamed from: f  reason: collision with root package name */
        public int f57046f;

        /* renamed from: g  reason: collision with root package name */
        public int f57047g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f57048h;
        public Executor l;
        public String m;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f57049i = new HashMap<>();

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f57050j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C2162b(String str) {
            this.f57042b = 0;
            this.f57043c = str;
            this.f57042b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f57050j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes8.dex */
    public static class c<T extends c> {

        /* renamed from: b  reason: collision with root package name */
        public String f57051b;

        /* renamed from: c  reason: collision with root package name */
        public Object f57052c;

        /* renamed from: j  reason: collision with root package name */
        public Executor f57059j;
        public String k;
        public String l;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f57053d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f57054e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f57055f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f57056g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f57057h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f57058i = 0;

        public c(String str) {
            this.f57051b = str;
        }

        public T a(String str, File file) {
            this.f57057h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f57054e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes8.dex */
    public static class d<T extends d> {

        /* renamed from: b  reason: collision with root package name */
        public int f57060b;

        /* renamed from: c  reason: collision with root package name */
        public String f57061c;

        /* renamed from: d  reason: collision with root package name */
        public Object f57062d;
        public Executor o;
        public String p;
        public String q;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f57063e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f57064f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f57065g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f57066h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f57067i = null;

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f57068j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f57060b = 1;
            this.f57061c = str;
            this.f57060b = 1;
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
        this.f57031i = new HashMap<>();
        this.f57032j = new HashMap<>();
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
        this.f57026d = 1;
        this.f57024b = 0;
        this.f57025c = aVar.a;
        this.f57027e = aVar.f57033b;
        this.f57029g = aVar.f57034c;
        this.p = aVar.f57038g;
        this.q = aVar.f57039h;
        this.f57031i = aVar.f57035d;
        this.m = aVar.f57036e;
        this.n = aVar.f57037f;
        this.D = aVar.f57040i;
        this.J = aVar.f57041j;
        this.K = aVar.k;
    }

    public b(C2162b c2162b) {
        this.f57031i = new HashMap<>();
        this.f57032j = new HashMap<>();
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
        this.f57026d = 0;
        this.f57024b = c2162b.f57042b;
        this.f57025c = c2162b.a;
        this.f57027e = c2162b.f57043c;
        this.f57029g = c2162b.f57044d;
        this.f57031i = c2162b.f57049i;
        this.F = c2162b.f57045e;
        this.H = c2162b.f57047g;
        this.G = c2162b.f57046f;
        this.I = c2162b.f57048h;
        this.m = c2162b.f57050j;
        this.n = c2162b.k;
        this.J = c2162b.l;
        this.K = c2162b.m;
    }

    public b(c cVar) {
        this.f57031i = new HashMap<>();
        this.f57032j = new HashMap<>();
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
        this.f57026d = 2;
        this.f57024b = 1;
        this.f57025c = cVar.a;
        this.f57027e = cVar.f57051b;
        this.f57029g = cVar.f57052c;
        this.f57031i = cVar.f57053d;
        this.m = cVar.f57055f;
        this.n = cVar.f57056g;
        this.l = cVar.f57054e;
        this.o = cVar.f57057h;
        this.D = cVar.f57058i;
        this.J = cVar.f57059j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f57031i = new HashMap<>();
        this.f57032j = new HashMap<>();
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
        this.f57026d = 0;
        this.f57024b = dVar.f57060b;
        this.f57025c = dVar.a;
        this.f57027e = dVar.f57061c;
        this.f57029g = dVar.f57062d;
        this.f57031i = dVar.f57068j;
        this.f57032j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f57063e;
        this.s = dVar.f57064f;
        this.t = dVar.f57065g;
        this.v = dVar.f57067i;
        this.u = dVar.f57066h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f57030h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.a[this.f57030h.ordinal()];
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
        this.f57030h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f57024b;
    }

    public String e() {
        String str = this.f57027e;
        for (Map.Entry<String, String> entry : this.n.entrySet()) {
            str = str.replace("{" + entry.getKey() + "}", String.valueOf(entry.getValue()));
        }
        f.a g2 = f.c(str).g();
        for (Map.Entry<String, String> entry2 : this.m.entrySet()) {
            g2.a(entry2.getKey(), entry2.getValue());
        }
        return g2.b().toString();
    }

    public e f() {
        return this.f57030h;
    }

    public int g() {
        return this.f57026d;
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
            for (Map.Entry<String, String> entry : this.f57032j.entrySet()) {
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
        h.a a2 = new h.a().a(h.f57118e);
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
            for (Map.Entry<String, String> entry : this.f57031i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f57028f + ", mMethod=" + this.f57024b + ", mPriority=" + this.f57025c + ", mRequestType=" + this.f57026d + ", mUrl=" + this.f57027e + ExtendedMessageFormat.END_FE;
    }
}
