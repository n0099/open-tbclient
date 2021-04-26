package d.a.h0.a.n1.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.a.r1.h;
import d.a.h0.a.r1.i;
import d.a.h0.a.r1.m;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class c extends m implements d.a.h0.a.n1.b.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f43421h = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f43422f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, d.a.h0.a.n1.b.b> f43423g;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<i.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (c.f43421h) {
                c cVar = c.this;
                cVar.F("onEventCallback msg" + aVar);
            }
            c.this.H(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<i.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (c.f43421h) {
                c cVar = c.this;
                cVar.F("onEventCallback msg" + aVar);
            }
            c.this.I(aVar);
        }
    }

    /* renamed from: d.a.h0.a.n1.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0714c {

        /* renamed from: a  reason: collision with root package name */
        public static c f43426a = new c(d.e());
    }

    public c(h hVar) {
        super(hVar);
        this.f43422f = new HashMap<>();
        this.f43423g = new HashMap<>();
        if (f43421h) {
            F("SwanIpc");
        }
        d.a.h0.a.r1.b bVar = new d.a.h0.a.r1.b();
        bVar.e(new b(), "event_messenger_call_out");
        bVar.e(new a(), "event_messenger_call_in");
        t(bVar);
    }

    public static synchronized d.a.h0.a.n1.b.b C(@NonNull String str) {
        d.a.h0.a.n1.b.b Q;
        synchronized (c.class) {
            Q = D().Q(str);
        }
        return Q;
    }

    public static c D() {
        return C0714c.f43426a;
    }

    public static void E() {
        D();
    }

    public static synchronized d.a.h0.a.n1.b.b L(@NonNull Bundle bundle) {
        d.a.h0.a.n1.b.b O;
        synchronized (c.class) {
            O = D().O(bundle);
        }
        return O;
    }

    public static synchronized d.a.h0.a.n1.b.b M(@NonNull String str) {
        d.a.h0.a.n1.b.b P;
        synchronized (c.class) {
            P = D().P(str, null);
        }
        return P;
    }

    public static synchronized boolean e(@NonNull Bundle bundle, @NonNull String str) {
        boolean g2;
        synchronized (c.class) {
            g2 = D().g(L(bundle), str);
        }
        return g2;
    }

    public static synchronized boolean f(@NonNull String str, @NonNull String str2) {
        boolean g2;
        synchronized (c.class) {
            g2 = D().g(M(str), str2);
        }
        return g2;
    }

    public final void F(String str) {
        if (f43421h) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void G(String str, String str2) {
        F(str + ": " + str2);
    }

    public final void H(i.a aVar) {
        if (f43421h) {
            G("onCallIn", "msg=" + aVar);
        }
        if (aVar != null) {
            Bundle A = aVar.A();
            i.a aVar2 = new i.a("event_messenger_call", A);
            d.a.h0.a.n1.b.b L = L(A);
            if (d(L, A) && L.V(aVar2)) {
                return;
            }
            d.e().y(aVar2);
        }
    }

    public final void I(i.a aVar) {
        if (f43421h) {
            G("onCallOut", "msg=" + aVar);
        }
        if (aVar != null) {
            L(aVar.A()).J();
        }
    }

    public String J(@NonNull d.a.h0.a.n1.b.b bVar) {
        return K(bVar.P());
    }

    public String K(@NonNull String str) {
        return this.f43422f.get(str);
    }

    public c N(d.a.h0.a.n1.b.b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.f43423g) {
                bVar.M(exc);
                this.f43423g.remove(bVar.P());
            }
        }
        return this;
    }

    public final synchronized d.a.h0.a.n1.b.b O(Bundle bundle) {
        return P(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    public final synchronized d.a.h0.a.n1.b.b P(String str, Bundle bundle) {
        d.a.h0.a.n1.b.b bVar;
        bVar = TextUtils.isEmpty(str) ? null : this.f43423g.get(str);
        if (bVar == null || !bVar.Y()) {
            N(bVar, new IllegalStateException("invalid session"));
            bVar = new d.a.h0.a.n1.b.b(this, str);
            this.f43423g.put(bVar.P(), bVar);
        }
        boolean z = bundle != null && d(bVar, bundle);
        if (z) {
            int i2 = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i2)) {
                bVar.H(i2);
            } else if (SwanAppProcessInfo.SERVICE.index == i2) {
                bVar.I(true);
            }
        }
        bVar.R(z ? bundle.getLong("ipc_session_timeout") : d.a.h0.a.n1.b.a.H0);
        if (f43421h) {
            G("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        }
        return bVar;
    }

    public final synchronized d.a.h0.a.n1.b.b Q(String str) {
        d.a.h0.a.n1.b.b O;
        O = O(null);
        g(O, str);
        if (f43421h) {
            G("topic", str + " session=" + O);
        }
        return O;
    }

    public final synchronized boolean d(@NonNull d.a.h0.a.n1.b.b bVar, @NonNull Bundle bundle) {
        boolean z;
        if (bVar.Y()) {
            z = g(bVar, bundle.getString("ipc_topic", ""));
        }
        return z;
    }

    public final synchronized boolean g(@NonNull d.a.h0.a.n1.b.b bVar, @NonNull String str) {
        boolean z = false;
        if (bVar.Y()) {
            String P = bVar.P();
            String str2 = this.f43422f.get(P);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.f43422f.put(P, str);
            }
            return z;
        }
        return false;
    }
}
