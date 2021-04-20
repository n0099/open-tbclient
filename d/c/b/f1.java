package d.c.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import d.c.b.a1;
import d.c.b.c;
import d.c.b.g1;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f1 {
    public static final String i;
    public static final String j;
    @Nullable
    public static c k;
    public static String l;

    /* renamed from: b  reason: collision with root package name */
    public g1 f65830b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65831c;

    /* renamed from: d  reason: collision with root package name */
    public j1 f65832d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f65833e;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f65835g;

    /* renamed from: h  reason: collision with root package name */
    public Long f65836h;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f65829a = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f65834f = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f1.this.j();
        }
    }

    static {
        String str = f1.class.getSimpleName() + "#";
        i = str;
        j = str;
    }

    public f1(Context context) {
        this.f65833e = context;
        g1 a2 = h1.a(context);
        this.f65830b = a2;
        if (a2 != null) {
            this.f65831c = a2.a(context);
        } else {
            this.f65831c = false;
        }
        this.f65832d = new j1(context);
    }

    public static void d(@Nullable c.a aVar) {
        c cVar;
        if (aVar == null || (cVar = k) == null) {
            return;
        }
        cVar.onOaidLoaded(aVar);
    }

    @AnyThread
    public static void e(@Nullable c cVar) {
        k = cVar;
        String str = l;
        if (str != null) {
            d(new c.a(str));
        }
    }

    public static void g(Runnable runnable) {
        z0.a(j + "-query", runnable);
    }

    public static <K, V> void h(Map<K, V> map, K k2, V v) {
        if (k2 == null || v == null) {
            return;
        }
        map.put(k2, v);
    }

    public static void i(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @NonNull
    @WorkerThread
    public final Pair<String, Boolean> a(Context context) {
        Boolean bool;
        g1.a b2;
        g1 g1Var = this.f65830b;
        String str = null;
        if (g1Var == null || (b2 = g1Var.b(context)) == null) {
            bool = null;
        } else {
            str = b2.f65841a;
            bool = Boolean.valueOf(b2.f65842b);
            if (b2 instanceof a1.c) {
                this.f65836h = Long.valueOf(((a1.c) b2).f65795c);
            }
        }
        return new Pair<>(str, bool);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0058, code lost:
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
        if (r2 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
        r5.f65829a.unlock();
     */
    @Nullable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> b(long j2) {
        if (this.f65831c) {
            c();
            String str = j;
            y0.c(str, "Oaid#getOaid timeoutMills=" + j2);
            if (this.f65835g == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                boolean z = false;
                try {
                    try {
                        z = this.f65829a.tryLock(j2, TimeUnit.MILLISECONDS);
                        String str2 = j;
                        y0.e(str2, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    if (z) {
                        this.f65829a.unlock();
                    }
                    throw th;
                }
            }
            String str3 = j;
            y0.c(str3, "Oaid#getOaid return apiMap=" + this.f65835g);
            return this.f65835g;
        }
        return null;
    }

    public void c() {
        if (this.f65834f.compareAndSet(false, true)) {
            g(new a());
        }
    }

    public final void j() {
        y0.e(j, "Oaid#initOaid");
        try {
            this.f65829a.lock();
            y0.e(j, "Oaid#initOaid exec");
            i1 a2 = this.f65832d.a();
            String str = j;
            y0.e(str, "Oaid#initOaid fetch=" + a2);
            if (a2 != null) {
                l = a2.f65858a;
                this.f65835g = a2.b();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> a3 = a(this.f65833e);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            i1 i1Var = null;
            String str2 = null;
            if (a3.first != null) {
                int i2 = -1;
                int i3 = 1;
                if (a2 != null) {
                    str2 = a2.f65859b;
                    i2 = a2.f65863f.intValue() + 1;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                String str3 = str2;
                if (i2 > 0) {
                    i3 = i2;
                }
                i1 i1Var2 = new i1((String) a3.first, str3, (Boolean) a3.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3), this.f65836h);
                this.f65832d.b(i1Var2);
                i1Var = i1Var2;
            }
            if (i1Var != null) {
                l = i1Var.f65858a;
                this.f65835g = i1Var.b();
            }
            String str4 = j;
            y0.e(str4, "Oaid#initOaid oaidModel=" + i1Var);
        } finally {
            this.f65829a.unlock();
            d(new c.a(l));
        }
    }
}
