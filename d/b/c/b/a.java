package d.b.c.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.bytedance.sdk.adnet.d.d;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import d.b.c.b.c.f;
import d.b.c.b.d.m;
import d.b.c.b.d.n;
import d.b.c.b.d.o;
import d.b.c.b.d.p;
import d.b.c.b.d.q;
import d.b.c.b.e.h;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f69477a = null;

    /* renamed from: b  reason: collision with root package name */
    public static p f69478b = null;

    /* renamed from: c  reason: collision with root package name */
    public static d.b.c.b.c.b f69479c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f69480d = true;

    /* renamed from: e  reason: collision with root package name */
    public static d.b.c.b.c.a f69481e;

    /* renamed from: d.b.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1893a extends g {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f69482e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1893a(String str, Context context) {
            super(str);
            this.f69482e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(this.f69482e).n();
            b.a(this.f69482e);
            b.k(this.f69482e);
        }
    }

    public static d.b.c.b.c.b a() {
        d.b.c.b.c.b bVar = f69479c;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static n b(Context context) {
        return m.a(context);
    }

    public static void c(Activity activity) {
        if (activity == null) {
            return;
        }
        e.b(new C1893a("adnet onActivityResume", activity.getApplicationContext()));
    }

    public static void d(Context context, Application application, boolean z) {
        if (context != null) {
            f.a().e(context, d.b.c.b.e.f.c(context));
            if (d.b.c.b.e.f.b(context) || (!d.b.c.b.e.f.c(context) && z)) {
                b.a(context).n();
                b.a(context).b();
            }
            if (d.b.c.b.e.f.c(context)) {
                b.a(context);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet context is null");
    }

    public static void e(d.b.c.b.c.a aVar) {
        f69481e = aVar;
    }

    public static void f(d.b.c.b.c.b bVar) {
        f69479c = bVar;
    }

    public static void g(boolean z) {
        f69480d = z;
    }

    public static String h(Context context) {
        try {
            if (TextUtils.isEmpty(f69477a)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                f69477a = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            q.b(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return f69477a;
    }

    public static boolean i() {
        return f69480d;
    }

    public static void j() {
        d.a(d.a.DEBUG);
    }

    public static d.b.c.b.c.a k() {
        return f69481e;
    }

    /* loaded from: classes6.dex */
    public class b implements d.b.c.b.c.a, h.a {
        public static b k;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f69483a;

        /* renamed from: h  reason: collision with root package name */
        public final Context f69490h;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f69484b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f69485c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f69486d = false;

        /* renamed from: e  reason: collision with root package name */
        public long f69487e = 0;

        /* renamed from: f  reason: collision with root package name */
        public long f69488f = 0;

        /* renamed from: g  reason: collision with root package name */
        public AtomicBoolean f69489g = new AtomicBoolean(false);

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f69491i = false;
        public final h j = new h(Looper.getMainLooper(), this);

        /* renamed from: d.b.c.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1894a extends g {
            public C1894a(String str) {
                super(str);
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i();
            }
        }

        /* renamed from: d.b.c.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1895b extends g {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f69493e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1895b(String str, boolean z) {
                super(str);
                this.f69493e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.o(this.f69493e);
            }
        }

        /* loaded from: classes6.dex */
        public class c implements o.a<JSONObject> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f69495e;

            public c(int i2) {
                this.f69495e = i2;
            }

            @Override // d.b.c.b.d.o.a
            public void a(o<JSONObject> oVar) {
                JSONObject jSONObject = oVar.f69644a;
                if (jSONObject == null) {
                    b.this.c(this.f69495e + 1);
                    return;
                }
                String str = null;
                try {
                    str = jSONObject.getString("message");
                } catch (Exception unused) {
                }
                if (!"success".equals(str)) {
                    b.this.c(this.f69495e + 1);
                    return;
                }
                try {
                    if (b.this.g(jSONObject)) {
                        b.this.j(101);
                    } else {
                        b.this.c(this.f69495e + 1);
                    }
                } catch (Exception unused2) {
                }
            }

            @Override // d.b.c.b.d.o.a
            public void b(o<JSONObject> oVar) {
                b.this.c(this.f69495e + 1);
            }
        }

        public b(Context context, boolean z) {
            this.f69490h = context;
            this.f69483a = z;
        }

        public static b a(Context context) {
            b bVar;
            synchronized (b.class) {
                if (k == null) {
                    b bVar2 = new b(context.getApplicationContext(), d.b.c.b.e.f.c(context));
                    k = bVar2;
                    a.e(bVar2);
                }
                bVar = k;
            }
            return bVar;
        }

        public static void k(Context context) {
            b bVar = k;
            if (bVar != null) {
                if (d.b.c.b.e.f.c(context)) {
                    bVar.e(true);
                } else {
                    bVar.b();
                }
            }
        }

        public void b() {
            e(false);
        }

        public final void c(int i2) {
            String[] q = q();
            if (q != null && q.length > i2) {
                String str = q[i2];
                if (TextUtils.isEmpty(str)) {
                    j(102);
                    return;
                }
                try {
                    String h2 = h(str);
                    if (TextUtils.isEmpty(h2)) {
                        j(102);
                        return;
                    }
                    d.b.c.b.b.f fVar = new d.b.c.b.b.f(0, h2, new JSONObject(), new c(i2));
                    d.b.c.b.d.g gVar = new d.b.c.b.d.g();
                    gVar.b(10000);
                    gVar.c(0);
                    fVar.setRetryPolicy(gVar).build(a.b(this.f69490h));
                    return;
                } catch (Throwable th) {
                    d.c("AppConfig", "try app config exception: " + th);
                    return;
                }
            }
            j(102);
        }

        public synchronized void e(boolean z) {
            if (this.f69483a) {
                p(z);
            } else if (this.f69487e <= 0) {
                try {
                    e.b(new C1894a("adnet tryRefreshConfig"));
                } catch (Throwable unused) {
                }
            }
        }

        public final boolean g(Object obj) throws Exception {
            JSONObject jSONObject;
            if (obj instanceof String) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                jSONObject = new JSONObject(str);
                if (!"success".equals(jSONObject.getString("message"))) {
                    return false;
                }
            } else {
                jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
            }
            if (jSONObject == null) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            synchronized (this) {
                SharedPreferences.Editor edit = this.f69490h.getSharedPreferences("ss_app_config", 0).edit();
                edit.putLong("last_refresh_time", System.currentTimeMillis());
                edit.apply();
            }
            if (f.a().r() != null) {
                f.a().r().b(jSONObject2);
                return true;
            }
            return true;
        }

        public final String h(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Address a2 = a.a().a(this.f69490h);
            d.b.c.b.e.g gVar = new d.b.c.b.e.g("https://" + str + "/get_domains/v4/");
            if (a2 != null && a2.hasLatitude() && a2.hasLongitude()) {
                gVar.c("latitude", a2.getLatitude());
                gVar.c("longitude", a2.getLongitude());
                String locality = a2.getLocality();
                if (!TextUtils.isEmpty(locality)) {
                    gVar.e("city", Uri.encode(locality));
                }
            }
            if (this.f69484b) {
                gVar.d("force", 1);
            }
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    str2 = Build.CPU_ABI;
                } else {
                    str2 = Build.SUPPORTED_ABIS[0];
                }
                gVar.e("abi", str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            gVar.d("aid", a.a().a());
            gVar.e("device_platform", a.a().c());
            gVar.e("channel", a.a().b());
            gVar.d("version_code", a.a().d());
            gVar.e("custom_info_1", a.a().e());
            return gVar.toString();
        }

        public synchronized void i() {
            if (System.currentTimeMillis() - this.f69487e > 3600000) {
                this.f69487e = System.currentTimeMillis();
                try {
                    if (f.a().r() != null) {
                        f.a().r().d();
                    }
                } catch (Exception unused) {
                }
            }
        }

        public final void j(int i2) {
            h hVar = this.j;
            if (hVar != null) {
                hVar.sendEmptyMessage(i2);
            }
        }

        public boolean m(boolean z) {
            d.c("TNCManager", "doRefresh: updating state " + this.f69489g.get());
            if (!this.f69489g.compareAndSet(false, true)) {
                d.c("TNCManager", "doRefresh, already running");
                return false;
            }
            if (z) {
                this.f69488f = System.currentTimeMillis();
            }
            e.b(new C1895b("adnet doRefresh", z));
            return true;
        }

        public synchronized void n() {
            if (this.f69491i) {
                return;
            }
            this.f69491i = true;
            long j = this.f69490h.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > currentTimeMillis) {
                j = currentTimeMillis;
            }
            this.f69487e = j;
            if (f.a().r() != null) {
                f.a().r().a();
            }
        }

        public void o(boolean z) {
            d.c("TNCManager", "doRefresh, actual request");
            n();
            this.f69486d = true;
            if (!z) {
                this.j.sendEmptyMessage(102);
                return;
            }
            try {
                r();
            } catch (Exception unused) {
                this.f69489g.set(false);
            }
        }

        public final void p(boolean z) {
            if (this.f69486d) {
                return;
            }
            if (this.f69485c) {
                this.f69485c = false;
                this.f69487e = 0L;
                this.f69488f = 0L;
            }
            long j = z ? Constants.SYNC_MSG_DELAY_TIME : 43200000L;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f69487e <= j || currentTimeMillis - this.f69488f <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return;
            }
            boolean a2 = d.b.c.b.e.e.a(this.f69490h);
            if (!this.f69491i || a2) {
                m(a2);
            }
        }

        public String[] q() {
            String[] f2 = a.a().f();
            return (f2 == null || f2.length <= 0) ? new String[0] : f2;
        }

        public final boolean r() {
            String[] q = q();
            if (q != null && q.length != 0) {
                c(0);
            }
            return false;
        }

        @Override // d.b.c.b.e.h.a
        public void a(Message message) {
            int i2 = message.what;
            if (i2 == 101) {
                this.f69486d = false;
                this.f69487e = System.currentTimeMillis();
                d.c("TNCManager", "doRefresh, succ");
                if (this.f69485c) {
                    b();
                }
                this.f69489g.set(false);
            } else if (i2 != 102) {
            } else {
                this.f69486d = false;
                if (this.f69485c) {
                    b();
                }
                d.c("TNCManager", "doRefresh, error");
                this.f69489g.set(false);
            }
        }

        @Override // d.b.c.b.c.a
        public String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    return f.a().d(str);
                } catch (Throwable unused) {
                    return str;
                }
            }
            try {
                if (this.f69483a) {
                    n();
                } else {
                    i();
                }
                return f.a().d(str);
            } catch (Throwable unused2) {
                return str;
            }
        }
    }
}
