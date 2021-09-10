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
    public static final String f74479a = "b";
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
    public int f74480b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f74481c;

    /* renamed from: d  reason: collision with root package name */
    public int f74482d;

    /* renamed from: e  reason: collision with root package name */
    public String f74483e;

    /* renamed from: f  reason: collision with root package name */
    public int f74484f;

    /* renamed from: g  reason: collision with root package name */
    public Object f74485g;

    /* renamed from: h  reason: collision with root package name */
    public e f74486h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f74487i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, String> f74488j;
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
        public static final /* synthetic */ int[] f74490a;

        static {
            int[] iArr = new int[e.values().length];
            f74490a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f74490a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f74490a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f74490a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f74490a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f74492b;

        /* renamed from: c  reason: collision with root package name */
        public Object f74493c;

        /* renamed from: g  reason: collision with root package name */
        public String f74497g;

        /* renamed from: h  reason: collision with root package name */
        public String f74498h;

        /* renamed from: j  reason: collision with root package name */
        public Executor f74500j;
        public String k;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74491a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f74494d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f74495e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f74496f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f74499i = 0;

        public a(String str, String str2, String str3) {
            this.f74492b = str;
            this.f74497g = str2;
            this.f74498h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2035b<T extends C2035b> {

        /* renamed from: b  reason: collision with root package name */
        public int f74502b;

        /* renamed from: c  reason: collision with root package name */
        public String f74503c;

        /* renamed from: d  reason: collision with root package name */
        public Object f74504d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f74505e;

        /* renamed from: f  reason: collision with root package name */
        public int f74506f;

        /* renamed from: g  reason: collision with root package name */
        public int f74507g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f74508h;
        public Executor l;
        public String m;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74501a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f74509i = new HashMap<>();

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f74510j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C2035b(String str) {
            this.f74502b = 0;
            this.f74503c = str;
            this.f74502b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f74510j.put(entry.getKey(), entry.getValue());
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
        public String f74512b;

        /* renamed from: c  reason: collision with root package name */
        public Object f74513c;

        /* renamed from: j  reason: collision with root package name */
        public Executor f74520j;
        public String k;
        public String l;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74511a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f74514d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f74515e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f74516f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f74517g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f74518h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f74519i = 0;

        public c(String str) {
            this.f74512b = str;
        }

        public T a(String str, File file) {
            this.f74518h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f74515e.put(entry.getKey(), entry.getValue());
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
        public int f74522b;

        /* renamed from: c  reason: collision with root package name */
        public String f74523c;

        /* renamed from: d  reason: collision with root package name */
        public Object f74524d;
        public Executor o;
        public String p;
        public String q;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f74521a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f74525e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f74526f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f74527g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f74528h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f74529i = null;

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f74530j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f74522b = 1;
            this.f74523c = str;
            this.f74522b = 1;
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
        this.f74487i = new HashMap<>();
        this.f74488j = new HashMap<>();
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
        this.f74482d = 1;
        this.f74480b = 0;
        this.f74481c = aVar.f74491a;
        this.f74483e = aVar.f74492b;
        this.f74485g = aVar.f74493c;
        this.p = aVar.f74497g;
        this.q = aVar.f74498h;
        this.f74487i = aVar.f74494d;
        this.m = aVar.f74495e;
        this.n = aVar.f74496f;
        this.D = aVar.f74499i;
        this.J = aVar.f74500j;
        this.K = aVar.k;
    }

    public b(C2035b c2035b) {
        this.f74487i = new HashMap<>();
        this.f74488j = new HashMap<>();
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
        this.f74482d = 0;
        this.f74480b = c2035b.f74502b;
        this.f74481c = c2035b.f74501a;
        this.f74483e = c2035b.f74503c;
        this.f74485g = c2035b.f74504d;
        this.f74487i = c2035b.f74509i;
        this.F = c2035b.f74505e;
        this.H = c2035b.f74507g;
        this.G = c2035b.f74506f;
        this.I = c2035b.f74508h;
        this.m = c2035b.f74510j;
        this.n = c2035b.k;
        this.J = c2035b.l;
        this.K = c2035b.m;
    }

    public b(c cVar) {
        this.f74487i = new HashMap<>();
        this.f74488j = new HashMap<>();
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
        this.f74482d = 2;
        this.f74480b = 1;
        this.f74481c = cVar.f74511a;
        this.f74483e = cVar.f74512b;
        this.f74485g = cVar.f74513c;
        this.f74487i = cVar.f74514d;
        this.m = cVar.f74516f;
        this.n = cVar.f74517g;
        this.l = cVar.f74515e;
        this.o = cVar.f74518h;
        this.D = cVar.f74519i;
        this.J = cVar.f74520j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f74487i = new HashMap<>();
        this.f74488j = new HashMap<>();
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
        this.f74482d = 0;
        this.f74480b = dVar.f74522b;
        this.f74481c = dVar.f74521a;
        this.f74483e = dVar.f74523c;
        this.f74485g = dVar.f74524d;
        this.f74487i = dVar.f74530j;
        this.f74488j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f74525e;
        this.s = dVar.f74526f;
        this.t = dVar.f74527g;
        this.v = dVar.f74529i;
        this.u = dVar.f74528h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f74486h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.f74490a[this.f74486h.ordinal()];
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
        this.f74486h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f74480b;
    }

    public String e() {
        String str = this.f74483e;
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
        return this.f74486h;
    }

    public int g() {
        return this.f74482d;
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
            for (Map.Entry<String, String> entry : this.f74488j.entrySet()) {
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
        h.a a2 = new h.a().a(h.f74596e);
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
            for (Map.Entry<String, String> entry : this.f74487i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f74484f + ", mMethod=" + this.f74480b + ", mPriority=" + this.f74481c + ", mRequestType=" + this.f74482d + ", mUrl=" + this.f74483e + ExtendedMessageFormat.END_FE;
    }
}
