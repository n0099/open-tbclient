package com.repackage;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lj;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class pj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public volatile lk b;
    public volatile nk c;
    public lj.a d;
    public URI e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public nj m;
    public kk n;
    public boolean o;
    public boolean p;
    public volatile boolean q;
    public long r;
    public jj s;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pj a;

        public a(pj pjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pjVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String message2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof jk) {
                    jk jkVar = (jk) obj;
                    if (this.a.m != null) {
                        this.a.m.a(jkVar.a);
                    }
                } else if (obj instanceof dk) {
                    dk dkVar = (dk) obj;
                    if (this.a.m != null) {
                        this.a.m.d(dkVar.a);
                    } else if (this.a.D()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof rj) {
                    rj rjVar = (rj) obj;
                    if (this.a.m != null) {
                        this.a.m.f(rjVar);
                    } else if (this.a.D()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof ak) {
                    bk bkVar = new bk();
                    bkVar.a = ((ak) obj).a;
                    this.a.c.b(bkVar);
                } else if (obj instanceof bk) {
                    bk bkVar2 = (bk) obj;
                    if (this.a.m != null) {
                        this.a.m.e();
                    }
                } else {
                    if (obj instanceof tj) {
                        this.a.q(1, null);
                    } else if (obj instanceof hk) {
                        hk hkVar = (hk) obj;
                        if (hkVar.a) {
                            if (this.a.m != null) {
                                this.a.m.onOpen(hkVar.b);
                                this.a.o = true;
                                this.a.p = false;
                                if (this.a.m != null) {
                                    this.a.m.c(null);
                                    return;
                                }
                                return;
                            }
                            this.a.q(6, "handler already NULL");
                        }
                    } else if (obj instanceof uj) {
                        SocketException socketException = ((uj) obj).a;
                        message2 = socketException != null ? socketException.getMessage() : null;
                        pj pjVar = this.a;
                        pjVar.q(3, "WebSockets connection lost = " + message2);
                    } else if (obj instanceof ck) {
                        WebSocketException webSocketException = ((ck) obj).a;
                        message2 = webSocketException != null ? webSocketException.getMessage() : null;
                        pj pjVar2 = this.a;
                        pjVar2.q(4, "WebSockets protocol violation error = " + message2);
                    } else if (obj instanceof wj) {
                        pj pjVar3 = this.a;
                        pjVar3.q(5, "WebSockets internal error (" + ((wj) obj).a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof gk) {
                        gk gkVar = (gk) obj;
                        pj pjVar4 = this.a;
                        pjVar4.q(6, "Server error " + gkVar.a + " (" + gkVar.b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof vj) {
                        pj pjVar5 = this.a;
                        pjVar5.q(2, "WebSockets connot connect:" + ((vj) obj).a);
                    } else if (obj instanceof ik) {
                        if (this.a.m != null) {
                            this.a.m.i(((ik) message.obj).a);
                        }
                    } else if (obj instanceof xj) {
                        this.a.s = null;
                        jj jjVar = ((xj) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.h(jjVar);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(jjVar);
                        }
                    } else if (obj instanceof ek) {
                        this.a.s = null;
                        jj jjVar2 = ((ek) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.g(2, jjVar2);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(jjVar2);
                        }
                    } else {
                        this.a.G(obj);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pj a;

        public b(pj pjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pjVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    lj ljVar = new lj();
                    this.a.d = ljVar.a(this.a.g, this.a.h, this.a.n, false);
                    if (this.a.q) {
                        this.a.H(new tj());
                        return;
                    }
                    try {
                        if (!this.a.d.isConnected()) {
                            this.a.H(new vj(2, "cannot connect"));
                            return;
                        }
                        this.a.r = System.currentTimeMillis() - currentTimeMillis;
                        this.a.t();
                        this.a.u();
                        sj sjVar = new sj(this.a.g + ":" + this.a.h);
                        sjVar.b = this.a.i;
                        sjVar.c = this.a.j;
                        sjVar.e = this.a.k;
                        sjVar.f = this.a.l;
                        this.a.c.b(sjVar);
                        if (this.a.q) {
                            this.a.H(new tj());
                        }
                    } catch (Throwable th) {
                        if (this.a.D()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.a.H(new wj(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.a.H(new vj(2, th2.getMessage()));
                }
            }
        }

        public /* synthetic */ b(pj pjVar, a aVar) {
            this(pjVar);
        }
    }

    public pj() {
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
            lj.a aVar = this.d;
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
            lj.a aVar = this.d;
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
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.obj = obj;
            this.a.sendMessage(obtainMessage);
        }
    }

    public boolean I(jj jjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jjVar)) == null) {
            if (jjVar == null) {
                return false;
            }
            if (this.s == null && E()) {
                this.s = jjVar;
                return J(jjVar);
            }
            D();
            if (jjVar != null) {
                jjVar.a(1);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean J(jj jjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jjVar)) == null) {
            if (this.c == null) {
                H(new wj(new Exception("mWriter = null")));
                return false;
            }
            return this.c.b(new zj(jjVar));
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b == null) {
            return;
        }
        this.b.a();
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.c == null) {
            return;
        }
        this.c.a();
    }

    public void q(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                ba.a("more_log", 0, 0, "close", i, str);
            }
            this.o = false;
            this.q = true;
            if (this.b != null) {
                this.b.p();
                this.b = null;
            }
            if (this.c != null) {
                this.c.i();
                this.c = null;
            }
            lj.a aVar = this.d;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable th) {
                    if (D()) {
                        th.printStackTrace();
                    }
                }
                this.d = null;
            }
            nj njVar = this.m;
            this.m = null;
            if (njVar != null) {
                try {
                    njVar.b(i, str);
                } catch (Exception e) {
                    if (D()) {
                        BdLog.d(e.getMessage());
                    }
                }
            }
        }
    }

    public void r(String str, String[] strArr, nj njVar, kk kkVar, List<BasicNameValuePair> list) throws WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048589, this, str, strArr, njVar, kkVar, list) == null) {
            this.p = true;
            lj.a aVar = this.d;
            if (aVar != null && aVar.isConnected()) {
                throw new WebSocketException("already connected");
            }
            try {
                URI uri = new URI(str);
                this.e = uri;
                if (!uri.getScheme().equals("ws") && !this.e.getScheme().equals("wss")) {
                    throw new WebSocketException("unsupported scheme for WebSockets URI");
                }
                if (!this.e.getScheme().equals("wss")) {
                    this.f = this.e.getScheme();
                    if (this.e.getPort() == -1) {
                        if (this.f.equals("ws")) {
                            this.h = 80;
                        } else {
                            this.h = 443;
                        }
                    } else {
                        this.h = this.e.getPort();
                    }
                    if (this.e.getHost() != null) {
                        this.g = this.e.getHost();
                        if (this.e.getPath() != null && !this.e.getPath().equals("")) {
                            this.i = this.e.getPath();
                            if (this.e.getQuery() != null && !this.e.getQuery().equals("")) {
                                this.j = this.e.getQuery();
                                this.k = strArr;
                                this.l = list;
                                this.m = njVar;
                                this.n = new kk(kkVar);
                                new b(this, null).start();
                                return;
                            }
                            this.j = null;
                            this.k = strArr;
                            this.l = list;
                            this.m = njVar;
                            this.n = new kk(kkVar);
                            new b(this, null).start();
                            return;
                        }
                        this.i = "/";
                        if (this.e.getQuery() != null) {
                            this.j = this.e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = njVar;
                            this.n = new kk(kkVar);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = njVar;
                        this.n = new kk(kkVar);
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
            this.a = new a(this);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b = new lk(this.a, this.d, this.n, "WebSocketReader");
            this.b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.c = new nk(handlerThread.getLooper(), this.a, this.d, this.n);
        }
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.b != null) {
                return this.b.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            lj.a aVar = this.d;
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
            lj.a aVar = this.d;
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
            if (this.c != null) {
                return this.c.c();
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
