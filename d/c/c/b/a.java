package d.c.c.b;

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
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.bytedance.sdk.adnet.d.d;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.g;
import d.c.c.b.c.f;
import d.c.c.b.d.m;
import d.c.c.b.d.n;
import d.c.c.b.d.o;
import d.c.c.b.d.p;
import d.c.c.b.d.q;
import d.c.c.b.e.h;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f66424a = null;

    /* renamed from: b  reason: collision with root package name */
    public static p f66425b = null;

    /* renamed from: c  reason: collision with root package name */
    public static d.c.c.b.c.b f66426c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f66427d = true;

    /* renamed from: e  reason: collision with root package name */
    public static d.c.c.b.c.a f66428e;

    /* renamed from: d.c.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1820a extends g {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66429e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1820a(String str, Context context) {
            super(str);
            this.f66429e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(this.f66429e).n();
            b.a(this.f66429e);
            b.k(this.f66429e);
        }
    }

    public static d.c.c.b.c.b a() {
        d.c.c.b.c.b bVar = f66426c;
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
        e.b(new C1820a("adnet onActivityResume", activity.getApplicationContext()));
    }

    public static void d(Context context, Application application, boolean z) {
        if (context != null) {
            f.a().e(context, d.c.c.b.e.f.c(context));
            if (d.c.c.b.e.f.b(context) || (!d.c.c.b.e.f.c(context) && z)) {
                b.a(context).n();
                b.a(context).b();
            }
            if (d.c.c.b.e.f.c(context)) {
                b.a(context);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet context is null");
    }

    public static void e(d.c.c.b.c.a aVar) {
        f66428e = aVar;
    }

    public static void f(d.c.c.b.c.b bVar) {
        f66426c = bVar;
    }

    public static void g(boolean z) {
        f66427d = z;
    }

    public static String h(Context context) {
        try {
            if (TextUtils.isEmpty(f66424a)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                f66424a = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            q.b(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return f66424a;
    }

    public static boolean i() {
        return f66427d;
    }

    public static void j() {
        d.a(d.a.DEBUG);
    }

    public static d.c.c.b.c.a k() {
        return f66428e;
    }

    /* loaded from: classes5.dex */
    public class b implements d.c.c.b.c.a, h.a {
        public static b k;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f66430a;

        /* renamed from: h  reason: collision with root package name */
        public final Context f66437h;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f66431b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f66432c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66433d = false;

        /* renamed from: e  reason: collision with root package name */
        public long f66434e = 0;

        /* renamed from: f  reason: collision with root package name */
        public long f66435f = 0;

        /* renamed from: g  reason: collision with root package name */
        public AtomicBoolean f66436g = new AtomicBoolean(false);
        public volatile boolean i = false;
        public final h j = new h(Looper.getMainLooper(), this);

        /* renamed from: d.c.c.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1821a extends g {
            public C1821a(String str) {
                super(str);
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i();
            }
        }

        /* renamed from: d.c.c.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1822b extends g {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f66439e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1822b(String str, boolean z) {
                super(str);
                this.f66439e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.o(this.f66439e);
            }
        }

        /* loaded from: classes5.dex */
        public class c implements o.a<JSONObject> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f66441e;

            public c(int i) {
                this.f66441e = i;
            }

            @Override // d.c.c.b.d.o.a
            public void a(o<JSONObject> oVar) {
                JSONObject jSONObject = oVar.f66584a;
                if (jSONObject == null) {
                    b.this.c(this.f66441e + 1);
                    return;
                }
                String str = null;
                try {
                    str = jSONObject.getString("message");
                } catch (Exception unused) {
                }
                if (!"success".equals(str)) {
                    b.this.c(this.f66441e + 1);
                    return;
                }
                try {
                    if (b.this.g(jSONObject)) {
                        b.this.j(101);
                    } else {
                        b.this.c(this.f66441e + 1);
                    }
                } catch (Exception unused2) {
                }
            }

            @Override // d.c.c.b.d.o.a
            public void b(o<JSONObject> oVar) {
                b.this.c(this.f66441e + 1);
            }
        }

        public b(Context context, boolean z) {
            this.f66437h = context;
            this.f66430a = z;
        }

        public static b a(Context context) {
            b bVar;
            synchronized (b.class) {
                if (k == null) {
                    b bVar2 = new b(context.getApplicationContext(), d.c.c.b.e.f.c(context));
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
                if (d.c.c.b.e.f.c(context)) {
                    bVar.e(true);
                } else {
                    bVar.b();
                }
            }
        }

        public void b() {
            e(false);
        }

        public final void c(int i) {
            String[] q = q();
            if (q != null && q.length > i) {
                String str = q[i];
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
                    d.c.c.b.b.f fVar = new d.c.c.b.b.f(0, h2, new JSONObject(), new c(i));
                    d.c.c.b.d.g gVar = new d.c.c.b.d.g();
                    gVar.b(10000);
                    gVar.c(0);
                    fVar.setRetryPolicy(gVar).build(a.b(this.f66437h));
                    return;
                } catch (Throwable th) {
                    d.c("AppConfig", "try app config exception: " + th);
                    return;
                }
            }
            j(102);
        }

        public synchronized void e(boolean z) {
            if (this.f66430a) {
                p(z);
            } else if (this.f66434e <= 0) {
                try {
                    e.b(new C1821a("adnet tryRefreshConfig"));
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
                SharedPreferences.Editor edit = this.f66437h.getSharedPreferences("ss_app_config", 0).edit();
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
            Address a2 = a.a().a(this.f66437h);
            d.c.c.b.e.g gVar = new d.c.c.b.e.g("https://" + str + "/get_domains/v4/");
            if (a2 != null && a2.hasLatitude() && a2.hasLongitude()) {
                gVar.c("latitude", a2.getLatitude());
                gVar.c("longitude", a2.getLongitude());
                String locality = a2.getLocality();
                if (!TextUtils.isEmpty(locality)) {
                    gVar.e("city", Uri.encode(locality));
                }
            }
            if (this.f66431b) {
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
            if (System.currentTimeMillis() - this.f66434e > VideoCloudSetting.HOUR_MILLISECOND) {
                this.f66434e = System.currentTimeMillis();
                try {
                    if (f.a().r() != null) {
                        f.a().r().d();
                    }
                } catch (Exception unused) {
                }
            }
        }

        public final void j(int i) {
            h hVar = this.j;
            if (hVar != null) {
                hVar.sendEmptyMessage(i);
            }
        }

        public boolean m(boolean z) {
            d.c("TNCManager", "doRefresh: updating state " + this.f66436g.get());
            if (!this.f66436g.compareAndSet(false, true)) {
                d.c("TNCManager", "doRefresh, already running");
                return false;
            }
            if (z) {
                this.f66435f = System.currentTimeMillis();
            }
            e.b(new C1822b("adnet doRefresh", z));
            return true;
        }

        public synchronized void n() {
            if (this.i) {
                return;
            }
            this.i = true;
            long j = this.f66437h.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > currentTimeMillis) {
                j = currentTimeMillis;
            }
            this.f66434e = j;
            if (f.a().r() != null) {
                f.a().r().a();
            }
        }

        public void o(boolean z) {
            d.c("TNCManager", "doRefresh, actual request");
            n();
            this.f66433d = true;
            if (!z) {
                this.j.sendEmptyMessage(102);
                return;
            }
            try {
                r();
            } catch (Exception unused) {
                this.f66436g.set(false);
            }
        }

        public final void p(boolean z) {
            if (this.f66433d) {
                return;
            }
            if (this.f66432c) {
                this.f66432c = false;
                this.f66434e = 0L;
                this.f66435f = 0L;
            }
            long j = z ? Constants.SYNC_MSG_DELAY_TIME : 43200000L;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f66434e <= j || currentTimeMillis - this.f66435f <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return;
            }
            boolean a2 = d.c.c.b.e.e.a(this.f66437h);
            if (!this.i || a2) {
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

        @Override // d.c.c.b.e.h.a
        public void a(Message message) {
            int i = message.what;
            if (i == 101) {
                this.f66433d = false;
                this.f66434e = System.currentTimeMillis();
                d.c("TNCManager", "doRefresh, succ");
                if (this.f66432c) {
                    b();
                }
                this.f66436g.set(false);
            } else if (i != 102) {
            } else {
                this.f66433d = false;
                if (this.f66432c) {
                    b();
                }
                d.c("TNCManager", "doRefresh, error");
                this.f66436g.set(false);
            }
        }

        @Override // d.c.c.b.c.a
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
                if (this.f66430a) {
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
