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
    public a.C1785a f64407d;

    /* renamed from: e  reason: collision with root package name */
    public e f64408e;

    /* renamed from: f  reason: collision with root package name */
    public d f64409f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f64410g;

    /* renamed from: d.a.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1789a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f64411a;

        /* renamed from: d.a.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1790a implements Runnable {
            public RunnableC1790a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1789a.this.f64411a.f64432c.get()) {
                    return;
                }
                a.this.f64408e.d(64L, 124L);
                a.this.f64408e.m();
                a.this.i();
                HandlerC1789a.this.f64411a.f64432c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1789a(Looper looper, d dVar) {
            super(looper);
            this.f64411a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f64375b.f64382d.submit(new RunnableC1790a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f64414e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f64415f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f64416g;

        /* renamed from: d.a.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1791a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f64418a;

            /* renamed from: d.a.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1792a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f64420e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f64421f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f64422g;

                public RunnableC1792a(long j, boolean z, String str) {
                    this.f64420e = j;
                    this.f64421f = z;
                    this.f64422g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f64408e.i(this.f64420e - C1791a.this.f64418a);
                    a.this.f64408e.d(this.f64421f ? 1L : 2L, 3L);
                    a.this.f64408e.d(16L, 124L);
                    a.this.f64408e.h(this.f64422g);
                    if (!TextUtils.isEmpty(this.f64422g)) {
                        try {
                            String b2 = d.a.q.h.a.b("A10", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f64422g.getBytes("UTF-8")));
                            a.this.f64408e.e(b2);
                            a.this.f64408e.l(b2);
                            a.this.f64408e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f64408e.m();
                    if (b.this.f64416g.f64432c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f64416g.f64432c.set(true);
                }
            }

            public C1791a(long j) {
                this.f64418a = j;
            }

            @Override // d.a.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f64414e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f64416g.f64431b = a.this.f64375b.f64382d.submit(new RunnableC1792a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.a.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1793b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f64424e;

            public RunnableC1793b(int i2) {
                this.f64424e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f64424e;
                if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                    if (!b.this.f64416g.f64432c.get()) {
                        b.this.f64416g.f64432c.set(true);
                        a.this.i();
                    }
                    b.this.f64414e.removeMessages(0);
                }
                a.this.f64408e.c(this.f64424e);
                a.this.f64408e.d(8L, 124L);
                a.this.f64408e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f64426e;

            public c(Throwable th) {
                this.f64426e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f64414e.removeMessages(0);
                a.this.f64408e.j(Log.getStackTraceString(this.f64426e));
                a.this.f64408e.m();
                if (b.this.f64416g.f64432c.get()) {
                    return;
                }
                b.this.f64416g.f64432c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f64414e = handler;
            this.f64415f = context;
            this.f64416g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64414e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f64415f, new C1791a(SystemClock.elapsedRealtime()));
                this.f64416g.f64430a = a.this.f64375b.f64382d.submit(new RunnableC1793b(InitSdk));
            } catch (Throwable th) {
                a.this.f64375b.f64382d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f64428e;

        public c(a.d dVar) {
            this.f64428e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64409f.f64432c.get()) {
                a.this.j(this.f64428e);
            } else {
                a.this.f64410g.add(this.f64428e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f64430a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f64431b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f64432c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f64433a;

        /* renamed from: d  reason: collision with root package name */
        public String f64436d;

        /* renamed from: e  reason: collision with root package name */
        public int f64437e;

        /* renamed from: g  reason: collision with root package name */
        public long f64439g;

        /* renamed from: h  reason: collision with root package name */
        public String f64440h;

        /* renamed from: i  reason: collision with root package name */
        public String f64441i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64434b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f64435c = new d.a.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f64438f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f64436d;
        }

        public void c(int i2) {
            if (this.f64437e != i2) {
                this.f64437e = i2;
                this.f64434b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f64435c.c(j, j2)) {
                this.f64434b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64436d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64436d = str;
                this.f64434b = true;
            }
        }

        public long f() {
            return this.f64433a;
        }

        public void g(long j) {
            if (this.f64433a != j) {
                this.f64433a = j;
                this.f64434b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f64440h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64440h = str;
                this.f64434b = true;
            }
        }

        public void i(long j) {
            if (this.f64439g != j) {
                this.f64439g = j;
                this.f64434b = true;
            }
        }

        public void j(String str) {
            if (this.f64441i == str) {
                return;
            }
            if (str == null || !str.equals(this.f64440h)) {
                this.f64441i = str;
                this.f64434b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f64407d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f64436d = jSONObject.optString("form_id");
                    this.f64433a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f64435c.b(jSONObject.getLong("flags"));
                    this.f64437e = jSONObject.optInt("init_res");
                    this.f64439g = jSONObject.optLong("acquire_ts_cost");
                    this.f64440h = jSONObject.optString("oid");
                    this.f64438f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f64438f.clear();
                                return false;
                            }
                            this.f64438f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f64438f.contains(str)) {
                return;
            }
            this.f64438f.add(str);
            this.f64434b = true;
        }

        public boolean m() {
            if (this.f64434b) {
                try {
                    a.this.f64407d.i("cache.dat", n().toString(), true);
                    this.f64434b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f64436d);
                jSONObject.put("lst_fe_ts", this.f64433a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f64435c.d());
                jSONObject.put("init_res", this.f64437e);
                jSONObject.put("acquire_ts_cost", this.f64439g);
                jSONObject.put("oid", this.f64440h);
                int size = this.f64438f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i2 = 0; i2 < min; i2++) {
                        jSONObject2.put("id_" + i2, this.f64438f.get((size - min) + i2));
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
        this.f64408e = new e();
        this.f64410g = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f64408e.b();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f64407d = this.f64374a.f(e());
        Context context = this.f64375b.f64379a;
        d dVar = new d(this);
        this.f64409f = dVar;
        this.f64408e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f64384a && Math.abs(currentTimeMillis - this.f64408e.f()) <= 604800000) {
            dVar.f64432c.set(true);
            return;
        }
        this.f64408e.g(currentTimeMillis);
        this.f64408e.d(4L, 124L);
        this.f64408e.i(0L);
        this.f64408e.m();
        this.f64375b.f64383e.submit(new b(new HandlerC1789a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f64375b.f64382d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f64410g) {
            j(dVar);
        }
        this.f64410g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f64408e.b())) {
            dVar.b(this.f64408e.f64437e, null, bundle);
        } else {
            dVar.a(this.f64408e.b(), bundle);
        }
    }
}
