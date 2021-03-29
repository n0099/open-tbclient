package d.b.q.h.f;

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
import d.b.q.g.d.a;
import d.b.q.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1753a f64492d;

    /* renamed from: e  reason: collision with root package name */
    public e f64493e;

    /* renamed from: f  reason: collision with root package name */
    public d f64494f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f64495g;

    /* renamed from: d.b.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1757a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64496a;

        /* renamed from: d.b.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1758a implements Runnable {
            public RunnableC1758a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1757a.this.f64496a.f64517c.get()) {
                    return;
                }
                a.this.f64493e.d(64L, 124L);
                a.this.f64493e.m();
                a.this.i();
                HandlerC1757a.this.f64496a.f64517c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1757a(Looper looper, d dVar) {
            super(looper);
            this.f64496a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f64461b.f64468d.submit(new RunnableC1758a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f64499e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64500f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f64501g;

        /* renamed from: d.b.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1759a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f64503a;

            /* renamed from: d.b.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1760a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f64505e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f64506f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f64507g;

                public RunnableC1760a(long j, boolean z, String str) {
                    this.f64505e = j;
                    this.f64506f = z;
                    this.f64507g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f64493e.i(this.f64505e - C1759a.this.f64503a);
                    a.this.f64493e.d(this.f64506f ? 1L : 2L, 3L);
                    a.this.f64493e.d(16L, 124L);
                    a.this.f64493e.h(this.f64507g);
                    if (!TextUtils.isEmpty(this.f64507g)) {
                        try {
                            String b2 = d.b.q.h.a.b("A10", new d.b.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64507g.getBytes("UTF-8")));
                            a.this.f64493e.e(b2);
                            a.this.f64493e.l(b2);
                            a.this.f64493e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f64493e.m();
                    if (b.this.f64501g.f64517c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f64501g.f64517c.set(true);
                }
            }

            public C1759a(long j) {
                this.f64503a = j;
            }

            @Override // d.b.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f64499e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f64501g.f64516b = a.this.f64461b.f64468d.submit(new RunnableC1760a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.b.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1761b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64509e;

            public RunnableC1761b(int i) {
                this.f64509e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.f64509e;
                if (i == 1008612 || i == 1008611 || i == 1008615) {
                    if (!b.this.f64501g.f64517c.get()) {
                        b.this.f64501g.f64517c.set(true);
                        a.this.i();
                    }
                    b.this.f64499e.removeMessages(0);
                }
                a.this.f64493e.c(this.f64509e);
                a.this.f64493e.d(8L, 124L);
                a.this.f64493e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f64511e;

            public c(Throwable th) {
                this.f64511e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64499e.removeMessages(0);
                a.this.f64493e.j(Log.getStackTraceString(this.f64511e));
                a.this.f64493e.m();
                if (b.this.f64501g.f64517c.get()) {
                    return;
                }
                b.this.f64501g.f64517c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f64499e = handler;
            this.f64500f = context;
            this.f64501g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64499e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f64500f, new C1759a(SystemClock.elapsedRealtime()));
                this.f64501g.f64515a = a.this.f64461b.f64468d.submit(new RunnableC1761b(InitSdk));
            } catch (Throwable th) {
                a.this.f64461b.f64468d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f64513e;

        public c(a.d dVar) {
            this.f64513e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64494f.f64517c.get()) {
                a.this.j(this.f64513e);
            } else {
                a.this.f64495g.add(this.f64513e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f64515a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f64516b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f64517c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f64518a;

        /* renamed from: d  reason: collision with root package name */
        public String f64521d;

        /* renamed from: e  reason: collision with root package name */
        public int f64522e;

        /* renamed from: g  reason: collision with root package name */
        public long f64524g;

        /* renamed from: h  reason: collision with root package name */
        public String f64525h;
        public String i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64519b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.b.q.g.c.a.e f64520c = new d.b.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f64523f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f64521d;
        }

        public void c(int i) {
            if (this.f64522e != i) {
                this.f64522e = i;
                this.f64519b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f64520c.c(j, j2)) {
                this.f64519b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64521d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64521d = str;
                this.f64519b = true;
            }
        }

        public long f() {
            return this.f64518a;
        }

        public void g(long j) {
            if (this.f64518a != j) {
                this.f64518a = j;
                this.f64519b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f64525h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64525h = str;
                this.f64519b = true;
            }
        }

        public void i(long j) {
            if (this.f64524g != j) {
                this.f64524g = j;
                this.f64519b = true;
            }
        }

        public void j(String str) {
            if (this.i == str) {
                return;
            }
            if (str == null || !str.equals(this.f64525h)) {
                this.i = str;
                this.f64519b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f64492d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f64521d = jSONObject.optString("form_id");
                    this.f64518a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f64520c.b(jSONObject.getLong("flags"));
                    this.f64522e = jSONObject.optInt("init_res");
                    this.f64524g = jSONObject.optLong("acquire_ts_cost");
                    this.f64525h = jSONObject.optString("oid");
                    this.f64523f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i = optJSONObject.getInt("count");
                        for (int i2 = 0; i2 < i; i2++) {
                            String string = optJSONObject.getString("id_" + i2);
                            if (TextUtils.isEmpty(string)) {
                                this.f64523f.clear();
                                return false;
                            }
                            this.f64523f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f64523f.contains(str)) {
                return;
            }
            this.f64523f.add(str);
            this.f64519b = true;
        }

        public boolean m() {
            if (this.f64519b) {
                try {
                    a.this.f64492d.i("cache.dat", n().toString(), true);
                    this.f64519b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f64521d);
                jSONObject.put("lst_fe_ts", this.f64518a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f64520c.d());
                jSONObject.put("init_res", this.f64522e);
                jSONObject.put("acquire_ts_cost", this.f64524g);
                jSONObject.put("oid", this.f64525h);
                int size = this.f64523f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i = 0; i < min; i++) {
                        jSONObject2.put("id_" + i, this.f64523f.get((size - min) + i));
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
        this.f64493e = new e();
        this.f64495g = new ArrayList();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f64493e.b();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f64492d = this.f64460a.f(e());
        Context context = this.f64461b.f64465a;
        d dVar = new d(this);
        this.f64494f = dVar;
        this.f64493e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f64470a && Math.abs(currentTimeMillis - this.f64493e.f()) <= 604800000) {
            dVar.f64517c.set(true);
            return;
        }
        this.f64493e.g(currentTimeMillis);
        this.f64493e.d(4L, 124L);
        this.f64493e.i(0L);
        this.f64493e.m();
        this.f64461b.f64469e.submit(new b(new HandlerC1757a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.b.q.h.a
    public void g(a.d<String> dVar) {
        this.f64461b.f64468d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f64495g) {
            j(dVar);
        }
        this.f64495g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f64493e.b())) {
            dVar.b(this.f64493e.f64522e, null, bundle);
        } else {
            dVar.a(this.f64493e.b(), bundle);
        }
    }
}
