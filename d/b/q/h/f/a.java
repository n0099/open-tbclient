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
    public a.C1784a f65450d;

    /* renamed from: e  reason: collision with root package name */
    public e f65451e;

    /* renamed from: f  reason: collision with root package name */
    public d f65452f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f65453g;

    /* renamed from: d.b.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1788a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65454a;

        /* renamed from: d.b.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1789a implements Runnable {
            public RunnableC1789a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1788a.this.f65454a.f65475c.get()) {
                    return;
                }
                a.this.f65451e.d(64L, 124L);
                a.this.f65451e.m();
                a.this.i();
                HandlerC1788a.this.f65454a.f65475c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1788a(Looper looper, d dVar) {
            super(looper);
            this.f65454a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f65419b.f65426d.submit(new RunnableC1789a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f65457e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f65458f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f65459g;

        /* renamed from: d.b.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1790a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f65461a;

            /* renamed from: d.b.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1791a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f65463e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f65464f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f65465g;

                public RunnableC1791a(long j, boolean z, String str) {
                    this.f65463e = j;
                    this.f65464f = z;
                    this.f65465g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f65451e.i(this.f65463e - C1790a.this.f65461a);
                    a.this.f65451e.d(this.f65464f ? 1L : 2L, 3L);
                    a.this.f65451e.d(16L, 124L);
                    a.this.f65451e.h(this.f65465g);
                    if (!TextUtils.isEmpty(this.f65465g)) {
                        try {
                            String b2 = d.b.q.h.a.b("A10", new d.b.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f65465g.getBytes("UTF-8")));
                            a.this.f65451e.e(b2);
                            a.this.f65451e.l(b2);
                            a.this.f65451e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f65451e.m();
                    if (b.this.f65459g.f65475c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f65459g.f65475c.set(true);
                }
            }

            public C1790a(long j) {
                this.f65461a = j;
            }

            @Override // d.b.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f65457e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f65459g.f65474b = a.this.f65419b.f65426d.submit(new RunnableC1791a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.b.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1792b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f65467e;

            public RunnableC1792b(int i) {
                this.f65467e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.f65467e;
                if (i == 1008612 || i == 1008611 || i == 1008615) {
                    if (!b.this.f65459g.f65475c.get()) {
                        b.this.f65459g.f65475c.set(true);
                        a.this.i();
                    }
                    b.this.f65457e.removeMessages(0);
                }
                a.this.f65451e.c(this.f65467e);
                a.this.f65451e.d(8L, 124L);
                a.this.f65451e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f65469e;

            public c(Throwable th) {
                this.f65469e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f65457e.removeMessages(0);
                a.this.f65451e.j(Log.getStackTraceString(this.f65469e));
                a.this.f65451e.m();
                if (b.this.f65459g.f65475c.get()) {
                    return;
                }
                b.this.f65459g.f65475c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f65457e = handler;
            this.f65458f = context;
            this.f65459g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65457e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f65458f, new C1790a(SystemClock.elapsedRealtime()));
                this.f65459g.f65473a = a.this.f65419b.f65426d.submit(new RunnableC1792b(InitSdk));
            } catch (Throwable th) {
                a.this.f65419b.f65426d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f65471e;

        public c(a.d dVar) {
            this.f65471e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f65452f.f65475c.get()) {
                a.this.j(this.f65471e);
            } else {
                a.this.f65453g.add(this.f65471e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f65473a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f65474b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f65475c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f65476a;

        /* renamed from: d  reason: collision with root package name */
        public String f65479d;

        /* renamed from: e  reason: collision with root package name */
        public int f65480e;

        /* renamed from: g  reason: collision with root package name */
        public long f65482g;

        /* renamed from: h  reason: collision with root package name */
        public String f65483h;
        public String i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65477b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.b.q.g.c.a.e f65478c = new d.b.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f65481f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f65479d;
        }

        public void c(int i) {
            if (this.f65480e != i) {
                this.f65480e = i;
                this.f65477b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f65478c.c(j, j2)) {
                this.f65477b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f65479d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65479d = str;
                this.f65477b = true;
            }
        }

        public long f() {
            return this.f65476a;
        }

        public void g(long j) {
            if (this.f65476a != j) {
                this.f65476a = j;
                this.f65477b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f65483h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65483h = str;
                this.f65477b = true;
            }
        }

        public void i(long j) {
            if (this.f65482g != j) {
                this.f65482g = j;
                this.f65477b = true;
            }
        }

        public void j(String str) {
            if (this.i == str) {
                return;
            }
            if (str == null || !str.equals(this.f65483h)) {
                this.i = str;
                this.f65477b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f65450d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f65479d = jSONObject.optString("form_id");
                    this.f65476a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f65478c.b(jSONObject.getLong("flags"));
                    this.f65480e = jSONObject.optInt("init_res");
                    this.f65482g = jSONObject.optLong("acquire_ts_cost");
                    this.f65483h = jSONObject.optString("oid");
                    this.f65481f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i = optJSONObject.getInt("count");
                        for (int i2 = 0; i2 < i; i2++) {
                            String string = optJSONObject.getString("id_" + i2);
                            if (TextUtils.isEmpty(string)) {
                                this.f65481f.clear();
                                return false;
                            }
                            this.f65481f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f65481f.contains(str)) {
                return;
            }
            this.f65481f.add(str);
            this.f65477b = true;
        }

        public boolean m() {
            if (this.f65477b) {
                try {
                    a.this.f65450d.i("cache.dat", n().toString(), true);
                    this.f65477b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f65479d);
                jSONObject.put("lst_fe_ts", this.f65476a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f65478c.d());
                jSONObject.put("init_res", this.f65480e);
                jSONObject.put("acquire_ts_cost", this.f65482g);
                jSONObject.put("oid", this.f65483h);
                int size = this.f65481f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i = 0; i < min; i++) {
                        jSONObject2.put("id_" + i, this.f65481f.get((size - min) + i));
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
        this.f65451e = new e();
        this.f65453g = new ArrayList();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f65451e.b();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f65450d = this.f65418a.f(e());
        Context context = this.f65419b.f65423a;
        d dVar = new d(this);
        this.f65452f = dVar;
        this.f65451e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f65428a && Math.abs(currentTimeMillis - this.f65451e.f()) <= 604800000) {
            dVar.f65475c.set(true);
            return;
        }
        this.f65451e.g(currentTimeMillis);
        this.f65451e.d(4L, 124L);
        this.f65451e.i(0L);
        this.f65451e.m();
        this.f65419b.f65427e.submit(new b(new HandlerC1788a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.b.q.h.a
    public void g(a.d<String> dVar) {
        this.f65419b.f65426d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f65453g) {
            j(dVar);
        }
        this.f65453g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f65451e.b())) {
            dVar.b(this.f65451e.f65480e, null, bundle);
        } else {
            dVar.a(this.f65451e.b(), bundle);
        }
    }
}
