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
    public static b f67861i;

    /* renamed from: a  reason: collision with root package name */
    public Thread f67862a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f67863b;

    /* renamed from: c  reason: collision with root package name */
    public c f67864c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q.f.a.k.b f67865d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f67866e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f67867f;

    /* renamed from: g  reason: collision with root package name */
    public j f67868g;

    /* renamed from: h  reason: collision with root package name */
    public Context f67869h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            b bVar = b.this;
            bVar.f67864c = new g(bVar.f67869h);
            if (b.this.f67868g != null) {
                b.this.f67868g.a(b.this.f67864c.a());
                z = b.this.f67868g.a();
            } else {
                z = false;
            }
            if (z && b.this.k()) {
                b.this.m();
                b.this.o();
            }
            b.this.f67862a = null;
        }
    }

    /* renamed from: d.a.q.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1844b {

        /* renamed from: a  reason: collision with root package name */
        public static C1844b f67871a;

        public C1844b(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (b.f67861i == null) {
                synchronized (b.class) {
                    if (b.f67861i == null) {
                        b unused = b.f67861i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1844b c(Context context) {
            if (f67871a == null) {
                synchronized (b.class) {
                    if (f67871a == null) {
                        f67871a = new C1844b(context);
                    }
                }
            }
            return f67871a;
        }

        public final void a() {
            b.f67861i.f67866e = new HashMap();
            b.f67861i.f67866e.put(BOSTokenRequest.CHARSET, "utf-8");
            b.f67861i.f67866e.put("Content-type", "application/json");
            b.f67861i.f67865d = new d.a.q.f.a.r.a();
        }

        public b b() {
            if (b.f67861i.f67865d == null) {
                a();
            }
            return b.f67861i;
        }
    }

    public b(Context context) {
        this.f67863b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f67869h = context;
        this.f67868g = new o(context);
    }

    public /* synthetic */ b(Context context, d.a.q.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        HashMap<String, String> hashMap = this.f67867f;
        return hashMap == null ? str : q.b(str, hashMap);
    }

    public final Runnable h() {
        return new a();
    }

    public final boolean k() {
        d.a.q.f.a.k.c a2;
        String e2 = e("https://mbd.baidu.com/store");
        d.a.q.f.a.k.b bVar = this.f67865d;
        JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f67866e, this.f67864c.a()));
        return a3 != null && a3.optInt("errno", -1) == 0;
    }

    public final void m() {
        j jVar = this.f67868g;
        if (jVar != null) {
            jVar.b(this.f67864c.a());
        }
    }

    public final void o() {
        AtomicInteger atomicInteger = this.f67863b;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public void t() {
        synchronized (b.class) {
            if (this.f67863b.get() == 0) {
                if (this.f67869h == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f67863b.set(1);
                if (this.f67862a == null) {
                    this.f67862a = new Thread(h());
                }
                this.f67862a.start();
            }
        }
    }
}
