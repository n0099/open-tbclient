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
    public static b f63630i;

    /* renamed from: a  reason: collision with root package name */
    public Thread f63631a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f63632b;

    /* renamed from: c  reason: collision with root package name */
    public c f63633c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q.f.a.k.b f63634d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f63635e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f63636f;

    /* renamed from: g  reason: collision with root package name */
    public j f63637g;

    /* renamed from: h  reason: collision with root package name */
    public Context f63638h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            b bVar = b.this;
            bVar.f63633c = new g(bVar.f63638h);
            if (b.this.f63637g != null) {
                b.this.f63637g.a(b.this.f63633c.a());
                z = b.this.f63637g.a();
            } else {
                z = false;
            }
            if (z && b.this.k()) {
                b.this.m();
                b.this.o();
            }
            b.this.f63631a = null;
        }
    }

    /* renamed from: d.a.q.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1720b {

        /* renamed from: a  reason: collision with root package name */
        public static C1720b f63640a;

        public C1720b(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (b.f63630i == null) {
                synchronized (b.class) {
                    if (b.f63630i == null) {
                        b unused = b.f63630i = new b(context.getApplicationContext(), null);
                    }
                }
            }
        }

        public static C1720b c(Context context) {
            if (f63640a == null) {
                synchronized (b.class) {
                    if (f63640a == null) {
                        f63640a = new C1720b(context);
                    }
                }
            }
            return f63640a;
        }

        public final void a() {
            b.f63630i.f63635e = new HashMap();
            b.f63630i.f63635e.put(BOSTokenRequest.CHARSET, "utf-8");
            b.f63630i.f63635e.put("Content-type", "application/json");
            b.f63630i.f63634d = new d.a.q.f.a.r.a();
        }

        public b b() {
            if (b.f63630i.f63634d == null) {
                a();
            }
            return b.f63630i;
        }
    }

    public b(Context context) {
        this.f63632b = new AtomicInteger(0);
        new AtomicBoolean(false);
        this.f63638h = context;
        this.f63637g = new o(context);
    }

    public /* synthetic */ b(Context context, d.a.q.f.a.a aVar) {
        this(context);
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        HashMap<String, String> hashMap = this.f63636f;
        return hashMap == null ? str : q.b(str, hashMap);
    }

    public final Runnable h() {
        return new a();
    }

    public final boolean k() {
        d.a.q.f.a.k.c a2;
        String e2 = e("https://mbd.baidu.com/store");
        d.a.q.f.a.k.b bVar = this.f63634d;
        JSONObject a3 = n.a((bVar == null || (a2 = bVar.a()) == null) ? null : a2.a(e2, "POST", this.f63635e, this.f63633c.a()));
        return a3 != null && a3.optInt("errno", -1) == 0;
    }

    public final void m() {
        j jVar = this.f63637g;
        if (jVar != null) {
            jVar.b(this.f63633c.a());
        }
    }

    public final void o() {
        AtomicInteger atomicInteger = this.f63632b;
        if (atomicInteger != null) {
            atomicInteger.set(2);
        }
    }

    public void t() {
        synchronized (b.class) {
            if (this.f63632b.get() == 0) {
                if (this.f63638h == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f63632b.set(1);
                if (this.f63631a == null) {
                    this.f63631a = new Thread(h());
                }
                this.f63631a.start();
            }
        }
    }
}
