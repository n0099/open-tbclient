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
import com.repackage.zj3;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class jj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jj3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public sj3 a;
    public ConcurrentLinkedQueue<nj3> b;
    public volatile boolean c;
    public xj3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xj3 b;
        public final /* synthetic */ jj3 c;

        public a(jj3 jj3Var, String str, xj3 xj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj3Var, str, xj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jj3Var;
            this.a = str;
            this.b = xj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vc4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zj3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jj3 a;

        public b(jj3 jj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jj3Var;
        }

        @Override // com.repackage.zj3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            qj3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (dj3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = uj3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (dj3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (dj3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (dj3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        ij3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (tj3.a(this.a.a, f) != null) {
                                        if (dj3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        ij3.a("serverHello");
                                        while (true) {
                                            nj3 nj3Var = (nj3) this.a.b.poll();
                                            if (nj3Var == null) {
                                                return;
                                            }
                                            this.a.g(nj3Var.b(), nj3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (dj3.a) {
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

    public jj3() {
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
        this.a = new sj3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static jj3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (jj3.class) {
                    if (e == null) {
                        e = new jj3();
                    }
                }
            }
            return e;
        }
        return (jj3) invokeV.objValue;
    }

    public final void g(String str, xj3 xj3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, xj3Var) == null) {
            if (xj3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(xj3Var.b(), "POST")) {
                o(-1, xj3Var);
            } else {
                if (dj3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(xj3Var.b(), "GET")) {
                    b2 = hj3.f().b(this.a, null);
                } else {
                    b2 = hj3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (dj3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    xj3Var.i(true);
                    this.d = xj3Var;
                    xj3Var.h(b2);
                    return;
                }
                o(-1, xj3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (dj3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (dj3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = hj3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new zj3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, xj3 xj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xj3Var) == null) {
            if (xj3Var != null && TextUtils.equals(xj3Var.b(), "GET")) {
                if (dj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                xj3Var.i(false);
                this.d = xj3Var;
                xj3Var.h(null);
            } else if (xj3Var != null && str != null) {
                if (dj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                xj3Var.i(false);
                this.d = xj3Var;
                xj3Var.h(str.getBytes());
            } else {
                o(-1, xj3Var);
            }
        }
    }

    public final void j(String str, xj3 xj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, xj3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new nj3(str, xj3Var));
                    if (gu2.c()) {
                        oj3 oj3Var = new oj3();
                        long j = oj3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(oj3Var.getString("secretKey", "").getBytes());
                            this.a.t(oj3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, xj3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, xj3Var);
                return;
            }
            i(str, xj3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            xj3 xj3Var = this.d;
            if (xj3Var == null) {
                return false;
            }
            return xj3Var.c();
        }
        return invokeV.booleanValue;
    }

    public sj3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new sj3();
            }
            return this.a;
        }
        return (sj3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (dj3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            nj3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                xj3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, xj3 xj3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, xj3Var) == null) || xj3Var == null) {
            return;
        }
        xj3Var.f(i);
    }

    public void p(String str, xj3 xj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, xj3Var) == null) {
            cd3.l(new a(this, str, xj3Var), "SessionController");
        }
    }
}
