package d.b.q.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static b i;

    /* renamed from: a  reason: collision with root package name */
    public Thread f64355a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f64356b;

    /* renamed from: c  reason: collision with root package name */
    public c f64357c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.q.f.a.k.b f64358d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f64359e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f64360f;

    /* renamed from: g  reason: collision with root package name */
    public j f64361g;

    /* renamed from: h  reason: collision with root package name */
    public Context f64362h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            b bVar = b.this;
            bVar.f64357c = new g(bVar.f64362h);
            if (b.this.f64361g != null) {
                b.this.f64361g.a(b.this.f64357c.a());
                z = b.this.f64361g.a();
            } else {
                z = false;
            }
            if (z && b.this.k()) {
                b.this.m();
                b.this.o();
            }
            b.this.f64355a = null;
        }
    }

    /* renamed from: d.b.q.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1751b {

        /* renamed from: a  reason: collision with root package name */
        public static C1751b f64364a;

        public C1751b(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (b.i == null) {
                synchronized (b.class) {
                    if (b.i == null) {
                        b unused = b.i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1751b c(Context context) {
            if (f64364a == null) {
                synchronized (b.class) {
                    if (f64364a == null) {
                        f64364a = new C1751b(context);
                    }
                }
            }
            return f64364a;
        }

        public final void a() {
            b.i.f64359e = new HashMap();
            b.i.f64359e.put(BOSTokenRequest.CHARSET, "utf-8");
            b.i.f64359e.put("Content-type", "application/json");
            b.i.f64358d = new d.b.q.f.a.r.a();
        }

        public b b() {
            if (b.i.f64358d == null) {
                a();
            }
            return b.i;
        }
    }

    public b(Context context) {
        this.f64356b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f64362h = context;
        this.f64361g = new o(context);
    }

    public /* synthetic */ b(Context context, d.b.q.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        HashMap<String, String> hashMap = this.f64360f;
        return hashMap == null ? str : q.b(str, hashMap);
    }

    public final Runnable h() {
        return new a();
    }

    public final boolean k() {
        d.b.q.f.a.k.c a2;
        String e2 = e("https://mbd.baidu.com/store");
        d.b.q.f.a.k.b bVar = this.f64358d;
        JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f64359e, this.f64357c.a()));
        return a3 != null && a3.optInt("errno", -1) == 0;
    }

    public final void m() {
        j jVar = this.f64361g;
        if (jVar != null) {
            jVar.b(this.f64357c.a());
        }
    }

    public final void o() {
        AtomicInteger atomicInteger = this.f64356b;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public void t() {
        synchronized (b.class) {
            if (this.f64356b.get() == 0) {
                if (this.f64362h == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f64356b.set(1);
                if (this.f64355a == null) {
                    this.f64355a = new Thread(h());
                }
                this.f64355a.start();
            }
        }
    }
}
