package d.a.j0.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import d.a.j0.f.e;
import d.a.j0.l.g;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.j0.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f40413g;

    /* renamed from: c  reason: collision with root package name */
    public e f40414c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.h.c f40415d;

    /* renamed from: e  reason: collision with root package name */
    public Context f40416e;

    /* renamed from: f  reason: collision with root package name */
    public int f40417f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.i(true);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.a.j0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0553b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f40419e;

        public RunnableC0553b(long j) {
            this.f40419e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.i(false)) {
                    d.a.j0.b.a.g(b.this.f40416e).E(this.f40419e);
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.c(b.this.f40416e).i(true);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    public b(Context context, Handler handler) {
        super(context, handler);
        this.f40417f = 0;
        this.f40416e = context;
        this.f40414c = e.a(context);
        this.f40415d = new d.a.j0.h.c();
    }

    public static b c(Context context) {
        if (f40413g == null) {
            synchronized (b.class) {
                if (f40413g == null) {
                    f40413g = new b(context, null);
                }
            }
        }
        return f40413g;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        try {
            jSONArray.put(new JSONObject(str));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
        return jSONArray;
    }

    public void e() {
        long a0 = d.a.j0.b.a.g(this.f40416e).a0();
        long g0 = d.a.j0.b.a.g(this.f40416e).g0() * d.a.j0.l.c.f40471e;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a0 >= g0 && d.a.j0.l.c.k(this.f40416e) != 0 && d.a.j0.l.c.o(this.f40416e)) {
            d.a.j0.h.a.a().post(new RunnableC0553b(currentTimeMillis));
        }
    }

    public synchronized void f(String str, String str2, int i2) {
        d.a.j0.j.a a2;
        try {
            a2 = this.f40415d.a(this.f40416e, str, str2, i2, 1);
        } finally {
        }
        if (a2 == null) {
            return;
        }
        this.f40417f++;
        d.a.j0.i.a.a(this.f40416e).c(a2);
        if (this.f40417f >= 2 && d.a.j0.l.c.o(this.f40416e)) {
            this.f40417f = 0;
            d.a.j0.h.a.a().post(new a());
        }
    }

    public final boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = g.b(d.a.j0.l.d.e(this.f40416e)).getBytes();
            byte[] f2 = d.a.j0.l.c.f();
            String b2 = this.f40414c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(d.a.j0.l.e.h(f2, bytes), 0)));
            byte[] e2 = this.f40414c.e(f2, str);
            if (e2 == null) {
                return false;
            }
            String a2 = a(b2, e2);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            try {
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
            return new JSONObject(a2).getInt("response") == 1;
        } catch (Throwable th2) {
            d.a.j0.l.c.d(th2);
            return false;
        }
    }

    public final boolean i(boolean z) {
        boolean z2;
        ArrayList<d.a.j0.j.a> b2;
        try {
            int k = d.a.j0.l.c.k(this.f40416e);
            if (k != 2) {
                z2 = k == 1 ? true : true;
                return false;
            }
            z2 = false;
            String valueOf = z ? String.valueOf(1) : "1,2";
            if (z2) {
                b2 = d.a.j0.i.a.a(this.f40416e).e(valueOf);
                String Z = d.a.j0.b.a.g(this.f40416e).Z();
                String a2 = d.a.j0.l.c.a();
                if (!TextUtils.isEmpty(a2) && !a2.equals(Z)) {
                    d.a.j0.b.a.g(this.f40416e).J(a2);
                    d.a.j0.b.a.g(this.f40416e).R(0L);
                }
            } else {
                b2 = d.a.j0.i.a.a(this.f40416e).b(valueOf);
            }
            if (b2 != null && b2.size() != 0) {
                long k0 = d.a.j0.b.a.g(this.f40416e).k0();
                int size = b2.size();
                long e0 = d.a.j0.b.a.g(this.f40416e).e0() * 1048576;
                JSONArray jSONArray = new JSONArray();
                ArrayList<d.a.j0.j.a> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.j0.j.a aVar = b2.get(i2);
                    if (aVar != null) {
                        String d2 = aVar.d();
                        if (z2) {
                            if (d2.length() + k0 > e0) {
                                break;
                            }
                            k0 += d2.length();
                        }
                        d(jSONArray, d2);
                        arrayList.add(aVar);
                    }
                }
                if (jSONArray.length() == 0) {
                    return false;
                }
                boolean h2 = h(jSONArray.toString());
                if (h2) {
                    d.a.j0.i.a.a(this.f40416e).d(arrayList);
                    if (z2) {
                        d.a.j0.b.a.g(this.f40416e).R(d.a.j0.b.a.g(this.f40416e).k0() + jSONArray.toString().length());
                    }
                }
                return h2;
            }
            return false;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return false;
        }
    }

    public void j() {
        if (d.a.j0.l.c.o(this.f40416e)) {
            d.a.j0.h.a.a().post(new c());
        }
    }
}
