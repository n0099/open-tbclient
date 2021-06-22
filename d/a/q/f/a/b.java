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
    public static b f67817i;

    /* renamed from: a  reason: collision with root package name */
    public Thread f67818a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f67819b;

    /* renamed from: c  reason: collision with root package name */
    public c f67820c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q.f.a.k.b f67821d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f67822e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f67823f;

    /* renamed from: g  reason: collision with root package name */
    public j f67824g;

    /* renamed from: h  reason: collision with root package name */
    public Context f67825h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            b bVar = b.this;
            bVar.f67820c = new g(bVar.f67825h);
            if (b.this.f67824g != null) {
                b.this.f67824g.a(b.this.f67820c.a());
                z = b.this.f67824g.a();
            } else {
                z = false;
            }
            if (z && b.this.k()) {
                b.this.m();
                b.this.o();
            }
            b.this.f67818a = null;
        }
    }

    /* renamed from: d.a.q.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1846b {

        /* renamed from: a  reason: collision with root package name */
        public static C1846b f67827a;

        public C1846b(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (b.f67817i == null) {
                synchronized (b.class) {
                    if (b.f67817i == null) {
                        b unused = b.f67817i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1846b c(Context context) {
            if (f67827a == null) {
                synchronized (b.class) {
                    if (f67827a == null) {
                        f67827a = new C1846b(context);
                    }
                }
            }
            return f67827a;
        }

        public final void a() {
            b.f67817i.f67822e = new HashMap();
            b.f67817i.f67822e.put(BOSTokenRequest.CHARSET, "utf-8");
            b.f67817i.f67822e.put("Content-type", "application/json");
            b.f67817i.f67821d = new d.a.q.f.a.r.a();
        }

        public b b() {
            if (b.f67817i.f67821d == null) {
                a();
            }
            return b.f67817i;
        }
    }

    public b(Context context) {
        this.f67819b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f67825h = context;
        this.f67824g = new o(context);
    }

    public /* synthetic */ b(Context context, d.a.q.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        HashMap<String, String> hashMap = this.f67823f;
        return hashMap == null ? str : q.b(str, hashMap);
    }

    public final Runnable h() {
        return new a();
    }

    public final boolean k() {
        d.a.q.f.a.k.c a2;
        String e2 = e("https://mbd.baidu.com/store");
        d.a.q.f.a.k.b bVar = this.f67821d;
        JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f67822e, this.f67820c.a()));
        return a3 != null && a3.optInt("errno", -1) == 0;
    }

    public final void m() {
        j jVar = this.f67824g;
        if (jVar != null) {
            jVar.b(this.f67820c.a());
        }
    }

    public final void o() {
        AtomicInteger atomicInteger = this.f67819b;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public void t() {
        synchronized (b.class) {
            if (this.f67819b.get() == 0) {
                if (this.f67825h == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f67819b.set(1);
                if (this.f67818a == null) {
                    this.f67818a = new Thread(h());
                }
                this.f67818a.start();
            }
        }
    }
}
