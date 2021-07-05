package d.a.y0.p.c;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.y0.p.f.c;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f71291a;

    /* renamed from: b  reason: collision with root package name */
    public c f71292b;

    /* renamed from: c  reason: collision with root package name */
    public b f71293c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.y0.p.g.c f71294d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71295e;

    /* renamed from: d.a.y0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1976a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f71296e;

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
            this.f71296e = aVar;
        }

        public /* synthetic */ b(a aVar, C1976a c1976a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f71296e.f71292b = new c(-100);
                        if (this.f71296e.f71292b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f71399d);
                            this.f71296e.f71292b.c();
                            if (this.f71296e.f71292b.e() != 3) {
                                return;
                            }
                            while (!this.f71296e.f71291a) {
                                allocateDirect.clear();
                                int a2 = this.f71296e.f71292b.a(allocateDirect, c.f71399d);
                                if (a2 > 0) {
                                    double a3 = d.a.y0.p.i.a.a(allocateDirect, a2);
                                    if (this.f71296e.f71294d != null && a3 > 0.0d) {
                                        this.f71296e.f71294d.a(a3);
                                    }
                                }
                            }
                        } else if (this.f71296e.f71294d != null) {
                            this.f71296e.f71294d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f71296e.f71294d != null) {
                            this.f71296e.f71294d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f71296e.i();
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
        this.f71291a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f71295e = true;
            this.f71291a = false;
            b bVar = new b(this, null);
            this.f71293c = bVar;
            bVar.start();
        }
    }

    public void d(d.a.y0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f71294d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f71291a = true;
            this.f71295e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71295e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f71291a = false;
            this.f71295e = false;
            c cVar = this.f71292b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f71293c != null) {
                this.f71293c = null;
            }
        }
    }
}
