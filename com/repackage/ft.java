package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dt;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes6.dex */
public class ft {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ft d;
    public transient /* synthetic */ FieldHolder $fh;
    public ws a;
    public ConcurrentLinkedQueue<rs> b;
    public volatile boolean c;

    /* loaded from: classes6.dex */
    public static class a implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                System.loadLibrary("bdptask");
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ct b;
        public final /* synthetic */ ft c;

        public b(ft ftVar, String str, ct ctVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ftVar, str, ctVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ftVar;
            this.a = str;
            this.b = ctVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.l(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dt.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft a;

        public c(ft ftVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ftVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ftVar;
        }

        @Override // com.repackage.dt.b
        public void a(boolean z, byte[] bArr) {
            us a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        DebugTrace.a.a("doHandShake response");
                        if (z && bArr != null && (a = zs.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] o = a.o();
                            if (o != null) {
                                DebugTrace debugTrace = DebugTrace.a;
                                debugTrace.a("doHandShake response schemeType =" + ((int) i));
                                if (i == 21) {
                                    DebugTrace.a.a("doHandShake alert");
                                    ks a2 = ks.a(o);
                                    if (a2 != null) {
                                        DebugTrace.a.a("bdtls ubc handshake alert");
                                        if (a2.b() != null) {
                                            str = a2.b();
                                        }
                                    }
                                } else if (i == 22) {
                                    if (ys.a(this.a.a, o) != null) {
                                        DebugTrace.a.a("doHandShake serverHello");
                                        this.a.a.b(1);
                                        while (true) {
                                            rs rsVar = (rs) this.a.b.poll();
                                            if (rsVar == null) {
                                                return;
                                            }
                                            this.a.n(rsVar.a(), rsVar.b());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        DebugTrace debugTrace2 = DebugTrace.a;
                        debugTrace2.a("exception=" + e.getMessage());
                    }
                    this.a.f(str);
                } finally {
                    this.a.c = false;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964039945, "Lcom/repackage/ft;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964039945, "Lcom/repackage/ft;");
                return;
            }
        }
        nu.a(new a());
        d = new ft();
    }

    public ft() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ws();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static ft b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d : (ft) invokeV.objValue;
    }

    public final void c(int i, ct ctVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, ctVar) == null) || ctVar == null) {
            return;
        }
        ctVar.b(i);
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
            return;
        }
        DebugTrace.a.a("onHandshakeError");
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.b(i);
        while (true) {
            rs poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                o(poll.a(), poll.b());
            } else {
                ct b2 = poll.b();
                if (b2 != null) {
                    b2.c(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public void g(String str, ct ctVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ctVar) == null) {
            ExecutorUtilsExt.postOnSerial(new b(this, str, ctVar), "SessionController");
        }
    }

    public ws i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                this.a = new ws();
            }
            return this.a;
        }
        return (ws) invokeV.objValue;
    }

    public final void l(String str, ct ctVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, ctVar) == null) {
            if (this.a.a() != 2) {
                if (!this.a.k()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new rs(str, ctVar));
                    m();
                    return;
                }
                n(str, ctVar);
                return;
            }
            o(str, ctVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DebugTrace.a.a("doHandShake");
            if (this.c) {
                DebugTrace.a.a("doHandShake isHandshakeRunning");
                return;
            }
            this.c = true;
            byte[] e = et.c().e(this.a);
            if (e != null && e.length > 0) {
                new dt().a(e, new c(this));
                return;
            }
            this.c = false;
            f("record data error");
        }
    }

    public final void n(String str, ct ctVar) {
        byte[] f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, ctVar) == null) {
            if (str != null && ctVar != null) {
                if (TextUtils.equals(ctVar.a(), "GET")) {
                    f = et.c().f(this.a, null);
                } else {
                    f = et.c().f(this.a, str);
                }
                if (f != null) {
                    DebugTrace.a.a("doBdtlsApplicationDataRequest");
                    ctVar.e(true);
                    ctVar.f(f);
                    return;
                }
                c(-1, ctVar);
                return;
            }
            c(-1, null);
        }
    }

    public final void o(String str, ct ctVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, ctVar) == null) {
            if (ctVar != null && str != null) {
                DebugTrace.a.a("doNormalApplicationDataRequest");
                ctVar.e(false);
                ctVar.f(str.getBytes());
                return;
            }
            c(-1, ctVar);
        }
    }
}
