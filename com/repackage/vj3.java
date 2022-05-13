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
import com.repackage.lk3;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class vj3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vj3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ek3 a;
    public ConcurrentLinkedQueue<zj3> b;
    public volatile boolean c;
    public jk3 d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jk3 b;
        public final /* synthetic */ vj3 c;

        public a(vj3 vj3Var, String str, jk3 jk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj3Var, str, jk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vj3Var;
            this.a = str;
            this.b = jk3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hd4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements lk3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj3 a;

        public b(vj3 vj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj3Var;
        }

        @Override // com.repackage.lk3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            ck3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (pj3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = gk3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (pj3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (pj3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (pj3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        uj3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (fk3.a(this.a.a, f) != null) {
                                        if (pj3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        uj3.a("serverHello");
                                        while (true) {
                                            zj3 zj3Var = (zj3) this.a.b.poll();
                                            if (zj3Var == null) {
                                                return;
                                            }
                                            this.a.g(zj3Var.b(), zj3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (pj3.a) {
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

    public vj3() {
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
        this.a = new ek3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static vj3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (vj3.class) {
                    if (e == null) {
                        e = new vj3();
                    }
                }
            }
            return e;
        }
        return (vj3) invokeV.objValue;
    }

    public final void g(String str, jk3 jk3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jk3Var) == null) {
            if (jk3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(jk3Var.b(), "POST")) {
                o(-1, jk3Var);
            } else {
                if (pj3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(jk3Var.b(), "GET")) {
                    b2 = tj3.f().b(this.a, null);
                } else {
                    b2 = tj3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (pj3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    jk3Var.i(true);
                    this.d = jk3Var;
                    jk3Var.h(b2);
                    return;
                }
                o(-1, jk3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (pj3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (pj3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = tj3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new lk3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, jk3 jk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jk3Var) == null) {
            if (jk3Var != null && TextUtils.equals(jk3Var.b(), "GET")) {
                if (pj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                jk3Var.i(false);
                this.d = jk3Var;
                jk3Var.h(null);
            } else if (jk3Var != null && str != null) {
                if (pj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                jk3Var.i(false);
                this.d = jk3Var;
                jk3Var.h(str.getBytes());
            } else {
                o(-1, jk3Var);
            }
        }
    }

    public final void j(String str, jk3 jk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jk3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new zj3(str, jk3Var));
                    if (su2.c()) {
                        ak3 ak3Var = new ak3();
                        long j = ak3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(ak3Var.getString("secretKey", "").getBytes());
                            this.a.t(ak3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, jk3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, jk3Var);
                return;
            }
            i(str, jk3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            jk3 jk3Var = this.d;
            if (jk3Var == null) {
                return false;
            }
            return jk3Var.c();
        }
        return invokeV.booleanValue;
    }

    public ek3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ek3();
            }
            return this.a;
        }
        return (ek3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (pj3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            zj3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                jk3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, jk3 jk3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, jk3Var) == null) || jk3Var == null) {
            return;
        }
        jk3Var.f(i);
    }

    public void p(String str, jk3 jk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, jk3Var) == null) {
            od3.l(new a(this, str, jk3Var), "SessionController");
        }
    }
}
