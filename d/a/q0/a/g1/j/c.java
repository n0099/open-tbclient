package d.a.q0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements d.a.q0.a.g1.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f47865a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.q0.a.g1.j.a> f47866b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f47867c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47868e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47868e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d.a.q0.a.g1.j.a aVar : this.f47868e.f47866b) {
                    aVar.onPause();
                }
                this.f47868e.f47865a = true;
                this.f47868e.f47867c = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47869e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47869e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f47869e.f47865a) {
                if (this.f47869e.f47867c != null) {
                    q0.a0(this.f47869e.f47867c);
                    this.f47869e.f47867c = null;
                }
                for (d.a.q0.a.g1.j.a aVar : this.f47869e.f47866b) {
                    aVar.onResume();
                }
                this.f47869e.f47865a = false;
            }
        }
    }

    /* renamed from: d.a.q0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0762c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f47870a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f47871b = -2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1357678006, "Ld/a/q0/a/g1/j/c$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1357678006, "Ld/a/q0/a/g1/j/c$c;");
            }
        }

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f47871b == -2) {
                    d.a.q0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f47871b = 3;
                }
                return (f47871b & 2) == 2;
            }
            return invokeV.booleanValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f47871b == -2) {
                    d.a.q0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f47871b = 3;
                }
                return (f47871b & 1) == 1;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f47870a == -2) {
                    d.a.q0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                    f47870a = -1;
                }
                return f47870a > -1;
            }
            return invokeV.booleanValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f47870a : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f47872a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1357677975, "Ld/a/q0/a/g1/j/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1357677975, "Ld/a/q0/a/g1/j/c$d;");
                    return;
                }
            }
            f47872a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.a.q0.a.g1.j.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.f47872a : (d.a.q0.a.g1.j.a) invokeV.objValue;
    }

    @Override // d.a.q0.a.g1.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && C0762c.c()) {
            this.f47867c = new a(this);
            q0.Y(this.f47867c, C0762c.d() * 1000);
        }
    }

    @Override // d.a.q0.a.g1.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && C0762c.c()) {
            q0.b0(new b(this));
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47865a = false;
        this.f47866b = new ArrayList();
        if (C0762c.c()) {
            if (C0762c.b()) {
                this.f47866b.add(new d.a.q0.a.g1.j.d());
            }
            if (C0762c.a()) {
                this.f47866b.add(new d.a.q0.a.g1.j.b());
            }
        }
    }
}
