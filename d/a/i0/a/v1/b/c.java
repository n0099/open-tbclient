package d.a.i0.a.v1.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.i0.a.a2.h;
import d.a.i0.a.a2.i;
import d.a.i0.a.a2.m;
import d.a.i0.a.k;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class c extends m implements d.a.i0.a.v1.b.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45114h = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f45115f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, d.a.i0.a.v1.b.b> f45116g;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (c.f45114h) {
                c cVar = c.this;
                cVar.H("onEventCallback msg" + aVar);
            }
            c.this.J(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.v2.e1.b<i.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (c.f45114h) {
                c cVar = c.this;
                cVar.H("onEventCallback msg" + aVar);
            }
            c.this.K(aVar);
        }
    }

    /* renamed from: d.a.i0.a.v1.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0866c {

        /* renamed from: a  reason: collision with root package name */
        public static c f45119a = new c(d.a.i0.a.a2.d.g());
    }

    public c(h hVar) {
        super(hVar);
        this.f45115f = new HashMap<>();
        this.f45116g = new HashMap<>();
        if (f45114h) {
            H("SwanIpc");
        }
        d.a.i0.a.a2.b bVar = new d.a.i0.a.a2.b();
        bVar.e(new b(), "event_messenger_call_out");
        bVar.e(new a(), "event_messenger_call_in");
        v(bVar);
    }

    public static synchronized d.a.i0.a.v1.b.b E(@NonNull String str) {
        d.a.i0.a.v1.b.b S;
        synchronized (c.class) {
            S = F().S(str);
        }
        return S;
    }

    public static c F() {
        return C0866c.f45119a;
    }

    public static void G() {
        F();
    }

    public static synchronized d.a.i0.a.v1.b.b N(@NonNull Bundle bundle) {
        d.a.i0.a.v1.b.b Q;
        synchronized (c.class) {
            Q = F().Q(bundle);
        }
        return Q;
    }

    public static synchronized d.a.i0.a.v1.b.b O(@NonNull String str) {
        d.a.i0.a.v1.b.b R;
        synchronized (c.class) {
            R = F().R(str, null);
        }
        return R;
    }

    public static synchronized boolean f(@NonNull Bundle bundle, @NonNull String str) {
        boolean h2;
        synchronized (c.class) {
            h2 = F().h(N(bundle), str);
        }
        return h2;
    }

    public static synchronized boolean g(@NonNull String str, @NonNull String str2) {
        boolean h2;
        synchronized (c.class) {
            h2 = F().h(O(str), str2);
        }
        return h2;
    }

    public final void H(String str) {
        if (f45114h) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void I(String str, String str2) {
        H(str + ": " + str2);
    }

    public final void J(i.a aVar) {
        if (f45114h) {
            I("onCallIn", "msg=" + aVar);
        }
        if (aVar != null) {
            Bundle C = aVar.C();
            i.a aVar2 = new i.a("event_messenger_call", C);
            d.a.i0.a.v1.b.b N = N(C);
            if (e(N, C) && N.X(aVar2)) {
                return;
            }
            d.a.i0.a.a2.d.g().A(aVar2);
        }
    }

    public final void K(i.a aVar) {
        if (f45114h) {
            I("onCallOut", "msg=" + aVar);
        }
        if (aVar != null) {
            N(aVar.C()).L();
        }
    }

    public String L(@NonNull d.a.i0.a.v1.b.b bVar) {
        return M(bVar.R());
    }

    public String M(@NonNull String str) {
        return this.f45115f.get(str);
    }

    public c P(d.a.i0.a.v1.b.b bVar, Exception exc) {
        if (bVar != null) {
            synchronized (this.f45116g) {
                bVar.O(exc);
                this.f45116g.remove(bVar.R());
            }
        }
        return this;
    }

    public final synchronized d.a.i0.a.v1.b.b Q(Bundle bundle) {
        return R(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
    }

    public final synchronized d.a.i0.a.v1.b.b R(String str, Bundle bundle) {
        d.a.i0.a.v1.b.b bVar;
        bVar = TextUtils.isEmpty(str) ? null : this.f45116g.get(str);
        if (bVar == null || !bVar.Z()) {
            P(bVar, new IllegalStateException("invalid session"));
            bVar = new d.a.i0.a.v1.b.b(this, str);
            this.f45116g.put(bVar.R(), bVar);
        }
        boolean z = bundle != null && e(bVar, bundle);
        if (z) {
            int i2 = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
            if (SwanAppProcessInfo.checkProcessId(i2)) {
                bVar.I(i2);
            } else if (SwanAppProcessInfo.SERVICE.index == i2) {
                bVar.K(true);
            }
        }
        bVar.T(z ? bundle.getLong("ipc_session_timeout") : d.a.i0.a.v1.b.a.H0);
        if (f45114h) {
            I("session", "id=" + str + " session=" + bundle + " session=" + bVar);
        }
        return bVar;
    }

    public final synchronized d.a.i0.a.v1.b.b S(String str) {
        d.a.i0.a.v1.b.b Q;
        Q = Q(null);
        h(Q, str);
        if (f45114h) {
            I("topic", str + " session=" + Q);
        }
        return Q;
    }

    public final synchronized boolean e(@NonNull d.a.i0.a.v1.b.b bVar, @NonNull Bundle bundle) {
        boolean z;
        if (bVar.Z()) {
            z = h(bVar, bundle.getString("ipc_topic", ""));
        }
        return z;
    }

    public final synchronized boolean h(@NonNull d.a.i0.a.v1.b.b bVar, @NonNull String str) {
        boolean z = false;
        if (bVar.Z()) {
            String R = bVar.R();
            String str2 = this.f45115f.get(R);
            boolean z2 = !TextUtils.isEmpty(str2);
            z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
            if (z && !z2 && !TextUtils.isEmpty(str)) {
                this.f45115f.put(R, str);
            }
            return z;
        }
        return false;
    }
}
