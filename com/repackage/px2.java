package com.repackage;

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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppIPCData;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.wallet.YYPayManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b62;
import com.repackage.qj2;
import com.repackage.rb4;
import com.repackage.rl2;
import com.repackage.y52;
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
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class px2 extends lx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static final long i;
    public static final Object j;
    public transient /* synthetic */ FieldHolder $fh;
    public final e b;
    public IProcessBridge c;
    public d d;
    public ServiceConnection e;
    public final Deque<Long> f;
    public List<Runnable> g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px2 a;

        public b(px2 px2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = px2Var;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                if (px2.h) {
                    Log.i("SwanAppMessengerClient", String.format("onServiceConnected: name(%s) service(%s)", componentName, iBinder));
                }
                if (this.a.N() || !SwanAppProcessInfo.current().isSwanAppProcess()) {
                    if (px2.h) {
                        Log.i("SwanAppMessengerClient", String.format("onServiceConnected: return by connected(%b) isSwanAppProcess(%s)", Boolean.valueOf(this.a.N()), Boolean.valueOf(SwanAppProcessInfo.current().isSwanAppProcess())));
                        return;
                    }
                    return;
                }
                this.a.c = IProcessBridge.Stub.asInterface(iBinder);
                px2 px2Var = this.a;
                px2Var.Y(13, px2Var.O());
                if (this.a.d != null) {
                    this.a.d.a();
                }
                kx2.e().c();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (px2.h) {
                    Log.d("SwanAppMessengerClient", "onServiceDisconnected");
                }
                this.a.T();
            }
        }

        public /* synthetic */ b(px2 px2Var, a aVar) {
            this(px2Var);
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public static class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<c> a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ux1.k("SwanAppMessengerClient", "Recovery kill self");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                WeakReference<c> weakReference = this.a;
                c cVar = weakReference != null ? weakReference.get() : null;
                if ((cVar == null || !cVar.a(message)) && !e(message)) {
                    return bk2.q0().a(message);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final String b(PrefetchEvent prefetchEvent, @NonNull u03 u03Var, z52 z52Var) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, u03Var, z52Var)) == null) {
                SwanAppConfigData P = u03Var.P();
                if (P == null) {
                    if (px2.h) {
                        Log.w("SwanAppMessengerClient", "getPrefectPageUrl - configData is null ");
                        return null;
                    }
                    return null;
                }
                String n1 = rl2.n1(prefetchEvent.schema, P);
                if (TextUtils.isEmpty(n1)) {
                    if (z52Var.b) {
                        return P.g(z52Var.c);
                    }
                    return P.f();
                }
                return n1;
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
                k33.d().b(Intent.parseUri(string, 0));
            } catch (URISyntaxException e) {
                if (px2.h) {
                    e.printStackTrace();
                }
            }
        }

        public final void d(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
                if (px2.h) {
                    Log.d("AppLaunchMessenger", "handleAppOnLaunch msg start.");
                }
                p72.e();
                u03 a0 = u03.a0();
                if (a0 != null) {
                    if (!TextUtils.isEmpty(a0.V().V())) {
                        j72.c(18);
                        return;
                    } else if (a0.H()) {
                        if (!"update_tag_by_activity_on_create".equals(a0.i0())) {
                            if ("update_tag_by_activity_on_new_intent".equals(a0.i0())) {
                                j72.c(17);
                                return;
                            } else {
                                j72.c(6);
                                return;
                            }
                        }
                        j72.c(16);
                        if (!b62.a.c()) {
                            return;
                        }
                    }
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    j72.c(7);
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                Bundle bundle2 = bundle.getBundle("swan_app_on_launch_event");
                if (bundle2 == null) {
                    j72.c(8);
                } else if (o72.U().m0()) {
                    if (px2.h) {
                        Log.d("AppLaunchMessenger", "handleAppOnLaunch get bundle.");
                    }
                    mu2.j().m();
                    t03.J().m(bundle2, "update_tag_by_app_launch");
                    u03 a02 = u03.a0();
                    if (a02 != null && qj2.O(a02)) {
                        Set<rb4.a> i = bw2.i(a02.V().f0());
                        a02.L0(i);
                        if (i != null && !i.isEmpty()) {
                            j72.c(19);
                            return;
                        }
                        e62.k().x(bundle2.getString("mAppId", null), false);
                        if (px2.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch swan app updated.");
                        }
                        hm2.U().Q(a02.l());
                        o72.U().W0(a02);
                        if (p42.a() && p42.c()) {
                            ux1.i("SwanAppMessengerClient", "handleAppOnLaunch: init cache video ");
                            bi2.a();
                        }
                        if (px2.h) {
                            Log.d("AppLaunchMessenger", "handleAppOnLaunch msg end");
                            return;
                        }
                        return;
                    }
                    j72.c(10);
                } else {
                    j72.c(9);
                    o72.U().H0(null);
                }
            }
        }

        public final boolean e(Message message) {
            InterceptResult invokeL;
            u03 a0;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
                if (d32.b().a() == null || (a0 = u03.a0()) == null || a0.H()) {
                    return false;
                }
                int i = message.what;
                if (i == 100) {
                    if (px2.h) {
                        Log.d("SwanAppMessengerClient", "get logout msg when in preload/prefetch status");
                    }
                    r(a0);
                    t03.J().t();
                } else if (i == 103) {
                    if (px2.h) {
                        Log.d("SwanAppMessengerClient", "get login msg when in preload/prefetch status");
                    }
                    a0.d0().i();
                    qs2.g().v();
                    r(a0);
                } else if (i != 106) {
                    return false;
                } else {
                    if (px2.h) {
                        Log.d("SwanAppMessengerClient", "get purge msg when in preload/prefetch status");
                    }
                    t03.J().t();
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void f(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
                Bundle bundle = (Bundle) message.obj;
                u03 a0 = u03.a0();
                h33 b = h33.b();
                if (bundle == null || a0 == null || b == null || !TextUtils.equals(bundle.getString("ai_apps_key", ""), a0.N())) {
                    return;
                }
                b.j();
            }
        }

        public final void g(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, message) == null) {
                if (px2.h) {
                    Log.i("SwanAppMessengerClient", "handleKillActivity");
                }
                if (t03.J().D()) {
                    dd3.j(t03.J().x());
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                ux1.k("SwanAppMessengerClient", "Recovery killProcess hasAppOccupied: " + t03.J().D());
                if (t03.J().D()) {
                    t03.J().o("flag_finish_activity", "flag_remove_task");
                    oe3.a0(new a(this));
                    return;
                }
                ux1.k("SwanAppMessengerClient", "Recovery kill self");
                Process.killProcess(Process.myPid());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
                if (px2.h) {
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
                            t03.J().w("event_messenger_call_in", (Bundle) message.obj);
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
                        q71.a((Bundle) message.obj);
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
                        nx2.d(message);
                        return;
                    case 130:
                        j32.i().g((Bundle) message.obj);
                        return;
                    case 131:
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
                long currentTimeMillis = px2.h ? System.currentTimeMillis() : 0L;
                String uuid = UUID.randomUUID().toString();
                x52 d = x52.d();
                d.g(uuid);
                d.b(uuid, new UbcFlowEvent("prefetch_start"));
                d.j(uuid, 3000L);
                Bundle bundle = (Bundle) message.obj;
                bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
                PrefetchEvent prefetchEvent = (PrefetchEvent) bundle.getParcelable("swan_app_bundle_prefetch");
                if (prefetchEvent == null || !prefetchEvent.isValid()) {
                    return;
                }
                x52 d2 = x52.d();
                y52.b a2 = y52.a();
                a2.h(RecordType.APP_ID);
                a2.f(prefetchEvent.appId);
                d2.f(uuid, a2.e());
                ux1.k("SwanAppMessengerClient", "get prefetch event");
                if (px2.h) {
                    Log.d("SwanAppMessengerClient", "PrefetchMessage execCall event: " + prefetchEvent);
                }
                boolean z = false;
                if (q(prefetchEvent, bundle)) {
                    x52.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_start"));
                    rl2.a aVar = new rl2.a();
                    PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                    if (pMSAppInfo == null) {
                        pMSAppInfo = p84.i().u(prefetchEvent.appId);
                    }
                    aVar.S0(pMSAppInfo);
                    t03.J().m(aVar.D(), "update_tag_by_prefetch");
                    ux1.k("SwanAppMessengerClient", "shouldUpdateForPrefetch for current Preload");
                    x52.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_app_end"));
                    z = true;
                }
                u03 r = t03.J().r();
                if (r == null) {
                    return;
                }
                SwanPrefetchImageRes.b().d(prefetchEvent.appId);
                if (vu2.e()) {
                    ss2.g(true);
                }
                PMSAppInfo f0 = r.V().f0();
                if (f0 != null && !f0.isMaxAgeExpires()) {
                    t42.g().c(prefetchEvent);
                    if (TextUtils.equals(prefetchEvent.appId, f0.appId)) {
                        o(uuid, r, f0);
                        x52.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start"));
                        z52 a3 = a62.a(f0, rl2.o1(prefetchEvent.schema));
                        if (a3 != null && a3.a()) {
                            File file = new File(a3.a, "app.json");
                            if ((r.P() == null || z) && !qj2.P(r, a3.a)) {
                                ux1.k("SwanAppMessengerClient", "updateSwanAppConfig failed");
                                if (px2.h) {
                                    Log.w("SwanAppMessengerClient", "can not find app config file");
                                    return;
                                }
                                return;
                            } else if (r.P() == null) {
                                ux1.k("SwanAppMessengerClient", "swanApp.getConfig() == null");
                                return;
                            } else {
                                x52.d().b(uuid, new UbcFlowEvent("prefetch_update_swan_config_start_end"));
                                prefetchEvent.appConfig = qj2.m(file);
                                prefetchEvent.appPath = qj2.e.i(prefetchEvent.appId, String.valueOf(f0.versionCode)).getPath() + File.separator;
                                String b = b(prefetchEvent, r, a3);
                                prefetchEvent.pageUrl = b;
                                prefetchEvent.rootPath = i72.c(r, b);
                                prefetchEvent.pageType = r.P().h(prefetchEvent.pageUrl);
                                prefetchEvent.sConsole = String.valueOf(tx1.c());
                                prefetchEvent.version = String.valueOf(f0.versionCode);
                                if (!TextUtils.isEmpty(f0.userActionApis)) {
                                    prefetchEvent.userActionApis = String.valueOf(f0.userActionApis);
                                }
                                q52.c(prefetchEvent);
                                if (u42.p() || TextUtils.equals(prefetchEvent.pageType, "main")) {
                                    if (px2.h) {
                                        Log.d("SwanAppMessengerClient", "PrefetchEvent - " + prefetchEvent.toString());
                                    }
                                    o72.U().x0(uuid, prefetchEvent, f0);
                                } else {
                                    ux1.k("SwanAppMessengerClient", "not support sub pkg preload, page type - " + prefetchEvent.pageType);
                                    return;
                                }
                            }
                        } else {
                            ux1.k("SwanAppMessengerClient", "can not find app.json anywhere");
                            return;
                        }
                    }
                    if (px2.h) {
                        Log.d("SwanAppMessengerClient", "PrefetchMessage send event end.");
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Log.d("SwanAppMessengerClient", "prefetch cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        return;
                    }
                    return;
                }
                ux1.k("SwanAppMessengerClient", "appInfo==null or appInfo isMaxAgeExpires");
            }
        }

        public final void j(Message message) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, message) == null) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(PMSAppInfo.class.getClassLoader());
            t03.J().m(bundle, null);
        }

        public final void k(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, message) == null) && message != null && TextUtils.isEmpty(t03.J().getAppId())) {
                if (px2.h) {
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
                ExtensionCore T = o72.U().T();
                if (px2.h) {
                    Log.d("SwanAppMessengerClient", "handleUpdateExtensionCoreVersion: remoteVersion : " + j + " curVersion : " + T);
                }
                if (T == null || T.extensionCoreVersionCode >= j) {
                    return;
                }
                if (px2.h) {
                    Log.d("SwanAppMessengerClient", "start reCreate cause lower extension version, remoteVersion : " + j + " curVersion : " + T);
                }
                o72.Q0();
            }
        }

        public final void l(Message message) {
            Bundle bundle;
            SwanCoreVersion n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, message) == null) || message == null || !TextUtils.isEmpty(t03.J().getAppId()) || (bundle = (Bundle) message.obj) == null) {
                return;
            }
            bundle.setClassLoader(e.class.getClassLoader());
            long j = bundle.getLong("ai_apps_data");
            if (j == 0 || (n = ck2.i().n()) == null) {
                return;
            }
            long j2 = n.swanCoreVersionCode;
            if (j2 == 0 || j2 >= j) {
                return;
            }
            if (px2.h) {
                Log.d("SwanAppMessengerClient", "SwanGameCoreRuntime gameCoreUpdate, remoteVersion : " + j + " coreRuntimeVersion : " + n);
            }
            ck2.i().release();
        }

        public final void m(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, message) == null) && message != null && TextUtils.isEmpty(t03.J().getAppId())) {
                if (px2.h) {
                    Log.d("SwanAppMessengerClient", "start check swanCore version.");
                }
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return;
                }
                bundle.setClassLoader(e.class.getClassLoader());
                long j = bundle.getLong("ai_apps_data");
                if (j == 0 || o72.U().d0() == null) {
                    return;
                }
                if (px2.h) {
                    Log.d("SwanAppMessengerClient", "start reCreate cause lower version, remoteVersion : " + j + " curVersion : " + o72.U().d0());
                }
                o72.Q0();
            }
        }

        public final void n(Message message) {
            Bundle bundle;
            t71 t71Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048590, this, message) == null) || message == null || (bundle = (Bundle) message.obj) == null || (t71Var = it2.b().d) == null) {
                return;
            }
            t71Var.onPayResult(it2.a(bundle.getInt(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE)), bundle.getString(YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR));
        }

        public final void o(String str, u03 u03Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, str, u03Var, pMSAppInfo) == null) {
                x52 d = x52.d();
                y52.b a2 = y52.a();
                a2.h(RecordType.APP_ID);
                a2.f(pMSAppInfo.appId);
                d.f(str, a2.e());
                y52.b a3 = y52.a();
                a3.h(RecordType.APP_VERSION);
                a3.f(String.valueOf(pMSAppInfo.versionCode));
                d.f(str, a3.e());
                y52.b a4 = y52.a();
                a4.h(RecordType.PREFETCH_TYPE);
                a4.g(u03Var.H());
                d.f(str, a4.e());
            }
        }

        public void p(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
                this.a = new WeakReference<>(cVar);
            }
        }

        public final boolean q(PrefetchEvent prefetchEvent, Bundle bundle) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, prefetchEvent, bundle)) == null) {
                u03 a0 = u03.a0();
                if (a0 == null) {
                    return true;
                }
                if (!a0.H() && TextUtils.isEmpty(a0.V().V())) {
                    if (TextUtils.equals(a0.getAppId(), prefetchEvent.appId)) {
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) bundle.getParcelable("swan_app_prefetch_pms_info");
                        if (pMSAppInfo == null) {
                            return false;
                        }
                        PMSAppInfo f0 = a0.V().f0();
                        return f0 == null || f0.versionCode != pMSAppInfo.versionCode;
                    }
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public final void r(u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, u03Var) == null) {
                gk1 a2 = u03Var.y().a().a();
                if (a2 != null) {
                    a2.a(AppRuntime.getAppContext());
                }
                hh1 M = u03Var.M();
                M.h(M.c(AppRuntime.getAppContext()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755394617, "Lcom/repackage/px2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755394617, "Lcom/repackage/px2;");
                return;
            }
        }
        h = eh1.a;
        i = TimeUnit.MINUTES.toMillis(5L);
        j = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px2(x03 x03Var) {
        super(x03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((x03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new e();
        this.f = new ArrayDeque();
    }

    @Deprecated
    public static px2 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? t03.J().z() : (px2) invokeV.objValue;
    }

    public void L(d dVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, cVar) == null) {
            this.d = dVar;
            this.b.p(cVar);
            Y(1, O());
            if (this.d == null || !N()) {
                return;
            }
            this.d.a();
        }
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.f) {
                S("checkRebindable ===>");
                if (this.f.size() < 3) {
                    S(String.format(Locale.getDefault(), "allowRebind by size(%d) < max(%d)", Integer.valueOf(this.f.size()), 3));
                    return true;
                }
                int size = this.f.size() - 3;
                S("after offer purgeCount=" + size);
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        S("purge: " + this.f.poll());
                    }
                }
                S("after purge");
                Long peek = this.f.peek();
                if (peek == null) {
                    S("allowRebind by null oldestRecord is should not happen");
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis() - peek.longValue();
                boolean z = currentTimeMillis > i;
                S("allowRebind:" + z + " oldestRecordDuration:" + currentTimeMillis);
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c != null : invokeV.booleanValue;
    }

    public final Bundle O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("process_id", SwanAppProcessInfo.current().index);
            bundle.putString("app_id", getAppId());
            bundle.putParcelable("app_core", n());
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Handler Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (Handler) invokeV.objValue;
    }

    public IProcessBridge R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.c : (IProcessBridge) invokeV.objValue;
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && h) {
            Log.i("SwanAppMessengerClient", "SwanRebind:: status => " + str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            Iterator<Long> it = this.f.iterator();
            while (it.hasNext()) {
                Log.i("SwanAppMessengerClient", "SwanRebind::   >>>  record @ " + simpleDateFormat.format(new Date(it.next().longValue())));
            }
        }
    }

    public synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.e = null;
                this.c = null;
                if (this.d != null) {
                    this.d.b();
                }
                c0();
                if (this.g != null) {
                    synchronized (j) {
                        for (Runnable runnable : this.g) {
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                        this.g.clear();
                    }
                }
            }
        }
    }

    public void U(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
            synchronized (j) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(runnable);
            }
        }
    }

    @Deprecated
    public void V(@Nullable Bundle bundle, @NonNull Class<? extends uw2> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bundle, cls) == null) {
            W(bundle, cls, null);
        }
    }

    @Deprecated
    public void W(@Nullable Bundle bundle, @NonNull Class<? extends uw2> cls, @Nullable bx2 bx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, bundle, cls, bx2Var) == null) {
            if (h) {
                Log.d("SwanAppMessengerClient", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 12);
            obtain.arg1 = SwanAppProcessInfo.current().index;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (bx2Var != null) {
                bundle2.putString("ai_apps_observer_id", bx2Var.b());
                yw2.b().e(bx2Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            bundle2.putString("ai_apps_id", getAppId());
            obtain.obj = bundle2;
            kx2 e2 = kx2.e();
            mx2 mx2Var = new mx2(obtain);
            mx2Var.p(true);
            e2.h(mx2Var);
        }
    }

    @Deprecated
    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            a0(i2, "");
        }
    }

    public void Y(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, bundle) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            Message obtain = Message.obtain(null, i2, bundle);
            obtain.arg1 = current.index;
            obtain.obj = bundle;
            kx2.e().h(new mx2(obtain));
        }
    }

    @Deprecated
    public void Z(int i2, SwanAppIPCData swanAppIPCData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, swanAppIPCData) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (h) {
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
            kx2.e().h(new mx2(obtain));
        }
    }

    @Deprecated
    public void a0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (h) {
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
            kx2.e().h(new mx2(obtain));
        }
    }

    public synchronized void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                if (h) {
                    Log.i("SwanAppMessengerClient", "tryBindRemoteMsgService");
                }
                if (this.e == null) {
                    this.e = new b(this, null);
                    Application c2 = bk2.c();
                    try {
                        c2.bindService(new Intent(c2, SwanAppMessengerService.class), this.e, 1);
                    } catch (Exception e2) {
                        if (h) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this.f) {
                if (M()) {
                    this.f.offer(Long.valueOf(System.currentTimeMillis()));
                    b0();
                }
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            X(2);
        }
    }
}
