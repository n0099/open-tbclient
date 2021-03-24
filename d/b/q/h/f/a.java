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
    public a.C1752a f64491d;

    /* renamed from: e  reason: collision with root package name */
    public e f64492e;

    /* renamed from: f  reason: collision with root package name */
    public d f64493f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f64494g;

    /* renamed from: d.b.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1756a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64495a;

        /* renamed from: d.b.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1757a implements Runnable {
            public RunnableC1757a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1756a.this.f64495a.f64516c.get()) {
                    return;
                }
                a.this.f64492e.d(64L, 124L);
                a.this.f64492e.m();
                a.this.i();
                HandlerC1756a.this.f64495a.f64516c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1756a(Looper looper, d dVar) {
            super(looper);
            this.f64495a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f64460b.f64467d.submit(new RunnableC1757a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f64498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64499f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f64500g;

        /* renamed from: d.b.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1758a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f64502a;

            /* renamed from: d.b.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1759a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f64504e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f64505f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f64506g;

                public RunnableC1759a(long j, boolean z, String str) {
                    this.f64504e = j;
                    this.f64505f = z;
                    this.f64506g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f64492e.i(this.f64504e - C1758a.this.f64502a);
                    a.this.f64492e.d(this.f64505f ? 1L : 2L, 3L);
                    a.this.f64492e.d(16L, 124L);
                    a.this.f64492e.h(this.f64506g);
                    if (!TextUtils.isEmpty(this.f64506g)) {
                        try {
                            String b2 = d.b.q.h.a.b("A10", new d.b.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64506g.getBytes("UTF-8")));
                            a.this.f64492e.e(b2);
                            a.this.f64492e.l(b2);
                            a.this.f64492e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f64492e.m();
                    if (b.this.f64500g.f64516c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f64500g.f64516c.set(true);
                }
            }

            public C1758a(long j) {
                this.f64502a = j;
            }

            @Override // d.b.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f64498e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f64500g.f64515b = a.this.f64460b.f64467d.submit(new RunnableC1759a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.b.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1760b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64508e;

            public RunnableC1760b(int i) {
                this.f64508e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.f64508e;
                if (i == 1008612 || i == 1008611 || i == 1008615) {
                    if (!b.this.f64500g.f64516c.get()) {
                        b.this.f64500g.f64516c.set(true);
                        a.this.i();
                    }
                    b.this.f64498e.removeMessages(0);
                }
                a.this.f64492e.c(this.f64508e);
                a.this.f64492e.d(8L, 124L);
                a.this.f64492e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f64510e;

            public c(Throwable th) {
                this.f64510e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64498e.removeMessages(0);
                a.this.f64492e.j(Log.getStackTraceString(this.f64510e));
                a.this.f64492e.m();
                if (b.this.f64500g.f64516c.get()) {
                    return;
                }
                b.this.f64500g.f64516c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f64498e = handler;
            this.f64499f = context;
            this.f64500g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64498e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f64499f, new C1758a(SystemClock.elapsedRealtime()));
                this.f64500g.f64514a = a.this.f64460b.f64467d.submit(new RunnableC1760b(InitSdk));
            } catch (Throwable th) {
                a.this.f64460b.f64467d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f64512e;

        public c(a.d dVar) {
            this.f64512e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64493f.f64516c.get()) {
                a.this.j(this.f64512e);
            } else {
                a.this.f64494g.add(this.f64512e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f64514a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f64515b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f64516c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f64517a;

        /* renamed from: d  reason: collision with root package name */
        public String f64520d;

        /* renamed from: e  reason: collision with root package name */
        public int f64521e;

        /* renamed from: g  reason: collision with root package name */
        public long f64523g;

        /* renamed from: h  reason: collision with root package name */
        public String f64524h;
        public String i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64518b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.b.q.g.c.a.e f64519c = new d.b.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f64522f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f64520d;
        }

        public void c(int i) {
            if (this.f64521e != i) {
                this.f64521e = i;
                this.f64518b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f64519c.c(j, j2)) {
                this.f64518b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64520d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64520d = str;
                this.f64518b = true;
            }
        }

        public long f() {
            return this.f64517a;
        }

        public void g(long j) {
            if (this.f64517a != j) {
                this.f64517a = j;
                this.f64518b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f64524h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64524h = str;
                this.f64518b = true;
            }
        }

        public void i(long j) {
            if (this.f64523g != j) {
                this.f64523g = j;
                this.f64518b = true;
            }
        }

        public void j(String str) {
            if (this.i == str) {
                return;
            }
            if (str == null || !str.equals(this.f64524h)) {
                this.i = str;
                this.f64518b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f64491d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f64520d = jSONObject.optString("form_id");
                    this.f64517a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f64519c.b(jSONObject.getLong("flags"));
                    this.f64521e = jSONObject.optInt("init_res");
                    this.f64523g = jSONObject.optLong("acquire_ts_cost");
                    this.f64524h = jSONObject.optString("oid");
                    this.f64522f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i = optJSONObject.getInt("count");
                        for (int i2 = 0; i2 < i; i2++) {
                            String string = optJSONObject.getString("id_" + i2);
                            if (TextUtils.isEmpty(string)) {
                                this.f64522f.clear();
                                return false;
                            }
                            this.f64522f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f64522f.contains(str)) {
                return;
            }
            this.f64522f.add(str);
            this.f64518b = true;
        }

        public boolean m() {
            if (this.f64518b) {
                try {
                    a.this.f64491d.i("cache.dat", n().toString(), true);
                    this.f64518b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f64520d);
                jSONObject.put("lst_fe_ts", this.f64517a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f64519c.d());
                jSONObject.put("init_res", this.f64521e);
                jSONObject.put("acquire_ts_cost", this.f64523g);
                jSONObject.put("oid", this.f64524h);
                int size = this.f64522f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i = 0; i < min; i++) {
                        jSONObject2.put("id_" + i, this.f64522f.get((size - min) + i));
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
        this.f64492e = new e();
        this.f64494g = new ArrayList();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f64492e.b();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f64491d = this.f64459a.f(e());
        Context context = this.f64460b.f64464a;
        d dVar = new d(this);
        this.f64493f = dVar;
        this.f64492e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f64469a && Math.abs(currentTimeMillis - this.f64492e.f()) <= 604800000) {
            dVar.f64516c.set(true);
            return;
        }
        this.f64492e.g(currentTimeMillis);
        this.f64492e.d(4L, 124L);
        this.f64492e.i(0L);
        this.f64492e.m();
        this.f64460b.f64468e.submit(new b(new HandlerC1756a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.b.q.h.a
    public void g(a.d<String> dVar) {
        this.f64460b.f64467d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f64494g) {
            j(dVar);
        }
        this.f64494g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f64492e.b())) {
            dVar.b(this.f64492e.f64521e, null, bundle);
        } else {
            dVar.a(this.f64492e.b(), bundle);
        }
    }
}
