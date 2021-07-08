package d.a.n0.a.h0.s;

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
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45190h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f45191i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45192a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45193b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45194c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45195d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f45196e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f45197f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f45198g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f45200f;

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
            this.f45200f = bVar;
            this.f45199e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.f45200f.f(this.f45199e);
                this.f45200f.f45193b = true;
                synchronized (this.f45200f.f45197f) {
                    this.f45200f.f45195d = true;
                    this.f45200f.f45197f.notifyAll();
                    this.f45200f.l();
                }
            }
        }
    }

    /* renamed from: d.a.n0.a.h0.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0766b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0766b(b bVar) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318526566, "Ld/a/n0/a/h0/s/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318526566, "Ld/a/n0/a/h0/s/b;");
                return;
            }
        }
        f45190h = k.f45831a;
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
        this.f45193b = false;
        this.f45194c = false;
        this.f45195d = false;
        this.f45196e = new Object();
        this.f45197f = new Object();
        this.f45198g = new ArrayList<>();
        this.f45192a = context.getApplicationContext();
    }

    public static synchronized b g(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (b.class) {
                if (f45191i == null) {
                    f45191i = new b(context);
                }
                bVar = f45191i;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            synchronized (this.f45197f) {
                if (f45190h) {
                    android.util.Log.d("BlinkInitHelper", "addBlinkInitListener.");
                }
                if (!this.f45198g.contains(cVar)) {
                    this.f45198g.add(cVar);
                }
                if (this.f45195d) {
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
            BdSailor.getInstance().init(this.f45192a, null, null);
            if (f45190h) {
                q0.X(new RunnableC0766b(this));
            }
            BdSailor.getInstance().setWebkitEnable(!(f45190h && d.a.n0.a.u1.a.a.F().booleanValue()));
            BdSailor.getInstance().initWebkit("swan", false);
            BdSailor.getInstance().getSailorSettings().setJavaScriptEnabledOnFileScheme(true);
            if (BdZeusUtil.isWebkitLoaded()) {
                if (f45190h) {
                    android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) success ^V^");
                }
            } else if (f45190h) {
                android.util.Log.d("BlinkInitHelper", "WebKitFactory.setEngine(WebKitFactory.ENGINE_BLINK) fail !!!!");
            }
            CookieSyncManager.createInstance(this.f45192a);
            BdSailor.initCookieSyncManager(this.f45192a);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f45193b) {
            return;
        }
        synchronized (this.f45196e) {
            if (!this.f45194c) {
                Executors.newSingleThreadExecutor().execute(new a(this, z2));
                this.f45194c = true;
            }
        }
        if (z) {
            synchronized (this.f45197f) {
                while (!this.f45195d) {
                    try {
                        this.f45197f.wait(1000L);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45193b : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f45197f) {
                if (f45190h) {
                    android.util.Log.d("BlinkInitHelper", "notifyBlinkLoaded.");
                }
                Iterator<c> it = this.f45198g.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f45198g.clear();
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
