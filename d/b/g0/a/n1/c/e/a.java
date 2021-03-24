package d.b.g0.a.n1.c.e;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.k;
import d.b.g0.a.r1.h;
import d.b.g0.a.u0.d;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z0.f;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class a extends d.b.g0.a.n1.c.b {
    public static final boolean l = k.f45050a;
    public static final long m = TimeUnit.MINUTES.toMillis(5);
    public static final Object n = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final e f45374f;

    /* renamed from: g  reason: collision with root package name */
    public Messenger f45375g;

    /* renamed from: h  reason: collision with root package name */
    public d f45376h;
    public ServiceConnection i;
    public final Deque<Long> j;
    public List<Runnable> k;

    /* loaded from: classes3.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (a.l) {
                Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
            }
            if (a.this.A() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.l) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.A()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.f45375g = new Messenger(iBinder);
            a aVar = a.this;
            aVar.L(13, aVar.B());
            if (a.this.f45376h != null) {
                a.this.f45376h.a();
            }
            d.b.g0.a.n1.c.a.e().c();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.l) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.G();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f45378a;

        public e() {
            super(Looper.getMainLooper());
        }

        public final boolean a(Message message) {
            WeakReference<c> weakReference = this.f45378a;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar == null || !cVar.a(message)) {
                return d.b.g0.a.w0.a.V().a(message);
            }
            return true;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull d.b.g0.a.r1.e eVar) {
            SwanAppConfigData D = eVar.D();
            if (D == null) {
                if (a.l) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                    return null;
                }
                return null;
            }
            String f1 = d.b.g0.a.y0.e.b.f1(prefetchEvent.schema, D);
            return TextUtils.isEmpty(f1) ? D.e() : f1;
        }

        public final void c(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                return;
            }
            String string = bundle.getString("ai_apps_data");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                d.b.g0.a.t1.k.i0.a.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e2) {
                if (a.l) {
                    e2.printStackTrace();
                }
            }
        }

        public final void d(Message message) {
            Bundle bundle;
            if (a.l) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if ((O == null || !O.d()) && d.b.g0.a.e0.w.d.L().a0() && (bundle = (Bundle) message.obj) != null) {
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    return;
                }
                if (a.l) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                }
                d.b.g0.a.r1.d.e().j(bundle2, "update_tag_by_app_launch");
                d.b.g0.a.r1.e O2 = d.b.g0.a.r1.e.O();
                if (O2 == null || !d.b.g0.a.u0.d.w(O2)) {
                    return;
                }
                if (a.l) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                }
                f.V().R(O2.h());
                d.b.g0.a.e0.w.d.L().C0(O2);
                if (a.l) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                }
            }
        }

        public final void e(Message message) {
            if (a.l) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (d.b.g0.a.r1.d.e().x()) {
                d.b.g0.a.i2.e.i(d.b.g0.a.r1.d.e().n());
            }
        }

        public final void f(Message message) {
            PMSAppInfo c0;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent == null || !prefetchEvent.c()) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
            }
            if (m(prefetchEvent)) {
                b.a aVar = new b.a();
                PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                if (pMSAppInfo == null) {
                    pMSAppInfo = d.b.g0.l.i.a.h().r(prefetchEvent.appId);
                }
                aVar.K0(pMSAppInfo);
                d.b.g0.a.r1.d.e().j(aVar.A(), "update_tag_by_prefetch");
            }
            d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
            if (s == null || (c0 = s.J().c0()) == null) {
                return;
            }
            if (TextUtils.equals(prefetchEvent.appId, c0.appId)) {
                prefetchEvent.appPath = d.e.h(prefetchEvent.appId, String.valueOf(c0.versionCode)).getPath() + File.separator;
                prefetchEvent.appConfig = d.b.g0.a.u0.d.h(new File(prefetchEvent.appPath, "app.json"));
                if (s.D() == null) {
                    d.b.g0.a.u0.d.w(s);
                }
                prefetchEvent.pageUrl = b(prefetchEvent, s);
                if (a.l) {
                    Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                }
                d.b.g0.a.e0.w.d.L().h0(prefetchEvent.appId, PrefetchEvent.a(prefetchEvent, bundle));
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
            }
        }

        public final void g(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            d.b.g0.a.r1.d.e().j(bundle, null);
        }

        public final void h(Message message) {
            if (message == null || !TextUtils.isEmpty(d.b.g0.a.r1.d.e().getAppId())) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "start check extension version.");
            }
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0) {
                return;
            }
            ExtensionCore K = d.b.g0.a.e0.w.d.L().K();
            if (a.l) {
                Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + K);
            }
            if (K == null || K.extensionCoreVersionCode >= j) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + K);
            }
            d.b.g0.a.e0.w.d.w0();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.l) {
                Log.i("SwanAppMessengerClient", "handleMessage => " + message);
            }
            switch (message.what) {
                case 109:
                    return;
                case 110:
                    e(message);
                    return;
                case 111:
                    if (message.obj instanceof Bundle) {
                        d.b.g0.a.r1.d.e().l("event_messenger_call_in", (Bundle) message.obj);
                        return;
                    }
                    return;
                case 112:
                case 113:
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                case 125:
                default:
                    if (a(message)) {
                        return;
                    }
                    super.handleMessage(message);
                    return;
                case 114:
                    j(message);
                    return;
                case 115:
                    k(message);
                    return;
                case 116:
                    c(message);
                    return;
                case 117:
                    i(message);
                    return;
                case 118:
                    g(message);
                    return;
                case 119:
                    d.b.b0.d.a((Bundle) message.obj);
                    return;
                case 120:
                    f(message);
                    return;
                case Constants.METHOD_IM_FRIEND_GROUP_DROP /* 121 */:
                    h(message);
                    return;
                case 122:
                    d(message);
                    return;
                case 126:
                    d.b.g0.a.n1.c.d.a.d(message);
                    return;
            }
        }

        public final void i(Message message) {
            Bundle bundle;
            SwanCoreVersion s;
            if (message == null || !TextUtils.isEmpty(d.b.g0.a.r1.d.e().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0 || (s = d.b.g0.g.m.a.m().s()) == null) {
                return;
            }
            long j2 = s.swanCoreVersion;
            if (j2 == 0 || j2 >= j) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + s);
            }
            d.b.g0.g.m.a.C();
        }

        public final void j(Message message) {
            if (message == null || !TextUtils.isEmpty(d.b.g0.a.r1.d.e().getAppId())) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "start check swanCore version.");
            }
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0 || d.b.g0.a.e0.w.d.L().T() == null) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + d.b.g0.a.e0.w.d.L().T());
            }
            d.b.g0.a.e0.w.d.w0();
        }

        public final void k(Message message) {
            Bundle bundle;
            d.b.b0.e.a aVar;
            if (message == null || (bundle = (Bundle) message.obj) == null || (aVar = d.b.g0.a.i1.a.b().f44621d) == null) {
                return;
            }
            aVar.onPayResult(d.b.g0.a.i1.a.a(bundle.getInt("_wxapi_baseresp_errcode")), bundle.getString("_wxapi_baseresp_errstr"));
        }

        public void l(c cVar) {
            this.f45378a = new WeakReference<>(cVar);
        }

        public final boolean m(PrefetchEvent prefetchEvent) {
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (O == null) {
                return true;
            }
            return (O.d() || TextUtils.equals(O.getAppId(), prefetchEvent.appId)) ? false : true;
        }
    }

    public a(h hVar) {
        super(hVar);
        this.f45374f = new e();
        this.j = new ArrayDeque();
    }

    @Deprecated
    public static a C() {
        return d.b.g0.a.r1.d.e().q();
    }

    public boolean A() {
        return this.f45375g != null;
    }

    public final Bundle B() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString(com.xiaomi.mipush.sdk.Constants.APP_ID, getAppId());
        bundle.putParcelable("app_core", k());
        return bundle;
    }

    public Handler D() {
        return this.f45374f;
    }

    public Messenger E() {
        return this.f45375g;
    }

    public final void F(String str) {
        if (l) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.j.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public synchronized void G() {
        this.i = null;
        this.f45375g = null;
        if (this.f45376h != null) {
            this.f45376h.b();
        }
        P();
        if (this.k != null) {
            synchronized (n) {
                for (Runnable runnable : this.k) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.k.clear();
            }
        }
    }

    public void H(@NonNull Runnable runnable) {
        synchronized (n) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.k.add(runnable);
        }
    }

    @Deprecated
    public void I(@Nullable Bundle bundle, @NonNull Class<? extends d.b.g0.a.n1.a.a.a> cls) {
        J(bundle, cls, null);
    }

    @Deprecated
    public void J(@Nullable Bundle bundle, @NonNull Class<? extends d.b.g0.a.n1.a.a.a> cls, @Nullable d.b.g0.a.n1.a.b.c.c cVar) {
        if (l) {
            Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.arg1 = SwanAppProcessInfo.current().index;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.b());
            d.b.g0.a.n1.a.b.b.a.b().e(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
        d.b.g0.a.n1.c.c cVar2 = new d.b.g0.a.n1.c.c(obtain);
        cVar2.p(true);
        e2.h(cVar2);
    }

    @Deprecated
    public void K(int i) {
        N(i, "");
    }

    public void L(int i, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        d.b.g0.a.n1.c.a.e().h(new d.b.g0.a.n1.c.c(obtain));
    }

    @Deprecated
    public void M(int i, SwanAppIPCData swanAppIPCData) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (l) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i + " ipcData: " + swanAppIPCData);
        }
        Message obtain = Message.obtain((Handler) null, i);
        obtain.arg1 = current.index;
        Bundle bundle = new Bundle();
        if (swanAppIPCData != null) {
            bundle.putParcelable("ai_apps_data", swanAppIPCData);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        d.b.g0.a.n1.c.a.e().h(new d.b.g0.a.n1.c.c(obtain));
    }

    @Deprecated
    public void N(int i, String str) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (l) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i + " strData: " + str);
        }
        Message obtain = Message.obtain((Handler) null, i);
        obtain.arg1 = current.index;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("ai_apps_data", str);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        d.b.g0.a.n1.c.a.e().h(new d.b.g0.a.n1.c.c(obtain));
    }

    public synchronized void O() {
        if (l) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.i == null) {
            this.i = new b();
            Application c2 = d.b.g0.a.w0.a.c();
            try {
                c2.bindService(new Intent(c2, SwanAppMessengerService.class), this.i, 1);
            } catch (Exception e2) {
                if (l) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void P() {
        synchronized (this.j) {
            if (z()) {
                this.j.offer(Long.valueOf(System.currentTimeMillis()));
                O();
            }
        }
    }

    public void Q() {
        K(2);
    }

    public void y(d dVar, c cVar) {
        this.f45376h = dVar;
        this.f45374f.l(cVar);
        L(1, B());
        if (this.f45376h == null || !A()) {
            return;
        }
        this.f45376h.a();
    }

    public final boolean z() {
        synchronized (this.j) {
            F("checkRebindable ===>");
            if (this.j.size() < 3) {
                F(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.j.size()), 3));
                return true;
            }
            int size = this.j.size() - 3;
            F("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    F("purge: " + this.j.poll());
                }
            }
            F("after purge");
            Long peek = this.j.peek();
            if (peek == null) {
                F("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > m;
            F("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }
}
