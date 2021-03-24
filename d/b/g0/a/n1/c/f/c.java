package d.b.g0.a.n1.c.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class c extends d.b.g0.a.n1.c.b {
    public static final boolean r = d.b.g0.a.n1.c.a.f45361b;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppProcessInfo f45390f;

    /* renamed from: g  reason: collision with root package name */
    public String f45391g;

    /* renamed from: h  reason: collision with root package name */
    public Messenger f45392h;
    public SwanAppCores i;
    public PrefetchEvent j;
    public boolean k;
    public long l;
    public long m;
    public boolean n;
    public ServiceConnectionC0746c o;
    public final Deque<Message> p;
    public b q;

    /* loaded from: classes3.dex */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: d.b.g0.a.n1.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ServiceConnectionC0746c implements ServiceConnection {
        public ServiceConnectionC0746c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.f45390f) {
                c.this.f45392h = new Messenger(iBinder);
                e j = e.j();
                j.l().a("event_puppet_online", c.this);
                if (c.r) {
                    j.t("on main bind to swan: " + c.this.f45390f);
                }
                c.this.f();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.K();
        }
    }

    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(new d.b.g0.a.r1.c());
        this.f45391g = "";
        this.f45392h = null;
        this.k = true;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
        this.p = new ArrayDeque();
        this.f45390f = swanAppProcessInfo;
    }

    public boolean A() {
        return System.currentTimeMillis() - this.l < ((long) d.b.g0.a.j1.m.c.a());
    }

    public boolean B() {
        return this.k;
    }

    public boolean C() {
        return this.n;
    }

    public boolean D() {
        return z();
    }

    public c E(String str) {
        if (!TextUtils.equals(str, this.f45391g)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.f45391g = str;
            e.j().l().a("event_puppet_load_app", this);
            this.k = true;
        } else {
            this.k = false;
        }
        return this;
    }

    public final void F(String str) {
        if (r) {
            Log.i("SwanClientPuppet", str);
        }
    }

    public void G() {
        this.l = System.currentTimeMillis();
    }

    public c H(Bundle bundle) {
        X(bundle);
        return this;
    }

    public c I(Bundle bundle) {
        S(null);
        X(bundle);
        return this;
    }

    public c J() {
        N();
        e.j().l().a("event_puppet_unload_app", this);
        return this;
    }

    public final void K() {
        synchronized (this.f45390f) {
            this.f45392h = null;
            this.o = null;
            M();
            e j = e.j();
            j.l().a("event_puppet_offline", this);
            if (r) {
                j.t("onSwanClientConnDown => " + this);
            }
            j.v();
        }
    }

    public c L() {
        this.n = true;
        this.m = 0L;
        b bVar = this.q;
        if (bVar != null) {
            bVar.a(this);
        }
        return this;
    }

    public c M() {
        synchronized (this.f45390f) {
            N();
            this.f45392h = null;
            this.i = null;
            S(null);
            O();
        }
        return this;
    }

    public c N() {
        this.f45391g = "";
        S(null);
        return this;
    }

    public c O() {
        this.n = false;
        this.m = 0L;
        S(null);
        return this;
    }

    public boolean P(Message message) {
        this.p.offer(message);
        f();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001d A[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:9:0x0011, B:14:0x0016, B:16:0x001d, B:17:0x0020), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Q(Message message) {
        synchronized (this.f45390f) {
            if (message != null) {
                if (D()) {
                    try {
                        this.f45392h.send(message);
                        return true;
                    } catch (RemoteException e2) {
                        e = e2;
                        K();
                        if (r) {
                            e.printStackTrace();
                        }
                        return false;
                    } catch (RuntimeException e3) {
                        e = e3;
                        K();
                        if (r) {
                        }
                        return false;
                    }
                }
            }
            return false;
        }
    }

    public boolean R(Collection<Message> collection) {
        for (Message message : collection) {
            this.p.offer(message);
        }
        f();
        return true;
    }

    public void S(PrefetchEvent prefetchEvent) {
        this.j = prefetchEvent;
    }

    public void T(b bVar) {
        this.q = bVar;
    }

    public c U() {
        V(false, null, null);
        return this;
    }

    public c V(boolean z, Context context, Bundle bundle) {
        if (r) {
            e j = e.j();
            j.t("b4 tryPreBind: " + this.f45390f);
        }
        if (context == null) {
            context = d.b.g0.a.w0.a.c();
        }
        Intent intent = new Intent(context, this.f45390f.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.m = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.f45390f) {
            try {
                if (this.o == null) {
                    ServiceConnectionC0746c serviceConnectionC0746c = new ServiceConnectionC0746c();
                    this.o = serviceConnectionC0746c;
                    context.bindService(intent, serviceConnectionC0746c, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            if (this.f45392h != null) {
                f();
            }
        }
        return this;
    }

    public c W(Context context, Bundle bundle) {
        if (r) {
            e j = e.j();
            j.t("b4 preload: " + this.f45390f);
        }
        V(true, context, bundle);
        return this;
    }

    public final c X(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        Z(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString(Constants.APP_ID);
        if (!TextUtils.isEmpty(string)) {
            E(string);
            e.j().f(string, this);
            d.b.g0.a.n1.c.a.e().d(string);
            O();
        }
        U();
        return this;
    }

    public c Y(long j) {
        if (j > 0) {
            e.j().l().a("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    public c Z(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.i = swanAppCores;
        }
        return this;
    }

    public c f() {
        F("flushCachedMsgs");
        synchronized (this.f45390f) {
            while (this.f45392h != null && !this.p.isEmpty()) {
                Message peek = this.p.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.j().f45399c;
                }
                if (!Q(peek)) {
                    break;
                }
                this.p.poll();
            }
        }
        return this;
    }

    public long g() {
        return System.currentTimeMillis() - this.l;
    }

    @Override // d.b.g0.a.r1.m, d.b.g0.a.r1.h
    public String getAppId() {
        return this.f45391g;
    }

    @Override // d.b.g0.a.r1.m, d.b.g0.a.r1.h
    public SwanAppCores k() {
        return this.i;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", this.f45390f.toString(), Integer.valueOf(D() ? 1 : 0), Integer.valueOf(this.n ? 1 : 0), SimpleDateFormat.getTimeInstance(2).format(new Date(this.m)), this.f45391g);
    }

    @Override // d.b.g0.a.r1.m, d.b.g0.a.r1.h
    public boolean x() {
        return !TextUtils.isEmpty(this.f45391g);
    }

    public SwanAppProcessInfo y() {
        return this.f45390f;
    }

    public boolean z() {
        boolean z;
        synchronized (this.f45390f) {
            z = this.f45392h != null;
        }
        return z;
    }
}
