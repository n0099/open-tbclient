package d.a.n0.c.a;

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
import d.a.n0.a.v2.q;
import d.a.n0.c.a.k.e;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f49083e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.c.a.i.g f49084a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<d.a.n0.c.a.i.c> f49085b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f49086c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.c.a.k.c f49087d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.c.a.k.c f49089f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f49090g;

        public a(g gVar, String str, d.a.n0.c.a.k.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49090g = gVar;
            this.f49088e = str;
            this.f49089f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.n.j.j.b.c().d();
                this.f49090g.j(this.f49088e, this.f49089f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f49091a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49091a = gVar;
        }

        @Override // d.a.n0.c.a.k.e.b
        public void a(boolean z, byte[] bArr) {
            String str;
            d.a.n0.c.a.i.e a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (d.a.n0.c.a.a.f49075a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a2 = d.a.n0.c.a.j.b.a(bArr)) != null) {
                            byte i2 = a2.i();
                            byte[] f2 = a2.f();
                            if (f2 != null) {
                                if (d.a.n0.c.a.a.f49075a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i2));
                                }
                                if (i2 == 21) {
                                    if (d.a.n0.c.a.a.f49075a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f2);
                                    if (parseFrom != null) {
                                        if (d.a.n0.c.a.a.f49075a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        f.b(this.f49091a.f49084a, parseFrom);
                                    }
                                } else if (i2 == 22) {
                                    if (d.a.n0.c.a.j.a.a(this.f49091a.f49084a, f2) != null) {
                                        if (d.a.n0.c.a.a.f49075a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.f49091a.f49084a.s(1);
                                        f.a("serverHello");
                                        while (true) {
                                            d.a.n0.c.a.i.c cVar = (d.a.n0.c.a.i.c) this.f49091a.f49085b.poll();
                                            if (cVar == null) {
                                                return;
                                            }
                                            this.f49091a.g(cVar.b(), cVar.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (d.a.n0.c.a.a.f49075a) {
                            e2.printStackTrace();
                            Log.d("BDTLS", "exception=" + e2.getMessage());
                        }
                    }
                    this.f49091a.n(str);
                } finally {
                    this.f49091a.f49086c = false;
                }
            }
        }
    }

    public g() {
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
        this.f49084a = new d.a.n0.c.a.i.g();
        this.f49086c = false;
        this.f49085b = new ConcurrentLinkedQueue<>();
    }

    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f49083e == null) {
                synchronized (g.class) {
                    if (f49083e == null) {
                        f49083e = new g();
                    }
                }
            }
            return f49083e;
        }
        return (g) invokeV.objValue;
    }

    public final void g(String str, d.a.n0.c.a.k.c cVar) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (cVar == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(cVar.b(), "POST")) {
                o(-1, cVar);
            } else {
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(cVar.b(), "GET")) {
                    b2 = e.f().b(this.f49084a, null);
                } else {
                    b2 = e.f().b(this.f49084a, str);
                }
                if (b2 != null) {
                    if (d.a.n0.c.a.a.f49075a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    cVar.i(true);
                    this.f49087d = cVar;
                    cVar.h(b2);
                    return;
                }
                o(-1, cVar);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (d.a.n0.c.a.a.f49075a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.f49086c) {
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.f49086c = true;
            byte[] e2 = e.f().e(this.f49084a);
            if (e2 != null && e2.length > 0) {
                new d.a.n0.c.a.k.e().a(e2, new b(this));
                return;
            }
            this.f49086c = false;
            n("record data error");
        }
    }

    public final void i(String str, d.a.n0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (cVar != null && TextUtils.equals(cVar.b(), "GET")) {
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                cVar.i(false);
                this.f49087d = cVar;
                cVar.h(null);
            } else if (cVar != null && str != null) {
                if (d.a.n0.c.a.a.f49075a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                cVar.i(false);
                this.f49087d = cVar;
                cVar.h(str.getBytes());
            } else {
                o(-1, cVar);
            }
        }
    }

    public final void j(String str, d.a.n0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            if (this.f49084a.h() != 2) {
                if (!this.f49084a.j()) {
                    if (this.f49085b == null) {
                        this.f49085b = new ConcurrentLinkedQueue<>();
                    }
                    this.f49085b.offer(new d.a.n0.c.a.i.c(str, cVar));
                    h();
                    return;
                }
                g(str, cVar);
                return;
            }
            i(str, cVar);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.n0.c.a.k.c cVar = this.f49087d;
            if (cVar == null) {
                return false;
            }
            return cVar.c();
        }
        return invokeV.booleanValue;
    }

    public d.a.n0.c.a.i.g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f49084a == null) {
                this.f49084a = new d.a.n0.c.a.i.g();
            }
            return this.f49084a;
        }
        return (d.a.n0.c.a.i.g) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (d.a.n0.c.a.a.f49075a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i2 = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.f49084a.s(i2);
        while (true) {
            d.a.n0.c.a.i.c poll = this.f49085b.poll();
            if (poll == null) {
                return;
            }
            if (i2 == 2) {
                i(poll.b(), poll.a());
            } else {
                d.a.n0.c.a.k.c a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i2, d.a.n0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, cVar) == null) || cVar == null) {
            return;
        }
        cVar.f(i2);
    }

    public void p(String str, d.a.n0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cVar) == null) {
            q.k(new a(this, str, cVar), "SessionController");
        }
    }
}
