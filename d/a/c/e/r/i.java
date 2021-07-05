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
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f44538a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e0 f44539b;

    /* renamed from: c  reason: collision with root package name */
    public volatile g0 f44540c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f44541d;

    /* renamed from: e  reason: collision with root package name */
    public URI f44542e;

    /* renamed from: f  reason: collision with root package name */
    public String f44543f;

    /* renamed from: g  reason: collision with root package name */
    public String f44544g;

    /* renamed from: h  reason: collision with root package name */
    public int f44545h;

    /* renamed from: i  reason: collision with root package name */
    public String f44546i;
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

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f44547a;

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
            this.f44547a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String message2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof c0) {
                    c0 c0Var = (c0) obj;
                    if (this.f44547a.m != null) {
                        this.f44547a.m.a(c0Var.f44485a);
                    }
                } else if (obj instanceof w) {
                    w wVar = (w) obj;
                    if (this.f44547a.m != null) {
                        this.f44547a.m.d(wVar.f44567a);
                    } else if (this.f44547a.D()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof k) {
                    k kVar = (k) obj;
                    if (this.f44547a.m != null) {
                        this.f44547a.m.f(kVar);
                    } else if (this.f44547a.D()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof t) {
                    u uVar = new u();
                    uVar.f44565a = ((t) obj).f44564a;
                    this.f44547a.f44540c.b(uVar);
                } else if (obj instanceof u) {
                    u uVar2 = (u) obj;
                    if (this.f44547a.m != null) {
                        this.f44547a.m.e();
                    }
                } else {
                    if (obj instanceof m) {
                        this.f44547a.q(1, null);
                    } else if (obj instanceof a0) {
                        a0 a0Var = (a0) obj;
                        if (a0Var.f44481a) {
                            if (this.f44547a.m != null) {
                                this.f44547a.m.onOpen(a0Var.f44482b);
                                this.f44547a.o = true;
                                this.f44547a.p = false;
                                if (this.f44547a.m != null) {
                                    this.f44547a.m.c(null);
                                    return;
                                }
                                return;
                            }
                            this.f44547a.q(6, "handler already NULL");
                        }
                    } else if (obj instanceof n) {
                        SocketException socketException = ((n) obj).f44560a;
                        message2 = socketException != null ? socketException.getMessage() : null;
                        i iVar = this.f44547a;
                        iVar.q(3, "WebSockets connection lost = " + message2);
                    } else if (obj instanceof v) {
                        WebSocketException webSocketException = ((v) obj).f44566a;
                        message2 = webSocketException != null ? webSocketException.getMessage() : null;
                        i iVar2 = this.f44547a;
                        iVar2.q(4, "WebSockets protocol violation error = " + message2);
                    } else if (obj instanceof p) {
                        i iVar3 = this.f44547a;
                        iVar3.q(5, "WebSockets internal error (" + ((p) obj).f44562a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof z) {
                        z zVar = (z) obj;
                        i iVar4 = this.f44547a;
                        iVar4.q(6, "Server error " + zVar.f44569a + " (" + zVar.f44570b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof o) {
                        i iVar5 = this.f44547a;
                        iVar5.q(2, "WebSockets connot connect:" + ((o) obj).f44561a);
                    } else if (obj instanceof b0) {
                        if (this.f44547a.m != null) {
                            this.f44547a.m.i(((b0) message.obj).f44568a);
                        }
                    } else if (obj instanceof q) {
                        this.f44547a.s = null;
                        c cVar = ((q) message.obj).f44568a;
                        if (this.f44547a.m != null) {
                            this.f44547a.m.h(cVar);
                        }
                        if (this.f44547a.m != null) {
                            this.f44547a.m.c(cVar);
                        }
                    } else if (obj instanceof x) {
                        this.f44547a.s = null;
                        c cVar2 = ((x) message.obj).f44568a;
                        if (this.f44547a.m != null) {
                            this.f44547a.m.g(2, cVar2);
                        }
                        if (this.f44547a.m != null) {
                            this.f44547a.m.c(cVar2);
                        }
                    } else {
                        this.f44547a.G(obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f44548e;

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
            this.f44548e = iVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    e eVar = new e();
                    this.f44548e.f44541d = eVar.a(this.f44548e.f44544g, this.f44548e.f44545h, this.f44548e.n, false);
                    if (this.f44548e.q) {
                        this.f44548e.H(new m());
                        return;
                    }
                    try {
                        if (!this.f44548e.f44541d.isConnected()) {
                            this.f44548e.H(new o(2, "cannot connect"));
                            return;
                        }
                        this.f44548e.r = System.currentTimeMillis() - currentTimeMillis;
                        this.f44548e.t();
                        this.f44548e.u();
                        l lVar = new l(this.f44548e.f44544g + ":" + this.f44548e.f44545h);
                        lVar.f44553b = this.f44548e.f44546i;
                        lVar.f44554c = this.f44548e.j;
                        lVar.f44556e = this.f44548e.k;
                        lVar.f44557f = this.f44548e.l;
                        this.f44548e.f44540c.b(lVar);
                        if (this.f44548e.q) {
                            this.f44548e.H(new m());
                        }
                    } catch (Throwable th) {
                        if (this.f44548e.D()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.f44548e.H(new p(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.f44548e.H(new o(2, th2.getMessage()));
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
            e.a aVar = this.f44541d;
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
            e.a aVar = this.f44541d;
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
            Message obtainMessage = this.f44538a.obtainMessage();
            obtainMessage.obj = obj;
            this.f44538a.sendMessage(obtainMessage);
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
            if (this.f44540c == null) {
                H(new p(new Exception("mWriter = null")));
                return false;
            }
            return this.f44540c.b(new s(cVar));
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f44539b == null) {
            return;
        }
        this.f44539b.a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f44540c == null) {
            return;
        }
        this.f44540c.a();
    }

    public void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                d.a.c.c.e.c.i.a("more_log", 0, 0, IntentConfig.CLOSE, i2, str);
            }
            this.o = false;
            this.q = true;
            if (this.f44539b != null) {
                this.f44539b.p();
                this.f44539b = null;
            }
            if (this.f44540c != null) {
                this.f44540c.i();
                this.f44540c = null;
            }
            e.a aVar = this.f44541d;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable th) {
                    if (D()) {
                        th.printStackTrace();
                    }
                }
                this.f44541d = null;
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
            e.a aVar = this.f44541d;
            if (aVar != null && aVar.isConnected()) {
                throw new WebSocketException("already connected");
            }
            try {
                URI uri = new URI(str);
                this.f44542e = uri;
                if (!uri.getScheme().equals("ws") && !this.f44542e.getScheme().equals("wss")) {
                    throw new WebSocketException("unsupported scheme for WebSockets URI");
                }
                if (!this.f44542e.getScheme().equals("wss")) {
                    this.f44543f = this.f44542e.getScheme();
                    if (this.f44542e.getPort() == -1) {
                        if (this.f44543f.equals("ws")) {
                            this.f44545h = 80;
                        } else {
                            this.f44545h = Constants.SOCKET_PORT_SSL;
                        }
                    } else {
                        this.f44545h = this.f44542e.getPort();
                    }
                    if (this.f44542e.getHost() != null) {
                        this.f44544g = this.f44542e.getHost();
                        if (this.f44542e.getPath() != null && !this.f44542e.getPath().equals("")) {
                            this.f44546i = this.f44542e.getPath();
                            if (this.f44542e.getQuery() != null && !this.f44542e.getQuery().equals("")) {
                                this.j = this.f44542e.getQuery();
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
                        this.f44546i = "/";
                        if (this.f44542e.getQuery() != null) {
                            this.j = this.f44542e.getQuery();
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
            this.f44538a = new a(this);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f44539b = new e0(this.f44538a, this.f44541d, this.n, "WebSocketReader");
            this.f44539b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.f44540c = new g0(handlerThread.getLooper(), this.f44538a, this.f44541d, this.n);
        }
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f44539b != null) {
                return this.f44539b.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            e.a aVar = this.f44541d;
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
            e.a aVar = this.f44541d;
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
            if (this.f44540c != null) {
                return this.f44540c.c();
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
