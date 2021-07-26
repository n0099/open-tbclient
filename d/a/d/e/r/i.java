package d.a.d.e.r;

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
import d.a.d.e.r.e;
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
    public Handler f42058a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e0 f42059b;

    /* renamed from: c  reason: collision with root package name */
    public volatile g0 f42060c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f42061d;

    /* renamed from: e  reason: collision with root package name */
    public URI f42062e;

    /* renamed from: f  reason: collision with root package name */
    public String f42063f;

    /* renamed from: g  reason: collision with root package name */
    public String f42064g;

    /* renamed from: h  reason: collision with root package name */
    public int f42065h;

    /* renamed from: i  reason: collision with root package name */
    public String f42066i;
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
        public final /* synthetic */ i f42067a;

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
            this.f42067a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String message2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof c0) {
                    c0 c0Var = (c0) obj;
                    if (this.f42067a.m != null) {
                        this.f42067a.m.a(c0Var.f42005a);
                    }
                } else if (obj instanceof w) {
                    w wVar = (w) obj;
                    if (this.f42067a.m != null) {
                        this.f42067a.m.d(wVar.f42087a);
                    } else if (this.f42067a.D()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof k) {
                    k kVar = (k) obj;
                    if (this.f42067a.m != null) {
                        this.f42067a.m.f(kVar);
                    } else if (this.f42067a.D()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof t) {
                    u uVar = new u();
                    uVar.f42085a = ((t) obj).f42084a;
                    this.f42067a.f42060c.b(uVar);
                } else if (obj instanceof u) {
                    u uVar2 = (u) obj;
                    if (this.f42067a.m != null) {
                        this.f42067a.m.e();
                    }
                } else {
                    if (obj instanceof m) {
                        this.f42067a.q(1, null);
                    } else if (obj instanceof a0) {
                        a0 a0Var = (a0) obj;
                        if (a0Var.f42001a) {
                            if (this.f42067a.m != null) {
                                this.f42067a.m.onOpen(a0Var.f42002b);
                                this.f42067a.o = true;
                                this.f42067a.p = false;
                                if (this.f42067a.m != null) {
                                    this.f42067a.m.c(null);
                                    return;
                                }
                                return;
                            }
                            this.f42067a.q(6, "handler already NULL");
                        }
                    } else if (obj instanceof n) {
                        SocketException socketException = ((n) obj).f42080a;
                        message2 = socketException != null ? socketException.getMessage() : null;
                        i iVar = this.f42067a;
                        iVar.q(3, "WebSockets connection lost = " + message2);
                    } else if (obj instanceof v) {
                        WebSocketException webSocketException = ((v) obj).f42086a;
                        message2 = webSocketException != null ? webSocketException.getMessage() : null;
                        i iVar2 = this.f42067a;
                        iVar2.q(4, "WebSockets protocol violation error = " + message2);
                    } else if (obj instanceof p) {
                        i iVar3 = this.f42067a;
                        iVar3.q(5, "WebSockets internal error (" + ((p) obj).f42082a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof z) {
                        z zVar = (z) obj;
                        i iVar4 = this.f42067a;
                        iVar4.q(6, "Server error " + zVar.f42089a + " (" + zVar.f42090b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof o) {
                        i iVar5 = this.f42067a;
                        iVar5.q(2, "WebSockets connot connect:" + ((o) obj).f42081a);
                    } else if (obj instanceof b0) {
                        if (this.f42067a.m != null) {
                            this.f42067a.m.i(((b0) message.obj).f42088a);
                        }
                    } else if (obj instanceof q) {
                        this.f42067a.s = null;
                        c cVar = ((q) message.obj).f42088a;
                        if (this.f42067a.m != null) {
                            this.f42067a.m.h(cVar);
                        }
                        if (this.f42067a.m != null) {
                            this.f42067a.m.c(cVar);
                        }
                    } else if (obj instanceof x) {
                        this.f42067a.s = null;
                        c cVar2 = ((x) message.obj).f42088a;
                        if (this.f42067a.m != null) {
                            this.f42067a.m.g(2, cVar2);
                        }
                        if (this.f42067a.m != null) {
                            this.f42067a.m.c(cVar2);
                        }
                    } else {
                        this.f42067a.G(obj);
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
        public final /* synthetic */ i f42068e;

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
            this.f42068e = iVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    e eVar = new e();
                    this.f42068e.f42061d = eVar.a(this.f42068e.f42064g, this.f42068e.f42065h, this.f42068e.n, false);
                    if (this.f42068e.q) {
                        this.f42068e.H(new m());
                        return;
                    }
                    try {
                        if (!this.f42068e.f42061d.isConnected()) {
                            this.f42068e.H(new o(2, "cannot connect"));
                            return;
                        }
                        this.f42068e.r = System.currentTimeMillis() - currentTimeMillis;
                        this.f42068e.t();
                        this.f42068e.u();
                        l lVar = new l(this.f42068e.f42064g + ":" + this.f42068e.f42065h);
                        lVar.f42073b = this.f42068e.f42066i;
                        lVar.f42074c = this.f42068e.j;
                        lVar.f42076e = this.f42068e.k;
                        lVar.f42077f = this.f42068e.l;
                        this.f42068e.f42060c.b(lVar);
                        if (this.f42068e.q) {
                            this.f42068e.H(new m());
                        }
                    } catch (Throwable th) {
                        if (this.f42068e.D()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.f42068e.H(new p(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.f42068e.H(new o(2, th2.getMessage()));
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
            e.a aVar = this.f42061d;
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
            e.a aVar = this.f42061d;
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
            Message obtainMessage = this.f42058a.obtainMessage();
            obtainMessage.obj = obj;
            this.f42058a.sendMessage(obtainMessage);
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
            if (this.f42060c == null) {
                H(new p(new Exception("mWriter = null")));
                return false;
            }
            return this.f42060c.b(new s(cVar));
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f42059b == null) {
            return;
        }
        this.f42059b.a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f42060c == null) {
            return;
        }
        this.f42060c.a();
    }

    public void q(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                d.a.d.c.e.c.i.a("more_log", 0, 0, IntentConfig.CLOSE, i2, str);
            }
            this.o = false;
            this.q = true;
            if (this.f42059b != null) {
                this.f42059b.p();
                this.f42059b = null;
            }
            if (this.f42060c != null) {
                this.f42060c.i();
                this.f42060c = null;
            }
            e.a aVar = this.f42061d;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable th) {
                    if (D()) {
                        th.printStackTrace();
                    }
                }
                this.f42061d = null;
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
            e.a aVar = this.f42061d;
            if (aVar != null && aVar.isConnected()) {
                throw new WebSocketException("already connected");
            }
            try {
                URI uri = new URI(str);
                this.f42062e = uri;
                if (!uri.getScheme().equals("ws") && !this.f42062e.getScheme().equals("wss")) {
                    throw new WebSocketException("unsupported scheme for WebSockets URI");
                }
                if (!this.f42062e.getScheme().equals("wss")) {
                    this.f42063f = this.f42062e.getScheme();
                    if (this.f42062e.getPort() == -1) {
                        if (this.f42063f.equals("ws")) {
                            this.f42065h = 80;
                        } else {
                            this.f42065h = Constants.SOCKET_PORT_SSL;
                        }
                    } else {
                        this.f42065h = this.f42062e.getPort();
                    }
                    if (this.f42062e.getHost() != null) {
                        this.f42064g = this.f42062e.getHost();
                        if (this.f42062e.getPath() != null && !this.f42062e.getPath().equals("")) {
                            this.f42066i = this.f42062e.getPath();
                            if (this.f42062e.getQuery() != null && !this.f42062e.getQuery().equals("")) {
                                this.j = this.f42062e.getQuery();
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
                        this.f42066i = "/";
                        if (this.f42062e.getQuery() != null) {
                            this.j = this.f42062e.getQuery();
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
            this.f42058a = new a(this);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f42059b = new e0(this.f42058a, this.f42061d, this.n, "WebSocketReader");
            this.f42059b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.f42060c = new g0(handlerThread.getLooper(), this.f42058a, this.f42061d, this.n);
        }
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f42059b != null) {
                return this.f42059b.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            e.a aVar = this.f42061d;
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
            e.a aVar = this.f42061d;
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
            if (this.f42060c != null) {
                return this.f42060c.c();
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
