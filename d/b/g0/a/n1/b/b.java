package d.b.g0.a.n1.b;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.b.g0.a.k;
import d.b.g0.a.r1.d;
import d.b.g0.a.r1.i;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public final class b extends d.b.g0.a.y0.e.f.c<b> implements d.b.g0.a.n1.b.a {
    public static final boolean q = k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public final c f45745g;

    /* renamed from: h  reason: collision with root package name */
    public final String f45746h;
    public final Set<d.b.g0.a.i2.u0.b<i.a>> i = new HashSet();
    public final Set<d.b.g0.a.i2.u0.b<b>> j = new HashSet();
    public final Set<String> k = new HashSet();
    public final Set<Integer> l = new HashSet();
    public Exception m = null;
    public long n = 0;
    public boolean o = false;
    public final Runnable p = new a();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.W();
        }
    }

    public b(@NonNull c cVar, String str) {
        this.f45745g = cVar;
        this.f45746h = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (q) {
            T("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.f45746h);
        }
    }

    public b E(d.b.g0.a.i2.u0.b<b> bVar) {
        G(this.j, bVar);
        return this;
    }

    public b F(d.b.g0.a.i2.u0.b<i.a> bVar) {
        G(this.i, bVar);
        return this;
    }

    public final <CallBackT> b G(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.f45745g) {
            if (Y() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    public b H(int i) {
        synchronized (this.f45745g) {
            this.l.add(Integer.valueOf(i));
            X();
        }
        return this;
    }

    public b I(boolean z) {
        synchronized (this.f45745g) {
            this.o = z;
            X();
        }
        return this;
    }

    public b J() {
        K(d.b.g0.a.n1.b.a.H0);
        return this;
    }

    public b K(long j) {
        synchronized (this.f45745g) {
            if (q) {
                T(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (Y()) {
                long R = R(j);
                if (q) {
                    T(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + R);
                }
                d.b.g0.a.n1.c.a.e().h(L());
                b();
            } else {
                this.f45745g.N(this, new IllegalStateException("invalid session call"));
            }
            X();
        }
        return this;
    }

    public final d.b.g0.a.n1.c.c L() {
        Bundle A = A();
        A.putString("ipc_session_id", this.f45746h);
        A.putLong("ipc_session_timeout", this.n);
        A.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        A.putString("ipc_topic", this.f45745g.J(this));
        d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(U(), A);
        cVar.p(true);
        cVar.f(!SwanAppProcessInfo.current().isSwanService || this.o);
        for (Integer num : this.l) {
            int intValue = num.intValue();
            if (SwanAppProcessInfo.checkProcessId(intValue)) {
                cVar.a(intValue);
            }
        }
        for (String str : this.k) {
            if (!TextUtils.isEmpty(str)) {
                cVar.c(str);
            }
        }
        if (q) {
            T("createMsg", "msgCooker=" + cVar + " bundle=" + A);
        }
        return cVar;
    }

    public b M(Exception exc) {
        synchronized (this.f45745g) {
            if (!Q()) {
                d.g().removeCallbacks(this.p);
                this.n = -1L;
                this.m = exc;
                this.i.clear();
                for (d.b.g0.a.i2.u0.b<b> bVar : this.j) {
                    bVar.onCallback(this);
                }
                this.j.clear();
                this.o = false;
                this.k.clear();
                this.l.clear();
                b();
            }
        }
        return this;
    }

    public Exception N() {
        return this.m;
    }

    public boolean O() {
        return this.m != null;
    }

    public String P() {
        return this.f45746h;
    }

    public boolean Q() {
        return this.n < 0;
    }

    public long R(long j) {
        long j2;
        synchronized (this.f45745g) {
            if (Y()) {
                this.n = Math.max(Math.max(j, d.b.g0.a.n1.b.a.H0), this.n);
                Handler g2 = d.g();
                if (this.n > 0) {
                    g2.removeCallbacks(this.p);
                    g2.postDelayed(this.p, this.n);
                }
            }
            j2 = this.n;
        }
        return j2;
    }

    public final void S(String str) {
        if (q) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void T(String str, String str2) {
        S(str + ": " + str2);
    }

    public final int U() {
        boolean z = SwanAppProcessInfo.current().isSwanService;
        int i = z ? 111 : 11;
        if (q) {
            T("msgType", "service=" + z + " msgType=" + i);
        }
        return i;
    }

    public boolean V(i.a aVar) {
        boolean z;
        synchronized (this.f45745g) {
            z = (!Y() || this.i.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (d.b.g0.a.i2.u0.b<i.a> bVar : this.i) {
                    bVar.onCallback(aVar);
                }
            }
        }
        return z;
    }

    public final void W() {
        synchronized (this.f45745g) {
            this.f45745g.N(this, new TimeoutException("timeout"));
        }
    }

    public b X() {
        return this;
    }

    public boolean Y() {
        boolean z;
        synchronized (this.f45745g) {
            z = (Q() || O() || TextUtils.isEmpty(this.f45746h)) ? false : true;
            if (q) {
                T("valid", z + " isFinished=" + Q() + " hasException=" + this.m + " id=" + this.f45746h);
            }
        }
        return z;
    }

    @Override // d.b.g0.a.i2.u0.d
    public /* bridge */ /* synthetic */ d.b.g0.a.i2.u0.d a() {
        X();
        return this;
    }

    @Override // d.b.g0.a.y0.e.f.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.f45746h + " timeout=" + this.n;
    }
}
