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
    public a.C1788a f64283d;

    /* renamed from: e  reason: collision with root package name */
    public e f64284e;

    /* renamed from: f  reason: collision with root package name */
    public d f64285f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f64286g;

    /* renamed from: d.a.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1792a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64287a;

        /* renamed from: d.a.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1793a implements Runnable {
            public RunnableC1793a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1792a.this.f64287a.f64308c.get()) {
                    return;
                }
                a.this.f64284e.d(64L, 124L);
                a.this.f64284e.m();
                a.this.i();
                HandlerC1792a.this.f64287a.f64308c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1792a(Looper looper, d dVar) {
            super(looper);
            this.f64287a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f64251b.f64258d.submit(new RunnableC1793a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f64290e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64291f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f64292g;

        /* renamed from: d.a.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1794a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f64294a;

            /* renamed from: d.a.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1795a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f64296e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f64297f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f64298g;

                public RunnableC1795a(long j, boolean z, String str) {
                    this.f64296e = j;
                    this.f64297f = z;
                    this.f64298g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f64284e.i(this.f64296e - C1794a.this.f64294a);
                    a.this.f64284e.d(this.f64297f ? 1L : 2L, 3L);
                    a.this.f64284e.d(16L, 124L);
                    a.this.f64284e.h(this.f64298g);
                    if (!TextUtils.isEmpty(this.f64298g)) {
                        try {
                            String b2 = d.a.q.h.a.b("A10", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64298g.getBytes("UTF-8")));
                            a.this.f64284e.e(b2);
                            a.this.f64284e.l(b2);
                            a.this.f64284e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f64284e.m();
                    if (b.this.f64292g.f64308c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f64292g.f64308c.set(true);
                }
            }

            public C1794a(long j) {
                this.f64294a = j;
            }

            @Override // d.a.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f64290e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f64292g.f64307b = a.this.f64251b.f64258d.submit(new RunnableC1795a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.a.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1796b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64300e;

            public RunnableC1796b(int i2) {
                this.f64300e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f64300e;
                if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                    if (!b.this.f64292g.f64308c.get()) {
                        b.this.f64292g.f64308c.set(true);
                        a.this.i();
                    }
                    b.this.f64290e.removeMessages(0);
                }
                a.this.f64284e.c(this.f64300e);
                a.this.f64284e.d(8L, 124L);
                a.this.f64284e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f64302e;

            public c(Throwable th) {
                this.f64302e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64290e.removeMessages(0);
                a.this.f64284e.j(Log.getStackTraceString(this.f64302e));
                a.this.f64284e.m();
                if (b.this.f64292g.f64308c.get()) {
                    return;
                }
                b.this.f64292g.f64308c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f64290e = handler;
            this.f64291f = context;
            this.f64292g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64290e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f64291f, new C1794a(SystemClock.elapsedRealtime()));
                this.f64292g.f64306a = a.this.f64251b.f64258d.submit(new RunnableC1796b(InitSdk));
            } catch (Throwable th) {
                a.this.f64251b.f64258d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f64304e;

        public c(a.d dVar) {
            this.f64304e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64285f.f64308c.get()) {
                a.this.j(this.f64304e);
            } else {
                a.this.f64286g.add(this.f64304e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f64306a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f64307b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f64308c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f64309a;

        /* renamed from: d  reason: collision with root package name */
        public String f64312d;

        /* renamed from: e  reason: collision with root package name */
        public int f64313e;

        /* renamed from: g  reason: collision with root package name */
        public long f64315g;

        /* renamed from: h  reason: collision with root package name */
        public String f64316h;

        /* renamed from: i  reason: collision with root package name */
        public String f64317i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64310b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f64311c = new d.a.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f64314f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f64312d;
        }

        public void c(int i2) {
            if (this.f64313e != i2) {
                this.f64313e = i2;
                this.f64310b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f64311c.c(j, j2)) {
                this.f64310b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64312d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64312d = str;
                this.f64310b = true;
            }
        }

        public long f() {
            return this.f64309a;
        }

        public void g(long j) {
            if (this.f64309a != j) {
                this.f64309a = j;
                this.f64310b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f64316h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64316h = str;
                this.f64310b = true;
            }
        }

        public void i(long j) {
            if (this.f64315g != j) {
                this.f64315g = j;
                this.f64310b = true;
            }
        }

        public void j(String str) {
            if (this.f64317i == str) {
                return;
            }
            if (str == null || !str.equals(this.f64316h)) {
                this.f64317i = str;
                this.f64310b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f64283d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f64312d = jSONObject.optString("form_id");
                    this.f64309a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f64311c.b(jSONObject.getLong("flags"));
                    this.f64313e = jSONObject.optInt("init_res");
                    this.f64315g = jSONObject.optLong("acquire_ts_cost");
                    this.f64316h = jSONObject.optString("oid");
                    this.f64314f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f64314f.clear();
                                return false;
                            }
                            this.f64314f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f64314f.contains(str)) {
                return;
            }
            this.f64314f.add(str);
            this.f64310b = true;
        }

        public boolean m() {
            if (this.f64310b) {
                try {
                    a.this.f64283d.i("cache.dat", n().toString(), true);
                    this.f64310b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f64312d);
                jSONObject.put("lst_fe_ts", this.f64309a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f64311c.d());
                jSONObject.put("init_res", this.f64313e);
                jSONObject.put("acquire_ts_cost", this.f64315g);
                jSONObject.put("oid", this.f64316h);
                int size = this.f64314f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i2 = 0; i2 < min; i2++) {
                        jSONObject2.put("id_" + i2, this.f64314f.get((size - min) + i2));
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
        this.f64284e = new e();
        this.f64286g = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f64284e.b();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f64283d = this.f64250a.f(e());
        Context context = this.f64251b.f64255a;
        d dVar = new d(this);
        this.f64285f = dVar;
        this.f64284e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f64260a && Math.abs(currentTimeMillis - this.f64284e.f()) <= 604800000) {
            dVar.f64308c.set(true);
            return;
        }
        this.f64284e.g(currentTimeMillis);
        this.f64284e.d(4L, 124L);
        this.f64284e.i(0L);
        this.f64284e.m();
        this.f64251b.f64259e.submit(new b(new HandlerC1792a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f64251b.f64258d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f64286g) {
            j(dVar);
        }
        this.f64286g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f64284e.b())) {
            dVar.b(this.f64284e.f64313e, null, bundle);
        } else {
            dVar.a(this.f64284e.b(), bundle);
        }
    }
}
