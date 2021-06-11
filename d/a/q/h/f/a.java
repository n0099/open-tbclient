package d.a.q.h.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.MdidSdk;
import com.bun.miitmdid.supplier.IdSupplier;
import d.a.q.g.d.a;
import d.a.q.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1846a f68001d;

    /* renamed from: e  reason: collision with root package name */
    public e f68002e;

    /* renamed from: f  reason: collision with root package name */
    public d f68003f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f68004g;

    /* renamed from: d.a.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1850a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f68005a;

        /* renamed from: d.a.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1851a implements Runnable {
            public RunnableC1851a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1850a.this.f68005a.f68026c.get()) {
                    return;
                }
                a.this.f68002e.d(64L, 124L);
                a.this.f68002e.m();
                a.this.i();
                HandlerC1850a.this.f68005a.f68026c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1850a(Looper looper, d dVar) {
            super(looper);
            this.f68005a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f67969b.f67976d.submit(new RunnableC1851a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f68008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f68009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f68010g;

        /* renamed from: d.a.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1852a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f68012a;

            /* renamed from: d.a.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1853a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f68014e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f68015f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f68016g;

                public RunnableC1853a(long j, boolean z, String str) {
                    this.f68014e = j;
                    this.f68015f = z;
                    this.f68016g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f68002e.i(this.f68014e - C1852a.this.f68012a);
                    a.this.f68002e.d(this.f68015f ? 1L : 2L, 3L);
                    a.this.f68002e.d(16L, 124L);
                    a.this.f68002e.h(this.f68016g);
                    if (!TextUtils.isEmpty(this.f68016g)) {
                        try {
                            String b2 = d.a.q.h.a.b("A10", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f68016g.getBytes("UTF-8")));
                            a.this.f68002e.e(b2);
                            a.this.f68002e.l(b2);
                            a.this.f68002e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f68002e.m();
                    if (b.this.f68010g.f68026c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f68010g.f68026c.set(true);
                }
            }

            public C1852a(long j) {
                this.f68012a = j;
            }

            @Override // d.a.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f68008e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f68010g.f68025b = a.this.f67969b.f67976d.submit(new RunnableC1853a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.a.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1854b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f68018e;

            public RunnableC1854b(int i2) {
                this.f68018e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f68018e;
                if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                    if (!b.this.f68010g.f68026c.get()) {
                        b.this.f68010g.f68026c.set(true);
                        a.this.i();
                    }
                    b.this.f68008e.removeMessages(0);
                }
                a.this.f68002e.c(this.f68018e);
                a.this.f68002e.d(8L, 124L);
                a.this.f68002e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f68020e;

            public c(Throwable th) {
                this.f68020e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f68008e.removeMessages(0);
                a.this.f68002e.j(Log.getStackTraceString(this.f68020e));
                a.this.f68002e.m();
                if (b.this.f68010g.f68026c.get()) {
                    return;
                }
                b.this.f68010g.f68026c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f68008e = handler;
            this.f68009f = context;
            this.f68010g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f68008e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f68009f, new C1852a(SystemClock.elapsedRealtime()));
                this.f68010g.f68024a = a.this.f67969b.f67976d.submit(new RunnableC1854b(InitSdk));
            } catch (Throwable th) {
                a.this.f67969b.f67976d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f68022e;

        public c(a.d dVar) {
            this.f68022e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f68003f.f68026c.get()) {
                a.this.j(this.f68022e);
            } else {
                a.this.f68004g.add(this.f68022e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f68024a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f68025b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f68026c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f68027a;

        /* renamed from: d  reason: collision with root package name */
        public String f68030d;

        /* renamed from: e  reason: collision with root package name */
        public int f68031e;

        /* renamed from: g  reason: collision with root package name */
        public long f68033g;

        /* renamed from: h  reason: collision with root package name */
        public String f68034h;

        /* renamed from: i  reason: collision with root package name */
        public String f68035i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f68028b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f68029c = new d.a.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f68032f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f68030d;
        }

        public void c(int i2) {
            if (this.f68031e != i2) {
                this.f68031e = i2;
                this.f68028b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f68029c.c(j, j2)) {
                this.f68028b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f68030d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f68030d = str;
                this.f68028b = true;
            }
        }

        public long f() {
            return this.f68027a;
        }

        public void g(long j) {
            if (this.f68027a != j) {
                this.f68027a = j;
                this.f68028b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f68034h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f68034h = str;
                this.f68028b = true;
            }
        }

        public void i(long j) {
            if (this.f68033g != j) {
                this.f68033g = j;
                this.f68028b = true;
            }
        }

        public void j(String str) {
            if (this.f68035i == str) {
                return;
            }
            if (str == null || !str.equals(this.f68034h)) {
                this.f68035i = str;
                this.f68028b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f68001d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f68030d = jSONObject.optString("form_id");
                    this.f68027a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f68029c.b(jSONObject.getLong("flags"));
                    this.f68031e = jSONObject.optInt("init_res");
                    this.f68033g = jSONObject.optLong("acquire_ts_cost");
                    this.f68034h = jSONObject.optString("oid");
                    this.f68032f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f68032f.clear();
                                return false;
                            }
                            this.f68032f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f68032f.contains(str)) {
                return;
            }
            this.f68032f.add(str);
            this.f68028b = true;
        }

        public boolean m() {
            if (this.f68028b) {
                try {
                    a.this.f68001d.i("cache.dat", n().toString(), true);
                    this.f68028b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f68030d);
                jSONObject.put("lst_fe_ts", this.f68027a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f68029c.d());
                jSONObject.put("init_res", this.f68031e);
                jSONObject.put("acquire_ts_cost", this.f68033g);
                jSONObject.put("oid", this.f68034h);
                int size = this.f68032f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i2 = 0; i2 < min; i2++) {
                        jSONObject2.put("id_" + i2, this.f68032f.get((size - min) + i2));
                    }
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class f implements IIdentifierListener {
        @Override // com.bun.miitmdid.core.IIdentifierListener
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            a(z, idSupplier);
        }

        public abstract void a(boolean z, IdSupplier idSupplier);
    }

    public a() {
        super("oid");
        this.f68002e = new e();
        this.f68004g = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f68002e.b();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f68001d = this.f67968a.f(e());
        Context context = this.f67969b.f67973a;
        d dVar = new d(this);
        this.f68003f = dVar;
        this.f68002e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f67978a && Math.abs(currentTimeMillis - this.f68002e.f()) <= 604800000) {
            dVar.f68026c.set(true);
            return;
        }
        this.f68002e.g(currentTimeMillis);
        this.f68002e.d(4L, 124L);
        this.f68002e.i(0L);
        this.f68002e.m();
        this.f67969b.f67977e.submit(new b(new HandlerC1850a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f67969b.f67976d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f68004g) {
            j(dVar);
        }
        this.f68004g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f68002e.b())) {
            dVar.b(this.f68002e.f68031e, null, bundle);
        } else {
            dVar.a(this.f68002e.b(), bundle);
        }
    }
}
