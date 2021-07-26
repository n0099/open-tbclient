package d.a.w0.p.c;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w0.p.f.c;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f68772a;

    /* renamed from: b  reason: collision with root package name */
    public c f68773b;

    /* renamed from: c  reason: collision with root package name */
    public b f68774c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.w0.p.g.c f68775d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68776e;

    /* renamed from: d.a.w0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1940a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68777e;

        public b(a aVar) {
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
            this.f68777e = aVar;
        }

        public /* synthetic */ b(a aVar, C1940a c1940a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f68777e.f68773b = new c(-100);
                        if (this.f68777e.f68773b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f68880d);
                            this.f68777e.f68773b.c();
                            if (this.f68777e.f68773b.e() != 3) {
                                return;
                            }
                            while (!this.f68777e.f68772a) {
                                allocateDirect.clear();
                                int a2 = this.f68777e.f68773b.a(allocateDirect, c.f68880d);
                                if (a2 > 0) {
                                    double a3 = d.a.w0.p.i.a.a(allocateDirect, a2);
                                    if (this.f68777e.f68775d != null && a3 > 0.0d) {
                                        this.f68777e.f68775d.a(a3);
                                    }
                                }
                            }
                        } else if (this.f68777e.f68775d != null) {
                            this.f68777e.f68775d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f68777e.f68775d != null) {
                            this.f68777e.f68775d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f68777e.i();
                }
            }
        }
    }

    public a() {
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
        this.f68772a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68776e = true;
            this.f68772a = false;
            b bVar = new b(this, null);
            this.f68774c = bVar;
            bVar.start();
        }
    }

    public void d(d.a.w0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f68775d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f68772a = true;
            this.f68776e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68776e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f68772a = false;
            this.f68776e = false;
            c cVar = this.f68773b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f68774c != null) {
                this.f68774c = null;
            }
        }
    }
}
