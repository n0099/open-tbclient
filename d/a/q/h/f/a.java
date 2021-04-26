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
    public a.C1722a f63770d;

    /* renamed from: e  reason: collision with root package name */
    public e f63771e;

    /* renamed from: f  reason: collision with root package name */
    public d f63772f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f63773g;

    /* renamed from: d.a.q.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1726a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f63774a;

        /* renamed from: d.a.q.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1727a implements Runnable {
            public RunnableC1727a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1726a.this.f63774a.f63795c.get()) {
                    return;
                }
                a.this.f63771e.d(64L, 124L);
                a.this.f63771e.m();
                a.this.i();
                HandlerC1726a.this.f63774a.f63795c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1726a(Looper looper, d dVar) {
            super(looper);
            this.f63774a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f63738b.f63745d.submit(new RunnableC1727a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f63777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f63778f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f63779g;

        /* renamed from: d.a.q.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1728a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f63781a;

            /* renamed from: d.a.q.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1729a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f63783e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f63784f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f63785g;

                public RunnableC1729a(long j, boolean z, String str) {
                    this.f63783e = j;
                    this.f63784f = z;
                    this.f63785g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f63771e.i(this.f63783e - C1728a.this.f63781a);
                    a.this.f63771e.d(this.f63784f ? 1L : 2L, 3L);
                    a.this.f63771e.d(16L, 124L);
                    a.this.f63771e.h(this.f63785g);
                    if (!TextUtils.isEmpty(this.f63785g)) {
                        try {
                            String b2 = d.a.q.h.a.b("A10", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f63785g.getBytes("UTF-8")));
                            a.this.f63771e.e(b2);
                            a.this.f63771e.l(b2);
                            a.this.f63771e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f63771e.m();
                    if (b.this.f63779g.f63795c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f63779g.f63795c.set(true);
                }
            }

            public C1728a(long j) {
                this.f63781a = j;
            }

            @Override // d.a.q.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f63777e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f63779g.f63794b = a.this.f63738b.f63745d.submit(new RunnableC1729a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.a.q.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1730b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f63787e;

            public RunnableC1730b(int i2) {
                this.f63787e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f63787e;
                if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                    if (!b.this.f63779g.f63795c.get()) {
                        b.this.f63779g.f63795c.set(true);
                        a.this.i();
                    }
                    b.this.f63777e.removeMessages(0);
                }
                a.this.f63771e.c(this.f63787e);
                a.this.f63771e.d(8L, 124L);
                a.this.f63771e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f63789e;

            public c(Throwable th) {
                this.f63789e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f63777e.removeMessages(0);
                a.this.f63771e.j(Log.getStackTraceString(this.f63789e));
                a.this.f63771e.m();
                if (b.this.f63779g.f63795c.get()) {
                    return;
                }
                b.this.f63779g.f63795c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f63777e = handler;
            this.f63778f = context;
            this.f63779g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f63777e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f63778f, new C1728a(SystemClock.elapsedRealtime()));
                this.f63779g.f63793a = a.this.f63738b.f63745d.submit(new RunnableC1730b(InitSdk));
            } catch (Throwable th) {
                a.this.f63738b.f63745d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f63791e;

        public c(a.d dVar) {
            this.f63791e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f63772f.f63795c.get()) {
                a.this.j(this.f63791e);
            } else {
                a.this.f63773g.add(this.f63791e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f63793a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f63794b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f63795c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f63796a;

        /* renamed from: d  reason: collision with root package name */
        public String f63799d;

        /* renamed from: e  reason: collision with root package name */
        public int f63800e;

        /* renamed from: g  reason: collision with root package name */
        public long f63802g;

        /* renamed from: h  reason: collision with root package name */
        public String f63803h;

        /* renamed from: i  reason: collision with root package name */
        public String f63804i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63797b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.g.c.a.e f63798c = new d.a.q.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f63801f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f63799d;
        }

        public void c(int i2) {
            if (this.f63800e != i2) {
                this.f63800e = i2;
                this.f63797b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f63798c.c(j, j2)) {
                this.f63797b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f63799d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f63799d = str;
                this.f63797b = true;
            }
        }

        public long f() {
            return this.f63796a;
        }

        public void g(long j) {
            if (this.f63796a != j) {
                this.f63796a = j;
                this.f63797b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f63803h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f63803h = str;
                this.f63797b = true;
            }
        }

        public void i(long j) {
            if (this.f63802g != j) {
                this.f63802g = j;
                this.f63797b = true;
            }
        }

        public void j(String str) {
            if (this.f63804i == str) {
                return;
            }
            if (str == null || !str.equals(this.f63803h)) {
                this.f63804i = str;
                this.f63797b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f63770d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f63799d = jSONObject.optString("form_id");
                    this.f63796a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f63798c.b(jSONObject.getLong("flags"));
                    this.f63800e = jSONObject.optInt("init_res");
                    this.f63802g = jSONObject.optLong("acquire_ts_cost");
                    this.f63803h = jSONObject.optString("oid");
                    this.f63801f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i2 = optJSONObject.getInt("count");
                        for (int i3 = 0; i3 < i2; i3++) {
                            String string = optJSONObject.getString("id_" + i3);
                            if (TextUtils.isEmpty(string)) {
                                this.f63801f.clear();
                                return false;
                            }
                            this.f63801f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f63801f.contains(str)) {
                return;
            }
            this.f63801f.add(str);
            this.f63797b = true;
        }

        public boolean m() {
            if (this.f63797b) {
                try {
                    a.this.f63770d.i("cache.dat", n().toString(), true);
                    this.f63797b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f63799d);
                jSONObject.put("lst_fe_ts", this.f63796a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f63798c.d());
                jSONObject.put("init_res", this.f63800e);
                jSONObject.put("acquire_ts_cost", this.f63802g);
                jSONObject.put("oid", this.f63803h);
                int size = this.f63801f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i2 = 0; i2 < min; i2++) {
                        jSONObject2.put("id_" + i2, this.f63801f.get((size - min) + i2));
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
        this.f63771e = new e();
        this.f63773g = new ArrayList();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f63771e.b();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f63770d = this.f63737a.f(e());
        Context context = this.f63738b.f63742a;
        d dVar = new d(this);
        this.f63772f = dVar;
        this.f63771e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f63747a && Math.abs(currentTimeMillis - this.f63771e.f()) <= 604800000) {
            dVar.f63795c.set(true);
            return;
        }
        this.f63771e.g(currentTimeMillis);
        this.f63771e.d(4L, 124L);
        this.f63771e.i(0L);
        this.f63771e.m();
        this.f63738b.f63746e.submit(new b(new HandlerC1726a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.a.q.h.a
    public void g(a.d<String> dVar) {
        this.f63738b.f63745d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f63773g) {
            j(dVar);
        }
        this.f63773g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f63771e.b())) {
            dVar.b(this.f63771e.f63800e, null, bundle);
        } else {
            dVar.a(this.f63771e.b(), bundle);
        }
    }
}
