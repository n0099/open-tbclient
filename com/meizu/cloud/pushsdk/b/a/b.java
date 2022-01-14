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
    public int f58462b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f58463c;

    /* renamed from: d  reason: collision with root package name */
    public int f58464d;

    /* renamed from: e  reason: collision with root package name */
    public String f58465e;

    /* renamed from: f  reason: collision with root package name */
    public int f58466f;

    /* renamed from: g  reason: collision with root package name */
    public Object f58467g;

    /* renamed from: h  reason: collision with root package name */
    public e f58468h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f58469i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, String> f58470j;
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
        public String f58471b;

        /* renamed from: c  reason: collision with root package name */
        public Object f58472c;

        /* renamed from: g  reason: collision with root package name */
        public String f58476g;

        /* renamed from: h  reason: collision with root package name */
        public String f58477h;

        /* renamed from: j  reason: collision with root package name */
        public Executor f58479j;
        public String k;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f58473d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f58474e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f58475f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f58478i = 0;

        public a(String str, String str2, String str3) {
            this.f58471b = str;
            this.f58476g = str2;
            this.f58477h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2167b<T extends C2167b> {

        /* renamed from: b  reason: collision with root package name */
        public int f58480b;

        /* renamed from: c  reason: collision with root package name */
        public String f58481c;

        /* renamed from: d  reason: collision with root package name */
        public Object f58482d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f58483e;

        /* renamed from: f  reason: collision with root package name */
        public int f58484f;

        /* renamed from: g  reason: collision with root package name */
        public int f58485g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f58486h;
        public Executor l;
        public String m;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f58487i = new HashMap<>();

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f58488j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C2167b(String str) {
            this.f58480b = 0;
            this.f58481c = str;
            this.f58480b = 0;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f58488j.put(entry.getKey(), entry.getValue());
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
        public String f58489b;

        /* renamed from: c  reason: collision with root package name */
        public Object f58490c;

        /* renamed from: j  reason: collision with root package name */
        public Executor f58497j;
        public String k;
        public String l;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f58491d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f58492e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f58493f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f58494g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f58495h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f58496i = 0;

        public c(String str) {
            this.f58489b = str;
        }

        public T a(String str, File file) {
            this.f58495h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f58492e.put(entry.getKey(), entry.getValue());
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
        public int f58498b;

        /* renamed from: c  reason: collision with root package name */
        public String f58499c;

        /* renamed from: d  reason: collision with root package name */
        public Object f58500d;
        public Executor o;
        public String p;
        public String q;
        public com.meizu.cloud.pushsdk.b.a.d a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f58501e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f58502f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f58503g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f58504h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f58505i = null;

        /* renamed from: j  reason: collision with root package name */
        public HashMap<String, String> f58506j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f58498b = 1;
            this.f58499c = str;
            this.f58498b = 1;
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
        this.f58469i = new HashMap<>();
        this.f58470j = new HashMap<>();
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
        this.f58464d = 1;
        this.f58462b = 0;
        this.f58463c = aVar.a;
        this.f58465e = aVar.f58471b;
        this.f58467g = aVar.f58472c;
        this.p = aVar.f58476g;
        this.q = aVar.f58477h;
        this.f58469i = aVar.f58473d;
        this.m = aVar.f58474e;
        this.n = aVar.f58475f;
        this.D = aVar.f58478i;
        this.J = aVar.f58479j;
        this.K = aVar.k;
    }

    public b(C2167b c2167b) {
        this.f58469i = new HashMap<>();
        this.f58470j = new HashMap<>();
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
        this.f58464d = 0;
        this.f58462b = c2167b.f58480b;
        this.f58463c = c2167b.a;
        this.f58465e = c2167b.f58481c;
        this.f58467g = c2167b.f58482d;
        this.f58469i = c2167b.f58487i;
        this.F = c2167b.f58483e;
        this.H = c2167b.f58485g;
        this.G = c2167b.f58484f;
        this.I = c2167b.f58486h;
        this.m = c2167b.f58488j;
        this.n = c2167b.k;
        this.J = c2167b.l;
        this.K = c2167b.m;
    }

    public b(c cVar) {
        this.f58469i = new HashMap<>();
        this.f58470j = new HashMap<>();
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
        this.f58464d = 2;
        this.f58462b = 1;
        this.f58463c = cVar.a;
        this.f58465e = cVar.f58489b;
        this.f58467g = cVar.f58490c;
        this.f58469i = cVar.f58491d;
        this.m = cVar.f58493f;
        this.n = cVar.f58494g;
        this.l = cVar.f58492e;
        this.o = cVar.f58495h;
        this.D = cVar.f58496i;
        this.J = cVar.f58497j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f58469i = new HashMap<>();
        this.f58470j = new HashMap<>();
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
        this.f58464d = 0;
        this.f58462b = dVar.f58498b;
        this.f58463c = dVar.a;
        this.f58465e = dVar.f58499c;
        this.f58467g = dVar.f58500d;
        this.f58469i = dVar.f58506j;
        this.f58470j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f58501e;
        this.s = dVar.f58502f;
        this.t = dVar.f58503g;
        this.v = dVar.f58505i;
        this.u = dVar.f58504h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f58468h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.a[this.f58468h.ordinal()];
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
        this.f58468h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f58462b;
    }

    public String e() {
        String str = this.f58465e;
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
        return this.f58468h;
    }

    public int g() {
        return this.f58464d;
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
            for (Map.Entry<String, String> entry : this.f58470j.entrySet()) {
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
        h.a a2 = new h.a().a(h.f58556e);
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
            for (Map.Entry<String, String> entry : this.f58469i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f58466f + ", mMethod=" + this.f58462b + ", mPriority=" + this.f58463c + ", mRequestType=" + this.f58464d + ", mUrl=" + this.f58465e + ExtendedMessageFormat.END_FE;
    }
}
