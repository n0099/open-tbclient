package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ak3;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class kj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kj3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public tj3 a;
    public ConcurrentLinkedQueue<oj3> b;
    public volatile boolean c;
    public yj3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yj3 b;
        public final /* synthetic */ kj3 c;

        public a(kj3 kj3Var, String str, yj3 yj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kj3Var, str, yj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kj3Var;
            this.a = str;
            this.b = yj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xc4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ak3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kj3 a;

        public b(kj3 kj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kj3Var;
        }

        @Override // com.repackage.ak3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            rj3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (ej3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = vj3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (ej3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (ej3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (ej3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        jj3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (uj3.a(this.a.a, f) != null) {
                                        if (ej3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        jj3.a("serverHello");
                                        while (true) {
                                            oj3 oj3Var = (oj3) this.a.b.poll();
                                            if (oj3Var == null) {
                                                return;
                                            }
                                            this.a.g(oj3Var.b(), oj3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (ej3.a) {
                            e.printStackTrace();
                            Log.d("BDTLS", "exception=" + e.getMessage());
                        }
                    }
                    this.a.n(str);
                } finally {
                    this.a.c = false;
                }
            }
        }
    }

    public kj3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new tj3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static kj3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (kj3.class) {
                    if (e == null) {
                        e = new kj3();
                    }
                }
            }
            return e;
        }
        return (kj3) invokeV.objValue;
    }

    public final void g(String str, yj3 yj3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, yj3Var) == null) {
            if (yj3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(yj3Var.b(), "POST")) {
                o(-1, yj3Var);
            } else {
                if (ej3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(yj3Var.b(), "GET")) {
                    b2 = ij3.f().b(this.a, null);
                } else {
                    b2 = ij3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (ej3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    yj3Var.i(true);
                    this.d = yj3Var;
                    yj3Var.h(b2);
                    return;
                }
                o(-1, yj3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (ej3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (ej3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = ij3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new ak3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, yj3 yj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, yj3Var) == null) {
            if (yj3Var != null && TextUtils.equals(yj3Var.b(), "GET")) {
                if (ej3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                yj3Var.i(false);
                this.d = yj3Var;
                yj3Var.h(null);
            } else if (yj3Var != null && str != null) {
                if (ej3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                yj3Var.i(false);
                this.d = yj3Var;
                yj3Var.h(str.getBytes());
            } else {
                o(-1, yj3Var);
            }
        }
    }

    public final void j(String str, yj3 yj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, yj3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new oj3(str, yj3Var));
                    if (hu2.c()) {
                        pj3 pj3Var = new pj3();
                        long j = pj3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(pj3Var.getString("secretKey", "").getBytes());
                            this.a.t(pj3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, yj3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, yj3Var);
                return;
            }
            i(str, yj3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            yj3 yj3Var = this.d;
            if (yj3Var == null) {
                return false;
            }
            return yj3Var.c();
        }
        return invokeV.booleanValue;
    }

    public tj3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new tj3();
            }
            return this.a;
        }
        return (tj3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (ej3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            oj3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                yj3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, yj3 yj3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, yj3Var) == null) || yj3Var == null) {
            return;
        }
        yj3Var.f(i);
    }

    public void p(String str, yj3 yj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, yj3Var) == null) {
            dd3.l(new a(this, str, yj3Var), "SessionController");
        }
    }
}
