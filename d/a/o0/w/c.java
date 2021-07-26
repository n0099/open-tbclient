package d.a.o0.w;

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
import d.a.o0.n.l.b;
import d.a.o0.t.d;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class c implements d.a.o0.n.l.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f51721c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<b.a> f51722d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f51723a;

    /* renamed from: b  reason: collision with root package name */
    public String f51724b;

    /* loaded from: classes7.dex */
    public class a implements WebKitFactory.WebkitInstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f51726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f51727c;

        /* renamed from: d.a.o0.w.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1171a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f51728e;

            public RunnableC1171a(a aVar) {
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
                this.f51728e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.f51728e.f51727c;
                    cVar.j(cVar.f51724b);
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
            this.f51727c = cVar;
            this.f51725a = str;
            this.f51726b = file;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
        public void onInstallFinish(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (d.A(this.f51725a, str)) {
                    synchronized (c.f51722d) {
                        this.f51727c.i(new b(AppRuntime.getAppContext()).q());
                    }
                    return;
                }
                if (c.e(this.f51727c) <= 2) {
                    boolean z = true;
                    if (8 == i2) {
                        this.f51727c.f51724b = this.f51725a;
                    } else {
                        c cVar = this.f51727c;
                        cVar.f51724b = this.f51725a + File.pathSeparator + this.f51727c.f51723a;
                        if (d.f(this.f51726b, new File(this.f51727c.f51724b)) != this.f51726b.length()) {
                            z = false;
                        }
                    }
                    if (z && d.a.o0.a.a2.d.i().postDelayed(new RunnableC1171a(this), 1000L)) {
                        return;
                    }
                }
                if (8 == i2) {
                    d.j(this.f51725a);
                }
                synchronized (c.f51722d) {
                    this.f51727c.i(false);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-799182567, "Ld/a/o0/w/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-799182567, "Ld/a/o0/w/c;");
                return;
            }
        }
        f51722d = new HashSet();
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
        this.f51723a = 0;
    }

    public static /* synthetic */ int e(c cVar) {
        int i2 = cVar.f51723a + 1;
        cVar.f51723a = i2;
        return i2;
    }

    @Override // d.a.o0.n.l.b
    public void a(String str, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            synchronized (f51722d) {
                f51722d.add(aVar);
                if (f51721c) {
                    return;
                }
                f51721c = true;
                j(str);
            }
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            synchronized (f51722d) {
                for (b.a aVar : f51722d) {
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
                f51722d.clear();
                f51721c = false;
                this.f51723a = 0;
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                synchronized (f51722d) {
                    i(false);
                }
                return;
            }
            File file = new File(str);
            if (!file.isFile()) {
                synchronized (f51722d) {
                    i(false);
                }
                return;
            }
            WebKitFactory.installAsync("file://" + str, new a(this, str, file));
        }
    }
}
