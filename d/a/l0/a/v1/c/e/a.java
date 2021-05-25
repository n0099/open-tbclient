package d.a.l0.a.v1.c.e;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.xiaomi.mipush.sdk.Constants;
import d.a.l0.a.a1.e;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.l.g.h;
import d.a.l0.a.h0.p.a;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
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
public final class a extends d.a.l0.a.v1.c.b {
    public static final boolean l = k.f43199a;
    public static final long m = TimeUnit.MINUTES.toMillis(5);
    public static final Object n = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final e f45311f;

    /* renamed from: g  reason: collision with root package name */
    public IProcessBridge f45312g;

    /* renamed from: h  reason: collision with root package name */
    public d f45313h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f45314i;
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
            if (a.this.k() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                if (a.l) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(a.this.k()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                    return;
                }
                return;
            }
            a.this.f45312g = IProcessBridge.Stub.asInterface(iBinder);
            a aVar = a.this;
            aVar.N(13, aVar.D());
            if (a.this.f45313h != null) {
                a.this.f45313h.a();
            }
            d.a.l0.a.v1.c.a.e().c();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (a.l) {
                Log.d("SwanAppMessengerClient", "onServiceDisconnected");
            }
            a.this.I();
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
        public WeakReference<c> f45316a;

        /* renamed from: d.a.l0.a.v1.c.e.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0880a implements Runnable {
            public RunnableC0880a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
                Process.killProcess(Process.myPid());
            }
        }

        public e() {
            super(Looper.getMainLooper());
        }

        public final boolean a(Message message) {
            WeakReference<c> weakReference = this.f45316a;
            c cVar = weakReference != null ? weakReference.get() : null;
            if ((cVar == null || !cVar.a(message)) && !e(message)) {
                return d.a.l0.a.c1.a.h0().a(message);
            }
            return true;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull d.a.l0.a.a2.e eVar, d.a.l0.a.h0.o.j.a aVar) {
            SwanAppConfigData F = eVar.F();
            if (F == null) {
                if (a.l) {
                    Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                    return null;
                }
                return null;
            }
            String l1 = d.a.l0.a.f1.e.b.l1(prefetchEvent.schema, F);
            if (TextUtils.isEmpty(l1)) {
                if (aVar.f42508b) {
                    return F.f(aVar.f42509c);
                }
                return F.e();
            }
            return l1;
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
                d.a.l0.a.c2.f.i0.a.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e2) {
                if (a.l) {
                    e2.printStackTrace();
                }
            }
        }

        public final void d(Message message) {
            if (a.l) {
                Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
            }
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (Q != null) {
                if (!TextUtils.isEmpty(Q.L().V())) {
                    d.a.l0.a.h0.u.b.c(18);
                    return;
                } else if (Q.e()) {
                    if (!"update_tag_by_activity_on_create".equals(Q.Y())) {
                        if ("update_tag_by_activity_on_new_intent".equals(Q.Y())) {
                            d.a.l0.a.h0.u.b.c(17);
                            return;
                        } else {
                            d.a.l0.a.h0.u.b.c(6);
                            return;
                        }
                    }
                    d.a.l0.a.h0.u.b.c(16);
                    if (!a.C0694a.c()) {
                        return;
                    }
                }
            }
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                d.a.l0.a.h0.u.b.c(7);
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
            if (bundle2 == null) {
                d.a.l0.a.h0.u.b.c(8);
            } else if (g.N().c0()) {
                if (a.l) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                }
                d.a.l0.a.r1.k.i.a.k().n();
                d.a.l0.a.a2.d.g().m(bundle2, "update_tag_by_app_launch");
                d.a.l0.a.a2.e Q2 = d.a.l0.a.a2.e.Q();
                if (Q2 != null && d.a.l0.a.a1.e.M(Q2)) {
                    d.a.l0.a.h0.q.b.g().p(bundle2.getString("mAppId", null), false);
                    if (a.l) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                    }
                    f.V().R(Q2.l());
                    g.N().J0(Q2);
                    if (d.a.l0.a.h0.n.a.a.c()) {
                        d.a.l0.a.e0.d.g("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                        d.a.l0.a.y0.k.d.a();
                    }
                    if (a.l) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                        return;
                    }
                    return;
                }
                d.a.l0.a.h0.u.b.c(10);
            } else {
                d.a.l0.a.h0.u.b.c(9);
            }
        }

        public final boolean e(Message message) {
            d.a.l0.a.a2.e Q;
            if (h.b().a() == null || (Q = d.a.l0.a.a2.e.Q()) == null || Q.e()) {
                return false;
            }
            int i2 = message.what;
            if (i2 == 100) {
                if (a.l) {
                    Log.d("SwanAppMessengerClient", "get logout msg when in preload/prefetch status");
                }
                q(Q);
                d.a.l0.a.a2.d.g().t();
            } else if (i2 == 103) {
                if (a.l) {
                    Log.d("SwanAppMessengerClient", "get login msg when in preload/prefetch status");
                }
                Q.T().i();
                d.a.l0.a.n1.q.a.g().v();
                q(Q);
            } else if (i2 != 106) {
                return false;
            } else {
                if (a.l) {
                    Log.d("SwanAppMessengerClient", "get purge msg when in preload/prefetch status");
                }
                d.a.l0.a.a2.d.g().t();
            }
            return true;
        }

        public final void f(Message message) {
            Bundle bundle = (Bundle) message.obj;
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            d.a.l0.a.c2.f.g0.d b2 = d.a.l0.a.c2.f.g0.d.b();
            if (bundle == null || Q == null || b2 == null || !TextUtils.equals(bundle.getString("ai_apps_key", ""), Q.D())) {
                return;
            }
            b2.j();
        }

        public final void g(Message message) {
            if (a.l) {
                Log.i("SwanAppMessengerClient", "handleKillActivity");
            }
            if (d.a.l0.a.a2.d.g().C()) {
                d.a.l0.a.v2.f.j(d.a.l0.a.a2.d.g().x());
            }
        }

        public final void h() {
            d.a.l0.a.e0.d.h("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + d.a.l0.a.a2.d.g().C());
            if (d.a.l0.a.a2.d.g().C()) {
                d.a.l0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
                q0.X(new RunnableC0880a(this));
                return;
            }
            d.a.l0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
            Process.killProcess(Process.myPid());
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
                    g(message);
                    return;
                case 111:
                    if (message.obj instanceof Bundle) {
                        d.a.l0.a.a2.d.g().w("event_messenger_call_in", (Bundle) message.obj);
                        return;
                    }
                    return;
                case 112:
                case 113:
                case 123:
                case 124:
                case 125:
                case 127:
                case 128:
                case 129:
                default:
                    if (a(message)) {
                        return;
                    }
                    super.handleMessage(message);
                    return;
                case 114:
                    m(message);
                    return;
                case 115:
                    n(message);
                    return;
                case 116:
                    c(message);
                    return;
                case 117:
                    l(message);
                    return;
                case 118:
                    j(message);
                    return;
                case 119:
                    d.a.b0.d.a((Bundle) message.obj);
                    return;
                case 120:
                    i(message);
                    return;
                case 121:
                    k(message);
                    return;
                case 122:
                    d(message);
                    return;
                case 126:
                    d.a.l0.a.v1.c.d.a.d(message);
                    return;
                case IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER /* 130 */:
                    d.a.l0.a.h0.l.g.n.a.i().g((Bundle) message.obj);
                    return;
                case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
                    f(message);
                    return;
                case 132:
                    h();
                    return;
            }
        }

        public final void i(Message message) {
            long currentTimeMillis = a.l ? System.currentTimeMillis() : 0L;
            Bundle bundle = (Bundle) message.obj;
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
            if (prefetchEvent == null || !prefetchEvent.f()) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
            }
            boolean z = false;
            if (p(prefetchEvent, bundle)) {
                b.a aVar = new b.a();
                PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                if (pMSAppInfo == null) {
                    pMSAppInfo = d.a.l0.n.g.a.h().s(prefetchEvent.appId);
                }
                aVar.R0(pMSAppInfo);
                d.a.l0.a.a2.d.g().m(aVar.C(), "update_tag_by_prefetch");
                z = true;
            }
            d.a.l0.a.a2.e r = d.a.l0.a.a2.d.g().r();
            if (r == null) {
                return;
            }
            SwanPrefetchImageRes.b().d(prefetchEvent.appId);
            PMSAppInfo f0 = r.L().f0();
            if (f0 == null || f0.m()) {
                return;
            }
            if (TextUtils.equals(prefetchEvent.appId, f0.appId)) {
                d.a.l0.a.h0.o.j.a a2 = d.a.l0.a.h0.o.j.b.a(f0, d.a.l0.a.f1.e.b.m1(prefetchEvent.schema));
                if (a2 == null || !a2.a()) {
                    return;
                }
                File file = new File(a2.f42507a, "app.json");
                if ((r.F() == null || z) && !d.a.l0.a.a1.e.N(r, a2.f42507a)) {
                    if (a.l) {
                        Log.w("SwanAppMessengerClient", "can not find app config file");
                        return;
                    }
                    return;
                } else if (r.F() == null) {
                    return;
                } else {
                    prefetchEvent.appConfig = d.a.l0.a.a1.e.m(file);
                    prefetchEvent.appPath = e.C0561e.i(prefetchEvent.appId, String.valueOf(f0.versionCode)).getPath() + File.separator;
                    String b2 = b(prefetchEvent, r, a2);
                    prefetchEvent.pageUrl = b2;
                    prefetchEvent.rootPath = d.a.l0.a.h0.u.a.c(r, b2);
                    prefetchEvent.pageType = r.F().g(prefetchEvent.pageUrl);
                    prefetchEvent.sConsole = String.valueOf(d.a.l0.a.e0.c.c());
                    prefetchEvent.version = String.valueOf(f0.versionCode);
                    if (d.a.l0.a.h0.o.e.a.m() || TextUtils.equals(prefetchEvent.pageType, FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                        if (a.l) {
                            Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                        }
                        g.N().n0(prefetchEvent, f0);
                    } else if (a.l) {
                        Log.d("SwanAppMessengerClient", "not support sub pkg preload, page type - " + prefetchEvent.pageType);
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppMessengerClient", "prefetch cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }

        public final void j(Message message) {
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            d.a.l0.a.a2.d.g().m(bundle, null);
        }

        public final void k(Message message) {
            if (message == null || !TextUtils.isEmpty(d.a.l0.a.a2.d.g().getAppId())) {
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
            ExtensionCore M = g.N().M();
            if (a.l) {
                Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + M);
            }
            if (M == null || M.extensionCoreVersionCode >= j) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + M);
            }
            g.D0();
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion n;
            if (message == null || !TextUtils.isEmpty(d.a.l0.a.a2.d.g().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0 || (n = d.a.l0.a.c1.b.i().n()) == null) {
                return;
            }
            long j2 = n.swanCoreVersionCode;
            if (j2 == 0 || j2 >= j) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + n);
            }
            d.a.l0.a.c1.b.i().release();
        }

        public final void m(Message message) {
            if (message == null || !TextUtils.isEmpty(d.a.l0.a.a2.d.g().getAppId())) {
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
            if (j == 0 || g.N().V() == null) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + g.N().V());
            }
            g.D0();
        }

        public final void n(Message message) {
            Bundle bundle;
            d.a.b0.e.a aVar;
            if (message == null || (bundle = (Bundle) message.obj) == null || (aVar = d.a.l0.a.q1.a.b().f44171d) == null) {
                return;
            }
            aVar.onPayResult(d.a.l0.a.q1.a.a(bundle.getInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public void o(c cVar) {
            this.f45316a = new WeakReference<>(cVar);
        }

        public final boolean p(PrefetchEvent prefetchEvent, Bundle bundle) {
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (Q == null) {
                return true;
            }
            if (!Q.e() && TextUtils.isEmpty(Q.L().V())) {
                if (TextUtils.equals(Q.getAppId(), prefetchEvent.appId)) {
                    PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                    if (pMSAppInfo == null) {
                        return false;
                    }
                    PMSAppInfo f0 = Q.L().f0();
                    return f0 == null || f0.versionCode != pMSAppInfo.versionCode;
                }
                return true;
            }
            return false;
        }

        public final void q(d.a.l0.a.a2.e eVar) {
            d.a.l0.a.p.d.b a2 = eVar.y().a().a();
            if (a2 != null) {
                a2.a(AppRuntime.getAppContext());
            }
            d.a.l0.a.m.b j = eVar.j();
            j.h(j.c(AppRuntime.getAppContext()));
        }
    }

    public a(d.a.l0.a.a2.h hVar) {
        super(hVar);
        this.f45311f = new e();
        this.j = new ArrayDeque();
    }

    @Deprecated
    public static a E() {
        return d.a.l0.a.a2.d.g().z();
    }

    public final Bundle D() {
        Bundle bundle = new Bundle();
        bundle.putInt("process_id", SwanAppProcessInfo.current().index);
        bundle.putString(Constants.APP_ID, getAppId());
        bundle.putParcelable("app_core", n());
        return bundle;
    }

    public Handler F() {
        return this.f45311f;
    }

    public IProcessBridge G() {
        return this.f45312g;
    }

    public final void H(String str) {
        if (l) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.j.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public synchronized void I() {
        this.f45314i = null;
        this.f45312g = null;
        if (this.f45313h != null) {
            this.f45313h.b();
        }
        R();
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

    public void J(@NonNull Runnable runnable) {
        synchronized (n) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.k.add(runnable);
        }
    }

    @Deprecated
    public void K(@Nullable Bundle bundle, @NonNull Class<? extends d.a.l0.a.v1.a.a.a> cls) {
        L(bundle, cls, null);
    }

    @Deprecated
    public void L(@Nullable Bundle bundle, @NonNull Class<? extends d.a.l0.a.v1.a.a.a> cls, @Nullable d.a.l0.a.v1.a.b.c.c cVar) {
        if (l) {
            Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.arg1 = SwanAppProcessInfo.current().index;
        Bundle bundle2 = new Bundle();
        bundle2.putString("ai_apps_delegation_name", cls.getName());
        if (cVar != null) {
            bundle2.putString("ai_apps_observer_id", cVar.b());
            d.a.l0.a.v1.a.b.b.a.b().e(cVar);
        }
        if (bundle != null) {
            bundle2.putBundle("ai_apps_data", bundle);
        }
        bundle2.putString("ai_apps_id", getAppId());
        obtain.obj = bundle2;
        d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
        d.a.l0.a.v1.c.c cVar2 = new d.a.l0.a.v1.c.c(obtain);
        cVar2.p(true);
        e2.h(cVar2);
    }

    @Deprecated
    public void M(int i2) {
        P(i2, "");
    }

    public void N(int i2, Bundle bundle) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        Message obtain = Message.obtain(null, i2, bundle);
        obtain.arg1 = current.index;
        obtain.obj = bundle;
        d.a.l0.a.v1.c.a.e().h(new d.a.l0.a.v1.c.c(obtain));
    }

    @Deprecated
    public void O(int i2, SwanAppIPCData swanAppIPCData) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (l) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i2 + " ipcData: " + swanAppIPCData);
        }
        Message obtain = Message.obtain((Handler) null, i2);
        obtain.arg1 = current.index;
        Bundle bundle = new Bundle();
        if (swanAppIPCData != null) {
            bundle.putParcelable("ai_apps_data", swanAppIPCData);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        d.a.l0.a.v1.c.a.e().h(new d.a.l0.a.v1.c.c(obtain));
    }

    @Deprecated
    public void P(int i2, String str) {
        SwanAppProcessInfo current = SwanAppProcessInfo.current();
        if (l) {
            Log.d("SwanAppMessengerClient", "sendMessage msgType:" + i2 + " strData: " + str);
        }
        Message obtain = Message.obtain((Handler) null, i2);
        obtain.arg1 = current.index;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("ai_apps_data", str);
        }
        bundle.putString("ai_apps_id", getAppId());
        obtain.obj = bundle;
        d.a.l0.a.v1.c.a.e().h(new d.a.l0.a.v1.c.c(obtain));
    }

    public synchronized void Q() {
        if (l) {
            Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
        }
        if (this.f45314i == null) {
            this.f45314i = new b();
            Application b2 = d.a.l0.a.c1.a.b();
            try {
                b2.bindService(new Intent(b2, SwanAppMessengerService.class), this.f45314i, 1);
            } catch (Exception e2) {
                if (l) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void R() {
        synchronized (this.j) {
            if (j()) {
                this.j.offer(Long.valueOf(System.currentTimeMillis()));
                Q();
            }
        }
    }

    public void S() {
        M(2);
    }

    public void i(d dVar, c cVar) {
        this.f45313h = dVar;
        this.f45311f.o(cVar);
        N(1, D());
        if (this.f45313h == null || !k()) {
            return;
        }
        this.f45313h.a();
    }

    public final boolean j() {
        synchronized (this.j) {
            H("checkRebindable ===>");
            if (this.j.size() < 3) {
                H(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.j.size()), 3));
                return true;
            }
            int size = this.j.size() - 3;
            H("after offer purgeCount=" + size);
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    H("purge: " + this.j.poll());
                }
            }
            H("after purge");
            Long peek = this.j.peek();
            if (peek == null) {
                H("allowRebind by null oldestRecord is should not happen");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
            boolean z = currentTimeMillis > m;
            H("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
            return z;
        }
    }

    public boolean k() {
        return this.f45312g != null;
    }
}
