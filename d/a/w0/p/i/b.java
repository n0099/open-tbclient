package d.a.w0.p.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68917a;

    /* renamed from: b  reason: collision with root package name */
    public int f68918b;

    /* renamed from: c  reason: collision with root package name */
    public int f68919c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68920d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1948b f68921e;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f68922e;

        public a(b bVar) {
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
                    return;
                }
            }
            this.f68922e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68922e.i();
            }
        }
    }

    /* renamed from: d.a.w0.p.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1948b {
        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-990268465, "Ld/a/w0/p/i/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-990268465, "Ld/a/w0/p/i/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f68919c;
            if (i2 != 0) {
                return i2;
            }
            int i3 = this.f68918b;
            return i3 != 0 ? i3 : this.f68917a;
        }
        return invokeV.intValue;
    }

    public synchronized void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this) {
                if (i2 == this.f68919c) {
                    return;
                }
                if ((this.f68918b == 0 || i2 != this.f68918b) && (this.f68918b != 0 || i2 != this.f68917a)) {
                    this.f68919c = i2;
                    if (i2 != 0 && !this.f68920d) {
                        this.f68920d = true;
                        g();
                    }
                }
                this.f68919c = 0;
            }
        }
    }

    public void c(InterfaceC1948b interfaceC1948b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1948b) == null) {
            this.f68921e = interfaceC1948b;
        }
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f68919c != this.f68917a) {
                    this.f68918b = this.f68919c;
                }
                this.f68919c = 0;
            }
        }
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f68918b != 0) {
                    this.f68917a = this.f68918b;
                }
                this.f68918b = 0;
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ThreadPool.b().e(new a(this));
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                this.f68920d = false;
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        while (true) {
            e();
            int i2 = this.f68918b;
            if (i2 == 0) {
                h();
                return;
            }
            InterfaceC1948b interfaceC1948b = this.f68921e;
            if (interfaceC1948b != null) {
                interfaceC1948b.a(i2);
            }
            f();
        }
    }
}
