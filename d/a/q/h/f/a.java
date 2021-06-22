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
    public a.C1848a f67957d;

    /* renamed from: e  reason: collision with root package name */
    public e f67958e;

    /* renamed from: f  reason: collision with root package name */
    public d f67959f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f67960g;

    /* renamed from: d.a.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1852a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f67961a;

        /* renamed from: d.a.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1853a implements Runnable {
            public RunnableC1853a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1852a.this.f67961a.f67982c.get()) {
                    return;
                }
                a.this.f67958e.d(64L, 124L);
                a.this.f67958e.m();
                a.this.i();
                HandlerC1852a.this.f67961a.f67982c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1852a(Looper looper, d dVar) {
            super(looper);
            this.f67961a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f67925b.f67932d.submit(new RunnableC1853a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f67964e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f67965f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f67966g;

        /* renamed from: d.a.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1854a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f67968a;

            /* renamed from: d.a.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1855a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f67970e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f67971f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f67972g;

                public RunnableC1855a(long j, boolean z, String str) {
                    this.f67970e = j;
                    this.f67971f = z;
                    this.f67972g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f67958e.i(this.f67970e - C1854a.this.f67968a);
                    a.this.f67958e.d(this.f67971f ? 1L : 2L, 3L);
                    a.this.f67958e.d(16L, 124L);
                    a.this.f67958e.h(this.f67972g);
                    if (!TextUtils.isEmpty(this.f67972g)) {
                        try {
                            String b2 = d.a.q.h.a.b("A10", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f67972g.getBytes("UTF-8")));
                            a.this.f67958e.e(b2);
                            a.this.f67958e.l(b2);
                            a.this.f67958e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f67958e.m();
                    if (b.this.f67966g.f67982c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f67966g.f67982c.set(true);
                }
            }

            public C1854a(long j) {
                this.f67968a = j;
            }

            @Override // d.a.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f67964e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f67966g.f67981b = a.this.f67925b.f67932d.submit(new RunnableC1855a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.a.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1856b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f67974e;

            public RunnableC1856b(int i2) {
                this.f67974e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f67974e;
                if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                    if (!b.this.f67966g.f67982c.get()) {
                        b.this.f67966g.f67982c.set(true);
                        a.this.i();
                    }
                    b.this.f67964e.removeMessages(0);
                }
                a.this.f67958e.c(this.f67974e);
                a.this.f67958e.d(8L, 124L);
                a.this.f67958e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f67976e;

            public c(Throwable th) {
                this.f67976e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f67964e.removeMessages(0);
                a.this.f67958e.j(Log.getStackTraceString(this.f67976e));
                a.this.f67958e.m();
                if (b.this.f67966g.f67982c.get()) {
                    return;
                }
                b.this.f67966g.f67982c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f67964e = handler;
            this.f67965f = context;
            this.f67966g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f67964e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f67965f, new C1854a(SystemClock.elapsedRealtime()));
                this.f67966g.f67980a = a.this.f67925b.f67932d.submit(new RunnableC1856b(InitSdk));
            } catch (Throwable th) {
                a.this.f67925b.f67932d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f67978e;

        public c(a.d dVar) {
            this.f67978e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f67959f.f67982c.get()) {
                a.this.j(this.f67978e);
            } else {
                a.this.f67960g.add(this.f67978e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f67980a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f67981b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f67982c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f67983a;

        /* renamed from: d  reason: collision with root package name */
        public String f67986d;

        /* renamed from: e  reason: collision with root package name */
        public int f67987e;

        /* renamed from: g  reason: collision with root package name */
        public long f67989g;

        /* renamed from: h  reason: collision with root package name */
        public String f67990h;

        /* renamed from: i  reason: collision with root package name */
        public String f67991i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67984b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f67985c = new d.a.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f67988f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f67986d;
        }

        public void c(int i2) {
            if (this.f67987e != i2) {
                this.f67987e = i2;
                this.f67984b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f67985c.c(j, j2)) {
                this.f67984b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f67986d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67986d = str;
                this.f67984b = true;
            }
        }

        public long f() {
            return this.f67983a;
        }

        public void g(long j) {
            if (this.f67983a != j) {
                this.f67983a = j;
                this.f67984b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f67990h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67990h = str;
                this.f67984b = true;
            }
        }

        public void i(long j) {
            if (this.f67989g != j) {
                this.f67989g = j;
                this.f67984b = true;
            }
        }

        public void j(String str) {
            if (this.f67991i == str) {
                return;
            }
            if (str == null || !str.equals(this.f67990h)) {
                this.f67991i = str;
                this.f67984b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f67957d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f67986d = jSONObject.optString("form_id");
                    this.f67983a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f67985c.b(jSONObject.getLong("flags"));
                    this.f67987e = jSONObject.optInt("init_res");
                    this.f67989g = jSONObject.optLong("acquire_ts_cost");
                    this.f67990h = jSONObject.optString("oid");
                    this.f67988f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f67988f.clear();
                                return false;
                            }
                            this.f67988f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f67988f.contains(str)) {
                return;
            }
            this.f67988f.add(str);
            this.f67984b = true;
        }

        public boolean m() {
            if (this.f67984b) {
                try {
                    a.this.f67957d.i("cache.dat", n().toString(), true);
                    this.f67984b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f67986d);
                jSONObject.put("lst_fe_ts", this.f67983a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f67985c.d());
                jSONObject.put("init_res", this.f67987e);
                jSONObject.put("acquire_ts_cost", this.f67989g);
                jSONObject.put("oid", this.f67990h);
                int size = this.f67988f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i2 = 0; i2 < min; i2++) {
                        jSONObject2.put("id_" + i2, this.f67988f.get((size - min) + i2));
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
        this.f67958e = new e();
        this.f67960g = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f67958e.b();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f67957d = this.f67924a.f(e());
        Context context = this.f67925b.f67929a;
        d dVar = new d(this);
        this.f67959f = dVar;
        this.f67958e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f67934a && Math.abs(currentTimeMillis - this.f67958e.f()) <= 604800000) {
            dVar.f67982c.set(true);
            return;
        }
        this.f67958e.g(currentTimeMillis);
        this.f67958e.d(4L, 124L);
        this.f67958e.i(0L);
        this.f67958e.m();
        this.f67925b.f67933e.submit(new b(new HandlerC1852a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f67925b.f67932d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f67960g) {
            j(dVar);
        }
        this.f67960g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f67958e.b())) {
            dVar.b(this.f67958e.f67987e, null, bundle);
        } else {
            dVar.a(this.f67958e.b(), bundle);
        }
    }
}
