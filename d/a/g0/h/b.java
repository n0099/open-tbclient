package d.a.g0.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import d.a.g0.f.e;
import d.a.g0.l.g;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.g0.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f40152g;

    /* renamed from: c  reason: collision with root package name */
    public e f40153c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.g0.h.c f40154d;

    /* renamed from: e  reason: collision with root package name */
    public Context f40155e;

    /* renamed from: f  reason: collision with root package name */
    public int f40156f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.i(true);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.a.g0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0540b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f40158e;

        public RunnableC0540b(long j) {
            this.f40158e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.i(false)) {
                    d.a.g0.b.a.g(b.this.f40155e).E(this.f40158e);
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
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
                b.c(b.this.f40155e).i(true);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    public b(Context context, Handler handler) {
        super(context, handler);
        this.f40156f = 0;
        this.f40155e = context;
        this.f40153c = e.a(context);
        this.f40154d = new d.a.g0.h.c();
    }

    public static b c(Context context) {
        if (f40152g == null) {
            synchronized (b.class) {
                if (f40152g == null) {
                    f40152g = new b(context, null);
                }
            }
        }
        return f40152g;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        try {
            jSONArray.put(new JSONObject(str));
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
        }
        return jSONArray;
    }

    public void e() {
        long a0 = d.a.g0.b.a.g(this.f40155e).a0();
        long g0 = d.a.g0.b.a.g(this.f40155e).g0() * d.a.g0.l.c.f40210e;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a0 >= g0 && d.a.g0.l.c.k(this.f40155e) != 0 && d.a.g0.l.c.o(this.f40155e)) {
            d.a.g0.h.a.a().post(new RunnableC0540b(currentTimeMillis));
        }
    }

    public synchronized void f(String str, String str2, int i2) {
        d.a.g0.j.a a2;
        try {
            a2 = this.f40154d.a(this.f40155e, str, str2, i2, 1);
        } finally {
        }
        if (a2 == null) {
            return;
        }
        this.f40156f++;
        d.a.g0.i.a.a(this.f40155e).c(a2);
        if (this.f40156f >= 2 && d.a.g0.l.c.o(this.f40155e)) {
            this.f40156f = 0;
            d.a.g0.h.a.a().post(new a());
        }
    }

    public final boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = g.b(d.a.g0.l.d.e(this.f40155e)).getBytes();
            byte[] f2 = d.a.g0.l.c.f();
            String b2 = this.f40153c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(d.a.g0.l.e.h(f2, bytes), 0)));
            byte[] e2 = this.f40153c.e(f2, str);
            if (e2 == null) {
                return false;
            }
            String a2 = a(b2, e2);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            try {
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
            return new JSONObject(a2).getInt("response") == 1;
        } catch (Throwable th2) {
            d.a.g0.l.c.d(th2);
            return false;
        }
    }

    public final boolean i(boolean z) {
        boolean z2;
        ArrayList<d.a.g0.j.a> b2;
        try {
            int k = d.a.g0.l.c.k(this.f40155e);
            if (k != 2) {
                z2 = k == 1 ? true : true;
                return false;
            }
            z2 = false;
            String valueOf = z ? String.valueOf(1) : "1,2";
            if (z2) {
                b2 = d.a.g0.i.a.a(this.f40155e).e(valueOf);
                String Z = d.a.g0.b.a.g(this.f40155e).Z();
                String a2 = d.a.g0.l.c.a();
                if (!TextUtils.isEmpty(a2) && !a2.equals(Z)) {
                    d.a.g0.b.a.g(this.f40155e).J(a2);
                    d.a.g0.b.a.g(this.f40155e).R(0L);
                }
            } else {
                b2 = d.a.g0.i.a.a(this.f40155e).b(valueOf);
            }
            if (b2 != null && b2.size() != 0) {
                long k0 = d.a.g0.b.a.g(this.f40155e).k0();
                int size = b2.size();
                long e0 = d.a.g0.b.a.g(this.f40155e).e0() * 1048576;
                JSONArray jSONArray = new JSONArray();
                ArrayList<d.a.g0.j.a> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.g0.j.a aVar = b2.get(i2);
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
                    d.a.g0.i.a.a(this.f40155e).d(arrayList);
                    if (z2) {
                        d.a.g0.b.a.g(this.f40155e).R(d.a.g0.b.a.g(this.f40155e).k0() + jSONArray.toString().length());
                    }
                }
                return h2;
            }
            return false;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return false;
        }
    }

    public void j() {
        if (d.a.g0.l.c.o(this.f40155e)) {
            d.a.g0.h.a.a().post(new c());
        }
    }
}
