package d.a.o0.a.h0.s;

import android.content.Context;
import android.os.Process;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45694h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f45695i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45696a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45697b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45698c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45699d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f45700e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f45701f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f45702g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f45704f;

        public a(b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45704f = bVar;
            this.f45703e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f45704f.f(this.f45703e);
                this.f45704f.f45697b = true;
                synchronized (this.f45704f.f45701f) {
                    this.f45704f.f45699d = true;
                    this.f45704f.f45701f.notifyAll();
                    this.f45704f.l();
                }
            }
        }
    }

    /* renamed from: d.a.o0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0775b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0775b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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
                WebView.setWebContentsDebuggingEnabled(true);
                Log.setMinLogLevel(3, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447609285, "Ld/a/o0/a/h0/s/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447609285, "Ld/a/o0/a/h0/s/b;");
                return;
            }
        }
        f45694h = k.f46335a;
    }

    public b(Context context) {
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
        this.f45697b = false;
        this.f45698c = false;
        this.f45699d = false;
        this.f45700e = new Object();
        this.f45701f = new Object();
        this.f45702g = new ArrayList<>();
        this.f45696a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (b.class) {
                if (f45695i == null) {
                    f45695i = new b(context);
                }
                bVar = f45695i;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            synchronized (this.f45701f) {
                if (f45694h) {
                    android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
                }
                if (!this.f45702g.contains(cVar)) {
                    this.f45702g.add(cVar);
                }
                if (this.f45699d) {
                    l();
                }
            }
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            WebKitFactory.setNeedDownloadCloudResource(false);
            WebKitFactory.setProcessType("1");
            com.baidu.webkit.sdk.WebView.setDataDirectorySuffix(ProcessUtils.getCurProcessName());
            BdSailor.getInstance().init(this.f45696a, null, null);
            if (f45694h) {
                q0.X(new RunnableC0775b(this));
            }
            BdSailor.getInstance().setWebkitEnable(!(f45694h && d.a.o0.a.u1.a.a.F().booleanValue()));
            BdSailor.getInstance().initWebkit("swan", false);
            BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
            if (BdZeusUtil.isWebkitLoaded()) {
                if (f45694h) {
                    android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
                }
            } else if (f45694h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
            }
            CookieSyncManager.createInstance(this.f45696a);
            BdSailor.initCookieSyncManager(this.f45696a);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i(true, ProcessUtils.checkIsMainProcess(ProcessUtils.getCurProcessName()));
        }
    }

    public final void i(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f45697b) {
            return;
        }
        synchronized (this.f45700e) {
            if (!this.f45698c) {
                Executors.newSingleThreadExecutor().execute(new a(this, z2));
                this.f45698c = true;
            }
        }
        if (z) {
            synchronized (this.f45701f) {
                while (!this.f45699d) {
                    try {
                        this.f45701f.wait(1000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            i(false, z);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45697b : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f45701f) {
                if (f45694h) {
                    android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
                }
                Iterator<c> it = this.f45702g.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f45702g.clear();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && k()) {
            BdSailor.getInstance().destroy();
        }
    }
}
