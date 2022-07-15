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
import com.repackage.yj3;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class ij3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ij3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public rj3 a;
    public ConcurrentLinkedQueue<mj3> b;
    public volatile boolean c;
    public wj3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wj3 b;
        public final /* synthetic */ ij3 c;

        public a(ij3 ij3Var, String str, wj3 wj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij3Var, str, wj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ij3Var;
            this.a = str;
            this.b = wj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uc4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yj3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij3 a;

        public b(ij3 ij3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij3Var;
        }

        @Override // com.repackage.yj3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            pj3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (cj3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = tj3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (cj3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (cj3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (cj3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        hj3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (sj3.a(this.a.a, f) != null) {
                                        if (cj3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        hj3.a("serverHello");
                                        while (true) {
                                            mj3 mj3Var = (mj3) this.a.b.poll();
                                            if (mj3Var == null) {
                                                return;
                                            }
                                            this.a.g(mj3Var.b(), mj3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (cj3.a) {
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

    public ij3() {
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
        this.a = new rj3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static ij3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ij3.class) {
                    if (e == null) {
                        e = new ij3();
                    }
                }
            }
            return e;
        }
        return (ij3) invokeV.objValue;
    }

    public final void g(String str, wj3 wj3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, wj3Var) == null) {
            if (wj3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(wj3Var.b(), "POST")) {
                o(-1, wj3Var);
            } else {
                if (cj3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(wj3Var.b(), "GET")) {
                    b2 = gj3.f().b(this.a, null);
                } else {
                    b2 = gj3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (cj3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    wj3Var.i(true);
                    this.d = wj3Var;
                    wj3Var.h(b2);
                    return;
                }
                o(-1, wj3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (cj3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (cj3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = gj3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new yj3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, wj3 wj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, wj3Var) == null) {
            if (wj3Var != null && TextUtils.equals(wj3Var.b(), "GET")) {
                if (cj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                wj3Var.i(false);
                this.d = wj3Var;
                wj3Var.h(null);
            } else if (wj3Var != null && str != null) {
                if (cj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                wj3Var.i(false);
                this.d = wj3Var;
                wj3Var.h(str.getBytes());
            } else {
                o(-1, wj3Var);
            }
        }
    }

    public final void j(String str, wj3 wj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wj3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new mj3(str, wj3Var));
                    if (fu2.c()) {
                        nj3 nj3Var = new nj3();
                        long j = nj3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(nj3Var.getString("secretKey", "").getBytes());
                            this.a.t(nj3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, wj3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, wj3Var);
                return;
            }
            i(str, wj3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            wj3 wj3Var = this.d;
            if (wj3Var == null) {
                return false;
            }
            return wj3Var.c();
        }
        return invokeV.booleanValue;
    }

    public rj3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new rj3();
            }
            return this.a;
        }
        return (rj3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (cj3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            mj3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                wj3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, wj3 wj3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, wj3Var) == null) || wj3Var == null) {
            return;
        }
        wj3Var.f(i);
    }

    public void p(String str, wj3 wj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, wj3Var) == null) {
            bd3.l(new a(this, str, wj3Var), "SessionController");
        }
    }
}
