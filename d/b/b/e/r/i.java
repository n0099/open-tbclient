package d.b.b.e.r;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.b.e.r.e;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Handler f42111a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e0 f42112b;

    /* renamed from: c  reason: collision with root package name */
    public volatile g0 f42113c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f42114d;

    /* renamed from: e  reason: collision with root package name */
    public URI f42115e;

    /* renamed from: f  reason: collision with root package name */
    public String f42116f;

    /* renamed from: g  reason: collision with root package name */
    public String f42117g;

    /* renamed from: h  reason: collision with root package name */
    public int f42118h;
    public String i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public g m;
    public d0 n;
    public boolean o = false;
    public boolean p = false;
    public volatile boolean q = false;
    public long r = 0;
    public c s = null;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String message2;
            Object obj = message.obj;
            if (obj instanceof c0) {
                c0 c0Var = (c0) obj;
                if (i.this.m != null) {
                    i.this.m.c(c0Var.f42060a);
                }
            } else if (obj instanceof w) {
                w wVar = (w) obj;
                if (i.this.m != null) {
                    i.this.m.d(wVar.f42139a);
                } else if (i.this.D()) {
                    BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                }
            } else if (obj instanceof k) {
                k kVar = (k) obj;
                if (i.this.m != null) {
                    i.this.m.h(kVar);
                } else if (i.this.D()) {
                    BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                }
            } else if (obj instanceof t) {
                u uVar = new u();
                uVar.f42137a = ((t) obj).f42136a;
                i.this.f42113c.b(uVar);
            } else if (obj instanceof u) {
                u uVar2 = (u) obj;
                if (i.this.m != null) {
                    i.this.m.g();
                }
            } else {
                if (obj instanceof m) {
                    i.this.q(1, null);
                } else if (obj instanceof a0) {
                    a0 a0Var = (a0) obj;
                    if (a0Var.f42056a) {
                        if (i.this.m != null) {
                            i.this.m.onOpen(a0Var.f42057b);
                            i.this.o = true;
                            i.this.p = false;
                            if (i.this.m != null) {
                                i.this.m.b(null);
                                return;
                            }
                            return;
                        }
                        i.this.q(6, "handler already NULL");
                    }
                } else if (obj instanceof n) {
                    SocketException socketException = ((n) obj).f42132a;
                    message2 = socketException != null ? socketException.getMessage() : null;
                    i iVar = i.this;
                    iVar.q(3, "WebSockets connection lost = " + message2);
                } else if (obj instanceof v) {
                    WebSocketException webSocketException = ((v) obj).f42138a;
                    message2 = webSocketException != null ? webSocketException.getMessage() : null;
                    i iVar2 = i.this;
                    iVar2.q(4, "WebSockets protocol violation error = " + message2);
                } else if (obj instanceof p) {
                    i iVar3 = i.this;
                    iVar3.q(5, "WebSockets internal error (" + ((p) obj).f42134a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                } else if (obj instanceof z) {
                    z zVar = (z) obj;
                    i iVar4 = i.this;
                    iVar4.q(6, "Server error " + zVar.f42141a + " (" + zVar.f42142b + SmallTailInfo.EMOTION_SUFFIX);
                } else if (obj instanceof o) {
                    i iVar5 = i.this;
                    iVar5.q(2, "WebSockets connot connect:" + ((o) obj).f42133a);
                } else if (obj instanceof b0) {
                    if (i.this.m != null) {
                        i.this.m.i(((b0) message.obj).f42140a);
                    }
                } else if (obj instanceof q) {
                    i.this.s = null;
                    c cVar = ((q) message.obj).f42140a;
                    if (i.this.m != null) {
                        i.this.m.f(cVar);
                    }
                    if (i.this.m != null) {
                        i.this.m.b(cVar);
                    }
                } else if (obj instanceof x) {
                    i.this.s = null;
                    c cVar2 = ((x) message.obj).f42140a;
                    if (i.this.m != null) {
                        i.this.m.e(2, cVar2);
                    }
                    if (i.this.m != null) {
                        i.this.m.b(cVar2);
                    }
                } else {
                    i.this.G(obj);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketConnector");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e eVar = new e();
                i.this.f42114d = eVar.a(i.this.f42117g, i.this.f42118h, i.this.n, false);
                if (i.this.q) {
                    i.this.H(new m());
                    return;
                }
                try {
                    if (!i.this.f42114d.isConnected()) {
                        i.this.H(new o(2, "cannot connect"));
                        return;
                    }
                    i.this.r = System.currentTimeMillis() - currentTimeMillis;
                    i.this.t();
                    i.this.u();
                    l lVar = new l(i.this.f42117g + ":" + i.this.f42118h);
                    lVar.f42125b = i.this.i;
                    lVar.f42126c = i.this.j;
                    lVar.f42128e = i.this.k;
                    lVar.f42129f = i.this.l;
                    i.this.f42113c.b(lVar);
                    if (i.this.q) {
                        i.this.H(new m());
                    }
                } catch (Throwable th) {
                    if (i.this.D()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.H(new p(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.H(new o(2, th2.getMessage()));
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this();
        }
    }

    public i() {
        s();
    }

    public long A() {
        e.a aVar = this.f42114d;
        if (aVar != null) {
            return aVar.d();
        }
        return 0L;
    }

    public String B() {
        e.a aVar = this.f42114d;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public boolean C() {
        return this.p;
    }

    public final boolean D() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public boolean E() {
        return this.o;
    }

    public boolean F() {
        return this.s != null;
    }

    public void G(Object obj) {
    }

    public final void H(Object obj) {
        Message obtainMessage = this.f42111a.obtainMessage();
        obtainMessage.obj = obj;
        this.f42111a.sendMessage(obtainMessage);
    }

    public boolean I(c cVar) {
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

    public final boolean J(c cVar) {
        if (this.f42113c == null) {
            H(new p(new Exception("mWriter = null")));
            return false;
        }
        return this.f42113c.b(new s(cVar));
    }

    public void o() {
        if (this.f42112b != null) {
            this.f42112b.a();
        }
    }

    public void p() {
        if (this.f42113c != null) {
            this.f42113c.a();
        }
    }

    public void q(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            d.b.b.c.e.c.i.a("more_log", 0, 0, IntentConfig.CLOSE, i, str);
        }
        this.o = false;
        this.q = true;
        if (this.f42112b != null) {
            this.f42112b.p();
            this.f42112b = null;
        }
        if (this.f42113c != null) {
            this.f42113c.i();
            this.f42113c = null;
        }
        e.a aVar = this.f42114d;
        if (aVar != null) {
            try {
                aVar.close();
            } catch (Throwable th) {
                if (D()) {
                    th.printStackTrace();
                }
            }
            this.f42114d = null;
        }
        g gVar = this.m;
        this.m = null;
        if (gVar != null) {
            try {
                gVar.a(i, str);
            } catch (Exception e2) {
                if (D()) {
                    BdLog.d(e2.getMessage());
                }
            }
        }
    }

    public void r(String str, String[] strArr, g gVar, d0 d0Var, List<BasicNameValuePair> list) throws WebSocketException {
        this.p = true;
        e.a aVar = this.f42114d;
        if (aVar != null && aVar.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            URI uri = new URI(str);
            this.f42115e = uri;
            if (!uri.getScheme().equals("ws") && !this.f42115e.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (!this.f42115e.getScheme().equals("wss")) {
                this.f42116f = this.f42115e.getScheme();
                if (this.f42115e.getPort() == -1) {
                    if (this.f42116f.equals("ws")) {
                        this.f42118h = 80;
                    } else {
                        this.f42118h = Constants.SOCKET_PORT_SSL;
                    }
                } else {
                    this.f42118h = this.f42115e.getPort();
                }
                if (this.f42115e.getHost() != null) {
                    this.f42117g = this.f42115e.getHost();
                    if (this.f42115e.getPath() != null && !this.f42115e.getPath().equals("")) {
                        this.i = this.f42115e.getPath();
                        if (this.f42115e.getQuery() != null && !this.f42115e.getQuery().equals("")) {
                            this.j = this.f42115e.getQuery();
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
                    this.i = "/";
                    if (this.f42115e.getQuery() != null) {
                        this.j = this.f42115e.getQuery();
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

    public void s() {
        this.f42111a = new a();
    }

    public void t() {
        this.f42112b = new e0(this.f42111a, this.f42114d, this.n, "WebSocketReader");
        this.f42112b.start();
    }

    public void u() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.f42113c = new g0(handlerThread.getLooper(), this.f42111a, this.f42114d, this.n);
    }

    public long v() {
        if (this.f42112b != null) {
            return this.f42112b.c();
        }
        return 0L;
    }

    public String w() {
        e.a aVar = this.f42114d;
        if (aVar != null) {
            return aVar.getLocalDns();
        }
        return null;
    }

    public String x() {
        e.a aVar = this.f42114d;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public long y() {
        if (this.f42113c != null) {
            return this.f42113c.c();
        }
        return 0L;
    }

    public long z() {
        return this.r;
    }
}
