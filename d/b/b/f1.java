package d.b.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import d.b.b.a1;
import d.b.b.c;
import d.b.b.g1;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class f1 {

    /* renamed from: i  reason: collision with root package name */
    public static final String f65010i;
    public static final String j;
    @Nullable
    public static c k;
    public static String l;

    /* renamed from: b  reason: collision with root package name */
    public g1 f65012b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65013c;

    /* renamed from: d  reason: collision with root package name */
    public j1 f65014d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f65015e;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f65017g;

    /* renamed from: h  reason: collision with root package name */
    public Long f65018h;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f65011a = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f65016f = new AtomicBoolean(false);

    /* loaded from: classes6.dex */
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
        f65010i = str;
        j = str;
    }

    public f1(Context context) {
        this.f65015e = context;
        g1 a2 = h1.a(context);
        this.f65012b = a2;
        if (a2 != null) {
            this.f65013c = a2.a(context);
        } else {
            this.f65013c = false;
        }
        this.f65014d = new j1(context);
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
        g1 g1Var = this.f65012b;
        String str = null;
        if (g1Var == null || (b2 = g1Var.b(context)) == null) {
            bool = null;
        } else {
            str = b2.f65023a;
            bool = Boolean.valueOf(b2.f65024b);
            if (b2 instanceof a1.c) {
                this.f65018h = Long.valueOf(((a1.c) b2).f64974c);
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
        r5.f65011a.unlock();
     */
    @Nullable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> b(long j2) {
        if (this.f65013c) {
            c();
            String str = j;
            y0.c(str, "Oaid#getOaid timeoutMills=" + j2);
            if (this.f65017g == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                boolean z = false;
                try {
                    try {
                        z = this.f65011a.tryLock(j2, TimeUnit.MILLISECONDS);
                        String str2 = j;
                        y0.e(str2, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    if (z) {
                        this.f65011a.unlock();
                    }
                    throw th;
                }
            }
            String str3 = j;
            y0.c(str3, "Oaid#getOaid return apiMap=" + this.f65017g);
            return this.f65017g;
        }
        return null;
    }

    public void c() {
        if (this.f65016f.compareAndSet(false, true)) {
            g(new a());
        }
    }

    public final void j() {
        y0.e(j, "Oaid#initOaid");
        try {
            this.f65011a.lock();
            y0.e(j, "Oaid#initOaid exec");
            i1 a2 = this.f65014d.a();
            String str = j;
            y0.e(str, "Oaid#initOaid fetch=" + a2);
            if (a2 != null) {
                l = a2.f65040a;
                this.f65017g = a2.b();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> a3 = a(this.f65015e);
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            i1 i1Var = null;
            String str2 = null;
            if (a3.first != null) {
                int i2 = -1;
                int i3 = 1;
                if (a2 != null) {
                    str2 = a2.f65041b;
                    i2 = a2.f65045f.intValue() + 1;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                String str3 = str2;
                if (i2 > 0) {
                    i3 = i2;
                }
                i1 i1Var2 = new i1((String) a3.first, str3, (Boolean) a3.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3), this.f65018h);
                this.f65014d.b(i1Var2);
                i1Var = i1Var2;
            }
            if (i1Var != null) {
                l = i1Var.f65040a;
                this.f65017g = i1Var.b();
            }
            String str4 = j;
            y0.e(str4, "Oaid#initOaid oaidModel=" + i1Var);
        } finally {
            this.f65011a.unlock();
            d(new c.a(l));
        }
    }
}
