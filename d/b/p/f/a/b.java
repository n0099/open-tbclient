package d.b.p.f.a;

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
    public Thread f65049a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f65050b;

    /* renamed from: c  reason: collision with root package name */
    public c f65051c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.p.f.a.k.b f65052d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f65053e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f65054f;

    /* renamed from: g  reason: collision with root package name */
    public j f65055g;

    /* renamed from: h  reason: collision with root package name */
    public Context f65056h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            b bVar = b.this;
            bVar.f65051c = new g(bVar.f65056h);
            if (b.this.f65055g != null) {
                b.this.f65055g.a(b.this.f65051c.a());
                z = b.this.f65055g.a();
            } else {
                z = false;
            }
            if (z && b.this.k()) {
                b.this.m();
                b.this.o();
            }
            b.this.f65049a = null;
        }
    }

    /* renamed from: d.b.p.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1763b {

        /* renamed from: a  reason: collision with root package name */
        public static C1763b f65058a;

        public C1763b(Context context) {
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

        public static C1763b c(Context context) {
            if (f65058a == null) {
                synchronized (b.class) {
                    if (f65058a == null) {
                        f65058a = new C1763b(context);
                    }
                }
            }
            return f65058a;
        }

        public final void a() {
            b.i.f65053e = new HashMap();
            b.i.f65053e.put(BOSTokenRequest.CHARSET, "utf-8");
            b.i.f65053e.put("Content-type", "application/json");
            b.i.f65052d = new d.b.p.f.a.r.a();
        }

        public b b() {
            if (b.i.f65052d == null) {
                a();
            }
            return b.i;
        }
    }

    public b(Context context) {
        this.f65050b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f65056h = context;
        this.f65055g = new o(context);
    }

    public /* synthetic */ b(Context context, d.b.p.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        HashMap<String, String> hashMap = this.f65054f;
        return hashMap == null ? str : q.b(str, hashMap);
    }

    public final Runnable h() {
        return new a();
    }

    public final boolean k() {
        d.b.p.f.a.k.c a2;
        String e2 = e("https://mbd.baidu.com/store");
        d.b.p.f.a.k.b bVar = this.f65052d;
        JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f65053e, this.f65051c.a()));
        return a3 != null && a3.optInt("errno", -1) == 0;
    }

    public final void m() {
        j jVar = this.f65055g;
        if (jVar != null) {
            jVar.b(this.f65051c.a());
        }
    }

    public final void o() {
        AtomicInteger atomicInteger = this.f65050b;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public void t() {
        synchronized (b.class) {
            if (this.f65050b.get() == 0) {
                if (this.f65056h == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f65050b.set(1);
                if (this.f65049a == null) {
                    this.f65049a = new Thread(h());
                }
                this.f65049a.start();
            }
        }
    }
}
