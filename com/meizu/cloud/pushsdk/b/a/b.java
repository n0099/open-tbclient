package com.meizu.cloud.pushsdk.b.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
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
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11124a = b.class.getSimpleName();
    private static final g w = g.a(AbstractBceClient.DEFAULT_CONTENT_TYPE);
    private static final g x = g.a("text/x-markdown; charset=utf-8");
    private static final Object z = new Object();
    private com.meizu.cloud.pushsdk.b.c.a A;
    private int B;
    private boolean C;
    private int D;
    private com.meizu.cloud.pushsdk.b.d.a E;
    private Bitmap.Config F;
    private int G;
    private int H;
    private ImageView.ScaleType I;
    private Executor J;
    private String K;
    private Type L;

    /* renamed from: b  reason: collision with root package name */
    private int f11125b;
    private com.meizu.cloud.pushsdk.b.a.d c;
    private int d;
    private String e;
    private int f;
    private Object g;
    private e h;
    private HashMap<String, String> i;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private HashMap<String, String> l;
    private HashMap<String, String> m;
    private HashMap<String, String> n;
    private HashMap<String, File> o;
    private String p;
    private String q;
    private JSONObject r;
    private JSONArray s;
    private String t;
    private byte[] u;
    private File v;
    private g y;

    /* loaded from: classes5.dex */
    public static class a<T extends a> {

        /* renamed from: b  reason: collision with root package name */
        private String f11129b;
        private Object c;
        private String g;
        private String h;
        private Executor j;
        private String k;

        /* renamed from: a  reason: collision with root package name */
        private com.meizu.cloud.pushsdk.b.a.d f11128a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;
        private HashMap<String, String> d = new HashMap<>();
        private HashMap<String, String> e = new HashMap<>();
        private HashMap<String, String> f = new HashMap<>();
        private int i = 0;

        public a(String str, String str2, String str3) {
            this.f11129b = str;
            this.g = str2;
            this.h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1163b<T extends C1163b> {

        /* renamed from: b  reason: collision with root package name */
        private int f11131b;
        private String c;
        private Object d;
        private Bitmap.Config e;
        private int f;
        private int g;
        private ImageView.ScaleType h;
        private Executor l;
        private String m;

        /* renamed from: a  reason: collision with root package name */
        private com.meizu.cloud.pushsdk.b.a.d f11130a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;
        private HashMap<String, String> i = new HashMap<>();
        private HashMap<String, String> j = new HashMap<>();
        private HashMap<String, String> k = new HashMap<>();

        public C1163b(String str) {
            this.f11131b = 0;
            this.c = str;
            this.f11131b = 0;
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

    /* loaded from: classes5.dex */
    public static class c<T extends c> {

        /* renamed from: b  reason: collision with root package name */
        private String f11133b;
        private Object c;
        private Executor j;
        private String k;
        private String l;

        /* renamed from: a  reason: collision with root package name */
        private com.meizu.cloud.pushsdk.b.a.d f11132a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;
        private HashMap<String, String> d = new HashMap<>();
        private HashMap<String, String> e = new HashMap<>();
        private HashMap<String, String> f = new HashMap<>();
        private HashMap<String, String> g = new HashMap<>();
        private HashMap<String, File> h = new HashMap<>();
        private int i = 0;

        public c(String str) {
            this.f11133b = str;
        }

        public T a(String str, File file) {
            this.h.put(str, file);
            return this;
        }

        public T a(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    this.e.put(entry.getKey(), entry.getValue());
                }
            }
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* loaded from: classes5.dex */
    public static class d<T extends d> {

        /* renamed from: b  reason: collision with root package name */
        private int f11135b;
        private String c;
        private Object d;
        private Executor o;
        private String p;
        private String q;

        /* renamed from: a  reason: collision with root package name */
        private com.meizu.cloud.pushsdk.b.a.d f11134a = com.meizu.cloud.pushsdk.b.a.d.MEDIUM;
        private JSONObject e = null;
        private JSONArray f = null;
        private String g = null;
        private byte[] h = null;
        private File i = null;
        private HashMap<String, String> j = new HashMap<>();
        private HashMap<String, String> k = new HashMap<>();
        private HashMap<String, String> l = new HashMap<>();
        private HashMap<String, String> m = new HashMap<>();
        private HashMap<String, String> n = new HashMap<>();

        public d(String str) {
            this.f11135b = 1;
            this.c = str;
            this.f11135b = 1;
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
        this.i = new HashMap<>();
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
        this.d = 1;
        this.f11125b = 0;
        this.c = aVar.f11128a;
        this.e = aVar.f11129b;
        this.g = aVar.c;
        this.p = aVar.g;
        this.q = aVar.h;
        this.i = aVar.d;
        this.m = aVar.e;
        this.n = aVar.f;
        this.D = aVar.i;
        this.J = aVar.j;
        this.K = aVar.k;
    }

    public b(C1163b c1163b) {
        this.i = new HashMap<>();
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
        this.d = 0;
        this.f11125b = c1163b.f11131b;
        this.c = c1163b.f11130a;
        this.e = c1163b.c;
        this.g = c1163b.d;
        this.i = c1163b.i;
        this.F = c1163b.e;
        this.H = c1163b.g;
        this.G = c1163b.f;
        this.I = c1163b.h;
        this.m = c1163b.j;
        this.n = c1163b.k;
        this.J = c1163b.l;
        this.K = c1163b.m;
    }

    public b(c cVar) {
        this.i = new HashMap<>();
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
        this.d = 2;
        this.f11125b = 1;
        this.c = cVar.f11132a;
        this.e = cVar.f11133b;
        this.g = cVar.c;
        this.i = cVar.d;
        this.m = cVar.f;
        this.n = cVar.g;
        this.l = cVar.e;
        this.o = cVar.h;
        this.D = cVar.i;
        this.J = cVar.j;
        this.K = cVar.k;
        if (cVar.l != null) {
            this.y = g.a(cVar.l);
        }
    }

    public b(d dVar) {
        this.i = new HashMap<>();
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
        this.d = 0;
        this.f11125b = dVar.f11135b;
        this.c = dVar.f11134a;
        this.e = dVar.c;
        this.g = dVar.d;
        this.i = dVar.j;
        this.j = dVar.k;
        this.k = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.r = dVar.e;
        this.s = dVar.f;
        this.t = dVar.g;
        this.v = dVar.i;
        this.u = dVar.h;
        this.J = dVar.o;
        this.K = dVar.p;
        if (dVar.q != null) {
            this.y = g.a(dVar.q);
        }
    }

    public com.meizu.cloud.pushsdk.b.a.c a() {
        this.h = e.STRING;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c a(k kVar) {
        com.meizu.cloud.pushsdk.b.a.c<Bitmap> a2;
        switch (this.h) {
            case JSON_ARRAY:
                try {
                    return com.meizu.cloud.pushsdk.b.a.c.a(new JSONArray(com.meizu.cloud.pushsdk.b.g.g.a(kVar.b().a()).h()));
                } catch (Exception e) {
                    return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e)));
                }
            case JSON_OBJECT:
                try {
                    return com.meizu.cloud.pushsdk.b.a.c.a(new JSONObject(com.meizu.cloud.pushsdk.b.g.g.a(kVar.b().a()).h()));
                } catch (Exception e2) {
                    return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e2)));
                }
            case STRING:
                try {
                    return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.g.g.a(kVar.b().a()).h());
                } catch (Exception e3) {
                    return com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e3)));
                }
            case BITMAP:
                synchronized (z) {
                    try {
                        a2 = com.meizu.cloud.pushsdk.b.i.b.a(kVar, this.G, this.H, this.F, this.I);
                    } catch (Exception e4) {
                        a2 = com.meizu.cloud.pushsdk.b.a.c.a(com.meizu.cloud.pushsdk.b.i.b.b(new com.meizu.cloud.pushsdk.b.b.a(e4)));
                    }
                }
                return a2;
            case PREFETCH:
                return com.meizu.cloud.pushsdk.b.a.c.a("prefetch");
            default:
                return null;
        }
    }

    public com.meizu.cloud.pushsdk.b.b.a a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        try {
            if (aVar.a() != null && aVar.a().b() != null && aVar.a().b().a() != null) {
                aVar.b(com.meizu.cloud.pushsdk.b.g.g.a(aVar.a().b().a()).h());
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        this.h = e.BITMAP;
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public com.meizu.cloud.pushsdk.b.a.c c() {
        return com.meizu.cloud.pushsdk.b.e.c.a(this);
    }

    public int d() {
        return this.f11125b;
    }

    public String e() {
        String str;
        String str2 = this.e;
        Iterator<Map.Entry<String, String>> it = this.n.entrySet().iterator();
        while (true) {
            str = str2;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            str2 = str.replace("{" + next.getKey() + "}", String.valueOf(next.getValue()));
        }
        f.a g = f.c(str).g();
        for (Map.Entry<String, String> entry : this.m.entrySet()) {
            g.a(entry.getKey(), entry.getValue());
        }
        return g.b().toString();
    }

    public e f() {
        return this.h;
    }

    public int g() {
        return this.d;
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
        if (this.r != null) {
            return this.y != null ? j.a(this.y, this.r.toString()) : j.a(w, this.r.toString());
        } else if (this.s != null) {
            return this.y != null ? j.a(this.y, this.s.toString()) : j.a(w, this.s.toString());
        } else if (this.t != null) {
            return this.y != null ? j.a(this.y, this.t) : j.a(x, this.t);
        } else if (this.v != null) {
            return this.y != null ? j.a(this.y, this.v) : j.a(x, this.v);
        } else if (this.u != null) {
            return this.y != null ? j.a(this.y, this.u) : j.a(x, this.u);
        } else {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            return aVar.a();
        }
    }

    public j n() {
        h.a a2 = new h.a().a(h.e);
        try {
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.b.c.c.a("Content-Disposition", "form-data; name=\"" + entry.getKey() + "\""), j.a((g) null, entry.getValue()));
            }
            for (Map.Entry<String, File> entry2 : this.o.entrySet()) {
                if (entry2.getValue() != null) {
                    String name = entry2.getValue().getName();
                    a2.a(com.meizu.cloud.pushsdk.b.c.c.a("Content-Disposition", "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), j.a(g.a(com.meizu.cloud.pushsdk.b.i.b.a(name)), entry2.getValue()));
                    if (this.y != null) {
                        a2.a(this.y);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.b.c.c o() {
        c.a aVar = new c.a();
        try {
            for (Map.Entry<String, String> entry : this.i.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar.a();
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f + ", mMethod=" + this.f11125b + ", mPriority=" + this.c + ", mRequestType=" + this.d + ", mUrl=" + this.e + '}';
    }
}
