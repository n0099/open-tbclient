package d.a.q0.a.v1.c.e;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a1.e;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.g1.f;
import d.a.q0.a.h0.l.g.h;
import d.a.q0.a.h0.p.a;
import d.a.q0.a.h0.u.g;
import d.a.q0.a.k;
import d.a.q0.a.v2.q0;
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
/* loaded from: classes8.dex */
public final class a extends d.a.q0.a.v1.c.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public static final long m;
    public static final Object n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final e f51239f;

    /* renamed from: g  reason: collision with root package name */
    public IProcessBridge f51240g;

    /* renamed from: h  reason: collision with root package name */
    public d f51241h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f51242i;
    public final Deque<Long> j;
    public List<Runnable> k;

    /* renamed from: d.a.q0.a.v1.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0998a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f51243e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51243e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (a.l) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (this.f51243e.k() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (a.l) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.f51243e.k()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                this.f51243e.f51240g = IProcessBridge.Stub.asInterface(iBinder);
                a aVar = this.f51243e;
                aVar.N(13, aVar.D());
                if (this.f51243e.f51241h != null) {
                    this.f51243e.f51241h.a();
                }
                d.a.q0.a.v1.c.a.e().c();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (a.l) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                this.f51243e.I();
            }
        }

        public /* synthetic */ b(a aVar, C0998a c0998a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f51244a;

        /* renamed from: d.a.q0.a.v1.c.e.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0999a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0999a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
                    Process.killProcess(Process.myPid());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e() {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public final boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                WeakReference<c> weakReference = this.f51244a;
                c cVar = weakReference != null ? weakReference.get() : null;
                if ((cVar == null || !cVar.a(message)) && !e(message)) {
                    return d.a.q0.a.c1.a.h0().a(message);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull d.a.q0.a.a2.e eVar, d.a.q0.a.h0.o.j.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, eVar, aVar)) == null) {
                SwanAppConfigData F = eVar.F();
                if (F == null) {
                    if (a.l) {
                        Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                        return null;
                    }
                    return null;
                }
                String l1 = d.a.q0.a.f1.e.b.l1(prefetchEvent.schema, F);
                if (TextUtils.isEmpty(l1)) {
                    if (aVar.f48442b) {
                        return F.f(aVar.f48443c);
                    }
                    return F.e();
                }
                return l1;
            }
            return (String) invokeLLL.objValue;
        }

        public final void c(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            String string = bundle.getString("ai_apps_data");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                d.a.q0.a.c2.f.i0.a.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e2) {
                if (a.l) {
                    e2.printStackTrace();
                }
            }
        }

        public final void d(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                if (a.l) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
                }
                d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
                if (Q != null) {
                    if (!TextUtils.isEmpty(Q.L().V())) {
                        d.a.q0.a.h0.u.b.c(18);
                        return;
                    } else if (Q.e()) {
                        if (!"update_tag_by_activity_on_create".equals(Q.Y())) {
                            if ("update_tag_by_activity_on_new_intent".equals(Q.Y())) {
                                d.a.q0.a.h0.u.b.c(17);
                                return;
                            } else {
                                d.a.q0.a.h0.u.b.c(6);
                                return;
                            }
                        }
                        d.a.q0.a.h0.u.b.c(16);
                        if (!a.C0813a.c()) {
                            return;
                        }
                    }
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    d.a.q0.a.h0.u.b.c(7);
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    d.a.q0.a.h0.u.b.c(8);
                } else if (g.N().c0()) {
                    if (a.l) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    d.a.q0.a.r1.k.i.a.k().n();
                    d.a.q0.a.a2.d.g().m(bundle2, "update_tag_by_app_launch");
                    d.a.q0.a.a2.e Q2 = d.a.q0.a.a2.e.Q();
                    if (Q2 != null && d.a.q0.a.a1.e.M(Q2)) {
                        d.a.q0.a.h0.q.b.g().p(bundle2.getString("mAppId", null), false);
                        if (a.l) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        f.V().R(Q2.l());
                        g.N().J0(Q2);
                        if (d.a.q0.a.h0.n.a.a.c()) {
                            d.a.q0.a.e0.d.g("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            d.a.q0.a.y0.k.d.a();
                        }
                        if (a.l) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                            return;
                        }
                        return;
                    }
                    d.a.q0.a.h0.u.b.c(10);
                } else {
                    d.a.q0.a.h0.u.b.c(9);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            d.a.q0.a.a2.e Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (h.b().a() == null || (Q = d.a.q0.a.a2.e.Q()) == null || Q.e()) {
                    return false;
                }
                int i2 = message.what;
                if (i2 == 100) {
                    if (a.l) {
                        Log.d("SwanAppMessengerClient", "get logout msg when in preload/prefetch status");
                    }
                    q(Q);
                    d.a.q0.a.a2.d.g().t();
                } else if (i2 == 103) {
                    if (a.l) {
                        Log.d("SwanAppMessengerClient", "get login msg when in preload/prefetch status");
                    }
                    Q.T().i();
                    d.a.q0.a.n1.q.a.g().v();
                    q(Q);
                } else if (i2 != 106) {
                    return false;
                } else {
                    if (a.l) {
                        Log.d("SwanAppMessengerClient", "get purge msg when in preload/prefetch status");
                    }
                    d.a.q0.a.a2.d.g().t();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
                d.a.q0.a.c2.f.g0.d b2 = d.a.q0.a.c2.f.g0.d.b();
                if (bundle == null || Q == null || b2 == null || !TextUtils.equals(bundle.getString("ai_apps_key", ""), Q.D())) {
                    return;
                }
                b2.j();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (a.l) {
                    Log.i("SwanAppMessengerClient", "handleKillActivity");
                }
                if (d.a.q0.a.a2.d.g().C()) {
                    d.a.q0.a.v2.f.j(d.a.q0.a.a2.d.g().x());
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                d.a.q0.a.e0.d.h("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + d.a.q0.a.a2.d.g().C());
                if (d.a.q0.a.a2.d.g().C()) {
                    d.a.q0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
                    q0.X(new RunnableC0999a(this));
                    return;
                }
                d.a.q0.a.e0.d.h("SwanAppMessengerClient", "Recovery kill self");
                Process.killProcess(Process.myPid());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
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
                            d.a.q0.a.a2.d.g().w("event_messenger_call_in", (Bundle) message.obj);
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
                        d.a.f0.d.a((Bundle) message.obj);
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
                        d.a.q0.a.v1.c.d.a.d(message);
                        return;
                    case IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER /* 130 */:
                        d.a.q0.a.h0.l.g.n.a.i().g((Bundle) message.obj);
                        return;
                    case IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER /* 131 */:
                        f(message);
                        return;
                    case 132:
                        h();
                        return;
                }
            }
        }

        public final void i(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
                long currentTimeMillis = a.l ? System.currentTimeMillis() : 0L;
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
                PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
                if (prefetchEvent == null || !prefetchEvent.isValid()) {
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
                        pMSAppInfo = d.a.q0.n.g.a.h().s(prefetchEvent.appId);
                    }
                    aVar.R0(pMSAppInfo);
                    d.a.q0.a.a2.d.g().m(aVar.C(), "update_tag_by_prefetch");
                    z = true;
                }
                d.a.q0.a.a2.e r = d.a.q0.a.a2.d.g().r();
                if (r == null) {
                    return;
                }
                SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                PMSAppInfo f0 = r.L().f0();
                if (f0 == null || f0.isMaxAgeExpires()) {
                    return;
                }
                if (TextUtils.equals(prefetchEvent.appId, f0.appId)) {
                    d.a.q0.a.h0.o.j.a a2 = d.a.q0.a.h0.o.j.b.a(f0, d.a.q0.a.f1.e.b.m1(prefetchEvent.schema));
                    if (a2 == null || !a2.a()) {
                        return;
                    }
                    File file = new File(a2.f48441a, "app.json");
                    if ((r.F() == null || z) && !d.a.q0.a.a1.e.N(r, a2.f48441a)) {
                        if (a.l) {
                            Log.w("SwanAppMessengerClient", "can not find app config file");
                            return;
                        }
                        return;
                    } else if (r.F() == null) {
                        return;
                    } else {
                        prefetchEvent.appConfig = d.a.q0.a.a1.e.m(file);
                        prefetchEvent.appPath = e.C0680e.i(prefetchEvent.appId, String.valueOf(f0.versionCode)).getPath() + File.separator;
                        String b2 = b(prefetchEvent, r, a2);
                        prefetchEvent.pageUrl = b2;
                        prefetchEvent.rootPath = d.a.q0.a.h0.u.a.c(r, b2);
                        prefetchEvent.pageType = r.F().g(prefetchEvent.pageUrl);
                        prefetchEvent.sConsole = String.valueOf(d.a.q0.a.e0.c.c());
                        prefetchEvent.version = String.valueOf(f0.versionCode);
                        if (d.a.q0.a.h0.o.e.a.m() || TextUtils.equals(prefetchEvent.pageType, FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
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
        }

        public final void j(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            d.a.q0.a.a2.d.g().m(bundle, null);
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(d.a.q0.a.a2.d.g().getAppId())) {
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
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, message) == null) || message == null || !TextUtils.isEmpty(d.a.q0.a.a2.d.g().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0 || (n = d.a.q0.a.c1.b.i().n()) == null) {
                return;
            }
            long j2 = n.swanCoreVersionCode;
            if (j2 == 0 || j2 >= j) {
                return;
            }
            if (a.l) {
                Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + n);
            }
            d.a.q0.a.c1.b.i().release();
        }

        public final void m(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(d.a.q0.a.a2.d.g().getAppId())) {
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
        }

        public final void n(Message message) {
            Bundle bundle;
            d.a.f0.e.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048590, this, message) == null) || message == null || (bundle = (Bundle) message.obj) == null || (aVar = d.a.q0.a.q1.a.b().f50099d) == null) {
                return;
            }
            aVar.onPayResult(d.a.q0.a.q1.a.a(bundle.getInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public void o(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) {
                this.f51244a = new WeakReference<>(cVar);
            }
        }

        public final boolean p(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, prefetchEvent, bundle)) == null) {
                d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
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
            return invokeLL.booleanValue;
        }

        public final void q(d.a.q0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
                d.a.q0.a.p.d.b a2 = eVar.y().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                d.a.q0.a.m.b j = eVar.j();
                j.h(j.c(AppRuntime.getAppContext()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394942155, "Ld/a/q0/a/v1/c/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1394942155, "Ld/a/q0/a/v1/c/e/a;");
                return;
            }
        }
        l = k.f49133a;
        m = TimeUnit.MINUTES.toMillis(5L);
        n = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.q0.a.a2.h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.a2.h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51239f = new e();
        this.j = new ArrayDeque();
    }

    @Deprecated
    public static a E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d.a.q0.a.a2.d.g().z() : (a) invokeV.objValue;
    }

    public final Bundle D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("process_id", SwanAppProcessInfo.current().index);
            bundle.putString("app_id", getAppId());
            bundle.putParcelable("app_core", n());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Handler F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51239f : (Handler) invokeV.objValue;
    }

    public IProcessBridge G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51240g : (IProcessBridge) invokeV.objValue;
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && l) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.j.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public synchronized void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.f51242i = null;
                this.f51240g = null;
                if (this.f51241h != null) {
                    this.f51241h.b();
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
        }
    }

    public void J(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            synchronized (n) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                this.k.add(runnable);
            }
        }
    }

    @Deprecated
    public void K(@Nullable Bundle bundle, @NonNull Class<? extends d.a.q0.a.v1.a.a.a> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, cls) == null) {
            L(bundle, cls, null);
        }
    }

    @Deprecated
    public void L(@Nullable Bundle bundle, @NonNull Class<? extends d.a.q0.a.v1.a.a.a> cls, @Nullable d.a.q0.a.v1.a.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, bundle, cls, cVar) == null) {
            if (l) {
                Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.arg1 = SwanAppProcessInfo.current().index;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (cVar != null) {
                bundle2.putString("ai_apps_observer_id", cVar.b());
                d.a.q0.a.v1.a.b.b.a.b().e(cVar);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            d.a.q0.a.v1.c.c cVar2 = new d.a.q0.a.v1.c.c(obtain);
            cVar2.p(true);
            e2.h(cVar2);
        }
    }

    @Deprecated
    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            P(i2, "");
        }
    }

    public void N(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, bundle) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            Message obtain = Message.obtain(null, i2, bundle);
            obtain.arg1 = current.index;
            obtain.obj = bundle;
            d.a.q0.a.v1.c.a.e().h(new d.a.q0.a.v1.c.c(obtain));
        }
    }

    @Deprecated
    public void O(int i2, SwanAppIPCData swanAppIPCData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, swanAppIPCData) == null) {
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
            d.a.q0.a.v1.c.a.e().h(new d.a.q0.a.v1.c.c(obtain));
        }
    }

    @Deprecated
    public void P(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
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
            d.a.q0.a.v1.c.a.e().h(new d.a.q0.a.v1.c.c(obtain));
        }
    }

    public synchronized void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (l) {
                    Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
                }
                if (this.f51242i == null) {
                    this.f51242i = new b(this, null);
                    Application b2 = d.a.q0.a.c1.a.b();
                    try {
                        b2.bindService(new Intent(b2, SwanAppMessengerService.class), this.f51242i, 1);
                    } catch (Exception e2) {
                        if (l) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.j) {
                if (j()) {
                    this.j.offer(Long.valueOf(System.currentTimeMillis()));
                    Q();
                }
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            M(2);
        }
    }

    public void i(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, dVar, cVar) == null) {
            this.f51241h = dVar;
            this.f51239f.o(cVar);
            N(1, D());
            if (this.f51241h == null || !k()) {
                return;
            }
            this.f51241h.a();
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f51240g != null : invokeV.booleanValue;
    }
}
