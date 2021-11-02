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
/* loaded from: classes2.dex */
public class b<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f67204a = "b";
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
    public int f67205b;

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.a.d f67206c;

    /* renamed from: d  reason: collision with root package name */
    public int f67207d;

    /* renamed from: e  reason: collision with root package name */
    public String f67208e;

    /* renamed from: f  reason: collision with root package name */
    public int f67209f;

    /* renamed from: g  reason: collision with root package name */
    public Object f67210g;

    /* renamed from: h  reason: collision with root package name */
    public e f67211h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f67212i;
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
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67214a;

        static {
            int[] iArr = new int[e.values().length];
            f67214a = iArr;
            try {
                iArr[e.JSON_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67214a[e.JSON_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67214a[e.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67214a[e.BITMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67214a[e.PREFETCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        public String f67216b;

        /* renamed from: c  reason: collision with root package name */
        public Object f67217c;

        /* renamed from: g  reason: collision with root package name */
        public String f67221g;

        /* renamed from: h  reason: collision with root package name */
        public String f67222h;
        public Executor j;
        public String k;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f67215a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f67218d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f67219e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f67220f = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f67223i = 0;

        public a(String str, String str2, String str3) {
            this.f67216b = str;
            this.f67221g = str2;
            this.f67222h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1951b<T extends C1951b> {

        /* renamed from: b  reason: collision with root package name */
        public int f67225b;

        /* renamed from: c  reason: collision with root package name */
        public String f67226c;

        /* renamed from: d  reason: collision with root package name */
        public Object f67227d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap.Config f67228e;

        /* renamed from: f  reason: collision with root package name */
        public int f67229f;

        /* renamed from: g  reason: collision with root package name */
        public int f67230g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView.ScaleType f67231h;
        public Executor l;
        public String m;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f67224a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: i  reason: collision with root package name */
        public HashMap<String, String> f67232i = new HashMap<>();
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();

        public C1951b(String str) {
            this.f67225b = 0;
            this.f67226c = str;
            this.f67225b = 0;
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

    /* loaded from: classes2.dex */
    public static class c<T extends c> {

        /* renamed from: b  reason: collision with root package name */
        public String f67234b;

        /* renamed from: c  reason: collision with root package name */
        public Object f67235c;
        public Executor j;
        public String k;
        public String l;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f67233a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: d  reason: collision with root package name */
        public HashMap<String, String> f67236d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        public HashMap<String, String> f67237e = new HashMap<>();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, String> f67238f = new HashMap<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, String> f67239g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public HashMap<String, File> f67240h = new HashMap<>();

        /* renamed from: i  reason: collision with root package name */
        public int f67241i = 0;

        public c(String str) {
            this.f67234b = str;
        }

        public T a(String str, File file) {
            this.f67240h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.f67237e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes2.dex */
    public static class d<T extends d> {

        /* renamed from: b  reason: collision with root package name */
        public int f67243b;

        /* renamed from: c  reason: collision with root package name */
        public String f67244c;

        /* renamed from: d  reason: collision with root package name */
        public Object f67245d;
        public Executor o;
        public String p;
        public String q;

        /* renamed from: a  reason: collision with root package name */
        public com.meizu.cloud.pushsdk.b.a.d f67242a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f67246e = null;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f67247f = null;

        /* renamed from: g  reason: collision with root package name */
        public String f67248g = null;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f67249h = null;

        /* renamed from: i  reason: collision with root package name */
        public File f67250i = null;
        public HashMap<String, String> j = new HashMap<>();
        public HashMap<String, String> k = new HashMap<>();
        public HashMap<String, String> l = new HashMap<>();
        public HashMap<String, String> m = new HashMap<>();
        public HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f67243b = 1;
            this.f67244c = str;
            this.f67243b = 1;
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
        this.f67212i = new HashMap<>();
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
        this.f67207d = 1;
        this.f67205b = 0;
        this.f67206c = aVar.f67215a;
        this.f67208e = aVar.f67216b;
        this.f67210g = aVar.f67217c;
        this.p = aVar.f67221g;
        this.q = aVar.f67222h;
        this.f67212i = aVar.f67218d;
        this.m = aVar.f67219e;
        this.n = aVar.f67220f;
        this.D = aVar.f67223i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(C1951b c1951b) {
        this.f67212i = new HashMap<>();
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
        this.f67207d = 0;
        this.f67205b = c1951b.f67225b;
        this.f67206c = c1951b.f67224a;
        this.f67208e = c1951b.f67226c;
        this.f67210g = c1951b.f67227d;
        this.f67212i = c1951b.f67232i;
        this.F = c1951b.f67228e;
        this.H = c1951b.f67230g;
        this.G = c1951b.f67229f;
        this.I = c1951b.f67231h;
        this.m = c1951b.j;
        this.n = c1951b.k;
        this.J = c1951b.l;
        this.K = c1951b.m;
    }

    public b(c cVar) {
        this.f67212i = new HashMap<>();
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
        this.f67207d = 2;
        this.f67205b = 1;
        this.f67206c = cVar.f67233a;
        this.f67208e = cVar.f67234b;
        this.f67210g = cVar.f67235c;
        this.f67212i = cVar.f67236d;
        this.m = cVar.f67238f;
        this.n = cVar.f67239g;
        this.l = cVar.f67237e;
        this.o = cVar.f67240h;
        this.D = cVar.f67241i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.f67212i = new HashMap<>();
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
        this.f67207d = 0;
        this.f67205b = dVar.f67243b;
        this.f67206c = dVar.f67242a;
        this.f67208e = dVar.f67244c;
        this.f67210g = dVar.f67245d;
        this.f67212i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.f67246e;
        this.s = dVar.f67247f;
        this.t = dVar.f67248g;
        this.v = dVar.f67250i;
        this.u = dVar.f67249h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.f67211h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        int i2 = AnonymousClass2.f67214a[this.f67211h.ordinal()];
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
        this.f67211h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f67205b;
    }

    public String e() {
        String str = this.f67208e;
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
        return this.f67211h;
    }

    public int g() {
        return this.f67207d;
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
        h.a a2 = new h.a().a(h.f67315e);
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
            for (Map.Entry<String, String> entry : this.f67212i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f67209f + ", mMethod=" + this.f67205b + ", mPriority=" + this.f67206c + ", mRequestType=" + this.f67207d + ", mUrl=" + this.f67208e + ExtendedMessageFormat.END_FE;
    }
}
