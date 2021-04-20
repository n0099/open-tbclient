package d.b.f0.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import d.b.f0.f.e;
import d.b.f0.l.g;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.f0.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f43358g;

    /* renamed from: c  reason: collision with root package name */
    public e f43359c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.f0.h.c f43360d;

    /* renamed from: e  reason: collision with root package name */
    public Context f43361e;

    /* renamed from: f  reason: collision with root package name */
    public int f43362f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.i(true);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.b.f0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0595b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43364e;

        public RunnableC0595b(long j) {
            this.f43364e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.i(false)) {
                    d.b.f0.b.a.g(b.this.f43361e).E(this.f43364e);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
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
                b.c(b.this.f43361e).i(true);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    public b(Context context, Handler handler) {
        super(context, handler);
        this.f43362f = 0;
        this.f43361e = context;
        this.f43359c = e.a(context);
        this.f43360d = new d.b.f0.h.c();
    }

    public static b c(Context context) {
        if (f43358g == null) {
            synchronized (b.class) {
                if (f43358g == null) {
                    f43358g = new b(context, null);
                }
            }
        }
        return f43358g;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        try {
            jSONArray.put(new JSONObject(str));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
        return jSONArray;
    }

    public void e() {
        long a0 = d.b.f0.b.a.g(this.f43361e).a0();
        long g0 = d.b.f0.b.a.g(this.f43361e).g0() * d.b.f0.l.c.f43411e;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a0 >= g0 && d.b.f0.l.c.k(this.f43361e) != 0 && d.b.f0.l.c.o(this.f43361e)) {
            d.b.f0.h.a.a().post(new RunnableC0595b(currentTimeMillis));
        }
    }

    public synchronized void f(String str, String str2, int i) {
        d.b.f0.j.a a2;
        try {
            a2 = this.f43360d.a(this.f43361e, str, str2, i, 1);
        } finally {
        }
        if (a2 == null) {
            return;
        }
        this.f43362f++;
        d.b.f0.i.a.a(this.f43361e).c(a2);
        if (this.f43362f >= 2 && d.b.f0.l.c.o(this.f43361e)) {
            this.f43362f = 0;
            d.b.f0.h.a.a().post(new a());
        }
    }

    public final boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = g.b(d.b.f0.l.d.e(this.f43361e)).getBytes();
            byte[] f2 = d.b.f0.l.c.f();
            String b2 = this.f43359c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(d.b.f0.l.e.h(f2, bytes), 0)));
            byte[] e2 = this.f43359c.e(f2, str);
            if (e2 == null) {
                return false;
            }
            String a2 = a(b2, e2);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            try {
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
            return new JSONObject(a2).getInt("response") == 1;
        } catch (Throwable th2) {
            d.b.f0.l.c.d(th2);
            return false;
        }
    }

    public final boolean i(boolean z) {
        boolean z2;
        ArrayList<d.b.f0.j.a> b2;
        try {
            int k = d.b.f0.l.c.k(this.f43361e);
            if (k != 2) {
                z2 = k == 1 ? true : true;
                return false;
            }
            z2 = false;
            String valueOf = z ? String.valueOf(1) : "1,2";
            if (z2) {
                b2 = d.b.f0.i.a.a(this.f43361e).e(valueOf);
                String Z = d.b.f0.b.a.g(this.f43361e).Z();
                String a2 = d.b.f0.l.c.a();
                if (!TextUtils.isEmpty(a2) && !a2.equals(Z)) {
                    d.b.f0.b.a.g(this.f43361e).J(a2);
                    d.b.f0.b.a.g(this.f43361e).R(0L);
                }
            } else {
                b2 = d.b.f0.i.a.a(this.f43361e).b(valueOf);
            }
            if (b2 != null && b2.size() != 0) {
                long k0 = d.b.f0.b.a.g(this.f43361e).k0();
                int size = b2.size();
                long e0 = d.b.f0.b.a.g(this.f43361e).e0() * 1048576;
                JSONArray jSONArray = new JSONArray();
                ArrayList<d.b.f0.j.a> arrayList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    d.b.f0.j.a aVar = b2.get(i);
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
                    d.b.f0.i.a.a(this.f43361e).d(arrayList);
                    if (z2) {
                        d.b.f0.b.a.g(this.f43361e).R(d.b.f0.b.a.g(this.f43361e).k0() + jSONArray.toString().length());
                    }
                }
                return h2;
            }
            return false;
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return false;
        }
    }

    public void j() {
        if (d.b.f0.l.c.o(this.f43361e)) {
            d.b.f0.h.a.a().post(new c());
        }
    }
}
