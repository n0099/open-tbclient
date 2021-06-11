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
    public static volatile b f44092g;

    /* renamed from: c  reason: collision with root package name */
    public e f44093c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.h.c f44094d;

    /* renamed from: e  reason: collision with root package name */
    public Context f44095e;

    /* renamed from: f  reason: collision with root package name */
    public int f44096f;

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
    public class RunnableC0610b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f44098e;

        public RunnableC0610b(long j) {
            this.f44098e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.i(false)) {
                    d.a.j0.b.a.h(b.this.f44095e).G(this.f44098e);
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
                b.c(b.this.f44095e).i(true);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    public b(Context context, Handler handler) {
        super(context, handler);
        this.f44096f = 0;
        this.f44095e = context;
        this.f44093c = e.a(context);
        this.f44094d = new d.a.j0.h.c();
    }

    public static b c(Context context) {
        if (f44092g == null) {
            synchronized (b.class) {
                if (f44092g == null) {
                    f44092g = new b(context, null);
                }
            }
        }
        return f44092g;
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
        long c0 = d.a.j0.b.a.h(this.f44095e).c0();
        long j0 = d.a.j0.b.a.h(this.f44095e).j0() * d.a.j0.l.c.f44150e;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - c0 >= j0 && d.a.j0.l.c.k(this.f44095e) != 0 && d.a.j0.l.c.o(this.f44095e)) {
            d.a.j0.h.a.a().post(new RunnableC0610b(currentTimeMillis));
        }
    }

    public synchronized void f(String str, String str2, int i2) {
        d.a.j0.j.a a2;
        try {
            a2 = this.f44094d.a(this.f44095e, str, str2, i2, 1);
        } finally {
        }
        if (a2 == null) {
            return;
        }
        this.f44096f++;
        d.a.j0.i.a.a(this.f44095e).c(a2);
        if (this.f44096f >= 2 && d.a.j0.l.c.o(this.f44095e)) {
            this.f44096f = 0;
            d.a.j0.h.a.a().post(new a());
        }
    }

    public final boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = g.b(d.a.j0.l.d.f(this.f44095e)).getBytes();
            byte[] f2 = d.a.j0.l.c.f();
            String b2 = this.f44093c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(d.a.j0.l.e.h(f2, bytes), 0)));
            byte[] e2 = this.f44093c.e(f2, str);
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
            int k = d.a.j0.l.c.k(this.f44095e);
            if (k != 2) {
                z2 = k == 1 ? true : true;
                return false;
            }
            z2 = false;
            String valueOf = z ? String.valueOf(1) : "1,2";
            if (z2) {
                b2 = d.a.j0.i.a.a(this.f44095e).e(valueOf);
                String b0 = d.a.j0.b.a.h(this.f44095e).b0();
                String a2 = d.a.j0.l.c.a();
                if (!TextUtils.isEmpty(a2) && !a2.equals(b0)) {
                    d.a.j0.b.a.h(this.f44095e).L(a2);
                    d.a.j0.b.a.h(this.f44095e).T(0L);
                }
            } else {
                b2 = d.a.j0.i.a.a(this.f44095e).b(valueOf);
            }
            if (b2 != null && b2.size() != 0) {
                long n0 = d.a.j0.b.a.h(this.f44095e).n0();
                int size = b2.size();
                long h0 = d.a.j0.b.a.h(this.f44095e).h0() * 1048576;
                JSONArray jSONArray = new JSONArray();
                ArrayList<d.a.j0.j.a> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < size; i2++) {
                    d.a.j0.j.a aVar = b2.get(i2);
                    if (aVar != null) {
                        String d2 = aVar.d();
                        if (z2) {
                            if (d2.length() + n0 > h0) {
                                break;
                            }
                            n0 += d2.length();
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
                    d.a.j0.i.a.a(this.f44095e).d(arrayList);
                    if (z2) {
                        d.a.j0.b.a.h(this.f44095e).T(d.a.j0.b.a.h(this.f44095e).n0() + jSONArray.toString().length());
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
        if (d.a.j0.l.c.o(this.f44095e)) {
            d.a.j0.h.a.a().post(new c());
        }
    }
}
