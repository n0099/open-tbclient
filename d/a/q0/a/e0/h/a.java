package d.a.q0.a.e0.h;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e0.f.f.d;
import d.a.q0.a.k2.g.h;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static int f47441d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f47442a;

    /* renamed from: b  reason: collision with root package name */
    public b f47443b;

    /* renamed from: c  reason: collision with root package name */
    public c f47444c;

    /* renamed from: d.a.q0.a.e0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0723a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47445e;

        public RunnableC0723a(a aVar) {
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
            this.f47445e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.q0.a.e0.f.b.e() || a.e() != 0) {
                    this.f47445e.f47444c = new d.a.q0.a.e0.h.c.c(String.format("v8in%s_devtools_remote", this.f47445e.f47442a.getPackageName()), this.f47445e.f47443b);
                } else if (d.a.q0.a.e0.f.b.f()) {
                    this.f47445e.f47444c = new d.a.q0.a.e0.h.c.b(d.e(), this.f47445e.f47443b);
                } else {
                    d.a.q0.a.e0.d.b("V8Inspector", "Unknown inspect mode");
                    return;
                }
                this.f47445e.f47444c.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onConnected();
    }

    /* loaded from: classes8.dex */
    public interface c {
        void start();

        void stop();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1957064052, "Ld/a/q0/a/e0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1957064052, "Ld/a/q0/a/e0/h/a;");
                return;
            }
        }
        f47441d = h.a().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
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
        this.f47442a = context;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f47441d : invokeV.intValue;
    }

    public static void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            h.a().putBoolean("Inspector", i2 == 2);
            f47441d = i2;
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f47443b = bVar;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ExecutorUtilsExt.postOnSerial(new RunnableC0723a(this), "V8Inspector");
        }
    }

    public void i() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f47444c) == null) {
            return;
        }
        cVar.stop();
        this.f47444c = null;
    }
}
