package d.a.q0.w;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import d.a.q0.n.l.b;
import d.a.q0.t.d;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class c implements d.a.q0.n.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f54519c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f54520d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f54521a;

    /* renamed from: b  reason: collision with root package name */
    public String f54522b;

    /* loaded from: classes8.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f54524b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f54525c;

        /* renamed from: d.a.q0.w.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1213a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f54526e;

            public RunnableC1213a(a aVar) {
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
                this.f54526e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f54526e.f54525c;
                    cVar.j(cVar.f54522b);
                }
            }
        }

        public a(c cVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54525c = cVar;
            this.f54523a = str;
            this.f54524b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (d.A(this.f54523a, str)) {
                    synchronized (c.f54520d) {
                        this.f54525c.i(new b(AppRuntime.getAppContext()).q());
                    }
                    return;
                }
                if (c.e(this.f54525c) <= 2) {
                    boolean z = true;
                    if (8 == i2) {
                        this.f54525c.f54522b = this.f54523a;
                    } else {
                        c cVar = this.f54525c;
                        cVar.f54522b = this.f54523a + File.pathSeparator + this.f54525c.f54521a;
                        if (d.f(this.f54524b, new File(this.f54525c.f54522b)) != this.f54524b.length()) {
                            z = false;
                        }
                    }
                    if (z && d.a.q0.a.a2.d.i().postDelayed(new RunnableC1213a(this), 1000L)) {
                        return;
                    }
                }
                if (8 == i2) {
                    d.j(this.f54523a);
                }
                synchronized (c.f54520d) {
                    this.f54525c.i(false);
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975824795, "Ld/a/q0/w/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975824795, "Ld/a/q0/w/c;");
                return;
            }
        }
        f54520d = new HashSet();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54521a = 0;
    }

    public static /* synthetic */ int e(c cVar) {
        int i2 = cVar.f54521a + 1;
        cVar.f54521a = i2;
        return i2;
    }

    @Override // d.a.q0.n.l.b
    public void a(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            synchronized (f54520d) {
                f54520d.add(aVar);
                if (f54519c) {
                    return;
                }
                f54519c = true;
                j(str);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (f54520d) {
                for (b.a aVar : f54520d) {
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
                f54520d.clear();
                f54519c = false;
                this.f54521a = 0;
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                synchronized (f54520d) {
                    i(false);
                }
                return;
            }
            File file = new File(str);
            if (!file.isFile()) {
                synchronized (f54520d) {
                    i(false);
                }
                return;
            }
            WebKitFactory.installAsync("file://" + str, new a(this, str, file));
        }
    }
}
