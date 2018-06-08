package com.meizu.cloud.pushsdk.networking.common;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.meizu.cloud.pushsdk.networking.b.b;
import com.meizu.cloud.pushsdk.networking.b.c;
import com.meizu.cloud.pushsdk.networking.b.f;
import com.meizu.cloud.pushsdk.networking.b.g;
import com.meizu.cloud.pushsdk.networking.b.h;
import com.meizu.cloud.pushsdk.networking.c.d;
import com.meizu.cloud.pushsdk.networking.c.e;
import com.meizu.cloud.pushsdk.networking.c.f;
import com.meizu.cloud.pushsdk.networking.c.h;
import com.meizu.cloud.pushsdk.networking.c.i;
import com.meizu.cloud.pushsdk.networking.c.j;
import com.meizu.cloud.pushsdk.networking.c.k;
import com.meizu.cloud.pushsdk.networking.c.l;
import com.meizu.cloud.pushsdk.networking.c.m;
import com.meizu.cloud.pushsdk.networking.c.n;
import com.meizu.cloud.pushsdk.networking.c.o;
import com.meizu.cloud.pushsdk.networking.common.b;
import com.meizu.cloud.pushsdk.networking.error.ANError;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.apache.http.entity.mime.MIME;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b<T extends b> {
    private static final String a = b.class.getSimpleName();
    private static final g w = g.a("application/json; charset=utf-8");
    private static final g x = g.a("text/x-markdown; charset=utf-8");
    private static final Object z = new Object();
    private Future A;
    private com.meizu.cloud.pushsdk.networking.b.a B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private e G;
    private f H;
    private n I;
    private l J;
    private com.meizu.cloud.pushsdk.networking.c.b K;
    private m L;
    private i M;
    private h N;
    private k O;
    private com.meizu.cloud.pushsdk.networking.c.g P;
    private j Q;
    private d R;
    private o S;
    private com.meizu.cloud.pushsdk.networking.c.c T;
    private com.meizu.cloud.pushsdk.networking.c.a U;
    private Bitmap.Config V;
    private int W;
    private int X;
    private ImageView.ScaleType Y;
    private Executor Z;
    private String aa;
    private Type ab;
    private int b;
    private Priority c;
    private int d;
    private String e;
    private int f;
    private Object g;
    private ResponseType h;
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

    public b(C0269b c0269b) {
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
        this.F = 0;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.d = 0;
        this.b = c0269b.b;
        this.c = c0269b.a;
        this.e = c0269b.c;
        this.g = c0269b.d;
        this.i = c0269b.i;
        this.V = c0269b.e;
        this.X = c0269b.g;
        this.W = c0269b.f;
        this.Y = c0269b.h;
        this.m = c0269b.j;
        this.n = c0269b.k;
        this.Z = c0269b.l;
        this.aa = c0269b.m;
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
        this.F = 0;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.d = 0;
        this.b = cVar.b;
        this.c = cVar.a;
        this.e = cVar.c;
        this.g = cVar.d;
        this.i = cVar.j;
        this.j = cVar.k;
        this.k = cVar.l;
        this.m = cVar.m;
        this.n = cVar.n;
        this.r = cVar.e;
        this.s = cVar.f;
        this.t = cVar.g;
        this.v = cVar.i;
        this.u = cVar.h;
        this.Z = cVar.o;
        this.aa = cVar.p;
        if (cVar.q == null) {
            return;
        }
        this.y = g.a(cVar.q);
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
        this.F = 0;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.d = 1;
        this.b = 0;
        this.c = aVar.a;
        this.e = aVar.b;
        this.g = aVar.c;
        this.p = aVar.g;
        this.q = aVar.h;
        this.i = aVar.d;
        this.m = aVar.e;
        this.n = aVar.f;
        this.F = aVar.i;
        this.Z = aVar.j;
        this.aa = aVar.k;
    }

    public void a(k kVar) {
        this.h = ResponseType.STRING;
        this.O = kVar;
        com.meizu.cloud.pushsdk.networking.d.a.a().a(this);
    }

    public com.meizu.cloud.pushsdk.networking.common.c a() {
        this.h = ResponseType.BITMAP;
        return com.meizu.cloud.pushsdk.networking.d.e.a(this);
    }

    public com.meizu.cloud.pushsdk.networking.common.c b() {
        return com.meizu.cloud.pushsdk.networking.d.e.a(this);
    }

    public int c() {
        return this.b;
    }

    public Priority d() {
        return this.c;
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
        f.a g = com.meizu.cloud.pushsdk.networking.b.f.c(str).g();
        for (Map.Entry<String, String> entry : this.m.entrySet()) {
            g.a(entry.getKey(), entry.getValue());
        }
        return g.b().toString();
    }

    public int f() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public ResponseType g() {
        return this.h;
    }

    public int h() {
        return this.d;
    }

    public void a(String str) {
        this.aa = str;
    }

    public String i() {
        return this.aa;
    }

    public void j() {
        this.E = true;
        if (this.T != null) {
            if (!this.D) {
                if (this.Z != null) {
                    this.Z.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.common.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.T != null) {
                                b.this.T.a();
                            }
                            com.meizu.cloud.pushsdk.networking.common.a.a("Delivering success : " + toString());
                            b.this.p();
                        }
                    });
                    return;
                } else {
                    com.meizu.cloud.pushsdk.networking.a.b.a().b().c().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.common.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.T != null) {
                                b.this.T.a();
                            }
                            com.meizu.cloud.pushsdk.networking.common.a.a("Delivering success : " + toString());
                            b.this.p();
                        }
                    });
                    return;
                }
            }
            b(new ANError());
            p();
            return;
        }
        com.meizu.cloud.pushsdk.networking.common.a.a("Prefetch done : " + toString());
        p();
    }

    public o k() {
        return new o() { // from class: com.meizu.cloud.pushsdk.networking.common.b.3
            @Override // com.meizu.cloud.pushsdk.networking.c.o
            public void a(long j, long j2) {
                b.this.C = (int) ((100 * j) / j2);
                if (b.this.S != null && !b.this.D) {
                    b.this.S.a(j, j2);
                }
            }
        };
    }

    public String l() {
        return this.p;
    }

    public String m() {
        return this.q;
    }

    public com.meizu.cloud.pushsdk.networking.b.a n() {
        return this.B;
    }

    public void a(com.meizu.cloud.pushsdk.networking.b.a aVar) {
        this.B = aVar;
    }

    public void a(Future future) {
        this.A = future;
    }

    public void o() {
        this.G = null;
        this.G = null;
        this.I = null;
        this.K = null;
        this.L = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
    }

    public void p() {
        o();
        com.meizu.cloud.pushsdk.networking.d.a.a().b(this);
    }

    public com.meizu.cloud.pushsdk.networking.common.c a(com.meizu.cloud.pushsdk.networking.b.k kVar) {
        com.meizu.cloud.pushsdk.networking.common.c<Bitmap> a2;
        switch (this.h) {
            case JSON_ARRAY:
                try {
                    return com.meizu.cloud.pushsdk.networking.common.c.a(new JSONArray(com.meizu.cloud.pushsdk.networking.okio.f.a(kVar.b().a()).h()));
                } catch (Exception e) {
                    return com.meizu.cloud.pushsdk.networking.common.c.a(com.meizu.cloud.pushsdk.networking.e.b.b(new ANError(e)));
                }
            case JSON_OBJECT:
                try {
                    return com.meizu.cloud.pushsdk.networking.common.c.a(new JSONObject(com.meizu.cloud.pushsdk.networking.okio.f.a(kVar.b().a()).h()));
                } catch (Exception e2) {
                    return com.meizu.cloud.pushsdk.networking.common.c.a(com.meizu.cloud.pushsdk.networking.e.b.b(new ANError(e2)));
                }
            case STRING:
                try {
                    return com.meizu.cloud.pushsdk.networking.common.c.a(com.meizu.cloud.pushsdk.networking.okio.f.a(kVar.b().a()).h());
                } catch (Exception e3) {
                    return com.meizu.cloud.pushsdk.networking.common.c.a(com.meizu.cloud.pushsdk.networking.e.b.b(new ANError(e3)));
                }
            case BITMAP:
                synchronized (z) {
                    try {
                        a2 = com.meizu.cloud.pushsdk.networking.e.b.a(kVar, this.W, this.X, this.V, this.Y);
                    } catch (Exception e4) {
                        a2 = com.meizu.cloud.pushsdk.networking.common.c.a(com.meizu.cloud.pushsdk.networking.e.b.b(new ANError(e4)));
                    }
                }
                return a2;
            case PREFETCH:
                return com.meizu.cloud.pushsdk.networking.common.c.a("prefetch");
            default:
                return null;
        }
    }

    public ANError a(ANError aNError) {
        try {
            if (aNError.getResponse() != null && aNError.getResponse().b() != null && aNError.getResponse().b().a() != null) {
                aNError.setErrorBody(com.meizu.cloud.pushsdk.networking.okio.f.a(aNError.getResponse().b().a()).h());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aNError;
    }

    public synchronized void b(ANError aNError) {
        try {
            if (!this.E) {
                if (this.D) {
                    aNError.setCancellationMessageInError();
                    aNError.setErrorCode(0);
                }
                c(aNError);
                com.meizu.cloud.pushsdk.networking.common.a.a("Delivering anError : " + toString());
            }
            this.E = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(final com.meizu.cloud.pushsdk.networking.common.c cVar) {
        try {
            this.E = true;
            if (!this.D) {
                if (this.Z != null) {
                    this.Z.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.common.b.4
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.b(cVar);
                        }
                    });
                } else {
                    com.meizu.cloud.pushsdk.networking.a.b.a().b().c().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.common.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.b(cVar);
                        }
                    });
                }
                com.meizu.cloud.pushsdk.networking.common.a.a("Delivering success : " + toString());
                return;
            }
            ANError aNError = new ANError();
            aNError.setCancellationMessageInError();
            aNError.setErrorCode(0);
            c(aNError);
            p();
            com.meizu.cloud.pushsdk.networking.common.a.a("Delivering cancelled : " + toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.meizu.cloud.pushsdk.networking.common.c cVar) {
        if (this.H != null) {
            this.H.a((JSONObject) cVar.a());
        } else if (this.G != null) {
            this.G.a((JSONArray) cVar.a());
        } else if (this.I != null) {
            this.I.a((String) cVar.a());
        } else if (this.K != null) {
            this.K.a((Bitmap) cVar.a());
        } else if (this.L != null) {
            this.L.a((m) cVar.a());
        } else if (this.M != null) {
            this.M.a(cVar.d(), (JSONObject) cVar.a());
        } else if (this.N != null) {
            this.N.a(cVar.d(), (JSONArray) cVar.a());
        } else if (this.O != null) {
            this.O.a(cVar.d(), (String) cVar.a());
        } else if (this.P != null) {
            this.P.a(cVar.d(), (Bitmap) cVar.a());
        } else if (this.Q != null) {
            this.Q.a(cVar.d(), cVar.a());
        }
        p();
    }

    private void c(ANError aNError) {
        if (this.H != null) {
            this.H.a(aNError);
        } else if (this.G != null) {
            this.G.a(aNError);
        } else if (this.I != null) {
            this.I.a(aNError);
        } else if (this.K != null) {
            this.K.a(aNError);
        } else if (this.L != null) {
            this.L.a(aNError);
        } else if (this.M != null) {
            this.M.a(aNError);
        } else if (this.N != null) {
            this.N.a(aNError);
        } else if (this.O != null) {
            this.O.a(aNError);
        } else if (this.P != null) {
            this.P.a(aNError);
        } else if (this.Q != null) {
            this.Q.a(aNError);
        } else if (this.T != null) {
            this.T.a(aNError);
        }
    }

    public void b(final com.meizu.cloud.pushsdk.networking.b.k kVar) {
        try {
            this.E = true;
            if (!this.D) {
                if (this.Z != null) {
                    this.Z.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.common.b.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.J != null) {
                                b.this.J.a(kVar);
                            }
                            b.this.p();
                        }
                    });
                } else {
                    com.meizu.cloud.pushsdk.networking.a.b.a().b().c().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.networking.common.b.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.J != null) {
                                b.this.J.a(kVar);
                            }
                            b.this.p();
                        }
                    });
                }
                com.meizu.cloud.pushsdk.networking.common.a.a("Delivering success : " + toString());
                return;
            }
            ANError aNError = new ANError();
            aNError.setCancellationMessageInError();
            aNError.setErrorCode(0);
            if (this.J != null) {
                this.J.a(aNError);
            }
            p();
            com.meizu.cloud.pushsdk.networking.common.a.a("Delivering cancelled : " + toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public com.meizu.cloud.pushsdk.networking.b.j q() {
        if (this.r != null) {
            if (this.y != null) {
                return com.meizu.cloud.pushsdk.networking.b.j.a(this.y, this.r.toString());
            }
            return com.meizu.cloud.pushsdk.networking.b.j.a(w, this.r.toString());
        } else if (this.s != null) {
            if (this.y != null) {
                return com.meizu.cloud.pushsdk.networking.b.j.a(this.y, this.s.toString());
            }
            return com.meizu.cloud.pushsdk.networking.b.j.a(w, this.s.toString());
        } else if (this.t != null) {
            if (this.y != null) {
                return com.meizu.cloud.pushsdk.networking.b.j.a(this.y, this.t);
            }
            return com.meizu.cloud.pushsdk.networking.b.j.a(x, this.t);
        } else if (this.v != null) {
            if (this.y != null) {
                return com.meizu.cloud.pushsdk.networking.b.j.a(this.y, this.v);
            }
            return com.meizu.cloud.pushsdk.networking.b.j.a(x, this.v);
        } else if (this.u != null) {
            if (this.y != null) {
                return com.meizu.cloud.pushsdk.networking.b.j.a(this.y, this.u);
            }
            return com.meizu.cloud.pushsdk.networking.b.j.a(x, this.u);
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

    public com.meizu.cloud.pushsdk.networking.b.j r() {
        h.a a2 = new h.a().a(com.meizu.cloud.pushsdk.networking.b.h.e);
        try {
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                a2.a(com.meizu.cloud.pushsdk.networking.b.c.a(MIME.CONTENT_DISPOSITION, "form-data; name=\"" + entry.getKey() + "\""), com.meizu.cloud.pushsdk.networking.b.j.a((g) null, entry.getValue()));
            }
            for (Map.Entry<String, File> entry2 : this.o.entrySet()) {
                String name = entry2.getValue().getName();
                a2.a(com.meizu.cloud.pushsdk.networking.b.c.a(MIME.CONTENT_DISPOSITION, "form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + name + "\""), com.meizu.cloud.pushsdk.networking.b.j.a(g.a(com.meizu.cloud.pushsdk.networking.e.b.a(name)), entry2.getValue()));
                if (this.y != null) {
                    a2.a(this.y);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a2.a();
    }

    public com.meizu.cloud.pushsdk.networking.b.c s() {
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

    /* renamed from: com.meizu.cloud.pushsdk.networking.common.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0269b<T extends C0269b> {
        private int b;
        private String c;
        private Object d;
        private Bitmap.Config e;
        private int f;
        private int g;
        private ImageView.ScaleType h;
        private Executor l;
        private String m;
        private Priority a = Priority.MEDIUM;
        private HashMap<String, String> i = new HashMap<>();
        private HashMap<String, String> j = new HashMap<>();
        private HashMap<String, String> k = new HashMap<>();

        public C0269b(String str) {
            this.b = 0;
            this.c = str;
            this.b = 0;
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

    /* loaded from: classes3.dex */
    public static class c<T extends c> {
        private int b;
        private String c;
        private Object d;
        private Executor o;
        private String p;
        private String q;
        private Priority a = Priority.MEDIUM;
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

        public c(String str) {
            this.b = 1;
            this.c = str;
            this.b = 1;
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

    /* loaded from: classes3.dex */
    public static class a<T extends a> {
        private String b;
        private Object c;
        private String g;
        private String h;
        private Executor j;
        private String k;
        private Priority a = Priority.MEDIUM;
        private HashMap<String, String> d = new HashMap<>();
        private HashMap<String, String> e = new HashMap<>();
        private HashMap<String, String> f = new HashMap<>();
        private int i = 0;

        public a(String str, String str2, String str3) {
            this.b = str;
            this.g = str2;
            this.h = str3;
        }

        public b a() {
            return new b(this);
        }
    }

    public String toString() {
        return "ANRequest{sequenceNumber='" + this.f + ", mMethod=" + this.b + ", mPriority=" + this.c + ", mRequestType=" + this.d + ", mUrl=" + this.e + '}';
    }
}
