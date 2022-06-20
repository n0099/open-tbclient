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
import com.repackage.jj3;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class ti3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ti3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public cj3 a;
    public ConcurrentLinkedQueue<xi3> b;
    public volatile boolean c;
    public hj3 d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hj3 b;
        public final /* synthetic */ ti3 c;

        public a(ti3 ti3Var, String str, hj3 hj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti3Var, str, hj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ti3Var;
            this.a = str;
            this.b = hj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fc4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements jj3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ti3 a;

        public b(ti3 ti3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ti3Var;
        }

        @Override // com.repackage.jj3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            aj3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (ni3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = ej3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (ni3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (ni3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (ni3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        si3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (dj3.a(this.a.a, f) != null) {
                                        if (ni3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        si3.a("serverHello");
                                        while (true) {
                                            xi3 xi3Var = (xi3) this.a.b.poll();
                                            if (xi3Var == null) {
                                                return;
                                            }
                                            this.a.g(xi3Var.b(), xi3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (ni3.a) {
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

    public ti3() {
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
        this.a = new cj3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static ti3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ti3.class) {
                    if (e == null) {
                        e = new ti3();
                    }
                }
            }
            return e;
        }
        return (ti3) invokeV.objValue;
    }

    public final void g(String str, hj3 hj3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, hj3Var) == null) {
            if (hj3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(hj3Var.b(), "POST")) {
                o(-1, hj3Var);
            } else {
                if (ni3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(hj3Var.b(), "GET")) {
                    b2 = ri3.f().b(this.a, null);
                } else {
                    b2 = ri3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (ni3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    hj3Var.i(true);
                    this.d = hj3Var;
                    hj3Var.h(b2);
                    return;
                }
                o(-1, hj3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (ni3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (ni3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = ri3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new jj3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, hj3 hj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hj3Var) == null) {
            if (hj3Var != null && TextUtils.equals(hj3Var.b(), "GET")) {
                if (ni3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                hj3Var.i(false);
                this.d = hj3Var;
                hj3Var.h(null);
            } else if (hj3Var != null && str != null) {
                if (ni3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                hj3Var.i(false);
                this.d = hj3Var;
                hj3Var.h(str.getBytes());
            } else {
                o(-1, hj3Var);
            }
        }
    }

    public final void j(String str, hj3 hj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hj3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new xi3(str, hj3Var));
                    if (qt2.c()) {
                        yi3 yi3Var = new yi3();
                        long j = yi3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(yi3Var.getString("secretKey", "").getBytes());
                            this.a.t(yi3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, hj3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, hj3Var);
                return;
            }
            i(str, hj3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            hj3 hj3Var = this.d;
            if (hj3Var == null) {
                return false;
            }
            return hj3Var.c();
        }
        return invokeV.booleanValue;
    }

    public cj3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new cj3();
            }
            return this.a;
        }
        return (cj3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (ni3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            xi3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                hj3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, hj3 hj3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, hj3Var) == null) || hj3Var == null) {
            return;
        }
        hj3Var.f(i);
    }

    public void p(String str, hj3 hj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, hj3Var) == null) {
            mc3.l(new a(this, str, hj3Var), "SessionController");
        }
    }
}
