package com.repackage;

import android.content.Context;
import android.os.Process;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public final class i52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static volatile i52 i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public volatile boolean b;
    public boolean c;
    public boolean d;
    public final Object e;
    public final Object f;
    public ArrayList<e> g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ i52 c;

        public a(i52 i52Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i52Var;
            this.a = z;
            this.b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.c.g(this.a, this.b);
                this.c.b = true;
                synchronized (this.c.f) {
                    this.c.d = true;
                    this.c.f.notifyAll();
                    this.c.m();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(i52 i52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var};
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
                WebView.setWebContentsDebuggingEnabled(true);
                Log.setMinLogLevel(3, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i52 a;

        public c(i52 i52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CookieSyncManager.createInstance(this.a.a);
                BdSailor.initCookieSyncManager(this.a.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements be3<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public d(i52 i52Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i52Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.be3
        /* renamed from: a */
        public Void create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.run();
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755667541, "Lcom/repackage/i52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755667541, "Lcom/repackage/i52;");
                return;
            }
        }
        h = rf1.a;
    }

    public i52(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new Object();
        this.f = new Object();
        this.g = new ArrayList<>();
        this.a = context.getApplicationContext();
    }

    public static synchronized i52 h(Context context) {
        InterceptResult invokeL;
        i52 i52Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (i52.class) {
                if (i == null) {
                    i = new i52(context);
                }
                i52Var = i;
            }
            return i52Var;
        }
        return (i52) invokeL.objValue;
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            synchronized (this.f) {
                if (h) {
                    android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
                }
                if (!this.g.contains(eVar)) {
                    this.g.add(eVar);
                }
                if (this.d) {
                    m();
                }
            }
        }
    }

    public final void g(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            WebKitFactory.setNeedDownloadCloudResource(false);
            WebKitFactory.setProcessType("1");
            com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
            BdSailor.getInstance().init(this.a, null, null);
            if (h) {
                bd3.a0(new b(this));
            }
            BdSailor.getInstance().setWebkitEnable(!(h && gv2.G().booleanValue()));
            BdSailor.getInstance().initWebkit("swan", false);
            BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
            if (BdZeusUtil.isWebkitLoaded()) {
                if (h) {
                    android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
                }
            } else if (h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
            }
            c cVar = new c(this);
            if (z2) {
                gz2.L().post(cVar);
            } else {
                yd3.b(new d(this, cVar));
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
        }
    }

    public final void j(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.b) {
            return;
        }
        boolean z3 = z && bd3.O();
        synchronized (this.e) {
            if (!this.c) {
                Executors.newSingleThreadExecutor().execute(new a(this, z2, z3));
                this.c = true;
            }
        }
        if (z) {
            synchronized (this.f) {
                while (!this.d) {
                    try {
                        this.f.wait(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            j(false, z);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f) {
                if (h) {
                    android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
                }
                Iterator<e> it = this.g.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.g.clear();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && l()) {
            BdSailor.getInstance().destroy();
        }
    }
}
