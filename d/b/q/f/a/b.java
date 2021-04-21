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
    public Thread f65313a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f65314b;

    /* renamed from: c  reason: collision with root package name */
    public c f65315c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.q.f.a.k.b f65316d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f65317e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f65318f;

    /* renamed from: g  reason: collision with root package name */
    public j f65319g;

    /* renamed from: h  reason: collision with root package name */
    public Context f65320h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            b bVar = b.this;
            bVar.f65315c = new g(bVar.f65320h);
            if (b.this.f65319g != null) {
                b.this.f65319g.a(b.this.f65315c.a());
                z = b.this.f65319g.a();
            } else {
                z = false;
            }
            if (z && b.this.k()) {
                b.this.m();
                b.this.o();
            }
            b.this.f65313a = null;
        }
    }

    /* renamed from: d.b.q.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1782b {

        /* renamed from: a  reason: collision with root package name */
        public static C1782b f65322a;

        public C1782b(Context context) {
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

        public static C1782b c(Context context) {
            if (f65322a == null) {
                synchronized (b.class) {
                    if (f65322a == null) {
                        f65322a = new C1782b(context);
                    }
                }
            }
            return f65322a;
        }

        public final void a() {
            b.i.f65317e = new HashMap();
            b.i.f65317e.put(BOSTokenRequest.CHARSET, "utf-8");
            b.i.f65317e.put("Content-type", "application/json");
            b.i.f65316d = new d.b.q.f.a.r.a();
        }

        public b b() {
            if (b.i.f65316d == null) {
                a();
            }
            return b.i;
        }
    }

    public b(Context context) {
        this.f65314b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f65320h = context;
        this.f65319g = new o(context);
    }

    public /* synthetic */ b(Context context, d.b.q.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        HashMap<String, String> hashMap = this.f65318f;
        return hashMap == null ? str : q.b(str, hashMap);
    }

    public final Runnable h() {
        return new a();
    }

    public final boolean k() {
        d.b.q.f.a.k.c a2;
        String e2 = e("https://mbd.baidu.com/store");
        d.b.q.f.a.k.b bVar = this.f65316d;
        JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f65317e, this.f65315c.a()));
        return a3 != null && a3.optInt("errno", -1) == 0;
    }

    public final void m() {
        j jVar = this.f65319g;
        if (jVar != null) {
            jVar.b(this.f65315c.a());
        }
    }

    public final void o() {
        AtomicInteger atomicInteger = this.f65314b;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public void t() {
        synchronized (b.class) {
            if (this.f65314b.get() == 0) {
                if (this.f65320h == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f65314b.set(1);
                if (this.f65313a == null) {
                    this.f65313a = new Thread(h());
                }
                this.f65313a.start();
            }
        }
    }
}
