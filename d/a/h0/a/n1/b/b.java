package d.a.h0.a.n1.b;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.i;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class b extends d.a.h0.a.y0.e.f.c<b> implements d.a.h0.a.n1.b.a {
    public static final boolean q = k.f43101a;

    /* renamed from: g  reason: collision with root package name */
    public final c f43417g;

    /* renamed from: h  reason: collision with root package name */
    public final String f43418h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<d.a.h0.a.i2.u0.b<i.a>> f43419i = new HashSet();
    public final Set<d.a.h0.a.i2.u0.b<b>> j = new HashSet();
    public final Set<String> k = new HashSet();
    public final Set<Integer> l = new HashSet();
    public Exception m = null;
    public long n = 0;
    public boolean o = false;
    public final Runnable p = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.W();
        }
    }

    public b(@NonNull c cVar, String str) {
        this.f43417g = cVar;
        this.f43418h = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        if (q) {
            T("IpcSession", "host=" + cVar + " id=" + str + " mId=" + this.f43418h);
        }
    }

    public b E(d.a.h0.a.i2.u0.b<b> bVar) {
        G(this.j, bVar);
        return this;
    }

    public b F(d.a.h0.a.i2.u0.b<i.a> bVar) {
        G(this.f43419i, bVar);
        return this;
    }

    public final <CallBackT> b G(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        synchronized (this.f43417g) {
            if (Y() && callbackt != null) {
                set.add(callbackt);
            }
        }
        return this;
    }

    public b H(int i2) {
        synchronized (this.f43417g) {
            this.l.add(Integer.valueOf(i2));
            X();
        }
        return this;
    }

    public b I(boolean z) {
        synchronized (this.f43417g) {
            this.o = z;
            X();
        }
        return this;
    }

    public b J() {
        K(d.a.h0.a.n1.b.a.H0);
        return this;
    }

    public b K(long j) {
        synchronized (this.f43417g) {
            if (q) {
                T(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
            }
            if (Y()) {
                long R = R(j);
                if (q) {
                    T(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + R);
                }
                d.a.h0.a.n1.c.a.e().h(L());
                b();
            } else {
                this.f43417g.N(this, new IllegalStateException("invalid session call"));
            }
            X();
        }
        return this;
    }

    public final d.a.h0.a.n1.c.c L() {
        Bundle A = A();
        A.putString("ipc_session_id", this.f43418h);
        A.putLong("ipc_session_timeout", this.n);
        A.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
        A.putString("ipc_topic", this.f43417g.J(this));
        d.a.h0.a.n1.c.c cVar = new d.a.h0.a.n1.c.c(U(), A);
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
        synchronized (this.f43417g) {
            if (!Q()) {
                d.g().removeCallbacks(this.p);
                this.n = -1L;
                this.m = exc;
                this.f43419i.clear();
                for (d.a.h0.a.i2.u0.b<b> bVar : this.j) {
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
        return this.f43418h;
    }

    public boolean Q() {
        return this.n < 0;
    }

    public long R(long j) {
        long j2;
        synchronized (this.f43417g) {
            if (Y()) {
                this.n = Math.max(Math.max(j, d.a.h0.a.n1.b.a.H0), this.n);
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
        int i2 = z ? 111 : 11;
        if (q) {
            T("msgType", "service=" + z + " msgType=" + i2);
        }
        return i2;
    }

    public boolean V(i.a aVar) {
        boolean z;
        synchronized (this.f43417g) {
            z = (!Y() || this.f43419i.isEmpty() || aVar == null) ? false : true;
            if (z) {
                for (d.a.h0.a.i2.u0.b<i.a> bVar : this.f43419i) {
                    bVar.onCallback(aVar);
                }
            }
        }
        return z;
    }

    public final void W() {
        synchronized (this.f43417g) {
            this.f43417g.N(this, new TimeoutException("timeout"));
        }
    }

    public b X() {
        return this;
    }

    public boolean Y() {
        boolean z;
        synchronized (this.f43417g) {
            z = (Q() || O() || TextUtils.isEmpty(this.f43418h)) ? false : true;
            if (q) {
                T("valid", z + " isFinished=" + Q() + " hasException=" + this.m + " id=" + this.f43418h);
            }
        }
        return z;
    }

    @Override // d.a.h0.a.i2.u0.d
    public /* bridge */ /* synthetic */ d.a.h0.a.i2.u0.d a() {
        X();
        return this;
    }

    @Override // d.a.h0.a.y0.e.f.c
    public synchronized String toString() {
        return "IpcSession: id=" + this.f43418h + " timeout=" + this.n;
    }
}
