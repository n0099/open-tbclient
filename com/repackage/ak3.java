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
import com.repackage.qk3;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class ak3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ak3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public jk3 a;
    public ConcurrentLinkedQueue<ek3> b;
    public volatile boolean c;
    public ok3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ok3 b;
        public final /* synthetic */ ak3 c;

        public a(ak3 ak3Var, String str, ok3 ok3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak3Var, str, ok3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ak3Var;
            this.a = str;
            this.b = ok3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                md4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qk3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak3 a;

        public b(ak3 ak3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak3Var;
        }

        @Override // com.repackage.qk3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            hk3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (uj3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = lk3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (uj3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (uj3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (uj3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        zj3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (kk3.a(this.a.a, f) != null) {
                                        if (uj3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        zj3.a("serverHello");
                                        while (true) {
                                            ek3 ek3Var = (ek3) this.a.b.poll();
                                            if (ek3Var == null) {
                                                return;
                                            }
                                            this.a.g(ek3Var.b(), ek3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (uj3.a) {
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

    public ak3() {
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
        this.a = new jk3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static ak3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ak3.class) {
                    if (e == null) {
                        e = new ak3();
                    }
                }
            }
            return e;
        }
        return (ak3) invokeV.objValue;
    }

    public final void g(String str, ok3 ok3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ok3Var) == null) {
            if (ok3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(ok3Var.b(), "POST")) {
                o(-1, ok3Var);
            } else {
                if (uj3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(ok3Var.b(), "GET")) {
                    b2 = yj3.f().b(this.a, null);
                } else {
                    b2 = yj3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (uj3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    ok3Var.i(true);
                    this.d = ok3Var;
                    ok3Var.h(b2);
                    return;
                }
                o(-1, ok3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (uj3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (uj3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = yj3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new qk3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, ok3 ok3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ok3Var) == null) {
            if (ok3Var != null && TextUtils.equals(ok3Var.b(), "GET")) {
                if (uj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ok3Var.i(false);
                this.d = ok3Var;
                ok3Var.h(null);
            } else if (ok3Var != null && str != null) {
                if (uj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ok3Var.i(false);
                this.d = ok3Var;
                ok3Var.h(str.getBytes());
            } else {
                o(-1, ok3Var);
            }
        }
    }

    public final void j(String str, ok3 ok3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ok3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new ek3(str, ok3Var));
                    if (xu2.c()) {
                        fk3 fk3Var = new fk3();
                        long j = fk3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(fk3Var.getString("secretKey", "").getBytes());
                            this.a.t(fk3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, ok3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, ok3Var);
                return;
            }
            i(str, ok3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ok3 ok3Var = this.d;
            if (ok3Var == null) {
                return false;
            }
            return ok3Var.c();
        }
        return invokeV.booleanValue;
    }

    public jk3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new jk3();
            }
            return this.a;
        }
        return (jk3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (uj3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            ek3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                ok3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, ok3 ok3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, ok3Var) == null) || ok3Var == null) {
            return;
        }
        ok3Var.f(i);
    }

    public void p(String str, ok3 ok3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ok3Var) == null) {
            td3.l(new a(this, str, ok3Var), "SessionController");
        }
    }
}
