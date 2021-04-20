package d.b.g0.a.n1.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.b.g0.a.k;
import d.b.g0.a.r1.d;
import d.b.g0.a.r1.h;
import d.b.g0.a.r1.i;
import d.b.g0.a.r1.m;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class c extends m implements d.b.g0.a.n1.b.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45748h = k.f45443a;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f45749f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, d.b.g0.a.n1.b.b> f45750g;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<i.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (c.f45748h) {
                c cVar = c.this;
                cVar.F("onEventCallback msg" + aVar);
            }
            c.this.H(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<i.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (c.f45748h) {
                c cVar = c.this;
                cVar.F("onEventCallback msg" + aVar);
            }
            c.this.I(aVar);
        }
    }

    /* renamed from: d.b.g0.a.n1.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0755c {

        /* renamed from: a  reason: collision with root package name */
        public static c f45753a = new c(d.e());
    }

    public c(h hVar) {
        super(hVar);
        this.f45749f = new HashMap<>();
        this.f45750g = new HashMap<>();
        if (f45748h) {
            F("SwanIpc");
        }
        d.b.g0.a.r1.b bVar = new d.b.g0.a.r1.b();
        bVar.e(new b(), "event_messenger_call_out");
        bVar.e(new a(), "event_messenger_call_in");
        i(bVar);
    }

    public static synchronized d.b.g0.a.n1.b.b C(@NonNull String str) {
        d.b.g0.a.n1.b.b Q;
        synchronized (c.class) {
            Q = D().Q(str);
        }
        return Q;
    }

    public static c D() {
        return C0755c.f45753a;
    }

    public static void E() {
        D();
    }

    public static synchronized d.b.g0.a.n1.b.b L(@NonNull Bundle bundle) {
        d.b.g0.a.n1.b.b O;
        synchronized (c.class) {
            O = D().O(bundle);
        }
        return O;
    }

    public static synchronized d.b.g0.a.n1.b.b M(@NonNull String str) {
        d.b.g0.a.n1.b.b P;
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
        if (f45748h) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void G(String str, String str2) {
        F(str + ": " + str2);
    }

    public final void H(i.a aVar) {
        if (f45748h) {
            G("onCallIn", "msg=" + aVar);
        }
        if (aVar != null) {
            Bundle A = aVar.A();
            i.a aVar2 = new i.a("event_messenger_call", A);
            d.b.g0.a.n1.b.b L = L(A);
            if (d(L, A) && L.V(aVar2)) {
                return;
            }
            d.e().t(aVar2);
        }
    }

    public final void I(i.a aVar) {
        if (f45748h) {
            G("onCallOut", "msg=" + aVar);
        }
        if (aVar != null) {
            L(aVar.A()).J();
        }
    }

    public String J(@NonNull d.b.g0.a.n1.b.b bVar) {
        return K(bVar.P());
    }

    public String K(@NonNull String str) {
        return this.f45749f.get(str);
    }

    public c N(d.b.g0.a.n1.b.b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.f45750g) {
                bVar.M(exc);
                this.f45750g.remove(bVar.P());
            }
        }
        return this;
    }

    public final synchronized d.b.g0.a.n1.b.b O(Bundle bundle) {
        return P(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    public final synchronized d.b.g0.a.n1.b.b P(String str, Bundle bundle) {
        d.b.g0.a.n1.b.b bVar;
        bVar = TextUtils.isEmpty(str) ? null : this.f45750g.get(str);
        if (bVar == null || !bVar.Y()) {
            N(bVar, new IllegalStateException("invalid session"));
            bVar = new d.b.g0.a.n1.b.b(this, str);
            this.f45750g.put(bVar.P(), bVar);
        }
        boolean z = bundle != null && d(bVar, bundle);
        if (z) {
            int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i)) {
                bVar.H(i);
            } else if (SwanAppProcessInfo.SERVICE.index == i) {
                bVar.I(true);
            }
        }
        bVar.R(z ? bundle.getLong("ipc_session_timeout") : d.b.g0.a.n1.b.a.H0);
        if (f45748h) {
            G("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        }
        return bVar;
    }

    public final synchronized d.b.g0.a.n1.b.b Q(String str) {
        d.b.g0.a.n1.b.b O;
        O = O(null);
        g(O, str);
        if (f45748h) {
            G("topic", str + " session=" + O);
        }
        return O;
    }

    public final synchronized boolean d(@NonNull d.b.g0.a.n1.b.b bVar, @NonNull Bundle bundle) {
        boolean z;
        if (bVar.Y()) {
            z = g(bVar, bundle.getString("ipc_topic", ""));
        }
        return z;
    }

    public final synchronized boolean g(@NonNull d.b.g0.a.n1.b.b bVar, @NonNull String str) {
        boolean z = false;
        if (bVar.Y()) {
            String P = bVar.P();
            String str2 = this.f45749f.get(P);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.f45749f.put(P, str);
            }
            return z;
        }
        return false;
    }
}
