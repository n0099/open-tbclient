package d.b.p.h.f;

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
import d.b.p.g.d.a;
import d.b.p.h.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.p.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1765a f65186d;

    /* renamed from: e  reason: collision with root package name */
    public e f65187e;

    /* renamed from: f  reason: collision with root package name */
    public d f65188f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f65189g;

    /* renamed from: d.b.p.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC1769a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f65190a;

        /* renamed from: d.b.p.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1770a implements Runnable {
            public RunnableC1770a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (HandlerC1769a.this.f65190a.f65211c.get()) {
                    return;
                }
                a.this.f65187e.d(64L, 124L);
                a.this.f65187e.m();
                a.this.i();
                HandlerC1769a.this.f65190a.f65211c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1769a(Looper looper, d dVar) {
            super(looper);
            this.f65190a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.this.f65155b.f65162d.submit(new RunnableC1770a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f65193e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f65194f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f65195g;

        /* renamed from: d.b.p.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1771a extends f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f65197a;

            /* renamed from: d.b.p.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC1772a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f65199e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f65200f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f65201g;

                public RunnableC1772a(long j, boolean z, String str) {
                    this.f65199e = j;
                    this.f65200f = z;
                    this.f65201g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f65187e.i(this.f65199e - C1771a.this.f65197a);
                    a.this.f65187e.d(this.f65200f ? 1L : 2L, 3L);
                    a.this.f65187e.d(16L, 124L);
                    a.this.f65187e.h(this.f65201g);
                    if (!TextUtils.isEmpty(this.f65201g)) {
                        try {
                            String b2 = d.b.p.h.a.b("A10", new d.b.p.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f65201g.getBytes("UTF-8")));
                            a.this.f65187e.e(b2);
                            a.this.f65187e.l(b2);
                            a.this.f65187e.d(32L, 124L);
                        } catch (Exception unused) {
                        }
                    }
                    a.this.f65187e.m();
                    if (b.this.f65195g.f65211c.get()) {
                        return;
                    }
                    a.this.i();
                    b.this.f65195g.f65211c.set(true);
                }
            }

            public C1771a(long j) {
                this.f65197a = j;
            }

            @Override // d.b.p.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                String oaid = idSupplier.getOAID();
                b.this.f65193e.removeMessages(0);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b bVar = b.this;
                bVar.f65195g.f65210b = a.this.f65155b.f65162d.submit(new RunnableC1772a(elapsedRealtime, z, oaid));
            }
        }

        /* renamed from: d.b.p.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1773b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f65203e;

            public RunnableC1773b(int i) {
                this.f65203e = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.f65203e;
                if (i == 1008612 || i == 1008611 || i == 1008615) {
                    if (!b.this.f65195g.f65211c.get()) {
                        b.this.f65195g.f65211c.set(true);
                        a.this.i();
                    }
                    b.this.f65193e.removeMessages(0);
                }
                a.this.f65187e.c(this.f65203e);
                a.this.f65187e.d(8L, 124L);
                a.this.f65187e.m();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f65205e;

            public c(Throwable th) {
                this.f65205e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f65193e.removeMessages(0);
                a.this.f65187e.j(Log.getStackTraceString(this.f65205e));
                a.this.f65187e.m();
                if (b.this.f65195g.f65211c.get()) {
                    return;
                }
                b.this.f65195g.f65211c.set(true);
                a.this.i();
            }
        }

        public b(Handler handler, Context context, d dVar) {
            this.f65193e = handler;
            this.f65194f = context;
            this.f65195g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65193e.sendEmptyMessageDelayed(0, 50000L);
            try {
                int InitSdk = new MdidSdk().InitSdk(this.f65194f, new C1771a(SystemClock.elapsedRealtime()));
                this.f65195g.f65209a = a.this.f65155b.f65162d.submit(new RunnableC1773b(InitSdk));
            } catch (Throwable th) {
                a.this.f65155b.f65162d.submit(new c(th));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f65207e;

        public c(a.d dVar) {
            this.f65207e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f65188f.f65211c.get()) {
                a.this.j(this.f65207e);
            } else {
                a.this.f65189g.add(this.f65207e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f65209a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f65210b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f65211c = new AtomicBoolean(false);

        public d(a aVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public long f65212a;

        /* renamed from: d  reason: collision with root package name */
        public String f65215d;

        /* renamed from: e  reason: collision with root package name */
        public int f65216e;

        /* renamed from: g  reason: collision with root package name */
        public long f65218g;

        /* renamed from: h  reason: collision with root package name */
        public String f65219h;
        public String i;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65213b = true;

        /* renamed from: c  reason: collision with root package name */
        public d.b.p.g.c.a.e f65214c = new d.b.p.g.c.a.e();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f65217f = new ArrayList<>();

        public e() {
        }

        public String b() {
            return this.f65215d;
        }

        public void c(int i) {
            if (this.f65216e != i) {
                this.f65216e = i;
                this.f65213b = true;
            }
        }

        public void d(long j, long j2) {
            if (this.f65214c.c(j, j2)) {
                this.f65213b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f65215d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65215d = str;
                this.f65213b = true;
            }
        }

        public long f() {
            return this.f65212a;
        }

        public void g(long j) {
            if (this.f65212a != j) {
                this.f65212a = j;
                this.f65213b = true;
            }
        }

        public void h(String str) {
            String str2 = this.f65219h;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65219h = str;
                this.f65213b = true;
            }
        }

        public void i(long j) {
            if (this.f65218g != j) {
                this.f65218g = j;
                this.f65213b = true;
            }
        }

        public void j(String str) {
            if (this.i == str) {
                return;
            }
            if (str == null || !str.equals(this.f65219h)) {
                this.i = str;
                this.f65213b = true;
            }
        }

        public boolean k() {
            String g2 = a.this.f65186d.g("cache.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f65215d = jSONObject.optString("form_id");
                    this.f65212a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f65214c.b(jSONObject.getLong("flags"));
                    this.f65216e = jSONObject.optInt("init_res");
                    this.f65218g = jSONObject.optLong("acquire_ts_cost");
                    this.f65219h = jSONObject.optString("oid");
                    this.f65217f.clear();
                    JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                    if (optJSONObject != null) {
                        int i = optJSONObject.getInt("count");
                        for (int i2 = 0; i2 < i; i2++) {
                            String string = optJSONObject.getString("id_" + i2);
                            if (TextUtils.isEmpty(string)) {
                                this.f65217f.clear();
                                return false;
                            }
                            this.f65217f.add(string);
                        }
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public void l(String str) {
            if (this.f65217f.contains(str)) {
                return;
            }
            this.f65217f.add(str);
            this.f65213b = true;
        }

        public boolean m() {
            if (this.f65213b) {
                try {
                    a.this.f65186d.i("cache.dat", n().toString(), true);
                    this.f65213b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("form_id", this.f65215d);
                jSONObject.put("lst_fe_ts", this.f65212a);
                jSONObject.put("c_form_ver", 1);
                jSONObject.put("flags", this.f65214c.d());
                jSONObject.put("init_res", this.f65216e);
                jSONObject.put("acquire_ts_cost", this.f65218g);
                jSONObject.put("oid", this.f65219h);
                int size = this.f65217f.size();
                if (size > 0) {
                    int min = Math.min(size, 5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("his_form_ids", jSONObject2);
                    jSONObject2.put("count", min);
                    for (int i = 0; i < min; i++) {
                        jSONObject2.put("id_" + i, this.f65217f.get((size - min) + i));
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
        this.f65187e = new e();
        this.f65189g = new ArrayList();
    }

    @Override // d.b.p.h.a
    public String c() {
        return this.f65187e.b();
    }

    @Override // d.b.p.h.a
    public void f(a.c cVar) {
        this.f65186d = this.f65154a.f(e());
        Context context = this.f65155b.f65159a;
        d dVar = new d(this);
        this.f65188f = dVar;
        this.f65187e.k();
        long currentTimeMillis = System.currentTimeMillis();
        if (!cVar.f65164a && Math.abs(currentTimeMillis - this.f65187e.f()) <= 604800000) {
            dVar.f65211c.set(true);
            return;
        }
        this.f65187e.g(currentTimeMillis);
        this.f65187e.d(4L, 124L);
        this.f65187e.i(0L);
        this.f65187e.m();
        this.f65155b.f65163e.submit(new b(new HandlerC1769a(Looper.getMainLooper(), dVar), context, dVar));
    }

    @Override // d.b.p.h.a
    public void g(a.d<String> dVar) {
        this.f65155b.f65162d.submit(new c(dVar));
    }

    public final void i() {
        for (a.d<String> dVar : this.f65189g) {
            j(dVar);
        }
        this.f65189g.clear();
    }

    public final void j(a.d<String> dVar) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(this.f65187e.b())) {
            dVar.b(this.f65187e.f65216e, null, bundle);
        } else {
            dVar.a(this.f65187e.b(), bundle);
        }
    }
}
