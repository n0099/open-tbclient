package d.a.c.e.r;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.r.e;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f41554a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e0 f41555b;

    /* renamed from: c  reason: collision with root package name */
    public volatile g0 f41556c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f41557d;

    /* renamed from: e  reason: collision with root package name */
    public URI f41558e;

    /* renamed from: f  reason: collision with root package name */
    public String f41559f;

    /* renamed from: g  reason: collision with root package name */
    public String f41560g;

    /* renamed from: h  reason: collision with root package name */
    public int f41561h;

    /* renamed from: i  reason: collision with root package name */
    public String f41562i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public g m;
    public d0 n;
    public boolean o;
    public boolean p;
    public volatile boolean q;
    public long r;
    public c s;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f41563a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41563a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String message2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof c0) {
                    c0 c0Var = (c0) obj;
                    if (this.f41563a.m != null) {
                        this.f41563a.m.a(c0Var.f41501a);
                    }
                } else if (obj instanceof w) {
                    w wVar = (w) obj;
                    if (this.f41563a.m != null) {
                        this.f41563a.m.d(wVar.f41583a);
                    } else if (this.f41563a.D()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof k) {
                    k kVar = (k) obj;
                    if (this.f41563a.m != null) {
                        this.f41563a.m.f(kVar);
                    } else if (this.f41563a.D()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof t) {
                    u uVar = new u();
                    uVar.f41581a = ((t) obj).f41580a;
                    this.f41563a.f41556c.b(uVar);
                } else if (obj instanceof u) {
                    u uVar2 = (u) obj;
                    if (this.f41563a.m != null) {
                        this.f41563a.m.e();
                    }
                } else {
                    if (obj instanceof m) {
                        this.f41563a.q(1, null);
                    } else if (obj instanceof a0) {
                        a0 a0Var = (a0) obj;
                        if (a0Var.f41497a) {
                            if (this.f41563a.m != null) {
                                this.f41563a.m.onOpen(a0Var.f41498b);
                                this.f41563a.o = true;
                                this.f41563a.p = false;
                                if (this.f41563a.m != null) {
                                    this.f41563a.m.c(null);
                                    return;
                                }
                                return;
                            }
                            this.f41563a.q(6, "handler already NULL");
                        }
                    } else if (obj instanceof n) {
                        SocketException socketException = ((n) obj).f41576a;
                        message2 = socketException != null ? socketException.getMessage() : null;
                        i iVar = this.f41563a;
                        iVar.q(3, "WebSockets connection lost = " + message2);
                    } else if (obj instanceof v) {
                        WebSocketException webSocketException = ((v) obj).f41582a;
                        message2 = webSocketException != null ? webSocketException.getMessage() : null;
                        i iVar2 = this.f41563a;
                        iVar2.q(4, "WebSockets protocol violation error = " + message2);
                    } else if (obj instanceof p) {
                        i iVar3 = this.f41563a;
                        iVar3.q(5, "WebSockets internal error (" + ((p) obj).f41578a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof z) {
                        z zVar = (z) obj;
                        i iVar4 = this.f41563a;
                        iVar4.q(6, "Server error " + zVar.f41585a + " (" + zVar.f41586b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof o) {
                        i iVar5 = this.f41563a;
                        iVar5.q(2, "WebSockets connot connect:" + ((o) obj).f41577a);
                    } else if (obj instanceof b0) {
                        if (this.f41563a.m != null) {
                            this.f41563a.m.i(((b0) message.obj).f41584a);
                        }
                    } else if (obj instanceof q) {
                        this.f41563a.s = null;
                        c cVar = ((q) message.obj).f41584a;
                        if (this.f41563a.m != null) {
                            this.f41563a.m.h(cVar);
                        }
                        if (this.f41563a.m != null) {
                            this.f41563a.m.c(cVar);
                        }
                    } else if (obj instanceof x) {
                        this.f41563a.s = null;
                        c cVar2 = ((x) message.obj).f41584a;
                        if (this.f41563a.m != null) {
                            this.f41563a.m.g(2, cVar2);
                        }
                        if (this.f41563a.m != null) {
                            this.f41563a.m.c(cVar2);
                        }
                    } else {
                        this.f41563a.G(obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f41564e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41564e = iVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    e eVar = new e();
                    this.f41564e.f41557d = eVar.a(this.f41564e.f41560g, this.f41564e.f41561h, this.f41564e.n, false);
                    if (this.f41564e.q) {
                        this.f41564e.H(new m());
                        return;
                    }
                    try {
                        if (!this.f41564e.f41557d.isConnected()) {
                            this.f41564e.H(new o(2, "cannot connect"));
                            return;
                        }
                        this.f41564e.r = System.currentTimeMillis() - currentTimeMillis;
                        this.f41564e.t();
                        this.f41564e.u();
                        l lVar = new l(this.f41564e.f41560g + ":" + this.f41564e.f41561h);
                        lVar.f41569b = this.f41564e.f41562i;
                        lVar.f41570c = this.f41564e.j;
                        lVar.f41572e = this.f41564e.k;
                        lVar.f41573f = this.f41564e.l;
                        this.f41564e.f41556c.b(lVar);
                        if (this.f41564e.q) {
                            this.f41564e.H(new m());
                        }
                    } catch (Throwable th) {
                        if (this.f41564e.D()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.f41564e.H(new p(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.f41564e.H(new o(2, th2.getMessage()));
                }
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    public i() {
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
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = 0L;
        this.s = null;
        s();
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e.a aVar = this.f41557d;
            if (aVar != null) {
                return aVar.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e.a aVar = this.f41557d;
            if (aVar != null) {
                return aVar.d();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BdBaseApplication.getInst().isDebugMode() : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s != null : invokeV.booleanValue;
    }

    public void G(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
        }
    }

    public final void H(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            Message obtainMessage = this.f41554a.obtainMessage();
            obtainMessage.obj = obj;
            this.f41554a.sendMessage(obtainMessage);
        }
    }

    public boolean I(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            if (this.s == null && E()) {
                this.s = cVar;
                return J(cVar);
            }
            D();
            if (cVar != null) {
                cVar.a(1);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean J(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cVar)) == null) {
            if (this.f41556c == null) {
                H(new p(new Exception("mWriter = null")));
                return false;
            }
            return this.f41556c.b(new s(cVar));
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f41555b == null) {
            return;
        }
        this.f41555b.a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f41556c == null) {
            return;
        }
        this.f41556c.a();
    }

    public void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                d.a.c.c.e.c.i.a("more_log", 0, 0, IntentConfig.CLOSE, i2, str);
            }
            this.o = false;
            this.q = true;
            if (this.f41555b != null) {
                this.f41555b.p();
                this.f41555b = null;
            }
            if (this.f41556c != null) {
                this.f41556c.i();
                this.f41556c = null;
            }
            e.a aVar = this.f41557d;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable th) {
                    if (D()) {
                        th.printStackTrace();
                    }
                }
                this.f41557d = null;
            }
            g gVar = this.m;
            this.m = null;
            if (gVar != null) {
                try {
                    gVar.b(i2, str);
                } catch (Exception e2) {
                    if (D()) {
                        BdLog.d(e2.getMessage());
                    }
                }
            }
        }
    }

    public void r(String str, String[] strArr, g gVar, d0 d0Var, List<BasicNameValuePair> list) throws WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048589, this, str, strArr, gVar, d0Var, list) == null) {
            this.p = true;
            e.a aVar = this.f41557d;
            if (aVar != null && aVar.isConnected()) {
                throw new WebSocketException("already connected");
            }
            try {
                URI uri = new URI(str);
                this.f41558e = uri;
                if (!uri.getScheme().equals("ws") && !this.f41558e.getScheme().equals("wss")) {
                    throw new WebSocketException("unsupported scheme for WebSockets URI");
                }
                if (!this.f41558e.getScheme().equals("wss")) {
                    this.f41559f = this.f41558e.getScheme();
                    if (this.f41558e.getPort() == -1) {
                        if (this.f41559f.equals("ws")) {
                            this.f41561h = 80;
                        } else {
                            this.f41561h = Constants.SOCKET_PORT_SSL;
                        }
                    } else {
                        this.f41561h = this.f41558e.getPort();
                    }
                    if (this.f41558e.getHost() != null) {
                        this.f41560g = this.f41558e.getHost();
                        if (this.f41558e.getPath() != null && !this.f41558e.getPath().equals("")) {
                            this.f41562i = this.f41558e.getPath();
                            if (this.f41558e.getQuery() != null && !this.f41558e.getQuery().equals("")) {
                                this.j = this.f41558e.getQuery();
                                this.k = strArr;
                                this.l = list;
                                this.m = gVar;
                                this.n = new d0(d0Var);
                                new b(this, null).start();
                                return;
                            }
                            this.j = null;
                            this.k = strArr;
                            this.l = list;
                            this.m = gVar;
                            this.n = new d0(d0Var);
                            new b(this, null).start();
                            return;
                        }
                        this.f41562i = "/";
                        if (this.f41558e.getQuery() != null) {
                            this.j = this.f41558e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = gVar;
                            this.n = new d0(d0Var);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = gVar;
                        this.n = new d0(d0Var);
                        new b(this, null).start();
                        return;
                    }
                    throw new WebSocketException("no host specified in WebSockets URI");
                }
                throw new WebSocketException("secure WebSockets not implemented");
            } catch (URISyntaxException unused) {
                throw new WebSocketException("invalid WebSockets URI");
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f41554a = new a(this);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f41555b = new e0(this.f41554a, this.f41557d, this.n, "WebSocketReader");
            this.f41555b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.f41556c = new g0(handlerThread.getLooper(), this.f41554a, this.f41557d, this.n);
        }
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f41555b != null) {
                return this.f41555b.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            e.a aVar = this.f41557d;
            if (aVar != null) {
                return aVar.getLocalDns();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            e.a aVar = this.f41557d;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f41556c != null) {
                return this.f41556c.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r : invokeV.longValue;
    }
}
