package d.a.m0.a.v1.c.f;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.xiaomi.mipush.sdk.Constants;
import d.a.m0.a.a2.i;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c extends d.a.m0.a.v1.c.b implements Object {
    public static final boolean r = d.a.m0.a.v1.c.a.f49080b;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppProcessInfo f49113f;

    /* renamed from: g  reason: collision with root package name */
    public String f49114g;

    /* renamed from: h  reason: collision with root package name */
    public Messenger f49115h;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppCores f49116i;
    public PrefetchEvent j;
    public boolean k;
    public long l;
    public boolean m;
    public ServiceConnectionC0941c n;
    public final Deque<Message> o;
    public b p;
    public final Set<String> q;

    /* loaded from: classes3.dex */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: d.a.m0.a.v1.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ServiceConnectionC0941c implements ServiceConnection {
        public ServiceConnectionC0941c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.f49113f) {
                c.this.f49115h = new Messenger(iBinder);
                e k = e.k();
                k.m().a("event_puppet_online", c.this);
                if (c.r) {
                    k.u("on main bind to swan: " + c.this.f49113f);
                }
                c.this.h();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.O();
        }
    }

    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(d.a.m0.a.a2.d.g());
        this.f49114g = "";
        this.f49115h = null;
        this.k = true;
        this.l = 0L;
        this.m = false;
        this.o = new ArrayDeque();
        this.q = d.a.m0.a.v2.z0.a.a(new String[0]);
        this.f49113f = swanAppProcessInfo;
        d.a.m0.a.a2.b bVar = new d.a.m0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
    }

    @Override // d.a.m0.a.a2.m, d.a.m0.a.a2.h
    public boolean C() {
        return !TextUtils.isEmpty(this.f49114g);
    }

    public boolean D() {
        boolean z;
        synchronized (this.f49113f) {
            z = this.f49115h != null;
        }
        return z;
    }

    public boolean E() {
        return this.j != null;
    }

    public boolean F() {
        return this.k;
    }

    public boolean G() {
        return this.m;
    }

    public boolean H() {
        return D();
    }

    public c I(String str) {
        if (!TextUtils.equals(str, this.f49114g)) {
            if (TextUtils.isEmpty(str)) {
                str = "swan_id_unknown";
            }
            this.f49114g = str;
            e.k().m().a("event_puppet_load_app", this);
            this.k = true;
        } else {
            this.k = false;
        }
        return this;
    }

    public final void J(String str) {
        if (r) {
            Log.i("SwanClientPuppet", str);
        }
    }

    public c K(Bundle bundle) {
        c0(bundle);
        return this;
    }

    public c L(Bundle bundle) {
        X(null);
        g();
        c0(bundle);
        return this;
    }

    public c M() {
        R();
        e.k().m().a("event_puppet_unload_app", this);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: N */
    public void onCallback(i.a aVar) {
        String[] p;
        if (d.a.m0.a.v1.b.c.f(aVar.C(), "swan_multi_preload_on_server") && aVar.i("swan_multi_preload_app_process_index") == this.f49113f.index && (p = aVar.p("swan_multi_preload_app_ids")) != null) {
            synchronized (this.q) {
                this.q.clear();
                for (String str : p) {
                    if (!TextUtils.isEmpty(str)) {
                        this.q.add(str);
                    }
                }
                if (r) {
                    Log.d("SwanClientPuppet", "get all in prefetch ids - " + this.q);
                }
            }
        }
    }

    public final void O() {
        synchronized (this.f49113f) {
            this.f49115h = null;
            this.n = null;
            Q();
            e k = e.k();
            k.m().a("event_puppet_offline", this);
            if (r) {
                k.u("onSwanClientConnDown => " + this);
            }
            k.w();
        }
    }

    public c P() {
        this.m = true;
        this.l = 0L;
        b bVar = this.p;
        if (bVar != null) {
            bVar.a(this);
        }
        return this;
    }

    public c Q() {
        synchronized (this.f49113f) {
            R();
            this.f49115h = null;
            this.f49116i = null;
            X(null);
            g();
            S();
        }
        return this;
    }

    public c R() {
        this.f49114g = "";
        X(null);
        g();
        return this;
    }

    public c S() {
        this.m = false;
        this.l = 0L;
        X(null);
        g();
        return this;
    }

    public void T(@NonNull Message message) {
        try {
            Application b2 = d.a.m0.a.c1.a.b();
            Intent intent = new Intent(b2, this.f49113f.service);
            intent.setAction(SwanAppLocalService.ACTION_RECEIVER_MSG);
            intent.putExtra("data", message);
            b2.startService(intent);
        } catch (Throwable th) {
            d.a.m0.a.e0.d.c("SwanClientPuppet", "sendMessageToClientService fail", th);
        }
    }

    public boolean U(Message message) {
        this.o.offer(message);
        h();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001d A[Catch: all -> 0x0023, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:9:0x0011, B:14:0x0016, B:16:0x001d, B:17:0x0020), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean V(Message message) {
        synchronized (this.f49113f) {
            if (message != null) {
                if (H()) {
                    try {
                        this.f49115h.send(message);
                        return true;
                    } catch (RemoteException e2) {
                        e = e2;
                        O();
                        if (r) {
                            e.printStackTrace();
                        }
                        return false;
                    } catch (RuntimeException e3) {
                        e = e3;
                        O();
                        if (r) {
                        }
                        return false;
                    }
                }
            }
            return false;
        }
    }

    public boolean W(Collection<Message> collection) {
        for (Message message : collection) {
            this.o.offer(message);
        }
        h();
        return true;
    }

    public void X(PrefetchEvent prefetchEvent) {
        this.j = prefetchEvent;
    }

    public void Y(b bVar) {
        this.p = bVar;
    }

    public c Z() {
        a0(false, null, null);
        return this;
    }

    public c a0(boolean z, Context context, Bundle bundle) {
        if (r) {
            e k = e.k();
            k.u("b4 tryPreBind: " + this.f49113f);
        }
        if (context == null) {
            context = d.a.m0.a.c1.a.b();
        }
        Intent intent = new Intent(context, this.f49113f.service);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.l = System.currentTimeMillis();
        intent.putExtra("call_preload_time", System.currentTimeMillis());
        intent.putExtra("bundle_key_main_pid", Process.myPid());
        intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
        intent.addCategory("android.intent.category.DEFAULT");
        synchronized (this.f49113f) {
            try {
                if (this.n == null) {
                    ServiceConnectionC0941c serviceConnectionC0941c = new ServiceConnectionC0941c();
                    this.n = serviceConnectionC0941c;
                    context.bindService(intent, serviceConnectionC0941c, 1);
                } else if (z) {
                    context.startService(intent);
                }
            } catch (Exception e2) {
                if (r) {
                    e2.printStackTrace();
                }
            }
            if (this.f49115h != null) {
                h();
            }
        }
        return this;
    }

    public c b0(Context context, Bundle bundle) {
        if (r) {
            e k = e.k();
            k.u("b4 preload: " + this.f49113f);
        }
        a0(true, context, bundle);
        return this;
    }

    public final c c0(Bundle bundle) {
        Parcelable parcelable = bundle.getParcelable("app_core");
        e0(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
        String string = bundle.getString(Constants.APP_ID);
        if (!TextUtils.isEmpty(string)) {
            I(string);
            e.k().g(string, this);
            d.a.m0.a.v1.c.a.e().d(string);
            S();
        }
        Z();
        return this;
    }

    public c d0(long j) {
        if (j > 0) {
            e.k().m().a("event_puppet_fmp_launch_finish", this);
        }
        return this;
    }

    public c e0(SwanAppCores swanAppCores) {
        if (swanAppCores != null) {
            this.f49116i = swanAppCores;
        }
        return this;
    }

    public final void g() {
        synchronized (this.q) {
            this.q.clear();
            if (r) {
                Log.d("SwanClientPuppet", "clear all prefetch ids");
            }
        }
    }

    @Override // d.a.m0.a.a2.m, d.a.m0.a.a2.h
    public String getAppId() {
        return this.f49114g;
    }

    public c h() {
        J("flushCachedMsgs");
        synchronized (this.f49113f) {
            while (this.f49115h != null && !this.o.isEmpty()) {
                Message peek = this.o.peek();
                if (peek.replyTo == null) {
                    peek.replyTo = e.k().f49124d;
                }
                if (!V(peek)) {
                    break;
                }
                this.o.poll();
            }
        }
        return this;
    }

    public Set<String> i() {
        HashSet hashSet;
        synchronized (this.q) {
            hashSet = new HashSet(this.q);
            if (this.j != null && !TextUtils.isEmpty(this.j.appId)) {
                hashSet.add(this.j.appId);
            }
        }
        return hashSet;
    }

    public String j() {
        PrefetchEvent prefetchEvent = this.j;
        return prefetchEvent != null ? prefetchEvent.appId : "";
    }

    public SwanAppProcessInfo k() {
        return this.f49113f;
    }

    @Override // d.a.m0.a.a2.m, d.a.m0.a.a2.h
    public SwanAppCores n() {
        return this.f49116i;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", this.f49113f.toString(), Integer.valueOf(H() ? 1 : 0), Integer.valueOf(this.m ? 1 : 0), SimpleDateFormat.getTimeInstance(2).format(new Date(this.l)), this.f49114g);
    }
}
