package d.a.n0.a.g1.j;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements d.a.n0.a.g1.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f44563a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.n0.a.g1.j.a> f44564b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f44565c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f44566e;

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
            this.f44566e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d.a.n0.a.g1.j.a aVar : this.f44566e.f44564b) {
                    aVar.onPause();
                }
                this.f44566e.f44563a = true;
                this.f44566e.f44565c = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f44567e;

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
            this.f44567e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f44567e.f44563a) {
                if (this.f44567e.f44565c != null) {
                    q0.a0(this.f44567e.f44565c);
                    this.f44567e.f44565c = null;
                }
                for (d.a.n0.a.g1.j.a aVar : this.f44567e.f44564b) {
                    aVar.onResume();
                }
                this.f44567e.f44563a = false;
            }
        }
    }

    /* renamed from: d.a.n0.a.g1.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0711c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f44568a = -2;

        /* renamed from: b  reason: collision with root package name */
        public static int f44569b = -2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(158997869, "Ld/a/n0/a/g1/j/c$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(158997869, "Ld/a/n0/a/g1/j/c$c;");
            }
        }

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f44569b == -2) {
                    d.a.n0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f44569b = 3;
                }
                return (f44569b & 2) == 2;
            }
            return invokeV.booleanValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f44569b == -2) {
                    d.a.n0.a.c1.a.Z().getSwitch("swan_webview_pause_control", 3);
                    f44569b = 3;
                }
                return (f44569b & 1) == 1;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f44568a == -2) {
                    d.a.n0.a.c1.a.Z().getSwitch("swan_webview_backstage_optimize", -1);
                    f44568a = -1;
                }
                return f44568a > -1;
            }
            return invokeV.booleanValue;
        }

        public static int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f44568a : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f44570a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(158997900, "Ld/a/n0/a/g1/j/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(158997900, "Ld/a/n0/a/g1/j/c$d;");
                    return;
                }
            }
            f44570a = new c(null);
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static d.a.n0.a.g1.j.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.f44570a : (d.a.n0.a.g1.j.a) invokeV.objValue;
    }

    @Override // d.a.n0.a.g1.j.a
    @AnyThread
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && C0711c.c()) {
            this.f44565c = new a(this);
            q0.Y(this.f44565c, C0711c.d() * 1000);
        }
    }

    @Override // d.a.n0.a.g1.j.a
    @AnyThread
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && C0711c.c()) {
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
        this.f44563a = false;
        this.f44564b = new ArrayList();
        if (C0711c.c()) {
            if (C0711c.b()) {
                this.f44564b.add(new d.a.n0.a.g1.j.d());
            }
            if (C0711c.a()) {
                this.f44564b.add(new d.a.n0.a.g1.j.b());
            }
        }
    }
}
