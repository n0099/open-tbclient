package d.b.g0.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import d.b.g0.f.e;
import d.b.g0.l.g;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.g0.f.a {

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f43655g;

    /* renamed from: c  reason: collision with root package name */
    public e f43656c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.h.c f43657d;

    /* renamed from: e  reason: collision with root package name */
    public Context f43658e;

    /* renamed from: f  reason: collision with root package name */
    public int f43659f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.i(true);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* renamed from: d.b.g0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0614b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43661e;

        public RunnableC0614b(long j) {
            this.f43661e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.i(false)) {
                    d.b.g0.b.a.g(b.this.f43658e).E(this.f43661e);
                }
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
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
                b.c(b.this.f43658e).i(true);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    public b(Context context, Handler handler) {
        super(context, handler);
        this.f43659f = 0;
        this.f43658e = context;
        this.f43656c = e.a(context);
        this.f43657d = new d.b.g0.h.c();
    }

    public static b c(Context context) {
        if (f43655g == null) {
            synchronized (b.class) {
                if (f43655g == null) {
                    f43655g = new b(context, null);
                }
            }
        }
        return f43655g;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        try {
            jSONArray.put(new JSONObject(str));
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
        }
        return jSONArray;
    }

    public void e() {
        long a0 = d.b.g0.b.a.g(this.f43658e).a0();
        long g0 = d.b.g0.b.a.g(this.f43658e).g0() * d.b.g0.l.c.f43708e;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a0 >= g0 && d.b.g0.l.c.k(this.f43658e) != 0 && d.b.g0.l.c.o(this.f43658e)) {
            d.b.g0.h.a.a().post(new RunnableC0614b(currentTimeMillis));
        }
    }

    public synchronized void f(String str, String str2, int i) {
        d.b.g0.j.a a2;
        try {
            a2 = this.f43657d.a(this.f43658e, str, str2, i, 1);
        } finally {
        }
        if (a2 == null) {
            return;
        }
        this.f43659f++;
        d.b.g0.i.a.a(this.f43658e).c(a2);
        if (this.f43659f >= 2 && d.b.g0.l.c.o(this.f43658e)) {
            this.f43659f = 0;
            d.b.g0.h.a.a().post(new a());
        }
    }

    public final boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bytes = g.b(d.b.g0.l.d.e(this.f43658e)).getBytes();
            byte[] f2 = d.b.g0.l.c.f();
            String b2 = this.f43656c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(d.b.g0.l.e.h(f2, bytes), 0)));
            byte[] e2 = this.f43656c.e(f2, str);
            if (e2 == null) {
                return false;
            }
            String a2 = a(b2, e2);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            try {
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
            return new JSONObject(a2).getInt("response") == 1;
        } catch (Throwable th2) {
            d.b.g0.l.c.d(th2);
            return false;
        }
    }

    public final boolean i(boolean z) {
        boolean z2;
        ArrayList<d.b.g0.j.a> b2;
        try {
            int k = d.b.g0.l.c.k(this.f43658e);
            if (k != 2) {
                z2 = k == 1 ? true : true;
                return false;
            }
            z2 = false;
            String valueOf = z ? String.valueOf(1) : "1,2";
            if (z2) {
                b2 = d.b.g0.i.a.a(this.f43658e).e(valueOf);
                String Z = d.b.g0.b.a.g(this.f43658e).Z();
                String a2 = d.b.g0.l.c.a();
                if (!TextUtils.isEmpty(a2) && !a2.equals(Z)) {
                    d.b.g0.b.a.g(this.f43658e).J(a2);
                    d.b.g0.b.a.g(this.f43658e).R(0L);
                }
            } else {
                b2 = d.b.g0.i.a.a(this.f43658e).b(valueOf);
            }
            if (b2 != null && b2.size() != 0) {
                long k0 = d.b.g0.b.a.g(this.f43658e).k0();
                int size = b2.size();
                long e0 = d.b.g0.b.a.g(this.f43658e).e0() * 1048576;
                JSONArray jSONArray = new JSONArray();
                ArrayList<d.b.g0.j.a> arrayList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    d.b.g0.j.a aVar = b2.get(i);
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
                    d.b.g0.i.a.a(this.f43658e).d(arrayList);
                    if (z2) {
                        d.b.g0.b.a.g(this.f43658e).R(d.b.g0.b.a.g(this.f43658e).k0() + jSONArray.toString().length());
                    }
                }
                return h2;
            }
            return false;
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
            return false;
        }
    }

    public void j() {
        if (d.b.g0.l.c.o(this.f43658e)) {
            d.b.g0.h.a.a().post(new c());
        }
    }
}
