package d.a.q.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static b f64143i;

    /* renamed from: a  reason: collision with root package name */
    public Thread f64144a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f64145b;

    /* renamed from: c  reason: collision with root package name */
    public c f64146c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q.f.a.k.b f64147d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f64148e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f64149f;

    /* renamed from: g  reason: collision with root package name */
    public j f64150g;

    /* renamed from: h  reason: collision with root package name */
    public Context f64151h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            b bVar = b.this;
            bVar.f64146c = new g(bVar.f64151h);
            if (b.this.f64150g != null) {
                b.this.f64150g.a(b.this.f64146c.a());
                z = b.this.f64150g.a();
            } else {
                z = false;
            }
            if (z && b.this.k()) {
                b.this.m();
                b.this.o();
            }
            b.this.f64144a = null;
        }
    }

    /* renamed from: d.a.q.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1786b {

        /* renamed from: a  reason: collision with root package name */
        public static C1786b f64153a;

        public C1786b(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (b.f64143i == null) {
                synchronized (b.class) {
                    if (b.f64143i == null) {
                        b unused = b.f64143i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1786b c(Context context) {
            if (f64153a == null) {
                synchronized (b.class) {
                    if (f64153a == null) {
                        f64153a = new C1786b(context);
                    }
                }
            }
            return f64153a;
        }

        public final void a() {
            b.f64143i.f64148e = new HashMap();
            b.f64143i.f64148e.put(BOSTokenRequest.CHARSET, "utf-8");
            b.f64143i.f64148e.put("Content-type", "application/json");
            b.f64143i.f64147d = new d.a.q.f.a.r.a();
        }

        public b b() {
            if (b.f64143i.f64147d == null) {
                a();
            }
            return b.f64143i;
        }
    }

    public b(Context context) {
        this.f64145b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f64151h = context;
        this.f64150g = new o(context);
    }

    public /* synthetic */ b(Context context, d.a.q.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        HashMap<String, String> hashMap = this.f64149f;
        return hashMap == null ? str : q.b(str, hashMap);
    }

    public final Runnable h() {
        return new a();
    }

    public final boolean k() {
        d.a.q.f.a.k.c a2;
        String e2 = e("https://mbd.baidu.com/store");
        d.a.q.f.a.k.b bVar = this.f64147d;
        JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f64148e, this.f64146c.a()));
        return a3 != null && a3.optInt("errno", -1) == 0;
    }

    public final void m() {
        j jVar = this.f64150g;
        if (jVar != null) {
            jVar.b(this.f64146c.a());
        }
    }

    public final void o() {
        AtomicInteger atomicInteger = this.f64145b;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public void t() {
        synchronized (b.class) {
            if (this.f64145b.get() == 0) {
                if (this.f64151h == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f64145b.set(1);
                if (this.f64144a == null) {
                    this.f64144a = new Thread(h());
                }
                this.f64144a.start();
            }
        }
    }
}
