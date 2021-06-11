package d.a.l0.a.v1.b;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.a2.i;
import d.a.l0.a.k;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class b extends d.a.l0.a.f1.e.f.c<b> implements d.a.l0.a.v1.b.a {
    public static final boolean p = k.f46875a;

    /* renamed from: f  reason: collision with root package name */
    public final c f48959f;

    /* renamed from: g  reason: collision with root package name */
    public final String f48960g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<d.a.l0.a.v2.e1.b<i.a>> f48961h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public final Set<d.a.l0.a.v2.e1.b<b>> f48962i = new HashSet();
    public final Set<String> j = new HashSet();
    public final Set<Integer> k = new HashSet();
    public Exception l = null;
    public long m = 0;
    public boolean n = false;
    public final Runnable o = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this.f48959f) {
                b.this.f48959f.P(b.this, new TimeoutException("timeout"));
            }
        }
    }

    public b(@NonNull c cVar, String str) {
        this.f48959f = cVar;
        this.f48960g = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (p) {
            V("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.f48960g);
        }
    }

    public b F(d.a.l0.a.v2.e1.b<b> bVar) {
        H(this.f48962i, bVar);
        return this;
    }

    public b G(d.a.l0.a.v2.e1.b<i.a> bVar) {
        H(this.f48961h, bVar);
        return this;
    }

    public final <CallBackT> b H(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.f48959f) {
            if (Z() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    public b I(int i2) {
        synchronized (this.f48959f) {
            this.k.add(Integer.valueOf(i2));
            Y();
        }
        return this;
    }

    public b J(String str) {
        synchronized (this.f48959f) {
            this.j.add(str);
            Y();
        }
        return this;
    }

    public b K(boolean z) {
        synchronized (this.f48959f) {
            this.n = z;
            Y();
        }
        return this;
    }

    public b L() {
        M(d.a.l0.a.v1.b.a.J0);
        return this;
    }

    public b M(long j) {
        synchronized (this.f48959f) {
            if (p) {
                V(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (Z()) {
                long T = T(j);
                if (p) {
                    V(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + T);
                }
                d.a.l0.a.v1.c.a.e().h(N());
                b();
            } else {
                this.f48959f.P(this, new IllegalStateException("invalid session call"));
            }
            Y();
        }
        return this;
    }

    public final d.a.l0.a.v1.c.c N() {
        Bundle C = C();
        C.putString("ipc_session_id", this.f48960g);
        C.putLong("ipc_session_timeout", this.m);
        C.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        C.putString("ipc_topic", this.f48959f.L(this));
        d.a.l0.a.v1.c.c cVar = new d.a.l0.a.v1.c.c(W(), C);
        cVar.p(true);
        cVar.f(!SwanAppProcessInfo.current().isSwanService || this.n);
        for (Integer num : this.k) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                cVar.a(intValue);
            }
        }
        for (String str : this.j) {
            if (!TextUtils.isEmpty(str)) {
                cVar.c(str);
            }
        }
        if (p) {
            V("createMsg", "msgCooker=" + cVar + " bundle=" + C);
        }
        return cVar;
    }

    public b O(Exception exc) {
        synchronized (this.f48959f) {
            if (!S()) {
                d.a.l0.a.a2.d.i().removeCallbacks(this.o);
                this.m = -1L;
                this.l = exc;
                this.f48961h.clear();
                for (d.a.l0.a.v2.e1.b<b> bVar : this.f48962i) {
                    bVar.onCallback(this);
                }
                this.f48962i.clear();
                this.n = false;
                this.j.clear();
                this.k.clear();
                b();
            }
        }
        return this;
    }

    public Exception P() {
        return this.l;
    }

    public boolean Q() {
        return this.l != null;
    }

    public String R() {
        return this.f48960g;
    }

    public boolean S() {
        return this.m < 0;
    }

    public long T(long j) {
        long j2;
        synchronized (this.f48959f) {
            if (Z()) {
                this.m = Math.max(Math.max(j, d.a.l0.a.v1.b.a.J0), this.m);
                Handler i2 = d.a.l0.a.a2.d.i();
                if (this.m > 0) {
                    i2.removeCallbacks(this.o);
                    i2.postDelayed(this.o, this.m);
                }
            }
            j2 = this.m;
        }
        return j2;
    }

    public final void U(String str) {
        if (p) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void V(String str, String str2) {
        U(str + ": " + str2);
    }

    public final int W() {
        boolean z = SwanAppProcessInfo.current().isSwanService;
        int i2 = z ? 111 : 11;
        if (p) {
            V("msgType", "service=" + z + " msgType=" + i2);
        }
        return i2;
    }

    public boolean X(i.a aVar) {
        boolean z;
        synchronized (this.f48959f) {
            z = (!Z() || this.f48961h.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (d.a.l0.a.v2.e1.b<i.a> bVar : this.f48961h) {
                    bVar.onCallback(aVar);
                }
            }
        }
        return z;
    }

    public b Y() {
        return this;
    }

    public boolean Z() {
        boolean z;
        synchronized (this.f48959f) {
            z = (S() || Q() || TextUtils.isEmpty(this.f48960g)) ? false : true;
            if (p) {
                V("valid", z + " isFinished=" + S() + " hasException=" + this.l + " id=" + this.f48960g);
            }
        }
        return z;
    }

    @Override // d.a.l0.a.v2.e1.d
    public /* bridge */ /* synthetic */ d.a.l0.a.v2.e1.d a() {
        Y();
        return this;
    }

    @Override // d.a.l0.a.f1.e.f.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.f48960g + " timeout=" + this.m;
    }
}
