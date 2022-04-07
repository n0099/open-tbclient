package com.repackage;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.PluginInstallTask;
import com.baidu.adp.plugin.install.PluginInstallerRetryService;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class cm {
    public static /* synthetic */ Interceptable $ic;
    public static Handler t;
    public static volatile cm u;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public ArrayList<String> b;
    public BroadcastReceiver c;
    public boolean d;
    public am e;
    public boolean f;
    public final Object g;
    public PluginInstallTask h;
    public LinkedList<PluginInstallTask> i;
    public PluginInstallTask j;
    public LinkedList<PluginInstallTask> k;
    public Messenger l;
    public ServiceConnection m;
    public Handler n;
    public Messenger o;
    public Runnable p;
    public Runnable q;
    public Runnable r;
    public Runnable s;

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm this$0;

        public a(cm cmVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cmVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cmVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:106:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0150, code lost:
            if (android.text.TextUtils.equals(r1, r6.this$0.j.b) != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0197, code lost:
            if (android.text.TextUtils.equals(r1, r6.this$0.j.b) != false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0199, code lost:
            r6.this$0.I();
            r0 = r6.this$0.t(null);
            com.repackage.em.b().g("plugin_retry_install_succ");
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(Context context, Intent intent) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) {
                return;
            }
            try {
                if (intent == null) {
                    if (this.this$0.h == null || !TextUtils.equals(null, this.this$0.h.b)) {
                        if (this.this$0.j == null || !TextUtils.equals(null, this.this$0.j.b)) {
                            this.this$0.t(null);
                            return;
                        }
                        this.this$0.I();
                        this.this$0.t(null);
                        em.b().g("plugin_retry_install_succ");
                        return;
                    }
                    this.this$0.F();
                    this.this$0.h = null;
                    this.this$0.t(null);
                    return;
                }
                try {
                    str = intent.getStringExtra("package_name");
                    try {
                    } catch (Exception e) {
                        e = e;
                        BdLog.detailException(e);
                        if (this.this$0.h == null || !TextUtils.equals(str, this.this$0.h.b)) {
                            if (this.this$0.j != null) {
                            }
                            this.this$0.t(null);
                            return;
                        }
                        this.this$0.F();
                        this.this$0.h = null;
                        this.this$0.t(null);
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                } catch (Throwable th) {
                    th = th;
                    if (this.this$0.h == null || !TextUtils.equals(null, this.this$0.h.b)) {
                        if (this.this$0.j == null || !TextUtils.equals(null, this.this$0.j.b)) {
                            this.this$0.t(null);
                        } else {
                            this.this$0.I();
                            this.this$0.t(null);
                            em.b().g("plugin_retry_install_succ");
                        }
                    } else {
                        this.this$0.F();
                        this.this$0.h = null;
                        this.this$0.t(null);
                    }
                    throw th;
                }
                if (TextUtils.isEmpty(str)) {
                    if (this.this$0.h == null || !TextUtils.equals(str, this.this$0.h.b)) {
                        if (this.this$0.j == null || !TextUtils.equals(str, this.this$0.j.b)) {
                            this.this$0.t(null);
                            return;
                        }
                        this.this$0.I();
                        this.this$0.t(null);
                        em.b().g("plugin_retry_install_succ");
                        return;
                    }
                    this.this$0.F();
                    this.this$0.h = null;
                    this.this$0.t(null);
                    return;
                }
                String stringExtra = intent.getStringExtra("install_src_file");
                boolean z = stringExtra != null && stringExtra.startsWith("assets://");
                String action = intent.getAction();
                if ("com.baidu.adp.plugin.installed".equals(action)) {
                    this.this$0.z(str, z);
                    rm.a().d(str);
                } else if ("com.baidu.adp.plugin.installfail".equals(action)) {
                    if (z) {
                        this.this$0.f = false;
                    }
                    this.this$0.z(str, z);
                    rm.a().c(str, intent.getStringExtra("fail_reason"), intent.getStringExtra("install_comment"));
                } else if ("com.baidu.adp.plugin.installcancel".equals(action)) {
                    this.this$0.z(str, z);
                } else {
                    "com.baidu.adp.plugin.installrepeat".equals(action);
                }
                if (this.this$0.h == null || !TextUtils.equals(str, this.this$0.h.b)) {
                    if (this.this$0.j != null) {
                    }
                    this.this$0.t(null);
                    return;
                }
                this.this$0.F();
                this.this$0.h = null;
                this.this$0.t(null);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ cm c;

        public b(cm cmVar, Intent intent, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cmVar, intent, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cmVar;
            this.a = intent;
            this.b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.c.l = new Messenger(iBinder);
                String stringExtra = this.a.getStringExtra("package_name");
                if (this.c.h == null || !TextUtils.equals(stringExtra, this.c.h.b)) {
                    return;
                }
                try {
                    this.b.startService(this.a);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.c.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(cm cmVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cmVar, looper};
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
            this.a = cmVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.h == null || message == null) {
                return;
            }
            try {
                if (TextUtils.equals(((PluginInstallTask) OrmObject.objectWithBundle(message.getData(), PluginInstallTask.class)).b, this.a.h.b)) {
                    cm.t.removeCallbacks(this.a.q);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm a;

        public d(cm cmVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cmVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
                this.a.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm a;

        public e(cm cmVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cmVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm a;

        public f(cm cmVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cmVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.H();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm a;

        public g(cm cmVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cmVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964043045, "Lcom/repackage/cm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964043045, "Lcom/repackage/cm;");
                return;
            }
        }
        t = new Handler(Looper.getMainLooper());
        u = null;
    }

    public cm() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = false;
        this.f = true;
        this.g = new Object();
        this.i = new LinkedList<>();
        this.k = new LinkedList<>();
        this.n = new c(this, Looper.getMainLooper());
        this.o = new Messenger(this.n);
        this.p = new d(this);
        this.q = new e(this);
        this.r = new f(this);
        this.s = new g(this);
        this.b = new ArrayList<>();
        this.c = new a(this);
        K();
    }

    public static File x(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            PluginSetting q = PluginPackageManager.p().q(str);
            if (q == null || (str2 = q.apkPath) == null || str2.length() <= 0) {
                return null;
            }
            return new File(q.apkPath);
        }
        return (File) invokeL.objValue;
    }

    public static cm y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (u == null) {
                synchronized (cm.class) {
                    if (u == null) {
                        u = new cm();
                    }
                }
            }
            return u;
        }
        return (cm) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? w() > 0 : invokeV.booleanValue;
    }

    public boolean B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            PluginInstallTask pluginInstallTask = this.h;
            if (pluginInstallTask != null) {
                return TextUtils.equals(str, pluginInstallTask.b);
            }
            PluginInstallTask pluginInstallTask2 = this.j;
            if (pluginInstallTask2 != null) {
                return TextUtils.equals(str, pluginInstallTask2.b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.m != null) {
                BdBaseApplication.getInst().getApplicationContext().unbindService(this.m);
            }
            this.m = null;
            this.l = null;
            int w = w();
            if (w <= 0 || w == Process.myPid()) {
                return;
            }
            Process.killProcess(w);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            t.removeCallbacks(this.p);
            t.postDelayed(this.p, 10000L);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            em.b().g("plugin_installprocess_noresponse");
            em b2 = em.b();
            PluginInstallTask pluginInstallTask = this.h;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.b;
            b2.m("plugin_install", "installprocess_noresponse", str, this.i.size() + "-" + this.k.size());
            F();
            C();
            L();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            t.removeCallbacks(this.p);
            t.removeCallbacks(this.r);
            t.removeCallbacks(this.q);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.m = null;
            this.l = null;
            em b2 = em.b();
            PluginInstallTask pluginInstallTask = this.h;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.b;
            b2.m("plugin_install", "system_kill_installprocess", str, this.i.size() + "-" + this.k.size());
            F();
            L();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.h != null) {
                rm.a().c(this.h.b, "plugin_install_timeout", null);
            }
            PluginInstallTask pluginInstallTask = this.h;
            if (!A()) {
                em.b().g("plugin_install_timeout_installprocess_notlive");
                em b2 = em.b();
                String str = pluginInstallTask == null ? "" : pluginInstallTask.b;
                StringBuilder sb = new StringBuilder();
                sb.append("timeout-");
                sb.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.y()) : "");
                sb.append("-");
                sb.append(this.i.size());
                sb.append("-");
                sb.append(this.k.size());
                b2.m("plugin_install", "timeout_installprocess_notlive", str, sb.toString());
            } else {
                em.b().g("plugin_install_timeout");
                em b3 = em.b();
                String str2 = pluginInstallTask == null ? "" : pluginInstallTask.b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("timeout-");
                sb2.append(pluginInstallTask != null ? Long.valueOf(pluginInstallTask.y()) : "");
                sb2.append("-");
                sb2.append(this.i.size());
                sb2.append("-");
                sb2.append(this.k.size());
                b3.m("plugin_install", "timeout", str2, sb2.toString());
            }
            F();
            C();
            L();
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j = null;
            t.removeCallbacks(this.s);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.j != null) {
                rm.a().c(this.j.b, "plugin_install_retry_timeout", null);
            }
            em b2 = em.b();
            PluginInstallTask pluginInstallTask = this.j;
            String str = pluginInstallTask == null ? "" : pluginInstallTask.b;
            StringBuilder sb = new StringBuilder();
            sb.append("timeout-");
            PluginInstallTask pluginInstallTask2 = this.j;
            sb.append(pluginInstallTask2 != null ? Long.valueOf(pluginInstallTask2.y()) : "");
            sb.append("-");
            sb.append(this.i.size());
            sb.append("-");
            sb.append(this.k.size());
            b2.m("plugin_install", "timeout", str, sb.toString());
            I();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a) {
            return;
        }
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.addAction("com.baidu.adp.plugin.installfail");
            intentFilter.addAction("com.baidu.adp.plugin.installcancel");
            intentFilter.addAction("com.baidu.adp.plugin.installrepeat");
            if (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().equals(RomUtils.MANUFACTURER_OPPO)) {
                intentFilter.setPriority(1000);
            }
            applicationContext.registerReceiver(this.c, intentFilter);
            this.a = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.h != null) {
                em.b().i("plugin_retry_install", this.h.b);
                em b2 = em.b();
                String str = this.h.b;
                b2.m("plugin_install", "plugin_retry_install", str, this.h.y() + "");
                v(this.h);
                this.h = null;
                return;
            }
            t(null);
        }
    }

    public final boolean M(Context context, PluginInstallTask pluginInstallTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, pluginInstallTask)) == null) {
            if (pluginInstallTask == null) {
                return false;
            }
            PluginSetting g2 = om.h().g(pluginInstallTask.b);
            String str = pluginInstallTask.a;
            boolean z = str != null && str.startsWith("assets://");
            String str2 = pluginInstallTask.a;
            if (str2 != null && str2.startsWith("file://")) {
                if (g2 != null && g2.installStatus == 0 && g2.tempVersionCode == 0) {
                    em.b().m("plugin_install", "start_service_install_status_error", pluginInstallTask.b, "apkFilePath_" + pluginInstallTask.a);
                    return false;
                }
                String substring = pluginInstallTask.a.substring(7);
                try {
                    if (!new File(substring).exists()) {
                        em.b().m("plugin_install", "start_service_file_not_find", pluginInstallTask.b, "apkFilePath_" + substring);
                        return false;
                    }
                } catch (Exception unused) {
                }
            }
            String str3 = "f" + System.currentTimeMillis();
            em.b().m("plugin_install", "start_install_service", pluginInstallTask.b, "flag=" + str3 + "_" + pluginInstallTask.a);
            Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
            intent.putExtra("install_src_file", pluginInstallTask.a);
            intent.putExtra("package_name", pluginInstallTask.b);
            intent.putExtra("install_flag", str3);
            if (g2 != null) {
                intent.putExtra("plugin_setting", g2);
            }
            intent.putExtra("is_debug_plugin", PluginPackageManager.p().v());
            if (pluginInstallTask.c) {
                intent.setClass(context, PluginInstallerRetryService.class);
                try {
                    context.startService(intent);
                    return true;
                } catch (Throwable unused2) {
                    return false;
                }
            }
            intent.setClass(context, PluginInstallerService.class);
            if (this.m == null && z) {
                ServiceConnection bVar = new b(this, intent, context);
                this.m = bVar;
                if (context.bindService(intent, bVar, 1)) {
                    return true;
                }
                try {
                    context.startService(intent);
                    return true;
                } catch (Throwable unused3) {
                    return false;
                }
            }
            try {
                context.startService(intent);
                return true;
            } catch (Throwable unused4) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.l == null || this.h == null) {
            return;
        }
        Message message = new Message();
        try {
            message.setData(OrmObject.bundleWithObject(this.h));
            message.replyTo = this.o;
            this.l.send(message);
        } catch (RemoteException e2) {
            BdLog.detailException(e2);
        }
        t.removeCallbacks(this.q);
        t.postDelayed(this.q, 1000L);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.m == null) {
            return;
        }
        BdBaseApplication.getInst().unbindService(this.m);
        this.m = null;
    }

    public final boolean t(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, pluginInstallTask)) == null) {
            if (u(pluginInstallTask)) {
                return true;
            }
            return v(pluginInstallTask);
        }
        return invokeL.booleanValue;
    }

    public final boolean u(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pluginInstallTask)) == null) {
            synchronized (this.g) {
                if (pluginInstallTask == null) {
                    try {
                        pluginInstallTask = this.i.poll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z = false;
                if (pluginInstallTask == null) {
                    return false;
                }
                if (this.h != null) {
                    Iterator<PluginInstallTask> it = this.i.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PluginInstallTask next = it.next();
                        if (next != null && TextUtils.equals(pluginInstallTask.b, next.b)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.i.add(pluginInstallTask);
                    }
                    return true;
                }
                this.h = pluginInstallTask;
                if (M(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                    D();
                    t.removeCallbacks(this.r);
                    t.postDelayed(this.r, this.h.y());
                    return true;
                }
                this.h = null;
                return t(null);
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean v(PluginInstallTask pluginInstallTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, pluginInstallTask)) == null) {
            synchronized (this.g) {
                if (pluginInstallTask == null) {
                    try {
                        pluginInstallTask = this.k.poll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z = false;
                if (pluginInstallTask == null) {
                    return false;
                }
                if (this.j != null) {
                    Iterator<PluginInstallTask> it = this.k.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PluginInstallTask next = it.next();
                        if (next != null && TextUtils.equals(pluginInstallTask.b, next.b)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.k.add(pluginInstallTask);
                    }
                    return true;
                }
                this.j = pluginInstallTask;
                pluginInstallTask.c = true;
                if (M(BdBaseApplication.getInst().getApplicationContext(), pluginInstallTask)) {
                    t.removeCallbacks(this.s);
                    t.postDelayed(this.s, this.j.y());
                    return true;
                }
                return t(null);
            }
        }
        return invokeL.booleanValue;
    }

    public final int w() {
        InterceptResult invokeV;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            try {
                serviceInfo = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, PluginInstallerService.class), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                BdLog.detailException(e2);
                serviceInfo = null;
            }
            if (serviceInfo != null) {
                String str = serviceInfo.processName;
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) applicationContext.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && TextUtils.equals(str, runningAppProcessInfo.processName)) {
                            return runningAppProcessInfo.pid;
                        }
                    }
                    return Integer.MIN_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        return invokeV.intValue;
    }

    public final void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, str, z) == null) {
            if (this.b.contains(str)) {
                this.b.remove(str);
            }
            if (!this.d && z && this.b.isEmpty()) {
                this.d = true;
                am amVar = this.e;
                if (amVar != null) {
                    amVar.a(this.f);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000988));
                s();
            }
        }
    }
}
