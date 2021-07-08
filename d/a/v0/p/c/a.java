package d.a.v0.p.c;

import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.v0.p.f.c;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f68094a;

    /* renamed from: b  reason: collision with root package name */
    public c f68095b;

    /* renamed from: c  reason: collision with root package name */
    public b f68096c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.v0.p.g.c f68097d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68098e;

    /* renamed from: d.a.v0.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1935a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68099e;

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
            this.f68099e = aVar;
        }

        public /* synthetic */ b(a aVar, C1935a c1935a) {
            this(aVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                try {
                    try {
                        this.f68099e.f68095b = new c(-100);
                        if (this.f68099e.f68095b.d() != null) {
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(c.f68202d);
                            this.f68099e.f68095b.c();
                            if (this.f68099e.f68095b.e() != 3) {
                                return;
                            }
                            while (!this.f68099e.f68094a) {
                                allocateDirect.clear();
                                int a2 = this.f68099e.f68095b.a(allocateDirect, c.f68202d);
                                if (a2 > 0) {
                                    double a3 = d.a.v0.p.i.a.a(allocateDirect, a2);
                                    if (this.f68099e.f68097d != null && a3 > 0.0d) {
                                        this.f68099e.f68097d.a(a3);
                                    }
                                }
                            }
                        } else if (this.f68099e.f68097d != null) {
                            this.f68099e.f68097d.a("failed to initialize AudioRecord", true);
                        }
                    } catch (Exception unused) {
                        if (this.f68099e.f68097d != null) {
                            this.f68099e.f68097d.a("failed to initialize AudioRecord", true);
                        }
                    }
                } finally {
                    this.f68099e.i();
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
        this.f68094a = false;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68098e = true;
            this.f68094a = false;
            b bVar = new b(this, null);
            this.f68096c = bVar;
            bVar.start();
        }
    }

    public void d(d.a.v0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f68097d = cVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f68094a = true;
            this.f68098e = false;
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68098e : invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f68094a = false;
            this.f68098e = false;
            c cVar = this.f68095b;
            if (cVar != null) {
                cVar.b();
            }
            if (this.f68096c != null) {
                this.f68096c = null;
            }
        }
    }
}
