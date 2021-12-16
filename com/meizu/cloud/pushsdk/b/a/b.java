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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public int f60763b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f60764c;

    /* renamed from: d  reason: collision with root package name */
    public int f60765d;

    /* renamed from: e  reason: collision with root package name */
    public String f60766e;

    /* renamed from: f  reason: collision with root package name */
    public int f60767f;

    /* renamed from: g  reason: collision with root package name */
    public Object f60768g;

    /* renamed from: h  reason: collision with root package name */
    public e f60769h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f60770i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, String> f60771j;

    /* renamed from: k  reason: collision with root package name */
    public HashMap<String, String> f60772k;
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
    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f60773b;

        /* renamed from: c  reason: collision with root package name */
        public Object f60774c;

        /* renamed from: g  reason: collision with root package name */
        public String f60778g;

        /* renamed from: h  reason: collision with root package name */
        public String f60779h;

        /* renamed from: j  reason: collision with root package name */
        public Executor f60781j;

        /* renamed from: k  reason: collision with root package name */
        public String f60782k;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f60775d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f60776e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f60777f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f60780i = 0;

        public a(String str, String str2, String str3) {
            this.f60773b = str;
            this.f60778g = str2;
            this.f60779h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2143b<T extends C2143b> {

        /* renamed from: b  reason: collision with root package name */
        public int f60783b;

        /* renamed from: c  reason: collision with root package name */
        public String f60784c;

        /* renamed from: d  reason: collision with root package name */
        public Object f60785d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f60786e;

        /* renamed from: f  reason: collision with root package name */
        public int f60787f;

        /* renamed from: g  reason: collision with root package name */
        public int f60788g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f60789h;
        public Executor l;
        public String m;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f60790i = new HashMap<>();

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f60791j = new HashMap<>();

        /* renamed from: k  reason: collision with root package name */
        public HashMap<String, String> f60792k = new HashMap<>();

        public C2143b(String str) {
            this.f60783b = 0;
            this.f60784c = str;
            this.f60783b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f60791j.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class c<T extends c> {

        /* renamed from: b  reason: collision with root package name */
        public String f60793b;

        /* renamed from: c  reason: collision with root package name */
        public Object f60794c;

        /* renamed from: j  reason: collision with root package name */
        public Executor f60801j;

        /* renamed from: k  reason: collision with root package name */
        public String f60802k;
        public String l;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f60795d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f60796e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f60797f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f60798g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f60799h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f60800i = 0;

        public c(String str) {
            this.f60793b = str;
        }

        public T a(String str, File file) {
            this.f60799h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f60796e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class d<T extends d> {

        /* renamed from: b  reason: collision with root package name */
        public int f60803b;

        /* renamed from: c  reason: collision with root package name */
        public String f60804c;

        /* renamed from: d  reason: collision with root package name */
        public Object f60805d;
        public Executor o;
        public String p;
        public String q;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f60806e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f60807f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f60808g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f60809h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f60810i = null;

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f60811j = new HashMap<>();

        /* renamed from: k  reason: collision with root package name */
        public HashMap<String, String> f60812k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f60803b = 1;
            this.f60804c = str;
            this.f60803b = 1;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f60812k.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f60770i = new HashMap<>();
        this.f60771j = new HashMap<>();
        this.f60772k = new HashMap<>();
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
        this.f60765d = 1;
        this.f60763b = 0;
        this.f60764c = aVar.a;
        this.f60766e = aVar.f60773b;
        this.f60768g = aVar.f60774c;
        this.p = aVar.f60778g;
        this.q = aVar.f60779h;
        this.f60770i = aVar.f60775d;
        this.m = aVar.f60776e;
        this.n = aVar.f60777f;
        this.D = aVar.f60780i;
        this.J = aVar.f60781j;
        this.K = aVar.f60782k;
    }

    public b(C2143b c2143b) {
        this.f60770i = new HashMap<>();
        this.f60771j = new HashMap<>();
        this.f60772k = new HashMap<>();
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
        this.f60765d = 0;
        this.f60763b = c2143b.f60783b;
        this.f60764c = c2143b.a;
        this.f60766e = c2143b.f60784c;
        this.f60768g = c2143b.f60785d;
        this.f60770i = c2143b.f60790i;
        this.F = c2143b.f60786e;
        this.H = c2143b.f60788g;
        this.G = c2143b.f60787f;
        this.I = c2143b.f60789h;
        this.m = c2143b.f60791j;
        this.n = c2143b.f60792k;
        this.J = c2143b.l;
        this.K = c2143b.m;
    }

    public b(c cVar) {
        this.f60770i = new HashMap<>();
        this.f60771j = new HashMap<>();
        this.f60772k = new HashMap<>();
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
        this.f60765d = 2;
        this.f60763b = 1;
        this.f60764c = cVar.a;
        this.f60766e = cVar.f60793b;
        this.f60768g = cVar.f60794c;
        this.f60770i = cVar.f60795d;
        this.m = cVar.f60797f;
        this.n = cVar.f60798g;
        this.l = cVar.f60796e;
        this.o = cVar.f60799h;
        this.D = cVar.f60800i;
        this.J = cVar.f60801j;
        this.K = cVar.f60802k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f60770i = new HashMap<>();
        this.f60771j = new HashMap<>();
        this.f60772k = new HashMap<>();
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
        this.f60765d = 0;
        this.f60763b = dVar.f60803b;
        this.f60764c = dVar.a;
        this.f60766e = dVar.f60804c;
        this.f60768g = dVar.f60805d;
        this.f60770i = dVar.f60811j;
        this.f60771j = dVar.f60812k;
        this.f60772k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f60806e;
        this.s = dVar.f60807f;
        this.t = dVar.f60808g;
        this.v = dVar.f60810i;
        this.u = dVar.f60809h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f60769h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.a[this.f60769h.ordinal()];
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
        this.f60769h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f60763b;
    }

    public String e() {
        String str = this.f60766e;
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
        return this.f60769h;
    }

    public int g() {
        return this.f60765d;
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
            for (Map.Entry<String, String> entry : this.f60771j.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    aVar.a(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<String, String> entry2 : this.f60772k.entrySet()) {
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
        h.a a2 = new h.a().a(h.f60862e);
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
            for (Map.Entry<String, String> entry : this.f60770i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f60767f + ", mMethod=" + this.f60763b + ", mPriority=" + this.f60764c + ", mRequestType=" + this.f60765d + ", mUrl=" + this.f60766e + ExtendedMessageFormat.END_FE;
    }
}
