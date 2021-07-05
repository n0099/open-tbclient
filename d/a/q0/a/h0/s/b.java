package d.a.q0.a.h0.s;

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
import d.a.q0.a.k;
import d.a.q0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f48492h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f48493i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f48494a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f48495b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48496c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48497d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f48498e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f48499f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f48500g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f48502f;

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
            this.f48502f = bVar;
            this.f48501e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f48502f.f(this.f48501e);
                this.f48502f.f48495b = true;
                synchronized (this.f48502f.f48499f) {
                    this.f48502f.f48497d = true;
                    this.f48502f.f48499f.notifyAll();
                    this.f48502f.l();
                }
            }
        }
    }

    /* renamed from: d.a.q0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0817b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0817b(b bVar) {
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

    /* loaded from: classes8.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705774723, "Ld/a/q0/a/h0/s/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705774723, "Ld/a/q0/a/h0/s/b;");
                return;
            }
        }
        f48492h = k.f49133a;
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
        this.f48495b = false;
        this.f48496c = false;
        this.f48497d = false;
        this.f48498e = new Object();
        this.f48499f = new Object();
        this.f48500g = new ArrayList<>();
        this.f48494a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (b.class) {
                if (f48493i == null) {
                    f48493i = new b(context);
                }
                bVar = f48493i;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            synchronized (this.f48499f) {
                if (f48492h) {
                    android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
                }
                if (!this.f48500g.contains(cVar)) {
                    this.f48500g.add(cVar);
                }
                if (this.f48497d) {
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
            BdSailor.getInstance().init(this.f48494a, null, null);
            if (f48492h) {
                q0.X(new RunnableC0817b(this));
            }
            BdSailor.getInstance().setWebkitEnable(!(f48492h && d.a.q0.a.u1.a.a.F().booleanValue()));
            BdSailor.getInstance().initWebkit("swan", false);
            BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
            if (BdZeusUtil.isWebkitLoaded()) {
                if (f48492h) {
                    android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
                }
            } else if (f48492h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
            }
            CookieSyncManager.createInstance(this.f48494a);
            BdSailor.initCookieSyncManager(this.f48494a);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f48495b) {
            return;
        }
        synchronized (this.f48498e) {
            if (!this.f48496c) {
                Executors.newSingleThreadExecutor().execute(new a(this, z2));
                this.f48496c = true;
            }
        }
        if (z) {
            synchronized (this.f48499f) {
                while (!this.f48497d) {
                    try {
                        this.f48499f.wait(1000L);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48495b : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f48499f) {
                if (f48492h) {
                    android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
                }
                Iterator<c> it = this.f48500g.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f48500g.clear();
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
